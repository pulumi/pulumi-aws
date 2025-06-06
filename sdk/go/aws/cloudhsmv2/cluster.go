// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package cloudhsmv2

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Creates an Amazon CloudHSM v2 cluster.
//
// For information about CloudHSM v2, see the
// [AWS CloudHSM User Guide](https://docs.aws.amazon.com/cloudhsm/latest/userguide/introduction.html) and the [Amazon
// CloudHSM API Reference][2].
//
// > **NOTE:** A CloudHSM Cluster can take several minutes to set up.
// Practically no single attribute can be updated, except for `tags`.
// If you need to delete a cluster, you have to remove its HSM modules first.
// To initialize cluster, you have to add an HSM instance to the cluster, then sign CSR and upload it.
//
// ## Import
//
// Using `pulumi import`, import CloudHSM v2 Clusters using the cluster `id`. For example:
//
// ```sh
// $ pulumi import aws:cloudhsmv2/cluster:Cluster test_cluster cluster-aeb282a201
// ```
type Cluster struct {
	pulumi.CustomResourceState

	// The list of cluster certificates.
	ClusterCertificates ClusterClusterCertificateArrayOutput `pulumi:"clusterCertificates"`
	// The id of the CloudHSM cluster.
	ClusterId pulumi.StringOutput `pulumi:"clusterId"`
	// The state of the CloudHSM cluster.
	ClusterState pulumi.StringOutput `pulumi:"clusterState"`
	// The type of HSM module in the cluster. Currently, `hsm1.medium` and `hsm2m.medium` are supported.
	HsmType pulumi.StringOutput `pulumi:"hsmType"`
	// The mode to use in the cluster. The allowed values are `FIPS` and `NON_FIPS`. This field is required if `hsmType` is `hsm2m.medium`.
	Mode pulumi.StringOutput `pulumi:"mode"`
	// The ID of the security group associated with the CloudHSM cluster.
	SecurityGroupId pulumi.StringOutput `pulumi:"securityGroupId"`
	// ID of Cloud HSM v2 cluster backup to be restored.
	SourceBackupIdentifier pulumi.StringPtrOutput `pulumi:"sourceBackupIdentifier"`
	// The IDs of subnets in which cluster will operate.
	SubnetIds pulumi.StringArrayOutput `pulumi:"subnetIds"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// The id of the VPC that the CloudHSM cluster resides in.
	VpcId pulumi.StringOutput `pulumi:"vpcId"`
}

// NewCluster registers a new resource with the given unique name, arguments, and options.
func NewCluster(ctx *pulumi.Context,
	name string, args *ClusterArgs, opts ...pulumi.ResourceOption) (*Cluster, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.HsmType == nil {
		return nil, errors.New("invalid value for required argument 'HsmType'")
	}
	if args.SubnetIds == nil {
		return nil, errors.New("invalid value for required argument 'SubnetIds'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Cluster
	err := ctx.RegisterResource("aws:cloudhsmv2/cluster:Cluster", name, args, &resource, opts...)
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
	err := ctx.ReadResource("aws:cloudhsmv2/cluster:Cluster", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Cluster resources.
type clusterState struct {
	// The list of cluster certificates.
	ClusterCertificates []ClusterClusterCertificate `pulumi:"clusterCertificates"`
	// The id of the CloudHSM cluster.
	ClusterId *string `pulumi:"clusterId"`
	// The state of the CloudHSM cluster.
	ClusterState *string `pulumi:"clusterState"`
	// The type of HSM module in the cluster. Currently, `hsm1.medium` and `hsm2m.medium` are supported.
	HsmType *string `pulumi:"hsmType"`
	// The mode to use in the cluster. The allowed values are `FIPS` and `NON_FIPS`. This field is required if `hsmType` is `hsm2m.medium`.
	Mode *string `pulumi:"mode"`
	// The ID of the security group associated with the CloudHSM cluster.
	SecurityGroupId *string `pulumi:"securityGroupId"`
	// ID of Cloud HSM v2 cluster backup to be restored.
	SourceBackupIdentifier *string `pulumi:"sourceBackupIdentifier"`
	// The IDs of subnets in which cluster will operate.
	SubnetIds []string `pulumi:"subnetIds"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// The id of the VPC that the CloudHSM cluster resides in.
	VpcId *string `pulumi:"vpcId"`
}

