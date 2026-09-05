package provider

import (
	"testing"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/info"
	tks "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/tokens"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestPricingPlanManagerSubscriptionToken(t *testing.T) {
	t.Parallel()

	strategy := tks.MappedModules("aws_", "", moduleMap, func(mod, name string) (string, error) {
		return awsResource(mod, name).String(), nil
	})
	resource := info.Resource{}

	require.NoError(t, strategy.Resource("aws_pricingplanmanager_subscription", &resource))
	assert.Equal(t, "aws:pricingplanmanager/subscription:Subscription", resource.Tok.String())
}
