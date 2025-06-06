// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package controltower

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Creates a new landing zone using Control Tower. For more information on usage, please see the
// [AWS Control Tower Landing Zone User Guide](https://docs.aws.amazon.com/controltower/latest/userguide/how-control-tower-works.html).
//
// ## Import
//
// Using `pulumi import`, import a Control Tower Landing Zone using the `id`. For example:
//
// ```sh
// $ pulumi import aws:controltower/landingZone:LandingZone example 1A2B3C4D5E6F7G8H
// ```
type LandingZone struct {
	pulumi.CustomResourceState

	// The ARN of the landing zone.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The drift status summary of the landing zone.
	DriftStatuses LandingZoneDriftStatusArrayOutput `pulumi:"driftStatuses"`
	// The latest available version of the landing zone.
	LatestAvailableVersion pulumi.StringOutput `pulumi:"latestAvailableVersion"`
	// The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
	ManifestJson pulumi.StringOutput `pulumi:"manifestJson"`
	// Tags to apply to the landing zone. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the landing zone, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The landing zone version.
	Version pulumi.StringOutput `pulumi:"version"`
}

// NewLandingZone registers a new resource with the given unique name, arguments, and options.
func NewLandingZone(ctx *pulumi.Context,
	name string, args *LandingZoneArgs, opts ...pulumi.ResourceOption) (*LandingZone, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ManifestJson == nil {
		return nil, errors.New("invalid value for required argument 'ManifestJson'")
	}
	if args.Version == nil {
		return nil, errors.New("invalid value for required argument 'Version'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource LandingZone
	err := ctx.RegisterResource("aws:controltower/landingZone:LandingZone", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetLandingZone gets an existing LandingZone resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetLandingZone(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *LandingZoneState, opts ...pulumi.ResourceOption) (*LandingZone, error) {
	var resource LandingZone
	err := ctx.ReadResource("aws:controltower/landingZone:LandingZone", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering LandingZone resources.
type landingZoneState struct {
	// The ARN of the landing zone.
	Arn *string `pulumi:"arn"`
	// The drift status summary of the landing zone.
	DriftStatuses []LandingZoneDriftStatus `pulumi:"driftStatuses"`
	// The latest available version of the landing zone.
	LatestAvailableVersion *string `pulumi:"latestAvailableVersion"`
	// The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
	ManifestJson *string `pulumi:"manifestJson"`
	// Tags to apply to the landing zone. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the landing zone, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The landing zone version.
	Version *string `pulumi:"version"`
}

type LandingZoneState struct {
	// The ARN of the landing zone.
	Arn pulumi.StringPtrInput
	// The drift status summary of the landing zone.
	DriftStatuses LandingZoneDriftStatusArrayInput
	// The latest available version of the landing zone.
	LatestAvailableVersion pulumi.StringPtrInput
	// The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
	ManifestJson pulumi.StringPtrInput
	// Tags to apply to the landing zone. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the landing zone, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The landing zone version.
	Version pulumi.StringPtrInput
}

func (LandingZoneState) ElementType() reflect.Type {
	return reflect.TypeOf((*landingZoneState)(nil)).Elem()
}

type landingZoneArgs struct {
	// The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
	ManifestJson string `pulumi:"manifestJson"`
	// Tags to apply to the landing zone. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// The landing zone version.
	Version string `pulumi:"version"`
}

// The set of arguments for constructing a LandingZone resource.
type LandingZoneArgs struct {
	// The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
	ManifestJson pulumi.StringInput
	// Tags to apply to the landing zone. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// The landing zone version.
	Version pulumi.StringInput
}

func (LandingZoneArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*landingZoneArgs)(nil)).Elem()
}

type LandingZoneInput interface {
	pulumi.Input

	ToLandingZoneOutput() LandingZoneOutput
	ToLandingZoneOutputWithContext(ctx context.Context) LandingZoneOutput
}

func (*LandingZone) ElementType() reflect.Type {
	return reflect.TypeOf((**LandingZone)(nil)).Elem()
}

func (i *LandingZone) ToLandingZoneOutput() LandingZoneOutput {
	return i.ToLandingZoneOutputWithContext(context.Background())
}

func (i *LandingZone) ToLandingZoneOutputWithContext(ctx context.Context) LandingZoneOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LandingZoneOutput)
}

// LandingZoneArrayInput is an input type that accepts LandingZoneArray and LandingZoneArrayOutput values.
// You can construct a concrete instance of `LandingZoneArrayInput` via:
//
//	LandingZoneArray{ LandingZoneArgs{...} }
type LandingZoneArrayInput interface {
	pulumi.Input

	ToLandingZoneArrayOutput() LandingZoneArrayOutput
	ToLandingZoneArrayOutputWithContext(context.Context) LandingZoneArrayOutput
}

type LandingZoneArray []LandingZoneInput

func (LandingZoneArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LandingZone)(nil)).Elem()
}

