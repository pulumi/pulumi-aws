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

// Provides an application cookie stickiness policy, which allows an ELB to wed its sticky cookie's expiration to a cookie generated by your application.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/elb"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			lb, err := elb.NewLoadBalancer(ctx, "lb", &elb.LoadBalancerArgs{
//				Name: pulumi.String("test-lb"),
//				AvailabilityZones: pulumi.StringArray{
//					pulumi.String("us-east-1a"),
//				},
//				Listeners: elb.LoadBalancerListenerArray{
//					&elb.LoadBalancerListenerArgs{
//						InstancePort:     pulumi.Int(8000),
//						InstanceProtocol: pulumi.String("http"),
//						LbPort:           pulumi.Int(80),
//						LbProtocol:       pulumi.String("http"),
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			_, err = elb.NewAppCookieStickinessPolicy(ctx, "foo", &elb.AppCookieStickinessPolicyArgs{
//				Name:         pulumi.String("foo_policy"),
//				LoadBalancer: lb.Name,
//				LbPort:       pulumi.Int(80),
//				CookieName:   pulumi.String("MyAppCookie"),
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
// Using `pulumi import`, import application cookie stickiness policies using the ELB name, port, and policy name separated by colons (`:`). For example:
//
// ```sh
// $ pulumi import aws:elb/appCookieStickinessPolicy:AppCookieStickinessPolicy example my-elb:80:my-policy
// ```
type AppCookieStickinessPolicy struct {
	pulumi.CustomResourceState

	// Application cookie whose lifetime the ELB's cookie should follow.
	CookieName pulumi.StringOutput `pulumi:"cookieName"`
	// Load balancer port to which the policy
	// should be applied. This must be an active listener on the load
	// balancer.
	LbPort pulumi.IntOutput `pulumi:"lbPort"`
	// Name of load balancer to which the policy
	// should be attached.
	LoadBalancer pulumi.StringOutput `pulumi:"loadBalancer"`
	// Name of the stickiness policy.
	Name pulumi.StringOutput `pulumi:"name"`
}

// NewAppCookieStickinessPolicy registers a new resource with the given unique name, arguments, and options.
func NewAppCookieStickinessPolicy(ctx *pulumi.Context,
	name string, args *AppCookieStickinessPolicyArgs, opts ...pulumi.ResourceOption) (*AppCookieStickinessPolicy, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.CookieName == nil {
		return nil, errors.New("invalid value for required argument 'CookieName'")
	}
	if args.LbPort == nil {
		return nil, errors.New("invalid value for required argument 'LbPort'")
	}
	if args.LoadBalancer == nil {
		return nil, errors.New("invalid value for required argument 'LoadBalancer'")
	}
	aliases := pulumi.Aliases([]pulumi.Alias{
		{
			Type: pulumi.String("aws:elasticloadbalancing/appCookieStickinessPolicy:AppCookieStickinessPolicy"),
		},
	})
	opts = append(opts, aliases)
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource AppCookieStickinessPolicy
	err := ctx.RegisterResource("aws:elb/appCookieStickinessPolicy:AppCookieStickinessPolicy", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAppCookieStickinessPolicy gets an existing AppCookieStickinessPolicy resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAppCookieStickinessPolicy(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AppCookieStickinessPolicyState, opts ...pulumi.ResourceOption) (*AppCookieStickinessPolicy, error) {
	var resource AppCookieStickinessPolicy
	err := ctx.ReadResource("aws:elb/appCookieStickinessPolicy:AppCookieStickinessPolicy", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AppCookieStickinessPolicy resources.
type appCookieStickinessPolicyState struct {
	// Application cookie whose lifetime the ELB's cookie should follow.
	CookieName *string `pulumi:"cookieName"`
	// Load balancer port to which the policy
	// should be applied. This must be an active listener on the load
	// balancer.
	LbPort *int `pulumi:"lbPort"`
	// Name of load balancer to which the policy
	// should be attached.
	LoadBalancer *string `pulumi:"loadBalancer"`
	// Name of the stickiness policy.
	Name *string `pulumi:"name"`
}

type AppCookieStickinessPolicyState struct {
	// Application cookie whose lifetime the ELB's cookie should follow.
	CookieName pulumi.StringPtrInput
	// Load balancer port to which the policy
	// should be applied. This must be an active listener on the load
	// balancer.
	LbPort pulumi.IntPtrInput
	// Name of load balancer to which the policy
	// should be attached.
	LoadBalancer pulumi.StringPtrInput
	// Name of the stickiness policy.
	Name pulumi.StringPtrInput
}

func (AppCookieStickinessPolicyState) ElementType() reflect.Type {
	return reflect.TypeOf((*appCookieStickinessPolicyState)(nil)).Elem()
}

type appCookieStickinessPolicyArgs struct {
	// Application cookie whose lifetime the ELB's cookie should follow.
	CookieName string `pulumi:"cookieName"`
	// Load balancer port to which the policy
	// should be applied. This must be an active listener on the load
	// balancer.
	LbPort int `pulumi:"lbPort"`
	// Name of load balancer to which the policy
	// should be attached.
	LoadBalancer string `pulumi:"loadBalancer"`
	// Name of the stickiness policy.
	Name *string `pulumi:"name"`
}

// The set of arguments for constructing a AppCookieStickinessPolicy resource.
type AppCookieStickinessPolicyArgs struct {
	// Application cookie whose lifetime the ELB's cookie should follow.
	CookieName pulumi.StringInput
	// Load balancer port to which the policy
	// should be applied. This must be an active listener on the load
	// balancer.
	LbPort pulumi.IntInput
	// Name of load balancer to which the policy
	// should be attached.
	LoadBalancer pulumi.StringInput
	// Name of the stickiness policy.
	Name pulumi.StringPtrInput
}

func (AppCookieStickinessPolicyArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*appCookieStickinessPolicyArgs)(nil)).Elem()
}

type AppCookieStickinessPolicyInput interface {
	pulumi.Input

	ToAppCookieStickinessPolicyOutput() AppCookieStickinessPolicyOutput
	ToAppCookieStickinessPolicyOutputWithContext(ctx context.Context) AppCookieStickinessPolicyOutput
}

func (*AppCookieStickinessPolicy) ElementType() reflect.Type {
	return reflect.TypeOf((**AppCookieStickinessPolicy)(nil)).Elem()
}

func (i *AppCookieStickinessPolicy) ToAppCookieStickinessPolicyOutput() AppCookieStickinessPolicyOutput {
	return i.ToAppCookieStickinessPolicyOutputWithContext(context.Background())
}

func (i *AppCookieStickinessPolicy) ToAppCookieStickinessPolicyOutputWithContext(ctx context.Context) AppCookieStickinessPolicyOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppCookieStickinessPolicyOutput)
}

// AppCookieStickinessPolicyArrayInput is an input type that accepts AppCookieStickinessPolicyArray and AppCookieStickinessPolicyArrayOutput values.
// You can construct a concrete instance of `AppCookieStickinessPolicyArrayInput` via:
//
//	AppCookieStickinessPolicyArray{ AppCookieStickinessPolicyArgs{...} }
type AppCookieStickinessPolicyArrayInput interface {
	pulumi.Input

	ToAppCookieStickinessPolicyArrayOutput() AppCookieStickinessPolicyArrayOutput
	ToAppCookieStickinessPolicyArrayOutputWithContext(context.Context) AppCookieStickinessPolicyArrayOutput
}

type AppCookieStickinessPolicyArray []AppCookieStickinessPolicyInput

func (AppCookieStickinessPolicyArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AppCookieStickinessPolicy)(nil)).Elem()
}

