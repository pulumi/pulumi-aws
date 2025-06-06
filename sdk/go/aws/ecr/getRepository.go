// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ecr

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// The ECR Repository data source allows the ARN, Repository URI and Registry ID to be retrieved for an ECR repository.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ecr"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ecr.LookupRepository(ctx, &ecr.LookupRepositoryArgs{
//				Name: "ecr-repository",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupRepository(ctx *pulumi.Context, args *LookupRepositoryArgs, opts ...pulumi.InvokeOption) (*LookupRepositoryResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupRepositoryResult
	err := ctx.Invoke("aws:ecr/getRepository:getRepository", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getRepository.
type LookupRepositoryArgs struct {
	// Name of the ECR Repository.
	Name string `pulumi:"name"`
	// Registry ID where the repository was created.
	RegistryId *string `pulumi:"registryId"`
	// Map of tags assigned to the resource.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getRepository.
type LookupRepositoryResult struct {
	// Full ARN of the repository.
	Arn string `pulumi:"arn"`
	// Encryption configuration for the repository. See Encryption Configuration below.
	EncryptionConfigurations []GetRepositoryEncryptionConfiguration `pulumi:"encryptionConfigurations"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Configuration block that defines image scanning configuration for the repository. See Image Scanning Configuration below.
	ImageScanningConfigurations []GetRepositoryImageScanningConfiguration `pulumi:"imageScanningConfigurations"`
	// The tag mutability setting for the repository.
	ImageTagMutability string `pulumi:"imageTagMutability"`
	// List of image tags associated with the most recently pushed image in the repository.
	MostRecentImageTags []string `pulumi:"mostRecentImageTags"`
	Name                string   `pulumi:"name"`
	RegistryId          string   `pulumi:"registryId"`
	// URL of the repository (in the form `aws_account_id.dkr.ecr.region.amazonaws.com/repositoryName`).
	RepositoryUrl string `pulumi:"repositoryUrl"`
	// Map of tags assigned to the resource.
	Tags map[string]string `pulumi:"tags"`
}

func LookupRepositoryOutput(ctx *pulumi.Context, args LookupRepositoryOutputArgs, opts ...pulumi.InvokeOption) LookupRepositoryResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupRepositoryResultOutput, error) {
			args := v.(LookupRepositoryArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:ecr/getRepository:getRepository", args, LookupRepositoryResultOutput{}, options).(LookupRepositoryResultOutput), nil
		}).(LookupRepositoryResultOutput)
}

// A collection of arguments for invoking getRepository.
type LookupRepositoryOutputArgs struct {
	// Name of the ECR Repository.
	Name pulumi.StringInput `pulumi:"name"`
	// Registry ID where the repository was created.
	RegistryId pulumi.StringPtrInput `pulumi:"registryId"`
	// Map of tags assigned to the resource.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupRepositoryOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupRepositoryArgs)(nil)).Elem()
}

// A collection of values returned by getRepository.
type LookupRepositoryResultOutput struct{ *pulumi.OutputState }

func (LookupRepositoryResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupRepositoryResult)(nil)).Elem()
}

func (o LookupRepositoryResultOutput) ToLookupRepositoryResultOutput() LookupRepositoryResultOutput {
	return o
}

func (o LookupRepositoryResultOutput) ToLookupRepositoryResultOutputWithContext(ctx context.Context) LookupRepositoryResultOutput {
	return o
}

// Full ARN of the repository.
func (o LookupRepositoryResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupRepositoryResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Encryption configuration for the repository. See Encryption Configuration below.
func (o LookupRepositoryResultOutput) EncryptionConfigurations() GetRepositoryEncryptionConfigurationArrayOutput {
	return o.ApplyT(func(v LookupRepositoryResult) []GetRepositoryEncryptionConfiguration {
		return v.EncryptionConfigurations
	}).(GetRepositoryEncryptionConfigurationArrayOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupRepositoryResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupRepositoryResult) string { return v.Id }).(pulumi.StringOutput)
}

// Configuration block that defines image scanning configuration for the repository. See Image Scanning Configuration below.
func (o LookupRepositoryResultOutput) ImageScanningConfigurations() GetRepositoryImageScanningConfigurationArrayOutput {
	return o.ApplyT(func(v LookupRepositoryResult) []GetRepositoryImageScanningConfiguration {
		return v.ImageScanningConfigurations
	}).(GetRepositoryImageScanningConfigurationArrayOutput)
}

// The tag mutability setting for the repository.
func (o LookupRepositoryResultOutput) ImageTagMutability() pulumi.StringOutput {
	return o.ApplyT(func(v LookupRepositoryResult) string { return v.ImageTagMutability }).(pulumi.StringOutput)
}

// List of image tags associated with the most recently pushed image in the repository.
func (o LookupRepositoryResultOutput) MostRecentImageTags() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupRepositoryResult) []string { return v.MostRecentImageTags }).(pulumi.StringArrayOutput)
}

func (o LookupRepositoryResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupRepositoryResult) string { return v.Name }).(pulumi.StringOutput)
}

func (o LookupRepositoryResultOutput) RegistryId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupRepositoryResult) string { return v.RegistryId }).(pulumi.StringOutput)
}

// URL of the repository (in the form `aws_account_id.dkr.ecr.region.amazonaws.com/repositoryName`).
func (o LookupRepositoryResultOutput) RepositoryUrl() pulumi.StringOutput {
	return o.ApplyT(func(v LookupRepositoryResult) string { return v.RepositoryUrl }).(pulumi.StringOutput)
}

// Map of tags assigned to the resource.
func (o LookupRepositoryResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupRepositoryResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupRepositoryResultOutput{})
}
