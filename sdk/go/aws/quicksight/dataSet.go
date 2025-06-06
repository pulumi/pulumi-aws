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

// Resource for managing a QuickSight Data Set.
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
//			_, err := quicksight.NewDataSet(ctx, "example", &quicksight.DataSetArgs{
//				DataSetId:  pulumi.String("example-id"),
//				Name:       pulumi.String("example-name"),
//				ImportMode: pulumi.String("SPICE"),
//				PhysicalTableMaps: quicksight.DataSetPhysicalTableMapArray{
//					&quicksight.DataSetPhysicalTableMapArgs{
//						PhysicalTableMapId: pulumi.String("example-id"),
//						S3Source: &quicksight.DataSetPhysicalTableMapS3SourceArgs{
//							DataSourceArn: pulumi.Any(exampleAwsQuicksightDataSource.Arn),
//							InputColumns: quicksight.DataSetPhysicalTableMapS3SourceInputColumnArray{
//								&quicksight.DataSetPhysicalTableMapS3SourceInputColumnArgs{
//									Name: pulumi.String("Column1"),
//									Type: pulumi.String("STRING"),
//								},
//							},
//							UploadSettings: &quicksight.DataSetPhysicalTableMapS3SourceUploadSettingsArgs{
//								Format: pulumi.String("JSON"),
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
// ### With Column Level Permission Rules
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
//			_, err := quicksight.NewDataSet(ctx, "example", &quicksight.DataSetArgs{
//				DataSetId:  pulumi.String("example-id"),
//				Name:       pulumi.String("example-name"),
//				ImportMode: pulumi.String("SPICE"),
//				PhysicalTableMaps: quicksight.DataSetPhysicalTableMapArray{
//					&quicksight.DataSetPhysicalTableMapArgs{
//						PhysicalTableMapId: pulumi.String("example-id"),
//						S3Source: &quicksight.DataSetPhysicalTableMapS3SourceArgs{
//							DataSourceArn: pulumi.Any(exampleAwsQuicksightDataSource.Arn),
//							InputColumns: quicksight.DataSetPhysicalTableMapS3SourceInputColumnArray{
//								&quicksight.DataSetPhysicalTableMapS3SourceInputColumnArgs{
//									Name: pulumi.String("Column1"),
//									Type: pulumi.String("STRING"),
//								},
//							},
//							UploadSettings: &quicksight.DataSetPhysicalTableMapS3SourceUploadSettingsArgs{
//								Format: pulumi.String("JSON"),
//							},
//						},
//					},
//				},
//				ColumnLevelPermissionRules: quicksight.DataSetColumnLevelPermissionRuleArray{
//					&quicksight.DataSetColumnLevelPermissionRuleArgs{
//						ColumnNames: pulumi.StringArray{
//							pulumi.String("Column1"),
//						},
//						Principals: pulumi.StringArray{
//							exampleAwsQuicksightUser.Arn,
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
// ### With Field Folders
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
//			_, err := quicksight.NewDataSet(ctx, "example", &quicksight.DataSetArgs{
//				DataSetId:  pulumi.String("example-id"),
//				Name:       pulumi.String("example-name"),
//				ImportMode: pulumi.String("SPICE"),
//				PhysicalTableMaps: quicksight.DataSetPhysicalTableMapArray{
//					&quicksight.DataSetPhysicalTableMapArgs{
//						PhysicalTableMapId: pulumi.String("example-id"),
//						S3Source: &quicksight.DataSetPhysicalTableMapS3SourceArgs{
//							DataSourceArn: pulumi.Any(exampleAwsQuicksightDataSource.Arn),
//							InputColumns: quicksight.DataSetPhysicalTableMapS3SourceInputColumnArray{
//								&quicksight.DataSetPhysicalTableMapS3SourceInputColumnArgs{
//									Name: pulumi.String("Column1"),
//									Type: pulumi.String("STRING"),
//								},
//							},
//							UploadSettings: &quicksight.DataSetPhysicalTableMapS3SourceUploadSettingsArgs{
//								Format: pulumi.String("JSON"),
//							},
//						},
//					},
//				},
//				FieldFolders: quicksight.DataSetFieldFolderArray{
//					&quicksight.DataSetFieldFolderArgs{
//						FieldFoldersId: pulumi.String("example-id"),
//						Columns: pulumi.StringArray{
//							pulumi.String("Column1"),
//						},
//						Description: pulumi.String("example description"),
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
// ### With Permissions
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
//			_, err := quicksight.NewDataSet(ctx, "example", &quicksight.DataSetArgs{
//				DataSetId:  pulumi.String("example-id"),
//				Name:       pulumi.String("example-name"),
//				ImportMode: pulumi.String("SPICE"),
//				PhysicalTableMaps: quicksight.DataSetPhysicalTableMapArray{
//					&quicksight.DataSetPhysicalTableMapArgs{
//						PhysicalTableMapId: pulumi.String("example-id"),
//						S3Source: &quicksight.DataSetPhysicalTableMapS3SourceArgs{
//							DataSourceArn: pulumi.Any(exampleAwsQuicksightDataSource.Arn),
//							InputColumns: quicksight.DataSetPhysicalTableMapS3SourceInputColumnArray{
//								&quicksight.DataSetPhysicalTableMapS3SourceInputColumnArgs{
//									Name: pulumi.String("Column1"),
//									Type: pulumi.String("STRING"),
//								},
//							},
//							UploadSettings: &quicksight.DataSetPhysicalTableMapS3SourceUploadSettingsArgs{
//								Format: pulumi.String("JSON"),
//							},
//						},
//					},
//				},
//				Permissions: quicksight.DataSetPermissionArray{
//					&quicksight.DataSetPermissionArgs{
//						Actions: pulumi.StringArray{
//							pulumi.String("quicksight:DescribeDataSet"),
//							pulumi.String("quicksight:DescribeDataSetPermissions"),
//							pulumi.String("quicksight:PassDataSet"),
//							pulumi.String("quicksight:DescribeIngestion"),
//							pulumi.String("quicksight:ListIngestions"),
//						},
//						Principal: pulumi.Any(exampleAwsQuicksightUser.Arn),
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
// ### With Row Level Permission Tag Configuration
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
//			_, err := quicksight.NewDataSet(ctx, "example", &quicksight.DataSetArgs{
//				DataSetId:  pulumi.String("example-id"),
//				Name:       pulumi.String("example-name"),
//				ImportMode: pulumi.String("SPICE"),
//				PhysicalTableMaps: quicksight.DataSetPhysicalTableMapArray{
//					&quicksight.DataSetPhysicalTableMapArgs{
//						PhysicalTableMapId: pulumi.String("example-id"),
//						S3Source: &quicksight.DataSetPhysicalTableMapS3SourceArgs{
//							DataSourceArn: pulumi.Any(exampleAwsQuicksightDataSource.Arn),
//							InputColumns: quicksight.DataSetPhysicalTableMapS3SourceInputColumnArray{
//								&quicksight.DataSetPhysicalTableMapS3SourceInputColumnArgs{
//									Name: pulumi.String("Column1"),
//									Type: pulumi.String("STRING"),
//								},
//							},
//							UploadSettings: &quicksight.DataSetPhysicalTableMapS3SourceUploadSettingsArgs{
//								Format: pulumi.String("JSON"),
//							},
//						},
//					},
//				},
//				RowLevelPermissionTagConfiguration: &quicksight.DataSetRowLevelPermissionTagConfigurationArgs{
//					Status: pulumi.String("ENABLED"),
//					TagRules: quicksight.DataSetRowLevelPermissionTagConfigurationTagRuleArray{
//						&quicksight.DataSetRowLevelPermissionTagConfigurationTagRuleArgs{
//							ColumnName:             pulumi.String("Column1"),
//							TagKey:                 pulumi.String("tagkey"),
//							MatchAllValue:          pulumi.String("*"),
//							TagMultiValueDelimiter: pulumi.String(","),
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
// Using `pulumi import`, import a QuickSight Data Set using the AWS account ID and data set ID separated by a comma (`,`). For example:
//
// ```sh
// $ pulumi import aws:quicksight/dataSet:DataSet example 123456789012,example-id
// ```
type DataSet struct {
	pulumi.CustomResourceState

	// Amazon Resource Name (ARN) of the data set.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// AWS account ID.
	AwsAccountId pulumi.StringOutput `pulumi:"awsAccountId"`
	// Groupings of columns that work together in certain Amazon QuickSight features. Currently, only geospatial hierarchy is supported. See column_groups.
	ColumnGroups DataSetColumnGroupArrayOutput `pulumi:"columnGroups"`
	// A set of 1 or more definitions of a [ColumnLevelPermissionRule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_ColumnLevelPermissionRule.html). See column_level_permission_rules.
	ColumnLevelPermissionRules DataSetColumnLevelPermissionRuleArrayOutput `pulumi:"columnLevelPermissionRules"`
	// Identifier for the data set.
	DataSetId pulumi.StringOutput `pulumi:"dataSetId"`
	// The usage configuration to apply to child datasets that reference this dataset as a source. See data_set_usage_configuration.
	DataSetUsageConfiguration DataSetDataSetUsageConfigurationOutput `pulumi:"dataSetUsageConfiguration"`
	// The folder that contains fields and nested subfolders for your dataset. See field_folders.
	FieldFolders DataSetFieldFolderArrayOutput `pulumi:"fieldFolders"`
	// Indicates whether you want to import the data into SPICE. Valid values are `SPICE` and `DIRECT_QUERY`.
	ImportMode pulumi.StringOutput `pulumi:"importMode"`
	// Configures the combination and transformation of the data from the physical tables. Maximum of 1 entry. See logical_table_map.
	LogicalTableMaps DataSetLogicalTableMapArrayOutput `pulumi:"logicalTableMaps"`
	// Display name for the dataset.
	//
	// The following arguments are optional:
	Name          pulumi.StringOutput            `pulumi:"name"`
	OutputColumns DataSetOutputColumnArrayOutput `pulumi:"outputColumns"`
	// A set of resource permissions on the data source. Maximum of 64 items. See permissions.
	Permissions DataSetPermissionArrayOutput `pulumi:"permissions"`
	// Declares the physical tables that are available in the underlying data sources. See physical_table_map.
	PhysicalTableMaps DataSetPhysicalTableMapArrayOutput `pulumi:"physicalTableMaps"`
	// The refresh properties for the data set. **NOTE**: Only valid when `importMode` is set to `SPICE`. See refresh_properties.
	RefreshProperties DataSetRefreshPropertiesPtrOutput `pulumi:"refreshProperties"`
	// The row-level security configuration for the data that you want to create. See row_level_permission_data_set.
	RowLevelPermissionDataSet DataSetRowLevelPermissionDataSetPtrOutput `pulumi:"rowLevelPermissionDataSet"`
	// The configuration of tags on a dataset to set row-level security. Row-level security tags are currently supported for anonymous embedding only. See row_level_permission_tag_configuration.
	RowLevelPermissionTagConfiguration DataSetRowLevelPermissionTagConfigurationPtrOutput `pulumi:"rowLevelPermissionTagConfiguration"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewDataSet registers a new resource with the given unique name, arguments, and options.
func NewDataSet(ctx *pulumi.Context,
	name string, args *DataSetArgs, opts ...pulumi.ResourceOption) (*DataSet, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.DataSetId == nil {
		return nil, errors.New("invalid value for required argument 'DataSetId'")
	}
	if args.ImportMode == nil {
		return nil, errors.New("invalid value for required argument 'ImportMode'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource DataSet
	err := ctx.RegisterResource("aws:quicksight/dataSet:DataSet", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetDataSet gets an existing DataSet resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetDataSet(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *DataSetState, opts ...pulumi.ResourceOption) (*DataSet, error) {
	var resource DataSet
	err := ctx.ReadResource("aws:quicksight/dataSet:DataSet", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering DataSet resources.
type dataSetState struct {
	// Amazon Resource Name (ARN) of the data set.
	Arn *string `pulumi:"arn"`
	// AWS account ID.
	AwsAccountId *string `pulumi:"awsAccountId"`
	// Groupings of columns that work together in certain Amazon QuickSight features. Currently, only geospatial hierarchy is supported. See column_groups.
	ColumnGroups []DataSetColumnGroup `pulumi:"columnGroups"`
	// A set of 1 or more definitions of a [ColumnLevelPermissionRule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_ColumnLevelPermissionRule.html). See column_level_permission_rules.
	ColumnLevelPermissionRules []DataSetColumnLevelPermissionRule `pulumi:"columnLevelPermissionRules"`
	// Identifier for the data set.
	DataSetId *string `pulumi:"dataSetId"`
	// The usage configuration to apply to child datasets that reference this dataset as a source. See data_set_usage_configuration.
	DataSetUsageConfiguration *DataSetDataSetUsageConfiguration `pulumi:"dataSetUsageConfiguration"`
	// The folder that contains fields and nested subfolders for your dataset. See field_folders.
	FieldFolders []DataSetFieldFolder `pulumi:"fieldFolders"`
	// Indicates whether you want to import the data into SPICE. Valid values are `SPICE` and `DIRECT_QUERY`.
	ImportMode *string `pulumi:"importMode"`
	// Configures the combination and transformation of the data from the physical tables. Maximum of 1 entry. See logical_table_map.
	LogicalTableMaps []DataSetLogicalTableMap `pulumi:"logicalTableMaps"`
	// Display name for the dataset.
	//
	// The following arguments are optional:
	Name          *string               `pulumi:"name"`
	OutputColumns []DataSetOutputColumn `pulumi:"outputColumns"`
	// A set of resource permissions on the data source. Maximum of 64 items. See permissions.
	Permissions []DataSetPermission `pulumi:"permissions"`
	// Declares the physical tables that are available in the underlying data sources. See physical_table_map.
	PhysicalTableMaps []DataSetPhysicalTableMap `pulumi:"physicalTableMaps"`
	// The refresh properties for the data set. **NOTE**: Only valid when `importMode` is set to `SPICE`. See refresh_properties.
	RefreshProperties *DataSetRefreshProperties `pulumi:"refreshProperties"`
	// The row-level security configuration for the data that you want to create. See row_level_permission_data_set.
	RowLevelPermissionDataSet *DataSetRowLevelPermissionDataSet `pulumi:"rowLevelPermissionDataSet"`
	// The configuration of tags on a dataset to set row-level security. Row-level security tags are currently supported for anonymous embedding only. See row_level_permission_tag_configuration.
	RowLevelPermissionTagConfiguration *DataSetRowLevelPermissionTagConfiguration `pulumi:"rowLevelPermissionTagConfiguration"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type DataSetState struct {
	// Amazon Resource Name (ARN) of the data set.
	Arn pulumi.StringPtrInput
	// AWS account ID.
	AwsAccountId pulumi.StringPtrInput
	// Groupings of columns that work together in certain Amazon QuickSight features. Currently, only geospatial hierarchy is supported. See column_groups.
	ColumnGroups DataSetColumnGroupArrayInput
	// A set of 1 or more definitions of a [ColumnLevelPermissionRule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_ColumnLevelPermissionRule.html). See column_level_permission_rules.
	ColumnLevelPermissionRules DataSetColumnLevelPermissionRuleArrayInput
	// Identifier for the data set.
	DataSetId pulumi.StringPtrInput
	// The usage configuration to apply to child datasets that reference this dataset as a source. See data_set_usage_configuration.
	DataSetUsageConfiguration DataSetDataSetUsageConfigurationPtrInput
	// The folder that contains fields and nested subfolders for your dataset. See field_folders.
	FieldFolders DataSetFieldFolderArrayInput
	// Indicates whether you want to import the data into SPICE. Valid values are `SPICE` and `DIRECT_QUERY`.
	ImportMode pulumi.StringPtrInput
	// Configures the combination and transformation of the data from the physical tables. Maximum of 1 entry. See logical_table_map.
	LogicalTableMaps DataSetLogicalTableMapArrayInput
	// Display name for the dataset.
	//
	// The following arguments are optional:
	Name          pulumi.StringPtrInput
	OutputColumns DataSetOutputColumnArrayInput
	// A set of resource permissions on the data source. Maximum of 64 items. See permissions.
	Permissions DataSetPermissionArrayInput
	// Declares the physical tables that are available in the underlying data sources. See physical_table_map.
	PhysicalTableMaps DataSetPhysicalTableMapArrayInput
	// The refresh properties for the data set. **NOTE**: Only valid when `importMode` is set to `SPICE`. See refresh_properties.
	RefreshProperties DataSetRefreshPropertiesPtrInput
	// The row-level security configuration for the data that you want to create. See row_level_permission_data_set.
	RowLevelPermissionDataSet DataSetRowLevelPermissionDataSetPtrInput
	// The configuration of tags on a dataset to set row-level security. Row-level security tags are currently supported for anonymous embedding only. See row_level_permission_tag_configuration.
	RowLevelPermissionTagConfiguration DataSetRowLevelPermissionTagConfigurationPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (DataSetState) ElementType() reflect.Type {
	return reflect.TypeOf((*dataSetState)(nil)).Elem()
}

type dataSetArgs struct {
	// AWS account ID.
	AwsAccountId *string `pulumi:"awsAccountId"`
	// Groupings of columns that work together in certain Amazon QuickSight features. Currently, only geospatial hierarchy is supported. See column_groups.
	ColumnGroups []DataSetColumnGroup `pulumi:"columnGroups"`
	// A set of 1 or more definitions of a [ColumnLevelPermissionRule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_ColumnLevelPermissionRule.html). See column_level_permission_rules.
	ColumnLevelPermissionRules []DataSetColumnLevelPermissionRule `pulumi:"columnLevelPermissionRules"`
	// Identifier for the data set.
	DataSetId string `pulumi:"dataSetId"`
	// The usage configuration to apply to child datasets that reference this dataset as a source. See data_set_usage_configuration.
	DataSetUsageConfiguration *DataSetDataSetUsageConfiguration `pulumi:"dataSetUsageConfiguration"`
	// The folder that contains fields and nested subfolders for your dataset. See field_folders.
	FieldFolders []DataSetFieldFolder `pulumi:"fieldFolders"`
	// Indicates whether you want to import the data into SPICE. Valid values are `SPICE` and `DIRECT_QUERY`.
	ImportMode string `pulumi:"importMode"`
	// Configures the combination and transformation of the data from the physical tables. Maximum of 1 entry. See logical_table_map.
	LogicalTableMaps []DataSetLogicalTableMap `pulumi:"logicalTableMaps"`
	// Display name for the dataset.
	//
	// The following arguments are optional:
	Name *string `pulumi:"name"`
	// A set of resource permissions on the data source. Maximum of 64 items. See permissions.
	Permissions []DataSetPermission `pulumi:"permissions"`
	// Declares the physical tables that are available in the underlying data sources. See physical_table_map.
	PhysicalTableMaps []DataSetPhysicalTableMap `pulumi:"physicalTableMaps"`
	// The refresh properties for the data set. **NOTE**: Only valid when `importMode` is set to `SPICE`. See refresh_properties.
	RefreshProperties *DataSetRefreshProperties `pulumi:"refreshProperties"`
	// The row-level security configuration for the data that you want to create. See row_level_permission_data_set.
	RowLevelPermissionDataSet *DataSetRowLevelPermissionDataSet `pulumi:"rowLevelPermissionDataSet"`
	// The configuration of tags on a dataset to set row-level security. Row-level security tags are currently supported for anonymous embedding only. See row_level_permission_tag_configuration.
	RowLevelPermissionTagConfiguration *DataSetRowLevelPermissionTagConfiguration `pulumi:"rowLevelPermissionTagConfiguration"`
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a DataSet resource.
type DataSetArgs struct {
	// AWS account ID.
	AwsAccountId pulumi.StringPtrInput
	// Groupings of columns that work together in certain Amazon QuickSight features. Currently, only geospatial hierarchy is supported. See column_groups.
	ColumnGroups DataSetColumnGroupArrayInput
	// A set of 1 or more definitions of a [ColumnLevelPermissionRule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_ColumnLevelPermissionRule.html). See column_level_permission_rules.
	ColumnLevelPermissionRules DataSetColumnLevelPermissionRuleArrayInput
	// Identifier for the data set.
	DataSetId pulumi.StringInput
	// The usage configuration to apply to child datasets that reference this dataset as a source. See data_set_usage_configuration.
	DataSetUsageConfiguration DataSetDataSetUsageConfigurationPtrInput
	// The folder that contains fields and nested subfolders for your dataset. See field_folders.
	FieldFolders DataSetFieldFolderArrayInput
	// Indicates whether you want to import the data into SPICE. Valid values are `SPICE` and `DIRECT_QUERY`.
	ImportMode pulumi.StringInput
	// Configures the combination and transformation of the data from the physical tables. Maximum of 1 entry. See logical_table_map.
	LogicalTableMaps DataSetLogicalTableMapArrayInput
	// Display name for the dataset.
	//
	// The following arguments are optional:
	Name pulumi.StringPtrInput
	// A set of resource permissions on the data source. Maximum of 64 items. See permissions.
	Permissions DataSetPermissionArrayInput
	// Declares the physical tables that are available in the underlying data sources. See physical_table_map.
	PhysicalTableMaps DataSetPhysicalTableMapArrayInput
	// The refresh properties for the data set. **NOTE**: Only valid when `importMode` is set to `SPICE`. See refresh_properties.
	RefreshProperties DataSetRefreshPropertiesPtrInput
	// The row-level security configuration for the data that you want to create. See row_level_permission_data_set.
	RowLevelPermissionDataSet DataSetRowLevelPermissionDataSetPtrInput
	// The configuration of tags on a dataset to set row-level security. Row-level security tags are currently supported for anonymous embedding only. See row_level_permission_tag_configuration.
	RowLevelPermissionTagConfiguration DataSetRowLevelPermissionTagConfigurationPtrInput
	// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
}

func (DataSetArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*dataSetArgs)(nil)).Elem()
}

type DataSetInput interface {
	pulumi.Input

	ToDataSetOutput() DataSetOutput
	ToDataSetOutputWithContext(ctx context.Context) DataSetOutput
}

func (*DataSet) ElementType() reflect.Type {
	return reflect.TypeOf((**DataSet)(nil)).Elem()
}

func (i *DataSet) ToDataSetOutput() DataSetOutput {
	return i.ToDataSetOutputWithContext(context.Background())
}

func (i *DataSet) ToDataSetOutputWithContext(ctx context.Context) DataSetOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DataSetOutput)
}

