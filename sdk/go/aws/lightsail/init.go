// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package lightsail

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
	case "aws:lightsail/bucket:Bucket":
		r = &Bucket{}
	case "aws:lightsail/bucketAccessKey:BucketAccessKey":
		r = &BucketAccessKey{}
	case "aws:lightsail/bucketResourceAccess:BucketResourceAccess":
		r = &BucketResourceAccess{}
	case "aws:lightsail/certificate:Certificate":
		r = &Certificate{}
	case "aws:lightsail/containerService:ContainerService":
		r = &ContainerService{}
	case "aws:lightsail/containerServiceDeploymentVersion:ContainerServiceDeploymentVersion":
		r = &ContainerServiceDeploymentVersion{}
	case "aws:lightsail/database:Database":
		r = &Database{}
	case "aws:lightsail/disk:Disk":
		r = &Disk{}
	case "aws:lightsail/disk_attachment:Disk_attachment":
		r = &Disk_attachment{}
	case "aws:lightsail/distribution:Distribution":
		r = &Distribution{}
	case "aws:lightsail/domain:Domain":
		r = &Domain{}
	case "aws:lightsail/domainEntry:DomainEntry":
		r = &DomainEntry{}
	case "aws:lightsail/instance:Instance":
		r = &Instance{}
	case "aws:lightsail/instancePublicPorts:InstancePublicPorts":
		r = &InstancePublicPorts{}
	case "aws:lightsail/keyPair:KeyPair":
		r = &KeyPair{}
	case "aws:lightsail/lb:Lb":
		r = &Lb{}
	case "aws:lightsail/lbAttachment:LbAttachment":
		r = &LbAttachment{}
	case "aws:lightsail/lbCertificate:LbCertificate":
		r = &LbCertificate{}
	case "aws:lightsail/lbCertificateAttachment:LbCertificateAttachment":
		r = &LbCertificateAttachment{}
	case "aws:lightsail/lbHttpsRedirectionPolicy:LbHttpsRedirectionPolicy":
		r = &LbHttpsRedirectionPolicy{}
	case "aws:lightsail/lbStickinessPolicy:LbStickinessPolicy":
		r = &LbStickinessPolicy{}
	case "aws:lightsail/staticIp:StaticIp":
		r = &StaticIp{}
	case "aws:lightsail/staticIpAttachment:StaticIpAttachment":
		r = &StaticIpAttachment{}
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
		"lightsail/bucket",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/bucketAccessKey",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/bucketResourceAccess",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/certificate",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/containerService",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/containerServiceDeploymentVersion",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/database",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/disk",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/disk_attachment",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/distribution",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/domain",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/domainEntry",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/instance",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/instancePublicPorts",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/keyPair",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/lb",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/lbAttachment",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/lbCertificate",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/lbCertificateAttachment",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/lbHttpsRedirectionPolicy",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/lbStickinessPolicy",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/staticIp",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"lightsail/staticIpAttachment",
		&module{version},
	)
}
