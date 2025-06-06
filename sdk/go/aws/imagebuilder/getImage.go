// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package imagebuilder

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides details about an Image Builder Image.
//
// ## Example Usage
//
// ### Latest
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/imagebuilder"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := imagebuilder.LookupImage(ctx, &imagebuilder.LookupImageArgs{
//				Arn: "arn:aws:imagebuilder:us-west-2:aws:image/amazon-linux-2-x86/x.x.x",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupImage(ctx *pulumi.Context, args *LookupImageArgs, opts ...pulumi.InvokeOption) (*LookupImageResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupImageResult
	err := ctx.Invoke("aws:imagebuilder/getImage:getImage", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getImage.
type LookupImageArgs struct {
	// ARN of the image. The suffix can either be specified with wildcards (`x.x.x`) to fetch the latest build version or a full build version (e.g., `2020.11.26/1`) to fetch an exact version.
	Arn string `pulumi:"arn"`
	// Key-value map of resource tags for the image.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getImage.
type LookupImageResult struct {
	Arn string `pulumi:"arn"`
	// Build version ARN of the image. This will always have the `#.#.#/#` suffix.
	BuildVersionArn string `pulumi:"buildVersionArn"`
	// ARN of the container recipe.
	ContainerRecipeArn string `pulumi:"containerRecipeArn"`
	// Date the image was created.
	DateCreated string `pulumi:"dateCreated"`
	// ARN of the Image Builder Distribution Configuration.
	DistributionConfigurationArn string `pulumi:"distributionConfigurationArn"`
	// Whether additional information about the image being created is collected.
	EnhancedImageMetadataEnabled bool `pulumi:"enhancedImageMetadataEnabled"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// ARN of the image recipe.
	ImageRecipeArn string `pulumi:"imageRecipeArn"`
	// List of an object with image scanning configuration fields.
	ImageScanningConfigurations []GetImageImageScanningConfiguration `pulumi:"imageScanningConfigurations"`
	// List of an object with image tests configuration.
	ImageTestsConfigurations []GetImageImageTestsConfiguration `pulumi:"imageTestsConfigurations"`
	// ARN of the Image Builder Infrastructure Configuration.
	InfrastructureConfigurationArn string `pulumi:"infrastructureConfigurationArn"`
	// Name of the AMI.
	Name string `pulumi:"name"`
	// Operating System version of the image.
	OsVersion string `pulumi:"osVersion"`
	// List of objects with resources created by the image.
	OutputResources []GetImageOutputResource `pulumi:"outputResources"`
	// Platform of the image.
	Platform string `pulumi:"platform"`
	// Key-value map of resource tags for the image.
	Tags map[string]string `pulumi:"tags"`
	// Version of the image.
	Version string `pulumi:"version"`
}

func LookupImageOutput(ctx *pulumi.Context, args LookupImageOutputArgs, opts ...pulumi.InvokeOption) LookupImageResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupImageResultOutput, error) {
			args := v.(LookupImageArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:imagebuilder/getImage:getImage", args, LookupImageResultOutput{}, options).(LookupImageResultOutput), nil
		}).(LookupImageResultOutput)
}

// A collection of arguments for invoking getImage.
type LookupImageOutputArgs struct {
	// ARN of the image. The suffix can either be specified with wildcards (`x.x.x`) to fetch the latest build version or a full build version (e.g., `2020.11.26/1`) to fetch an exact version.
	Arn pulumi.StringInput `pulumi:"arn"`
	// Key-value map of resource tags for the image.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupImageOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupImageArgs)(nil)).Elem()
}

// A collection of values returned by getImage.
type LookupImageResultOutput struct{ *pulumi.OutputState }

func (LookupImageResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupImageResult)(nil)).Elem()
}

func (o LookupImageResultOutput) ToLookupImageResultOutput() LookupImageResultOutput {
	return o
}

func (o LookupImageResultOutput) ToLookupImageResultOutputWithContext(ctx context.Context) LookupImageResultOutput {
	return o
}

func (o LookupImageResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Build version ARN of the image. This will always have the `#.#.#/#` suffix.
func (o LookupImageResultOutput) BuildVersionArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.BuildVersionArn }).(pulumi.StringOutput)
}

// ARN of the container recipe.
func (o LookupImageResultOutput) ContainerRecipeArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.ContainerRecipeArn }).(pulumi.StringOutput)
}

// Date the image was created.
func (o LookupImageResultOutput) DateCreated() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.DateCreated }).(pulumi.StringOutput)
}

// ARN of the Image Builder Distribution Configuration.
func (o LookupImageResultOutput) DistributionConfigurationArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.DistributionConfigurationArn }).(pulumi.StringOutput)
}

// Whether additional information about the image being created is collected.
func (o LookupImageResultOutput) EnhancedImageMetadataEnabled() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupImageResult) bool { return v.EnhancedImageMetadataEnabled }).(pulumi.BoolOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupImageResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.Id }).(pulumi.StringOutput)
}

// ARN of the image recipe.
func (o LookupImageResultOutput) ImageRecipeArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.ImageRecipeArn }).(pulumi.StringOutput)
}

// List of an object with image scanning configuration fields.
func (o LookupImageResultOutput) ImageScanningConfigurations() GetImageImageScanningConfigurationArrayOutput {
	return o.ApplyT(func(v LookupImageResult) []GetImageImageScanningConfiguration { return v.ImageScanningConfigurations }).(GetImageImageScanningConfigurationArrayOutput)
}

// List of an object with image tests configuration.
func (o LookupImageResultOutput) ImageTestsConfigurations() GetImageImageTestsConfigurationArrayOutput {
	return o.ApplyT(func(v LookupImageResult) []GetImageImageTestsConfiguration { return v.ImageTestsConfigurations }).(GetImageImageTestsConfigurationArrayOutput)
}

// ARN of the Image Builder Infrastructure Configuration.
func (o LookupImageResultOutput) InfrastructureConfigurationArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.InfrastructureConfigurationArn }).(pulumi.StringOutput)
}

// Name of the AMI.
func (o LookupImageResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.Name }).(pulumi.StringOutput)
}

// Operating System version of the image.
func (o LookupImageResultOutput) OsVersion() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.OsVersion }).(pulumi.StringOutput)
}

// List of objects with resources created by the image.
func (o LookupImageResultOutput) OutputResources() GetImageOutputResourceArrayOutput {
	return o.ApplyT(func(v LookupImageResult) []GetImageOutputResource { return v.OutputResources }).(GetImageOutputResourceArrayOutput)
}

// Platform of the image.
func (o LookupImageResultOutput) Platform() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.Platform }).(pulumi.StringOutput)
}

// Key-value map of resource tags for the image.
func (o LookupImageResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupImageResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// Version of the image.
func (o LookupImageResultOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v LookupImageResult) string { return v.Version }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupImageResultOutput{})
}
