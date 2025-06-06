// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package directoryservice

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a Log subscription for AWS Directory Service that pushes logs to cloudwatch.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cloudwatch"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/directoryservice"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := cloudwatch.NewLogGroup(ctx, "example", &cloudwatch.LogGroupArgs{
//				Name:            pulumi.Sprintf("/aws/directoryservice/%v", exampleAwsDirectoryServiceDirectory.Id),
//				RetentionInDays: pulumi.Int(14),
//			})
//			if err != nil {
//				return err
//			}
//			ad_log_policy := iam.GetPolicyDocumentOutput(ctx, iam.GetPolicyDocumentOutputArgs{
//				Statements: iam.GetPolicyDocumentStatementArray{
//					&iam.GetPolicyDocumentStatementArgs{
//						Actions: pulumi.StringArray{
//							pulumi.String("logs:CreateLogStream"),
//							pulumi.String("logs:PutLogEvents"),
//						},
//						Principals: iam.GetPolicyDocumentStatementPrincipalArray{
//							&iam.GetPolicyDocumentStatementPrincipalArgs{
//								Identifiers: pulumi.StringArray{
//									pulumi.String("ds.amazonaws.com"),
//								},
//								Type: pulumi.String("Service"),
//							},
//						},
//						Resources: pulumi.StringArray{
//							example.Arn.ApplyT(func(arn string) (string, error) {
//								return fmt.Sprintf("%v:*", arn), nil
//							}).(pulumi.StringOutput),
//						},
//						Effect: pulumi.String("Allow"),
//					},
//				},
//			}, nil)
//			_, err = cloudwatch.NewLogResourcePolicy(ctx, "ad-log-policy", &cloudwatch.LogResourcePolicyArgs{
//				PolicyDocument: pulumi.String(ad_log_policy.ApplyT(func(ad_log_policy iam.GetPolicyDocumentResult) (*string, error) {
//					return &ad_log_policy.Json, nil
//				}).(pulumi.StringPtrOutput)),
//				PolicyName: pulumi.String("ad-log-policy"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = directoryservice.NewLogSubscription(ctx, "example", &directoryservice.LogSubscriptionArgs{
//				DirectoryId:  pulumi.Any(exampleAwsDirectoryServiceDirectory.Id),
//				LogGroupName: example.Name,
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
// Using `pulumi import`, import Directory Service Log Subscriptions using the directory id. For example:
//
// ```sh
// $ pulumi import aws:directoryservice/logSubscription:LogSubscription msad d-1234567890
// ```
type LogSubscription struct {
	pulumi.CustomResourceState

	// ID of directory.
	DirectoryId pulumi.StringOutput `pulumi:"directoryId"`
	// Name of the cloudwatch log group to which the logs should be published. The log group should be already created and the directory service principal should be provided with required permission to create stream and publish logs. Changing this value would delete the current subscription and create a new one. A directory can only have one log subscription at a time.
	LogGroupName pulumi.StringOutput `pulumi:"logGroupName"`
}

// NewLogSubscription registers a new resource with the given unique name, arguments, and options.
func NewLogSubscription(ctx *pulumi.Context,
	name string, args *LogSubscriptionArgs, opts ...pulumi.ResourceOption) (*LogSubscription, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.DirectoryId == nil {
		return nil, errors.New("invalid value for required argument 'DirectoryId'")
	}
	if args.LogGroupName == nil {
		return nil, errors.New("invalid value for required argument 'LogGroupName'")
	}
	aliases := pulumi.Aliases([]pulumi.Alias{
		{
			Type: pulumi.String("aws:directoryservice/logService:LogService"),
		},
	})
	opts = append(opts, aliases)
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource LogSubscription
	err := ctx.RegisterResource("aws:directoryservice/logSubscription:LogSubscription", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetLogSubscription gets an existing LogSubscription resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetLogSubscription(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *LogSubscriptionState, opts ...pulumi.ResourceOption) (*LogSubscription, error) {
	var resource LogSubscription
	err := ctx.ReadResource("aws:directoryservice/logSubscription:LogSubscription", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering LogSubscription resources.
type logSubscriptionState struct {
	// ID of directory.
	DirectoryId *string `pulumi:"directoryId"`
	// Name of the cloudwatch log group to which the logs should be published. The log group should be already created and the directory service principal should be provided with required permission to create stream and publish logs. Changing this value would delete the current subscription and create a new one. A directory can only have one log subscription at a time.
	LogGroupName *string `pulumi:"logGroupName"`
}

type LogSubscriptionState struct {
	// ID of directory.
	DirectoryId pulumi.StringPtrInput
	// Name of the cloudwatch log group to which the logs should be published. The log group should be already created and the directory service principal should be provided with required permission to create stream and publish logs. Changing this value would delete the current subscription and create a new one. A directory can only have one log subscription at a time.
	LogGroupName pulumi.StringPtrInput
}

func (LogSubscriptionState) ElementType() reflect.Type {
	return reflect.TypeOf((*logSubscriptionState)(nil)).Elem()
}

type logSubscriptionArgs struct {
	// ID of directory.
	DirectoryId string `pulumi:"directoryId"`
	// Name of the cloudwatch log group to which the logs should be published. The log group should be already created and the directory service principal should be provided with required permission to create stream and publish logs. Changing this value would delete the current subscription and create a new one. A directory can only have one log subscription at a time.
	LogGroupName string `pulumi:"logGroupName"`
}

// The set of arguments for constructing a LogSubscription resource.
type LogSubscriptionArgs struct {
	// ID of directory.
	DirectoryId pulumi.StringInput
	// Name of the cloudwatch log group to which the logs should be published. The log group should be already created and the directory service principal should be provided with required permission to create stream and publish logs. Changing this value would delete the current subscription and create a new one. A directory can only have one log subscription at a time.
	LogGroupName pulumi.StringInput
}

func (LogSubscriptionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*logSubscriptionArgs)(nil)).Elem()
}

type LogSubscriptionInput interface {
	pulumi.Input

	ToLogSubscriptionOutput() LogSubscriptionOutput
	ToLogSubscriptionOutputWithContext(ctx context.Context) LogSubscriptionOutput
}

func (*LogSubscription) ElementType() reflect.Type {
	return reflect.TypeOf((**LogSubscription)(nil)).Elem()
}

func (i *LogSubscription) ToLogSubscriptionOutput() LogSubscriptionOutput {
	return i.ToLogSubscriptionOutputWithContext(context.Background())
}

func (i *LogSubscription) ToLogSubscriptionOutputWithContext(ctx context.Context) LogSubscriptionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LogSubscriptionOutput)
}

// LogSubscriptionArrayInput is an input type that accepts LogSubscriptionArray and LogSubscriptionArrayOutput values.
// You can construct a concrete instance of `LogSubscriptionArrayInput` via:
//
//	LogSubscriptionArray{ LogSubscriptionArgs{...} }
type LogSubscriptionArrayInput interface {
	pulumi.Input

	ToLogSubscriptionArrayOutput() LogSubscriptionArrayOutput
	ToLogSubscriptionArrayOutputWithContext(context.Context) LogSubscriptionArrayOutput
}

type LogSubscriptionArray []LogSubscriptionInput

func (LogSubscriptionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LogSubscription)(nil)).Elem()
}

