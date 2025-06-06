// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package notifications

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing AWS User Notifications Contacts Email Contact.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/notifications"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := notifications.NewContactsEmailContact(ctx, "example", &notifications.ContactsEmailContactArgs{
//				Name:         pulumi.String("example-contact"),
//				EmailAddress: pulumi.String("example@example.com"),
//				Tags: pulumi.StringMap{
//					"Environment": pulumi.String("Production"),
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
// Using `pulumi import`, import User Notifications Contacts Email Contact using the `arn`. For example:
//
// ```sh
// $ pulumi import aws:notifications/contactsEmailContact:ContactsEmailContact example arn:aws:notificationscontacts:us-west-2:123456789012:emailcontact:example-contact
// ```
type ContactsEmailContact struct {
	pulumi.CustomResourceState

	// ARN of the Email Contact.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Email address for the contact. Must be between 6 and 254 characters and match an email
	// pattern.
	EmailAddress pulumi.StringOutput `pulumi:"emailAddress"`
	// Name of the email contact. Must be between 1 and 64 characters and can contain alphanumeric
	// characters, underscores, tildes, periods, and hyphens.
	//
	// The following arguments are optional:
	Name pulumi.StringOutput `pulumi:"name"`
	// Map of tags to assign to the resource. If configured with a provider
	// `defaultTags` configuration block
	// present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider
	// `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewContactsEmailContact registers a new resource with the given unique name, arguments, and options.
func NewContactsEmailContact(ctx *pulumi.Context,
	name string, args *ContactsEmailContactArgs, opts ...pulumi.ResourceOption) (*ContactsEmailContact, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.EmailAddress == nil {
		return nil, errors.New("invalid value for required argument 'EmailAddress'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ContactsEmailContact
	err := ctx.RegisterResource("aws:notifications/contactsEmailContact:ContactsEmailContact", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetContactsEmailContact gets an existing ContactsEmailContact resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetContactsEmailContact(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ContactsEmailContactState, opts ...pulumi.ResourceOption) (*ContactsEmailContact, error) {
	var resource ContactsEmailContact
	err := ctx.ReadResource("aws:notifications/contactsEmailContact:ContactsEmailContact", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ContactsEmailContact resources.
type contactsEmailContactState struct {
	// ARN of the Email Contact.
	Arn *string `pulumi:"arn"`
	// Email address for the contact. Must be between 6 and 254 characters and match an email
	// pattern.
	EmailAddress *string `pulumi:"emailAddress"`
	// Name of the email contact. Must be between 1 and 64 characters and can contain alphanumeric
	// characters, underscores, tildes, periods, and hyphens.
	//
	// The following arguments are optional:
	Name *string `pulumi:"name"`
	// Map of tags to assign to the resource. If configured with a provider
	// `defaultTags` configuration block
	// present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider
	// `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type ContactsEmailContactState struct {
	// ARN of the Email Contact.
	Arn pulumi.StringPtrInput
	// Email address for the contact. Must be between 6 and 254 characters and match an email
	// pattern.
	EmailAddress pulumi.StringPtrInput
	// Name of the email contact. Must be between 1 and 64 characters and can contain alphanumeric
	// characters, underscores, tildes, periods, and hyphens.
	//
	// The following arguments are optional:
	Name pulumi.StringPtrInput
	// Map of tags to assign to the resource. If configured with a provider
	// `defaultTags` configuration block
	// present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider
	// `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (ContactsEmailContactState) ElementType() reflect.Type {
	return reflect.TypeOf((*contactsEmailContactState)(nil)).Elem()
}

type contactsEmailContactArgs struct {
	// Email address for the contact. Must be between 6 and 254 characters and match an email
	// pattern.
	EmailAddress string `pulumi:"emailAddress"`
	// Name of the email contact. Must be between 1 and 64 characters and can contain alphanumeric
	// characters, underscores, tildes, periods, and hyphens.
	//
	// The following arguments are optional:
	Name *string `pulumi:"name"`
	// Map of tags to assign to the resource. If configured with a provider
	// `defaultTags` configuration block
	// present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a ContactsEmailContact resource.
type ContactsEmailContactArgs struct {
	// Email address for the contact. Must be between 6 and 254 characters and match an email
	// pattern.
	EmailAddress pulumi.StringInput
	// Name of the email contact. Must be between 1 and 64 characters and can contain alphanumeric
	// characters, underscores, tildes, periods, and hyphens.
	//
	// The following arguments are optional:
	Name pulumi.StringPtrInput
	// Map of tags to assign to the resource. If configured with a provider
	// `defaultTags` configuration block
	// present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (ContactsEmailContactArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*contactsEmailContactArgs)(nil)).Elem()
}

type ContactsEmailContactInput interface {
	pulumi.Input

	ToContactsEmailContactOutput() ContactsEmailContactOutput
	ToContactsEmailContactOutputWithContext(ctx context.Context) ContactsEmailContactOutput
}

func (*ContactsEmailContact) ElementType() reflect.Type {
	return reflect.TypeOf((**ContactsEmailContact)(nil)).Elem()
}

func (i *ContactsEmailContact) ToContactsEmailContactOutput() ContactsEmailContactOutput {
	return i.ToContactsEmailContactOutputWithContext(context.Background())
}

func (i *ContactsEmailContact) ToContactsEmailContactOutputWithContext(ctx context.Context) ContactsEmailContactOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ContactsEmailContactOutput)
}

// ContactsEmailContactArrayInput is an input type that accepts ContactsEmailContactArray and ContactsEmailContactArrayOutput values.
// You can construct a concrete instance of `ContactsEmailContactArrayInput` via:
//
//	ContactsEmailContactArray{ ContactsEmailContactArgs{...} }
type ContactsEmailContactArrayInput interface {
	pulumi.Input

	ToContactsEmailContactArrayOutput() ContactsEmailContactArrayOutput
	ToContactsEmailContactArrayOutputWithContext(context.Context) ContactsEmailContactArrayOutput
}

type ContactsEmailContactArray []ContactsEmailContactInput

func (ContactsEmailContactArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ContactsEmailContact)(nil)).Elem()
}

func (i ContactsEmailContactArray) ToContactsEmailContactArrayOutput() ContactsEmailContactArrayOutput {
	return i.ToContactsEmailContactArrayOutputWithContext(context.Background())
}

func (i ContactsEmailContactArray) ToContactsEmailContactArrayOutputWithContext(ctx context.Context) ContactsEmailContactArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ContactsEmailContactArrayOutput)
}

// ContactsEmailContactMapInput is an input type that accepts ContactsEmailContactMap and ContactsEmailContactMapOutput values.
// You can construct a concrete instance of `ContactsEmailContactMapInput` via:
//
//	ContactsEmailContactMap{ "key": ContactsEmailContactArgs{...} }
type ContactsEmailContactMapInput interface {
	pulumi.Input

	ToContactsEmailContactMapOutput() ContactsEmailContactMapOutput
	ToContactsEmailContactMapOutputWithContext(context.Context) ContactsEmailContactMapOutput
}

type ContactsEmailContactMap map[string]ContactsEmailContactInput

func (ContactsEmailContactMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ContactsEmailContact)(nil)).Elem()
}

