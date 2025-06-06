// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package datasync

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages an AWS DataSync EFS Location.
//
// > **NOTE:** The EFS File System must have a mounted EFS Mount Target before creating this resource.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/datasync"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := datasync.NewEfsLocation(ctx, "example", &datasync.EfsLocationArgs{
//				EfsFileSystemArn: pulumi.Any(exampleAwsEfsMountTarget.FileSystemArn),
//				Ec2Config: &datasync.EfsLocationEc2ConfigArgs{
//					SecurityGroupArns: pulumi.StringArray{
//						exampleAwsSecurityGroup.Arn,
//					},
//					SubnetArn: pulumi.Any(exampleAwsSubnet.Arn),
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
// Using `pulumi import`, import `aws_datasync_location_efs` using the DataSync Task Amazon Resource Name (ARN). For example:
//
// ```sh
// $ pulumi import aws:datasync/efsLocation:EfsLocation example arn:aws:datasync:us-east-1:123456789012:location/loc-12345678901234567
// ```
type EfsLocation struct {
	pulumi.CustomResourceState

	// Specifies the Amazon Resource Name (ARN) of the access point that DataSync uses to access the Amazon EFS file system.
	AccessPointArn pulumi.StringPtrOutput `pulumi:"accessPointArn"`
	// Amazon Resource Name (ARN) of the DataSync Location.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Configuration block containing EC2 configurations for connecting to the EFS File System.
	Ec2Config EfsLocationEc2ConfigOutput `pulumi:"ec2Config"`
	// Amazon Resource Name (ARN) of EFS File System.
	EfsFileSystemArn pulumi.StringOutput `pulumi:"efsFileSystemArn"`
	// Specifies an Identity and Access Management (IAM) role that DataSync assumes when mounting the Amazon EFS file system.
	FileSystemAccessRoleArn pulumi.StringPtrOutput `pulumi:"fileSystemAccessRoleArn"`
	// Specifies whether you want DataSync to use TLS encryption when transferring data to or from your Amazon EFS file system. Valid values are `NONE` and `TLS1_2`.
	InTransitEncryption pulumi.StringPtrOutput `pulumi:"inTransitEncryption"`
	// Subdirectory to perform actions as source or destination. Default `/`.
	Subdirectory pulumi.StringPtrOutput `pulumi:"subdirectory"`
	// Key-value pairs of resource tags to assign to the DataSync Location. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	Uri     pulumi.StringOutput    `pulumi:"uri"`
}

