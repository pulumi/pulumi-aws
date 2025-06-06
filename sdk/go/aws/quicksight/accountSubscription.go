// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package quicksight

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS QuickSight Account Subscription.
//
// > Due to the absence of the `adminGroup`, `authorGroup`, and `readerGroup` fields in the [`DescribeAccountSettings`](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_DescribeAccountSettings.html) API response, changes made to these groups post-subscription will not be detected by this resource.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/quicksight"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := quicksight.NewAccountSubscription(ctx, "subscription", &quicksight.AccountSubscriptionArgs{
//				AccountName:          pulumi.String("quicksight-pulumi"),
//				AuthenticationMethod: pulumi.String("IAM_AND_QUICKSIGHT"),
//				Edition:              pulumi.String("ENTERPRISE"),
//				NotificationEmail:    pulumi.String("notification@email.com"),
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
// You cannot import this resource.
type AccountSubscription struct {
	pulumi.CustomResourceState

	// Name of your Amazon QuickSight account. This name is unique over all of AWS, and it appears only when users sign in.
	AccountName pulumi.StringOutput `pulumi:"accountName"`
	// Status of the Amazon QuickSight account's subscription.
	AccountSubscriptionStatus pulumi.StringOutput `pulumi:"accountSubscriptionStatus"`
	// Name of your Active Directory. This field is required if `ACTIVE_DIRECTORY` is the selected authentication method of the new Amazon QuickSight account.
	ActiveDirectoryName pulumi.StringPtrOutput `pulumi:"activeDirectoryName"`
	// Admin group associated with your Active Directory or IAM Identity Center account. This field is required if `ACTIVE_DIRECTORY` or `IAM_IDENTITY_CENTER` is the selected authentication method of the new Amazon QuickSight account.
	AdminGroups pulumi.StringArrayOutput `pulumi:"adminGroups"`
	// Method that you want to use to authenticate your Amazon QuickSight account. Currently, the valid values for this parameter are `IAM_AND_QUICKSIGHT`, `IAM_ONLY`, `IAM_IDENTITY_CENTER`, and `ACTIVE_DIRECTORY`.
	AuthenticationMethod pulumi.StringOutput `pulumi:"authenticationMethod"`
	// Author group associated with your Active Directory or IAM Identity Center account.
	AuthorGroups pulumi.StringArrayOutput `pulumi:"authorGroups"`
	// AWS account ID hosting the QuickSight account. Default to provider account.
	AwsAccountId pulumi.StringOutput `pulumi:"awsAccountId"`
	// A 10-digit phone number for the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	ContactNumber pulumi.StringPtrOutput `pulumi:"contactNumber"`
	// Active Directory ID that is associated with your Amazon QuickSight account.
	DirectoryId pulumi.StringPtrOutput `pulumi:"directoryId"`
	// Edition of Amazon QuickSight that you want your account to have. Currently, you can choose from `STANDARD`, `ENTERPRISE` or `ENTERPRISE_AND_Q`.
	Edition pulumi.StringOutput `pulumi:"edition"`
	// Email address of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	EmailAddress pulumi.StringPtrOutput `pulumi:"emailAddress"`
	// First name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	FirstName pulumi.StringPtrOutput `pulumi:"firstName"`
	// The Amazon Resource Name (ARN) for the IAM Identity Center instance.
	IamIdentityCenterInstanceArn pulumi.StringPtrOutput `pulumi:"iamIdentityCenterInstanceArn"`
	// Last name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	LastName pulumi.StringPtrOutput `pulumi:"lastName"`
	// Email address that you want Amazon QuickSight to send notifications to regarding your Amazon QuickSight account or Amazon QuickSight subscription.
	//
	// The following arguments are optional:
	NotificationEmail pulumi.StringOutput `pulumi:"notificationEmail"`
	// Reader group associated with your Active Directory or IAM Identity Center account.
	ReaderGroups pulumi.StringArrayOutput `pulumi:"readerGroups"`
	// Realm of the Active Directory that is associated with your Amazon QuickSight account.
	Realm pulumi.StringPtrOutput `pulumi:"realm"`
}

