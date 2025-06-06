// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package cfg

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an AWS Config Delivery Channel.
//
// > **Note:** Delivery Channel requires a Configuration Recorder to be present. Use of `dependsOn` (as shown below) is recommended to avoid race conditions.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cfg"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/s3"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			b, err := s3.NewBucketV2(ctx, "b", &s3.BucketV2Args{
//				Bucket:       pulumi.String("example-awsconfig"),
//				ForceDestroy: pulumi.Bool(true),
//			})
//			if err != nil {
//				return err
//			}
//			assumeRole, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Effect: pulumi.StringRef("Allow"),
//						Principals: []iam.GetPolicyDocumentStatementPrincipal{
//							{
//								Type: "Service",
//								Identifiers: []string{
//									"config.amazonaws.com",
//								},
//							},
//						},
//						Actions: []string{
//							"sts:AssumeRole",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			r, err := iam.NewRole(ctx, "r", &iam.RoleArgs{
//				Name:             pulumi.String("awsconfig-example"),
//				AssumeRolePolicy: pulumi.String(assumeRole.Json),
//			})
//			if err != nil {
//				return err
//			}
//			fooRecorder, err := cfg.NewRecorder(ctx, "foo", &cfg.RecorderArgs{
//				Name:    pulumi.String("example"),
//				RoleArn: r.Arn,
//			})
//			if err != nil {
//				return err
//			}
//			_, err = cfg.NewDeliveryChannel(ctx, "foo", &cfg.DeliveryChannelArgs{
//				Name:         pulumi.String("example"),
//				S3BucketName: b.Bucket,
//			}, pulumi.DependsOn([]pulumi.Resource{
//				fooRecorder,
//			}))
//			if err != nil {
//				return err
//			}
//			p := iam.GetPolicyDocumentOutput(ctx, iam.GetPolicyDocumentOutputArgs{
//				Statements: iam.GetPolicyDocumentStatementArray{
//					&iam.GetPolicyDocumentStatementArgs{
//						Effect: pulumi.String("Allow"),
//						Actions: pulumi.StringArray{
//							pulumi.String("s3:*"),
//						},
//						Resources: pulumi.StringArray{
//							b.Arn,
//							b.Arn.ApplyT(func(arn string) (string, error) {
//								return fmt.Sprintf("%v/*", arn), nil
//							}).(pulumi.StringOutput),
//						},
//					},
//				},
//			}, nil)
//			_, err = iam.NewRolePolicy(ctx, "p", &iam.RolePolicyArgs{
//				Name: pulumi.String("awsconfig-example"),
//				Role: r.ID(),
//				Policy: pulumi.String(p.ApplyT(func(p iam.GetPolicyDocumentResult) (*string, error) {
//					return &p.Json, nil
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
// Using `pulumi import`, import Delivery Channel using the name. For example:
//
// ```sh
// $ pulumi import aws:cfg/deliveryChannel:DeliveryChannel foo example
// ```
type DeliveryChannel struct {
	pulumi.CustomResourceState

	// The name of the delivery channel. Defaults to `default`. Changing it recreates the resource.
	Name pulumi.StringOutput `pulumi:"name"`
	// The name of the S3 bucket used to store the configuration history.
	S3BucketName pulumi.StringOutput `pulumi:"s3BucketName"`
	// The prefix for the specified S3 bucket.
	S3KeyPrefix pulumi.StringPtrOutput `pulumi:"s3KeyPrefix"`
	// The ARN of the AWS KMS key used to encrypt objects delivered by AWS Config. Must belong to the same Region as the destination S3 bucket.
	S3KmsKeyArn pulumi.StringPtrOutput `pulumi:"s3KmsKeyArn"`
	// Options for how AWS Config delivers configuration snapshots. See below
	SnapshotDeliveryProperties DeliveryChannelSnapshotDeliveryPropertiesPtrOutput `pulumi:"snapshotDeliveryProperties"`
	// The ARN of the SNS topic that AWS Config delivers notifications to.
	SnsTopicArn pulumi.StringPtrOutput `pulumi:"snsTopicArn"`
}

