// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lightsail

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages public ports for a Lightsail instance. Use this resource to open ports for a specific Amazon Lightsail instance and specify the IP addresses allowed to connect to the instance through the ports and the protocol.
//
// > See [What is Amazon Lightsail?](https://lightsail.aws.amazon.com/ls/docs/getting-started/article/what-is-amazon-lightsail) for more information.
//
// > **Note:** Lightsail is currently only supported in a limited number of AWS Regions, please see ["Regions and Availability Zones in Amazon Lightsail"](https://lightsail.aws.amazon.com/ls/docs/overview/article/understanding-regions-and-availability-zones-in-amazon-lightsail) for more details.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lightsail"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			available, err := aws.GetAvailabilityZones(ctx, &aws.GetAvailabilityZonesArgs{
//				State: pulumi.StringRef("available"),
//				Filters: []aws.GetAvailabilityZonesFilter{
//					{
//						Name: "opt-in-status",
//						Values: []string{
//							"opt-in-not-required",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			example, err := lightsail.NewInstance(ctx, "example", &lightsail.InstanceArgs{
//				Name:             pulumi.String("example-instance"),
//				AvailabilityZone: pulumi.String(available.Names[0]),
//				BlueprintId:      pulumi.String("amazon_linux_2"),
//				BundleId:         pulumi.String("nano_3_0"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = lightsail.NewInstancePublicPorts(ctx, "example", &lightsail.InstancePublicPortsArgs{
//				InstanceName: example.Name,
//				PortInfos: lightsail.InstancePublicPortsPortInfoArray{
//					&lightsail.InstancePublicPortsPortInfoArgs{
//						Protocol: pulumi.String("tcp"),
//						FromPort: pulumi.Int(80),
//						ToPort:   pulumi.Int(80),
//					},
//					&lightsail.InstancePublicPortsPortInfoArgs{
//						Protocol: pulumi.String("tcp"),
//						FromPort: pulumi.Int(443),
//						ToPort:   pulumi.Int(443),
//						Cidrs: pulumi.StringArray{
//							pulumi.String("192.168.1.0/24"),
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
type InstancePublicPorts struct {
	pulumi.CustomResourceState

	// Name of the Lightsail Instance.
	InstanceName pulumi.StringOutput `pulumi:"instanceName"`
	// Configuration block with port information. AWS closes all currently open ports that are not included in the `portInfo`. See below.
	PortInfos InstancePublicPortsPortInfoArrayOutput `pulumi:"portInfos"`
}

// NewInstancePublicPorts registers a new resource with the given unique name, arguments, and options.
func NewInstancePublicPorts(ctx *pulumi.Context,
	name string, args *InstancePublicPortsArgs, opts ...pulumi.ResourceOption) (*InstancePublicPorts, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.InstanceName == nil {
		return nil, errors.New("invalid value for required argument 'InstanceName'")
	}
	if args.PortInfos == nil {
		return nil, errors.New("invalid value for required argument 'PortInfos'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource InstancePublicPorts
	err := ctx.RegisterResource("aws:lightsail/instancePublicPorts:InstancePublicPorts", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetInstancePublicPorts gets an existing InstancePublicPorts resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetInstancePublicPorts(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *InstancePublicPortsState, opts ...pulumi.ResourceOption) (*InstancePublicPorts, error) {
	var resource InstancePublicPorts
	err := ctx.ReadResource("aws:lightsail/instancePublicPorts:InstancePublicPorts", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering InstancePublicPorts resources.
type instancePublicPortsState struct {
	// Name of the Lightsail Instance.
	InstanceName *string `pulumi:"instanceName"`
	// Configuration block with port information. AWS closes all currently open ports that are not included in the `portInfo`. See below.
	PortInfos []InstancePublicPortsPortInfo `pulumi:"portInfos"`
}

type InstancePublicPortsState struct {
	// Name of the Lightsail Instance.
	InstanceName pulumi.StringPtrInput
	// Configuration block with port information. AWS closes all currently open ports that are not included in the `portInfo`. See below.
	PortInfos InstancePublicPortsPortInfoArrayInput
}

func (InstancePublicPortsState) ElementType() reflect.Type {
	return reflect.TypeOf((*instancePublicPortsState)(nil)).Elem()
}

type instancePublicPortsArgs struct {
	// Name of the Lightsail Instance.
	InstanceName string `pulumi:"instanceName"`
	// Configuration block with port information. AWS closes all currently open ports that are not included in the `portInfo`. See below.
	PortInfos []InstancePublicPortsPortInfo `pulumi:"portInfos"`
}

// The set of arguments for constructing a InstancePublicPorts resource.
type InstancePublicPortsArgs struct {
	// Name of the Lightsail Instance.
	InstanceName pulumi.StringInput
	// Configuration block with port information. AWS closes all currently open ports that are not included in the `portInfo`. See below.
	PortInfos InstancePublicPortsPortInfoArrayInput
}

func (InstancePublicPortsArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*instancePublicPortsArgs)(nil)).Elem()
}

type InstancePublicPortsInput interface {
	pulumi.Input

	ToInstancePublicPortsOutput() InstancePublicPortsOutput
	ToInstancePublicPortsOutputWithContext(ctx context.Context) InstancePublicPortsOutput
}

func (*InstancePublicPorts) ElementType() reflect.Type {
	return reflect.TypeOf((**InstancePublicPorts)(nil)).Elem()
}

func (i *InstancePublicPorts) ToInstancePublicPortsOutput() InstancePublicPortsOutput {
	return i.ToInstancePublicPortsOutputWithContext(context.Background())
}

func (i *InstancePublicPorts) ToInstancePublicPortsOutputWithContext(ctx context.Context) InstancePublicPortsOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InstancePublicPortsOutput)
}

// InstancePublicPortsArrayInput is an input type that accepts InstancePublicPortsArray and InstancePublicPortsArrayOutput values.
// You can construct a concrete instance of `InstancePublicPortsArrayInput` via:
//
//	InstancePublicPortsArray{ InstancePublicPortsArgs{...} }
type InstancePublicPortsArrayInput interface {
	pulumi.Input

	ToInstancePublicPortsArrayOutput() InstancePublicPortsArrayOutput
	ToInstancePublicPortsArrayOutputWithContext(context.Context) InstancePublicPortsArrayOutput
}

type InstancePublicPortsArray []InstancePublicPortsInput

func (InstancePublicPortsArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*InstancePublicPorts)(nil)).Elem()
}

