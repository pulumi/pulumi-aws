// Code generated by the Pulumi Terraform Bridge (tfgen) Tool DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package vpclattice

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS VPC Lattice Listener Rule.
//
// ## Example Usage
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/vpclattice"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := vpclattice.NewListenerRule(ctx, "test", &vpclattice.ListenerRuleArgs{
//				ListenerIdentifier: pulumi.Any(aws_vpclattice_listener.Example.Listener_id),
//				ServiceIdentifier:  pulumi.Any(aws_vpclattice_service.Example.Id),
//				Priority:           pulumi.Int(20),
//				Match: &vpclattice.ListenerRuleMatchArgs{
//					HttpMatch: &vpclattice.ListenerRuleMatchHttpMatchArgs{
//						HeaderMatches: vpclattice.ListenerRuleMatchHttpMatchHeaderMatchArray{
//							&vpclattice.ListenerRuleMatchHttpMatchHeaderMatchArgs{
//								Name:          pulumi.String("example-header"),
//								CaseSensitive: pulumi.Bool(false),
//								Match: &vpclattice.ListenerRuleMatchHttpMatchHeaderMatchMatchArgs{
//									Exact: pulumi.String("example-contains"),
//								},
//							},
//						},
//						PathMatch: &vpclattice.ListenerRuleMatchHttpMatchPathMatchArgs{
//							CaseSensitive: pulumi.Bool(true),
//							Match: &vpclattice.ListenerRuleMatchHttpMatchPathMatchMatchArgs{
//								Prefix: pulumi.String("/example-path"),
//							},
//						},
//					},
//				},
//				Action: &vpclattice.ListenerRuleActionArgs{
//					Forward: &vpclattice.ListenerRuleActionForwardArgs{
//						TargetGroups: vpclattice.ListenerRuleActionForwardTargetGroupArray{
//							&vpclattice.ListenerRuleActionForwardTargetGroupArgs{
//								TargetGroupIdentifier: pulumi.Any(aws_vpclattice_target_group.Example.Id),
//								Weight:                pulumi.Int(1),
//							},
//							&vpclattice.ListenerRuleActionForwardTargetGroupArgs{
//								TargetGroupIdentifier: pulumi.Any(aws_vpclattice_target_group.Example2.Id),
//								Weight:                pulumi.Int(2),
//							},
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
// ### Basic Usage
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v5/go/aws/vpclattice"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := vpclattice.NewListenerRule(ctx, "test", &vpclattice.ListenerRuleArgs{
//				ListenerIdentifier: pulumi.Any(aws_vpclattice_listener.Example.Listener_id),
//				ServiceIdentifier:  pulumi.Any(aws_vpclattice_service.Example.Id),
//				Priority:           pulumi.Int(10),
//				Match: &vpclattice.ListenerRuleMatchArgs{
//					HttpMatch: &vpclattice.ListenerRuleMatchHttpMatchArgs{
//						PathMatch: &vpclattice.ListenerRuleMatchHttpMatchPathMatchArgs{
//							CaseSensitive: pulumi.Bool(false),
//							Match: &vpclattice.ListenerRuleMatchHttpMatchPathMatchMatchArgs{
//								Exact: pulumi.String("/example-path"),
//							},
//						},
//					},
//				},
//				Action: &vpclattice.ListenerRuleActionArgs{
//					FixedResponse: &vpclattice.ListenerRuleActionFixedResponseArgs{
//						StatusCode: pulumi.Int(404),
//					},
//				},
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
// VPC Lattice Listener Rule can be imported using the `example_id_arg`, e.g.,
//
// ```sh
//
//	$ pulumi import aws:vpclattice/listenerRule:ListenerRule example rft-8012925589
//
// ```
type ListenerRule struct {
	pulumi.CustomResourceState

	// The action for the default rule.
	Action ListenerRuleActionOutput `pulumi:"action"`
	// ARN of the target group.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The ID or Amazon Resource Name (ARN) of the listener.
	ListenerIdentifier pulumi.StringOutput `pulumi:"listenerIdentifier"`
	// The rule match.
	Match ListenerRuleMatchOutput `pulumi:"match"`
	// The name of the rule. The name must be unique within the listener. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name pulumi.StringOutput `pulumi:"name"`
	// The priority assigned to the rule. Each rule for a specific listener must have a unique priority. The lower the priority number the higher the priority.
	Priority pulumi.IntOutput `pulumi:"priority"`
	// Unique identifier for the target group.
	RuleId pulumi.StringOutput `pulumi:"ruleId"`
	// The ID or Amazon Resource Identifier (ARN) of the service.
	ServiceIdentifier pulumi.StringOutput `pulumi:"serviceIdentifier"`
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewListenerRule registers a new resource with the given unique name, arguments, and options.
func NewListenerRule(ctx *pulumi.Context,
	name string, args *ListenerRuleArgs, opts ...pulumi.ResourceOption) (*ListenerRule, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Action == nil {
		return nil, errors.New("invalid value for required argument 'Action'")
	}
	if args.ListenerIdentifier == nil {
		return nil, errors.New("invalid value for required argument 'ListenerIdentifier'")
	}
	if args.Match == nil {
		return nil, errors.New("invalid value for required argument 'Match'")
	}
	if args.Priority == nil {
		return nil, errors.New("invalid value for required argument 'Priority'")
	}
	if args.ServiceIdentifier == nil {
		return nil, errors.New("invalid value for required argument 'ServiceIdentifier'")
	}
	var resource ListenerRule
	err := ctx.RegisterResource("aws:vpclattice/listenerRule:ListenerRule", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetListenerRule gets an existing ListenerRule resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetListenerRule(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ListenerRuleState, opts ...pulumi.ResourceOption) (*ListenerRule, error) {
	var resource ListenerRule
	err := ctx.ReadResource("aws:vpclattice/listenerRule:ListenerRule", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ListenerRule resources.
type listenerRuleState struct {
	// The action for the default rule.
	Action *ListenerRuleAction `pulumi:"action"`
	// ARN of the target group.
	Arn *string `pulumi:"arn"`
	// The ID or Amazon Resource Name (ARN) of the listener.
	ListenerIdentifier *string `pulumi:"listenerIdentifier"`
	// The rule match.
	Match *ListenerRuleMatch `pulumi:"match"`
	// The name of the rule. The name must be unique within the listener. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name *string `pulumi:"name"`
	// The priority assigned to the rule. Each rule for a specific listener must have a unique priority. The lower the priority number the higher the priority.
	Priority *int `pulumi:"priority"`
	// Unique identifier for the target group.
	RuleId *string `pulumi:"ruleId"`
	// The ID or Amazon Resource Identifier (ARN) of the service.
	ServiceIdentifier *string `pulumi:"serviceIdentifier"`
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type ListenerRuleState struct {
	// The action for the default rule.
	Action ListenerRuleActionPtrInput
	// ARN of the target group.
	Arn pulumi.StringPtrInput
	// The ID or Amazon Resource Name (ARN) of the listener.
	ListenerIdentifier pulumi.StringPtrInput
	// The rule match.
	Match ListenerRuleMatchPtrInput
	// The name of the rule. The name must be unique within the listener. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name pulumi.StringPtrInput
	// The priority assigned to the rule. Each rule for a specific listener must have a unique priority. The lower the priority number the higher the priority.
	Priority pulumi.IntPtrInput
	// Unique identifier for the target group.
	RuleId pulumi.StringPtrInput
	// The ID or Amazon Resource Identifier (ARN) of the service.
	ServiceIdentifier pulumi.StringPtrInput
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	TagsAll pulumi.StringMapInput
}

func (ListenerRuleState) ElementType() reflect.Type {
	return reflect.TypeOf((*listenerRuleState)(nil)).Elem()
}

type listenerRuleArgs struct {
	// The action for the default rule.
	Action ListenerRuleAction `pulumi:"action"`
	// The ID or Amazon Resource Name (ARN) of the listener.
	ListenerIdentifier string `pulumi:"listenerIdentifier"`
	// The rule match.
	Match ListenerRuleMatch `pulumi:"match"`
	// The name of the rule. The name must be unique within the listener. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name *string `pulumi:"name"`
	// The priority assigned to the rule. Each rule for a specific listener must have a unique priority. The lower the priority number the higher the priority.
	Priority int `pulumi:"priority"`
	// The ID or Amazon Resource Identifier (ARN) of the service.
	ServiceIdentifier string `pulumi:"serviceIdentifier"`
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

// The set of arguments for constructing a ListenerRule resource.
type ListenerRuleArgs struct {
	// The action for the default rule.
	Action ListenerRuleActionInput
	// The ID or Amazon Resource Name (ARN) of the listener.
	ListenerIdentifier pulumi.StringInput
	// The rule match.
	Match ListenerRuleMatchInput
	// The name of the rule. The name must be unique within the listener. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
	Name pulumi.StringPtrInput
	// The priority assigned to the rule. Each rule for a specific listener must have a unique priority. The lower the priority number the higher the priority.
	Priority pulumi.IntInput
	// The ID or Amazon Resource Identifier (ARN) of the service.
	ServiceIdentifier pulumi.StringInput
	// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	TagsAll pulumi.StringMapInput
}

func (ListenerRuleArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*listenerRuleArgs)(nil)).Elem()
}

type ListenerRuleInput interface {
	pulumi.Input

	ToListenerRuleOutput() ListenerRuleOutput
	ToListenerRuleOutputWithContext(ctx context.Context) ListenerRuleOutput
}

func (*ListenerRule) ElementType() reflect.Type {
	return reflect.TypeOf((**ListenerRule)(nil)).Elem()
}

func (i *ListenerRule) ToListenerRuleOutput() ListenerRuleOutput {
	return i.ToListenerRuleOutputWithContext(context.Background())
}

func (i *ListenerRule) ToListenerRuleOutputWithContext(ctx context.Context) ListenerRuleOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ListenerRuleOutput)
}

// ListenerRuleArrayInput is an input type that accepts ListenerRuleArray and ListenerRuleArrayOutput values.
// You can construct a concrete instance of `ListenerRuleArrayInput` via:
//
//	ListenerRuleArray{ ListenerRuleArgs{...} }
type ListenerRuleArrayInput interface {
	pulumi.Input

	ToListenerRuleArrayOutput() ListenerRuleArrayOutput
	ToListenerRuleArrayOutputWithContext(context.Context) ListenerRuleArrayOutput
}

type ListenerRuleArray []ListenerRuleInput

func (ListenerRuleArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ListenerRule)(nil)).Elem()
}

func (i ListenerRuleArray) ToListenerRuleArrayOutput() ListenerRuleArrayOutput {
	return i.ToListenerRuleArrayOutputWithContext(context.Background())
}

func (i ListenerRuleArray) ToListenerRuleArrayOutputWithContext(ctx context.Context) ListenerRuleArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ListenerRuleArrayOutput)
}