// DataSetArrayInput is an input type that accepts DataSetArray and DataSetArrayOutput values.
// You can construct a concrete instance of `DataSetArrayInput` via:
//
//	DataSetArray{ DataSetArgs{...} }
type DataSetArrayInput interface {
	pulumi.Input

	ToDataSetArrayOutput() DataSetArrayOutput
	ToDataSetArrayOutputWithContext(context.Context) DataSetArrayOutput
}

type DataSetArray []DataSetInput

func (DataSetArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DataSet)(nil)).Elem()
}

func (i DataSetArray) ToDataSetArrayOutput() DataSetArrayOutput {
	return i.ToDataSetArrayOutputWithContext(context.Background())
}

func (i DataSetArray) ToDataSetArrayOutputWithContext(ctx context.Context) DataSetArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DataSetArrayOutput)
}

// DataSetMapInput is an input type that accepts DataSetMap and DataSetMapOutput values.
// You can construct a concrete instance of `DataSetMapInput` via:
//
//	DataSetMap{ "key": DataSetArgs{...} }
type DataSetMapInput interface {
	pulumi.Input

	ToDataSetMapOutput() DataSetMapOutput
	ToDataSetMapOutputWithContext(context.Context) DataSetMapOutput
}

type DataSetMap map[string]DataSetInput

