// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ssm

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an SSM Maintenance Window Task resource
//
// ## Example Usage
//
// ### Automation Tasks
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ssm"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ssm.NewMaintenanceWindowTask(ctx, "example", &ssm.MaintenanceWindowTaskArgs{
//				MaxConcurrency: pulumi.String("2"),
//				MaxErrors:      pulumi.String("1"),
//				Priority:       pulumi.Int(1),
//				TaskArn:        pulumi.String("AWS-RestartEC2Instance"),
//				TaskType:       pulumi.String("AUTOMATION"),
//				WindowId:       pulumi.Any(exampleAwsSsmMaintenanceWindow.Id),
//				Targets: ssm.MaintenanceWindowTaskTargetArray{
//					&ssm.MaintenanceWindowTaskTargetArgs{
//						Key: pulumi.String("InstanceIds"),
//						Values: pulumi.StringArray{
//							exampleAwsInstance.Id,
//						},
//					},
//				},
//				TaskInvocationParameters: &ssm.MaintenanceWindowTaskTaskInvocationParametersArgs{
//					AutomationParameters: &ssm.MaintenanceWindowTaskTaskInvocationParametersAutomationParametersArgs{
//						DocumentVersion: pulumi.String("$LATEST"),
//						Parameters: ssm.MaintenanceWindowTaskTaskInvocationParametersAutomationParametersParameterArray{
//							&ssm.MaintenanceWindowTaskTaskInvocationParametersAutomationParametersParameterArgs{
//								Name: pulumi.String("InstanceId"),
//								Values: pulumi.StringArray{
//									exampleAwsInstance.Id,
//								},
//							},
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
// ### Lambda Tasks
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ssm"
//	"github.com/pulumi/pulumi-std/sdk/go/std"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			invokeBase64encode, err := std.Base64encode(ctx, &std.Base64encodeArgs{
//				Input: "{\"key1\":\"value1\"}",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = ssm.NewMaintenanceWindowTask(ctx, "example", &ssm.MaintenanceWindowTaskArgs{
//				MaxConcurrency: pulumi.String("2"),
//				MaxErrors:      pulumi.String("1"),
//				Priority:       pulumi.Int(1),
//				TaskArn:        pulumi.Any(exampleAwsLambdaFunction.Arn),
//				TaskType:       pulumi.String("LAMBDA"),
//				WindowId:       pulumi.Any(exampleAwsSsmMaintenanceWindow.Id),
//				Targets: ssm.MaintenanceWindowTaskTargetArray{
//					&ssm.MaintenanceWindowTaskTargetArgs{
//						Key: pulumi.String("InstanceIds"),
//						Values: pulumi.StringArray{
//							exampleAwsInstance.Id,
//						},
//					},
//				},
//				TaskInvocationParameters: &ssm.MaintenanceWindowTaskTaskInvocationParametersArgs{
//					LambdaParameters: &ssm.MaintenanceWindowTaskTaskInvocationParametersLambdaParametersArgs{
//						ClientContext: pulumi.String(invokeBase64encode.Result),
//						Payload:       pulumi.String("{\"key1\":\"value1\"}"),
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
// ### Run Command Tasks
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ssm"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ssm.NewMaintenanceWindowTask(ctx, "example", &ssm.MaintenanceWindowTaskArgs{
//				MaxConcurrency: pulumi.String("2"),
//				MaxErrors:      pulumi.String("1"),
//				Priority:       pulumi.Int(1),
//				TaskArn:        pulumi.String("AWS-RunShellScript"),
//				TaskType:       pulumi.String("RUN_COMMAND"),
//				WindowId:       pulumi.Any(exampleAwsSsmMaintenanceWindow.Id),
//				Targets: ssm.MaintenanceWindowTaskTargetArray{
//					&ssm.MaintenanceWindowTaskTargetArgs{
//						Key: pulumi.String("InstanceIds"),
//						Values: pulumi.StringArray{
//							exampleAwsInstance.Id,
//						},
//					},
//				},
//				TaskInvocationParameters: &ssm.MaintenanceWindowTaskTaskInvocationParametersArgs{
//					RunCommandParameters: &ssm.MaintenanceWindowTaskTaskInvocationParametersRunCommandParametersArgs{
//						OutputS3Bucket:    pulumi.Any(exampleAwsS3Bucket.Id),
//						OutputS3KeyPrefix: pulumi.String("output"),
//						ServiceRoleArn:    pulumi.Any(exampleAwsIamRole.Arn),
//						TimeoutSeconds:    pulumi.Int(600),
//						NotificationConfig: &ssm.MaintenanceWindowTaskTaskInvocationParametersRunCommandParametersNotificationConfigArgs{
//							NotificationArn: pulumi.Any(exampleAwsSnsTopic.Arn),
//							NotificationEvents: pulumi.StringArray{
//								pulumi.String("All"),
//							},
//							NotificationType: pulumi.String("Command"),
//						},
//						Parameters: ssm.MaintenanceWindowTaskTaskInvocationParametersRunCommandParametersParameterArray{
//							&ssm.MaintenanceWindowTaskTaskInvocationParametersRunCommandParametersParameterArgs{
//								Name: pulumi.String("commands"),
//								Values: pulumi.StringArray{
//									pulumi.String("date"),
//								},
//							},
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
// ### Step Function Tasks
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ssm"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ssm.NewMaintenanceWindowTask(ctx, "example", &ssm.MaintenanceWindowTaskArgs{
//				MaxConcurrency: pulumi.String("2"),
//				MaxErrors:      pulumi.String("1"),
//				Priority:       pulumi.Int(1),
//				TaskArn:        pulumi.Any(exampleAwsSfnActivity.Id),
//				TaskType:       pulumi.String("STEP_FUNCTIONS"),
//				WindowId:       pulumi.Any(exampleAwsSsmMaintenanceWindow.Id),
//				Targets: ssm.MaintenanceWindowTaskTargetArray{
//					&ssm.MaintenanceWindowTaskTargetArgs{
//						Key: pulumi.String("InstanceIds"),
//						Values: pulumi.StringArray{
//							exampleAwsInstance.Id,
//						},
//					},
//				},
//				TaskInvocationParameters: &ssm.MaintenanceWindowTaskTaskInvocationParametersArgs{
//					StepFunctionsParameters: &ssm.MaintenanceWindowTaskTaskInvocationParametersStepFunctionsParametersArgs{
//						Input: pulumi.String("{\"key1\":\"value1\"}"),
//						Name:  pulumi.String("example"),
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
// Using `pulumi import`, import AWS Maintenance Window Task using the `window_id` and `window_task_id` separated by `/`. For example:
//
// ```sh
// $ pulumi import aws:ssm/maintenanceWindowTask:MaintenanceWindowTask task <window_id>/<window_task_id>
// ```
type MaintenanceWindowTask struct {
	pulumi.CustomResourceState

	// The ARN of the maintenance window task.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Indicates whether tasks should continue to run after the cutoff time specified in the maintenance windows is reached. Valid values are `CONTINUE_TASK` and `CANCEL_TASK`.
	CutoffBehavior pulumi.StringPtrOutput `pulumi:"cutoffBehavior"`
	// The description of the maintenance window task.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// The maximum number of targets this task can be run for in parallel.
	MaxConcurrency pulumi.StringOutput `pulumi:"maxConcurrency"`
	// The maximum number of errors allowed before this task stops being scheduled.
	MaxErrors pulumi.StringOutput `pulumi:"maxErrors"`
	// The name of the maintenance window task.
	Name pulumi.StringOutput `pulumi:"name"`
	// The priority of the task in the Maintenance Window, the lower the number the higher the priority. Tasks in a Maintenance Window are scheduled in priority order with tasks that have the same priority scheduled in parallel.
	Priority pulumi.IntPtrOutput `pulumi:"priority"`
	// The role that should be assumed when executing the task. If a role is not provided, Systems Manager uses your account's service-linked role. If no service-linked role for Systems Manager exists in your account, it is created for you.
	ServiceRoleArn pulumi.StringOutput `pulumi:"serviceRoleArn"`
	// The targets (either instances or window target ids). Instances are specified using Key=InstanceIds,Values=instanceid1,instanceid2. Window target ids are specified using Key=WindowTargetIds,Values=window target id1, window target id2.
	Targets MaintenanceWindowTaskTargetArrayOutput `pulumi:"targets"`
	// The ARN of the task to execute.
	TaskArn pulumi.StringOutput `pulumi:"taskArn"`
	// Configuration block with parameters for task execution.
	TaskInvocationParameters MaintenanceWindowTaskTaskInvocationParametersPtrOutput `pulumi:"taskInvocationParameters"`
	// The type of task being registered. Valid values: `AUTOMATION`, `LAMBDA`, `RUN_COMMAND` or `STEP_FUNCTIONS`.
	TaskType pulumi.StringOutput `pulumi:"taskType"`
	// The Id of the maintenance window to register the task with.
	WindowId pulumi.StringOutput `pulumi:"windowId"`
	// The ID of the maintenance window task.
	WindowTaskId pulumi.StringOutput `pulumi:"windowTaskId"`
}