// ListenerRuleMapInput is an input type that accepts ListenerRuleMap and ListenerRuleMapOutput values.
// You can construct a concrete instance of `ListenerRuleMapInput` via:
//
//	ListenerRuleMap{ "key": ListenerRuleArgs{...} }
type ListenerRuleMapInput interface {
	pulumi.Input

	ToListenerRuleMapOutput() ListenerRuleMapOutput
	ToListenerRuleMapOutputWithContext(context.Context) ListenerRuleMapOutput
}

type ListenerRuleMap map[string]ListenerRuleInput

func (ListenerRuleMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ListenerRule)(nil)).Elem()
}

func (i ListenerRuleMap) ToListenerRuleMapOutput() ListenerRuleMapOutput {
	return i.ToListenerRuleMapOutputWithContext(context.Background())
}

func (i ListenerRuleMap) ToListenerRuleMapOutputWithContext(ctx context.Context) ListenerRuleMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ListenerRuleMapOutput)
}

type ListenerRuleOutput struct{ *pulumi.OutputState }

func (ListenerRuleOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ListenerRule)(nil)).Elem()
}

func (o ListenerRuleOutput) ToListenerRuleOutput() ListenerRuleOutput {
	return o
}

func (o ListenerRuleOutput) ToListenerRuleOutputWithContext(ctx context.Context) ListenerRuleOutput {
	return o
}

