// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apigateway

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an API Gateway Client Certificate.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/apigateway"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := apigateway.NewClientCertificate(ctx, "demo", &apigateway.ClientCertificateArgs{
//				Description: pulumi.String("My client certificate"),
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
// Using `pulumi import`, import API Gateway Client Certificates using the id. For example:
//
// ```sh
// $ pulumi import aws:apigateway/clientCertificate:ClientCertificate demo ab1cqe
// ```
type ClientCertificate struct {
	pulumi.CustomResourceState

	// ARN
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Date when the client certificate was created.
	CreatedDate pulumi.StringOutput `pulumi:"createdDate"`
	// Description of the client certificate.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Date when the client certificate will expire.
	ExpirationDate pulumi.StringOutput `pulumi:"expirationDate"`
	// The PEM-encoded public key of the client certificate.
	PemEncodedCertificate pulumi.StringOutput `pulumi:"pemEncodedCertificate"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewClientCertificate registers a new resource with the given unique name, arguments, and options.
func NewClientCertificate(ctx *pulumi.Context,
	name string, args *ClientCertificateArgs, opts ...pulumi.ResourceOption) (*ClientCertificate, error) {
	if args == nil {
		args = &ClientCertificateArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ClientCertificate
	err := ctx.RegisterResource("aws:apigateway/clientCertificate:ClientCertificate", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetClientCertificate gets an existing ClientCertificate resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetClientCertificate(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ClientCertificateState, opts ...pulumi.ResourceOption) (*ClientCertificate, error) {
	var resource ClientCertificate
	err := ctx.ReadResource("aws:apigateway/clientCertificate:ClientCertificate", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ClientCertificate resources.
type clientCertificateState struct {
	// ARN
	Arn *string `pulumi:"arn"`
	// Date when the client certificate was created.
	CreatedDate *string `pulumi:"createdDate"`
	// Description of the client certificate.
	Description *string `pulumi:"description"`
	// Date when the client certificate will expire.
	ExpirationDate *string `pulumi:"expirationDate"`
	// The PEM-encoded public key of the client certificate.
	PemEncodedCertificate *string `pulumi:"pemEncodedCertificate"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type ClientCertificateState struct {
	// ARN
	Arn pulumi.StringPtrInput
	// Date when the client certificate was created.
	CreatedDate pulumi.StringPtrInput
	// Description of the client certificate.
	Description pulumi.StringPtrInput
	// Date when the client certificate will expire.
	ExpirationDate pulumi.StringPtrInput
	// The PEM-encoded public key of the client certificate.
	PemEncodedCertificate pulumi.StringPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (ClientCertificateState) ElementType() reflect.Type {
	return reflect.TypeOf((*clientCertificateState)(nil)).Elem()
}

type clientCertificateArgs struct {
	// Description of the client certificate.
	Description *string `pulumi:"description"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a ClientCertificate resource.
type ClientCertificateArgs struct {
	// Description of the client certificate.
	Description pulumi.StringPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (ClientCertificateArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*clientCertificateArgs)(nil)).Elem()
}

type ClientCertificateInput interface {
	pulumi.Input

	ToClientCertificateOutput() ClientCertificateOutput
	ToClientCertificateOutputWithContext(ctx context.Context) ClientCertificateOutput
}

func (*ClientCertificate) ElementType() reflect.Type {
	return reflect.TypeOf((**ClientCertificate)(nil)).Elem()
}

func (i *ClientCertificate) ToClientCertificateOutput() ClientCertificateOutput {
	return i.ToClientCertificateOutputWithContext(context.Background())
}

func (i *ClientCertificate) ToClientCertificateOutputWithContext(ctx context.Context) ClientCertificateOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClientCertificateOutput)
}

// ClientCertificateArrayInput is an input type that accepts ClientCertificateArray and ClientCertificateArrayOutput values.
// You can construct a concrete instance of `ClientCertificateArrayInput` via:
//
//	ClientCertificateArray{ ClientCertificateArgs{...} }
type ClientCertificateArrayInput interface {
	pulumi.Input

	ToClientCertificateArrayOutput() ClientCertificateArrayOutput
	ToClientCertificateArrayOutputWithContext(context.Context) ClientCertificateArrayOutput
}

type ClientCertificateArray []ClientCertificateInput

func (ClientCertificateArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ClientCertificate)(nil)).Elem()
}

func (i ClientCertificateArray) ToClientCertificateArrayOutput() ClientCertificateArrayOutput {
	return i.ToClientCertificateArrayOutputWithContext(context.Background())
}

func (i ClientCertificateArray) ToClientCertificateArrayOutputWithContext(ctx context.Context) ClientCertificateArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClientCertificateArrayOutput)
}

// ClientCertificateMapInput is an input type that accepts ClientCertificateMap and ClientCertificateMapOutput values.
// You can construct a concrete instance of `ClientCertificateMapInput` via:
//
//	ClientCertificateMap{ "key": ClientCertificateArgs{...} }
type ClientCertificateMapInput interface {
	pulumi.Input

	ToClientCertificateMapOutput() ClientCertificateMapOutput
	ToClientCertificateMapOutputWithContext(context.Context) ClientCertificateMapOutput
}

type ClientCertificateMap map[string]ClientCertificateInput

func (ClientCertificateMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ClientCertificate)(nil)).Elem()
}

func (i ClientCertificateMap) ToClientCertificateMapOutput() ClientCertificateMapOutput {
	return i.ToClientCertificateMapOutputWithContext(context.Background())
}

func (i ClientCertificateMap) ToClientCertificateMapOutputWithContext(ctx context.Context) ClientCertificateMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClientCertificateMapOutput)
}

type ClientCertificateOutput struct{ *pulumi.OutputState }

func (ClientCertificateOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ClientCertificate)(nil)).Elem()
}

func (o ClientCertificateOutput) ToClientCertificateOutput() ClientCertificateOutput {
	return o
}

func (o ClientCertificateOutput) ToClientCertificateOutputWithContext(ctx context.Context) ClientCertificateOutput {
	return o
}

// ARN
func (o ClientCertificateOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *ClientCertificate) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Date when the client certificate was created.
func (o ClientCertificateOutput) CreatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v *ClientCertificate) pulumi.StringOutput { return v.CreatedDate }).(pulumi.StringOutput)
}

// Description of the client certificate.
func (o ClientCertificateOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ClientCertificate) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Date when the client certificate will expire.
func (o ClientCertificateOutput) ExpirationDate() pulumi.StringOutput {
	return o.ApplyT(func(v *ClientCertificate) pulumi.StringOutput { return v.ExpirationDate }).(pulumi.StringOutput)
}

// The PEM-encoded public key of the client certificate.
func (o ClientCertificateOutput) PemEncodedCertificate() pulumi.StringOutput {
	return o.ApplyT(func(v *ClientCertificate) pulumi.StringOutput { return v.PemEncodedCertificate }).(pulumi.StringOutput)
}

// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ClientCertificateOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ClientCertificate) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ClientCertificateOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ClientCertificate) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type ClientCertificateArrayOutput struct{ *pulumi.OutputState }

func (ClientCertificateArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ClientCertificate)(nil)).Elem()
}

func (o ClientCertificateArrayOutput) ToClientCertificateArrayOutput() ClientCertificateArrayOutput {
	return o
}

func (o ClientCertificateArrayOutput) ToClientCertificateArrayOutputWithContext(ctx context.Context) ClientCertificateArrayOutput {
	return o
}

func (o ClientCertificateArrayOutput) Index(i pulumi.IntInput) ClientCertificateOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ClientCertificate {
		return vs[0].([]*ClientCertificate)[vs[1].(int)]
	}).(ClientCertificateOutput)
}

type ClientCertificateMapOutput struct{ *pulumi.OutputState }

func (ClientCertificateMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ClientCertificate)(nil)).Elem()
}

func (o ClientCertificateMapOutput) ToClientCertificateMapOutput() ClientCertificateMapOutput {
	return o
}

func (o ClientCertificateMapOutput) ToClientCertificateMapOutputWithContext(ctx context.Context) ClientCertificateMapOutput {
	return o
}

func (o ClientCertificateMapOutput) MapIndex(k pulumi.StringInput) ClientCertificateOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ClientCertificate {
		return vs[0].(map[string]*ClientCertificate)[vs[1].(string)]
	}).(ClientCertificateOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ClientCertificateInput)(nil)).Elem(), &ClientCertificate{})
	pulumi.RegisterInputType(reflect.TypeOf((*ClientCertificateArrayInput)(nil)).Elem(), ClientCertificateArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ClientCertificateMapInput)(nil)).Elem(), ClientCertificateMap{})
	pulumi.RegisterOutputType(ClientCertificateOutput{})
	pulumi.RegisterOutputType(ClientCertificateArrayOutput{})
	pulumi.RegisterOutputType(ClientCertificateMapOutput{})
}