// NewMaintenanceWindowTask registers a new resource with the given unique name, arguments, and options.
func NewMaintenanceWindowTask(ctx *pulumi.Context,
	name string, args *MaintenanceWindowTaskArgs, opts ...pulumi.ResourceOption) (*MaintenanceWindowTask, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.TaskArn == nil {
		return nil, errors.New("invalid value for required argument 'TaskArn'")
	}
	if args.TaskType == nil {
		return nil, errors.New("invalid value for required argument 'TaskType'")
	}
	if args.WindowId == nil {
		return nil, errors.New("invalid value for required argument 'WindowId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource MaintenanceWindowTask
	err := ctx.RegisterResource("aws:ssm/maintenanceWindowTask:MaintenanceWindowTask", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetMaintenanceWindowTask gets an existing MaintenanceWindowTask resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetMaintenanceWindowTask(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *MaintenanceWindowTaskState, opts ...pulumi.ResourceOption) (*MaintenanceWindowTask, error) {
	var resource MaintenanceWindowTask
	err := ctx.ReadResource("aws:ssm/maintenanceWindowTask:MaintenanceWindowTask", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering MaintenanceWindowTask resources.
type maintenanceWindowTaskState struct {
	// The ARN of the maintenance window task.
	Arn *string `pulumi:"arn"`
	// Indicates whether tasks should continue to run after the cutoff time specified in the maintenance windows is reached. Valid values are `CONTINUE_TASK` and `CANCEL_TASK`.
	CutoffBehavior *string `pulumi:"cutoffBehavior"`
	// The description of the maintenance window task.
	Description *string `pulumi:"description"`
	// The maximum number of targets this task can be run for in parallel.
	MaxConcurrency *string `pulumi:"maxConcurrency"`
	// The maximum number of errors allowed before this task stops being scheduled.
	MaxErrors *string `pulumi:"maxErrors"`
	// The name of the maintenance window task.
	Name *string `pulumi:"name"`
	// The priority of the task in the Maintenance Window, the lower the number the higher the priority. Tasks in a Maintenance Window are scheduled in priority order with tasks that have the same priority scheduled in parallel.
	Priority *int `pulumi:"priority"`
	// The role that should be assumed when executing the task. If a role is not provided, Systems Manager uses your account's service-linked role. If no service-linked role for Systems Manager exists in your account, it is created for you.
	ServiceRoleArn *string `pulumi:"serviceRoleArn"`
	// The targets (either instances or window target ids). Instances are specified using Key=InstanceIds,Values=instanceid1,instanceid2. Window target ids are specified using Key=WindowTargetIds,Values=window target id1, window target id2.
	Targets []MaintenanceWindowTaskTarget `pulumi:"targets"`
	// The ARN of the task to execute.
	TaskArn *string `pulumi:"taskArn"`
	// Configuration block with parameters for task execution.
	TaskInvocationParameters *MaintenanceWindowTaskTaskInvocationParameters `pulumi:"taskInvocationParameters"`
	// The type of task being registered. Valid values: `AUTOMATION`, `LAMBDA`, `RUN_COMMAND` or `STEP_FUNCTIONS`.
	TaskType *string `pulumi:"taskType"`
	// The Id of the maintenance window to register the task with.
	WindowId *string `pulumi:"windowId"`
	// The ID of the maintenance window task.
	WindowTaskId *string `pulumi:"windowTaskId"`
}

type MaintenanceWindowTaskState struct {
	// The ARN of the maintenance window task.
	Arn pulumi.StringPtrInput
	// Indicates whether tasks should continue to run after the cutoff time specified in the maintenance windows is reached. Valid values are `CONTINUE_TASK` and `CANCEL_TASK`.
	CutoffBehavior pulumi.StringPtrInput
	// The description of the maintenance window task.
	Description pulumi.StringPtrInput
	// The maximum number of targets this task can be run for in parallel.
	MaxConcurrency pulumi.StringPtrInput
	// The maximum number of errors allowed before this task stops being scheduled.
	MaxErrors pulumi.StringPtrInput
	// The name of the maintenance window task.
	Name pulumi.StringPtrInput
	// The priority of the task in the Maintenance Window, the lower the number the higher the priority. Tasks in a Maintenance Window are scheduled in priority order with tasks that have the same priority scheduled in parallel.
	Priority pulumi.IntPtrInput
	// The role that should be assumed when executing the task. If a role is not provided, Systems Manager uses your account's service-linked role. If no service-linked role for Systems Manager exists in your account, it is created for you.
	ServiceRoleArn pulumi.StringPtrInput
	// The targets (either instances or window target ids). Instances are specified using Key=InstanceIds,Values=instanceid1,instanceid2. Window target ids are specified using Key=WindowTargetIds,Values=window target id1, window target id2.
	Targets MaintenanceWindowTaskTargetArrayInput
	// The ARN of the task to execute.
	TaskArn pulumi.StringPtrInput
	// Configuration block with parameters for task execution.
	TaskInvocationParameters MaintenanceWindowTaskTaskInvocationParametersPtrInput
	// The type of task being registered. Valid values: `AUTOMATION`, `LAMBDA`, `RUN_COMMAND` or `STEP_FUNCTIONS`.
	TaskType pulumi.StringPtrInput
	// The Id of the maintenance window to register the task with.
	WindowId pulumi.StringPtrInput
	// The ID of the maintenance window task.
	WindowTaskId pulumi.StringPtrInput
}

func (MaintenanceWindowTaskState) ElementType() reflect.Type {
	return reflect.TypeOf((*maintenanceWindowTaskState)(nil)).Elem()
}

type maintenanceWindowTaskArgs struct {
	// Indicates whether tasks should continue to run after the cutoff time specified in the maintenance windows is reached. Valid values are `CONTINUE_TASK` and `CANCEL_TASK`.
	CutoffBehavior *string `pulumi:"cutoffBehavior"`
	// The description of the maintenance window task.
	Description *string `pulumi:"description"`
	// The maximum number of targets this task can be run for in parallel.
	MaxConcurrency *string `pulumi:"maxConcurrency"`
	// The maximum number of errors allowed before this task stops being scheduled.
	MaxErrors *string `pulumi:"maxErrors"`
	// The name of the maintenance window task.
	Name *string `pulumi:"name"`
	// The priority of the task in the Maintenance Window, the lower the number the higher the priority. Tasks in a Maintenance Window are scheduled in priority order with tasks that have the same priority scheduled in parallel.
	Priority *int `pulumi:"priority"`
	// The role that should be assumed when executing the task. If a role is not provided, Systems Manager uses your account's service-linked role. If no service-linked role for Systems Manager exists in your account, it is created for you.
	ServiceRoleArn *string `pulumi:"serviceRoleArn"`
	// The targets (either instances or window target ids). Instances are specified using Key=InstanceIds,Values=instanceid1,instanceid2. Window target ids are specified using Key=WindowTargetIds,Values=window target id1, window target id2.
	Targets []MaintenanceWindowTaskTarget `pulumi:"targets"`
	// The ARN of the task to execute.
	TaskArn string `pulumi:"taskArn"`
	// Configuration block with parameters for task execution.
	TaskInvocationParameters *MaintenanceWindowTaskTaskInvocationParameters `pulumi:"taskInvocationParameters"`
	// The type of task being registered. Valid values: `AUTOMATION`, `LAMBDA`, `RUN_COMMAND` or `STEP_FUNCTIONS`.
	TaskType string `pulumi:"taskType"`
	// The Id of the maintenance window to register the task with.
	WindowId string `pulumi:"windowId"`
}

// The set of arguments for constructing a MaintenanceWindowTask resource.
type MaintenanceWindowTaskArgs struct {
	// Indicates whether tasks should continue to run after the cutoff time specified in the maintenance windows is reached. Valid values are `CONTINUE_TASK` and `CANCEL_TASK`.
	CutoffBehavior pulumi.StringPtrInput
	// The description of the maintenance window task.
	Description pulumi.StringPtrInput
	// The maximum number of targets this task can be run for in parallel.
	MaxConcurrency pulumi.StringPtrInput
	// The maximum number of errors allowed before this task stops being scheduled.
	MaxErrors pulumi.StringPtrInput
	// The name of the maintenance window task.
	Name pulumi.StringPtrInput
	// The priority of the task in the Maintenance Window, the lower the number the higher the priority. Tasks in a Maintenance Window are scheduled in priority order with tasks that have the same priority scheduled in parallel.
	Priority pulumi.IntPtrInput
	// The role that should be assumed when executing the task. If a role is not provided, Systems Manager uses your account's service-linked role. If no service-linked role for Systems Manager exists in your account, it is created for you.
	ServiceRoleArn pulumi.StringPtrInput
	// The targets (either instances or window target ids). Instances are specified using Key=InstanceIds,Values=instanceid1,instanceid2. Window target ids are specified using Key=WindowTargetIds,Values=window target id1, window target id2.
	Targets MaintenanceWindowTaskTargetArrayInput
	// The ARN of the task to execute.
	TaskArn pulumi.StringInput
	// Configuration block with parameters for task execution.
	TaskInvocationParameters MaintenanceWindowTaskTaskInvocationParametersPtrInput
	// The type of task being registered. Valid values: `AUTOMATION`, `LAMBDA`, `RUN_COMMAND` or `STEP_FUNCTIONS`.
	TaskType pulumi.StringInput
	// The Id of the maintenance window to register the task with.
	WindowId pulumi.StringInput
}

func (MaintenanceWindowTaskArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*maintenanceWindowTaskArgs)(nil)).Elem()
}

type MaintenanceWindowTaskInput interface {
	pulumi.Input

	ToMaintenanceWindowTaskOutput() MaintenanceWindowTaskOutput
	ToMaintenanceWindowTaskOutputWithContext(ctx context.Context) MaintenanceWindowTaskOutput
}

func (*MaintenanceWindowTask) ElementType() reflect.Type {
	return reflect.TypeOf((**MaintenanceWindowTask)(nil)).Elem()
}

func (i *MaintenanceWindowTask) ToMaintenanceWindowTaskOutput() MaintenanceWindowTaskOutput {
	return i.ToMaintenanceWindowTaskOutputWithContext(context.Background())
}

func (i *MaintenanceWindowTask) ToMaintenanceWindowTaskOutputWithContext(ctx context.Context) MaintenanceWindowTaskOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MaintenanceWindowTaskOutput)
}

// MaintenanceWindowTaskArrayInput is an input type that accepts MaintenanceWindowTaskArray and MaintenanceWindowTaskArrayOutput values.
// You can construct a concrete instance of `MaintenanceWindowTaskArrayInput` via:
//
//	MaintenanceWindowTaskArray{ MaintenanceWindowTaskArgs{...} }
type MaintenanceWindowTaskArrayInput interface {
	pulumi.Input

	ToMaintenanceWindowTaskArrayOutput() MaintenanceWindowTaskArrayOutput
	ToMaintenanceWindowTaskArrayOutputWithContext(context.Context) MaintenanceWindowTaskArrayOutput
}

type MaintenanceWindowTaskArray []MaintenanceWindowTaskInput

func (MaintenanceWindowTaskArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MaintenanceWindowTask)(nil)).Elem()
}