// The action for the default rule.
func (o ListenerRuleOutput) Action() ListenerRuleActionOutput {
	return o.ApplyT(func(v *ListenerRule) ListenerRuleActionOutput { return v.Action }).(ListenerRuleActionOutput)
}

// ARN of the target group.
func (o ListenerRuleOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *ListenerRule) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The ID or Amazon Resource Name (ARN) of the listener.
func (o ListenerRuleOutput) ListenerIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v *ListenerRule) pulumi.StringOutput { return v.ListenerIdentifier }).(pulumi.StringOutput)
}

// The rule match.
func (o ListenerRuleOutput) Match() ListenerRuleMatchOutput {
	return o.ApplyT(func(v *ListenerRule) ListenerRuleMatchOutput { return v.Match }).(ListenerRuleMatchOutput)
}

// The name of the rule. The name must be unique within the listener. The valid characters are a-z, 0-9, and hyphens (-). You can't use a hyphen as the first or last character, or immediately after another hyphen.
func (o ListenerRuleOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *ListenerRule) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The priority assigned to the rule. Each rule for a specific listener must have a unique priority. The lower the priority number the higher the priority.
func (o ListenerRuleOutput) Priority() pulumi.IntOutput {
	return o.ApplyT(func(v *ListenerRule) pulumi.IntOutput { return v.Priority }).(pulumi.IntOutput)
}

