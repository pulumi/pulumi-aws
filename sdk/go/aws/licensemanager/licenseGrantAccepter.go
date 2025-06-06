// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package licensemanager

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Accepts a License Manager grant. This allows for sharing licenses with other aws accounts.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/licensemanager"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := licensemanager.NewLicenseGrantAccepter(ctx, "test", &licensemanager.LicenseGrantAccepterArgs{
//				GrantArn: pulumi.String("arn:aws:license-manager::123456789012:grant:g-1cf9fba4ba2f42dcab11c686c4b4d329"),
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
// Using `pulumi import`, import `aws_licensemanager_grant_accepter` using the grant arn. For example:
//
// ```sh
// $ pulumi import aws:licensemanager/licenseGrantAccepter:LicenseGrantAccepter test arn:aws:license-manager::123456789012:grant:g-1cf9fba4ba2f42dcab11c686c4b4d329
// ```
type LicenseGrantAccepter struct {
	pulumi.CustomResourceState

	// A list of the allowed operations for the grant.
	AllowedOperations pulumi.StringArrayOutput `pulumi:"allowedOperations"`
	// The ARN of the grant to accept.
	GrantArn pulumi.StringOutput `pulumi:"grantArn"`
	// The home region for the license.
	HomeRegion pulumi.StringOutput `pulumi:"homeRegion"`
	// The ARN of the license for the grant.
	LicenseArn pulumi.StringOutput `pulumi:"licenseArn"`
	// The Name of the grant.
	Name pulumi.StringOutput `pulumi:"name"`
	// The parent ARN.
	ParentArn pulumi.StringOutput `pulumi:"parentArn"`
	// The target account for the grant.
	Principal pulumi.StringOutput `pulumi:"principal"`
	// The grant status.
	Status pulumi.StringOutput `pulumi:"status"`
	// The grant version.
	Version pulumi.StringOutput `pulumi:"version"`
}

// NewLicenseGrantAccepter registers a new resource with the given unique name, arguments, and options.
func NewLicenseGrantAccepter(ctx *pulumi.Context,
	name string, args *LicenseGrantAccepterArgs, opts ...pulumi.ResourceOption) (*LicenseGrantAccepter, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.GrantArn == nil {
		return nil, errors.New("invalid value for required argument 'GrantArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource LicenseGrantAccepter
	err := ctx.RegisterResource("aws:licensemanager/licenseGrantAccepter:LicenseGrantAccepter", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetLicenseGrantAccepter gets an existing LicenseGrantAccepter resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetLicenseGrantAccepter(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *LicenseGrantAccepterState, opts ...pulumi.ResourceOption) (*LicenseGrantAccepter, error) {
	var resource LicenseGrantAccepter
	err := ctx.ReadResource("aws:licensemanager/licenseGrantAccepter:LicenseGrantAccepter", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering LicenseGrantAccepter resources.
type licenseGrantAccepterState struct {
	// A list of the allowed operations for the grant.
	AllowedOperations []string `pulumi:"allowedOperations"`
	// The ARN of the grant to accept.
	GrantArn *string `pulumi:"grantArn"`
	// The home region for the license.
	HomeRegion *string `pulumi:"homeRegion"`
	// The ARN of the license for the grant.
	LicenseArn *string `pulumi:"licenseArn"`
	// The Name of the grant.
	Name *string `pulumi:"name"`
	// The parent ARN.
	ParentArn *string `pulumi:"parentArn"`
	// The target account for the grant.
	Principal *string `pulumi:"principal"`
	// The grant status.
	Status *string `pulumi:"status"`
	// The grant version.
	Version *string `pulumi:"version"`
}

type LicenseGrantAccepterState struct {
	// A list of the allowed operations for the grant.
	AllowedOperations pulumi.StringArrayInput
	// The ARN of the grant to accept.
	GrantArn pulumi.StringPtrInput
	// The home region for the license.
	HomeRegion pulumi.StringPtrInput
	// The ARN of the license for the grant.
	LicenseArn pulumi.StringPtrInput
	// The Name of the grant.
	Name pulumi.StringPtrInput
	// The parent ARN.
	ParentArn pulumi.StringPtrInput
	// The target account for the grant.
	Principal pulumi.StringPtrInput
	// The grant status.
	Status pulumi.StringPtrInput
	// The grant version.
	Version pulumi.StringPtrInput
}

func (LicenseGrantAccepterState) ElementType() reflect.Type {
	return reflect.TypeOf((*licenseGrantAccepterState)(nil)).Elem()
}

type licenseGrantAccepterArgs struct {
	// The ARN of the grant to accept.
	GrantArn string `pulumi:"grantArn"`
}

// The set of arguments for constructing a LicenseGrantAccepter resource.
type LicenseGrantAccepterArgs struct {
	// The ARN of the grant to accept.
	GrantArn pulumi.StringInput
}

func (LicenseGrantAccepterArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*licenseGrantAccepterArgs)(nil)).Elem()
}

type LicenseGrantAccepterInput interface {
	pulumi.Input

	ToLicenseGrantAccepterOutput() LicenseGrantAccepterOutput
	ToLicenseGrantAccepterOutputWithContext(ctx context.Context) LicenseGrantAccepterOutput
}

func (*LicenseGrantAccepter) ElementType() reflect.Type {
	return reflect.TypeOf((**LicenseGrantAccepter)(nil)).Elem()
}

func (i *LicenseGrantAccepter) ToLicenseGrantAccepterOutput() LicenseGrantAccepterOutput {
	return i.ToLicenseGrantAccepterOutputWithContext(context.Background())
}

func (i *LicenseGrantAccepter) ToLicenseGrantAccepterOutputWithContext(ctx context.Context) LicenseGrantAccepterOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LicenseGrantAccepterOutput)
}

// LicenseGrantAccepterArrayInput is an input type that accepts LicenseGrantAccepterArray and LicenseGrantAccepterArrayOutput values.
// You can construct a concrete instance of `LicenseGrantAccepterArrayInput` via:
//
//	LicenseGrantAccepterArray{ LicenseGrantAccepterArgs{...} }
type LicenseGrantAccepterArrayInput interface {
	pulumi.Input

	ToLicenseGrantAccepterArrayOutput() LicenseGrantAccepterArrayOutput
	ToLicenseGrantAccepterArrayOutputWithContext(context.Context) LicenseGrantAccepterArrayOutput
}

type LicenseGrantAccepterArray []LicenseGrantAccepterInput

func (LicenseGrantAccepterArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LicenseGrantAccepter)(nil)).Elem()
}

