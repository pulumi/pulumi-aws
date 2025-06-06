// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package redshiftserverless

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Creates a new Amazon Redshift Serverless Workgroup.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/redshiftserverless"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := redshiftserverless.NewWorkgroup(ctx, "example", &redshiftserverless.WorkgroupArgs{
//				NamespaceName: pulumi.String("concurrency-scaling"),
//				WorkgroupName: pulumi.String("concurrency-scaling"),
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
// Using `pulumi import`, import Redshift Serverless Workgroups using the `workgroup_name`. For example:
//
// ```sh
// $ pulumi import aws:redshiftserverless/workgroup:Workgroup example example
// ```
type Workgroup struct {
	pulumi.CustomResourceState

	// Amazon Resource Name (ARN) of the Redshift Serverless Workgroup.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
	BaseCapacity pulumi.IntOutput `pulumi:"baseCapacity"`
	// An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
	ConfigParameters WorkgroupConfigParameterArrayOutput `pulumi:"configParameters"`
	// The endpoint that is created from the workgroup. See `Endpoint` below.
	Endpoints WorkgroupEndpointArrayOutput `pulumi:"endpoints"`
	// The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
	EnhancedVpcRouting pulumi.BoolPtrOutput `pulumi:"enhancedVpcRouting"`
	// The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
	MaxCapacity pulumi.IntPtrOutput `pulumi:"maxCapacity"`
	// The name of the namespace.
	NamespaceName pulumi.StringOutput `pulumi:"namespaceName"`
	// The port number on which the cluster accepts incoming connections.
	Port pulumi.IntOutput `pulumi:"port"`
	// Price-performance scaling for the workgroup. See `Price Performance Target` below.
	PricePerformanceTarget WorkgroupPricePerformanceTargetOutput `pulumi:"pricePerformanceTarget"`
	// A value that specifies whether the workgroup can be accessed from a public network.
	PubliclyAccessible pulumi.BoolPtrOutput `pulumi:"publiclyAccessible"`
	// An array of security group IDs to associate with the workgroup.
	SecurityGroupIds pulumi.StringArrayOutput `pulumi:"securityGroupIds"`
	// An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
	SubnetIds pulumi.StringArrayOutput `pulumi:"subnetIds"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
	TrackName pulumi.StringOutput `pulumi:"trackName"`
	// The Redshift Workgroup ID.
	WorkgroupId pulumi.StringOutput `pulumi:"workgroupId"`
	// The name of the workgroup.
	//
	// The following arguments are optional:
	WorkgroupName pulumi.StringOutput `pulumi:"workgroupName"`
}

// NewWorkgroup registers a new resource with the given unique name, arguments, and options.
func NewWorkgroup(ctx *pulumi.Context,
	name string, args *WorkgroupArgs, opts ...pulumi.ResourceOption) (*Workgroup, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.NamespaceName == nil {
		return nil, errors.New("invalid value for required argument 'NamespaceName'")
	}
	if args.WorkgroupName == nil {
		return nil, errors.New("invalid value for required argument 'WorkgroupName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Workgroup
	err := ctx.RegisterResource("aws:redshiftserverless/workgroup:Workgroup", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetWorkgroup gets an existing Workgroup resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetWorkgroup(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *WorkgroupState, opts ...pulumi.ResourceOption) (*Workgroup, error) {
	var resource Workgroup
	err := ctx.ReadResource("aws:redshiftserverless/workgroup:Workgroup", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Workgroup resources.
type workgroupState struct {
	// Amazon Resource Name (ARN) of the Redshift Serverless Workgroup.
	Arn *string `pulumi:"arn"`
	// The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
	BaseCapacity *int `pulumi:"baseCapacity"`
	// An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
	ConfigParameters []WorkgroupConfigParameter `pulumi:"configParameters"`
	// The endpoint that is created from the workgroup. See `Endpoint` below.
	Endpoints []WorkgroupEndpoint `pulumi:"endpoints"`
	// The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
	EnhancedVpcRouting *bool `pulumi:"enhancedVpcRouting"`
	// The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
	MaxCapacity *int `pulumi:"maxCapacity"`
	// The name of the namespace.
	NamespaceName *string `pulumi:"namespaceName"`
	// The port number on which the cluster accepts incoming connections.
	Port *int `pulumi:"port"`
	// Price-performance scaling for the workgroup. See `Price Performance Target` below.
	PricePerformanceTarget *WorkgroupPricePerformanceTarget `pulumi:"pricePerformanceTarget"`
	// A value that specifies whether the workgroup can be accessed from a public network.
	PubliclyAccessible *bool `pulumi:"publiclyAccessible"`
	// An array of security group IDs to associate with the workgroup.
	SecurityGroupIds []string `pulumi:"securityGroupIds"`
	// An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
	SubnetIds []string `pulumi:"subnetIds"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
	TrackName *string `pulumi:"trackName"`
	// The Redshift Workgroup ID.
	WorkgroupId *string `pulumi:"workgroupId"`
	// The name of the workgroup.
	//
	// The following arguments are optional:
	WorkgroupName *string `pulumi:"workgroupName"`
}

