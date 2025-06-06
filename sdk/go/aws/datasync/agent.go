// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package datasync

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages an AWS DataSync Agent deployed on premises.
//
// > **NOTE:** One of `activationKey` or `ipAddress` must be provided for resource creation (agent activation). Neither is required for resource import. If using `ipAddress`, this provider must be able to make an HTTP (port 80) GET request to the specified IP address from where it is running. The agent will turn off that HTTP server after activation.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/datasync"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := datasync.NewAgent(ctx, "example", &datasync.AgentArgs{
//				IpAddress: pulumi.String("1.2.3.4"),
//				Name:      pulumi.String("example"),
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
// ### With VPC Endpoints
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/datasync"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ec2"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			current, err := aws.GetRegion(ctx, &aws.GetRegionArgs{}, nil)
//			if err != nil {
//				return err
//			}
//			exampleVpcEndpoint, err := ec2.NewVpcEndpoint(ctx, "example", &ec2.VpcEndpointArgs{
//				ServiceName: pulumi.Sprintf("com.amazonaws.%v.datasync", current.Name),
//				VpcId:       pulumi.Any(exampleAwsVpc.Id),
//				SecurityGroupIds: pulumi.StringArray{
//					exampleAwsSecurityGroup.Id,
//				},
//				SubnetIds: pulumi.StringArray{
//					exampleAwsSubnet.Id,
//				},
//				VpcEndpointType: pulumi.String("Interface"),
//			})
//			if err != nil {
//				return err
//			}
//			example := ec2.LookupNetworkInterfaceOutput(ctx, ec2.GetNetworkInterfaceOutputArgs{
//				Id: exampleVpcEndpoint.NetworkInterfaceIds.ApplyT(func(networkInterfaceIds []string) (string, error) {
//					return networkInterfaceIds[0], nil
//				}).(pulumi.StringOutput),
//			}, nil)
//			_, err = datasync.NewAgent(ctx, "example", &datasync.AgentArgs{
//				IpAddress: pulumi.String("1.2.3.4"),
//				SecurityGroupArns: pulumi.StringArray{
//					exampleAwsSecurityGroup.Arn,
//				},
//				SubnetArns: pulumi.StringArray{
//					exampleAwsSubnet.Arn,
//				},
//				VpcEndpointId: exampleVpcEndpoint.ID(),
//				PrivateLinkEndpoint: pulumi.String(example.ApplyT(func(example ec2.GetNetworkInterfaceResult) (*string, error) {
//					return &example.PrivateIp, nil
//				}).(pulumi.StringPtrOutput)),
//				Name: pulumi.String("example"),
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
// Using `pulumi import`, import `aws_datasync_agent` using the DataSync Agent Amazon Resource Name (ARN). For example:
//
// ```sh
// $ pulumi import aws:datasync/agent:Agent example arn:aws:datasync:us-east-1:123456789012:agent/agent-12345678901234567
// ```
type Agent struct {
	pulumi.CustomResourceState

	// DataSync Agent activation key during resource creation. Conflicts with `ipAddress`. If an `ipAddress` is provided instead, the provider will retrieve the `activationKey` as part of the resource creation.
	ActivationKey pulumi.StringOutput `pulumi:"activationKey"`
	// Amazon Resource Name (ARN) of the DataSync Agent.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// DataSync Agent IP address to retrieve activation key during resource creation. Conflicts with `activationKey`. DataSync Agent must be accessible on port 80 from where the provider is running.
	IpAddress pulumi.StringOutput `pulumi:"ipAddress"`
	// Name of the DataSync Agent.
	Name pulumi.StringOutput `pulumi:"name"`
	// The IP address of the VPC endpoint the agent should connect to when retrieving an activation key during resource creation. Conflicts with `activationKey`.
	PrivateLinkEndpoint pulumi.StringOutput `pulumi:"privateLinkEndpoint"`
	// The ARNs of the security groups used to protect your data transfer task subnets.
	SecurityGroupArns pulumi.StringArrayOutput `pulumi:"securityGroupArns"`
	// The Amazon Resource Names (ARNs) of the subnets in which DataSync will create elastic network interfaces for each data transfer task.
	SubnetArns pulumi.StringArrayOutput `pulumi:"subnetArns"`
	// Key-value pairs of resource tags to assign to the DataSync Agent. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The ID of the VPC (virtual private cloud) endpoint that the agent has access to.
	VpcEndpointId pulumi.StringPtrOutput `pulumi:"vpcEndpointId"`
}