// NewDeliveryChannel registers a new resource with the given unique name, arguments, and options.
func NewDeliveryChannel(ctx *pulumi.Context,
	name string, args *DeliveryChannelArgs, opts ...pulumi.ResourceOption) (*DeliveryChannel, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.S3BucketName == nil {
		return nil, errors.New("invalid value for required argument 'S3BucketName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource DeliveryChannel
	err := ctx.RegisterResource("aws:cfg/deliveryChannel:DeliveryChannel", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetDeliveryChannel gets an existing DeliveryChannel resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetDeliveryChannel(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *DeliveryChannelState, opts ...pulumi.ResourceOption) (*DeliveryChannel, error) {
	var resource DeliveryChannel
	err := ctx.ReadResource("aws:cfg/deliveryChannel:DeliveryChannel", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering DeliveryChannel resources.
type deliveryChannelState struct {
	// The name of the delivery channel. Defaults to `default`. Changing it recreates the resource.
	Name *string `pulumi:"name"`
	// The name of the S3 bucket used to store the configuration history.
	S3BucketName *string `pulumi:"s3BucketName"`
	// The prefix for the specified S3 bucket.
	S3KeyPrefix *string `pulumi:"s3KeyPrefix"`
	// The ARN of the AWS KMS key used to encrypt objects delivered by AWS Config. Must belong to the same Region as the destination S3 bucket.
	S3KmsKeyArn *string `pulumi:"s3KmsKeyArn"`
	// Options for how AWS Config delivers configuration snapshots. See below
	SnapshotDeliveryProperties *DeliveryChannelSnapshotDeliveryProperties `pulumi:"snapshotDeliveryProperties"`
	// The ARN of the SNS topic that AWS Config delivers notifications to.
	SnsTopicArn *string `pulumi:"snsTopicArn"`
}

type DeliveryChannelState struct {
	// The name of the delivery channel. Defaults to `default`. Changing it recreates the resource.
	Name pulumi.StringPtrInput
	// The name of the S3 bucket used to store the configuration history.
	S3BucketName pulumi.StringPtrInput
	// The prefix for the specified S3 bucket.
	S3KeyPrefix pulumi.StringPtrInput
	// The ARN of the AWS KMS key used to encrypt objects delivered by AWS Config. Must belong to the same Region as the destination S3 bucket.
	S3KmsKeyArn pulumi.StringPtrInput
	// Options for how AWS Config delivers configuration snapshots. See below
	SnapshotDeliveryProperties DeliveryChannelSnapshotDeliveryPropertiesPtrInput
	// The ARN of the SNS topic that AWS Config delivers notifications to.
	SnsTopicArn pulumi.StringPtrInput
}

func (DeliveryChannelState) ElementType() reflect.Type {
	return reflect.TypeOf((*deliveryChannelState)(nil)).Elem()
}

type deliveryChannelArgs struct {
	// The name of the delivery channel. Defaults to `default`. Changing it recreates the resource.
	Name *string `pulumi:"name"`
	// The name of the S3 bucket used to store the configuration history.
	S3BucketName string `pulumi:"s3BucketName"`
	// The prefix for the specified S3 bucket.
	S3KeyPrefix *string `pulumi:"s3KeyPrefix"`
	// The ARN of the AWS KMS key used to encrypt objects delivered by AWS Config. Must belong to the same Region as the destination S3 bucket.
	S3KmsKeyArn *string `pulumi:"s3KmsKeyArn"`
	// Options for how AWS Config delivers configuration snapshots. See below
	SnapshotDeliveryProperties *DeliveryChannelSnapshotDeliveryProperties `pulumi:"snapshotDeliveryProperties"`
	// The ARN of the SNS topic that AWS Config delivers notifications to.
	SnsTopicArn *string `pulumi:"snsTopicArn"`
}

// The set of arguments for constructing a DeliveryChannel resource.
type DeliveryChannelArgs struct {
	// The name of the delivery channel. Defaults to `default`. Changing it recreates the resource.
	Name pulumi.StringPtrInput
	// The name of the S3 bucket used to store the configuration history.
	S3BucketName pulumi.StringInput
	// The prefix for the specified S3 bucket.
	S3KeyPrefix pulumi.StringPtrInput
	// The ARN of the AWS KMS key used to encrypt objects delivered by AWS Config. Must belong to the same Region as the destination S3 bucket.
	S3KmsKeyArn pulumi.StringPtrInput
	// Options for how AWS Config delivers configuration snapshots. See below
	SnapshotDeliveryProperties DeliveryChannelSnapshotDeliveryPropertiesPtrInput
	// The ARN of the SNS topic that AWS Config delivers notifications to.
	SnsTopicArn pulumi.StringPtrInput
}

func (DeliveryChannelArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*deliveryChannelArgs)(nil)).Elem()
}

type DeliveryChannelInput interface {
	pulumi.Input

	ToDeliveryChannelOutput() DeliveryChannelOutput
	ToDeliveryChannelOutputWithContext(ctx context.Context) DeliveryChannelOutput
}

func (*DeliveryChannel) ElementType() reflect.Type {
	return reflect.TypeOf((**DeliveryChannel)(nil)).Elem()
}

func (i *DeliveryChannel) ToDeliveryChannelOutput() DeliveryChannelOutput {
	return i.ToDeliveryChannelOutputWithContext(context.Background())
}

func (i *DeliveryChannel) ToDeliveryChannelOutputWithContext(ctx context.Context) DeliveryChannelOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DeliveryChannelOutput)
}

// DeliveryChannelArrayInput is an input type that accepts DeliveryChannelArray and DeliveryChannelArrayOutput values.
// You can construct a concrete instance of `DeliveryChannelArrayInput` via:
//
//	DeliveryChannelArray{ DeliveryChannelArgs{...} }
type DeliveryChannelArrayInput interface {
	pulumi.Input

	ToDeliveryChannelArrayOutput() DeliveryChannelArrayOutput
	ToDeliveryChannelArrayOutputWithContext(context.Context) DeliveryChannelArrayOutput
}

type DeliveryChannelArray []DeliveryChannelInput

func (DeliveryChannelArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DeliveryChannel)(nil)).Elem()
}

