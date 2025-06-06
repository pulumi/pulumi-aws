// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package directoryservice

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages a directory in your account (directory owner) shared with another account (directory consumer).
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/directoryservice"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
// func main() {
// pulumi.Run(func(ctx *pulumi.Context) error {
// example, err := directoryservice.NewDirectory(ctx, "example", &directoryservice.DirectoryArgs{
// Name: pulumi.String("tf-example"),
// Password: pulumi.String("SuperSecretPassw0rd"),
// Type: pulumi.String("MicrosoftAD"),
// Edition: pulumi.String("Standard"),
// VpcSettings: &directoryservice.DirectoryVpcSettingsArgs{
// VpcId: pulumi.Any(exampleAwsVpc.Id),
// SubnetIds: []pulumi.String(%!v(PANIC=Format method: fatal: A failure has occurred: unlowered splat expression @ example.pp:7,17-39)),
// },
// })
// if err != nil {
// return err
// }
// _, err = directoryservice.NewSharedDirectory(ctx, "example", &directoryservice.SharedDirectoryArgs{
// DirectoryId: example.ID(),
// Notes: pulumi.String("You wanna have a catch?"),
// Target: &directoryservice.SharedDirectoryTargetArgs{
// Id: pulumi.Any(receiver.AccountId),
// },
// })
// if err != nil {
// return err
// }
// return nil
// })
// }
// ```
//
// ## Import
//
// Using `pulumi import`, import Directory Service Shared Directories using the owner directory ID/shared directory ID. For example:
//
// ```sh
// $ pulumi import aws:directoryservice/sharedDirectory:SharedDirectory example d-1234567890/d-9267633ece
// ```
type SharedDirectory struct {
	pulumi.CustomResourceState

	// Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
	DirectoryId pulumi.StringOutput `pulumi:"directoryId"`
	// Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
	Method pulumi.StringPtrOutput `pulumi:"method"`
	// Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
	Notes pulumi.StringPtrOutput `pulumi:"notes"`
	// Identifier of the directory that is stored in the directory consumer account that corresponds to the shared directory in the owner account.
	SharedDirectoryId pulumi.StringOutput `pulumi:"sharedDirectoryId"`
	// Identifier for the directory consumer account with whom the directory is to be shared. See below.
	//
	// The following arguments are optional:
	Target SharedDirectoryTargetOutput `pulumi:"target"`
}

