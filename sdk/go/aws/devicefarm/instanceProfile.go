// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package devicefarm

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a resource to manage AWS Device Farm Instance Profiles.
// ∂
// > **NOTE:** AWS currently has limited regional support for Device Farm (e.g., `us-west-2`). See [AWS Device Farm endpoints and quotas](https://docs.aws.amazon.com/general/latest/gr/devicefarm.html) for information on supported regions.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/devicefarm"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := devicefarm.NewInstanceProfile(ctx, "example", &devicefarm.InstanceProfileArgs{
//				Name: pulumi.String("example"),
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ## Import
//
// Using `pulumi import`, import DeviceFarm Instance Profiles using their ARN. For example:
//
// ```sh
// $ pulumi import aws:devicefarm/instanceProfile:InstanceProfile example arn:aws:devicefarm:us-west-2:123456789012:instanceprofile:4fa784c7-ccb4-4dbf-ba4f-02198320daa1
// ```
type InstanceProfile struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name of this instance profile.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The description of the instance profile.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// An array of strings that specifies the list of app packages that should not be cleaned up from the device after a test run.
	ExcludeAppPackagesFromCleanups pulumi.StringArrayOutput `pulumi:"excludeAppPackagesFromCleanups"`
	// The name for the instance profile.
	Name pulumi.StringOutput `pulumi:"name"`
	// When set to `true`, Device Farm removes app packages after a test run. The default value is `false` for private devices.
	PackageCleanup pulumi.BoolPtrOutput `pulumi:"packageCleanup"`
	// When set to `true`, Device Farm reboots the instance after a test run. The default value is `true`.
	RebootAfterUse pulumi.BoolPtrOutput `pulumi:"rebootAfterUse"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewInstanceProfile registers a new resource with the given unique name, arguments, and options.
func NewInstanceProfile(ctx *pulumi.Context,
	name string, args *InstanceProfileArgs, opts ...pulumi.ResourceOption) (*InstanceProfile, error) {
	if args == nil {
		args = &InstanceProfileArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource InstanceProfile
	err := ctx.RegisterResource("aws:devicefarm/instanceProfile:InstanceProfile", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetInstanceProfile gets an existing InstanceProfile resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetInstanceProfile(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *InstanceProfileState, opts ...pulumi.ResourceOption) (*InstanceProfile, error) {
	var resource InstanceProfile
	err := ctx.ReadResource("aws:devicefarm/instanceProfile:InstanceProfile", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering InstanceProfile resources.
type instanceProfileState struct {
	// The Amazon Resource Name of this instance profile.
	Arn *string `pulumi:"arn"`
	// The description of the instance profile.
	Description *string `pulumi:"description"`
	// An array of strings that specifies the list of app packages that should not be cleaned up from the device after a test run.
	ExcludeAppPackagesFromCleanups []string `pulumi:"excludeAppPackagesFromCleanups"`
	// The name for the instance profile.
	Name *string `pulumi:"name"`
	// When set to `true`, Device Farm removes app packages after a test run. The default value is `false` for private devices.
	PackageCleanup *bool `pulumi:"packageCleanup"`
	// When set to `true`, Device Farm reboots the instance after a test run. The default value is `true`.
	RebootAfterUse *bool `pulumi:"rebootAfterUse"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type InstanceProfileState struct {
	// The Amazon Resource Name of this instance profile.
	Arn pulumi.StringPtrInput
	// The description of the instance profile.
	Description pulumi.StringPtrInput
	// An array of strings that specifies the list of app packages that should not be cleaned up from the device after a test run.
	ExcludeAppPackagesFromCleanups pulumi.StringArrayInput
	// The name for the instance profile.
	Name pulumi.StringPtrInput
	// When set to `true`, Device Farm removes app packages after a test run. The default value is `false` for private devices.
	PackageCleanup pulumi.BoolPtrInput
	// When set to `true`, Device Farm reboots the instance after a test run. The default value is `true`.
	RebootAfterUse pulumi.BoolPtrInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (InstanceProfileState) ElementType() reflect.Type {
	return reflect.TypeOf((*instanceProfileState)(nil)).Elem()
}

type instanceProfileArgs struct {
	// The description of the instance profile.
	Description *string `pulumi:"description"`
	// An array of strings that specifies the list of app packages that should not be cleaned up from the device after a test run.
	ExcludeAppPackagesFromCleanups []string `pulumi:"excludeAppPackagesFromCleanups"`
	// The name for the instance profile.
	Name *string `pulumi:"name"`
	// When set to `true`, Device Farm removes app packages after a test run. The default value is `false` for private devices.
	PackageCleanup *bool `pulumi:"packageCleanup"`
	// When set to `true`, Device Farm reboots the instance after a test run. The default value is `true`.
	RebootAfterUse *bool `pulumi:"rebootAfterUse"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a InstanceProfile resource.
type InstanceProfileArgs struct {
	// The description of the instance profile.
	Description pulumi.StringPtrInput
	// An array of strings that specifies the list of app packages that should not be cleaned up from the device after a test run.
	ExcludeAppPackagesFromCleanups pulumi.StringArrayInput
	// The name for the instance profile.
	Name pulumi.StringPtrInput
	// When set to `true`, Device Farm removes app packages after a test run. The default value is `false` for private devices.
	PackageCleanup pulumi.BoolPtrInput
	// When set to `true`, Device Farm reboots the instance after a test run. The default value is `true`.
	RebootAfterUse pulumi.BoolPtrInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (InstanceProfileArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*instanceProfileArgs)(nil)).Elem()
}

type InstanceProfileInput interface {
	pulumi.Input

	ToInstanceProfileOutput() InstanceProfileOutput
	ToInstanceProfileOutputWithContext(ctx context.Context) InstanceProfileOutput
}

func (*InstanceProfile) ElementType() reflect.Type {
	return reflect.TypeOf((**InstanceProfile)(nil)).Elem()
}

func (i *InstanceProfile) ToInstanceProfileOutput() InstanceProfileOutput {
	return i.ToInstanceProfileOutputWithContext(context.Background())
}

func (i *InstanceProfile) ToInstanceProfileOutputWithContext(ctx context.Context) InstanceProfileOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InstanceProfileOutput)
}

// InstanceProfileArrayInput is an input type that accepts InstanceProfileArray and InstanceProfileArrayOutput values.
// You can construct a concrete instance of `InstanceProfileArrayInput` via:
//
//	InstanceProfileArray{ InstanceProfileArgs{...} }
type InstanceProfileArrayInput interface {
	pulumi.Input

	ToInstanceProfileArrayOutput() InstanceProfileArrayOutput
	ToInstanceProfileArrayOutputWithContext(context.Context) InstanceProfileArrayOutput
}

type InstanceProfileArray []InstanceProfileInput

func (InstanceProfileArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*InstanceProfile)(nil)).Elem()
}

func (i InstanceProfileArray) ToInstanceProfileArrayOutput() InstanceProfileArrayOutput {
	return i.ToInstanceProfileArrayOutputWithContext(context.Background())
}

func (i InstanceProfileArray) ToInstanceProfileArrayOutputWithContext(ctx context.Context) InstanceProfileArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InstanceProfileArrayOutput)
}

// InstanceProfileMapInput is an input type that accepts InstanceProfileMap and InstanceProfileMapOutput values.
// You can construct a concrete instance of `InstanceProfileMapInput` via:
//
//	InstanceProfileMap{ "key": InstanceProfileArgs{...} }
type InstanceProfileMapInput interface {
	pulumi.Input

	ToInstanceProfileMapOutput() InstanceProfileMapOutput
	ToInstanceProfileMapOutputWithContext(context.Context) InstanceProfileMapOutput
}

type InstanceProfileMap map[string]InstanceProfileInput

func (InstanceProfileMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*InstanceProfile)(nil)).Elem()
}

func (i InstanceProfileMap) ToInstanceProfileMapOutput() InstanceProfileMapOutput {
	return i.ToInstanceProfileMapOutputWithContext(context.Background())
}

func (i InstanceProfileMap) ToInstanceProfileMapOutputWithContext(ctx context.Context) InstanceProfileMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InstanceProfileMapOutput)
}

type InstanceProfileOutput struct{ *pulumi.OutputState }

func (InstanceProfileOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**InstanceProfile)(nil)).Elem()
}

func (o InstanceProfileOutput) ToInstanceProfileOutput() InstanceProfileOutput {
	return o
}

func (o InstanceProfileOutput) ToInstanceProfileOutputWithContext(ctx context.Context) InstanceProfileOutput {
	return o
}

// The Amazon Resource Name of this instance profile.
func (o InstanceProfileOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *InstanceProfile) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The description of the instance profile.
func (o InstanceProfileOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *InstanceProfile) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// An array of strings that specifies the list of app packages that should not be cleaned up from the device after a test run.
func (o InstanceProfileOutput) ExcludeAppPackagesFromCleanups() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *InstanceProfile) pulumi.StringArrayOutput { return v.ExcludeAppPackagesFromCleanups }).(pulumi.StringArrayOutput)
}

// The name for the instance profile.
func (o InstanceProfileOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *InstanceProfile) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// When set to `true`, Device Farm removes app packages after a test run. The default value is `false` for private devices.
func (o InstanceProfileOutput) PackageCleanup() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *InstanceProfile) pulumi.BoolPtrOutput { return v.PackageCleanup }).(pulumi.BoolPtrOutput)
}

// When set to `true`, Device Farm reboots the instance after a test run. The default value is `true`.
func (o InstanceProfileOutput) RebootAfterUse() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *InstanceProfile) pulumi.BoolPtrOutput { return v.RebootAfterUse }).(pulumi.BoolPtrOutput)
}

// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o InstanceProfileOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *InstanceProfile) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o InstanceProfileOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *InstanceProfile) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type InstanceProfileArrayOutput struct{ *pulumi.OutputState }

func (InstanceProfileArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*InstanceProfile)(nil)).Elem()
}

func (o InstanceProfileArrayOutput) ToInstanceProfileArrayOutput() InstanceProfileArrayOutput {
	return o
}

func (o InstanceProfileArrayOutput) ToInstanceProfileArrayOutputWithContext(ctx context.Context) InstanceProfileArrayOutput {
	return o
}

func (o InstanceProfileArrayOutput) Index(i pulumi.IntInput) InstanceProfileOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *InstanceProfile {
		return vs[0].([]*InstanceProfile)[vs[1].(int)]
	}).(InstanceProfileOutput)
}

type InstanceProfileMapOutput struct{ *pulumi.OutputState }

func (InstanceProfileMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*InstanceProfile)(nil)).Elem()
}

func (o InstanceProfileMapOutput) ToInstanceProfileMapOutput() InstanceProfileMapOutput {
	return o
}

func (o InstanceProfileMapOutput) ToInstanceProfileMapOutputWithContext(ctx context.Context) InstanceProfileMapOutput {
	return o
}

func (o InstanceProfileMapOutput) MapIndex(k pulumi.StringInput) InstanceProfileOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *InstanceProfile {
		return vs[0].(map[string]*InstanceProfile)[vs[1].(string)]
	}).(InstanceProfileOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*InstanceProfileInput)(nil)).Elem(), &InstanceProfile{})
	pulumi.RegisterInputType(reflect.TypeOf((*InstanceProfileArrayInput)(nil)).Elem(), InstanceProfileArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*InstanceProfileMapInput)(nil)).Elem(), InstanceProfileMap{})
	pulumi.RegisterOutputType(InstanceProfileOutput{})
	pulumi.RegisterOutputType(InstanceProfileArrayOutput{})
	pulumi.RegisterOutputType(InstanceProfileMapOutput{})
}
