// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package appfabric

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS AppFabric Ingestion Destination.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appfabric"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appfabric.NewIngestionDestination(ctx, "example", &appfabric.IngestionDestinationArgs{
//				AppBundleArn: pulumi.Any(exampleAwsAppfabricAppBundle.Arn),
//				IngestionArn: pulumi.Any(exampleAwsAppfabricIngestion.Arn),
//				ProcessingConfiguration: &appfabric.IngestionDestinationProcessingConfigurationArgs{
//					AuditLog: &appfabric.IngestionDestinationProcessingConfigurationAuditLogArgs{
//						Format: pulumi.String("json"),
//						Schema: pulumi.String("raw"),
//					},
//				},
//				DestinationConfiguration: &appfabric.IngestionDestinationDestinationConfigurationArgs{
//					AuditLog: &appfabric.IngestionDestinationDestinationConfigurationAuditLogArgs{
//						Destination: &appfabric.IngestionDestinationDestinationConfigurationAuditLogDestinationArgs{
//							S3Bucket: &appfabric.IngestionDestinationDestinationConfigurationAuditLogDestinationS3BucketArgs{
//								BucketName: pulumi.Any(exampleAwsS3Bucket.Bucket),
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
type IngestionDestination struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn pulumi.StringOutput `pulumi:"appBundleArn"`
	// ARN of the Ingestion Destination.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Contains information about the destination of ingested data.
	DestinationConfiguration IngestionDestinationDestinationConfigurationPtrOutput `pulumi:"destinationConfiguration"`
	// The Amazon Resource Name (ARN) of the ingestion to use for the request.
	IngestionArn pulumi.StringOutput `pulumi:"ingestionArn"`
	// Contains information about how ingested data is processed.
	ProcessingConfiguration IngestionDestinationProcessingConfigurationPtrOutput `pulumi:"processingConfiguration"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapOutput                `pulumi:"tagsAll"`
	Timeouts IngestionDestinationTimeoutsPtrOutput `pulumi:"timeouts"`
}

// NewIngestionDestination registers a new resource with the given unique name, arguments, and options.
func NewIngestionDestination(ctx *pulumi.Context,
	name string, args *IngestionDestinationArgs, opts ...pulumi.ResourceOption) (*IngestionDestination, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.AppBundleArn == nil {
		return nil, errors.New("invalid value for required argument 'AppBundleArn'")
	}
	if args.IngestionArn == nil {
		return nil, errors.New("invalid value for required argument 'IngestionArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource IngestionDestination
	err := ctx.RegisterResource("aws:appfabric/ingestionDestination:IngestionDestination", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetIngestionDestination gets an existing IngestionDestination resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetIngestionDestination(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *IngestionDestinationState, opts ...pulumi.ResourceOption) (*IngestionDestination, error) {
	var resource IngestionDestination
	err := ctx.ReadResource("aws:appfabric/ingestionDestination:IngestionDestination", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering IngestionDestination resources.
type ingestionDestinationState struct {
	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn *string `pulumi:"appBundleArn"`
	// ARN of the Ingestion Destination.
	Arn *string `pulumi:"arn"`
	// Contains information about the destination of ingested data.
	DestinationConfiguration *IngestionDestinationDestinationConfiguration `pulumi:"destinationConfiguration"`
	// The Amazon Resource Name (ARN) of the ingestion to use for the request.
	IngestionArn *string `pulumi:"ingestionArn"`
	// Contains information about how ingested data is processed.
	ProcessingConfiguration *IngestionDestinationProcessingConfiguration `pulumi:"processingConfiguration"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  map[string]string             `pulumi:"tagsAll"`
	Timeouts *IngestionDestinationTimeouts `pulumi:"timeouts"`
}

type IngestionDestinationState struct {
	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn pulumi.StringPtrInput
	// ARN of the Ingestion Destination.
	Arn pulumi.StringPtrInput
	// Contains information about the destination of ingested data.
	DestinationConfiguration IngestionDestinationDestinationConfigurationPtrInput
	// The Amazon Resource Name (ARN) of the ingestion to use for the request.
	IngestionArn pulumi.StringPtrInput
	// Contains information about how ingested data is processed.
	ProcessingConfiguration IngestionDestinationProcessingConfigurationPtrInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapInput
	Timeouts IngestionDestinationTimeoutsPtrInput
}