func (i LicenseGrantAccepterArray) ToLicenseGrantAccepterArrayOutput() LicenseGrantAccepterArrayOutput {
	return i.ToLicenseGrantAccepterArrayOutputWithContext(context.Background())
}

func (i LicenseGrantAccepterArray) ToLicenseGrantAccepterArrayOutputWithContext(ctx context.Context) LicenseGrantAccepterArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LicenseGrantAccepterArrayOutput)
}

// LicenseGrantAccepterMapInput is an input type that accepts LicenseGrantAccepterMap and LicenseGrantAccepterMapOutput values.
// You can construct a concrete instance of `LicenseGrantAccepterMapInput` via:
//
//	LicenseGrantAccepterMap{ "key": LicenseGrantAccepterArgs{...} }
type LicenseGrantAccepterMapInput interface {
	pulumi.Input

	ToLicenseGrantAccepterMapOutput() LicenseGrantAccepterMapOutput
	ToLicenseGrantAccepterMapOutputWithContext(context.Context) LicenseGrantAccepterMapOutput
}

type LicenseGrantAccepterMap map[string]LicenseGrantAccepterInput

func (LicenseGrantAccepterMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LicenseGrantAccepter)(nil)).Elem()
}

func (i LicenseGrantAccepterMap) ToLicenseGrantAccepterMapOutput() LicenseGrantAccepterMapOutput {
	return i.ToLicenseGrantAccepterMapOutputWithContext(context.Background())
}

func (i LicenseGrantAccepterMap) ToLicenseGrantAccepterMapOutputWithContext(ctx context.Context) LicenseGrantAccepterMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LicenseGrantAccepterMapOutput)
}

type LicenseGrantAccepterOutput struct{ *pulumi.OutputState }

func (LicenseGrantAccepterOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**LicenseGrantAccepter)(nil)).Elem()
}

func (o LicenseGrantAccepterOutput) ToLicenseGrantAccepterOutput() LicenseGrantAccepterOutput {
	return o
}

func (o LicenseGrantAccepterOutput) ToLicenseGrantAccepterOutputWithContext(ctx context.Context) LicenseGrantAccepterOutput {
	return o
}