// NewSharedDirectory registers a new resource with the given unique name, arguments, and options.
func NewSharedDirectory(ctx *pulumi.Context,
	name string, args *SharedDirectoryArgs, opts ...pulumi.ResourceOption) (*SharedDirectory, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.DirectoryId == nil {
		return nil, errors.New("invalid value for required argument 'DirectoryId'")
	}
	if args.Target == nil {
		return nil, errors.New("invalid value for required argument 'Target'")
	}
	if args.Notes != nil {
		args.Notes = pulumi.ToSecret(args.Notes).(pulumi.StringPtrInput)
	}
	secrets := pulumi.AdditionalSecretOutputs([]string{
		"notes",
	})
	opts = append(opts, secrets)
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource SharedDirectory
	err := ctx.RegisterResource("aws:directoryservice/sharedDirectory:SharedDirectory", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetSharedDirectory gets an existing SharedDirectory resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetSharedDirectory(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *SharedDirectoryState, opts ...pulumi.ResourceOption) (*SharedDirectory, error) {
	var resource SharedDirectory
	err := ctx.ReadResource("aws:directoryservice/sharedDirectory:SharedDirectory", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering SharedDirectory resources.
type sharedDirectoryState struct {
	// Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
	DirectoryId *string `pulumi:"directoryId"`
	// Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
	Method *string `pulumi:"method"`
	// Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
	Notes *string `pulumi:"notes"`
	// Identifier of the directory that is stored in the directory consumer account that corresponds to the shared directory in the owner account.
	SharedDirectoryId *string `pulumi:"sharedDirectoryId"`
	// Identifier for the directory consumer account with whom the directory is to be shared. See below.
	//
	// The following arguments are optional:
	Target *SharedDirectoryTarget `pulumi:"target"`
}

type SharedDirectoryState struct {
	// Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
	DirectoryId pulumi.StringPtrInput
	// Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
	Method pulumi.StringPtrInput
	// Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
	Notes pulumi.StringPtrInput
	// Identifier of the directory that is stored in the directory consumer account that corresponds to the shared directory in the owner account.
	SharedDirectoryId pulumi.StringPtrInput
	// Identifier for the directory consumer account with whom the directory is to be shared. See below.
	//
	// The following arguments are optional:
	Target SharedDirectoryTargetPtrInput
}

func (SharedDirectoryState) ElementType() reflect.Type {
	return reflect.TypeOf((*sharedDirectoryState)(nil)).Elem()
}

type sharedDirectoryArgs struct {
	// Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
	DirectoryId string `pulumi:"directoryId"`
	// Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
	Method *string `pulumi:"method"`
	// Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
	Notes *string `pulumi:"notes"`
	// Identifier for the directory consumer account with whom the directory is to be shared. See below.
	//
	// The following arguments are optional:
	Target SharedDirectoryTarget `pulumi:"target"`
}

// The set of arguments for constructing a SharedDirectory resource.
type SharedDirectoryArgs struct {
	// Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
	DirectoryId pulumi.StringInput
	// Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
	Method pulumi.StringPtrInput
	// Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
	Notes pulumi.StringPtrInput
	// Identifier for the directory consumer account with whom the directory is to be shared. See below.
	//
	// The following arguments are optional:
	Target SharedDirectoryTargetInput
}

func (SharedDirectoryArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*sharedDirectoryArgs)(nil)).Elem()
}

type SharedDirectoryInput interface {
	pulumi.Input

	ToSharedDirectoryOutput() SharedDirectoryOutput
	ToSharedDirectoryOutputWithContext(ctx context.Context) SharedDirectoryOutput
}

func (*SharedDirectory) ElementType() reflect.Type {
	return reflect.TypeOf((**SharedDirectory)(nil)).Elem()
}

func (i *SharedDirectory) ToSharedDirectoryOutput() SharedDirectoryOutput {
	return i.ToSharedDirectoryOutputWithContext(context.Background())
}

func (i *SharedDirectory) ToSharedDirectoryOutputWithContext(ctx context.Context) SharedDirectoryOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SharedDirectoryOutput)
}

// SharedDirectoryArrayInput is an input type that accepts SharedDirectoryArray and SharedDirectoryArrayOutput values.
// You can construct a concrete instance of `SharedDirectoryArrayInput` via:
//
//	SharedDirectoryArray{ SharedDirectoryArgs{...} }
type SharedDirectoryArrayInput interface {
	pulumi.Input

	ToSharedDirectoryArrayOutput() SharedDirectoryArrayOutput
	ToSharedDirectoryArrayOutputWithContext(context.Context) SharedDirectoryArrayOutput
}

type SharedDirectoryArray []SharedDirectoryInput

func (SharedDirectoryArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SharedDirectory)(nil)).Elem()
}

func (i SharedDirectoryArray) ToSharedDirectoryArrayOutput() SharedDirectoryArrayOutput {
	return i.ToSharedDirectoryArrayOutputWithContext(context.Background())
}

func (i SharedDirectoryArray) ToSharedDirectoryArrayOutputWithContext(ctx context.Context) SharedDirectoryArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SharedDirectoryArrayOutput)
}

// SharedDirectoryMapInput is an input type that accepts SharedDirectoryMap and SharedDirectoryMapOutput values.
// You can construct a concrete instance of `SharedDirectoryMapInput` via:
//
//	SharedDirectoryMap{ "key": SharedDirectoryArgs{...} }
type SharedDirectoryMapInput interface {
	pulumi.Input

	ToSharedDirectoryMapOutput() SharedDirectoryMapOutput
	ToSharedDirectoryMapOutputWithContext(context.Context) SharedDirectoryMapOutput
}

type SharedDirectoryMap map[string]SharedDirectoryInput

func (SharedDirectoryMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SharedDirectory)(nil)).Elem()
}

func (i SharedDirectoryMap) ToSharedDirectoryMapOutput() SharedDirectoryMapOutput {
	return i.ToSharedDirectoryMapOutputWithContext(context.Background())
}

