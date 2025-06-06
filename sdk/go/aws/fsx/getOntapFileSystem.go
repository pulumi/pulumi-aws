// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package fsx

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Retrieve information on FSx ONTAP File System.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/fsx"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := fsx.LookupOntapFileSystem(ctx, &fsx.LookupOntapFileSystemArgs{
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
func LookupOntapFileSystem(ctx *pulumi.Context, args *LookupOntapFileSystemArgs, opts ...pulumi.InvokeOption) (*LookupOntapFileSystemResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupOntapFileSystemResult
	err := ctx.Invoke("aws:fsx/getOntapFileSystem:getOntapFileSystem", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getOntapFileSystem.
type LookupOntapFileSystemArgs struct {
	// Identifier of the file system (e.g. `fs-12345678`).
	Id string `pulumi:"id"`
	// The tags associated with the file system.
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getOntapFileSystem.
type LookupOntapFileSystemResult struct {
	// Amazon Resource Name of the file system.
	Arn string `pulumi:"arn"`
	// The number of days to retain automatic backups.
	AutomaticBackupRetentionDays int `pulumi:"automaticBackupRetentionDays"`
	// The preferred time (in `HH:MM` format) to take daily automatic backups, in the UTC time zone.
	DailyAutomaticBackupStartTime string `pulumi:"dailyAutomaticBackupStartTime"`
	// The file system deployment type.
	DeploymentType string `pulumi:"deploymentType"`
	// The SSD IOPS configuration for the Amazon FSx for NetApp ONTAP file system, specifying the number of provisioned IOPS and the provision mode. See Disk IOPS Below.
	DiskIopsConfigurations []GetOntapFileSystemDiskIopsConfiguration `pulumi:"diskIopsConfigurations"`
	// DNS name for the file system.
	DnsName string `pulumi:"dnsName"`
	// (Multi-AZ only) Specifies the IP address range in which the endpoints to access your file system exist.
	EndpointIpAddressRange string `pulumi:"endpointIpAddressRange"`
	// The Management and Intercluster FileSystemEndpoints that are used to access data or to manage the file system using the NetApp ONTAP CLI, REST API, or NetApp SnapMirror. See FileSystemEndpoints below.
	Endpoints []GetOntapFileSystemEndpoint `pulumi:"endpoints"`
	// The number of HA pairs for the file system.
	HaPairs int `pulumi:"haPairs"`
	// Identifier of the file system (e.g. `fs-12345678`).
	Id string `pulumi:"id"`
	// ARN for the KMS Key to encrypt the file system at rest.
	KmsKeyId string `pulumi:"kmsKeyId"`
	// The IDs of the elastic network interfaces from which a specific file system is accessible.
	NetworkInterfaceIds []string `pulumi:"networkInterfaceIds"`
	// AWS account identifier that created the file system.
	OwnerId string `pulumi:"ownerId"`
	// Specifies the subnet in which you want the preferred file server to be located.
	PreferredSubnetId string `pulumi:"preferredSubnetId"`
	// (Multi-AZ only) The VPC route tables in which your file system's endpoints exist.
	RouteTableIds []string `pulumi:"routeTableIds"`
	// The storage capacity of the file system in gibibytes (GiB).
	StorageCapacity int `pulumi:"storageCapacity"`
	// The type of storage the file system is using. If set to `SSD`, the file system uses solid state drive storage. If set to `HDD`, the file system uses hard disk drive storage.
	StorageType string `pulumi:"storageType"`
	// Specifies the IDs of the subnets that the file system is accessible from. For the MULTI_AZ_1 file system deployment type, there are two subnet IDs, one for the preferred file server and one for the standby file server. The preferred file server subnet identified in the `preferredSubnetId` property.
	SubnetIds []string `pulumi:"subnetIds"`
	// The tags associated with the file system.
	Tags map[string]string `pulumi:"tags"`
	// The sustained throughput of an Amazon FSx file system in Megabytes per second (MBps). If the file system uses multiple HA pairs this will equal throuthputCapacityPerHaPair x ha_pairs
	ThroughputCapacity int `pulumi:"throughputCapacity"`
	// The sustained throughput of each HA pair for an Amazon FSx file system in Megabytes per second (MBps).
	ThroughputCapacityPerHaPair int `pulumi:"throughputCapacityPerHaPair"`
	// The ID of the primary virtual private cloud (VPC) for the file system.
	VpcId string `pulumi:"vpcId"`
	// The preferred start time (in `D:HH:MM` format) to perform weekly maintenance, in the UTC time zone.
	WeeklyMaintenanceStartTime string `pulumi:"weeklyMaintenanceStartTime"`
}

func LookupOntapFileSystemOutput(ctx *pulumi.Context, args LookupOntapFileSystemOutputArgs, opts ...pulumi.InvokeOption) LookupOntapFileSystemResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupOntapFileSystemResultOutput, error) {
			args := v.(LookupOntapFileSystemArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:fsx/getOntapFileSystem:getOntapFileSystem", args, LookupOntapFileSystemResultOutput{}, options).(LookupOntapFileSystemResultOutput), nil
		}).(LookupOntapFileSystemResultOutput)
}

// A collection of arguments for invoking getOntapFileSystem.
type LookupOntapFileSystemOutputArgs struct {
	// Identifier of the file system (e.g. `fs-12345678`).
	Id pulumi.StringInput `pulumi:"id"`
	// The tags associated with the file system.
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupOntapFileSystemOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupOntapFileSystemArgs)(nil)).Elem()
}

