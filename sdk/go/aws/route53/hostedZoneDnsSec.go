// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package route53

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages Route 53 Hosted Zone Domain Name System Security Extensions (DNSSEC). For more information about managing DNSSEC in Route 53, see the [Route 53 Developer Guide](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-configuring-dnssec.html).
//
// !> **WARNING:** If you disable DNSSEC signing for your hosted zone before the DNS changes have propagated, your domain could become unavailable on the internet. When you remove the DS records, you must wait until the longest TTL for the DS records that you remove has expired before you complete the step to disable DNSSEC signing. Please refer to the [Route 53 Developer Guide - Disable DNSSEC](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-configuring-dnssec-disable.html) for a detailed breakdown on the steps required to disable DNSSEC safely for a hosted zone.
//
// > **Note:** Route53 hosted zones are global resources, and as such any `kms.Key` that you use as part of a signing key needs to be located in the `us-east-1` region. In the example below, the main AWS provider declaration is for `us-east-1`, however if you are provisioning your AWS resources in a different region, you will need to specify a provider alias and use that attached to the `kms.Key` resource as described in the provider alias documentation.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"encoding/json"
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/kms"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/route53"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			current, err := aws.GetCallerIdentity(ctx, &aws.GetCallerIdentityArgs{}, nil)
//			if err != nil {
//				return err
//			}
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"Statement": []interface{}{
//					map[string]interface{}{
//						"Action": []string{
//							"kms:DescribeKey",
//							"kms:GetPublicKey",
//							"kms:Sign",
//							"kms:Verify",
//						},
//						"Effect": "Allow",
//						"Principal": map[string]interface{}{
//							"Service": "dnssec-route53.amazonaws.com",
//						},
//						"Resource": "*",
//						"Sid":      "Allow Route 53 DNSSEC Service",
//					},
//					map[string]interface{}{
//						"Action": "kms:*",
//						"Effect": "Allow",
//						"Principal": map[string]interface{}{
//							"AWS": fmt.Sprintf("arn:aws:iam::%v:root", current.AccountId),
//						},
//						"Resource": "*",
//						"Sid":      "Enable IAM User Permissions",
//					},
//				},
//				"Version": "2012-10-17",
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			example, err := kms.NewKey(ctx, "example", &kms.KeyArgs{
//				CustomerMasterKeySpec: pulumi.String("ECC_NIST_P256"),
//				DeletionWindowInDays:  pulumi.Int(7),
//				KeyUsage:              pulumi.String("SIGN_VERIFY"),
//				Policy:                pulumi.String(json0),
//			})
//			if err != nil {
//				return err
//			}
//			exampleZone, err := route53.NewZone(ctx, "example", &route53.ZoneArgs{
//				Name: pulumi.String("example.com"),
//			})
//			if err != nil {
//				return err
//			}
//			exampleKeySigningKey, err := route53.NewKeySigningKey(ctx, "example", &route53.KeySigningKeyArgs{
//				HostedZoneId:            exampleZone.ID(),
//				KeyManagementServiceArn: example.Arn,
//				Name:                    pulumi.String("example"),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = route53.NewHostedZoneDnsSec(ctx, "example", &route53.HostedZoneDnsSecArgs{
//				HostedZoneId: exampleKeySigningKey.HostedZoneId,
//			}, pulumi.DependsOn([]pulumi.Resource{
//				exampleKeySigningKey,
//			}))
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
// Using `pulumi import`, import `aws_route53_hosted_zone_dnssec` resources using the Route 53 Hosted Zone identifier. For example:
//
// ```sh
// $ pulumi import aws:route53/hostedZoneDnsSec:HostedZoneDnsSec example Z1D633PJN98FT9
// ```
type HostedZoneDnsSec struct {
	pulumi.CustomResourceState

	// Identifier of the Route 53 Hosted Zone.
	//
	// The following arguments are optional:
	HostedZoneId pulumi.StringOutput `pulumi:"hostedZoneId"`
	// Hosted Zone signing status. Valid values: `SIGNING`, `NOT_SIGNING`. Defaults to `SIGNING`.
	SigningStatus pulumi.StringPtrOutput `pulumi:"signingStatus"`
}

// NewHostedZoneDnsSec registers a new resource with the given unique name, arguments, and options.
func NewHostedZoneDnsSec(ctx *pulumi.Context,
	name string, args *HostedZoneDnsSecArgs, opts ...pulumi.ResourceOption) (*HostedZoneDnsSec, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.HostedZoneId == nil {
		return nil, errors.New("invalid value for required argument 'HostedZoneId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource HostedZoneDnsSec
	err := ctx.RegisterResource("aws:route53/hostedZoneDnsSec:HostedZoneDnsSec", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetHostedZoneDnsSec gets an existing HostedZoneDnsSec resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetHostedZoneDnsSec(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *HostedZoneDnsSecState, opts ...pulumi.ResourceOption) (*HostedZoneDnsSec, error) {
	var resource HostedZoneDnsSec
	err := ctx.ReadResource("aws:route53/hostedZoneDnsSec:HostedZoneDnsSec", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering HostedZoneDnsSec resources.
type hostedZoneDnsSecState struct {
	// Identifier of the Route 53 Hosted Zone.
	//
	// The following arguments are optional:
	HostedZoneId *string `pulumi:"hostedZoneId"`
	// Hosted Zone signing status. Valid values: `SIGNING`, `NOT_SIGNING`. Defaults to `SIGNING`.
	SigningStatus *string `pulumi:"signingStatus"`
}

type HostedZoneDnsSecState struct {
	// Identifier of the Route 53 Hosted Zone.
	//
	// The following arguments are optional:
	HostedZoneId pulumi.StringPtrInput
	// Hosted Zone signing status. Valid values: `SIGNING`, `NOT_SIGNING`. Defaults to `SIGNING`.
	SigningStatus pulumi.StringPtrInput
}

func (HostedZoneDnsSecState) ElementType() reflect.Type {
	return reflect.TypeOf((*hostedZoneDnsSecState)(nil)).Elem()
}

type hostedZoneDnsSecArgs struct {
	// Identifier of the Route 53 Hosted Zone.
	//
	// The following arguments are optional:
	HostedZoneId string `pulumi:"hostedZoneId"`
	// Hosted Zone signing status. Valid values: `SIGNING`, `NOT_SIGNING`. Defaults to `SIGNING`.
	SigningStatus *string `pulumi:"signingStatus"`
}

// The set of arguments for constructing a HostedZoneDnsSec resource.
type HostedZoneDnsSecArgs struct {
	// Identifier of the Route 53 Hosted Zone.
	//
	// The following arguments are optional:
	HostedZoneId pulumi.StringInput
	// Hosted Zone signing status. Valid values: `SIGNING`, `NOT_SIGNING`. Defaults to `SIGNING`.
	SigningStatus pulumi.StringPtrInput
}

func (HostedZoneDnsSecArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*hostedZoneDnsSecArgs)(nil)).Elem()
}

type HostedZoneDnsSecInput interface {
	pulumi.Input

	ToHostedZoneDnsSecOutput() HostedZoneDnsSecOutput
	ToHostedZoneDnsSecOutputWithContext(ctx context.Context) HostedZoneDnsSecOutput
}

func (*HostedZoneDnsSec) ElementType() reflect.Type {
	return reflect.TypeOf((**HostedZoneDnsSec)(nil)).Elem()
}

func (i *HostedZoneDnsSec) ToHostedZoneDnsSecOutput() HostedZoneDnsSecOutput {
	return i.ToHostedZoneDnsSecOutputWithContext(context.Background())
}

func (i *HostedZoneDnsSec) ToHostedZoneDnsSecOutputWithContext(ctx context.Context) HostedZoneDnsSecOutput {
	return pulumi.ToOutputWithContext(ctx, i).(HostedZoneDnsSecOutput)
}

// HostedZoneDnsSecArrayInput is an input type that accepts HostedZoneDnsSecArray and HostedZoneDnsSecArrayOutput values.
// You can construct a concrete instance of `HostedZoneDnsSecArrayInput` via:
//
//	HostedZoneDnsSecArray{ HostedZoneDnsSecArgs{...} }
type HostedZoneDnsSecArrayInput interface {
	pulumi.Input

	ToHostedZoneDnsSecArrayOutput() HostedZoneDnsSecArrayOutput
	ToHostedZoneDnsSecArrayOutputWithContext(context.Context) HostedZoneDnsSecArrayOutput
}

type HostedZoneDnsSecArray []HostedZoneDnsSecInput

func (HostedZoneDnsSecArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*HostedZoneDnsSec)(nil)).Elem()
}

func (i HostedZoneDnsSecArray) ToHostedZoneDnsSecArrayOutput() HostedZoneDnsSecArrayOutput {
	return i.ToHostedZoneDnsSecArrayOutputWithContext(context.Background())
}

func (i HostedZoneDnsSecArray) ToHostedZoneDnsSecArrayOutputWithContext(ctx context.Context) HostedZoneDnsSecArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(HostedZoneDnsSecArrayOutput)
}

// HostedZoneDnsSecMapInput is an input type that accepts HostedZoneDnsSecMap and HostedZoneDnsSecMapOutput values.
// You can construct a concrete instance of `HostedZoneDnsSecMapInput` via:
//
//	HostedZoneDnsSecMap{ "key": HostedZoneDnsSecArgs{...} }
type HostedZoneDnsSecMapInput interface {
	pulumi.Input

	ToHostedZoneDnsSecMapOutput() HostedZoneDnsSecMapOutput
	ToHostedZoneDnsSecMapOutputWithContext(context.Context) HostedZoneDnsSecMapOutput
}

type HostedZoneDnsSecMap map[string]HostedZoneDnsSecInput

func (HostedZoneDnsSecMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*HostedZoneDnsSec)(nil)).Elem()
}

func (i HostedZoneDnsSecMap) ToHostedZoneDnsSecMapOutput() HostedZoneDnsSecMapOutput {
	return i.ToHostedZoneDnsSecMapOutputWithContext(context.Background())
}

func (i HostedZoneDnsSecMap) ToHostedZoneDnsSecMapOutputWithContext(ctx context.Context) HostedZoneDnsSecMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(HostedZoneDnsSecMapOutput)
}

type HostedZoneDnsSecOutput struct{ *pulumi.OutputState }

func (HostedZoneDnsSecOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**HostedZoneDnsSec)(nil)).Elem()
}

