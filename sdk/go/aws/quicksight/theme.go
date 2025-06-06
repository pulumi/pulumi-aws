// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package quicksight

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing a QuickSight Theme.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/quicksight"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := quicksight.NewTheme(ctx, "example", &quicksight.ThemeArgs{
//				ThemeId:     pulumi.String("example"),
//				Name:        pulumi.String("example"),
//				BaseThemeId: pulumi.String("MIDNIGHT"),
//				Configuration: &quicksight.ThemeConfigurationArgs{
//					DataColorPalette: &quicksight.ThemeConfigurationDataColorPaletteArgs{
//						Colors: pulumi.StringArray{
//							pulumi.String("#FFFFFF"),
//							pulumi.String("#111111"),
//							pulumi.String("#222222"),
//							pulumi.String("#333333"),
//							pulumi.String("#444444"),
//							pulumi.String("#555555"),
//							pulumi.String("#666666"),
//							pulumi.String("#777777"),
//							pulumi.String("#888888"),
//							pulumi.String("#999999"),
//						},
//						EmptyFillColor: pulumi.String("#FFFFFF"),
//						MinMaxGradients: pulumi.StringArray{
//							pulumi.String("#FFFFFF"),
//							pulumi.String("#111111"),
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
// Using `pulumi import`, import a QuickSight Theme using the AWS account ID and theme ID separated by a comma (`,`). For example:
//
// ```sh
// $ pulumi import aws:quicksight/theme:Theme example 123456789012,example-id
// ```
type Theme struct {
	pulumi.CustomResourceState

	// ARN of the theme.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// AWS account ID.
	AwsAccountId pulumi.StringOutput `pulumi:"awsAccountId"`
	// The ID of the theme that a custom theme will inherit from. All themes inherit from one of the starting themes defined by Amazon QuickSight. For a list of the starting themes, use ListThemes or choose Themes from within an analysis.
	BaseThemeId pulumi.StringOutput `pulumi:"baseThemeId"`
	// The theme configuration, which contains the theme display properties. See configuration.
	//
	// The following arguments are optional:
	Configuration ThemeConfigurationPtrOutput `pulumi:"configuration"`
	// The time that the theme was created.
	CreatedTime pulumi.StringOutput `pulumi:"createdTime"`
	// The time that the theme was last updated.
	LastUpdatedTime pulumi.StringOutput `pulumi:"lastUpdatedTime"`
	// Display name of the theme.
	Name pulumi.StringOutput `pulumi:"name"`
	// A set of resource permissions on the theme. Maximum of 64 items. See permissions.
	Permissions ThemePermissionArrayOutput `pulumi:"permissions"`
	// The theme creation status.
	Status pulumi.StringOutput `pulumi:"status"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// Identifier of the theme.
	ThemeId pulumi.StringOutput `pulumi:"themeId"`
	// A description of the current theme version being created/updated.
	VersionDescription pulumi.StringPtrOutput `pulumi:"versionDescription"`
	// The version number of the theme version.
	VersionNumber pulumi.IntOutput `pulumi:"versionNumber"`
}

// NewTheme registers a new resource with the given unique name, arguments, and options.
func NewTheme(ctx *pulumi.Context,
	name string, args *ThemeArgs, opts ...pulumi.ResourceOption) (*Theme, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.BaseThemeId == nil {
		return nil, errors.New("invalid value for required argument 'BaseThemeId'")
	}
	if args.ThemeId == nil {
		return nil, errors.New("invalid value for required argument 'ThemeId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Theme
	err := ctx.RegisterResource("aws:quicksight/theme:Theme", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetTheme gets an existing Theme resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetTheme(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ThemeState, opts ...pulumi.ResourceOption) (*Theme, error) {
	var resource Theme
	err := ctx.ReadResource("aws:quicksight/theme:Theme", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Theme resources.
type themeState struct {
	// ARN of the theme.
	Arn *string `pulumi:"arn"`
	// AWS account ID.
	AwsAccountId *string `pulumi:"awsAccountId"`
	// The ID of the theme that a custom theme will inherit from. All themes inherit from one of the starting themes defined by Amazon QuickSight. For a list of the starting themes, use ListThemes or choose Themes from within an analysis.
	BaseThemeId *string `pulumi:"baseThemeId"`
	// The theme configuration, which contains the theme display properties. See configuration.
	//
	// The following arguments are optional:
	Configuration *ThemeConfiguration `pulumi:"configuration"`
	// The time that the theme was created.
	CreatedTime *string `pulumi:"createdTime"`
	// The time that the theme was last updated.
	LastUpdatedTime *string `pulumi:"lastUpdatedTime"`
	// Display name of the theme.
	Name *string `pulumi:"name"`
	// A set of resource permissions on the theme. Maximum of 64 items. See permissions.
	Permissions []ThemePermission `pulumi:"permissions"`
	// The theme creation status.
	Status *string `pulumi:"status"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// Identifier of the theme.
	ThemeId *string `pulumi:"themeId"`
	// A description of the current theme version being created/updated.
	VersionDescription *string `pulumi:"versionDescription"`
	// The version number of the theme version.
	VersionNumber *int `pulumi:"versionNumber"`
}

