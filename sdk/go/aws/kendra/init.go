// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package kendra

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
	case "aws:kendra/dataSource:DataSource":
		r = &DataSource{}
	case "aws:kendra/experience:Experience":
		r = &Experience{}
	case "aws:kendra/faq:Faq":
		r = &Faq{}
	case "aws:kendra/index:Index":
		r = &Index{}
	case "aws:kendra/querySuggestionsBlockList:QuerySuggestionsBlockList":
		r = &QuerySuggestionsBlockList{}
	case "aws:kendra/thesaurus:Thesaurus":
		r = &Thesaurus{}
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
		"kendra/dataSource",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"kendra/experience",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"kendra/faq",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"kendra/index",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"kendra/querySuggestionsBlockList",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"kendra/thesaurus",
		&module{version},
	)
}
