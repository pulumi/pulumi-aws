// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package grafana

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Amazon Managed Grafana workspace SAML configuration resource.
//
// ## Example Usage
//
// ### Basic configuration
//
// ```go
// package main
//
// import (
//
//	"encoding/json"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/grafana"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			tmpJSON0, err := json.Marshal(map[string]interface{}{
//				"Version": "2012-10-17",
//				"Statement": []map[string]interface{}{
//					map[string]interface{}{
//						"Action": "sts:AssumeRole",
//						"Effect": "Allow",
//						"Sid":    "",
//						"Principal": map[string]interface{}{
//							"Service": "grafana.amazonaws.com",
//						},
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			json0 := string(tmpJSON0)
//			assume, err := iam.NewRole(ctx, "assume", &iam.RoleArgs{
//				Name:             pulumi.String("grafana-assume"),
//				AssumeRolePolicy: pulumi.String(json0),
//			})
//			if err != nil {
//				return err
//			}
//			exampleWorkspace, err := grafana.NewWorkspace(ctx, "example", &grafana.WorkspaceArgs{
//				AccountAccessType: pulumi.String("CURRENT_ACCOUNT"),
//				AuthenticationProviders: pulumi.StringArray{
//					pulumi.String("SAML"),
//				},
//				PermissionType: pulumi.String("SERVICE_MANAGED"),
//				RoleArn:        assume.Arn,
//			})
//			if err != nil {
//				return err
//			}
//			_, err = grafana.NewWorkspaceSamlConfiguration(ctx, "example", &grafana.WorkspaceSamlConfigurationArgs{
//				EditorRoleValues: pulumi.StringArray{
//					pulumi.String("editor"),
//				},
//				IdpMetadataUrl: pulumi.String("https://my_idp_metadata.url"),
//				WorkspaceId:    exampleWorkspace.ID(),
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
// Using `pulumi import`, import Grafana Workspace SAML configuration using the workspace's `id`. For example:
//
// ```sh
// $ pulumi import aws:grafana/workspaceSamlConfiguration:WorkspaceSamlConfiguration example g-2054c75a02
// ```
type WorkspaceSamlConfiguration struct {
	pulumi.CustomResourceState

	// The admin role values.
	AdminRoleValues pulumi.StringArrayOutput `pulumi:"adminRoleValues"`
	// The allowed organizations.
	AllowedOrganizations pulumi.StringArrayOutput `pulumi:"allowedOrganizations"`
	// The editor role values.
	EditorRoleValues pulumi.StringArrayOutput `pulumi:"editorRoleValues"`
	// The email assertion.
	EmailAssertion pulumi.StringOutput `pulumi:"emailAssertion"`
	// The groups assertion.
	GroupsAssertion pulumi.StringPtrOutput `pulumi:"groupsAssertion"`
	// The IDP Metadata URL. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataUrl pulumi.StringPtrOutput `pulumi:"idpMetadataUrl"`
	// The IDP Metadata XML. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataXml pulumi.StringPtrOutput `pulumi:"idpMetadataXml"`
	// The login assertion.
	LoginAssertion pulumi.StringOutput `pulumi:"loginAssertion"`
	// The login validity duration.
	LoginValidityDuration pulumi.IntOutput `pulumi:"loginValidityDuration"`
	// The name assertion.
	NameAssertion pulumi.StringOutput `pulumi:"nameAssertion"`
	// The org assertion.
	OrgAssertion pulumi.StringPtrOutput `pulumi:"orgAssertion"`
	// The role assertion.
	RoleAssertion pulumi.StringPtrOutput `pulumi:"roleAssertion"`
	// The status of the SAML configuration.
	Status pulumi.StringOutput `pulumi:"status"`
	// The workspace id.
	//
	// The following arguments are optional:
	WorkspaceId pulumi.StringOutput `pulumi:"workspaceId"`
}

