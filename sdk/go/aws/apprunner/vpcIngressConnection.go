// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apprunner

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages an App Runner VPC Ingress Connection.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apprunner"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := apprunner.NewVpcIngressConnection(ctx, "example", &apprunner.VpcIngressConnectionArgs{
//				Name:       pulumi.String("example"),
//				ServiceArn: pulumi.Any(exampleAwsApprunnerService.Arn),
//				IngressVpcConfiguration: &apprunner.VpcIngressConnectionIngressVpcConfigurationArgs{
//					VpcId:         pulumi.Any(_default.Id),
//					VpcEndpointId: pulumi.Any(apprunner.Id),
//				},
//				Tags: pulumi.StringMap{
//					"foo": pulumi.String("bar"),
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
// Using `pulumi import`, import App Runner VPC Ingress Connection using the `arn`. For example:
//
// ```sh
// $ pulumi import aws:apprunner/vpcIngressConnection:VpcIngressConnection example "arn:aws:apprunner:us-west-2:837424938642:vpcingressconnection/example/b379f86381d74825832c2e82080342fa"
// ```
type VpcIngressConnection struct {
	pulumi.CustomResourceState

	// The Amazon Resource Name (ARN) of the VPC Ingress Connection.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The domain name associated with the VPC Ingress Connection resource.
	DomainName pulumi.StringOutput `pulumi:"domainName"`
	// Specifications for the customer’s Amazon VPC and the related AWS PrivateLink VPC endpoint that are used to create the VPC Ingress Connection resource. See Ingress VPC Configuration below for more details.
	IngressVpcConfiguration VpcIngressConnectionIngressVpcConfigurationOutput `pulumi:"ingressVpcConfiguration"`
	// A name for the VPC Ingress Connection resource. It must be unique across all the active VPC Ingress Connections in your AWS account in the AWS Region.
	Name pulumi.StringOutput `pulumi:"name"`
	// The Amazon Resource Name (ARN) for this App Runner service that is used to create the VPC Ingress Connection resource.
	ServiceArn pulumi.StringOutput `pulumi:"serviceArn"`
	// The current status of the VPC Ingress Connection.
	Status pulumi.StringOutput `pulumi:"status"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewVpcIngressConnection registers a new resource with the given unique name, arguments, and options.
func NewVpcIngressConnection(ctx *pulumi.Context,
	name string, args *VpcIngressConnectionArgs, opts ...pulumi.ResourceOption) (*VpcIngressConnection, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.IngressVpcConfiguration == nil {
		return nil, errors.New("invalid value for required argument 'IngressVpcConfiguration'")
	}
	if args.ServiceArn == nil {
		return nil, errors.New("invalid value for required argument 'ServiceArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource VpcIngressConnection
	err := ctx.RegisterResource("aws:apprunner/vpcIngressConnection:VpcIngressConnection", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetVpcIngressConnection gets an existing VpcIngressConnection resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetVpcIngressConnection(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *VpcIngressConnectionState, opts ...pulumi.ResourceOption) (*VpcIngressConnection, error) {
	var resource VpcIngressConnection
	err := ctx.ReadResource("aws:apprunner/vpcIngressConnection:VpcIngressConnection", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering VpcIngressConnection resources.
type vpcIngressConnectionState struct {
	// The Amazon Resource Name (ARN) of the VPC Ingress Connection.
	Arn *string `pulumi:"arn"`
	// The domain name associated with the VPC Ingress Connection resource.
	DomainName *string `pulumi:"domainName"`
	// Specifications for the customer’s Amazon VPC and the related AWS PrivateLink VPC endpoint that are used to create the VPC Ingress Connection resource. See Ingress VPC Configuration below for more details.
	IngressVpcConfiguration *VpcIngressConnectionIngressVpcConfiguration `pulumi:"ingressVpcConfiguration"`
	// A name for the VPC Ingress Connection resource. It must be unique across all the active VPC Ingress Connections in your AWS account in the AWS Region.
	Name *string `pulumi:"name"`
	// The Amazon Resource Name (ARN) for this App Runner service that is used to create the VPC Ingress Connection resource.
	ServiceArn *string `pulumi:"serviceArn"`
	// The current status of the VPC Ingress Connection.
	Status *string `pulumi:"status"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type VpcIngressConnectionState struct {
	// The Amazon Resource Name (ARN) of the VPC Ingress Connection.
	Arn pulumi.StringPtrInput
	// The domain name associated with the VPC Ingress Connection resource.
	DomainName pulumi.StringPtrInput
	// Specifications for the customer’s Amazon VPC and the related AWS PrivateLink VPC endpoint that are used to create the VPC Ingress Connection resource. See Ingress VPC Configuration below for more details.
	IngressVpcConfiguration VpcIngressConnectionIngressVpcConfigurationPtrInput
	// A name for the VPC Ingress Connection resource. It must be unique across all the active VPC Ingress Connections in your AWS account in the AWS Region.
	Name pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) for this App Runner service that is used to create the VPC Ingress Connection resource.
	ServiceArn pulumi.StringPtrInput
	// The current status of the VPC Ingress Connection.
	Status pulumi.StringPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (VpcIngressConnectionState) ElementType() reflect.Type {
	return reflect.TypeOf((*vpcIngressConnectionState)(nil)).Elem()
}

type vpcIngressConnectionArgs struct {
	// Specifications for the customer’s Amazon VPC and the related AWS PrivateLink VPC endpoint that are used to create the VPC Ingress Connection resource. See Ingress VPC Configuration below for more details.
	IngressVpcConfiguration VpcIngressConnectionIngressVpcConfiguration `pulumi:"ingressVpcConfiguration"`
	// A name for the VPC Ingress Connection resource. It must be unique across all the active VPC Ingress Connections in your AWS account in the AWS Region.
	Name *string `pulumi:"name"`
	// The Amazon Resource Name (ARN) for this App Runner service that is used to create the VPC Ingress Connection resource.
	ServiceArn string `pulumi:"serviceArn"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a VpcIngressConnection resource.
type VpcIngressConnectionArgs struct {
	// Specifications for the customer’s Amazon VPC and the related AWS PrivateLink VPC endpoint that are used to create the VPC Ingress Connection resource. See Ingress VPC Configuration below for more details.
	IngressVpcConfiguration VpcIngressConnectionIngressVpcConfigurationInput
	// A name for the VPC Ingress Connection resource. It must be unique across all the active VPC Ingress Connections in your AWS account in the AWS Region.
	Name pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) for this App Runner service that is used to create the VPC Ingress Connection resource.
	ServiceArn pulumi.StringInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (VpcIngressConnectionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*vpcIngressConnectionArgs)(nil)).Elem()
}

type VpcIngressConnectionInput interface {
	pulumi.Input

	ToVpcIngressConnectionOutput() VpcIngressConnectionOutput
	ToVpcIngressConnectionOutputWithContext(ctx context.Context) VpcIngressConnectionOutput
}

func (*VpcIngressConnection) ElementType() reflect.Type {
	return reflect.TypeOf((**VpcIngressConnection)(nil)).Elem()
}

func (i *VpcIngressConnection) ToVpcIngressConnectionOutput() VpcIngressConnectionOutput {
	return i.ToVpcIngressConnectionOutputWithContext(context.Background())
}

func (i *VpcIngressConnection) ToVpcIngressConnectionOutputWithContext(ctx context.Context) VpcIngressConnectionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VpcIngressConnectionOutput)
}

// VpcIngressConnectionArrayInput is an input type that accepts VpcIngressConnectionArray and VpcIngressConnectionArrayOutput values.
// You can construct a concrete instance of `VpcIngressConnectionArrayInput` via:
//
//	VpcIngressConnectionArray{ VpcIngressConnectionArgs{...} }
type VpcIngressConnectionArrayInput interface {
	pulumi.Input

	ToVpcIngressConnectionArrayOutput() VpcIngressConnectionArrayOutput
	ToVpcIngressConnectionArrayOutputWithContext(context.Context) VpcIngressConnectionArrayOutput
}

type VpcIngressConnectionArray []VpcIngressConnectionInput

func (VpcIngressConnectionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*VpcIngressConnection)(nil)).Elem()
}

func (i VpcIngressConnectionArray) ToVpcIngressConnectionArrayOutput() VpcIngressConnectionArrayOutput {
	return i.ToVpcIngressConnectionArrayOutputWithContext(context.Background())
}

func (i VpcIngressConnectionArray) ToVpcIngressConnectionArrayOutputWithContext(ctx context.Context) VpcIngressConnectionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VpcIngressConnectionArrayOutput)
}

// VpcIngressConnectionMapInput is an input type that accepts VpcIngressConnectionMap and VpcIngressConnectionMapOutput values.
// You can construct a concrete instance of `VpcIngressConnectionMapInput` via:
//
//	VpcIngressConnectionMap{ "key": VpcIngressConnectionArgs{...} }
type VpcIngressConnectionMapInput interface {
	pulumi.Input

	ToVpcIngressConnectionMapOutput() VpcIngressConnectionMapOutput
	ToVpcIngressConnectionMapOutputWithContext(context.Context) VpcIngressConnectionMapOutput
}

type VpcIngressConnectionMap map[string]VpcIngressConnectionInput

func (VpcIngressConnectionMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*VpcIngressConnection)(nil)).Elem()
}

func (i VpcIngressConnectionMap) ToVpcIngressConnectionMapOutput() VpcIngressConnectionMapOutput {
	return i.ToVpcIngressConnectionMapOutputWithContext(context.Background())
}

func (i VpcIngressConnectionMap) ToVpcIngressConnectionMapOutputWithContext(ctx context.Context) VpcIngressConnectionMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(VpcIngressConnectionMapOutput)
}

type VpcIngressConnectionOutput struct{ *pulumi.OutputState }

func (VpcIngressConnectionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**VpcIngressConnection)(nil)).Elem()
}

func (o VpcIngressConnectionOutput) ToVpcIngressConnectionOutput() VpcIngressConnectionOutput {
	return o
}

func (o VpcIngressConnectionOutput) ToVpcIngressConnectionOutputWithContext(ctx context.Context) VpcIngressConnectionOutput {
	return o
}

// The Amazon Resource Name (ARN) of the VPC Ingress Connection.
func (o VpcIngressConnectionOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *VpcIngressConnection) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The domain name associated with the VPC Ingress Connection resource.
func (o VpcIngressConnectionOutput) DomainName() pulumi.StringOutput {
	return o.ApplyT(func(v *VpcIngressConnection) pulumi.StringOutput { return v.DomainName }).(pulumi.StringOutput)
}

// Specifications for the customer’s Amazon VPC and the related AWS PrivateLink VPC endpoint that are used to create the VPC Ingress Connection resource. See Ingress VPC Configuration below for more details.
func (o VpcIngressConnectionOutput) IngressVpcConfiguration() VpcIngressConnectionIngressVpcConfigurationOutput {
	return o.ApplyT(func(v *VpcIngressConnection) VpcIngressConnectionIngressVpcConfigurationOutput {
		return v.IngressVpcConfiguration
	}).(VpcIngressConnectionIngressVpcConfigurationOutput)
}

// A name for the VPC Ingress Connection resource. It must be unique across all the active VPC Ingress Connections in your AWS account in the AWS Region.
func (o VpcIngressConnectionOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *VpcIngressConnection) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The Amazon Resource Name (ARN) for this App Runner service that is used to create the VPC Ingress Connection resource.
func (o VpcIngressConnectionOutput) ServiceArn() pulumi.StringOutput {
	return o.ApplyT(func(v *VpcIngressConnection) pulumi.StringOutput { return v.ServiceArn }).(pulumi.StringOutput)
}

// The current status of the VPC Ingress Connection.
func (o VpcIngressConnectionOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *VpcIngressConnection) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o VpcIngressConnectionOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *VpcIngressConnection) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o VpcIngressConnectionOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *VpcIngressConnection) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type VpcIngressConnectionArrayOutput struct{ *pulumi.OutputState }

func (VpcIngressConnectionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*VpcIngressConnection)(nil)).Elem()
}

func (o VpcIngressConnectionArrayOutput) ToVpcIngressConnectionArrayOutput() VpcIngressConnectionArrayOutput {
	return o
}

func (o VpcIngressConnectionArrayOutput) ToVpcIngressConnectionArrayOutputWithContext(ctx context.Context) VpcIngressConnectionArrayOutput {
	return o
}

func (o VpcIngressConnectionArrayOutput) Index(i pulumi.IntInput) VpcIngressConnectionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *VpcIngressConnection {
		return vs[0].([]*VpcIngressConnection)[vs[1].(int)]
	}).(VpcIngressConnectionOutput)
}

type VpcIngressConnectionMapOutput struct{ *pulumi.OutputState }

func (VpcIngressConnectionMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*VpcIngressConnection)(nil)).Elem()
}

func (o VpcIngressConnectionMapOutput) ToVpcIngressConnectionMapOutput() VpcIngressConnectionMapOutput {
	return o
}

func (o VpcIngressConnectionMapOutput) ToVpcIngressConnectionMapOutputWithContext(ctx context.Context) VpcIngressConnectionMapOutput {
	return o
}

func (o VpcIngressConnectionMapOutput) MapIndex(k pulumi.StringInput) VpcIngressConnectionOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *VpcIngressConnection {
		return vs[0].(map[string]*VpcIngressConnection)[vs[1].(string)]
	}).(VpcIngressConnectionOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*VpcIngressConnectionInput)(nil)).Elem(), &VpcIngressConnection{})
	pulumi.RegisterInputType(reflect.TypeOf((*VpcIngressConnectionArrayInput)(nil)).Elem(), VpcIngressConnectionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*VpcIngressConnectionMapInput)(nil)).Elem(), VpcIngressConnectionMap{})
	pulumi.RegisterOutputType(VpcIngressConnectionOutput{})
	pulumi.RegisterOutputType(VpcIngressConnectionArrayOutput{})
	pulumi.RegisterOutputType(VpcIngressConnectionMapOutput{})
}
