// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package memorydb

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
	case "aws:memorydb/acl:Acl":
		r = &Acl{}
	case "aws:memorydb/cluster:Cluster":
		r = &Cluster{}
	case "aws:memorydb/multiRegionCluster:MultiRegionCluster":
		r = &MultiRegionCluster{}
	case "aws:memorydb/parameterGroup:ParameterGroup":
		r = &ParameterGroup{}
	case "aws:memorydb/snapshot:Snapshot":
		r = &Snapshot{}
	case "aws:memorydb/subnetGroup:SubnetGroup":
		r = &SubnetGroup{}
	case "aws:memorydb/user:User":
		r = &User{}
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
		"memorydb/acl",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"memorydb/cluster",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"memorydb/multiRegionCluster",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"memorydb/parameterGroup",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"memorydb/snapshot",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"memorydb/subnetGroup",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"memorydb/user",
		&module{version},
	)
}