func (IngestionDestinationState) ElementType() reflect.Type {
	return reflect.TypeOf((*ingestionDestinationState)(nil)).Elem()
}

type ingestionDestinationArgs struct {
	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn string `pulumi:"appBundleArn"`
	// Contains information about the destination of ingested data.
	DestinationConfiguration *IngestionDestinationDestinationConfiguration `pulumi:"destinationConfiguration"`
	// The Amazon Resource Name (ARN) of the ingestion to use for the request.
	IngestionArn string `pulumi:"ingestionArn"`
	// Contains information about how ingested data is processed.
	ProcessingConfiguration *IngestionDestinationProcessingConfiguration `pulumi:"processingConfiguration"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags     map[string]string             `pulumi:"tags"`
	Timeouts *IngestionDestinationTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a IngestionDestination resource.
type IngestionDestinationArgs struct {
	// The Amazon Resource Name (ARN) of the app bundle to use for the request.
	AppBundleArn pulumi.StringInput
	// Contains information about the destination of ingested data.
	DestinationConfiguration IngestionDestinationDestinationConfigurationPtrInput
	// The Amazon Resource Name (ARN) of the ingestion to use for the request.
	IngestionArn pulumi.StringInput
	// Contains information about how ingested data is processed.
	ProcessingConfiguration IngestionDestinationProcessingConfigurationPtrInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags     pulumi.StringMapInput
	Timeouts IngestionDestinationTimeoutsPtrInput
}

func (IngestionDestinationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*ingestionDestinationArgs)(nil)).Elem()
}

type IngestionDestinationInput interface {
	pulumi.Input

	ToIngestionDestinationOutput() IngestionDestinationOutput
	ToIngestionDestinationOutputWithContext(ctx context.Context) IngestionDestinationOutput
}

func (*IngestionDestination) ElementType() reflect.Type {
	return reflect.TypeOf((**IngestionDestination)(nil)).Elem()
}

func (i *IngestionDestination) ToIngestionDestinationOutput() IngestionDestinationOutput {
	return i.ToIngestionDestinationOutputWithContext(context.Background())
}

func (i *IngestionDestination) ToIngestionDestinationOutputWithContext(ctx context.Context) IngestionDestinationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(IngestionDestinationOutput)
}

// IngestionDestinationArrayInput is an input type that accepts IngestionDestinationArray and IngestionDestinationArrayOutput values.
// You can construct a concrete instance of `IngestionDestinationArrayInput` via:
//
//	IngestionDestinationArray{ IngestionDestinationArgs{...} }
type IngestionDestinationArrayInput interface {
	pulumi.Input

	ToIngestionDestinationArrayOutput() IngestionDestinationArrayOutput
	ToIngestionDestinationArrayOutputWithContext(context.Context) IngestionDestinationArrayOutput
}

type IngestionDestinationArray []IngestionDestinationInput

func (IngestionDestinationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*IngestionDestination)(nil)).Elem()
}

func (i IngestionDestinationArray) ToIngestionDestinationArrayOutput() IngestionDestinationArrayOutput {
	return i.ToIngestionDestinationArrayOutputWithContext(context.Background())
}

func (i IngestionDestinationArray) ToIngestionDestinationArrayOutputWithContext(ctx context.Context) IngestionDestinationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(IngestionDestinationArrayOutput)
}

// IngestionDestinationMapInput is an input type that accepts IngestionDestinationMap and IngestionDestinationMapOutput values.
// You can construct a concrete instance of `IngestionDestinationMapInput` via:
//
//	IngestionDestinationMap{ "key": IngestionDestinationArgs{...} }
type IngestionDestinationMapInput interface {
	pulumi.Input

	ToIngestionDestinationMapOutput() IngestionDestinationMapOutput
	ToIngestionDestinationMapOutputWithContext(context.Context) IngestionDestinationMapOutput
}

type IngestionDestinationMap map[string]IngestionDestinationInput

func (IngestionDestinationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*IngestionDestination)(nil)).Elem()
}

func (i IngestionDestinationMap) ToIngestionDestinationMapOutput() IngestionDestinationMapOutput {
	return i.ToIngestionDestinationMapOutputWithContext(context.Background())
}

func (i IngestionDestinationMap) ToIngestionDestinationMapOutputWithContext(ctx context.Context) IngestionDestinationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(IngestionDestinationMapOutput)
}

type IngestionDestinationOutput struct{ *pulumi.OutputState }

func (IngestionDestinationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**IngestionDestination)(nil)).Elem()
}

func (o IngestionDestinationOutput) ToIngestionDestinationOutput() IngestionDestinationOutput {
	return o
}

func (o IngestionDestinationOutput) ToIngestionDestinationOutputWithContext(ctx context.Context) IngestionDestinationOutput {
	return o
}

// The Amazon Resource Name (ARN) of the app bundle to use for the request.
func (o IngestionDestinationOutput) AppBundleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *IngestionDestination) pulumi.StringOutput { return v.AppBundleArn }).(pulumi.StringOutput)
}

// ARN of the Ingestion Destination.
func (o IngestionDestinationOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *IngestionDestination) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Contains information about the destination of ingested data.
func (o IngestionDestinationOutput) DestinationConfiguration() IngestionDestinationDestinationConfigurationPtrOutput {
	return o.ApplyT(func(v *IngestionDestination) IngestionDestinationDestinationConfigurationPtrOutput {
		return v.DestinationConfiguration
	}).(IngestionDestinationDestinationConfigurationPtrOutput)
}

// The Amazon Resource Name (ARN) of the ingestion to use for the request.
func (o IngestionDestinationOutput) IngestionArn() pulumi.StringOutput {
	return o.ApplyT(func(v *IngestionDestination) pulumi.StringOutput { return v.IngestionArn }).(pulumi.StringOutput)
}

// Contains information about how ingested data is processed.
func (o IngestionDestinationOutput) ProcessingConfiguration() IngestionDestinationProcessingConfigurationPtrOutput {
	return o.ApplyT(func(v *IngestionDestination) IngestionDestinationProcessingConfigurationPtrOutput {
		return v.ProcessingConfiguration
	}).(IngestionDestinationProcessingConfigurationPtrOutput)
}

// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o IngestionDestinationOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *IngestionDestination) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o IngestionDestinationOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *IngestionDestination) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o IngestionDestinationOutput) Timeouts() IngestionDestinationTimeoutsPtrOutput {
	return o.ApplyT(func(v *IngestionDestination) IngestionDestinationTimeoutsPtrOutput { return v.Timeouts }).(IngestionDestinationTimeoutsPtrOutput)
}

type IngestionDestinationArrayOutput struct{ *pulumi.OutputState }

func (IngestionDestinationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*IngestionDestination)(nil)).Elem()
}

func (o IngestionDestinationArrayOutput) ToIngestionDestinationArrayOutput() IngestionDestinationArrayOutput {
	return o
}

func (o IngestionDestinationArrayOutput) ToIngestionDestinationArrayOutputWithContext(ctx context.Context) IngestionDestinationArrayOutput {
	return o
}

func (o IngestionDestinationArrayOutput) Index(i pulumi.IntInput) IngestionDestinationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *IngestionDestination {
		return vs[0].([]*IngestionDestination)[vs[1].(int)]
	}).(IngestionDestinationOutput)
}

type IngestionDestinationMapOutput struct{ *pulumi.OutputState }

func (IngestionDestinationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*IngestionDestination)(nil)).Elem()
}

func (o IngestionDestinationMapOutput) ToIngestionDestinationMapOutput() IngestionDestinationMapOutput {
	return o
}

func (o IngestionDestinationMapOutput) ToIngestionDestinationMapOutputWithContext(ctx context.Context) IngestionDestinationMapOutput {
	return o
}

func (o IngestionDestinationMapOutput) MapIndex(k pulumi.StringInput) IngestionDestinationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *IngestionDestination {
		return vs[0].(map[string]*IngestionDestination)[vs[1].(string)]
	}).(IngestionDestinationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*IngestionDestinationInput)(nil)).Elem(), &IngestionDestination{})
	pulumi.RegisterInputType(reflect.TypeOf((*IngestionDestinationArrayInput)(nil)).Elem(), IngestionDestinationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*IngestionDestinationMapInput)(nil)).Elem(), IngestionDestinationMap{})
	pulumi.RegisterOutputType(IngestionDestinationOutput{})
	pulumi.RegisterOutputType(IngestionDestinationArrayOutput{})
	pulumi.RegisterOutputType(IngestionDestinationMapOutput{})
}
