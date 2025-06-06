// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package efs

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Elastic File System (EFS) File System Policy resource.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/efs"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			fs, err := efs.NewFileSystem(ctx, "fs", &efs.FileSystemArgs{
//				CreationToken: pulumi.String("my-product"),
//			})
//			if err != nil {
//				return err
//			}
//			policy := iam.GetPolicyDocumentOutput(ctx, iam.GetPolicyDocumentOutputArgs{
//				Statements: iam.GetPolicyDocumentStatementArray{
//					&iam.GetPolicyDocumentStatementArgs{
//						Sid:    pulumi.String("ExampleStatement01"),
//						Effect: pulumi.String("Allow"),
//						Principals: iam.GetPolicyDocumentStatementPrincipalArray{
//							&iam.GetPolicyDocumentStatementPrincipalArgs{
//								Type: pulumi.String("AWS"),
//								Identifiers: pulumi.StringArray{
//									pulumi.String("*"),
//								},
//							},
//						},
//						Actions: pulumi.StringArray{
//							pulumi.String("elasticfilesystem:ClientMount"),
//							pulumi.String("elasticfilesystem:ClientWrite"),
//						},
//						Resources: pulumi.StringArray{
//							fs.Arn,
//						},
//						Conditions: iam.GetPolicyDocumentStatementConditionArray{
//							&iam.GetPolicyDocumentStatementConditionArgs{
//								Test:     pulumi.String("Bool"),
//								Variable: pulumi.String("aws:SecureTransport"),
//								Values: pulumi.StringArray{
//									pulumi.String("true"),
//								},
//							},
//						},
//					},
//				},
//			}, nil)
//			_, err = efs.NewFileSystemPolicy(ctx, "policy", &efs.FileSystemPolicyArgs{
//				FileSystemId: fs.ID(),
//				Policy: pulumi.String(policy.ApplyT(func(policy iam.GetPolicyDocumentResult) (*string, error) {
//					return &policy.Json, nil
//				}).(pulumi.StringPtrOutput)),
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
// Using `pulumi import`, import the EFS file system policies using the `id`. For example:
//
// ```sh
// $ pulumi import aws:efs/fileSystemPolicy:FileSystemPolicy foo fs-6fa144c6
// ```
type FileSystemPolicy struct {
	pulumi.CustomResourceState

	// A flag to indicate whether to bypass the `efs.FileSystemPolicy` lockout safety check. The policy lockout safety check determines whether the policy in the request will prevent the principal making the request will be locked out from making future `PutFileSystemPolicy` requests on the file system. Set `bypassPolicyLockoutSafetyCheck` to `true` only when you intend to prevent the principal that is making the request from making a subsequent `PutFileSystemPolicy` request on the file system. The default value is `false`.
	BypassPolicyLockoutSafetyCheck pulumi.BoolPtrOutput `pulumi:"bypassPolicyLockoutSafetyCheck"`
	// The ID of the EFS file system.
	FileSystemId pulumi.StringOutput `pulumi:"fileSystemId"`
	// The JSON formatted file system policy for the EFS file system. see [Docs](https://docs.aws.amazon.com/efs/latest/ug/access-control-overview.html#access-control-manage-access-intro-resource-policies) for more info.
	//
	// The following arguments are optional:
	Policy pulumi.StringOutput `pulumi:"policy"`
}

