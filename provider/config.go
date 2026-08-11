package provider

import (
	"context"
	"errors"
	"fmt"
	"log"
	"os"
	"strconv"
	"strings"
	"sync/atomic"
	"time"

	_ "embed"

	"github.com/aws/aws-sdk-go-v2/feature/ec2/imds"
	awsbase "github.com/hashicorp/aws-sdk-go-base/v2"
	"github.com/mitchellh/go-homedir"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// stringValue gets a string value from a property map if present, else ""
func stringValue(vars resource.PropertyMap, prop resource.PropertyKey, envs []string) string {
	val, ok := vars[prop]
	if ok && val.IsString() {
		return val.StringValue()
	}
	for _, env := range envs {
		val, ok := os.LookupEnv(env)
		if ok {
			return val
		}
	}
	return ""
}

// boolValue gets a bool value from a property map if present, else false
func boolValue(vars resource.PropertyMap, prop resource.PropertyKey, envs []string) (*bool, error) {
	val, ok := vars[prop]
	if ok && val.IsBool() {
		result := val.BoolValue()
		return &result, nil
	}
	for _, env := range envs {
		val, ok := os.LookupEnv(env)
		if ok {
			boolValue, err := strconv.ParseBool(val)
			if err != nil {
				return nil, err
			}
			return &boolValue, nil
		}
	}
	return nil, nil
}

func arrayValue(vars resource.PropertyMap, prop resource.PropertyKey, envs []string) []string {
	val, ok := vars[prop]
	var vals []string
	if ok && val.IsArray() {
		for _, v := range val.ArrayValue() {
			vals = append(vals, v.StringValue())
		}
		return vals
	}

	for _, env := range envs {
		val, ok := os.LookupEnv(env)
		if ok {
			return strings.Split(val, ";")
		}
	}
	return vals
}

func extractTags(vars resource.PropertyMap, prop resource.PropertyKey) map[string]string {
	val, ok := vars[prop]

	if !ok || !val.IsObject() {
		return nil
	}

	tagProp := val.ObjectValue()
	tags := make(map[string]string, len(tagProp))

	for k, v := range tagProp {
		if !v.IsString() {
			continue
		}
		tags[string(k)] = v.StringValue()
	}

	return tags
}

// returns a pointer so we can distinguish between a zero value and a missing value
func durationFromConfig(vars resource.PropertyMap, prop resource.PropertyKey) (*time.Duration, error) {
	val, ok := vars[prop]
	if ok && val.IsString() {
		secondsString := val.StringValue()
		if !strings.HasSuffix(secondsString, "s") {
			secondsString += "s"
		}
		dur, err := time.ParseDuration(secondsString)
		if err != nil {
			return nil, err
		}
		return &dur, nil
	}

	return nil, nil
}

//go:embed errors/no_credentials.txt
var noCredentialsError string

//go:embed errors/invalid_credentials.txt
var invalidCredentialsError string

//go:embed errors/no_region.txt
var noRegionError string

//go:embed errors/expired_sso.txt
var expiredSSOError string

func parseAssumeRoles(vars resource.PropertyMap) ([]awsbase.AssumeRole, error) {
	assumeRoles := []awsbase.AssumeRole{}
	// if we don't catch this early it will eventually error in the bridge with something like
	// could not marshal config state: internal: Pulumi property 'assumeRole' mapped non-uniquely to
	// Terraform attribute 'assume_role' (duplicates Pulumi key 'assumeRoles')
	if _, ok := vars["assumeRole"]; ok {
		return assumeRoles, errors.New("invalid config key 'aws:assumeRole', should be 'aws:assumeRoles'")
	}
	if roles, ok := vars["assumeRoles"]; ok {
		if !roles.IsArray() {
			return assumeRoles, fmt.Errorf("expected aws:assumeRoles to be an array, got %s", roles.TypeString())
		}
		for _, details := range roles.ArrayValue() {
			assumeRole := awsbase.AssumeRole{
				RoleARN:           stringValue(details.ObjectValue(), "roleArn", []string{}),
				ExternalID:        stringValue(details.ObjectValue(), "externalId", []string{}),
				Policy:            stringValue(details.ObjectValue(), "policy", []string{}),
				PolicyARNs:        arrayValue(details.ObjectValue(), "policyArns", []string{}),
				SessionName:       stringValue(details.ObjectValue(), "sessionName", []string{}),
				SourceIdentity:    stringValue(details.ObjectValue(), "sourceIdentity", []string{}),
				TransitiveTagKeys: arrayValue(details.ObjectValue(), "transitiveTagKeys", []string{}),
				Tags:              extractTags(details.ObjectValue(), "tags"),
			}
			duration, err := durationFromConfig(details.ObjectValue(), "durationSeconds")
			if err != nil {
				return assumeRoles, err
			}
			if duration != nil {
				assumeRole.Duration = *duration
			}
			assumeRoles = append(assumeRoles, assumeRole)
		}
	}

	return assumeRoles, nil
}

func validateCredentials(vars resource.PropertyMap, _ shim.ResourceConfig) error {
	config := &awsbase.Config{
		AccessKey: stringValue(vars, "accessKey", []string{"AWS_ACCESS_KEY_ID"}),
		SecretKey: stringValue(vars, "secretKey", []string{"AWS_SECRET_ACCESS_KEY"}),
		Profile:   stringValue(vars, "profile", []string{"AWS_PROFILE"}),
		Token:     stringValue(vars, "token", []string{"AWS_SESSION_TOKEN"}),
		Region:    stringValue(vars, "region", []string{"AWS_REGION", "AWS_DEFAULT_REGION"}),

		CallerName:             "Pulumi AWS Classic",
		CallerDocumentationURL: "https://www.pulumi.com/registry/packages/aws/installation-configuration/",
	}

	assumeRoles, err := parseAssumeRoles(vars)
	if err != nil {
		return err
	}
	if len(assumeRoles) > 0 {
		config.AssumeRole = assumeRoles
	}

	if details, ok := vars["assumeRoleWithWebIdentity"]; ok {
		assumeRole := awsbase.AssumeRoleWithWebIdentity{
			RoleARN:              stringValue(details.ObjectValue(), "roleArn", []string{}),
			Policy:               stringValue(details.ObjectValue(), "policy", []string{}),
			PolicyARNs:           arrayValue(details.ObjectValue(), "policyArns", []string{}),
			SessionName:          stringValue(details.ObjectValue(), "sessionName", []string{}),
			WebIdentityToken:     stringValue(details.ObjectValue(), "webIdentityToken", []string{}),
			WebIdentityTokenFile: stringValue(details.ObjectValue(), "webIdentityTokenFile", []string{}),
		}
		duration, err := durationFromConfig(details.ObjectValue(), "durationSeconds")
		if err != nil {
			return err
		}
		if duration != nil {
			assumeRole.Duration = *duration
		}
		config.AssumeRoleWithWebIdentity = &assumeRole
	}

	// Only set non-default EC2MetadataServiceEnableState if requested by skipMetadataApiCheck.
	skipMetadataAPICheck, err := boolValue(vars, "skipMetadataApiCheck",
		[]string{"AWS_SKIP_METADATA_API_CHECK"})
	contract.AssertNoErrorf(err, "Failed to parse skipMetadataApiCheck configuration")
	if skipMetadataAPICheck != nil {
		if !*skipMetadataAPICheck {
			config.EC2MetadataServiceEnableState = imds.ClientEnabled
		} else {
			config.EC2MetadataServiceEnableState = imds.ClientDisabled
		}
	}

	// lastly let's set the sharedCreds and sharedConfig file. If these are not found then let's default to the
	// locations that AWS cli will store these values.
	var sharedCredentialsFilePaths []string
	sharedCredentialsFile := stringValue(vars, "sharedCredentialsFile", []string{"AWS_SHARED_CREDENTIALS_FILE"})
	if sharedCredentialsFile != "" {
		sharedCredentialsFilePaths = append(sharedCredentialsFilePaths, sharedCredentialsFile)
	}

	sharedCredentialsFiles := arrayValue(vars, "sharedCredentialsFiles",
		[]string{"AWS_SHARED_CREDENTIALS_FILE", "AWS_SHARED_CREDENTIALS_FILES"})
	if len(sharedCredentialsFiles) > 0 {
		sharedCredentialsFilePaths = append(sharedCredentialsFilePaths, sharedCredentialsFiles...)
	}

	if len(sharedCredentialsFilePaths) == 0 {
		sharedCredentialsFile := "~/.aws/credentials" //nolint:gosec // This is a file path, not a credential
		credsPath, err := homedir.Expand(sharedCredentialsFile)
		if err != nil {
			return err
		}

		sharedCredentialsFilePaths = append(sharedCredentialsFilePaths, credsPath)
	}
	config.SharedCredentialsFiles = sharedCredentialsFilePaths

	sharedConfigFile := stringValue(vars, "sharedConfigFile", []string{"AWS_CONFIG_FILE"})
	if sharedConfigFile == "" {
		sharedConfigFile = "~/.aws/config"
	}
	configPath, err := homedir.Expand(sharedConfigFile)
	if err != nil {
		return err
	}

	config.SharedConfigFiles = []string{configPath}

	if _, _, diag := awsbase.GetAwsConfig(context.Background(), config); diag != nil && diag.HasError() {
		formattedDiag := formatDiags(diag)
		// Normally it'd query sts.REGION.amazonaws.com
		// but if we query sts..amazonaws.com, then we don't have a region.
		if strings.Contains(formattedDiag, "endpoint rule error, Invalid Configuration: Missing Region") {
			return tfbridge.CheckFailureError{
				Failures: []tfbridge.CheckFailureErrorElement{
					{
						Reason:   noRegionError,
						Property: "",
					},
				},
			}
		}
		if strings.Contains(formattedDiag, "no EC2 IMDS role found") {
			return tfbridge.CheckFailureError{
				Failures: []tfbridge.CheckFailureErrorElement{
					{
						Reason:   noCredentialsError,
						Property: "",
					},
				},
			}
		}
		if strings.Contains(formattedDiag, "The security token included in the request is invalid") {
			return tfbridge.CheckFailureError{
				Failures: []tfbridge.CheckFailureErrorElement{
					{
						Reason:   invalidCredentialsError,
						Property: "",
					},
				},
			}
		}
		if strings.Contains(formattedDiag, "failed to refresh cached credentials") {
			return tfbridge.CheckFailureError{
				Failures: []tfbridge.CheckFailureErrorElement{
					{
						Reason:   expiredSSOError,
						Property: "",
					},
				},
			}
		}

		return tfbridge.CheckFailureError{
			Failures: []tfbridge.CheckFailureErrorElement{
				{
					Reason:   fmt.Sprintf("unable to validate AWS credentials.\nDetails: %s\n", formattedDiag),
					Property: "",
				},
			},
		}
	}

	return nil
}

// preConfigureCallback validates that AWS credentials can be successfully discovered. This emulates the credentials
// configuration subset of `github.com/terraform-providers/terraform-provider-aws/aws.providerConfigure`.  We do this
// before passing control to the TF provider to ensure we can report actionable errors.
func preConfigureCallback(alreadyRun *atomic.Bool) func(vars resource.PropertyMap, c shim.ResourceConfig) error {
	return func(vars resource.PropertyMap, c shim.ResourceConfig) error {
		var err error
		skipCredentialsValidation, err := boolValue(vars, "skipCredentialsValidation",
			[]string{"AWS_SKIP_CREDENTIALS_VALIDATION"})
		if err != nil {
			return err
		}

		// if we skipCredentialsValidation then we don't need to do anything in
		// preConfigureCallback as this is an explicit operation
		if skipCredentialsValidation != nil && *skipCredentialsValidation {
			log.Printf("[INFO] pulumi-aws: skip credentials validation")
			return nil
		}

		if alreadyRun.CompareAndSwap(false, true) {
			log.Printf("[INFO] pulumi-aws: starting to validate credentials. " +
				"Disable this by AWS_SKIP_CREDENTIALS_VALIDATION or " +
				"skipCredentialsValidation option")
			err = validateCredentials(vars, c)
			if err == nil {
				log.Printf("[INFO] pulumi-aws: credentials are valid")
			} else {
				log.Printf("[INFO] pulumi-aws: error validating credentials: %v", err)
			}
		}
		return err
	}
}

// managedByPulumi is a default used for some managed resources, in the absence of something more meaningful.
var managedByPulumi = &tfbridge.DefaultInfo{Value: "Managed by Pulumi"}