// A collection of values returned by getOntapFileSystem.
type LookupOntapFileSystemResultOutput struct{ *pulumi.OutputState }

func (LookupOntapFileSystemResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupOntapFileSystemResult)(nil)).Elem()
}

func (o LookupOntapFileSystemResultOutput) ToLookupOntapFileSystemResultOutput() LookupOntapFileSystemResultOutput {
	return o
}

func (o LookupOntapFileSystemResultOutput) ToLookupOntapFileSystemResultOutputWithContext(ctx context.Context) LookupOntapFileSystemResultOutput {
	return o
}

// Amazon Resource Name of the file system.
func (o LookupOntapFileSystemResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.Arn }).(pulumi.StringOutput)
}

// The number of days to retain automatic backups.
func (o LookupOntapFileSystemResultOutput) AutomaticBackupRetentionDays() pulumi.IntOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) int { return v.AutomaticBackupRetentionDays }).(pulumi.IntOutput)
}

// The preferred time (in `HH:MM` format) to take daily automatic backups, in the UTC time zone.
func (o LookupOntapFileSystemResultOutput) DailyAutomaticBackupStartTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.DailyAutomaticBackupStartTime }).(pulumi.StringOutput)
}

// The file system deployment type.
func (o LookupOntapFileSystemResultOutput) DeploymentType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.DeploymentType }).(pulumi.StringOutput)
}

// The SSD IOPS configuration for the Amazon FSx for NetApp ONTAP file system, specifying the number of provisioned IOPS and the provision mode. See Disk IOPS Below.
func (o LookupOntapFileSystemResultOutput) DiskIopsConfigurations() GetOntapFileSystemDiskIopsConfigurationArrayOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) []GetOntapFileSystemDiskIopsConfiguration {
		return v.DiskIopsConfigurations
	}).(GetOntapFileSystemDiskIopsConfigurationArrayOutput)
}

// DNS name for the file system.
func (o LookupOntapFileSystemResultOutput) DnsName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.DnsName }).(pulumi.StringOutput)
}

// (Multi-AZ only) Specifies the IP address range in which the endpoints to access your file system exist.
func (o LookupOntapFileSystemResultOutput) EndpointIpAddressRange() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.EndpointIpAddressRange }).(pulumi.StringOutput)
}

