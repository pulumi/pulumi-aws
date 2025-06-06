// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package dms

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides a DMS (Data Migration Service) replication instance resource. DMS replication instances can be created, updated, deleted, and imported.
//
// ## Example Usage
//
// Create required roles and then create a DMS instance, setting the dependsOn to the required role policy attachments.
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/dms"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			// Database Migration Service requires the below IAM Roles to be created before
//			// replication instances can be created. See the DMS Documentation for
//			// additional information: https://docs.aws.amazon.com/dms/latest/userguide/security-iam.html#CHAP_Security.APIRole
//			//   - dms-vpc-role
//			//   - dms-cloudwatch-logs-role
//			//   - dms-access-for-endpoint
//			dmsAssumeRole, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Actions: []string{
//							"sts:AssumeRole",
//						},
//						Principals: []iam.GetPolicyDocumentStatementPrincipal{
//							{
//								Identifiers: []string{
//									"dms.amazonaws.com",
//								},
//								Type: "Service",
//							},
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			dms_access_for_endpoint, err := iam.NewRole(ctx, "dms-access-for-endpoint", &iam.RoleArgs{
//				AssumeRolePolicy: pulumi.String(dmsAssumeRole.Json),
//				Name:             pulumi.String("dms-access-for-endpoint"),
//			})
//			if err != nil {
//				return err
//			}
//			dms_access_for_endpoint_AmazonDMSRedshiftS3Role, err := iam.NewRolePolicyAttachment(ctx, "dms-access-for-endpoint-AmazonDMSRedshiftS3Role", &iam.RolePolicyAttachmentArgs{
//				PolicyArn: pulumi.String("arn:aws:iam::aws:policy/service-role/AmazonDMSRedshiftS3Role"),
//				Role:      dms_access_for_endpoint.Name,
//			})
//			if err != nil {
//				return err
//			}
//			dms_cloudwatch_logs_role, err := iam.NewRole(ctx, "dms-cloudwatch-logs-role", &iam.RoleArgs{
//				AssumeRolePolicy: pulumi.String(dmsAssumeRole.Json),
//				Name:             pulumi.String("dms-cloudwatch-logs-role"),
//			})
//			if err != nil {
//				return err
//			}
//			dms_cloudwatch_logs_role_AmazonDMSCloudWatchLogsRole, err := iam.NewRolePolicyAttachment(ctx, "dms-cloudwatch-logs-role-AmazonDMSCloudWatchLogsRole", &iam.RolePolicyAttachmentArgs{
//				PolicyArn: pulumi.String("arn:aws:iam::aws:policy/service-role/AmazonDMSCloudWatchLogsRole"),
//				Role:      dms_cloudwatch_logs_role.Name,
//			})
//			if err != nil {
//				return err
//			}
//			dms_vpc_role, err := iam.NewRole(ctx, "dms-vpc-role", &iam.RoleArgs{
//				AssumeRolePolicy: pulumi.String(dmsAssumeRole.Json),
//				Name:             pulumi.String("dms-vpc-role"),
//			})
//			if err != nil {
//				return err
//			}
//			dms_vpc_role_AmazonDMSVPCManagementRole, err := iam.NewRolePolicyAttachment(ctx, "dms-vpc-role-AmazonDMSVPCManagementRole", &iam.RolePolicyAttachmentArgs{
//				PolicyArn: pulumi.String("arn:aws:iam::aws:policy/service-role/AmazonDMSVPCManagementRole"),
//				Role:      dms_vpc_role.Name,
//			})
//			if err != nil {
//				return err
//			}
//			// Create a new replication instance
//			_, err = dms.NewReplicationInstance(ctx, "test", &dms.ReplicationInstanceArgs{
//				AllocatedStorage:           pulumi.Int(20),
//				ApplyImmediately:           pulumi.Bool(true),
//				AutoMinorVersionUpgrade:    pulumi.Bool(true),
//				AvailabilityZone:           pulumi.String("us-west-2c"),
//				EngineVersion:              pulumi.String("3.1.4"),
//				KmsKeyArn:                  pulumi.String("arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012"),
//				MultiAz:                    pulumi.Bool(false),
//				PreferredMaintenanceWindow: pulumi.String("sun:10:30-sun:14:30"),
//				PubliclyAccessible:         pulumi.Bool(true),
//				ReplicationInstanceClass:   pulumi.String("dms.t3.micro"),
//				ReplicationInstanceId:      pulumi.String("test-dms-replication-instance-tf"),
//				ReplicationSubnetGroupId:   pulumi.Any(test_dms_replication_subnet_group_tf.Id),
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("test"),
//				},
//				VpcSecurityGroupIds: pulumi.StringArray{
//					pulumi.String("sg-12345678"),
//				},
//			}, pulumi.DependsOn([]pulumi.Resource{
//				dms_access_for_endpoint_AmazonDMSRedshiftS3Role,
//				dms_cloudwatch_logs_role_AmazonDMSCloudWatchLogsRole,
//				dms_vpc_role_AmazonDMSVPCManagementRole,
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
// Using `pulumi import`, import replication instances using the `replication_instance_id`. For example:
//
// ```sh
// $ pulumi import aws:dms/replicationInstance:ReplicationInstance test test-dms-replication-instance-tf
// ```
type ReplicationInstance struct {
	pulumi.CustomResourceState

	// The amount of storage (in gigabytes) to be initially allocated for the replication instance.
	AllocatedStorage pulumi.IntOutput `pulumi:"allocatedStorage"`
	// Indicates that major version upgrades are allowed.
	AllowMajorVersionUpgrade pulumi.BoolPtrOutput `pulumi:"allowMajorVersionUpgrade"`
	// Indicates whether the changes should be applied immediately or during the next maintenance window. Only used when updating an existing resource.
	ApplyImmediately pulumi.BoolPtrOutput `pulumi:"applyImmediately"`
	// Indicates that minor engine upgrades will be applied automatically to the replication instance during the maintenance window.
	AutoMinorVersionUpgrade pulumi.BoolOutput `pulumi:"autoMinorVersionUpgrade"`
	// The EC2 Availability Zone that the replication instance will be created in.
	AvailabilityZone pulumi.StringOutput `pulumi:"availabilityZone"`
	// The engine version number of the replication instance.
	EngineVersion pulumi.StringOutput `pulumi:"engineVersion"`
	// The Amazon Resource Name (ARN) for the KMS key that will be used to encrypt the connection parameters. If you do not specify a value for `kmsKeyArn`, then AWS DMS will use your default encryption key. AWS KMS creates the default encryption key for your AWS account. Your AWS account has a different default encryption key for each AWS region.
	KmsKeyArn pulumi.StringOutput `pulumi:"kmsKeyArn"`
	// Specifies if the replication instance is a multi-az deployment. You cannot set the `availabilityZone` parameter if the `multiAz` parameter is set to `true`.
	MultiAz pulumi.BoolOutput `pulumi:"multiAz"`
	// The type of IP address protocol used by a replication instance. Valid values: `IPV4`, `DUAL`.
	NetworkType pulumi.StringOutput `pulumi:"networkType"`
	// The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
	//
	// - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
	// - Format: `ddd:hh24:mi-ddd:hh24:mi`
	// - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
	// - Constraints: Minimum 30-minute window.
	PreferredMaintenanceWindow pulumi.StringOutput `pulumi:"preferredMaintenanceWindow"`
	// Specifies the accessibility options for the replication instance. A value of true represents an instance with a public IP address. A value of false represents an instance with a private IP address.
	PubliclyAccessible pulumi.BoolOutput `pulumi:"publiclyAccessible"`
	// The Amazon Resource Name (ARN) of the replication instance.
	ReplicationInstanceArn pulumi.StringOutput `pulumi:"replicationInstanceArn"`
	// The compute and memory capacity of the replication instance as specified by the replication instance class. See [AWS DMS User Guide](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_ReplicationInstance.Types.html) for available instance sizes and advice on which one to choose.
	ReplicationInstanceClass pulumi.StringOutput `pulumi:"replicationInstanceClass"`
	// The replication instance identifier. This parameter is stored as a lowercase string.
	//
	// - Must contain from 1 to 63 alphanumeric characters or hyphens.
	// - First character must be a letter.
	// - Cannot end with a hyphen
	// - Cannot contain two consecutive hyphens.
	ReplicationInstanceId pulumi.StringOutput `pulumi:"replicationInstanceId"`
	// A list of the private IP addresses of the replication instance.
	ReplicationInstancePrivateIps pulumi.StringArrayOutput `pulumi:"replicationInstancePrivateIps"`
	// A list of the public IP addresses of the replication instance.
	ReplicationInstancePublicIps pulumi.StringArrayOutput `pulumi:"replicationInstancePublicIps"`
	// A subnet group to associate with the replication instance.
	ReplicationSubnetGroupId pulumi.StringOutput `pulumi:"replicationSubnetGroupId"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// A list of VPC security group IDs to be used with the replication instance. The VPC security groups must work with the VPC containing the replication instance.
	VpcSecurityGroupIds pulumi.StringArrayOutput `pulumi:"vpcSecurityGroupIds"`
}

// NewReplicationInstance registers a new resource with the given unique name, arguments, and options.
func NewReplicationInstance(ctx *pulumi.Context,
	name string, args *ReplicationInstanceArgs, opts ...pulumi.ResourceOption) (*ReplicationInstance, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ReplicationInstanceClass == nil {
		return nil, errors.New("invalid value for required argument 'ReplicationInstanceClass'")
	}
	if args.ReplicationInstanceId == nil {
		return nil, errors.New("invalid value for required argument 'ReplicationInstanceId'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ReplicationInstance
	err := ctx.RegisterResource("aws:dms/replicationInstance:ReplicationInstance", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetReplicationInstance gets an existing ReplicationInstance resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetReplicationInstance(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ReplicationInstanceState, opts ...pulumi.ResourceOption) (*ReplicationInstance, error) {
	var resource ReplicationInstance
	err := ctx.ReadResource("aws:dms/replicationInstance:ReplicationInstance", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ReplicationInstance resources.
type replicationInstanceState struct {
	// The amount of storage (in gigabytes) to be initially allocated for the replication instance.
	AllocatedStorage *int `pulumi:"allocatedStorage"`
	// Indicates that major version upgrades are allowed.
	AllowMajorVersionUpgrade *bool `pulumi:"allowMajorVersionUpgrade"`
	// Indicates whether the changes should be applied immediately or during the next maintenance window. Only used when updating an existing resource.
	ApplyImmediately *bool `pulumi:"applyImmediately"`
	// Indicates that minor engine upgrades will be applied automatically to the replication instance during the maintenance window.
	AutoMinorVersionUpgrade *bool `pulumi:"autoMinorVersionUpgrade"`
	// The EC2 Availability Zone that the replication instance will be created in.
	AvailabilityZone *string `pulumi:"availabilityZone"`
	// The engine version number of the replication instance.
	EngineVersion *string `pulumi:"engineVersion"`
	// The Amazon Resource Name (ARN) for the KMS key that will be used to encrypt the connection parameters. If you do not specify a value for `kmsKeyArn`, then AWS DMS will use your default encryption key. AWS KMS creates the default encryption key for your AWS account. Your AWS account has a different default encryption key for each AWS region.
	KmsKeyArn *string `pulumi:"kmsKeyArn"`
	// Specifies if the replication instance is a multi-az deployment. You cannot set the `availabilityZone` parameter if the `multiAz` parameter is set to `true`.
	MultiAz *bool `pulumi:"multiAz"`
	// The type of IP address protocol used by a replication instance. Valid values: `IPV4`, `DUAL`.
	NetworkType *string `pulumi:"networkType"`
	// The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
	//
	// - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
	// - Format: `ddd:hh24:mi-ddd:hh24:mi`
	// - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
	// - Constraints: Minimum 30-minute window.
	PreferredMaintenanceWindow *string `pulumi:"preferredMaintenanceWindow"`
	// Specifies the accessibility options for the replication instance. A value of true represents an instance with a public IP address. A value of false represents an instance with a private IP address.
	PubliclyAccessible *bool `pulumi:"publiclyAccessible"`
	// The Amazon Resource Name (ARN) of the replication instance.
	ReplicationInstanceArn *string `pulumi:"replicationInstanceArn"`
	// The compute and memory capacity of the replication instance as specified by the replication instance class. See [AWS DMS User Guide](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_ReplicationInstance.Types.html) for available instance sizes and advice on which one to choose.
	ReplicationInstanceClass *string `pulumi:"replicationInstanceClass"`
	// The replication instance identifier. This parameter is stored as a lowercase string.
	//
	// - Must contain from 1 to 63 alphanumeric characters or hyphens.
	// - First character must be a letter.
	// - Cannot end with a hyphen
	// - Cannot contain two consecutive hyphens.
	ReplicationInstanceId *string `pulumi:"replicationInstanceId"`
	// A list of the private IP addresses of the replication instance.
	ReplicationInstancePrivateIps []string `pulumi:"replicationInstancePrivateIps"`
	// A list of the public IP addresses of the replication instance.
	ReplicationInstancePublicIps []string `pulumi:"replicationInstancePublicIps"`
	// A subnet group to associate with the replication instance.
	ReplicationSubnetGroupId *string `pulumi:"replicationSubnetGroupId"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// A list of VPC security group IDs to be used with the replication instance. The VPC security groups must work with the VPC containing the replication instance.
	VpcSecurityGroupIds []string `pulumi:"vpcSecurityGroupIds"`
}

type ReplicationInstanceState struct {
	// The amount of storage (in gigabytes) to be initially allocated for the replication instance.
	AllocatedStorage pulumi.IntPtrInput
	// Indicates that major version upgrades are allowed.
	AllowMajorVersionUpgrade pulumi.BoolPtrInput
	// Indicates whether the changes should be applied immediately or during the next maintenance window. Only used when updating an existing resource.
	ApplyImmediately pulumi.BoolPtrInput
	// Indicates that minor engine upgrades will be applied automatically to the replication instance during the maintenance window.
	AutoMinorVersionUpgrade pulumi.BoolPtrInput
	// The EC2 Availability Zone that the replication instance will be created in.
	AvailabilityZone pulumi.StringPtrInput
	// The engine version number of the replication instance.
	EngineVersion pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) for the KMS key that will be used to encrypt the connection parameters. If you do not specify a value for `kmsKeyArn`, then AWS DMS will use your default encryption key. AWS KMS creates the default encryption key for your AWS account. Your AWS account has a different default encryption key for each AWS region.
	KmsKeyArn pulumi.StringPtrInput
	// Specifies if the replication instance is a multi-az deployment. You cannot set the `availabilityZone` parameter if the `multiAz` parameter is set to `true`.
	MultiAz pulumi.BoolPtrInput
	// The type of IP address protocol used by a replication instance. Valid values: `IPV4`, `DUAL`.
	NetworkType pulumi.StringPtrInput
	// The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
	//
	// - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
	// - Format: `ddd:hh24:mi-ddd:hh24:mi`
	// - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
	// - Constraints: Minimum 30-minute window.
	PreferredMaintenanceWindow pulumi.StringPtrInput
	// Specifies the accessibility options for the replication instance. A value of true represents an instance with a public IP address. A value of false represents an instance with a private IP address.
	PubliclyAccessible pulumi.BoolPtrInput
	// The Amazon Resource Name (ARN) of the replication instance.
	ReplicationInstanceArn pulumi.StringPtrInput
	// The compute and memory capacity of the replication instance as specified by the replication instance class. See [AWS DMS User Guide](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_ReplicationInstance.Types.html) for available instance sizes and advice on which one to choose.
	ReplicationInstanceClass pulumi.StringPtrInput
	// The replication instance identifier. This parameter is stored as a lowercase string.
	//
	// - Must contain from 1 to 63 alphanumeric characters or hyphens.
	// - First character must be a letter.
	// - Cannot end with a hyphen
	// - Cannot contain two consecutive hyphens.
	ReplicationInstanceId pulumi.StringPtrInput
	// A list of the private IP addresses of the replication instance.
	ReplicationInstancePrivateIps pulumi.StringArrayInput
	// A list of the public IP addresses of the replication instance.
	ReplicationInstancePublicIps pulumi.StringArrayInput
	// A subnet group to associate with the replication instance.
	ReplicationSubnetGroupId pulumi.StringPtrInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// A list of VPC security group IDs to be used with the replication instance. The VPC security groups must work with the VPC containing the replication instance.
	VpcSecurityGroupIds pulumi.StringArrayInput
}

func (ReplicationInstanceState) ElementType() reflect.Type {
	return reflect.TypeOf((*replicationInstanceState)(nil)).Elem()
}

type replicationInstanceArgs struct {
	// The amount of storage (in gigabytes) to be initially allocated for the replication instance.
	AllocatedStorage *int `pulumi:"allocatedStorage"`
	// Indicates that major version upgrades are allowed.
	AllowMajorVersionUpgrade *bool `pulumi:"allowMajorVersionUpgrade"`
	// Indicates whether the changes should be applied immediately or during the next maintenance window. Only used when updating an existing resource.
	ApplyImmediately *bool `pulumi:"applyImmediately"`
	// Indicates that minor engine upgrades will be applied automatically to the replication instance during the maintenance window.
	AutoMinorVersionUpgrade *bool `pulumi:"autoMinorVersionUpgrade"`
	// The EC2 Availability Zone that the replication instance will be created in.
	AvailabilityZone *string `pulumi:"availabilityZone"`
	// The engine version number of the replication instance.
	EngineVersion *string `pulumi:"engineVersion"`
	// The Amazon Resource Name (ARN) for the KMS key that will be used to encrypt the connection parameters. If you do not specify a value for `kmsKeyArn`, then AWS DMS will use your default encryption key. AWS KMS creates the default encryption key for your AWS account. Your AWS account has a different default encryption key for each AWS region.
	KmsKeyArn *string `pulumi:"kmsKeyArn"`
	// Specifies if the replication instance is a multi-az deployment. You cannot set the `availabilityZone` parameter if the `multiAz` parameter is set to `true`.
	MultiAz *bool `pulumi:"multiAz"`
	// The type of IP address protocol used by a replication instance. Valid values: `IPV4`, `DUAL`.
	NetworkType *string `pulumi:"networkType"`
	// The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
	//
	// - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
	// - Format: `ddd:hh24:mi-ddd:hh24:mi`
	// - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
	// - Constraints: Minimum 30-minute window.
	PreferredMaintenanceWindow *string `pulumi:"preferredMaintenanceWindow"`
	// Specifies the accessibility options for the replication instance. A value of true represents an instance with a public IP address. A value of false represents an instance with a private IP address.
	PubliclyAccessible *bool `pulumi:"publiclyAccessible"`
	// The compute and memory capacity of the replication instance as specified by the replication instance class. See [AWS DMS User Guide](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_ReplicationInstance.Types.html) for available instance sizes and advice on which one to choose.
	ReplicationInstanceClass string `pulumi:"replicationInstanceClass"`
	// The replication instance identifier. This parameter is stored as a lowercase string.
	//
	// - Must contain from 1 to 63 alphanumeric characters or hyphens.
	// - First character must be a letter.
	// - Cannot end with a hyphen
	// - Cannot contain two consecutive hyphens.
	ReplicationInstanceId string `pulumi:"replicationInstanceId"`
	// A subnet group to associate with the replication instance.
	ReplicationSubnetGroupId *string `pulumi:"replicationSubnetGroupId"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A list of VPC security group IDs to be used with the replication instance. The VPC security groups must work with the VPC containing the replication instance.
	VpcSecurityGroupIds []string `pulumi:"vpcSecurityGroupIds"`
}

// The set of arguments for constructing a ReplicationInstance resource.
type ReplicationInstanceArgs struct {
	// The amount of storage (in gigabytes) to be initially allocated for the replication instance.
	AllocatedStorage pulumi.IntPtrInput
	// Indicates that major version upgrades are allowed.
	AllowMajorVersionUpgrade pulumi.BoolPtrInput
	// Indicates whether the changes should be applied immediately or during the next maintenance window. Only used when updating an existing resource.
	ApplyImmediately pulumi.BoolPtrInput
	// Indicates that minor engine upgrades will be applied automatically to the replication instance during the maintenance window.
	AutoMinorVersionUpgrade pulumi.BoolPtrInput
	// The EC2 Availability Zone that the replication instance will be created in.
	AvailabilityZone pulumi.StringPtrInput
	// The engine version number of the replication instance.
	EngineVersion pulumi.StringPtrInput
	// The Amazon Resource Name (ARN) for the KMS key that will be used to encrypt the connection parameters. If you do not specify a value for `kmsKeyArn`, then AWS DMS will use your default encryption key. AWS KMS creates the default encryption key for your AWS account. Your AWS account has a different default encryption key for each AWS region.
	KmsKeyArn pulumi.StringPtrInput
	// Specifies if the replication instance is a multi-az deployment. You cannot set the `availabilityZone` parameter if the `multiAz` parameter is set to `true`.
	MultiAz pulumi.BoolPtrInput
	// The type of IP address protocol used by a replication instance. Valid values: `IPV4`, `DUAL`.
	NetworkType pulumi.StringPtrInput
	// The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
	//
	// - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
	// - Format: `ddd:hh24:mi-ddd:hh24:mi`
	// - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
	// - Constraints: Minimum 30-minute window.
	PreferredMaintenanceWindow pulumi.StringPtrInput
	// Specifies the accessibility options for the replication instance. A value of true represents an instance with a public IP address. A value of false represents an instance with a private IP address.
	PubliclyAccessible pulumi.BoolPtrInput
	// The compute and memory capacity of the replication instance as specified by the replication instance class. See [AWS DMS User Guide](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_ReplicationInstance.Types.html) for available instance sizes and advice on which one to choose.
	ReplicationInstanceClass pulumi.StringInput
	// The replication instance identifier. This parameter is stored as a lowercase string.
	//
	// - Must contain from 1 to 63 alphanumeric characters or hyphens.
	// - First character must be a letter.
	// - Cannot end with a hyphen
	// - Cannot contain two consecutive hyphens.
	ReplicationInstanceId pulumi.StringInput
	// A subnet group to associate with the replication instance.
	ReplicationSubnetGroupId pulumi.StringPtrInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A list of VPC security group IDs to be used with the replication instance. The VPC security groups must work with the VPC containing the replication instance.
	VpcSecurityGroupIds pulumi.StringArrayInput
}

func (ReplicationInstanceArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*replicationInstanceArgs)(nil)).Elem()
}

type ReplicationInstanceInput interface {
	pulumi.Input

	ToReplicationInstanceOutput() ReplicationInstanceOutput
	ToReplicationInstanceOutputWithContext(ctx context.Context) ReplicationInstanceOutput
}

func (*ReplicationInstance) ElementType() reflect.Type {
	return reflect.TypeOf((**ReplicationInstance)(nil)).Elem()
}

func (i *ReplicationInstance) ToReplicationInstanceOutput() ReplicationInstanceOutput {
	return i.ToReplicationInstanceOutputWithContext(context.Background())
}

func (i *ReplicationInstance) ToReplicationInstanceOutputWithContext(ctx context.Context) ReplicationInstanceOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ReplicationInstanceOutput)
}

// ReplicationInstanceArrayInput is an input type that accepts ReplicationInstanceArray and ReplicationInstanceArrayOutput values.
// You can construct a concrete instance of `ReplicationInstanceArrayInput` via:
//
//	ReplicationInstanceArray{ ReplicationInstanceArgs{...} }
type ReplicationInstanceArrayInput interface {
	pulumi.Input

	ToReplicationInstanceArrayOutput() ReplicationInstanceArrayOutput
	ToReplicationInstanceArrayOutputWithContext(context.Context) ReplicationInstanceArrayOutput
}

type ReplicationInstanceArray []ReplicationInstanceInput

func (ReplicationInstanceArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ReplicationInstance)(nil)).Elem()
}

func (i ReplicationInstanceArray) ToReplicationInstanceArrayOutput() ReplicationInstanceArrayOutput {
	return i.ToReplicationInstanceArrayOutputWithContext(context.Background())
}

func (i ReplicationInstanceArray) ToReplicationInstanceArrayOutputWithContext(ctx context.Context) ReplicationInstanceArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ReplicationInstanceArrayOutput)
}

// ReplicationInstanceMapInput is an input type that accepts ReplicationInstanceMap and ReplicationInstanceMapOutput values.
// You can construct a concrete instance of `ReplicationInstanceMapInput` via:
//
//	ReplicationInstanceMap{ "key": ReplicationInstanceArgs{...} }
type ReplicationInstanceMapInput interface {
	pulumi.Input

	ToReplicationInstanceMapOutput() ReplicationInstanceMapOutput
	ToReplicationInstanceMapOutputWithContext(context.Context) ReplicationInstanceMapOutput
}

type ReplicationInstanceMap map[string]ReplicationInstanceInput

func (ReplicationInstanceMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ReplicationInstance)(nil)).Elem()
}

func (i ReplicationInstanceMap) ToReplicationInstanceMapOutput() ReplicationInstanceMapOutput {
	return i.ToReplicationInstanceMapOutputWithContext(context.Background())
}

func (i ReplicationInstanceMap) ToReplicationInstanceMapOutputWithContext(ctx context.Context) ReplicationInstanceMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ReplicationInstanceMapOutput)
}

type ReplicationInstanceOutput struct{ *pulumi.OutputState }

func (ReplicationInstanceOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ReplicationInstance)(nil)).Elem()
}

func (o ReplicationInstanceOutput) ToReplicationInstanceOutput() ReplicationInstanceOutput {
	return o
}

func (o ReplicationInstanceOutput) ToReplicationInstanceOutputWithContext(ctx context.Context) ReplicationInstanceOutput {
	return o
}

// The amount of storage (in gigabytes) to be initially allocated for the replication instance.
func (o ReplicationInstanceOutput) AllocatedStorage() pulumi.IntOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.IntOutput { return v.AllocatedStorage }).(pulumi.IntOutput)
}

// Indicates that major version upgrades are allowed.
func (o ReplicationInstanceOutput) AllowMajorVersionUpgrade() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.BoolPtrOutput { return v.AllowMajorVersionUpgrade }).(pulumi.BoolPtrOutput)
}

// Indicates whether the changes should be applied immediately or during the next maintenance window. Only used when updating an existing resource.
func (o ReplicationInstanceOutput) ApplyImmediately() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.BoolPtrOutput { return v.ApplyImmediately }).(pulumi.BoolPtrOutput)
}

// Indicates that minor engine upgrades will be applied automatically to the replication instance during the maintenance window.
func (o ReplicationInstanceOutput) AutoMinorVersionUpgrade() pulumi.BoolOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.BoolOutput { return v.AutoMinorVersionUpgrade }).(pulumi.BoolOutput)
}

// The EC2 Availability Zone that the replication instance will be created in.
func (o ReplicationInstanceOutput) AvailabilityZone() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringOutput { return v.AvailabilityZone }).(pulumi.StringOutput)
}

// The engine version number of the replication instance.
func (o ReplicationInstanceOutput) EngineVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringOutput { return v.EngineVersion }).(pulumi.StringOutput)
}

// The Amazon Resource Name (ARN) for the KMS key that will be used to encrypt the connection parameters. If you do not specify a value for `kmsKeyArn`, then AWS DMS will use your default encryption key. AWS KMS creates the default encryption key for your AWS account. Your AWS account has a different default encryption key for each AWS region.
func (o ReplicationInstanceOutput) KmsKeyArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringOutput { return v.KmsKeyArn }).(pulumi.StringOutput)
}

// Specifies if the replication instance is a multi-az deployment. You cannot set the `availabilityZone` parameter if the `multiAz` parameter is set to `true`.
func (o ReplicationInstanceOutput) MultiAz() pulumi.BoolOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.BoolOutput { return v.MultiAz }).(pulumi.BoolOutput)
}

// The type of IP address protocol used by a replication instance. Valid values: `IPV4`, `DUAL`.
func (o ReplicationInstanceOutput) NetworkType() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringOutput { return v.NetworkType }).(pulumi.StringOutput)
}

// The weekly time range during which system maintenance can occur, in Universal Coordinated Time (UTC).
//
// - Default: A 30-minute window selected at random from an 8-hour block of time per region, occurring on a random day of the week.
// - Format: `ddd:hh24:mi-ddd:hh24:mi`
// - Valid Days: `mon, tue, wed, thu, fri, sat, sun`
// - Constraints: Minimum 30-minute window.
func (o ReplicationInstanceOutput) PreferredMaintenanceWindow() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringOutput { return v.PreferredMaintenanceWindow }).(pulumi.StringOutput)
}

// Specifies the accessibility options for the replication instance. A value of true represents an instance with a public IP address. A value of false represents an instance with a private IP address.
func (o ReplicationInstanceOutput) PubliclyAccessible() pulumi.BoolOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.BoolOutput { return v.PubliclyAccessible }).(pulumi.BoolOutput)
}

// The Amazon Resource Name (ARN) of the replication instance.
func (o ReplicationInstanceOutput) ReplicationInstanceArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringOutput { return v.ReplicationInstanceArn }).(pulumi.StringOutput)
}

// The compute and memory capacity of the replication instance as specified by the replication instance class. See [AWS DMS User Guide](https://docs.aws.amazon.com/dms/latest/userguide/CHAP_ReplicationInstance.Types.html) for available instance sizes and advice on which one to choose.
func (o ReplicationInstanceOutput) ReplicationInstanceClass() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringOutput { return v.ReplicationInstanceClass }).(pulumi.StringOutput)
}

// The replication instance identifier. This parameter is stored as a lowercase string.
//
// - Must contain from 1 to 63 alphanumeric characters or hyphens.
// - First character must be a letter.
// - Cannot end with a hyphen
// - Cannot contain two consecutive hyphens.
func (o ReplicationInstanceOutput) ReplicationInstanceId() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringOutput { return v.ReplicationInstanceId }).(pulumi.StringOutput)
}

// A list of the private IP addresses of the replication instance.
func (o ReplicationInstanceOutput) ReplicationInstancePrivateIps() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringArrayOutput { return v.ReplicationInstancePrivateIps }).(pulumi.StringArrayOutput)
}

// A list of the public IP addresses of the replication instance.
func (o ReplicationInstanceOutput) ReplicationInstancePublicIps() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringArrayOutput { return v.ReplicationInstancePublicIps }).(pulumi.StringArrayOutput)
}

// A subnet group to associate with the replication instance.
func (o ReplicationInstanceOutput) ReplicationSubnetGroupId() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringOutput { return v.ReplicationSubnetGroupId }).(pulumi.StringOutput)
}

// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ReplicationInstanceOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ReplicationInstanceOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// A list of VPC security group IDs to be used with the replication instance. The VPC security groups must work with the VPC containing the replication instance.
func (o ReplicationInstanceOutput) VpcSecurityGroupIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *ReplicationInstance) pulumi.StringArrayOutput { return v.VpcSecurityGroupIds }).(pulumi.StringArrayOutput)
}

type ReplicationInstanceArrayOutput struct{ *pulumi.OutputState }

func (ReplicationInstanceArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ReplicationInstance)(nil)).Elem()
}

func (o ReplicationInstanceArrayOutput) ToReplicationInstanceArrayOutput() ReplicationInstanceArrayOutput {
	return o
}

func (o ReplicationInstanceArrayOutput) ToReplicationInstanceArrayOutputWithContext(ctx context.Context) ReplicationInstanceArrayOutput {
	return o
}

func (o ReplicationInstanceArrayOutput) Index(i pulumi.IntInput) ReplicationInstanceOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ReplicationInstance {
		return vs[0].([]*ReplicationInstance)[vs[1].(int)]
	}).(ReplicationInstanceOutput)
}

type ReplicationInstanceMapOutput struct{ *pulumi.OutputState }

func (ReplicationInstanceMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ReplicationInstance)(nil)).Elem()
}

func (o ReplicationInstanceMapOutput) ToReplicationInstanceMapOutput() ReplicationInstanceMapOutput {
	return o
}

func (o ReplicationInstanceMapOutput) ToReplicationInstanceMapOutputWithContext(ctx context.Context) ReplicationInstanceMapOutput {
	return o
}

func (o ReplicationInstanceMapOutput) MapIndex(k pulumi.StringInput) ReplicationInstanceOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ReplicationInstance {
		return vs[0].(map[string]*ReplicationInstance)[vs[1].(string)]
	}).(ReplicationInstanceOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ReplicationInstanceInput)(nil)).Elem(), &ReplicationInstance{})
	pulumi.RegisterInputType(reflect.TypeOf((*ReplicationInstanceArrayInput)(nil)).Elem(), ReplicationInstanceArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ReplicationInstanceMapInput)(nil)).Elem(), ReplicationInstanceMap{})
	pulumi.RegisterOutputType(ReplicationInstanceOutput{})
	pulumi.RegisterOutputType(ReplicationInstanceArrayOutput{})
	pulumi.RegisterOutputType(ReplicationInstanceMapOutput{})
}
