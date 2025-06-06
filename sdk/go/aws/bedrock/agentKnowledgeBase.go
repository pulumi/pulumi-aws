// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package bedrock

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Agents for Amazon Bedrock Knowledge Base.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/bedrock"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := bedrock.NewAgentKnowledgeBase(ctx, "example", &bedrock.AgentKnowledgeBaseArgs{
//				Name:    pulumi.String("example"),
//				RoleArn: pulumi.Any(exampleAwsIamRole.Arn),
//				KnowledgeBaseConfiguration: &bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationArgs{
//					VectorKnowledgeBaseConfiguration: &bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationArgs{
//						EmbeddingModelArn: pulumi.String("arn:aws:bedrock:us-west-2::foundation-model/amazon.titan-embed-text-v2:0"),
//					},
//					Type: pulumi.String("VECTOR"),
//				},
//				StorageConfiguration: &bedrock.AgentKnowledgeBaseStorageConfigurationArgs{
//					Type: pulumi.String("OPENSEARCH_SERVERLESS"),
//					OpensearchServerlessConfiguration: &bedrock.AgentKnowledgeBaseStorageConfigurationOpensearchServerlessConfigurationArgs{
//						CollectionArn:   pulumi.String("arn:aws:aoss:us-west-2:123456789012:collection/142bezjddq707i5stcrf"),
//						VectorIndexName: pulumi.String("bedrock-knowledge-base-default-index"),
//						FieldMapping: &bedrock.AgentKnowledgeBaseStorageConfigurationOpensearchServerlessConfigurationFieldMappingArgs{
//							VectorField:   pulumi.String("bedrock-knowledge-base-default-vector"),
//							TextField:     pulumi.String("AMAZON_BEDROCK_TEXT_CHUNK"),
//							MetadataField: pulumi.String("AMAZON_BEDROCK_METADATA"),
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
// ### With Supplemental Data Storage Configuration
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/bedrock"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := bedrock.NewAgentKnowledgeBase(ctx, "example", &bedrock.AgentKnowledgeBaseArgs{
//				Name:    pulumi.String("example"),
//				RoleArn: pulumi.Any(exampleAwsIamRole.Arn),
//				KnowledgeBaseConfiguration: &bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationArgs{
//					VectorKnowledgeBaseConfiguration: &bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationArgs{
//						EmbeddingModelArn: pulumi.String("arn:aws:bedrock:us-west-2::foundation-model/amazon.titan-embed-text-v2:0"),
//						EmbeddingModelConfiguration: &bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationArgs{
//							BedrockEmbeddingModelConfiguration: &bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs{
//								Dimensions:        pulumi.Int(1024),
//								EmbeddingDataType: pulumi.String("FLOAT32"),
//							},
//						},
//						SupplementalDataStorageConfiguration: &bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationArgs{
//							StorageLocations: bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationStorageLocationArray{
//								&bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationStorageLocationArgs{
//									Type: pulumi.String("S3"),
//									S3Location: &bedrock.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationStorageLocationS3LocationArgs{
//										Uri: pulumi.String("s3://my-bucket/chunk-processor/"),
//									},
//								},
//							},
//						},
//					},
//					Type: pulumi.String("VECTOR"),
//				},
//				StorageConfiguration: &bedrock.AgentKnowledgeBaseStorageConfigurationArgs{
//					Type: pulumi.String("OPENSEARCH_SERVERLESS"),
//					OpensearchServerlessConfiguration: &bedrock.AgentKnowledgeBaseStorageConfigurationOpensearchServerlessConfigurationArgs{
//						CollectionArn:   pulumi.String("arn:aws:aoss:us-west-2:123456789012:collection/142bezjddq707i5stcrf"),
//						VectorIndexName: pulumi.String("bedrock-knowledge-base-default-index"),
//						FieldMapping: &bedrock.AgentKnowledgeBaseStorageConfigurationOpensearchServerlessConfigurationFieldMappingArgs{
//							VectorField:   pulumi.String("bedrock-knowledge-base-default-vector"),
//							TextField:     pulumi.String("AMAZON_BEDROCK_TEXT_CHUNK"),
//							MetadataField: pulumi.String("AMAZON_BEDROCK_METADATA"),
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
// ## Import
//
// Using `pulumi import`, import Agents for Amazon Bedrock Knowledge Base using the knowledge base ID. For example:
//
// ```sh
// $ pulumi import aws:bedrock/agentKnowledgeBase:AgentKnowledgeBase example EMDPPAYPZI
// ```
type AgentKnowledgeBase struct {
	pulumi.CustomResourceState

	// ARN of the knowledge base.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Time at which the knowledge base was created.
	CreatedAt pulumi.StringOutput `pulumi:"createdAt"`
	// Description of the knowledge base.
	Description    pulumi.StringPtrOutput   `pulumi:"description"`
	FailureReasons pulumi.StringArrayOutput `pulumi:"failureReasons"`
	// Details about the embeddings configuration of the knowledge base. See `knowledgeBaseConfiguration` block for details.
	KnowledgeBaseConfiguration AgentKnowledgeBaseKnowledgeBaseConfigurationPtrOutput `pulumi:"knowledgeBaseConfiguration"`
	// Name of the knowledge base.
	Name pulumi.StringOutput `pulumi:"name"`
	// ARN of the IAM role with permissions to invoke API operations on the knowledge base.
	RoleArn pulumi.StringOutput `pulumi:"roleArn"`
	// Details about the storage configuration of the knowledge base. See `storageConfiguration` block for details.
	//
	// The following arguments are optional:
	StorageConfiguration AgentKnowledgeBaseStorageConfigurationPtrOutput `pulumi:"storageConfiguration"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapOutput              `pulumi:"tagsAll"`
	Timeouts AgentKnowledgeBaseTimeoutsPtrOutput `pulumi:"timeouts"`
	// Time at which the knowledge base was last updated.
	UpdatedAt pulumi.StringOutput `pulumi:"updatedAt"`
}

// NewAgentKnowledgeBase registers a new resource with the given unique name, arguments, and options.
func NewAgentKnowledgeBase(ctx *pulumi.Context,
	name string, args *AgentKnowledgeBaseArgs, opts ...pulumi.ResourceOption) (*AgentKnowledgeBase, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.RoleArn == nil {
		return nil, errors.New("invalid value for required argument 'RoleArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource AgentKnowledgeBase
	err := ctx.RegisterResource("aws:bedrock/agentKnowledgeBase:AgentKnowledgeBase", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAgentKnowledgeBase gets an existing AgentKnowledgeBase resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAgentKnowledgeBase(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AgentKnowledgeBaseState, opts ...pulumi.ResourceOption) (*AgentKnowledgeBase, error) {
	var resource AgentKnowledgeBase
	err := ctx.ReadResource("aws:bedrock/agentKnowledgeBase:AgentKnowledgeBase", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AgentKnowledgeBase resources.
type agentKnowledgeBaseState struct {
	// ARN of the knowledge base.
	Arn *string `pulumi:"arn"`
	// Time at which the knowledge base was created.
	CreatedAt *string `pulumi:"createdAt"`
	// Description of the knowledge base.
	Description    *string  `pulumi:"description"`
	FailureReasons []string `pulumi:"failureReasons"`
	// Details about the embeddings configuration of the knowledge base. See `knowledgeBaseConfiguration` block for details.
	KnowledgeBaseConfiguration *AgentKnowledgeBaseKnowledgeBaseConfiguration `pulumi:"knowledgeBaseConfiguration"`
	// Name of the knowledge base.
	Name *string `pulumi:"name"`
	// ARN of the IAM role with permissions to invoke API operations on the knowledge base.
	RoleArn *string `pulumi:"roleArn"`
	// Details about the storage configuration of the knowledge base. See `storageConfiguration` block for details.
	//
	// The following arguments are optional:
	StorageConfiguration *AgentKnowledgeBaseStorageConfiguration `pulumi:"storageConfiguration"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  map[string]string           `pulumi:"tagsAll"`
	Timeouts *AgentKnowledgeBaseTimeouts `pulumi:"timeouts"`
	// Time at which the knowledge base was last updated.
	UpdatedAt *string `pulumi:"updatedAt"`
}

