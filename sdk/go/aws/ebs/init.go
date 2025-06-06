// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package ebs

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
	case "aws:ebs/defaultKmsKey:DefaultKmsKey":
		r = &DefaultKmsKey{}
	case "aws:ebs/encryptionByDefault:EncryptionByDefault":
		r = &EncryptionByDefault{}
	case "aws:ebs/fastSnapshotRestore:FastSnapshotRestore":
		r = &FastSnapshotRestore{}
	case "aws:ebs/snapshot:Snapshot":
		r = &Snapshot{}
	case "aws:ebs/snapshotBlockPublicAccess:SnapshotBlockPublicAccess":
		r = &SnapshotBlockPublicAccess{}
	case "aws:ebs/snapshotCopy:SnapshotCopy":
		r = &SnapshotCopy{}
	case "aws:ebs/snapshotImport:SnapshotImport":
		r = &SnapshotImport{}
	case "aws:ebs/volume:Volume":
		r = &Volume{}
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
		"ebs/defaultKmsKey",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ebs/encryptionByDefault",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ebs/fastSnapshotRestore",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ebs/snapshot",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ebs/snapshotBlockPublicAccess",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ebs/snapshotCopy",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ebs/snapshotImport",
		&module{version},
	)
	pulumi.RegisterResourceModule(
		"aws",
		"ebs/volume",
		&module{version},
	)
}