// NewWorkspaceSamlConfiguration registers a new resource with the given unique name, arguments, and options.
func NewWorkspaceSamlConfiguration(ctx *pulumi.Context,
	name string, args *WorkspaceSamlConfigurationArgs, opts ...pulumi.ResourceOption) (*WorkspaceSamlConfiguration, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.EditorRoleValues == nil {
		return nil, errors.New("invalid value for required argument 'EditorRoleValues'")
	}
	if args.WorkspaceId == nil {
		return nil, errors.New("invalid value for required argument 'WorkspaceId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource WorkspaceSamlConfiguration
	err := ctx.RegisterResource("aws:grafana/workspaceSamlConfiguration:WorkspaceSamlConfiguration", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetWorkspaceSamlConfiguration gets an existing WorkspaceSamlConfiguration resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetWorkspaceSamlConfiguration(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *WorkspaceSamlConfigurationState, opts ...pulumi.ResourceOption) (*WorkspaceSamlConfiguration, error) {
	var resource WorkspaceSamlConfiguration
	err := ctx.ReadResource("aws:grafana/workspaceSamlConfiguration:WorkspaceSamlConfiguration", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering WorkspaceSamlConfiguration resources.
type workspaceSamlConfigurationState struct {
	// The admin role values.
	AdminRoleValues []string `pulumi:"adminRoleValues"`
	// The allowed organizations.
	AllowedOrganizations []string `pulumi:"allowedOrganizations"`
	// The editor role values.
	EditorRoleValues []string `pulumi:"editorRoleValues"`
	// The email assertion.
	EmailAssertion *string `pulumi:"emailAssertion"`
	// The groups assertion.
	GroupsAssertion *string `pulumi:"groupsAssertion"`
	// The IDP Metadata URL. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataUrl *string `pulumi:"idpMetadataUrl"`
	// The IDP Metadata XML. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataXml *string `pulumi:"idpMetadataXml"`
	// The login assertion.
	LoginAssertion *string `pulumi:"loginAssertion"`
	// The login validity duration.
	LoginValidityDuration *int `pulumi:"loginValidityDuration"`
	// The name assertion.
	NameAssertion *string `pulumi:"nameAssertion"`
	// The org assertion.
	OrgAssertion *string `pulumi:"orgAssertion"`
	// The role assertion.
	RoleAssertion *string `pulumi:"roleAssertion"`
	// The status of the SAML configuration.
	Status *string `pulumi:"status"`
	// The workspace id.
	//
	// The following arguments are optional:
	WorkspaceId *string `pulumi:"workspaceId"`
}

type WorkspaceSamlConfigurationState struct {
	// The admin role values.
	AdminRoleValues pulumi.StringArrayInput
	// The allowed organizations.
	AllowedOrganizations pulumi.StringArrayInput
	// The editor role values.
	EditorRoleValues pulumi.StringArrayInput
	// The email assertion.
	EmailAssertion pulumi.StringPtrInput
	// The groups assertion.
	GroupsAssertion pulumi.StringPtrInput
	// The IDP Metadata URL. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataUrl pulumi.StringPtrInput
	// The IDP Metadata XML. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataXml pulumi.StringPtrInput
	// The login assertion.
	LoginAssertion pulumi.StringPtrInput
	// The login validity duration.
	LoginValidityDuration pulumi.IntPtrInput
	// The name assertion.
	NameAssertion pulumi.StringPtrInput
	// The org assertion.
	OrgAssertion pulumi.StringPtrInput
	// The role assertion.
	RoleAssertion pulumi.StringPtrInput
	// The status of the SAML configuration.
	Status pulumi.StringPtrInput
	// The workspace id.
	//
	// The following arguments are optional:
	WorkspaceId pulumi.StringPtrInput
}

func (WorkspaceSamlConfigurationState) ElementType() reflect.Type {
	return reflect.TypeOf((*workspaceSamlConfigurationState)(nil)).Elem()
}

type workspaceSamlConfigurationArgs struct {
	// The admin role values.
	AdminRoleValues []string `pulumi:"adminRoleValues"`
	// The allowed organizations.
	AllowedOrganizations []string `pulumi:"allowedOrganizations"`
	// The editor role values.
	EditorRoleValues []string `pulumi:"editorRoleValues"`
	// The email assertion.
	EmailAssertion *string `pulumi:"emailAssertion"`
	// The groups assertion.
	GroupsAssertion *string `pulumi:"groupsAssertion"`
	// The IDP Metadata URL. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataUrl *string `pulumi:"idpMetadataUrl"`
	// The IDP Metadata XML. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataXml *string `pulumi:"idpMetadataXml"`
	// The login assertion.
	LoginAssertion *string `pulumi:"loginAssertion"`
	// The login validity duration.
	LoginValidityDuration *int `pulumi:"loginValidityDuration"`
	// The name assertion.
	NameAssertion *string `pulumi:"nameAssertion"`
	// The org assertion.
	OrgAssertion *string `pulumi:"orgAssertion"`
	// The role assertion.
	RoleAssertion *string `pulumi:"roleAssertion"`
	// The workspace id.
	//
	// The following arguments are optional:
	WorkspaceId string `pulumi:"workspaceId"`
}

// The set of arguments for constructing a WorkspaceSamlConfiguration resource.
type WorkspaceSamlConfigurationArgs struct {
	// The admin role values.
	AdminRoleValues pulumi.StringArrayInput
	// The allowed organizations.
	AllowedOrganizations pulumi.StringArrayInput
	// The editor role values.
	EditorRoleValues pulumi.StringArrayInput
	// The email assertion.
	EmailAssertion pulumi.StringPtrInput
	// The groups assertion.
	GroupsAssertion pulumi.StringPtrInput
	// The IDP Metadata URL. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataUrl pulumi.StringPtrInput
	// The IDP Metadata XML. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
	IdpMetadataXml pulumi.StringPtrInput
	// The login assertion.
	LoginAssertion pulumi.StringPtrInput
	// The login validity duration.
	LoginValidityDuration pulumi.IntPtrInput
	// The name assertion.
	NameAssertion pulumi.StringPtrInput
	// The org assertion.
	OrgAssertion pulumi.StringPtrInput
	// The role assertion.
	RoleAssertion pulumi.StringPtrInput
	// The workspace id.
	//
	// The following arguments are optional:
	WorkspaceId pulumi.StringInput
}

func (WorkspaceSamlConfigurationArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*workspaceSamlConfigurationArgs)(nil)).Elem()
}

type WorkspaceSamlConfigurationInput interface {
	pulumi.Input

	ToWorkspaceSamlConfigurationOutput() WorkspaceSamlConfigurationOutput
	ToWorkspaceSamlConfigurationOutputWithContext(ctx context.Context) WorkspaceSamlConfigurationOutput
}

func (*WorkspaceSamlConfiguration) ElementType() reflect.Type {
	return reflect.TypeOf((**WorkspaceSamlConfiguration)(nil)).Elem()
}

func (i *WorkspaceSamlConfiguration) ToWorkspaceSamlConfigurationOutput() WorkspaceSamlConfigurationOutput {
	return i.ToWorkspaceSamlConfigurationOutputWithContext(context.Background())
}

func (i *WorkspaceSamlConfiguration) ToWorkspaceSamlConfigurationOutputWithContext(ctx context.Context) WorkspaceSamlConfigurationOutput {
	return pulumi.ToOutputWithContext(ctx, i).(WorkspaceSamlConfigurationOutput)
}

// WorkspaceSamlConfigurationArrayInput is an input type that accepts WorkspaceSamlConfigurationArray and WorkspaceSamlConfigurationArrayOutput values.
// You can construct a concrete instance of `WorkspaceSamlConfigurationArrayInput` via:
//
//	WorkspaceSamlConfigurationArray{ WorkspaceSamlConfigurationArgs{...} }
type WorkspaceSamlConfigurationArrayInput interface {
	pulumi.Input

	ToWorkspaceSamlConfigurationArrayOutput() WorkspaceSamlConfigurationArrayOutput
	ToWorkspaceSamlConfigurationArrayOutputWithContext(context.Context) WorkspaceSamlConfigurationArrayOutput
}

type WorkspaceSamlConfigurationArray []WorkspaceSamlConfigurationInput

func (WorkspaceSamlConfigurationArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*WorkspaceSamlConfiguration)(nil)).Elem()
}

func (i WorkspaceSamlConfigurationArray) ToWorkspaceSamlConfigurationArrayOutput() WorkspaceSamlConfigurationArrayOutput {
	return i.ToWorkspaceSamlConfigurationArrayOutputWithContext(context.Background())
}

func (i WorkspaceSamlConfigurationArray) ToWorkspaceSamlConfigurationArrayOutputWithContext(ctx context.Context) WorkspaceSamlConfigurationArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(WorkspaceSamlConfigurationArrayOutput)
}

// WorkspaceSamlConfigurationMapInput is an input type that accepts WorkspaceSamlConfigurationMap and WorkspaceSamlConfigurationMapOutput values.
// You can construct a concrete instance of `WorkspaceSamlConfigurationMapInput` via:
//
//	WorkspaceSamlConfigurationMap{ "key": WorkspaceSamlConfigurationArgs{...} }
type WorkspaceSamlConfigurationMapInput interface {
	pulumi.Input

	ToWorkspaceSamlConfigurationMapOutput() WorkspaceSamlConfigurationMapOutput
	ToWorkspaceSamlConfigurationMapOutputWithContext(context.Context) WorkspaceSamlConfigurationMapOutput
}

type WorkspaceSamlConfigurationMap map[string]WorkspaceSamlConfigurationInput

func (WorkspaceSamlConfigurationMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*WorkspaceSamlConfiguration)(nil)).Elem()
}

