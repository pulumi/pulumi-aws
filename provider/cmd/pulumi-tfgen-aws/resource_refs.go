package main

import (
	"strings"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

func replaceResourceRefs(spec *schema.PackageSpec) {
	resourcesWithRefs := []string{
		"aws:apigateway/authorizer:Authorizer",
		"aws:apigateway/basePathMapping:BasePathMapping",
		"aws:apigateway/deployment:Deployment",
		"aws:apigateway/integration:Integration",
		"aws:apigateway/method:Method",
		"aws:apigateway/methodResponse:MethodResponse",
		"aws:apigateway/methodSettings:MethodSettings",
		"aws:apigateway/model:Model",
		"aws:apigateway/requestValidator:RequestValidator",
		"aws:apigateway/resource:Resource",
		"aws:apigateway/stage:Stage",
		"aws:apigateway/integrationResponse:IntegrationResponse",
		"aws:autoscaling/group:Group",
		"aws:cloudwatch/logSubscriptionFilter:LogSubscriptionFilter",
		"aws:cloudwatch/metricAlarm:MetricAlarm",
		"aws:elasticbeanstalk/applicationVersion:ApplicationVersion",
		"aws:elasticbeanstalk/environment:Environment",
		"aws:ec2/instance:Instance",
		"aws:ec2/launchConfiguration:LaunchConfiguration",
		"aws:iam/groupPolicyAttachment:GroupPolicyAttachment",
		"aws:iam/userPolicyAttachment:UserPolicyAttachment",
		"aws:iam/instanceProfile:InstanceProfile",
		"aws:iam/policyAttachment:PolicyAttachment",
		"aws:iam/rolePolicyAttachment:RolePolicyAttachment",
		"aws:iam/rolePolicy:RolePolicy",
		"aws:iot/policyAttachment:PolicyAttachment",
		"aws:lambda/permission:Permission",
		"aws:s3/bucketObject:BucketObject",
		"aws:s3/bucketObjectv2:BucketObjectv2",
		"aws:sns/topicSubscription:TopicSubscription",
	}

	processOneOf := func(oneOf []schema.TypeSpec) []schema.TypeSpec {
		for i, one := range oneOf {
			if strings.HasPrefix(one.Ref, "#/types/aws:") {
				ref := one.Ref
				replacement := strings.Replace(ref, "#/types", "#/resources", 1)
				// Extract just the resource type name for checking
				resourceType := strings.TrimPrefix(replacement, "#/resources/")
				if _, ok := spec.Resources[resourceType]; ok {
					oneOf[i].Ref = replacement
				}
			}
		}
		return oneOf

	}

	processPropertySpec := func(propSpec map[string]schema.PropertySpec) {
		for key, prop := range propSpec {
			if prop.Type == "string" && len(prop.OneOf) == 2 {
				prop.OneOf = processOneOf(prop.OneOf)
			}
			if prop.Items != nil {
				if prop.Items.Type == "string" && len(prop.Items.OneOf) == 2 {
					prop.Items.OneOf = processOneOf(prop.Items.OneOf)
				}
			}
			propSpec[key] = prop
		}
	}

	for _, res := range resourcesWithRefs {
		resource, ok := spec.Resources[res]
		contract.Assertf(ok, "no resource: %s", res)
		processPropertySpec(resource.InputProperties)
		processPropertySpec(resource.StateInputs.Properties)
	}
}