// NewEfsLocation registers a new resource with the given unique name, arguments, and options.
func NewEfsLocation(ctx *pulumi.Context,
	name string, args *EfsLocationArgs, opts ...pulumi.ResourceOption) (*EfsLocation, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Ec2Config == nil {
		return nil, errors.New("invalid value for required argument 'Ec2Config'")
	}
	if args.EfsFileSystemArn == nil {
		return nil, errors.New("invalid value for required argument 'EfsFileSystemArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource EfsLocation
	err := ctx.RegisterResource("aws:datasync/efsLocation:EfsLocation", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetEfsLocation gets an existing EfsLocation resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetEfsLocation(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *EfsLocationState, opts ...pulumi.ResourceOption) (*EfsLocation, error) {
	var resource EfsLocation
	err := ctx.ReadResource("aws:datasync/efsLocation:EfsLocation", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering EfsLocation resources.
type efsLocationState struct {
	// Specifies the Amazon Resource Name (ARN) of the access point that DataSync uses to access the Amazon EFS file system.
	AccessPointArn *string `pulumi:"accessPointArn"`
	// Amazon Resource Name (ARN) of the DataSync Location.
	Arn *string `pulumi:"arn"`
	// Configuration block containing EC2 configurations for connecting to the EFS File System.
	Ec2Config *EfsLocationEc2Config `pulumi:"ec2Config"`
	// Amazon Resource Name (ARN) of EFS File System.
	EfsFileSystemArn *string `pulumi:"efsFileSystemArn"`
	// Specifies an Identity and Access Management (IAM) role that DataSync assumes when mounting the Amazon EFS file system.
	FileSystemAccessRoleArn *string `pulumi:"fileSystemAccessRoleArn"`
	// Specifies whether you want DataSync to use TLS encryption when transferring data to or from your Amazon EFS file system. Valid values are `NONE` and `TLS1_2`.
	InTransitEncryption *string `pulumi:"inTransitEncryption"`
	// Subdirectory to perform actions as source or destination. Default `/`.
	Subdirectory *string `pulumi:"subdirectory"`
	// Key-value pairs of resource tags to assign to the DataSync Location. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	Uri     *string           `pulumi:"uri"`
}

type EfsLocationState struct {
	// Specifies the Amazon Resource Name (ARN) of the access point that DataSync uses to access the Amazon EFS file system.
	AccessPointArn pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the DataSync Location.
	Arn pulumi.StringPtrInput
	// Configuration block containing EC2 configurations for connecting to the EFS File System.
	Ec2Config EfsLocationEc2ConfigPtrInput
	// Amazon Resource Name (ARN) of EFS File System.
	EfsFileSystemArn pulumi.StringPtrInput
	// Specifies an Identity and Access Management (IAM) role that DataSync assumes when mounting the Amazon EFS file system.
	FileSystemAccessRoleArn pulumi.StringPtrInput
	// Specifies whether you want DataSync to use TLS encryption when transferring data to or from your Amazon EFS file system. Valid values are `NONE` and `TLS1_2`.
	InTransitEncryption pulumi.StringPtrInput
	// Subdirectory to perform actions as source or destination. Default `/`.
	Subdirectory pulumi.StringPtrInput
	// Key-value pairs of resource tags to assign to the DataSync Location. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	Uri     pulumi.StringPtrInput
}

func (EfsLocationState) ElementType() reflect.Type {
	return reflect.TypeOf((*efsLocationState)(nil)).Elem()
}

type efsLocationArgs struct {
	// Specifies the Amazon Resource Name (ARN) of the access point that DataSync uses to access the Amazon EFS file system.
	AccessPointArn *string `pulumi:"accessPointArn"`
	// Configuration block containing EC2 configurations for connecting to the EFS File System.
	Ec2Config EfsLocationEc2Config `pulumi:"ec2Config"`
	// Amazon Resource Name (ARN) of EFS File System.
	EfsFileSystemArn string `pulumi:"efsFileSystemArn"`
	// Specifies an Identity and Access Management (IAM) role that DataSync assumes when mounting the Amazon EFS file system.
	FileSystemAccessRoleArn *string `pulumi:"fileSystemAccessRoleArn"`
	// Specifies whether you want DataSync to use TLS encryption when transferring data to or from your Amazon EFS file system. Valid values are `NONE` and `TLS1_2`.
	InTransitEncryption *string `pulumi:"inTransitEncryption"`
	// Subdirectory to perform actions as source or destination. Default `/`.
	Subdirectory *string `pulumi:"subdirectory"`
	// Key-value pairs of resource tags to assign to the DataSync Location. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a EfsLocation resource.
type EfsLocationArgs struct {
	// Specifies the Amazon Resource Name (ARN) of the access point that DataSync uses to access the Amazon EFS file system.
	AccessPointArn pulumi.StringPtrInput
	// Configuration block containing EC2 configurations for connecting to the EFS File System.
	Ec2Config EfsLocationEc2ConfigInput
	// Amazon Resource Name (ARN) of EFS File System.
	EfsFileSystemArn pulumi.StringInput
	// Specifies an Identity and Access Management (IAM) role that DataSync assumes when mounting the Amazon EFS file system.
	FileSystemAccessRoleArn pulumi.StringPtrInput
	// Specifies whether you want DataSync to use TLS encryption when transferring data to or from your Amazon EFS file system. Valid values are `NONE` and `TLS1_2`.
	InTransitEncryption pulumi.StringPtrInput
	// Subdirectory to perform actions as source or destination. Default `/`.
	Subdirectory pulumi.StringPtrInput
	// Key-value pairs of resource tags to assign to the DataSync Location. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (EfsLocationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*efsLocationArgs)(nil)).Elem()
}

type EfsLocationInput interface {
	pulumi.Input

	ToEfsLocationOutput() EfsLocationOutput
	ToEfsLocationOutputWithContext(ctx context.Context) EfsLocationOutput
}

func (*EfsLocation) ElementType() reflect.Type {
	return reflect.TypeOf((**EfsLocation)(nil)).Elem()
}

func (i *EfsLocation) ToEfsLocationOutput() EfsLocationOutput {
	return i.ToEfsLocationOutputWithContext(context.Background())
}

func (i *EfsLocation) ToEfsLocationOutputWithContext(ctx context.Context) EfsLocationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(EfsLocationOutput)
}

// EfsLocationArrayInput is an input type that accepts EfsLocationArray and EfsLocationArrayOutput values.
// You can construct a concrete instance of `EfsLocationArrayInput` via:
//
//	EfsLocationArray{ EfsLocationArgs{...} }
type EfsLocationArrayInput interface {
	pulumi.Input

	ToEfsLocationArrayOutput() EfsLocationArrayOutput
	ToEfsLocationArrayOutputWithContext(context.Context) EfsLocationArrayOutput
}

type EfsLocationArray []EfsLocationInput

func (EfsLocationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*EfsLocation)(nil)).Elem()
}

func (i EfsLocationArray) ToEfsLocationArrayOutput() EfsLocationArrayOutput {
	return i.ToEfsLocationArrayOutputWithContext(context.Background())
}

func (i EfsLocationArray) ToEfsLocationArrayOutputWithContext(ctx context.Context) EfsLocationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(EfsLocationArrayOutput)
}

// EfsLocationMapInput is an input type that accepts EfsLocationMap and EfsLocationMapOutput values.
// You can construct a concrete instance of `EfsLocationMapInput` via:
//
//	EfsLocationMap{ "key": EfsLocationArgs{...} }
type EfsLocationMapInput interface {
	pulumi.Input

	ToEfsLocationMapOutput() EfsLocationMapOutput
	ToEfsLocationMapOutputWithContext(context.Context) EfsLocationMapOutput
}

type EfsLocationMap map[string]EfsLocationInput

func (EfsLocationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*EfsLocation)(nil)).Elem()
}

func (i EfsLocationMap) ToEfsLocationMapOutput() EfsLocationMapOutput {
	return i.ToEfsLocationMapOutputWithContext(context.Background())
}

func (i EfsLocationMap) ToEfsLocationMapOutputWithContext(ctx context.Context) EfsLocationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(EfsLocationMapOutput)
}

