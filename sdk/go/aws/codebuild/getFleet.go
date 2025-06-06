// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package codebuild

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Retrieve information about an CodeBuild Fleet.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/codebuild"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			testFleet, err := codebuild.NewFleet(ctx, "test", &codebuild.FleetArgs{
//				BaseCapacity:     pulumi.Int(2),
//				ComputeType:      pulumi.String("BUILD_GENERAL1_SMALL"),
//				EnvironmentType:  pulumi.String("LINUX_CONTAINER"),
//				Name:             pulumi.String("full-example-codebuild-fleet"),
//				OverflowBehavior: pulumi.String("QUEUE"),
//				ScalingConfiguration: &codebuild.FleetScalingConfigurationArgs{
//					MaxCapacity: pulumi.Int(5),
//					ScalingType: pulumi.String("TARGET_TRACKING_SCALING"),
//					TargetTrackingScalingConfigs: codebuild.FleetScalingConfigurationTargetTrackingScalingConfigArray{
//						&codebuild.FleetScalingConfigurationTargetTrackingScalingConfigArgs{
//							MetricType:  pulumi.String("FLEET_UTILIZATION_RATE"),
//							TargetValue: pulumi.Float64(97.5),
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_ = codebuild.LookupFleetOutput(ctx, codebuild.GetFleetOutputArgs{
//				Name: testFleet.Name,
//			}, nil)
//			return nil
//		})
//	}
//
// ```
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/codebuild"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := codebuild.LookupFleet(ctx, &codebuild.LookupFleetArgs{
//				Name: "my-codebuild-fleet-name",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupFleet(ctx *pulumi.Context, args *LookupFleetArgs, opts ...pulumi.InvokeOption) (*LookupFleetResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupFleetResult
	err := ctx.Invoke("aws:codebuild/getFleet:getFleet", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getFleet.
type LookupFleetArgs struct {
	// Fleet name.
	Name string `pulumi:"name"`
	// Mapping of Key-Value tags for the resource.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getFleet.
type LookupFleetResult struct {
	// ARN of the Fleet.
	Arn string `pulumi:"arn"`
	// Number of machines allocated to the ﬂeet.
	BaseCapacity int `pulumi:"baseCapacity"`
	// Compute configuration of the compute fleet.
	ComputeConfigurations []GetFleetComputeConfiguration `pulumi:"computeConfigurations"`
	// Compute resources the compute fleet uses.
	ComputeType string `pulumi:"computeType"`
	// Creation time of the fleet.
	Created string `pulumi:"created"`
	// Environment type of the compute fleet.
	EnvironmentType string `pulumi:"environmentType"`
	// The service role associated with the compute fleet.
	FleetServiceRole string `pulumi:"fleetServiceRole"`
	// ARN of the Fleet.
	Id string `pulumi:"id"`
	// The Amazon Machine Image (AMI) of the compute fleet.
	ImageId string `pulumi:"imageId"`
	// Last modification time of the fleet.
	LastModified string `pulumi:"lastModified"`
	Name         string `pulumi:"name"`
	// Overflow behavior for compute fleet.
	OverflowBehavior string `pulumi:"overflowBehavior"`
	// Nested attribute containing information about the scaling configuration.
	ScalingConfigurations []GetFleetScalingConfiguration `pulumi:"scalingConfigurations"`
	// Nested attribute containing information about the current status of the fleet.
	Statuses []GetFleetStatus `pulumi:"statuses"`
	// Mapping of Key-Value tags for the resource.
	Tags map[string]string `pulumi:"tags"`
	// Nested attribute containing information about the VPC configuration.
	VpcConfigs []GetFleetVpcConfig `pulumi:"vpcConfigs"`
}

func LookupFleetOutput(ctx *pulumi.Context, args LookupFleetOutputArgs, opts ...pulumi.InvokeOption) LookupFleetResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupFleetResultOutput, error) {
			args := v.(LookupFleetArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:codebuild/getFleet:getFleet", args, LookupFleetResultOutput{}, options).(LookupFleetResultOutput), nil
		}).(LookupFleetResultOutput)
}

// A collection of arguments for invoking getFleet.
type LookupFleetOutputArgs struct {
	// Fleet name.
	Name pulumi.StringInput `pulumi:"name"`
	// Mapping of Key-Value tags for the resource.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupFleetOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupFleetArgs)(nil)).Elem()
}

// A collection of values returned by getFleet.
type LookupFleetResultOutput struct{ *pulumi.OutputState }

func (LookupFleetResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupFleetResult)(nil)).Elem()
}

