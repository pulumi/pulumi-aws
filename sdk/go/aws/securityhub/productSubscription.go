// Code generated by pulumi-language-go DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package securityhub

import (
	"context"
	"reflect"

	"errors"
	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/internal"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Subscribes to a Security Hub product.
//
// ## Example Usage
//
// ```go
// package main
//
// import (
//
//	"fmt"
//
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws"
//	"github.com/pulumi/pulumi-aws/sdk/v6/go/aws/securityhub"
//	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
//
// )
//
//	func main() {
//		pulumi.Run(func(ctx *pulumi.Context) error {
//			example, err := securityhub.NewAccount(ctx, "example", nil)
//			if err != nil {
//				return err
//			}
//			current, err := aws.GetRegion(ctx, &aws.GetRegionArgs{}, nil)
//			if err != nil {
//				return err
//			}
//			_, err = securityhub.NewProductSubscription(ctx, "example", &securityhub.ProductSubscriptionArgs{
//				ProductArn: pulumi.Sprintf("arn:aws:securityhub:%v:733251395267:product/alertlogic/althreatmanagement", current.Name),
//			}, pulumi.DependsOn([]pulumi.Resource{
//				example,
//			}))
//			if err != nil {
//				return err
//			}
//			return nil
//		})
//	}
//
// ```
//
// ## Import
//
// Using `pulumi import`, import Security Hub product subscriptions using `product_arn,arn`. For example:
//
// ```sh
// $ pulumi import aws:securityhub/productSubscription:ProductSubscription example arn:aws:securityhub:eu-west-1:733251395267:product/alertlogic/althreatmanagement,arn:aws:securityhub:eu-west-1:123456789012:product-subscription/alertlogic/althreatmanagement
// ```
type ProductSubscription struct {
	pulumi.CustomResourceState

	// The ARN of a resource that represents your subscription to the product that generates the findings that you want to import into Security Hub.
	Arn pulumi.StringOutput `pulumi:"arn"`
	// The ARN of the product that generates findings that you want to import into Security Hub - see below.
	//
	// Amazon maintains a list of [Product integrations in AWS Security Hub](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-providers.html) that changes over time. Any of the products on the linked [Available AWS service integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-internal-providers.html) or [Available third-party partner product integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-partner-providers.html) can be configured using `securityhub.ProductSubscription`.
	//
	// Available products can also be listed by running the AWS CLI command `aws securityhub describe-products`.
	//
	// A subset of currently available products (remember to replace `${var.region}` as appropriate) includes:
	//
	// * `arn:aws:securityhub:${var.region}::product/aws/guardduty`
	// * `arn:aws:securityhub:${var.region}::product/aws/inspector`
	// * `arn:aws:securityhub:${var.region}::product/aws/macie`
	// * `arn:aws:securityhub:${var.region}::product/alertlogic/althreatmanagement`
	// * `arn:aws:securityhub:${var.region}::product/armordefense/armoranywhere`
	// * `arn:aws:securityhub:${var.region}::product/barracuda/cloudsecurityguardian`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/cloudguard-iaas`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/dome9-arc`
	// * `arn:aws:securityhub:${var.region}::product/crowdstrike/crowdstrike-falcon`
	// * `arn:aws:securityhub:${var.region}::product/cyberark/cyberark-pta`
	// * `arn:aws:securityhub:${var.region}::product/f5networks/f5-advanced-waf`
	// * `arn:aws:securityhub:${var.region}::product/fortinet/fortigate`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/aws-infection-monkey`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/guardicore`
	// * `arn:aws:securityhub:${var.region}::product/ibm/qradar-siem`
	// * `arn:aws:securityhub:${var.region}::product/imperva/imperva-attack-analytics`
	// * `arn:aws:securityhub:${var.region}::product/mcafee-skyhigh/mcafee-mvision-cloud-aws`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/redlock`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/vm-series`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-pc`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-vm`
	// * `arn:aws:securityhub:${var.region}::product/rapid7/insightvm`
	// * `arn:aws:securityhub:${var.region}::product/sophos/sophos-server-protection`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-enterprise`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-phantom`
	// * `arn:aws:securityhub:${var.region}::product/sumologicinc/sumologic-mda`
	// * `arn:aws:securityhub:${var.region}::product/symantec-corp/symantec-cwp`
	// * `arn:aws:securityhub:${var.region}::product/tenable/tenable-io`
	// * `arn:aws:securityhub:${var.region}::product/trend-micro/deep-security`
	// * `arn:aws:securityhub:${var.region}::product/turbot/turbot`
	// * `arn:aws:securityhub:${var.region}::product/twistlock/twistlock-enterprise`
	ProductArn pulumi.StringOutput `pulumi:"productArn"`
}

// NewProductSubscription registers a new resource with the given unique name, arguments, and options.
func NewProductSubscription(ctx *pulumi.Context,
	name string, args *ProductSubscriptionArgs, opts ...pulumi.ResourceOption) (*ProductSubscription, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.ProductArn == nil {
		return nil, errors.New("invalid value for required argument 'ProductArn'")
	}
	opts = internal.PkgResourceDefaultOpts(opts)
	var resource ProductSubscription
	err := ctx.RegisterResource("aws:securityhub/productSubscription:ProductSubscription", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetProductSubscription gets an existing ProductSubscription resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetProductSubscription(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ProductSubscriptionState, opts ...pulumi.ResourceOption) (*ProductSubscription, error) {
	var resource ProductSubscription
	err := ctx.ReadResource("aws:securityhub/productSubscription:ProductSubscription", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ProductSubscription resources.
type productSubscriptionState struct {
	// The ARN of a resource that represents your subscription to the product that generates the findings that you want to import into Security Hub.
	Arn *string `pulumi:"arn"`
	// The ARN of the product that generates findings that you want to import into Security Hub - see below.
	//
	// Amazon maintains a list of [Product integrations in AWS Security Hub](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-providers.html) that changes over time. Any of the products on the linked [Available AWS service integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-internal-providers.html) or [Available third-party partner product integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-partner-providers.html) can be configured using `securityhub.ProductSubscription`.
	//
	// Available products can also be listed by running the AWS CLI command `aws securityhub describe-products`.
	//
	// A subset of currently available products (remember to replace `${var.region}` as appropriate) includes:
	//
	// * `arn:aws:securityhub:${var.region}::product/aws/guardduty`
	// * `arn:aws:securityhub:${var.region}::product/aws/inspector`
	// * `arn:aws:securityhub:${var.region}::product/aws/macie`
	// * `arn:aws:securityhub:${var.region}::product/alertlogic/althreatmanagement`
	// * `arn:aws:securityhub:${var.region}::product/armordefense/armoranywhere`
	// * `arn:aws:securityhub:${var.region}::product/barracuda/cloudsecurityguardian`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/cloudguard-iaas`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/dome9-arc`
	// * `arn:aws:securityhub:${var.region}::product/crowdstrike/crowdstrike-falcon`
	// * `arn:aws:securityhub:${var.region}::product/cyberark/cyberark-pta`
	// * `arn:aws:securityhub:${var.region}::product/f5networks/f5-advanced-waf`
	// * `arn:aws:securityhub:${var.region}::product/fortinet/fortigate`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/aws-infection-monkey`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/guardicore`
	// * `arn:aws:securityhub:${var.region}::product/ibm/qradar-siem`
	// * `arn:aws:securityhub:${var.region}::product/imperva/imperva-attack-analytics`
	// * `arn:aws:securityhub:${var.region}::product/mcafee-skyhigh/mcafee-mvision-cloud-aws`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/redlock`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/vm-series`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-pc`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-vm`
	// * `arn:aws:securityhub:${var.region}::product/rapid7/insightvm`
	// * `arn:aws:securityhub:${var.region}::product/sophos/sophos-server-protection`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-enterprise`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-phantom`
	// * `arn:aws:securityhub:${var.region}::product/sumologicinc/sumologic-mda`
	// * `arn:aws:securityhub:${var.region}::product/symantec-corp/symantec-cwp`
	// * `arn:aws:securityhub:${var.region}::product/tenable/tenable-io`
	// * `arn:aws:securityhub:${var.region}::product/trend-micro/deep-security`
	// * `arn:aws:securityhub:${var.region}::product/turbot/turbot`
	// * `arn:aws:securityhub:${var.region}::product/twistlock/twistlock-enterprise`
	ProductArn *string `pulumi:"productArn"`
}

type ProductSubscriptionState struct {
	// The ARN of a resource that represents your subscription to the product that generates the findings that you want to import into Security Hub.
	Arn pulumi.StringPtrInput
	// The ARN of the product that generates findings that you want to import into Security Hub - see below.
	//
	// Amazon maintains a list of [Product integrations in AWS Security Hub](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-providers.html) that changes over time. Any of the products on the linked [Available AWS service integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-internal-providers.html) or [Available third-party partner product integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-partner-providers.html) can be configured using `securityhub.ProductSubscription`.
	//
	// Available products can also be listed by running the AWS CLI command `aws securityhub describe-products`.
	//
	// A subset of currently available products (remember to replace `${var.region}` as appropriate) includes:
	//
	// * `arn:aws:securityhub:${var.region}::product/aws/guardduty`
	// * `arn:aws:securityhub:${var.region}::product/aws/inspector`
	// * `arn:aws:securityhub:${var.region}::product/aws/macie`
	// * `arn:aws:securityhub:${var.region}::product/alertlogic/althreatmanagement`
	// * `arn:aws:securityhub:${var.region}::product/armordefense/armoranywhere`
	// * `arn:aws:securityhub:${var.region}::product/barracuda/cloudsecurityguardian`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/cloudguard-iaas`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/dome9-arc`
	// * `arn:aws:securityhub:${var.region}::product/crowdstrike/crowdstrike-falcon`
	// * `arn:aws:securityhub:${var.region}::product/cyberark/cyberark-pta`
	// * `arn:aws:securityhub:${var.region}::product/f5networks/f5-advanced-waf`
	// * `arn:aws:securityhub:${var.region}::product/fortinet/fortigate`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/aws-infection-monkey`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/guardicore`
	// * `arn:aws:securityhub:${var.region}::product/ibm/qradar-siem`
	// * `arn:aws:securityhub:${var.region}::product/imperva/imperva-attack-analytics`
	// * `arn:aws:securityhub:${var.region}::product/mcafee-skyhigh/mcafee-mvision-cloud-aws`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/redlock`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/vm-series`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-pc`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-vm`
	// * `arn:aws:securityhub:${var.region}::product/rapid7/insightvm`
	// * `arn:aws:securityhub:${var.region}::product/sophos/sophos-server-protection`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-enterprise`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-phantom`
	// * `arn:aws:securityhub:${var.region}::product/sumologicinc/sumologic-mda`
	// * `arn:aws:securityhub:${var.region}::product/symantec-corp/symantec-cwp`
	// * `arn:aws:securityhub:${var.region}::product/tenable/tenable-io`
	// * `arn:aws:securityhub:${var.region}::product/trend-micro/deep-security`
	// * `arn:aws:securityhub:${var.region}::product/turbot/turbot`
	// * `arn:aws:securityhub:${var.region}::product/twistlock/twistlock-enterprise`
	ProductArn pulumi.StringPtrInput
}

func (ProductSubscriptionState) ElementType() reflect.Type {
	return reflect.TypeOf((*productSubscriptionState)(nil)).Elem()
}

type productSubscriptionArgs struct {
	// The ARN of the product that generates findings that you want to import into Security Hub - see below.
	//
	// Amazon maintains a list of [Product integrations in AWS Security Hub](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-providers.html) that changes over time. Any of the products on the linked [Available AWS service integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-internal-providers.html) or [Available third-party partner product integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-partner-providers.html) can be configured using `securityhub.ProductSubscription`.
	//
	// Available products can also be listed by running the AWS CLI command `aws securityhub describe-products`.
	//
	// A subset of currently available products (remember to replace `${var.region}` as appropriate) includes:
	//
	// * `arn:aws:securityhub:${var.region}::product/aws/guardduty`
	// * `arn:aws:securityhub:${var.region}::product/aws/inspector`
	// * `arn:aws:securityhub:${var.region}::product/aws/macie`
	// * `arn:aws:securityhub:${var.region}::product/alertlogic/althreatmanagement`
	// * `arn:aws:securityhub:${var.region}::product/armordefense/armoranywhere`
	// * `arn:aws:securityhub:${var.region}::product/barracuda/cloudsecurityguardian`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/cloudguard-iaas`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/dome9-arc`
	// * `arn:aws:securityhub:${var.region}::product/crowdstrike/crowdstrike-falcon`
	// * `arn:aws:securityhub:${var.region}::product/cyberark/cyberark-pta`
	// * `arn:aws:securityhub:${var.region}::product/f5networks/f5-advanced-waf`
	// * `arn:aws:securityhub:${var.region}::product/fortinet/fortigate`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/aws-infection-monkey`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/guardicore`
	// * `arn:aws:securityhub:${var.region}::product/ibm/qradar-siem`
	// * `arn:aws:securityhub:${var.region}::product/imperva/imperva-attack-analytics`
	// * `arn:aws:securityhub:${var.region}::product/mcafee-skyhigh/mcafee-mvision-cloud-aws`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/redlock`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/vm-series`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-pc`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-vm`
	// * `arn:aws:securityhub:${var.region}::product/rapid7/insightvm`
	// * `arn:aws:securityhub:${var.region}::product/sophos/sophos-server-protection`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-enterprise`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-phantom`
	// * `arn:aws:securityhub:${var.region}::product/sumologicinc/sumologic-mda`
	// * `arn:aws:securityhub:${var.region}::product/symantec-corp/symantec-cwp`
	// * `arn:aws:securityhub:${var.region}::product/tenable/tenable-io`
	// * `arn:aws:securityhub:${var.region}::product/trend-micro/deep-security`
	// * `arn:aws:securityhub:${var.region}::product/turbot/turbot`
	// * `arn:aws:securityhub:${var.region}::product/twistlock/twistlock-enterprise`
	ProductArn string `pulumi:"productArn"`
}

// The set of arguments for constructing a ProductSubscription resource.
type ProductSubscriptionArgs struct {
	// The ARN of the product that generates findings that you want to import into Security Hub - see below.
	//
	// Amazon maintains a list of [Product integrations in AWS Security Hub](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-providers.html) that changes over time. Any of the products on the linked [Available AWS service integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-internal-providers.html) or [Available third-party partner product integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-partner-providers.html) can be configured using `securityhub.ProductSubscription`.
	//
	// Available products can also be listed by running the AWS CLI command `aws securityhub describe-products`.
	//
	// A subset of currently available products (remember to replace `${var.region}` as appropriate) includes:
	//
	// * `arn:aws:securityhub:${var.region}::product/aws/guardduty`
	// * `arn:aws:securityhub:${var.region}::product/aws/inspector`
	// * `arn:aws:securityhub:${var.region}::product/aws/macie`
	// * `arn:aws:securityhub:${var.region}::product/alertlogic/althreatmanagement`
	// * `arn:aws:securityhub:${var.region}::product/armordefense/armoranywhere`
	// * `arn:aws:securityhub:${var.region}::product/barracuda/cloudsecurityguardian`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/cloudguard-iaas`
	// * `arn:aws:securityhub:${var.region}::product/checkpoint/dome9-arc`
	// * `arn:aws:securityhub:${var.region}::product/crowdstrike/crowdstrike-falcon`
	// * `arn:aws:securityhub:${var.region}::product/cyberark/cyberark-pta`
	// * `arn:aws:securityhub:${var.region}::product/f5networks/f5-advanced-waf`
	// * `arn:aws:securityhub:${var.region}::product/fortinet/fortigate`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/aws-infection-monkey`
	// * `arn:aws:securityhub:${var.region}::product/guardicore/guardicore`
	// * `arn:aws:securityhub:${var.region}::product/ibm/qradar-siem`
	// * `arn:aws:securityhub:${var.region}::product/imperva/imperva-attack-analytics`
	// * `arn:aws:securityhub:${var.region}::product/mcafee-skyhigh/mcafee-mvision-cloud-aws`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/redlock`
	// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/vm-series`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-pc`
	// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-vm`
	// * `arn:aws:securityhub:${var.region}::product/rapid7/insightvm`
	// * `arn:aws:securityhub:${var.region}::product/sophos/sophos-server-protection`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-enterprise`
	// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-phantom`
	// * `arn:aws:securityhub:${var.region}::product/sumologicinc/sumologic-mda`
	// * `arn:aws:securityhub:${var.region}::product/symantec-corp/symantec-cwp`
	// * `arn:aws:securityhub:${var.region}::product/tenable/tenable-io`
	// * `arn:aws:securityhub:${var.region}::product/trend-micro/deep-security`
	// * `arn:aws:securityhub:${var.region}::product/turbot/turbot`
	// * `arn:aws:securityhub:${var.region}::product/twistlock/twistlock-enterprise`
	ProductArn pulumi.StringInput
}

func (ProductSubscriptionArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*productSubscriptionArgs)(nil)).Elem()
}

type ProductSubscriptionInput interface {
	pulumi.Input

	ToProductSubscriptionOutput() ProductSubscriptionOutput
	ToProductSubscriptionOutputWithContext(ctx context.Context) ProductSubscriptionOutput
}

func (*ProductSubscription) ElementType() reflect.Type {
	return reflect.TypeOf((**ProductSubscription)(nil)).Elem()
}

func (i *ProductSubscription) ToProductSubscriptionOutput() ProductSubscriptionOutput {
	return i.ToProductSubscriptionOutputWithContext(context.Background())
}

func (i *ProductSubscription) ToProductSubscriptionOutputWithContext(ctx context.Context) ProductSubscriptionOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ProductSubscriptionOutput)
}

// ProductSubscriptionArrayInput is an input type that accepts ProductSubscriptionArray and ProductSubscriptionArrayOutput values.
// You can construct a concrete instance of `ProductSubscriptionArrayInput` via:
//
//	ProductSubscriptionArray{ ProductSubscriptionArgs{...} }
type ProductSubscriptionArrayInput interface {
	pulumi.Input

	ToProductSubscriptionArrayOutput() ProductSubscriptionArrayOutput
	ToProductSubscriptionArrayOutputWithContext(context.Context) ProductSubscriptionArrayOutput
}

type ProductSubscriptionArray []ProductSubscriptionInput

func (ProductSubscriptionArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ProductSubscription)(nil)).Elem()
}

