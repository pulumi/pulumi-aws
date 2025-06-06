// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ec2clientvpn

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
	case "aws:ec2clientvpn/authorizationRule:AuthorizationRule":
		r = &AuthorizationRule{}
	case "aws:ec2clientvpn/endpoint:Endpoint":
		r = &Endpoint{}
	case "aws:ec2clientvpn/networkAssociation:NetworkAssociation":
		r = &NetworkAssociation{}
	case "aws:ec2clientvpn/route:Route":
		r = &Route{}
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
		"ec2clientvpn/authorizationRule",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ec2clientvpn/endpoint",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ec2clientvpn/networkAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ec2clientvpn/route",
		&module{version},
	)
}
