// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package identitystore

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// This resource manages a User resource within an Identity Store.
//
// > **Note:** If you use an external identity provider or Active Directory as your identity source,
// use this resource with caution. IAM Identity Center does not support outbound synchronization,
// so your identity source does not automatically update with the changes that you make to
// users using this resource.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/identitystore"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := identitystore.NewUser(ctx, "example", &identitystore.UserArgs{
//				IdentityStoreId: pulumi.Any(exampleAwsSsoadminInstances.IdentityStoreIds[0]),
//				DisplayName:     pulumi.String("John Doe"),
//				UserName:        pulumi.String("johndoe"),
//				Name: &identitystore.UserNameArgs{
//					GivenName:  pulumi.String("John"),
//					FamilyName: pulumi.String("Doe"),
//				},
//				Emails: &identitystore.UserEmailsArgs{
//					Value: pulumi.String("john@example.com"),
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
// Using `pulumi import`, import an Identity Store User using the combination `identity_store_id/user_id`. For example:
//
// ```sh
// $ pulumi import aws:identitystore/user:User example d-9c6705e95c/065212b4-9061-703b-5876-13a517ae2a7c
// ```
type User struct {
	pulumi.CustomResourceState

	// Details about the user's address. At most 1 address is allowed. Detailed below.
	Addresses UserAddressesPtrOutput `pulumi:"addresses"`
	// The name that is typically displayed when the user is referenced.
	DisplayName pulumi.StringOutput `pulumi:"displayName"`
	// Details about the user's email. At most 1 email is allowed. Detailed below.
	Emails UserEmailsPtrOutput `pulumi:"emails"`
	// A list of identifiers issued to this resource by an external identity provider.
	ExternalIds UserExternalIdArrayOutput `pulumi:"externalIds"`
	// The globally unique identifier for the identity store that this user is in.
	IdentityStoreId pulumi.StringOutput `pulumi:"identityStoreId"`
	// The user's geographical region or location.
	Locale pulumi.StringPtrOutput `pulumi:"locale"`
	// Details about the user's full name. Detailed below.
	Name UserNameOutput `pulumi:"name"`
	// An alternate name for the user.
	Nickname pulumi.StringPtrOutput `pulumi:"nickname"`
	// Details about the user's phone number. At most 1 phone number is allowed. Detailed below.
	PhoneNumbers UserPhoneNumbersPtrOutput `pulumi:"phoneNumbers"`
	// The preferred language of the user.
	PreferredLanguage pulumi.StringPtrOutput `pulumi:"preferredLanguage"`
	// An URL that may be associated with the user.
	ProfileUrl pulumi.StringPtrOutput `pulumi:"profileUrl"`
	// The user's time zone.
	Timezone pulumi.StringPtrOutput `pulumi:"timezone"`
	// The user's title.
	Title pulumi.StringPtrOutput `pulumi:"title"`
	// The identifier for this user in the identity store.
	UserId pulumi.StringOutput `pulumi:"userId"`
	// A unique string used to identify the user. This value can consist of letters, accented characters, symbols, numbers, and punctuation. This value is specified at the time the user is created and stored as an attribute of the user object in the identity store. The limit is 128 characters.
	//
	// The following arguments are optional:
	UserName pulumi.StringOutput `pulumi:"userName"`
	// The user type.
	//
	// > Unless specified otherwise, all fields can contain up to 1024 characters of free-form text.
	UserType pulumi.StringPtrOutput `pulumi:"userType"`
}

