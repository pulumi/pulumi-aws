// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package dsql

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Resource for managing an Amazon Aurora DSQL Cluster.
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
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/dsql"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := dsql.NewCluster(ctx, "example", &dsql.ClusterArgs{
//				DeletionProtectionEnabled: pulumi.Bool(true),
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("TestCluster"),
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
// Using `pulumi import`, import DSQL Cluster using the `identifier`. For example:
//
// ```sh
// $ pulumi import aws:dsql/cluster:Cluster example abcde1f234ghijklmnop5qr6st
// ```
type Cluster struct {
	pulumi.CustomResourceState

	// ARN of the Cluster.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Whether deletion protection is enabled in this cluster.
	DeletionProtectionEnabled pulumi.BoolPtrOutput `pulumi:"deletionProtectionEnabled"`
	// Encryption configuration details for the DSQL Cluster.
	EncryptionDetails ClusterEncryptionDetailArrayOutput `pulumi:"encryptionDetails"`
	// Cluster Identifier.
	Identifier pulumi.StringOutput `pulumi:"identifier"`
	// The ARN of the AWS KMS key that encrypts data in the DSQL Cluster, or `"AWS_OWNED_KMS_KEY"`.
	KmsEncryptionKey pulumi.StringOutput `pulumi:"kmsEncryptionKey"`
	// Multi-region properties of the DSQL Cluster.
	MultiRegionProperties ClusterMultiRegionPropertiesPtrOutput `pulumi:"multiRegionProperties"`
	// Set of tags to be associated with the AWS DSQL Cluster resource.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapOutput   `pulumi:"tagsAll"`
	Timeouts ClusterTimeoutsPtrOutput `pulumi:"timeouts"`
	// The DSQL Cluster's VPC endpoint service name.
	VpcEndpointServiceName pulumi.StringOutput `pulumi:"vpcEndpointServiceName"`
}