func (DataSetMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DataSet)(nil)).Elem()
}

func (i DataSetMap) ToDataSetMapOutput() DataSetMapOutput {
	return i.ToDataSetMapOutputWithContext(context.Background())
}

func (i DataSetMap) ToDataSetMapOutputWithContext(ctx context.Context) DataSetMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DataSetMapOutput)
}

type DataSetOutput struct{ *pulumi.OutputState }

func (DataSetOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**DataSet)(nil)).Elem()
}

func (o DataSetOutput) ToDataSetOutput() DataSetOutput {
	return o
}

func (o DataSetOutput) ToDataSetOutputWithContext(ctx context.Context) DataSetOutput {
	return o
}

// Amazon Resource Name (ARN) of the data set.
func (o DataSetOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *DataSet) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// AWS account ID.
func (o DataSetOutput) AwsAccountId() pulumi.StringOutput {
	return o.ApplyT(func(v *DataSet) pulumi.StringOutput { return v.AwsAccountId }).(pulumi.StringOutput)
}

// Groupings of columns that work together in certain Amazon QuickSight features. Currently, only geospatial hierarchy is supported. See column_groups.
func (o DataSetOutput) ColumnGroups() DataSetColumnGroupArrayOutput {
	return o.ApplyT(func(v *DataSet) DataSetColumnGroupArrayOutput { return v.ColumnGroups }).(DataSetColumnGroupArrayOutput)
}

