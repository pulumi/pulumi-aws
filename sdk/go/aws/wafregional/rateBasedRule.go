// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package wafregional

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a WAF Rate Based Rule Resource
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/wafregional"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			ipset, err := wafregional.NewIpSet(ctx, "ipset", &wafregional.IpSetArgs{
//				Name: pulumi.String("tfIPSet"),
//				IpSetDescriptors: wafregional.IpSetIpSetDescriptorArray{
//					&wafregional.IpSetIpSetDescriptorArgs{
//						Type:  pulumi.String("IPV4"),
//						Value: pulumi.String("192.0.7.0/24"),
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = wafregional.NewRateBasedRule(ctx, "wafrule", &wafregional.RateBasedRuleArgs{
//				Name:       pulumi.String("tfWAFRule"),
//				MetricName: pulumi.String("tfWAFRule"),
//				RateKey:    pulumi.String("IP"),
//				RateLimit:  pulumi.Int(100),
//				Predicates: wafregional.RateBasedRulePredicateArray{
//					&wafregional.RateBasedRulePredicateArgs{
//						DataId:  ipset.ID(),
//						Negated: pulumi.Bool(false),
//						Type:    pulumi.String("IPMatch"),
//					},
//				},
//			}, pulumi.DependsOn([]pulumi.Resource{
//				ipset,
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
// Using `pulumi import`, import WAF Regional Rate Based Rule using the id. For example:
//
// ```sh
// $ pulumi import aws:wafregional/rateBasedRule:RateBasedRule wafrule a1b2c3d4-d5f6-7777-8888-9999aaaabbbbcccc
// ```
type RateBasedRule struct {
	pulumi.CustomResourceState

	// The ARN of the WAF Regional Rate Based Rule.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The name or description for the Amazon CloudWatch metric of this rule.
	MetricName pulumi.StringOutput `pulumi:"metricName"`
	// The name or description of the rule.
	Name pulumi.StringOutput `pulumi:"name"`
	// The objects to include in a rule (documented below).
	Predicates RateBasedRulePredicateArrayOutput `pulumi:"predicates"`
	// Valid value is IP.
	RateKey pulumi.StringOutput `pulumi:"rateKey"`
	// The maximum number of requests, which have an identical value in the field specified by the RateKey, allowed in a five-minute period. Minimum value is 100.
	RateLimit pulumi.IntOutput `pulumi:"rateLimit"`
	// Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewRateBasedRule registers a new resource with the given unique name, arguments, and options.
func NewRateBasedRule(ctx *pulumi.Context,
	name string, args *RateBasedRuleArgs, opts ...pulumi.ResourceOption) (*RateBasedRule, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.MetricName == nil {
		return nil, errors.New("invalid value for required argument 'MetricName'")
	}
	if args.RateKey == nil {
		return nil, errors.New("invalid value for required argument 'RateKey'")
	}
	if args.RateLimit == nil {
		return nil, errors.New("invalid value for required argument 'RateLimit'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource RateBasedRule
	err := ctx.RegisterResource("aws:wafregional/rateBasedRule:RateBasedRule", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetRateBasedRule gets an existing RateBasedRule resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetRateBasedRule(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *RateBasedRuleState, opts ...pulumi.ResourceOption) (*RateBasedRule, error) {
	var resource RateBasedRule
	err := ctx.ReadResource("aws:wafregional/rateBasedRule:RateBasedRule", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering RateBasedRule resources.
type rateBasedRuleState struct {
	// The ARN of the WAF Regional Rate Based Rule.
	Arn *string `pulumi:"arn"`
	// The name or description for the Amazon CloudWatch metric of this rule.
	MetricName *string `pulumi:"metricName"`
	// The name or description of the rule.
	Name *string `pulumi:"name"`
	// The objects to include in a rule (documented below).
	Predicates []RateBasedRulePredicate `pulumi:"predicates"`
	// Valid value is IP.
	RateKey *string `pulumi:"rateKey"`
	// The maximum number of requests, which have an identical value in the field specified by the RateKey, allowed in a five-minute period. Minimum value is 100.
	RateLimit *int `pulumi:"rateLimit"`
	// Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type RateBasedRuleState struct {
	// The ARN of the WAF Regional Rate Based Rule.
	Arn pulumi.StringPtrInput
	// The name or description for the Amazon CloudWatch metric of this rule.
	MetricName pulumi.StringPtrInput
	// The name or description of the rule.
	Name pulumi.StringPtrInput
	// The objects to include in a rule (documented below).
	Predicates RateBasedRulePredicateArrayInput
	// Valid value is IP.
	RateKey pulumi.StringPtrInput
	// The maximum number of requests, which have an identical value in the field specified by the RateKey, allowed in a five-minute period. Minimum value is 100.
	RateLimit pulumi.IntPtrInput
	// Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (RateBasedRuleState) ElementType() reflect.Type {
	return reflect.TypeOf((*rateBasedRuleState)(nil)).Elem()
}

type rateBasedRuleArgs struct {
	// The name or description for the Amazon CloudWatch metric of this rule.
	MetricName string `pulumi:"metricName"`
	// The name or description of the rule.
	Name *string `pulumi:"name"`
	// The objects to include in a rule (documented below).
	Predicates []RateBasedRulePredicate `pulumi:"predicates"`
	// Valid value is IP.
	RateKey string `pulumi:"rateKey"`
	// The maximum number of requests, which have an identical value in the field specified by the RateKey, allowed in a five-minute period. Minimum value is 100.
	RateLimit int `pulumi:"rateLimit"`
	// Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a RateBasedRule resource.
type RateBasedRuleArgs struct {
	// The name or description for the Amazon CloudWatch metric of this rule.
	MetricName pulumi.StringInput
	// The name or description of the rule.
	Name pulumi.StringPtrInput
	// The objects to include in a rule (documented below).
	Predicates RateBasedRulePredicateArrayInput
	// Valid value is IP.
	RateKey pulumi.StringInput
	// The maximum number of requests, which have an identical value in the field specified by the RateKey, allowed in a five-minute period. Minimum value is 100.
	RateLimit pulumi.IntInput
	// Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (RateBasedRuleArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*rateBasedRuleArgs)(nil)).Elem()
}

type RateBasedRuleInput interface {
	pulumi.Input

	ToRateBasedRuleOutput() RateBasedRuleOutput
	ToRateBasedRuleOutputWithContext(ctx context.Context) RateBasedRuleOutput
}

func (*RateBasedRule) ElementType() reflect.Type {
	return reflect.TypeOf((**RateBasedRule)(nil)).Elem()
}

func (i *RateBasedRule) ToRateBasedRuleOutput() RateBasedRuleOutput {
	return i.ToRateBasedRuleOutputWithContext(context.Background())
}

func (i *RateBasedRule) ToRateBasedRuleOutputWithContext(ctx context.Context) RateBasedRuleOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RateBasedRuleOutput)
}

// RateBasedRuleArrayInput is an input type that accepts RateBasedRuleArray and RateBasedRuleArrayOutput values.
// You can construct a concrete instance of `RateBasedRuleArrayInput` via:
//
//	RateBasedRuleArray{ RateBasedRuleArgs{...} }
type RateBasedRuleArrayInput interface {
	pulumi.Input

	ToRateBasedRuleArrayOutput() RateBasedRuleArrayOutput
	ToRateBasedRuleArrayOutputWithContext(context.Context) RateBasedRuleArrayOutput
}

type RateBasedRuleArray []RateBasedRuleInput

func (RateBasedRuleArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RateBasedRule)(nil)).Elem()
}

func (i RateBasedRuleArray) ToRateBasedRuleArrayOutput() RateBasedRuleArrayOutput {
	return i.ToRateBasedRuleArrayOutputWithContext(context.Background())
}

func (i RateBasedRuleArray) ToRateBasedRuleArrayOutputWithContext(ctx context.Context) RateBasedRuleArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RateBasedRuleArrayOutput)
}

// RateBasedRuleMapInput is an input type that accepts RateBasedRuleMap and RateBasedRuleMapOutput values.
// You can construct a concrete instance of `RateBasedRuleMapInput` via:
//
//	RateBasedRuleMap{ "key": RateBasedRuleArgs{...} }
type RateBasedRuleMapInput interface {
	pulumi.Input

	ToRateBasedRuleMapOutput() RateBasedRuleMapOutput
	ToRateBasedRuleMapOutputWithContext(context.Context) RateBasedRuleMapOutput
}

type RateBasedRuleMap map[string]RateBasedRuleInput

func (RateBasedRuleMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RateBasedRule)(nil)).Elem()
}

func (i RateBasedRuleMap) ToRateBasedRuleMapOutput() RateBasedRuleMapOutput {
	return i.ToRateBasedRuleMapOutputWithContext(context.Background())
}

func (i RateBasedRuleMap) ToRateBasedRuleMapOutputWithContext(ctx context.Context) RateBasedRuleMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(RateBasedRuleMapOutput)
}

type RateBasedRuleOutput struct{ *pulumi.OutputState }

func (RateBasedRuleOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**RateBasedRule)(nil)).Elem()
}

