// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package fsx

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Retrieve information on FSx Windows File System.
//
// ## Example Usage
//
// ### Root volume Example
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/fsx"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := fsx.LookupWindowsFileSystem(ctx, &fsx.LookupWindowsFileSystemArgs{
//				Id: "fs-12345678",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupWindowsFileSystem(ctx *pulumi.Context, args *LookupWindowsFileSystemArgs, opts ...pulumi.InvokeOption) (*LookupWindowsFileSystemResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupWindowsFileSystemResult
	err := ctx.Invoke("aws:fsx/getWindowsFileSystem:getWindowsFileSystem", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getWindowsFileSystem.
type LookupWindowsFileSystemArgs struct {
	// Identifier of the file system (e.g. `fs-12345678`).
	Id string `pulumi:"id"`
	// The tags to associate with the file system.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getWindowsFileSystem.
type LookupWindowsFileSystemResult struct {
	// The ID for Microsoft Active Directory instance that the file system is join to.
	ActiveDirectoryId string `pulumi:"activeDirectoryId"`
	// An array DNS alias names associated with the Amazon FSx file system.
	Aliases []string `pulumi:"aliases"`
	// Amazon Resource Name of the file system.
	Arn string `pulumi:"arn"`
	// The configuration that Amazon FSx for Windows File Server uses to audit and log user accesses of files, folders, and file shares on the Amazon FSx for Windows File Server file system.
	AuditLogConfigurations []GetWindowsFileSystemAuditLogConfiguration `pulumi:"auditLogConfigurations"`
	// The number of days to retain automatic backups.
	AutomaticBackupRetentionDays int    `pulumi:"automaticBackupRetentionDays"`
	BackupId                     string `pulumi:"backupId"`
	// A boolean flag indicating whether tags on the file system should be copied to backups.
	CopyTagsToBackups bool `pulumi:"copyTagsToBackups"`
	// The preferred time (in `HH:MM` format) to take daily automatic backups, in the UTC time zone.
	DailyAutomaticBackupStartTime string `pulumi:"dailyAutomaticBackupStartTime"`
	// The file system deployment type.
	DeploymentType string `pulumi:"deploymentType"`
	// The SSD IOPS configuration for the file system.
	DiskIopsConfigurations []GetWindowsFileSystemDiskIopsConfiguration `pulumi:"diskIopsConfigurations"`
	// DNS name for the file system (e.g. `fs-12345678.corp.example.com`).
	DnsName string `pulumi:"dnsName"`
	// Identifier of the file system (e.g. `fs-12345678`).
	Id string `pulumi:"id"`
	// ARN for the KMS Key to encrypt the file system at rest.
	KmsKeyId            string   `pulumi:"kmsKeyId"`
	NetworkInterfaceIds []string `pulumi:"networkInterfaceIds"`
	// AWS account identifier that created the file system.
	OwnerId string `pulumi:"ownerId"`
	// The IP address of the primary, or preferred, file server.
	PreferredFileServerIp string `pulumi:"preferredFileServerIp"`
	// Specifies the subnet in which you want the preferred file server to be located.
	PreferredSubnetId string   `pulumi:"preferredSubnetId"`
	SecurityGroupIds  []string `pulumi:"securityGroupIds"`
	SkipFinalBackup   bool     `pulumi:"skipFinalBackup"`
	// The storage capacity of the file system in gibibytes (GiB).
	StorageCapacity int `pulumi:"storageCapacity"`
	// The type of storage the file system is using. If set to `SSD`, the file system uses solid state drive storage. If set to `HDD`, the file system uses hard disk drive storage.
	StorageType string `pulumi:"storageType"`
	// Specifies the IDs of the subnets that the file system is accessible from.
	SubnetIds []string `pulumi:"subnetIds"`
	// The tags to associate with the file system.
	Tags map[string]string `pulumi:"tags"`
	// Throughput (megabytes per second) of the file system in power of 2 increments. Minimum of `8` and maximum of `2048`.
	ThroughputCapacity int `pulumi:"throughputCapacity"`
	// The ID of the primary virtual private cloud (VPC) for the file system.
	VpcId string `pulumi:"vpcId"`
	// The preferred start time (in `d:HH:MM` format) to perform weekly maintenance, in the UTC time zone.
	WeeklyMaintenanceStartTime string `pulumi:"weeklyMaintenanceStartTime"`
}

func LookupWindowsFileSystemOutput(ctx *pulumi.Context, args LookupWindowsFileSystemOutputArgs, opts ...pulumi.InvokeOption) LookupWindowsFileSystemResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupWindowsFileSystemResultOutput, error) {
			args := v.(LookupWindowsFileSystemArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:fsx/getWindowsFileSystem:getWindowsFileSystem", args, LookupWindowsFileSystemResultOutput{}, options).(LookupWindowsFileSystemResultOutput), nil
		}).(LookupWindowsFileSystemResultOutput)
}

// A collection of arguments for invoking getWindowsFileSystem.
type LookupWindowsFileSystemOutputArgs struct {
	// Identifier of the file system (e.g. `fs-12345678`).
	Id pulumi.StringInput `pulumi:"id"`
	// The tags to associate with the file system.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupWindowsFileSystemOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupWindowsFileSystemArgs)(nil)).Elem()
}

// A collection of values returned by getWindowsFileSystem.
type LookupWindowsFileSystemResultOutput struct{ *pulumi.OutputState }

func (LookupWindowsFileSystemResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupWindowsFileSystemResult)(nil)).Elem()
}

func (o LookupWindowsFileSystemResultOutput) ToLookupWindowsFileSystemResultOutput() LookupWindowsFileSystemResultOutput {
	return o
}