// NewUser registers a new resource with the given unique name, arguments, and options.
func NewUser(ctx *pulumi.Context,
	name string, args *UserArgs, opts ...pulumi.ResourceOption) (*User, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.DisplayName == nil {
		return nil, errors.New("invalid value for required argument 'DisplayName'")
	}
	if args.IdentityStoreId == nil {
		return nil, errors.New("invalid value for required argument 'IdentityStoreId'")
	}
	if args.UserName == nil {
		return nil, errors.New("invalid value for required argument 'UserName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource User
	err := ctx.RegisterResource("aws:identitystore/user:User", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetUser gets an existing User resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetUser(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *UserState, opts ...pulumi.ResourceOption) (*User, error) {
	var resource User
	err := ctx.ReadResource("aws:identitystore/user:User", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering User resources.
type userState struct {
	// Details about the user's address. At most 1 address is allowed. Detailed below.
	Addresses *UserAddresses `pulumi:"addresses"`
	// The name that is typically displayed when the user is referenced.
	DisplayName *string `pulumi:"displayName"`
	// Details about the user's email. At most 1 email is allowed. Detailed below.
	Emails *UserEmails `pulumi:"emails"`
	// A list of identifiers issued to this resource by an external identity provider.
	ExternalIds []UserExternalId `pulumi:"externalIds"`
	// The globally unique identifier for the identity store that this user is in.
	IdentityStoreId *string `pulumi:"identityStoreId"`
	// The user's geographical region or location.
	Locale *string `pulumi:"locale"`
	// Details about the user's full name. Detailed below.
	Name *UserName `pulumi:"name"`
	// An alternate name for the user.
	Nickname *string `pulumi:"nickname"`
	// Details about the user's phone number. At most 1 phone number is allowed. Detailed below.
	PhoneNumbers *UserPhoneNumbers `pulumi:"phoneNumbers"`
	// The preferred language of the user.
	PreferredLanguage *string `pulumi:"preferredLanguage"`
	// An URL that may be associated with the user.
	ProfileUrl *string `pulumi:"profileUrl"`
	// The user's time zone.
	Timezone *string `pulumi:"timezone"`
	// The user's title.
	Title *string `pulumi:"title"`
	// The identifier for this user in the identity store.
	UserId *string `pulumi:"userId"`
	// A unique string used to identify the user. This value can consist of letters, accented characters, symbols, numbers, and punctuation. This value is specified at the time the user is created and stored as an attribute of the user object in the identity store. The limit is 128 characters.
	//
	// The following arguments are optional:
	UserName *string `pulumi:"userName"`
	// The user type.
	//
	// > Unless specified otherwise, all fields can contain up to 1024 characters of free-form text.
	UserType *string `pulumi:"userType"`
}

type UserState struct {
	// Details about the user's address. At most 1 address is allowed. Detailed below.
	Addresses UserAddressesPtrInput
	// The name that is typically displayed when the user is referenced.
	DisplayName pulumi.StringPtrInput
	// Details about the user's email. At most 1 email is allowed. Detailed below.
	Emails UserEmailsPtrInput
	// A list of identifiers issued to this resource by an external identity provider.
	ExternalIds UserExternalIdArrayInput
	// The globally unique identifier for the identity store that this user is in.
	IdentityStoreId pulumi.StringPtrInput
	// The user's geographical region or location.
	Locale pulumi.StringPtrInput
	// Details about the user's full name. Detailed below.
	Name UserNamePtrInput
	// An alternate name for the user.
	Nickname pulumi.StringPtrInput
	// Details about the user's phone number. At most 1 phone number is allowed. Detailed below.
	PhoneNumbers UserPhoneNumbersPtrInput
	// The preferred language of the user.
	PreferredLanguage pulumi.StringPtrInput
	// An URL that may be associated with the user.
	ProfileUrl pulumi.StringPtrInput
	// The user's time zone.
	Timezone pulumi.StringPtrInput
	// The user's title.
	Title pulumi.StringPtrInput
	// The identifier for this user in the identity store.
	UserId pulumi.StringPtrInput
	// A unique string used to identify the user. This value can consist of letters, accented characters, symbols, numbers, and punctuation. This value is specified at the time the user is created and stored as an attribute of the user object in the identity store. The limit is 128 characters.
	//
	// The following arguments are optional:
	UserName pulumi.StringPtrInput
	// The user type.
	//
	// > Unless specified otherwise, all fields can contain up to 1024 characters of free-form text.
	UserType pulumi.StringPtrInput
}

func (UserState) ElementType() reflect.Type {
	return reflect.TypeOf((*userState)(nil)).Elem()
}

type userArgs struct {
	// Details about the user's address. At most 1 address is allowed. Detailed below.
	Addresses *UserAddresses `pulumi:"addresses"`
	// The name that is typically displayed when the user is referenced.
	DisplayName string `pulumi:"displayName"`
	// Details about the user's email. At most 1 email is allowed. Detailed below.
	Emails *UserEmails `pulumi:"emails"`
	// The globally unique identifier for the identity store that this user is in.
	IdentityStoreId string `pulumi:"identityStoreId"`
	// The user's geographical region or location.
	Locale *string `pulumi:"locale"`
	// Details about the user's full name. Detailed below.
	Name *UserName `pulumi:"name"`
	// An alternate name for the user.
	Nickname *string `pulumi:"nickname"`
	// Details about the user's phone number. At most 1 phone number is allowed. Detailed below.
	PhoneNumbers *UserPhoneNumbers `pulumi:"phoneNumbers"`
	// The preferred language of the user.
	PreferredLanguage *string `pulumi:"preferredLanguage"`
	// An URL that may be associated with the user.
	ProfileUrl *string `pulumi:"profileUrl"`
	// The user's time zone.
	Timezone *string `pulumi:"timezone"`
	// The user's title.
	Title *string `pulumi:"title"`
	// A unique string used to identify the user. This value can consist of letters, accented characters, symbols, numbers, and punctuation. This value is specified at the time the user is created and stored as an attribute of the user object in the identity store. The limit is 128 characters.
	//
	// The following arguments are optional:
	UserName string `pulumi:"userName"`
	// The user type.
	//
	// > Unless specified otherwise, all fields can contain up to 1024 characters of free-form text.
	UserType *string `pulumi:"userType"`
}

// The set of arguments for constructing a User resource.
type UserArgs struct {
	// Details about the user's address. At most 1 address is allowed. Detailed below.
	Addresses UserAddressesPtrInput
	// The name that is typically displayed when the user is referenced.
	DisplayName pulumi.StringInput
	// Details about the user's email. At most 1 email is allowed. Detailed below.
	Emails UserEmailsPtrInput
	// The globally unique identifier for the identity store that this user is in.
	IdentityStoreId pulumi.StringInput
	// The user's geographical region or location.
	Locale pulumi.StringPtrInput
	// Details about the user's full name. Detailed below.
	Name UserNamePtrInput
	// An alternate name for the user.
	Nickname pulumi.StringPtrInput
	// Details about the user's phone number. At most 1 phone number is allowed. Detailed below.
	PhoneNumbers UserPhoneNumbersPtrInput
	// The preferred language of the user.
	PreferredLanguage pulumi.StringPtrInput
	// An URL that may be associated with the user.
	ProfileUrl pulumi.StringPtrInput
	// The user's time zone.
	Timezone pulumi.StringPtrInput
	// The user's title.
	Title pulumi.StringPtrInput
	// A unique string used to identify the user. This value can consist of letters, accented characters, symbols, numbers, and punctuation. This value is specified at the time the user is created and stored as an attribute of the user object in the identity store. The limit is 128 characters.
	//
	// The following arguments are optional:
	UserName pulumi.StringInput
	// The user type.
	//
	// > Unless specified otherwise, all fields can contain up to 1024 characters of free-form text.
	UserType pulumi.StringPtrInput
}

func (UserArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*userArgs)(nil)).Elem()
}

type UserInput interface {
	pulumi.Input

	ToUserOutput() UserOutput
	ToUserOutputWithContext(ctx context.Context) UserOutput
}

func (*User) ElementType() reflect.Type {
	return reflect.TypeOf((**User)(nil)).Elem()
}

func (i *User) ToUserOutput() UserOutput {
	return i.ToUserOutputWithContext(context.Background())
}

func (i *User) ToUserOutputWithContext(ctx context.Context) UserOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UserOutput)
}

// UserArrayInput is an input type that accepts UserArray and UserArrayOutput values.
// You can construct a concrete instance of `UserArrayInput` via:
//
//	UserArray{ UserArgs{...} }
type UserArrayInput interface {
	pulumi.Input

	ToUserArrayOutput() UserArrayOutput
	ToUserArrayOutputWithContext(context.Context) UserArrayOutput
}

type UserArray []UserInput

func (UserArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*User)(nil)).Elem()
}