// NewFileSystemPolicy registers a new resource with the given unique name, arguments, and options.
func NewFileSystemPolicy(ctx *pulumi.Context,
	name string, args *FileSystemPolicyArgs, opts ...pulumi.ResourceOption) (*FileSystemPolicy, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.FileSystemId == nil {
		return nil, errors.New("invalid value for required argument 'FileSystemId'")
	}
	if args.Policy == nil {
		return nil, errors.New("invalid value for required argument 'Policy'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource FileSystemPolicy
	err := ctx.RegisterResource("aws:efs/fileSystemPolicy:FileSystemPolicy", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetFileSystemPolicy gets an existing FileSystemPolicy resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetFileSystemPolicy(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *FileSystemPolicyState, opts ...pulumi.ResourceOption) (*FileSystemPolicy, error) {
	var resource FileSystemPolicy
	err := ctx.ReadResource("aws:efs/fileSystemPolicy:FileSystemPolicy", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering FileSystemPolicy resources.
type fileSystemPolicyState struct {
	// A flag to indicate whether to bypass the `efs.FileSystemPolicy` lockout safety check. The policy lockout safety check determines whether the policy in the request will prevent the principal making the request will be locked out from making future `PutFileSystemPolicy` requests on the file system. Set `bypassPolicyLockoutSafetyCheck` to `true` only when you intend to prevent the principal that is making the request from making a subsequent `PutFileSystemPolicy` request on the file system. The default value is `false`.
	BypassPolicyLockoutSafetyCheck *bool `pulumi:"bypassPolicyLockoutSafetyCheck"`
	// The ID of the EFS file system.
	FileSystemId *string `pulumi:"fileSystemId"`
	// The JSON formatted file system policy for the EFS file system. see [Docs](https://docs.aws.amazon.com/efs/latest/ug/access-control-overview.html#access-control-manage-access-intro-resource-policies) for more info.
	//
	// The following arguments are optional:
	Policy *string `pulumi:"policy"`
}

type FileSystemPolicyState struct {
	// A flag to indicate whether to bypass the `efs.FileSystemPolicy` lockout safety check. The policy lockout safety check determines whether the policy in the request will prevent the principal making the request will be locked out from making future `PutFileSystemPolicy` requests on the file system. Set `bypassPolicyLockoutSafetyCheck` to `true` only when you intend to prevent the principal that is making the request from making a subsequent `PutFileSystemPolicy` request on the file system. The default value is `false`.
	BypassPolicyLockoutSafetyCheck pulumi.BoolPtrInput
	// The ID of the EFS file system.
	FileSystemId pulumi.StringPtrInput
	// The JSON formatted file system policy for the EFS file system. see [Docs](https://docs.aws.amazon.com/efs/latest/ug/access-control-overview.html#access-control-manage-access-intro-resource-policies) for more info.
	//
	// The following arguments are optional:
	Policy pulumi.StringPtrInput
}

func (FileSystemPolicyState) ElementType() reflect.Type {
	return reflect.TypeOf((*fileSystemPolicyState)(nil)).Elem()
}

type fileSystemPolicyArgs struct {
	// A flag to indicate whether to bypass the `efs.FileSystemPolicy` lockout safety check. The policy lockout safety check determines whether the policy in the request will prevent the principal making the request will be locked out from making future `PutFileSystemPolicy` requests on the file system. Set `bypassPolicyLockoutSafetyCheck` to `true` only when you intend to prevent the principal that is making the request from making a subsequent `PutFileSystemPolicy` request on the file system. The default value is `false`.
	BypassPolicyLockoutSafetyCheck *bool `pulumi:"bypassPolicyLockoutSafetyCheck"`
	// The ID of the EFS file system.
	FileSystemId string `pulumi:"fileSystemId"`
	// The JSON formatted file system policy for the EFS file system. see [Docs](https://docs.aws.amazon.com/efs/latest/ug/access-control-overview.html#access-control-manage-access-intro-resource-policies) for more info.
	//
	// The following arguments are optional:
	Policy string `pulumi:"policy"`
}

// The set of arguments for constructing a FileSystemPolicy resource.
type FileSystemPolicyArgs struct {
	// A flag to indicate whether to bypass the `efs.FileSystemPolicy` lockout safety check. The policy lockout safety check determines whether the policy in the request will prevent the principal making the request will be locked out from making future `PutFileSystemPolicy` requests on the file system. Set `bypassPolicyLockoutSafetyCheck` to `true` only when you intend to prevent the principal that is making the request from making a subsequent `PutFileSystemPolicy` request on the file system. The default value is `false`.
	BypassPolicyLockoutSafetyCheck pulumi.BoolPtrInput
	// The ID of the EFS file system.
	FileSystemId pulumi.StringInput
	// The JSON formatted file system policy for the EFS file system. see [Docs](https://docs.aws.amazon.com/efs/latest/ug/access-control-overview.html#access-control-manage-access-intro-resource-policies) for more info.
	//
	// The following arguments are optional:
	Policy pulumi.StringInput
}

func (FileSystemPolicyArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*fileSystemPolicyArgs)(nil)).Elem()
}

type FileSystemPolicyInput interface {
	pulumi.Input

	ToFileSystemPolicyOutput() FileSystemPolicyOutput
	ToFileSystemPolicyOutputWithContext(ctx context.Context) FileSystemPolicyOutput
}

func (*FileSystemPolicy) ElementType() reflect.Type {
	return reflect.TypeOf((**FileSystemPolicy)(nil)).Elem()
}

func (i *FileSystemPolicy) ToFileSystemPolicyOutput() FileSystemPolicyOutput {
	return i.ToFileSystemPolicyOutputWithContext(context.Background())
}

func (i *FileSystemPolicy) ToFileSystemPolicyOutputWithContext(ctx context.Context) FileSystemPolicyOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FileSystemPolicyOutput)
}

// FileSystemPolicyArrayInput is an input type that accepts FileSystemPolicyArray and FileSystemPolicyArrayOutput values.
// You can construct a concrete instance of `FileSystemPolicyArrayInput` via:
//
//	FileSystemPolicyArray{ FileSystemPolicyArgs{...} }
type FileSystemPolicyArrayInput interface {
	pulumi.Input

	ToFileSystemPolicyArrayOutput() FileSystemPolicyArrayOutput
	ToFileSystemPolicyArrayOutputWithContext(context.Context) FileSystemPolicyArrayOutput
}

type FileSystemPolicyArray []FileSystemPolicyInput

func (FileSystemPolicyArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*FileSystemPolicy)(nil)).Elem()
}

func (i FileSystemPolicyArray) ToFileSystemPolicyArrayOutput() FileSystemPolicyArrayOutput {
	return i.ToFileSystemPolicyArrayOutputWithContext(context.Background())
}

func (i FileSystemPolicyArray) ToFileSystemPolicyArrayOutputWithContext(ctx context.Context) FileSystemPolicyArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FileSystemPolicyArrayOutput)
}

