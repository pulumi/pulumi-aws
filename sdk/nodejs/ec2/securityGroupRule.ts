// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a security group rule resource. Represents a single `ingress` or `egress` group rule, which can be added to external Security Groups.
 *
 * > **NOTE:** Avoid using the `aws.ec2.SecurityGroupRule` resource, as it struggles with managing multiple CIDR blocks, and, due to the historical lack of unique IDs, tags and descriptions. To avoid these problems, use the current best practice of the `aws.vpc.SecurityGroupEgressRule` and `aws.vpc.SecurityGroupIngressRule` resources with one CIDR block per rule.
 *
 * !> **WARNING:** You should not use the `aws.ec2.SecurityGroupRule` resource in conjunction with `aws.vpc.SecurityGroupEgressRule` and `aws.vpc.SecurityGroupIngressRule` resources or with an `aws.ec2.SecurityGroup` resource that has in-line rules. Doing so may cause rule conflicts, perpetual differences, and result in rules being overwritten.
 *
 * > **NOTE:** Setting `protocol = "all"` or `protocol = -1` with `fromPort` and `toPort` will result in the EC2 API creating a security group rule with all ports open. This API behavior cannot be controlled by this provider and may generate warnings in the future.
 *
 * > **NOTE:** Referencing Security Groups across VPC peering has certain restrictions. More information is available in the [VPC Peering User Guide](https://docs.aws.amazon.com/vpc/latest/peering/vpc-peering-security-groups.html).
 *
 * ## Example Usage
 *
 * Basic usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2.SecurityGroupRule("example", {
 *     type: "ingress",
 *     fromPort: 0,
 *     toPort: 65535,
 *     protocol: aws.ec2.ProtocolType.TCP,
 *     cidrBlocks: [exampleAwsVpc.cidrBlock],
 *     ipv6CidrBlocks: [exampleAwsVpc.ipv6CidrBlock],
 *     securityGroupId: "sg-123456",
 * });
 * ```
 *
 * ### Usage With Prefix List IDs
 *
 * Prefix Lists are either managed by AWS internally, or created by the customer using a
 * Managed Prefix List resource. Prefix Lists provided by
 * AWS are associated with a prefix list name, or service name, that is linked to a specific region.
 *
 * Prefix list IDs are exported on VPC Endpoints, so you can use this format:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * // ...
 * const myEndpoint = new aws.ec2.VpcEndpoint("my_endpoint", {});
 * const allowAll = new aws.ec2.SecurityGroupRule("allow_all", {
 *     type: "egress",
 *     toPort: 0,
 *     protocol: "-1",
 *     prefixListIds: [myEndpoint.prefixListId],
 *     fromPort: 0,
 *     securityGroupId: "sg-123456",
 * });
 * ```
 *
 * You can also find a specific Prefix List using the `aws.ec2.getPrefixList`
 * or `ec2ManagedPrefixList` data sources:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getRegion({});
 * const s3 = current.then(current => aws.ec2.getPrefixList({
 *     name: `com.amazonaws.${current.name}.s3`,
 * }));
 * const s3GatewayEgress = new aws.ec2.SecurityGroupRule("s3_gateway_egress", {
 *     description: "S3 Gateway Egress",
 *     type: "egress",
 *     securityGroupId: "sg-123456",
 *     fromPort: 443,
 *     toPort: 443,
 *     protocol: aws.ec2.ProtocolType.TCP,
 *     prefixListIds: [s3.then(s3 => s3.id)],
 * });
 * ```
 *
 * ## Import
 *
 * Import a rule with various IPv4 and IPv6 source CIDR blocks:
 *
 * Import a rule, applicable to all ports, with a protocol other than TCP/UDP/ICMP/ICMPV6/ALL, e.g., Multicast Transport Protocol (MTP), using the IANA protocol number. For example: 92.
 *
 * Import a default any/any egress rule to 0.0.0.0/0:
 *
 * Import an egress rule with a prefix list ID destination:
 *
 * Import a rule applicable to all protocols and ports with a security group source:
 *
 * Import a rule that has itself and an IPv6 CIDR block as sources:
 *
 * __Using `pulumi import` to import__ Security Group Rules using the `security_group_id`, `type`, `protocol`, `from_port`, `to_port`, and source(s)/destination(s) (such as a `cidr_block`) separated by underscores (`_`). All parts are required. For example:
 *
 * __NOTE:__ Not all rule permissions (e.g., not all of a rule's CIDR blocks) need to be imported for this provider to manage rule permissions. However, importing some of a rule's permissions but not others, and then making changes to the rule will result in the creation of an additional rule to capture the updated permissions. Rule permissions that were not imported are left intact in the original rule.
 *
 * Import an ingress rule in security group `sg-6e616f6d69` for TCP port 8000 with an IPv4 destination CIDR of `10.0.3.0/24`:
 *
 * ```sh
 * $ pulumi import aws:ec2/securityGroupRule:SecurityGroupRule ingress sg-6e616f6d69_ingress_tcp_8000_8000_10.0.3.0/24
 * ```
 * Import a rule with various IPv4 and IPv6 source CIDR blocks:
 *
 * ```sh
 * $ pulumi import aws:ec2/securityGroupRule:SecurityGroupRule ingress sg-4973616163_ingress_tcp_100_121_10.1.0.0/16_2001:db8::/48_10.2.0.0/16_2002:db8::/48
 * ```
 * Import a rule, applicable to all ports, with a protocol other than TCP/UDP/ICMP/ICMPV6/ALL, e.g., Multicast Transport Protocol (MTP), using the IANA protocol number. For example: 92.
 *
 * ```sh
 * $ pulumi import aws:ec2/securityGroupRule:SecurityGroupRule ingress sg-6777656e646f6c796e_ingress_92_0_65536_10.0.3.0/24_10.0.4.0/24
 * ```
 * Import a default any/any egress rule to 0.0.0.0/0:
 *
 * ```sh
 * $ pulumi import aws:ec2/securityGroupRule:SecurityGroupRule default_egress sg-6777656e646f6c796e_egress_all_0_0_0.0.0.0/0
 * ```
 * Import an egress rule with a prefix list ID destination:
 *
 * ```sh
 * $ pulumi import aws:ec2/securityGroupRule:SecurityGroupRule egress sg-62726f6479_egress_tcp_8000_8000_pl-6469726b
 * ```
 * Import a rule applicable to all protocols and ports with a security group source:
 *
 * ```sh
 * $ pulumi import aws:ec2/securityGroupRule:SecurityGroupRule ingress_rule sg-7472697374616e_ingress_all_0_65536_sg-6176657279
 * ```
 * Import a rule that has itself and an IPv6 CIDR block as sources:
 *
 * ```sh
 * $ pulumi import aws:ec2/securityGroupRule:SecurityGroupRule rule_name sg-656c65616e6f72_ingress_tcp_80_80_self_2001:db8::/48
 * ```
 */
export class SecurityGroupRule extends pulumi.CustomResource {
    /**
     * Get an existing SecurityGroupRule resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: SecurityGroupRuleState, opts?: pulumi.CustomResourceOptions): SecurityGroupRule {
        return new SecurityGroupRule(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/securityGroupRule:SecurityGroupRule';

    /**
     * Returns true if the given object is an instance of SecurityGroupRule.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is SecurityGroupRule {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === SecurityGroupRule.__pulumiType;
    }

    /**
     * List of CIDR blocks. Cannot be specified with `sourceSecurityGroupId` or `self`.
     */
    public readonly cidrBlocks!: pulumi.Output<string[] | undefined>;
    /**
     * Description of the rule.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Start port (or ICMP type number if protocol is "icmp" or "icmpv6").
     */
    public readonly fromPort!: pulumi.Output<number>;
    /**
     * List of IPv6 CIDR blocks. Cannot be specified with `sourceSecurityGroupId` or `self`.
     */
    public readonly ipv6CidrBlocks!: pulumi.Output<string[] | undefined>;
    /**
     * List of Prefix List IDs.
     */
    public readonly prefixListIds!: pulumi.Output<string[] | undefined>;
    /**
     * Protocol. If not icmp, icmpv6, tcp, udp, or all use the [protocol number](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml)
     */
    public readonly protocol!: pulumi.Output<string>;
    /**
     * Security group to apply this rule to.
     */
    public readonly securityGroupId!: pulumi.Output<string>;
    /**
     * If the `aws.ec2.SecurityGroupRule` resource has a single source or destination then this is the AWS Security Group Rule resource ID. Otherwise it is empty.
     */
    public /*out*/ readonly securityGroupRuleId!: pulumi.Output<string>;
    /**
     * Whether the security group itself will be added as a source to this ingress rule. Cannot be specified with `cidrBlocks`, `ipv6CidrBlocks`, or `sourceSecurityGroupId`.
     */
    public readonly self!: pulumi.Output<boolean | undefined>;
    /**
     * Security group id to allow access to/from, depending on the `type`. Cannot be specified with `cidrBlocks`, `ipv6CidrBlocks`, or `self`.
     */
    public readonly sourceSecurityGroupId!: pulumi.Output<string>;
    /**
     * End port (or ICMP code if protocol is "icmp").
     */
    public readonly toPort!: pulumi.Output<number>;
    /**
     * Type of rule being created. Valid options are `ingress` (inbound)
     * or `egress` (outbound).
     *
     * The following arguments are optional:
     *
     * > **Note** Although `cidrBlocks`, `ipv6CidrBlocks`, `prefixListIds`, and `sourceSecurityGroupId` are all marked as optional, you _must_ provide one of them in order to configure the source of the traffic.
     */
    public readonly type!: pulumi.Output<string>;

    /**
     * Create a SecurityGroupRule resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: SecurityGroupRuleArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: SecurityGroupRuleArgs | SecurityGroupRuleState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as SecurityGroupRuleState | undefined;
            resourceInputs["cidrBlocks"] = state ? state.cidrBlocks : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["fromPort"] = state ? state.fromPort : undefined;
            resourceInputs["ipv6CidrBlocks"] = state ? state.ipv6CidrBlocks : undefined;
            resourceInputs["prefixListIds"] = state ? state.prefixListIds : undefined;
            resourceInputs["protocol"] = state ? state.protocol : undefined;
            resourceInputs["securityGroupId"] = state ? state.securityGroupId : undefined;
            resourceInputs["securityGroupRuleId"] = state ? state.securityGroupRuleId : undefined;
            resourceInputs["self"] = state ? state.self : undefined;
            resourceInputs["sourceSecurityGroupId"] = state ? state.sourceSecurityGroupId : undefined;
            resourceInputs["toPort"] = state ? state.toPort : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
        } else {
            const args = argsOrState as SecurityGroupRuleArgs | undefined;
            if ((!args || args.fromPort === undefined) && !opts.urn) {
                throw new Error("Missing required property 'fromPort'");
            }
            if ((!args || args.protocol === undefined) && !opts.urn) {
                throw new Error("Missing required property 'protocol'");
            }
            if ((!args || args.securityGroupId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'securityGroupId'");
            }
            if ((!args || args.toPort === undefined) && !opts.urn) {
                throw new Error("Missing required property 'toPort'");
            }
            if ((!args || args.type === undefined) && !opts.urn) {
                throw new Error("Missing required property 'type'");
            }
            resourceInputs["cidrBlocks"] = args ? args.cidrBlocks : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["fromPort"] = args ? args.fromPort : undefined;
            resourceInputs["ipv6CidrBlocks"] = args ? args.ipv6CidrBlocks : undefined;
            resourceInputs["prefixListIds"] = args ? args.prefixListIds : undefined;
            resourceInputs["protocol"] = args ? args.protocol : undefined;
            resourceInputs["securityGroupId"] = args ? args.securityGroupId : undefined;
            resourceInputs["self"] = args ? args.self : undefined;
            resourceInputs["sourceSecurityGroupId"] = args ? args.sourceSecurityGroupId : undefined;
            resourceInputs["toPort"] = args ? args.toPort : undefined;
            resourceInputs["type"] = args ? args.type : undefined;
            resourceInputs["securityGroupRuleId"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(SecurityGroupRule.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering SecurityGroupRule resources.
 */
export interface SecurityGroupRuleState {
    /**
     * List of CIDR blocks. Cannot be specified with `sourceSecurityGroupId` or `self`.
     */
    cidrBlocks?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Description of the rule.
     */
    description?: pulumi.Input<string>;
    /**
     * Start port (or ICMP type number if protocol is "icmp" or "icmpv6").
     */
    fromPort?: pulumi.Input<number>;
    /**
     * List of IPv6 CIDR blocks. Cannot be specified with `sourceSecurityGroupId` or `self`.
     */
    ipv6CidrBlocks?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * List of Prefix List IDs.
     */
    prefixListIds?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Protocol. If not icmp, icmpv6, tcp, udp, or all use the [protocol number](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml)
     */
    protocol?: pulumi.Input<string | enums.ec2.ProtocolType>;
    /**
     * Security group to apply this rule to.
     */
    securityGroupId?: pulumi.Input<string>;
    /**
     * If the `aws.ec2.SecurityGroupRule` resource has a single source or destination then this is the AWS Security Group Rule resource ID. Otherwise it is empty.
     */
    securityGroupRuleId?: pulumi.Input<string>;
    /**
     * Whether the security group itself will be added as a source to this ingress rule. Cannot be specified with `cidrBlocks`, `ipv6CidrBlocks`, or `sourceSecurityGroupId`.
     */
    self?: pulumi.Input<boolean>;
    /**
     * Security group id to allow access to/from, depending on the `type`. Cannot be specified with `cidrBlocks`, `ipv6CidrBlocks`, or `self`.
     */
    sourceSecurityGroupId?: pulumi.Input<string>;
    /**
     * End port (or ICMP code if protocol is "icmp").
     */
    toPort?: pulumi.Input<number>;
    /**
     * Type of rule being created. Valid options are `ingress` (inbound)
     * or `egress` (outbound).
     *
     * The following arguments are optional:
     *
     * > **Note** Although `cidrBlocks`, `ipv6CidrBlocks`, `prefixListIds`, and `sourceSecurityGroupId` are all marked as optional, you _must_ provide one of them in order to configure the source of the traffic.
     */
    type?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a SecurityGroupRule resource.
 */
export interface SecurityGroupRuleArgs {
    /**
     * List of CIDR blocks. Cannot be specified with `sourceSecurityGroupId` or `self`.
     */
    cidrBlocks?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Description of the rule.
     */
    description?: pulumi.Input<string>;
    /**
     * Start port (or ICMP type number if protocol is "icmp" or "icmpv6").
     */
    fromPort: pulumi.Input<number>;
    /**
     * List of IPv6 CIDR blocks. Cannot be specified with `sourceSecurityGroupId` or `self`.
     */
    ipv6CidrBlocks?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * List of Prefix List IDs.
     */
    prefixListIds?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Protocol. If not icmp, icmpv6, tcp, udp, or all use the [protocol number](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml)
     */
    protocol: pulumi.Input<string | enums.ec2.ProtocolType>;
    /**
     * Security group to apply this rule to.
     */
    securityGroupId: pulumi.Input<string>;
    /**
     * Whether the security group itself will be added as a source to this ingress rule. Cannot be specified with `cidrBlocks`, `ipv6CidrBlocks`, or `sourceSecurityGroupId`.
     */
    self?: pulumi.Input<boolean>;
    /**
     * Security group id to allow access to/from, depending on the `type`. Cannot be specified with `cidrBlocks`, `ipv6CidrBlocks`, or `self`.
     */
    sourceSecurityGroupId?: pulumi.Input<string>;
    /**
     * End port (or ICMP code if protocol is "icmp").
     */
    toPort: pulumi.Input<number>;
    /**
     * Type of rule being created. Valid options are `ingress` (inbound)
     * or `egress` (outbound).
     *
     * The following arguments are optional:
     *
     * > **Note** Although `cidrBlocks`, `ipv6CidrBlocks`, `prefixListIds`, and `sourceSecurityGroupId` are all marked as optional, you _must_ provide one of them in order to configure the source of the traffic.
     */
    type: pulumi.Input<string>;
}
