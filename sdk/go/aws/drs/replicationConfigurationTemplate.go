// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package drs

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Elastic Disaster Recovery replication configuration template resource. Before using DRS, your account must be [initialized](https://docs.aws.amazon.com/drs/latest/userguide/getting-started-initializing.html).
//
// > **NOTE:** Your configuration must use the PIT policy shown in the basic configuration due to AWS rules. The only value that you can change is the `retentionDuration` of `ruleId` 3.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/drs"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
// func main() {
// pulumi.Run(func(ctx *pulumi.Context) error {
// var splat0 []interface{}
// for _, val0 := range exampleAwsSecurityGroup {
// splat0 = append(splat0, val0.Id)
// }
// _, err := drs.NewReplicationConfigurationTemplate(ctx, "example", &drs.ReplicationConfigurationTemplateArgs{
// AssociateDefaultSecurityGroup: pulumi.Bool(false),
// BandwidthThrottling: pulumi.Int(12),
// CreatePublicIp: pulumi.Bool(false),
// DataPlaneRouting: pulumi.String("PRIVATE_IP"),
// DefaultLargeStagingDiskType: pulumi.String("GP2"),
// EbsEncryption: pulumi.String("DEFAULT"),
// EbsEncryptionKeyArn: pulumi.String("arn:aws:kms:us-east-1:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab"),
// ReplicationServerInstanceType: pulumi.String("t3.small"),
// ReplicationServersSecurityGroupsIds: toPulumiArray(splat0),
// StagingAreaSubnetId: pulumi.Any(exampleAwsSubnet.Id),
// UseDedicatedReplicationServer: pulumi.Bool(false),
// PitPolicies: drs.ReplicationConfigurationTemplatePitPolicyArray{
// &drs.ReplicationConfigurationTemplatePitPolicyArgs{
// Enabled: pulumi.Bool(true),
// Interval: pulumi.Int(10),
// RetentionDuration: pulumi.Int(60),
// Units: pulumi.String("MINUTE"),
// RuleId: pulumi.Int(1),
// },
// &drs.ReplicationConfigurationTemplatePitPolicyArgs{
// Enabled: pulumi.Bool(true),
// Interval: pulumi.Int(1),
// RetentionDuration: pulumi.Int(24),
// Units: pulumi.String("HOUR"),
// RuleId: pulumi.Int(2),
// },
// &drs.ReplicationConfigurationTemplatePitPolicyArgs{
// Enabled: pulumi.Bool(true),
// Interval: pulumi.Int(1),
// RetentionDuration: pulumi.Int(3),
// Units: pulumi.String("DAY"),
// RuleId: pulumi.Int(3),
// },
// },
// })
// if err != nil {
// return err
// }
// return nil
// })
// }
// func toPulumiArray(arr []) pulumi.Array {
// var pulumiArr pulumi.Array
// for _, v := range arr {
// pulumiArr = append(pulumiArr, pulumi.(v))
// }
// return pulumiArr
// }
// ```
//
// ## Import
//
// Using `pulumi import`, import DRS Replication Configuration Template using the `id`. For example:
//
// ```sh
// $ pulumi import aws:drs/replicationConfigurationTemplate:ReplicationConfigurationTemplate example templateid
// ```
type ReplicationConfigurationTemplate struct {
	pulumi.CustomResourceState

	// Replication configuration template ARN.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Whether to associate the default Elastic Disaster Recovery Security group with the Replication Configuration Template.
	AssociateDefaultSecurityGroup pulumi.BoolOutput `pulumi:"associateDefaultSecurityGroup"`
	// Whether to allow the AWS replication agent to automatically replicate newly added disks.
	AutoReplicateNewDisks pulumi.BoolOutput `pulumi:"autoReplicateNewDisks"`
	// Configure bandwidth throttling for the outbound data transfer rate of the Source Server in Mbps.
	BandwidthThrottling pulumi.IntOutput `pulumi:"bandwidthThrottling"`
	// Whether to create a Public IP for the Recovery Instance by default.
	CreatePublicIp pulumi.BoolOutput `pulumi:"createPublicIp"`
	// Data plane routing mechanism that will be used for replication. Valid values are `PUBLIC_IP` and `PRIVATE_IP`.
	DataPlaneRouting pulumi.StringOutput `pulumi:"dataPlaneRouting"`
	// Staging Disk EBS volume type to be used during replication. Valid values are `GP2`, `GP3`, `ST1`, or `AUTO`.
	DefaultLargeStagingDiskType pulumi.StringOutput `pulumi:"defaultLargeStagingDiskType"`
	// Type of EBS encryption to be used during replication. Valid values are `DEFAULT` and `CUSTOM`.
	EbsEncryption pulumi.StringOutput `pulumi:"ebsEncryption"`
	// ARN of the EBS encryption key to be used during replication.
	EbsEncryptionKeyArn pulumi.StringPtrOutput `pulumi:"ebsEncryptionKeyArn"`
	// Configuration block for Point in time (PIT) policy to manage snapshots taken during replication. See below.
	PitPolicies ReplicationConfigurationTemplatePitPolicyArrayOutput `pulumi:"pitPolicies"`
	// Instance type to be used for the replication server.
	ReplicationServerInstanceType pulumi.StringOutput `pulumi:"replicationServerInstanceType"`
	// Security group IDs that will be used by the replication server.
	ReplicationServersSecurityGroupsIds pulumi.StringArrayOutput `pulumi:"replicationServersSecurityGroupsIds"`
	// Subnet to be used by the replication staging area.
	StagingAreaSubnetId pulumi.StringOutput `pulumi:"stagingAreaSubnetId"`
	// Set of tags to be associated with all resources created in the replication staging area: EC2 replication server, EBS volumes, EBS snapshots, etc.
	StagingAreaTags pulumi.StringMapOutput `pulumi:"stagingAreaTags"`
	// Set of tags to be associated with the Replication Configuration Template resource.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapOutput                            `pulumi:"tagsAll"`
	Timeouts ReplicationConfigurationTemplateTimeoutsPtrOutput `pulumi:"timeouts"`
	// Whether to use a dedicated Replication Server in the replication staging area.
	//
	// The following arguments are optional:
	UseDedicatedReplicationServer pulumi.BoolOutput `pulumi:"useDedicatedReplicationServer"`
}

// NewReplicationConfigurationTemplate registers a new resource with the given unique name, arguments, and options.
func NewReplicationConfigurationTemplate(ctx *pulumi.Context,
	name string, args *ReplicationConfigurationTemplateArgs, opts ...pulumi.ResourceOption) (*ReplicationConfigurationTemplate, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.AssociateDefaultSecurityGroup == nil {
		return nil, errors.New("invalid value for required argument 'AssociateDefaultSecurityGroup'")
	}
	if args.BandwidthThrottling == nil {
		return nil, errors.New("invalid value for required argument 'BandwidthThrottling'")
	}
	if args.CreatePublicIp == nil {
		return nil, errors.New("invalid value for required argument 'CreatePublicIp'")
	}
	if args.DataPlaneRouting == nil {
		return nil, errors.New("invalid value for required argument 'DataPlaneRouting'")
	}
	if args.DefaultLargeStagingDiskType == nil {
		return nil, errors.New("invalid value for required argument 'DefaultLargeStagingDiskType'")
	}
	if args.EbsEncryption == nil {
		return nil, errors.New("invalid value for required argument 'EbsEncryption'")
	}
	if args.ReplicationServerInstanceType == nil {
		return nil, errors.New("invalid value for required argument 'ReplicationServerInstanceType'")
	}
	if args.ReplicationServersSecurityGroupsIds == nil {
		return nil, errors.New("invalid value for required argument 'ReplicationServersSecurityGroupsIds'")
	}
	if args.StagingAreaSubnetId == nil {
		return nil, errors.New("invalid value for required argument 'StagingAreaSubnetId'")
	}
	if args.StagingAreaTags == nil {
		return nil, errors.New("invalid value for required argument 'StagingAreaTags'")
	}
	if args.UseDedicatedReplicationServer == nil {
		return nil, errors.New("invalid value for required argument 'UseDedicatedReplicationServer'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ReplicationConfigurationTemplate
	err := ctx.RegisterResource("aws:drs/replicationConfigurationTemplate:ReplicationConfigurationTemplate", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetReplicationConfigurationTemplate gets an existing ReplicationConfigurationTemplate resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetReplicationConfigurationTemplate(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ReplicationConfigurationTemplateState, opts ...pulumi.ResourceOption) (*ReplicationConfigurationTemplate, error) {
	var resource ReplicationConfigurationTemplate
	err := ctx.ReadResource("aws:drs/replicationConfigurationTemplate:ReplicationConfigurationTemplate", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ReplicationConfigurationTemplate resources.
type replicationConfigurationTemplateState struct {
	// Replication configuration template ARN.
	Arn *string `pulumi:"arn"`
	// Whether to associate the default Elastic Disaster Recovery Security group with the Replication Configuration Template.
	AssociateDefaultSecurityGroup *bool `pulumi:"associateDefaultSecurityGroup"`
	// Whether to allow the AWS replication agent to automatically replicate newly added disks.
	AutoReplicateNewDisks *bool `pulumi:"autoReplicateNewDisks"`
	// Configure bandwidth throttling for the outbound data transfer rate of the Source Server in Mbps.
	BandwidthThrottling *int `pulumi:"bandwidthThrottling"`
	// Whether to create a Public IP for the Recovery Instance by default.
	CreatePublicIp *bool `pulumi:"createPublicIp"`
	// Data plane routing mechanism that will be used for replication. Valid values are `PUBLIC_IP` and `PRIVATE_IP`.
	DataPlaneRouting *string `pulumi:"dataPlaneRouting"`
	// Staging Disk EBS volume type to be used during replication. Valid values are `GP2`, `GP3`, `ST1`, or `AUTO`.
	DefaultLargeStagingDiskType *string `pulumi:"defaultLargeStagingDiskType"`
	// Type of EBS encryption to be used during replication. Valid values are `DEFAULT` and `CUSTOM`.
	EbsEncryption *string `pulumi:"ebsEncryption"`
	// ARN of the EBS encryption key to be used during replication.
	EbsEncryptionKeyArn *string `pulumi:"ebsEncryptionKeyArn"`
	// Configuration block for Point in time (PIT) policy to manage snapshots taken during replication. See below.
	PitPolicies []ReplicationConfigurationTemplatePitPolicy `pulumi:"pitPolicies"`
	// Instance type to be used for the replication server.
	ReplicationServerInstanceType *string `pulumi:"replicationServerInstanceType"`
	// Security group IDs that will be used by the replication server.
	ReplicationServersSecurityGroupsIds []string `pulumi:"replicationServersSecurityGroupsIds"`
	// Subnet to be used by the replication staging area.
	StagingAreaSubnetId *string `pulumi:"stagingAreaSubnetId"`
	// Set of tags to be associated with all resources created in the replication staging area: EC2 replication server, EBS volumes, EBS snapshots, etc.
	StagingAreaTags map[string]string `pulumi:"stagingAreaTags"`
	// Set of tags to be associated with the Replication Configuration Template resource.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  map[string]string                         `pulumi:"tagsAll"`
	Timeouts *ReplicationConfigurationTemplateTimeouts `pulumi:"timeouts"`
	// Whether to use a dedicated Replication Server in the replication staging area.
	//
	// The following arguments are optional:
	UseDedicatedReplicationServer *bool `pulumi:"useDedicatedReplicationServer"`
}

type ReplicationConfigurationTemplateState struct {
	// Replication configuration template ARN.
	Arn pulumi.StringPtrInput
	// Whether to associate the default Elastic Disaster Recovery Security group with the Replication Configuration Template.
	AssociateDefaultSecurityGroup pulumi.BoolPtrInput
	// Whether to allow the AWS replication agent to automatically replicate newly added disks.
	AutoReplicateNewDisks pulumi.BoolPtrInput
	// Configure bandwidth throttling for the outbound data transfer rate of the Source Server in Mbps.
	BandwidthThrottling pulumi.IntPtrInput
	// Whether to create a Public IP for the Recovery Instance by default.
	CreatePublicIp pulumi.BoolPtrInput
	// Data plane routing mechanism that will be used for replication. Valid values are `PUBLIC_IP` and `PRIVATE_IP`.
	DataPlaneRouting pulumi.StringPtrInput
	// Staging Disk EBS volume type to be used during replication. Valid values are `GP2`, `GP3`, `ST1`, or `AUTO`.
	DefaultLargeStagingDiskType pulumi.StringPtrInput
	// Type of EBS encryption to be used during replication. Valid values are `DEFAULT` and `CUSTOM`.
	EbsEncryption pulumi.StringPtrInput
	// ARN of the EBS encryption key to be used during replication.
	EbsEncryptionKeyArn pulumi.StringPtrInput
	// Configuration block for Point in time (PIT) policy to manage snapshots taken during replication. See below.
	PitPolicies ReplicationConfigurationTemplatePitPolicyArrayInput
	// Instance type to be used for the replication server.
	ReplicationServerInstanceType pulumi.StringPtrInput
	// Security group IDs that will be used by the replication server.
	ReplicationServersSecurityGroupsIds pulumi.StringArrayInput
	// Subnet to be used by the replication staging area.
	StagingAreaSubnetId pulumi.StringPtrInput
	// Set of tags to be associated with all resources created in the replication staging area: EC2 replication server, EBS volumes, EBS snapshots, etc.
	StagingAreaTags pulumi.StringMapInput
	// Set of tags to be associated with the Replication Configuration Template resource.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapInput
	Timeouts ReplicationConfigurationTemplateTimeoutsPtrInput
	// Whether to use a dedicated Replication Server in the replication staging area.
	//
	// The following arguments are optional:
	UseDedicatedReplicationServer pulumi.BoolPtrInput
}

func (ReplicationConfigurationTemplateState) ElementType() reflect.Type {
	return reflect.TypeOf((*replicationConfigurationTemplateState)(nil)).Elem()
}

type replicationConfigurationTemplateArgs struct {
	// Whether to associate the default Elastic Disaster Recovery Security group with the Replication Configuration Template.
	AssociateDefaultSecurityGroup bool `pulumi:"associateDefaultSecurityGroup"`
	// Whether to allow the AWS replication agent to automatically replicate newly added disks.
	AutoReplicateNewDisks *bool `pulumi:"autoReplicateNewDisks"`
	// Configure bandwidth throttling for the outbound data transfer rate of the Source Server in Mbps.
	BandwidthThrottling int `pulumi:"bandwidthThrottling"`
	// Whether to create a Public IP for the Recovery Instance by default.
	CreatePublicIp bool `pulumi:"createPublicIp"`
	// Data plane routing mechanism that will be used for replication. Valid values are `PUBLIC_IP` and `PRIVATE_IP`.
	DataPlaneRouting string `pulumi:"dataPlaneRouting"`
	// Staging Disk EBS volume type to be used during replication. Valid values are `GP2`, `GP3`, `ST1`, or `AUTO`.
	DefaultLargeStagingDiskType string `pulumi:"defaultLargeStagingDiskType"`
	// Type of EBS encryption to be used during replication. Valid values are `DEFAULT` and `CUSTOM`.
	EbsEncryption string `pulumi:"ebsEncryption"`
	// ARN of the EBS encryption key to be used during replication.
	EbsEncryptionKeyArn *string `pulumi:"ebsEncryptionKeyArn"`
	// Configuration block for Point in time (PIT) policy to manage snapshots taken during replication. See below.
	PitPolicies []ReplicationConfigurationTemplatePitPolicy `pulumi:"pitPolicies"`
	// Instance type to be used for the replication server.
	ReplicationServerInstanceType string `pulumi:"replicationServerInstanceType"`
	// Security group IDs that will be used by the replication server.
	ReplicationServersSecurityGroupsIds []string `pulumi:"replicationServersSecurityGroupsIds"`
	// Subnet to be used by the replication staging area.
	StagingAreaSubnetId string `pulumi:"stagingAreaSubnetId"`
	// Set of tags to be associated with all resources created in the replication staging area: EC2 replication server, EBS volumes, EBS snapshots, etc.
	StagingAreaTags map[string]string `pulumi:"stagingAreaTags"`
	// Set of tags to be associated with the Replication Configuration Template resource.
	Tags     map[string]string                         `pulumi:"tags"`
	Timeouts *ReplicationConfigurationTemplateTimeouts `pulumi:"timeouts"`
	// Whether to use a dedicated Replication Server in the replication staging area.
	//
	// The following arguments are optional:
	UseDedicatedReplicationServer bool `pulumi:"useDedicatedReplicationServer"`
}

// The set of arguments for constructing a ReplicationConfigurationTemplate resource.
type ReplicationConfigurationTemplateArgs struct {
	// Whether to associate the default Elastic Disaster Recovery Security group with the Replication Configuration Template.
	AssociateDefaultSecurityGroup pulumi.BoolInput
	// Whether to allow the AWS replication agent to automatically replicate newly added disks.
	AutoReplicateNewDisks pulumi.BoolPtrInput
	// Configure bandwidth throttling for the outbound data transfer rate of the Source Server in Mbps.
	BandwidthThrottling pulumi.IntInput
	// Whether to create a Public IP for the Recovery Instance by default.
	CreatePublicIp pulumi.BoolInput
	// Data plane routing mechanism that will be used for replication. Valid values are `PUBLIC_IP` and `PRIVATE_IP`.
	DataPlaneRouting pulumi.StringInput
	// Staging Disk EBS volume type to be used during replication. Valid values are `GP2`, `GP3`, `ST1`, or `AUTO`.
	DefaultLargeStagingDiskType pulumi.StringInput
	// Type of EBS encryption to be used during replication. Valid values are `DEFAULT` and `CUSTOM`.
	EbsEncryption pulumi.StringInput
	// ARN of the EBS encryption key to be used during replication.
	EbsEncryptionKeyArn pulumi.StringPtrInput
	// Configuration block for Point in time (PIT) policy to manage snapshots taken during replication. See below.
	PitPolicies ReplicationConfigurationTemplatePitPolicyArrayInput
	// Instance type to be used for the replication server.
	ReplicationServerInstanceType pulumi.StringInput
	// Security group IDs that will be used by the replication server.
	ReplicationServersSecurityGroupsIds pulumi.StringArrayInput
	// Subnet to be used by the replication staging area.
	StagingAreaSubnetId pulumi.StringInput
	// Set of tags to be associated with all resources created in the replication staging area: EC2 replication server, EBS volumes, EBS snapshots, etc.
	StagingAreaTags pulumi.StringMapInput
	// Set of tags to be associated with the Replication Configuration Template resource.
	Tags     pulumi.StringMapInput
	Timeouts ReplicationConfigurationTemplateTimeoutsPtrInput
	// Whether to use a dedicated Replication Server in the replication staging area.
	//
	// The following arguments are optional:
	UseDedicatedReplicationServer pulumi.BoolInput
}

func (ReplicationConfigurationTemplateArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*replicationConfigurationTemplateArgs)(nil)).Elem()
}

type ReplicationConfigurationTemplateInput interface {
	pulumi.Input

	ToReplicationConfigurationTemplateOutput() ReplicationConfigurationTemplateOutput
	ToReplicationConfigurationTemplateOutputWithContext(ctx context.Context) ReplicationConfigurationTemplateOutput
}

func (*ReplicationConfigurationTemplate) ElementType() reflect.Type {
	return reflect.TypeOf((**ReplicationConfigurationTemplate)(nil)).Elem()
}

func (i *ReplicationConfigurationTemplate) ToReplicationConfigurationTemplateOutput() ReplicationConfigurationTemplateOutput {
	return i.ToReplicationConfigurationTemplateOutputWithContext(context.Background())
}

func (i *ReplicationConfigurationTemplate) ToReplicationConfigurationTemplateOutputWithContext(ctx context.Context) ReplicationConfigurationTemplateOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ReplicationConfigurationTemplateOutput)
}

// ReplicationConfigurationTemplateArrayInput is an input type that accepts ReplicationConfigurationTemplateArray and ReplicationConfigurationTemplateArrayOutput values.
// You can construct a concrete instance of `ReplicationConfigurationTemplateArrayInput` via:
//
//	ReplicationConfigurationTemplateArray{ ReplicationConfigurationTemplateArgs{...} }
type ReplicationConfigurationTemplateArrayInput interface {
	pulumi.Input

	ToReplicationConfigurationTemplateArrayOutput() ReplicationConfigurationTemplateArrayOutput
	ToReplicationConfigurationTemplateArrayOutputWithContext(context.Context) ReplicationConfigurationTemplateArrayOutput
}

type ReplicationConfigurationTemplateArray []ReplicationConfigurationTemplateInput

func (ReplicationConfigurationTemplateArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ReplicationConfigurationTemplate)(nil)).Elem()
}

func (i ReplicationConfigurationTemplateArray) ToReplicationConfigurationTemplateArrayOutput() ReplicationConfigurationTemplateArrayOutput {
	return i.ToReplicationConfigurationTemplateArrayOutputWithContext(context.Background())
}

func (i ReplicationConfigurationTemplateArray) ToReplicationConfigurationTemplateArrayOutputWithContext(ctx context.Context) ReplicationConfigurationTemplateArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ReplicationConfigurationTemplateArrayOutput)
}

