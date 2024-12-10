package batch

import (
	"context"
	"testing"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge/log"
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
	actual, err := ComputeEnvironment("", func(ctx context.Context) tfbridge.Logger {
		return testLogger{t}
	}).TransformFromState(ctx, pm)
	require.NoError(t, err)
	require.Equal(t, expect, actual)
}

type testLogger struct {
	t *testing.T
}

func (l testLogger) Debug(msg string) {
	l.t.Log(msg)
}
func (l testLogger) Info(msg string) {
	l.t.Log(msg)
}
func (l testLogger) Warn(msg string) {
	l.t.Log(msg)
}
func (l testLogger) Error(msg string) {
	l.t.Log(msg)
}
func (l testLogger) Status() log.Log {
	return l
}