// NewAccountSubscription registers a new resource with the given unique name, arguments, and options.
func NewAccountSubscription(ctx *pulumi.Context,
	name string, args *AccountSubscriptionArgs, opts ...pulumi.ResourceOption) (*AccountSubscription, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.AccountName == nil {
		return nil, errors.New("invalid value for required argument 'AccountName'")
	}
	if args.AuthenticationMethod == nil {
		return nil, errors.New("invalid value for required argument 'AuthenticationMethod'")
	}
	if args.Edition == nil {
		return nil, errors.New("invalid value for required argument 'Edition'")
	}
	if args.NotificationEmail == nil {
		return nil, errors.New("invalid value for required argument 'NotificationEmail'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource AccountSubscription
	err := ctx.RegisterResource("aws:quicksight/accountSubscription:AccountSubscription", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAccountSubscription gets an existing AccountSubscription resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAccountSubscription(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AccountSubscriptionState, opts ...pulumi.ResourceOption) (*AccountSubscription, error) {
	var resource AccountSubscription
	err := ctx.ReadResource("aws:quicksight/accountSubscription:AccountSubscription", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AccountSubscription resources.
type accountSubscriptionState struct {
	// Name of your Amazon QuickSight account. This name is unique over all of AWS, and it appears only when users sign in.
	AccountName *string `pulumi:"accountName"`
	// Status of the Amazon QuickSight account's subscription.
	AccountSubscriptionStatus *string `pulumi:"accountSubscriptionStatus"`
	// Name of your Active Directory. This field is required if `ACTIVE_DIRECTORY` is the selected authentication method of the new Amazon QuickSight account.
	ActiveDirectoryName *string `pulumi:"activeDirectoryName"`
	// Admin group associated with your Active Directory or IAM Identity Center account. This field is required if `ACTIVE_DIRECTORY` or `IAM_IDENTITY_CENTER` is the selected authentication method of the new Amazon QuickSight account.
	AdminGroups []string `pulumi:"adminGroups"`
	// Method that you want to use to authenticate your Amazon QuickSight account. Currently, the valid values for this parameter are `IAM_AND_QUICKSIGHT`, `IAM_ONLY`, `IAM_IDENTITY_CENTER`, and `ACTIVE_DIRECTORY`.
	AuthenticationMethod *string `pulumi:"authenticationMethod"`
	// Author group associated with your Active Directory or IAM Identity Center account.
	AuthorGroups []string `pulumi:"authorGroups"`
	// AWS account ID hosting the QuickSight account. Default to provider account.
	AwsAccountId *string `pulumi:"awsAccountId"`
	// A 10-digit phone number for the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	ContactNumber *string `pulumi:"contactNumber"`
	// Active Directory ID that is associated with your Amazon QuickSight account.
	DirectoryId *string `pulumi:"directoryId"`
	// Edition of Amazon QuickSight that you want your account to have. Currently, you can choose from `STANDARD`, `ENTERPRISE` or `ENTERPRISE_AND_Q`.
	Edition *string `pulumi:"edition"`
	// Email address of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	EmailAddress *string `pulumi:"emailAddress"`
	// First name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	FirstName *string `pulumi:"firstName"`
	// The Amazon Resource Name (ARN) for the IAM Identity Center instance.
	IamIdentityCenterInstanceArn *string `pulumi:"iamIdentityCenterInstanceArn"`
	// Last name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	LastName *string `pulumi:"lastName"`
	// Email address that you want Amazon QuickSight to send notifications to regarding your Amazon QuickSight account or Amazon QuickSight subscription.
	//
	// The following arguments are optional:
	NotificationEmail *string `pulumi:"notificationEmail"`
	// Reader group associated with your Active Directory or IAM Identity Center account.
	ReaderGroups []string `pulumi:"readerGroups"`
	// Realm of the Active Directory that is associated with your Amazon QuickSight account.
	Realm *string `pulumi:"realm"`
}

type AccountSubscriptionState struct {
	// Name of your Amazon QuickSight account. This name is unique over all of AWS, and it appears only when users sign in.
	AccountName pulumi.StringPtrInput
	// Status of the Amazon QuickSight account's subscription.
	AccountSubscriptionStatus pulumi.StringPtrInput
	// Name of your Active Directory. This field is required if `ACTIVE_DIRECTORY` is the selected authentication method of the new Amazon QuickSight account.
	ActiveDirectoryName pulumi.StringPtrInput
	// Admin group associated with your Active Directory or IAM Identity Center account. This field is required if `ACTIVE_DIRECTORY` or `IAM_IDENTITY_CENTER` is the selected authentication method of the new Amazon QuickSight account.
	AdminGroups pulumi.StringArrayInput
	// Method that you want to use to authenticate your Amazon QuickSight account. Currently, the valid values for this parameter are `IAM_AND_QUICKSIGHT`, `IAM_ONLY`, `IAM_IDENTITY_CENTER`, and `ACTIVE_DIRECTORY`.
	AuthenticationMethod pulumi.StringPtrInput
	// Author group associated with your Active Directory or IAM Identity Center account.
	AuthorGroups pulumi.StringArrayInput
	// AWS account ID hosting the QuickSight account. Default to provider account.
	AwsAccountId pulumi.StringPtrInput
	// A 10-digit phone number for the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	ContactNumber pulumi.StringPtrInput
	// Active Directory ID that is associated with your Amazon QuickSight account.
	DirectoryId pulumi.StringPtrInput
	// Edition of Amazon QuickSight that you want your account to have. Currently, you can choose from `STANDARD`, `ENTERPRISE` or `ENTERPRISE_AND_Q`.
	Edition pulumi.StringPtrInput
	// Email address of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	EmailAddress pulumi.StringPtrInput
	// First name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	FirstName pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) for the IAM Identity Center instance.
	IamIdentityCenterInstanceArn pulumi.StringPtrInput
	// Last name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	LastName pulumi.StringPtrInput
	// Email address that you want Amazon QuickSight to send notifications to regarding your Amazon QuickSight account or Amazon QuickSight subscription.
	//
	// The following arguments are optional:
	NotificationEmail pulumi.StringPtrInput
	// Reader group associated with your Active Directory or IAM Identity Center account.
	ReaderGroups pulumi.StringArrayInput
	// Realm of the Active Directory that is associated with your Amazon QuickSight account.
	Realm pulumi.StringPtrInput
}

func (AccountSubscriptionState) ElementType() reflect.Type {
	return reflect.TypeOf((*accountSubscriptionState)(nil)).Elem()
}

type accountSubscriptionArgs struct {
	// Name of your Amazon QuickSight account. This name is unique over all of AWS, and it appears only when users sign in.
	AccountName string `pulumi:"accountName"`
	// Name of your Active Directory. This field is required if `ACTIVE_DIRECTORY` is the selected authentication method of the new Amazon QuickSight account.
	ActiveDirectoryName *string `pulumi:"activeDirectoryName"`
	// Admin group associated with your Active Directory or IAM Identity Center account. This field is required if `ACTIVE_DIRECTORY` or `IAM_IDENTITY_CENTER` is the selected authentication method of the new Amazon QuickSight account.
	AdminGroups []string `pulumi:"adminGroups"`
	// Method that you want to use to authenticate your Amazon QuickSight account. Currently, the valid values for this parameter are `IAM_AND_QUICKSIGHT`, `IAM_ONLY`, `IAM_IDENTITY_CENTER`, and `ACTIVE_DIRECTORY`.
	AuthenticationMethod string `pulumi:"authenticationMethod"`
	// Author group associated with your Active Directory or IAM Identity Center account.
	AuthorGroups []string `pulumi:"authorGroups"`
	// AWS account ID hosting the QuickSight account. Default to provider account.
	AwsAccountId *string `pulumi:"awsAccountId"`
	// A 10-digit phone number for the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	ContactNumber *string `pulumi:"contactNumber"`
	// Active Directory ID that is associated with your Amazon QuickSight account.
	DirectoryId *string `pulumi:"directoryId"`
	// Edition of Amazon QuickSight that you want your account to have. Currently, you can choose from `STANDARD`, `ENTERPRISE` or `ENTERPRISE_AND_Q`.
	Edition string `pulumi:"edition"`
	// Email address of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	EmailAddress *string `pulumi:"emailAddress"`
	// First name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	FirstName *string `pulumi:"firstName"`
	// The Amazon Resource Name (ARN) for the IAM Identity Center instance.
	IamIdentityCenterInstanceArn *string `pulumi:"iamIdentityCenterInstanceArn"`
	// Last name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	LastName *string `pulumi:"lastName"`
	// Email address that you want Amazon QuickSight to send notifications to regarding your Amazon QuickSight account or Amazon QuickSight subscription.
	//
	// The following arguments are optional:
	NotificationEmail string `pulumi:"notificationEmail"`
	// Reader group associated with your Active Directory or IAM Identity Center account.
	ReaderGroups []string `pulumi:"readerGroups"`
	// Realm of the Active Directory that is associated with your Amazon QuickSight account.
	Realm *string `pulumi:"realm"`
}

// The set of arguments for constructing a AccountSubscription resource.
type AccountSubscriptionArgs struct {
	// Name of your Amazon QuickSight account. This name is unique over all of AWS, and it appears only when users sign in.
	AccountName pulumi.StringInput
	// Name of your Active Directory. This field is required if `ACTIVE_DIRECTORY` is the selected authentication method of the new Amazon QuickSight account.
	ActiveDirectoryName pulumi.StringPtrInput
	// Admin group associated with your Active Directory or IAM Identity Center account. This field is required if `ACTIVE_DIRECTORY` or `IAM_IDENTITY_CENTER` is the selected authentication method of the new Amazon QuickSight account.
	AdminGroups pulumi.StringArrayInput
	// Method that you want to use to authenticate your Amazon QuickSight account. Currently, the valid values for this parameter are `IAM_AND_QUICKSIGHT`, `IAM_ONLY`, `IAM_IDENTITY_CENTER`, and `ACTIVE_DIRECTORY`.
	AuthenticationMethod pulumi.StringInput
	// Author group associated with your Active Directory or IAM Identity Center account.
	AuthorGroups pulumi.StringArrayInput
	// AWS account ID hosting the QuickSight account. Default to provider account.
	AwsAccountId pulumi.StringPtrInput
	// A 10-digit phone number for the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	ContactNumber pulumi.StringPtrInput
	// Active Directory ID that is associated with your Amazon QuickSight account.
	DirectoryId pulumi.StringPtrInput
	// Edition of Amazon QuickSight that you want your account to have. Currently, you can choose from `STANDARD`, `ENTERPRISE` or `ENTERPRISE_AND_Q`.
	Edition pulumi.StringInput
	// Email address of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	EmailAddress pulumi.StringPtrInput
	// First name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	FirstName pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) for the IAM Identity Center instance.
	IamIdentityCenterInstanceArn pulumi.StringPtrInput
	// Last name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
	LastName pulumi.StringPtrInput
	// Email address that you want Amazon QuickSight to send notifications to regarding your Amazon QuickSight account or Amazon QuickSight subscription.
	//
	// The following arguments are optional:
	NotificationEmail pulumi.StringInput
	// Reader group associated with your Active Directory or IAM Identity Center account.
	ReaderGroups pulumi.StringArrayInput
	// Realm of the Active Directory that is associated with your Amazon QuickSight account.
	Realm pulumi.StringPtrInput
}

func (AccountSubscriptionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*accountSubscriptionArgs)(nil)).Elem()
}

type AccountSubscriptionInput interface {
	pulumi.Input

	ToAccountSubscriptionOutput() AccountSubscriptionOutput
	ToAccountSubscriptionOutputWithContext(ctx context.Context) AccountSubscriptionOutput
}

func (*AccountSubscription) ElementType() reflect.Type {
	return reflect.TypeOf((**AccountSubscription)(nil)).Elem()
}

func (i *AccountSubscription) ToAccountSubscriptionOutput() AccountSubscriptionOutput {
	return i.ToAccountSubscriptionOutputWithContext(context.Background())
}

func (i *AccountSubscription) ToAccountSubscriptionOutputWithContext(ctx context.Context) AccountSubscriptionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountSubscriptionOutput)
}

// AccountSubscriptionArrayInput is an input type that accepts AccountSubscriptionArray and AccountSubscriptionArrayOutput values.
// You can construct a concrete instance of `AccountSubscriptionArrayInput` via:
//
//	AccountSubscriptionArray{ AccountSubscriptionArgs{...} }
type AccountSubscriptionArrayInput interface {
	pulumi.Input

	ToAccountSubscriptionArrayOutput() AccountSubscriptionArrayOutput
	ToAccountSubscriptionArrayOutputWithContext(context.Context) AccountSubscriptionArrayOutput
}

type AccountSubscriptionArray []AccountSubscriptionInput

func (AccountSubscriptionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AccountSubscription)(nil)).Elem()
}

