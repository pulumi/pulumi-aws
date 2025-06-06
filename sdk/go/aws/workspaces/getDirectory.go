// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package workspaces

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Retrieve information about an AWS WorkSpaces directory.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/workspaces"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := workspaces.LookupDirectory(ctx, &workspaces.LookupDirectoryArgs{
//				DirectoryId: "d-9067783251",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupDirectory(ctx *pulumi.Context, args *LookupDirectoryArgs, opts ...pulumi.InvokeOption) (*LookupDirectoryResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupDirectoryResult
	err := ctx.Invoke("aws:workspaces/getDirectory:getDirectory", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getDirectory.
type LookupDirectoryArgs struct {
	// Directory identifier for registration in WorkSpaces service.
	DirectoryId string `pulumi:"directoryId"`
	// A map of tags assigned to the WorkSpaces directory.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getDirectory.
type LookupDirectoryResult struct {
	// Configuration for Active Directory integration when `workspaceType` is set to `POOLS`.
	ActiveDirectoryConfigs []GetDirectoryActiveDirectoryConfig `pulumi:"activeDirectoryConfigs"`
	// Directory alias.
	Alias                          string                                     `pulumi:"alias"`
	CertificateBasedAuthProperties []GetDirectoryCertificateBasedAuthProperty `pulumi:"certificateBasedAuthProperties"`
	// User name for the service account.
	CustomerUserName string `pulumi:"customerUserName"`
	DirectoryId      string `pulumi:"directoryId"`
	// Name of the directory.
	DirectoryName string `pulumi:"directoryName"`
	// Directory type.
	DirectoryType string `pulumi:"directoryType"`
	// IP addresses of the DNS servers for the directory.
	DnsIpAddresses []string `pulumi:"dnsIpAddresses"`
	// Identifier of the IAM role. This is the role that allows Amazon WorkSpaces to make calls to other services, such as Amazon EC2, on your behalf.
	IamRoleId string `pulumi:"iamRoleId"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Identifiers of the IP access control groups associated with the directory.
	IpGroupIds []string `pulumi:"ipGroupIds"`
	// Registration code for the directory. This is the code that users enter in their Amazon WorkSpaces client application to connect to the directory.
	RegistrationCode string                     `pulumi:"registrationCode"`
	SamlProperties   []GetDirectorySamlProperty `pulumi:"samlProperties"`
	// The permissions to enable or disable self-service capabilities.
	SelfServicePermissions []GetDirectorySelfServicePermission `pulumi:"selfServicePermissions"`
	// Identifiers of the subnets where the directory resides.
	SubnetIds []string `pulumi:"subnetIds"`
	// A map of tags assigned to the WorkSpaces directory.
	Tags map[string]string `pulumi:"tags"`
	// The user identity type for the WorkSpaces directory.
	UserIdentityType string `pulumi:"userIdentityType"`
	// Specifies which devices and operating systems users can use to access their WorkSpaces.
	WorkspaceAccessProperties []GetDirectoryWorkspaceAccessProperty `pulumi:"workspaceAccessProperties"`
	// The default properties that are used for creating WorkSpaces.
	WorkspaceCreationProperties []GetDirectoryWorkspaceCreationProperty `pulumi:"workspaceCreationProperties"`
	// The description of the WorkSpaces directory when `workspaceType` is set to `POOLS`.
	WorkspaceDirectoryDescription string `pulumi:"workspaceDirectoryDescription"`
	// The name of the WorkSpaces directory when `workspaceType` is set to `POOLS`.
	WorkspaceDirectoryName string `pulumi:"workspaceDirectoryName"`
	// The identifier of the security group that is assigned to new WorkSpaces.
	WorkspaceSecurityGroupId string `pulumi:"workspaceSecurityGroupId"`
	// The type of WorkSpaces directory.
	WorkspaceType string `pulumi:"workspaceType"`
}

func LookupDirectoryOutput(ctx *pulumi.Context, args LookupDirectoryOutputArgs, opts ...pulumi.InvokeOption) LookupDirectoryResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupDirectoryResultOutput, error) {
			args := v.(LookupDirectoryArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:workspaces/getDirectory:getDirectory", args, LookupDirectoryResultOutput{}, options).(LookupDirectoryResultOutput), nil
		}).(LookupDirectoryResultOutput)
}

// A collection of arguments for invoking getDirectory.
type LookupDirectoryOutputArgs struct {
	// Directory identifier for registration in WorkSpaces service.
	DirectoryId pulumi.StringInput `pulumi:"directoryId"`
	// A map of tags assigned to the WorkSpaces directory.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupDirectoryOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupDirectoryArgs)(nil)).Elem()
}

// A collection of values returned by getDirectory.
type LookupDirectoryResultOutput struct{ *pulumi.OutputState }

func (LookupDirectoryResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupDirectoryResult)(nil)).Elem()
}

func (o LookupDirectoryResultOutput) ToLookupDirectoryResultOutput() LookupDirectoryResultOutput {
	return o
}

func (o LookupDirectoryResultOutput) ToLookupDirectoryResultOutputWithContext(ctx context.Context) LookupDirectoryResultOutput {
	return o
}

// Configuration for Active Directory integration when `workspaceType` is set to `POOLS`.
func (o LookupDirectoryResultOutput) ActiveDirectoryConfigs() GetDirectoryActiveDirectoryConfigArrayOutput {
	return o.ApplyT(func(v LookupDirectoryResult) []GetDirectoryActiveDirectoryConfig { return v.ActiveDirectoryConfigs }).(GetDirectoryActiveDirectoryConfigArrayOutput)
}

// Directory alias.
func (o LookupDirectoryResultOutput) Alias() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.Alias }).(pulumi.StringOutput)
}

func (o LookupDirectoryResultOutput) CertificateBasedAuthProperties() GetDirectoryCertificateBasedAuthPropertyArrayOutput {
	return o.ApplyT(func(v LookupDirectoryResult) []GetDirectoryCertificateBasedAuthProperty {
		return v.CertificateBasedAuthProperties
	}).(GetDirectoryCertificateBasedAuthPropertyArrayOutput)
}

// User name for the service account.
func (o LookupDirectoryResultOutput) CustomerUserName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.CustomerUserName }).(pulumi.StringOutput)
}

func (o LookupDirectoryResultOutput) DirectoryId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.DirectoryId }).(pulumi.StringOutput)
}

// Name of the directory.
func (o LookupDirectoryResultOutput) DirectoryName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.DirectoryName }).(pulumi.StringOutput)
}

// Directory type.
func (o LookupDirectoryResultOutput) DirectoryType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.DirectoryType }).(pulumi.StringOutput)
}

// IP addresses of the DNS servers for the directory.
func (o LookupDirectoryResultOutput) DnsIpAddresses() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupDirectoryResult) []string { return v.DnsIpAddresses }).(pulumi.StringArrayOutput)
}

// Identifier of the IAM role. This is the role that allows Amazon WorkSpaces to make calls to other services, such as Amazon EC2, on your behalf.
func (o LookupDirectoryResultOutput) IamRoleId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.IamRoleId }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupDirectoryResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.Id }).(pulumi.StringOutput)
}

// Identifiers of the IP access control groups associated with the directory.
func (o LookupDirectoryResultOutput) IpGroupIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupDirectoryResult) []string { return v.IpGroupIds }).(pulumi.StringArrayOutput)
}

// Registration code for the directory. This is the code that users enter in their Amazon WorkSpaces client application to connect to the directory.
func (o LookupDirectoryResultOutput) RegistrationCode() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.RegistrationCode }).(pulumi.StringOutput)
}

func (o LookupDirectoryResultOutput) SamlProperties() GetDirectorySamlPropertyArrayOutput {
	return o.ApplyT(func(v LookupDirectoryResult) []GetDirectorySamlProperty { return v.SamlProperties }).(GetDirectorySamlPropertyArrayOutput)
}

// The permissions to enable or disable self-service capabilities.
func (o LookupDirectoryResultOutput) SelfServicePermissions() GetDirectorySelfServicePermissionArrayOutput {
	return o.ApplyT(func(v LookupDirectoryResult) []GetDirectorySelfServicePermission { return v.SelfServicePermissions }).(GetDirectorySelfServicePermissionArrayOutput)
}

// Identifiers of the subnets where the directory resides.
func (o LookupDirectoryResultOutput) SubnetIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupDirectoryResult) []string { return v.SubnetIds }).(pulumi.StringArrayOutput)
}

// A map of tags assigned to the WorkSpaces directory.
func (o LookupDirectoryResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupDirectoryResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// The user identity type for the WorkSpaces directory.
func (o LookupDirectoryResultOutput) UserIdentityType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.UserIdentityType }).(pulumi.StringOutput)
}

// Specifies which devices and operating systems users can use to access their WorkSpaces.
func (o LookupDirectoryResultOutput) WorkspaceAccessProperties() GetDirectoryWorkspaceAccessPropertyArrayOutput {
	return o.ApplyT(func(v LookupDirectoryResult) []GetDirectoryWorkspaceAccessProperty {
		return v.WorkspaceAccessProperties
	}).(GetDirectoryWorkspaceAccessPropertyArrayOutput)
}

// The default properties that are used for creating WorkSpaces.
func (o LookupDirectoryResultOutput) WorkspaceCreationProperties() GetDirectoryWorkspaceCreationPropertyArrayOutput {
	return o.ApplyT(func(v LookupDirectoryResult) []GetDirectoryWorkspaceCreationProperty {
		return v.WorkspaceCreationProperties
	}).(GetDirectoryWorkspaceCreationPropertyArrayOutput)
}

// The description of the WorkSpaces directory when `workspaceType` is set to `POOLS`.
func (o LookupDirectoryResultOutput) WorkspaceDirectoryDescription() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.WorkspaceDirectoryDescription }).(pulumi.StringOutput)
}

// The name of the WorkSpaces directory when `workspaceType` is set to `POOLS`.
func (o LookupDirectoryResultOutput) WorkspaceDirectoryName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.WorkspaceDirectoryName }).(pulumi.StringOutput)
}

// The identifier of the security group that is assigned to new WorkSpaces.
func (o LookupDirectoryResultOutput) WorkspaceSecurityGroupId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.WorkspaceSecurityGroupId }).(pulumi.StringOutput)
}

// The type of WorkSpaces directory.
func (o LookupDirectoryResultOutput) WorkspaceType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDirectoryResult) string { return v.WorkspaceType }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupDirectoryResultOutput{})
}
