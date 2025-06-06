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

// Provides an AWS Config Configuration Recorder. Please note that this resource **does not start** the created recorder automatically.
//
// > **Note:** _Starting_ the Configuration Recorder requires a delivery channel (while delivery channel creation requires Configuration Recorder). This is why `cfg.RecorderStatus` is a separate resource.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cfg"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
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
//			_, err = cfg.NewRecorder(ctx, "foo", &cfg.RecorderArgs{
//				Name:    pulumi.String("example"),
//				RoleArn: r.Arn,
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
// ### Exclude Resources Types Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cfg"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := cfg.NewRecorder(ctx, "foo", &cfg.RecorderArgs{
//				Name:    pulumi.String("example"),
//				RoleArn: pulumi.Any(r.Arn),
//				RecordingGroup: &cfg.RecorderRecordingGroupArgs{
//					AllSupported: pulumi.Bool(false),
//					ExclusionByResourceTypes: cfg.RecorderRecordingGroupExclusionByResourceTypeArray{
//						&cfg.RecorderRecordingGroupExclusionByResourceTypeArgs{
//							ResourceTypes: pulumi.StringArray{
//								pulumi.String("AWS::EC2::Instance"),
//							},
//						},
//					},
//					RecordingStrategies: cfg.RecorderRecordingGroupRecordingStrategyArray{
//						&cfg.RecorderRecordingGroupRecordingStrategyArgs{
//							UseOnly: pulumi.String("EXCLUSION_BY_RESOURCE_TYPES"),
//						},
//					},
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
// ### Periodic Recording
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cfg"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := cfg.NewRecorder(ctx, "foo", &cfg.RecorderArgs{
//				Name:    pulumi.String("example"),
//				RoleArn: pulumi.Any(r.Arn),
//				RecordingGroup: &cfg.RecorderRecordingGroupArgs{
//					AllSupported:               pulumi.Bool(false),
//					IncludeGlobalResourceTypes: pulumi.Bool(false),
//					ResourceTypes: pulumi.StringArray{
//						pulumi.String("AWS::EC2::Instance"),
//						pulumi.String("AWS::EC2::NetworkInterface"),
//					},
//				},
//				RecordingMode: &cfg.RecorderRecordingModeArgs{
//					RecordingFrequency: pulumi.String("CONTINUOUS"),
//					RecordingModeOverride: &cfg.RecorderRecordingModeRecordingModeOverrideArgs{
//						Description: pulumi.String("Only record EC2 network interfaces daily"),
//						ResourceTypes: pulumi.StringArray{
//							pulumi.String("AWS::EC2::NetworkInterface"),
//						},
//						RecordingFrequency: pulumi.String("DAILY"),
//					},
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
// Using `pulumi import`, import Configuration Recorder using the name. For example:
//
// ```sh
// $ pulumi import aws:cfg/recorder:Recorder foo example
// ```
type Recorder struct {
	pulumi.CustomResourceState

	// The name of the recorder. Defaults to `default`. Changing it recreates the resource.
	Name pulumi.StringOutput `pulumi:"name"`
	// Recording group - see below.
	RecordingGroup RecorderRecordingGroupOutput `pulumi:"recordingGroup"`
	// Recording mode - see below.
	RecordingMode RecorderRecordingModeOutput `pulumi:"recordingMode"`
	// Amazon Resource Name (ARN) of the IAM role. Used to make read or write requests to the delivery channel and to describe the AWS resources associated with the account. See [AWS Docs](http://docs.aws.amazon.com/config/latest/developerguide/iamrole-permissions.html) for more details.
	RoleArn pulumi.StringOutput `pulumi:"roleArn"`
}