func (i AppCookieStickinessPolicyArray) ToAppCookieStickinessPolicyArrayOutput() AppCookieStickinessPolicyArrayOutput {
	return i.ToAppCookieStickinessPolicyArrayOutputWithContext(context.Background())
}

func (i AppCookieStickinessPolicyArray) ToAppCookieStickinessPolicyArrayOutputWithContext(ctx context.Context) AppCookieStickinessPolicyArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppCookieStickinessPolicyArrayOutput)
}

// AppCookieStickinessPolicyMapInput is an input type that accepts AppCookieStickinessPolicyMap and AppCookieStickinessPolicyMapOutput values.
// You can construct a concrete instance of `AppCookieStickinessPolicyMapInput` via:
//
//	AppCookieStickinessPolicyMap{ "key": AppCookieStickinessPolicyArgs{...} }
type AppCookieStickinessPolicyMapInput interface {
	pulumi.Input

	ToAppCookieStickinessPolicyMapOutput() AppCookieStickinessPolicyMapOutput
	ToAppCookieStickinessPolicyMapOutputWithContext(context.Context) AppCookieStickinessPolicyMapOutput
}

type AppCookieStickinessPolicyMap map[string]AppCookieStickinessPolicyInput

func (AppCookieStickinessPolicyMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AppCookieStickinessPolicy)(nil)).Elem()
}

func (i AppCookieStickinessPolicyMap) ToAppCookieStickinessPolicyMapOutput() AppCookieStickinessPolicyMapOutput {
	return i.ToAppCookieStickinessPolicyMapOutputWithContext(context.Background())
}

