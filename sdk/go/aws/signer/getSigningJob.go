// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package signer

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides information about a Signer Signing Job.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/signer"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := signer.LookupSigningJob(ctx, &signer.LookupSigningJobArgs{
//				JobId: "9ed7e5c3-b8d4-4da0-8459-44e0b068f7ee",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupSigningJob(ctx *pulumi.Context, args *LookupSigningJobArgs, opts ...pulumi.InvokeOption) (*LookupSigningJobResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupSigningJobResult
	err := ctx.Invoke("aws:signer/getSigningJob:getSigningJob", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getSigningJob.
type LookupSigningJobArgs struct {
	// ID of the signing job on output.
	JobId string `pulumi:"jobId"`
}

// A collection of values returned by getSigningJob.
type LookupSigningJobResult struct {
	// Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the signing job was completed.
	CompletedAt string `pulumi:"completedAt"`
	// Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the signing job was created.
	CreatedAt string `pulumi:"createdAt"`
	// The provider-assigned unique ID for this managed resource.
	Id    string `pulumi:"id"`
	JobId string `pulumi:"jobId"`
	// IAM entity that initiated the signing job.
	JobInvoker string `pulumi:"jobInvoker"`
	// AWS account ID of the job owner.
	JobOwner string `pulumi:"jobOwner"`
	// A human-readable name for the signing platform associated with the signing job.
	PlatformDisplayName string `pulumi:"platformDisplayName"`
	// Platform to which your signed code image will be distributed.
	PlatformId string `pulumi:"platformId"`
	// Name of the profile that initiated the signing operation.
	ProfileName string `pulumi:"profileName"`
	// Version of the signing profile used to initiate the signing job.
	ProfileVersion string `pulumi:"profileVersion"`
	// IAM principal that requested the signing job.
	RequestedBy string `pulumi:"requestedBy"`
	// Revocation record if the signature generated by the signing job has been revoked. Contains a timestamp and the ID of the IAM entity that revoked the signature.
	RevocationRecords []GetSigningJobRevocationRecord `pulumi:"revocationRecords"`
	// The time when the signature of a signing job expires.
	SignatureExpiresAt string `pulumi:"signatureExpiresAt"`
	// Name of the S3 bucket where the signed code image is saved by code signing.
	SignedObjects []GetSigningJobSignedObject `pulumi:"signedObjects"`
	// Object that contains the name of your S3 bucket or your raw code.
	Sources []GetSigningJobSource `pulumi:"sources"`
	// Status of the signing job.
	Status string `pulumi:"status"`
	// String value that contains the status reason.
	StatusReason string `pulumi:"statusReason"`
}

func LookupSigningJobOutput(ctx *pulumi.Context, args LookupSigningJobOutputArgs, opts ...pulumi.InvokeOption) LookupSigningJobResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupSigningJobResultOutput, error) {
			args := v.(LookupSigningJobArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:signer/getSigningJob:getSigningJob", args, LookupSigningJobResultOutput{}, options).(LookupSigningJobResultOutput), nil
		}).(LookupSigningJobResultOutput)
}

// A collection of arguments for invoking getSigningJob.
type LookupSigningJobOutputArgs struct {
	// ID of the signing job on output.
	JobId pulumi.StringInput `pulumi:"jobId"`
}

func (LookupSigningJobOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupSigningJobArgs)(nil)).Elem()
}

// A collection of values returned by getSigningJob.
type LookupSigningJobResultOutput struct{ *pulumi.OutputState }

func (LookupSigningJobResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupSigningJobResult)(nil)).Elem()
}

func (o LookupSigningJobResultOutput) ToLookupSigningJobResultOutput() LookupSigningJobResultOutput {
	return o
}

func (o LookupSigningJobResultOutput) ToLookupSigningJobResultOutputWithContext(ctx context.Context) LookupSigningJobResultOutput {
	return o
}

// Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the signing job was completed.
func (o LookupSigningJobResultOutput) CompletedAt() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.CompletedAt }).(pulumi.StringOutput)
}

// Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the signing job was created.
func (o LookupSigningJobResultOutput) CreatedAt() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.CreatedAt }).(pulumi.StringOutput)
}

// The provider-assigned unique ID for this managed resource.
func (o LookupSigningJobResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.Id }).(pulumi.StringOutput)
}

func (o LookupSigningJobResultOutput) JobId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.JobId }).(pulumi.StringOutput)
}

// IAM entity that initiated the signing job.
func (o LookupSigningJobResultOutput) JobInvoker() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.JobInvoker }).(pulumi.StringOutput)
}

// AWS account ID of the job owner.
func (o LookupSigningJobResultOutput) JobOwner() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.JobOwner }).(pulumi.StringOutput)
}

// A human-readable name for the signing platform associated with the signing job.
func (o LookupSigningJobResultOutput) PlatformDisplayName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.PlatformDisplayName }).(pulumi.StringOutput)
}

// Platform to which your signed code image will be distributed.
func (o LookupSigningJobResultOutput) PlatformId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.PlatformId }).(pulumi.StringOutput)
}

// Name of the profile that initiated the signing operation.
func (o LookupSigningJobResultOutput) ProfileName() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.ProfileName }).(pulumi.StringOutput)
}

// Version of the signing profile used to initiate the signing job.
func (o LookupSigningJobResultOutput) ProfileVersion() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.ProfileVersion }).(pulumi.StringOutput)
}

// IAM principal that requested the signing job.
func (o LookupSigningJobResultOutput) RequestedBy() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.RequestedBy }).(pulumi.StringOutput)
}

// Revocation record if the signature generated by the signing job has been revoked. Contains a timestamp and the ID of the IAM entity that revoked the signature.
func (o LookupSigningJobResultOutput) RevocationRecords() GetSigningJobRevocationRecordArrayOutput {
	return o.ApplyT(func(v LookupSigningJobResult) []GetSigningJobRevocationRecord { return v.RevocationRecords }).(GetSigningJobRevocationRecordArrayOutput)
}

// The time when the signature of a signing job expires.
func (o LookupSigningJobResultOutput) SignatureExpiresAt() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.SignatureExpiresAt }).(pulumi.StringOutput)
}

// Name of the S3 bucket where the signed code image is saved by code signing.
func (o LookupSigningJobResultOutput) SignedObjects() GetSigningJobSignedObjectArrayOutput {
	return o.ApplyT(func(v LookupSigningJobResult) []GetSigningJobSignedObject { return v.SignedObjects }).(GetSigningJobSignedObjectArrayOutput)
}

// Object that contains the name of your S3 bucket or your raw code.
func (o LookupSigningJobResultOutput) Sources() GetSigningJobSourceArrayOutput {
	return o.ApplyT(func(v LookupSigningJobResult) []GetSigningJobSource { return v.Sources }).(GetSigningJobSourceArrayOutput)
}

// Status of the signing job.
func (o LookupSigningJobResultOutput) Status() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.Status }).(pulumi.StringOutput)
}

// String value that contains the status reason.
func (o LookupSigningJobResultOutput) StatusReason() pulumi.StringOutput {
	return o.ApplyT(func(v LookupSigningJobResult) string { return v.StatusReason }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupSigningJobResultOutput{})
}
