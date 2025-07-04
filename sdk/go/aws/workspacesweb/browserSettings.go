// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package workspacesweb

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS WorkSpaces Web Browser Settings resource.
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
//	"encoding/json"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/workspacesweb"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"AdditionalSettings": map[string]interface{}{
//					"DownloadsSettings": map[string]interface{}{
//						"Behavior": "DISABLE",
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			_, err = workspacesweb.NewBrowserSettings(ctx, "example", &workspacesweb.BrowserSettingsArgs{
//				BrowserPolicy: pulumi.String(json0),
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
// ### With All Arguments
//
// ```go
// package main
//
// import (
//
//	"encoding/json"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/kms"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/workspacesweb"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := kms.NewKey(ctx, "example", &kms.KeyArgs{
//				Description:          pulumi.String("KMS key for WorkSpaces Web Browser Settings"),
//				DeletionWindowInDays: pulumi.Int(7),
//			})
//			if err != nil {
//				return err
//			}
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"chromePolicies": map[string]interface{}{
//					"DefaultDownloadDirectory": map[string]interface{}{
//						"value": "/home/as2-streaming-user/MyFiles/TemporaryFiles1",
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			_, err = workspacesweb.NewBrowserSettings(ctx, "example", &workspacesweb.BrowserSettingsArgs{
//				BrowserPolicy:      pulumi.String(json0),
//				CustomerManagedKey: example.Arn,
//				AdditionalEncryptionContext: pulumi.StringMap{
//					"Environment": pulumi.String("Production"),
//				},
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("example-browser-settings"),
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
// Using `pulumi import`, import WorkSpaces Web Browser Settings using the `browser_settings_arn`. For example:
//
// ```sh
// $ pulumi import aws:workspacesweb/browserSettings:BrowserSettings example arn:aws:workspacesweb:us-west-2:123456789012:browsersettings/abcdef12345
// ```
type BrowserSettings struct {
	pulumi.CustomResourceState

	// Additional encryption context for the browser settings.
	AdditionalEncryptionContext pulumi.StringMapOutput `pulumi:"additionalEncryptionContext"`
	// List of web portal ARNs to associate with the browser settings.
	AssociatedPortalArns pulumi.StringArrayOutput `pulumi:"associatedPortalArns"`
	// Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
	//
	// The following arguments are optional:
	BrowserPolicy pulumi.StringOutput `pulumi:"browserPolicy"`
	// ARN of the browser settings resource.
	BrowserSettingsArn pulumi.StringOutput `pulumi:"browserSettingsArn"`
	// ARN of the customer managed KMS key.
	CustomerManagedKey pulumi.StringPtrOutput `pulumi:"customerManagedKey"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewBrowserSettings registers a new resource with the given unique name, arguments, and options.
func NewBrowserSettings(ctx *pulumi.Context,
	name string, args *BrowserSettingsArgs, opts ...pulumi.ResourceOption) (*BrowserSettings, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.BrowserPolicy == nil {
		return nil, errors.New("invalid value for required argument 'BrowserPolicy'")
	}
	aliases := pulumi.Aliases([]pulumi.Alias{
		{
			Type: pulumi.String("aws:workspaces/webBrowserSettings:WebBrowserSettings"),
		},
	})
	opts = append(opts, aliases)
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource BrowserSettings
	err := ctx.RegisterResource("aws:workspacesweb/browserSettings:BrowserSettings", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetBrowserSettings gets an existing BrowserSettings resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetBrowserSettings(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *BrowserSettingsState, opts ...pulumi.ResourceOption) (*BrowserSettings, error) {
	var resource BrowserSettings
	err := ctx.ReadResource("aws:workspacesweb/browserSettings:BrowserSettings", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering BrowserSettings resources.
type browserSettingsState struct {
	// Additional encryption context for the browser settings.
	AdditionalEncryptionContext map[string]string `pulumi:"additionalEncryptionContext"`
	// List of web portal ARNs to associate with the browser settings.
	AssociatedPortalArns []string `pulumi:"associatedPortalArns"`
	// Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
	//
	// The following arguments are optional:
	BrowserPolicy *string `pulumi:"browserPolicy"`
	// ARN of the browser settings resource.
	BrowserSettingsArn *string `pulumi:"browserSettingsArn"`
	// ARN of the customer managed KMS key.
	CustomerManagedKey *string `pulumi:"customerManagedKey"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type BrowserSettingsState struct {
	// Additional encryption context for the browser settings.
	AdditionalEncryptionContext pulumi.StringMapInput
	// List of web portal ARNs to associate with the browser settings.
	AssociatedPortalArns pulumi.StringArrayInput
	// Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
	//
	// The following arguments are optional:
	BrowserPolicy pulumi.StringPtrInput
	// ARN of the browser settings resource.
	BrowserSettingsArn pulumi.StringPtrInput
	// ARN of the customer managed KMS key.
	CustomerManagedKey pulumi.StringPtrInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (BrowserSettingsState) ElementType() reflect.Type {
	return reflect.TypeOf((*browserSettingsState)(nil)).Elem()
}

type browserSettingsArgs struct {
	// Additional encryption context for the browser settings.
	AdditionalEncryptionContext map[string]string `pulumi:"additionalEncryptionContext"`
	// Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
	//
	// The following arguments are optional:
	BrowserPolicy string `pulumi:"browserPolicy"`
	// ARN of the customer managed KMS key.
	CustomerManagedKey *string `pulumi:"customerManagedKey"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a BrowserSettings resource.
type BrowserSettingsArgs struct {
	// Additional encryption context for the browser settings.
	AdditionalEncryptionContext pulumi.StringMapInput
	// Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
	//
	// The following arguments are optional:
	BrowserPolicy pulumi.StringInput
	// ARN of the customer managed KMS key.
	CustomerManagedKey pulumi.StringPtrInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (BrowserSettingsArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*browserSettingsArgs)(nil)).Elem()
}

type BrowserSettingsInput interface {
	pulumi.Input

	ToBrowserSettingsOutput() BrowserSettingsOutput
	ToBrowserSettingsOutputWithContext(ctx context.Context) BrowserSettingsOutput
}

func (*BrowserSettings) ElementType() reflect.Type {
	return reflect.TypeOf((**BrowserSettings)(nil)).Elem()
}

func (i *BrowserSettings) ToBrowserSettingsOutput() BrowserSettingsOutput {
	return i.ToBrowserSettingsOutputWithContext(context.Background())
}

func (i *BrowserSettings) ToBrowserSettingsOutputWithContext(ctx context.Context) BrowserSettingsOutput {
	return pulumi.ToOutputWithContext(ctx, i).(BrowserSettingsOutput)
}

// BrowserSettingsArrayInput is an input type that accepts BrowserSettingsArray and BrowserSettingsArrayOutput values.
// You can construct a concrete instance of `BrowserSettingsArrayInput` via:
//
//	BrowserSettingsArray{ BrowserSettingsArgs{...} }
type BrowserSettingsArrayInput interface {
	pulumi.Input

	ToBrowserSettingsArrayOutput() BrowserSettingsArrayOutput
	ToBrowserSettingsArrayOutputWithContext(context.Context) BrowserSettingsArrayOutput
}

type BrowserSettingsArray []BrowserSettingsInput

func (BrowserSettingsArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*BrowserSettings)(nil)).Elem()
}

func (i BrowserSettingsArray) ToBrowserSettingsArrayOutput() BrowserSettingsArrayOutput {
	return i.ToBrowserSettingsArrayOutputWithContext(context.Background())
}

func (i BrowserSettingsArray) ToBrowserSettingsArrayOutputWithContext(ctx context.Context) BrowserSettingsArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(BrowserSettingsArrayOutput)
}

// BrowserSettingsMapInput is an input type that accepts BrowserSettingsMap and BrowserSettingsMapOutput values.
// You can construct a concrete instance of `BrowserSettingsMapInput` via:
//
//	BrowserSettingsMap{ "key": BrowserSettingsArgs{...} }
type BrowserSettingsMapInput interface {
	pulumi.Input

	ToBrowserSettingsMapOutput() BrowserSettingsMapOutput
	ToBrowserSettingsMapOutputWithContext(context.Context) BrowserSettingsMapOutput
}

type BrowserSettingsMap map[string]BrowserSettingsInput

func (BrowserSettingsMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*BrowserSettings)(nil)).Elem()
}

func (i BrowserSettingsMap) ToBrowserSettingsMapOutput() BrowserSettingsMapOutput {
	return i.ToBrowserSettingsMapOutputWithContext(context.Background())
}

func (i BrowserSettingsMap) ToBrowserSettingsMapOutputWithContext(ctx context.Context) BrowserSettingsMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(BrowserSettingsMapOutput)
}

type BrowserSettingsOutput struct{ *pulumi.OutputState }

func (BrowserSettingsOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**BrowserSettings)(nil)).Elem()
}

func (o BrowserSettingsOutput) ToBrowserSettingsOutput() BrowserSettingsOutput {
	return o
}

func (o BrowserSettingsOutput) ToBrowserSettingsOutputWithContext(ctx context.Context) BrowserSettingsOutput {
	return o
}

// Additional encryption context for the browser settings.
func (o BrowserSettingsOutput) AdditionalEncryptionContext() pulumi.StringMapOutput {
	return o.ApplyT(func(v *BrowserSettings) pulumi.StringMapOutput { return v.AdditionalEncryptionContext }).(pulumi.StringMapOutput)
}

// List of web portal ARNs to associate with the browser settings.
func (o BrowserSettingsOutput) AssociatedPortalArns() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *BrowserSettings) pulumi.StringArrayOutput { return v.AssociatedPortalArns }).(pulumi.StringArrayOutput)
}

// Browser policy for the browser settings. This is a JSON string that defines the browser settings policy.
//
// The following arguments are optional:
func (o BrowserSettingsOutput) BrowserPolicy() pulumi.StringOutput {
	return o.ApplyT(func(v *BrowserSettings) pulumi.StringOutput { return v.BrowserPolicy }).(pulumi.StringOutput)
}

// ARN of the browser settings resource.
func (o BrowserSettingsOutput) BrowserSettingsArn() pulumi.StringOutput {
	return o.ApplyT(func(v *BrowserSettings) pulumi.StringOutput { return v.BrowserSettingsArn }).(pulumi.StringOutput)
}

// ARN of the customer managed KMS key.
func (o BrowserSettingsOutput) CustomerManagedKey() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *BrowserSettings) pulumi.StringPtrOutput { return v.CustomerManagedKey }).(pulumi.StringPtrOutput)
}

// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o BrowserSettingsOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *BrowserSettings) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o BrowserSettingsOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *BrowserSettings) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type BrowserSettingsArrayOutput struct{ *pulumi.OutputState }

func (BrowserSettingsArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*BrowserSettings)(nil)).Elem()
}

func (o BrowserSettingsArrayOutput) ToBrowserSettingsArrayOutput() BrowserSettingsArrayOutput {
	return o
}

func (o BrowserSettingsArrayOutput) ToBrowserSettingsArrayOutputWithContext(ctx context.Context) BrowserSettingsArrayOutput {
	return o
}

func (o BrowserSettingsArrayOutput) Index(i pulumi.IntInput) BrowserSettingsOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *BrowserSettings {
		return vs[0].([]*BrowserSettings)[vs[1].(int)]
	}).(BrowserSettingsOutput)
}

type BrowserSettingsMapOutput struct{ *pulumi.OutputState }

func (BrowserSettingsMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*BrowserSettings)(nil)).Elem()
}

func (o BrowserSettingsMapOutput) ToBrowserSettingsMapOutput() BrowserSettingsMapOutput {
	return o
}

func (o BrowserSettingsMapOutput) ToBrowserSettingsMapOutputWithContext(ctx context.Context) BrowserSettingsMapOutput {
	return o
}

func (o BrowserSettingsMapOutput) MapIndex(k pulumi.StringInput) BrowserSettingsOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *BrowserSettings {
		return vs[0].(map[string]*BrowserSettings)[vs[1].(string)]
	}).(BrowserSettingsOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*BrowserSettingsInput)(nil)).Elem(), &BrowserSettings{})
	pulumi.RegisterInputType(reflect.TypeOf((*BrowserSettingsArrayInput)(nil)).Elem(), BrowserSettingsArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*BrowserSettingsMapInput)(nil)).Elem(), BrowserSettingsMap{})
	pulumi.RegisterOutputType(BrowserSettingsOutput{})
	pulumi.RegisterOutputType(BrowserSettingsArrayOutput{})
	pulumi.RegisterOutputType(BrowserSettingsMapOutput{})
}