func (i MaintenanceWindowTaskArray) ToMaintenanceWindowTaskArrayOutput() MaintenanceWindowTaskArrayOutput {
	return i.ToMaintenanceWindowTaskArrayOutputWithContext(context.Background())
}

func (i MaintenanceWindowTaskArray) ToMaintenanceWindowTaskArrayOutputWithContext(ctx context.Context) MaintenanceWindowTaskArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MaintenanceWindowTaskArrayOutput)
}

// MaintenanceWindowTaskMapInput is an input type that accepts MaintenanceWindowTaskMap and MaintenanceWindowTaskMapOutput values.
// You can construct a concrete instance of `MaintenanceWindowTaskMapInput` via:
//
//	MaintenanceWindowTaskMap{ "key": MaintenanceWindowTaskArgs{...} }
type MaintenanceWindowTaskMapInput interface {
	pulumi.Input

	ToMaintenanceWindowTaskMapOutput() MaintenanceWindowTaskMapOutput
	ToMaintenanceWindowTaskMapOutputWithContext(context.Context) MaintenanceWindowTaskMapOutput
}

type MaintenanceWindowTaskMap map[string]MaintenanceWindowTaskInput

func (MaintenanceWindowTaskMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MaintenanceWindowTask)(nil)).Elem()
}

