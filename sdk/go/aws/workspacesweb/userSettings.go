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

// Resource for managing an AWS WorkSpaces Web User Settings resource. Once associated with a web portal, user settings control how users can transfer data between a streaming session and their local devices.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/workspacesweb"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := workspacesweb.NewUserSettings(ctx, "example", &workspacesweb.UserSettingsArgs{
//				CopyAllowed:     pulumi.String("Enabled"),
//				DownloadAllowed: pulumi.String("Enabled"),
//				PasteAllowed:    pulumi.String("Enabled"),
//				PrintAllowed:    pulumi.String("Enabled"),
//				UploadAllowed:   pulumi.String("Enabled"),
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
// ### With Toolbar Configuration
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/workspacesweb"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := workspacesweb.NewUserSettings(ctx, "example", &workspacesweb.UserSettingsArgs{
//				CopyAllowed:     pulumi.String("Enabled"),
//				DownloadAllowed: pulumi.String("Enabled"),
//				PasteAllowed:    pulumi.String("Enabled"),
//				PrintAllowed:    pulumi.String("Enabled"),
//				UploadAllowed:   pulumi.String("Enabled"),
//				ToolbarConfiguration: &workspacesweb.UserSettingsToolbarConfigurationArgs{
//					ToolbarType: pulumi.String("Docked"),
//					VisualMode:  pulumi.String("Dark"),
//					HiddenToolbarItems: pulumi.StringArray{
//						pulumi.String("Webcam"),
//						pulumi.String("Microphone"),
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
// ### Complete Example
//
// ```go
// package main
//
// import (
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
//				Description:          pulumi.String("KMS key for WorkSpaces Web User Settings"),
//				DeletionWindowInDays: pulumi.Int(7),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = workspacesweb.NewUserSettings(ctx, "example", &workspacesweb.UserSettingsArgs{
//				CopyAllowed:                    pulumi.String("Enabled"),
//				DownloadAllowed:                pulumi.String("Enabled"),
//				PasteAllowed:                   pulumi.String("Enabled"),
//				PrintAllowed:                   pulumi.String("Enabled"),
//				UploadAllowed:                  pulumi.String("Enabled"),
//				DeepLinkAllowed:                pulumi.String("Enabled"),
//				DisconnectTimeoutInMinutes:     pulumi.Int(30),
//				IdleDisconnectTimeoutInMinutes: pulumi.Int(15),
//				CustomerManagedKey:             example.Arn,
//				AdditionalEncryptionContext: pulumi.StringMap{
//					"Environment": pulumi.String("Production"),
//				},
//				ToolbarConfiguration: &workspacesweb.UserSettingsToolbarConfigurationArgs{
//					ToolbarType: pulumi.String("Docked"),
//					VisualMode:  pulumi.String("Dark"),
//					HiddenToolbarItems: pulumi.StringArray{
//						pulumi.String("Webcam"),
//						pulumi.String("Microphone"),
//					},
//					MaxDisplayResolution: pulumi.String("size1920X1080"),
//				},
//				CookieSynchronizationConfiguration: &workspacesweb.UserSettingsCookieSynchronizationConfigurationArgs{
//					Allowlists: workspacesweb.UserSettingsCookieSynchronizationConfigurationAllowlistArray{
//						&workspacesweb.UserSettingsCookieSynchronizationConfigurationAllowlistArgs{
//							Domain: pulumi.String("example.com"),
//							Path:   pulumi.String("/path"),
//						},
//					},
//					Blocklists: workspacesweb.UserSettingsCookieSynchronizationConfigurationBlocklistArray{
//						&workspacesweb.UserSettingsCookieSynchronizationConfigurationBlocklistArgs{
//							Domain: pulumi.String("blocked.com"),
//						},
//					},
//				},
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("example-user-settings"),
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
// Using `pulumi import`, import WorkSpaces Web User Settings using the `user_settings_arn`. For example:
//
// ```sh
// $ pulumi import aws:workspacesweb/userSettings:UserSettings example arn:aws:workspacesweb:us-west-2:123456789012:usersettings/abcdef12345
// ```
type UserSettings struct {
	pulumi.CustomResourceState

	// Additional encryption context for the user settings.
	AdditionalEncryptionContext pulumi.StringMapOutput `pulumi:"additionalEncryptionContext"`
	// List of web portal ARNs to associate with the user settings.
	AssociatedPortalArns pulumi.StringArrayOutput `pulumi:"associatedPortalArns"`
	// Configuration that specifies which cookies should be synchronized from the end user's local browser to the remote browser. Detailed below.
	CookieSynchronizationConfiguration UserSettingsCookieSynchronizationConfigurationPtrOutput `pulumi:"cookieSynchronizationConfiguration"`
	// Specifies whether the user can copy text from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	CopyAllowed pulumi.StringOutput `pulumi:"copyAllowed"`
	// ARN of the customer managed KMS key.
	CustomerManagedKey pulumi.StringPtrOutput `pulumi:"customerManagedKey"`
	// Specifies whether the user can use deep links that open automatically when connecting to a session. Valid values are `Enabled` or `Disabled`.
	DeepLinkAllowed pulumi.StringOutput `pulumi:"deepLinkAllowed"`
	// Amount of time that a streaming session remains active after users disconnect. Value must be between 1 and 600 minutes.
	DisconnectTimeoutInMinutes pulumi.IntPtrOutput `pulumi:"disconnectTimeoutInMinutes"`
	// Specifies whether the user can download files from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	DownloadAllowed pulumi.StringOutput `pulumi:"downloadAllowed"`
	// Amount of time that users can be idle before they are disconnected from their streaming session. Value must be between 0 and 60 minutes.
	IdleDisconnectTimeoutInMinutes pulumi.IntPtrOutput `pulumi:"idleDisconnectTimeoutInMinutes"`
	// Specifies whether the user can paste text from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	PasteAllowed pulumi.StringOutput `pulumi:"pasteAllowed"`
	// Specifies whether the user can print to the local device. Valid values are `Enabled` or `Disabled`.
	PrintAllowed pulumi.StringOutput `pulumi:"printAllowed"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// Configuration of the toolbar. Detailed below.
	ToolbarConfiguration UserSettingsToolbarConfigurationPtrOutput `pulumi:"toolbarConfiguration"`
	// Specifies whether the user can upload files from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	//
	// The following arguments are optional:
	UploadAllowed pulumi.StringOutput `pulumi:"uploadAllowed"`
	// ARN of the user settings resource.
	UserSettingsArn pulumi.StringOutput `pulumi:"userSettingsArn"`
}

// NewUserSettings registers a new resource with the given unique name, arguments, and options.
func NewUserSettings(ctx *pulumi.Context,
	name string, args *UserSettingsArgs, opts ...pulumi.ResourceOption) (*UserSettings, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.CopyAllowed == nil {
		return nil, errors.New("invalid value for required argument 'CopyAllowed'")
	}
	if args.DownloadAllowed == nil {
		return nil, errors.New("invalid value for required argument 'DownloadAllowed'")
	}
	if args.PasteAllowed == nil {
		return nil, errors.New("invalid value for required argument 'PasteAllowed'")
	}
	if args.PrintAllowed == nil {
		return nil, errors.New("invalid value for required argument 'PrintAllowed'")
	}
	if args.UploadAllowed == nil {
		return nil, errors.New("invalid value for required argument 'UploadAllowed'")
	}
	aliases := pulumi.Aliases([]pulumi.Alias{
		{
			Type: pulumi.String("aws:workspaces/webUserSettings:WebUserSettings"),
		},
	})
	opts = append(opts, aliases)
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource UserSettings
	err := ctx.RegisterResource("aws:workspacesweb/userSettings:UserSettings", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetUserSettings gets an existing UserSettings resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetUserSettings(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *UserSettingsState, opts ...pulumi.ResourceOption) (*UserSettings, error) {
	var resource UserSettings
	err := ctx.ReadResource("aws:workspacesweb/userSettings:UserSettings", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering UserSettings resources.
type userSettingsState struct {
	// Additional encryption context for the user settings.
	AdditionalEncryptionContext map[string]string `pulumi:"additionalEncryptionContext"`
	// List of web portal ARNs to associate with the user settings.
	AssociatedPortalArns []string `pulumi:"associatedPortalArns"`
	// Configuration that specifies which cookies should be synchronized from the end user's local browser to the remote browser. Detailed below.
	CookieSynchronizationConfiguration *UserSettingsCookieSynchronizationConfiguration `pulumi:"cookieSynchronizationConfiguration"`
	// Specifies whether the user can copy text from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	CopyAllowed *string `pulumi:"copyAllowed"`
	// ARN of the customer managed KMS key.
	CustomerManagedKey *string `pulumi:"customerManagedKey"`
	// Specifies whether the user can use deep links that open automatically when connecting to a session. Valid values are `Enabled` or `Disabled`.
	DeepLinkAllowed *string `pulumi:"deepLinkAllowed"`
	// Amount of time that a streaming session remains active after users disconnect. Value must be between 1 and 600 minutes.
	DisconnectTimeoutInMinutes *int `pulumi:"disconnectTimeoutInMinutes"`
	// Specifies whether the user can download files from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	DownloadAllowed *string `pulumi:"downloadAllowed"`
	// Amount of time that users can be idle before they are disconnected from their streaming session. Value must be between 0 and 60 minutes.
	IdleDisconnectTimeoutInMinutes *int `pulumi:"idleDisconnectTimeoutInMinutes"`
	// Specifies whether the user can paste text from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	PasteAllowed *string `pulumi:"pasteAllowed"`
	// Specifies whether the user can print to the local device. Valid values are `Enabled` or `Disabled`.
	PrintAllowed *string `pulumi:"printAllowed"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// Configuration of the toolbar. Detailed below.
	ToolbarConfiguration *UserSettingsToolbarConfiguration `pulumi:"toolbarConfiguration"`
	// Specifies whether the user can upload files from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	//
	// The following arguments are optional:
	UploadAllowed *string `pulumi:"uploadAllowed"`
	// ARN of the user settings resource.
	UserSettingsArn *string `pulumi:"userSettingsArn"`
}

