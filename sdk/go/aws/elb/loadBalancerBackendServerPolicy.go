// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package elb

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Attaches a load balancer policy to an ELB backend server.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/elb"
//	"github.com/pulumi/pulumi-std/sdk/go/std"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			wu_tang, err := elb.NewLoadBalancer(ctx, "wu-tang", &elb.LoadBalancerArgs{
//				Name: pulumi.String("wu-tang"),
//				AvailabilityZones: pulumi.StringArray{
//					pulumi.String("us-east-1a"),
//				},
//				Listeners: elb.LoadBalancerListenerArray{
//					&elb.LoadBalancerListenerArgs{
//						InstancePort:     pulumi.Int(443),
//						InstanceProtocol: pulumi.String("http"),
//						LbPort:           pulumi.Int(443),
//						LbProtocol:       pulumi.String("https"),
//						SslCertificateId: pulumi.String("arn:aws:iam::000000000000:server-certificate/wu-tang.net"),
//					},
//				},
//				Tags: pulumi.StringMap{
//					"Name": pulumi.String("wu-tang"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			invokeFile, err := std.File(ctx, &std.FileArgs{
//				Input: "wu-tang-pubkey",
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = elb.NewLoadBalancerPolicy(ctx, "wu-tang-ca-pubkey-policy", &elb.LoadBalancerPolicyArgs{
//				LoadBalancerName: wu_tang.Name,
//				PolicyName:       pulumi.String("wu-tang-ca-pubkey-policy"),
//				PolicyTypeName:   pulumi.String("PublicKeyPolicyType"),
//				PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
//					&elb.LoadBalancerPolicyPolicyAttributeArgs{
//						Name:  pulumi.String("PublicKey"),
//						Value: pulumi.String(invokeFile.Result),
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			wu_tang_root_ca_backend_auth_policy, err := elb.NewLoadBalancerPolicy(ctx, "wu-tang-root-ca-backend-auth-policy", &elb.LoadBalancerPolicyArgs{
//				LoadBalancerName: wu_tang.Name,
//				PolicyName:       pulumi.String("wu-tang-root-ca-backend-auth-policy"),
//				PolicyTypeName:   pulumi.String("BackendServerAuthenticationPolicyType"),
//				PolicyAttributes: elb.LoadBalancerPolicyPolicyAttributeArray{
//					&elb.LoadBalancerPolicyPolicyAttributeArgs{
//						Name:  pulumi.String("PublicKeyPolicyName"),
//						Value: pulumi.Any(wu_tang_root_ca_pubkey_policy.PolicyName),
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = elb.NewLoadBalancerBackendServerPolicy(ctx, "wu-tang-backend-auth-policies-443", &elb.LoadBalancerBackendServerPolicyArgs{
//				LoadBalancerName: wu_tang.Name,
//				InstancePort:     pulumi.Int(443),
//				PolicyNames: pulumi.StringArray{
//					wu_tang_root_ca_backend_auth_policy.PolicyName,
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
type LoadBalancerBackendServerPolicy struct {
	pulumi.CustomResourceState

	// The instance port to apply the policy to.
	InstancePort pulumi.IntOutput `pulumi:"instancePort"`
	// The load balancer to attach the policy to.
	LoadBalancerName pulumi.StringOutput `pulumi:"loadBalancerName"`
	// List of Policy Names to apply to the backend server.
	PolicyNames pulumi.StringArrayOutput `pulumi:"policyNames"`
}

// NewLoadBalancerBackendServerPolicy registers a new resource with the given unique name, arguments, and options.
func NewLoadBalancerBackendServerPolicy(ctx *pulumi.Context,
	name string, args *LoadBalancerBackendServerPolicyArgs, opts ...pulumi.ResourceOption) (*LoadBalancerBackendServerPolicy, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.InstancePort == nil {
		return nil, errors.New("invalid value for required argument 'InstancePort'")
	}
	if args.LoadBalancerName == nil {
		return nil, errors.New("invalid value for required argument 'LoadBalancerName'")
	}
	aliases := pulumi.Aliases([]pulumi.Alias{
		{
			Type: pulumi.String("aws:elasticloadbalancing/loadBalancerBackendServerPolicy:LoadBalancerBackendServerPolicy"),
		},
	})
	opts = append(opts, aliases)
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource LoadBalancerBackendServerPolicy
	err := ctx.RegisterResource("aws:elb/loadBalancerBackendServerPolicy:LoadBalancerBackendServerPolicy", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetLoadBalancerBackendServerPolicy gets an existing LoadBalancerBackendServerPolicy resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetLoadBalancerBackendServerPolicy(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *LoadBalancerBackendServerPolicyState, opts ...pulumi.ResourceOption) (*LoadBalancerBackendServerPolicy, error) {
	var resource LoadBalancerBackendServerPolicy
	err := ctx.ReadResource("aws:elb/loadBalancerBackendServerPolicy:LoadBalancerBackendServerPolicy", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering LoadBalancerBackendServerPolicy resources.
type loadBalancerBackendServerPolicyState struct {
	// The instance port to apply the policy to.
	InstancePort *int `pulumi:"instancePort"`
	// The load balancer to attach the policy to.
	LoadBalancerName *string `pulumi:"loadBalancerName"`
	// List of Policy Names to apply to the backend server.
	PolicyNames []string `pulumi:"policyNames"`
}

type LoadBalancerBackendServerPolicyState struct {
	// The instance port to apply the policy to.
	InstancePort pulumi.IntPtrInput
	// The load balancer to attach the policy to.
	LoadBalancerName pulumi.StringPtrInput
	// List of Policy Names to apply to the backend server.
	PolicyNames pulumi.StringArrayInput
}

func (LoadBalancerBackendServerPolicyState) ElementType() reflect.Type {
	return reflect.TypeOf((*loadBalancerBackendServerPolicyState)(nil)).Elem()
}

type loadBalancerBackendServerPolicyArgs struct {
	// The instance port to apply the policy to.
	InstancePort int `pulumi:"instancePort"`
	// The load balancer to attach the policy to.
	LoadBalancerName string `pulumi:"loadBalancerName"`
	// List of Policy Names to apply to the backend server.
	PolicyNames []string `pulumi:"policyNames"`
}

// The set of arguments for constructing a LoadBalancerBackendServerPolicy resource.
type LoadBalancerBackendServerPolicyArgs struct {
	// The instance port to apply the policy to.
	InstancePort pulumi.IntInput
	// The load balancer to attach the policy to.
	LoadBalancerName pulumi.StringInput
	// List of Policy Names to apply to the backend server.
	PolicyNames pulumi.StringArrayInput
}

func (LoadBalancerBackendServerPolicyArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*loadBalancerBackendServerPolicyArgs)(nil)).Elem()
}

type LoadBalancerBackendServerPolicyInput interface {
	pulumi.Input

	ToLoadBalancerBackendServerPolicyOutput() LoadBalancerBackendServerPolicyOutput
	ToLoadBalancerBackendServerPolicyOutputWithContext(ctx context.Context) LoadBalancerBackendServerPolicyOutput
}

func (*LoadBalancerBackendServerPolicy) ElementType() reflect.Type {
	return reflect.TypeOf((**LoadBalancerBackendServerPolicy)(nil)).Elem()
}

func (i *LoadBalancerBackendServerPolicy) ToLoadBalancerBackendServerPolicyOutput() LoadBalancerBackendServerPolicyOutput {
	return i.ToLoadBalancerBackendServerPolicyOutputWithContext(context.Background())
}

func (i *LoadBalancerBackendServerPolicy) ToLoadBalancerBackendServerPolicyOutputWithContext(ctx context.Context) LoadBalancerBackendServerPolicyOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LoadBalancerBackendServerPolicyOutput)
}

// LoadBalancerBackendServerPolicyArrayInput is an input type that accepts LoadBalancerBackendServerPolicyArray and LoadBalancerBackendServerPolicyArrayOutput values.
// You can construct a concrete instance of `LoadBalancerBackendServerPolicyArrayInput` via:
//
//	LoadBalancerBackendServerPolicyArray{ LoadBalancerBackendServerPolicyArgs{...} }
type LoadBalancerBackendServerPolicyArrayInput interface {
	pulumi.Input

	ToLoadBalancerBackendServerPolicyArrayOutput() LoadBalancerBackendServerPolicyArrayOutput
	ToLoadBalancerBackendServerPolicyArrayOutputWithContext(context.Context) LoadBalancerBackendServerPolicyArrayOutput
}

type LoadBalancerBackendServerPolicyArray []LoadBalancerBackendServerPolicyInput

func (LoadBalancerBackendServerPolicyArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LoadBalancerBackendServerPolicy)(nil)).Elem()
}

func (i LoadBalancerBackendServerPolicyArray) ToLoadBalancerBackendServerPolicyArrayOutput() LoadBalancerBackendServerPolicyArrayOutput {
	return i.ToLoadBalancerBackendServerPolicyArrayOutputWithContext(context.Background())
}

func (i LoadBalancerBackendServerPolicyArray) ToLoadBalancerBackendServerPolicyArrayOutputWithContext(ctx context.Context) LoadBalancerBackendServerPolicyArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LoadBalancerBackendServerPolicyArrayOutput)
}

// LoadBalancerBackendServerPolicyMapInput is an input type that accepts LoadBalancerBackendServerPolicyMap and LoadBalancerBackendServerPolicyMapOutput values.
// You can construct a concrete instance of `LoadBalancerBackendServerPolicyMapInput` via:
//
//	LoadBalancerBackendServerPolicyMap{ "key": LoadBalancerBackendServerPolicyArgs{...} }
type LoadBalancerBackendServerPolicyMapInput interface {
	pulumi.Input

	ToLoadBalancerBackendServerPolicyMapOutput() LoadBalancerBackendServerPolicyMapOutput
	ToLoadBalancerBackendServerPolicyMapOutputWithContext(context.Context) LoadBalancerBackendServerPolicyMapOutput
}

type LoadBalancerBackendServerPolicyMap map[string]LoadBalancerBackendServerPolicyInput

func (LoadBalancerBackendServerPolicyMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LoadBalancerBackendServerPolicy)(nil)).Elem()
}

