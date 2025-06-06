// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package glue

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// This data source can be used to fetch information about an AWS Glue Data Catalog Table.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/glue"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := glue.LookupCatalogTable(ctx, &glue.LookupCatalogTableArgs{
//				Name:         "MyCatalogTable",
//				DatabaseName: "MyCatalogDatabase",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupCatalogTable(ctx *pulumi.Context, args *LookupCatalogTableArgs, opts ...pulumi.InvokeOption) (*LookupCatalogTableResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupCatalogTableResult
	err := ctx.Invoke("aws:glue/getCatalogTable:getCatalogTable", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getCatalogTable.
type LookupCatalogTableArgs struct {
	// ID of the Glue Catalog and database where the table metadata resides. If omitted, this defaults to the current AWS Account ID.
	CatalogId *string `pulumi:"catalogId"`
	// Name of the metadata database where the table metadata resides.
	DatabaseName string `pulumi:"databaseName"`
	// Name of the table.
	Name string `pulumi:"name"`
	// The time as of when to read the table contents. If not set, the most recent transaction commit time will be used. Cannot be specified along with `transactionId`. Specified in RFC 3339 format, e.g. `2006-01-02T15:04:05Z07:00`.
	QueryAsOfTime *string `pulumi:"queryAsOfTime"`
	// The transaction ID at which to read the table contents.
	TransactionId *int `pulumi:"transactionId"`
}

// A collection of values returned by getCatalogTable.
type LookupCatalogTableResult struct {
	// The ARN of the Glue Table.
	Arn string `pulumi:"arn"`
	// ID of the Data Catalog in which the table resides.
	CatalogId string `pulumi:"catalogId"`
	// Name of the catalog database that contains the target table.
	DatabaseName string `pulumi:"databaseName"`
	// Description of the table.
	Description string `pulumi:"description"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// Name of the target table.
	Name string `pulumi:"name"`
	// Owner of the table.
	Owner string `pulumi:"owner"`
	// Map of initialization parameters for the SerDe, in key-value form.
	Parameters map[string]string `pulumi:"parameters"`
	// Configuration block for a maximum of 3 partition indexes. See `partitionIndex` below.
	PartitionIndices []GetCatalogTablePartitionIndex `pulumi:"partitionIndices"`
	// Configuration block of columns by which the table is partitioned. Only primitive types are supported as partition keys. See `partitionKeys` below.
	PartitionKeys []GetCatalogTablePartitionKey `pulumi:"partitionKeys"`
	QueryAsOfTime *string                       `pulumi:"queryAsOfTime"`
	// Retention time for this table.
	Retention int `pulumi:"retention"`
	// Configuration block for information about the physical storage of this table. For more information, refer to the [Glue Developer Guide](https://docs.aws.amazon.com/glue/latest/dg/aws-glue-api-catalog-tables.html#aws-glue-api-catalog-tables-StorageDescriptor). See `storageDescriptor` below.
	StorageDescriptors []GetCatalogTableStorageDescriptor `pulumi:"storageDescriptors"`
	// Type of this table (EXTERNAL_TABLE, VIRTUAL_VIEW, etc.). While optional, some Athena DDL queries such as `ALTER TABLE` and `SHOW CREATE TABLE` will fail if this argument is empty.
	TableType string `pulumi:"tableType"`
	// Configuration block of a target table for resource linking. See `targetTable` below.
	TargetTables  []GetCatalogTableTargetTable `pulumi:"targetTables"`
	TransactionId *int                         `pulumi:"transactionId"`
	// If the table is a view, the expanded text of the view; otherwise null.
	ViewExpandedText string `pulumi:"viewExpandedText"`
	// If the table is a view, the original text of the view; otherwise null.
	ViewOriginalText string `pulumi:"viewOriginalText"`
}

func LookupCatalogTableOutput(ctx *pulumi.Context, args LookupCatalogTableOutputArgs, opts ...pulumi.InvokeOption) LookupCatalogTableResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupCatalogTableResultOutput, error) {
			args := v.(LookupCatalogTableArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:glue/getCatalogTable:getCatalogTable", args, LookupCatalogTableResultOutput{}, options).(LookupCatalogTableResultOutput), nil
		}).(LookupCatalogTableResultOutput)
}

// A collection of arguments for invoking getCatalogTable.
type LookupCatalogTableOutputArgs struct {
	// ID of the Glue Catalog and database where the table metadata resides. If omitted, this defaults to the current AWS Account ID.
	CatalogId pulumi.StringPtrInput `pulumi:"catalogId"`
	// Name of the metadata database where the table metadata resides.
	DatabaseName pulumi.StringInput `pulumi:"databaseName"`
	// Name of the table.
	Name pulumi.StringInput `pulumi:"name"`
	// The time as of when to read the table contents. If not set, the most recent transaction commit time will be used. Cannot be specified along with `transactionId`. Specified in RFC 3339 format, e.g. `2006-01-02T15:04:05Z07:00`.
	QueryAsOfTime pulumi.StringPtrInput `pulumi:"queryAsOfTime"`
	// The transaction ID at which to read the table contents.
	TransactionId pulumi.IntPtrInput `pulumi:"transactionId"`
}

func (LookupCatalogTableOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupCatalogTableArgs)(nil)).Elem()
}

// A collection of values returned by getCatalogTable.
type LookupCatalogTableResultOutput struct{ *pulumi.OutputState }

func (LookupCatalogTableResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupCatalogTableResult)(nil)).Elem()
}

func (o LookupCatalogTableResultOutput) ToLookupCatalogTableResultOutput() LookupCatalogTableResultOutput {
	return o
}

func (o LookupCatalogTableResultOutput) ToLookupCatalogTableResultOutputWithContext(ctx context.Context) LookupCatalogTableResultOutput {
	return o
}

// The ARN of the Glue Table.
func (o LookupCatalogTableResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.Arn }).(pulumi.StringOutput)
}

// ID of the Data Catalog in which the table resides.
func (o LookupCatalogTableResultOutput) CatalogId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.CatalogId }).(pulumi.StringOutput)
}

// Name of the catalog database that contains the target table.
func (o LookupCatalogTableResultOutput) DatabaseName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.DatabaseName }).(pulumi.StringOutput)
}

// Description of the table.
func (o LookupCatalogTableResultOutput) Description() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.Description }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupCatalogTableResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.Id }).(pulumi.StringOutput)
}

// Name of the target table.
func (o LookupCatalogTableResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.Name }).(pulumi.StringOutput)
}

// Owner of the table.
func (o LookupCatalogTableResultOutput) Owner() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.Owner }).(pulumi.StringOutput)
}

// Map of initialization parameters for the SerDe, in key-value form.
func (o LookupCatalogTableResultOutput) Parameters() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) map[string]string { return v.Parameters }).(pulumi.StringMapOutput)
}

// Configuration block for a maximum of 3 partition indexes. See `partitionIndex` below.
func (o LookupCatalogTableResultOutput) PartitionIndices() GetCatalogTablePartitionIndexArrayOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) []GetCatalogTablePartitionIndex { return v.PartitionIndices }).(GetCatalogTablePartitionIndexArrayOutput)
}

// Configuration block of columns by which the table is partitioned. Only primitive types are supported as partition keys. See `partitionKeys` below.
func (o LookupCatalogTableResultOutput) PartitionKeys() GetCatalogTablePartitionKeyArrayOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) []GetCatalogTablePartitionKey { return v.PartitionKeys }).(GetCatalogTablePartitionKeyArrayOutput)
}

func (o LookupCatalogTableResultOutput) QueryAsOfTime() pulumi.StringPtrOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) *string { return v.QueryAsOfTime }).(pulumi.StringPtrOutput)
}

// Retention time for this table.
func (o LookupCatalogTableResultOutput) Retention() pulumi.IntOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) int { return v.Retention }).(pulumi.IntOutput)
}

// Configuration block for information about the physical storage of this table. For more information, refer to the [Glue Developer Guide](https://docs.aws.amazon.com/glue/latest/dg/aws-glue-api-catalog-tables.html#aws-glue-api-catalog-tables-StorageDescriptor). See `storageDescriptor` below.
func (o LookupCatalogTableResultOutput) StorageDescriptors() GetCatalogTableStorageDescriptorArrayOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) []GetCatalogTableStorageDescriptor { return v.StorageDescriptors }).(GetCatalogTableStorageDescriptorArrayOutput)
}

// Type of this table (EXTERNAL_TABLE, VIRTUAL_VIEW, etc.). While optional, some Athena DDL queries such as `ALTER TABLE` and `SHOW CREATE TABLE` will fail if this argument is empty.
func (o LookupCatalogTableResultOutput) TableType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.TableType }).(pulumi.StringOutput)
}

// Configuration block of a target table for resource linking. See `targetTable` below.
func (o LookupCatalogTableResultOutput) TargetTables() GetCatalogTableTargetTableArrayOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) []GetCatalogTableTargetTable { return v.TargetTables }).(GetCatalogTableTargetTableArrayOutput)
}

func (o LookupCatalogTableResultOutput) TransactionId() pulumi.IntPtrOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) *int { return v.TransactionId }).(pulumi.IntPtrOutput)
}

// If the table is a view, the expanded text of the view; otherwise null.
func (o LookupCatalogTableResultOutput) ViewExpandedText() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.ViewExpandedText }).(pulumi.StringOutput)
}

// If the table is a view, the original text of the view; otherwise null.
func (o LookupCatalogTableResultOutput) ViewOriginalText() pulumi.StringOutput {
	return o.ApplyT(func(v LookupCatalogTableResult) string { return v.ViewOriginalText }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupCatalogTableResultOutput{})
}
