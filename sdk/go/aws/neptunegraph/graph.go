// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package neptunegraph

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// The neptunegraph.Graph resource creates an Amazon Analytics Graph.
//
// ## Example Usage
//
// ### Neptune Graph (with Vector Search configuration)
//
// Creates a Neptune Graph with 16GB provisioned memory, vector search capability with 128 dimensions, and a single replica for high availability.
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/neptunegraph"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			// Create Neptune Graph
//			_, err := neptunegraph.NewGraph(ctx, "example", &neptunegraph.GraphArgs{
//				GraphName:          pulumi.String("example-graph-test-20250203"),
//				ProvisionedMemory:  pulumi.Int(16),
//				DeletionProtection: pulumi.Bool(false),
//				PublicConnectivity: pulumi.Bool(false),
//				ReplicaCount:       pulumi.Int(1),
//				KmsKeyIdentifier:   pulumi.String("arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012"),
//				VectorSearchConfiguration: &neptunegraph.GraphVectorSearchConfigurationArgs{
//					VectorSearchDimension: pulumi.Int(128),
//				},
//				Tags: pulumi.StringMap{
//					"Environment": pulumi.String("Development"),
//					"ModifiedBy":  pulumi.String("AWS"),
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
// Using `pulumi import`, import `aws_neptunegraph_graph` using the graph identifier. For example:
//
// ```sh
// $ pulumi import aws:neptunegraph/graph:Graph example "graph_id"
// ```
type Graph struct {
	pulumi.CustomResourceState

	// (String) Graph resource ARN
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Value that indicates whether the Graph has deletion protection enabled. The graph can't be deleted when deletion protection is enabled.
	DeletionProtection pulumi.BoolOutput `pulumi:"deletionProtection"`
	// (String) The connection endpoint for the graph. For example: `g-12a3bcdef4.us-east-1.neptune-graph.amazonaws.com`
	Endpoint pulumi.StringOutput `pulumi:"endpoint"`
	// The graph name. For example: my-graph-1. The name must contain from 1 to 63 letters, numbers, or hyphens, and its first
	// character must be a letter. It cannot end with a hyphen or contain two consecutive hyphens. If you don't specify a graph
	// name, a unique graph name is generated for you using the prefix graph-for, followed by a combination of Stack Name and a
	// UUID.
	GraphName pulumi.StringOutput `pulumi:"graphName"`
	// Allows user to specify name prefix and have remainder of name automatically generated.
	GraphNamePrefix pulumi.StringPtrOutput `pulumi:"graphNamePrefix"`
	// The ARN for the KMS encryption key. By Default, Neptune Analytics will use an AWS provided key ("AWS_OWNED_KEY"). This parameter is used if you want to encrypt the graph using a KMS Customer Managed Key (CMK).
	KmsKeyIdentifier pulumi.StringOutput `pulumi:"kmsKeyIdentifier"`
	// The provisioned memory-optimized Neptune Capacity Units (m-NCUs) to use for the graph.
	//
	// The following arguments are optional:
	ProvisionedMemory pulumi.IntOutput `pulumi:"provisionedMemory"`
	// Specifies whether the Graph can be reached over the internet. Access to all graphs requires IAM authentication.  When the Graph is publicly reachable, its Domain Name System (DNS) endpoint resolves to the public IP address from the internet.  When the Graph isn't publicly reachable, you need to create a PrivateGraphEndpoint in a given VPC to ensure the DNS name resolves to a private IP address that is reachable from the VPC.
	PublicConnectivity pulumi.BoolOutput `pulumi:"publicConnectivity"`
	// Specifies the number of replicas you want when finished. All replicas will be provisioned in different availability zones.  Replica Count should always be less than or equal to 2.
	ReplicaCount pulumi.IntOutput `pulumi:"replicaCount"`
	// The tags associated with this graph. (see below for nested schema of tags)
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapOutput `pulumi:"tagsAll"`
	Timeouts GraphTimeoutsPtrOutput `pulumi:"timeouts"`
	// Vector Search Configuration (see below for nested schema of vector_search_configuration)
	VectorSearchConfiguration GraphVectorSearchConfigurationPtrOutput `pulumi:"vectorSearchConfiguration"`
}