// A set of 1 or more definitions of a [ColumnLevelPermissionRule](https://docs.aws.amazon.com/quicksight/latest/APIReference/API_ColumnLevelPermissionRule.html). See column_level_permission_rules.
func (o DataSetOutput) ColumnLevelPermissionRules() DataSetColumnLevelPermissionRuleArrayOutput {
	return o.ApplyT(func(v *DataSet) DataSetColumnLevelPermissionRuleArrayOutput { return v.ColumnLevelPermissionRules }).(DataSetColumnLevelPermissionRuleArrayOutput)
}

// Identifier for the data set.
func (o DataSetOutput) DataSetId() pulumi.StringOutput {
	return o.ApplyT(func(v *DataSet) pulumi.StringOutput { return v.DataSetId }).(pulumi.StringOutput)
}

// The usage configuration to apply to child datasets that reference this dataset as a source. See data_set_usage_configuration.
func (o DataSetOutput) DataSetUsageConfiguration() DataSetDataSetUsageConfigurationOutput {
	return o.ApplyT(func(v *DataSet) DataSetDataSetUsageConfigurationOutput { return v.DataSetUsageConfiguration }).(DataSetDataSetUsageConfigurationOutput)
}

// The folder that contains fields and nested subfolders for your dataset. See field_folders.
func (o DataSetOutput) FieldFolders() DataSetFieldFolderArrayOutput {
	return o.ApplyT(func(v *DataSet) DataSetFieldFolderArrayOutput { return v.FieldFolders }).(DataSetFieldFolderArrayOutput)
}