type EfsLocationOutput struct{ *pulumi.OutputState }

func (EfsLocationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**EfsLocation)(nil)).Elem()
}

func (o EfsLocationOutput) ToEfsLocationOutput() EfsLocationOutput {
	return o
}

func (o EfsLocationOutput) ToEfsLocationOutputWithContext(ctx context.Context) EfsLocationOutput {
	return o
}

// Specifies the Amazon Resource Name (ARN) of the access point that DataSync uses to access the Amazon EFS file system.
func (o EfsLocationOutput) AccessPointArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *EfsLocation) pulumi.StringPtrOutput { return v.AccessPointArn }).(pulumi.StringPtrOutput)
}

// Amazon Resource Name (ARN) of the DataSync Location.
func (o EfsLocationOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *EfsLocation) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Configuration block containing EC2 configurations for connecting to the EFS File System.
func (o EfsLocationOutput) Ec2Config() EfsLocationEc2ConfigOutput {
	return o.ApplyT(func(v *EfsLocation) EfsLocationEc2ConfigOutput { return v.Ec2Config }).(EfsLocationEc2ConfigOutput)
}

// Amazon Resource Name (ARN) of EFS File System.
func (o EfsLocationOutput) EfsFileSystemArn() pulumi.StringOutput {
	return o.ApplyT(func(v *EfsLocation) pulumi.StringOutput { return v.EfsFileSystemArn }).(pulumi.StringOutput)
}

// Specifies an Identity and Access Management (IAM) role that DataSync assumes when mounting the Amazon EFS file system.
func (o EfsLocationOutput) FileSystemAccessRoleArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *EfsLocation) pulumi.StringPtrOutput { return v.FileSystemAccessRoleArn }).(pulumi.StringPtrOutput)
}

// Specifies whether you want DataSync to use TLS encryption when transferring data to or from your Amazon EFS file system. Valid values are `NONE` and `TLS1_2`.
func (o EfsLocationOutput) InTransitEncryption() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *EfsLocation) pulumi.StringPtrOutput { return v.InTransitEncryption }).(pulumi.StringPtrOutput)
}

// Subdirectory to perform actions as source or destination. Default `/`.
func (o EfsLocationOutput) Subdirectory() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *EfsLocation) pulumi.StringPtrOutput { return v.Subdirectory }).(pulumi.StringPtrOutput)
}

// Key-value pairs of resource tags to assign to the DataSync Location. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o EfsLocationOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *EfsLocation) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o EfsLocationOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *EfsLocation) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o EfsLocationOutput) Uri() pulumi.StringOutput {
	return o.ApplyT(func(v *EfsLocation) pulumi.StringOutput { return v.Uri }).(pulumi.StringOutput)
}

type EfsLocationArrayOutput struct{ *pulumi.OutputState }

func (EfsLocationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*EfsLocation)(nil)).Elem()
}

func (o EfsLocationArrayOutput) ToEfsLocationArrayOutput() EfsLocationArrayOutput {
	return o
}

func (o EfsLocationArrayOutput) ToEfsLocationArrayOutputWithContext(ctx context.Context) EfsLocationArrayOutput {
	return o
}

func (o EfsLocationArrayOutput) Index(i pulumi.IntInput) EfsLocationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *EfsLocation {
		return vs[0].([]*EfsLocation)[vs[1].(int)]
	}).(EfsLocationOutput)
}

type EfsLocationMapOutput struct{ *pulumi.OutputState }

func (EfsLocationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*EfsLocation)(nil)).Elem()
}

func (o EfsLocationMapOutput) ToEfsLocationMapOutput() EfsLocationMapOutput {
	return o
}

func (o EfsLocationMapOutput) ToEfsLocationMapOutputWithContext(ctx context.Context) EfsLocationMapOutput {
	return o
}

func (o EfsLocationMapOutput) MapIndex(k pulumi.StringInput) EfsLocationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *EfsLocation {
		return vs[0].(map[string]*EfsLocation)[vs[1].(string)]
	}).(EfsLocationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*EfsLocationInput)(nil)).Elem(), &EfsLocation{})
	pulumi.RegisterInputType(reflect.TypeOf((*EfsLocationArrayInput)(nil)).Elem(), EfsLocationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*EfsLocationMapInput)(nil)).Elem(), EfsLocationMap{})
	pulumi.RegisterOutputType(EfsLocationOutput{})
	pulumi.RegisterOutputType(EfsLocationArrayOutput{})
	pulumi.RegisterOutputType(EfsLocationMapOutput{})
}
