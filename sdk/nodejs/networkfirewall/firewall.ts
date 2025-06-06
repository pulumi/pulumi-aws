// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides an AWS Network Firewall Firewall Resource
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.networkfirewall.Firewall("example", {
 *     name: "example",
 *     firewallPolicyArn: exampleAwsNetworkfirewallFirewallPolicy.arn,
 *     vpcId: exampleAwsVpc.id,
 *     enabledAnalysisTypes: [
 *         "TLS_SNI",
 *         "HTTP_HOST",
 *     ],
 *     subnetMappings: [{
 *         subnetId: exampleAwsSubnet.id,
 *     }],
 *     tags: {
 *         Tag1: "Value1",
 *         Tag2: "Value2",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Network Firewall Firewalls using their `arn`. For example:
 *
 * ```sh
 * $ pulumi import aws:networkfirewall/firewall:Firewall example arn:aws:network-firewall:us-west-1:123456789012:firewall/example
 * ```
 */
export class Firewall extends pulumi.CustomResource {
    /**
     * Get an existing Firewall resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: FirewallState, opts?: pulumi.CustomResourceOptions): Firewall {
        return new Firewall(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:networkfirewall/firewall:Firewall';

    /**
     * Returns true if the given object is an instance of Firewall.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Firewall {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Firewall.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) that identifies the firewall.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A flag indicating whether the firewall is protected against deletion. Use this setting to protect against accidentally deleting a firewall that is in use. Defaults to `false`.
     */
    public readonly deleteProtection!: pulumi.Output<boolean | undefined>;
    /**
     * A friendly description of the firewall.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Set of types for which to collect analysis metrics. See [Reporting on network traffic in Network Firewall](https://docs.aws.amazon.com/network-firewall/latest/developerguide/reporting.html) for details on how to use the data. Valid values: `TLS_SNI`, `HTTP_HOST`. Defaults to `[]`.
     */
    public readonly enabledAnalysisTypes!: pulumi.Output<string[] | undefined>;
    /**
     * KMS encryption configuration settings. See Encryption Configuration below for details.
     */
    public readonly encryptionConfiguration!: pulumi.Output<outputs.networkfirewall.FirewallEncryptionConfiguration | undefined>;
    /**
     * The Amazon Resource Name (ARN) of the VPC Firewall policy.
     */
    public readonly firewallPolicyArn!: pulumi.Output<string>;
    /**
     * A flag indicating whether the firewall is protected against a change to the firewall policy association. Use this setting to protect against accidentally modifying the firewall policy for a firewall that is in use. Defaults to `false`.
     */
    public readonly firewallPolicyChangeProtection!: pulumi.Output<boolean | undefined>;
    /**
     * Nested list of information about the current status of the firewall.
     */
    public /*out*/ readonly firewallStatuses!: pulumi.Output<outputs.networkfirewall.FirewallFirewallStatus[]>;
    /**
     * A friendly name of the firewall.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * A flag indicating whether the firewall is protected against changes to the subnet associations. Use this setting to protect against accidentally modifying the subnet associations for a firewall that is in use. Defaults to `false`.
     */
    public readonly subnetChangeProtection!: pulumi.Output<boolean | undefined>;
    /**
     * Set of configuration blocks describing the public subnets. Each subnet must belong to a different Availability Zone in the VPC. AWS Network Firewall creates a firewall endpoint in each subnet. See Subnet Mapping below for details.
     */
    public readonly subnetMappings!: pulumi.Output<outputs.networkfirewall.FirewallSubnetMapping[]>;
    /**
     * Map of resource tags to associate with the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * A string token used when updating a firewall.
     */
    public /*out*/ readonly updateToken!: pulumi.Output<string>;
    /**
     * The unique identifier of the VPC where AWS Network Firewall should create the firewall.
     */
    public readonly vpcId!: pulumi.Output<string>;

    /**
     * Create a Firewall resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: FirewallArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: FirewallArgs | FirewallState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as FirewallState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["deleteProtection"] = state ? state.deleteProtection : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["enabledAnalysisTypes"] = state ? state.enabledAnalysisTypes : undefined;
            resourceInputs["encryptionConfiguration"] = state ? state.encryptionConfiguration : undefined;
            resourceInputs["firewallPolicyArn"] = state ? state.firewallPolicyArn : undefined;
            resourceInputs["firewallPolicyChangeProtection"] = state ? state.firewallPolicyChangeProtection : undefined;
            resourceInputs["firewallStatuses"] = state ? state.firewallStatuses : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["subnetChangeProtection"] = state ? state.subnetChangeProtection : undefined;
            resourceInputs["subnetMappings"] = state ? state.subnetMappings : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["updateToken"] = state ? state.updateToken : undefined;
            resourceInputs["vpcId"] = state ? state.vpcId : undefined;
        } else {
            const args = argsOrState as FirewallArgs | undefined;
            if ((!args || args.firewallPolicyArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'firewallPolicyArn'");
            }
            if ((!args || args.subnetMappings === undefined) && !opts.urn) {
                throw new Error("Missing required property 'subnetMappings'");
            }
            if ((!args || args.vpcId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'vpcId'");
            }
            resourceInputs["deleteProtection"] = args ? args.deleteProtection : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["enabledAnalysisTypes"] = args ? args.enabledAnalysisTypes : undefined;
            resourceInputs["encryptionConfiguration"] = args ? args.encryptionConfiguration : undefined;
            resourceInputs["firewallPolicyArn"] = args ? args.firewallPolicyArn : undefined;
            resourceInputs["firewallPolicyChangeProtection"] = args ? args.firewallPolicyChangeProtection : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["subnetChangeProtection"] = args ? args.subnetChangeProtection : undefined;
            resourceInputs["subnetMappings"] = args ? args.subnetMappings : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["vpcId"] = args ? args.vpcId : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["firewallStatuses"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["updateToken"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Firewall.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Firewall resources.
 */
export interface FirewallState {
    /**
     * The Amazon Resource Name (ARN) that identifies the firewall.
     */
    arn?: pulumi.Input<string>;
    /**
     * A flag indicating whether the firewall is protected against deletion. Use this setting to protect against accidentally deleting a firewall that is in use. Defaults to `false`.
     */
    deleteProtection?: pulumi.Input<boolean>;
    /**
     * A friendly description of the firewall.
     */
    description?: pulumi.Input<string>;
    /**
     * Set of types for which to collect analysis metrics. See [Reporting on network traffic in Network Firewall](https://docs.aws.amazon.com/network-firewall/latest/developerguide/reporting.html) for details on how to use the data. Valid values: `TLS_SNI`, `HTTP_HOST`. Defaults to `[]`.
     */
    enabledAnalysisTypes?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * KMS encryption configuration settings. See Encryption Configuration below for details.
     */
    encryptionConfiguration?: pulumi.Input<inputs.networkfirewall.FirewallEncryptionConfiguration>;
    /**
     * The Amazon Resource Name (ARN) of the VPC Firewall policy.
     */
    firewallPolicyArn?: pulumi.Input<string>;
    /**
     * A flag indicating whether the firewall is protected against a change to the firewall policy association. Use this setting to protect against accidentally modifying the firewall policy for a firewall that is in use. Defaults to `false`.
     */
    firewallPolicyChangeProtection?: pulumi.Input<boolean>;
    /**
     * Nested list of information about the current status of the firewall.
     */
    firewallStatuses?: pulumi.Input<pulumi.Input<inputs.networkfirewall.FirewallFirewallStatus>[]>;
    /**
     * A friendly name of the firewall.
     */
    name?: pulumi.Input<string>;
    /**
     * A flag indicating whether the firewall is protected against changes to the subnet associations. Use this setting to protect against accidentally modifying the subnet associations for a firewall that is in use. Defaults to `false`.
     */
    subnetChangeProtection?: pulumi.Input<boolean>;
    /**
     * Set of configuration blocks describing the public subnets. Each subnet must belong to a different Availability Zone in the VPC. AWS Network Firewall creates a firewall endpoint in each subnet. See Subnet Mapping below for details.
     */
    subnetMappings?: pulumi.Input<pulumi.Input<inputs.networkfirewall.FirewallSubnetMapping>[]>;
    /**
     * Map of resource tags to associate with the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A string token used when updating a firewall.
     */
    updateToken?: pulumi.Input<string>;
    /**
     * The unique identifier of the VPC where AWS Network Firewall should create the firewall.
     */
    vpcId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Firewall resource.
 */
export interface FirewallArgs {
    /**
     * A flag indicating whether the firewall is protected against deletion. Use this setting to protect against accidentally deleting a firewall that is in use. Defaults to `false`.
     */
    deleteProtection?: pulumi.Input<boolean>;
    /**
     * A friendly description of the firewall.
     */
    description?: pulumi.Input<string>;
    /**
     * Set of types for which to collect analysis metrics. See [Reporting on network traffic in Network Firewall](https://docs.aws.amazon.com/network-firewall/latest/developerguide/reporting.html) for details on how to use the data. Valid values: `TLS_SNI`, `HTTP_HOST`. Defaults to `[]`.
     */
    enabledAnalysisTypes?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * KMS encryption configuration settings. See Encryption Configuration below for details.
     */
    encryptionConfiguration?: pulumi.Input<inputs.networkfirewall.FirewallEncryptionConfiguration>;
    /**
     * The Amazon Resource Name (ARN) of the VPC Firewall policy.
     */
    firewallPolicyArn: pulumi.Input<string>;
    /**
     * A flag indicating whether the firewall is protected against a change to the firewall policy association. Use this setting to protect against accidentally modifying the firewall policy for a firewall that is in use. Defaults to `false`.
     */
    firewallPolicyChangeProtection?: pulumi.Input<boolean>;
    /**
     * A friendly name of the firewall.
     */
    name?: pulumi.Input<string>;
    /**
     * A flag indicating whether the firewall is protected against changes to the subnet associations. Use this setting to protect against accidentally modifying the subnet associations for a firewall that is in use. Defaults to `false`.
     */
    subnetChangeProtection?: pulumi.Input<boolean>;
    /**
     * Set of configuration blocks describing the public subnets. Each subnet must belong to a different Availability Zone in the VPC. AWS Network Firewall creates a firewall endpoint in each subnet. See Subnet Mapping below for details.
     */
    subnetMappings: pulumi.Input<pulumi.Input<inputs.networkfirewall.FirewallSubnetMapping>[]>;
    /**
     * Map of resource tags to associate with the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The unique identifier of the VPC where AWS Network Firewall should create the firewall.
     */
    vpcId: pulumi.Input<string>;
}
