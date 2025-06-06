// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package sagemaker

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a SageMaker AI MLFlow Tracking Server resource.
//
// ## Example Usage
//
// ### Cognito Usage
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/sagemaker"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := sagemaker.NewMlflowTrackingServer(ctx, "example", &sagemaker.MlflowTrackingServerArgs{
//				TrackingServerName: pulumi.String("example"),
//				RoleArn:            pulumi.Any(exampleAwsIamRole.Arn),
//				ArtifactStoreUri:   pulumi.Sprintf("s3://%v/path", exampleAwsS3Bucket.Bucket),
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
// Using `pulumi import`, import SageMaker AI MLFlow Tracking Servers using the `workteam_name`. For example:
//
// ```sh
// $ pulumi import aws:sagemaker/mlflowTrackingServer:MlflowTrackingServer example example
// ```
type MlflowTrackingServer struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) assigned by AWS to this MLFlow Tracking Server.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The S3 URI for a general purpose bucket to use as the MLflow Tracking Server artifact store.
	ArtifactStoreUri pulumi.StringOutput `pulumi:"artifactStoreUri"`
	// A list of Member Definitions that contains objects that identify the workers that make up the work team.
	AutomaticModelRegistration pulumi.BoolPtrOutput `pulumi:"automaticModelRegistration"`
	// The version of MLflow that the tracking server uses. To see which MLflow versions are available to use, see [How it works](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow.html#mlflow-create-tracking-server-how-it-works).
	MlflowVersion pulumi.StringOutput `pulumi:"mlflowVersion"`
	// The Amazon Resource Name (ARN) for an IAM role in your account that the MLflow Tracking Server uses to access the artifact store in Amazon S3. The role should have AmazonS3FullAccess permissions. For more information on IAM permissions for tracking server creation, see [Set up IAM permissions for MLflow](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow-create-tracking-server-iam.html).
	RoleArn pulumi.StringOutput `pulumi:"roleArn"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// A unique string identifying the tracking server name. This string is part of the tracking server ARN.
	TrackingServerName pulumi.StringOutput `pulumi:"trackingServerName"`
	// The size of the tracking server you want to create. You can choose between "Small", "Medium", and "Large". The default MLflow Tracking Server configuration size is "Small". You can choose a size depending on the projected use of the tracking server such as the volume of data logged, number of users, and frequency of use.
	TrackingServerSize pulumi.StringPtrOutput `pulumi:"trackingServerSize"`
	// The URL to connect to the MLflow user interface for the described tracking server.
	TrackingServerUrl pulumi.StringOutput `pulumi:"trackingServerUrl"`
	// The day and time of the week in Coordinated Universal Time (UTC) 24-hour standard time that weekly maintenance updates are scheduled. For example: TUE:03:30.
	WeeklyMaintenanceWindowStart pulumi.StringOutput `pulumi:"weeklyMaintenanceWindowStart"`
}

// NewMlflowTrackingServer registers a new resource with the given unique name, arguments, and options.
func NewMlflowTrackingServer(ctx *pulumi.Context,
	name string, args *MlflowTrackingServerArgs, opts ...pulumi.ResourceOption) (*MlflowTrackingServer, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ArtifactStoreUri == nil {
		return nil, errors.New("invalid value for required argument 'ArtifactStoreUri'")
	}
	if args.RoleArn == nil {
		return nil, errors.New("invalid value for required argument 'RoleArn'")
	}
	if args.TrackingServerName == nil {
		return nil, errors.New("invalid value for required argument 'TrackingServerName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource MlflowTrackingServer
	err := ctx.RegisterResource("aws:sagemaker/mlflowTrackingServer:MlflowTrackingServer", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetMlflowTrackingServer gets an existing MlflowTrackingServer resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetMlflowTrackingServer(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *MlflowTrackingServerState, opts ...pulumi.ResourceOption) (*MlflowTrackingServer, error) {
	var resource MlflowTrackingServer
	err := ctx.ReadResource("aws:sagemaker/mlflowTrackingServer:MlflowTrackingServer", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering MlflowTrackingServer resources.
type mlflowTrackingServerState struct {
	// The Amazon Resource Name (ARN) assigned by AWS to this MLFlow Tracking Server.
	Arn *string `pulumi:"arn"`
	// The S3 URI for a general purpose bucket to use as the MLflow Tracking Server artifact store.
	ArtifactStoreUri *string `pulumi:"artifactStoreUri"`
	// A list of Member Definitions that contains objects that identify the workers that make up the work team.
	AutomaticModelRegistration *bool `pulumi:"automaticModelRegistration"`
	// The version of MLflow that the tracking server uses. To see which MLflow versions are available to use, see [How it works](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow.html#mlflow-create-tracking-server-how-it-works).
	MlflowVersion *string `pulumi:"mlflowVersion"`
	// The Amazon Resource Name (ARN) for an IAM role in your account that the MLflow Tracking Server uses to access the artifact store in Amazon S3. The role should have AmazonS3FullAccess permissions. For more information on IAM permissions for tracking server creation, see [Set up IAM permissions for MLflow](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow-create-tracking-server-iam.html).
	RoleArn *string `pulumi:"roleArn"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// A unique string identifying the tracking server name. This string is part of the tracking server ARN.
	TrackingServerName *string `pulumi:"trackingServerName"`
	// The size of the tracking server you want to create. You can choose between "Small", "Medium", and "Large". The default MLflow Tracking Server configuration size is "Small". You can choose a size depending on the projected use of the tracking server such as the volume of data logged, number of users, and frequency of use.
	TrackingServerSize *string `pulumi:"trackingServerSize"`
	// The URL to connect to the MLflow user interface for the described tracking server.
	TrackingServerUrl *string `pulumi:"trackingServerUrl"`
	// The day and time of the week in Coordinated Universal Time (UTC) 24-hour standard time that weekly maintenance updates are scheduled. For example: TUE:03:30.
	WeeklyMaintenanceWindowStart *string `pulumi:"weeklyMaintenanceWindowStart"`
}