// The Management and Intercluster FileSystemEndpoints that are used to access data or to manage the file system using the NetApp ONTAP CLI, REST API, or NetApp SnapMirror. See FileSystemEndpoints below.
func (o LookupOntapFileSystemResultOutput) Endpoints() GetOntapFileSystemEndpointArrayOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) []GetOntapFileSystemEndpoint { return v.Endpoints }).(GetOntapFileSystemEndpointArrayOutput)
}

// The number of HA pairs for the file system.
func (o LookupOntapFileSystemResultOutput) HaPairs() pulumi.IntOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) int { return v.HaPairs }).(pulumi.IntOutput)
}

// Identifier of the file system (e.g. `fs-12345678`).
func (o LookupOntapFileSystemResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.Id }).(pulumi.StringOutput)
}

// ARN for the KMS Key to encrypt the file system at rest.
func (o LookupOntapFileSystemResultOutput) KmsKeyId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.KmsKeyId }).(pulumi.StringOutput)
}

// The IDs of the elastic network interfaces from which a specific file system is accessible.
func (o LookupOntapFileSystemResultOutput) NetworkInterfaceIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) []string { return v.NetworkInterfaceIds }).(pulumi.StringArrayOutput)
}

// AWS account identifier that created the file system.
func (o LookupOntapFileSystemResultOutput) OwnerId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.OwnerId }).(pulumi.StringOutput)
}

// Specifies the subnet in which you want the preferred file server to be located.
func (o LookupOntapFileSystemResultOutput) PreferredSubnetId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.PreferredSubnetId }).(pulumi.StringOutput)
}

// (Multi-AZ only) The VPC route tables in which your file system's endpoints exist.
func (o LookupOntapFileSystemResultOutput) RouteTableIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) []string { return v.RouteTableIds }).(pulumi.StringArrayOutput)
}

// The storage capacity of the file system in gibibytes (GiB).
func (o LookupOntapFileSystemResultOutput) StorageCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) int { return v.StorageCapacity }).(pulumi.IntOutput)
}

// The type of storage the file system is using. If set to `SSD`, the file system uses solid state drive storage. If set to `HDD`, the file system uses hard disk drive storage.
func (o LookupOntapFileSystemResultOutput) StorageType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.StorageType }).(pulumi.StringOutput)
}

// Specifies the IDs of the subnets that the file system is accessible from. For the MULTI_AZ_1 file system deployment type, there are two subnet IDs, one for the preferred file server and one for the standby file server. The preferred file server subnet identified in the `preferredSubnetId` property.
func (o LookupOntapFileSystemResultOutput) SubnetIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) []string { return v.SubnetIds }).(pulumi.StringArrayOutput)
}

// The tags associated with the file system.
func (o LookupOntapFileSystemResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// The sustained throughput of an Amazon FSx file system in Megabytes per second (MBps). If the file system uses multiple HA pairs this will equal throuthputCapacityPerHaPair x ha_pairs
func (o LookupOntapFileSystemResultOutput) ThroughputCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) int { return v.ThroughputCapacity }).(pulumi.IntOutput)
}

// The sustained throughput of each HA pair for an Amazon FSx file system in Megabytes per second (MBps).
func (o LookupOntapFileSystemResultOutput) ThroughputCapacityPerHaPair() pulumi.IntOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) int { return v.ThroughputCapacityPerHaPair }).(pulumi.IntOutput)
}

// The ID of the primary virtual private cloud (VPC) for the file system.
func (o LookupOntapFileSystemResultOutput) VpcId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.VpcId }).(pulumi.StringOutput)
}

// The preferred start time (in `D:HH:MM` format) to perform weekly maintenance, in the UTC time zone.
func (o LookupOntapFileSystemResultOutput) WeeklyMaintenanceStartTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapFileSystemResult) string { return v.WeeklyMaintenanceStartTime }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupOntapFileSystemResultOutput{})
}