func (i LoadBalancerBackendServerPolicyMap) ToLoadBalancerBackendServerPolicyMapOutput() LoadBalancerBackendServerPolicyMapOutput {
	return i.ToLoadBalancerBackendServerPolicyMapOutputWithContext(context.Background())
}

func (i LoadBalancerBackendServerPolicyMap) ToLoadBalancerBackendServerPolicyMapOutputWithContext(ctx context.Context) LoadBalancerBackendServerPolicyMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(LoadBalancerBackendServerPolicyMapOutput)
}

type LoadBalancerBackendServerPolicyOutput struct{ *pulumi.OutputState }

func (LoadBalancerBackendServerPolicyOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**LoadBalancerBackendServerPolicy)(nil)).Elem()
}

func (o LoadBalancerBackendServerPolicyOutput) ToLoadBalancerBackendServerPolicyOutput() LoadBalancerBackendServerPolicyOutput {
	return o
}

func (o LoadBalancerBackendServerPolicyOutput) ToLoadBalancerBackendServerPolicyOutputWithContext(ctx context.Context) LoadBalancerBackendServerPolicyOutput {
	return o
}

// The instance port to apply the policy to.
func (o LoadBalancerBackendServerPolicyOutput) InstancePort() pulumi.IntOutput {
	return o.ApplyT(func(v *LoadBalancerBackendServerPolicy) pulumi.IntOutput { return v.InstancePort }).(pulumi.IntOutput)
}