type MlflowTrackingServerState struct {
	// The Amazon Resource Name (ARN) assigned by AWS to this MLFlow Tracking Server.
	Arn pulumi.StringPtrInput
	// The S3 URI for a general purpose bucket to use as the MLflow Tracking Server artifact store.
	ArtifactStoreUri pulumi.StringPtrInput
	// A list of Member Definitions that contains objects that identify the workers that make up the work team.
	AutomaticModelRegistration pulumi.BoolPtrInput
	// The version of MLflow that the tracking server uses. To see which MLflow versions are available to use, see [How it works](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow.html#mlflow-create-tracking-server-how-it-works).
	MlflowVersion pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) for an IAM role in your account that the MLflow Tracking Server uses to access the artifact store in Amazon S3. The role should have AmazonS3FullAccess permissions. For more information on IAM permissions for tracking server creation, see [Set up IAM permissions for MLflow](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow-create-tracking-server-iam.html).
	RoleArn pulumi.StringPtrInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// A unique string identifying the tracking server name. This string is part of the tracking server ARN.
	TrackingServerName pulumi.StringPtrInput
	// The size of the tracking server you want to create. You can choose between "Small", "Medium", and "Large". The default MLflow Tracking Server configuration size is "Small". You can choose a size depending on the projected use of the tracking server such as the volume of data logged, number of users, and frequency of use.
	TrackingServerSize pulumi.StringPtrInput
	// The URL to connect to the MLflow user interface for the described tracking server.
	TrackingServerUrl pulumi.StringPtrInput
	// The day and time of the week in Coordinated Universal Time (UTC) 24-hour standard time that weekly maintenance updates are scheduled. For example: TUE:03:30.
	WeeklyMaintenanceWindowStart pulumi.StringPtrInput
}

func (MlflowTrackingServerState) ElementType() reflect.Type {
	return reflect.TypeOf((*mlflowTrackingServerState)(nil)).Elem()
}