func (o LookupFleetResultOutput) ToLookupFleetResultOutput() LookupFleetResultOutput {
	return o
}

func (o LookupFleetResultOutput) ToLookupFleetResultOutputWithContext(ctx context.Context) LookupFleetResultOutput {
	return o
}

// ARN of the Fleet.
func (o LookupFleetResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Number of machines allocated to the ﬂeet.
func (o LookupFleetResultOutput) BaseCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupFleetResult) int { return v.BaseCapacity }).(pulumi.IntOutput)
}

// Compute configuration of the compute fleet.
func (o LookupFleetResultOutput) ComputeConfigurations() GetFleetComputeConfigurationArrayOutput {
	return o.ApplyT(func(v LookupFleetResult) []GetFleetComputeConfiguration { return v.ComputeConfigurations }).(GetFleetComputeConfigurationArrayOutput)
}

// Compute resources the compute fleet uses.
func (o LookupFleetResultOutput) ComputeType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.ComputeType }).(pulumi.StringOutput)
}

// Creation time of the fleet.
func (o LookupFleetResultOutput) Created() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.Created }).(pulumi.StringOutput)
}

// Environment type of the compute fleet.
func (o LookupFleetResultOutput) EnvironmentType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.EnvironmentType }).(pulumi.StringOutput)
}

// The service role associated with the compute fleet.
func (o LookupFleetResultOutput) FleetServiceRole() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.FleetServiceRole }).(pulumi.StringOutput)
}

// ARN of the Fleet.
func (o LookupFleetResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.Id }).(pulumi.StringOutput)
}

// The Amazon Machine Image (AMI) of the compute fleet.
func (o LookupFleetResultOutput) ImageId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.ImageId }).(pulumi.StringOutput)
}

// Last modification time of the fleet.
func (o LookupFleetResultOutput) LastModified() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.LastModified }).(pulumi.StringOutput)
}

func (o LookupFleetResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.Name }).(pulumi.StringOutput)
}

// Overflow behavior for compute fleet.
func (o LookupFleetResultOutput) OverflowBehavior() pulumi.StringOutput {
	return o.ApplyT(func(v LookupFleetResult) string { return v.OverflowBehavior }).(pulumi.StringOutput)
}

// Nested attribute containing information about the scaling configuration.
func (o LookupFleetResultOutput) ScalingConfigurations() GetFleetScalingConfigurationArrayOutput {
	return o.ApplyT(func(v LookupFleetResult) []GetFleetScalingConfiguration { return v.ScalingConfigurations }).(GetFleetScalingConfigurationArrayOutput)
}

// Nested attribute containing information about the current status of the fleet.
func (o LookupFleetResultOutput) Statuses() GetFleetStatusArrayOutput {
	return o.ApplyT(func(v LookupFleetResult) []GetFleetStatus { return v.Statuses }).(GetFleetStatusArrayOutput)
}

// Mapping of Key-Value tags for the resource.
func (o LookupFleetResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupFleetResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// Nested attribute containing information about the VPC configuration.
func (o LookupFleetResultOutput) VpcConfigs() GetFleetVpcConfigArrayOutput {
	return o.ApplyT(func(v LookupFleetResult) []GetFleetVpcConfig { return v.VpcConfigs }).(GetFleetVpcConfigArrayOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupFleetResultOutput{})
}
