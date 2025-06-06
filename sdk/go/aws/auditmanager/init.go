// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package auditmanager

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
	case "aws:auditmanager/accountRegistration:AccountRegistration":
		r = &AccountRegistration{}
	case "aws:auditmanager/assessment:Assessment":
		r = &Assessment{}
	case "aws:auditmanager/assessmentDelegation:AssessmentDelegation":
		r = &AssessmentDelegation{}
	case "aws:auditmanager/assessmentReport:AssessmentReport":
		r = &AssessmentReport{}
	case "aws:auditmanager/control:Control":
		r = &Control{}
	case "aws:auditmanager/framework:Framework":
		r = &Framework{}
	case "aws:auditmanager/frameworkShare:FrameworkShare":
		r = &FrameworkShare{}
	case "aws:auditmanager/organizationAdminAccountRegistration:OrganizationAdminAccountRegistration":
		r = &OrganizationAdminAccountRegistration{}
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
		"auditmanager/accountRegistration",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"auditmanager/assessment",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"auditmanager/assessmentDelegation",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"auditmanager/assessmentReport",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"auditmanager/control",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"auditmanager/framework",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"auditmanager/frameworkShare",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"auditmanager/organizationAdminAccountRegistration",
		&module{version},
	)
}
