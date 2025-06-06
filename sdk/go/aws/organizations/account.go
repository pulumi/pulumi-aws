// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package organizations

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a resource to create a member account in the current organization.
//
// > **Note:** Account management must be done from the organization's root account.
//
// > **Note:** By default, deleting this resource will only remove an AWS account from an organization. You must set the `closeOnDeletion` flag to true to close the account. It is worth noting that quotas are enforced when using the `closeOnDeletion` argument, which can produce a [CLOSE_ACCOUNT_QUOTA_EXCEEDED](https://docs.aws.amazon.com/organizations/latest/APIReference/API_CloseAccount.html) error, and require you to close the account manually.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/organizations"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := organizations.NewAccount(ctx, "account", &organizations.AccountArgs{
//				Name:  pulumi.String("my_new_account"),
//				Email: pulumi.String("john@doe.org"),
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
// Using `pulumi import`, import the AWS member account using the `account_id`. For example:
//
// ```sh
// $ pulumi import aws:organizations/account:Account my_account 111111111111
// ```
// To import accounts that have set iam_user_access_to_billing, use the following:
//
// ```sh
// $ pulumi import aws:organizations/account:Account my_account 111111111111_ALLOW
// ```
// Certain resource arguments, like `role_name`, do not have an Organizations API method for reading the information after account creation. If the argument is set in the Pulumi program on an imported resource, Pulumi will always show a difference. To workaround this behavior, either omit the argument from the Pulumi program or use `ignore_changes` to hide the difference. For example:
type Account struct {
	pulumi.CustomResourceState

	// The ARN for this account.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// If true, a deletion event will close the account. Otherwise, it will only remove from the organization. This is not supported for GovCloud accounts.
	CloseOnDeletion pulumi.BoolPtrOutput `pulumi:"closeOnDeletion"`
	// Whether to also create a GovCloud account. The GovCloud account is tied to the main (commercial) account this resource creates. If `true`, the GovCloud account ID is available in the `govcloudId` attribute. The only way to manage the GovCloud account with the provider is to subsequently import the account using this resource.
	CreateGovcloud pulumi.BoolPtrOutput `pulumi:"createGovcloud"`
	// Email address of the owner to assign to the new member account. This email address must not already be associated with another AWS account.
	Email pulumi.StringOutput `pulumi:"email"`
	// ID for a GovCloud account created with the account.
	GovcloudId pulumi.StringOutput `pulumi:"govcloudId"`
	// If set to `ALLOW`, the new account enables IAM users and roles to access account billing information if they have the required permissions. If set to `DENY`, then only the root user (and no roles) of the new account can access account billing information. If this is unset, the AWS API will default this to `ALLOW`. If the resource is created and this option is changed, it will try to recreate the account.
	IamUserAccessToBilling pulumi.StringPtrOutput `pulumi:"iamUserAccessToBilling"`
	JoinedMethod           pulumi.StringOutput    `pulumi:"joinedMethod"`
	JoinedTimestamp        pulumi.StringOutput    `pulumi:"joinedTimestamp"`
	// Friendly name for the member account.
	//
	// The following arguments are optional:
	Name pulumi.StringOutput `pulumi:"name"`
	// Parent Organizational Unit ID or Root ID for the account. Defaults to the Organization default Root ID. A configuration must be present for this argument to perform drift detection.
	ParentId pulumi.StringOutput `pulumi:"parentId"`
	// The name of an IAM role that Organizations automatically preconfigures in the new member account. This role trusts the root account, allowing users in the root account to assume the role, as permitted by the root account administrator. The role has administrator permissions in the new member account. The Organizations API provides no method for reading this information after account creation, so the provider cannot perform drift detection on its value and will always show a difference for a configured value after import unless `ignoreChanges` is used.
	RoleName pulumi.StringPtrOutput `pulumi:"roleName"`
	// The status of the account in the organization.
	Status pulumi.StringOutput `pulumi:"status"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewAccount registers a new resource with the given unique name, arguments, and options.
func NewAccount(ctx *pulumi.Context,
	name string, args *AccountArgs, opts ...pulumi.ResourceOption) (*Account, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Email == nil {
		return nil, errors.New("invalid value for required argument 'Email'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Account
	err := ctx.RegisterResource("aws:organizations/account:Account", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAccount gets an existing Account resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAccount(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AccountState, opts ...pulumi.ResourceOption) (*Account, error) {
	var resource Account
	err := ctx.ReadResource("aws:organizations/account:Account", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Account resources.
type accountState struct {
	// The ARN for this account.
	Arn *string `pulumi:"arn"`
	// If true, a deletion event will close the account. Otherwise, it will only remove from the organization. This is not supported for GovCloud accounts.
	CloseOnDeletion *bool `pulumi:"closeOnDeletion"`
	// Whether to also create a GovCloud account. The GovCloud account is tied to the main (commercial) account this resource creates. If `true`, the GovCloud account ID is available in the `govcloudId` attribute. The only way to manage the GovCloud account with the provider is to subsequently import the account using this resource.
	CreateGovcloud *bool `pulumi:"createGovcloud"`
	// Email address of the owner to assign to the new member account. This email address must not already be associated with another AWS account.
	Email *string `pulumi:"email"`
	// ID for a GovCloud account created with the account.
	GovcloudId *string `pulumi:"govcloudId"`
	// If set to `ALLOW`, the new account enables IAM users and roles to access account billing information if they have the required permissions. If set to `DENY`, then only the root user (and no roles) of the new account can access account billing information. If this is unset, the AWS API will default this to `ALLOW`. If the resource is created and this option is changed, it will try to recreate the account.
	IamUserAccessToBilling *string `pulumi:"iamUserAccessToBilling"`
	JoinedMethod           *string `pulumi:"joinedMethod"`
	JoinedTimestamp        *string `pulumi:"joinedTimestamp"`
	// Friendly name for the member account.
	//
	// The following arguments are optional:
	Name *string `pulumi:"name"`
	// Parent Organizational Unit ID or Root ID for the account. Defaults to the Organization default Root ID. A configuration must be present for this argument to perform drift detection.
	ParentId *string `pulumi:"parentId"`
	// The name of an IAM role that Organizations automatically preconfigures in the new member account. This role trusts the root account, allowing users in the root account to assume the role, as permitted by the root account administrator. The role has administrator permissions in the new member account. The Organizations API provides no method for reading this information after account creation, so the provider cannot perform drift detection on its value and will always show a difference for a configured value after import unless `ignoreChanges` is used.
	RoleName *string `pulumi:"roleName"`
	// The status of the account in the organization.
	Status *string `pulumi:"status"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type AccountState struct {
	// The ARN for this account.
	Arn pulumi.StringPtrInput
	// If true, a deletion event will close the account. Otherwise, it will only remove from the organization. This is not supported for GovCloud accounts.
	CloseOnDeletion pulumi.BoolPtrInput
	// Whether to also create a GovCloud account. The GovCloud account is tied to the main (commercial) account this resource creates. If `true`, the GovCloud account ID is available in the `govcloudId` attribute. The only way to manage the GovCloud account with the provider is to subsequently import the account using this resource.
	CreateGovcloud pulumi.BoolPtrInput
	// Email address of the owner to assign to the new member account. This email address must not already be associated with another AWS account.
	Email pulumi.StringPtrInput
	// ID for a GovCloud account created with the account.
	GovcloudId pulumi.StringPtrInput
	// If set to `ALLOW`, the new account enables IAM users and roles to access account billing information if they have the required permissions. If set to `DENY`, then only the root user (and no roles) of the new account can access account billing information. If this is unset, the AWS API will default this to `ALLOW`. If the resource is created and this option is changed, it will try to recreate the account.
	IamUserAccessToBilling pulumi.StringPtrInput
	JoinedMethod           pulumi.StringPtrInput
	JoinedTimestamp        pulumi.StringPtrInput
	// Friendly name for the member account.
	//
	// The following arguments are optional:
	Name pulumi.StringPtrInput
	// Parent Organizational Unit ID or Root ID for the account. Defaults to the Organization default Root ID. A configuration must be present for this argument to perform drift detection.
	ParentId pulumi.StringPtrInput
	// The name of an IAM role that Organizations automatically preconfigures in the new member account. This role trusts the root account, allowing users in the root account to assume the role, as permitted by the root account administrator. The role has administrator permissions in the new member account. The Organizations API provides no method for reading this information after account creation, so the provider cannot perform drift detection on its value and will always show a difference for a configured value after import unless `ignoreChanges` is used.
	RoleName pulumi.StringPtrInput
	// The status of the account in the organization.
	Status pulumi.StringPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (AccountState) ElementType() reflect.Type {
	return reflect.TypeOf((*accountState)(nil)).Elem()
}

type accountArgs struct {
	// If true, a deletion event will close the account. Otherwise, it will only remove from the organization. This is not supported for GovCloud accounts.
	CloseOnDeletion *bool `pulumi:"closeOnDeletion"`
	// Whether to also create a GovCloud account. The GovCloud account is tied to the main (commercial) account this resource creates. If `true`, the GovCloud account ID is available in the `govcloudId` attribute. The only way to manage the GovCloud account with the provider is to subsequently import the account using this resource.
	CreateGovcloud *bool `pulumi:"createGovcloud"`
	// Email address of the owner to assign to the new member account. This email address must not already be associated with another AWS account.
	Email string `pulumi:"email"`
	// If set to `ALLOW`, the new account enables IAM users and roles to access account billing information if they have the required permissions. If set to `DENY`, then only the root user (and no roles) of the new account can access account billing information. If this is unset, the AWS API will default this to `ALLOW`. If the resource is created and this option is changed, it will try to recreate the account.
	IamUserAccessToBilling *string `pulumi:"iamUserAccessToBilling"`
	// Friendly name for the member account.
	//
	// The following arguments are optional:
	Name *string `pulumi:"name"`
	// Parent Organizational Unit ID or Root ID for the account. Defaults to the Organization default Root ID. A configuration must be present for this argument to perform drift detection.
	ParentId *string `pulumi:"parentId"`
	// The name of an IAM role that Organizations automatically preconfigures in the new member account. This role trusts the root account, allowing users in the root account to assume the role, as permitted by the root account administrator. The role has administrator permissions in the new member account. The Organizations API provides no method for reading this information after account creation, so the provider cannot perform drift detection on its value and will always show a difference for a configured value after import unless `ignoreChanges` is used.
	RoleName *string `pulumi:"roleName"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a Account resource.
type AccountArgs struct {
	// If true, a deletion event will close the account. Otherwise, it will only remove from the organization. This is not supported for GovCloud accounts.
	CloseOnDeletion pulumi.BoolPtrInput
	// Whether to also create a GovCloud account. The GovCloud account is tied to the main (commercial) account this resource creates. If `true`, the GovCloud account ID is available in the `govcloudId` attribute. The only way to manage the GovCloud account with the provider is to subsequently import the account using this resource.
	CreateGovcloud pulumi.BoolPtrInput
	// Email address of the owner to assign to the new member account. This email address must not already be associated with another AWS account.
	Email pulumi.StringInput
	// If set to `ALLOW`, the new account enables IAM users and roles to access account billing information if they have the required permissions. If set to `DENY`, then only the root user (and no roles) of the new account can access account billing information. If this is unset, the AWS API will default this to `ALLOW`. If the resource is created and this option is changed, it will try to recreate the account.
	IamUserAccessToBilling pulumi.StringPtrInput
	// Friendly name for the member account.
	//
	// The following arguments are optional:
	Name pulumi.StringPtrInput
	// Parent Organizational Unit ID or Root ID for the account. Defaults to the Organization default Root ID. A configuration must be present for this argument to perform drift detection.
	ParentId pulumi.StringPtrInput
	// The name of an IAM role that Organizations automatically preconfigures in the new member account. This role trusts the root account, allowing users in the root account to assume the role, as permitted by the root account administrator. The role has administrator permissions in the new member account. The Organizations API provides no method for reading this information after account creation, so the provider cannot perform drift detection on its value and will always show a difference for a configured value after import unless `ignoreChanges` is used.
	RoleName pulumi.StringPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (AccountArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*accountArgs)(nil)).Elem()
}

type AccountInput interface {
	pulumi.Input

	ToAccountOutput() AccountOutput
	ToAccountOutputWithContext(ctx context.Context) AccountOutput
}

func (*Account) ElementType() reflect.Type {
	return reflect.TypeOf((**Account)(nil)).Elem()
}

func (i *Account) ToAccountOutput() AccountOutput {
	return i.ToAccountOutputWithContext(context.Background())
}

func (i *Account) ToAccountOutputWithContext(ctx context.Context) AccountOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountOutput)
}

// AccountArrayInput is an input type that accepts AccountArray and AccountArrayOutput values.
// You can construct a concrete instance of `AccountArrayInput` via:
//
//	AccountArray{ AccountArgs{...} }
type AccountArrayInput interface {
	pulumi.Input

	ToAccountArrayOutput() AccountArrayOutput
	ToAccountArrayOutputWithContext(context.Context) AccountArrayOutput
}

type AccountArray []AccountInput

func (AccountArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Account)(nil)).Elem()
}

func (i AccountArray) ToAccountArrayOutput() AccountArrayOutput {
	return i.ToAccountArrayOutputWithContext(context.Background())
}

func (i AccountArray) ToAccountArrayOutputWithContext(ctx context.Context) AccountArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountArrayOutput)
}

// AccountMapInput is an input type that accepts AccountMap and AccountMapOutput values.
// You can construct a concrete instance of `AccountMapInput` via:
//
//	AccountMap{ "key": AccountArgs{...} }
type AccountMapInput interface {
	pulumi.Input

	ToAccountMapOutput() AccountMapOutput
	ToAccountMapOutputWithContext(context.Context) AccountMapOutput
}

type AccountMap map[string]AccountInput

func (AccountMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Account)(nil)).Elem()
}

func (i AccountMap) ToAccountMapOutput() AccountMapOutput {
	return i.ToAccountMapOutputWithContext(context.Background())
}

func (i AccountMap) ToAccountMapOutputWithContext(ctx context.Context) AccountMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountMapOutput)
}

type AccountOutput struct{ *pulumi.OutputState }

func (AccountOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Account)(nil)).Elem()
}

func (o AccountOutput) ToAccountOutput() AccountOutput {
	return o
}

func (o AccountOutput) ToAccountOutputWithContext(ctx context.Context) AccountOutput {
	return o
}

// The ARN for this account.
func (o AccountOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// If true, a deletion event will close the account. Otherwise, it will only remove from the organization. This is not supported for GovCloud accounts.
func (o AccountOutput) CloseOnDeletion() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *Account) pulumi.BoolPtrOutput { return v.CloseOnDeletion }).(pulumi.BoolPtrOutput)
}

// Whether to also create a GovCloud account. The GovCloud account is tied to the main (commercial) account this resource creates. If `true`, the GovCloud account ID is available in the `govcloudId` attribute. The only way to manage the GovCloud account with the provider is to subsequently import the account using this resource.
func (o AccountOutput) CreateGovcloud() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *Account) pulumi.BoolPtrOutput { return v.CreateGovcloud }).(pulumi.BoolPtrOutput)
}

// Email address of the owner to assign to the new member account. This email address must not already be associated with another AWS account.
func (o AccountOutput) Email() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.Email }).(pulumi.StringOutput)
}

// ID for a GovCloud account created with the account.
func (o AccountOutput) GovcloudId() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.GovcloudId }).(pulumi.StringOutput)
}

// If set to `ALLOW`, the new account enables IAM users and roles to access account billing information if they have the required permissions. If set to `DENY`, then only the root user (and no roles) of the new account can access account billing information. If this is unset, the AWS API will default this to `ALLOW`. If the resource is created and this option is changed, it will try to recreate the account.
func (o AccountOutput) IamUserAccessToBilling() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Account) pulumi.StringPtrOutput { return v.IamUserAccessToBilling }).(pulumi.StringPtrOutput)
}

func (o AccountOutput) JoinedMethod() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.JoinedMethod }).(pulumi.StringOutput)
}

func (o AccountOutput) JoinedTimestamp() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.JoinedTimestamp }).(pulumi.StringOutput)
}

// Friendly name for the member account.
//
// The following arguments are optional:
func (o AccountOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Parent Organizational Unit ID or Root ID for the account. Defaults to the Organization default Root ID. A configuration must be present for this argument to perform drift detection.
func (o AccountOutput) ParentId() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.ParentId }).(pulumi.StringOutput)
}

// The name of an IAM role that Organizations automatically preconfigures in the new member account. This role trusts the root account, allowing users in the root account to assume the role, as permitted by the root account administrator. The role has administrator permissions in the new member account. The Organizations API provides no method for reading this information after account creation, so the provider cannot perform drift detection on its value and will always show a difference for a configured value after import unless `ignoreChanges` is used.
func (o AccountOutput) RoleName() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Account) pulumi.StringPtrOutput { return v.RoleName }).(pulumi.StringPtrOutput)
}

// The status of the account in the organization.
func (o AccountOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *Account) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o AccountOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Account) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o AccountOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Account) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type AccountArrayOutput struct{ *pulumi.OutputState }

func (AccountArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Account)(nil)).Elem()
}

func (o AccountArrayOutput) ToAccountArrayOutput() AccountArrayOutput {
	return o
}

func (o AccountArrayOutput) ToAccountArrayOutputWithContext(ctx context.Context) AccountArrayOutput {
	return o
}

func (o AccountArrayOutput) Index(i pulumi.IntInput) AccountOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Account {
		return vs[0].([]*Account)[vs[1].(int)]
	}).(AccountOutput)
}

type AccountMapOutput struct{ *pulumi.OutputState }

func (AccountMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Account)(nil)).Elem()
}

func (o AccountMapOutput) ToAccountMapOutput() AccountMapOutput {
	return o
}

func (o AccountMapOutput) ToAccountMapOutputWithContext(ctx context.Context) AccountMapOutput {
	return o
}

func (o AccountMapOutput) MapIndex(k pulumi.StringInput) AccountOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Account {
		return vs[0].(map[string]*Account)[vs[1].(string)]
	}).(AccountOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AccountInput)(nil)).Elem(), &Account{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccountArrayInput)(nil)).Elem(), AccountArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccountMapInput)(nil)).Elem(), AccountMap{})
	pulumi.RegisterOutputType(AccountOutput{})
	pulumi.RegisterOutputType(AccountArrayOutput{})
	pulumi.RegisterOutputType(AccountMapOutput{})
}
