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

// Provides an AWS App Mesh virtual gateway resource.
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
//			_, err := appmesh.NewVirtualGateway(ctx, "example", &appmesh.VirtualGatewayArgs{
//				Name:     pulumi.String("example-virtual-gateway"),
//				MeshName: pulumi.String("example-service-mesh"),
//				Spec: &appmesh.VirtualGatewaySpecArgs{
//					Listeners: appmesh.VirtualGatewaySpecListenerArray{
//						&appmesh.VirtualGatewaySpecListenerArgs{
//							PortMapping: &appmesh.VirtualGatewaySpecListenerPortMappingArgs{
//								Port:     pulumi.Int(8080),
//								Protocol: pulumi.String("http"),
//							},
//						},
//					},
//				},
//				Tags: pulumi.StringMap{
//					"Environment": pulumi.String("test"),
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
// ### Access Logs and TLS
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
//			_, err := appmesh.NewVirtualGateway(ctx, "example", &appmesh.VirtualGatewayArgs{
//				Name:     pulumi.String("example-virtual-gateway"),
//				MeshName: pulumi.String("example-service-mesh"),
//				Spec: &appmesh.VirtualGatewaySpecArgs{
//					Listeners: appmesh.VirtualGatewaySpecListenerArray{
//						&appmesh.VirtualGatewaySpecListenerArgs{
//							PortMapping: &appmesh.VirtualGatewaySpecListenerPortMappingArgs{
//								Port:     pulumi.Int(8080),
//								Protocol: pulumi.String("http"),
//							},
//							Tls: &appmesh.VirtualGatewaySpecListenerTlsArgs{
//								Certificate: &appmesh.VirtualGatewaySpecListenerTlsCertificateArgs{
//									Acm: &appmesh.VirtualGatewaySpecListenerTlsCertificateAcmArgs{
//										CertificateArn: pulumi.Any(exampleAwsAcmCertificate.Arn),
//									},
//								},
//								Mode: pulumi.String("STRICT"),
//							},
//						},
//					},
//					Logging: &appmesh.VirtualGatewaySpecLoggingArgs{
//						AccessLog: &appmesh.VirtualGatewaySpecLoggingAccessLogArgs{
//							File: &appmesh.VirtualGatewaySpecLoggingAccessLogFileArgs{
//								Path: pulumi.String("/var/log/access.log"),
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
// Using `pulumi import`, import App Mesh virtual gateway using `mesh_name` together with the virtual gateway's `name`. For example:
//
// ```sh
// $ pulumi import aws:appmesh/virtualGateway:VirtualGateway example mesh/gw1
// ```
type VirtualGateway struct {
	pulumi.CustomResourceState

	// ARN of the virtual gateway.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Creation date of the virtual gateway.
	CreatedDate pulumi.StringOutput `pulumi:"createdDate"`
	// Last update date of the virtual gateway.
	LastUpdatedDate pulumi.StringOutput `pulumi:"lastUpdatedDate"`
	// Name of the service mesh in which to create the virtual gateway. Must be between 1 and 255 characters in length.
	MeshName pulumi.StringOutput `pulumi:"meshName"`
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner pulumi.StringOutput `pulumi:"meshOwner"`
	// Name to use for the virtual gateway. Must be between 1 and 255 characters in length.
	Name pulumi.StringOutput `pulumi:"name"`
	// Resource owner's AWS account ID.
	ResourceOwner pulumi.StringOutput `pulumi:"resourceOwner"`
	// Virtual gateway specification to apply.
	Spec VirtualGatewaySpecOutput `pulumi:"spec"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewVirtualGateway registers a new resource with the given unique name, arguments, and options.
func NewVirtualGateway(ctx *pulumi.Context,
	name string, args *VirtualGatewayArgs, opts ...pulumi.ResourceOption) (*VirtualGateway, error) {
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
	var resource VirtualGateway
	err := ctx.RegisterResource("aws:appmesh/virtualGateway:VirtualGateway", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetVirtualGateway gets an existing VirtualGateway resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetVirtualGateway(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *VirtualGatewayState, opts ...pulumi.ResourceOption) (*VirtualGateway, error) {
	var resource VirtualGateway
	err := ctx.ReadResource("aws:appmesh/virtualGateway:VirtualGateway", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering VirtualGateway resources.
type virtualGatewayState struct {
	// ARN of the virtual gateway.
	Arn *string `pulumi:"arn"`
	// Creation date of the virtual gateway.
	CreatedDate *string `pulumi:"createdDate"`
	// Last update date of the virtual gateway.
	LastUpdatedDate *string `pulumi:"lastUpdatedDate"`
	// Name of the service mesh in which to create the virtual gateway. Must be between 1 and 255 characters in length.
	MeshName *string `pulumi:"meshName"`
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner *string `pulumi:"meshOwner"`
	// Name to use for the virtual gateway. Must be between 1 and 255 characters in length.
	Name *string `pulumi:"name"`
	// Resource owner's AWS account ID.
	ResourceOwner *string `pulumi:"resourceOwner"`
	// Virtual gateway specification to apply.
	Spec *VirtualGatewaySpec `pulumi:"spec"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type VirtualGatewayState struct {
	// ARN of the virtual gateway.
	Arn pulumi.StringPtrInput
	// Creation date of the virtual gateway.
	CreatedDate pulumi.StringPtrInput
	// Last update date of the virtual gateway.
	LastUpdatedDate pulumi.StringPtrInput
	// Name of the service mesh in which to create the virtual gateway. Must be between 1 and 255 characters in length.
	MeshName pulumi.StringPtrInput
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner pulumi.StringPtrInput
	// Name to use for the virtual gateway. Must be between 1 and 255 characters in length.
	Name pulumi.StringPtrInput
	// Resource owner's AWS account ID.
	ResourceOwner pulumi.StringPtrInput
	// Virtual gateway specification to apply.
	Spec VirtualGatewaySpecPtrInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (VirtualGatewayState) ElementType() reflect.Type {
	return reflect.TypeOf((*virtualGatewayState)(nil)).Elem()
}

type virtualGatewayArgs struct {
	// Name of the service mesh in which to create the virtual gateway. Must be between 1 and 255 characters in length.
	MeshName string `pulumi:"meshName"`
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner *string `pulumi:"meshOwner"`
	// Name to use for the virtual gateway. Must be between 1 and 255 characters in length.
	Name *string `pulumi:"name"`
	// Virtual gateway specification to apply.
	Spec VirtualGatewaySpec `pulumi:"spec"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a VirtualGateway resource.
type VirtualGatewayArgs struct {
	// Name of the service mesh in which to create the virtual gateway. Must be between 1 and 255 characters in length.
	MeshName pulumi.StringInput
	// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
	MeshOwner pulumi.StringPtrInput
	// Name to use for the virtual gateway. Must be between 1 and 255 characters in length.
	Name pulumi.StringPtrInput
	// Virtual gateway specification to apply.
	Spec VirtualGatewaySpecInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (VirtualGatewayArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*virtualGatewayArgs)(nil)).Elem()
}

type VirtualGatewayInput interface {
	pulumi.Input

	ToVirtualGatewayOutput() VirtualGatewayOutput
	ToVirtualGatewayOutputWithContext(ctx context.Context) VirtualGatewayOutput
}

func (*VirtualGateway) ElementType() reflect.Type {
	return reflect.TypeOf((**VirtualGateway)(nil)).Elem()
}

func (i *VirtualGateway) ToVirtualGatewayOutput() VirtualGatewayOutput {
	return i.ToVirtualGatewayOutputWithContext(context.Background())
}

func (i *VirtualGateway) ToVirtualGatewayOutputWithContext(ctx context.Context) VirtualGatewayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VirtualGatewayOutput)
}

// VirtualGatewayArrayInput is an input type that accepts VirtualGatewayArray and VirtualGatewayArrayOutput values.
// You can construct a concrete instance of `VirtualGatewayArrayInput` via:
//
//	VirtualGatewayArray{ VirtualGatewayArgs{...} }
type VirtualGatewayArrayInput interface {
	pulumi.Input

	ToVirtualGatewayArrayOutput() VirtualGatewayArrayOutput
	ToVirtualGatewayArrayOutputWithContext(context.Context) VirtualGatewayArrayOutput
}

type VirtualGatewayArray []VirtualGatewayInput

func (VirtualGatewayArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*VirtualGateway)(nil)).Elem()
}

func (i VirtualGatewayArray) ToVirtualGatewayArrayOutput() VirtualGatewayArrayOutput {
	return i.ToVirtualGatewayArrayOutputWithContext(context.Background())
}

func (i VirtualGatewayArray) ToVirtualGatewayArrayOutputWithContext(ctx context.Context) VirtualGatewayArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VirtualGatewayArrayOutput)
}

// VirtualGatewayMapInput is an input type that accepts VirtualGatewayMap and VirtualGatewayMapOutput values.
// You can construct a concrete instance of `VirtualGatewayMapInput` via:
//
//	VirtualGatewayMap{ "key": VirtualGatewayArgs{...} }
type VirtualGatewayMapInput interface {
	pulumi.Input

	ToVirtualGatewayMapOutput() VirtualGatewayMapOutput
	ToVirtualGatewayMapOutputWithContext(context.Context) VirtualGatewayMapOutput
}

type VirtualGatewayMap map[string]VirtualGatewayInput

func (VirtualGatewayMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*VirtualGateway)(nil)).Elem()
}

func (i VirtualGatewayMap) ToVirtualGatewayMapOutput() VirtualGatewayMapOutput {
	return i.ToVirtualGatewayMapOutputWithContext(context.Background())
}

func (i VirtualGatewayMap) ToVirtualGatewayMapOutputWithContext(ctx context.Context) VirtualGatewayMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VirtualGatewayMapOutput)
}

type VirtualGatewayOutput struct{ *pulumi.OutputState }

func (VirtualGatewayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**VirtualGateway)(nil)).Elem()
}

func (o VirtualGatewayOutput) ToVirtualGatewayOutput() VirtualGatewayOutput {
	return o
}

func (o VirtualGatewayOutput) ToVirtualGatewayOutputWithContext(ctx context.Context) VirtualGatewayOutput {
	return o
}

// ARN of the virtual gateway.
func (o VirtualGatewayOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualGateway) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Creation date of the virtual gateway.
func (o VirtualGatewayOutput) CreatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualGateway) pulumi.StringOutput { return v.CreatedDate }).(pulumi.StringOutput)
}

// Last update date of the virtual gateway.
func (o VirtualGatewayOutput) LastUpdatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualGateway) pulumi.StringOutput { return v.LastUpdatedDate }).(pulumi.StringOutput)
}

// Name of the service mesh in which to create the virtual gateway. Must be between 1 and 255 characters in length.
func (o VirtualGatewayOutput) MeshName() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualGateway) pulumi.StringOutput { return v.MeshName }).(pulumi.StringOutput)
}

// AWS account ID of the service mesh's owner. Defaults to the account ID the AWS provider is currently connected to.
func (o VirtualGatewayOutput) MeshOwner() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualGateway) pulumi.StringOutput { return v.MeshOwner }).(pulumi.StringOutput)
}

// Name to use for the virtual gateway. Must be between 1 and 255 characters in length.
func (o VirtualGatewayOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualGateway) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Resource owner's AWS account ID.
func (o VirtualGatewayOutput) ResourceOwner() pulumi.StringOutput {
	return o.ApplyT(func(v *VirtualGateway) pulumi.StringOutput { return v.ResourceOwner }).(pulumi.StringOutput)
}

// Virtual gateway specification to apply.
func (o VirtualGatewayOutput) Spec() VirtualGatewaySpecOutput {
	return o.ApplyT(func(v *VirtualGateway) VirtualGatewaySpecOutput { return v.Spec }).(VirtualGatewaySpecOutput)
}

// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o VirtualGatewayOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *VirtualGateway) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o VirtualGatewayOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *VirtualGateway) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type VirtualGatewayArrayOutput struct{ *pulumi.OutputState }

func (VirtualGatewayArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*VirtualGateway)(nil)).Elem()
}

func (o VirtualGatewayArrayOutput) ToVirtualGatewayArrayOutput() VirtualGatewayArrayOutput {
	return o
}

func (o VirtualGatewayArrayOutput) ToVirtualGatewayArrayOutputWithContext(ctx context.Context) VirtualGatewayArrayOutput {
	return o
}

func (o VirtualGatewayArrayOutput) Index(i pulumi.IntInput) VirtualGatewayOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *VirtualGateway {
		return vs[0].([]*VirtualGateway)[vs[1].(int)]
	}).(VirtualGatewayOutput)
}

type VirtualGatewayMapOutput struct{ *pulumi.OutputState }

func (VirtualGatewayMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*VirtualGateway)(nil)).Elem()
}

func (o VirtualGatewayMapOutput) ToVirtualGatewayMapOutput() VirtualGatewayMapOutput {
	return o
}

func (o VirtualGatewayMapOutput) ToVirtualGatewayMapOutputWithContext(ctx context.Context) VirtualGatewayMapOutput {
	return o
}

func (o VirtualGatewayMapOutput) MapIndex(k pulumi.StringInput) VirtualGatewayOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *VirtualGateway {
		return vs[0].(map[string]*VirtualGateway)[vs[1].(string)]
	}).(VirtualGatewayOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*VirtualGatewayInput)(nil)).Elem(), &VirtualGateway{})
	pulumi.RegisterInputType(reflect.TypeOf((*VirtualGatewayArrayInput)(nil)).Elem(), VirtualGatewayArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*VirtualGatewayMapInput)(nil)).Elem(), VirtualGatewayMap{})
	pulumi.RegisterOutputType(VirtualGatewayOutput{})
	pulumi.RegisterOutputType(VirtualGatewayArrayOutput{})
	pulumi.RegisterOutputType(VirtualGatewayMapOutput{})
}