type UserSettingsState struct {
	// Additional encryption context for the user settings.
	AdditionalEncryptionContext pulumi.StringMapInput
	// List of web portal ARNs to associate with the user settings.
	AssociatedPortalArns pulumi.StringArrayInput
	// Configuration that specifies which cookies should be synchronized from the end user's local browser to the remote browser. Detailed below.
	CookieSynchronizationConfiguration UserSettingsCookieSynchronizationConfigurationPtrInput
	// Specifies whether the user can copy text from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	CopyAllowed pulumi.StringPtrInput
	// ARN of the customer managed KMS key.
	CustomerManagedKey pulumi.StringPtrInput
	// Specifies whether the user can use deep links that open automatically when connecting to a session. Valid values are `Enabled` or `Disabled`.
	DeepLinkAllowed pulumi.StringPtrInput
	// Amount of time that a streaming session remains active after users disconnect. Value must be between 1 and 600 minutes.
	DisconnectTimeoutInMinutes pulumi.IntPtrInput
	// Specifies whether the user can download files from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	DownloadAllowed pulumi.StringPtrInput
	// Amount of time that users can be idle before they are disconnected from their streaming session. Value must be between 0 and 60 minutes.
	IdleDisconnectTimeoutInMinutes pulumi.IntPtrInput
	// Specifies whether the user can paste text from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	PasteAllowed pulumi.StringPtrInput
	// Specifies whether the user can print to the local device. Valid values are `Enabled` or `Disabled`.
	PrintAllowed pulumi.StringPtrInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// Configuration of the toolbar. Detailed below.
	ToolbarConfiguration UserSettingsToolbarConfigurationPtrInput
	// Specifies whether the user can upload files from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	//
	// The following arguments are optional:
	UploadAllowed pulumi.StringPtrInput
	// ARN of the user settings resource.
	UserSettingsArn pulumi.StringPtrInput
}

