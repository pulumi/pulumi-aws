// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package rolesanywhere

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

var _ = internal.GetEnvOrDefault

type TrustAnchorNotificationSetting struct {
	Channel      *string `pulumi:"channel"`
	ConfiguredBy *string `pulumi:"configuredBy"`
	// Whether or not the Trust Anchor should be enabled.
	Enabled   *bool   `pulumi:"enabled"`
	Event     *string `pulumi:"event"`
	Threshold *int    `pulumi:"threshold"`
}

// TrustAnchorNotificationSettingInput is an input type that accepts TrustAnchorNotificationSettingArgs and TrustAnchorNotificationSettingOutput values.
// You can construct a concrete instance of `TrustAnchorNotificationSettingInput` via:
//
//	TrustAnchorNotificationSettingArgs{...}
type TrustAnchorNotificationSettingInput interface {
	pulumi.Input

	ToTrustAnchorNotificationSettingOutput() TrustAnchorNotificationSettingOutput
	ToTrustAnchorNotificationSettingOutputWithContext(context.Context) TrustAnchorNotificationSettingOutput
}

type TrustAnchorNotificationSettingArgs struct {
	Channel      pulumi.StringPtrInput `pulumi:"channel"`
	ConfiguredBy pulumi.StringPtrInput `pulumi:"configuredBy"`
	// Whether or not the Trust Anchor should be enabled.
	Enabled   pulumi.BoolPtrInput   `pulumi:"enabled"`
	Event     pulumi.StringPtrInput `pulumi:"event"`
	Threshold pulumi.IntPtrInput    `pulumi:"threshold"`
}

func (TrustAnchorNotificationSettingArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*TrustAnchorNotificationSetting)(nil)).Elem()
}

func (i TrustAnchorNotificationSettingArgs) ToTrustAnchorNotificationSettingOutput() TrustAnchorNotificationSettingOutput {
	return i.ToTrustAnchorNotificationSettingOutputWithContext(context.Background())
}

func (i TrustAnchorNotificationSettingArgs) ToTrustAnchorNotificationSettingOutputWithContext(ctx context.Context) TrustAnchorNotificationSettingOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TrustAnchorNotificationSettingOutput)
}

// TrustAnchorNotificationSettingArrayInput is an input type that accepts TrustAnchorNotificationSettingArray and TrustAnchorNotificationSettingArrayOutput values.
// You can construct a concrete instance of `TrustAnchorNotificationSettingArrayInput` via:
//
//	TrustAnchorNotificationSettingArray{ TrustAnchorNotificationSettingArgs{...} }
type TrustAnchorNotificationSettingArrayInput interface {
	pulumi.Input

	ToTrustAnchorNotificationSettingArrayOutput() TrustAnchorNotificationSettingArrayOutput
	ToTrustAnchorNotificationSettingArrayOutputWithContext(context.Context) TrustAnchorNotificationSettingArrayOutput
}

type TrustAnchorNotificationSettingArray []TrustAnchorNotificationSettingInput

func (TrustAnchorNotificationSettingArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]TrustAnchorNotificationSetting)(nil)).Elem()
}

func (i TrustAnchorNotificationSettingArray) ToTrustAnchorNotificationSettingArrayOutput() TrustAnchorNotificationSettingArrayOutput {
	return i.ToTrustAnchorNotificationSettingArrayOutputWithContext(context.Background())
}

func (i TrustAnchorNotificationSettingArray) ToTrustAnchorNotificationSettingArrayOutputWithContext(ctx context.Context) TrustAnchorNotificationSettingArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TrustAnchorNotificationSettingArrayOutput)
}

type TrustAnchorNotificationSettingOutput struct{ *pulumi.OutputState }

func (TrustAnchorNotificationSettingOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*TrustAnchorNotificationSetting)(nil)).Elem()
}

func (o TrustAnchorNotificationSettingOutput) ToTrustAnchorNotificationSettingOutput() TrustAnchorNotificationSettingOutput {
	return o
}

func (o TrustAnchorNotificationSettingOutput) ToTrustAnchorNotificationSettingOutputWithContext(ctx context.Context) TrustAnchorNotificationSettingOutput {
	return o
}

func (o TrustAnchorNotificationSettingOutput) Channel() pulumi.StringPtrOutput {
	return o.ApplyT(func(v TrustAnchorNotificationSetting) *string { return v.Channel }).(pulumi.StringPtrOutput)
}