func (i SharedDirectoryMap) ToSharedDirectoryMapOutputWithContext(ctx context.Context) SharedDirectoryMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(SharedDirectoryMapOutput)
}

type SharedDirectoryOutput struct{ *pulumi.OutputState }

func (SharedDirectoryOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**SharedDirectory)(nil)).Elem()
}

func (o SharedDirectoryOutput) ToSharedDirectoryOutput() SharedDirectoryOutput {
	return o
}

func (o SharedDirectoryOutput) ToSharedDirectoryOutputWithContext(ctx context.Context) SharedDirectoryOutput {
	return o
}

// Identifier of the Managed Microsoft AD directory that you want to share with other accounts.
func (o SharedDirectoryOutput) DirectoryId() pulumi.StringOutput {
	return o.ApplyT(func(v *SharedDirectory) pulumi.StringOutput { return v.DirectoryId }).(pulumi.StringOutput)
}

// Method used when sharing a directory. Valid values are `ORGANIZATIONS` and `HANDSHAKE`. Default is `HANDSHAKE`.
func (o SharedDirectoryOutput) Method() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *SharedDirectory) pulumi.StringPtrOutput { return v.Method }).(pulumi.StringPtrOutput)
}

// Message sent by the directory owner to the directory consumer to help the directory consumer administrator determine whether to approve or reject the share invitation.
func (o SharedDirectoryOutput) Notes() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *SharedDirectory) pulumi.StringPtrOutput { return v.Notes }).(pulumi.StringPtrOutput)
}

// Identifier of the directory that is stored in the directory consumer account that corresponds to the shared directory in the owner account.
func (o SharedDirectoryOutput) SharedDirectoryId() pulumi.StringOutput {
	return o.ApplyT(func(v *SharedDirectory) pulumi.StringOutput { return v.SharedDirectoryId }).(pulumi.StringOutput)
}

// Identifier for the directory consumer account with whom the directory is to be shared. See below.
//
// The following arguments are optional:
func (o SharedDirectoryOutput) Target() SharedDirectoryTargetOutput {
	return o.ApplyT(func(v *SharedDirectory) SharedDirectoryTargetOutput { return v.Target }).(SharedDirectoryTargetOutput)
}

type SharedDirectoryArrayOutput struct{ *pulumi.OutputState }

func (SharedDirectoryArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*SharedDirectory)(nil)).Elem()
}

func (o SharedDirectoryArrayOutput) ToSharedDirectoryArrayOutput() SharedDirectoryArrayOutput {
	return o
}

func (o SharedDirectoryArrayOutput) ToSharedDirectoryArrayOutputWithContext(ctx context.Context) SharedDirectoryArrayOutput {
	return o
}

func (o SharedDirectoryArrayOutput) Index(i pulumi.IntInput) SharedDirectoryOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *SharedDirectory {
		return vs[0].([]*SharedDirectory)[vs[1].(int)]
	}).(SharedDirectoryOutput)
}

type SharedDirectoryMapOutput struct{ *pulumi.OutputState }

func (SharedDirectoryMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*SharedDirectory)(nil)).Elem()
}

func (o SharedDirectoryMapOutput) ToSharedDirectoryMapOutput() SharedDirectoryMapOutput {
	return o
}

func (o SharedDirectoryMapOutput) ToSharedDirectoryMapOutputWithContext(ctx context.Context) SharedDirectoryMapOutput {
	return o
}

func (o SharedDirectoryMapOutput) MapIndex(k pulumi.StringInput) SharedDirectoryOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *SharedDirectory {
		return vs[0].(map[string]*SharedDirectory)[vs[1].(string)]
	}).(SharedDirectoryOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*SharedDirectoryInput)(nil)).Elem(), &SharedDirectory{})
	pulumi.RegisterInputType(reflect.TypeOf((*SharedDirectoryArrayInput)(nil)).Elem(), SharedDirectoryArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*SharedDirectoryMapInput)(nil)).Elem(), SharedDirectoryMap{})
	pulumi.RegisterOutputType(SharedDirectoryOutput{})
	pulumi.RegisterOutputType(SharedDirectoryArrayOutput{})
	pulumi.RegisterOutputType(SharedDirectoryMapOutput{})
}