func (UserSettingsState) ElementType() reflect.Type {
	return reflect.TypeOf((*userSettingsState)(nil)).Elem()
}

type userSettingsArgs struct {
	// Additional encryption context for the user settings.
	AdditionalEncryptionContext map[string]string `pulumi:"additionalEncryptionContext"`
	// Configuration that specifies which cookies should be synchronized from the end user's local browser to the remote browser. Detailed below.
	CookieSynchronizationConfiguration *UserSettingsCookieSynchronizationConfiguration `pulumi:"cookieSynchronizationConfiguration"`
	// Specifies whether the user can copy text from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	CopyAllowed string `pulumi:"copyAllowed"`
	// ARN of the customer managed KMS key.
	CustomerManagedKey *string `pulumi:"customerManagedKey"`
	// Specifies whether the user can use deep links that open automatically when connecting to a session. Valid values are `Enabled` or `Disabled`.
	DeepLinkAllowed *string `pulumi:"deepLinkAllowed"`
	// Amount of time that a streaming session remains active after users disconnect. Value must be between 1 and 600 minutes.
	DisconnectTimeoutInMinutes *int `pulumi:"disconnectTimeoutInMinutes"`
	// Specifies whether the user can download files from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	DownloadAllowed string `pulumi:"downloadAllowed"`
	// Amount of time that users can be idle before they are disconnected from their streaming session. Value must be between 0 and 60 minutes.
	IdleDisconnectTimeoutInMinutes *int `pulumi:"idleDisconnectTimeoutInMinutes"`
	// Specifies whether the user can paste text from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	PasteAllowed string `pulumi:"pasteAllowed"`
	// Specifies whether the user can print to the local device. Valid values are `Enabled` or `Disabled`.
	PrintAllowed string `pulumi:"printAllowed"`
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Configuration of the toolbar. Detailed below.
	ToolbarConfiguration *UserSettingsToolbarConfiguration `pulumi:"toolbarConfiguration"`
	// Specifies whether the user can upload files from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	//
	// The following arguments are optional:
	UploadAllowed string `pulumi:"uploadAllowed"`
}