// NewGraph registers a new resource with the given unique name, arguments, and options.
func NewGraph(ctx *pulumi.Context,
	name string, args *GraphArgs, opts ...pulumi.ResourceOption) (*Graph, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ProvisionedMemory == nil {
		return nil, errors.New("invalid value for required argument 'ProvisionedMemory'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Graph
	err := ctx.RegisterResource("aws:neptunegraph/graph:Graph", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetGraph gets an existing Graph resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetGraph(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *GraphState, opts ...pulumi.ResourceOption) (*Graph, error) {
	var resource Graph
	err := ctx.ReadResource("aws:neptunegraph/graph:Graph", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Graph resources.
type graphState struct {
	// (String) Graph resource ARN
	Arn *string `pulumi:"arn"`
	// Value that indicates whether the Graph has deletion protection enabled. The graph can't be deleted when deletion protection is enabled.
	DeletionProtection *bool `pulumi:"deletionProtection"`
	// (String) The connection endpoint for the graph. For example: `g-12a3bcdef4.us-east-1.neptune-graph.amazonaws.com`
	Endpoint *string `pulumi:"endpoint"`
	// The graph name. For example: my-graph-1. The name must contain from 1 to 63 letters, numbers, or hyphens, and its first
	// character must be a letter. It cannot end with a hyphen or contain two consecutive hyphens. If you don't specify a graph
	// name, a unique graph name is generated for you using the prefix graph-for, followed by a combination of Stack Name and a
	// UUID.
	GraphName *string `pulumi:"graphName"`
	// Allows user to specify name prefix and have remainder of name automatically generated.
	GraphNamePrefix *string `pulumi:"graphNamePrefix"`
	// The ARN for the KMS encryption key. By Default, Neptune Analytics will use an AWS provided key ("AWS_OWNED_KEY"). This parameter is used if you want to encrypt the graph using a KMS Customer Managed Key (CMK).
	KmsKeyIdentifier *string `pulumi:"kmsKeyIdentifier"`
	// The provisioned memory-optimized Neptune Capacity Units (m-NCUs) to use for the graph.
	//
	// The following arguments are optional:
	ProvisionedMemory *int `pulumi:"provisionedMemory"`
	// Specifies whether the Graph can be reached over the internet. Access to all graphs requires IAM authentication.  When the Graph is publicly reachable, its Domain Name System (DNS) endpoint resolves to the public IP address from the internet.  When the Graph isn't publicly reachable, you need to create a PrivateGraphEndpoint in a given VPC to ensure the DNS name resolves to a private IP address that is reachable from the VPC.
	PublicConnectivity *bool `pulumi:"publicConnectivity"`
	// Specifies the number of replicas you want when finished. All replicas will be provisioned in different availability zones.  Replica Count should always be less than or equal to 2.
	ReplicaCount *int `pulumi:"replicaCount"`
	// The tags associated with this graph. (see below for nested schema of tags)
	Tags map[string]string `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll  map[string]string `pulumi:"tagsAll"`
	Timeouts *GraphTimeouts    `pulumi:"timeouts"`
	// Vector Search Configuration (see below for nested schema of vector_search_configuration)
	VectorSearchConfiguration *GraphVectorSearchConfiguration `pulumi:"vectorSearchConfiguration"`
}

type GraphState struct {
	// (String) Graph resource ARN
	Arn pulumi.StringPtrInput
	// Value that indicates whether the Graph has deletion protection enabled. The graph can't be deleted when deletion protection is enabled.
	DeletionProtection pulumi.BoolPtrInput
	// (String) The connection endpoint for the graph. For example: `g-12a3bcdef4.us-east-1.neptune-graph.amazonaws.com`
	Endpoint pulumi.StringPtrInput
	// The graph name. For example: my-graph-1. The name must contain from 1 to 63 letters, numbers, or hyphens, and its first
	// character must be a letter. It cannot end with a hyphen or contain two consecutive hyphens. If you don't specify a graph
	// name, a unique graph name is generated for you using the prefix graph-for, followed by a combination of Stack Name and a
	// UUID.
	GraphName pulumi.StringPtrInput
	// Allows user to specify name prefix and have remainder of name automatically generated.
	GraphNamePrefix pulumi.StringPtrInput
	// The ARN for the KMS encryption key. By Default, Neptune Analytics will use an AWS provided key ("AWS_OWNED_KEY"). This parameter is used if you want to encrypt the graph using a KMS Customer Managed Key (CMK).
	KmsKeyIdentifier pulumi.StringPtrInput
	// The provisioned memory-optimized Neptune Capacity Units (m-NCUs) to use for the graph.
	//
	// The following arguments are optional:
	ProvisionedMemory pulumi.IntPtrInput
	// Specifies whether the Graph can be reached over the internet. Access to all graphs requires IAM authentication.  When the Graph is publicly reachable, its Domain Name System (DNS) endpoint resolves to the public IP address from the internet.  When the Graph isn't publicly reachable, you need to create a PrivateGraphEndpoint in a given VPC to ensure the DNS name resolves to a private IP address that is reachable from the VPC.
	PublicConnectivity pulumi.BoolPtrInput
	// Specifies the number of replicas you want when finished. All replicas will be provisioned in different availability zones.  Replica Count should always be less than or equal to 2.
	ReplicaCount pulumi.IntPtrInput
	// The tags associated with this graph. (see below for nested schema of tags)
	Tags pulumi.StringMapInput
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapInput
	Timeouts GraphTimeoutsPtrInput
	// Vector Search Configuration (see below for nested schema of vector_search_configuration)
	VectorSearchConfiguration GraphVectorSearchConfigurationPtrInput
}

func (GraphState) ElementType() reflect.Type {
	return reflect.TypeOf((*graphState)(nil)).Elem()
}

type graphArgs struct {
	// Value that indicates whether the Graph has deletion protection enabled. The graph can't be deleted when deletion protection is enabled.
	DeletionProtection *bool `pulumi:"deletionProtection"`
	// The graph name. For example: my-graph-1. The name must contain from 1 to 63 letters, numbers, or hyphens, and its first
	// character must be a letter. It cannot end with a hyphen or contain two consecutive hyphens. If you don't specify a graph
	// name, a unique graph name is generated for you using the prefix graph-for, followed by a combination of Stack Name and a
	// UUID.
	GraphName *string `pulumi:"graphName"`
	// Allows user to specify name prefix and have remainder of name automatically generated.
	GraphNamePrefix *string `pulumi:"graphNamePrefix"`
	// The ARN for the KMS encryption key. By Default, Neptune Analytics will use an AWS provided key ("AWS_OWNED_KEY"). This parameter is used if you want to encrypt the graph using a KMS Customer Managed Key (CMK).
	KmsKeyIdentifier *string `pulumi:"kmsKeyIdentifier"`
	// The provisioned memory-optimized Neptune Capacity Units (m-NCUs) to use for the graph.
	//
	// The following arguments are optional:
	ProvisionedMemory int `pulumi:"provisionedMemory"`
	// Specifies whether the Graph can be reached over the internet. Access to all graphs requires IAM authentication.  When the Graph is publicly reachable, its Domain Name System (DNS) endpoint resolves to the public IP address from the internet.  When the Graph isn't publicly reachable, you need to create a PrivateGraphEndpoint in a given VPC to ensure the DNS name resolves to a private IP address that is reachable from the VPC.
	PublicConnectivity *bool `pulumi:"publicConnectivity"`
	// Specifies the number of replicas you want when finished. All replicas will be provisioned in different availability zones.  Replica Count should always be less than or equal to 2.
	ReplicaCount *int `pulumi:"replicaCount"`
	// The tags associated with this graph. (see below for nested schema of tags)
	Tags     map[string]string `pulumi:"tags"`
	Timeouts *GraphTimeouts    `pulumi:"timeouts"`
	// Vector Search Configuration (see below for nested schema of vector_search_configuration)
	VectorSearchConfiguration *GraphVectorSearchConfiguration `pulumi:"vectorSearchConfiguration"`
}

// The set of arguments for constructing a Graph resource.
type GraphArgs struct {
	// Value that indicates whether the Graph has deletion protection enabled. The graph can't be deleted when deletion protection is enabled.
	DeletionProtection pulumi.BoolPtrInput
	// The graph name. For example: my-graph-1. The name must contain from 1 to 63 letters, numbers, or hyphens, and its first
	// character must be a letter. It cannot end with a hyphen or contain two consecutive hyphens. If you don't specify a graph
	// name, a unique graph name is generated for you using the prefix graph-for, followed by a combination of Stack Name and a
	// UUID.
	GraphName pulumi.StringPtrInput
	// Allows user to specify name prefix and have remainder of name automatically generated.
	GraphNamePrefix pulumi.StringPtrInput
	// The ARN for the KMS encryption key. By Default, Neptune Analytics will use an AWS provided key ("AWS_OWNED_KEY"). This parameter is used if you want to encrypt the graph using a KMS Customer Managed Key (CMK).
	KmsKeyIdentifier pulumi.StringPtrInput
	// The provisioned memory-optimized Neptune Capacity Units (m-NCUs) to use for the graph.
	//
	// The following arguments are optional:
	ProvisionedMemory pulumi.IntInput
	// Specifies whether the Graph can be reached over the internet. Access to all graphs requires IAM authentication.  When the Graph is publicly reachable, its Domain Name System (DNS) endpoint resolves to the public IP address from the internet.  When the Graph isn't publicly reachable, you need to create a PrivateGraphEndpoint in a given VPC to ensure the DNS name resolves to a private IP address that is reachable from the VPC.
	PublicConnectivity pulumi.BoolPtrInput
	// Specifies the number of replicas you want when finished. All replicas will be provisioned in different availability zones.  Replica Count should always be less than or equal to 2.
	ReplicaCount pulumi.IntPtrInput
	// The tags associated with this graph. (see below for nested schema of tags)
	Tags     pulumi.StringMapInput
	Timeouts GraphTimeoutsPtrInput
	// Vector Search Configuration (see below for nested schema of vector_search_configuration)
	VectorSearchConfiguration GraphVectorSearchConfigurationPtrInput
}

func (GraphArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*graphArgs)(nil)).Elem()
}

type GraphInput interface {
	pulumi.Input

	ToGraphOutput() GraphOutput
	ToGraphOutputWithContext(ctx context.Context) GraphOutput
}

func (*Graph) ElementType() reflect.Type {
	return reflect.TypeOf((**Graph)(nil)).Elem()
}

func (i *Graph) ToGraphOutput() GraphOutput {
	return i.ToGraphOutputWithContext(context.Background())
}

func (i *Graph) ToGraphOutputWithContext(ctx context.Context) GraphOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GraphOutput)
}

// GraphArrayInput is an input type that accepts GraphArray and GraphArrayOutput values.
// You can construct a concrete instance of `GraphArrayInput` via:
//
//	GraphArray{ GraphArgs{...} }
type GraphArrayInput interface {
	pulumi.Input

	ToGraphArrayOutput() GraphArrayOutput
	ToGraphArrayOutputWithContext(context.Context) GraphArrayOutput
}

type GraphArray []GraphInput

func (GraphArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Graph)(nil)).Elem()
}

func (i GraphArray) ToGraphArrayOutput() GraphArrayOutput {
	return i.ToGraphArrayOutputWithContext(context.Background())
}

func (i GraphArray) ToGraphArrayOutputWithContext(ctx context.Context) GraphArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GraphArrayOutput)
}

// GraphMapInput is an input type that accepts GraphMap and GraphMapOutput values.
// You can construct a concrete instance of `GraphMapInput` via:
//
//	GraphMap{ "key": GraphArgs{...} }
type GraphMapInput interface {
	pulumi.Input

	ToGraphMapOutput() GraphMapOutput
	ToGraphMapOutputWithContext(context.Context) GraphMapOutput
}

type GraphMap map[string]GraphInput

func (GraphMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Graph)(nil)).Elem()
}

func (i GraphMap) ToGraphMapOutput() GraphMapOutput {
	return i.ToGraphMapOutputWithContext(context.Background())
}

func (i GraphMap) ToGraphMapOutputWithContext(ctx context.Context) GraphMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GraphMapOutput)
}

type GraphOutput struct{ *pulumi.OutputState }

func (GraphOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Graph)(nil)).Elem()
}

func (o GraphOutput) ToGraphOutput() GraphOutput {
	return o
}

func (o GraphOutput) ToGraphOutputWithContext(ctx context.Context) GraphOutput {
	return o
}

// (String) Graph resource ARN
func (o GraphOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Graph) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Value that indicates whether the Graph has deletion protection enabled. The graph can't be deleted when deletion protection is enabled.
func (o GraphOutput) DeletionProtection() pulumi.BoolOutput {
	return o.ApplyT(func(v *Graph) pulumi.BoolOutput { return v.DeletionProtection }).(pulumi.BoolOutput)
}

// (String) The connection endpoint for the graph. For example: `g-12a3bcdef4.us-east-1.neptune-graph.amazonaws.com`
func (o GraphOutput) Endpoint() pulumi.StringOutput {
	return o.ApplyT(func(v *Graph) pulumi.StringOutput { return v.Endpoint }).(pulumi.StringOutput)
}

// The graph name. For example: my-graph-1. The name must contain from 1 to 63 letters, numbers, or hyphens, and its first
// character must be a letter. It cannot end with a hyphen or contain two consecutive hyphens. If you don't specify a graph
// name, a unique graph name is generated for you using the prefix graph-for, followed by a combination of Stack Name and a
// UUID.
func (o GraphOutput) GraphName() pulumi.StringOutput {
	return o.ApplyT(func(v *Graph) pulumi.StringOutput { return v.GraphName }).(pulumi.StringOutput)
}

// Allows user to specify name prefix and have remainder of name automatically generated.
func (o GraphOutput) GraphNamePrefix() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Graph) pulumi.StringPtrOutput { return v.GraphNamePrefix }).(pulumi.StringPtrOutput)
}

// The ARN for the KMS encryption key. By Default, Neptune Analytics will use an AWS provided key ("AWS_OWNED_KEY"). This parameter is used if you want to encrypt the graph using a KMS Customer Managed Key (CMK).
func (o GraphOutput) KmsKeyIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v *Graph) pulumi.StringOutput { return v.KmsKeyIdentifier }).(pulumi.StringOutput)
}

// The provisioned memory-optimized Neptune Capacity Units (m-NCUs) to use for the graph.
//
// The following arguments are optional:
func (o GraphOutput) ProvisionedMemory() pulumi.IntOutput {
	return o.ApplyT(func(v *Graph) pulumi.IntOutput { return v.ProvisionedMemory }).(pulumi.IntOutput)
}

// Specifies whether the Graph can be reached over the internet. Access to all graphs requires IAM authentication.  When the Graph is publicly reachable, its Domain Name System (DNS) endpoint resolves to the public IP address from the internet.  When the Graph isn't publicly reachable, you need to create a PrivateGraphEndpoint in a given VPC to ensure the DNS name resolves to a private IP address that is reachable from the VPC.
func (o GraphOutput) PublicConnectivity() pulumi.BoolOutput {
	return o.ApplyT(func(v *Graph) pulumi.BoolOutput { return v.PublicConnectivity }).(pulumi.BoolOutput)
}

// Specifies the number of replicas you want when finished. All replicas will be provisioned in different availability zones.  Replica Count should always be less than or equal to 2.
func (o GraphOutput) ReplicaCount() pulumi.IntOutput {
	return o.ApplyT(func(v *Graph) pulumi.IntOutput { return v.ReplicaCount }).(pulumi.IntOutput)
}

// The tags associated with this graph. (see below for nested schema of tags)
func (o GraphOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Graph) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Deprecated: Please use `tags` instead.
func (o GraphOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Graph) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o GraphOutput) Timeouts() GraphTimeoutsPtrOutput {
	return o.ApplyT(func(v *Graph) GraphTimeoutsPtrOutput { return v.Timeouts }).(GraphTimeoutsPtrOutput)
}

// Vector Search Configuration (see below for nested schema of vector_search_configuration)
func (o GraphOutput) VectorSearchConfiguration() GraphVectorSearchConfigurationPtrOutput {
	return o.ApplyT(func(v *Graph) GraphVectorSearchConfigurationPtrOutput { return v.VectorSearchConfiguration }).(GraphVectorSearchConfigurationPtrOutput)
}

type GraphArrayOutput struct{ *pulumi.OutputState }

func (GraphArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Graph)(nil)).Elem()
}

func (o GraphArrayOutput) ToGraphArrayOutput() GraphArrayOutput {
	return o
}

func (o GraphArrayOutput) ToGraphArrayOutputWithContext(ctx context.Context) GraphArrayOutput {
	return o
}

func (o GraphArrayOutput) Index(i pulumi.IntInput) GraphOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Graph {
		return vs[0].([]*Graph)[vs[1].(int)]
	}).(GraphOutput)
}

type GraphMapOutput struct{ *pulumi.OutputState }

func (GraphMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Graph)(nil)).Elem()
}

func (o GraphMapOutput) ToGraphMapOutput() GraphMapOutput {
	return o
}

func (o GraphMapOutput) ToGraphMapOutputWithContext(ctx context.Context) GraphMapOutput {
	return o
}

func (o GraphMapOutput) MapIndex(k pulumi.StringInput) GraphOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Graph {
		return vs[0].(map[string]*Graph)[vs[1].(string)]
	}).(GraphOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*GraphInput)(nil)).Elem(), &Graph{})
	pulumi.RegisterInputType(reflect.TypeOf((*GraphArrayInput)(nil)).Elem(), GraphArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*GraphMapInput)(nil)).Elem(), GraphMap{})
	pulumi.RegisterOutputType(GraphOutput{})
	pulumi.RegisterOutputType(GraphArrayOutput{})
	pulumi.RegisterOutputType(GraphMapOutput{})
}
