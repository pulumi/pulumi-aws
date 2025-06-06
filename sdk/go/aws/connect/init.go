// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package connect

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
	case "aws:connect/botAssociation:BotAssociation":
		r = &BotAssociation{}
	case "aws:connect/contactFlow:ContactFlow":
		r = &ContactFlow{}
	case "aws:connect/contactFlowModule:ContactFlowModule":
		r = &ContactFlowModule{}
	case "aws:connect/hoursOfOperation:HoursOfOperation":
		r = &HoursOfOperation{}
	case "aws:connect/instance:Instance":
		r = &Instance{}
	case "aws:connect/instanceStorageConfig:InstanceStorageConfig":
		r = &InstanceStorageConfig{}
	case "aws:connect/lambdaFunctionAssociation:LambdaFunctionAssociation":
		r = &LambdaFunctionAssociation{}
	case "aws:connect/phoneNumber:PhoneNumber":
		r = &PhoneNumber{}
	case "aws:connect/queue:Queue":
		r = &Queue{}
	case "aws:connect/quickConnect:QuickConnect":
		r = &QuickConnect{}
	case "aws:connect/routingProfile:RoutingProfile":
		r = &RoutingProfile{}
	case "aws:connect/securityProfile:SecurityProfile":
		r = &SecurityProfile{}
	case "aws:connect/user:User":
		r = &User{}
	case "aws:connect/userHierarchyGroup:UserHierarchyGroup":
		r = &UserHierarchyGroup{}
	case "aws:connect/userHierarchyStructure:UserHierarchyStructure":
		r = &UserHierarchyStructure{}
	case "aws:connect/vocabulary:Vocabulary":
		r = &Vocabulary{}
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
		"connect/botAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/contactFlow",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/contactFlowModule",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/hoursOfOperation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/instance",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/instanceStorageConfig",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/lambdaFunctionAssociation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/phoneNumber",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/queue",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/quickConnect",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/routingProfile",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/securityProfile",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/user",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/userHierarchyGroup",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/userHierarchyStructure",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"connect/vocabulary",
		&module{version},
	)
}
