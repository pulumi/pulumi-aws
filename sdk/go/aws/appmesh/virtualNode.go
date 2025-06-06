// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package appmesh

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an AWS App Mesh virtual node resource.
//
// ## Breaking Changes
//
// Because of backward incompatible API changes (read [here](https://github.com/awslabs/aws-app-mesh-examples/issues/92)), `appmesh.VirtualNode` resource definitions created with provider versions earlier than v2.3.0 will need to be modified:
//
// * Rename the `serviceName` attribute of the `dns` object to `hostname`.
//
// * Replace the `backends` attribute of the `spec` object with one or more `backend` configuration blocks,
// setting `virtualServiceName` to the name of the service.
//
// The state associated with existing resources will automatically be migrated.
//
// ## Example Usage
//
// ### Basic
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appmesh"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appmesh.NewVirtualNode(ctx, "serviceb1", &appmesh.VirtualNodeArgs{
//				Name:     pulumi.String("serviceBv1"),
//				MeshName: pulumi.Any(simple.Id),
//				Spec: &appmesh.VirtualNodeSpecArgs{
//					Backends: appmesh.VirtualNodeSpecBackendArray{
//						&appmesh.VirtualNodeSpecBackendArgs{
//							VirtualService: &appmesh.VirtualNodeSpecBackendVirtualServiceArgs{
//								VirtualServiceName: pulumi.String("servicea.simpleapp.local"),
//							},
//						},
//					},
//					Listeners: appmesh.VirtualNodeSpecListenerArray{
//						&appmesh.VirtualNodeSpecListenerArgs{
//							PortMapping: &appmesh.VirtualNodeSpecListenerPortMappingArgs{
//								Port:     pulumi.Int(8080),
//								Protocol: pulumi.String("http"),
//							},
//						},
//					},
//					ServiceDiscovery: &appmesh.VirtualNodeSpecServiceDiscoveryArgs{
//						Dns: &appmesh.VirtualNodeSpecServiceDiscoveryDnsArgs{
//							Hostname: pulumi.String("serviceb.simpleapp.local"),
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
// ### AWS Cloud Map Service Discovery
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appmesh"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/servicediscovery"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := servicediscovery.NewHttpNamespace(ctx, "example", &servicediscovery.HttpNamespaceArgs{
//				Name: pulumi.String("example-ns"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = appmesh.NewVirtualNode(ctx, "serviceb1", &appmesh.VirtualNodeArgs{
//				Name:     pulumi.String("serviceBv1"),
//				MeshName: pulumi.Any(simple.Id),
//				Spec: &appmesh.VirtualNodeSpecArgs{
//					Backends: appmesh.VirtualNodeSpecBackendArray{
//						&appmesh.VirtualNodeSpecBackendArgs{
//							VirtualService: &appmesh.VirtualNodeSpecBackendVirtualServiceArgs{
//								VirtualServiceName: pulumi.String("servicea.simpleapp.local"),
//							},
//						},
//					},
//					Listeners: appmesh.VirtualNodeSpecListenerArray{
//						&appmesh.VirtualNodeSpecListenerArgs{
//							PortMapping: &appmesh.VirtualNodeSpecListenerPortMappingArgs{
//								Port:     pulumi.Int(8080),
//								Protocol: pulumi.String("http"),
//							},
//						},
//					},
//					ServiceDiscovery: &appmesh.VirtualNodeSpecServiceDiscoveryArgs{
//						AwsCloudMap: &appmesh.VirtualNodeSpecServiceDiscoveryAwsCloudMapArgs{
//							Attributes: pulumi.StringMap{
//								"stack": pulumi.String("blue"),
//							},
//							ServiceName:   pulumi.String("serviceb1"),
//							NamespaceName: example.Name,
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
// ### Listener Health Check
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appmesh"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appmesh.NewVirtualNode(ctx, "serviceb1", &appmesh.VirtualNodeArgs{
//				Name:     pulumi.String("serviceBv1"),
//				MeshName: pulumi.Any(simple.Id),
//				Spec: &appmesh.VirtualNodeSpecArgs{
//					Backends: appmesh.VirtualNodeSpecBackendArray{
//						&appmesh.VirtualNodeSpecBackendArgs{
//							VirtualService: &appmesh.VirtualNodeSpecBackendVirtualServiceArgs{
//								VirtualServiceName: pulumi.String("servicea.simpleapp.local"),
//							},
//						},
//					},
//					Listeners: appmesh.VirtualNodeSpecListenerArray{
//						&appmesh.VirtualNodeSpecListenerArgs{
//							PortMapping: &appmesh.VirtualNodeSpecListenerPortMappingArgs{
//								Port:     pulumi.Int(8080),
//								Protocol: pulumi.String("http"),
//							},
//							HealthCheck: &appmesh.VirtualNodeSpecListenerHealthCheckArgs{
//								Protocol:           pulumi.String("http"),
//								Path:               pulumi.String("/ping"),
//								HealthyThreshold:   pulumi.Int(2),
//								UnhealthyThreshold: pulumi.Int(2),
//								TimeoutMillis:      pulumi.Int(2000),
//								IntervalMillis:     pulumi.Int(5000),
//							},
//						},
//					},
//					ServiceDiscovery: &appmesh.VirtualNodeSpecServiceDiscoveryArgs{
//						Dns: &appmesh.VirtualNodeSpecServiceDiscoveryDnsArgs{
//							Hostname: pulumi.String("serviceb.simpleapp.local"),
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
// ### Logging
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appmesh"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appmesh.NewVirtualNode(ctx, "serviceb1", &appmesh.VirtualNodeArgs{
//				Name:     pulumi.String("serviceBv1"),
//				MeshName: pulumi.Any(simple.Id),
//				Spec: &appmesh.VirtualNodeSpecArgs{
//					Backends: appmesh.VirtualNodeSpecBackendArray{
//						&appmesh.VirtualNodeSpecBackendArgs{
//							VirtualService: &appmesh.VirtualNodeSpecBackendVirtualServiceArgs{
//								VirtualServiceName: pulumi.String("servicea.simpleapp.local"),
//							},
//						},
//					},
//					Listeners: appmesh.VirtualNodeSpecListenerArray{
//						&appmesh.VirtualNodeSpecListenerArgs{
//							PortMapping: &appmesh.VirtualNodeSpecListenerPortMappingArgs{
//								Port:     pulumi.Int(8080),
//								Protocol: pulumi.String("http"),
//							},
//						},
//					},
//					ServiceDiscovery: &appmesh.VirtualNodeSpecServiceDiscoveryArgs{
//						Dns: &appmesh.VirtualNodeSpecServiceDiscoveryDnsArgs{
//							Hostname: pulumi.String("serviceb.simpleapp.local"),
//						},
//					},
//					Logging: &appmesh.VirtualNodeSpecLoggingArgs{
//						AccessLog: &appmesh.VirtualNodeSpecLoggingAccessLogArgs{
//							File: &appmesh.VirtualNodeSpecLoggingAccessLogFileArgs{
//								Path: pulumi.String("/dev/stdout"),
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
// ## Import
//
// Using `pulumi import`, import App Mesh virtual nodes using `mesh_name` together with the virtual node's `name`. For example:
//
// ```sh
// $ pulumi import aws:appmesh/virtualNode:VirtualNode serviceb1 simpleapp/serviceBv1
// ```
type VirtualNode struct {
	pulumi.CustomResourceState

	// ARN of the virtual node.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Creation date of the virtual node.
	CreatedDate pulumi.StringOutput `pulumi:"createdDate"`
	// Last update date of the virtual node.
	LastUpdatedDate pulumi.StringOutput `pulumi:"lastUpdatedDate"`
	// Name of the service mesh in which to create the virtual node. Must be between 1 and 255 characters in length.
	MeshName pulumi.StringOutput `pulumi:"meshName"`
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner pulumi.StringOutput `pulumi:"meshOwner"`
	// Name to use for the virtual node. Must be between 1 and 255 characters in length.
	Name pulumi.StringOutput `pulumi:"name"`
	// Resource owner's AWS account ID.
	ResourceOwner pulumi.StringOutput `pulumi:"resourceOwner"`
	// Virtual node specification to apply.
	Spec VirtualNodeSpecOutput `pulumi:"spec"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewVirtualNode registers a new resource with the given unique name, arguments, and options.
func NewVirtualNode(ctx *pulumi.Context,
	name string, args *VirtualNodeArgs, opts ...pulumi.ResourceOption) (*VirtualNode, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.MeshName == nil {
		return nil, errors.New("invalid value for required argument 'MeshName'")
	}
	if args.Spec == nil {
		return nil, errors.New("invalid value for required argument 'Spec'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource VirtualNode
	err := ctx.RegisterResource("aws:appmesh/virtualNode:VirtualNode", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetVirtualNode gets an existing VirtualNode resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetVirtualNode(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *VirtualNodeState, opts ...pulumi.ResourceOption) (*VirtualNode, error) {
	var resource VirtualNode
	err := ctx.ReadResource("aws:appmesh/virtualNode:VirtualNode", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering VirtualNode resources.
type virtualNodeState struct {
	// ARN of the virtual node.
	Arn *string `pulumi:"arn"`
	// Creation date of the virtual node.
	CreatedDate *string `pulumi:"createdDate"`
	// Last update date of the virtual node.
	LastUpdatedDate *string `pulumi:"lastUpdatedDate"`
	// Name of the service mesh in which to create the virtual node. Must be between 1 and 255 characters in length.
	MeshName *string `pulumi:"meshName"`
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner *string `pulumi:"meshOwner"`
	// Name to use for the virtual node. Must be between 1 and 255 characters in length.
	Name *string `pulumi:"name"`
	// Resource owner's AWS account ID.
	ResourceOwner *string `pulumi:"resourceOwner"`
	// Virtual node specification to apply.
	Spec *VirtualNodeSpec `pulumi:"spec"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type VirtualNodeState struct {
	// ARN of the virtual node.
	Arn pulumi.StringPtrInput
	// Creation date of the virtual node.
	CreatedDate pulumi.StringPtrInput
	// Last update date of the virtual node.
	LastUpdatedDate pulumi.StringPtrInput
	// Name of the service mesh in which to create the virtual node. Must be between 1 and 255 characters in length.
	MeshName pulumi.StringPtrInput
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner pulumi.StringPtrInput
	// Name to use for the virtual node. Must be between 1 and 255 characters in length.
	Name pulumi.StringPtrInput
	// Resource owner's AWS account ID.
	ResourceOwner pulumi.StringPtrInput
	// Virtual node specification to apply.
	Spec VirtualNodeSpecPtrInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (VirtualNodeState) ElementType() reflect.Type {
	return reflect.TypeOf((*virtualNodeState)(nil)).Elem()
}

type virtualNodeArgs struct {
	// Name of the service mesh in which to create the virtual node. Must be between 1 and 255 characters in length.
	MeshName string `pulumi:"meshName"`
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner *string `pulumi:"meshOwner"`
	// Name to use for the virtual node. Must be between 1 and 255 characters in length.
	Name *string `pulumi:"name"`
	// Virtual node specification to apply.
	Spec VirtualNodeSpec `pulumi:"spec"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a VirtualNode resource.
type VirtualNodeArgs struct {
	// Name of the service mesh in which to create the virtual node. Must be between 1 and 255 characters in length.
	MeshName pulumi.StringInput
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner pulumi.StringPtrInput
	// Name to use for the virtual node. Must be between 1 and 255 characters in length.
	Name pulumi.StringPtrInput
	// Virtual node specification to apply.
	Spec VirtualNodeSpecInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (VirtualNodeArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*virtualNodeArgs)(nil)).Elem()
}

type VirtualNodeInput interface {
	pulumi.Input

	ToVirtualNodeOutput() VirtualNodeOutput
	ToVirtualNodeOutputWithContext(ctx context.Context) VirtualNodeOutput
}

func (*VirtualNode) ElementType() reflect.Type {
	return reflect.TypeOf((**VirtualNode)(nil)).Elem()
}

func (i *VirtualNode) ToVirtualNodeOutput() VirtualNodeOutput {
	return i.ToVirtualNodeOutputWithContext(context.Background())
}

func (i *VirtualNode) ToVirtualNodeOutputWithContext(ctx context.Context) VirtualNodeOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VirtualNodeOutput)
}

// VirtualNodeArrayInput is an input type that accepts VirtualNodeArray and VirtualNodeArrayOutput values.
// You can construct a concrete instance of `VirtualNodeArrayInput` via:
//
//	VirtualNodeArray{ VirtualNodeArgs{...} }
type VirtualNodeArrayInput interface {
	pulumi.Input

	ToVirtualNodeArrayOutput() VirtualNodeArrayOutput
	ToVirtualNodeArrayOutputWithContext(context.Context) VirtualNodeArrayOutput
}

type VirtualNodeArray []VirtualNodeInput

func (VirtualNodeArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*VirtualNode)(nil)).Elem()
}

func (i VirtualNodeArray) ToVirtualNodeArrayOutput() VirtualNodeArrayOutput {
	return i.ToVirtualNodeArrayOutputWithContext(context.Background())
}

func (i VirtualNodeArray) ToVirtualNodeArrayOutputWithContext(ctx context.Context) VirtualNodeArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VirtualNodeArrayOutput)
}

// VirtualNodeMapInput is an input type that accepts VirtualNodeMap and VirtualNodeMapOutput values.
// You can construct a concrete instance of `VirtualNodeMapInput` via:
//
//	VirtualNodeMap{ "key": VirtualNodeArgs{...} }
type VirtualNodeMapInput interface {
	pulumi.Input

	ToVirtualNodeMapOutput() VirtualNodeMapOutput
	ToVirtualNodeMapOutputWithContext(context.Context) VirtualNodeMapOutput
}

type VirtualNodeMap map[string]VirtualNodeInput

func (VirtualNodeMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*VirtualNode)(nil)).Elem()
}

func (i VirtualNodeMap) ToVirtualNodeMapOutput() VirtualNodeMapOutput {
	return i.ToVirtualNodeMapOutputWithContext(context.Background())
}

func (i VirtualNodeMap) ToVirtualNodeMapOutputWithContext(ctx context.Context) VirtualNodeMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VirtualNodeMapOutput)
}

type VirtualNodeOutput struct{ *pulumi.OutputState }

func (VirtualNodeOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**VirtualNode)(nil)).Elem()
}

func (o VirtualNodeOutput) ToVirtualNodeOutput() VirtualNodeOutput {
	return o
}

func (o VirtualNodeOutput) ToVirtualNodeOutputWithContext(ctx context.Context) VirtualNodeOutput {
	return o
}

// ARN of the virtual node.
func (o VirtualNodeOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualNode) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Creation date of the virtual node.
func (o VirtualNodeOutput) CreatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualNode) pulumi.StringOutput { return v.CreatedDate }).(pulumi.StringOutput)
}

// Last update date of the virtual node.
func (o VirtualNodeOutput) LastUpdatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualNode) pulumi.StringOutput { return v.LastUpdatedDate }).(pulumi.StringOutput)
}

// Name of the service mesh in which to create the virtual node. Must be between 1 and 255 characters in length.
func (o VirtualNodeOutput) MeshName() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualNode) pulumi.StringOutput { return v.MeshName }).(pulumi.StringOutput)
}

// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
func (o VirtualNodeOutput) MeshOwner() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualNode) pulumi.StringOutput { return v.MeshOwner }).(pulumi.StringOutput)
}

// Name to use for the virtual node. Must be between 1 and 255 characters in length.
func (o VirtualNodeOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualNode) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Resource owner's AWS account ID.
func (o VirtualNodeOutput) ResourceOwner() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualNode) pulumi.StringOutput { return v.ResourceOwner }).(pulumi.StringOutput)
}

// Virtual node specification to apply.
func (o VirtualNodeOutput) Spec() VirtualNodeSpecOutput {
	return o.ApplyT(func(v *VirtualNode) VirtualNodeSpecOutput { return v.Spec }).(VirtualNodeSpecOutput)
}

// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o VirtualNodeOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *VirtualNode) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o VirtualNodeOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *VirtualNode) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type VirtualNodeArrayOutput struct{ *pulumi.OutputState }

func (VirtualNodeArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*VirtualNode)(nil)).Elem()
}

func (o VirtualNodeArrayOutput) ToVirtualNodeArrayOutput() VirtualNodeArrayOutput {
	return o
}

func (o VirtualNodeArrayOutput) ToVirtualNodeArrayOutputWithContext(ctx context.Context) VirtualNodeArrayOutput {
	return o
}

func (o VirtualNodeArrayOutput) Index(i pulumi.IntInput) VirtualNodeOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *VirtualNode {
		return vs[0].([]*VirtualNode)[vs[1].(int)]
	}).(VirtualNodeOutput)
}

type VirtualNodeMapOutput struct{ *pulumi.OutputState }

func (VirtualNodeMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*VirtualNode)(nil)).Elem()
}

func (o VirtualNodeMapOutput) ToVirtualNodeMapOutput() VirtualNodeMapOutput {
	return o
}

func (o VirtualNodeMapOutput) ToVirtualNodeMapOutputWithContext(ctx context.Context) VirtualNodeMapOutput {
	return o
}

func (o VirtualNodeMapOutput) MapIndex(k pulumi.StringInput) VirtualNodeOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *VirtualNode {
		return vs[0].(map[string]*VirtualNode)[vs[1].(string)]
	}).(VirtualNodeOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*VirtualNodeInput)(nil)).Elem(), &VirtualNode{})
	pulumi.RegisterInputType(reflect.TypeOf((*VirtualNodeArrayInput)(nil)).Elem(), VirtualNodeArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*VirtualNodeMapInput)(nil)).Elem(), VirtualNodeMap{})
	pulumi.RegisterOutputType(VirtualNodeOutput{})
	pulumi.RegisterOutputType(VirtualNodeArrayOutput{})
	pulumi.RegisterOutputType(VirtualNodeMapOutput{})
}
