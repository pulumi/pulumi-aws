// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package dynamodb

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides information about a DynamoDB table.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/dynamodb"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := dynamodb.LookupTable(ctx, &dynamodb.LookupTableArgs{
//				Name: "tableName",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupTable(ctx *pulumi.Context, args *LookupTableArgs, opts ...pulumi.InvokeOption) (*LookupTableResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupTableResult
	err := ctx.Invoke("aws:dynamodb/getTable:getTable", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getTable.
type LookupTableArgs struct {
	// Name of the DynamoDB table.
	Name                 string                        `pulumi:"name"`
	ServerSideEncryption *GetTableServerSideEncryption `pulumi:"serverSideEncryption"`
	Tags                 map[string]string             `pulumi:"tags"`
}

// A collection of values returned by getTable.
type LookupTableResult struct {
	Arn                       string                         `pulumi:"arn"`
	Attributes                []GetTableAttribute            `pulumi:"attributes"`
	BillingMode               string                         `pulumi:"billingMode"`
	DeletionProtectionEnabled bool                           `pulumi:"deletionProtectionEnabled"`
	GlobalSecondaryIndexes    []GetTableGlobalSecondaryIndex `pulumi:"globalSecondaryIndexes"`
	HashKey                   string                         `pulumi:"hashKey"`
	// The provider-assigned unique ID for this managed resource.
	Id                    string                        `pulumi:"id"`
	LocalSecondaryIndexes []GetTableLocalSecondaryIndex `pulumi:"localSecondaryIndexes"`
	Name                  string                        `pulumi:"name"`
	OnDemandThroughputs   []GetTableOnDemandThroughput  `pulumi:"onDemandThroughputs"`
	PointInTimeRecovery   GetTablePointInTimeRecovery   `pulumi:"pointInTimeRecovery"`
	RangeKey              string                        `pulumi:"rangeKey"`
	ReadCapacity          int                           `pulumi:"readCapacity"`
	Replicas              []GetTableReplicaType         `pulumi:"replicas"`
	ServerSideEncryption  GetTableServerSideEncryption  `pulumi:"serverSideEncryption"`
	StreamArn             string                        `pulumi:"streamArn"`
	StreamEnabled         bool                          `pulumi:"streamEnabled"`
	StreamLabel           string                        `pulumi:"streamLabel"`
	StreamViewType        string                        `pulumi:"streamViewType"`
	TableClass            string                        `pulumi:"tableClass"`
	Tags                  map[string]string             `pulumi:"tags"`
	Ttl                   GetTableTtl                   `pulumi:"ttl"`
	WriteCapacity         int                           `pulumi:"writeCapacity"`
}

func LookupTableOutput(ctx *pulumi.Context, args LookupTableOutputArgs, opts ...pulumi.InvokeOption) LookupTableResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupTableResultOutput, error) {
			args := v.(LookupTableArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:dynamodb/getTable:getTable", args, LookupTableResultOutput{}, options).(LookupTableResultOutput), nil
		}).(LookupTableResultOutput)
}

// A collection of arguments for invoking getTable.
type LookupTableOutputArgs struct {
	// Name of the DynamoDB table.
	Name                 pulumi.StringInput                   `pulumi:"name"`
	ServerSideEncryption GetTableServerSideEncryptionPtrInput `pulumi:"serverSideEncryption"`
	Tags                 pulumi.StringMapInput                `pulumi:"tags"`
}

func (LookupTableOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupTableArgs)(nil)).Elem()
}

// A collection of values returned by getTable.
type LookupTableResultOutput struct{ *pulumi.OutputState }

func (LookupTableResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupTableResult)(nil)).Elem()
}

func (o LookupTableResultOutput) ToLookupTableResultOutput() LookupTableResultOutput {
	return o
}

func (o LookupTableResultOutput) ToLookupTableResultOutputWithContext(ctx context.Context) LookupTableResultOutput {
	return o
}

func (o LookupTableResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.Arn }).(pulumi.StringOutput)
}

