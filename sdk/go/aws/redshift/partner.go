// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package redshift

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Creates a new Amazon Redshift Partner Integration.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/redshift"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := redshift.NewPartner(ctx, "example", &redshift.PartnerArgs{
//				ClusterIdentifier: pulumi.Any(exampleAwsRedshiftCluster.Id),
//				AccountId:         pulumi.String("1234567910"),
//				DatabaseName:      pulumi.Any(exampleAwsRedshiftCluster.DatabaseName),
//				PartnerName:       pulumi.String("example"),
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
// Using `pulumi import`, import Redshift usage limits using the `id`. For example:
//
// ```sh
// $ pulumi import aws:redshift/partner:Partner example 01234567910:cluster-example-id:example:example
// ```
type Partner struct {
	pulumi.CustomResourceState

	// The Amazon Web Services account ID that owns the cluster.
	AccountId pulumi.StringOutput `pulumi:"accountId"`
	// The cluster identifier of the cluster that receives data from the partner.
	ClusterIdentifier pulumi.StringOutput `pulumi:"clusterIdentifier"`
	// The name of the database that receives data from the partner.
	DatabaseName pulumi.StringOutput `pulumi:"databaseName"`
	// The name of the partner that is authorized to send data.
	PartnerName pulumi.StringOutput `pulumi:"partnerName"`
	// (Optional) The partner integration status.
	Status pulumi.StringOutput `pulumi:"status"`
	// (Optional) The status message provided by the partner.
	StatusMessage pulumi.StringOutput `pulumi:"statusMessage"`
}

// NewPartner registers a new resource with the given unique name, arguments, and options.
func NewPartner(ctx *pulumi.Context,
	name string, args *PartnerArgs, opts ...pulumi.ResourceOption) (*Partner, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.AccountId == nil {
		return nil, errors.New("invalid value for required argument 'AccountId'")
	}
	if args.ClusterIdentifier == nil {
		return nil, errors.New("invalid value for required argument 'ClusterIdentifier'")
	}
	if args.DatabaseName == nil {
		return nil, errors.New("invalid value for required argument 'DatabaseName'")
	}
	if args.PartnerName == nil {
		return nil, errors.New("invalid value for required argument 'PartnerName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Partner
	err := ctx.RegisterResource("aws:redshift/partner:Partner", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetPartner gets an existing Partner resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetPartner(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *PartnerState, opts ...pulumi.ResourceOption) (*Partner, error) {
	var resource Partner
	err := ctx.ReadResource("aws:redshift/partner:Partner", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Partner resources.
type partnerState struct {
	// The Amazon Web Services account ID that owns the cluster.
	AccountId *string `pulumi:"accountId"`
	// The cluster identifier of the cluster that receives data from the partner.
	ClusterIdentifier *string `pulumi:"clusterIdentifier"`
	// The name of the database that receives data from the partner.
	DatabaseName *string `pulumi:"databaseName"`
	// The name of the partner that is authorized to send data.
	PartnerName *string `pulumi:"partnerName"`
	// (Optional) The partner integration status.
	Status *string `pulumi:"status"`
	// (Optional) The status message provided by the partner.
	StatusMessage *string `pulumi:"statusMessage"`
}

type PartnerState struct {
	// The Amazon Web Services account ID that owns the cluster.
	AccountId pulumi.StringPtrInput
	// The cluster identifier of the cluster that receives data from the partner.
	ClusterIdentifier pulumi.StringPtrInput
	// The name of the database that receives data from the partner.
	DatabaseName pulumi.StringPtrInput
	// The name of the partner that is authorized to send data.
	PartnerName pulumi.StringPtrInput
	// (Optional) The partner integration status.
	Status pulumi.StringPtrInput
	// (Optional) The status message provided by the partner.
	StatusMessage pulumi.StringPtrInput
}

func (PartnerState) ElementType() reflect.Type {
	return reflect.TypeOf((*partnerState)(nil)).Elem()
}

type partnerArgs struct {
	// The Amazon Web Services account ID that owns the cluster.
	AccountId string `pulumi:"accountId"`
	// The cluster identifier of the cluster that receives data from the partner.
	ClusterIdentifier string `pulumi:"clusterIdentifier"`
	// The name of the database that receives data from the partner.
	DatabaseName string `pulumi:"databaseName"`
	// The name of the partner that is authorized to send data.
	PartnerName string `pulumi:"partnerName"`
}

// The set of arguments for constructing a Partner resource.
type PartnerArgs struct {
	// The Amazon Web Services account ID that owns the cluster.
	AccountId pulumi.StringInput
	// The cluster identifier of the cluster that receives data from the partner.
	ClusterIdentifier pulumi.StringInput
	// The name of the database that receives data from the partner.
	DatabaseName pulumi.StringInput
	// The name of the partner that is authorized to send data.
	PartnerName pulumi.StringInput
}

func (PartnerArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*partnerArgs)(nil)).Elem()
}

type PartnerInput interface {
	pulumi.Input

	ToPartnerOutput() PartnerOutput
	ToPartnerOutputWithContext(ctx context.Context) PartnerOutput
}

func (*Partner) ElementType() reflect.Type {
	return reflect.TypeOf((**Partner)(nil)).Elem()
}

func (i *Partner) ToPartnerOutput() PartnerOutput {
	return i.ToPartnerOutputWithContext(context.Background())
}

func (i *Partner) ToPartnerOutputWithContext(ctx context.Context) PartnerOutput {
	return pulumi.ToOutputWithContext(ctx, i).(PartnerOutput)
}

// PartnerArrayInput is an input type that accepts PartnerArray and PartnerArrayOutput values.
// You can construct a concrete instance of `PartnerArrayInput` via:
//
//	PartnerArray{ PartnerArgs{...} }
type PartnerArrayInput interface {
	pulumi.Input

	ToPartnerArrayOutput() PartnerArrayOutput
	ToPartnerArrayOutputWithContext(context.Context) PartnerArrayOutput
}

type PartnerArray []PartnerInput

func (PartnerArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Partner)(nil)).Elem()
}

func (i PartnerArray) ToPartnerArrayOutput() PartnerArrayOutput {
	return i.ToPartnerArrayOutputWithContext(context.Background())
}

func (i PartnerArray) ToPartnerArrayOutputWithContext(ctx context.Context) PartnerArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(PartnerArrayOutput)
}

// PartnerMapInput is an input type that accepts PartnerMap and PartnerMapOutput values.
// You can construct a concrete instance of `PartnerMapInput` via:
//
//	PartnerMap{ "key": PartnerArgs{...} }
type PartnerMapInput interface {
	pulumi.Input

	ToPartnerMapOutput() PartnerMapOutput
	ToPartnerMapOutputWithContext(context.Context) PartnerMapOutput
}

type PartnerMap map[string]PartnerInput

func (PartnerMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Partner)(nil)).Elem()
}