// NewRecorder registers a new resource with the given unique name, arguments, and options.
func NewRecorder(ctx *pulumi.Context,
	name string, args *RecorderArgs, opts ...pulumi.ResourceOption) (*Recorder, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.RoleArn == nil {
		return nil, errors.New("invalid value for required argument 'RoleArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Recorder
	err := ctx.RegisterResource("aws:cfg/recorder:Recorder", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetRecorder gets an existing Recorder resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetRecorder(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *RecorderState, opts ...pulumi.ResourceOption) (*Recorder, error) {
	var resource Recorder
	err := ctx.ReadResource("aws:cfg/recorder:Recorder", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Recorder resources.
type recorderState struct {
	// The name of the recorder. Defaults to `default`. Changing it recreates the resource.
	Name *string `pulumi:"name"`
	// Recording group - see below.
	RecordingGroup *RecorderRecordingGroup `pulumi:"recordingGroup"`
	// Recording mode - see below.
	RecordingMode *RecorderRecordingMode `pulumi:"recordingMode"`
	// Amazon Resource Name (ARN) of the IAM role. Used to make read or write requests to the delivery channel and to describe the AWS resources associated with the account. See [AWS Docs](http://docs.aws.amazon.com/config/latest/developerguide/iamrole-permissions.html) for more details.
	RoleArn *string `pulumi:"roleArn"`
}

type RecorderState struct {
	// The name of the recorder. Defaults to `default`. Changing it recreates the resource.
	Name pulumi.StringPtrInput
	// Recording group - see below.
	RecordingGroup RecorderRecordingGroupPtrInput
	// Recording mode - see below.
	RecordingMode RecorderRecordingModePtrInput
	// Amazon Resource Name (ARN) of the IAM role. Used to make read or write requests to the delivery channel and to describe the AWS resources associated with the account. See [AWS Docs](http://docs.aws.amazon.com/config/latest/developerguide/iamrole-permissions.html) for more details.
	RoleArn pulumi.StringPtrInput
}

func (RecorderState) ElementType() reflect.Type {
	return reflect.TypeOf((*recorderState)(nil)).Elem()
}

type recorderArgs struct {
	// The name of the recorder. Defaults to `default`. Changing it recreates the resource.
	Name *string `pulumi:"name"`
	// Recording group - see below.
	RecordingGroup *RecorderRecordingGroup `pulumi:"recordingGroup"`
	// Recording mode - see below.
	RecordingMode *RecorderRecordingMode `pulumi:"recordingMode"`
	// Amazon Resource Name (ARN) of the IAM role. Used to make read or write requests to the delivery channel and to describe the AWS resources associated with the account. See [AWS Docs](http://docs.aws.amazon.com/config/latest/developerguide/iamrole-permissions.html) for more details.
	RoleArn string `pulumi:"roleArn"`
}

// The set of arguments for constructing a Recorder resource.
type RecorderArgs struct {
	// The name of the recorder. Defaults to `default`. Changing it recreates the resource.
	Name pulumi.StringPtrInput
	// Recording group - see below.
	RecordingGroup RecorderRecordingGroupPtrInput
	// Recording mode - see below.
	RecordingMode RecorderRecordingModePtrInput
	// Amazon Resource Name (ARN) of the IAM role. Used to make read or write requests to the delivery channel and to describe the AWS resources associated with the account. See [AWS Docs](http://docs.aws.amazon.com/config/latest/developerguide/iamrole-permissions.html) for more details.
	RoleArn pulumi.StringInput
}

func (RecorderArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*recorderArgs)(nil)).Elem()
}

type RecorderInput interface {
	pulumi.Input

	ToRecorderOutput() RecorderOutput
	ToRecorderOutputWithContext(ctx context.Context) RecorderOutput
}

func (*Recorder) ElementType() reflect.Type {
	return reflect.TypeOf((**Recorder)(nil)).Elem()
}

func (i *Recorder) ToRecorderOutput() RecorderOutput {
	return i.ToRecorderOutputWithContext(context.Background())
}

func (i *Recorder) ToRecorderOutputWithContext(ctx context.Context) RecorderOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RecorderOutput)
}

// RecorderArrayInput is an input type that accepts RecorderArray and RecorderArrayOutput values.
// You can construct a concrete instance of `RecorderArrayInput` via:
//
//	RecorderArray{ RecorderArgs{...} }
type RecorderArrayInput interface {
	pulumi.Input

	ToRecorderArrayOutput() RecorderArrayOutput
	ToRecorderArrayOutputWithContext(context.Context) RecorderArrayOutput
}

type RecorderArray []RecorderInput

func (RecorderArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Recorder)(nil)).Elem()
}