func (i MaintenanceWindowTaskMap) ToMaintenanceWindowTaskMapOutput() MaintenanceWindowTaskMapOutput {
	return i.ToMaintenanceWindowTaskMapOutputWithContext(context.Background())
}

func (i MaintenanceWindowTaskMap) ToMaintenanceWindowTaskMapOutputWithContext(ctx context.Context) MaintenanceWindowTaskMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MaintenanceWindowTaskMapOutput)
}

type MaintenanceWindowTaskOutput struct{ *pulumi.OutputState }

func (MaintenanceWindowTaskOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**MaintenanceWindowTask)(nil)).Elem()
}

func (o MaintenanceWindowTaskOutput) ToMaintenanceWindowTaskOutput() MaintenanceWindowTaskOutput {
	return o
}

func (o MaintenanceWindowTaskOutput) ToMaintenanceWindowTaskOutputWithContext(ctx context.Context) MaintenanceWindowTaskOutput {
	return o
}

// The ARN of the maintenance window task.
func (o MaintenanceWindowTaskOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Indicates whether tasks should continue to run after the cutoff time specified in the maintenance windows is reached. Valid values are `CONTINUE_TASK` and `CANCEL_TASK`.
func (o MaintenanceWindowTaskOutput) CutoffBehavior() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringPtrOutput { return v.CutoffBehavior }).(pulumi.StringPtrOutput)
}