func (i AccountSubscriptionArray) ToAccountSubscriptionArrayOutput() AccountSubscriptionArrayOutput {
	return i.ToAccountSubscriptionArrayOutputWithContext(context.Background())
}

func (i AccountSubscriptionArray) ToAccountSubscriptionArrayOutputWithContext(ctx context.Context) AccountSubscriptionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountSubscriptionArrayOutput)
}

// AccountSubscriptionMapInput is an input type that accepts AccountSubscriptionMap and AccountSubscriptionMapOutput values.
// You can construct a concrete instance of `AccountSubscriptionMapInput` via:
//
//	AccountSubscriptionMap{ "key": AccountSubscriptionArgs{...} }
type AccountSubscriptionMapInput interface {
	pulumi.Input

	ToAccountSubscriptionMapOutput() AccountSubscriptionMapOutput
	ToAccountSubscriptionMapOutputWithContext(context.Context) AccountSubscriptionMapOutput
}

type AccountSubscriptionMap map[string]AccountSubscriptionInput

func (AccountSubscriptionMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AccountSubscription)(nil)).Elem()
}

func (i AccountSubscriptionMap) ToAccountSubscriptionMapOutput() AccountSubscriptionMapOutput {
	return i.ToAccountSubscriptionMapOutputWithContext(context.Background())
}

