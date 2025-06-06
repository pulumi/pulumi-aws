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

// Resource for managing QuickSight User
//
// ## Example Usage
//
// ### Create User With IAM Identity Type Using an IAM Role
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
//			_, err := quicksight.NewUser(ctx, "example", &quicksight.UserArgs{
//				Email:        pulumi.String("author1@example.com"),
//				IdentityType: pulumi.String("IAM"),
//				UserRole:     pulumi.String("AUTHOR"),
//				IamArn:       pulumi.String("arn:aws:iam::123456789012:role/AuthorRole"),
//				SessionName:  pulumi.String("author1"),
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
// ### Create User With IAM Identity Type Using an IAM User
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
//			_, err := quicksight.NewUser(ctx, "example", &quicksight.UserArgs{
//				Email:        pulumi.String("authorpro1@example.com"),
//				IdentityType: pulumi.String("IAM"),
//				UserRole:     pulumi.String("AUTHOR_PRO"),
//				IamArn:       pulumi.String("arn:aws:iam::123456789012:user/authorpro1"),
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
// ### Create User With QuickSight Identity Type in Non-Default Namespace
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
//			_, err := quicksight.NewUser(ctx, "example", &quicksight.UserArgs{
//				Email:        pulumi.String("reader1@example.com"),
//				IdentityType: pulumi.String("QUICKSIGHT"),
//				UserRole:     pulumi.String("READER"),
//				Namespace:    pulumi.String("example"),
//				UserName:     pulumi.String("reader1"),
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
type User struct {
	pulumi.CustomResourceState

	// Amazon Resource Name (ARN) for the user.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
	AwsAccountId pulumi.StringOutput `pulumi:"awsAccountId"`
	// Email address of the user that you want to register.
	Email pulumi.StringOutput `pulumi:"email"`
	// ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
	IamArn pulumi.StringPtrOutput `pulumi:"iamArn"`
	// Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
	IdentityType pulumi.StringOutput `pulumi:"identityType"`
	// The Amazon Quicksight namespace to create the user in. Defaults to `default`.
	Namespace pulumi.StringPtrOutput `pulumi:"namespace"`
	// Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
	SessionName pulumi.StringPtrOutput `pulumi:"sessionName"`
	// URL the user visits to complete registration and provide a password. Returned only for users with an identity type of `QUICKSIGHT`.
	UserInvitationUrl pulumi.StringOutput `pulumi:"userInvitationUrl"`
	// Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
	UserName pulumi.StringPtrOutput `pulumi:"userName"`
	// Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
	//
	// The following arguments are optional:
	UserRole pulumi.StringOutput `pulumi:"userRole"`
}