func (o TrustAnchorNotificationSettingOutput) ConfiguredBy() pulumi.StringPtrOutput {
	return o.ApplyT(func(v TrustAnchorNotificationSetting) *string { return v.ConfiguredBy }).(pulumi.StringPtrOutput)
}

// Whether or not the Trust Anchor should be enabled.
func (o TrustAnchorNotificationSettingOutput) Enabled() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v TrustAnchorNotificationSetting) *bool { return v.Enabled }).(pulumi.BoolPtrOutput)
}

func (o TrustAnchorNotificationSettingOutput) Event() pulumi.StringPtrOutput {
	return o.ApplyT(func(v TrustAnchorNotificationSetting) *string { return v.Event }).(pulumi.StringPtrOutput)
}

func (o TrustAnchorNotificationSettingOutput) Threshold() pulumi.IntPtrOutput {
	return o.ApplyT(func(v TrustAnchorNotificationSetting) *int { return v.Threshold }).(pulumi.IntPtrOutput)
}

type TrustAnchorNotificationSettingArrayOutput struct{ *pulumi.OutputState }

func (TrustAnchorNotificationSettingArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]TrustAnchorNotificationSetting)(nil)).Elem()
}

func (o TrustAnchorNotificationSettingArrayOutput) ToTrustAnchorNotificationSettingArrayOutput() TrustAnchorNotificationSettingArrayOutput {
	return o
}

func (o TrustAnchorNotificationSettingArrayOutput) ToTrustAnchorNotificationSettingArrayOutputWithContext(ctx context.Context) TrustAnchorNotificationSettingArrayOutput {
	return o
}

func (o TrustAnchorNotificationSettingArrayOutput) Index(i pulumi.IntInput) TrustAnchorNotificationSettingOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) TrustAnchorNotificationSetting {
		return vs[0].([]TrustAnchorNotificationSetting)[vs[1].(int)]
	}).(TrustAnchorNotificationSettingOutput)
}

type TrustAnchorSource struct {
	// The data denoting the source of trust, documented below
	SourceData TrustAnchorSourceSourceData `pulumi:"sourceData"`
	// The type of the source of trust. Must be either `AWS_ACM_PCA` or `CERTIFICATE_BUNDLE`.
	SourceType string `pulumi:"sourceType"`
}

// TrustAnchorSourceInput is an input type that accepts TrustAnchorSourceArgs and TrustAnchorSourceOutput values.
// You can construct a concrete instance of `TrustAnchorSourceInput` via:
//
//	TrustAnchorSourceArgs{...}
type TrustAnchorSourceInput interface {
	pulumi.Input

	ToTrustAnchorSourceOutput() TrustAnchorSourceOutput
	ToTrustAnchorSourceOutputWithContext(context.Context) TrustAnchorSourceOutput
}

type TrustAnchorSourceArgs struct {
	// The data denoting the source of trust, documented below
	SourceData TrustAnchorSourceSourceDataInput `pulumi:"sourceData"`
	// The type of the source of trust. Must be either `AWS_ACM_PCA` or `CERTIFICATE_BUNDLE`.
	SourceType pulumi.StringInput `pulumi:"sourceType"`
}

func (TrustAnchorSourceArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*TrustAnchorSource)(nil)).Elem()
}

func (i TrustAnchorSourceArgs) ToTrustAnchorSourceOutput() TrustAnchorSourceOutput {
	return i.ToTrustAnchorSourceOutputWithContext(context.Background())
}

func (i TrustAnchorSourceArgs) ToTrustAnchorSourceOutputWithContext(ctx context.Context) TrustAnchorSourceOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TrustAnchorSourceOutput)
}

func (i TrustAnchorSourceArgs) ToTrustAnchorSourcePtrOutput() TrustAnchorSourcePtrOutput {
	return i.ToTrustAnchorSourcePtrOutputWithContext(context.Background())
}

func (i TrustAnchorSourceArgs) ToTrustAnchorSourcePtrOutputWithContext(ctx context.Context) TrustAnchorSourcePtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TrustAnchorSourceOutput).ToTrustAnchorSourcePtrOutputWithContext(ctx)
}

// TrustAnchorSourcePtrInput is an input type that accepts TrustAnchorSourceArgs, TrustAnchorSourcePtr and TrustAnchorSourcePtrOutput values.
// You can construct a concrete instance of `TrustAnchorSourcePtrInput` via:
//
//	        TrustAnchorSourceArgs{...}
//
//	or:
//
//	        nil
type TrustAnchorSourcePtrInput interface {
	pulumi.Input

	ToTrustAnchorSourcePtrOutput() TrustAnchorSourcePtrOutput
	ToTrustAnchorSourcePtrOutputWithContext(context.Context) TrustAnchorSourcePtrOutput
}

