// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ssmcontacts

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
	case "aws:ssmcontacts/contact:Contact":
		r = &Contact{}
	case "aws:ssmcontacts/contactChannel:ContactChannel":
		r = &ContactChannel{}
	case "aws:ssmcontacts/plan:Plan":
		r = &Plan{}
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
		"ssmcontacts/contact",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ssmcontacts/contactChannel",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ssmcontacts/plan",
		&module{version},
	)
}