func (i PartnerMap) ToPartnerMapOutput() PartnerMapOutput {
	return i.ToPartnerMapOutputWithContext(context.Background())
}

func (i PartnerMap) ToPartnerMapOutputWithContext(ctx context.Context) PartnerMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(PartnerMapOutput)
}

type PartnerOutput struct{ *pulumi.OutputState }

func (PartnerOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Partner)(nil)).Elem()
}

func (o PartnerOutput) ToPartnerOutput() PartnerOutput {
	return o
}

func (o PartnerOutput) ToPartnerOutputWithContext(ctx context.Context) PartnerOutput {
	return o
}

// The Amazon Web Services account ID that owns the cluster.
func (o PartnerOutput) AccountId() pulumi.StringOutput {
	return o.ApplyT(func(v *Partner) pulumi.StringOutput { return v.AccountId }).(pulumi.StringOutput)
}

// The cluster identifier of the cluster that receives data from the partner.
func (o PartnerOutput) ClusterIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v *Partner) pulumi.StringOutput { return v.ClusterIdentifier }).(pulumi.StringOutput)
}

// The name of the database that receives data from the partner.
func (o PartnerOutput) DatabaseName() pulumi.StringOutput {
	return o.ApplyT(func(v *Partner) pulumi.StringOutput { return v.DatabaseName }).(pulumi.StringOutput)
}

// The name of the partner that is authorized to send data.
func (o PartnerOutput) PartnerName() pulumi.StringOutput {
	return o.ApplyT(func(v *Partner) pulumi.StringOutput { return v.PartnerName }).(pulumi.StringOutput)
}

// (Optional) The partner integration status.
func (o PartnerOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *Partner) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// (Optional) The status message provided by the partner.
func (o PartnerOutput) StatusMessage() pulumi.StringOutput {
	return o.ApplyT(func(v *Partner) pulumi.StringOutput { return v.StatusMessage }).(pulumi.StringOutput)
}

type PartnerArrayOutput struct{ *pulumi.OutputState }

func (PartnerArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Partner)(nil)).Elem()
}

func (o PartnerArrayOutput) ToPartnerArrayOutput() PartnerArrayOutput {
	return o
}

func (o PartnerArrayOutput) ToPartnerArrayOutputWithContext(ctx context.Context) PartnerArrayOutput {
	return o
}

func (o PartnerArrayOutput) Index(i pulumi.IntInput) PartnerOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Partner {
		return vs[0].([]*Partner)[vs[1].(int)]
	}).(PartnerOutput)
}

type PartnerMapOutput struct{ *pulumi.OutputState }

func (PartnerMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Partner)(nil)).Elem()
}

func (o PartnerMapOutput) ToPartnerMapOutput() PartnerMapOutput {
	return o
}

func (o PartnerMapOutput) ToPartnerMapOutputWithContext(ctx context.Context) PartnerMapOutput {
	return o
}

func (o PartnerMapOutput) MapIndex(k pulumi.StringInput) PartnerOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Partner {
		return vs[0].(map[string]*Partner)[vs[1].(string)]
	}).(PartnerOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*PartnerInput)(nil)).Elem(), &Partner{})
	pulumi.RegisterInputType(reflect.TypeOf((*PartnerArrayInput)(nil)).Elem(), PartnerArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*PartnerMapInput)(nil)).Elem(), PartnerMap{})
	pulumi.RegisterOutputType(PartnerOutput{})
	pulumi.RegisterOutputType(PartnerArrayOutput{})
	pulumi.RegisterOutputType(PartnerMapOutput{})
}
