// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package cloudhsmv2

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

var _ = internal.GetEnvOrDefault

type ClusterClusterCertificate struct {
	// The HSM hardware certificate issued (signed) by AWS CloudHSM.
	AwsHardwareCertificate *string `pulumi:"awsHardwareCertificate"`
	// The cluster certificate issued (signed) by the issuing certificate authority (CA) of the cluster's owner.
	ClusterCertificate *string `pulumi:"clusterCertificate"`
	// The certificate signing request (CSR). Available only in `UNINITIALIZED` state after an HSM instance is added to the cluster.
	ClusterCsr *string `pulumi:"clusterCsr"`
	// The HSM certificate issued (signed) by the HSM hardware.
	HsmCertificate *string `pulumi:"hsmCertificate"`
	// The HSM hardware certificate issued (signed) by the hardware manufacturer.
	ManufacturerHardwareCertificate *string `pulumi:"manufacturerHardwareCertificate"`
}

// ClusterClusterCertificateInput is an input type that accepts ClusterClusterCertificateArgs and ClusterClusterCertificateOutput values.
// You can construct a concrete instance of `ClusterClusterCertificateInput` via:
//
//	ClusterClusterCertificateArgs{...}
type ClusterClusterCertificateInput interface {
	pulumi.Input

	ToClusterClusterCertificateOutput() ClusterClusterCertificateOutput
	ToClusterClusterCertificateOutputWithContext(context.Context) ClusterClusterCertificateOutput
}

type ClusterClusterCertificateArgs struct {
	// The HSM hardware certificate issued (signed) by AWS CloudHSM.
	AwsHardwareCertificate pulumi.StringPtrInput `pulumi:"awsHardwareCertificate"`
	// The cluster certificate issued (signed) by the issuing certificate authority (CA) of the cluster's owner.
	ClusterCertificate pulumi.StringPtrInput `pulumi:"clusterCertificate"`
	// The certificate signing request (CSR). Available only in `UNINITIALIZED` state after an HSM instance is added to the cluster.
	ClusterCsr pulumi.StringPtrInput `pulumi:"clusterCsr"`
	// The HSM certificate issued (signed) by the HSM hardware.
	HsmCertificate pulumi.StringPtrInput `pulumi:"hsmCertificate"`
	// The HSM hardware certificate issued (signed) by the hardware manufacturer.
	ManufacturerHardwareCertificate pulumi.StringPtrInput `pulumi:"manufacturerHardwareCertificate"`
}

func (ClusterClusterCertificateArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*ClusterClusterCertificate)(nil)).Elem()
}

func (i ClusterClusterCertificateArgs) ToClusterClusterCertificateOutput() ClusterClusterCertificateOutput {
	return i.ToClusterClusterCertificateOutputWithContext(context.Background())
}

func (i ClusterClusterCertificateArgs) ToClusterClusterCertificateOutputWithContext(ctx context.Context) ClusterClusterCertificateOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClusterClusterCertificateOutput)
}

// ClusterClusterCertificateArrayInput is an input type that accepts ClusterClusterCertificateArray and ClusterClusterCertificateArrayOutput values.
// You can construct a concrete instance of `ClusterClusterCertificateArrayInput` via:
//
//	ClusterClusterCertificateArray{ ClusterClusterCertificateArgs{...} }
type ClusterClusterCertificateArrayInput interface {
	pulumi.Input

	ToClusterClusterCertificateArrayOutput() ClusterClusterCertificateArrayOutput
	ToClusterClusterCertificateArrayOutputWithContext(context.Context) ClusterClusterCertificateArrayOutput
}

type ClusterClusterCertificateArray []ClusterClusterCertificateInput

func (ClusterClusterCertificateArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ClusterClusterCertificate)(nil)).Elem()
}

func (i ClusterClusterCertificateArray) ToClusterClusterCertificateArrayOutput() ClusterClusterCertificateArrayOutput {
	return i.ToClusterClusterCertificateArrayOutputWithContext(context.Background())
}

func (i ClusterClusterCertificateArray) ToClusterClusterCertificateArrayOutputWithContext(ctx context.Context) ClusterClusterCertificateArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClusterClusterCertificateArrayOutput)
}

type ClusterClusterCertificateOutput struct{ *pulumi.OutputState }

func (ClusterClusterCertificateOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*ClusterClusterCertificate)(nil)).Elem()
}

func (o ClusterClusterCertificateOutput) ToClusterClusterCertificateOutput() ClusterClusterCertificateOutput {
	return o
}

func (o ClusterClusterCertificateOutput) ToClusterClusterCertificateOutputWithContext(ctx context.Context) ClusterClusterCertificateOutput {
	return o
}

// The HSM hardware certificate issued (signed) by AWS CloudHSM.
func (o ClusterClusterCertificateOutput) AwsHardwareCertificate() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ClusterClusterCertificate) *string { return v.AwsHardwareCertificate }).(pulumi.StringPtrOutput)
}