// ReplicationConfigurationTemplateMapInput is an input type that accepts ReplicationConfigurationTemplateMap and ReplicationConfigurationTemplateMapOutput values.
// You can construct a concrete instance of `ReplicationConfigurationTemplateMapInput` via:
//
//	ReplicationConfigurationTemplateMap{ "key": ReplicationConfigurationTemplateArgs{...} }
type ReplicationConfigurationTemplateMapInput interface {
	pulumi.Input

	ToReplicationConfigurationTemplateMapOutput() ReplicationConfigurationTemplateMapOutput
	ToReplicationConfigurationTemplateMapOutputWithContext(context.Context) ReplicationConfigurationTemplateMapOutput
}

type ReplicationConfigurationTemplateMap map[string]ReplicationConfigurationTemplateInput

func (ReplicationConfigurationTemplateMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ReplicationConfigurationTemplate)(nil)).Elem()
}

func (i ReplicationConfigurationTemplateMap) ToReplicationConfigurationTemplateMapOutput() ReplicationConfigurationTemplateMapOutput {
	return i.ToReplicationConfigurationTemplateMapOutputWithContext(context.Background())
}

func (i ReplicationConfigurationTemplateMap) ToReplicationConfigurationTemplateMapOutputWithContext(ctx context.Context) ReplicationConfigurationTemplateMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ReplicationConfigurationTemplateMapOutput)
}