// FileSystemPolicyMapInput is an input type that accepts FileSystemPolicyMap and FileSystemPolicyMapOutput values.
// You can construct a concrete instance of `FileSystemPolicyMapInput` via:
//
//	FileSystemPolicyMap{ "key": FileSystemPolicyArgs{...} }
type FileSystemPolicyMapInput interface {
	pulumi.Input

	ToFileSystemPolicyMapOutput() FileSystemPolicyMapOutput
	ToFileSystemPolicyMapOutputWithContext(context.Context) FileSystemPolicyMapOutput
}

type FileSystemPolicyMap map[string]FileSystemPolicyInput

func (FileSystemPolicyMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*FileSystemPolicy)(nil)).Elem()
}

func (i FileSystemPolicyMap) ToFileSystemPolicyMapOutput() FileSystemPolicyMapOutput {
	return i.ToFileSystemPolicyMapOutputWithContext(context.Background())
}

func (i FileSystemPolicyMap) ToFileSystemPolicyMapOutputWithContext(ctx context.Context) FileSystemPolicyMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FileSystemPolicyMapOutput)
}

type FileSystemPolicyOutput struct{ *pulumi.OutputState }

func (FileSystemPolicyOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**FileSystemPolicy)(nil)).Elem()
}

func (o FileSystemPolicyOutput) ToFileSystemPolicyOutput() FileSystemPolicyOutput {
	return o
}

func (o FileSystemPolicyOutput) ToFileSystemPolicyOutputWithContext(ctx context.Context) FileSystemPolicyOutput {
	return o
}

// A flag to indicate whether to bypass the `efs.FileSystemPolicy` lockout safety check. The policy lockout safety check determines whether the policy in the request will prevent the principal making the request will be locked out from making future `PutFileSystemPolicy` requests on the file system. Set `bypassPolicyLockoutSafetyCheck` to `true` only when you intend to prevent the principal that is making the request from making a subsequent `PutFileSystemPolicy` request on the file system. The default value is `false`.
func (o FileSystemPolicyOutput) BypassPolicyLockoutSafetyCheck() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *FileSystemPolicy) pulumi.BoolPtrOutput { return v.BypassPolicyLockoutSafetyCheck }).(pulumi.BoolPtrOutput)
}

// The ID of the EFS file system.
func (o FileSystemPolicyOutput) FileSystemId() pulumi.StringOutput {
	return o.ApplyT(func(v *FileSystemPolicy) pulumi.StringOutput { return v.FileSystemId }).(pulumi.StringOutput)
}

// The JSON formatted file system policy for the EFS file system. see [Docs](https://docs.aws.amazon.com/efs/latest/ug/access-control-overview.html#access-control-manage-access-intro-resource-policies) for more info.
//
// The following arguments are optional:
func (o FileSystemPolicyOutput) Policy() pulumi.StringOutput {
	return o.ApplyT(func(v *FileSystemPolicy) pulumi.StringOutput { return v.Policy }).(pulumi.StringOutput)
}

type FileSystemPolicyArrayOutput struct{ *pulumi.OutputState }

func (FileSystemPolicyArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*FileSystemPolicy)(nil)).Elem()
}

func (o FileSystemPolicyArrayOutput) ToFileSystemPolicyArrayOutput() FileSystemPolicyArrayOutput {
	return o
}

func (o FileSystemPolicyArrayOutput) ToFileSystemPolicyArrayOutputWithContext(ctx context.Context) FileSystemPolicyArrayOutput {
	return o
}

func (o FileSystemPolicyArrayOutput) Index(i pulumi.IntInput) FileSystemPolicyOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *FileSystemPolicy {
		return vs[0].([]*FileSystemPolicy)[vs[1].(int)]
	}).(FileSystemPolicyOutput)
}

type FileSystemPolicyMapOutput struct{ *pulumi.OutputState }

func (FileSystemPolicyMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*FileSystemPolicy)(nil)).Elem()
}

func (o FileSystemPolicyMapOutput) ToFileSystemPolicyMapOutput() FileSystemPolicyMapOutput {
	return o
}

func (o FileSystemPolicyMapOutput) ToFileSystemPolicyMapOutputWithContext(ctx context.Context) FileSystemPolicyMapOutput {
	return o
}

func (o FileSystemPolicyMapOutput) MapIndex(k pulumi.StringInput) FileSystemPolicyOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *FileSystemPolicy {
		return vs[0].(map[string]*FileSystemPolicy)[vs[1].(string)]
	}).(FileSystemPolicyOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*FileSystemPolicyInput)(nil)).Elem(), &FileSystemPolicy{})
	pulumi.RegisterInputType(reflect.TypeOf((*FileSystemPolicyArrayInput)(nil)).Elem(), FileSystemPolicyArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*FileSystemPolicyMapInput)(nil)).Elem(), FileSystemPolicyMap{})
	pulumi.RegisterOutputType(FileSystemPolicyOutput{})
	pulumi.RegisterOutputType(FileSystemPolicyArrayOutput{})
	pulumi.RegisterOutputType(FileSystemPolicyMapOutput{})
}