func (i WorkspaceSamlConfigurationMap) ToWorkspaceSamlConfigurationMapOutput() WorkspaceSamlConfigurationMapOutput {
	return i.ToWorkspaceSamlConfigurationMapOutputWithContext(context.Background())
}

func (i WorkspaceSamlConfigurationMap) ToWorkspaceSamlConfigurationMapOutputWithContext(ctx context.Context) WorkspaceSamlConfigurationMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(WorkspaceSamlConfigurationMapOutput)
}

type WorkspaceSamlConfigurationOutput struct{ *pulumi.OutputState }

func (WorkspaceSamlConfigurationOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**WorkspaceSamlConfiguration)(nil)).Elem()
}

func (o WorkspaceSamlConfigurationOutput) ToWorkspaceSamlConfigurationOutput() WorkspaceSamlConfigurationOutput {
	return o
}

func (o WorkspaceSamlConfigurationOutput) ToWorkspaceSamlConfigurationOutputWithContext(ctx context.Context) WorkspaceSamlConfigurationOutput {
	return o
}

// The admin role values.
func (o WorkspaceSamlConfigurationOutput) AdminRoleValues() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringArrayOutput { return v.AdminRoleValues }).(pulumi.StringArrayOutput)
}

// The allowed organizations.
func (o WorkspaceSamlConfigurationOutput) AllowedOrganizations() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringArrayOutput { return v.AllowedOrganizations }).(pulumi.StringArrayOutput)
}