type mlflowTrackingServerArgs struct {
	// The S3 URI for a general purpose bucket to use as the MLflow Tracking Server artifact store.
	ArtifactStoreUri string `pulumi:"artifactStoreUri"`
	// A list of Member Definitions that contains objects that identify the workers that make up the work team.
	AutomaticModelRegistration *bool `pulumi:"automaticModelRegistration"`
	// The version of MLflow that the tracking server uses. To see which MLflow versions are available to use, see [How it works](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow.html#mlflow-create-tracking-server-how-it-works).
	MlflowVersion *string `pulumi:"mlflowVersion"`
	// The Amazon Resource Name (ARN) for an IAM role in your account that the MLflow Tracking Server uses to access the artifact store in Amazon S3. The role should have AmazonS3FullAccess permissions. For more information on IAM permissions for tracking server creation, see [Set up IAM permissions for MLflow](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow-create-tracking-server-iam.html).
	RoleArn string `pulumi:"roleArn"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A unique string identifying the tracking server name. This string is part of the tracking server ARN.
	TrackingServerName string `pulumi:"trackingServerName"`
	// The size of the tracking server you want to create. You can choose between "Small", "Medium", and "Large". The default MLflow Tracking Server configuration size is "Small". You can choose a size depending on the projected use of the tracking server such as the volume of data logged, number of users, and frequency of use.
	TrackingServerSize *string `pulumi:"trackingServerSize"`
	// The day and time of the week in Coordinated Universal Time (UTC) 24-hour standard time that weekly maintenance updates are scheduled. For example: TUE:03:30.
	WeeklyMaintenanceWindowStart *string `pulumi:"weeklyMaintenanceWindowStart"`
}

// The set of arguments for constructing a MlflowTrackingServer resource.
type MlflowTrackingServerArgs struct {
	// The S3 URI for a general purpose bucket to use as the MLflow Tracking Server artifact store.
	ArtifactStoreUri pulumi.StringInput
	// A list of Member Definitions that contains objects that identify the workers that make up the work team.
	AutomaticModelRegistration pulumi.BoolPtrInput
	// The version of MLflow that the tracking server uses. To see which MLflow versions are available to use, see [How it works](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow.html#mlflow-create-tracking-server-how-it-works).
	MlflowVersion pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) for an IAM role in your account that the MLflow Tracking Server uses to access the artifact store in Amazon S3. The role should have AmazonS3FullAccess permissions. For more information on IAM permissions for tracking server creation, see [Set up IAM permissions for MLflow](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow-create-tracking-server-iam.html).
	RoleArn pulumi.StringInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A unique string identifying the tracking server name. This string is part of the tracking server ARN.
	TrackingServerName pulumi.StringInput
	// The size of the tracking server you want to create. You can choose between "Small", "Medium", and "Large". The default MLflow Tracking Server configuration size is "Small". You can choose a size depending on the projected use of the tracking server such as the volume of data logged, number of users, and frequency of use.
	TrackingServerSize pulumi.StringPtrInput
	// The day and time of the week in Coordinated Universal Time (UTC) 24-hour standard time that weekly maintenance updates are scheduled. For example: TUE:03:30.
	WeeklyMaintenanceWindowStart pulumi.StringPtrInput
}

func (MlflowTrackingServerArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*mlflowTrackingServerArgs)(nil)).Elem()
}

type MlflowTrackingServerInput interface {
	pulumi.Input

	ToMlflowTrackingServerOutput() MlflowTrackingServerOutput
	ToMlflowTrackingServerOutputWithContext(ctx context.Context) MlflowTrackingServerOutput
}

func (*MlflowTrackingServer) ElementType() reflect.Type {
	return reflect.TypeOf((**MlflowTrackingServer)(nil)).Elem()
}

func (i *MlflowTrackingServer) ToMlflowTrackingServerOutput() MlflowTrackingServerOutput {
	return i.ToMlflowTrackingServerOutputWithContext(context.Background())
}

func (i *MlflowTrackingServer) ToMlflowTrackingServerOutputWithContext(ctx context.Context) MlflowTrackingServerOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MlflowTrackingServerOutput)
}

// MlflowTrackingServerArrayInput is an input type that accepts MlflowTrackingServerArray and MlflowTrackingServerArrayOutput values.
// You can construct a concrete instance of `MlflowTrackingServerArrayInput` via:
//
//	MlflowTrackingServerArray{ MlflowTrackingServerArgs{...} }
type MlflowTrackingServerArrayInput interface {
	pulumi.Input

	ToMlflowTrackingServerArrayOutput() MlflowTrackingServerArrayOutput
	ToMlflowTrackingServerArrayOutputWithContext(context.Context) MlflowTrackingServerArrayOutput
}

type MlflowTrackingServerArray []MlflowTrackingServerInput

func (MlflowTrackingServerArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MlflowTrackingServer)(nil)).Elem()
}

func (i MlflowTrackingServerArray) ToMlflowTrackingServerArrayOutput() MlflowTrackingServerArrayOutput {
	return i.ToMlflowTrackingServerArrayOutputWithContext(context.Background())
}

func (i MlflowTrackingServerArray) ToMlflowTrackingServerArrayOutputWithContext(ctx context.Context) MlflowTrackingServerArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MlflowTrackingServerArrayOutput)
}

// MlflowTrackingServerMapInput is an input type that accepts MlflowTrackingServerMap and MlflowTrackingServerMapOutput values.
// You can construct a concrete instance of `MlflowTrackingServerMapInput` via:
//
//	MlflowTrackingServerMap{ "key": MlflowTrackingServerArgs{...} }
type MlflowTrackingServerMapInput interface {
	pulumi.Input

	ToMlflowTrackingServerMapOutput() MlflowTrackingServerMapOutput
	ToMlflowTrackingServerMapOutputWithContext(context.Context) MlflowTrackingServerMapOutput
}

type MlflowTrackingServerMap map[string]MlflowTrackingServerInput

func (MlflowTrackingServerMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MlflowTrackingServer)(nil)).Elem()
}

func (i MlflowTrackingServerMap) ToMlflowTrackingServerMapOutput() MlflowTrackingServerMapOutput {
	return i.ToMlflowTrackingServerMapOutputWithContext(context.Background())
}

func (i MlflowTrackingServerMap) ToMlflowTrackingServerMapOutputWithContext(ctx context.Context) MlflowTrackingServerMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(MlflowTrackingServerMapOutput)
}

type MlflowTrackingServerOutput struct{ *pulumi.OutputState }

func (MlflowTrackingServerOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**MlflowTrackingServer)(nil)).Elem()
}

func (o MlflowTrackingServerOutput) ToMlflowTrackingServerOutput() MlflowTrackingServerOutput {
	return o
}

func (o MlflowTrackingServerOutput) ToMlflowTrackingServerOutputWithContext(ctx context.Context) MlflowTrackingServerOutput {
	return o
}

// The Amazon Resource Name (ARN) assigned by AWS to this MLFlow Tracking Server.
func (o MlflowTrackingServerOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The S3 URI for a general purpose bucket to use as the MLflow Tracking Server artifact store.
func (o MlflowTrackingServerOutput) ArtifactStoreUri() pulumi.StringOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringOutput { return v.ArtifactStoreUri }).(pulumi.StringOutput)
}

// A list of Member Definitions that contains objects that identify the workers that make up the work team.
func (o MlflowTrackingServerOutput) AutomaticModelRegistration() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.BoolPtrOutput { return v.AutomaticModelRegistration }).(pulumi.BoolPtrOutput)
}

// The version of MLflow that the tracking server uses. To see which MLflow versions are available to use, see [How it works](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow.html#mlflow-create-tracking-server-how-it-works).
func (o MlflowTrackingServerOutput) MlflowVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringOutput { return v.MlflowVersion }).(pulumi.StringOutput)
}

// The Amazon Resource Name (ARN) for an IAM role in your account that the MLflow Tracking Server uses to access the artifact store in Amazon S3. The role should have AmazonS3FullAccess permissions. For more information on IAM permissions for tracking server creation, see [Set up IAM permissions for MLflow](https://docs.aws.amazon.com/sagemaker/latest/dg/mlflow-create-tracking-server-iam.html).
func (o MlflowTrackingServerOutput) RoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringOutput { return v.RoleArn }).(pulumi.StringOutput)
}

// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o MlflowTrackingServerOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o MlflowTrackingServerOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// A unique string identifying the tracking server name. This string is part of the tracking server ARN.
func (o MlflowTrackingServerOutput) TrackingServerName() pulumi.StringOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringOutput { return v.TrackingServerName }).(pulumi.StringOutput)
}

// The size of the tracking server you want to create. You can choose between "Small", "Medium", and "Large". The default MLflow Tracking Server configuration size is "Small". You can choose a size depending on the projected use of the tracking server such as the volume of data logged, number of users, and frequency of use.
func (o MlflowTrackingServerOutput) TrackingServerSize() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringPtrOutput { return v.TrackingServerSize }).(pulumi.StringPtrOutput)
}

// The URL to connect to the MLflow user interface for the described tracking server.
func (o MlflowTrackingServerOutput) TrackingServerUrl() pulumi.StringOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringOutput { return v.TrackingServerUrl }).(pulumi.StringOutput)
}

// The day and time of the week in Coordinated Universal Time (UTC) 24-hour standard time that weekly maintenance updates are scheduled. For example: TUE:03:30.
func (o MlflowTrackingServerOutput) WeeklyMaintenanceWindowStart() pulumi.StringOutput {
	return o.ApplyT(func(v *MlflowTrackingServer) pulumi.StringOutput { return v.WeeklyMaintenanceWindowStart }).(pulumi.StringOutput)
}

type MlflowTrackingServerArrayOutput struct{ *pulumi.OutputState }

func (MlflowTrackingServerArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*MlflowTrackingServer)(nil)).Elem()
}

func (o MlflowTrackingServerArrayOutput) ToMlflowTrackingServerArrayOutput() MlflowTrackingServerArrayOutput {
	return o
}

func (o MlflowTrackingServerArrayOutput) ToMlflowTrackingServerArrayOutputWithContext(ctx context.Context) MlflowTrackingServerArrayOutput {
	return o
}

func (o MlflowTrackingServerArrayOutput) Index(i pulumi.IntInput) MlflowTrackingServerOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *MlflowTrackingServer {
		return vs[0].([]*MlflowTrackingServer)[vs[1].(int)]
	}).(MlflowTrackingServerOutput)
}

type MlflowTrackingServerMapOutput struct{ *pulumi.OutputState }

func (MlflowTrackingServerMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*MlflowTrackingServer)(nil)).Elem()
}

func (o MlflowTrackingServerMapOutput) ToMlflowTrackingServerMapOutput() MlflowTrackingServerMapOutput {
	return o
}

func (o MlflowTrackingServerMapOutput) ToMlflowTrackingServerMapOutputWithContext(ctx context.Context) MlflowTrackingServerMapOutput {
	return o
}

func (o MlflowTrackingServerMapOutput) MapIndex(k pulumi.StringInput) MlflowTrackingServerOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *MlflowTrackingServer {
		return vs[0].(map[string]*MlflowTrackingServer)[vs[1].(string)]
	}).(MlflowTrackingServerOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*MlflowTrackingServerInput)(nil)).Elem(), &MlflowTrackingServer{})
	pulumi.RegisterInputType(reflect.TypeOf((*MlflowTrackingServerArrayInput)(nil)).Elem(), MlflowTrackingServerArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*MlflowTrackingServerMapInput)(nil)).Elem(), MlflowTrackingServerMap{})
	pulumi.RegisterOutputType(MlflowTrackingServerOutput{})
	pulumi.RegisterOutputType(MlflowTrackingServerArrayOutput{})
	pulumi.RegisterOutputType(MlflowTrackingServerMapOutput{})
}
