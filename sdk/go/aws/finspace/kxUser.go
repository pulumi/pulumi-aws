// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package finspace

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS FinSpace Kx User.
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
//	"encoding/json"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/finspace"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/kms"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := kms.NewKey(ctx, "example", &kms.KeyArgs{
//				Description:          pulumi.String("Example KMS Key"),
//				DeletionWindowInDays: pulumi.Int(7),
//			})
//			if err != nil {
//				return err
//			}
//			exampleKxEnvironment, err := finspace.NewKxEnvironment(ctx, "example", &finspace.KxEnvironmentArgs{
//				Name:     pulumi.String("my-tf-kx-environment"),
//				KmsKeyId: example.Arn,
//			})
//			if err != nil {
//				return err
//			}
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"Version": "2012-10-17",
//				"Statement": []map[string]interface{}{
//					map[string]interface{}{
//						"Action": "sts:AssumeRole",
//						"Effect": "Allow",
//						"Sid":    "",
//						"Principal": map[string]interface{}{
//							"Service": "ec2.amazonaws.com",
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			exampleRole, err := iam.NewRole(ctx, "example", &iam.RoleArgs{
//				Name:             pulumi.String("example-role"),
//				AssumeRolePolicy: pulumi.String(json0),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = finspace.NewKxUser(ctx, "example", &finspace.KxUserArgs{
//				Name:          pulumi.String("my-tf-kx-user"),
//				EnvironmentId: exampleKxEnvironment.ID(),
//				IamRole:       exampleRole.Arn,
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
// Using `pulumi import`, import an AWS FinSpace Kx User using the `id` (environment ID and user name, comma-delimited). For example:
//
// ```sh
// $ pulumi import aws:finspace/kxUser:KxUser example n3ceo7wqxoxcti5tujqwzs,my-tf-kx-user
// ```
type KxUser struct {
	pulumi.CustomResourceState

	// Amazon Resource Name (ARN) identifier of the KX user.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Unique identifier for the KX environment.
	EnvironmentId pulumi.StringOutput `pulumi:"environmentId"`
	// IAM role ARN to be associated with the user.
	//
	// The following arguments are optional:
	IamRole pulumi.StringOutput `pulumi:"iamRole"`
	// A unique identifier for the user.
	Name pulumi.StringOutput `pulumi:"name"`
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewKxUser registers a new resource with the given unique name, arguments, and options.
func NewKxUser(ctx *pulumi.Context,
	name string, args *KxUserArgs, opts ...pulumi.ResourceOption) (*KxUser, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.EnvironmentId == nil {
		return nil, errors.New("invalid value for required argument 'EnvironmentId'")
	}
	if args.IamRole == nil {
		return nil, errors.New("invalid value for required argument 'IamRole'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource KxUser
	err := ctx.RegisterResource("aws:finspace/kxUser:KxUser", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetKxUser gets an existing KxUser resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetKxUser(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *KxUserState, opts ...pulumi.ResourceOption) (*KxUser, error) {
	var resource KxUser
	err := ctx.ReadResource("aws:finspace/kxUser:KxUser", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering KxUser resources.
type kxUserState struct {
	// Amazon Resource Name (ARN) identifier of the KX user.
	Arn *string `pulumi:"arn"`
	// Unique identifier for the KX environment.
	EnvironmentId *string `pulumi:"environmentId"`
	// IAM role ARN to be associated with the user.
	//
	// The following arguments are optional:
	IamRole *string `pulumi:"iamRole"`
	// A unique identifier for the user.
	Name *string `pulumi:"name"`
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type KxUserState struct {
	// Amazon Resource Name (ARN) identifier of the KX user.
	Arn pulumi.StringPtrInput
	// Unique identifier for the KX environment.
	EnvironmentId pulumi.StringPtrInput
	// IAM role ARN to be associated with the user.
	//
	// The following arguments are optional:
	IamRole pulumi.StringPtrInput
	// A unique identifier for the user.
	Name pulumi.StringPtrInput
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (KxUserState) ElementType() reflect.Type {
	return reflect.TypeOf((*kxUserState)(nil)).Elem()
}

type kxUserArgs struct {
	// Unique identifier for the KX environment.
	EnvironmentId string `pulumi:"environmentId"`
	// IAM role ARN to be associated with the user.
	//
	// The following arguments are optional:
	IamRole string `pulumi:"iamRole"`
	// A unique identifier for the user.
	Name *string `pulumi:"name"`
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a KxUser resource.
type KxUserArgs struct {
	// Unique identifier for the KX environment.
	EnvironmentId pulumi.StringInput
	// IAM role ARN to be associated with the user.
	//
	// The following arguments are optional:
	IamRole pulumi.StringInput
	// A unique identifier for the user.
	Name pulumi.StringPtrInput
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (KxUserArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*kxUserArgs)(nil)).Elem()
}

type KxUserInput interface {
	pulumi.Input

	ToKxUserOutput() KxUserOutput
	ToKxUserOutputWithContext(ctx context.Context) KxUserOutput
}

func (*KxUser) ElementType() reflect.Type {
	return reflect.TypeOf((**KxUser)(nil)).Elem()
}

func (i *KxUser) ToKxUserOutput() KxUserOutput {
	return i.ToKxUserOutputWithContext(context.Background())
}

func (i *KxUser) ToKxUserOutputWithContext(ctx context.Context) KxUserOutput {
	return pulumi.ToOutputWithContext(ctx, i).(KxUserOutput)
}

// KxUserArrayInput is an input type that accepts KxUserArray and KxUserArrayOutput values.
// You can construct a concrete instance of `KxUserArrayInput` via:
//
//	KxUserArray{ KxUserArgs{...} }
type KxUserArrayInput interface {
	pulumi.Input

	ToKxUserArrayOutput() KxUserArrayOutput
	ToKxUserArrayOutputWithContext(context.Context) KxUserArrayOutput
}

type KxUserArray []KxUserInput

func (KxUserArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*KxUser)(nil)).Elem()
}

func (i KxUserArray) ToKxUserArrayOutput() KxUserArrayOutput {
	return i.ToKxUserArrayOutputWithContext(context.Background())
}

func (i KxUserArray) ToKxUserArrayOutputWithContext(ctx context.Context) KxUserArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(KxUserArrayOutput)
}

// KxUserMapInput is an input type that accepts KxUserMap and KxUserMapOutput values.
// You can construct a concrete instance of `KxUserMapInput` via:
//
//	KxUserMap{ "key": KxUserArgs{...} }
type KxUserMapInput interface {
	pulumi.Input

	ToKxUserMapOutput() KxUserMapOutput
	ToKxUserMapOutputWithContext(context.Context) KxUserMapOutput
}

type KxUserMap map[string]KxUserInput

func (KxUserMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*KxUser)(nil)).Elem()
}

func (i KxUserMap) ToKxUserMapOutput() KxUserMapOutput {
	return i.ToKxUserMapOutputWithContext(context.Background())
}

func (i KxUserMap) ToKxUserMapOutputWithContext(ctx context.Context) KxUserMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(KxUserMapOutput)
}

type KxUserOutput struct{ *pulumi.OutputState }

func (KxUserOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**KxUser)(nil)).Elem()
}

func (o KxUserOutput) ToKxUserOutput() KxUserOutput {
	return o
}

func (o KxUserOutput) ToKxUserOutputWithContext(ctx context.Context) KxUserOutput {
	return o
}

// Amazon Resource Name (ARN) identifier of the KX user.
func (o KxUserOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *KxUser) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Unique identifier for the KX environment.
func (o KxUserOutput) EnvironmentId() pulumi.StringOutput {
	return o.ApplyT(func(v *KxUser) pulumi.StringOutput { return v.EnvironmentId }).(pulumi.StringOutput)
}

// IAM role ARN to be associated with the user.
//
// The following arguments are optional:
func (o KxUserOutput) IamRole() pulumi.StringOutput {
	return o.ApplyT(func(v *KxUser) pulumi.StringOutput { return v.IamRole }).(pulumi.StringOutput)
}

// A unique identifier for the user.
func (o KxUserOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *KxUser) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o KxUserOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *KxUser) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o KxUserOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *KxUser) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type KxUserArrayOutput struct{ *pulumi.OutputState }

func (KxUserArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*KxUser)(nil)).Elem()
}

