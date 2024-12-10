package batch

import (
	"context"
	"testing"

	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/stretchr/testify/require"
)

func TestComputeEnvironmentTransformFromState(t *testing.T) {
	ctx := context.Background()
	pm := resource.PropertyMap{
		"computeResources": resource.NewObjectProperty(resource.PropertyMap{
			"ec2Configuration": resource.NewObjectProperty(resource.PropertyMap{
				"imageIdOverride": resource.NewStringProperty(""),
				"imageType":       resource.NewStringProperty("ECS_AL2"),
			}),
		}),
	}
	expect := resource.PropertyMap{
		"computeResources": resource.NewObjectProperty(resource.PropertyMap{
			"ec2Configuration": resource.NewArrayProperty([]resource.PropertyValue{
				resource.NewObjectProperty(resource.PropertyMap{
					"imageIdOverride": resource.NewStringProperty(""),
					"imageType":       resource.NewStringProperty("ECS_AL2"),
				}),
			}),
		}),
	}
	actual, err := ComputeEnvironment("").TransformFromState(ctx, pm)
	require.NoError(t, err)
	require.Equal(t, expect, actual)
}