func (o LookupWindowsFileSystemResultOutput) ToLookupWindowsFileSystemResultOutputWithContext(ctx context.Context) LookupWindowsFileSystemResultOutput {
	return o
}

// The ID for Microsoft Active Directory instance that the file system is join to.
func (o LookupWindowsFileSystemResultOutput) ActiveDirectoryId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.ActiveDirectoryId }).(pulumi.StringOutput)
}

// An array DNS alias names associated with the Amazon FSx file system.
func (o LookupWindowsFileSystemResultOutput) Aliases() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) []string { return v.Aliases }).(pulumi.StringArrayOutput)
}

// Amazon Resource Name of the file system.
func (o LookupWindowsFileSystemResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.Arn }).(pulumi.StringOutput)
}

// The configuration that Amazon FSx for Windows File Server uses to audit and log user accesses of files, folders, and file shares on the Amazon FSx for Windows File Server file system.
func (o LookupWindowsFileSystemResultOutput) AuditLogConfigurations() GetWindowsFileSystemAuditLogConfigurationArrayOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) []GetWindowsFileSystemAuditLogConfiguration {
		return v.AuditLogConfigurations
	}).(GetWindowsFileSystemAuditLogConfigurationArrayOutput)
}

// The number of days to retain automatic backups.
func (o LookupWindowsFileSystemResultOutput) AutomaticBackupRetentionDays() pulumi.IntOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) int { return v.AutomaticBackupRetentionDays }).(pulumi.IntOutput)
}

func (o LookupWindowsFileSystemResultOutput) BackupId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.BackupId }).(pulumi.StringOutput)
}

// A boolean flag indicating whether tags on the file system should be copied to backups.
func (o LookupWindowsFileSystemResultOutput) CopyTagsToBackups() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) bool { return v.CopyTagsToBackups }).(pulumi.BoolOutput)
}

// The preferred time (in `HH:MM` format) to take daily automatic backups, in the UTC time zone.
func (o LookupWindowsFileSystemResultOutput) DailyAutomaticBackupStartTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.DailyAutomaticBackupStartTime }).(pulumi.StringOutput)
}

// The file system deployment type.
func (o LookupWindowsFileSystemResultOutput) DeploymentType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.DeploymentType }).(pulumi.StringOutput)
}

// The SSD IOPS configuration for the file system.
func (o LookupWindowsFileSystemResultOutput) DiskIopsConfigurations() GetWindowsFileSystemDiskIopsConfigurationArrayOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) []GetWindowsFileSystemDiskIopsConfiguration {
		return v.DiskIopsConfigurations
	}).(GetWindowsFileSystemDiskIopsConfigurationArrayOutput)
}

// DNS name for the file system (e.g. `fs-12345678.corp.example.com`).
func (o LookupWindowsFileSystemResultOutput) DnsName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.DnsName }).(pulumi.StringOutput)
}

// Identifier of the file system (e.g. `fs-12345678`).
func (o LookupWindowsFileSystemResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.Id }).(pulumi.StringOutput)
}

// ARN for the KMS Key to encrypt the file system at rest.
func (o LookupWindowsFileSystemResultOutput) KmsKeyId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.KmsKeyId }).(pulumi.StringOutput)
}

func (o LookupWindowsFileSystemResultOutput) NetworkInterfaceIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) []string { return v.NetworkInterfaceIds }).(pulumi.StringArrayOutput)
}

// AWS account identifier that created the file system.
func (o LookupWindowsFileSystemResultOutput) OwnerId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.OwnerId }).(pulumi.StringOutput)
}

// The IP address of the primary, or preferred, file server.
func (o LookupWindowsFileSystemResultOutput) PreferredFileServerIp() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.PreferredFileServerIp }).(pulumi.StringOutput)
}

// Specifies the subnet in which you want the preferred file server to be located.
func (o LookupWindowsFileSystemResultOutput) PreferredSubnetId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.PreferredSubnetId }).(pulumi.StringOutput)
}

func (o LookupWindowsFileSystemResultOutput) SecurityGroupIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) []string { return v.SecurityGroupIds }).(pulumi.StringArrayOutput)
}

func (o LookupWindowsFileSystemResultOutput) SkipFinalBackup() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) bool { return v.SkipFinalBackup }).(pulumi.BoolOutput)
}

// The storage capacity of the file system in gibibytes (GiB).
func (o LookupWindowsFileSystemResultOutput) StorageCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) int { return v.StorageCapacity }).(pulumi.IntOutput)
}

// The type of storage the file system is using. If set to `SSD`, the file system uses solid state drive storage. If set to `HDD`, the file system uses hard disk drive storage.
func (o LookupWindowsFileSystemResultOutput) StorageType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.StorageType }).(pulumi.StringOutput)
}

// Specifies the IDs of the subnets that the file system is accessible from.
func (o LookupWindowsFileSystemResultOutput) SubnetIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) []string { return v.SubnetIds }).(pulumi.StringArrayOutput)
}

// The tags to associate with the file system.
func (o LookupWindowsFileSystemResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// Throughput (megabytes per second) of the file system in power of 2 increments. Minimum of `8` and maximum of `2048`.
func (o LookupWindowsFileSystemResultOutput) ThroughputCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) int { return v.ThroughputCapacity }).(pulumi.IntOutput)
}

// The ID of the primary virtual private cloud (VPC) for the file system.
func (o LookupWindowsFileSystemResultOutput) VpcId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.VpcId }).(pulumi.StringOutput)
}

// The preferred start time (in `d:HH:MM` format) to perform weekly maintenance, in the UTC time zone.
func (o LookupWindowsFileSystemResultOutput) WeeklyMaintenanceStartTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupWindowsFileSystemResult) string { return v.WeeklyMaintenanceStartTime }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupWindowsFileSystemResultOutput{})
}