// The description of the maintenance window task.
func (o MaintenanceWindowTaskOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// The maximum number of targets this task can be run for in parallel.
func (o MaintenanceWindowTaskOutput) MaxConcurrency() pulumi.StringOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringOutput { return v.MaxConcurrency }).(pulumi.StringOutput)
}

// The maximum number of errors allowed before this task stops being scheduled.
func (o MaintenanceWindowTaskOutput) MaxErrors() pulumi.StringOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringOutput { return v.MaxErrors }).(pulumi.StringOutput)
}

// The name of the maintenance window task.
func (o MaintenanceWindowTaskOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The priority of the task in the Maintenance Window, the lower the number the higher the priority. Tasks in a Maintenance Window are scheduled in priority order with tasks that have the same priority scheduled in parallel.
func (o MaintenanceWindowTaskOutput) Priority() pulumi.IntPtrOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.IntPtrOutput { return v.Priority }).(pulumi.IntPtrOutput)
}

// The role that should be assumed when executing the task. If a role is not provided, Systems Manager uses your account's service-linked role. If no service-linked role for Systems Manager exists in your account, it is created for you.
func (o MaintenanceWindowTaskOutput) ServiceRoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringOutput { return v.ServiceRoleArn }).(pulumi.StringOutput)
}