// NewUser registers a new resource with the given unique name, arguments, and options.
func NewUser(ctx *pulumi.Context,
	name string, args *UserArgs, opts ...pulumi.ResourceOption) (*User, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Email == nil {
		return nil, errors.New("invalid value for required argument 'Email'")
	}
	if args.IdentityType == nil {
		return nil, errors.New("invalid value for required argument 'IdentityType'")
	}
	if args.UserRole == nil {
		return nil, errors.New("invalid value for required argument 'UserRole'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource User
	err := ctx.RegisterResource("aws:quicksight/user:User", name, args, &resource, opts...)
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
	err := ctx.ReadResource("aws:quicksight/user:User", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering User resources.
type userState struct {
	// Amazon Resource Name (ARN) for the user.
	Arn *string `pulumi:"arn"`
	// ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
	AwsAccountId *string `pulumi:"awsAccountId"`
	// Email address of the user that you want to register.
	Email *string `pulumi:"email"`
	// ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
	IamArn *string `pulumi:"iamArn"`
	// Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
	IdentityType *string `pulumi:"identityType"`
	// The Amazon Quicksight namespace to create the user in. Defaults to `default`.
	Namespace *string `pulumi:"namespace"`
	// Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
	SessionName *string `pulumi:"sessionName"`
	// URL the user visits to complete registration and provide a password. Returned only for users with an identity type of `QUICKSIGHT`.
	UserInvitationUrl *string `pulumi:"userInvitationUrl"`
	// Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
	UserName *string `pulumi:"userName"`
	// Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
	//
	// The following arguments are optional:
	UserRole *string `pulumi:"userRole"`
}

type UserState struct {
	// Amazon Resource Name (ARN) for the user.
	Arn pulumi.StringPtrInput
	// ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
	AwsAccountId pulumi.StringPtrInput
	// Email address of the user that you want to register.
	Email pulumi.StringPtrInput
	// ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
	IamArn pulumi.StringPtrInput
	// Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
	IdentityType pulumi.StringPtrInput
	// The Amazon Quicksight namespace to create the user in. Defaults to `default`.
	Namespace pulumi.StringPtrInput
	// Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
	SessionName pulumi.StringPtrInput
	// URL the user visits to complete registration and provide a password. Returned only for users with an identity type of `QUICKSIGHT`.
	UserInvitationUrl pulumi.StringPtrInput
	// Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
	UserName pulumi.StringPtrInput
	// Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
	//
	// The following arguments are optional:
	UserRole pulumi.StringPtrInput
}

func (UserState) ElementType() reflect.Type {
	return reflect.TypeOf((*userState)(nil)).Elem()
}

type userArgs struct {
	// ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
	AwsAccountId *string `pulumi:"awsAccountId"`
	// Email address of the user that you want to register.
	Email string `pulumi:"email"`
	// ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
	IamArn *string `pulumi:"iamArn"`
	// Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
	IdentityType string `pulumi:"identityType"`
	// The Amazon Quicksight namespace to create the user in. Defaults to `default`.
	Namespace *string `pulumi:"namespace"`
	// Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
	SessionName *string `pulumi:"sessionName"`
	// Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
	UserName *string `pulumi:"userName"`
	// Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
	//
	// The following arguments are optional:
	UserRole string `pulumi:"userRole"`
}

// The set of arguments for constructing a User resource.
type UserArgs struct {
	// ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
	AwsAccountId pulumi.StringPtrInput
	// Email address of the user that you want to register.
	Email pulumi.StringInput
	// ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
	IamArn pulumi.StringPtrInput
	// Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
	IdentityType pulumi.StringInput
	// The Amazon Quicksight namespace to create the user in. Defaults to `default`.
	Namespace pulumi.StringPtrInput
	// Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
	SessionName pulumi.StringPtrInput
	// Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
	UserName pulumi.StringPtrInput
	// Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
	//
	// The following arguments are optional:
	UserRole pulumi.StringInput
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

// Amazon Resource Name (ARN) for the user.
func (o UserOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// ID for the AWS account that the user is in. Use the ID for the AWS account that contains your Amazon QuickSight account.
func (o UserOutput) AwsAccountId() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.AwsAccountId }).(pulumi.StringOutput)
}

// Email address of the user that you want to register.
func (o UserOutput) Email() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.Email }).(pulumi.StringOutput)
}

// ARN of the IAM user or role that you are registering with Amazon QuickSight. Required only for users with an identity type of `IAM`.
func (o UserOutput) IamArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.IamArn }).(pulumi.StringPtrOutput)
}

// Identity type that your Amazon QuickSight account uses to manage the identity of users. Valid values: `IAM`, `QUICKSIGHT`.
func (o UserOutput) IdentityType() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.IdentityType }).(pulumi.StringOutput)
}

// The Amazon Quicksight namespace to create the user in. Defaults to `default`.
func (o UserOutput) Namespace() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.Namespace }).(pulumi.StringPtrOutput)
}

// Name of the IAM session to use when assuming roles that can embed QuickSight dashboards. Only valid for registering users using an assumed IAM role. Additionally, if registering multiple users using the same IAM role, each user needs to have a unique session name.
func (o UserOutput) SessionName() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.SessionName }).(pulumi.StringPtrOutput)
}

// URL the user visits to complete registration and provide a password. Returned only for users with an identity type of `QUICKSIGHT`.
func (o UserOutput) UserInvitationUrl() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.UserInvitationUrl }).(pulumi.StringOutput)
}

// Amazon QuickSight user name that you want to create for the user you are registering. Required only for users with an identity type of `QUICKSIGHT`.
func (o UserOutput) UserName() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *User) pulumi.StringPtrOutput { return v.UserName }).(pulumi.StringPtrOutput)
}

// Amazon QuickSight role for the user. Value values: `READER`, `AUTHOR`, `ADMIN`, `READER_PRO`, `AUTHOR_PRO`, `ADMIN_PRO`.
//
// The following arguments are optional:
func (o UserOutput) UserRole() pulumi.StringOutput {
	return o.ApplyT(func(v *User) pulumi.StringOutput { return v.UserRole }).(pulumi.StringOutput)
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