// NewCluster registers a new resource with the given unique name, arguments, and options.
func NewCluster(ctx *pulumi.Context,
	name string, args *ClusterArgs, opts ...pulumi.ResourceOption) (*Cluster, error) {
	if args == nil {
		args = &ClusterArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Cluster
	err := ctx.RegisterResource("aws:dsql/cluster:Cluster", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetCluster gets an existing Cluster resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetCluster(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ClusterState, opts ...pulumi.ResourceOption) (*Cluster, error) {
	var resource Cluster
	err := ctx.ReadResource("aws:dsql/cluster:Cluster", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Cluster resources.
type clusterState struct {
	// ARN of the Cluster.
	Arn *string `pulumi:"arn"`
	// Whether deletion protection is enabled in this cluster.
	DeletionProtectionEnabled *bool `pulumi:"deletionProtectionEnabled"`
	// Encryption configuration details for the DSQL Cluster.
	EncryptionDetails []ClusterEncryptionDetail `pulumi:"encryptionDetails"`
	// Cluster Identifier.
	Identifier *string `pulumi:"identifier"`
	// The ARN of the AWS KMS key that encrypts data in the DSQL Cluster, or `"AWS_OWNED_KMS_KEY"`.
	KmsEncryptionKey *string `pulumi:"kmsEncryptionKey"`
	// Multi-region properties of the DSQL Cluster.
	MultiRegionProperties *ClusterMultiRegionProperties `pulumi:"multiRegionProperties"`
	// Set of tags to be associated with the AWS DSQL Cluster resource.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  map[string]string `pulumi:"tagsAll"`
	Timeouts *ClusterTimeouts  `pulumi:"timeouts"`
	// The DSQL Cluster's VPC endpoint service name.
	VpcEndpointServiceName *string `pulumi:"vpcEndpointServiceName"`
}

type ClusterState struct {
	// ARN of the Cluster.
	Arn pulumi.StringPtrInput
	// Whether deletion protection is enabled in this cluster.
	DeletionProtectionEnabled pulumi.BoolPtrInput
	// Encryption configuration details for the DSQL Cluster.
	EncryptionDetails ClusterEncryptionDetailArrayInput
	// Cluster Identifier.
	Identifier pulumi.StringPtrInput
	// The ARN of the AWS KMS key that encrypts data in the DSQL Cluster, or `"AWS_OWNED_KMS_KEY"`.
	KmsEncryptionKey pulumi.StringPtrInput
	// Multi-region properties of the DSQL Cluster.
	MultiRegionProperties ClusterMultiRegionPropertiesPtrInput
	// Set of tags to be associated with the AWS DSQL Cluster resource.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll  pulumi.StringMapInput
	Timeouts ClusterTimeoutsPtrInput
	// The DSQL Cluster's VPC endpoint service name.
	VpcEndpointServiceName pulumi.StringPtrInput
}

func (ClusterState) ElementType() reflect.Type {
	return reflect.TypeOf((*clusterState)(nil)).Elem()
}

type clusterArgs struct {
	// Whether deletion protection is enabled in this cluster.
	DeletionProtectionEnabled *bool `pulumi:"deletionProtectionEnabled"`
	// The ARN of the AWS KMS key that encrypts data in the DSQL Cluster, or `"AWS_OWNED_KMS_KEY"`.
	KmsEncryptionKey *string `pulumi:"kmsEncryptionKey"`
	// Multi-region properties of the DSQL Cluster.
	MultiRegionProperties *ClusterMultiRegionProperties `pulumi:"multiRegionProperties"`
	// Set of tags to be associated with the AWS DSQL Cluster resource.
	Tags     map[string]string `pulumi:"tags"`
	Timeouts *ClusterTimeouts  `pulumi:"timeouts"`
}

// The set of arguments for constructing a Cluster resource.
type ClusterArgs struct {
	// Whether deletion protection is enabled in this cluster.
	DeletionProtectionEnabled pulumi.BoolPtrInput
	// The ARN of the AWS KMS key that encrypts data in the DSQL Cluster, or `"AWS_OWNED_KMS_KEY"`.
	KmsEncryptionKey pulumi.StringPtrInput
	// Multi-region properties of the DSQL Cluster.
	MultiRegionProperties ClusterMultiRegionPropertiesPtrInput
	// Set of tags to be associated with the AWS DSQL Cluster resource.
	Tags     pulumi.StringMapInput
	Timeouts ClusterTimeoutsPtrInput
}

func (ClusterArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*clusterArgs)(nil)).Elem()
}

type ClusterInput interface {
	pulumi.Input

	ToClusterOutput() ClusterOutput
	ToClusterOutputWithContext(ctx context.Context) ClusterOutput
}

func (*Cluster) ElementType() reflect.Type {
	return reflect.TypeOf((**Cluster)(nil)).Elem()
}

func (i *Cluster) ToClusterOutput() ClusterOutput {
	return i.ToClusterOutputWithContext(context.Background())
}

func (i *Cluster) ToClusterOutputWithContext(ctx context.Context) ClusterOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClusterOutput)
}

// ClusterArrayInput is an input type that accepts ClusterArray and ClusterArrayOutput values.
// You can construct a concrete instance of `ClusterArrayInput` via:
//
//	ClusterArray{ ClusterArgs{...} }
type ClusterArrayInput interface {
	pulumi.Input

	ToClusterArrayOutput() ClusterArrayOutput
	ToClusterArrayOutputWithContext(context.Context) ClusterArrayOutput
}

type ClusterArray []ClusterInput

func (ClusterArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Cluster)(nil)).Elem()
}

func (i ClusterArray) ToClusterArrayOutput() ClusterArrayOutput {
	return i.ToClusterArrayOutputWithContext(context.Background())
}

func (i ClusterArray) ToClusterArrayOutputWithContext(ctx context.Context) ClusterArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClusterArrayOutput)
}

// ClusterMapInput is an input type that accepts ClusterMap and ClusterMapOutput values.
// You can construct a concrete instance of `ClusterMapInput` via:
//
//	ClusterMap{ "key": ClusterArgs{...} }
type ClusterMapInput interface {
	pulumi.Input

	ToClusterMapOutput() ClusterMapOutput
	ToClusterMapOutputWithContext(context.Context) ClusterMapOutput
}

type ClusterMap map[string]ClusterInput

func (ClusterMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Cluster)(nil)).Elem()
}