func (i RecorderArray) ToRecorderArrayOutput() RecorderArrayOutput {
	return i.ToRecorderArrayOutputWithContext(context.Background())
}

func (i RecorderArray) ToRecorderArrayOutputWithContext(ctx context.Context) RecorderArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RecorderArrayOutput)
}

// RecorderMapInput is an input type that accepts RecorderMap and RecorderMapOutput values.
// You can construct a concrete instance of `RecorderMapInput` via:
//
//	RecorderMap{ "key": RecorderArgs{...} }
type RecorderMapInput interface {
	pulumi.Input

	ToRecorderMapOutput() RecorderMapOutput
	ToRecorderMapOutputWithContext(context.Context) RecorderMapOutput
}

type RecorderMap map[string]RecorderInput

func (RecorderMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Recorder)(nil)).Elem()
}

func (i RecorderMap) ToRecorderMapOutput() RecorderMapOutput {
	return i.ToRecorderMapOutputWithContext(context.Background())
}

func (i RecorderMap) ToRecorderMapOutputWithContext(ctx context.Context) RecorderMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RecorderMapOutput)
}

type RecorderOutput struct{ *pulumi.OutputState }

func (RecorderOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Recorder)(nil)).Elem()
}

func (o RecorderOutput) ToRecorderOutput() RecorderOutput {
	return o
}

func (o RecorderOutput) ToRecorderOutputWithContext(ctx context.Context) RecorderOutput {
	return o
}

// The name of the recorder. Defaults to `default`. Changing it recreates the resource.
func (o RecorderOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Recorder) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Recording group - see below.
func (o RecorderOutput) RecordingGroup() RecorderRecordingGroupOutput {
	return o.ApplyT(func(v *Recorder) RecorderRecordingGroupOutput { return v.RecordingGroup }).(RecorderRecordingGroupOutput)
}

// Recording mode - see below.
func (o RecorderOutput) RecordingMode() RecorderRecordingModeOutput {
	return o.ApplyT(func(v *Recorder) RecorderRecordingModeOutput { return v.RecordingMode }).(RecorderRecordingModeOutput)
}

// Amazon Resource Name (ARN) of the IAM role. Used to make read or write requests to the delivery channel and to describe the AWS resources associated with the account. See [AWS Docs](http://docs.aws.amazon.com/config/latest/developerguide/iamrole-permissions.html) for more details.
func (o RecorderOutput) RoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *Recorder) pulumi.StringOutput { return v.RoleArn }).(pulumi.StringOutput)
}

type RecorderArrayOutput struct{ *pulumi.OutputState }

func (RecorderArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Recorder)(nil)).Elem()
}

func (o RecorderArrayOutput) ToRecorderArrayOutput() RecorderArrayOutput {
	return o
}

func (o RecorderArrayOutput) ToRecorderArrayOutputWithContext(ctx context.Context) RecorderArrayOutput {
	return o
}

func (o RecorderArrayOutput) Index(i pulumi.IntInput) RecorderOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Recorder {
		return vs[0].([]*Recorder)[vs[1].(int)]
	}).(RecorderOutput)
}

type RecorderMapOutput struct{ *pulumi.OutputState }

func (RecorderMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Recorder)(nil)).Elem()
}

func (o RecorderMapOutput) ToRecorderMapOutput() RecorderMapOutput {
	return o
}

func (o RecorderMapOutput) ToRecorderMapOutputWithContext(ctx context.Context) RecorderMapOutput {
	return o
}

func (o RecorderMapOutput) MapIndex(k pulumi.StringInput) RecorderOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Recorder {
		return vs[0].(map[string]*Recorder)[vs[1].(string)]
	}).(RecorderOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*RecorderInput)(nil)).Elem(), &Recorder{})
	pulumi.RegisterInputType(reflect.TypeOf((*RecorderArrayInput)(nil)).Elem(), RecorderArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*RecorderMapInput)(nil)).Elem(), RecorderMap{})
	pulumi.RegisterOutputType(RecorderOutput{})
	pulumi.RegisterOutputType(RecorderArrayOutput{})
	pulumi.RegisterOutputType(RecorderMapOutput{})
}