type trustAnchorSourcePtrType TrustAnchorSourceArgs

func TrustAnchorSourcePtr(v *TrustAnchorSourceArgs) TrustAnchorSourcePtrInput {
	return (*trustAnchorSourcePtrType)(v)
}

func (*trustAnchorSourcePtrType) ElementType() reflect.Type {
	return reflect.TypeOf((**TrustAnchorSource)(nil)).Elem()
}

func (i *trustAnchorSourcePtrType) ToTrustAnchorSourcePtrOutput() TrustAnchorSourcePtrOutput {
	return i.ToTrustAnchorSourcePtrOutputWithContext(context.Background())
}

func (i *trustAnchorSourcePtrType) ToTrustAnchorSourcePtrOutputWithContext(ctx context.Context) TrustAnchorSourcePtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TrustAnchorSourcePtrOutput)
}

type TrustAnchorSourceOutput struct{ *pulumi.OutputState }

func (TrustAnchorSourceOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*TrustAnchorSource)(nil)).Elem()
}

func (o TrustAnchorSourceOutput) ToTrustAnchorSourceOutput() TrustAnchorSourceOutput {
	return o
}

func (o TrustAnchorSourceOutput) ToTrustAnchorSourceOutputWithContext(ctx context.Context) TrustAnchorSourceOutput {
	return o
}

func (o TrustAnchorSourceOutput) ToTrustAnchorSourcePtrOutput() TrustAnchorSourcePtrOutput {
	return o.ToTrustAnchorSourcePtrOutputWithContext(context.Background())
}

func (o TrustAnchorSourceOutput) ToTrustAnchorSourcePtrOutputWithContext(ctx context.Context) TrustAnchorSourcePtrOutput {
	return o.ApplyTWithContext(ctx, func(_ context.Context, v TrustAnchorSource) *TrustAnchorSource {
		return &v
	}).(TrustAnchorSourcePtrOutput)
}

// The data denoting the source of trust, documented below
func (o TrustAnchorSourceOutput) SourceData() TrustAnchorSourceSourceDataOutput {
	return o.ApplyT(func(v TrustAnchorSource) TrustAnchorSourceSourceData { return v.SourceData }).(TrustAnchorSourceSourceDataOutput)
}

// The type of the source of trust. Must be either `AWS_ACM_PCA` or `CERTIFICATE_BUNDLE`.
func (o TrustAnchorSourceOutput) SourceType() pulumi.StringOutput {
	return o.ApplyT(func(v TrustAnchorSource) string { return v.SourceType }).(pulumi.StringOutput)
}

type TrustAnchorSourcePtrOutput struct{ *pulumi.OutputState }

func (TrustAnchorSourcePtrOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**TrustAnchorSource)(nil)).Elem()
}

func (o TrustAnchorSourcePtrOutput) ToTrustAnchorSourcePtrOutput() TrustAnchorSourcePtrOutput {
	return o
}

func (o TrustAnchorSourcePtrOutput) ToTrustAnchorSourcePtrOutputWithContext(ctx context.Context) TrustAnchorSourcePtrOutput {
	return o
}

func (o TrustAnchorSourcePtrOutput) Elem() TrustAnchorSourceOutput {
	return o.ApplyT(func(v *TrustAnchorSource) TrustAnchorSource {
		if v != nil {
			return *v
		}
		var ret TrustAnchorSource
		return ret
	}).(TrustAnchorSourceOutput)
}

// The data denoting the source of trust, documented below
func (o TrustAnchorSourcePtrOutput) SourceData() TrustAnchorSourceSourceDataPtrOutput {
	return o.ApplyT(func(v *TrustAnchorSource) *TrustAnchorSourceSourceData {
		if v == nil {
			return nil
		}
		return &v.SourceData
	}).(TrustAnchorSourceSourceDataPtrOutput)
}

// The type of the source of trust. Must be either `AWS_ACM_PCA` or `CERTIFICATE_BUNDLE`.
func (o TrustAnchorSourcePtrOutput) SourceType() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *TrustAnchorSource) *string {
		if v == nil {
			return nil
		}
		return &v.SourceType
	}).(pulumi.StringPtrOutput)
}