type ReplicationConfigurationTemplateOutput struct{ *pulumi.OutputState }

func (ReplicationConfigurationTemplateOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ReplicationConfigurationTemplate)(nil)).Elem()
}

func (o ReplicationConfigurationTemplateOutput) ToReplicationConfigurationTemplateOutput() ReplicationConfigurationTemplateOutput {
	return o
}

func (o ReplicationConfigurationTemplateOutput) ToReplicationConfigurationTemplateOutputWithContext(ctx context.Context) ReplicationConfigurationTemplateOutput {
	return o
}

// Replication configuration template ARN.
func (o ReplicationConfigurationTemplateOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Whether to associate the default Elastic Disaster Recovery Security group with the Replication Configuration Template.
func (o ReplicationConfigurationTemplateOutput) AssociateDefaultSecurityGroup() pulumi.BoolOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.BoolOutput { return v.AssociateDefaultSecurityGroup }).(pulumi.BoolOutput)
}

// Whether to allow the AWS replication agent to automatically replicate newly added disks.
func (o ReplicationConfigurationTemplateOutput) AutoReplicateNewDisks() pulumi.BoolOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.BoolOutput { return v.AutoReplicateNewDisks }).(pulumi.BoolOutput)
}

// Configure bandwidth throttling for the outbound data transfer rate of the Source Server in Mbps.
func (o ReplicationConfigurationTemplateOutput) BandwidthThrottling() pulumi.IntOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.IntOutput { return v.BandwidthThrottling }).(pulumi.IntOutput)
}

