// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ecr

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Provides an Elastic Container Registry Pull Through Cache Rule.
//
// More information about pull through cache rules, including the set of supported
// upstream repositories, see [Using pull through cache rules](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache.html).
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ecr"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := ecr.NewPullThroughCacheRule(ctx, "example", &ecr.PullThroughCacheRuleArgs{
//				EcrRepositoryPrefix: pulumi.String("ecr-public"),
//				UpstreamRegistryUrl: pulumi.String("public.ecr.aws"),
//				CredentialArn:       pulumi.String("arn:aws:secretsmanager:us-east-1:123456789:secret:ecr-pullthroughcache/ecrpublic"),
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
// Using `pulumi import`, import a pull-through cache rule using the `ecr_repository_prefix`. For example:
//
// ```sh
// $ pulumi import aws:ecr/pullThroughCacheRule:PullThroughCacheRule example ecr-public
// ```
type PullThroughCacheRule struct {
	pulumi.CustomResourceState

	// ARN of the Secret which will be used to authenticate against the registry.
	CredentialArn pulumi.StringPtrOutput `pulumi:"credentialArn"`
	// The ARN of the IAM role associated with the pull through cache rule. Must be specified if the upstream registry is a cross-account ECR private registry. See [AWS Document - Setting up permissions for cross-account ECR to ECR PTC](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private.html).
	CustomRoleArn pulumi.StringPtrOutput `pulumi:"customRoleArn"`
	// The repository name prefix to use when caching images from the source registry. Use `ROOT` as the prefix to apply a template to all repositories in your registry that don't have an associated pull through cache rule.
	EcrRepositoryPrefix pulumi.StringOutput `pulumi:"ecrRepositoryPrefix"`
	// The registry ID where the repository was created.
	RegistryId pulumi.StringOutput `pulumi:"registryId"`
	// The registry URL of the upstream registry to use as the source.
	UpstreamRegistryUrl pulumi.StringOutput `pulumi:"upstreamRegistryUrl"`
	// The upstream repository prefix associated with the pull through cache rule. Used if the upstream registry is an ECR private registry. If not specified, it's set to `ROOT`, which allows matching with any upstream repository. See [AWS Document - Customizing repository prefixes for ECR to ECR pull through cache](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private-wildcards.html).
	UpstreamRepositoryPrefix pulumi.StringPtrOutput `pulumi:"upstreamRepositoryPrefix"`
}

