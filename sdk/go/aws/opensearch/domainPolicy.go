// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package opensearch

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Allows setting policy to an OpenSearch domain while referencing domain attributes (e.g., ARN).
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/opensearch"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := opensearch.NewDomain(ctx, "example", &opensearch.DomainArgs{
//				DomainName:    pulumi.String("tf-test"),
//				EngineVersion: pulumi.String("OpenSearch_1.1"),
//			})
//			if err != nil {
//				return err
//			}
//			main := iam.GetPolicyDocumentOutput(ctx, iam.GetPolicyDocumentOutputArgs{
//				Statements: iam.GetPolicyDocumentStatementArray{
//					&iam.GetPolicyDocumentStatementArgs{
//						Effect: pulumi.String("Allow"),
//						Principals: iam.GetPolicyDocumentStatementPrincipalArray{
//							&iam.GetPolicyDocumentStatementPrincipalArgs{
//								Type: pulumi.String("*"),
//								Identifiers: pulumi.StringArray{
//									pulumi.String("*"),
//								},
//							},
//						},
//						Actions: pulumi.StringArray{
//							pulumi.String("es:*"),
//						},
//						Resources: pulumi.StringArray{
//							example.Arn.ApplyT(func(arn string) (string, error) {
//								return fmt.Sprintf("%v/*", arn), nil
//							}).(pulumi.StringOutput),
//						},
//						Conditions: iam.GetPolicyDocumentStatementConditionArray{
//							&iam.GetPolicyDocumentStatementConditionArgs{
//								Test:     pulumi.String("IpAddress"),
//								Variable: pulumi.String("aws:SourceIp"),
//								Values: pulumi.StringArray{
//									pulumi.String("127.0.0.1/32"),
//								},
//							},
//						},
//					},
//				},
//			}, nil)
//			_, err = opensearch.NewDomainPolicy(ctx, "main", &opensearch.DomainPolicyArgs{
//				DomainName: example.DomainName,
//				AccessPolicies: pulumi.String(main.ApplyT(func(main iam.GetPolicyDocumentResult) (*string, error) {
//					return &main.Json, nil
//				}).(pulumi.StringPtrOutput)),
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
type DomainPolicy struct {
	pulumi.CustomResourceState

	// IAM policy document specifying the access policies for the domain
	AccessPolicies pulumi.StringOutput `pulumi:"accessPolicies"`
	// Name of the domain.
	DomainName pulumi.StringOutput `pulumi:"domainName"`
}

// NewDomainPolicy registers a new resource with the given unique name, arguments, and options.
func NewDomainPolicy(ctx *pulumi.Context,
	name string, args *DomainPolicyArgs, opts ...pulumi.ResourceOption) (*DomainPolicy, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.AccessPolicies == nil {
		return nil, errors.New("invalid value for required argument 'AccessPolicies'")
	}
	if args.DomainName == nil {
		return nil, errors.New("invalid value for required argument 'DomainName'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource DomainPolicy
	err := ctx.RegisterResource("aws:opensearch/domainPolicy:DomainPolicy", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetDomainPolicy gets an existing DomainPolicy resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetDomainPolicy(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *DomainPolicyState, opts ...pulumi.ResourceOption) (*DomainPolicy, error) {
	var resource DomainPolicy
	err := ctx.ReadResource("aws:opensearch/domainPolicy:DomainPolicy", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering DomainPolicy resources.
type domainPolicyState struct {
	// IAM policy document specifying the access policies for the domain
	AccessPolicies *string `pulumi:"accessPolicies"`
	// Name of the domain.
	DomainName *string `pulumi:"domainName"`
}

type DomainPolicyState struct {
	// IAM policy document specifying the access policies for the domain
	AccessPolicies pulumi.StringPtrInput
	// Name of the domain.
	DomainName pulumi.StringPtrInput
}

func (DomainPolicyState) ElementType() reflect.Type {
	return reflect.TypeOf((*domainPolicyState)(nil)).Elem()
}

type domainPolicyArgs struct {
	// IAM policy document specifying the access policies for the domain
	AccessPolicies string `pulumi:"accessPolicies"`
	// Name of the domain.
	DomainName string `pulumi:"domainName"`
}

// The set of arguments for constructing a DomainPolicy resource.
type DomainPolicyArgs struct {
	// IAM policy document specifying the access policies for the domain
	AccessPolicies pulumi.StringInput
	// Name of the domain.
	DomainName pulumi.StringInput
}

func (DomainPolicyArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*domainPolicyArgs)(nil)).Elem()
}

type DomainPolicyInput interface {
	pulumi.Input

	ToDomainPolicyOutput() DomainPolicyOutput
	ToDomainPolicyOutputWithContext(ctx context.Context) DomainPolicyOutput
}

func (*DomainPolicy) ElementType() reflect.Type {
	return reflect.TypeOf((**DomainPolicy)(nil)).Elem()
}

func (i *DomainPolicy) ToDomainPolicyOutput() DomainPolicyOutput {
	return i.ToDomainPolicyOutputWithContext(context.Background())
}

func (i *DomainPolicy) ToDomainPolicyOutputWithContext(ctx context.Context) DomainPolicyOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DomainPolicyOutput)
}

// DomainPolicyArrayInput is an input type that accepts DomainPolicyArray and DomainPolicyArrayOutput values.
// You can construct a concrete instance of `DomainPolicyArrayInput` via:
//
//	DomainPolicyArray{ DomainPolicyArgs{...} }
type DomainPolicyArrayInput interface {
	pulumi.Input

	ToDomainPolicyArrayOutput() DomainPolicyArrayOutput
	ToDomainPolicyArrayOutputWithContext(context.Context) DomainPolicyArrayOutput
}

type DomainPolicyArray []DomainPolicyInput

func (DomainPolicyArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DomainPolicy)(nil)).Elem()
}