// Whether to create a Public IP for the Recovery Instance by default.
func (o ReplicationConfigurationTemplateOutput) CreatePublicIp() pulumi.BoolOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.BoolOutput { return v.CreatePublicIp }).(pulumi.BoolOutput)
}

// Data plane routing mechanism that will be used for replication. Valid values are `PUBLIC_IP` and `PRIVATE_IP`.
func (o ReplicationConfigurationTemplateOutput) DataPlaneRouting() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringOutput { return v.DataPlaneRouting }).(pulumi.StringOutput)
}

// Staging Disk EBS volume type to be used during replication. Valid values are `GP2`, `GP3`, `ST1`, or `AUTO`.
func (o ReplicationConfigurationTemplateOutput) DefaultLargeStagingDiskType() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringOutput { return v.DefaultLargeStagingDiskType }).(pulumi.StringOutput)
}

// Type of EBS encryption to be used during replication. Valid values are `DEFAULT` and `CUSTOM`.
func (o ReplicationConfigurationTemplateOutput) EbsEncryption() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringOutput { return v.EbsEncryption }).(pulumi.StringOutput)
}

// ARN of the EBS encryption key to be used during replication.
func (o ReplicationConfigurationTemplateOutput) EbsEncryptionKeyArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringPtrOutput { return v.EbsEncryptionKeyArn }).(pulumi.StringPtrOutput)
}