// A list of the allowed operations for the grant.
func (o LicenseGrantAccepterOutput) AllowedOperations() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *LicenseGrantAccepter) pulumi.StringArrayOutput { return v.AllowedOperations }).(pulumi.StringArrayOutput)
}

// The ARN of the grant to accept.
func (o LicenseGrantAccepterOutput) GrantArn() pulumi.StringOutput {
	return o.ApplyT(func(v *LicenseGrantAccepter) pulumi.StringOutput { return v.GrantArn }).(pulumi.StringOutput)
}

// The home region for the license.
func (o LicenseGrantAccepterOutput) HomeRegion() pulumi.StringOutput {
	return o.ApplyT(func(v *LicenseGrantAccepter) pulumi.StringOutput { return v.HomeRegion }).(pulumi.StringOutput)
}

// The ARN of the license for the grant.
func (o LicenseGrantAccepterOutput) LicenseArn() pulumi.StringOutput {
	return o.ApplyT(func(v *LicenseGrantAccepter) pulumi.StringOutput { return v.LicenseArn }).(pulumi.StringOutput)
}

// The Name of the grant.
func (o LicenseGrantAccepterOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *LicenseGrantAccepter) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The parent ARN.
func (o LicenseGrantAccepterOutput) ParentArn() pulumi.StringOutput {
	return o.ApplyT(func(v *LicenseGrantAccepter) pulumi.StringOutput { return v.ParentArn }).(pulumi.StringOutput)
}

// The target account for the grant.
func (o LicenseGrantAccepterOutput) Principal() pulumi.StringOutput {
	return o.ApplyT(func(v *LicenseGrantAccepter) pulumi.StringOutput { return v.Principal }).(pulumi.StringOutput)
}

// The grant status.
func (o LicenseGrantAccepterOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *LicenseGrantAccepter) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// The grant version.
func (o LicenseGrantAccepterOutput) Version() pulumi.StringOutput {
	return o.ApplyT(func(v *LicenseGrantAccepter) pulumi.StringOutput { return v.Version }).(pulumi.StringOutput)
}

type LicenseGrantAccepterArrayOutput struct{ *pulumi.OutputState }

func (LicenseGrantAccepterArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LicenseGrantAccepter)(nil)).Elem()
}

func (o LicenseGrantAccepterArrayOutput) ToLicenseGrantAccepterArrayOutput() LicenseGrantAccepterArrayOutput {
	return o
}

func (o LicenseGrantAccepterArrayOutput) ToLicenseGrantAccepterArrayOutputWithContext(ctx context.Context) LicenseGrantAccepterArrayOutput {
	return o
}

func (o LicenseGrantAccepterArrayOutput) Index(i pulumi.IntInput) LicenseGrantAccepterOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *LicenseGrantAccepter {
		return vs[0].([]*LicenseGrantAccepter)[vs[1].(int)]
	}).(LicenseGrantAccepterOutput)
}

type LicenseGrantAccepterMapOutput struct{ *pulumi.OutputState }

func (LicenseGrantAccepterMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LicenseGrantAccepter)(nil)).Elem()
}

func (o LicenseGrantAccepterMapOutput) ToLicenseGrantAccepterMapOutput() LicenseGrantAccepterMapOutput {
	return o
}

func (o LicenseGrantAccepterMapOutput) ToLicenseGrantAccepterMapOutputWithContext(ctx context.Context) LicenseGrantAccepterMapOutput {
	return o
}

func (o LicenseGrantAccepterMapOutput) MapIndex(k pulumi.StringInput) LicenseGrantAccepterOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *LicenseGrantAccepter {
		return vs[0].(map[string]*LicenseGrantAccepter)[vs[1].(string)]
	}).(LicenseGrantAccepterOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*LicenseGrantAccepterInput)(nil)).Elem(), &LicenseGrantAccepter{})
	pulumi.RegisterInputType(reflect.TypeOf((*LicenseGrantAccepterArrayInput)(nil)).Elem(), LicenseGrantAccepterArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*LicenseGrantAccepterMapInput)(nil)).Elem(), LicenseGrantAccepterMap{})
	pulumi.RegisterOutputType(LicenseGrantAccepterOutput{})
	pulumi.RegisterOutputType(LicenseGrantAccepterArrayOutput{})
	pulumi.RegisterOutputType(LicenseGrantAccepterMapOutput{})
}