// Indicates whether you want to import the data into SPICE. Valid values are `SPICE` and `DIRECT_QUERY`.
func (o DataSetOutput) ImportMode() pulumi.StringOutput {
	return o.ApplyT(func(v *DataSet) pulumi.StringOutput { return v.ImportMode }).(pulumi.StringOutput)
}

// Configures the combination and transformation of the data from the physical tables. Maximum of 1 entry. See logical_table_map.
func (o DataSetOutput) LogicalTableMaps() DataSetLogicalTableMapArrayOutput {
	return o.ApplyT(func(v *DataSet) DataSetLogicalTableMapArrayOutput { return v.LogicalTableMaps }).(DataSetLogicalTableMapArrayOutput)
}

// Display name for the dataset.
//
// The following arguments are optional:
func (o DataSetOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *DataSet) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

func (o DataSetOutput) OutputColumns() DataSetOutputColumnArrayOutput {
	return o.ApplyT(func(v *DataSet) DataSetOutputColumnArrayOutput { return v.OutputColumns }).(DataSetOutputColumnArrayOutput)
}

// A set of resource permissions on the data source. Maximum of 64 items. See permissions.
func (o DataSetOutput) Permissions() DataSetPermissionArrayOutput {
	return o.ApplyT(func(v *DataSet) DataSetPermissionArrayOutput { return v.Permissions }).(DataSetPermissionArrayOutput)
}