func (i DeliveryChannelArray) ToDeliveryChannelArrayOutput() DeliveryChannelArrayOutput {
	return i.ToDeliveryChannelArrayOutputWithContext(context.Background())
}

func (i DeliveryChannelArray) ToDeliveryChannelArrayOutputWithContext(ctx context.Context) DeliveryChannelArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DeliveryChannelArrayOutput)
}

// DeliveryChannelMapInput is an input type that accepts DeliveryChannelMap and DeliveryChannelMapOutput values.
// You can construct a concrete instance of `DeliveryChannelMapInput` via:
//
//	DeliveryChannelMap{ "key": DeliveryChannelArgs{...} }
type DeliveryChannelMapInput interface {
	pulumi.Input

	ToDeliveryChannelMapOutput() DeliveryChannelMapOutput
	ToDeliveryChannelMapOutputWithContext(context.Context) DeliveryChannelMapOutput
}

type DeliveryChannelMap map[string]DeliveryChannelInput

func (DeliveryChannelMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DeliveryChannel)(nil)).Elem()
}

func (i DeliveryChannelMap) ToDeliveryChannelMapOutput() DeliveryChannelMapOutput {
	return i.ToDeliveryChannelMapOutputWithContext(context.Background())
}

func (i DeliveryChannelMap) ToDeliveryChannelMapOutputWithContext(ctx context.Context) DeliveryChannelMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DeliveryChannelMapOutput)
}

type DeliveryChannelOutput struct{ *pulumi.OutputState }

func (DeliveryChannelOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**DeliveryChannel)(nil)).Elem()
}

func (o DeliveryChannelOutput) ToDeliveryChannelOutput() DeliveryChannelOutput {
	return o
}

