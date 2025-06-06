// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package shield

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
	case "aws:shield/applicationLayerAutomaticResponse:ApplicationLayerAutomaticResponse":
		r = &ApplicationLayerAutomaticResponse{}
	case "aws:shield/drtAccessLogBucketAssociation:DrtAccessLogBucketAssociation":
		r = &DrtAccessLogBucketAssociation{}
	case "aws:shield/drtAccessRoleArnAssociation:DrtAccessRoleArnAssociation":
		r = &DrtAccessRoleArnAssociation{}
	case "aws:shield/proactiveEngagement:ProactiveEngagement":
		r = &ProactiveEngagement{}
	case "aws:shield/protection:Protection":
		r = &Protection{}
	case "aws:shield/protectionGroup:ProtectionGroup":
		r = &ProtectionGroup{}
	case "aws:shield/protectionHealthCheckAssociation:ProtectionHealthCheckAssociation":
		r = &ProtectionHealthCheckAssociation{}
	case "aws:shield/subscription:Subscription":
		r = &Subscription{}
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
		"shield/applicationLayerAutomaticResponse",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"shield/drtAccessLogBucketAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"shield/drtAccessRoleArnAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"shield/proactiveEngagement",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"shield/protection",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"shield/protectionGroup",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"shield/protectionHealthCheckAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"shield/subscription",
		&module{version},
	)
}
