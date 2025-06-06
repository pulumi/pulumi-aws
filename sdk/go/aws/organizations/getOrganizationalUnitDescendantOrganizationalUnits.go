// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package organizations

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Get all direct child organizational units under a parent organizational unit. This provides all children.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/organizations"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			org, err := organizations.LookupOrganization(ctx, map[string]interface{}{}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = organizations.GetOrganizationalUnitDescendantOrganizationalUnits(ctx, &organizations.GetOrganizationalUnitDescendantOrganizationalUnitsArgs{
//				ParentId: org.Roots[0].Id,
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func GetOrganizationalUnitDescendantOrganizationalUnits(ctx *pulumi.Context, args *GetOrganizationalUnitDescendantOrganizationalUnitsArgs, opts ...pulumi.InvokeOption) (*GetOrganizationalUnitDescendantOrganizationalUnitsResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv GetOrganizationalUnitDescendantOrganizationalUnitsResult
	err := ctx.Invoke("aws:organizations/getOrganizationalUnitDescendantOrganizationalUnits:getOrganizationalUnitDescendantOrganizationalUnits", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getOrganizationalUnitDescendantOrganizationalUnits.
type GetOrganizationalUnitDescendantOrganizationalUnitsArgs struct {
	// Parent ID of the organizational unit.
	ParentId string `pulumi:"parentId"`
}

// A collection of values returned by getOrganizationalUnitDescendantOrganizationalUnits.
type GetOrganizationalUnitDescendantOrganizationalUnitsResult struct {
	// List of child organizational units, which have the following attributes:
	Childrens []GetOrganizationalUnitDescendantOrganizationalUnitsChildren `pulumi:"childrens"`
	// The provider-assigned unique ID for this managed resource.
	Id       string `pulumi:"id"`
	ParentId string `pulumi:"parentId"`
}

func GetOrganizationalUnitDescendantOrganizationalUnitsOutput(ctx *pulumi.Context, args GetOrganizationalUnitDescendantOrganizationalUnitsOutputArgs, opts ...pulumi.InvokeOption) GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput, error) {
			args := v.(GetOrganizationalUnitDescendantOrganizationalUnitsArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:organizations/getOrganizationalUnitDescendantOrganizationalUnits:getOrganizationalUnitDescendantOrganizationalUnits", args, GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput{}, options).(GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput), nil
		}).(GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput)
}

// A collection of arguments for invoking getOrganizationalUnitDescendantOrganizationalUnits.
type GetOrganizationalUnitDescendantOrganizationalUnitsOutputArgs struct {
	// Parent ID of the organizational unit.
	ParentId pulumi.StringInput `pulumi:"parentId"`
}

func (GetOrganizationalUnitDescendantOrganizationalUnitsOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*GetOrganizationalUnitDescendantOrganizationalUnitsArgs)(nil)).Elem()
}

// A collection of values returned by getOrganizationalUnitDescendantOrganizationalUnits.
type GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput struct{ *pulumi.OutputState }

func (GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*GetOrganizationalUnitDescendantOrganizationalUnitsResult)(nil)).Elem()
}

func (o GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput) ToGetOrganizationalUnitDescendantOrganizationalUnitsResultOutput() GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput {
	return o
}

func (o GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput) ToGetOrganizationalUnitDescendantOrganizationalUnitsResultOutputWithContext(ctx context.Context) GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput {
	return o
}

// List of child organizational units, which have the following attributes:
func (o GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput) Childrens() GetOrganizationalUnitDescendantOrganizationalUnitsChildrenArrayOutput {
	return o.ApplyT(func(v GetOrganizationalUnitDescendantOrganizationalUnitsResult) []GetOrganizationalUnitDescendantOrganizationalUnitsChildren {
		return v.Childrens
	}).(GetOrganizationalUnitDescendantOrganizationalUnitsChildrenArrayOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v GetOrganizationalUnitDescendantOrganizationalUnitsResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput) ParentId() pulumi.StringOutput {
	return o.ApplyT(func(v GetOrganizationalUnitDescendantOrganizationalUnitsResult) string { return v.ParentId }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(GetOrganizationalUnitDescendantOrganizationalUnitsResultOutput{})
}