// The targets (either instances or window target ids). Instances are specified using Key=InstanceIds,Values=instanceid1,instanceid2. Window target ids are specified using Key=WindowTargetIds,Values=window target id1, window target id2.
func (o MaintenanceWindowTaskOutput) Targets() MaintenanceWindowTaskTargetArrayOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) MaintenanceWindowTaskTargetArrayOutput { return v.Targets }).(MaintenanceWindowTaskTargetArrayOutput)
}

// The ARN of the task to execute.
func (o MaintenanceWindowTaskOutput) TaskArn() pulumi.StringOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringOutput { return v.TaskArn }).(pulumi.StringOutput)
}

// Configuration block with parameters for task execution.
func (o MaintenanceWindowTaskOutput) TaskInvocationParameters() MaintenanceWindowTaskTaskInvocationParametersPtrOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) MaintenanceWindowTaskTaskInvocationParametersPtrOutput {
		return v.TaskInvocationParameters
	}).(MaintenanceWindowTaskTaskInvocationParametersPtrOutput)
}

// The type of task being registered. Valid values: `AUTOMATION`, `LAMBDA`, `RUN_COMMAND` or `STEP_FUNCTIONS`.
func (o MaintenanceWindowTaskOutput) TaskType() pulumi.StringOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringOutput { return v.TaskType }).(pulumi.StringOutput)
}

