// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apigateway

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a resource to manage an API Gateway Documentation Version.
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
//			exampleRestApi, err := apigateway.NewRestApi(ctx, "example", &apigateway.RestApiArgs{
//				Name: pulumi.String("example_api"),
//			})
//			if err != nil {
//				return err
//			}
//			exampleDocumentationPart, err := apigateway.NewDocumentationPart(ctx, "example", &apigateway.DocumentationPartArgs{
//				Location: &apigateway.DocumentationPartLocationArgs{
//					Type: pulumi.String("API"),
//				},
//				Properties: pulumi.String("{\"description\":\"Example\"}"),
//				RestApiId:  exampleRestApi.ID(),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = apigateway.NewDocumentationVersion(ctx, "example", &apigateway.DocumentationVersionArgs{
//				Version:     pulumi.String("example_version"),
//				RestApiId:   exampleRestApi.ID(),
//				Description: pulumi.String("Example description"),
//			}, pulumi.DependsOn([]pulumi.Resource{
//				exampleDocumentationPart,
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
// Using `pulumi import`, import API Gateway documentation versions using `REST-API-ID/VERSION`. For example:
//
// ```sh
// $ pulumi import aws:apigateway/documentationVersion:DocumentationVersion example 5i4e1ko720/example-version
// ```
type DocumentationVersion struct {
	pulumi.CustomResourceState

	// Description of the API documentation version.
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// ID of the associated Rest API
	RestApiId pulumi.StringOutput `pulumi:"restApiId"`
	// Version identifier of the API documentation snapshot.
	Version pulumi.StringOutput `pulumi:"version"`
}

// NewDocumentationVersion registers a new resource with the given unique name, arguments, and options.
func NewDocumentationVersion(ctx *pulumi.Context,
	name string, args *DocumentationVersionArgs, opts ...pulumi.ResourceOption) (*DocumentationVersion, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.RestApiId == nil {
		return nil, errors.New("invalid value for required argument 'RestApiId'")
	}
	if args.Version == nil {
		return nil, errors.New("invalid value for required argument 'Version'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource DocumentationVersion
	err := ctx.RegisterResource("aws:apigateway/documentationVersion:DocumentationVersion", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetDocumentationVersion gets an existing DocumentationVersion resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetDocumentationVersion(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *DocumentationVersionState, opts ...pulumi.ResourceOption) (*DocumentationVersion, error) {
	var resource DocumentationVersion
	err := ctx.ReadResource("aws:apigateway/documentationVersion:DocumentationVersion", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering DocumentationVersion resources.
type documentationVersionState struct {
	// Description of the API documentation version.
	Description *string `pulumi:"description"`
	// ID of the associated Rest API
	RestApiId *string `pulumi:"restApiId"`
	// Version identifier of the API documentation snapshot.
	Version *string `pulumi:"version"`
}

type DocumentationVersionState struct {
	// Description of the API documentation version.
	Description pulumi.StringPtrInput
	// ID of the associated Rest API
	RestApiId pulumi.StringPtrInput
	// Version identifier of the API documentation snapshot.
	Version pulumi.StringPtrInput
}

func (DocumentationVersionState) ElementType() reflect.Type {
	return reflect.TypeOf((*documentationVersionState)(nil)).Elem()
}

type documentationVersionArgs struct {
	// Description of the API documentation version.
	Description *string `pulumi:"description"`
	// ID of the associated Rest API
	RestApiId string `pulumi:"restApiId"`
	// Version identifier of the API documentation snapshot.
	Version string `pulumi:"version"`
}

// The set of arguments for constructing a DocumentationVersion resource.
type DocumentationVersionArgs struct {
	// Description of the API documentation version.
	Description pulumi.StringPtrInput
	// ID of the associated Rest API
	RestApiId pulumi.StringInput
	// Version identifier of the API documentation snapshot.
	Version pulumi.StringInput
}

func (DocumentationVersionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*documentationVersionArgs)(nil)).Elem()
}

type DocumentationVersionInput interface {
	pulumi.Input

	ToDocumentationVersionOutput() DocumentationVersionOutput
	ToDocumentationVersionOutputWithContext(ctx context.Context) DocumentationVersionOutput
}

func (*DocumentationVersion) ElementType() reflect.Type {
	return reflect.TypeOf((**DocumentationVersion)(nil)).Elem()
}

func (i *DocumentationVersion) ToDocumentationVersionOutput() DocumentationVersionOutput {
	return i.ToDocumentationVersionOutputWithContext(context.Background())
}

func (i *DocumentationVersion) ToDocumentationVersionOutputWithContext(ctx context.Context) DocumentationVersionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DocumentationVersionOutput)
}

// DocumentationVersionArrayInput is an input type that accepts DocumentationVersionArray and DocumentationVersionArrayOutput values.
// You can construct a concrete instance of `DocumentationVersionArrayInput` via:
//
//	DocumentationVersionArray{ DocumentationVersionArgs{...} }
type DocumentationVersionArrayInput interface {
	pulumi.Input

	ToDocumentationVersionArrayOutput() DocumentationVersionArrayOutput
	ToDocumentationVersionArrayOutputWithContext(context.Context) DocumentationVersionArrayOutput
}

type DocumentationVersionArray []DocumentationVersionInput

func (DocumentationVersionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DocumentationVersion)(nil)).Elem()
}

