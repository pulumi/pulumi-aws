// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package fsx

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Retrieve information on FSx ONTAP Storage Virtual Machine (SVM).
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
//			_, err := fsx.LookupOntapStorageVirtualMachine(ctx, &fsx.LookupOntapStorageVirtualMachineArgs{
//				Id: pulumi.StringRef("svm-12345678"),
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### Filter Example
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
//			_, err := fsx.LookupOntapStorageVirtualMachine(ctx, &fsx.LookupOntapStorageVirtualMachineArgs{
//				Filters: []fsx.GetOntapStorageVirtualMachineFilter{
//					{
//						Name: "file-system-id",
//						Values: []string{
//							"fs-12345678",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
func LookupOntapStorageVirtualMachine(ctx *pulumi.Context, args *LookupOntapStorageVirtualMachineArgs, opts ...pulumi.InvokeOption) (*LookupOntapStorageVirtualMachineResult, error) {
	opts = internal.PkgInvokeDefaultOpts(opts)
	var rv LookupOntapStorageVirtualMachineResult
	err := ctx.Invoke("aws:fsx/getOntapStorageVirtualMachine:getOntapStorageVirtualMachine", args, &rv, opts...)
	if err != nil {
		return nil, err
	}
	return &rv, nil
}

// A collection of arguments for invoking getOntapStorageVirtualMachine.
type LookupOntapStorageVirtualMachineArgs struct {
	// Configuration block. Detailed below.
	Filters []GetOntapStorageVirtualMachineFilter `pulumi:"filters"`
	// Identifier of the storage virtual machine (e.g. `svm-12345678`).
	//
	// The arguments of this data source act as filters for querying the available ONTAP Storage Virtual Machines in the current region. The given filters must match exactly one Storage Virtual Machine whose data will be exported as attributes.
	Id   *string           `pulumi:"id"`
	Tags map[string]string `pulumi:"tags"`
}

// A collection of values returned by getOntapStorageVirtualMachine.
type LookupOntapStorageVirtualMachineResult struct {
	// The Microsoft Active Directory configuration to which the SVM is joined, if applicable. See Active Directory Configuration below.
	ActiveDirectoryConfigurations []GetOntapStorageVirtualMachineActiveDirectoryConfiguration `pulumi:"activeDirectoryConfigurations"`
	// Amazon Resource Name of the SVM.
	Arn string `pulumi:"arn"`
	// The time that the SVM was created.
	CreationTime string `pulumi:"creationTime"`
	// The endpoints that are used to access data or to manage the SVM using the NetApp ONTAP CLI, REST API, or NetApp CloudManager. They are the Iscsi, Management, Nfs, and Smb endpoints. See SVM Endpoints below.
	Endpoints []GetOntapStorageVirtualMachineEndpoint `pulumi:"endpoints"`
	// Identifier of the file system (e.g. `fs-12345678`).
	FileSystemId string                                `pulumi:"fileSystemId"`
	Filters      []GetOntapStorageVirtualMachineFilter `pulumi:"filters"`
	// The SVM's system generated unique ID.
	Id string `pulumi:"id"`
	// The SVM's lifecycle status.
	LifecycleStatus string `pulumi:"lifecycleStatus"`
	// Describes why the SVM lifecycle state changed. See Lifecycle Transition Reason below.
	LifecycleTransitionReasons []GetOntapStorageVirtualMachineLifecycleTransitionReason `pulumi:"lifecycleTransitionReasons"`
	// The name of the SVM, if provisioned.
	Name string `pulumi:"name"`
	// The SVM's subtype.
	Subtype string            `pulumi:"subtype"`
	Tags    map[string]string `pulumi:"tags"`
	// The SVM's UUID.
	Uuid string `pulumi:"uuid"`
}

func LookupOntapStorageVirtualMachineOutput(ctx *pulumi.Context, args LookupOntapStorageVirtualMachineOutputArgs, opts ...pulumi.InvokeOption) LookupOntapStorageVirtualMachineResultOutput {
	return pulumi.ToOutputWithContext(ctx.Context(), args).
		ApplyT(func(v interface{}) (LookupOntapStorageVirtualMachineResultOutput, error) {
			args := v.(LookupOntapStorageVirtualMachineArgs)
			options := pulumi.InvokeOutputOptions{InvokeOptions: internal.PkgInvokeDefaultOpts(opts)}
			return ctx.InvokeOutput("aws:fsx/getOntapStorageVirtualMachine:getOntapStorageVirtualMachine", args, LookupOntapStorageVirtualMachineResultOutput{}, options).(LookupOntapStorageVirtualMachineResultOutput), nil
		}).(LookupOntapStorageVirtualMachineResultOutput)
}

