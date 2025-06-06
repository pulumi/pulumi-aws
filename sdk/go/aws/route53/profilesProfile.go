// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package route53

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Route 53 Profile.
//
// ## Example Usage
//
// ### Empty Profile
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/route53"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := route53.NewProfilesProfile(ctx, "example", &route53.ProfilesProfileArgs{
//				Name: pulumi.String("example"),
//				Tags: pulumi.StringMap{
//					"Environment": pulumi.String("dev"),
//				},
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
// Using `pulumi import`, import Route 53 Profiles Profile using the `example`. For example:
//
// ```sh
// $ pulumi import aws:route53/profilesProfile:ProfilesProfile example rp-12345678
// ```
type ProfilesProfile struct {
	pulumi.CustomResourceState

	// ARN of the Profile.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Name of the Profile.
	Name    pulumi.StringOutput `pulumi:"name"`
	OwnerId pulumi.StringOutput `pulumi:"ownerId"`
	// Share status of the Profile.
	ShareStatus pulumi.StringOutput `pulumi:"shareStatus"`
	// Status of the Profile.
	Status pulumi.StringOutput `pulumi:"status"`
	// Status message of the Profile.
	StatusMessage pulumi.StringOutput `pulumi:"statusMessage"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapOutput           `pulumi:"tagsAll"`
	Timeouts ProfilesProfileTimeoutsPtrOutput `pulumi:"timeouts"`
}

// NewProfilesProfile registers a new resource with the given unique name, arguments, and options.
func NewProfilesProfile(ctx *pulumi.Context,
	name string, args *ProfilesProfileArgs, opts ...pulumi.ResourceOption) (*ProfilesProfile, error) {
	if args == nil {
		args = &ProfilesProfileArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ProfilesProfile
	err := ctx.RegisterResource("aws:route53/profilesProfile:ProfilesProfile", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetProfilesProfile gets an existing ProfilesProfile resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetProfilesProfile(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ProfilesProfileState, opts ...pulumi.ResourceOption) (*ProfilesProfile, error) {
	var resource ProfilesProfile
	err := ctx.ReadResource("aws:route53/profilesProfile:ProfilesProfile", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ProfilesProfile resources.
type profilesProfileState struct {
	// ARN of the Profile.
	Arn *string `pulumi:"arn"`
	// Name of the Profile.
	Name    *string `pulumi:"name"`
	OwnerId *string `pulumi:"ownerId"`
	// Share status of the Profile.
	ShareStatus *string `pulumi:"shareStatus"`
	// Status of the Profile.
	Status *string `pulumi:"status"`
	// Status message of the Profile.
	StatusMessage *string `pulumi:"statusMessage"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  map[string]string        `pulumi:"tagsAll"`
	Timeouts *ProfilesProfileTimeouts `pulumi:"timeouts"`
}

type ProfilesProfileState struct {
	// ARN of the Profile.
	Arn pulumi.StringPtrInput
	// Name of the Profile.
	Name    pulumi.StringPtrInput
	OwnerId pulumi.StringPtrInput
	// Share status of the Profile.
	ShareStatus pulumi.StringPtrInput
	// Status of the Profile.
	Status pulumi.StringPtrInput
	// Status message of the Profile.
	StatusMessage pulumi.StringPtrInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapInput
	Timeouts ProfilesProfileTimeoutsPtrInput
}

func (ProfilesProfileState) ElementType() reflect.Type {
	return reflect.TypeOf((*profilesProfileState)(nil)).Elem()
}

