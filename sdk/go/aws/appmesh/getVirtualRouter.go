// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package appmesh

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// The App Mesh Virtual Router data source allows details of an App Mesh Virtual Service to be retrieved by its name and mesh_name.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/appmesh"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := appmesh.LookupVirtualRouter(ctx, &appmesh.LookupVirtualRouterArgs{
//				Name:     "example-router-name",
//				MeshName: "example-mesh-name",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupVirtualRouter(ctx *pulumi.Context, args *LookupVirtualRouterArgs, opts ...pulumi.InvokeOption) (*LookupVirtualRouterResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupVirtualRouterResult
	err := ctx.Invoke("aws:appmesh/getVirtualRouter:getVirtualRouter", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getVirtualRouter.
type LookupVirtualRouterArgs struct {
	// Name of the mesh in which the virtual router exists
	MeshName  string  `pulumi:"meshName"`
	MeshOwner *string `pulumi:"meshOwner"`
	// Name of the virtual router.
	Name string `pulumi:"name"`
	// Map of tags.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getVirtualRouter.
type LookupVirtualRouterResult struct {
	// ARN of the virtual router.
	Arn string `pulumi:"arn"`
	// Creation date of the virtual router.
	CreatedDate string `pulumi:"createdDate"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Last update date of the virtual router.
	LastUpdatedDate string `pulumi:"lastUpdatedDate"`
	MeshName        string `pulumi:"meshName"`
	MeshOwner       string `pulumi:"meshOwner"`
	Name            string `pulumi:"name"`
	// Resource owner's AWS account ID.
	ResourceOwner string `pulumi:"resourceOwner"`
	// Virtual routers specification. See the `appmesh.VirtualRouter` resource for details.
	Specs []GetVirtualRouterSpec `pulumi:"specs"`
	// Map of tags.
	Tags map[string]string `pulumi:"tags"`
}

func LookupVirtualRouterOutput(ctx *pulumi.Context, args LookupVirtualRouterOutputArgs, opts ...pulumi.InvokeOption) LookupVirtualRouterResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupVirtualRouterResultOutput, error) {
			args := v.(LookupVirtualRouterArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:appmesh/getVirtualRouter:getVirtualRouter", args, LookupVirtualRouterResultOutput{}, options).(LookupVirtualRouterResultOutput), nil
		}).(LookupVirtualRouterResultOutput)
}

// A collection of arguments for invoking getVirtualRouter.
type LookupVirtualRouterOutputArgs struct {
	// Name of the mesh in which the virtual router exists
	MeshName  pulumi.StringInput    `pulumi:"meshName"`
	MeshOwner pulumi.StringPtrInput `pulumi:"meshOwner"`
	// Name of the virtual router.
	Name pulumi.StringInput `pulumi:"name"`
	// Map of tags.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupVirtualRouterOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupVirtualRouterArgs)(nil)).Elem()
}

// A collection of values returned by getVirtualRouter.
type LookupVirtualRouterResultOutput struct{ *pulumi.OutputState }

func (LookupVirtualRouterResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupVirtualRouterResult)(nil)).Elem()
}

func (o LookupVirtualRouterResultOutput) ToLookupVirtualRouterResultOutput() LookupVirtualRouterResultOutput {
	return o
}

func (o LookupVirtualRouterResultOutput) ToLookupVirtualRouterResultOutputWithContext(ctx context.Context) LookupVirtualRouterResultOutput {
	return o
}

// ARN of the virtual router.
func (o LookupVirtualRouterResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Creation date of the virtual router.
func (o LookupVirtualRouterResultOutput) CreatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) string { return v.CreatedDate }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupVirtualRouterResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) string { return v.Id }).(pulumi.StringOutput)
}

// Last update date of the virtual router.
func (o LookupVirtualRouterResultOutput) LastUpdatedDate() pulumi.StringOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) string { return v.LastUpdatedDate }).(pulumi.StringOutput)
}

func (o LookupVirtualRouterResultOutput) MeshName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) string { return v.MeshName }).(pulumi.StringOutput)
}

func (o LookupVirtualRouterResultOutput) MeshOwner() pulumi.StringOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) string { return v.MeshOwner }).(pulumi.StringOutput)
}

func (o LookupVirtualRouterResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) string { return v.Name }).(pulumi.StringOutput)
}

// Resource owner's AWS account ID.
func (o LookupVirtualRouterResultOutput) ResourceOwner() pulumi.StringOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) string { return v.ResourceOwner }).(pulumi.StringOutput)
}

// Virtual routers specification. See the `appmesh.VirtualRouter` resource for details.
func (o LookupVirtualRouterResultOutput) Specs() GetVirtualRouterSpecArrayOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) []GetVirtualRouterSpec { return v.Specs }).(GetVirtualRouterSpecArrayOutput)
}

// Map of tags.
func (o LookupVirtualRouterResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupVirtualRouterResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupVirtualRouterResultOutput{})
}