func (i UserArray) ToUserArrayOutput() UserArrayOutput {
	return i.ToUserArrayOutputWithContext(context.Background())
}

func (i UserArray) ToUserArrayOutputWithContext(ctx context.Context) UserArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UserArrayOutput)
}

// UserMapInput is an input type that accepts UserMap and UserMapOutput values.
// You can construct a concrete instance of `UserMapInput` via:
//
//	UserMap{ "key": UserArgs{...} }
type UserMapInput interface {
	pulumi.Input

	ToUserMapOutput() UserMapOutput
	ToUserMapOutputWithContext(context.Context) UserMapOutput
}

type UserMap map[string]UserInput

func (UserMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*User)(nil)).Elem()
}

func (i UserMap) ToUserMapOutput() UserMapOutput {
	return i.ToUserMapOutputWithContext(context.Background())
}

func (i UserMap) ToUserMapOutputWithContext(ctx context.Context) UserMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UserMapOutput)
}

type UserOutput struct{ *pulumi.OutputState }

func (UserOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**User)(nil)).Elem()
}

func (o UserOutput) ToUserOutput() UserOutput {
	return o
}

func (o UserOutput) ToUserOutputWithContext(ctx context.Context) UserOutput {
	return o
}

// Details about the user's address. At most 1 address is allowed. Detailed below.
func (o UserOutput) Addresses() UserAddressesPtrOutput {
	return o.ApplyT(func(v *User) UserAddressesPtrOutput { return v.Addresses }).(UserAddressesPtrOutput)
}