func (i ProductSubscriptionArray) ToProductSubscriptionArrayOutput() ProductSubscriptionArrayOutput {
	return i.ToProductSubscriptionArrayOutputWithContext(context.Background())
}

func (i ProductSubscriptionArray) ToProductSubscriptionArrayOutputWithContext(ctx context.Context) ProductSubscriptionArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ProductSubscriptionArrayOutput)
}

// ProductSubscriptionMapInput is an input type that accepts ProductSubscriptionMap and ProductSubscriptionMapOutput values.
// You can construct a concrete instance of `ProductSubscriptionMapInput` via:
//
//	ProductSubscriptionMap{ "key": ProductSubscriptionArgs{...} }
type ProductSubscriptionMapInput interface {
	pulumi.Input

	ToProductSubscriptionMapOutput() ProductSubscriptionMapOutput
	ToProductSubscriptionMapOutputWithContext(context.Context) ProductSubscriptionMapOutput
}

type ProductSubscriptionMap map[string]ProductSubscriptionInput

func (ProductSubscriptionMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ProductSubscription)(nil)).Elem()
}

func (i ProductSubscriptionMap) ToProductSubscriptionMapOutput() ProductSubscriptionMapOutput {
	return i.ToProductSubscriptionMapOutputWithContext(context.Background())
}