type ClusterState struct {
	// The list of cluster certificates.
	ClusterCertificates ClusterClusterCertificateArrayInput
	// The id of the CloudHSM cluster.
	ClusterId pulumi.StringPtrInput
	// The state of the CloudHSM cluster.
	ClusterState pulumi.StringPtrInput
	// The type of HSM module in the cluster. Currently, `hsm1.medium` and `hsm2m.medium` are supported.
	HsmType pulumi.StringPtrInput
	// The mode to use in the cluster. The allowed values are `FIPS` and `NON_FIPS`. This field is required if `hsmType` is `hsm2m.medium`.
	Mode pulumi.StringPtrInput
	// The ID of the security group associated with the CloudHSM cluster.
	SecurityGroupId pulumi.StringPtrInput
	// ID of Cloud HSM v2 cluster backup to be restored.
	SourceBackupIdentifier pulumi.StringPtrInput
	// The IDs of subnets in which cluster will operate.
	SubnetIds pulumi.StringArrayInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// The id of the VPC that the CloudHSM cluster resides in.
	VpcId pulumi.StringPtrInput
}

func (ClusterState) ElementType() reflect.Type {
	return reflect.TypeOf((*clusterState)(nil)).Elem()
}

type clusterArgs struct {
	// The type of HSM module in the cluster. Currently, `hsm1.medium` and `hsm2m.medium` are supported.
	HsmType string `pulumi:"hsmType"`
	// The mode to use in the cluster. The allowed values are `FIPS` and `NON_FIPS`. This field is required if `hsmType` is `hsm2m.medium`.
	Mode *string `pulumi:"mode"`
	// ID of Cloud HSM v2 cluster backup to be restored.
	SourceBackupIdentifier *string `pulumi:"sourceBackupIdentifier"`
	// The IDs of subnets in which cluster will operate.
	SubnetIds []string `pulumi:"subnetIds"`
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
}

// The set of arguments for constructing a Cluster resource.
type ClusterArgs struct {
	// The type of HSM module in the cluster. Currently, `hsm1.medium` and `hsm2m.medium` are supported.
	HsmType pulumi.StringInput
	// The mode to use in the cluster. The allowed values are `FIPS` and `NON_FIPS`. This field is required if `hsmType` is `hsm2m.medium`.
	Mode pulumi.StringPtrInput
	// ID of Cloud HSM v2 cluster backup to be restored.
	SourceBackupIdentifier pulumi.StringPtrInput
	// The IDs of subnets in which cluster will operate.
	SubnetIds pulumi.StringArrayInput
	// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
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

// The list of cluster certificates.
func (o ClusterOutput) ClusterCertificates() ClusterClusterCertificateArrayOutput {
	return o.ApplyT(func(v *Cluster) ClusterClusterCertificateArrayOutput { return v.ClusterCertificates }).(ClusterClusterCertificateArrayOutput)
}

// The id of the CloudHSM cluster.
func (o ClusterOutput) ClusterId() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.ClusterId }).(pulumi.StringOutput)
}

// The state of the CloudHSM cluster.
func (o ClusterOutput) ClusterState() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.ClusterState }).(pulumi.StringOutput)
}

// The type of HSM module in the cluster. Currently, `hsm1.medium` and `hsm2m.medium` are supported.
func (o ClusterOutput) HsmType() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.HsmType }).(pulumi.StringOutput)
}

// The mode to use in the cluster. The allowed values are `FIPS` and `NON_FIPS`. This field is required if `hsmType` is `hsm2m.medium`.
func (o ClusterOutput) Mode() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.Mode }).(pulumi.StringOutput)
}

// The ID of the security group associated with the CloudHSM cluster.
func (o ClusterOutput) SecurityGroupId() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.SecurityGroupId }).(pulumi.StringOutput)
}

// ID of Cloud HSM v2 cluster backup to be restored.
func (o ClusterOutput) SourceBackupIdentifier() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringPtrOutput { return v.SourceBackupIdentifier }).(pulumi.StringPtrOutput)
}

// The IDs of subnets in which cluster will operate.
func (o ClusterOutput) SubnetIds() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringArrayOutput { return v.SubnetIds }).(pulumi.StringArrayOutput)
}

// A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o ClusterOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o ClusterOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// The id of the VPC that the CloudHSM cluster resides in.
func (o ClusterOutput) VpcId() pulumi.StringOutput {
	return o.ApplyT(func(v *Cluster) pulumi.StringOutput { return v.VpcId }).(pulumi.StringOutput)
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