func (o HostedZoneDnsSecOutput) ToHostedZoneDnsSecOutput() HostedZoneDnsSecOutput {
	return o
}

func (o HostedZoneDnsSecOutput) ToHostedZoneDnsSecOutputWithContext(ctx context.Context) HostedZoneDnsSecOutput {
	return o
}

// Identifier of the Route 53 Hosted Zone.
//
// The following arguments are optional:
func (o HostedZoneDnsSecOutput) HostedZoneId() pulumi.StringOutput {
	return o.ApplyT(func(v *HostedZoneDnsSec) pulumi.StringOutput { return v.HostedZoneId }).(pulumi.StringOutput)
}

// Hosted Zone signing status. Valid values: `SIGNING`, `NOT_SIGNING`. Defaults to `SIGNING`.
func (o HostedZoneDnsSecOutput) SigningStatus() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *HostedZoneDnsSec) pulumi.StringPtrOutput { return v.SigningStatus }).(pulumi.StringPtrOutput)
}

type HostedZoneDnsSecArrayOutput struct{ *pulumi.OutputState }

func (HostedZoneDnsSecArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*HostedZoneDnsSec)(nil)).Elem()
}

func (o HostedZoneDnsSecArrayOutput) ToHostedZoneDnsSecArrayOutput() HostedZoneDnsSecArrayOutput {
	return o
}