func (i ProductSubscriptionMap) ToProductSubscriptionMapOutputWithContext(ctx context.Context) ProductSubscriptionMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ProductSubscriptionMapOutput)
}

type ProductSubscriptionOutput struct{ *pulumi.OutputState }

func (ProductSubscriptionOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ProductSubscription)(nil)).Elem()
}

func (o ProductSubscriptionOutput) ToProductSubscriptionOutput() ProductSubscriptionOutput {
	return o
}

func (o ProductSubscriptionOutput) ToProductSubscriptionOutputWithContext(ctx context.Context) ProductSubscriptionOutput {
	return o
}

// The ARN of a resource that represents your subscription to the product that generates the findings that you want to import into Security Hub.
func (o ProductSubscriptionOutput) Arn() pulumi.StringOutput {
	return o.ApplyT(func(v *ProductSubscription) pulumi.StringOutput { return v.Arn }).(pulumi.StringOutput)
}

// The ARN of the product that generates findings that you want to import into Security Hub - see below.
//
// Amazon maintains a list of [Product integrations in AWS Security Hub](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-findings-providers.html) that changes over time. Any of the products on the linked [Available AWS service integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-internal-providers.html) or [Available third-party partner product integrations](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-partner-providers.html) can be configured using `securityhub.ProductSubscription`.
//
// Available products can also be listed by running the AWS CLI command `aws securityhub describe-products`.
//
// A subset of currently available products (remember to replace `${var.region}` as appropriate) includes:
//
// * `arn:aws:securityhub:${var.region}::product/aws/guardduty`
// * `arn:aws:securityhub:${var.region}::product/aws/inspector`
// * `arn:aws:securityhub:${var.region}::product/aws/macie`
// * `arn:aws:securityhub:${var.region}::product/alertlogic/althreatmanagement`
// * `arn:aws:securityhub:${var.region}::product/armordefense/armoranywhere`
// * `arn:aws:securityhub:${var.region}::product/barracuda/cloudsecurityguardian`
// * `arn:aws:securityhub:${var.region}::product/checkpoint/cloudguard-iaas`
// * `arn:aws:securityhub:${var.region}::product/checkpoint/dome9-arc`
// * `arn:aws:securityhub:${var.region}::product/crowdstrike/crowdstrike-falcon`
// * `arn:aws:securityhub:${var.region}::product/cyberark/cyberark-pta`
// * `arn:aws:securityhub:${var.region}::product/f5networks/f5-advanced-waf`
// * `arn:aws:securityhub:${var.region}::product/fortinet/fortigate`
// * `arn:aws:securityhub:${var.region}::product/guardicore/aws-infection-monkey`
// * `arn:aws:securityhub:${var.region}::product/guardicore/guardicore`
// * `arn:aws:securityhub:${var.region}::product/ibm/qradar-siem`
// * `arn:aws:securityhub:${var.region}::product/imperva/imperva-attack-analytics`
// * `arn:aws:securityhub:${var.region}::product/mcafee-skyhigh/mcafee-mvision-cloud-aws`
// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/redlock`
// * `arn:aws:securityhub:${var.region}::product/paloaltonetworks/vm-series`
// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-pc`
// * `arn:aws:securityhub:${var.region}::product/qualys/qualys-vm`
// * `arn:aws:securityhub:${var.region}::product/rapid7/insightvm`
// * `arn:aws:securityhub:${var.region}::product/sophos/sophos-server-protection`
// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-enterprise`
// * `arn:aws:securityhub:${var.region}::product/splunk/splunk-phantom`
// * `arn:aws:securityhub:${var.region}::product/sumologicinc/sumologic-mda`
// * `arn:aws:securityhub:${var.region}::product/symantec-corp/symantec-cwp`
// * `arn:aws:securityhub:${var.region}::product/tenable/tenable-io`
// * `arn:aws:securityhub:${var.region}::product/trend-micro/deep-security`
// * `arn:aws:securityhub:${var.region}::product/turbot/turbot`
// * `arn:aws:securityhub:${var.region}::product/twistlock/twistlock-enterprise`
func (o ProductSubscriptionOutput) ProductArn() pulumi.StringOutput {
	return o.ApplyT(func(v *ProductSubscription) pulumi.StringOutput { return v.ProductArn }).(pulumi.StringOutput)
}

