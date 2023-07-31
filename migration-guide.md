# Migrating from v5 to v6

## Upstream Changes

The upstream target has been changed from [v4.67.0](https://github.com/pulumi/pulumi-aws/pull/2521) to targeting v5.8.0. That means that the upstream [migration guide](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/guides/version-5-upgrade) as well as the following `CHANGELOG`s are relevant:
- [v5.0.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.0.0)
- [v5.0.1](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.0.1)
- [v5.1.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.1.0)
- [v5.2.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.2.0)
- [v5.3.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.3.0)
- [v5.4.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.4.0)
- [v5.5.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.5.0)
- [v5.6.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.6.0)
- [v5.6.1](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.6.1)
- [v5.6.2](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.6.2)
- [v5.7.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.7.0)
- [v5.8.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.8.0)
- [v5.9.0](https://github.com/hashicorp/terraform-provider-aws/releases/tag/v5.9.0)

## Deprecated resources and functions

The resources and functions listed below were renamed in a previous version. With this release, the original names have been fully deprecated. Any existing references to the original name will need to be updated.

{{< chooser language "typescript,python,go,csharp,java,yaml" >}}

{{% chooseable language typescript }}

```diff
- const test = new aws.applicationloadbalancing.TargetGroup("test", {
+ const test = new aws.lb.TargetGroup("test", {
      port: 80,
      protocol: "HTTP",
      vpcId: main.id,
});
```

{{% /chooseable %}}

{{% choosable language python %}}

```diff
-  test = aws.applicationloadbalancing.TargetGroup("test",
+  test = aws.lb.TargetGroup("test",
       port=80,
       protocol="HTTP",
       vpc_id=main.id)
```

{{% /choosable %}}

{{% choosable language go %}}

```diff
- "github.com/pulumi/pulumi-aws/sdk/v5/go/aws/applicationloadbalancing"
+ "github.com/pulumi/pulumi-aws/sdk/v6/go/aws/lb"

- _, err = applicationloadbalancing.NewTargetGroup(ctx, "test", &lb.TargetGroupArgs{
+ _, err = lb.NewTargetGroup(ctx, "test", &lb.TargetGroupArgs{
      Port:     pulumi.Int(80),
      Protocol: pulumi.String("HTTP"),
      VpcId:    main.ID(),
  })
```

{{% /choosable %}}

{{% choosable language csharp %}}

```diff
- var test = new Aws.ApplicationLoadBalancing.TargetGroup("test", new()
+ var test = new Aws.LB.TargetGroup("test", new()
  {
      Port = 80,
      Protocol = "HTTP",
      VpcId = main.Id,
  });
```

{{% /choosable %}}

{{% choosable language java %}}

```diff
- import com.pulumi.aws.applicationLoadBalancing.TargetGroup;
+ import com.pulumi.aws.lb.TargetGroup;

    var test = new TargetGroup("test", TargetGroupArgs.builder()
        .port(80)
        .protocol("HTTP")
        .vpcId(main.id())
        .build());
```

{{% /choosable %}}

{{% choosable language yaml %}}

```diff
- type: aws:applicationLoadBalancing:TargetGroup
+ type: aws:lb:TargetGroup
    properties:
      port: 80
      protocol: HTTP
      vpcId: ${main.id}
```

{{% /choosable %}}

{{< /chooser >}}

### Resources

- aws:applicationloadbalancing/listener:Listener -> [aws:alb/listener:Listener](https://www.pulumi.com/registry/packages/aws/api-docs/alb/listener/)
- aws:applicationloadbalancing/listenerCertificate:ListenerCertificate -> [aws:applicationloadbalancing/listenerCertificate:ListenerCertificate](https://www.pulumi.com/registry/packages/aws/api-docs/alb/listenercertificate/)
- aws:alb/listenerRule:ListenerRule -> [aws:alb/listenerRule:ListenerRule](https://www.pulumi.com/registry/packages/aws/api-docs/alb/listenerrule/)
- aws:applicationloadbalancing/loadBalancer:LoadBalancer -> [aws:alb/loadBalancer:LoadBalancer](https://www.pulumi.com/registry/packages/aws/api-docs/alb/loadbalancer/)
- aws:applicationloadbalancing/targetGroup:TargetGroup -> [aws:alb/targetGroup:TargetGroup](https://www.pulumi.com/registry/packages/aws/api-docs/alb/targetgroup/)
- aws:applicationloadbalancing/targetGroupAttachment:TargetGroupAttachment -> [aws:applicationloadbalancing/targetGroupAttachment:TargetGroupAttachment](https://www.pulumi.com/registry/packages/aws/api-docs/alb/targetgroupattachment/)
- aws:ec2/transitGatewayPeeringAttachmentAccepter:TransitGatewayPeeringAttachmentAccepter -> [aws:ec2transitgateway/peeringAttachment:PeeringAttachment](https://www.pulumi.com/registry/packages/aws/api-docs/ec2transitgateway/peeringattachmentaccepter/)
- aws:elasticloadbalancing/appCookieStickinessPolicy:AppCookieStickinessPolicy -> [aws:elb/appCookieStickinessPolicy:AppCookieStickinessPolicy](https://www.pulumi.com/registry/packages/aws/api-docs/elb/appcookiestickinesspolicy/)
- aws:elasticloadbalancing/attachment:Attachment -> [aws:elb/attachment:Attachment](https://www.pulumi.com/registry/packages/aws/api-docs/elb/attachment/)
- aws:elasticloadbalancing/listenerPolicy:ListenerPolicy -> [aws:elb/listenerPolicy:ListenerPolicy](https://www.pulumi.com/registry/packages/aws/api-docs/elb/listenerpolicy/)
- aws:elasticloadbalancing/loadBalancer:LoadBalancer -> [aws:elb/loadBalancer:LoadBalancer](https://www.pulumi.com/registry/packages/aws/api-docs/elb/loadbalancer/)
- aws:elasticloadbalancing/loadBalancerBackendServerPolicy:LoadBalancerBackendServerPolicy -> [aws:elb/loadBalancerBackendServerPolicy:LoadBalancerBackendServerPolicy](https://www.pulumi.com/registry/packages/aws/api-docs/elb/loadbalancerbackendserverpolicy/)
- aws:elasticloadbalancing/loadBalancerCookieStickinessPolicy:LoadBalancerCookieStickinessPolicy -> [aws:elb/loadBalancerCookieStickinessPolicy:LoadBalancerCookieStickinessPolicy](https://www.pulumi.com/registry/packages/aws/api-docs/elb/loadbalancercookiestickinesspolicy/)
- aws:elasticloadbalancing/loadBalancerPolicy:LoadBalancerPolicy -> [aws:elb/loadBalancerPolicy:LoadBalancerPolicy](https://www.pulumi.com/registry/packages/aws/api-docs/elb/loadbalancerpolicy/)
- aws:elasticloadbalancing/sslNegotiationPolicy:SslNegotiationPolicy -> [aws:elb/sslNegotiationPolicy:SslNegotiationPolicy](https://www.pulumi.com/registry/packages/aws/api-docs/elb/sslnegotiationpolicy/)
- aws:elasticloadbalancingv2/listener:Listener -> [aws:lb/listener:Listener](https://www.pulumi.com/registry/packages/aws/api-docs/lb/listener/)
- aws:elasticloadbalancingv2/listenerCertificate:ListenerCertificate -> [aws:lb/listenerCertificate:ListenerCertificate](https://www.pulumi.com/registry/packages/aws/api-docs/lb/listenercertificate/)
- aws:elasticloadbalancingv2/listenerRule:ListenerRule -> [aws:lb/listenerRule:ListenerRule](https://www.pulumi.com/registry/packages/aws/api-docs/lb/listenerrule/)
- aws:elasticloadbalancingv2/loadBalancer:LoadBalancer -> [aws:lb/loadBalancer:LoadBalancer](https://www.pulumi.com/registry/packages/aws/api-docs/lb/loadbalancer/)
- aws:elasticloadbalancingv2/targetGroup:TargetGroup -> [aws:elbv2/targetGroup:TargetGroup](https://www.pulumi.com/registry/packages/aws/api-docs/lb/targetgroup/)
- aws:elasticloadbalancingv2/targetGroupAttachment:TargetGroupAttachment -> [aws:lb/targetGroupAttachment:TargetGroupAttachment](https://www.pulumi.com/registry/packages/aws/api-docs/lb/targetgroupattachment/)

### Functions

- aws:applicationloadbalancing/getListener:getListener -> [aws:alb/getListener:getListener](https://www.pulumi.com/registry/packages/aws/api-docs/alb/getlistener/)
- aws:applicationloadbalancing/getLoadBalancer:getLoadBalancer -> [aws:alb/getLoadBalancer:getLoadBalancer](https://www.pulumi.com/registry/packages/aws/api-docs/alb/getloadbalancer/)
- aws:applicationloadbalancing/getTargetGroup:getTargetGroup -> [aws:alb/getTargetGroup:getTargetGroup](https://www.pulumi.com/registry/packages/aws/api-docs/alb/gettargetgroup/)
- aws:cloudtrail/getFunction:getFunction -> [aws:cloudfront/getFunction:getFunction](https://www.pulumi.com/registry/packages/aws/api-docs/cloudfront/getfunction/)
- aws:elasticloadbalancing/getHostedZoneId:getHostedZoneId -> [aws:elb/getHostedZoneId:getHostedZoneId](https://www.pulumi.com/registry/packages/aws/api-docs/elb/gethostedzoneid)
- aws:elasticloadbalancing/getLoadBalancer:getLoadBalancer -> [- aws:elb/getLoadBalancer:getLoadBalancer](https://www.pulumi.com/registry/packages/aws/api-docs/elb/getloadbalancer)
- aws:elasticloadbalancing/getServiceAccount:getServiceAccount -> [- aws:elb/getServiceAccount:getServiceAccount](https://www.pulumi.com/registry/packages/aws/api-docs/elb/getserviceaccount)
- aws:elasticloadbalancingv2/getListener:getListener -> [aws:lb/getListener:getListener](https://www.pulumi.com/registry/packages/aws/api-docs/lb/getlistener)
- aws:elasticloadbalancingv2/getLoadBalancer:getLoadBalancer -> [aws:lb/getLoadBalancer:getLoadBalancer](https://www.pulumi.com/registry/packages/aws/api-docs/lb/getloadbalancer)
- aws:elasticloadbalancingv2/getTargetGroup:getTargetGroup -> [aws:lb/getTargetGroup:getTargetGroup](https://www.pulumi.com/registry/packages/aws/api-docs/lb/gettargetgroup)
- aws:iam/getOpenidConnectProvider:getOpenidConnectProvider -> [aws:iam/getOpenIdConnectProvider:getOpenIdConnectProvider](https://www.pulumi.com/registry/packages/aws/api-docs/iam/getopenidconnectprovider/)
- aws:index/getAmi:getAmi -> [aws:ec2/getAmi:getAmi](https://www.pulumi.com/registry/packages/aws/api-docs/ec2/getami/)
- aws:index/getAmiIds:getAmiIds -> [aws:ec2/getAmiIds:getAmiIds](https://www.pulumi.com/registry/packages/aws/api-docs/ec2/getamiids/)
- aws:index/getAutoscalingGroups:getAutoscalingGroups -> [aws:autoscaling/getAmiIds:getAmiIds](https://www.pulumi.com/registry/packages/aws/api-docs/autoscaling/getamiids/)
- aws:index/getCanonicalUserId:getCanonicalUserId -> [aws:s3/getCanonicalUserId:getCanonicalUserId](https://www.pulumi.com/registry/packages/aws/api-docs/s3/getcanonicaluserid/)
- aws:index/getElasticIp:getElasticIp -> [aws:ec2/getElasticIp:getElasticIp](https://www.pulumi.com/registry/packages/aws/api-docs/ec2/getelasticip/)
- aws:index/getPrefixList:getPrefixList -> [aws:ec2/getPrefixList:getPrefixList](https://www.pulumi.com/registry/packages/aws/api-docs/ec2/getprefixlist/)

## Property Removal

The [aws.sdk](https://github.com/pulumi/pulumi-aws/pull/2584)
property has been removed as it has already been deprecated upstream. The underlying functionality is still accessible by directly importing the AWS Typescript sdk. See https://github.com/pulumi/pulumi-aws/pull/2584 for more details.

## WafV2

The `wafv2` module has been refactored to properly define recursive types resulting in a significant decrease in SDK size.
Any references to `RuleGroupRuleStatement` or `WebAclRuleStatement` properties on a wafv2 resource, will need to be updated to use the new recursive types in the `wafv2` module.

{{< chooser language "typescript,python,go,csharp,java,yaml" >}}

{{% chooseable language typescript }}

```diff
-
+
```

{{% /chooseable %}}

{{% choosable language python %}}

```diff
-
+
```

{{% /choosable %}}

{{% choosable language go %}}

```diff
-
+
```

{{% /choosable %}}

{{% choosable language csharp %}}

```diff
-
+
```

{{% /choosable %}}

{{% choosable language java %}}

```diff
-
+
```

{{% /choosable %}}

{{% choosable language yaml %}}

```diff
-
+
```

{{% /choosable %}}

{{< /chooser >}}

## Unused Quicksight Types

Unused types from the `quicksight` module have been [removed](https://github.com/pulumi/pulumi-aws/pull/2609/commits/7a72e505fc7b5729f2ea1ec231e52fa614332744). Consumers of removed types can continue to reference the v5 types or move the
type definition into their own program.

{{< chooser language "typescript,python,go,csharp,java,yaml" >}}

{{% chooseable language typescript }}

```diff
- 
+
```

{{% /chooseable %}}

{{% choosable language python %}}

```diff
- 
+ 
```

{{% /choosable %}}

{{% choosable language go %}}

```diff
- 
+ 
```

{{% /choosable %}}

{{% choosable language csharp %}}

```diff
- 
+ 
```

{{% /choosable %}}

{{% choosable language java %}}

```diff
- 
+ 
```

{{% /choosable %}}

{{% choosable language yaml %}}

```diff
- 
+ 
```

{{% /choosable %}}

{{< /chooser >}}

## Property Name Change

The name of property `aws:organizations/getOrganizationalUnits:getOrganizationalUnits` has changed from `childrens` to `children` and the name of the associated type from `children` to `child`. See https://github.com/pulumi/pulumi-aws/pull/2634 for details.

## Function Signature Change

For three functions, the signature has changed to accommodate a new argument. The new argument is optional, so passing an empty argument block is sufficient. Any reference to these three functions will need to be updated. The three impacted functions are:

- `aws:index/getBillingServiceAccount:getBillingServiceAccount`
- `aws:index/getCallerIdentity:getCallerIdentity`
- `aws:index/getPartition:getPartition`

```diff
-`(pulumi.InvokeOptions) -> T`
+ `(Args, pulumi.InvokeOptions) -> T`
```
