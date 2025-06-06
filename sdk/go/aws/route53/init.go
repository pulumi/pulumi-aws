// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package route53

import (
	"fmt"

	"github.com/blang/semver"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

type module struct {
	version semver.Version
}

func (m *module) Version() semver.Version {
	return m.version
}

func (m *module) Construct(ctx *pulumi.Context, name, typ, urn string) (r pulumi.Resource, err error) {
	switch typ {
	case "aws:route53/cidrCollection:CidrCollection":
		r = &CidrCollection{}
	case "aws:route53/cidrLocation:CidrLocation":
		r = &CidrLocation{}
	case "aws:route53/delegationSet:DelegationSet":
		r = &DelegationSet{}
	case "aws:route53/healthCheck:HealthCheck":
		r = &HealthCheck{}
	case "aws:route53/hostedZoneDnsSec:HostedZoneDnsSec":
		r = &HostedZoneDnsSec{}
	case "aws:route53/keySigningKey:KeySigningKey":
		r = &KeySigningKey{}
	case "aws:route53/profilesAssociation:ProfilesAssociation":
		r = &ProfilesAssociation{}
	case "aws:route53/profilesProfile:ProfilesProfile":
		r = &ProfilesProfile{}
	case "aws:route53/profilesResourceAssociation:ProfilesResourceAssociation":
		r = &ProfilesResourceAssociation{}
	case "aws:route53/queryLog:QueryLog":
		r = &QueryLog{}
	case "aws:route53/record:Record":
		r = &Record{}
	case "aws:route53/recordsExclusive:RecordsExclusive":
		r = &RecordsExclusive{}
	case "aws:route53/resolverConfig:ResolverConfig":
		r = &ResolverConfig{}
	case "aws:route53/resolverDnsSecConfig:ResolverDnsSecConfig":
		r = &ResolverDnsSecConfig{}
	case "aws:route53/resolverEndpoint:ResolverEndpoint":
		r = &ResolverEndpoint{}
	case "aws:route53/resolverFirewallConfig:ResolverFirewallConfig":
		r = &ResolverFirewallConfig{}
	case "aws:route53/resolverFirewallDomainList:ResolverFirewallDomainList":
		r = &ResolverFirewallDomainList{}
	case "aws:route53/resolverFirewallRule:ResolverFirewallRule":
		r = &ResolverFirewallRule{}
	case "aws:route53/resolverFirewallRuleGroup:ResolverFirewallRuleGroup":
		r = &ResolverFirewallRuleGroup{}
	case "aws:route53/resolverFirewallRuleGroupAssociation:ResolverFirewallRuleGroupAssociation":
		r = &ResolverFirewallRuleGroupAssociation{}
	case "aws:route53/resolverQueryLogConfig:ResolverQueryLogConfig":
		r = &ResolverQueryLogConfig{}
	case "aws:route53/resolverQueryLogConfigAssociation:ResolverQueryLogConfigAssociation":
		r = &ResolverQueryLogConfigAssociation{}
	case "aws:route53/resolverRule:ResolverRule":
		r = &ResolverRule{}
	case "aws:route53/resolverRuleAssociation:ResolverRuleAssociation":
		r = &ResolverRuleAssociation{}
	case "aws:route53/trafficPolicy:TrafficPolicy":
		r = &TrafficPolicy{}
	case "aws:route53/trafficPolicyInstance:TrafficPolicyInstance":
		r = &TrafficPolicyInstance{}
	case "aws:route53/vpcAssociationAuthorization:VpcAssociationAuthorization":
		r = &VpcAssociationAuthorization{}
	case "aws:route53/zone:Zone":
		r = &Zone{}
	case "aws:route53/zoneAssociation:ZoneAssociation":
		r = &ZoneAssociation{}
	default:
		return nil, fmt.Errorf("unknown resource type: %s", typ)
	}

	err = ctx.RegisterResource(typ, name, nil, r, pulumi.URN_(urn))
	return
}

func init() {
	version, err := internal.PkgVersion()
	if err != nil {
		version = semver.Version{Major: 1}
	}
	pulumi.RegisterResourceModule(
		"aws",
		"route53/cidrCollection",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/cidrLocation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/delegationSet",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/healthCheck",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/hostedZoneDnsSec",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/keySigningKey",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/profilesAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/profilesProfile",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/profilesResourceAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/queryLog",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/record",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/recordsExclusive",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverConfig",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverDnsSecConfig",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverEndpoint",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverFirewallConfig",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverFirewallDomainList",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverFirewallRule",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverFirewallRuleGroup",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverFirewallRuleGroupAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverQueryLogConfig",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverQueryLogConfigAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverRule",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/resolverRuleAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/trafficPolicy",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/trafficPolicyInstance",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/vpcAssociationAuthorization",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/zone",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"route53/zoneAssociation",
		&module{version},
	)
}