func (i ContactsEmailContactMap) ToContactsEmailContactMapOutput() ContactsEmailContactMapOutput {
	return i.ToContactsEmailContactMapOutputWithContext(context.Background())
}

func (i ContactsEmailContactMap) ToContactsEmailContactMapOutputWithContext(ctx context.Context) ContactsEmailContactMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ContactsEmailContactMapOutput)
}

type ContactsEmailContactOutput struct{ *pulumi.OutputState }

func (ContactsEmailContactOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ContactsEmailContact)(nil)).Elem()
}

func (o ContactsEmailContactOutput) ToContactsEmailContactOutput() ContactsEmailContactOutput {
	return o
}

func (o ContactsEmailContactOutput) ToContactsEmailContactOutputWithContext(ctx context.Context) ContactsEmailContactOutput {
	return o
}

// ARN of the Email Contact.
func (o ContactsEmailContactOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *ContactsEmailContact) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Email address for the contact. Must be between 6 and 254 characters and match an email
// pattern.
func (o ContactsEmailContactOutput) EmailAddress() pulumi.StringOutput {
	return o.ApplyT(func(v *ContactsEmailContact) pulumi.StringOutput { return v.EmailAddress }).(pulumi.StringOutput)
}

// Name of the email contact. Must be between 1 and 64 characters and can contain alphanumeric
// characters, underscores, tildes, periods, and hyphens.
//
// The following arguments are optional:
func (o ContactsEmailContactOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *ContactsEmailContact) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Map of tags to assign to the resource. If configured with a provider
// `defaultTags` configuration block
// present, tags with matching keys will overwrite those defined at the provider-level.
func (o ContactsEmailContactOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ContactsEmailContact) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider
// `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ContactsEmailContactOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ContactsEmailContact) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type ContactsEmailContactArrayOutput struct{ *pulumi.OutputState }

func (ContactsEmailContactArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ContactsEmailContact)(nil)).Elem()
}

func (o ContactsEmailContactArrayOutput) ToContactsEmailContactArrayOutput() ContactsEmailContactArrayOutput {
	return o
}

func (o ContactsEmailContactArrayOutput) ToContactsEmailContactArrayOutputWithContext(ctx context.Context) ContactsEmailContactArrayOutput {
	return o
}

func (o ContactsEmailContactArrayOutput) Index(i pulumi.IntInput) ContactsEmailContactOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ContactsEmailContact {
		return vs[0].([]*ContactsEmailContact)[vs[1].(int)]
	}).(ContactsEmailContactOutput)
}

type ContactsEmailContactMapOutput struct{ *pulumi.OutputState }

func (ContactsEmailContactMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ContactsEmailContact)(nil)).Elem()
}

func (o ContactsEmailContactMapOutput) ToContactsEmailContactMapOutput() ContactsEmailContactMapOutput {
	return o
}

func (o ContactsEmailContactMapOutput) ToContactsEmailContactMapOutputWithContext(ctx context.Context) ContactsEmailContactMapOutput {
	return o
}

func (o ContactsEmailContactMapOutput) MapIndex(k pulumi.StringInput) ContactsEmailContactOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ContactsEmailContact {
		return vs[0].(map[string]*ContactsEmailContact)[vs[1].(string)]
	}).(ContactsEmailContactOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ContactsEmailContactInput)(nil)).Elem(), &ContactsEmailContact{})
	pulumi.RegisterInputType(reflect.TypeOf((*ContactsEmailContactArrayInput)(nil)).Elem(), ContactsEmailContactArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ContactsEmailContactMapInput)(nil)).Elem(), ContactsEmailContactMap{})
	pulumi.RegisterOutputType(ContactsEmailContactOutput{})
	pulumi.RegisterOutputType(ContactsEmailContactArrayOutput{})
	pulumi.RegisterOutputType(ContactsEmailContactMapOutput{})
}