// Configuration block for Point in time (PIT) policy to manage snapshots taken during replication. See below.
func (o ReplicationConfigurationTemplateOutput) PitPolicies() ReplicationConfigurationTemplatePitPolicyArrayOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) ReplicationConfigurationTemplatePitPolicyArrayOutput {
		return v.PitPolicies
	}).(ReplicationConfigurationTemplatePitPolicyArrayOutput)
}

// Instance type to be used for the replication server.
func (o ReplicationConfigurationTemplateOutput) ReplicationServerInstanceType() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringOutput { return v.ReplicationServerInstanceType }).(pulumi.StringOutput)
}

// Security group IDs that will be used by the replication server.
func (o ReplicationConfigurationTemplateOutput) ReplicationServersSecurityGroupsIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringArrayOutput {
		return v.ReplicationServersSecurityGroupsIds
	}).(pulumi.StringArrayOutput)
}

// Subnet to be used by the replication staging area.
func (o ReplicationConfigurationTemplateOutput) StagingAreaSubnetId() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringOutput { return v.StagingAreaSubnetId }).(pulumi.StringOutput)
}

// Set of tags to be associated with all resources created in the replication staging area: EC2 replication server, EBS volumes, EBS snapshots, etc.
func (o ReplicationConfigurationTemplateOutput) StagingAreaTags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringMapOutput { return v.StagingAreaTags }).(pulumi.StringMapOutput)
}