type WorkgroupState struct {
	// Amazon Resource Name (ARN) of the Redshift Serverless Workgroup.
	Arn pulumi.StringPtrInput
	// The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
	BaseCapacity pulumi.IntPtrInput
	// An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
	ConfigParameters WorkgroupConfigParameterArrayInput
	// The endpoint that is created from the workgroup. See `Endpoint` below.
	Endpoints WorkgroupEndpointArrayInput
	// The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
	EnhancedVpcRouting pulumi.BoolPtrInput
	// The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
	MaxCapacity pulumi.IntPtrInput
	// The name of the namespace.
	NamespaceName pulumi.StringPtrInput
	// The port number on which the cluster accepts incoming connections.
	Port pulumi.IntPtrInput
	// Price-performance scaling for the workgroup. See `Price Performance Target` below.
	PricePerformanceTarget WorkgroupPricePerformanceTargetPtrInput
	// A value that specifies whether the workgroup can be accessed from a public network.
	PubliclyAccessible pulumi.BoolPtrInput
	// An array of security group IDs to associate with the workgroup.
	SecurityGroupIds pulumi.StringArrayInput
	// An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
	SubnetIds pulumi.StringArrayInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
	TrackName pulumi.StringPtrInput
	// The Redshift Workgroup ID.
	WorkgroupId pulumi.StringPtrInput
	// The name of the workgroup.
	//
	// The following arguments are optional:
	WorkgroupName pulumi.StringPtrInput
}

func (WorkgroupState) ElementType() reflect.Type {
	return reflect.TypeOf((*workgroupState)(nil)).Elem()
}

type workgroupArgs struct {
	// The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
	BaseCapacity *int `pulumi:"baseCapacity"`
	// An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
	ConfigParameters []WorkgroupConfigParameter `pulumi:"configParameters"`
	// The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
	EnhancedVpcRouting *bool `pulumi:"enhancedVpcRouting"`
	// The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
	MaxCapacity *int `pulumi:"maxCapacity"`
	// The name of the namespace.
	NamespaceName string `pulumi:"namespaceName"`
	// The port number on which the cluster accepts incoming connections.
	Port *int `pulumi:"port"`
	// Price-performance scaling for the workgroup. See `Price Performance Target` below.
	PricePerformanceTarget *WorkgroupPricePerformanceTarget `pulumi:"pricePerformanceTarget"`
	// A value that specifies whether the workgroup can be accessed from a public network.
	PubliclyAccessible *bool `pulumi:"publiclyAccessible"`
	// An array of security group IDs to associate with the workgroup.
	SecurityGroupIds []string `pulumi:"securityGroupIds"`
	// An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
	SubnetIds []string `pulumi:"subnetIds"`
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
	TrackName *string `pulumi:"trackName"`
	// The name of the workgroup.
	//
	// The following arguments are optional:
	WorkgroupName string `pulumi:"workgroupName"`
}

// The set of arguments for constructing a Workgroup resource.
type WorkgroupArgs struct {
	// The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
	BaseCapacity pulumi.IntPtrInput
	// An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
	ConfigParameters WorkgroupConfigParameterArrayInput
	// The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
	EnhancedVpcRouting pulumi.BoolPtrInput
	// The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
	MaxCapacity pulumi.IntPtrInput
	// The name of the namespace.
	NamespaceName pulumi.StringInput
	// The port number on which the cluster accepts incoming connections.
	Port pulumi.IntPtrInput
	// Price-performance scaling for the workgroup. See `Price Performance Target` below.
	PricePerformanceTarget WorkgroupPricePerformanceTargetPtrInput
	// A value that specifies whether the workgroup can be accessed from a public network.
	PubliclyAccessible pulumi.BoolPtrInput
	// An array of security group IDs to associate with the workgroup.
	SecurityGroupIds pulumi.StringArrayInput
	// An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
	SubnetIds pulumi.StringArrayInput
	// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
	TrackName pulumi.StringPtrInput
	// The name of the workgroup.
	//
	// The following arguments are optional:
	WorkgroupName pulumi.StringInput
}