type ProductSubscriptionArrayOutput struct{ *pulumi.OutputState }

func (ProductSubscriptionArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ProductSubscription)(nil)).Elem()
}

func (o ProductSubscriptionArrayOutput) ToProductSubscriptionArrayOutput() ProductSubscriptionArrayOutput {
	return o
}

func (o ProductSubscriptionArrayOutput) ToProductSubscriptionArrayOutputWithContext(ctx context.Context) ProductSubscriptionArrayOutput {
	return o
}

func (o ProductSubscriptionArrayOutput) Index(i pulumi.IntInput) ProductSubscriptionOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ProductSubscription {
		return vs[0].([]*ProductSubscription)[vs[1].(int)]
	}).(ProductSubscriptionOutput)
}

type ProductSubscriptionMapOutput struct{ *pulumi.OutputState }

func (ProductSubscriptionMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ProductSubscription)(nil)).Elem()
}

func (o ProductSubscriptionMapOutput) ToProductSubscriptionMapOutput() ProductSubscriptionMapOutput {
	return o
}

func (o ProductSubscriptionMapOutput) ToProductSubscriptionMapOutputWithContext(ctx context.Context) ProductSubscriptionMapOutput {
	return o
}

func (o ProductSubscriptionMapOutput) MapIndex(k pulumi.StringInput) ProductSubscriptionOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ProductSubscription {
		return vs[0].(map[string]*ProductSubscription)[vs[1].(string)]
	}).(ProductSubscriptionOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ProductSubscriptionInput)(nil)).Elem(), &ProductSubscription{})
	pulumi.RegisterInputType(reflect.TypeOf((*ProductSubscriptionArrayInput)(nil)).Elem(), ProductSubscriptionArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ProductSubscriptionMapInput)(nil)).Elem(), ProductSubscriptionMap{})
	pulumi.RegisterOutputType(ProductSubscriptionOutput{})
	pulumi.RegisterOutputType(ProductSubscriptionArrayOutput{})
	pulumi.RegisterOutputType(ProductSubscriptionMapOutput{})
}