// Unique identifier for the target group.
func (o ListenerRuleOutput) RuleId() pulumi.StringOutput {
	return o.ApplyT(func(v *ListenerRule) pulumi.StringOutput { return v.RuleId }).(pulumi.StringOutput)
}

// The ID or Amazon Resource Identifier (ARN) of the service.
func (o ListenerRuleOutput) ServiceIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v *ListenerRule) pulumi.StringOutput { return v.ServiceIdentifier }).(pulumi.StringOutput)
}

// Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ListenerRuleOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ListenerRule) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
func (o ListenerRuleOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ListenerRule) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type ListenerRuleArrayOutput struct{ *pulumi.OutputState }

func (ListenerRuleArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ListenerRule)(nil)).Elem()
}

func (o ListenerRuleArrayOutput) ToListenerRuleArrayOutput() ListenerRuleArrayOutput {
	return o
}

func (o ListenerRuleArrayOutput) ToListenerRuleArrayOutputWithContext(ctx context.Context) ListenerRuleArrayOutput {
	return o
}

func (o ListenerRuleArrayOutput) Index(i pulumi.IntInput) ListenerRuleOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ListenerRule {
		return vs[0].([]*ListenerRule)[vs[1].(int)]
	}).(ListenerRuleOutput)
}

type ListenerRuleMapOutput struct{ *pulumi.OutputState }

func (ListenerRuleMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ListenerRule)(nil)).Elem()
}

func (o ListenerRuleMapOutput) ToListenerRuleMapOutput() ListenerRuleMapOutput {
	return o
}

func (o ListenerRuleMapOutput) ToListenerRuleMapOutputWithContext(ctx context.Context) ListenerRuleMapOutput {
	return o
}

func (o ListenerRuleMapOutput) MapIndex(k pulumi.StringInput) ListenerRuleOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ListenerRule {
		return vs[0].(map[string]*ListenerRule)[vs[1].(string)]
	}).(ListenerRuleOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ListenerRuleInput)(nil)).Elem(), &ListenerRule{})
	pulumi.RegisterInputType(reflect.TypeOf((*ListenerRuleArrayInput)(nil)).Elem(), ListenerRuleArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ListenerRuleMapInput)(nil)).Elem(), ListenerRuleMap{})
	pulumi.RegisterOutputType(ListenerRuleOutput{})
	pulumi.RegisterOutputType(ListenerRuleArrayOutput{})
	pulumi.RegisterOutputType(ListenerRuleMapOutput{})
}