func (i InstancePublicPortsArray) ToInstancePublicPortsArrayOutput() InstancePublicPortsArrayOutput {
	return i.ToInstancePublicPortsArrayOutputWithContext(context.Background())
}

func (i InstancePublicPortsArray) ToInstancePublicPortsArrayOutputWithContext(ctx context.Context) InstancePublicPortsArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InstancePublicPortsArrayOutput)
}

// InstancePublicPortsMapInput is an input type that accepts InstancePublicPortsMap and InstancePublicPortsMapOutput values.
// You can construct a concrete instance of `InstancePublicPortsMapInput` via:
//
//	InstancePublicPortsMap{ "key": InstancePublicPortsArgs{...} }
type InstancePublicPortsMapInput interface {
	pulumi.Input

	ToInstancePublicPortsMapOutput() InstancePublicPortsMapOutput
	ToInstancePublicPortsMapOutputWithContext(context.Context) InstancePublicPortsMapOutput
}

type InstancePublicPortsMap map[string]InstancePublicPortsInput

func (InstancePublicPortsMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*InstancePublicPorts)(nil)).Elem()
}

func (i InstancePublicPortsMap) ToInstancePublicPortsMapOutput() InstancePublicPortsMapOutput {
	return i.ToInstancePublicPortsMapOutputWithContext(context.Background())
}

func (i InstancePublicPortsMap) ToInstancePublicPortsMapOutputWithContext(ctx context.Context) InstancePublicPortsMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(InstancePublicPortsMapOutput)
}

type InstancePublicPortsOutput struct{ *pulumi.OutputState }

func (InstancePublicPortsOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**InstancePublicPorts)(nil)).Elem()
}

func (o InstancePublicPortsOutput) ToInstancePublicPortsOutput() InstancePublicPortsOutput {
	return o
}

func (o InstancePublicPortsOutput) ToInstancePublicPortsOutputWithContext(ctx context.Context) InstancePublicPortsOutput {
	return o
}

// Name of the Lightsail Instance.
func (o InstancePublicPortsOutput) InstanceName() pulumi.StringOutput {
	return o.ApplyT(func(v *InstancePublicPorts) pulumi.StringOutput { return v.InstanceName }).(pulumi.StringOutput)
}

// Configuration block with port information. AWS closes all currently open ports that are not included in the `portInfo`. See below.
func (o InstancePublicPortsOutput) PortInfos() InstancePublicPortsPortInfoArrayOutput {
	return o.ApplyT(func(v *InstancePublicPorts) InstancePublicPortsPortInfoArrayOutput { return v.PortInfos }).(InstancePublicPortsPortInfoArrayOutput)
}

type InstancePublicPortsArrayOutput struct{ *pulumi.OutputState }

func (InstancePublicPortsArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*InstancePublicPorts)(nil)).Elem()
}

func (o InstancePublicPortsArrayOutput) ToInstancePublicPortsArrayOutput() InstancePublicPortsArrayOutput {
	return o
}

func (o InstancePublicPortsArrayOutput) ToInstancePublicPortsArrayOutputWithContext(ctx context.Context) InstancePublicPortsArrayOutput {
	return o
}

func (o InstancePublicPortsArrayOutput) Index(i pulumi.IntInput) InstancePublicPortsOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *InstancePublicPorts {
		return vs[0].([]*InstancePublicPorts)[vs[1].(int)]
	}).(InstancePublicPortsOutput)
}

type InstancePublicPortsMapOutput struct{ *pulumi.OutputState }

func (InstancePublicPortsMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*InstancePublicPorts)(nil)).Elem()
}

func (o InstancePublicPortsMapOutput) ToInstancePublicPortsMapOutput() InstancePublicPortsMapOutput {
	return o
}

func (o InstancePublicPortsMapOutput) ToInstancePublicPortsMapOutputWithContext(ctx context.Context) InstancePublicPortsMapOutput {
	return o
}

func (o InstancePublicPortsMapOutput) MapIndex(k pulumi.StringInput) InstancePublicPortsOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *InstancePublicPorts {
		return vs[0].(map[string]*InstancePublicPorts)[vs[1].(string)]
	}).(InstancePublicPortsOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*InstancePublicPortsInput)(nil)).Elem(), &InstancePublicPorts{})
	pulumi.RegisterInputType(reflect.TypeOf((*InstancePublicPortsArrayInput)(nil)).Elem(), InstancePublicPortsArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*InstancePublicPortsMapInput)(nil)).Elem(), InstancePublicPortsMap{})
	pulumi.RegisterOutputType(InstancePublicPortsOutput{})
	pulumi.RegisterOutputType(InstancePublicPortsArrayOutput{})
	pulumi.RegisterOutputType(InstancePublicPortsMapOutput{})
}