type TrustAnchorSourceSourceData struct {
	// The ARN of an ACM Private Certificate Authority.
	AcmPcaArn           *string `pulumi:"acmPcaArn"`
	X509CertificateData *string `pulumi:"x509CertificateData"`
}

// TrustAnchorSourceSourceDataInput is an input type that accepts TrustAnchorSourceSourceDataArgs and TrustAnchorSourceSourceDataOutput values.
// You can construct a concrete instance of `TrustAnchorSourceSourceDataInput` via:
//
//	TrustAnchorSourceSourceDataArgs{...}
type TrustAnchorSourceSourceDataInput interface {
	pulumi.Input

	ToTrustAnchorSourceSourceDataOutput() TrustAnchorSourceSourceDataOutput
	ToTrustAnchorSourceSourceDataOutputWithContext(context.Context) TrustAnchorSourceSourceDataOutput
}

type TrustAnchorSourceSourceDataArgs struct {
	// The ARN of an ACM Private Certificate Authority.
	AcmPcaArn           pulumi.StringPtrInput `pulumi:"acmPcaArn"`
	X509CertificateData pulumi.StringPtrInput `pulumi:"x509CertificateData"`
}

func (TrustAnchorSourceSourceDataArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*TrustAnchorSourceSourceData)(nil)).Elem()
}

func (i TrustAnchorSourceSourceDataArgs) ToTrustAnchorSourceSourceDataOutput() TrustAnchorSourceSourceDataOutput {
	return i.ToTrustAnchorSourceSourceDataOutputWithContext(context.Background())
}

func (i TrustAnchorSourceSourceDataArgs) ToTrustAnchorSourceSourceDataOutputWithContext(ctx context.Context) TrustAnchorSourceSourceDataOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TrustAnchorSourceSourceDataOutput)
}

func (i TrustAnchorSourceSourceDataArgs) ToTrustAnchorSourceSourceDataPtrOutput() TrustAnchorSourceSourceDataPtrOutput {
	return i.ToTrustAnchorSourceSourceDataPtrOutputWithContext(context.Background())
}

func (i TrustAnchorSourceSourceDataArgs) ToTrustAnchorSourceSourceDataPtrOutputWithContext(ctx context.Context) TrustAnchorSourceSourceDataPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TrustAnchorSourceSourceDataOutput).ToTrustAnchorSourceSourceDataPtrOutputWithContext(ctx)
}

// TrustAnchorSourceSourceDataPtrInput is an input type that accepts TrustAnchorSourceSourceDataArgs, TrustAnchorSourceSourceDataPtr and TrustAnchorSourceSourceDataPtrOutput values.
// You can construct a concrete instance of `TrustAnchorSourceSourceDataPtrInput` via:
//
//	        TrustAnchorSourceSourceDataArgs{...}
//
//	or:
//
//	        nil
type TrustAnchorSourceSourceDataPtrInput interface {
	pulumi.Input

	ToTrustAnchorSourceSourceDataPtrOutput() TrustAnchorSourceSourceDataPtrOutput
	ToTrustAnchorSourceSourceDataPtrOutputWithContext(context.Context) TrustAnchorSourceSourceDataPtrOutput
}

type trustAnchorSourceSourceDataPtrType TrustAnchorSourceSourceDataArgs

func TrustAnchorSourceSourceDataPtr(v *TrustAnchorSourceSourceDataArgs) TrustAnchorSourceSourceDataPtrInput {
	return (*trustAnchorSourceSourceDataPtrType)(v)
}

func (*trustAnchorSourceSourceDataPtrType) ElementType() reflect.Type {
	return reflect.TypeOf((**TrustAnchorSourceSourceData)(nil)).Elem()
}

func (i *trustAnchorSourceSourceDataPtrType) ToTrustAnchorSourceSourceDataPtrOutput() TrustAnchorSourceSourceDataPtrOutput {
	return i.ToTrustAnchorSourceSourceDataPtrOutputWithContext(context.Background())
}

func (i *trustAnchorSourceSourceDataPtrType) ToTrustAnchorSourceSourceDataPtrOutputWithContext(ctx context.Context) TrustAnchorSourceSourceDataPtrOutput {
	return pulumi.ToOutputWithContext(ctx, i).(TrustAnchorSourceSourceDataPtrOutput)
}

type TrustAnchorSourceSourceDataOutput struct{ *pulumi.OutputState }

func (TrustAnchorSourceSourceDataOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*TrustAnchorSourceSourceData)(nil)).Elem()
}