type ThemeState struct {
	// ARN of the theme.
	Arn pulumi.StringPtrInput
	// AWS account ID.
	AwsAccountId pulumi.StringPtrInput
	// The ID of the theme that a custom theme will inherit from. All themes inherit from one of the starting themes defined by Amazon QuickSight. For a list of the starting themes, use ListThemes or choose Themes from within an analysis.
	BaseThemeId pulumi.StringPtrInput
	// The theme configuration, which contains the theme display properties. See configuration.
	//
	// The following arguments are optional:
	Configuration ThemeConfigurationPtrInput
	// The time that the theme was created.
	CreatedTime pulumi.StringPtrInput
	// The time that the theme was last updated.
	LastUpdatedTime pulumi.StringPtrInput
	// Display name of the theme.
	Name pulumi.StringPtrInput
	// A set of resource permissions on the theme. Maximum of 64 items. See permissions.
	Permissions ThemePermissionArrayInput
	// The theme creation status.
	Status pulumi.StringPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// Identifier of the theme.
	ThemeId pulumi.StringPtrInput
	// A description of the current theme version being created/updated.
	VersionDescription pulumi.StringPtrInput
	// The version number of the theme version.
	VersionNumber pulumi.IntPtrInput
}

func (ThemeState) ElementType() reflect.Type {
	return reflect.TypeOf((*themeState)(nil)).Elem()
}