// NewAgent registers a new resource with the given unique name, arguments, and options.
func NewAgent(ctx *pulumi.Context,
	name string, args *AgentArgs, opts ...pulumi.ResourceOption) (*Agent, error) {
	if args == nil {
		args = &AgentArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Agent
	err := ctx.RegisterResource("aws:datasync/agent:Agent", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAgent gets an existing Agent resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAgent(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AgentState, opts ...pulumi.ResourceOption) (*Agent, error) {
	var resource Agent
	err := ctx.ReadResource("aws:datasync/agent:Agent", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Agent resources.
type agentState struct {
	// DataSync Agent activation key during resource creation. Conflicts with `ipAddress`. If an `ipAddress` is provided instead, the provider will retrieve the `activationKey` as part of the resource creation.
	ActivationKey *string `pulumi:"activationKey"`
	// Amazon Resource Name (ARN) of the DataSync Agent.
	Arn *string `pulumi:"arn"`
	// DataSync Agent IP address to retrieve activation key during resource creation. Conflicts with `activationKey`. DataSync Agent must be accessible on port 80 from where the provider is running.
	IpAddress *string `pulumi:"ipAddress"`
	// Name of the DataSync Agent.
	Name *string `pulumi:"name"`
	// The IP address of the VPC endpoint the agent should connect to when retrieving an activation key during resource creation. Conflicts with `activationKey`.
	PrivateLinkEndpoint *string `pulumi:"privateLinkEndpoint"`
	// The ARNs of the security groups used to protect your data transfer task subnets.
	SecurityGroupArns []string `pulumi:"securityGroupArns"`
	// The Amazon Resource Names (ARNs) of the subnets in which DataSync will create elastic network interfaces for each data transfer task.
	SubnetArns []string `pulumi:"subnetArns"`
	// Key-value pairs of resource tags to assign to the DataSync Agent. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The ID of the VPC (virtual private cloud) endpoint that the agent has access to.
	VpcEndpointId *string `pulumi:"vpcEndpointId"`
}

type AgentState struct {
	// DataSync Agent activation key during resource creation. Conflicts with `ipAddress`. If an `ipAddress` is provided instead, the provider will retrieve the `activationKey` as part of the resource creation.
	ActivationKey pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the DataSync Agent.
	Arn pulumi.StringPtrInput
	// DataSync Agent IP address to retrieve activation key during resource creation. Conflicts with `activationKey`. DataSync Agent must be accessible on port 80 from where the provider is running.
	IpAddress pulumi.StringPtrInput
	// Name of the DataSync Agent.
	Name pulumi.StringPtrInput
	// The IP address of the VPC endpoint the agent should connect to when retrieving an activation key during resource creation. Conflicts with `activationKey`.
	PrivateLinkEndpoint pulumi.StringPtrInput
	// The ARNs of the security groups used to protect your data transfer task subnets.
	SecurityGroupArns pulumi.StringArrayInput
	// The Amazon Resource Names (ARNs) of the subnets in which DataSync will create elastic network interfaces for each data transfer task.
	SubnetArns pulumi.StringArrayInput
	// Key-value pairs of resource tags to assign to the DataSync Agent. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The ID of the VPC (virtual private cloud) endpoint that the agent has access to.
	VpcEndpointId pulumi.StringPtrInput
}

func (AgentState) ElementType() reflect.Type {
	return reflect.TypeOf((*agentState)(nil)).Elem()
}

type agentArgs struct {
	// DataSync Agent activation key during resource creation. Conflicts with `ipAddress`. If an `ipAddress` is provided instead, the provider will retrieve the `activationKey` as part of the resource creation.
	ActivationKey *string `pulumi:"activationKey"`
	// DataSync Agent IP address to retrieve activation key during resource creation. Conflicts with `activationKey`. DataSync Agent must be accessible on port 80 from where the provider is running.
	IpAddress *string `pulumi:"ipAddress"`
	// Name of the DataSync Agent.
	Name *string `pulumi:"name"`
	// The IP address of the VPC endpoint the agent should connect to when retrieving an activation key during resource creation. Conflicts with `activationKey`.
	PrivateLinkEndpoint *string `pulumi:"privateLinkEndpoint"`
	// The ARNs of the security groups used to protect your data transfer task subnets.
	SecurityGroupArns []string `pulumi:"securityGroupArns"`
	// The Amazon Resource Names (ARNs) of the subnets in which DataSync will create elastic network interfaces for each data transfer task.
	SubnetArns []string `pulumi:"subnetArns"`
	// Key-value pairs of resource tags to assign to the DataSync Agent. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// The ID of the VPC (virtual private cloud) endpoint that the agent has access to.
	VpcEndpointId *string `pulumi:"vpcEndpointId"`
}

// The set of arguments for constructing a Agent resource.
type AgentArgs struct {
	// DataSync Agent activation key during resource creation. Conflicts with `ipAddress`. If an `ipAddress` is provided instead, the provider will retrieve the `activationKey` as part of the resource creation.
	ActivationKey pulumi.StringPtrInput
	// DataSync Agent IP address to retrieve activation key during resource creation. Conflicts with `activationKey`. DataSync Agent must be accessible on port 80 from where the provider is running.
	IpAddress pulumi.StringPtrInput
	// Name of the DataSync Agent.
	Name pulumi.StringPtrInput
	// The IP address of the VPC endpoint the agent should connect to when retrieving an activation key during resource creation. Conflicts with `activationKey`.
	PrivateLinkEndpoint pulumi.StringPtrInput
	// The ARNs of the security groups used to protect your data transfer task subnets.
	SecurityGroupArns pulumi.StringArrayInput
	// The Amazon Resource Names (ARNs) of the subnets in which DataSync will create elastic network interfaces for each data transfer task.
	SubnetArns pulumi.StringArrayInput
	// Key-value pairs of resource tags to assign to the DataSync Agent. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// The ID of the VPC (virtual private cloud) endpoint that the agent has access to.
	VpcEndpointId pulumi.StringPtrInput
}

func (AgentArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*agentArgs)(nil)).Elem()
}

type AgentInput interface {
	pulumi.Input

	ToAgentOutput() AgentOutput
	ToAgentOutputWithContext(ctx context.Context) AgentOutput
}

func (*Agent) ElementType() reflect.Type {
	return reflect.TypeOf((**Agent)(nil)).Elem()
}

func (i *Agent) ToAgentOutput() AgentOutput {
	return i.ToAgentOutputWithContext(context.Background())
}

func (i *Agent) ToAgentOutputWithContext(ctx context.Context) AgentOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AgentOutput)
}

// AgentArrayInput is an input type that accepts AgentArray and AgentArrayOutput values.
// You can construct a concrete instance of `AgentArrayInput` via:
//
//	AgentArray{ AgentArgs{...} }
type AgentArrayInput interface {
	pulumi.Input

	ToAgentArrayOutput() AgentArrayOutput
	ToAgentArrayOutputWithContext(context.Context) AgentArrayOutput
}

type AgentArray []AgentInput

func (AgentArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Agent)(nil)).Elem()
}