// The set of arguments for constructing a UserSettings resource.
type UserSettingsArgs struct {
	// Additional encryption context for the user settings.
	AdditionalEncryptionContext pulumi.StringMapInput
	// Configuration that specifies which cookies should be synchronized from the end user's local browser to the remote browser. Detailed below.
	CookieSynchronizationConfiguration UserSettingsCookieSynchronizationConfigurationPtrInput
	// Specifies whether the user can copy text from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	CopyAllowed pulumi.StringInput
	// ARN of the customer managed KMS key.
	CustomerManagedKey pulumi.StringPtrInput
	// Specifies whether the user can use deep links that open automatically when connecting to a session. Valid values are `Enabled` or `Disabled`.
	DeepLinkAllowed pulumi.StringPtrInput
	// Amount of time that a streaming session remains active after users disconnect. Value must be between 1 and 600 minutes.
	DisconnectTimeoutInMinutes pulumi.IntPtrInput
	// Specifies whether the user can download files from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
	DownloadAllowed pulumi.StringInput
	// Amount of time that users can be idle before they are disconnected from their streaming session. Value must be between 0 and 60 minutes.
	IdleDisconnectTimeoutInMinutes pulumi.IntPtrInput
	// Specifies whether the user can paste text from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	PasteAllowed pulumi.StringInput
	// Specifies whether the user can print to the local device. Valid values are `Enabled` or `Disabled`.
	PrintAllowed pulumi.StringInput
	// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Configuration of the toolbar. Detailed below.
	ToolbarConfiguration UserSettingsToolbarConfigurationPtrInput
	// Specifies whether the user can upload files from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
	//
	// The following arguments are optional:
	UploadAllowed pulumi.StringInput
}

func (UserSettingsArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*userSettingsArgs)(nil)).Elem()
}

type UserSettingsInput interface {
	pulumi.Input

	ToUserSettingsOutput() UserSettingsOutput
	ToUserSettingsOutputWithContext(ctx context.Context) UserSettingsOutput
}

func (*UserSettings) ElementType() reflect.Type {
	return reflect.TypeOf((**UserSettings)(nil)).Elem()
}

func (i *UserSettings) ToUserSettingsOutput() UserSettingsOutput {
	return i.ToUserSettingsOutputWithContext(context.Background())
}