// NewPullThroughCacheRule registers a new resource with the given unique name, arguments, and options.
func NewPullThroughCacheRule(ctx *pulumi.Context,
	name string, args *PullThroughCacheRuleArgs, opts ...pulumi.ResourceOption) (*PullThroughCacheRule, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.EcrRepositoryPrefix == nil {
		return nil, errors.New("invalid value for required argument 'EcrRepositoryPrefix'")
	}
	if args.UpstreamRegistryUrl == nil {
		return nil, errors.New("invalid value for required argument 'UpstreamRegistryUrl'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource PullThroughCacheRule
	err := ctx.RegisterResource("aws:ecr/pullThroughCacheRule:PullThroughCacheRule", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetPullThroughCacheRule gets an existing PullThroughCacheRule resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetPullThroughCacheRule(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *PullThroughCacheRuleState, opts ...pulumi.ResourceOption) (*PullThroughCacheRule, error) {
	var resource PullThroughCacheRule
	err := ctx.ReadResource("aws:ecr/pullThroughCacheRule:PullThroughCacheRule", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering PullThroughCacheRule resources.
type pullThroughCacheRuleState struct {
	// ARN of the Secret which will be used to authenticate against the registry.
	CredentialArn *string `pulumi:"credentialArn"`
	// The ARN of the IAM role associated with the pull through cache rule. Must be specified if the upstream registry is a cross-account ECR private registry. See [AWS Document - Setting up permissions for cross-account ECR to ECR PTC](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private.html).
	CustomRoleArn *string `pulumi:"customRoleArn"`
	// The repository name prefix to use when caching images from the source registry. Use `ROOT` as the prefix to apply a template to all repositories in your registry that don't have an associated pull through cache rule.
	EcrRepositoryPrefix *string `pulumi:"ecrRepositoryPrefix"`
	// The registry ID where the repository was created.
	RegistryId *string `pulumi:"registryId"`
	// The registry URL of the upstream registry to use as the source.
	UpstreamRegistryUrl *string `pulumi:"upstreamRegistryUrl"`
	// The upstream repository prefix associated with the pull through cache rule. Used if the upstream registry is an ECR private registry. If not specified, it's set to `ROOT`, which allows matching with any upstream repository. See [AWS Document - Customizing repository prefixes for ECR to ECR pull through cache](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private-wildcards.html).
	UpstreamRepositoryPrefix *string `pulumi:"upstreamRepositoryPrefix"`
}

type PullThroughCacheRuleState struct {
	// ARN of the Secret which will be used to authenticate against the registry.
	CredentialArn pulumi.StringPtrInput
	// The ARN of the IAM role associated with the pull through cache rule. Must be specified if the upstream registry is a cross-account ECR private registry. See [AWS Document - Setting up permissions for cross-account ECR to ECR PTC](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private.html).
	CustomRoleArn pulumi.StringPtrInput
	// The repository name prefix to use when caching images from the source registry. Use `ROOT` as the prefix to apply a template to all repositories in your registry that don't have an associated pull through cache rule.
	EcrRepositoryPrefix pulumi.StringPtrInput
	// The registry ID where the repository was created.
	RegistryId pulumi.StringPtrInput
	// The registry URL of the upstream registry to use as the source.
	UpstreamRegistryUrl pulumi.StringPtrInput
	// The upstream repository prefix associated with the pull through cache rule. Used if the upstream registry is an ECR private registry. If not specified, it's set to `ROOT`, which allows matching with any upstream repository. See [AWS Document - Customizing repository prefixes for ECR to ECR pull through cache](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private-wildcards.html).
	UpstreamRepositoryPrefix pulumi.StringPtrInput
}

func (PullThroughCacheRuleState) ElementType() reflect.Type {
	return reflect.TypeOf((*pullThroughCacheRuleState)(nil)).Elem()
}

type pullThroughCacheRuleArgs struct {
	// ARN of the Secret which will be used to authenticate against the registry.
	CredentialArn *string `pulumi:"credentialArn"`
	// The ARN of the IAM role associated with the pull through cache rule. Must be specified if the upstream registry is a cross-account ECR private registry. See [AWS Document - Setting up permissions for cross-account ECR to ECR PTC](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private.html).
	CustomRoleArn *string `pulumi:"customRoleArn"`
	// The repository name prefix to use when caching images from the source registry. Use `ROOT` as the prefix to apply a template to all repositories in your registry that don't have an associated pull through cache rule.
	EcrRepositoryPrefix string `pulumi:"ecrRepositoryPrefix"`
	// The registry URL of the upstream registry to use as the source.
	UpstreamRegistryUrl string `pulumi:"upstreamRegistryUrl"`
	// The upstream repository prefix associated with the pull through cache rule. Used if the upstream registry is an ECR private registry. If not specified, it's set to `ROOT`, which allows matching with any upstream repository. See [AWS Document - Customizing repository prefixes for ECR to ECR pull through cache](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private-wildcards.html).
	UpstreamRepositoryPrefix *string `pulumi:"upstreamRepositoryPrefix"`
}

// The set of arguments for constructing a PullThroughCacheRule resource.
type PullThroughCacheRuleArgs struct {
	// ARN of the Secret which will be used to authenticate against the registry.
	CredentialArn pulumi.StringPtrInput
	// The ARN of the IAM role associated with the pull through cache rule. Must be specified if the upstream registry is a cross-account ECR private registry. See [AWS Document - Setting up permissions for cross-account ECR to ECR PTC](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private.html).
	CustomRoleArn pulumi.StringPtrInput
	// The repository name prefix to use when caching images from the source registry. Use `ROOT` as the prefix to apply a template to all repositories in your registry that don't have an associated pull through cache rule.
	EcrRepositoryPrefix pulumi.StringInput
	// The registry URL of the upstream registry to use as the source.
	UpstreamRegistryUrl pulumi.StringInput
	// The upstream repository prefix associated with the pull through cache rule. Used if the upstream registry is an ECR private registry. If not specified, it's set to `ROOT`, which allows matching with any upstream repository. See [AWS Document - Customizing repository prefixes for ECR to ECR pull through cache](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private-wildcards.html).
	UpstreamRepositoryPrefix pulumi.StringPtrInput
}

func (PullThroughCacheRuleArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*pullThroughCacheRuleArgs)(nil)).Elem()
}

type PullThroughCacheRuleInput interface {
	pulumi.Input

	ToPullThroughCacheRuleOutput() PullThroughCacheRuleOutput
	ToPullThroughCacheRuleOutputWithContext(ctx context.Context) PullThroughCacheRuleOutput
}

func (*PullThroughCacheRule) ElementType() reflect.Type {
	return reflect.TypeOf((**PullThroughCacheRule)(nil)).Elem()
}

func (i *PullThroughCacheRule) ToPullThroughCacheRuleOutput() PullThroughCacheRuleOutput {
	return i.ToPullThroughCacheRuleOutputWithContext(context.Background())
}

func (i *PullThroughCacheRule) ToPullThroughCacheRuleOutputWithContext(ctx context.Context) PullThroughCacheRuleOutput {
	return pulumi.ToOutputWithContext(ctx, i).(PullThroughCacheRuleOutput)
}

// PullThroughCacheRuleArrayInput is an input type that accepts PullThroughCacheRuleArray and PullThroughCacheRuleArrayOutput values.
// You can construct a concrete instance of `PullThroughCacheRuleArrayInput` via:
//
//	PullThroughCacheRuleArray{ PullThroughCacheRuleArgs{...} }
type PullThroughCacheRuleArrayInput interface {
	pulumi.Input

	ToPullThroughCacheRuleArrayOutput() PullThroughCacheRuleArrayOutput
	ToPullThroughCacheRuleArrayOutputWithContext(context.Context) PullThroughCacheRuleArrayOutput
}

type PullThroughCacheRuleArray []PullThroughCacheRuleInput

func (PullThroughCacheRuleArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*PullThroughCacheRule)(nil)).Elem()
}

func (i PullThroughCacheRuleArray) ToPullThroughCacheRuleArrayOutput() PullThroughCacheRuleArrayOutput {
	return i.ToPullThroughCacheRuleArrayOutputWithContext(context.Background())
}

func (i PullThroughCacheRuleArray) ToPullThroughCacheRuleArrayOutputWithContext(ctx context.Context) PullThroughCacheRuleArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(PullThroughCacheRuleArrayOutput)
}

// PullThroughCacheRuleMapInput is an input type that accepts PullThroughCacheRuleMap and PullThroughCacheRuleMapOutput values.
// You can construct a concrete instance of `PullThroughCacheRuleMapInput` via:
//
//	PullThroughCacheRuleMap{ "key": PullThroughCacheRuleArgs{...} }
type PullThroughCacheRuleMapInput interface {
	pulumi.Input

	ToPullThroughCacheRuleMapOutput() PullThroughCacheRuleMapOutput
	ToPullThroughCacheRuleMapOutputWithContext(context.Context) PullThroughCacheRuleMapOutput
}

type PullThroughCacheRuleMap map[string]PullThroughCacheRuleInput

func (PullThroughCacheRuleMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*PullThroughCacheRule)(nil)).Elem()
}

