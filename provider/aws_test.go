package provider

import (
	// 	"fmt"
	"testing"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestRepro(t *testing.T) {
	provider := Provider()
	res := provider.P.ResourcesMap().Get("aws_eks_cluster")
	inputs, meta, err := tfbridge.MakeTerraformStateInner(tfbridge.Resource{
		TF:     res,
		Schema: provider.Resources["aws_eks_cluster"],
		TFName: "aws_eks_cluster",
	}, resource.PropertyMap{
		"__meta": resource.PropertyValue{
			V: "{\"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0\":{\"create\":1800000000000,\"delete\":900000000000,\"update\":3600000000000}}",
		},
		"arn": resource.PropertyValue{
			V: "arn:aws:eks:us-west-2:616138583583:cluster/my-cluster",
		}, "certificateAuthorities": resource.PropertyValue{V: []resource.PropertyValue{{V: resource.PropertyMap{"data": resource.PropertyValue{V: "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM1ekNDQWMrZ0F3SUJBZ0lCQURBTkJna3Foa2lHOXcwQkFRc0ZBREFWTVJNd0VRWURWUVFERXdwcmRXSmwKY201bGRHVnpNQjRYRFRJek1ERXpNREUzTlRFMU5Wb1hEVE16TURFeU56RTNOVEUxTlZvd0ZURVRNQkVHQTFVRQpBeE1LYTNWaVpYSnVaWFJsY3pDQ0FTSXdEUVlKS29aSWh2Y05BUUVCQlFBRGdnRVBBRENDQVFvQ2dnRUJBUHc3Ck5Xa1JubWw2Y080clRSektPTCtIQ1p6WVJWMHZjQ0ZxZnRUdmozTGl4bEtiUnJkQVhkbDBNNFFCdTIwek5sd0gKcXRnWEgwT3hjeGlYR1N3RXUzVTk5dmpWVDVsazViWjlURUUrQXFSZDVlRnhJY2ozbHZRellGbHpRMWxTRUtROAp3YTlWbFU5bDFzY0ZjNEtkVEtFQ1hyL0VRVU5GMHVzTm50K0xYZERNUCtON1RoZG5TSFdxVEtvN0tDKzNRRVN1CmNIeUZDdFlFWitmZC9BaHFrcnpJMUNXQWxXMDBWdkRPRkhMY1FUQTFRUTFzazV6akkxSFB5NjJmLzZaQWxmUkgKc0VzNDNlNmwrWkVQUmRURFU3bzVaOGNzRnNBK3ZrZnJqVVVYcjBXN3Myamt6V2RVRk95WkRjMmEwLzJ3M0U2UApRVGNWZVNyMHkvMllISnpSL0VVQ0F3RUFBYU5DTUVBd0RnWURWUjBQQVFIL0JBUURBZ0trTUE4R0ExVWRFd0VCCi93UUZNQU1CQWY4d0hRWURWUjBPQkJZRUZEcDJXT05GMUtwRStFeXA3UUx5SWFLUzV0ekVNQTBHQ1NxR1NJYjMKRFFFQkN3VUFBNElCQVFDVnhna2pocG5tdGx4M01hREw1Y1pMN1YyNmdoYXc3MFJWOUQrUWl6c1NreGhrZzFVZwp2Q1J2THZWaE9aNTBHdWFSL3g5WDQwQTFQbHlId3NTVlpyWmlRL2pTL2k4THJsampIbkpzSHJwZUw1TUk5d2hqClNER2tiVVJ4M3NNL2s2UjcxajRQVkxMbEdYbC9Lb21vQ0ZhWDRxNWdURTBYV0VQcHZaUy9RSWNWNEJUaS9PNngKOVNkbWhQNTFhbHJsRWJTZE1iWENnbGV4WWV5aUlGdzVvTEZxRkNuTWNOMmhPeTRKTmRDYmFRWlV5NVAyWERzTQp3YlA2MWxURjBtY1hrb3JSeGNpRHd5ekxnQnVHYWdJbTBDbEI2alExZ29sblQ2dEZqWGZuUWFRZnA2ZUg3SzJsCkFFU1BOZnVjUjJyYVhuUXJoMWN3YUVlVXBkNGZOaDZSNVpUcQotLS0tLUVORCBDRVJUSUZJQ0FURS0tLS0tCg=="}}}}}, "certificateAuthority": resource.PropertyValue{V: resource.PropertyMap{"data": resource.PropertyValue{V: "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM1ekNDQWMrZ0F3SUJBZ0lCQURBTkJna3Foa2lHOXcwQkFRc0ZBREFWTVJNd0VRWURWUVFERXdwcmRXSmwKY201bGRHVnpNQjRYRFRJek1ERXpNREUzTlRFMU5Wb1hEVE16TURFeU56RTNOVEUxTlZvd0ZURVRNQkVHQTFVRQpBeE1LYTNWaVpYSnVaWFJsY3pDQ0FTSXdEUVlKS29aSWh2Y05BUUVCQlFBRGdnRVBBRENDQVFvQ2dnRUJBUHc3Ck5Xa1JubWw2Y080clRSektPTCtIQ1p6WVJWMHZjQ0ZxZnRUdmozTGl4bEtiUnJkQVhkbDBNNFFCdTIwek5sd0gKcXRnWEgwT3hjeGlYR1N3RXUzVTk5dmpWVDVsazViWjlURUUrQXFSZDVlRnhJY2ozbHZRellGbHpRMWxTRUtROAp3YTlWbFU5bDFzY0ZjNEtkVEtFQ1hyL0VRVU5GMHVzTm50K0xYZERNUCtON1RoZG5TSFdxVEtvN0tDKzNRRVN1CmNIeUZDdFlFWitmZC9BaHFrcnpJMUNXQWxXMDBWdkRPRkhMY1FUQTFRUTFzazV6akkxSFB5NjJmLzZaQWxmUkgKc0VzNDNlNmwrWkVQUmRURFU3bzVaOGNzRnNBK3ZrZnJqVVVYcjBXN3Myamt6V2RVRk95WkRjMmEwLzJ3M0U2UApRVGNWZVNyMHkvMllISnpSL0VVQ0F3RUFBYU5DTUVBd0RnWURWUjBQQVFIL0JBUURBZ0trTUE4R0ExVWRFd0VCCi93UUZNQU1CQWY4d0hRWURWUjBPQkJZRUZEcDJXT05GMUtwRStFeXA3UUx5SWFLUzV0ekVNQTBHQ1NxR1NJYjMKRFFFQkN3VUFBNElCQVFDVnhna2pocG5tdGx4M01hREw1Y1pMN1YyNmdoYXc3MFJWOUQrUWl6c1NreGhrZzFVZwp2Q1J2THZWaE9aNTBHdWFSL3g5WDQwQTFQbHlId3NTVlpyWmlRL2pTL2k4THJsampIbkpzSHJwZUw1TUk5d2hqClNER2tiVVJ4M3NNL2s2UjcxajRQVkxMbEdYbC9Lb21vQ0ZhWDRxNWdURTBYV0VQcHZaUy9RSWNWNEJUaS9PNngKOVNkbWhQNTFhbHJsRWJTZE1iWENnbGV4WWV5aUlGdzVvTEZxRkNuTWNOMmhPeTRKTmRDYmFRWlV5NVAyWERzTQp3YlA2MWxURjBtY1hrb3JSeGNpRHd5ekxnQnVHYWdJbTBDbEI2alExZ29sblQ2dEZqWGZuUWFRZnA2ZUg3SzJsCkFFU1BOZnVjUjJyYVhuUXJoMWN3YUVlVXBkNGZOaDZSNVpUcQotLS0tLUVORCBDRVJUSUZJQ0FURS0tLS0tCg=="}}}, "createdAt": resource.PropertyValue{V: "2023-01-30 17:46:14.665 +0000 UTC"}, "enabledClusterLogTypes": resource.PropertyValue{V: []resource.PropertyValue{}}, "endpoint": resource.PropertyValue{V: "https://A9706C137EEBAD726214E8427E0F5191.gr7.us-west-2.eks.amazonaws.com"}, "id": resource.PropertyValue{V: "my-cluster"}, "identities": resource.PropertyValue{V: []resource.PropertyValue{{V: resource.PropertyMap{"oidcs": resource.PropertyValue{V: []resource.PropertyValue{{V: resource.PropertyMap{"issuer": resource.PropertyValue{V: "https://oidc.eks.us-west-2.amazonaws.com/id/A9706C137EEBAD726214E8427E0F5191"}}}}}}}}}, "kubernetesNetworkConfig": resource.PropertyValue{V: resource.PropertyMap{"ipFamily": resource.PropertyValue{V: "ipv4"}, "serviceIpv4Cidr": resource.PropertyValue{V: "10.100.0.0/16"}}}, "name": resource.PropertyValue{V: "my-cluster"}, "platformVersion": resource.PropertyValue{V: "eks.15"}, "roleArn": resource.PropertyValue{V: "arn:aws:iam::616138583583:role/my-cluster-eksRole-role-e5162ea"}, "status": resource.PropertyValue{V: "ACTIVE"}, "tags": resource.PropertyValue{V: resource.PropertyMap{"Name": resource.PropertyValue{V: "my-cluster-eksCluster"}}}, "tagsAll": resource.PropertyValue{V: resource.PropertyMap{"Name": resource.PropertyValue{V: "my-cluster-eksCluster"}}}, "version": resource.PropertyValue{V: "1.21"}, "vpcConfig": resource.PropertyValue{V: resource.PropertyMap{"clusterSecurityGroupId": resource.PropertyValue{V: "sg-029766b5143e30695"}, "endpointPrivateAccess": resource.PropertyValue{V: false}, "endpointPublicAccess": resource.PropertyValue{V: true}, "publicAccessCidrs": resource.PropertyValue{V: []resource.PropertyValue{{V: "0.0.0.0/0"}}}, "securityGroupIds": resource.PropertyValue{V: []resource.PropertyValue{{V: "sg-0e6ade8fc1585462a"}}}, "subnetIds": resource.PropertyValue{V: []resource.PropertyValue{{V: "subnet-0016572b"}, {V: "subnet-d7e7fe9c"}, {V: "subnet-c7d926bf"}, {V: "subnet-43f43a1e"}}}, "vpcId": resource.PropertyValue{V: "vpc-4b82e033"}}}})
	require.NoError(t, err)
	assert.Equal(t, expectedInputs, inputs)
	assert.Equal(t, expectedMeta, meta)
	// state, err := res.InstanceState("", inputs, meta)
	// require.NoError(t, err)
	// t.Logf("%T: %[1]#v", state)
	// _, err = state.Object(res.Schema())
	// require.NoError(t, err)
}

var expectedInputs = map[string]interface{}{
	"arn": "arn:aws:eks:us-west-2:616138583583:cluster/my-cluster",
	"certificate_authority": []interface{}{[]interface{}{
		map[string]interface{}{
			"data": "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM1ekNDQWMrZ0F3SUJBZ0lCQURBTkJna3Foa2lHOXcwQkFRc0ZBREFWTVJNd0VRWURWUVFERXdwcmRXSmwKY201bGRHVnpNQjRYRFRJek1ERXpNREUzTlRFMU5Wb1hEVE16TURFeU56RTNOVEUxTlZvd0ZURVRNQkVHQTFVRQpBeE1LYTNWaVpYSnVaWFJsY3pDQ0FTSXdEUVlKS29aSWh2Y05BUUVCQlFBRGdnRVBBRENDQVFvQ2dnRUJBUHc3Ck5Xa1JubWw2Y080clRSektPTCtIQ1p6WVJWMHZjQ0ZxZnRUdmozTGl4bEtiUnJkQVhkbDBNNFFCdTIwek5sd0gKcXRnWEgwT3hjeGlYR1N3RXUzVTk5dmpWVDVsazViWjlURUUrQXFSZDVlRnhJY2ozbHZRellGbHpRMWxTRUtROAp3YTlWbFU5bDFzY0ZjNEtkVEtFQ1hyL0VRVU5GMHVzTm50K0xYZERNUCtON1RoZG5TSFdxVEtvN0tDKzNRRVN1CmNIeUZDdFlFWitmZC9BaHFrcnpJMUNXQWxXMDBWdkRPRkhMY1FUQTFRUTFzazV6akkxSFB5NjJmLzZaQWxmUkgKc0VzNDNlNmwrWkVQUmRURFU3bzVaOGNzRnNBK3ZrZnJqVVVYcjBXN3Myamt6V2RVRk95WkRjMmEwLzJ3M0U2UApRVGNWZVNyMHkvMllISnpSL0VVQ0F3RUFBYU5DTUVBd0RnWURWUjBQQVFIL0JBUURBZ0trTUE4R0ExVWRFd0VCCi93UUZNQU1CQWY4d0hRWURWUjBPQkJZRUZEcDJXT05GMUtwRStFeXA3UUx5SWFLUzV0ekVNQTBHQ1NxR1NJYjMKRFFFQkN3VUFBNElCQVFDVnhna2pocG5tdGx4M01hREw1Y1pMN1YyNmdoYXc3MFJWOUQrUWl6c1NreGhrZzFVZwp2Q1J2THZWaE9aNTBHdWFSL3g5WDQwQTFQbHlId3NTVlpyWmlRL2pTL2k4THJsampIbkpzSHJwZUw1TUk5d2hqClNER2tiVVJ4M3NNL2s2UjcxajRQVkxMbEdYbC9Lb21vQ0ZhWDRxNWdURTBYV0VQcHZaUy9RSWNWNEJUaS9PNngKOVNkbWhQNTFhbHJsRWJTZE1iWENnbGV4WWV5aUlGdzVvTEZxRkNuTWNOMmhPeTRKTmRDYmFRWlV5NVAyWERzTQp3YlA2MWxURjBtY1hrb3JSeGNpRHd5ekxnQnVHYWdJbTBDbEI2alExZ29sblQ2dEZqWGZuUWFRZnA2ZUg3SzJsCkFFU1BOZnVjUjJyYVhuUXJoMWN3YUVlVXBkNGZOaDZSNVpUcQotLS0tLUVORCBDRVJUSUZJQ0FURS0tLS0tCg==",
		},
	}},
	"created_at":                "2023-01-30 17:46:14.665 +0000 UTC",
	"enabled_cluster_log_types": []interface{}(nil),
	"endpoint":                  "https://A9706C137EEBAD726214E8427E0F5191.gr7.us-west-2.eks.amazonaws.com",
	"id":                        "my-cluster",
	"identity": []interface{}{map[string]interface{}{
		"oidc": []interface{}{map[string]interface{}{
			"issuer": "https://oidc.eks.us-west-2.amazonaws.com/id/A9706C137EEBAD726214E8427E0F5191"}}}},
	"kubernetes_network_config": []interface{}{map[string]interface{}{
		"ip_family":         "ipv4",
		"service_ipv4_cidr": "10.100.0.0/16"}},
	"name":             "my-cluster",
	"platform_version": "eks.15",
	"role_arn":         "arn:aws:iam::616138583583:role/my-cluster-eksRole-role-e5162ea",
	"status":           "ACTIVE",
	"tags":             map[string]interface{}{"Name": "my-cluster-eksCluster"},
	"tags_all":         map[string]interface{}{"Name": "my-cluster-eksCluster"},
	"version":          "1.21",
	"vpc_config": []interface{}{map[string]interface{}{
		"cluster_security_group_id": "sg-029766b5143e30695",
		"endpoint_private_access":   false,
		"endpoint_public_access":    true,
		"public_access_cidrs":       []interface{}{"0.0.0.0/0"},
		"security_group_ids":        []interface{}{"sg-0e6ade8fc1585462a"},
		"subnet_ids": []interface{}{
			"subnet-0016572b",
			"subnet-d7e7fe9c",
			"subnet-c7d926bf",
			"subnet-43f43a1e"},
		"vpc_id": "vpc-4b82e033"}}}

var expectedMeta = map[string]interface{}{
	"e2bfb730-ecaa-11e6-8f88-34363bc7c4c0": map[string]interface{}{
		"create": 1.8e+12,
		"delete": 9e+11,
		"update": 3.6e+12},
}