func (i ClusterMap) ToClusterMapOutput() ClusterMapOutput {
	return i.ToClusterMapOutputWithContext(context.Background())
}

func (i ClusterMap) ToClusterMapOutputWithContext(ctx context.Context) ClusterMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ClusterMapOutput)
}

type ClusterOutput struct{ *pulumi.OutputState }

func (ClusterOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Cluster)(nil)).Elem()
}

func (o ClusterOutput) ToClusterOutput() ClusterOutput {
	return o
}

func (o ClusterOutput) ToClusterOutputWithContext(ctx context.Context) ClusterOutput {
	return o
}

// ARN of the Cluster.
func (o ClusterOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Whether deletion protection is enabled in this cluster.
func (o ClusterOutput) DeletionProtectionEnabled() pulumi.BoolPtrOutput {
	return o.ApplyT(func(v *Cluster) pulumi.BoolPtrOutput { return v.DeletionProtectionEnabled }).(pulumi.BoolPtrOutput)
}

// Encryption configuration details for the DSQL Cluster.
func (o ClusterOutput) EncryptionDetails() ClusterEncryptionDetailArrayOutput {
	return o.ApplyT(func(v *Cluster) ClusterEncryptionDetailArrayOutput { return v.EncryptionDetails }).(ClusterEncryptionDetailArrayOutput)
}

// Cluster Identifier.
func (o ClusterOutput) Identifier() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.Identifier }).(pulumi.StringOutput)
}

// The ARN of the AWS KMS key that encrypts data in the DSQL Cluster, or `"AWS_OWNED_KMS_KEY"`.
func (o ClusterOutput) KmsEncryptionKey() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.KmsEncryptionKey }).(pulumi.StringOutput)
}

// Multi-region properties of the DSQL Cluster.
func (o ClusterOutput) MultiRegionProperties() ClusterMultiRegionPropertiesPtrOutput {
	return o.ApplyT(func(v *Cluster) ClusterMultiRegionPropertiesPtrOutput { return v.MultiRegionProperties }).(ClusterMultiRegionPropertiesPtrOutput)
}

// Set of tags to be associated with the AWS DSQL Cluster resource.
func (o ClusterOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ClusterOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

func (o ClusterOutput) Timeouts() ClusterTimeoutsPtrOutput {
	return o.ApplyT(func(v *Cluster) ClusterTimeoutsPtrOutput { return v.Timeouts }).(ClusterTimeoutsPtrOutput)
}

// The DSQL Cluster's VPC endpoint service name.
func (o ClusterOutput) VpcEndpointServiceName() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.VpcEndpointServiceName }).(pulumi.StringOutput)
}

type ClusterArrayOutput struct{ *pulumi.OutputState }

func (ClusterArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Cluster)(nil)).Elem()
}

func (o ClusterArrayOutput) ToClusterArrayOutput() ClusterArrayOutput {
	return o
}

func (o ClusterArrayOutput) ToClusterArrayOutputWithContext(ctx context.Context) ClusterArrayOutput {
	return o
}

func (o ClusterArrayOutput) Index(i pulumi.IntInput) ClusterOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Cluster {
		return vs[0].([]*Cluster)[vs[1].(int)]
	}).(ClusterOutput)
}

type ClusterMapOutput struct{ *pulumi.OutputState }

func (ClusterMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Cluster)(nil)).Elem()
}

func (o ClusterMapOutput) ToClusterMapOutput() ClusterMapOutput {
	return o
}

func (o ClusterMapOutput) ToClusterMapOutputWithContext(ctx context.Context) ClusterMapOutput {
	return o
}

func (o ClusterMapOutput) MapIndex(k pulumi.StringInput) ClusterOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Cluster {
		return vs[0].(map[string]*Cluster)[vs[1].(string)]
	}).(ClusterOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ClusterInput)(nil)).Elem(), &Cluster{})
	pulumi.RegisterInputType(reflect.TypeOf((*ClusterArrayInput)(nil)).Elem(), ClusterArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ClusterMapInput)(nil)).Elem(), ClusterMap{})
	pulumi.RegisterOutputType(ClusterOutput{})
	pulumi.RegisterOutputType(ClusterArrayOutput{})
	pulumi.RegisterOutputType(ClusterMapOutput{})
}
