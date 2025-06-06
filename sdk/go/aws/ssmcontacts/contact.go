// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ssmcontacts

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS SSM Contact.
//
// > **NOTE:** A contact implicitly depends on a replication set. If you configured your replication set in Pulumi, we recommend you add it to the `dependsOn` argument for the Contact Resource.
//
// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ssmcontacts"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ssmcontacts.NewContact(ctx, "example", &ssmcontacts.ContactArgs{
//				Alias: pulumi.String("alias"),
//				Type:  pulumi.String("PERSONAL"),
//			}, pulumi.DependsOn([]pulumi.Resource{
//				exampleAwsSsmincidentsReplicationSet,
//			}))
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### Usage With All Fields
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ssmcontacts"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ssmcontacts.NewContact(ctx, "example", &ssmcontacts.ContactArgs{
//				Alias:       pulumi.String("alias"),
//				DisplayName: pulumi.String("displayName"),
//				Type:        pulumi.String("ESCALATION"),
//				Tags: pulumi.StringMap{
//					"key": pulumi.String("value"),
//				},
//			}, pulumi.DependsOn([]pulumi.Resource{
//				exampleAwsSsmincidentsReplicationSet,
//			}))
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
// Using `pulumi import`, import SSM Contact using the `ARN`. For example:
//
// ```sh
// $ pulumi import aws:ssmcontacts/contact:Contact example {ARNValue}
// ```
type Contact struct {
	pulumi.CustomResourceState

	// A unique and identifiable alias for the contact or escalation plan. Must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), and hyphens (`-`).
	Alias pulumi.StringOutput `pulumi:"alias"`
	// The Amazon Resource Name (ARN) of the contact or escalation plan.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Full friendly name of the contact or escalation plan. If set, must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), hyphens (`-`), periods (`.`), and spaces.
	DisplayName pulumi.StringPtrOutput `pulumi:"displayName"`
	// Map of tags to assign to the resource.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The type of contact engaged. A single contact is type PERSONAL and an escalation
	// plan is type ESCALATION.
	//
	// The following arguments are optional:
	Type pulumi.StringOutput `pulumi:"type"`
}

// NewContact registers a new resource with the given unique name, arguments, and options.
func NewContact(ctx *pulumi.Context,
	name string, args *ContactArgs, opts ...pulumi.ResourceOption) (*Contact, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Alias == nil {
		return nil, errors.New("invalid value for required argument 'Alias'")
	}
	if args.Type == nil {
		return nil, errors.New("invalid value for required argument 'Type'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Contact
	err := ctx.RegisterResource("aws:ssmcontacts/contact:Contact", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetContact gets an existing Contact resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetContact(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ContactState, opts ...pulumi.ResourceOption) (*Contact, error) {
	var resource Contact
	err := ctx.ReadResource("aws:ssmcontacts/contact:Contact", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Contact resources.
type contactState struct {
	// A unique and identifiable alias for the contact or escalation plan. Must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), and hyphens (`-`).
	Alias *string `pulumi:"alias"`
	// The Amazon Resource Name (ARN) of the contact or escalation plan.
	Arn *string `pulumi:"arn"`
	// Full friendly name of the contact or escalation plan. If set, must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), hyphens (`-`), periods (`.`), and spaces.
	DisplayName *string `pulumi:"displayName"`
	// Map of tags to assign to the resource.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The type of contact engaged. A single contact is type PERSONAL and an escalation
	// plan is type ESCALATION.
	//
	// The following arguments are optional:
	Type *string `pulumi:"type"`
}

type ContactState struct {
	// A unique and identifiable alias for the contact or escalation plan. Must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), and hyphens (`-`).
	Alias pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) of the contact or escalation plan.
	Arn pulumi.StringPtrInput
	// Full friendly name of the contact or escalation plan. If set, must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), hyphens (`-`), periods (`.`), and spaces.
	DisplayName pulumi.StringPtrInput
	// Map of tags to assign to the resource.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The type of contact engaged. A single contact is type PERSONAL and an escalation
	// plan is type ESCALATION.
	//
	// The following arguments are optional:
	Type pulumi.StringPtrInput
}

func (ContactState) ElementType() reflect.Type {
	return reflect.TypeOf((*contactState)(nil)).Elem()
}

type contactArgs struct {
	// A unique and identifiable alias for the contact or escalation plan. Must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), and hyphens (`-`).
	Alias string `pulumi:"alias"`
	// Full friendly name of the contact or escalation plan. If set, must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), hyphens (`-`), periods (`.`), and spaces.
	DisplayName *string `pulumi:"displayName"`
	// Map of tags to assign to the resource.
	Tags map[string]string `pulumi:"tags"`
	// The type of contact engaged. A single contact is type PERSONAL and an escalation
	// plan is type ESCALATION.
	//
	// The following arguments are optional:
	Type string `pulumi:"type"`
}

// The set of arguments for constructing a Contact resource.
type ContactArgs struct {
	// A unique and identifiable alias for the contact or escalation plan. Must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), and hyphens (`-`).
	Alias pulumi.StringInput
	// Full friendly name of the contact or escalation plan. If set, must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), hyphens (`-`), periods (`.`), and spaces.
	DisplayName pulumi.StringPtrInput
	// Map of tags to assign to the resource.
	Tags pulumi.StringMapInput
	// The type of contact engaged. A single contact is type PERSONAL and an escalation
	// plan is type ESCALATION.
	//
	// The following arguments are optional:
	Type pulumi.StringInput
}

func (ContactArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*contactArgs)(nil)).Elem()
}

type ContactInput interface {
	pulumi.Input

	ToContactOutput() ContactOutput
	ToContactOutputWithContext(ctx context.Context) ContactOutput
}

func (*Contact) ElementType() reflect.Type {
	return reflect.TypeOf((**Contact)(nil)).Elem()
}

func (i *Contact) ToContactOutput() ContactOutput {
	return i.ToContactOutputWithContext(context.Background())
}

func (i *Contact) ToContactOutputWithContext(ctx context.Context) ContactOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ContactOutput)
}

// ContactArrayInput is an input type that accepts ContactArray and ContactArrayOutput values.
// You can construct a concrete instance of `ContactArrayInput` via:
//
//	ContactArray{ ContactArgs{...} }
type ContactArrayInput interface {
	pulumi.Input

	ToContactArrayOutput() ContactArrayOutput
	ToContactArrayOutputWithContext(context.Context) ContactArrayOutput
}

type ContactArray []ContactInput

func (ContactArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Contact)(nil)).Elem()
}