func (i DomainPolicyArray) ToDomainPolicyArrayOutput() DomainPolicyArrayOutput {
	return i.ToDomainPolicyArrayOutputWithContext(context.Background())
}

func (i DomainPolicyArray) ToDomainPolicyArrayOutputWithContext(ctx context.Context) DomainPolicyArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DomainPolicyArrayOutput)
}

// DomainPolicyMapInput is an input type that accepts DomainPolicyMap and DomainPolicyMapOutput values.
// You can construct a concrete instance of `DomainPolicyMapInput` via:
//
//	DomainPolicyMap{ "key": DomainPolicyArgs{...} }
type DomainPolicyMapInput interface {
	pulumi.Input

	ToDomainPolicyMapOutput() DomainPolicyMapOutput
	ToDomainPolicyMapOutputWithContext(context.Context) DomainPolicyMapOutput
}

type DomainPolicyMap map[string]DomainPolicyInput

func (DomainPolicyMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DomainPolicy)(nil)).Elem()
}

func (i DomainPolicyMap) ToDomainPolicyMapOutput() DomainPolicyMapOutput {
	return i.ToDomainPolicyMapOutputWithContext(context.Background())
}

func (i DomainPolicyMap) ToDomainPolicyMapOutputWithContext(ctx context.Context) DomainPolicyMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DomainPolicyMapOutput)
}

type DomainPolicyOutput struct{ *pulumi.OutputState }

func (DomainPolicyOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**DomainPolicy)(nil)).Elem()
}

func (o DomainPolicyOutput) ToDomainPolicyOutput() DomainPolicyOutput {
	return o
}

func (o DomainPolicyOutput) ToDomainPolicyOutputWithContext(ctx context.Context) DomainPolicyOutput {
	return o
}

// IAM policy document specifying the access policies for the domain
func (o DomainPolicyOutput) AccessPolicies() pulumi.StringOutput {
	return o.ApplyT(func(v *DomainPolicy) pulumi.StringOutput { return v.AccessPolicies }).(pulumi.StringOutput)
}

// Name of the domain.
func (o DomainPolicyOutput) DomainName() pulumi.StringOutput {
	return o.ApplyT(func(v *DomainPolicy) pulumi.StringOutput { return v.DomainName }).(pulumi.StringOutput)
}

type DomainPolicyArrayOutput struct{ *pulumi.OutputState }

func (DomainPolicyArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DomainPolicy)(nil)).Elem()
}

func (o DomainPolicyArrayOutput) ToDomainPolicyArrayOutput() DomainPolicyArrayOutput {
	return o
}

func (o DomainPolicyArrayOutput) ToDomainPolicyArrayOutputWithContext(ctx context.Context) DomainPolicyArrayOutput {
	return o
}

func (o DomainPolicyArrayOutput) Index(i pulumi.IntInput) DomainPolicyOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *DomainPolicy {
		return vs[0].([]*DomainPolicy)[vs[1].(int)]
	}).(DomainPolicyOutput)
}

type DomainPolicyMapOutput struct{ *pulumi.OutputState }

func (DomainPolicyMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DomainPolicy)(nil)).Elem()
}

func (o DomainPolicyMapOutput) ToDomainPolicyMapOutput() DomainPolicyMapOutput {
	return o
}

func (o DomainPolicyMapOutput) ToDomainPolicyMapOutputWithContext(ctx context.Context) DomainPolicyMapOutput {
	return o
}

func (o DomainPolicyMapOutput) MapIndex(k pulumi.StringInput) DomainPolicyOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *DomainPolicy {
		return vs[0].(map[string]*DomainPolicy)[vs[1].(string)]
	}).(DomainPolicyOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*DomainPolicyInput)(nil)).Elem(), &DomainPolicy{})
	pulumi.RegisterInputType(reflect.TypeOf((*DomainPolicyArrayInput)(nil)).Elem(), DomainPolicyArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*DomainPolicyMapInput)(nil)).Elem(), DomainPolicyMap{})
	pulumi.RegisterOutputType(DomainPolicyOutput{})
	pulumi.RegisterOutputType(DomainPolicyArrayOutput{})
	pulumi.RegisterOutputType(DomainPolicyMapOutput{})
}
