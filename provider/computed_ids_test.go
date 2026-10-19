package provider

import (
	"context"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"

	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
)

func TestComputedIDsUseSchemaAttributes(t *testing.T) {
	t.Parallel()

	p := Provider()

	tests := []struct {
		resource string
		state    resource.PropertyMap
		expected resource.ID
	}{
		{
			resource: "aws_vpc_route_server_propagation",
			state: resource.PropertyMap{
				"routeServerId": resource.NewStringProperty("rs-123"),
				"routeTableId":  resource.NewStringProperty("rtb-456"),
			},
			expected: "rs-123,rtb-456",
		},
		{
			resource: "aws_connect_phone_number_contact_flow_association",
			state: resource.PropertyMap{
				"phoneNumberId": resource.NewStringProperty("phone"),
				"instanceId":    resource.NewStringProperty("instance"),
				"contactFlowId": resource.NewStringProperty("flow"),
			},
			expected: "phone__instance__flow",
		},
		{
			resource: "aws_lakeformation_opt_in",
			state: resource.PropertyMap{
				"principals": resource.NewArrayProperty([]resource.PropertyValue{
					resource.NewObjectProperty(resource.PropertyMap{
						"dataLakePrincipalIdentifier": resource.NewStringProperty("principal-arn"),
					}),
				}),
			},
			expected: "principal-arn",
		},
		{
			resource: "aws_cloudwatch_contributor_insight_rule",
			state: resource.PropertyMap{
				"ruleName": resource.NewStringProperty("my-rule"),
			},
			expected: "my-rule",
		},
		{
			resource: "aws_ssmquicksetup_configuration_manager",
			state: resource.PropertyMap{
				"name":       resource.NewStringProperty("example"),
				"managerArn": resource.NewStringProperty("manager-arn"),
			},
			expected: "manager-arn",
		},
		{
			resource: "aws_wafv2_web_acl_rule_group_association",
			state: resource.PropertyMap{
				"webAclArn": resource.NewStringProperty("acl-arn"),
				"ruleName":  resource.NewStringProperty("rule"),
				"ruleGroupReference": resource.NewObjectProperty(resource.PropertyMap{
					"arn": resource.NewStringProperty("rule-group-arn"),
				}),
			},
			expected: "acl-arn,rule-group-arn,rule",
		},
	}

	for _, tt := range tests {
		t.Run(tt.resource, func(t *testing.T) {
			t.Parallel()

			info, ok := p.Resources[tt.resource]
			require.True(t, ok)
			require.NotNil(t, info.ComputeID)

			id, err := info.ComputeID(context.Background(), tt.state)
			require.NoError(t, err)
			assert.Equal(t, tt.expected, id)
		})
	}
}
