// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package inspector2

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS Inspector Filter.
//
// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/inspector2"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := inspector2.NewFilter(ctx, "example", &inspector2.FilterArgs{
//				Name:   pulumi.String("test"),
//				Action: pulumi.String("NONE"),
//				FilterCriterias: inspector2.FilterFilterCriteriaArray{
//					&inspector2.FilterFilterCriteriaArgs{
//						AwsAccountIds: inspector2.FilterFilterCriteriaAwsAccountIdArray{
//							&inspector2.FilterFilterCriteriaAwsAccountIdArgs{
//								Comparison: pulumi.String("EQUALS"),
//								Value:      pulumi.String("111222333444"),
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
//
// ## Import
//
// Using `pulumi import`, import Inspector Filter using the `example_id_arg`. For example:
//
// ```sh
// $ pulumi import aws:inspector2/filter:Filter example "arn:aws:inspector2:us-east-1:111222333444:owner/111222333444/filter/abcdefgh12345678"
// ```
type Filter struct {
	pulumi.CustomResourceState

	// Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
	Action pulumi.StringOutput `pulumi:"action"`
	// ARN of the Filter.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Description
	Description pulumi.StringPtrOutput `pulumi:"description"`
	// Details on the filter criteria. Documented below.
	//
	// The following arguments are optional:
	FilterCriterias FilterFilterCriteriaArrayOutput `pulumi:"filterCriterias"`
	// Name of the filter.
	Name pulumi.StringOutput `pulumi:"name"`
	// Reason for creating the filter
	Reason pulumi.StringPtrOutput `pulumi:"reason"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewFilter registers a new resource with the given unique name, arguments, and options.
func NewFilter(ctx *pulumi.Context,
	name string, args *FilterArgs, opts ...pulumi.ResourceOption) (*Filter, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Action == nil {
		return nil, errors.New("invalid value for required argument 'Action'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Filter
	err := ctx.RegisterResource("aws:inspector2/filter:Filter", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetFilter gets an existing Filter resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetFilter(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *FilterState, opts ...pulumi.ResourceOption) (*Filter, error) {
	var resource Filter
	err := ctx.ReadResource("aws:inspector2/filter:Filter", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Filter resources.
type filterState struct {
	// Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
	Action *string `pulumi:"action"`
	// ARN of the Filter.
	Arn *string `pulumi:"arn"`
	// Description
	Description *string `pulumi:"description"`
	// Details on the filter criteria. Documented below.
	//
	// The following arguments are optional:
	FilterCriterias []FilterFilterCriteria `pulumi:"filterCriterias"`
	// Name of the filter.
	Name *string `pulumi:"name"`
	// Reason for creating the filter
	Reason *string `pulumi:"reason"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type FilterState struct {
	// Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
	Action pulumi.StringPtrInput
	// ARN of the Filter.
	Arn pulumi.StringPtrInput
	// Description
	Description pulumi.StringPtrInput
	// Details on the filter criteria. Documented below.
	//
	// The following arguments are optional:
	FilterCriterias FilterFilterCriteriaArrayInput
	// Name of the filter.
	Name pulumi.StringPtrInput
	// Reason for creating the filter
	Reason pulumi.StringPtrInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (FilterState) ElementType() reflect.Type {
	return reflect.TypeOf((*filterState)(nil)).Elem()
}

type filterArgs struct {
	// Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
	Action string `pulumi:"action"`
	// Description
	Description *string `pulumi:"description"`
	// Details on the filter criteria. Documented below.
	//
	// The following arguments are optional:
	FilterCriterias []FilterFilterCriteria `pulumi:"filterCriterias"`
	// Name of the filter.
	Name *string `pulumi:"name"`
	// Reason for creating the filter
	Reason *string `pulumi:"reason"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a Filter resource.
type FilterArgs struct {
	// Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
	Action pulumi.StringInput
	// Description
	Description pulumi.StringPtrInput
	// Details on the filter criteria. Documented below.
	//
	// The following arguments are optional:
	FilterCriterias FilterFilterCriteriaArrayInput
	// Name of the filter.
	Name pulumi.StringPtrInput
	// Reason for creating the filter
	Reason pulumi.StringPtrInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (FilterArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*filterArgs)(nil)).Elem()
}

type FilterInput interface {
	pulumi.Input

	ToFilterOutput() FilterOutput
	ToFilterOutputWithContext(ctx context.Context) FilterOutput
}

func (*Filter) ElementType() reflect.Type {
	return reflect.TypeOf((**Filter)(nil)).Elem()
}

func (i *Filter) ToFilterOutput() FilterOutput {
	return i.ToFilterOutputWithContext(context.Background())
}

func (i *Filter) ToFilterOutputWithContext(ctx context.Context) FilterOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FilterOutput)
}

// FilterArrayInput is an input type that accepts FilterArray and FilterArrayOutput values.
// You can construct a concrete instance of `FilterArrayInput` via:
//
//	FilterArray{ FilterArgs{...} }
type FilterArrayInput interface {
	pulumi.Input

	ToFilterArrayOutput() FilterArrayOutput
	ToFilterArrayOutputWithContext(context.Context) FilterArrayOutput
}

type FilterArray []FilterInput

func (FilterArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Filter)(nil)).Elem()
}

func (i FilterArray) ToFilterArrayOutput() FilterArrayOutput {
	return i.ToFilterArrayOutputWithContext(context.Background())
}

func (i FilterArray) ToFilterArrayOutputWithContext(ctx context.Context) FilterArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FilterArrayOutput)
}

// FilterMapInput is an input type that accepts FilterMap and FilterMapOutput values.
// You can construct a concrete instance of `FilterMapInput` via:
//
//	FilterMap{ "key": FilterArgs{...} }
type FilterMapInput interface {
	pulumi.Input

	ToFilterMapOutput() FilterMapOutput
	ToFilterMapOutputWithContext(context.Context) FilterMapOutput
}

type FilterMap map[string]FilterInput

func (FilterMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Filter)(nil)).Elem()
}

func (i FilterMap) ToFilterMapOutput() FilterMapOutput {
	return i.ToFilterMapOutputWithContext(context.Background())
}

func (i FilterMap) ToFilterMapOutputWithContext(ctx context.Context) FilterMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(FilterMapOutput)
}

type FilterOutput struct{ *pulumi.OutputState }

func (FilterOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Filter)(nil)).Elem()
}

func (o FilterOutput) ToFilterOutput() FilterOutput {
	return o
}

func (o FilterOutput) ToFilterOutputWithContext(ctx context.Context) FilterOutput {
	return o
}

// Action to be applied to the findings that maatch the filter. Possible values are `NONE` and `SUPPRESS`
func (o FilterOutput) Action() pulumi.StringOutput {
	return o.ApplyT(func(v *Filter) pulumi.StringOutput { return v.Action }).(pulumi.StringOutput)
}

// ARN of the Filter.
func (o FilterOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Filter) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Description
func (o FilterOutput) Description() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Filter) pulumi.StringPtrOutput { return v.Description }).(pulumi.StringPtrOutput)
}

// Details on the filter criteria. Documented below.
//
// The following arguments are optional:
func (o FilterOutput) FilterCriterias() FilterFilterCriteriaArrayOutput {
	return o.ApplyT(func(v *Filter) FilterFilterCriteriaArrayOutput { return v.FilterCriterias }).(FilterFilterCriteriaArrayOutput)
}

// Name of the filter.
func (o FilterOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Filter) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// Reason for creating the filter
func (o FilterOutput) Reason() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Filter) pulumi.StringPtrOutput { return v.Reason }).(pulumi.StringPtrOutput)
}

// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o FilterOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Filter) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o FilterOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Filter) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type FilterArrayOutput struct{ *pulumi.OutputState }

func (FilterArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Filter)(nil)).Elem()
}

func (o FilterArrayOutput) ToFilterArrayOutput() FilterArrayOutput {
	return o
}

func (o FilterArrayOutput) ToFilterArrayOutputWithContext(ctx context.Context) FilterArrayOutput {
	return o
}

func (o FilterArrayOutput) Index(i pulumi.IntInput) FilterOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Filter {
		return vs[0].([]*Filter)[vs[1].(int)]
	}).(FilterOutput)
}

type FilterMapOutput struct{ *pulumi.OutputState }

func (FilterMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Filter)(nil)).Elem()
}

func (o FilterMapOutput) ToFilterMapOutput() FilterMapOutput {
	return o
}

func (o FilterMapOutput) ToFilterMapOutputWithContext(ctx context.Context) FilterMapOutput {
	return o
}

func (o FilterMapOutput) MapIndex(k pulumi.StringInput) FilterOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Filter {
		return vs[0].(map[string]*Filter)[vs[1].(string)]
	}).(FilterOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*FilterInput)(nil)).Elem(), &Filter{})
	pulumi.RegisterInputType(reflect.TypeOf((*FilterArrayInput)(nil)).Elem(), FilterArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*FilterMapInput)(nil)).Elem(), FilterMap{})
	pulumi.RegisterOutputType(FilterOutput{})
	pulumi.RegisterOutputType(FilterArrayOutput{})
	pulumi.RegisterOutputType(FilterMapOutput{})
}
