// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package apprunner

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
	case "aws:apprunner/autoScalingConfigurationVersion:AutoScalingConfigurationVersion":
		r = &AutoScalingConfigurationVersion{}
	case "aws:apprunner/connection:Connection":
		r = &Connection{}
	case "aws:apprunner/customDomainAssociation:CustomDomainAssociation":
		r = &CustomDomainAssociation{}
	case "aws:apprunner/defaultAutoScalingConfigurationVersion:DefaultAutoScalingConfigurationVersion":
		r = &DefaultAutoScalingConfigurationVersion{}
	case "aws:apprunner/deployment:Deployment":
		r = &Deployment{}
	case "aws:apprunner/observabilityConfiguration:ObservabilityConfiguration":
		r = &ObservabilityConfiguration{}
	case "aws:apprunner/service:Service":
		r = &Service{}
	case "aws:apprunner/vpcConnector:VpcConnector":
		r = &VpcConnector{}
	case "aws:apprunner/vpcIngressConnection:VpcIngressConnection":
		r = &VpcIngressConnection{}
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
		"apprunner/autoScalingConfigurationVersion",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"apprunner/connection",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"apprunner/customDomainAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"apprunner/defaultAutoScalingConfigurationVersion",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"apprunner/deployment",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"apprunner/observabilityConfiguration",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"apprunner/service",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"apprunner/vpcConnector",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"apprunner/vpcIngressConnection",
		&module{version},
	)
}