func (i AccountSubscriptionMap) ToAccountSubscriptionMapOutputWithContext(ctx context.Context) AccountSubscriptionMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccountSubscriptionMapOutput)
}

type AccountSubscriptionOutput struct{ *pulumi.OutputState }

func (AccountSubscriptionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AccountSubscription)(nil)).Elem()
}

func (o AccountSubscriptionOutput) ToAccountSubscriptionOutput() AccountSubscriptionOutput {
	return o
}

func (o AccountSubscriptionOutput) ToAccountSubscriptionOutputWithContext(ctx context.Context) AccountSubscriptionOutput {
	return o
}

// Name of your Amazon QuickSight account. This name is unique over all of AWS, and it appears only when users sign in.
func (o AccountSubscriptionOutput) AccountName() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringOutput { return v.AccountName }).(pulumi.StringOutput)
}

// Status of the Amazon QuickSight account's subscription.
func (o AccountSubscriptionOutput) AccountSubscriptionStatus() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringOutput { return v.AccountSubscriptionStatus }).(pulumi.StringOutput)
}

// Name of your Active Directory. This field is required if `ACTIVE_DIRECTORY` is the selected authentication method of the new Amazon QuickSight account.
func (o AccountSubscriptionOutput) ActiveDirectoryName() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringPtrOutput { return v.ActiveDirectoryName }).(pulumi.StringPtrOutput)
}