func (WorkgroupArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*workgroupArgs)(nil)).Elem()
}

type WorkgroupInput interface {
	pulumi.Input

	ToWorkgroupOutput() WorkgroupOutput
	ToWorkgroupOutputWithContext(ctx context.Context) WorkgroupOutput
}

func (*Workgroup) ElementType() reflect.Type {
	return reflect.TypeOf((**Workgroup)(nil)).Elem()
}

func (i *Workgroup) ToWorkgroupOutput() WorkgroupOutput {
	return i.ToWorkgroupOutputWithContext(context.Background())
}

func (i *Workgroup) ToWorkgroupOutputWithContext(ctx context.Context) WorkgroupOutput {
	return pulumi.ToOutputWithContext(ctx, i).(WorkgroupOutput)
}

// WorkgroupArrayInput is an input type that accepts WorkgroupArray and WorkgroupArrayOutput values.
// You can construct a concrete instance of `WorkgroupArrayInput` via:
//
//	WorkgroupArray{ WorkgroupArgs{...} }
type WorkgroupArrayInput interface {
	pulumi.Input

	ToWorkgroupArrayOutput() WorkgroupArrayOutput
	ToWorkgroupArrayOutputWithContext(context.Context) WorkgroupArrayOutput
}

type WorkgroupArray []WorkgroupInput

func (WorkgroupArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Workgroup)(nil)).Elem()
}

func (i WorkgroupArray) ToWorkgroupArrayOutput() WorkgroupArrayOutput {
	return i.ToWorkgroupArrayOutputWithContext(context.Background())
}

func (i WorkgroupArray) ToWorkgroupArrayOutputWithContext(ctx context.Context) WorkgroupArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(WorkgroupArrayOutput)
}

// WorkgroupMapInput is an input type that accepts WorkgroupMap and WorkgroupMapOutput values.
// You can construct a concrete instance of `WorkgroupMapInput` via:
//
//	WorkgroupMap{ "key": WorkgroupArgs{...} }
type WorkgroupMapInput interface {
	pulumi.Input

	ToWorkgroupMapOutput() WorkgroupMapOutput
	ToWorkgroupMapOutputWithContext(context.Context) WorkgroupMapOutput
}

type WorkgroupMap map[string]WorkgroupInput

func (WorkgroupMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Workgroup)(nil)).Elem()
}

func (i WorkgroupMap) ToWorkgroupMapOutput() WorkgroupMapOutput {
	return i.ToWorkgroupMapOutputWithContext(context.Background())
}

func (i WorkgroupMap) ToWorkgroupMapOutputWithContext(ctx context.Context) WorkgroupMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(WorkgroupMapOutput)
}

type WorkgroupOutput struct{ *pulumi.OutputState }

func (WorkgroupOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Workgroup)(nil)).Elem()
}

func (o WorkgroupOutput) ToWorkgroupOutput() WorkgroupOutput {
	return o
}

func (o WorkgroupOutput) ToWorkgroupOutputWithContext(ctx context.Context) WorkgroupOutput {
	return o
}

// Amazon Resource Name (ARN) of the Redshift Serverless Workgroup.
func (o WorkgroupOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The base data warehouse capacity of the workgroup in Redshift Processing Units (RPUs).
func (o WorkgroupOutput) BaseCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.IntOutput { return v.BaseCapacity }).(pulumi.IntOutput)
}

// An array of parameters to set for more control over a serverless database. See `Config Parameter` below.
func (o WorkgroupOutput) ConfigParameters() WorkgroupConfigParameterArrayOutput {
	return o.ApplyT(func(v *Workgroup) WorkgroupConfigParameterArrayOutput { return v.ConfigParameters }).(WorkgroupConfigParameterArrayOutput)
}

// The endpoint that is created from the workgroup. See `Endpoint` below.
func (o WorkgroupOutput) Endpoints() WorkgroupEndpointArrayOutput {
	return o.ApplyT(func(v *Workgroup) WorkgroupEndpointArrayOutput { return v.Endpoints }).(WorkgroupEndpointArrayOutput)
}

// The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
func (o WorkgroupOutput) EnhancedVpcRouting() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.BoolPtrOutput { return v.EnhancedVpcRouting }).(pulumi.BoolPtrOutput)
}