type profilesProfileArgs struct {
	// Name of the Profile.
	Name *string `pulumi:"name"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags     map[string]string        `pulumi:"tags"`
	Timeouts *ProfilesProfileTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a ProfilesProfile resource.
type ProfilesProfileArgs struct {
	// Name of the Profile.
	Name pulumi.StringPtrInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags     pulumi.StringMapInput
	Timeouts ProfilesProfileTimeoutsPtrInput
}

func (ProfilesProfileArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*profilesProfileArgs)(nil)).Elem()
}

type ProfilesProfileInput interface {
	pulumi.Input

	ToProfilesProfileOutput() ProfilesProfileOutput
	ToProfilesProfileOutputWithContext(ctx context.Context) ProfilesProfileOutput
}

func (*ProfilesProfile) ElementType() reflect.Type {
	return reflect.TypeOf((**ProfilesProfile)(nil)).Elem()
}

func (i *ProfilesProfile) ToProfilesProfileOutput() ProfilesProfileOutput {
	return i.ToProfilesProfileOutputWithContext(context.Background())
}

func (i *ProfilesProfile) ToProfilesProfileOutputWithContext(ctx context.Context) ProfilesProfileOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ProfilesProfileOutput)
}

// ProfilesProfileArrayInput is an input type that accepts ProfilesProfileArray and ProfilesProfileArrayOutput values.
// You can construct a concrete instance of `ProfilesProfileArrayInput` via:
//
//	ProfilesProfileArray{ ProfilesProfileArgs{...} }
type ProfilesProfileArrayInput interface {
	pulumi.Input

	ToProfilesProfileArrayOutput() ProfilesProfileArrayOutput
	ToProfilesProfileArrayOutputWithContext(context.Context) ProfilesProfileArrayOutput
}

type ProfilesProfileArray []ProfilesProfileInput

func (ProfilesProfileArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ProfilesProfile)(nil)).Elem()
}

func (i ProfilesProfileArray) ToProfilesProfileArrayOutput() ProfilesProfileArrayOutput {
	return i.ToProfilesProfileArrayOutputWithContext(context.Background())
}

func (i ProfilesProfileArray) ToProfilesProfileArrayOutputWithContext(ctx context.Context) ProfilesProfileArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ProfilesProfileArrayOutput)
}

// ProfilesProfileMapInput is an input type that accepts ProfilesProfileMap and ProfilesProfileMapOutput values.
// You can construct a concrete instance of `ProfilesProfileMapInput` via:
//
//	ProfilesProfileMap{ "key": ProfilesProfileArgs{...} }
type ProfilesProfileMapInput interface {
	pulumi.Input

	ToProfilesProfileMapOutput() ProfilesProfileMapOutput
	ToProfilesProfileMapOutputWithContext(context.Context) ProfilesProfileMapOutput
}

type ProfilesProfileMap map[string]ProfilesProfileInput

func (ProfilesProfileMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ProfilesProfile)(nil)).Elem()
}

func (i ProfilesProfileMap) ToProfilesProfileMapOutput() ProfilesProfileMapOutput {
	return i.ToProfilesProfileMapOutputWithContext(context.Background())
}

func (i ProfilesProfileMap) ToProfilesProfileMapOutputWithContext(ctx context.Context) ProfilesProfileMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ProfilesProfileMapOutput)
}

type ProfilesProfileOutput struct{ *pulumi.OutputState }

func (ProfilesProfileOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ProfilesProfile)(nil)).Elem()
}

func (o ProfilesProfileOutput) ToProfilesProfileOutput() ProfilesProfileOutput {
	return o
}

func (o ProfilesProfileOutput) ToProfilesProfileOutputWithContext(ctx context.Context) ProfilesProfileOutput {
	return o
}

// ARN of the Profile.
func (o ProfilesProfileOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *ProfilesProfile) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Name of the Profile.
func (o ProfilesProfileOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *ProfilesProfile) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

func (o ProfilesProfileOutput) OwnerId() pulumi.StringOutput {
	return o.ApplyT(func(v *ProfilesProfile) pulumi.StringOutput { return v.OwnerId }).(pulumi.StringOutput)
}

// Share status of the Profile.
func (o ProfilesProfileOutput) ShareStatus() pulumi.StringOutput {
	return o.ApplyT(func(v *ProfilesProfile) pulumi.StringOutput { return v.ShareStatus }).(pulumi.StringOutput)
}

// Status of the Profile.
func (o ProfilesProfileOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *ProfilesProfile) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// Status message of the Profile.
func (o ProfilesProfileOutput) StatusMessage() pulumi.StringOutput {
	return o.ApplyT(func(v *ProfilesProfile) pulumi.StringOutput { return v.StatusMessage }).(pulumi.StringOutput)
}

// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ProfilesProfileOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ProfilesProfile) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ProfilesProfileOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ProfilesProfile) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o ProfilesProfileOutput) Timeouts() ProfilesProfileTimeoutsPtrOutput {
	return o.ApplyT(func(v *ProfilesProfile) ProfilesProfileTimeoutsPtrOutput { return v.Timeouts }).(ProfilesProfileTimeoutsPtrOutput)
}

type ProfilesProfileArrayOutput struct{ *pulumi.OutputState }

func (ProfilesProfileArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ProfilesProfile)(nil)).Elem()
}

func (o ProfilesProfileArrayOutput) ToProfilesProfileArrayOutput() ProfilesProfileArrayOutput {
	return o
}

func (o ProfilesProfileArrayOutput) ToProfilesProfileArrayOutputWithContext(ctx context.Context) ProfilesProfileArrayOutput {
	return o
}

func (o ProfilesProfileArrayOutput) Index(i pulumi.IntInput) ProfilesProfileOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ProfilesProfile {
		return vs[0].([]*ProfilesProfile)[vs[1].(int)]
	}).(ProfilesProfileOutput)
}

type ProfilesProfileMapOutput struct{ *pulumi.OutputState }

func (ProfilesProfileMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ProfilesProfile)(nil)).Elem()
}

func (o ProfilesProfileMapOutput) ToProfilesProfileMapOutput() ProfilesProfileMapOutput {
	return o
}

func (o ProfilesProfileMapOutput) ToProfilesProfileMapOutputWithContext(ctx context.Context) ProfilesProfileMapOutput {
	return o
}

func (o ProfilesProfileMapOutput) MapIndex(k pulumi.StringInput) ProfilesProfileOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ProfilesProfile {
		return vs[0].(map[string]*ProfilesProfile)[vs[1].(string)]
	}).(ProfilesProfileOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ProfilesProfileInput)(nil)).Elem(), &ProfilesProfile{})
	pulumi.RegisterInputType(reflect.TypeOf((*ProfilesProfileArrayInput)(nil)).Elem(), ProfilesProfileArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ProfilesProfileMapInput)(nil)).Elem(), ProfilesProfileMap{})
	pulumi.RegisterOutputType(ProfilesProfileOutput{})
	pulumi.RegisterOutputType(ProfilesProfileArrayOutput{})
	pulumi.RegisterOutputType(ProfilesProfileMapOutput{})
}
