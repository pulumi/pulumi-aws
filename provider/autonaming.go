package provider

import (
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
)

const nameProperty = "name"

// prov.SetAutonaming is too inefficient for AWS as it forces SchemaFunc calls for large resources
// that use up RAM. Instead of doing prov.SetAutonaming(255, "-") we call a surgically crafted
// setAutonaming that avoids these calls.
func setAutonaming(p *tfbridge.ProviderInfo, resourceMetadata awsResourceMetadataLookup) {
	maxLength := 255
	separator := "-"
	for resname, res := range p.Resources {
		var schemaResource shim.Resource
		if p.P != nil {
			schemaResource = p.P.ResourcesMap().Get(resname)
		}
		// Only apply auto-name to input properties (Optional || Required) named `name`
		if !resourceMetadata(p.P, resname, schemaResource).HasInputName {
			continue
		}
		if _, hasfield := res.Fields[nameProperty]; !hasfield {
			if res.Fields == nil {
				res.Fields = make(map[string]*tfbridge.SchemaInfo)
			}
			res.Fields[nameProperty] = tfbridge.AutoName(nameProperty, maxLength, separator)
		}
	}
}

func hasOptionalOrRequiredNameProperty(p shim.Provider, tfResourceName string) bool {
	if schema := p.ResourcesMap().Get(tfResourceName); schema != nil {
		// Only apply auto-name to input properties (Optional || Required) named `name`
		if sch := schema.Schema().Get(nameProperty); sch != nil && (sch.Optional() || sch.Required()) {
			return true
		}
	}
	return false
}

func hasNonComputedTagsAndTagsAll(_ string, res shim.Resource) bool {
	// Skip resources that don't have tags.
	tagsF, ok := res.Schema().GetOk("tags")
	if !ok {
		return false
	}
	// Skip resources that don't have tags_all.
	_, ok = res.Schema().GetOk("tags_all")
	if !ok {
		return false
	}
	// tags must be non-computed.
	if tagsF.Computed() && !tagsF.Optional() {
		return false
	}
	return true
}