// The cluster certificate issued (signed) by the issuing certificate authority (CA) of the cluster's owner.
func (o ClusterClusterCertificateOutput) ClusterCertificate() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ClusterClusterCertificate) *string { return v.ClusterCertificate }).(pulumi.StringPtrOutput)
}

// The certificate signing request (CSR). Available only in `UNINITIALIZED` state after an HSM instance is added to the cluster.
func (o ClusterClusterCertificateOutput) ClusterCsr() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ClusterClusterCertificate) *string { return v.ClusterCsr }).(pulumi.StringPtrOutput)
}

// The HSM certificate issued (signed) by the HSM hardware.
func (o ClusterClusterCertificateOutput) HsmCertificate() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ClusterClusterCertificate) *string { return v.HsmCertificate }).(pulumi.StringPtrOutput)
}

// The HSM hardware certificate issued (signed) by the hardware manufacturer.
func (o ClusterClusterCertificateOutput) ManufacturerHardwareCertificate() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ClusterClusterCertificate) *string { return v.ManufacturerHardwareCertificate }).(pulumi.StringPtrOutput)
}

type ClusterClusterCertificateArrayOutput struct{ *pulumi.OutputState }

func (ClusterClusterCertificateArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ClusterClusterCertificate)(nil)).Elem()
}

func (o ClusterClusterCertificateArrayOutput) ToClusterClusterCertificateArrayOutput() ClusterClusterCertificateArrayOutput {
	return o
}

func (o ClusterClusterCertificateArrayOutput) ToClusterClusterCertificateArrayOutputWithContext(ctx context.Context) ClusterClusterCertificateArrayOutput {
	return o
}

func (o ClusterClusterCertificateArrayOutput) Index(i pulumi.IntInput) ClusterClusterCertificateOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) ClusterClusterCertificate {
		return vs[0].([]ClusterClusterCertificate)[vs[1].(int)]
	}).(ClusterClusterCertificateOutput)
}

type GetClusterClusterCertificate struct {
	// The HSM hardware certificate issued (signed) by AWS CloudHSM.
	AwsHardwareCertificate string `pulumi:"awsHardwareCertificate"`
	// The cluster certificate issued (signed) by the issuing certificate authority (CA) of the cluster's owner.
	ClusterCertificate string `pulumi:"clusterCertificate"`
	// The certificate signing request (CSR). Available only in UNINITIALIZED state.
	ClusterCsr string `pulumi:"clusterCsr"`
	// The HSM certificate issued (signed) by the HSM hardware.
	HsmCertificate string `pulumi:"hsmCertificate"`
	// The HSM hardware certificate issued (signed) by the hardware manufacturer.
	// The number of available cluster certificates may vary depending on state of the cluster.
	ManufacturerHardwareCertificate string `pulumi:"manufacturerHardwareCertificate"`
}

// GetClusterClusterCertificateInput is an input type that accepts GetClusterClusterCertificateArgs and GetClusterClusterCertificateOutput values.
// You can construct a concrete instance of `GetClusterClusterCertificateInput` via:
//
//	GetClusterClusterCertificateArgs{...}
type GetClusterClusterCertificateInput interface {
	pulumi.Input

	ToGetClusterClusterCertificateOutput() GetClusterClusterCertificateOutput
	ToGetClusterClusterCertificateOutputWithContext(context.Context) GetClusterClusterCertificateOutput
}

type GetClusterClusterCertificateArgs struct {
	// The HSM hardware certificate issued (signed) by AWS CloudHSM.
	AwsHardwareCertificate pulumi.StringInput `pulumi:"awsHardwareCertificate"`
	// The cluster certificate issued (signed) by the issuing certificate authority (CA) of the cluster's owner.
	ClusterCertificate pulumi.StringInput `pulumi:"clusterCertificate"`
	// The certificate signing request (CSR). Available only in UNINITIALIZED state.
	ClusterCsr pulumi.StringInput `pulumi:"clusterCsr"`
	// The HSM certificate issued (signed) by the HSM hardware.
	HsmCertificate pulumi.StringInput `pulumi:"hsmCertificate"`
	// The HSM hardware certificate issued (signed) by the hardware manufacturer.
	// The number of available cluster certificates may vary depending on state of the cluster.
	ManufacturerHardwareCertificate pulumi.StringInput `pulumi:"manufacturerHardwareCertificate"`
}

func (GetClusterClusterCertificateArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetClusterClusterCertificate)(nil)).Elem()
}

func (i GetClusterClusterCertificateArgs) ToGetClusterClusterCertificateOutput() GetClusterClusterCertificateOutput {
	return i.ToGetClusterClusterCertificateOutputWithContext(context.Background())
}

func (i GetClusterClusterCertificateArgs) ToGetClusterClusterCertificateOutputWithContext(ctx context.Context) GetClusterClusterCertificateOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GetClusterClusterCertificateOutput)
}