// The name that is typically displayed when the user is referenced.
func (o UserOutput) DisplayName() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.DisplayName }).(pulumi.StringOutput)
}

// Details about the user's email. At most 1 email is allowed. Detailed below.
func (o UserOutput) Emails() UserEmailsPtrOutput {
	return o.ApplyT(func(v *User) UserEmailsPtrOutput { return v.Emails }).(UserEmailsPtrOutput)
}

// A list of identifiers issued to this resource by an external identity provider.
func (o UserOutput) ExternalIds() UserExternalIdArrayOutput {
	return o.ApplyT(func(v *User) UserExternalIdArrayOutput { return v.ExternalIds }).(UserExternalIdArrayOutput)
}

// The globally unique identifier for the identity store that this user is in.
func (o UserOutput) IdentityStoreId() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.IdentityStoreId }).(pulumi.StringOutput)
}

// The user's geographical region or location.
func (o UserOutput) Locale() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.Locale }).(pulumi.StringPtrOutput)
}

// Details about the user's full name. Detailed below.
func (o UserOutput) Name() UserNameOutput {
	return o.ApplyT(func(v *User) UserNameOutput { return v.Name }).(UserNameOutput)
}

// An alternate name for the user.
func (o UserOutput) Nickname() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.Nickname }).(pulumi.StringPtrOutput)
}

// Details about the user's phone number. At most 1 phone number is allowed. Detailed below.
func (o UserOutput) PhoneNumbers() UserPhoneNumbersPtrOutput {
	return o.ApplyT(func(v *User) UserPhoneNumbersPtrOutput { return v.PhoneNumbers }).(UserPhoneNumbersPtrOutput)
}

// The preferred language of the user.
func (o UserOutput) PreferredLanguage() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.PreferredLanguage }).(pulumi.StringPtrOutput)
}

// An URL that may be associated with the user.
func (o UserOutput) ProfileUrl() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.ProfileUrl }).(pulumi.StringPtrOutput)
}

// The user's time zone.
func (o UserOutput) Timezone() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.Timezone }).(pulumi.StringPtrOutput)
}

// The user's title.
func (o UserOutput) Title() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.Title }).(pulumi.StringPtrOutput)
}

// The identifier for this user in the identity store.
func (o UserOutput) UserId() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.UserId }).(pulumi.StringOutput)
}

// A unique string used to identify the user. This value can consist of letters, accented characters, symbols, numbers, and punctuation. This value is specified at the time the user is created and stored as an attribute of the user object in the identity store. The limit is 128 characters.
//
// The following arguments are optional:
func (o UserOutput) UserName() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.UserName }).(pulumi.StringOutput)
}

// The user type.
//
// > Unless specified otherwise, all fields can contain up to 1024 characters of free-form text.
func (o UserOutput) UserType() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.UserType }).(pulumi.StringPtrOutput)
}

type UserArrayOutput struct{ *pulumi.OutputState }

func (UserArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*User)(nil)).Elem()
}

func (o UserArrayOutput) ToUserArrayOutput() UserArrayOutput {
	return o
}

func (o UserArrayOutput) ToUserArrayOutputWithContext(ctx context.Context) UserArrayOutput {
	return o
}

func (o UserArrayOutput) Index(i pulumi.IntInput) UserOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *User {
		return vs[0].([]*User)[vs[1].(int)]
	}).(UserOutput)
}

type UserMapOutput struct{ *pulumi.OutputState }

func (UserMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*User)(nil)).Elem()
}

func (o UserMapOutput) ToUserMapOutput() UserMapOutput {
	return o
}

func (o UserMapOutput) ToUserMapOutputWithContext(ctx context.Context) UserMapOutput {
	return o
}

func (o UserMapOutput) MapIndex(k pulumi.StringInput) UserOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *User {
		return vs[0].(map[string]*User)[vs[1].(string)]
	}).(UserOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*UserInput)(nil)).Elem(), &User{})
	pulumi.RegisterInputType(reflect.TypeOf((*UserArrayInput)(nil)).Elem(), UserArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*UserMapInput)(nil)).Elem(), UserMap{})
	pulumi.RegisterOutputType(UserOutput{})
	pulumi.RegisterOutputType(UserArrayOutput{})
	pulumi.RegisterOutputType(UserMapOutput{})
}