// The load balancer to attach the policy to.
func (o LoadBalancerBackendServerPolicyOutput) LoadBalancerName() pulumi.StringOutput {
	return o.ApplyT(func(v *LoadBalancerBackendServerPolicy) pulumi.StringOutput { return v.LoadBalancerName }).(pulumi.StringOutput)
}

// List of Policy Names to apply to the backend server.
func (o LoadBalancerBackendServerPolicyOutput) PolicyNames() pulumi.StringArrayOutput {
	return o.ApplyT(func(v *LoadBalancerBackendServerPolicy) pulumi.StringArrayOutput { return v.PolicyNames }).(pulumi.StringArrayOutput)
}

type LoadBalancerBackendServerPolicyArrayOutput struct{ *pulumi.OutputState }

func (LoadBalancerBackendServerPolicyArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*LoadBalancerBackendServerPolicy)(nil)).Elem()
}

func (o LoadBalancerBackendServerPolicyArrayOutput) ToLoadBalancerBackendServerPolicyArrayOutput() LoadBalancerBackendServerPolicyArrayOutput {
	return o
}

func (o LoadBalancerBackendServerPolicyArrayOutput) ToLoadBalancerBackendServerPolicyArrayOutputWithContext(ctx context.Context) LoadBalancerBackendServerPolicyArrayOutput {
	return o
}

func (o LoadBalancerBackendServerPolicyArrayOutput) Index(i pulumi.IntInput) LoadBalancerBackendServerPolicyOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *LoadBalancerBackendServerPolicy {
		return vs[0].([]*LoadBalancerBackendServerPolicy)[vs[1].(int)]
	}).(LoadBalancerBackendServerPolicyOutput)
}

type LoadBalancerBackendServerPolicyMapOutput struct{ *pulumi.OutputState }

func (LoadBalancerBackendServerPolicyMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*LoadBalancerBackendServerPolicy)(nil)).Elem()
}

func (o LoadBalancerBackendServerPolicyMapOutput) ToLoadBalancerBackendServerPolicyMapOutput() LoadBalancerBackendServerPolicyMapOutput {
	return o
}

func (o LoadBalancerBackendServerPolicyMapOutput) ToLoadBalancerBackendServerPolicyMapOutputWithContext(ctx context.Context) LoadBalancerBackendServerPolicyMapOutput {
	return o
}

func (o LoadBalancerBackendServerPolicyMapOutput) MapIndex(k pulumi.StringInput) LoadBalancerBackendServerPolicyOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *LoadBalancerBackendServerPolicy {
		return vs[0].(map[string]*LoadBalancerBackendServerPolicy)[vs[1].(string)]
	}).(LoadBalancerBackendServerPolicyOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*LoadBalancerBackendServerPolicyInput)(nil)).Elem(), &LoadBalancerBackendServerPolicy{})
	pulumi.RegisterInputType(reflect.TypeOf((*LoadBalancerBackendServerPolicyArrayInput)(nil)).Elem(), LoadBalancerBackendServerPolicyArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*LoadBalancerBackendServerPolicyMapInput)(nil)).Elem(), LoadBalancerBackendServerPolicyMap{})
	pulumi.RegisterOutputType(LoadBalancerBackendServerPolicyOutput{})
	pulumi.RegisterOutputType(LoadBalancerBackendServerPolicyArrayOutput{})
	pulumi.RegisterOutputType(LoadBalancerBackendServerPolicyMapOutput{})
}
