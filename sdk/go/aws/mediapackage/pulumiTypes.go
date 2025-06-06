// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package mediapackage

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

var _ = internal.GetEnvOrDefault

type ChannelHlsIngest struct {
	// A list of the ingest endpoints
	IngestEndpoints []ChannelHlsIngestIngestEndpoint `pulumi:"ingestEndpoints"`
}

// ChannelHlsIngestInput is an input type that accepts ChannelHlsIngestArgs and ChannelHlsIngestOutput values.
// You can construct a concrete instance of `ChannelHlsIngestInput` via:
//
//	ChannelHlsIngestArgs{...}
type ChannelHlsIngestInput interface {
	pulumi.Input

	ToChannelHlsIngestOutput() ChannelHlsIngestOutput
	ToChannelHlsIngestOutputWithContext(context.Context) ChannelHlsIngestOutput
}

type ChannelHlsIngestArgs struct {
	// A list of the ingest endpoints
	IngestEndpoints ChannelHlsIngestIngestEndpointArrayInput `pulumi:"ingestEndpoints"`
}

func (ChannelHlsIngestArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*ChannelHlsIngest)(nil)).Elem()
}

func (i ChannelHlsIngestArgs) ToChannelHlsIngestOutput() ChannelHlsIngestOutput {
	return i.ToChannelHlsIngestOutputWithContext(context.Background())
}

func (i ChannelHlsIngestArgs) ToChannelHlsIngestOutputWithContext(ctx context.Context) ChannelHlsIngestOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ChannelHlsIngestOutput)
}

// ChannelHlsIngestArrayInput is an input type that accepts ChannelHlsIngestArray and ChannelHlsIngestArrayOutput values.
// You can construct a concrete instance of `ChannelHlsIngestArrayInput` via:
//
//	ChannelHlsIngestArray{ ChannelHlsIngestArgs{...} }
type ChannelHlsIngestArrayInput interface {
	pulumi.Input

	ToChannelHlsIngestArrayOutput() ChannelHlsIngestArrayOutput
	ToChannelHlsIngestArrayOutputWithContext(context.Context) ChannelHlsIngestArrayOutput
}

type ChannelHlsIngestArray []ChannelHlsIngestInput

func (ChannelHlsIngestArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ChannelHlsIngest)(nil)).Elem()
}

func (i ChannelHlsIngestArray) ToChannelHlsIngestArrayOutput() ChannelHlsIngestArrayOutput {
	return i.ToChannelHlsIngestArrayOutputWithContext(context.Background())
}

func (i ChannelHlsIngestArray) ToChannelHlsIngestArrayOutputWithContext(ctx context.Context) ChannelHlsIngestArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ChannelHlsIngestArrayOutput)
}

type ChannelHlsIngestOutput struct{ *pulumi.OutputState }

func (ChannelHlsIngestOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*ChannelHlsIngest)(nil)).Elem()
}

func (o ChannelHlsIngestOutput) ToChannelHlsIngestOutput() ChannelHlsIngestOutput {
	return o
}

func (o ChannelHlsIngestOutput) ToChannelHlsIngestOutputWithContext(ctx context.Context) ChannelHlsIngestOutput {
	return o
}

// A list of the ingest endpoints
func (o ChannelHlsIngestOutput) IngestEndpoints() ChannelHlsIngestIngestEndpointArrayOutput {
	return o.ApplyT(func(v ChannelHlsIngest) []ChannelHlsIngestIngestEndpoint { return v.IngestEndpoints }).(ChannelHlsIngestIngestEndpointArrayOutput)
}

type ChannelHlsIngestArrayOutput struct{ *pulumi.OutputState }

func (ChannelHlsIngestArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ChannelHlsIngest)(nil)).Elem()
}

func (o ChannelHlsIngestArrayOutput) ToChannelHlsIngestArrayOutput() ChannelHlsIngestArrayOutput {
	return o
}

func (o ChannelHlsIngestArrayOutput) ToChannelHlsIngestArrayOutputWithContext(ctx context.Context) ChannelHlsIngestArrayOutput {
	return o
}

func (o ChannelHlsIngestArrayOutput) Index(i pulumi.IntInput) ChannelHlsIngestOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) ChannelHlsIngest {
		return vs[0].([]ChannelHlsIngest)[vs[1].(int)]
	}).(ChannelHlsIngestOutput)
}

type ChannelHlsIngestIngestEndpoint struct {
	// The password
	Password *string `pulumi:"password"`
	// The URL
	Url *string `pulumi:"url"`
	// The username
	Username *string `pulumi:"username"`
}

// ChannelHlsIngestIngestEndpointInput is an input type that accepts ChannelHlsIngestIngestEndpointArgs and ChannelHlsIngestIngestEndpointOutput values.
// You can construct a concrete instance of `ChannelHlsIngestIngestEndpointInput` via:
//
//	ChannelHlsIngestIngestEndpointArgs{...}
type ChannelHlsIngestIngestEndpointInput interface {
	pulumi.Input

	ToChannelHlsIngestIngestEndpointOutput() ChannelHlsIngestIngestEndpointOutput
	ToChannelHlsIngestIngestEndpointOutputWithContext(context.Context) ChannelHlsIngestIngestEndpointOutput
}

type ChannelHlsIngestIngestEndpointArgs struct {
	// The password
	Password pulumi.StringPtrInput `pulumi:"password"`
	// The URL
	Url pulumi.StringPtrInput `pulumi:"url"`
	// The username
	Username pulumi.StringPtrInput `pulumi:"username"`
}

func (ChannelHlsIngestIngestEndpointArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*ChannelHlsIngestIngestEndpoint)(nil)).Elem()
}

func (i ChannelHlsIngestIngestEndpointArgs) ToChannelHlsIngestIngestEndpointOutput() ChannelHlsIngestIngestEndpointOutput {
	return i.ToChannelHlsIngestIngestEndpointOutputWithContext(context.Background())
}

func (i ChannelHlsIngestIngestEndpointArgs) ToChannelHlsIngestIngestEndpointOutputWithContext(ctx context.Context) ChannelHlsIngestIngestEndpointOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ChannelHlsIngestIngestEndpointOutput)
}

// ChannelHlsIngestIngestEndpointArrayInput is an input type that accepts ChannelHlsIngestIngestEndpointArray and ChannelHlsIngestIngestEndpointArrayOutput values.
// You can construct a concrete instance of `ChannelHlsIngestIngestEndpointArrayInput` via:
//
//	ChannelHlsIngestIngestEndpointArray{ ChannelHlsIngestIngestEndpointArgs{...} }
type ChannelHlsIngestIngestEndpointArrayInput interface {
	pulumi.Input

	ToChannelHlsIngestIngestEndpointArrayOutput() ChannelHlsIngestIngestEndpointArrayOutput
	ToChannelHlsIngestIngestEndpointArrayOutputWithContext(context.Context) ChannelHlsIngestIngestEndpointArrayOutput
}

type ChannelHlsIngestIngestEndpointArray []ChannelHlsIngestIngestEndpointInput

func (ChannelHlsIngestIngestEndpointArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ChannelHlsIngestIngestEndpoint)(nil)).Elem()
}

func (i ChannelHlsIngestIngestEndpointArray) ToChannelHlsIngestIngestEndpointArrayOutput() ChannelHlsIngestIngestEndpointArrayOutput {
	return i.ToChannelHlsIngestIngestEndpointArrayOutputWithContext(context.Background())
}

func (i ChannelHlsIngestIngestEndpointArray) ToChannelHlsIngestIngestEndpointArrayOutputWithContext(ctx context.Context) ChannelHlsIngestIngestEndpointArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ChannelHlsIngestIngestEndpointArrayOutput)
}

type ChannelHlsIngestIngestEndpointOutput struct{ *pulumi.OutputState }

func (ChannelHlsIngestIngestEndpointOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*ChannelHlsIngestIngestEndpoint)(nil)).Elem()
}

func (o ChannelHlsIngestIngestEndpointOutput) ToChannelHlsIngestIngestEndpointOutput() ChannelHlsIngestIngestEndpointOutput {
	return o
}

func (o ChannelHlsIngestIngestEndpointOutput) ToChannelHlsIngestIngestEndpointOutputWithContext(ctx context.Context) ChannelHlsIngestIngestEndpointOutput {
	return o
}

// The password
func (o ChannelHlsIngestIngestEndpointOutput) Password() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ChannelHlsIngestIngestEndpoint) *string { return v.Password }).(pulumi.StringPtrOutput)
}

// The URL
func (o ChannelHlsIngestIngestEndpointOutput) Url() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ChannelHlsIngestIngestEndpoint) *string { return v.Url }).(pulumi.StringPtrOutput)
}

// The username
func (o ChannelHlsIngestIngestEndpointOutput) Username() pulumi.StringPtrOutput {
	return o.ApplyT(func(v ChannelHlsIngestIngestEndpoint) *string { return v.Username }).(pulumi.StringPtrOutput)
}

type ChannelHlsIngestIngestEndpointArrayOutput struct{ *pulumi.OutputState }

func (ChannelHlsIngestIngestEndpointArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]ChannelHlsIngestIngestEndpoint)(nil)).Elem()
}

func (o ChannelHlsIngestIngestEndpointArrayOutput) ToChannelHlsIngestIngestEndpointArrayOutput() ChannelHlsIngestIngestEndpointArrayOutput {
	return o
}

func (o ChannelHlsIngestIngestEndpointArrayOutput) ToChannelHlsIngestIngestEndpointArrayOutputWithContext(ctx context.Context) ChannelHlsIngestIngestEndpointArrayOutput {
	return o
}

func (o ChannelHlsIngestIngestEndpointArrayOutput) Index(i pulumi.IntInput) ChannelHlsIngestIngestEndpointOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) ChannelHlsIngestIngestEndpoint {
		return vs[0].([]ChannelHlsIngestIngestEndpoint)[vs[1].(int)]
	}).(ChannelHlsIngestIngestEndpointOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ChannelHlsIngestInput)(nil)).Elem(), ChannelHlsIngestArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*ChannelHlsIngestArrayInput)(nil)).Elem(), ChannelHlsIngestArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ChannelHlsIngestIngestEndpointInput)(nil)).Elem(), ChannelHlsIngestIngestEndpointArgs{})
	pulumi.RegisterInputType(reflect.TypeOf((*ChannelHlsIngestIngestEndpointArrayInput)(nil)).Elem(), ChannelHlsIngestIngestEndpointArray{})
	pulumi.RegisterOutputType(ChannelHlsIngestOutput{})
	pulumi.RegisterOutputType(ChannelHlsIngestArrayOutput{})
	pulumi.RegisterOutputType(ChannelHlsIngestIngestEndpointOutput{})
	pulumi.RegisterOutputType(ChannelHlsIngestIngestEndpointArrayOutput{})
}