// Declares the physical tables that are available in the underlying data sources. See physical_table_map.
func (o DataSetOutput) PhysicalTableMaps() DataSetPhysicalTableMapArrayOutput {
	return o.ApplyT(func(v *DataSet) DataSetPhysicalTableMapArrayOutput { return v.PhysicalTableMaps }).(DataSetPhysicalTableMapArrayOutput)
}

// The refresh properties for the data set. **NOTE**: Only valid when `importMode` is set to `SPICE`. See refresh_properties.
func (o DataSetOutput) RefreshProperties() DataSetRefreshPropertiesPtrOutput {
	return o.ApplyT(func(v *DataSet) DataSetRefreshPropertiesPtrOutput { return v.RefreshProperties }).(DataSetRefreshPropertiesPtrOutput)
}

// The row-level security configuration for the data that you want to create. See row_level_permission_data_set.
func (o DataSetOutput) RowLevelPermissionDataSet() DataSetRowLevelPermissionDataSetPtrOutput {
	return o.ApplyT(func(v *DataSet) DataSetRowLevelPermissionDataSetPtrOutput { return v.RowLevelPermissionDataSet }).(DataSetRowLevelPermissionDataSetPtrOutput)
}

// The configuration of tags on a dataset to set row-level security. Row-level security tags are currently supported for anonymous embedding only. See row_level_permission_tag_configuration.
func (o DataSetOutput) RowLevelPermissionTagConfiguration() DataSetRowLevelPermissionTagConfigurationPtrOutput {
	return o.ApplyT(func(v *DataSet) DataSetRowLevelPermissionTagConfigurationPtrOutput {
		return v.RowLevelPermissionTagConfiguration
	}).(DataSetRowLevelPermissionTagConfigurationPtrOutput)
}

// Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o DataSetOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *DataSet) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o DataSetOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *DataSet) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type DataSetArrayOutput struct{ *pulumi.OutputState }

func (DataSetArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*DataSet)(nil)).Elem()
}

func (o DataSetArrayOutput) ToDataSetArrayOutput() DataSetArrayOutput {
	return o
}

func (o DataSetArrayOutput) ToDataSetArrayOutputWithContext(ctx context.Context) DataSetArrayOutput {
	return o
}

func (o DataSetArrayOutput) Index(i pulumi.IntInput) DataSetOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *DataSet {
		return vs[0].([]*DataSet)[vs[1].(int)]
	}).(DataSetOutput)
}

type DataSetMapOutput struct{ *pulumi.OutputState }

func (DataSetMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*DataSet)(nil)).Elem()
}

func (o DataSetMapOutput) ToDataSetMapOutput() DataSetMapOutput {
	return o
}

func (o DataSetMapOutput) ToDataSetMapOutputWithContext(ctx context.Context) DataSetMapOutput {
	return o
}

func (o DataSetMapOutput) MapIndex(k pulumi.StringInput) DataSetOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *DataSet {
		return vs[0].(map[string]*DataSet)[vs[1].(string)]
	}).(DataSetOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*DataSetInput)(nil)).Elem(), &DataSet{})
	pulumi.RegisterInputType(reflect.TypeOf((*DataSetArrayInput)(nil)).Elem(), DataSetArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*DataSetMapInput)(nil)).Elem(), DataSetMap{})
	pulumi.RegisterOutputType(DataSetOutput{})
	pulumi.RegisterOutputType(DataSetArrayOutput{})
	pulumi.RegisterOutputType(DataSetMapOutput{})
}