func (o TrustAnchorSourceSourceDataOutput) ToTrustAnchorSourceSourceDataOutput() TrustAnchorSourceSourceDataOutput {
	return o
}

func (o TrustAnchorSourceSourceDataOutput) ToTrustAnchorSourceSourceDataOutputWithContext(ctx context.Context) TrustAnchorSourceSourceDataOutput {
	return o
}

func (o TrustAnchorSourceSourceDataOutput) ToTrustAnchorSourceSourceDataPtrOutput() TrustAnchorSourceSourceDataPtrOutput {
	return o.ToTrustAnchorSourceSourceDataPtrOutputWithContext(context.Background())
}

func (o TrustAnchorSourceSourceDataOutput) ToTrustAnchorSourceSourceDataPtrOutputWithContext(ctx context.Context) TrustAnchorSourceSourceDataPtrOutput {
	return o.ApplyTWithContext(ctx, func(_ context.Context, v TrustAnchorSourceSourceData) *TrustAnchorSourceSourceData {
		return &v
	}).(TrustAnchorSourceSourceDataPtrOutput)
}

// The ARN of an ACM Private Certificate Authority.
func (o TrustAnchorSourceSourceDataOutput) AcmPcaArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v TrustAnchorSourceSourceData) *string { return v.AcmPcaArn }).(pulumi.StringPtrOutput)
}

func (o TrustAnchorSourceSourceDataOutput) X509CertificateData() pulumi.StringPtrOutput {
	return o.ApplyT(func(v TrustAnchorSourceSourceData) *string { return v.X509CertificateData }).(pulumi.StringPtrOutput)
}

type TrustAnchorSourceSourceDataPtrOutput struct{ *pulumi.OutputState }

func (TrustAnchorSourceSourceDataPtrOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**TrustAnchorSourceSourceData)(nil)).Elem()
}

func (o TrustAnchorSourceSourceDataPtrOutput) ToTrustAnchorSourceSourceDataPtrOutput() TrustAnchorSourceSourceDataPtrOutput {
	return o
}

func (o TrustAnchorSourceSourceDataPtrOutput) ToTrustAnchorSourceSourceDataPtrOutputWithContext(ctx context.Context) TrustAnchorSourceSourceDataPtrOutput {
	return o
}

func (o TrustAnchorSourceSourceDataPtrOutput) Elem() TrustAnchorSourceSourceDataOutput {
	return o.ApplyT(func(v *TrustAnchorSourceSourceData) TrustAnchorSourceSourceData {
		if v != nil {
			return *v
		}
		var ret TrustAnchorSourceSourceData
		return ret
	}).(TrustAnchorSourceSourceDataOutput)
}

// The ARN of an ACM Private Certificate Authority.
func (o TrustAnchorSourceSourceDataPtrOutput) AcmPcaArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *TrustAnchorSourceSourceData) *string {
		if v == nil {
			return nil
		}
		return v.AcmPcaArn
	}).(pulumi.StringPtrOutput)
}

func (o TrustAnchorSourceSourceDataPtrOutput) X509CertificateData() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *TrustAnchorSourceSourceData) *string {
		if v == nil {
			return nil
		}
		return v.X509CertificateData
	}).(pulumi.StringPtrOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*TrustAnchorNotificationSettingInput)(nil)).Elem(), TrustAnchorNotificationSettingArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*TrustAnchorNotificationSettingArrayInput)(nil)).Elem(), TrustAnchorNotificationSettingArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*TrustAnchorSourceInput)(nil)).Elem(), TrustAnchorSourceArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*TrustAnchorSourcePtrInput)(nil)).Elem(), TrustAnchorSourceArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*TrustAnchorSourceSourceDataInput)(nil)).Elem(), TrustAnchorSourceSourceDataArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*TrustAnchorSourceSourceDataPtrInput)(nil)).Elem(), TrustAnchorSourceSourceDataArgs{})
	pulumi.RegisterOutputType(TrustAnchorNotificationSettingOutput{})
	pulumi.RegisterOutputType(TrustAnchorNotificationSettingArrayOutput{})
	pulumi.RegisterOutputType(TrustAnchorSourceOutput{})
	pulumi.RegisterOutputType(TrustAnchorSourcePtrOutput{})
	pulumi.RegisterOutputType(TrustAnchorSourceSourceDataOutput{})
	pulumi.RegisterOutputType(TrustAnchorSourceSourceDataPtrOutput{})
}
