// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package timestreamwrite

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Data source for managing an AWS Timestream Write Database.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/timestreamwrite"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := timestreamwrite.LookupDatabase(ctx, &timestreamwrite.LookupDatabaseArgs{
//				Name: "database-example",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupDatabase(ctx *pulumi.Context, args *LookupDatabaseArgs, opts ...pulumi.InvokeOption) (*LookupDatabaseResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupDatabaseResult
	err := ctx.Invoke("aws:timestreamwrite/getDatabase:getDatabase", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getDatabase.
type LookupDatabaseArgs struct {
	Name string `pulumi:"name"`
}

// A collection of values returned by getDatabase.
type LookupDatabaseResult struct {
	// The ARN that uniquely identifies this database.
	Arn string `pulumi:"arn"`
	// Creation time of database.
	CreatedTime string `pulumi:"createdTime"`
	// The provider-assigned unique ID for this managed resource.
	Id string `pulumi:"id"`
	// The ARN of the KMS key used to encrypt the data stored in the database.
	KmsKeyId string `pulumi:"kmsKeyId"`
	// Last time database was updated.
	LastUpdatedTime string `pulumi:"lastUpdatedTime"`
	Name            string `pulumi:"name"`
	// Total number of tables in the Timestream database.
	TableCount int `pulumi:"tableCount"`
}

func LookupDatabaseOutput(ctx *pulumi.Context, args LookupDatabaseOutputArgs, opts ...pulumi.InvokeOption) LookupDatabaseResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupDatabaseResultOutput, error) {
			args := v.(LookupDatabaseArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:timestreamwrite/getDatabase:getDatabase", args, LookupDatabaseResultOutput{}, options).(LookupDatabaseResultOutput), nil
		}).(LookupDatabaseResultOutput)
}

// A collection of arguments for invoking getDatabase.
type LookupDatabaseOutputArgs struct {
	Name pulumi.StringInput `pulumi:"name"`
}

func (LookupDatabaseOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupDatabaseArgs)(nil)).Elem()
}

// A collection of values returned by getDatabase.
type LookupDatabaseResultOutput struct{ *pulumi.OutputState }

func (LookupDatabaseResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupDatabaseResult)(nil)).Elem()
}

func (o LookupDatabaseResultOutput) ToLookupDatabaseResultOutput() LookupDatabaseResultOutput {
	return o
}

func (o LookupDatabaseResultOutput) ToLookupDatabaseResultOutputWithContext(ctx context.Context) LookupDatabaseResultOutput {
	return o
}

// The ARN that uniquely identifies this database.
func (o LookupDatabaseResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDatabaseResult) string { return v.Arn }).(pulumi.StringOutput)
}

// Creation time of database.
func (o LookupDatabaseResultOutput) CreatedTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDatabaseResult) string { return v.CreatedTime }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupDatabaseResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDatabaseResult) string { return v.Id }).(pulumi.StringOutput)
}

// The ARN of the KMS key used to encrypt the data stored in the database.
func (o LookupDatabaseResultOutput) KmsKeyId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDatabaseResult) string { return v.KmsKeyId }).(pulumi.StringOutput)
}

// Last time database was updated.
func (o LookupDatabaseResultOutput) LastUpdatedTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDatabaseResult) string { return v.LastUpdatedTime }).(pulumi.StringOutput)
}

func (o LookupDatabaseResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupDatabaseResult) string { return v.Name }).(pulumi.StringOutput)
}

// Total number of tables in the Timestream database.
func (o LookupDatabaseResultOutput) TableCount() pulumi.IntOutput {
	return o.ApplyT(func(v LookupDatabaseResult) int { return v.TableCount }).(pulumi.IntOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupDatabaseResultOutput{})
}