func (i *UserSettings) ToUserSettingsOutputWithContext(ctx context.Context) UserSettingsOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UserSettingsOutput)
}

// UserSettingsArrayInput is an input type that accepts UserSettingsArray and UserSettingsArrayOutput values.
// You can construct a concrete instance of `UserSettingsArrayInput` via:
//
//	UserSettingsArray{ UserSettingsArgs{...} }
type UserSettingsArrayInput interface {
	pulumi.Input

	ToUserSettingsArrayOutput() UserSettingsArrayOutput
	ToUserSettingsArrayOutputWithContext(context.Context) UserSettingsArrayOutput
}

type UserSettingsArray []UserSettingsInput

func (UserSettingsArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*UserSettings)(nil)).Elem()
}

func (i UserSettingsArray) ToUserSettingsArrayOutput() UserSettingsArrayOutput {
	return i.ToUserSettingsArrayOutputWithContext(context.Background())
}

func (i UserSettingsArray) ToUserSettingsArrayOutputWithContext(ctx context.Context) UserSettingsArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UserSettingsArrayOutput)
}

// UserSettingsMapInput is an input type that accepts UserSettingsMap and UserSettingsMapOutput values.
// You can construct a concrete instance of `UserSettingsMapInput` via:
//
//	UserSettingsMap{ "key": UserSettingsArgs{...} }
type UserSettingsMapInput interface {
	pulumi.Input

	ToUserSettingsMapOutput() UserSettingsMapOutput
	ToUserSettingsMapOutputWithContext(context.Context) UserSettingsMapOutput
}

type UserSettingsMap map[string]UserSettingsInput

func (UserSettingsMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*UserSettings)(nil)).Elem()
}

func (i UserSettingsMap) ToUserSettingsMapOutput() UserSettingsMapOutput {
	return i.ToUserSettingsMapOutputWithContext(context.Background())
}

func (i UserSettingsMap) ToUserSettingsMapOutputWithContext(ctx context.Context) UserSettingsMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(UserSettingsMapOutput)
}

type UserSettingsOutput struct{ *pulumi.OutputState }

func (UserSettingsOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**UserSettings)(nil)).Elem()
}

func (o UserSettingsOutput) ToUserSettingsOutput() UserSettingsOutput {
	return o
}

func (o UserSettingsOutput) ToUserSettingsOutputWithContext(ctx context.Context) UserSettingsOutput {
	return o
}

// Additional encryption context for the user settings.
func (o UserSettingsOutput) AdditionalEncryptionContext() pulumi.StringMapOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringMapOutput { return v.AdditionalEncryptionContext }).(pulumi.StringMapOutput)
}

// List of web portal ARNs to associate with the user settings.
func (o UserSettingsOutput) AssociatedPortalArns() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringArrayOutput { return v.AssociatedPortalArns }).(pulumi.StringArrayOutput)
}

// Configuration that specifies which cookies should be synchronized from the end user's local browser to the remote browser. Detailed below.
func (o UserSettingsOutput) CookieSynchronizationConfiguration() UserSettingsCookieSynchronizationConfigurationPtrOutput {
	return o.ApplyT(func(v *UserSettings) UserSettingsCookieSynchronizationConfigurationPtrOutput {
		return v.CookieSynchronizationConfiguration
	}).(UserSettingsCookieSynchronizationConfigurationPtrOutput)
}

// Specifies whether the user can copy text from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
func (o UserSettingsOutput) CopyAllowed() pulumi.StringOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringOutput { return v.CopyAllowed }).(pulumi.StringOutput)
}

// ARN of the customer managed KMS key.
func (o UserSettingsOutput) CustomerManagedKey() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringPtrOutput { return v.CustomerManagedKey }).(pulumi.StringPtrOutput)
}

// Specifies whether the user can use deep links that open automatically when connecting to a session. Valid values are `Enabled` or `Disabled`.
func (o UserSettingsOutput) DeepLinkAllowed() pulumi.StringOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringOutput { return v.DeepLinkAllowed }).(pulumi.StringOutput)
}