func (o DeliveryChannelOutput) ToDeliveryChannelOutputWithContext(ctx context.Context) DeliveryChannelOutput {
	return o
}

// The name of the delivery channel. Defaults to `default`. Changing it recreates the resource.
func (o DeliveryChannelOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *DeliveryChannel) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The name of the S3 bucket used to store the configuration history.
func (o DeliveryChannelOutput) S3BucketName() pulumi.StringOutput {
	return o.ApplyT(func(v *DeliveryChannel) pulumi.StringOutput { return v.S3BucketName }).(pulumi.StringOutput)
}

// The prefix for the specified S3 bucket.
func (o DeliveryChannelOutput) S3KeyPrefix() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *DeliveryChannel) pulumi.StringPtrOutput { return v.S3KeyPrefix }).(pulumi.StringPtrOutput)
}

// The ARN of the AWS KMS key used to encrypt objects delivered by AWS Config. Must belong to the same Region as the destination S3 bucket.
func (o DeliveryChannelOutput) S3KmsKeyArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *DeliveryChannel) pulumi.StringPtrOutput { return v.S3KmsKeyArn }).(pulumi.StringPtrOutput)
}

// Options for how AWS Config delivers configuration snapshots. See below
func (o DeliveryChannelOutput) SnapshotDeliveryProperties() DeliveryChannelSnapshotDeliveryPropertiesPtrOutput {
	return o.ApplyT(func(v *DeliveryChannel) DeliveryChannelSnapshotDeliveryPropertiesPtrOutput {
		return v.SnapshotDeliveryProperties
	}).(DeliveryChannelSnapshotDeliveryPropertiesPtrOutput)
}

// The ARN of the SNS topic that AWS Config delivers notifications to.
func (o DeliveryChannelOutput) SnsTopicArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *DeliveryChannel) pulumi.StringPtrOutput { return v.SnsTopicArn }).(pulumi.StringPtrOutput)
}

type DeliveryChannelArrayOutput struct{ *pulumi.OutputState }

func (DeliveryChannelArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DeliveryChannel)(nil)).Elem()
}

func (o DeliveryChannelArrayOutput) ToDeliveryChannelArrayOutput() DeliveryChannelArrayOutput {
	return o
}

func (o DeliveryChannelArrayOutput) ToDeliveryChannelArrayOutputWithContext(ctx context.Context) DeliveryChannelArrayOutput {
	return o
}

func (o DeliveryChannelArrayOutput) Index(i pulumi.IntInput) DeliveryChannelOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *DeliveryChannel {
		return vs[0].([]*DeliveryChannel)[vs[1].(int)]
	}).(DeliveryChannelOutput)
}

type DeliveryChannelMapOutput struct{ *pulumi.OutputState }

func (DeliveryChannelMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DeliveryChannel)(nil)).Elem()
}

func (o DeliveryChannelMapOutput) ToDeliveryChannelMapOutput() DeliveryChannelMapOutput {
	return o
}

func (o DeliveryChannelMapOutput) ToDeliveryChannelMapOutputWithContext(ctx context.Context) DeliveryChannelMapOutput {
	return o
}

func (o DeliveryChannelMapOutput) MapIndex(k pulumi.StringInput) DeliveryChannelOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *DeliveryChannel {
		return vs[0].(map[string]*DeliveryChannel)[vs[1].(string)]
	}).(DeliveryChannelOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*DeliveryChannelInput)(nil)).Elem(), &DeliveryChannel{})
	pulumi.RegisterInputType(reflect.TypeOf((*DeliveryChannelArrayInput)(nil)).Elem(), DeliveryChannelArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*DeliveryChannelMapInput)(nil)).Elem(), DeliveryChannelMap{})
	pulumi.RegisterOutputType(DeliveryChannelOutput{})
	pulumi.RegisterOutputType(DeliveryChannelArrayOutput{})
	pulumi.RegisterOutputType(DeliveryChannelMapOutput{})
}