func (i LogSubscriptionArray) ToLogSubscriptionArrayOutput() LogSubscriptionArrayOutput {
	return i.ToLogSubscriptionArrayOutputWithContext(context.Background())
}

func (i LogSubscriptionArray) ToLogSubscriptionArrayOutputWithContext(ctx context.Context) LogSubscriptionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LogSubscriptionArrayOutput)
}

// LogSubscriptionMapInput is an input type that accepts LogSubscriptionMap and LogSubscriptionMapOutput values.
// You can construct a concrete instance of `LogSubscriptionMapInput` via:
//
//	LogSubscriptionMap{ "key": LogSubscriptionArgs{...} }
type LogSubscriptionMapInput interface {
	pulumi.Input

	ToLogSubscriptionMapOutput() LogSubscriptionMapOutput
	ToLogSubscriptionMapOutputWithContext(context.Context) LogSubscriptionMapOutput
}

type LogSubscriptionMap map[string]LogSubscriptionInput

func (LogSubscriptionMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LogSubscription)(nil)).Elem()
}

func (i LogSubscriptionMap) ToLogSubscriptionMapOutput() LogSubscriptionMapOutput {
	return i.ToLogSubscriptionMapOutputWithContext(context.Background())
}

func (i LogSubscriptionMap) ToLogSubscriptionMapOutputWithContext(ctx context.Context) LogSubscriptionMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LogSubscriptionMapOutput)
}

