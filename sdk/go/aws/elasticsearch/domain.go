// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package elasticsearch

import (
	"context"
	"reflect"

	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Manages an AWS Elasticsearch Domain.
//
// ## Example Usage
//
// ### Basic Usage
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/elasticsearch"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			_, err := elasticsearch.NewDomain(ctx, "example", &elasticsearch.DomainArgs{
//				DomainName:           pulumi.String("example"),
//				ElasticsearchVersion: pulumi.String("7.10"),
//				ClusterConfig: &elasticsearch.DomainClusterConfigArgs{
//					InstanceType: pulumi.String("r4.large.elasticsearch"),
//				},
//				Tags: pulumi.StringMap{
//					"Domain": pulumi.String("TestDomain"),
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### Access Policy
//
// > See also: `elasticsearch.DomainPolicy` resource
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/elasticsearch"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi/config"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			cfg := config.New(ctx, "")
//			domain := "tf-test"
//			if param := cfg.Get("domain"); param != "" {
//				domain = param
//			}
//			current, err := aws.GetRegion(ctx, &aws.GetRegionArgs{}, nil)
//			if err != nil {
//				return err
//			}
//			currentGetCallerIdentity, err := aws.GetCallerIdentity(ctx, &aws.GetCallerIdentityArgs{}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = elasticsearch.NewDomain(ctx, "example", &elasticsearch.DomainArgs{
//				DomainName: pulumi.String(domain),
//				AccessPolicies: pulumi.Any(fmt.Sprintf(`{
//	  "Version": "2012-10-17",
//	  "Statement": [
//	    {
//	      "Action": "es:*",
//	      "Principal": "*",
//	      "Effect": "Allow",
//	      "Resource": "arn:aws:es:%v:%v:domain/%v/*",
//	      "Condition": {
//	        "IpAddress": {"aws:SourceIp": ["66.193.100.22/32"]}
//	      }
//	    }
//	  ]
//	}
//
// `, current.Name, currentGetCallerIdentity.AccountId, domain)),
//
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### Log Publishing to CloudWatch Logs
//
// ```go
// package main
//
// import (
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/cloudwatch"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/elasticsearch"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			exampleLogGroup, err := cloudwatch.NewLogGroup(ctx, "example", &cloudwatch.LogGroupArgs{
//				Name: pulumi.String("example"),
//			})
//			if err != nil {
//				return err
//			}
//			example, err := iam.GetPolicyDocument(ctx, &iam.GetPolicyDocumentArgs{
//				Statements: []iam.GetPolicyDocumentStatement{
//					{
//						Effect: pulumi.StringRef("Allow"),
//						Principals: []iam.GetPolicyDocumentStatementPrincipal{
//							{
//								Type: "Service",
//								Identifiers: []string{
//									"es.amazonaws.com",
//								},
//							},
//						},
//						Actions: []string{
//							"logs:PutLogEvents",
//							"logs:PutLogEventsBatch",
//							"logs:CreateLogStream",
//						},
//						Resources: []string{
//							"arn:aws:logs:*",
//						},
//					},
//				},
//			}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = cloudwatch.NewLogResourcePolicy(ctx, "example", &cloudwatch.LogResourcePolicyArgs{
//				PolicyName:     pulumi.String("example"),
//				PolicyDocument: pulumi.String(example.Json),
//			})
//			if err != nil {
//				return err
//			}
//			_, err = elasticsearch.NewDomain(ctx, "example", &elasticsearch.DomainArgs{
//				LogPublishingOptions: elasticsearch.DomainLogPublishingOptionArray{
//					&elasticsearch.DomainLogPublishingOptionArgs{
//						CloudwatchLogGroupArn: exampleLogGroup.Arn,
//						LogType:               pulumi.String("INDEX_SLOW_LOGS"),
//					},
//				},
//			})
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ### VPC based ES
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/ec2"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/elasticsearch"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/iam"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi/config"
//
// )
// func main() {
// pulumi.Run(func(ctx *pulumi.Context) error {
// cfg := config.New(ctx, "")
// vpc := cfg.RequireObject("vpc")
// domain := "tf-test";
// if param := cfg.Get("domain"); param != ""{
// domain = param
// }
// selected, err := ec2.LookupVpc(ctx, &ec2.LookupVpcArgs{
// Tags: pulumi.StringMap{
// "Name": vpc,
// },
// }, nil);
// if err != nil {
// return err
// }
// selectedGetSubnets, err := ec2.GetSubnets(ctx, &ec2.GetSubnetsArgs{
// Filters: []ec2.GetSubnetsFilter{
// {
// Name: "vpc-id",
// Values: interface{}{
// selected.Id,
// },
// },
// },
// Tags: map[string]interface{}{
// "Tier": "private",
// },
// }, nil);
// if err != nil {
// return err
// }
// current, err := aws.GetRegion(ctx, &aws.GetRegionArgs{
// }, nil);
// if err != nil {
// return err
// }
// currentGetCallerIdentity, err := aws.GetCallerIdentity(ctx, &aws.GetCallerIdentityArgs{
// }, nil);
// if err != nil {
// return err
// }
// es, err := ec2.NewSecurityGroup(ctx, "es", &ec2.SecurityGroupArgs{
// Name: pulumi.Sprintf("%v-elasticsearch-%v", vpc, domain),
// Description: pulumi.String("Managed by Pulumi"),
// VpcId: pulumi.String(selected.Id),
// Ingress: ec2.SecurityGroupIngressArray{
// &ec2.SecurityGroupIngressArgs{
// FromPort: pulumi.Int(443),
// ToPort: pulumi.Int(443),
// Protocol: pulumi.String("tcp"),
// CidrBlocks: pulumi.StringArray{
// pulumi.String(selected.CidrBlock),
// },
// },
// },
// })
// if err != nil {
// return err
// }
// esServiceLinkedRole, err := iam.NewServiceLinkedRole(ctx, "es", &iam.ServiceLinkedRoleArgs{
// AwsServiceName: pulumi.String("opensearchservice.amazonaws.com"),
// })
// if err != nil {
// return err
// }
// _, err = elasticsearch.NewDomain(ctx, "es", &elasticsearch.DomainArgs{
// DomainName: pulumi.String(domain),
// ElasticsearchVersion: pulumi.String("6.3"),
// ClusterConfig: &elasticsearch.DomainClusterConfigArgs{
// InstanceType: pulumi.String("m4.large.elasticsearch"),
// ZoneAwarenessEnabled: pulumi.Bool(true),
// },
// VpcOptions: &elasticsearch.DomainVpcOptionsArgs{
// SubnetIds: pulumi.StringArray{
// pulumi.String(selectedGetSubnets.Ids[0]),
// pulumi.String(selectedGetSubnets.Ids[1]),
// },
// SecurityGroupIds: pulumi.StringArray{
// es.ID(),
// },
// },
// AdvancedOptions: pulumi.StringMap{
// "rest.action.multi.allow_explicit_index": pulumi.String("true"),
// },
//
//	AccessPolicies: pulumi.Any(fmt.Sprintf(`{
//		"Version": "2012-10-17",
//		"Statement": [
//			{
//				"Action": "es:*",
//				"Principal": "*",
//				"Effect": "Allow",
//				"Resource": "arn:aws:es:%v:%v:domain/%v/*"
//			}
//		]
//	}
//
// `, current.Name, currentGetCallerIdentity.AccountId, domain)),
// Tags: pulumi.StringMap{
// "Domain": pulumi.String("TestDomain"),
// },
// }, pulumi.DependsOn([]pulumi.Resource{
// esServiceLinkedRole,
// }))
// if err != nil {
// return err
// }
// return nil
// })
// }
// ```
//
// ## Import
//
// Using `pulumi import`, import Elasticsearch domains using the `domain_name`. For example:
//
// ```sh
// $ pulumi import aws:elasticsearch/domain:Domain example domain_name
// ```
type Domain struct {
	pulumi.CustomResourceState

	// IAM policy document specifying the access policies for the domain.
	AccessPolicies pulumi.StringOutput `pulumi:"accessPolicies"`
	// Key-value string pairs to specify advanced configuration options. Note that the values for these configuration options must be strings (wrapped in quotes) or they may be wrong and cause a perpetual diff, causing the provider to want to recreate your Elasticsearch domain on every apply.
	AdvancedOptions pulumi.StringMapOutput `pulumi:"advancedOptions"`
	// Configuration block for [fine-grained access control](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/fgac.html). Detailed below.
	AdvancedSecurityOptions DomainAdvancedSecurityOptionsOutput `pulumi:"advancedSecurityOptions"`
	// ARN of the domain.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// Configuration block for the Auto-Tune options of the domain. Detailed below.
	AutoTuneOptions DomainAutoTuneOptionsOutput `pulumi:"autoTuneOptions"`
	// Configuration block for the cluster of the domain. Detailed below.
	ClusterConfig DomainClusterConfigOutput `pulumi:"clusterConfig"`
	// Configuration block for authenticating Kibana with Cognito. Detailed below.
	CognitoOptions DomainCognitoOptionsPtrOutput `pulumi:"cognitoOptions"`
	// Configuration block for domain endpoint HTTP(S) related options. Detailed below.
	DomainEndpointOptions DomainDomainEndpointOptionsOutput `pulumi:"domainEndpointOptions"`
	// Unique identifier for the domain.
	DomainId pulumi.StringOutput `pulumi:"domainId"`
	// Name of the domain.
	//
	// The following arguments are optional:
	DomainName pulumi.StringOutput `pulumi:"domainName"`
	// Configuration block for EBS related options, may be required based on chosen [instance size](https://aws.amazon.com/elasticsearch-service/pricing/). Detailed below.
	EbsOptions DomainEbsOptionsOutput `pulumi:"ebsOptions"`
	// Version of Elasticsearch to deploy. Defaults to `1.5`.
	ElasticsearchVersion pulumi.StringPtrOutput `pulumi:"elasticsearchVersion"`
	// Configuration block for encrypt at rest options. Only available for [certain instance types](http://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/aes-supported-instance-types.html). Detailed below.
	EncryptAtRest DomainEncryptAtRestOutput `pulumi:"encryptAtRest"`
	// Domain-specific endpoint used to submit index, search, and data upload requests.
	Endpoint pulumi.StringOutput `pulumi:"endpoint"`
	// Domain-specific endpoint for kibana without https scheme.
	KibanaEndpoint pulumi.StringOutput `pulumi:"kibanaEndpoint"`
	// Configuration block for publishing slow and application logs to CloudWatch Logs. This block can be declared multiple times, for each log_type, within the same resource. Detailed below.
	LogPublishingOptions DomainLogPublishingOptionArrayOutput `pulumi:"logPublishingOptions"`
	// Configuration block for node-to-node encryption options. Detailed below.
	NodeToNodeEncryption DomainNodeToNodeEncryptionOutput `pulumi:"nodeToNodeEncryption"`
	// Configuration block for snapshot related options. Detailed below. DEPRECATED. For domains running Elasticsearch 5.3 and later, Amazon ES takes hourly automated snapshots, making this setting irrelevant. For domains running earlier versions of Elasticsearch, Amazon ES takes daily automated snapshots.
	SnapshotOptions DomainSnapshotOptionsPtrOutput `pulumi:"snapshotOptions"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapOutput `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapOutput `pulumi:"tagsAll"`
	// Configuration block for VPC related options. Adding or removing this configuration forces a new resource ([documentation](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/es-vpc.html#es-vpc-limitations)). Detailed below.
	VpcOptions DomainVpcOptionsPtrOutput `pulumi:"vpcOptions"`
}

// NewDomain registers a new resource with the given unique name, arguments, and options.
func NewDomain(ctx *pulumi.Context,
	name string, args *DomainArgs, opts ...pulumi.ResourceOption) (*Domain, error) {
	if args == nil {
		args = &DomainArgs{}
	}

	opts = internal.PkgResourceDefaultOpts(opts)
	var resource Domain
	err := ctx.RegisterResource("aws:elasticsearch/domain:Domain", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetDomain gets an existing Domain resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetDomain(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *DomainState, opts ...pulumi.ResourceOption) (*Domain, error) {
	var resource Domain
	err := ctx.ReadResource("aws:elasticsearch/domain:Domain", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering Domain resources.
type domainState struct {
	// IAM policy document specifying the access policies for the domain.
	AccessPolicies interface{} `pulumi:"accessPolicies"`
	// Key-value string pairs to specify advanced configuration options. Note that the values for these configuration options must be strings (wrapped in quotes) or they may be wrong and cause a perpetual diff, causing the provider to want to recreate your Elasticsearch domain on every apply.
	AdvancedOptions map[string]string `pulumi:"advancedOptions"`
	// Configuration block for [fine-grained access control](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/fgac.html). Detailed below.
	AdvancedSecurityOptions *DomainAdvancedSecurityOptions `pulumi:"advancedSecurityOptions"`
	// ARN of the domain.
	Arn *string `pulumi:"arn"`
	// Configuration block for the Auto-Tune options of the domain. Detailed below.
	AutoTuneOptions *DomainAutoTuneOptions `pulumi:"autoTuneOptions"`
	// Configuration block for the cluster of the domain. Detailed below.
	ClusterConfig *DomainClusterConfig `pulumi:"clusterConfig"`
	// Configuration block for authenticating Kibana with Cognito. Detailed below.
	CognitoOptions *DomainCognitoOptions `pulumi:"cognitoOptions"`
	// Configuration block for domain endpoint HTTP(S) related options. Detailed below.
	DomainEndpointOptions *DomainDomainEndpointOptions `pulumi:"domainEndpointOptions"`
	// Unique identifier for the domain.
	DomainId *string `pulumi:"domainId"`
	// Name of the domain.
	//
	// The following arguments are optional:
	DomainName *string `pulumi:"domainName"`
	// Configuration block for EBS related options, may be required based on chosen [instance size](https://aws.amazon.com/elasticsearch-service/pricing/). Detailed below.
	EbsOptions *DomainEbsOptions `pulumi:"ebsOptions"`
	// Version of Elasticsearch to deploy. Defaults to `1.5`.
	ElasticsearchVersion *string `pulumi:"elasticsearchVersion"`
	// Configuration block for encrypt at rest options. Only available for [certain instance types](http://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/aes-supported-instance-types.html). Detailed below.
	EncryptAtRest *DomainEncryptAtRest `pulumi:"encryptAtRest"`
	// Domain-specific endpoint used to submit index, search, and data upload requests.
	Endpoint *string `pulumi:"endpoint"`
	// Domain-specific endpoint for kibana without https scheme.
	KibanaEndpoint *string `pulumi:"kibanaEndpoint"`
	// Configuration block for publishing slow and application logs to CloudWatch Logs. This block can be declared multiple times, for each log_type, within the same resource. Detailed below.
	LogPublishingOptions []DomainLogPublishingOption `pulumi:"logPublishingOptions"`
	// Configuration block for node-to-node encryption options. Detailed below.
	NodeToNodeEncryption *DomainNodeToNodeEncryption `pulumi:"nodeToNodeEncryption"`
	// Configuration block for snapshot related options. Detailed below. DEPRECATED. For domains running Elasticsearch 5.3 and later, Amazon ES takes hourly automated snapshots, making this setting irrelevant. For domains running earlier versions of Elasticsearch, Amazon ES takes daily automated snapshots.
	SnapshotOptions *DomainSnapshotOptions `pulumi:"snapshotOptions"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll map[string]string `pulumi:"tagsAll"`
	// Configuration block for VPC related options. Adding or removing this configuration forces a new resource ([documentation](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/es-vpc.html#es-vpc-limitations)). Detailed below.
	VpcOptions *DomainVpcOptions `pulumi:"vpcOptions"`
}

type DomainState struct {
	// IAM policy document specifying the access policies for the domain.
	AccessPolicies pulumi.Input
	// Key-value string pairs to specify advanced configuration options. Note that the values for these configuration options must be strings (wrapped in quotes) or they may be wrong and cause a perpetual diff, causing the provider to want to recreate your Elasticsearch domain on every apply.
	AdvancedOptions pulumi.StringMapInput
	// Configuration block for [fine-grained access control](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/fgac.html). Detailed below.
	AdvancedSecurityOptions DomainAdvancedSecurityOptionsPtrInput
	// ARN of the domain.
	Arn pulumi.StringPtrInput
	// Configuration block for the Auto-Tune options of the domain. Detailed below.
	AutoTuneOptions DomainAutoTuneOptionsPtrInput
	// Configuration block for the cluster of the domain. Detailed below.
	ClusterConfig DomainClusterConfigPtrInput
	// Configuration block for authenticating Kibana with Cognito. Detailed below.
	CognitoOptions DomainCognitoOptionsPtrInput
	// Configuration block for domain endpoint HTTP(S) related options. Detailed below.
	DomainEndpointOptions DomainDomainEndpointOptionsPtrInput
	// Unique identifier for the domain.
	DomainId pulumi.StringPtrInput
	// Name of the domain.
	//
	// The following arguments are optional:
	DomainName pulumi.StringPtrInput
	// Configuration block for EBS related options, may be required based on chosen [instance size](https://aws.amazon.com/elasticsearch-service/pricing/). Detailed below.
	EbsOptions DomainEbsOptionsPtrInput
	// Version of Elasticsearch to deploy. Defaults to `1.5`.
	ElasticsearchVersion pulumi.StringPtrInput
	// Configuration block for encrypt at rest options. Only available for [certain instance types](http://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/aes-supported-instance-types.html). Detailed below.
	EncryptAtRest DomainEncryptAtRestPtrInput
	// Domain-specific endpoint used to submit index, search, and data upload requests.
	Endpoint pulumi.StringPtrInput
	// Domain-specific endpoint for kibana without https scheme.
	KibanaEndpoint pulumi.StringPtrInput
	// Configuration block for publishing slow and application logs to CloudWatch Logs. This block can be declared multiple times, for each log_type, within the same resource. Detailed below.
	LogPublishingOptions DomainLogPublishingOptionArrayInput
	// Configuration block for node-to-node encryption options. Detailed below.
	NodeToNodeEncryption DomainNodeToNodeEncryptionPtrInput
	// Configuration block for snapshot related options. Detailed below. DEPRECATED. For domains running Elasticsearch 5.3 and later, Amazon ES takes hourly automated snapshots, making this setting irrelevant. For domains running earlier versions of Elasticsearch, Amazon ES takes daily automated snapshots.
	SnapshotOptions DomainSnapshotOptionsPtrInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
	//
	// Deprecated: Please use `tags` instead.
	TagsAll pulumi.StringMapInput
	// Configuration block for VPC related options. Adding or removing this configuration forces a new resource ([documentation](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/es-vpc.html#es-vpc-limitations)). Detailed below.
	VpcOptions DomainVpcOptionsPtrInput
}

func (DomainState) ElementType() reflect.Type {
	return reflect.TypeOf((*domainState)(nil)).Elem()
}

type domainArgs struct {
	// IAM policy document specifying the access policies for the domain.
	AccessPolicies interface{} `pulumi:"accessPolicies"`
	// Key-value string pairs to specify advanced configuration options. Note that the values for these configuration options must be strings (wrapped in quotes) or they may be wrong and cause a perpetual diff, causing the provider to want to recreate your Elasticsearch domain on every apply.
	AdvancedOptions map[string]string `pulumi:"advancedOptions"`
	// Configuration block for [fine-grained access control](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/fgac.html). Detailed below.
	AdvancedSecurityOptions *DomainAdvancedSecurityOptions `pulumi:"advancedSecurityOptions"`
	// Configuration block for the Auto-Tune options of the domain. Detailed below.
	AutoTuneOptions *DomainAutoTuneOptions `pulumi:"autoTuneOptions"`
	// Configuration block for the cluster of the domain. Detailed below.
	ClusterConfig *DomainClusterConfig `pulumi:"clusterConfig"`
	// Configuration block for authenticating Kibana with Cognito. Detailed below.
	CognitoOptions *DomainCognitoOptions `pulumi:"cognitoOptions"`
	// Configuration block for domain endpoint HTTP(S) related options. Detailed below.
	DomainEndpointOptions *DomainDomainEndpointOptions `pulumi:"domainEndpointOptions"`
	// Name of the domain.
	//
	// The following arguments are optional:
	DomainName *string `pulumi:"domainName"`
	// Configuration block for EBS related options, may be required based on chosen [instance size](https://aws.amazon.com/elasticsearch-service/pricing/). Detailed below.
	EbsOptions *DomainEbsOptions `pulumi:"ebsOptions"`
	// Version of Elasticsearch to deploy. Defaults to `1.5`.
	ElasticsearchVersion *string `pulumi:"elasticsearchVersion"`
	// Configuration block for encrypt at rest options. Only available for [certain instance types](http://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/aes-supported-instance-types.html). Detailed below.
	EncryptAtRest *DomainEncryptAtRest `pulumi:"encryptAtRest"`
	// Configuration block for publishing slow and application logs to CloudWatch Logs. This block can be declared multiple times, for each log_type, within the same resource. Detailed below.
	LogPublishingOptions []DomainLogPublishingOption `pulumi:"logPublishingOptions"`
	// Configuration block for node-to-node encryption options. Detailed below.
	NodeToNodeEncryption *DomainNodeToNodeEncryption `pulumi:"nodeToNodeEncryption"`
	// Configuration block for snapshot related options. Detailed below. DEPRECATED. For domains running Elasticsearch 5.3 and later, Amazon ES takes hourly automated snapshots, making this setting irrelevant. For domains running earlier versions of Elasticsearch, Amazon ES takes daily automated snapshots.
	SnapshotOptions *DomainSnapshotOptions `pulumi:"snapshotOptions"`
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags map[string]string `pulumi:"tags"`
	// Configuration block for VPC related options. Adding or removing this configuration forces a new resource ([documentation](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/es-vpc.html#es-vpc-limitations)). Detailed below.
	VpcOptions *DomainVpcOptions `pulumi:"vpcOptions"`
}

// The set of arguments for constructing a Domain resource.
type DomainArgs struct {
	// IAM policy document specifying the access policies for the domain.
	AccessPolicies pulumi.Input
	// Key-value string pairs to specify advanced configuration options. Note that the values for these configuration options must be strings (wrapped in quotes) or they may be wrong and cause a perpetual diff, causing the provider to want to recreate your Elasticsearch domain on every apply.
	AdvancedOptions pulumi.StringMapInput
	// Configuration block for [fine-grained access control](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/fgac.html). Detailed below.
	AdvancedSecurityOptions DomainAdvancedSecurityOptionsPtrInput
	// Configuration block for the Auto-Tune options of the domain. Detailed below.
	AutoTuneOptions DomainAutoTuneOptionsPtrInput
	// Configuration block for the cluster of the domain. Detailed below.
	ClusterConfig DomainClusterConfigPtrInput
	// Configuration block for authenticating Kibana with Cognito. Detailed below.
	CognitoOptions DomainCognitoOptionsPtrInput
	// Configuration block for domain endpoint HTTP(S) related options. Detailed below.
	DomainEndpointOptions DomainDomainEndpointOptionsPtrInput
	// Name of the domain.
	//
	// The following arguments are optional:
	DomainName pulumi.StringPtrInput
	// Configuration block for EBS related options, may be required based on chosen [instance size](https://aws.amazon.com/elasticsearch-service/pricing/). Detailed below.
	EbsOptions DomainEbsOptionsPtrInput
	// Version of Elasticsearch to deploy. Defaults to `1.5`.
	ElasticsearchVersion pulumi.StringPtrInput
	// Configuration block for encrypt at rest options. Only available for [certain instance types](http://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/aes-supported-instance-types.html). Detailed below.
	EncryptAtRest DomainEncryptAtRestPtrInput
	// Configuration block for publishing slow and application logs to CloudWatch Logs. This block can be declared multiple times, for each log_type, within the same resource. Detailed below.
	LogPublishingOptions DomainLogPublishingOptionArrayInput
	// Configuration block for node-to-node encryption options. Detailed below.
	NodeToNodeEncryption DomainNodeToNodeEncryptionPtrInput
	// Configuration block for snapshot related options. Detailed below. DEPRECATED. For domains running Elasticsearch 5.3 and later, Amazon ES takes hourly automated snapshots, making this setting irrelevant. For domains running earlier versions of Elasticsearch, Amazon ES takes daily automated snapshots.
	SnapshotOptions DomainSnapshotOptionsPtrInput
	// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
	Tags pulumi.StringMapInput
	// Configuration block for VPC related options. Adding or removing this configuration forces a new resource ([documentation](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/es-vpc.html#es-vpc-limitations)). Detailed below.
	VpcOptions DomainVpcOptionsPtrInput
}

func (DomainArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*domainArgs)(nil)).Elem()
}

type DomainInput interface {
	pulumi.Input

	ToDomainOutput() DomainOutput
	ToDomainOutputWithContext(ctx context.Context) DomainOutput
}

func (*Domain) ElementType() reflect.Type {
	return reflect.TypeOf((**Domain)(nil)).Elem()
}

func (i *Domain) ToDomainOutput() DomainOutput {
	return i.ToDomainOutputWithContext(context.Background())
}

func (i *Domain) ToDomainOutputWithContext(ctx context.Context) DomainOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DomainOutput)
}

// DomainArrayInput is an input type that accepts DomainArray and DomainArrayOutput values.
// You can construct a concrete instance of `DomainArrayInput` via:
//
//	DomainArray{ DomainArgs{...} }
type DomainArrayInput interface {
	pulumi.Input

	ToDomainArrayOutput() DomainArrayOutput
	ToDomainArrayOutputWithContext(context.Context) DomainArrayOutput
}

type DomainArray []DomainInput

func (DomainArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Domain)(nil)).Elem()
}

func (i DomainArray) ToDomainArrayOutput() DomainArrayOutput {
	return i.ToDomainArrayOutputWithContext(context.Background())
}

func (i DomainArray) ToDomainArrayOutputWithContext(ctx context.Context) DomainArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DomainArrayOutput)
}

// DomainMapInput is an input type that accepts DomainMap and DomainMapOutput values.
// You can construct a concrete instance of `DomainMapInput` via:
//
//	DomainMap{ "key": DomainArgs{...} }
type DomainMapInput interface {
	pulumi.Input

	ToDomainMapOutput() DomainMapOutput
	ToDomainMapOutputWithContext(context.Context) DomainMapOutput
}

type DomainMap map[string]DomainInput

func (DomainMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Domain)(nil)).Elem()
}

func (i DomainMap) ToDomainMapOutput() DomainMapOutput {
	return i.ToDomainMapOutputWithContext(context.Background())
}

func (i DomainMap) ToDomainMapOutputWithContext(ctx context.Context) DomainMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(DomainMapOutput)
}

type DomainOutput struct{ *pulumi.OutputState }

func (DomainOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**Domain)(nil)).Elem()
}

func (o DomainOutput) ToDomainOutput() DomainOutput {
	return o
}

func (o DomainOutput) ToDomainOutputWithContext(ctx context.Context) DomainOutput {
	return o
}

// IAM policy document specifying the access policies for the domain.
func (o DomainOutput) AccessPolicies() pulumi.StringOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringOutput { return v.AccessPolicies }).(pulumi.StringOutput)
}

// Key-value string pairs to specify advanced configuration options. Note that the values for these configuration options must be strings (wrapped in quotes) or they may be wrong and cause a perpetual diff, causing the provider to want to recreate your Elasticsearch domain on every apply.
func (o DomainOutput) AdvancedOptions() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringMapOutput { return v.AdvancedOptions }).(pulumi.StringMapOutput)
}

// Configuration block for [fine-grained access control](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/fgac.html). Detailed below.
func (o DomainOutput) AdvancedSecurityOptions() DomainAdvancedSecurityOptionsOutput {
	return o.ApplyT(func(v *Domain) DomainAdvancedSecurityOptionsOutput { return v.AdvancedSecurityOptions }).(DomainAdvancedSecurityOptionsOutput)
}

// ARN of the domain.
func (o DomainOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// Configuration block for the Auto-Tune options of the domain. Detailed below.
func (o DomainOutput) AutoTuneOptions() DomainAutoTuneOptionsOutput {
	return o.ApplyT(func(v *Domain) DomainAutoTuneOptionsOutput { return v.AutoTuneOptions }).(DomainAutoTuneOptionsOutput)
}

// Configuration block for the cluster of the domain. Detailed below.
func (o DomainOutput) ClusterConfig() DomainClusterConfigOutput {
	return o.ApplyT(func(v *Domain) DomainClusterConfigOutput { return v.ClusterConfig }).(DomainClusterConfigOutput)
}

// Configuration block for authenticating Kibana with Cognito. Detailed below.
func (o DomainOutput) CognitoOptions() DomainCognitoOptionsPtrOutput {
	return o.ApplyT(func(v *Domain) DomainCognitoOptionsPtrOutput { return v.CognitoOptions }).(DomainCognitoOptionsPtrOutput)
}

// Configuration block for domain endpoint HTTP(S) related options. Detailed below.
func (o DomainOutput) DomainEndpointOptions() DomainDomainEndpointOptionsOutput {
	return o.ApplyT(func(v *Domain) DomainDomainEndpointOptionsOutput { return v.DomainEndpointOptions }).(DomainDomainEndpointOptionsOutput)
}

// Unique identifier for the domain.
func (o DomainOutput) DomainId() pulumi.StringOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringOutput { return v.DomainId }).(pulumi.StringOutput)
}

// Name of the domain.
//
// The following arguments are optional:
func (o DomainOutput) DomainName() pulumi.StringOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringOutput { return v.DomainName }).(pulumi.StringOutput)
}

// Configuration block for EBS related options, may be required based on chosen [instance size](https://aws.amazon.com/elasticsearch-service/pricing/). Detailed below.
func (o DomainOutput) EbsOptions() DomainEbsOptionsOutput {
	return o.ApplyT(func(v *Domain) DomainEbsOptionsOutput { return v.EbsOptions }).(DomainEbsOptionsOutput)
}

// Version of Elasticsearch to deploy. Defaults to `1.5`.
func (o DomainOutput) ElasticsearchVersion() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringPtrOutput { return v.ElasticsearchVersion }).(pulumi.StringPtrOutput)
}

// Configuration block for encrypt at rest options. Only available for [certain instance types](http://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/aes-supported-instance-types.html). Detailed below.
func (o DomainOutput) EncryptAtRest() DomainEncryptAtRestOutput {
	return o.ApplyT(func(v *Domain) DomainEncryptAtRestOutput { return v.EncryptAtRest }).(DomainEncryptAtRestOutput)
}

// Domain-specific endpoint used to submit index, search, and data upload requests.
func (o DomainOutput) Endpoint() pulumi.StringOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringOutput { return v.Endpoint }).(pulumi.StringOutput)
}

// Domain-specific endpoint for kibana without https scheme.
func (o DomainOutput) KibanaEndpoint() pulumi.StringOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringOutput { return v.KibanaEndpoint }).(pulumi.StringOutput)
}

// Configuration block for publishing slow and application logs to CloudWatch Logs. This block can be declared multiple times, for each log_type, within the same resource. Detailed below.
func (o DomainOutput) LogPublishingOptions() DomainLogPublishingOptionArrayOutput {
	return o.ApplyT(func(v *Domain) DomainLogPublishingOptionArrayOutput { return v.LogPublishingOptions }).(DomainLogPublishingOptionArrayOutput)
}

// Configuration block for node-to-node encryption options. Detailed below.
func (o DomainOutput) NodeToNodeEncryption() DomainNodeToNodeEncryptionOutput {
	return o.ApplyT(func(v *Domain) DomainNodeToNodeEncryptionOutput { return v.NodeToNodeEncryption }).(DomainNodeToNodeEncryptionOutput)
}

// Configuration block for snapshot related options. Detailed below. DEPRECATED. For domains running Elasticsearch 5.3 and later, Amazon ES takes hourly automated snapshots, making this setting irrelevant. For domains running earlier versions of Elasticsearch, Amazon ES takes daily automated snapshots.
func (o DomainOutput) SnapshotOptions() DomainSnapshotOptionsPtrOutput {
	return o.ApplyT(func(v *Domain) DomainSnapshotOptionsPtrOutput { return v.SnapshotOptions }).(DomainSnapshotOptionsPtrOutput)
}

// Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
func (o DomainOutput) Tags() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringMapOutput { return v.Tags }).(pulumi.StringMapOutput)
}

// Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
//
// Deprecated: Please use `tags` instead.
func (o DomainOutput) TagsAll() pulumi.StringMapOutput {
	return o.ApplyT(func(v *Domain) pulumi.StringMapOutput { return v.TagsAll }).(pulumi.StringMapOutput)
}

// Configuration block for VPC related options. Adding or removing this configuration forces a new resource ([documentation](https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/es-vpc.html#es-vpc-limitations)). Detailed below.
func (o DomainOutput) VpcOptions() DomainVpcOptionsPtrOutput {
	return o.ApplyT(func(v *Domain) DomainVpcOptionsPtrOutput { return v.VpcOptions }).(DomainVpcOptionsPtrOutput)
}

type DomainArrayOutput struct{ *pulumi.OutputState }

func (DomainArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*Domain)(nil)).Elem()
}

func (o DomainArrayOutput) ToDomainArrayOutput() DomainArrayOutput {
	return o
}

func (o DomainArrayOutput) ToDomainArrayOutputWithContext(ctx context.Context) DomainArrayOutput {
	return o
}

func (o DomainArrayOutput) Index(i pulumi.IntInput) DomainOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *Domain {
		return vs[0].([]*Domain)[vs[1].(int)]
	}).(DomainOutput)
}

type DomainMapOutput struct{ *pulumi.OutputState }

func (DomainMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*Domain)(nil)).Elem()
}

func (o DomainMapOutput) ToDomainMapOutput() DomainMapOutput {
	return o
}

func (o DomainMapOutput) ToDomainMapOutputWithContext(ctx context.Context) DomainMapOutput {
	return o
}

func (o DomainMapOutput) MapIndex(k pulumi.StringInput) DomainOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *Domain {
		return vs[0].(map[string]*Domain)[vs[1].(string)]
	}).(DomainOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*DomainInput)(nil)).Elem(), &Domain{})
	pulumi.RegisterInputType(reflect.TypeOf((*DomainArrayInput)(nil)).Elem(), DomainArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*DomainMapInput)(nil)).Elem(), DomainMap{})
	pulumi.RegisterOutputType(DomainOutput{})
	pulumi.RegisterOutputType(DomainArrayOutput{})
	pulumi.RegisterOutputType(DomainMapOutput{})
}