// Set of tags to be associated with the Replication Configuration Template resource.
func (o ReplicationConfigurationTemplateOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ReplicationConfigurationTemplateOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o ReplicationConfigurationTemplateOutput) Timeouts() ReplicationConfigurationTemplateTimeoutsPtrOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) ReplicationConfigurationTemplateTimeoutsPtrOutput {
		return v.Timeouts
	}).(ReplicationConfigurationTemplateTimeoutsPtrOutput)
}

// Whether to use a dedicated Replication Server in the replication staging area.
//
// The following arguments are optional:
func (o ReplicationConfigurationTemplateOutput) UseDedicatedReplicationServer() pulumi.BoolOutput {
	return o.ApplyT(func(v *ReplicationConfigurationTemplate) pulumi.BoolOutput { return v.UseDedicatedReplicationServer }).(pulumi.BoolOutput)
}

type ReplicationConfigurationTemplateArrayOutput struct{ *pulumi.OutputState }

func (ReplicationConfigurationTemplateArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ReplicationConfigurationTemplate)(nil)).Elem()
}

func (o ReplicationConfigurationTemplateArrayOutput) ToReplicationConfigurationTemplateArrayOutput() ReplicationConfigurationTemplateArrayOutput {
	return o
}

func (o ReplicationConfigurationTemplateArrayOutput) ToReplicationConfigurationTemplateArrayOutputWithContext(ctx context.Context) ReplicationConfigurationTemplateArrayOutput {
	return o
}