// The editor role values.
func (o WorkspaceSamlConfigurationOutput) EditorRoleValues() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringArrayOutput { return v.EditorRoleValues }).(pulumi.StringArrayOutput)
}

// The email assertion.
func (o WorkspaceSamlConfigurationOutput) EmailAssertion() pulumi.StringOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringOutput { return v.EmailAssertion }).(pulumi.StringOutput)
}

// The groups assertion.
func (o WorkspaceSamlConfigurationOutput) GroupsAssertion() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringPtrOutput { return v.GroupsAssertion }).(pulumi.StringPtrOutput)
}

// The IDP Metadata URL. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
func (o WorkspaceSamlConfigurationOutput) IdpMetadataUrl() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringPtrOutput { return v.IdpMetadataUrl }).(pulumi.StringPtrOutput)
}

// The IDP Metadata XML. Note that either `idpMetadataUrl` or `idpMetadataXml` (but not both) must be specified.
func (o WorkspaceSamlConfigurationOutput) IdpMetadataXml() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringPtrOutput { return v.IdpMetadataXml }).(pulumi.StringPtrOutput)
}

// The login assertion.
func (o WorkspaceSamlConfigurationOutput) LoginAssertion() pulumi.StringOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringOutput { return v.LoginAssertion }).(pulumi.StringOutput)
}