func (i AgentArray) ToAgentArrayOutput() AgentArrayOutput {
	return i.ToAgentArrayOutputWithContext(context.Background())
}

func (i AgentArray) ToAgentArrayOutputWithContext(ctx context.Context) AgentArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AgentArrayOutput)
}

// AgentMapInput is an input type that accepts AgentMap and AgentMapOutput values.
// You can construct a concrete instance of `AgentMapInput` via:
//
//	AgentMap{ "key": AgentArgs{...} }
type AgentMapInput interface {
	pulumi.Input

	ToAgentMapOutput() AgentMapOutput
	ToAgentMapOutputWithContext(context.Context) AgentMapOutput
}

type AgentMap map[string]AgentInput

func (AgentMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Agent)(nil)).Elem()
}

func (i AgentMap) ToAgentMapOutput() AgentMapOutput {
	return i.ToAgentMapOutputWithContext(context.Background())
}

func (i AgentMap) ToAgentMapOutputWithContext(ctx context.Context) AgentMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AgentMapOutput)
}

type AgentOutput struct{ *pulumi.OutputState }

func (AgentOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Agent)(nil)).Elem()
}

func (o AgentOutput) ToAgentOutput() AgentOutput {
	return o
}

func (o AgentOutput) ToAgentOutputWithContext(ctx context.Context) AgentOutput {
	return o
}