func (o RateBasedRuleOutput) ToRateBasedRuleOutput() RateBasedRuleOutput {
	return o
}

func (o RateBasedRuleOutput) ToRateBasedRuleOutputWithContext(ctx context.Context) RateBasedRuleOutput {
	return o
}

// The ARN of the WAF Regional Rate Based Rule.
func (o RateBasedRuleOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *RateBasedRule) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The name or description for the Amazon CloudWatch metric of this rule.
func (o RateBasedRuleOutput) MetricName() pulumi.StringOutput {
	return o.ApplyT(func(v *RateBasedRule) pulumi.StringOutput { return v.MetricName }).(pulumi.StringOutput)
}

// The name or description of the rule.
func (o RateBasedRuleOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *RateBasedRule) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// The objects to include in a rule (documented below).
func (o RateBasedRuleOutput) Predicates() RateBasedRulePredicateArrayOutput {
	return o.ApplyT(func(v *RateBasedRule) RateBasedRulePredicateArrayOutput { return v.Predicates }).(RateBasedRulePredicateArrayOutput)
}

// Valid value is IP.
func (o RateBasedRuleOutput) RateKey() pulumi.StringOutput {
	return o.ApplyT(func(v *RateBasedRule) pulumi.StringOutput { return v.RateKey }).(pulumi.StringOutput)
}