// The login validity duration.
func (o WorkspaceSamlConfigurationOutput) LoginValidityDuration() pulumi.IntOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.IntOutput { return v.LoginValidityDuration }).(pulumi.IntOutput)
}

// The name assertion.
func (o WorkspaceSamlConfigurationOutput) NameAssertion() pulumi.StringOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringOutput { return v.NameAssertion }).(pulumi.StringOutput)
}

// The org assertion.
func (o WorkspaceSamlConfigurationOutput) OrgAssertion() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringPtrOutput { return v.OrgAssertion }).(pulumi.StringPtrOutput)
}

// The role assertion.
func (o WorkspaceSamlConfigurationOutput) RoleAssertion() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringPtrOutput { return v.RoleAssertion }).(pulumi.StringPtrOutput)
}

// The status of the SAML configuration.
func (o WorkspaceSamlConfigurationOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringOutput { return v.Status }).(pulumi.StringOutput)
}

// The workspace id.
//
// The following arguments are optional:
func (o WorkspaceSamlConfigurationOutput) WorkspaceId() pulumi.StringOutput {
	return o.ApplyT(func(v *WorkspaceSamlConfiguration) pulumi.StringOutput { return v.WorkspaceId }).(pulumi.StringOutput)
}

type WorkspaceSamlConfigurationArrayOutput struct{ *pulumi.OutputState }

func (WorkspaceSamlConfigurationArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*WorkspaceSamlConfiguration)(nil)).Elem()
}

func (o WorkspaceSamlConfigurationArrayOutput) ToWorkspaceSamlConfigurationArrayOutput() WorkspaceSamlConfigurationArrayOutput {
	return o
}

func (o WorkspaceSamlConfigurationArrayOutput) ToWorkspaceSamlConfigurationArrayOutputWithContext(ctx context.Context) WorkspaceSamlConfigurationArrayOutput {
	return o
}

func (o WorkspaceSamlConfigurationArrayOutput) Index(i pulumi.IntInput) WorkspaceSamlConfigurationOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *WorkspaceSamlConfiguration {
		return vs[0].([]*WorkspaceSamlConfiguration)[vs[1].(int)]
	}).(WorkspaceSamlConfigurationOutput)
}

type WorkspaceSamlConfigurationMapOutput struct{ *pulumi.OutputState }

func (WorkspaceSamlConfigurationMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*WorkspaceSamlConfiguration)(nil)).Elem()
}

func (o WorkspaceSamlConfigurationMapOutput) ToWorkspaceSamlConfigurationMapOutput() WorkspaceSamlConfigurationMapOutput {
	return o
}

func (o WorkspaceSamlConfigurationMapOutput) ToWorkspaceSamlConfigurationMapOutputWithContext(ctx context.Context) WorkspaceSamlConfigurationMapOutput {
	return o
}

func (o WorkspaceSamlConfigurationMapOutput) MapIndex(k pulumi.StringInput) WorkspaceSamlConfigurationOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *WorkspaceSamlConfiguration {
		return vs[0].(map[string]*WorkspaceSamlConfiguration)[vs[1].(string)]
	}).(WorkspaceSamlConfigurationOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*WorkspaceSamlConfigurationInput)(nil)).Elem(), &WorkspaceSamlConfiguration{})
	pulumi.RegisterInputType(reflect.TypeOf((*WorkspaceSamlConfigurationArrayInput)(nil)).Elem(), WorkspaceSamlConfigurationArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*WorkspaceSamlConfigurationMapInput)(nil)).Elem(), WorkspaceSamlConfigurationMap{})
	pulumi.RegisterOutputType(WorkspaceSamlConfigurationOutput{})
	pulumi.RegisterOutputType(WorkspaceSamlConfigurationArrayOutput{})
	pulumi.RegisterOutputType(WorkspaceSamlConfigurationMapOutput{})
}
