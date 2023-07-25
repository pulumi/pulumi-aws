# Migrating from v5 to v6

### Upstream Changes
We have moved the upstream target from [v4.67.0](https://github.com/pulumi/pulumi-aws/pull/2521) to targeting v5.8.0. That means that the upstream [migration guide](https://registry.terraform.io/providers/hashicorp/aws/latest/docs/guides/version-5-upgrade) as well as the following `CHANGELOG`s are relevant: 
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

### Removing depreciated resources
We had previously renamed the following resources. We have removed the old names from
v6. Any reference to the old name will need to switch to the new name. That is the only
change required.

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

### Removing depreciated functions
We had previously renamed the following resources. We have removed the old names from
v6. Any reference to the old name will need to switch to the new name. That is the only
change required.

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

### aws.sdk [typescript]
We have [removed the aws.sdk](https://github.com/pulumi/pulumi-aws/pull/2584)
property. You may still access the underlying functionality by directly importing the AWS
TS sdk. See https://github.com/pulumi/pulumi-aws/pull/2584 for more details.

### WafV2

The `wafv2` module has two problematic resources with massive schemas. Because Terraform can't represent recursive schema types, they
[brute-force generated](https://github.com/hashicorp/terraform-provider-aws/blob/5c5ab41aad82960be2dc8f0ed201098e260cd07a/internal/service/wafv2/schemas.go#L45.) 
approximations of recursive types a few layers down. This lead to massive SDK sizes on for Pulumi. However, Pulumi
does support recursive types. We now define these `wafv2` types recursively. If you were using any of the
"RuleGroupRuleStatement" or "WebAclRuleStatement" properties on a wafv2 resource, you will need to refactor to
use the new recursive types in the `wafv2` module.

### Unused Quicksight Types

We have [removed](https://github.com/pulumi/pulumi-aws/pull/2609/commits/7a72e505fc7b5729f2ea1ec231e52fa614332744) some
unused types from the `quicksight` module. Consumers of removed types can continue to reference the v5 types or move the
type definition into their own program.

### Miscellaneous changes
- `aws:organizations/getOrganizationalUnits:getOrganizationalUnits`: We have changed the
  name of property `childrens` to `children` and the name of the associated type from
  `children` to `child.  See https://github.com/pulumi/pulumi-aws/pull/2634 for details.
- We have changed the function signature for 3 generated Functions. For each function, the
  signature has changed from `(pulumi.InvokeOptions) -> T` to `(Args,
  pulumi.InvokeOptions) -> T`. Where each function is called, you will need to change the
  call site to accommodate the new argument. The new argument is optional, so passing an
  empty argument block is sufficient. These are the effected functions:
  - "aws:index/getBillingServiceAccount:getBillingServiceAccount"
  - "aws:index/getCallerIdentity:getCallerIdentity"
  - "aws:index/getPartition:getPartition"