// The Id of the maintenance window to register the task with.
func (o MaintenanceWindowTaskOutput) WindowId() pulumi.StringOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringOutput { return v.WindowId }).(pulumi.StringOutput)
}

// The ID of the maintenance window task.
func (o MaintenanceWindowTaskOutput) WindowTaskId() pulumi.StringOutput {
	return o.ApplyT(func(v *MaintenanceWindowTask) pulumi.StringOutput { return v.WindowTaskId }).(pulumi.StringOutput)
}

type MaintenanceWindowTaskArrayOutput struct{ *pulumi.OutputState }

func (MaintenanceWindowTaskArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MaintenanceWindowTask)(nil)).Elem()
}

func (o MaintenanceWindowTaskArrayOutput) ToMaintenanceWindowTaskArrayOutput() MaintenanceWindowTaskArrayOutput {
	return o
}

func (o MaintenanceWindowTaskArrayOutput) ToMaintenanceWindowTaskArrayOutputWithContext(ctx context.Context) MaintenanceWindowTaskArrayOutput {
	return o
}

func (o MaintenanceWindowTaskArrayOutput) Index(i pulumi.IntInput) MaintenanceWindowTaskOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *MaintenanceWindowTask {
		return vs[0].([]*MaintenanceWindowTask)[vs[1].(int)]
	}).(MaintenanceWindowTaskOutput)
}

type MaintenanceWindowTaskMapOutput struct{ *pulumi.OutputState }

func (MaintenanceWindowTaskMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MaintenanceWindowTask)(nil)).Elem()
}

func (o MaintenanceWindowTaskMapOutput) ToMaintenanceWindowTaskMapOutput() MaintenanceWindowTaskMapOutput {
	return o
}

func (o MaintenanceWindowTaskMapOutput) ToMaintenanceWindowTaskMapOutputWithContext(ctx context.Context) MaintenanceWindowTaskMapOutput {
	return o
}

func (o MaintenanceWindowTaskMapOutput) MapIndex(k pulumi.StringInput) MaintenanceWindowTaskOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *MaintenanceWindowTask {
		return vs[0].(map[string]*MaintenanceWindowTask)[vs[1].(string)]
	}).(MaintenanceWindowTaskOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*MaintenanceWindowTaskInput)(nil)).Elem(), &MaintenanceWindowTask{})
	pulumi.RegisterInputType(reflect.TypeOf((*MaintenanceWindowTaskArrayInput)(nil)).Elem(), MaintenanceWindowTaskArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*MaintenanceWindowTaskMapInput)(nil)).Elem(), MaintenanceWindowTaskMap{})
	pulumi.RegisterOutputType(MaintenanceWindowTaskOutput{})
	pulumi.RegisterOutputType(MaintenanceWindowTaskArrayOutput{})
	pulumi.RegisterOutputType(MaintenanceWindowTaskMapOutput{})
}