// The maximum data-warehouse capacity Amazon Redshift Serverless uses to serve queries, specified in Redshift Processing Units (RPUs).
func (o WorkgroupOutput) MaxCapacity() pulumi.IntPtrOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.IntPtrOutput { return v.MaxCapacity }).(pulumi.IntPtrOutput)
}

// The name of the namespace.
func (o WorkgroupOutput) NamespaceName() pulumi.StringOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.StringOutput { return v.NamespaceName }).(pulumi.StringOutput)
}

// The port number on which the cluster accepts incoming connections.
func (o WorkgroupOutput) Port() pulumi.IntOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.IntOutput { return v.Port }).(pulumi.IntOutput)
}

// Price-performance scaling for the workgroup. See `Price Performance Target` below.
func (o WorkgroupOutput) PricePerformanceTarget() WorkgroupPricePerformanceTargetOutput {
	return o.ApplyT(func(v *Workgroup) WorkgroupPricePerformanceTargetOutput { return v.PricePerformanceTarget }).(WorkgroupPricePerformanceTargetOutput)
}

// A value that specifies whether the workgroup can be accessed from a public network.
func (o WorkgroupOutput) PubliclyAccessible() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.BoolPtrOutput { return v.PubliclyAccessible }).(pulumi.BoolPtrOutput)
}

// An array of security group IDs to associate with the workgroup.
func (o WorkgroupOutput) SecurityGroupIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.StringArrayOutput { return v.SecurityGroupIds }).(pulumi.StringArrayOutput)
}

// An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
func (o WorkgroupOutput) SubnetIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.StringArrayOutput { return v.SubnetIds }).(pulumi.StringArrayOutput)
}

// A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o WorkgroupOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o WorkgroupOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The name of the track for the workgroup. If it is `current`, you get the most up-to-date certified release version with the latest features, security updates, and performance enhancements. If it is `trailing`, you will be on the previous certified release. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/tracks.html).
func (o WorkgroupOutput) TrackName() pulumi.StringOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.StringOutput { return v.TrackName }).(pulumi.StringOutput)
}

// The Redshift Workgroup ID.
func (o WorkgroupOutput) WorkgroupId() pulumi.StringOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.StringOutput { return v.WorkgroupId }).(pulumi.StringOutput)
}

// The name of the workgroup.
//
// The following arguments are optional:
func (o WorkgroupOutput) WorkgroupName() pulumi.StringOutput {
	return o.ApplyT(func(v *Workgroup) pulumi.StringOutput { return v.WorkgroupName }).(pulumi.StringOutput)
}

type WorkgroupArrayOutput struct{ *pulumi.OutputState }

func (WorkgroupArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Workgroup)(nil)).Elem()
}

func (o WorkgroupArrayOutput) ToWorkgroupArrayOutput() WorkgroupArrayOutput {
	return o
}

func (o WorkgroupArrayOutput) ToWorkgroupArrayOutputWithContext(ctx context.Context) WorkgroupArrayOutput {
	return o
}

func (o WorkgroupArrayOutput) Index(i pulumi.IntInput) WorkgroupOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Workgroup {
		return vs[0].([]*Workgroup)[vs[1].(int)]
	}).(WorkgroupOutput)
}

type WorkgroupMapOutput struct{ *pulumi.OutputState }

func (WorkgroupMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Workgroup)(nil)).Elem()
}

func (o WorkgroupMapOutput) ToWorkgroupMapOutput() WorkgroupMapOutput {
	return o
}

func (o WorkgroupMapOutput) ToWorkgroupMapOutputWithContext(ctx context.Context) WorkgroupMapOutput {
	return o
}

func (o WorkgroupMapOutput) MapIndex(k pulumi.StringInput) WorkgroupOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Workgroup {
		return vs[0].(map[string]*Workgroup)[vs[1].(string)]
	}).(WorkgroupOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*WorkgroupInput)(nil)).Elem(), &Workgroup{})
	pulumi.RegisterInputType(reflect.TypeOf((*WorkgroupArrayInput)(nil)).Elem(), WorkgroupArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*WorkgroupMapInput)(nil)).Elem(), WorkgroupMap{})
	pulumi.RegisterOutputType(WorkgroupOutput{})
	pulumi.RegisterOutputType(WorkgroupArrayOutput{})
	pulumi.RegisterOutputType(WorkgroupMapOutput{})
}