type AgentKnowledgeBaseState struct {
	// ARN of the knowledge base.
	Arn pulumi.StringPtrInput
	// Time at which the knowledge base was created.
	CreatedAt pulumi.StringPtrInput
	// Description of the knowledge base.
	Description    pulumi.StringPtrInput
	FailureReasons pulumi.StringArrayInput
	// Details about the embeddings configuration of the knowledge base. See `knowledgeBaseConfiguration` block for details.
	KnowledgeBaseConfiguration AgentKnowledgeBaseKnowledgeBaseConfigurationPtrInput
	// Name of the knowledge base.
	Name pulumi.StringPtrInput
	// ARN of the IAM role with permissions to invoke API operations on the knowledge base.
	RoleArn pulumi.StringPtrInput
	// Details about the storage configuration of the knowledge base. See `storageConfiguration` block for details.
	//
	// The following arguments are optional:
	StorageConfiguration AgentKnowledgeBaseStorageConfigurationPtrInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapInput
	Timeouts AgentKnowledgeBaseTimeoutsPtrInput
	// Time at which the knowledge base was last updated.
	UpdatedAt pulumi.StringPtrInput
}

func (AgentKnowledgeBaseState) ElementType() reflect.Type {
	return reflect.TypeOf((*agentKnowledgeBaseState)(nil)).Elem()
}