type LogSubscriptionOutput struct{ *pulumi.OutputState }

func (LogSubscriptionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**LogSubscription)(nil)).Elem()
}

func (o LogSubscriptionOutput) ToLogSubscriptionOutput() LogSubscriptionOutput {
	return o
}

func (o LogSubscriptionOutput) ToLogSubscriptionOutputWithContext(ctx context.Context) LogSubscriptionOutput {
	return o
}

// ID of directory.
func (o LogSubscriptionOutput) DirectoryId() pulumi.StringOutput {
	return o.ApplyT(func(v *LogSubscription) pulumi.StringOutput { return v.DirectoryId }).(pulumi.StringOutput)
}

// Name of the cloudwatch log group to which the logs should be published. The log group should be already created and the directory service principal should be provided with required permission to create stream and publish logs. Changing this value would delete the current subscription and create a new one. A directory can only have one log subscription at a time.
func (o LogSubscriptionOutput) LogGroupName() pulumi.StringOutput {
	return o.ApplyT(func(v *LogSubscription) pulumi.StringOutput { return v.LogGroupName }).(pulumi.StringOutput)
}

type LogSubscriptionArrayOutput struct{ *pulumi.OutputState }

func (LogSubscriptionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LogSubscription)(nil)).Elem()
}

func (o LogSubscriptionArrayOutput) ToLogSubscriptionArrayOutput() LogSubscriptionArrayOutput {
	return o
}

func (o LogSubscriptionArrayOutput) ToLogSubscriptionArrayOutputWithContext(ctx context.Context) LogSubscriptionArrayOutput {
	return o
}

func (o LogSubscriptionArrayOutput) Index(i pulumi.IntInput) LogSubscriptionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *LogSubscription {
		return vs[0].([]*LogSubscription)[vs[1].(int)]
	}).(LogSubscriptionOutput)
}

type LogSubscriptionMapOutput struct{ *pulumi.OutputState }

func (LogSubscriptionMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LogSubscription)(nil)).Elem()
}

func (o LogSubscriptionMapOutput) ToLogSubscriptionMapOutput() LogSubscriptionMapOutput {
	return o
}

func (o LogSubscriptionMapOutput) ToLogSubscriptionMapOutputWithContext(ctx context.Context) LogSubscriptionMapOutput {
	return o
}

func (o LogSubscriptionMapOutput) MapIndex(k pulumi.StringInput) LogSubscriptionOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *LogSubscription {
		return vs[0].(map[string]*LogSubscription)[vs[1].(string)]
	}).(LogSubscriptionOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*LogSubscriptionInput)(nil)).Elem(), &LogSubscription{})
	pulumi.RegisterInputType(reflect.TypeOf((*LogSubscriptionArrayInput)(nil)).Elem(), LogSubscriptionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*LogSubscriptionMapInput)(nil)).Elem(), LogSubscriptionMap{})
	pulumi.RegisterOutputType(LogSubscriptionOutput{})
	pulumi.RegisterOutputType(LogSubscriptionArrayOutput{})
	pulumi.RegisterOutputType(LogSubscriptionMapOutput{})
}
