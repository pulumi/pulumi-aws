// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package secretsmanager

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
	case "aws:secretsmanager/secret:Secret":
		r = &Secret{}
	case "aws:secretsmanager/secretPolicy:SecretPolicy":
		r = &SecretPolicy{}
	case "aws:secretsmanager/secretRotation:SecretRotation":
		r = &SecretRotation{}
	case "aws:secretsmanager/secretVersion:SecretVersion":
		r = &SecretVersion{}
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
		"secretsmanager/secret",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"secretsmanager/secretPolicy",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"secretsmanager/secretRotation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"secretsmanager/secretVersion",
		&module{version},
	)
}