func (o KxUserArrayOutput) ToKxUserArrayOutput() KxUserArrayOutput {
	return o
}

func (o KxUserArrayOutput) ToKxUserArrayOutputWithContext(ctx context.Context) KxUserArrayOutput {
	return o
}

func (o KxUserArrayOutput) Index(i pulumi.IntInput) KxUserOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *KxUser {
		return vs[0].([]*KxUser)[vs[1].(int)]
	}).(KxUserOutput)
}

type KxUserMapOutput struct{ *pulumi.OutputState }

func (KxUserMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*KxUser)(nil)).Elem()
}

func (o KxUserMapOutput) ToKxUserMapOutput() KxUserMapOutput {
	return o
}

func (o KxUserMapOutput) ToKxUserMapOutputWithContext(ctx context.Context) KxUserMapOutput {
	return o
}

func (o KxUserMapOutput) MapIndex(k pulumi.StringInput) KxUserOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *KxUser {
		return vs[0].(map[string]*KxUser)[vs[1].(string)]
	}).(KxUserOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*KxUserInput)(nil)).Elem(), &KxUser{})
	pulumi.RegisterInputType(reflect.TypeOf((*KxUserArrayInput)(nil)).Elem(), KxUserArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*KxUserMapInput)(nil)).Elem(), KxUserMap{})
	pulumi.RegisterOutputType(KxUserOutput{})
	pulumi.RegisterOutputType(KxUserArrayOutput{})
	pulumi.RegisterOutputType(KxUserMapOutput{})
}