// GetClusterClusterCertificateArrayInput is an input type that accepts GetClusterClusterCertificateArray and GetClusterClusterCertificateArrayOutput values.
// You can construct a concrete instance of `GetClusterClusterCertificateArrayInput` via:
//
//	GetClusterClusterCertificateArray{ GetClusterClusterCertificateArgs{...} }
type GetClusterClusterCertificateArrayInput interface {
	pulumi.Input

	ToGetClusterClusterCertificateArrayOutput() GetClusterClusterCertificateArrayOutput
	ToGetClusterClusterCertificateArrayOutputWithContext(context.Context) GetClusterClusterCertificateArrayOutput
}

type GetClusterClusterCertificateArray []GetClusterClusterCertificateInput

func (GetClusterClusterCertificateArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]GetClusterClusterCertificate)(nil)).Elem()
}

func (i GetClusterClusterCertificateArray) ToGetClusterClusterCertificateArrayOutput() GetClusterClusterCertificateArrayOutput {
	return i.ToGetClusterClusterCertificateArrayOutputWithContext(context.Background())
}

func (i GetClusterClusterCertificateArray) ToGetClusterClusterCertificateArrayOutputWithContext(ctx context.Context) GetClusterClusterCertificateArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(GetClusterClusterCertificateArrayOutput)
}

type GetClusterClusterCertificateOutput struct{ *pulumi.OutputState }

func (GetClusterClusterCertificateOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetClusterClusterCertificate)(nil)).Elem()
}

func (o GetClusterClusterCertificateOutput) ToGetClusterClusterCertificateOutput() GetClusterClusterCertificateOutput {
	return o
}

func (o GetClusterClusterCertificateOutput) ToGetClusterClusterCertificateOutputWithContext(ctx context.Context) GetClusterClusterCertificateOutput {
	return o
}

// The HSM hardware certificate issued (signed) by AWS CloudHSM.
func (o GetClusterClusterCertificateOutput) AwsHardwareCertificate() pulumi.StringOutput {
	return o.ApplyT(func(v GetClusterClusterCertificate) string { return v.AwsHardwareCertificate }).(pulumi.StringOutput)
}

// The cluster certificate issued (signed) by the issuing certificate authority (CA) of the cluster's owner.
func (o GetClusterClusterCertificateOutput) ClusterCertificate() pulumi.StringOutput {
	return o.ApplyT(func(v GetClusterClusterCertificate) string { return v.ClusterCertificate }).(pulumi.StringOutput)
}

// The certificate signing request (CSR). Available only in UNINITIALIZED state.
func (o GetClusterClusterCertificateOutput) ClusterCsr() pulumi.StringOutput {
	return o.ApplyT(func(v GetClusterClusterCertificate) string { return v.ClusterCsr }).(pulumi.StringOutput)
}

// The HSM certificate issued (signed) by the HSM hardware.
func (o GetClusterClusterCertificateOutput) HsmCertificate() pulumi.StringOutput {
	return o.ApplyT(func(v GetClusterClusterCertificate) string { return v.HsmCertificate }).(pulumi.StringOutput)
}

// The HSM hardware certificate issued (signed) by the hardware manufacturer.
// The number of available cluster certificates may vary depending on state of the cluster.
func (o GetClusterClusterCertificateOutput) ManufacturerHardwareCertificate() pulumi.StringOutput {
	return o.ApplyT(func(v GetClusterClusterCertificate) string { return v.ManufacturerHardwareCertificate }).(pulumi.StringOutput)
}

type GetClusterClusterCertificateArrayOutput struct{ *pulumi.OutputState }

func (GetClusterClusterCertificateArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]GetClusterClusterCertificate)(nil)).Elem()
}

func (o GetClusterClusterCertificateArrayOutput) ToGetClusterClusterCertificateArrayOutput() GetClusterClusterCertificateArrayOutput {
	return o
}

func (o GetClusterClusterCertificateArrayOutput) ToGetClusterClusterCertificateArrayOutputWithContext(ctx context.Context) GetClusterClusterCertificateArrayOutput {
	return o
}

func (o GetClusterClusterCertificateArrayOutput) Index(i pulumi.IntInput) GetClusterClusterCertificateOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) GetClusterClusterCertificate {
		return vs[0].([]GetClusterClusterCertificate)[vs[1].(int)]
	}).(GetClusterClusterCertificateOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ClusterClusterCertificateInput)(nil)).Elem(), ClusterClusterCertificateArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*ClusterClusterCertificateArrayInput)(nil)).Elem(), ClusterClusterCertificateArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*GetClusterClusterCertificateInput)(nil)).Elem(), GetClusterClusterCertificateArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*GetClusterClusterCertificateArrayInput)(nil)).Elem(), GetClusterClusterCertificateArray{})
	pulumi.RegisterOutputType(ClusterClusterCertificateOutput{})
	pulumi.RegisterOutputType(ClusterClusterCertificateArrayOutput{})
	pulumi.RegisterOutputType(GetClusterClusterCertificateOutput{})
	pulumi.RegisterOutputType(GetClusterClusterCertificateArrayOutput{})
}