func (i ContactArray) ToContactArrayOutput() ContactArrayOutput {
	return i.ToContactArrayOutputWithContext(context.Background())
}

func (i ContactArray) ToContactArrayOutputWithContext(ctx context.Context) ContactArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ContactArrayOutput)
}

// ContactMapInput is an input type that accepts ContactMap and ContactMapOutput values.
// You can construct a concrete instance of `ContactMapInput` via:
//
//	ContactMap{ "key": ContactArgs{...} }
type ContactMapInput interface {
	pulumi.Input

	ToContactMapOutput() ContactMapOutput
	ToContactMapOutputWithContext(context.Context) ContactMapOutput
}

type ContactMap map[string]ContactInput

func (ContactMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Contact)(nil)).Elem()
}

func (i ContactMap) ToContactMapOutput() ContactMapOutput {
	return i.ToContactMapOutputWithContext(context.Background())
}

func (i ContactMap) ToContactMapOutputWithContext(ctx context.Context) ContactMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ContactMapOutput)
}

type ContactOutput struct{ *pulumi.OutputState }

func (ContactOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Contact)(nil)).Elem()
}

func (o ContactOutput) ToContactOutput() ContactOutput {
	return o
}

func (o ContactOutput) ToContactOutputWithContext(ctx context.Context) ContactOutput {
	return o
}

// A unique and identifiable alias for the contact or escalation plan. Must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), and hyphens (`-`).
func (o ContactOutput) Alias() pulumi.StringOutput {
	return o.ApplyT(func(v *Contact) pulumi.StringOutput { return v.Alias }).(pulumi.StringOutput)
}

// The Amazon Resource Name (ARN) of the contact or escalation plan.
func (o ContactOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Contact) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Full friendly name of the contact or escalation plan. If set, must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), hyphens (`-`), periods (`.`), and spaces.
func (o ContactOutput) DisplayName() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Contact) pulumi.StringPtrOutput { return v.DisplayName }).(pulumi.StringPtrOutput)
}

// Map of tags to assign to the resource.
func (o ContactOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Contact) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ContactOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Contact) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The type of contact engaged. A single contact is type PERSONAL and an escalation
// plan is type ESCALATION.
//
// The following arguments are optional:
func (o ContactOutput) Type() pulumi.StringOutput {
	return o.ApplyT(func(v *Contact) pulumi.StringOutput { return v.Type }).(pulumi.StringOutput)
}

type ContactArrayOutput struct{ *pulumi.OutputState }

func (ContactArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Contact)(nil)).Elem()
}

func (o ContactArrayOutput) ToContactArrayOutput() ContactArrayOutput {
	return o
}

func (o ContactArrayOutput) ToContactArrayOutputWithContext(ctx context.Context) ContactArrayOutput {
	return o
}

func (o ContactArrayOutput) Index(i pulumi.IntInput) ContactOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Contact {
		return vs[0].([]*Contact)[vs[1].(int)]
	}).(ContactOutput)
}

type ContactMapOutput struct{ *pulumi.OutputState }

func (ContactMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Contact)(nil)).Elem()
}

func (o ContactMapOutput) ToContactMapOutput() ContactMapOutput {
	return o
}

func (o ContactMapOutput) ToContactMapOutputWithContext(ctx context.Context) ContactMapOutput {
	return o
}

func (o ContactMapOutput) MapIndex(k pulumi.StringInput) ContactOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Contact {
		return vs[0].(map[string]*Contact)[vs[1].(string)]
	}).(ContactOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ContactInput)(nil)).Elem(), &Contact{})
	pulumi.RegisterInputType(reflect.TypeOf((*ContactArrayInput)(nil)).Elem(), ContactArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ContactMapInput)(nil)).Elem(), ContactMap{})
	pulumi.RegisterOutputType(ContactOutput{})
	pulumi.RegisterOutputType(ContactArrayOutput{})
	pulumi.RegisterOutputType(ContactMapOutput{})
}