func (i PullThroughCacheRuleMap) ToPullThroughCacheRuleMapOutput() PullThroughCacheRuleMapOutput {
	return i.ToPullThroughCacheRuleMapOutputWithContext(context.Background())
}

func (i PullThroughCacheRuleMap) ToPullThroughCacheRuleMapOutputWithContext(ctx context.Context) PullThroughCacheRuleMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(PullThroughCacheRuleMapOutput)
}

type PullThroughCacheRuleOutput struct{ *pulumi.OutputState }

func (PullThroughCacheRuleOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**PullThroughCacheRule)(nil)).Elem()
}

func (o PullThroughCacheRuleOutput) ToPullThroughCacheRuleOutput() PullThroughCacheRuleOutput {
	return o
}

func (o PullThroughCacheRuleOutput) ToPullThroughCacheRuleOutputWithContext(ctx context.Context) PullThroughCacheRuleOutput {
	return o
}

// ARN of the Secret which will be used to authenticate against the registry.
func (o PullThroughCacheRuleOutput) CredentialArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *PullThroughCacheRule) pulumi.StringPtrOutput { return v.CredentialArn }).(pulumi.StringPtrOutput)
}

// The ARN of the IAM role associated with the pull through cache rule. Must be specified if the upstream registry is a cross-account ECR private registry. See [AWS Document - Setting up permissions for cross-account ECR to ECR PTC](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private.html).
func (o PullThroughCacheRuleOutput) CustomRoleArn() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *PullThroughCacheRule) pulumi.StringPtrOutput { return v.CustomRoleArn }).(pulumi.StringPtrOutput)
}

