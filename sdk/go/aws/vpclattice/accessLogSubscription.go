// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package vpclattice

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an AWS VPC Lattice Service Network or Service Access log subscription.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/vpclattice"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := vpclattice.NewAccessLogSubscription(ctx, "example", &vpclattice.AccessLogSubscriptionArgs{
//				ResourceIdentifier: pulumi.Any(exampleAwsVpclatticeServiceNetwork.Id),
//				DestinationArn:     pulumi.Any(bucket.Arn),
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
// Using `pulumi import`, import VPC Lattice Access Log Subscription using the access log subscription ID. For example:
//
// ```sh
// $ pulumi import aws:vpclattice/accessLogSubscription:AccessLogSubscription example rft-8012925589
// ```
type AccessLogSubscription struct {
	pulumi.CustomResourceState

	// Amazon Resource Name (ARN) of the access log subscription.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Amazon Resource Name (ARN) of the log destination.
	DestinationArn pulumi.StringOutput `pulumi:"destinationArn"`
	// Amazon Resource Name (ARN) of the service network or service.
	ResourceArn pulumi.StringOutput `pulumi:"resourceArn"`
	// The ID or Amazon Resource Identifier (ARN) of the service network or service. You must use the ARN if the resources specified in the operation are in different accounts.
	//
	// The following arguments are optional:
	ResourceIdentifier pulumi.StringOutput `pulumi:"resourceIdentifier"`
	// Type of log that monitors your Amazon VPC Lattice service networks. Valid values are: `SERVICE`, `RESOURCE`. Defaults to `SERVICE`.
	ServiceNetworkLogType pulumi.StringOutput    `pulumi:"serviceNetworkLogType"`
	Tags                  pulumi.StringMapOutput `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
}

// NewAccessLogSubscription registers a new resource with the given unique name, arguments, and options.
func NewAccessLogSubscription(ctx *pulumi.Context,
	name string, args *AccessLogSubscriptionArgs, opts ...pulumi.ResourceOption) (*AccessLogSubscription, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.DestinationArn == nil {
		return nil, errors.New("invalid value for required argument 'DestinationArn'")
	}
	if args.ResourceIdentifier == nil {
		return nil, errors.New("invalid value for required argument 'ResourceIdentifier'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource AccessLogSubscription
	err := ctx.RegisterResource("aws:vpclattice/accessLogSubscription:AccessLogSubscription", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAccessLogSubscription gets an existing AccessLogSubscription resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAccessLogSubscription(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AccessLogSubscriptionState, opts ...pulumi.ResourceOption) (*AccessLogSubscription, error) {
	var resource AccessLogSubscription
	err := ctx.ReadResource("aws:vpclattice/accessLogSubscription:AccessLogSubscription", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AccessLogSubscription resources.
type accessLogSubscriptionState struct {
	// Amazon Resource Name (ARN) of the access log subscription.
	Arn *string `pulumi:"arn"`
	// Amazon Resource Name (ARN) of the log destination.
	DestinationArn *string `pulumi:"destinationArn"`
	// Amazon Resource Name (ARN) of the service network or service.
	ResourceArn *string `pulumi:"resourceArn"`
	// The ID or Amazon Resource Identifier (ARN) of the service network or service. You must use the ARN if the resources specified in the operation are in different accounts.
	//
	// The following arguments are optional:
	ResourceIdentifier *string `pulumi:"resourceIdentifier"`
	// Type of log that monitors your Amazon VPC Lattice service networks. Valid values are: `SERVICE`, `RESOURCE`. Defaults to `SERVICE`.
	ServiceNetworkLogType *string           `pulumi:"serviceNetworkLogType"`
	Tags                  map[string]string `pulumi:"tags"`
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
}

type AccessLogSubscriptionState struct {
	// Amazon Resource Name (ARN) of the access log subscription.
	Arn pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the log destination.
	DestinationArn pulumi.StringPtrInput
	// Amazon Resource Name (ARN) of the service network or service.
	ResourceArn pulumi.StringPtrInput
	// The ID or Amazon Resource Identifier (ARN) of the service network or service. You must use the ARN if the resources specified in the operation are in different accounts.
	//
	// The following arguments are optional:
	ResourceIdentifier pulumi.StringPtrInput
	// Type of log that monitors your Amazon VPC Lattice service networks. Valid values are: `SERVICE`, `RESOURCE`. Defaults to `SERVICE`.
	ServiceNetworkLogType pulumi.StringPtrInput
	Tags                  pulumi.StringMapInput
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
}

func (AccessLogSubscriptionState) ElementType() reflect.Type {
	return reflect.TypeOf((*accessLogSubscriptionState)(nil)).Elem()
}

type accessLogSubscriptionArgs struct {
	// Amazon Resource Name (ARN) of the log destination.
	DestinationArn string `pulumi:"destinationArn"`
	// The ID or Amazon Resource Identifier (ARN) of the service network or service. You must use the ARN if the resources specified in the operation are in different accounts.
	//
	// The following arguments are optional:
	ResourceIdentifier string `pulumi:"resourceIdentifier"`
	// Type of log that monitors your Amazon VPC Lattice service networks. Valid values are: `SERVICE`, `RESOURCE`. Defaults to `SERVICE`.
	ServiceNetworkLogType *string           `pulumi:"serviceNetworkLogType"`
	Tags                  map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a AccessLogSubscription resource.
type AccessLogSubscriptionArgs struct {
	// Amazon Resource Name (ARN) of the log destination.
	DestinationArn pulumi.StringInput
	// The ID or Amazon Resource Identifier (ARN) of the service network or service. You must use the ARN if the resources specified in the operation are in different accounts.
	//
	// The following arguments are optional:
	ResourceIdentifier pulumi.StringInput
	// Type of log that monitors your Amazon VPC Lattice service networks. Valid values are: `SERVICE`, `RESOURCE`. Defaults to `SERVICE`.
	ServiceNetworkLogType pulumi.StringPtrInput
	Tags                  pulumi.StringMapInput
}

func (AccessLogSubscriptionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*accessLogSubscriptionArgs)(nil)).Elem()
}

type AccessLogSubscriptionInput interface {
	pulumi.Input

	ToAccessLogSubscriptionOutput() AccessLogSubscriptionOutput
	ToAccessLogSubscriptionOutputWithContext(ctx context.Context) AccessLogSubscriptionOutput
}

func (*AccessLogSubscription) ElementType() reflect.Type {
	return reflect.TypeOf((**AccessLogSubscription)(nil)).Elem()
}

func (i *AccessLogSubscription) ToAccessLogSubscriptionOutput() AccessLogSubscriptionOutput {
	return i.ToAccessLogSubscriptionOutputWithContext(context.Background())
}

func (i *AccessLogSubscription) ToAccessLogSubscriptionOutputWithContext(ctx context.Context) AccessLogSubscriptionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccessLogSubscriptionOutput)
}

// AccessLogSubscriptionArrayInput is an input type that accepts AccessLogSubscriptionArray and AccessLogSubscriptionArrayOutput values.
// You can construct a concrete instance of `AccessLogSubscriptionArrayInput` via:
//
//	AccessLogSubscriptionArray{ AccessLogSubscriptionArgs{...} }
type AccessLogSubscriptionArrayInput interface {
	pulumi.Input

	ToAccessLogSubscriptionArrayOutput() AccessLogSubscriptionArrayOutput
	ToAccessLogSubscriptionArrayOutputWithContext(context.Context) AccessLogSubscriptionArrayOutput
}

type AccessLogSubscriptionArray []AccessLogSubscriptionInput

func (AccessLogSubscriptionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AccessLogSubscription)(nil)).Elem()
}

func (i AccessLogSubscriptionArray) ToAccessLogSubscriptionArrayOutput() AccessLogSubscriptionArrayOutput {
	return i.ToAccessLogSubscriptionArrayOutputWithContext(context.Background())
}

func (i AccessLogSubscriptionArray) ToAccessLogSubscriptionArrayOutputWithContext(ctx context.Context) AccessLogSubscriptionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccessLogSubscriptionArrayOutput)
}

// AccessLogSubscriptionMapInput is an input type that accepts AccessLogSubscriptionMap and AccessLogSubscriptionMapOutput values.
// You can construct a concrete instance of `AccessLogSubscriptionMapInput` via:
//
//	AccessLogSubscriptionMap{ "key": AccessLogSubscriptionArgs{...} }
type AccessLogSubscriptionMapInput interface {
	pulumi.Input

	ToAccessLogSubscriptionMapOutput() AccessLogSubscriptionMapOutput
	ToAccessLogSubscriptionMapOutputWithContext(context.Context) AccessLogSubscriptionMapOutput
}

type AccessLogSubscriptionMap map[string]AccessLogSubscriptionInput

func (AccessLogSubscriptionMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AccessLogSubscription)(nil)).Elem()
}

func (i AccessLogSubscriptionMap) ToAccessLogSubscriptionMapOutput() AccessLogSubscriptionMapOutput {
	return i.ToAccessLogSubscriptionMapOutputWithContext(context.Background())
}

func (i AccessLogSubscriptionMap) ToAccessLogSubscriptionMapOutputWithContext(ctx context.Context) AccessLogSubscriptionMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AccessLogSubscriptionMapOutput)
}

type AccessLogSubscriptionOutput struct{ *pulumi.OutputState }

func (AccessLogSubscriptionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AccessLogSubscription)(nil)).Elem()
}

func (o AccessLogSubscriptionOutput) ToAccessLogSubscriptionOutput() AccessLogSubscriptionOutput {
	return o
}

func (o AccessLogSubscriptionOutput) ToAccessLogSubscriptionOutputWithContext(ctx context.Context) AccessLogSubscriptionOutput {
	return o
}

// Amazon Resource Name (ARN) of the access log subscription.
func (o AccessLogSubscriptionOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessLogSubscription) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Amazon Resource Name (ARN) of the log destination.
func (o AccessLogSubscriptionOutput) DestinationArn() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessLogSubscription) pulumi.StringOutput { return v.DestinationArn }).(pulumi.StringOutput)
}

// Amazon Resource Name (ARN) of the service network or service.
func (o AccessLogSubscriptionOutput) ResourceArn() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessLogSubscription) pulumi.StringOutput { return v.ResourceArn }).(pulumi.StringOutput)
}

// The ID or Amazon Resource Identifier (ARN) of the service network or service. You must use the ARN if the resources specified in the operation are in different accounts.
//
// The following arguments are optional:
func (o AccessLogSubscriptionOutput) ResourceIdentifier() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessLogSubscription) pulumi.StringOutput { return v.ResourceIdentifier }).(pulumi.StringOutput)
}

// Type of log that monitors your Amazon VPC Lattice service networks. Valid values are: `SERVICE`, `RESOURCE`. Defaults to `SERVICE`.
func (o AccessLogSubscriptionOutput) ServiceNetworkLogType() pulumi.StringOutput {
	return o.ApplyT(func(v *AccessLogSubscription) pulumi.StringOutput { return v.ServiceNetworkLogType }).(pulumi.StringOutput)
}

func (o AccessLogSubscriptionOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AccessLogSubscription) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Deprecated: Please use `tags` instead.
func (o AccessLogSubscriptionOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *AccessLogSubscription) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

type AccessLogSubscriptionArrayOutput struct{ *pulumi.OutputState }

func (AccessLogSubscriptionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AccessLogSubscription)(nil)).Elem()
}

func (o AccessLogSubscriptionArrayOutput) ToAccessLogSubscriptionArrayOutput() AccessLogSubscriptionArrayOutput {
	return o
}

func (o AccessLogSubscriptionArrayOutput) ToAccessLogSubscriptionArrayOutputWithContext(ctx context.Context) AccessLogSubscriptionArrayOutput {
	return o
}

func (o AccessLogSubscriptionArrayOutput) Index(i pulumi.IntInput) AccessLogSubscriptionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AccessLogSubscription {
		return vs[0].([]*AccessLogSubscription)[vs[1].(int)]
	}).(AccessLogSubscriptionOutput)
}

type AccessLogSubscriptionMapOutput struct{ *pulumi.OutputState }

func (AccessLogSubscriptionMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AccessLogSubscription)(nil)).Elem()
}

func (o AccessLogSubscriptionMapOutput) ToAccessLogSubscriptionMapOutput() AccessLogSubscriptionMapOutput {
	return o
}

func (o AccessLogSubscriptionMapOutput) ToAccessLogSubscriptionMapOutputWithContext(ctx context.Context) AccessLogSubscriptionMapOutput {
	return o
}

func (o AccessLogSubscriptionMapOutput) MapIndex(k pulumi.StringInput) AccessLogSubscriptionOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AccessLogSubscription {
		return vs[0].(map[string]*AccessLogSubscription)[vs[1].(string)]
	}).(AccessLogSubscriptionOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AccessLogSubscriptionInput)(nil)).Elem(), &AccessLogSubscription{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccessLogSubscriptionArrayInput)(nil)).Elem(), AccessLogSubscriptionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AccessLogSubscriptionMapInput)(nil)).Elem(), AccessLogSubscriptionMap{})
	pulumi.RegisterOutputType(AccessLogSubscriptionOutput{})
	pulumi.RegisterOutputType(AccessLogSubscriptionArrayOutput{})
	pulumi.RegisterOutputType(AccessLogSubscriptionMapOutput{})
}