type agentKnowledgeBaseArgs struct {
	// Description of the knowledge base.
	Description *string `pulumi:"description"`
	// Details about the embeddings configuration of the knowledge base. See `knowledgeBaseConfiguration` block for details.
	KnowledgeBaseConfiguration *AgentKnowledgeBaseKnowledgeBaseConfiguration `pulumi:"knowledgeBaseConfiguration"`
	// Name of the knowledge base.
	Name *string `pulumi:"name"`
	// ARN of the IAM role with permissions to invoke API operations on the knowledge base.
	RoleArn string `pulumi:"roleArn"`
	// Details about the storage configuration of the knowledge base. See `storageConfiguration` block for details.
	//
	// The following arguments are optional:
	StorageConfiguration *AgentKnowledgeBaseStorageConfiguration `pulumi:"storageConfiguration"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags     map[string]string           `pulumi:"tags"`
	Timeouts *AgentKnowledgeBaseTimeouts `pulumi:"timeouts"`
}

// The set of arguments for constructing a AgentKnowledgeBase resource.
type AgentKnowledgeBaseArgs struct {
	// Description of the knowledge base.
	Description pulumi.StringPtrInput
	// Details about the embeddings configuration of the knowledge base. See `knowledgeBaseConfiguration` block for details.
	KnowledgeBaseConfiguration AgentKnowledgeBaseKnowledgeBaseConfigurationPtrInput
	// Name of the knowledge base.
	Name pulumi.StringPtrInput
	// ARN of the IAM role with permissions to invoke API operations on the knowledge base.
	RoleArn pulumi.StringInput
	// Details about the storage configuration of the knowledge base. See `storageConfiguration` block for details.
	//
	// The following arguments are optional:
	StorageConfiguration AgentKnowledgeBaseStorageConfigurationPtrInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags     pulumi.StringMapInput
	Timeouts AgentKnowledgeBaseTimeoutsPtrInput
}

func (AgentKnowledgeBaseArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*agentKnowledgeBaseArgs)(nil)).Elem()
}

type AgentKnowledgeBaseInput interface {
	pulumi.Input

	ToAgentKnowledgeBaseOutput() AgentKnowledgeBaseOutput
	ToAgentKnowledgeBaseOutputWithContext(ctx context.Context) AgentKnowledgeBaseOutput
}

func (*AgentKnowledgeBase) ElementType() reflect.Type {
	return reflect.TypeOf((**AgentKnowledgeBase)(nil)).Elem()
}

func (i *AgentKnowledgeBase) ToAgentKnowledgeBaseOutput() AgentKnowledgeBaseOutput {
	return i.ToAgentKnowledgeBaseOutputWithContext(context.Background())
}

func (i *AgentKnowledgeBase) ToAgentKnowledgeBaseOutputWithContext(ctx context.Context) AgentKnowledgeBaseOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AgentKnowledgeBaseOutput)
}

// AgentKnowledgeBaseArrayInput is an input type that accepts AgentKnowledgeBaseArray and AgentKnowledgeBaseArrayOutput values.
// You can construct a concrete instance of `AgentKnowledgeBaseArrayInput` via:
//
//	AgentKnowledgeBaseArray{ AgentKnowledgeBaseArgs{...} }
type AgentKnowledgeBaseArrayInput interface {
	pulumi.Input

	ToAgentKnowledgeBaseArrayOutput() AgentKnowledgeBaseArrayOutput
	ToAgentKnowledgeBaseArrayOutputWithContext(context.Context) AgentKnowledgeBaseArrayOutput
}

type AgentKnowledgeBaseArray []AgentKnowledgeBaseInput

func (AgentKnowledgeBaseArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AgentKnowledgeBase)(nil)).Elem()
}

func (i AgentKnowledgeBaseArray) ToAgentKnowledgeBaseArrayOutput() AgentKnowledgeBaseArrayOutput {
	return i.ToAgentKnowledgeBaseArrayOutputWithContext(context.Background())
}

func (i AgentKnowledgeBaseArray) ToAgentKnowledgeBaseArrayOutputWithContext(ctx context.Context) AgentKnowledgeBaseArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AgentKnowledgeBaseArrayOutput)
}

// AgentKnowledgeBaseMapInput is an input type that accepts AgentKnowledgeBaseMap and AgentKnowledgeBaseMapOutput values.
// You can construct a concrete instance of `AgentKnowledgeBaseMapInput` via:
//
//	AgentKnowledgeBaseMap{ "key": AgentKnowledgeBaseArgs{...} }
type AgentKnowledgeBaseMapInput interface {
	pulumi.Input

	ToAgentKnowledgeBaseMapOutput() AgentKnowledgeBaseMapOutput
	ToAgentKnowledgeBaseMapOutputWithContext(context.Context) AgentKnowledgeBaseMapOutput
}

type AgentKnowledgeBaseMap map[string]AgentKnowledgeBaseInput

func (AgentKnowledgeBaseMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AgentKnowledgeBase)(nil)).Elem()
}

func (i AgentKnowledgeBaseMap) ToAgentKnowledgeBaseMapOutput() AgentKnowledgeBaseMapOutput {
	return i.ToAgentKnowledgeBaseMapOutputWithContext(context.Background())
}

func (i AgentKnowledgeBaseMap) ToAgentKnowledgeBaseMapOutputWithContext(ctx context.Context) AgentKnowledgeBaseMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AgentKnowledgeBaseMapOutput)
}

type AgentKnowledgeBaseOutput struct{ *pulumi.OutputState }

func (AgentKnowledgeBaseOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AgentKnowledgeBase)(nil)).Elem()
}

func (o AgentKnowledgeBaseOutput) ToAgentKnowledgeBaseOutput() AgentKnowledgeBaseOutput {
	return o
}

func (o AgentKnowledgeBaseOutput) ToAgentKnowledgeBaseOutputWithContext(ctx context.Context) AgentKnowledgeBaseOutput {
	return o
}

// ARN of the knowledge base.
func (o AgentKnowledgeBaseOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Time at which the knowledge base was created.
func (o AgentKnowledgeBaseOutput) CreatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) pulumi.StringOutput { return v.CreatedAt }).(pulumi.StringOutput)
}

// Description of the knowledge base.
func (o AgentKnowledgeBaseOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

func (o AgentKnowledgeBaseOutput) FailureReasons() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) pulumi.StringArrayOutput { return v.FailureReasons }).(pulumi.StringArrayOutput)
}

// Details about the embeddings configuration of the knowledge base. See `knowledgeBaseConfiguration` block for details.
func (o AgentKnowledgeBaseOutput) KnowledgeBaseConfiguration() AgentKnowledgeBaseKnowledgeBaseConfigurationPtrOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) AgentKnowledgeBaseKnowledgeBaseConfigurationPtrOutput {
		return v.KnowledgeBaseConfiguration
	}).(AgentKnowledgeBaseKnowledgeBaseConfigurationPtrOutput)
}

// Name of the knowledge base.
func (o AgentKnowledgeBaseOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// ARN of the IAM role with permissions to invoke API operations on the knowledge base.
func (o AgentKnowledgeBaseOutput) RoleArn() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) pulumi.StringOutput { return v.RoleArn }).(pulumi.StringOutput)
}

// Details about the storage configuration of the knowledge base. See `storageConfiguration` block for details.
//
// The following arguments are optional:
func (o AgentKnowledgeBaseOutput) StorageConfiguration() AgentKnowledgeBaseStorageConfigurationPtrOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) AgentKnowledgeBaseStorageConfigurationPtrOutput {
		return v.StorageConfiguration
	}).(AgentKnowledgeBaseStorageConfigurationPtrOutput)
}

// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o AgentKnowledgeBaseOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o AgentKnowledgeBaseOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o AgentKnowledgeBaseOutput) Timeouts() AgentKnowledgeBaseTimeoutsPtrOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) AgentKnowledgeBaseTimeoutsPtrOutput { return v.Timeouts }).(AgentKnowledgeBaseTimeoutsPtrOutput)
}

// Time at which the knowledge base was last updated.
func (o AgentKnowledgeBaseOutput) UpdatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v *AgentKnowledgeBase) pulumi.StringOutput { return v.UpdatedAt }).(pulumi.StringOutput)
}

type AgentKnowledgeBaseArrayOutput struct{ *pulumi.OutputState }

func (AgentKnowledgeBaseArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AgentKnowledgeBase)(nil)).Elem()
}

func (o AgentKnowledgeBaseArrayOutput) ToAgentKnowledgeBaseArrayOutput() AgentKnowledgeBaseArrayOutput {
	return o
}

func (o AgentKnowledgeBaseArrayOutput) ToAgentKnowledgeBaseArrayOutputWithContext(ctx context.Context) AgentKnowledgeBaseArrayOutput {
	return o
}

func (o AgentKnowledgeBaseArrayOutput) Index(i pulumi.IntInput) AgentKnowledgeBaseOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AgentKnowledgeBase {
		return vs[0].([]*AgentKnowledgeBase)[vs[1].(int)]
	}).(AgentKnowledgeBaseOutput)
}

type AgentKnowledgeBaseMapOutput struct{ *pulumi.OutputState }

func (AgentKnowledgeBaseMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AgentKnowledgeBase)(nil)).Elem()
}

func (o AgentKnowledgeBaseMapOutput) ToAgentKnowledgeBaseMapOutput() AgentKnowledgeBaseMapOutput {
	return o
}

func (o AgentKnowledgeBaseMapOutput) ToAgentKnowledgeBaseMapOutputWithContext(ctx context.Context) AgentKnowledgeBaseMapOutput {
	return o
}

func (o AgentKnowledgeBaseMapOutput) MapIndex(k pulumi.StringInput) AgentKnowledgeBaseOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AgentKnowledgeBase {
		return vs[0].(map[string]*AgentKnowledgeBase)[vs[1].(string)]
	}).(AgentKnowledgeBaseOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AgentKnowledgeBaseInput)(nil)).Elem(), &AgentKnowledgeBase{})
	pulumi.RegisterInputType(reflect.TypeOf((*AgentKnowledgeBaseArrayInput)(nil)).Elem(), AgentKnowledgeBaseArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AgentKnowledgeBaseMapInput)(nil)).Elem(), AgentKnowledgeBaseMap{})
	pulumi.RegisterOutputType(AgentKnowledgeBaseOutput{})
	pulumi.RegisterOutputType(AgentKnowledgeBaseArrayOutput{})
	pulumi.RegisterOutputType(AgentKnowledgeBaseMapOutput{})
}