// Admin group associated with your Active Directory or IAM Identity Center account. This field is required if `ACTIVE_DIRECTORY` or `IAM_IDENTITY_CENTER` is the selected authentication method of the new Amazon QuickSight account.
func (o AccountSubscriptionOutput) AdminGroups() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringArrayOutput { return v.AdminGroups }).(pulumi.StringArrayOutput)
}

// Method that you want to use to authenticate your Amazon QuickSight account. Currently, the valid values for this parameter are `IAM_AND_QUICKSIGHT`, `IAM_ONLY`, `IAM_IDENTITY_CENTER`, and `ACTIVE_DIRECTORY`.
func (o AccountSubscriptionOutput) AuthenticationMethod() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringOutput { return v.AuthenticationMethod }).(pulumi.StringOutput)
}

// Author group associated with your Active Directory or IAM Identity Center account.
func (o AccountSubscriptionOutput) AuthorGroups() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringArrayOutput { return v.AuthorGroups }).(pulumi.StringArrayOutput)
}

// AWS account ID hosting the QuickSight account. Default to provider account.
func (o AccountSubscriptionOutput) AwsAccountId() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringOutput { return v.AwsAccountId }).(pulumi.StringOutput)
}

// A 10-digit phone number for the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
func (o AccountSubscriptionOutput) ContactNumber() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringPtrOutput { return v.ContactNumber }).(pulumi.StringPtrOutput)
}