// A collection of arguments for invoking getOntapStorageVirtualMachine.
type LookupOntapStorageVirtualMachineOutputArgs struct {
	// Configuration block. Detailed below.
	Filters GetOntapStorageVirtualMachineFilterArrayInput `pulumi:"filters"`
	// Identifier of the storage virtual machine (e.g. `svm-12345678`).
	//
	// The arguments of this data source act as filters for querying the available ONTAP Storage Virtual Machines in the current region. The given filters must match exactly one Storage Virtual Machine whose data will be exported as attributes.
	Id   pulumi.StringPtrInput `pulumi:"id"`
	Tags pulumi.StringMapInput `pulumi:"tags"`
}

func (LookupOntapStorageVirtualMachineOutputArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupOntapStorageVirtualMachineArgs)(nil)).Elem()
}

// A collection of values returned by getOntapStorageVirtualMachine.
type LookupOntapStorageVirtualMachineResultOutput struct{ *pulumi.OutputState }

func (LookupOntapStorageVirtualMachineResultOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*LookupOntapStorageVirtualMachineResult)(nil)).Elem()
}

func (o LookupOntapStorageVirtualMachineResultOutput) ToLookupOntapStorageVirtualMachineResultOutput() LookupOntapStorageVirtualMachineResultOutput {
	return o
}

func (o LookupOntapStorageVirtualMachineResultOutput) ToLookupOntapStorageVirtualMachineResultOutputWithContext(ctx context.Context) LookupOntapStorageVirtualMachineResultOutput {
	return o
}

// The Microsoft Active Directory configuration to which the SVM is joined, if applicable. See Active Directory Configuration below.
func (o LookupOntapStorageVirtualMachineResultOutput) ActiveDirectoryConfigurations() GetOntapStorageVirtualMachineActiveDirectoryConfigurationArrayOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) []GetOntapStorageVirtualMachineActiveDirectoryConfiguration {
		return v.ActiveDirectoryConfigurations
	}).(GetOntapStorageVirtualMachineActiveDirectoryConfigurationArrayOutput)
}

// Amazon Resource Name of the SVM.
func (o LookupOntapStorageVirtualMachineResultOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) string { return v.Arn }).(pulumi.StringOutput)
}

// The time that the SVM was created.
func (o LookupOntapStorageVirtualMachineResultOutput) CreationTime() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) string { return v.CreationTime }).(pulumi.StringOutput)
}

// The endpoints that are used to access data or to manage the SVM using the NetApp ONTAP CLI, REST API, or NetApp CloudManager. They are the Iscsi, Management, Nfs, and Smb endpoints. See SVM Endpoints below.
func (o LookupOntapStorageVirtualMachineResultOutput) Endpoints() GetOntapStorageVirtualMachineEndpointArrayOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) []GetOntapStorageVirtualMachineEndpoint {
		return v.Endpoints
	}).(GetOntapStorageVirtualMachineEndpointArrayOutput)
}

// Identifier of the file system (e.g. `fs-12345678`).
func (o LookupOntapStorageVirtualMachineResultOutput) FileSystemId() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) string { return v.FileSystemId }).(pulumi.StringOutput)
}

func (o LookupOntapStorageVirtualMachineResultOutput) Filters() GetOntapStorageVirtualMachineFilterArrayOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) []GetOntapStorageVirtualMachineFilter { return v.Filters }).(GetOntapStorageVirtualMachineFilterArrayOutput)
}

// The SVM's system generated unique ID.
func (o LookupOntapStorageVirtualMachineResultOutput) Id() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) string { return v.Id }).(pulumi.StringOutput)
}

// The SVM's lifecycle status.
func (o LookupOntapStorageVirtualMachineResultOutput) LifecycleStatus() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) string { return v.LifecycleStatus }).(pulumi.StringOutput)
}

// Describes why the SVM lifecycle state changed. See Lifecycle Transition Reason below.
func (o LookupOntapStorageVirtualMachineResultOutput) LifecycleTransitionReasons() GetOntapStorageVirtualMachineLifecycleTransitionReasonArrayOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) []GetOntapStorageVirtualMachineLifecycleTransitionReason {
		return v.LifecycleTransitionReasons
	}).(GetOntapStorageVirtualMachineLifecycleTransitionReasonArrayOutput)
}

// The name of the SVM, if provisioned.
func (o LookupOntapStorageVirtualMachineResultOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) string { return v.Name }).(pulumi.StringOutput)
}

// The SVM's subtype.
func (o LookupOntapStorageVirtualMachineResultOutput) Subtype() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) string { return v.Subtype }).(pulumi.StringOutput)
}

func (o LookupOntapStorageVirtualMachineResultOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) map[string]string { return v.Tags }).(pulumi.StringMapOutput)
}

// The SVM's UUID.
func (o LookupOntapStorageVirtualMachineResultOutput) Uuid() pulumi.StringOutput {
	return o.ApplyT(func(v LookupOntapStorageVirtualMachineResult) string { return v.Uuid }).(pulumi.StringOutput)
}

func init() {
	pulumi.RegisterOutputType(LookupOntapStorageVirtualMachineResultOutput{})
}