func (o LookupTableResultOutput) Attributes() GetTableAttributeArrayOutput {
	return o.ApplyT(func(v LookupTableResult) []GetTableAttribute { return v.Attributes }).(GetTableAttributeArrayOutput)
}

func (o LookupTableResultOutput) BillingMode() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.BillingMode }).(pulumi.StringOutput)
}

func (o LookupTableResultOutput) DeletionProtectionEnabled() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupTableResult) bool { return v.DeletionProtectionEnabled }).(pulumi.BoolOutput)
}

func (o LookupTableResultOutput) GlobalSecondaryIndexes() GetTableGlobalSecondaryIndexArrayOutput {
	return o.ApplyT(func(v LookupTableResult) []GetTableGlobalSecondaryIndex { return v.GlobalSecondaryIndexes }).(GetTableGlobalSecondaryIndexArrayOutput)
}

func (o LookupTableResultOutput) HashKey() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.HashKey }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupTableResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o LookupTableResultOutput) LocalSecondaryIndexes() GetTableLocalSecondaryIndexArrayOutput {
	return o.ApplyT(func(v LookupTableResult) []GetTableLocalSecondaryIndex { return v.LocalSecondaryIndexes }).(GetTableLocalSecondaryIndexArrayOutput)
}

func (o LookupTableResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.Name }).(pulumi.StringOutput)
}

func (o LookupTableResultOutput) OnDemandThroughputs() GetTableOnDemandThroughputArrayOutput {
	return o.ApplyT(func(v LookupTableResult) []GetTableOnDemandThroughput { return v.OnDemandThroughputs }).(GetTableOnDemandThroughputArrayOutput)
}

func (o LookupTableResultOutput) PointInTimeRecovery() GetTablePointInTimeRecoveryOutput {
	return o.ApplyT(func(v LookupTableResult) GetTablePointInTimeRecovery { return v.PointInTimeRecovery }).(GetTablePointInTimeRecoveryOutput)
}

func (o LookupTableResultOutput) RangeKey() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.RangeKey }).(pulumi.StringOutput)
}

func (o LookupTableResultOutput) ReadCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupTableResult) int { return v.ReadCapacity }).(pulumi.IntOutput)
}

func (o LookupTableResultOutput) Replicas() GetTableReplicaTypeArrayOutput {
	return o.ApplyT(func(v LookupTableResult) []GetTableReplicaType { return v.Replicas }).(GetTableReplicaTypeArrayOutput)
}

func (o LookupTableResultOutput) ServerSideEncryption() GetTableServerSideEncryptionOutput {
	return o.ApplyT(func(v LookupTableResult) GetTableServerSideEncryption { return v.ServerSideEncryption }).(GetTableServerSideEncryptionOutput)
}

func (o LookupTableResultOutput) StreamArn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.StreamArn }).(pulumi.StringOutput)
}

func (o LookupTableResultOutput) StreamEnabled() pulumi.BoolOutput {
	return o.ApplyT(func(v LookupTableResult) bool { return v.StreamEnabled }).(pulumi.BoolOutput)
}

func (o LookupTableResultOutput) StreamLabel() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.StreamLabel }).(pulumi.StringOutput)
}

func (o LookupTableResultOutput) StreamViewType() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.StreamViewType }).(pulumi.StringOutput)
}

func (o LookupTableResultOutput) TableClass() pulumi.StringOutput {
	return o.ApplyT(func(v LookupTableResult) string { return v.TableClass }).(pulumi.StringOutput)
}

func (o LookupTableResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupTableResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

func (o LookupTableResultOutput) Ttl() GetTableTtlOutput {
	return o.ApplyT(func(v LookupTableResult) GetTableTtl { return v.Ttl }).(GetTableTtlOutput)
}

func (o LookupTableResultOutput) WriteCapacity() pulumi.IntOutput {
	return o.ApplyT(func(v LookupTableResult) int { return v.WriteCapacity }).(pulumi.IntOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupTableResultOutput{})
}