func (i LandingZoneArray) ToLandingZoneArrayOutput() LandingZoneArrayOutput {
	return i.ToLandingZoneArrayOutputWithContext(context.Background())
}

func (i LandingZoneArray) ToLandingZoneArrayOutputWithContext(ctx context.Context) LandingZoneArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LandingZoneArrayOutput)
}

// LandingZoneMapInput is an input type that accepts LandingZoneMap and LandingZoneMapOutput values.
// You can construct a concrete instance of `LandingZoneMapInput` via:
//
//	LandingZoneMap{ "key": LandingZoneArgs{...} }
type LandingZoneMapInput interface {
	pulumi.Input

	ToLandingZoneMapOutput() LandingZoneMapOutput
	ToLandingZoneMapOutputWithContext(context.Context) LandingZoneMapOutput
}

type LandingZoneMap map[string]LandingZoneInput

func (LandingZoneMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LandingZone)(nil)).Elem()
}

func (i LandingZoneMap) ToLandingZoneMapOutput() LandingZoneMapOutput {
	return i.ToLandingZoneMapOutputWithContext(context.Background())
}

func (i LandingZoneMap) ToLandingZoneMapOutputWithContext(ctx context.Context) LandingZoneMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LandingZoneMapOutput)
}

type LandingZoneOutput struct{ *pulumi.OutputState }

func (LandingZoneOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**LandingZone)(nil)).Elem()
}

func (o LandingZoneOutput) ToLandingZoneOutput() LandingZoneOutput {
	return o
}

func (o LandingZoneOutput) ToLandingZoneOutputWithContext(ctx context.Context) LandingZoneOutput {
	return o
}

// The ARN of the landing zone.
func (o LandingZoneOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *LandingZone) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The drift status summary of the landing zone.
func (o LandingZoneOutput) DriftStatuses() LandingZoneDriftStatusArrayOutput {
	return o.ApplyT(func(v *LandingZone) LandingZoneDriftStatusArrayOutput { return v.DriftStatuses }).(LandingZoneDriftStatusArrayOutput)
}

// The latest available version of the landing zone.
func (o LandingZoneOutput) LatestAvailableVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *LandingZone) pulumi.StringOutput { return v.LatestAvailableVersion }).(pulumi.StringOutput)
}

// The manifest JSON file is a text file that describes your AWS resources. For examples, review [Launch your landing zone](https://docs.aws.amazon.com/controltower/latest/userguide/lz-api-launch).
func (o LandingZoneOutput) ManifestJson() pulumi.StringOutput {
	return o.ApplyT(func(v *LandingZone) pulumi.StringOutput { return v.ManifestJson }).(pulumi.StringOutput)
}

// Tags to apply to the landing zone. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o LandingZoneOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *LandingZone) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the landing zone, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o LandingZoneOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *LandingZone) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The landing zone version.
func (o LandingZoneOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v *LandingZone) pulumi.StringOutput { return v.Version }).(pulumi.StringOutput)
}

type LandingZoneArrayOutput struct{ *pulumi.OutputState }

func (LandingZoneArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LandingZone)(nil)).Elem()
}

func (o LandingZoneArrayOutput) ToLandingZoneArrayOutput() LandingZoneArrayOutput {
	return o
}

func (o LandingZoneArrayOutput) ToLandingZoneArrayOutputWithContext(ctx context.Context) LandingZoneArrayOutput {
	return o
}

func (o LandingZoneArrayOutput) Index(i pulumi.IntInput) LandingZoneOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *LandingZone {
		return vs[0].([]*LandingZone)[vs[1].(int)]
	}).(LandingZoneOutput)
}

type LandingZoneMapOutput struct{ *pulumi.OutputState }

func (LandingZoneMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LandingZone)(nil)).Elem()
}

func (o LandingZoneMapOutput) ToLandingZoneMapOutput() LandingZoneMapOutput {
	return o
}

func (o LandingZoneMapOutput) ToLandingZoneMapOutputWithContext(ctx context.Context) LandingZoneMapOutput {
	return o
}

func (o LandingZoneMapOutput) MapIndex(k pulumi.StringInput) LandingZoneOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *LandingZone {
		return vs[0].(map[string]*LandingZone)[vs[1].(string)]
	}).(LandingZoneOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*LandingZoneInput)(nil)).Elem(), &LandingZone{})
	pulumi.RegisterInputType(reflect.TypeOf((*LandingZoneArrayInput)(nil)).Elem(), LandingZoneArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*LandingZoneMapInput)(nil)).Elem(), LandingZoneMap{})
	pulumi.RegisterOutputType(LandingZoneOutput{})
	pulumi.RegisterOutputType(LandingZoneArrayOutput{})
	pulumi.RegisterOutputType(LandingZoneMapOutput{})
}