func (i DocumentationVersionArray) ToDocumentationVersionArrayOutput() DocumentationVersionArrayOutput {
	return i.ToDocumentationVersionArrayOutputWithContext(context.Background())
}

func (i DocumentationVersionArray) ToDocumentationVersionArrayOutputWithContext(ctx context.Context) DocumentationVersionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DocumentationVersionArrayOutput)
}

// DocumentationVersionMapInput is an input type that accepts DocumentationVersionMap and DocumentationVersionMapOutput values.
// You can construct a concrete instance of `DocumentationVersionMapInput` via:
//
//	DocumentationVersionMap{ "key": DocumentationVersionArgs{...} }
type DocumentationVersionMapInput interface {
	pulumi.Input

	ToDocumentationVersionMapOutput() DocumentationVersionMapOutput
	ToDocumentationVersionMapOutputWithContext(context.Context) DocumentationVersionMapOutput
}

type DocumentationVersionMap map[string]DocumentationVersionInput

func (DocumentationVersionMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DocumentationVersion)(nil)).Elem()
}

func (i DocumentationVersionMap) ToDocumentationVersionMapOutput() DocumentationVersionMapOutput {
	return i.ToDocumentationVersionMapOutputWithContext(context.Background())
}

func (i DocumentationVersionMap) ToDocumentationVersionMapOutputWithContext(ctx context.Context) DocumentationVersionMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DocumentationVersionMapOutput)
}

type DocumentationVersionOutput struct{ *pulumi.OutputState }

func (DocumentationVersionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**DocumentationVersion)(nil)).Elem()
}

func (o DocumentationVersionOutput) ToDocumentationVersionOutput() DocumentationVersionOutput {
	return o
}

func (o DocumentationVersionOutput) ToDocumentationVersionOutputWithContext(ctx context.Context) DocumentationVersionOutput {
	return o
}

// Description of the API documentation version.
func (o DocumentationVersionOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *DocumentationVersion) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// ID of the associated Rest API
func (o DocumentationVersionOutput) RestApiId() pulumi.StringOutput {
	return o.ApplyT(func(v *DocumentationVersion) pulumi.StringOutput { return v.RestApiId }).(pulumi.StringOutput)
}

// Version identifier of the API documentation snapshot.
func (o DocumentationVersionOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v *DocumentationVersion) pulumi.StringOutput { return v.Version }).(pulumi.StringOutput)
}

type DocumentationVersionArrayOutput struct{ *pulumi.OutputState }

func (DocumentationVersionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DocumentationVersion)(nil)).Elem()
}

func (o DocumentationVersionArrayOutput) ToDocumentationVersionArrayOutput() DocumentationVersionArrayOutput {
	return o
}

func (o DocumentationVersionArrayOutput) ToDocumentationVersionArrayOutputWithContext(ctx context.Context) DocumentationVersionArrayOutput {
	return o
}

func (o DocumentationVersionArrayOutput) Index(i pulumi.IntInput) DocumentationVersionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *DocumentationVersion {
		return vs[0].([]*DocumentationVersion)[vs[1].(int)]
	}).(DocumentationVersionOutput)
}

type DocumentationVersionMapOutput struct{ *pulumi.OutputState }

func (DocumentationVersionMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DocumentationVersion)(nil)).Elem()
}

func (o DocumentationVersionMapOutput) ToDocumentationVersionMapOutput() DocumentationVersionMapOutput {
	return o
}

func (o DocumentationVersionMapOutput) ToDocumentationVersionMapOutputWithContext(ctx context.Context) DocumentationVersionMapOutput {
	return o
}

func (o DocumentationVersionMapOutput) MapIndex(k pulumi.StringInput) DocumentationVersionOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *DocumentationVersion {
		return vs[0].(map[string]*DocumentationVersion)[vs[1].(string)]
	}).(DocumentationVersionOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*DocumentationVersionInput)(nil)).Elem(), &DocumentationVersion{})
	pulumi.RegisterInputType(reflect.TypeOf((*DocumentationVersionArrayInput)(nil)).Elem(), DocumentationVersionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*DocumentationVersionMapInput)(nil)).Elem(), DocumentationVersionMap{})
	pulumi.RegisterOutputType(DocumentationVersionOutput{})
	pulumi.RegisterOutputType(DocumentationVersionArrayOutput{})
	pulumi.RegisterOutputType(DocumentationVersionMapOutput{})
}