// DataSync Agent activation key during resource creation. Conflicts with `ipAddress`. If an `ipAddress` is provided instead, the provider will retrieve the `activationKey` as part of the resource creation.
func (o AgentOutput) ActivationKey() pulumi.StringOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringOutput { return v.ActivationKey }).(pulumi.StringOutput)
}

// Amazon Resource Name (ARN) of the DataSync Agent.
func (o AgentOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// DataSync Agent IP address to retrieve activation key during resource creation. Conflicts with `activationKey`. DataSync Agent must be accessible on port 80 from where the provider is running.
func (o AgentOutput) IpAddress() pulumi.StringOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringOutput { return v.IpAddress }).(pulumi.StringOutput)
}

// Name of the DataSync Agent.
func (o AgentOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The IP address of the VPC endpoint the agent should connect to when retrieving an activation key during resource creation. Conflicts with `activationKey`.
func (o AgentOutput) PrivateLinkEndpoint() pulumi.StringOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringOutput { return v.PrivateLinkEndpoint }).(pulumi.StringOutput)
}

// The ARNs of the security groups used to protect your data transfer task subnets.
func (o AgentOutput) SecurityGroupArns() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringArrayOutput { return v.SecurityGroupArns }).(pulumi.StringArrayOutput)
}

// The Amazon Resource Names (ARNs) of the subnets in which DataSync will create elastic network interfaces for each data transfer task.
func (o AgentOutput) SubnetArns() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringArrayOutput { return v.SubnetArns }).(pulumi.StringArrayOutput)
}

// Key-value pairs of resource tags to assign to the DataSync Agent. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o AgentOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o AgentOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The ID of the VPC (virtual private cloud) endpoint that the agent has access to.
func (o AgentOutput) VpcEndpointId() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Agent) pulumi.StringPtrOutput { return v.VpcEndpointId }).(pulumi.StringPtrOutput)
}

type AgentArrayOutput struct{ *pulumi.OutputState }

func (AgentArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Agent)(nil)).Elem()
}

func (o AgentArrayOutput) ToAgentArrayOutput() AgentArrayOutput {
	return o
}

func (o AgentArrayOutput) ToAgentArrayOutputWithContext(ctx context.Context) AgentArrayOutput {
	return o
}

func (o AgentArrayOutput) Index(i pulumi.IntInput) AgentOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Agent {
		return vs[0].([]*Agent)[vs[1].(int)]
	}).(AgentOutput)
}

type AgentMapOutput struct{ *pulumi.OutputState }

func (AgentMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Agent)(nil)).Elem()
}

func (o AgentMapOutput) ToAgentMapOutput() AgentMapOutput {
	return o
}

func (o AgentMapOutput) ToAgentMapOutputWithContext(ctx context.Context) AgentMapOutput {
	return o
}

func (o AgentMapOutput) MapIndex(k pulumi.StringInput) AgentOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Agent {
		return vs[0].(map[string]*Agent)[vs[1].(string)]
	}).(AgentOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AgentInput)(nil)).Elem(), &Agent{})
	pulumi.RegisterInputType(reflect.TypeOf((*AgentArrayInput)(nil)).Elem(), AgentArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AgentMapInput)(nil)).Elem(), AgentMap{})
	pulumi.RegisterOutputType(AgentOutput{})
	pulumi.RegisterOutputType(AgentArrayOutput{})
	pulumi.RegisterOutputType(AgentMapOutput{})
}
