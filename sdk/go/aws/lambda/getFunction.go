// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lambda

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides information about a Lambda Function.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lambda"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi/config"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			cfg := config.New(ctx, "")
//			functionName := cfg.Require("functionName")
//			_, err := lambda.LookupFunction(ctx, &lambda.LookupFunctionArgs{
//				FunctionName: functionName,
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupFunction(ctx *pulumi.Context, args *LookupFunctionArgs, opts ...pulumi.InvokeOption) (*LookupFunctionResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupFunctionResult
	err := ctx.Invoke("aws:lambda/getFunction:getFunction", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getFunction.
type LookupFunctionArgs struct {
	// Name of the lambda function.
	FunctionName string `pulumi:"functionName"`
	// Alias name or version number of the lambda functionE.g., `$LATEST`, `my-alias`, or `1`. When not included: the data source resolves to the most recent published version; if no published version exists: it resolves to the most recent unpublished version.
	Qualifier *string           `pulumi:"qualifier"`
	Tags      map[string]string `pulumi:"tags"`
}

// A collection of values returned by getFunction.
type LookupFunctionResult struct {
	// Instruction set architecture for the Lambda function.
	Architectures []string `pulumi:"architectures"`
	// Unqualified (no `:QUALIFIER` or `:VERSION` suffix) ARN identifying your Lambda Function. See also `qualifiedArn`.
	Arn string `pulumi:"arn"`
	// Base64-encoded representation of raw SHA-256 sum of the zip file.
	CodeSha256 string `pulumi:"codeSha256"`
	// ARN for a Code Signing Configuration.
	CodeSigningConfigArn string `pulumi:"codeSigningConfigArn"`
	// Configure the function's *dead letter queue*.
	DeadLetterConfig GetFunctionDeadLetterConfig `pulumi:"deadLetterConfig"`
	// Description of what your Lambda Function does.
	Description string `pulumi:"description"`
	// Lambda environment's configuration settings.
	Environment GetFunctionEnvironment `pulumi:"environment"`
	// Amount of Ephemeral storage(`/tmp`) allocated for the Lambda Function.
	EphemeralStorages []GetFunctionEphemeralStorage `pulumi:"ephemeralStorages"`
	// Connection settings for an Amazon EFS file system.
	FileSystemConfigs []GetFunctionFileSystemConfig `pulumi:"fileSystemConfigs"`
	FunctionName      string                        `pulumi:"functionName"`
	// Function entrypoint in your code.
	Handler string `pulumi:"handler"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// URI of the container image.
	ImageUri string `pulumi:"imageUri"`
	// ARN to be used for invoking Lambda Function from API Gateway. **NOTE:** Starting with `v4.51.0` of the provider, this will *not* include the qualifier.
	InvokeArn string `pulumi:"invokeArn"`
	// ARN for the KMS encryption key.
	KmsKeyArn string `pulumi:"kmsKeyArn"`
	// Date this resource was last modified.
	LastModified string `pulumi:"lastModified"`
	// List of Lambda Layer ARNs attached to your Lambda Function.
	Layers []string `pulumi:"layers"`
	// Advanced logging settings.
	LoggingConfigs []GetFunctionLoggingConfig `pulumi:"loggingConfigs"`
	// Amount of memory in MB your Lambda Function can use at runtime.
	MemorySize int `pulumi:"memorySize"`
	// Qualified (`:QUALIFIER` or `:VERSION` suffix) ARN identifying your Lambda Function. See also `arn`.
	QualifiedArn string `pulumi:"qualifiedArn"`
	// Qualified (`:QUALIFIER` or `:VERSION` suffix) ARN to be used for invoking Lambda Function from API Gateway. See also `invokeArn`.
	QualifiedInvokeArn string  `pulumi:"qualifiedInvokeArn"`
	Qualifier          *string `pulumi:"qualifier"`
	// The amount of reserved concurrent executions for this lambda function or `-1` if unreserved.
	ReservedConcurrentExecutions int `pulumi:"reservedConcurrentExecutions"`
	// IAM role attached to the Lambda Function.
	Role string `pulumi:"role"`
	// Runtime environment for the Lambda function.
	Runtime string `pulumi:"runtime"`
	// ARN of a signing job.
	SigningJobArn string `pulumi:"signingJobArn"`
	// The ARN for a signing profile version.
	SigningProfileVersionArn string `pulumi:"signingProfileVersionArn"`
	// (**Deprecated** use `codeSha256` instead) Base64-encoded representation of raw SHA-256 sum of the zip file.
	//
	// Deprecated: source_code_hash is deprecated. Use codeSha256 instead.
	SourceCodeHash string `pulumi:"sourceCodeHash"`
	// Size in bytes of the function .zip file.
	SourceCodeSize int               `pulumi:"sourceCodeSize"`
	Tags           map[string]string `pulumi:"tags"`
	// Function execution time at which Lambda should terminate the function.
	Timeout int `pulumi:"timeout"`
	// Tracing settings of the function.
	TracingConfig GetFunctionTracingConfig `pulumi:"tracingConfig"`
	// The version of the Lambda function returned. If `qualifier` is not set, this will resolve to the most recent published version. If no published version of the function exists, `version` will resolve to `$LATEST`.
	Version string `pulumi:"version"`
	// VPC configuration associated with your Lambda function.
	VpcConfig GetFunctionVpcConfig `pulumi:"vpcConfig"`
}

func LookupFunctionOutput(ctx *pulumi.Context, args LookupFunctionOutputArgs, opts ...pulumi.InvokeOption) LookupFunctionResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupFunctionResultOutput, error) {
			args := v.(LookupFunctionArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:lambda/getFunction:getFunction", args, LookupFunctionResultOutput{}, options).(LookupFunctionResultOutput), nil
		}).(LookupFunctionResultOutput)
}

// A collection of arguments for invoking getFunction.
type LookupFunctionOutputArgs struct {
	// Name of the lambda function.
	FunctionName pulumi.StringInput `pulumi:"functionName"`
	// Alias name or version number of the lambda functionE.g., `$LATEST`, `my-alias`, or `1`. When not included: the data source resolves to the most recent published version; if no published version exists: it resolves to the most recent unpublished version.
	Qualifier pulumi.StringPtrInput `pulumi:"qualifier"`
	Tags      pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupFunctionOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupFunctionArgs)(nil)).Elem()
}

// A collection of values returned by getFunction.
type LookupFunctionResultOutput struct{ *pulumi.OutputState }

func (LookupFunctionResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupFunctionResult)(nil)).Elem()
}

func (o LookupFunctionResultOutput) ToLookupFunctionResultOutput() LookupFunctionResultOutput {
	return o
}

func (o LookupFunctionResultOutput) ToLookupFunctionResultOutputWithContext(ctx context.Context) LookupFunctionResultOutput {
	return o
}

// Instruction set architecture for the Lambda function.
func (o LookupFunctionResultOutput) Architectures() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupFunctionResult) []string { return v.Architectures }).(pulumi.StringArrayOutput)
}

// Unqualified (no `:QUALIFIER` or `:VERSION` suffix) ARN identifying your Lambda Function. See also `qualifiedArn`.
func (o LookupFunctionResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Base64-encoded representation of raw SHA-256 sum of the zip file.
func (o LookupFunctionResultOutput) CodeSha256() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.CodeSha256 }).(pulumi.StringOutput)
}

// ARN for a Code Signing Configuration.
func (o LookupFunctionResultOutput) CodeSigningConfigArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.CodeSigningConfigArn }).(pulumi.StringOutput)
}

// Configure the function's *dead letter queue*.
func (o LookupFunctionResultOutput) DeadLetterConfig() GetFunctionDeadLetterConfigOutput {
	return o.ApplyT(func(v LookupFunctionResult) GetFunctionDeadLetterConfig { return v.DeadLetterConfig }).(GetFunctionDeadLetterConfigOutput)
}

// Description of what your Lambda Function does.
func (o LookupFunctionResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.Description }).(pulumi.StringOutput)
}

// Lambda environment's configuration settings.
func (o LookupFunctionResultOutput) Environment() GetFunctionEnvironmentOutput {
	return o.ApplyT(func(v LookupFunctionResult) GetFunctionEnvironment { return v.Environment }).(GetFunctionEnvironmentOutput)
}

// Amount of Ephemeral storage(`/tmp`) allocated for the Lambda Function.
func (o LookupFunctionResultOutput) EphemeralStorages() GetFunctionEphemeralStorageArrayOutput {
	return o.ApplyT(func(v LookupFunctionResult) []GetFunctionEphemeralStorage { return v.EphemeralStorages }).(GetFunctionEphemeralStorageArrayOutput)
}

// Connection settings for an Amazon EFS file system.
func (o LookupFunctionResultOutput) FileSystemConfigs() GetFunctionFileSystemConfigArrayOutput {
	return o.ApplyT(func(v LookupFunctionResult) []GetFunctionFileSystemConfig { return v.FileSystemConfigs }).(GetFunctionFileSystemConfigArrayOutput)
}

func (o LookupFunctionResultOutput) FunctionName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.FunctionName }).(pulumi.StringOutput)
}

// Function entrypoint in your code.
func (o LookupFunctionResultOutput) Handler() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.Handler }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupFunctionResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.Id }).(pulumi.StringOutput)
}

// URI of the container image.
func (o LookupFunctionResultOutput) ImageUri() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.ImageUri }).(pulumi.StringOutput)
}

// ARN to be used for invoking Lambda Function from API Gateway. **NOTE:** Starting with `v4.51.0` of the provider, this will *not* include the qualifier.
func (o LookupFunctionResultOutput) InvokeArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.InvokeArn }).(pulumi.StringOutput)
}

// ARN for the KMS encryption key.
func (o LookupFunctionResultOutput) KmsKeyArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.KmsKeyArn }).(pulumi.StringOutput)
}

// Date this resource was last modified.
func (o LookupFunctionResultOutput) LastModified() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.LastModified }).(pulumi.StringOutput)
}

// List of Lambda Layer ARNs attached to your Lambda Function.
func (o LookupFunctionResultOutput) Layers() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupFunctionResult) []string { return v.Layers }).(pulumi.StringArrayOutput)
}

// Advanced logging settings.
func (o LookupFunctionResultOutput) LoggingConfigs() GetFunctionLoggingConfigArrayOutput {
	return o.ApplyT(func(v LookupFunctionResult) []GetFunctionLoggingConfig { return v.LoggingConfigs }).(GetFunctionLoggingConfigArrayOutput)
}

// Amount of memory in MB your Lambda Function can use at runtime.
func (o LookupFunctionResultOutput) MemorySize() pulumi.IntOutput {
	return o.ApplyT(func(v LookupFunctionResult) int { return v.MemorySize }).(pulumi.IntOutput)
}

// Qualified (`:QUALIFIER` or `:VERSION` suffix) ARN identifying your Lambda Function. See also `arn`.
func (o LookupFunctionResultOutput) QualifiedArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.QualifiedArn }).(pulumi.StringOutput)
}

// Qualified (`:QUALIFIER` or `:VERSION` suffix) ARN to be used for invoking Lambda Function from API Gateway. See also `invokeArn`.
func (o LookupFunctionResultOutput) QualifiedInvokeArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.QualifiedInvokeArn }).(pulumi.StringOutput)
}

func (o LookupFunctionResultOutput) Qualifier() pulumi.StringPtrOutput {
	return o.ApplyT(func(v LookupFunctionResult) *string { return v.Qualifier }).(pulumi.StringPtrOutput)
}

// The amount of reserved concurrent executions for this lambda function or `-1` if unreserved.
func (o LookupFunctionResultOutput) ReservedConcurrentExecutions() pulumi.IntOutput {
	return o.ApplyT(func(v LookupFunctionResult) int { return v.ReservedConcurrentExecutions }).(pulumi.IntOutput)
}

// IAM role attached to the Lambda Function.
func (o LookupFunctionResultOutput) Role() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.Role }).(pulumi.StringOutput)
}

// Runtime environment for the Lambda function.
func (o LookupFunctionResultOutput) Runtime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.Runtime }).(pulumi.StringOutput)
}

// ARN of a signing job.
func (o LookupFunctionResultOutput) SigningJobArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.SigningJobArn }).(pulumi.StringOutput)
}

// The ARN for a signing profile version.
func (o LookupFunctionResultOutput) SigningProfileVersionArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.SigningProfileVersionArn }).(pulumi.StringOutput)
}

// (**Deprecated** use `codeSha256` instead) Base64-encoded representation of raw SHA-256 sum of the zip file.
//
// Deprecated: source_code_hash is deprecated. Use codeSha256 instead.
func (o LookupFunctionResultOutput) SourceCodeHash() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.SourceCodeHash }).(pulumi.StringOutput)
}

// Size in bytes of the function .zip file.
func (o LookupFunctionResultOutput) SourceCodeSize() pulumi.IntOutput {
	return o.ApplyT(func(v LookupFunctionResult) int { return v.SourceCodeSize }).(pulumi.IntOutput)
}

func (o LookupFunctionResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupFunctionResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// Function execution time at which Lambda should terminate the function.
func (o LookupFunctionResultOutput) Timeout() pulumi.IntOutput {
	return o.ApplyT(func(v LookupFunctionResult) int { return v.Timeout }).(pulumi.IntOutput)
}

// Tracing settings of the function.
func (o LookupFunctionResultOutput) TracingConfig() GetFunctionTracingConfigOutput {
	return o.ApplyT(func(v LookupFunctionResult) GetFunctionTracingConfig { return v.TracingConfig }).(GetFunctionTracingConfigOutput)
}

// The version of the Lambda function returned. If `qualifier` is not set, this will resolve to the most recent published version. If no published version of the function exists, `version` will resolve to `$LATEST`.
func (o LookupFunctionResultOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFunctionResult) string { return v.Version }).(pulumi.StringOutput)
}

// VPC configuration associated with your Lambda function.
func (o LookupFunctionResultOutput) VpcConfig() GetFunctionVpcConfigOutput {
	return o.ApplyT(func(v LookupFunctionResult) GetFunctionVpcConfig { return v.VpcConfig }).(GetFunctionVpcConfigOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupFunctionResultOutput{})
}
