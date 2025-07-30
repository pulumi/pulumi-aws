package provider

import (
	"context"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
)

// This adds special handling for the `region` property
// Upstream uses "interceptors" to set the region property on all resources. This currently
// doesn't work with the way the bridge/pulumi works. The interceptor will add the region after
// Pulumi runs `Check` which causes issues. This workaround sets the `region` the same way upstream will
// but does it on the pulumi side before `Check`
// TODO[pulumi/pulumi-aws#5521]
func applyRegionPreCheckCallback(
	prov tfbridge.ProviderInfo,
	key string,
	res shim.Resource,
) {
	// global resources have a separate region argument (e.g. `stack_set_instance_region`)
	// and have deprecated the `region` argument if they had one
	if region, ok := res.Schema().GetOk("region"); !ok || region.Deprecated() != "" {
		return
	}
	if callback := prov.Resources[key].PreCheckCallback; callback != nil {
		prov.Resources[key].PreCheckCallback = func(
			ctx context.Context, config resource.PropertyMap, meta resource.PropertyMap,
		) (resource.PropertyMap, error) {
			config, err := callback(ctx, config, meta)
			if err != nil {
				return nil, err
			}
			return applyRegion(ctx, config, meta)
		}
	} else {
		prov.Resources[key].PreCheckCallback = applyRegion
	}
}

// applyRegion sets the region property on the resource if it is not already set.
// It first checks if the region is set in the resource inputs (config) and then checks the region from
// the provider config (meta)
// This matches the behavior of the upstream AWS provider which sets the region in the interceptor
func applyRegion(ctx context.Context, config resource.PropertyMap, meta resource.PropertyMap) (resource.PropertyMap, error) {
	ret := config.Copy()
	if t, ok := config["region"]; ok && !t.IsNull() {
		ret["region"] = t
		return ret, nil
	}

	if region, ok := meta["region"]; ok && !region.IsNull() {
		ret["region"] = region
		return ret, nil
	}
	return ret, nil
}
