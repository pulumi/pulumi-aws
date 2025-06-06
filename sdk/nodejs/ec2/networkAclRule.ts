// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Creates an entry (a rule) in a network ACL with the specified rule number.
 *
 * > **NOTE on Network ACLs and Network ACL Rules:** This provider currently
 * provides both a standalone Network ACL Rule resource and a Network ACL resource with rules
 * defined in-line. At this time you cannot use a Network ACL with in-line rules
 * in conjunction with any Network ACL Rule resources. Doing so will cause
 * a conflict of rule settings and will overwrite rules.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const bar = new aws.ec2.NetworkAcl("bar", {vpcId: foo.id});
 * const barNetworkAclRule = new aws.ec2.NetworkAclRule("bar", {
 *     networkAclId: bar.id,
 *     ruleNumber: 200,
 *     egress: false,
 *     protocol: "tcp",
 *     ruleAction: "allow",
 *     cidrBlock: foo.cidrBlock,
 *     fromPort: 22,
 *     toPort: 22,
 * });
 * ```
 *
 * > **Note:** One of either `cidrBlock` or `ipv6CidrBlock` is required.
 *
 * ## Import
 *
 * Using the procotol's decimal value:
 *
 * __Using `pulumi import` to import__ individual rules using `NETWORK_ACL_ID:RULE_NUMBER:PROTOCOL:EGRESS`, where `PROTOCOL` can be a decimal (such as "6") or string (such as "tcp") value. For example:
 *
 * Using the procotol's string value:
 *
 * ```sh
 * $ pulumi import aws:ec2/networkAclRule:NetworkAclRule my_rule acl-7aaabd18:100:tcp:false
 * ```
 * Using the procotol's decimal value:
 *
 * ```sh
 * $ pulumi import aws:ec2/networkAclRule:NetworkAclRule my_rule acl-7aaabd18:100:6:false
 * ```
 */
export class NetworkAclRule extends pulumi.CustomResource {
    /**
     * Get an existing NetworkAclRule resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: NetworkAclRuleState, opts?: pulumi.CustomResourceOptions): NetworkAclRule {
        return new NetworkAclRule(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/networkAclRule:NetworkAclRule';

    /**
     * Returns true if the given object is an instance of NetworkAclRule.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is NetworkAclRule {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === NetworkAclRule.__pulumiType;
    }

    /**
     * The network range to allow or deny, in CIDR notation (for example 172.16.0.0/24 ).
     */
    public readonly cidrBlock!: pulumi.Output<string | undefined>;
    /**
     * Indicates whether this is an egress rule (rule is applied to traffic leaving the subnet). Default `false`.
     */
    public readonly egress!: pulumi.Output<boolean | undefined>;
    /**
     * The from port to match.
     */
    public readonly fromPort!: pulumi.Output<number | undefined>;
    /**
     * ICMP protocol: The ICMP code. Required if specifying ICMP for the protocolE.g., -1
     *
     * > **NOTE:** If the value of `protocol` is `-1` or `all`, the `fromPort` and `toPort` values will be ignored and the rule will apply to all ports.
     *
     * > **NOTE:** If the value of `icmpType` is `-1` (which results in a wildcard ICMP type), the `icmpCode` must also be set to `-1` (wildcard ICMP code).
     *
     * > Note: For more information on ICMP types and codes, see here: https://www.iana.org/assignments/icmp-parameters/icmp-parameters.xhtml
     */
    public readonly icmpCode!: pulumi.Output<number | undefined>;
    /**
     * ICMP protocol: The ICMP type. Required if specifying ICMP for the protocolE.g., -1
     */
    public readonly icmpType!: pulumi.Output<number | undefined>;
    /**
     * The IPv6 CIDR block to allow or deny.
     */
    public readonly ipv6CidrBlock!: pulumi.Output<string | undefined>;
    /**
     * The ID of the network ACL.
     */
    public readonly networkAclId!: pulumi.Output<string>;
    /**
     * The protocol. A value of -1 means all protocols.
     */
    public readonly protocol!: pulumi.Output<string>;
    /**
     * Indicates whether to allow or deny the traffic that matches the rule. Accepted values: `allow` | `deny`
     */
    public readonly ruleAction!: pulumi.Output<string>;
    /**
     * The rule number for the entry (for example, 100). ACL entries are processed in ascending order by rule number.
     */
    public readonly ruleNumber!: pulumi.Output<number>;
    /**
     * The to port to match.
     */
    public readonly toPort!: pulumi.Output<number | undefined>;

    /**
     * Create a NetworkAclRule resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: NetworkAclRuleArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: NetworkAclRuleArgs | NetworkAclRuleState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as NetworkAclRuleState | undefined;
            resourceInputs["cidrBlock"] = state ? state.cidrBlock : undefined;
            resourceInputs["egress"] = state ? state.egress : undefined;
            resourceInputs["fromPort"] = state ? state.fromPort : undefined;
            resourceInputs["icmpCode"] = state ? state.icmpCode : undefined;
            resourceInputs["icmpType"] = state ? state.icmpType : undefined;
            resourceInputs["ipv6CidrBlock"] = state ? state.ipv6CidrBlock : undefined;
            resourceInputs["networkAclId"] = state ? state.networkAclId : undefined;
            resourceInputs["protocol"] = state ? state.protocol : undefined;
            resourceInputs["ruleAction"] = state ? state.ruleAction : undefined;
            resourceInputs["ruleNumber"] = state ? state.ruleNumber : undefined;
            resourceInputs["toPort"] = state ? state.toPort : undefined;
        } else {
            const args = argsOrState as NetworkAclRuleArgs | undefined;
            if ((!args || args.networkAclId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'networkAclId'");
            }
            if ((!args || args.protocol === undefined) && !opts.urn) {
                throw new Error("Missing required property 'protocol'");
            }
            if ((!args || args.ruleAction === undefined) && !opts.urn) {
                throw new Error("Missing required property 'ruleAction'");
            }
            if ((!args || args.ruleNumber === undefined) && !opts.urn) {
                throw new Error("Missing required property 'ruleNumber'");
            }
            resourceInputs["cidrBlock"] = args ? args.cidrBlock : undefined;
            resourceInputs["egress"] = args ? args.egress : undefined;
            resourceInputs["fromPort"] = args ? args.fromPort : undefined;
            resourceInputs["icmpCode"] = args ? args.icmpCode : undefined;
            resourceInputs["icmpType"] = args ? args.icmpType : undefined;
            resourceInputs["ipv6CidrBlock"] = args ? args.ipv6CidrBlock : undefined;
            resourceInputs["networkAclId"] = args ? args.networkAclId : undefined;
            resourceInputs["protocol"] = args ? args.protocol : undefined;
            resourceInputs["ruleAction"] = args ? args.ruleAction : undefined;
            resourceInputs["ruleNumber"] = args ? args.ruleNumber : undefined;
            resourceInputs["toPort"] = args ? args.toPort : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(NetworkAclRule.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering NetworkAclRule resources.
 */
export interface NetworkAclRuleState {
    /**
     * The network range to allow or deny, in CIDR notation (for example 172.16.0.0/24 ).
     */
    cidrBlock?: pulumi.Input<string>;
    /**
     * Indicates whether this is an egress rule (rule is applied to traffic leaving the subnet). Default `false`.
     */
    egress?: pulumi.Input<boolean>;
    /**
     * The from port to match.
     */
    fromPort?: pulumi.Input<number>;
    /**
     * ICMP protocol: The ICMP code. Required if specifying ICMP for the protocolE.g., -1
     *
     * > **NOTE:** If the value of `protocol` is `-1` or `all`, the `fromPort` and `toPort` values will be ignored and the rule will apply to all ports.
     *
     * > **NOTE:** If the value of `icmpType` is `-1` (which results in a wildcard ICMP type), the `icmpCode` must also be set to `-1` (wildcard ICMP code).
     *
     * > Note: For more information on ICMP types and codes, see here: https://www.iana.org/assignments/icmp-parameters/icmp-parameters.xhtml
     */
    icmpCode?: pulumi.Input<number>;
    /**
     * ICMP protocol: The ICMP type. Required if specifying ICMP for the protocolE.g., -1
     */
    icmpType?: pulumi.Input<number>;
    /**
     * The IPv6 CIDR block to allow or deny.
     */
    ipv6CidrBlock?: pulumi.Input<string>;
    /**
     * The ID of the network ACL.
     */
    networkAclId?: pulumi.Input<string>;
    /**
     * The protocol. A value of -1 means all protocols.
     */
    protocol?: pulumi.Input<string>;
    /**
     * Indicates whether to allow or deny the traffic that matches the rule. Accepted values: `allow` | `deny`
     */
    ruleAction?: pulumi.Input<string>;
    /**
     * The rule number for the entry (for example, 100). ACL entries are processed in ascending order by rule number.
     */
    ruleNumber?: pulumi.Input<number>;
    /**
     * The to port to match.
     */
    toPort?: pulumi.Input<number>;
}

/**
 * The set of arguments for constructing a NetworkAclRule resource.
 */
export interface NetworkAclRuleArgs {
    /**
     * The network range to allow or deny, in CIDR notation (for example 172.16.0.0/24 ).
     */
    cidrBlock?: pulumi.Input<string>;
    /**
     * Indicates whether this is an egress rule (rule is applied to traffic leaving the subnet). Default `false`.
     */
    egress?: pulumi.Input<boolean>;
    /**
     * The from port to match.
     */
    fromPort?: pulumi.Input<number>;
    /**
     * ICMP protocol: The ICMP code. Required if specifying ICMP for the protocolE.g., -1
     *
     * > **NOTE:** If the value of `protocol` is `-1` or `all`, the `fromPort` and `toPort` values will be ignored and the rule will apply to all ports.
     *
     * > **NOTE:** If the value of `icmpType` is `-1` (which results in a wildcard ICMP type), the `icmpCode` must also be set to `-1` (wildcard ICMP code).
     *
     * > Note: For more information on ICMP types and codes, see here: https://www.iana.org/assignments/icmp-parameters/icmp-parameters.xhtml
     */
    icmpCode?: pulumi.Input<number>;
    /**
     * ICMP protocol: The ICMP type. Required if specifying ICMP for the protocolE.g., -1
     */
    icmpType?: pulumi.Input<number>;
    /**
     * The IPv6 CIDR block to allow or deny.
     */
    ipv6CidrBlock?: pulumi.Input<string>;
    /**
     * The ID of the network ACL.
     */
    networkAclId: pulumi.Input<string>;
    /**
     * The protocol. A value of -1 means all protocols.
     */
    protocol: pulumi.Input<string>;
    /**
     * Indicates whether to allow or deny the traffic that matches the rule. Accepted values: `allow` | `deny`
     */
    ruleAction: pulumi.Input<string>;
    /**
     * The rule number for the entry (for example, 100). ACL entries are processed in ascending order by rule number.
     */
    ruleNumber: pulumi.Input<number>;
    /**
     * The to port to match.
     */
    toPort?: pulumi.Input<number>;
}