// Active Directory ID that is associated with your Amazon QuickSight account.
func (o AccountSubscriptionOutput) DirectoryId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringPtrOutput { return v.DirectoryId }).(pulumi.StringPtrOutput)
}

// Edition of Amazon QuickSight that you want your account to have. Currently, you can choose from `STANDARD`, `ENTERPRISE` or `ENTERPRISE_AND_Q`.
func (o AccountSubscriptionOutput) Edition() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringOutput { return v.Edition }).(pulumi.StringOutput)
}

// Email address of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
func (o AccountSubscriptionOutput) EmailAddress() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringPtrOutput { return v.EmailAddress }).(pulumi.StringPtrOutput)
}

// First name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
func (o AccountSubscriptionOutput) FirstName() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringPtrOutput { return v.FirstName }).(pulumi.StringPtrOutput)
}

// The Amazon Resource Name (ARN) for the IAM Identity Center instance.
func (o AccountSubscriptionOutput) IamIdentityCenterInstanceArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringPtrOutput { return v.IamIdentityCenterInstanceArn }).(pulumi.StringPtrOutput)
}

// Last name of the author of the Amazon QuickSight account to use for future communications. This field is required if `ENTERPPRISE_AND_Q` is the selected edition of the new Amazon QuickSight account.
func (o AccountSubscriptionOutput) LastName() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringPtrOutput { return v.LastName }).(pulumi.StringPtrOutput)
}

// Email address that you want Amazon QuickSight to send notifications to regarding your Amazon QuickSight account or Amazon QuickSight subscription.
//
// The following arguments are optional:
func (o AccountSubscriptionOutput) NotificationEmail() pulumi.StringOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringOutput { return v.NotificationEmail }).(pulumi.StringOutput)
}

// Reader group associated with your Active Directory or IAM Identity Center account.
func (o AccountSubscriptionOutput) ReaderGroups() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringArrayOutput { return v.ReaderGroups }).(pulumi.StringArrayOutput)
}

// Realm of the Active Directory that is associated with your Amazon QuickSight account.
func (o AccountSubscriptionOutput) Realm() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AccountSubscription) pulumi.StringPtrOutput { return v.Realm }).(pulumi.StringPtrOutput)
}

type AccountSubscriptionArrayOutput struct{ *pulumi.OutputState }

func (AccountSubscriptionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AccountSubscription)(nil)).Elem()
}

func (o AccountSubscriptionArrayOutput) ToAccountSubscriptionArrayOutput() AccountSubscriptionArrayOutput {
	return o
}

func (o AccountSubscriptionArrayOutput) ToAccountSubscriptionArrayOutputWithContext(ctx context.Context) AccountSubscriptionArrayOutput {
	return o
}

func (o AccountSubscriptionArrayOutput) Index(i pulumi.IntInput) AccountSubscriptionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AccountSubscription {
		return vs[0].([]*AccountSubscription)[vs[1].(int)]
	}).(AccountSubscriptionOutput)
}

type AccountSubscriptionMapOutput struct{ *pulumi.OutputState }

func (AccountSubscriptionMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AccountSubscription)(nil)).Elem()
}

func (o AccountSubscriptionMapOutput) ToAccountSubscriptionMapOutput() AccountSubscriptionMapOutput {
	return o
}

func (o AccountSubscriptionMapOutput) ToAccountSubscriptionMapOutputWithContext(ctx context.Context) AccountSubscriptionMapOutput {
	return o
}

func (o AccountSubscriptionMapOutput) MapIndex(k pulumi.StringInput) AccountSubscriptionOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AccountSubscription {
		return vs[0].(map[string]*AccountSubscription)[vs[1].(string)]
	}).(AccountSubscriptionOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AccountSubscriptionInput)(nil)).Elem(), &AccountSubscription{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccountSubscriptionArrayInput)(nil)).Elem(), AccountSubscriptionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccountSubscriptionMapInput)(nil)).Elem(), AccountSubscriptionMap{})
	pulumi.RegisterOutputType(AccountSubscriptionOutput{})
	pulumi.RegisterOutputType(AccountSubscriptionArrayOutput{})
	pulumi.RegisterOutputType(AccountSubscriptionMapOutput{})
}