func (o HostedZoneDnsSecArrayOutput) ToHostedZoneDnsSecArrayOutputWithContext(ctx context.Context) HostedZoneDnsSecArrayOutput {
	return o
}

func (o HostedZoneDnsSecArrayOutput) Index(i pulumi.IntInput) HostedZoneDnsSecOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *HostedZoneDnsSec {
		return vs[0].([]*HostedZoneDnsSec)[vs[1].(int)]
	}).(HostedZoneDnsSecOutput)
}

type HostedZoneDnsSecMapOutput struct{ *pulumi.OutputState }

func (HostedZoneDnsSecMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*HostedZoneDnsSec)(nil)).Elem()
}

func (o HostedZoneDnsSecMapOutput) ToHostedZoneDnsSecMapOutput() HostedZoneDnsSecMapOutput {
	return o
}

func (o HostedZoneDnsSecMapOutput) ToHostedZoneDnsSecMapOutputWithContext(ctx context.Context) HostedZoneDnsSecMapOutput {
	return o
}

func (o HostedZoneDnsSecMapOutput) MapIndex(k pulumi.StringInput) HostedZoneDnsSecOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *HostedZoneDnsSec {
		return vs[0].(map[string]*HostedZoneDnsSec)[vs[1].(string)]
	}).(HostedZoneDnsSecOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*HostedZoneDnsSecInput)(nil)).Elem(), &HostedZoneDnsSec{})
	pulumi.RegisterInputType(reflect.TypeOf((*HostedZoneDnsSecArrayInput)(nil)).Elem(), HostedZoneDnsSecArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*HostedZoneDnsSecMapInput)(nil)).Elem(), HostedZoneDnsSecMap{})
	pulumi.RegisterOutputType(HostedZoneDnsSecOutput{})
	pulumi.RegisterOutputType(HostedZoneDnsSecArrayOutput{})
	pulumi.RegisterOutputType(HostedZoneDnsSecMapOutput{})
}