// The repository name prefix to use when caching images from the source registry. Use `ROOT` as the prefix to apply a template to all repositories in your registry that don't have an associated pull through cache rule.
func (o PullThroughCacheRuleOutput) EcrRepositoryPrefix() pulumi.StringOutput {
	return o.ApplyT(func(v *PullThroughCacheRule) pulumi.StringOutput { return v.EcrRepositoryPrefix }).(pulumi.StringOutput)
}

// The registry ID where the repository was created.
func (o PullThroughCacheRuleOutput) RegistryId() pulumi.StringOutput {
	return o.ApplyT(func(v *PullThroughCacheRule) pulumi.StringOutput { return v.RegistryId }).(pulumi.StringOutput)
}

// The registry URL of the upstream registry to use as the source.
func (o PullThroughCacheRuleOutput) UpstreamRegistryUrl() pulumi.StringOutput {
	return o.ApplyT(func(v *PullThroughCacheRule) pulumi.StringOutput { return v.UpstreamRegistryUrl }).(pulumi.StringOutput)
}

// The upstream repository prefix associated with the pull through cache rule. Used if the upstream registry is an ECR private registry. If not specified, it's set to `ROOT`, which allows matching with any upstream repository. See [AWS Document - Customizing repository prefixes for ECR to ECR pull through cache](https://docs.aws.amazon.com/AmazonECR/latest/userguide/pull-through-cache-private-wildcards.html).
func (o PullThroughCacheRuleOutput) UpstreamRepositoryPrefix() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *PullThroughCacheRule) pulumi.StringPtrOutput { return v.UpstreamRepositoryPrefix }).(pulumi.StringPtrOutput)
}

type PullThroughCacheRuleArrayOutput struct{ *pulumi.OutputState }

func (PullThroughCacheRuleArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*PullThroughCacheRule)(nil)).Elem()
}

func (o PullThroughCacheRuleArrayOutput) ToPullThroughCacheRuleArrayOutput() PullThroughCacheRuleArrayOutput {
	return o
}

func (o PullThroughCacheRuleArrayOutput) ToPullThroughCacheRuleArrayOutputWithContext(ctx context.Context) PullThroughCacheRuleArrayOutput {
	return o
}

func (o PullThroughCacheRuleArrayOutput) Index(i pulumi.IntInput) PullThroughCacheRuleOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *PullThroughCacheRule {
		return vs[0].([]*PullThroughCacheRule)[vs[1].(int)]
	}).(PullThroughCacheRuleOutput)
}

type PullThroughCacheRuleMapOutput struct{ *pulumi.OutputState }

func (PullThroughCacheRuleMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*PullThroughCacheRule)(nil)).Elem()
}

func (o PullThroughCacheRuleMapOutput) ToPullThroughCacheRuleMapOutput() PullThroughCacheRuleMapOutput {
	return o
}

func (o PullThroughCacheRuleMapOutput) ToPullThroughCacheRuleMapOutputWithContext(ctx context.Context) PullThroughCacheRuleMapOutput {
	return o
}

func (o PullThroughCacheRuleMapOutput) MapIndex(k pulumi.StringInput) PullThroughCacheRuleOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *PullThroughCacheRule {
		return vs[0].(map[string]*PullThroughCacheRule)[vs[1].(string)]
	}).(PullThroughCacheRuleOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*PullThroughCacheRuleInput)(nil)).Elem(), &PullThroughCacheRule{})
	pulumi.RegisterInputType(reflect.TypeOf((*PullThroughCacheRuleArrayInput)(nil)).Elem(), PullThroughCacheRuleArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*PullThroughCacheRuleMapInput)(nil)).Elem(), PullThroughCacheRuleMap{})
	pulumi.RegisterOutputType(PullThroughCacheRuleOutput{})
	pulumi.RegisterOutputType(PullThroughCacheRuleArrayOutput{})
	pulumi.RegisterOutputType(PullThroughCacheRuleMapOutput{})
}