type themeArgs struct {
	// AWS account ID.
	AwsAccountId *string `pulumi:"awsAccountId"`
	// The ID of the theme that a custom theme will inherit from. All themes inherit from one of the starting themes defined by Amazon QuickSight. For a list of the starting themes, use ListThemes or choose Themes from within an analysis.
	BaseThemeId string `pulumi:"baseThemeId"`
	// The theme configuration, which contains the theme display properties. See configuration.
	//
	// The following arguments are optional:
	Configuration *ThemeConfiguration `pulumi:"configuration"`
	// Display name of the theme.
	Name *string `pulumi:"name"`
	// A set of resource permissions on the theme. Maximum of 64 items. See permissions.
	Permissions []ThemePermission `pulumi:"permissions"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Identifier of the theme.
	ThemeId string `pulumi:"themeId"`
	// A description of the current theme version being created/updated.
	VersionDescription *string `pulumi:"versionDescription"`
}

// The set of arguments for constructing a Theme resource.
type ThemeArgs struct {
	// AWS account ID.
	AwsAccountId pulumi.StringPtrInput
	// The ID of the theme that a custom theme will inherit from. All themes inherit from one of the starting themes defined by Amazon QuickSight. For a list of the starting themes, use ListThemes or choose Themes from within an analysis.
	BaseThemeId pulumi.StringInput
	// The theme configuration, which contains the theme display properties. See configuration.
	//
	// The following arguments are optional:
	Configuration ThemeConfigurationPtrInput
	// Display name of the theme.
	Name pulumi.StringPtrInput
	// A set of resource permissions on the theme. Maximum of 64 items. See permissions.
	Permissions ThemePermissionArrayInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Identifier of the theme.
	ThemeId pulumi.StringInput
	// A description of the current theme version being created/updated.
	VersionDescription pulumi.StringPtrInput
}

func (ThemeArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*themeArgs)(nil)).Elem()
}

type ThemeInput interface {
	pulumi.Input

	ToThemeOutput() ThemeOutput
	ToThemeOutputWithContext(ctx context.Context) ThemeOutput
}

func (*Theme) ElementType() reflect.Type {
	return reflect.TypeOf((**Theme)(nil)).Elem()
}

func (i *Theme) ToThemeOutput() ThemeOutput {
	return i.ToThemeOutputWithContext(context.Background())
}

func (i *Theme) ToThemeOutputWithContext(ctx context.Context) ThemeOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ThemeOutput)
}

// ThemeArrayInput is an input type that accepts ThemeArray and ThemeArrayOutput values.
// You can construct a concrete instance of `ThemeArrayInput` via:
//
//	ThemeArray{ ThemeArgs{...} }
type ThemeArrayInput interface {
	pulumi.Input

	ToThemeArrayOutput() ThemeArrayOutput
	ToThemeArrayOutputWithContext(context.Context) ThemeArrayOutput
}

type ThemeArray []ThemeInput

func (ThemeArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Theme)(nil)).Elem()
}

func (i ThemeArray) ToThemeArrayOutput() ThemeArrayOutput {
	return i.ToThemeArrayOutputWithContext(context.Background())
}

func (i ThemeArray) ToThemeArrayOutputWithContext(ctx context.Context) ThemeArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ThemeArrayOutput)
}

// ThemeMapInput is an input type that accepts ThemeMap and ThemeMapOutput values.
// You can construct a concrete instance of `ThemeMapInput` via:
//
//	ThemeMap{ "key": ThemeArgs{...} }
type ThemeMapInput interface {
	pulumi.Input

	ToThemeMapOutput() ThemeMapOutput
	ToThemeMapOutputWithContext(context.Context) ThemeMapOutput
}

type ThemeMap map[string]ThemeInput

func (ThemeMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Theme)(nil)).Elem()
}

func (i ThemeMap) ToThemeMapOutput() ThemeMapOutput {
	return i.ToThemeMapOutputWithContext(context.Background())
}

func (i ThemeMap) ToThemeMapOutputWithContext(ctx context.Context) ThemeMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ThemeMapOutput)
}

type ThemeOutput struct{ *pulumi.OutputState }

func (ThemeOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Theme)(nil)).Elem()
}

func (o ThemeOutput) ToThemeOutput() ThemeOutput {
	return o
}

func (o ThemeOutput) ToThemeOutputWithContext(ctx context.Context) ThemeOutput {
	return o
}

// ARN of the theme.
func (o ThemeOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// AWS account ID.
func (o ThemeOutput) AwsAccountId() pulumi.StringOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringOutput { return v.AwsAccountId }).(pulumi.StringOutput)
}

// The ID of the theme that a custom theme will inherit from. All themes inherit from one of the starting themes defined by Amazon QuickSight. For a list of the starting themes, use ListThemes or choose Themes from within an analysis.
func (o ThemeOutput) BaseThemeId() pulumi.StringOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringOutput { return v.BaseThemeId }).(pulumi.StringOutput)
}

// The theme configuration, which contains the theme display properties. See configuration.
//
// The following arguments are optional:
func (o ThemeOutput) Configuration() ThemeConfigurationPtrOutput {
	return o.ApplyT(func(v *Theme) ThemeConfigurationPtrOutput { return v.Configuration }).(ThemeConfigurationPtrOutput)
}

// The time that the theme was created.
func (o ThemeOutput) CreatedTime() pulumi.StringOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringOutput { return v.CreatedTime }).(pulumi.StringOutput)
}

// The time that the theme was last updated.
func (o ThemeOutput) LastUpdatedTime() pulumi.StringOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringOutput { return v.LastUpdatedTime }).(pulumi.StringOutput)
}

// Display name of the theme.
func (o ThemeOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

// A set of resource permissions on the theme. Maximum of 64 items. See permissions.
func (o ThemeOutput) Permissions() ThemePermissionArrayOutput {
	return o.ApplyT(func(v *Theme) ThemePermissionArrayOutput { return v.Permissions }).(ThemePermissionArrayOutput)
}

// The theme creation status.
func (o ThemeOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ThemeOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ThemeOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// Identifier of the theme.
func (o ThemeOutput) ThemeId() pulumi.StringOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringOutput { return v.ThemeId }).(pulumi.StringOutput)
}

// A description of the current theme version being created/updated.
func (o ThemeOutput) VersionDescription() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Theme) pulumi.StringPtrOutput { return v.VersionDescription }).(pulumi.StringPtrOutput)
}

// The version number of the theme version.
func (o ThemeOutput) VersionNumber() pulumi.IntOutput {
	return o.ApplyT(func(v *Theme) pulumi.IntOutput { return v.VersionNumber }).(pulumi.IntOutput)
}

type ThemeArrayOutput struct{ *pulumi.OutputState }

func (ThemeArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Theme)(nil)).Elem()
}

func (o ThemeArrayOutput) ToThemeArrayOutput() ThemeArrayOutput {
	return o
}

func (o ThemeArrayOutput) ToThemeArrayOutputWithContext(ctx context.Context) ThemeArrayOutput {
	return o
}

func (o ThemeArrayOutput) Index(i pulumi.IntInput) ThemeOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Theme {
		return vs[0].([]*Theme)[vs[1].(int)]
	}).(ThemeOutput)
}

type ThemeMapOutput struct{ *pulumi.OutputState }

func (ThemeMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Theme)(nil)).Elem()
}

func (o ThemeMapOutput) ToThemeMapOutput() ThemeMapOutput {
	return o
}

func (o ThemeMapOutput) ToThemeMapOutputWithContext(ctx context.Context) ThemeMapOutput {
	return o
}

func (o ThemeMapOutput) MapIndex(k pulumi.StringInput) ThemeOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Theme {
		return vs[0].(map[string]*Theme)[vs[1].(string)]
	}).(ThemeOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ThemeInput)(nil)).Elem(), &Theme{})
	pulumi.RegisterInputType(reflect.TypeOf((*ThemeArrayInput)(nil)).Elem(), ThemeArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ThemeMapInput)(nil)).Elem(), ThemeMap{})
	pulumi.RegisterOutputType(ThemeOutput{})
	pulumi.RegisterOutputType(ThemeArrayOutput{})
	pulumi.RegisterOutputType(ThemeMapOutput{})
}
