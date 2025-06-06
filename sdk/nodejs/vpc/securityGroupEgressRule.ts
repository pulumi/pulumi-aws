// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Manages an outbound (egress) rule for a security group.
 *
 * When specifying an outbound rule for your security group in a VPC, the configuration must include a destination for the traffic.
 *
 * > **NOTE:** Using `aws.vpc.SecurityGroupEgressRule` and `aws.vpc.SecurityGroupIngressRule` resources is the current best practice. Avoid using the `aws.ec2.SecurityGroupRule` resource and the `ingress` and `egress` arguments of the `aws.ec2.SecurityGroup` resource for configuring in-line rules, as they struggle with managing multiple CIDR blocks, and tags and descriptions due to the historical lack of unique IDs.
 *
 * !> **WARNING:** You should not use the `aws.vpc.SecurityGroupEgressRule` and `aws.vpc.SecurityGroupIngressRule` resources in conjunction with the `aws.ec2.SecurityGroup` resource with _in-line rules_ (using the `ingress` and `egress` arguments of `aws.ec2.SecurityGroup`) or the `aws.ec2.SecurityGroupRule` resource. Doing so may cause rule conflicts, perpetual differences, and result in rules being overwritten.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.vpc.SecurityGroupEgressRule("example", {
 *     securityGroupId: exampleAwsSecurityGroup.id,
 *     cidrIpv4: "10.0.0.0/8",
 *     fromPort: 80,
 *     ipProtocol: "tcp",
 *     toPort: 80,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import security group egress rules using the `security_group_rule_id`. For example:
 *
 * ```sh
 * $ pulumi import aws:vpc/securityGroupEgressRule:SecurityGroupEgressRule example sgr-02108b27edd666983
 * ```
 */
export class SecurityGroupEgressRule extends pulumi.CustomResource {
    /**
     * Get an existing SecurityGroupEgressRule resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: SecurityGroupEgressRuleState, opts?: pulumi.CustomResourceOptions): SecurityGroupEgressRule {
        return new SecurityGroupEgressRule(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:vpc/securityGroupEgressRule:SecurityGroupEgressRule';

    /**
     * Returns true if the given object is an instance of SecurityGroupEgressRule.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is SecurityGroupEgressRule {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === SecurityGroupEgressRule.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) of the security group rule.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The destination IPv4 CIDR range.
     */
    public readonly cidrIpv4!: pulumi.Output<string | undefined>;
    /**
     * The destination IPv6 CIDR range.
     */
    public readonly cidrIpv6!: pulumi.Output<string | undefined>;
    /**
     * The security group rule description.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The start of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 type.
     */
    public readonly fromPort!: pulumi.Output<number | undefined>;
    /**
     * The IP protocol name or number. Use `-1` to specify all protocols. Note that if `ipProtocol` is set to `-1`, it translates to all protocols, all port ranges, and `fromPort` and `toPort` values should not be defined.
     */
    public readonly ipProtocol!: pulumi.Output<string>;
    /**
     * The ID of the destination prefix list.
     */
    public readonly prefixListId!: pulumi.Output<string | undefined>;
    /**
     * The destination security group that is referenced in the rule.
     */
    public readonly referencedSecurityGroupId!: pulumi.Output<string | undefined>;
    /**
     * The ID of the security group.
     */
    public readonly securityGroupId!: pulumi.Output<string>;
    /**
     * The ID of the security group rule.
     */
    public /*out*/ readonly securityGroupRuleId!: pulumi.Output<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The end of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 code.
     *
     * > **Note** Although `cidrIpv4`, `cidrIpv6`, `prefixListId`, and `referencedSecurityGroupId` are all marked as optional, you *must* provide one of them in order to configure the destination of the traffic. The `fromPort` and `toPort` arguments are required unless `ipProtocol` is set to `-1` or `icmpv6`.
     */
    public readonly toPort!: pulumi.Output<number | undefined>;

    /**
     * Create a SecurityGroupEgressRule resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: SecurityGroupEgressRuleArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: SecurityGroupEgressRuleArgs | SecurityGroupEgressRuleState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as SecurityGroupEgressRuleState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["cidrIpv4"] = state ? state.cidrIpv4 : undefined;
            resourceInputs["cidrIpv6"] = state ? state.cidrIpv6 : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["fromPort"] = state ? state.fromPort : undefined;
            resourceInputs["ipProtocol"] = state ? state.ipProtocol : undefined;
            resourceInputs["prefixListId"] = state ? state.prefixListId : undefined;
            resourceInputs["referencedSecurityGroupId"] = state ? state.referencedSecurityGroupId : undefined;
            resourceInputs["securityGroupId"] = state ? state.securityGroupId : undefined;
            resourceInputs["securityGroupRuleId"] = state ? state.securityGroupRuleId : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["toPort"] = state ? state.toPort : undefined;
        } else {
            const args = argsOrState as SecurityGroupEgressRuleArgs | undefined;
            if ((!args || args.ipProtocol === undefined) && !opts.urn) {
                throw new Error("Missing required property 'ipProtocol'");
            }
            if ((!args || args.securityGroupId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'securityGroupId'");
            }
            resourceInputs["cidrIpv4"] = args ? args.cidrIpv4 : undefined;
            resourceInputs["cidrIpv6"] = args ? args.cidrIpv6 : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["fromPort"] = args ? args.fromPort : undefined;
            resourceInputs["ipProtocol"] = args ? args.ipProtocol : undefined;
            resourceInputs["prefixListId"] = args ? args.prefixListId : undefined;
            resourceInputs["referencedSecurityGroupId"] = args ? args.referencedSecurityGroupId : undefined;
            resourceInputs["securityGroupId"] = args ? args.securityGroupId : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["toPort"] = args ? args.toPort : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["securityGroupRuleId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(SecurityGroupEgressRule.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering SecurityGroupEgressRule resources.
 */
export interface SecurityGroupEgressRuleState {
    /**
     * The Amazon Resource Name (ARN) of the security group rule.
     */
    arn?: pulumi.Input<string>;
    /**
     * The destination IPv4 CIDR range.
     */
    cidrIpv4?: pulumi.Input<string>;
    /**
     * The destination IPv6 CIDR range.
     */
    cidrIpv6?: pulumi.Input<string>;
    /**
     * The security group rule description.
     */
    description?: pulumi.Input<string>;
    /**
     * The start of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 type.
     */
    fromPort?: pulumi.Input<number>;
    /**
     * The IP protocol name or number. Use `-1` to specify all protocols. Note that if `ipProtocol` is set to `-1`, it translates to all protocols, all port ranges, and `fromPort` and `toPort` values should not be defined.
     */
    ipProtocol?: pulumi.Input<string>;
    /**
     * The ID of the destination prefix list.
     */
    prefixListId?: pulumi.Input<string>;
    /**
     * The destination security group that is referenced in the rule.
     */
    referencedSecurityGroupId?: pulumi.Input<string>;
    /**
     * The ID of the security group.
     */
    securityGroupId?: pulumi.Input<string>;
    /**
     * The ID of the security group rule.
     */
    securityGroupRuleId?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The end of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 code.
     *
     * > **Note** Although `cidrIpv4`, `cidrIpv6`, `prefixListId`, and `referencedSecurityGroupId` are all marked as optional, you *must* provide one of them in order to configure the destination of the traffic. The `fromPort` and `toPort` arguments are required unless `ipProtocol` is set to `-1` or `icmpv6`.
     */
    toPort?: pulumi.Input<number>;
}

/**
 * The set of arguments for constructing a SecurityGroupEgressRule resource.
 */
export interface SecurityGroupEgressRuleArgs {
    /**
     * The destination IPv4 CIDR range.
     */
    cidrIpv4?: pulumi.Input<string>;
    /**
     * The destination IPv6 CIDR range.
     */
    cidrIpv6?: pulumi.Input<string>;
    /**
     * The security group rule description.
     */
    description?: pulumi.Input<string>;
    /**
     * The start of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 type.
     */
    fromPort?: pulumi.Input<number>;
    /**
     * The IP protocol name or number. Use `-1` to specify all protocols. Note that if `ipProtocol` is set to `-1`, it translates to all protocols, all port ranges, and `fromPort` and `toPort` values should not be defined.
     */
    ipProtocol: pulumi.Input<string>;
    /**
     * The ID of the destination prefix list.
     */
    prefixListId?: pulumi.Input<string>;
    /**
     * The destination security group that is referenced in the rule.
     */
    referencedSecurityGroupId?: pulumi.Input<string>;
    /**
     * The ID of the security group.
     */
    securityGroupId: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The end of port range for the TCP and UDP protocols, or an ICMP/ICMPv6 code.
     *
     * > **Note** Although `cidrIpv4`, `cidrIpv6`, `prefixListId`, and `referencedSecurityGroupId` are all marked as optional, you *must* provide one of them in order to configure the destination of the traffic. The `fromPort` and `toPort` arguments are required unless `ipProtocol` is set to `-1` or `icmpv6`.
     */
    toPort?: pulumi.Input<number>;
}