// The maximum number of requests, which have an identical value in the field specified by the RateKey, allowed in a five-minute period. Minimum value is 100.
func (o RateBasedRuleOutput) RateLimit() pulumi.IntOutput {
	return o.ApplyT(func(v *RateBasedRule) pulumi.IntOutput { return v.RateLimit }).(pulumi.IntOutput)
}

// Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o RateBasedRuleOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *RateBasedRule) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o RateBasedRuleOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *RateBasedRule) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type RateBasedRuleArrayOutput struct{ *pulumi.OutputState }

func (RateBasedRuleArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*RateBasedRule)(nil)).Elem()
}

func (o RateBasedRuleArrayOutput) ToRateBasedRuleArrayOutput() RateBasedRuleArrayOutput {
	return o
}

func (o RateBasedRuleArrayOutput) ToRateBasedRuleArrayOutputWithContext(ctx context.Context) RateBasedRuleArrayOutput {
	return o
}

func (o RateBasedRuleArrayOutput) Index(i pulumi.IntInput) RateBasedRuleOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *RateBasedRule {
		return vs[0].([]*RateBasedRule)[vs[1].(int)]
	}).(RateBasedRuleOutput)
}

type RateBasedRuleMapOutput struct{ *pulumi.OutputState }

func (RateBasedRuleMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*RateBasedRule)(nil)).Elem()
}

func (o RateBasedRuleMapOutput) ToRateBasedRuleMapOutput() RateBasedRuleMapOutput {
	return o
}

func (o RateBasedRuleMapOutput) ToRateBasedRuleMapOutputWithContext(ctx context.Context) RateBasedRuleMapOutput {
	return o
}

func (o RateBasedRuleMapOutput) MapIndex(k pulumi.StringInput) RateBasedRuleOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *RateBasedRule {
		return vs[0].(map[string]*RateBasedRule)[vs[1].(string)]
	}).(RateBasedRuleOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*RateBasedRuleInput)(nil)).Elem(), &RateBasedRule{})
	pulumi.RegisterInputType(reflect.TypeOf((*RateBasedRuleArrayInput)(nil)).Elem(), RateBasedRuleArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*RateBasedRuleMapInput)(nil)).Elem(), RateBasedRuleMap{})
	pulumi.RegisterOutputType(RateBasedRuleOutput{})
	pulumi.RegisterOutputType(RateBasedRuleArrayOutput{})
	pulumi.RegisterOutputType(RateBasedRuleMapOutput{})
}