// Amount of time that a streaming session remains active after users disconnect. Value must be between 1 and 600 minutes.
func (o UserSettingsOutput) DisconnectTimeoutInMinutes() pulumi.IntPtrOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.IntPtrOutput { return v.DisconnectTimeoutInMinutes }).(pulumi.IntPtrOutput)
}

// Specifies whether the user can download files from the streaming session to the local device. Valid values are `Enabled` or `Disabled`.
func (o UserSettingsOutput) DownloadAllowed() pulumi.StringOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringOutput { return v.DownloadAllowed }).(pulumi.StringOutput)
}

// Amount of time that users can be idle before they are disconnected from their streaming session. Value must be between 0 and 60 minutes.
func (o UserSettingsOutput) IdleDisconnectTimeoutInMinutes() pulumi.IntPtrOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.IntPtrOutput { return v.IdleDisconnectTimeoutInMinutes }).(pulumi.IntPtrOutput)
}

// Specifies whether the user can paste text from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
func (o UserSettingsOutput) PasteAllowed() pulumi.StringOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringOutput { return v.PasteAllowed }).(pulumi.StringOutput)
}

// Specifies whether the user can print to the local device. Valid values are `Enabled` or `Disabled`.
func (o UserSettingsOutput) PrintAllowed() pulumi.StringOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringOutput { return v.PrintAllowed }).(pulumi.StringOutput)
}

// Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o UserSettingsOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o UserSettingsOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// Configuration of the toolbar. Detailed below.
func (o UserSettingsOutput) ToolbarConfiguration() UserSettingsToolbarConfigurationPtrOutput {
	return o.ApplyT(func(v *UserSettings) UserSettingsToolbarConfigurationPtrOutput { return v.ToolbarConfiguration }).(UserSettingsToolbarConfigurationPtrOutput)
}

// Specifies whether the user can upload files from the local device to the streaming session. Valid values are `Enabled` or `Disabled`.
//
// The following arguments are optional:
func (o UserSettingsOutput) UploadAllowed() pulumi.StringOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringOutput { return v.UploadAllowed }).(pulumi.StringOutput)
}

// ARN of the user settings resource.
func (o UserSettingsOutput) UserSettingsArn() pulumi.StringOutput {
	return o.ApplyT(func(v *UserSettings) pulumi.StringOutput { return v.UserSettingsArn }).(pulumi.StringOutput)
}

type UserSettingsArrayOutput struct{ *pulumi.OutputState }

func (UserSettingsArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*UserSettings)(nil)).Elem()
}

func (o UserSettingsArrayOutput) ToUserSettingsArrayOutput() UserSettingsArrayOutput {
	return o
}

func (o UserSettingsArrayOutput) ToUserSettingsArrayOutputWithContext(ctx context.Context) UserSettingsArrayOutput {
	return o
}

func (o UserSettingsArrayOutput) Index(i pulumi.IntInput) UserSettingsOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *UserSettings {
		return vs[0].([]*UserSettings)[vs[1].(int)]
	}).(UserSettingsOutput)
}

type UserSettingsMapOutput struct{ *pulumi.OutputState }

func (UserSettingsMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*UserSettings)(nil)).Elem()
}

func (o UserSettingsMapOutput) ToUserSettingsMapOutput() UserSettingsMapOutput {
	return o
}

func (o UserSettingsMapOutput) ToUserSettingsMapOutputWithContext(ctx context.Context) UserSettingsMapOutput {
	return o
}

func (o UserSettingsMapOutput) MapIndex(k pulumi.StringInput) UserSettingsOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *UserSettings {
		return vs[0].(map[string]*UserSettings)[vs[1].(string)]
	}).(UserSettingsOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*UserSettingsInput)(nil)).Elem(), &UserSettings{})
	pulumi.RegisterInputType(reflect.TypeOf((*UserSettingsArrayInput)(nil)).Elem(), UserSettingsArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*UserSettingsMapInput)(nil)).Elem(), UserSettingsMap{})
	pulumi.RegisterOutputType(UserSettingsOutput{})
	pulumi.RegisterOutputType(UserSettingsArrayOutput{})
	pulumi.RegisterOutputType(UserSettingsMapOutput{})
}