func (i AppCookieStickinessPolicyMap) ToAppCookieStickinessPolicyMapOutputWithContext(ctx context.Context) AppCookieStickinessPolicyMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AppCookieStickinessPolicyMapOutput)
}

type AppCookieStickinessPolicyOutput struct{ *pulumi.OutputState }

func (AppCookieStickinessPolicyOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AppCookieStickinessPolicy)(nil)).Elem()
}

func (o AppCookieStickinessPolicyOutput) ToAppCookieStickinessPolicyOutput() AppCookieStickinessPolicyOutput {
	return o
}

func (o AppCookieStickinessPolicyOutput) ToAppCookieStickinessPolicyOutputWithContext(ctx context.Context) AppCookieStickinessPolicyOutput {
	return o
}

// Application cookie whose lifetime the ELB's cookie should follow.
func (o AppCookieStickinessPolicyOutput) CookieName() pulumi.StringOutput {
	return o.ApplyT(func(v *AppCookieStickinessPolicy) pulumi.StringOutput { return v.CookieName }).(pulumi.StringOutput)
}

// Load balancer port to which the policy
// should be applied. This must be an active listener on the load
// balancer.
func (o AppCookieStickinessPolicyOutput) LbPort() pulumi.IntOutput {
	return o.ApplyT(func(v *AppCookieStickinessPolicy) pulumi.IntOutput { return v.LbPort }).(pulumi.IntOutput)
}

// Name of load balancer to which the policy
// should be attached.
func (o AppCookieStickinessPolicyOutput) LoadBalancer() pulumi.StringOutput {
	return o.ApplyT(func(v *AppCookieStickinessPolicy) pulumi.StringOutput { return v.LoadBalancer }).(pulumi.StringOutput)
}

// Name of the stickiness policy.
func (o AppCookieStickinessPolicyOutput) Name() pulumi.StringOutput {
	return o.ApplyT(func(v *AppCookieStickinessPolicy) pulumi.StringOutput { return v.Name }).(pulumi.StringOutput)
}

type AppCookieStickinessPolicyArrayOutput struct{ *pulumi.OutputState }

func (AppCookieStickinessPolicyArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AppCookieStickinessPolicy)(nil)).Elem()
}

func (o AppCookieStickinessPolicyArrayOutput) ToAppCookieStickinessPolicyArrayOutput() AppCookieStickinessPolicyArrayOutput {
	return o
}

func (o AppCookieStickinessPolicyArrayOutput) ToAppCookieStickinessPolicyArrayOutputWithContext(ctx context.Context) AppCookieStickinessPolicyArrayOutput {
	return o
}

func (o AppCookieStickinessPolicyArrayOutput) Index(i pulumi.IntInput) AppCookieStickinessPolicyOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AppCookieStickinessPolicy {
		return vs[0].([]*AppCookieStickinessPolicy)[vs[1].(int)]
	}).(AppCookieStickinessPolicyOutput)
}

type AppCookieStickinessPolicyMapOutput struct{ *pulumi.OutputState }

func (AppCookieStickinessPolicyMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AppCookieStickinessPolicy)(nil)).Elem()
}

func (o AppCookieStickinessPolicyMapOutput) ToAppCookieStickinessPolicyMapOutput() AppCookieStickinessPolicyMapOutput {
	return o
}

func (o AppCookieStickinessPolicyMapOutput) ToAppCookieStickinessPolicyMapOutputWithContext(ctx context.Context) AppCookieStickinessPolicyMapOutput {
	return o
}

func (o AppCookieStickinessPolicyMapOutput) MapIndex(k pulumi.StringInput) AppCookieStickinessPolicyOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AppCookieStickinessPolicy {
		return vs[0].(map[string]*AppCookieStickinessPolicy)[vs[1].(string)]
	}).(AppCookieStickinessPolicyOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AppCookieStickinessPolicyInput)(nil)).Elem(), &AppCookieStickinessPolicy{})
	pulumi.RegisterInputType(reflect.TypeOf((*AppCookieStickinessPolicyArrayInput)(nil)).Elem(), AppCookieStickinessPolicyArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AppCookieStickinessPolicyMapInput)(nil)).Elem(), AppCookieStickinessPolicyMap{})
	pulumi.RegisterOutputType(AppCookieStickinessPolicyOutput{})
	pulumi.RegisterOutputType(AppCookieStickinessPolicyArrayOutput{})
	pulumi.RegisterOutputType(AppCookieStickinessPolicyMapOutput{})
}