func (o ReplicationConfigurationTemplateArrayOutput) Index(i pulumi.IntInput) ReplicationConfigurationTemplateOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ReplicationConfigurationTemplate {
		return vs[0].([]*ReplicationConfigurationTemplate)[vs[1].(int)]
	}).(ReplicationConfigurationTemplateOutput)
}

type ReplicationConfigurationTemplateMapOutput struct{ *pulumi.OutputState }

func (ReplicationConfigurationTemplateMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ReplicationConfigurationTemplate)(nil)).Elem()
}

func (o ReplicationConfigurationTemplateMapOutput) ToReplicationConfigurationTemplateMapOutput() ReplicationConfigurationTemplateMapOutput {
	return o
}

func (o ReplicationConfigurationTemplateMapOutput) ToReplicationConfigurationTemplateMapOutputWithContext(ctx context.Context) ReplicationConfigurationTemplateMapOutput {
	return o
}

func (o ReplicationConfigurationTemplateMapOutput) MapIndex(k pulumi.StringInput) ReplicationConfigurationTemplateOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ReplicationConfigurationTemplate {
		return vs[0].(map[string]*ReplicationConfigurationTemplate)[vs[1].(string)]
	}).(ReplicationConfigurationTemplateOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ReplicationConfigurationTemplateInput)(nil)).Elem(), &ReplicationConfigurationTemplate{})
	pulumi.RegisterInputType(reflect.TypeOf((*ReplicationConfigurationTemplateArrayInput)(nil)).Elem(), ReplicationConfigurationTemplateArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ReplicationConfigurationTemplateMapInput)(nil)).Elem(), ReplicationConfigurationTemplateMap{})
	pulumi.RegisterOutputType(ReplicationConfigurationTemplateOutput{})
	pulumi.RegisterOutputType(ReplicationConfigurationTemplateArrayOutput{})
	pulumi.RegisterOutputType(ReplicationConfigurationTemplateMapOutput{})
}
