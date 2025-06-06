// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a security group resource.
 *
 * > **NOTE:** Avoid using the `ingress` and `egress` arguments of the `aws.ec2.SecurityGroup` resource to configure in-line rules, as they struggle with managing multiple CIDR blocks, and, due to the historical lack of unique IDs, tags and descriptions. To avoid these problems, use the current best practice of the `aws.vpc.SecurityGroupEgressRule` and `aws.vpc.SecurityGroupIngressRule` resources with one CIDR block per rule.
 *
 * !> **WARNING:** You should not use the `aws.ec2.SecurityGroup` resource with _in-line rules_ (using the `ingress` and `egress` arguments of `aws.ec2.SecurityGroup`) in conjunction with the `aws.vpc.SecurityGroupEgressRule` and `aws.vpc.SecurityGroupIngressRule` resources or the `aws.ec2.SecurityGroupRule` resource. Doing so may cause rule conflicts, perpetual differences, and result in rules being overwritten.
 *
 * > **NOTE:** Referencing Security Groups across VPC peering has certain restrictions. More information is available in the [VPC Peering User Guide](https://docs.aws.amazon.com/vpc/latest/peering/vpc-peering-security-groups.html).
 *
 * > **NOTE:** Due to [AWS Lambda improved VPC networking changes that began deploying in September 2019](https://aws.amazon.com/blogs/compute/announcing-improved-vpc-networking-for-aws-lambda-functions/), security groups associated with Lambda Functions can take up to 45 minutes to successfully delete. To allow for successful deletion, the provider will wait for at least 45 minutes even if a shorter delete timeout is specified.
 *
 * > **NOTE:** The `cidrBlocks` and `ipv6CidrBlocks` parameters are optional in the `ingress` and `egress` blocks. If nothing is specified, traffic will be blocked as described in _NOTE on Egress rules_ later.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const allowTls = new aws.ec2.SecurityGroup("allow_tls", {
 *     name: "allow_tls",
 *     description: "Allow TLS inbound traffic and all outbound traffic",
 *     vpcId: main.id,
 *     tags: {
 *         Name: "allow_tls",
 *     },
 * });
 * const allowTlsIpv4 = new aws.vpc.SecurityGroupIngressRule("allow_tls_ipv4", {
 *     securityGroupId: allowTls.id,
 *     cidrIpv4: main.cidrBlock,
 *     fromPort: 443,
 *     ipProtocol: "tcp",
 *     toPort: 443,
 * });
 * const allowTlsIpv6 = new aws.vpc.SecurityGroupIngressRule("allow_tls_ipv6", {
 *     securityGroupId: allowTls.id,
 *     cidrIpv6: main.ipv6CidrBlock,
 *     fromPort: 443,
 *     ipProtocol: "tcp",
 *     toPort: 443,
 * });
 * const allowAllTrafficIpv4 = new aws.vpc.SecurityGroupEgressRule("allow_all_traffic_ipv4", {
 *     securityGroupId: allowTls.id,
 *     cidrIpv4: "0.0.0.0/0",
 *     ipProtocol: "-1",
 * });
 * const allowAllTrafficIpv6 = new aws.vpc.SecurityGroupEgressRule("allow_all_traffic_ipv6", {
 *     securityGroupId: allowTls.id,
 *     cidrIpv6: "::/0",
 *     ipProtocol: "-1",
 * });
 * ```
 *
 * > **NOTE on Egress rules:** By default, AWS creates an `ALLOW ALL` egress rule when creating a new Security Group inside of a VPC. When creating a new Security Group inside a VPC, **this provider will remove this default rule**, and require you specifically re-create it if you desire that rule. We feel this leads to fewer surprises in terms of controlling your egress rules. If you desire this rule to be in place, you can use this `egress` block:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2.SecurityGroup("example", {egress: [{
 *     fromPort: 0,
 *     toPort: 0,
 *     protocol: "-1",
 *     cidrBlocks: ["0.0.0.0/0"],
 *     ipv6CidrBlocks: ["::/0"],
 * }]});
 * ```
 *
 * ### Usage With Prefix List IDs
 *
 * Prefix Lists are either managed by AWS internally, or created by the customer using a
 * Prefix List resource. Prefix Lists provided by
 * AWS are associated with a prefix list name, or service name, that is linked to a specific region.
 * Prefix list IDs are exported on VPC Endpoints, so you can use this format:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const myEndpoint = new aws.ec2.VpcEndpoint("my_endpoint", {});
 * const example = new aws.ec2.SecurityGroup("example", {egress: [{
 *     fromPort: 0,
 *     toPort: 0,
 *     protocol: "-1",
 *     prefixListIds: [myEndpoint.prefixListId],
 * }]});
 * ```
 *
 * You can also find a specific Prefix List using the `aws.ec2.getPrefixList` data source.
 *
 * ### Removing All Ingress and Egress Rules
 *
 * The `ingress` and `egress` arguments are processed in attributes-as-blocks mode. Due to this, removing these arguments from the configuration will **not** cause the provider to destroy the managed rules. To subsequently remove all managed ingress and egress rules:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2.SecurityGroup("example", {
 *     name: "sg",
 *     vpcId: exampleAwsVpc.id,
 *     ingress: [],
 *     egress: [],
 * });
 * ```
 *
 * ### Recreating a Security Group
 *
 * A simple security group `name` change "forces new" the security group--the provider destroys the security group and creates a new one. (Likewise, `description`, `namePrefix`, or `vpcId` [cannot be changed](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/working-with-security-groups.html#creating-security-group).) Attempting to recreate the security group leads to a variety of complications depending on how it is used.
 *
 * Security groups are generally associated with other resources--**more than 100** AWS Provider resources reference security groups. Referencing a resource from another resource creates a one-way dependency. For example, if you create an EC2 `aws.ec2.Instance` that has a `vpcSecurityGroupIds` argument that refers to an `aws.ec2.SecurityGroup` resource, the `aws.ec2.SecurityGroup` is a dependent of the `aws.ec2.Instance`. Because of this, the provider will create the security group first so that it can then be associated with the EC2 instance.
 *
 * However, the dependency relationship actually goes both directions causing the _Security Group Deletion Problem_. AWS does not allow you to delete the security group associated with another resource (_e.g._, the `aws.ec2.Instance`).
 *
 * The provider does not model bi-directional dependencies like this, but, even if it did, simply knowing the dependency situation would not be enough to solve it. For example, some resources must always have an associated security group while others don't need to. In addition, when the `aws.ec2.SecurityGroup` resource attempts to recreate, it receives a dependent object error, which does not provide information on whether the dependent object is a security group rule or, for example, an associated EC2 instance. Within the provider, the associated resource (_e.g._, `aws.ec2.Instance`) does not receive an error when the `aws.ec2.SecurityGroup` is trying to recreate even though that is where changes to the associated resource would need to take place (_e.g._, removing the security group association).
 *
 * Despite these sticky problems, below are some ways to improve your experience when you find it necessary to recreate a security group.
 *
 * ### Shorter timeout
 *
 * (This example is one approach to recreating security groups. For more information on the challenges and the _Security Group Deletion Problem_, see the section above.)
 *
 * If destroying a security group takes a long time, it may be because the provider cannot distinguish between a dependent object (_e.g._, a security group rule or EC2 instance) that is _in the process of being deleted_ and one that is not. In other words, it may be waiting for a train that isn't scheduled to arrive. To fail faster, shorten the `delete` timeout from the default timeout:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2.SecurityGroup("example", {name: "izizavle"});
 * ```
 *
 * ### Provisioners
 *
 * (This example is one approach to recreating security groups. For more information on the challenges and the _Security Group Deletion Problem_, see the section above.)
 *
 * **DISCLAIMER:** We **_HIGHLY_** recommend using one of the above approaches and _NOT_ using local provisioners. Provisioners, like the one shown below, should be considered a **last resort** since they are _not readable_, _require skills outside standard configuration_, are _error prone_ and _difficult to maintain_, are not compatible with cloud environments and upgrade tools, require AWS CLI installation, and are subject to changes outside the AWS Provider.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as _null from "@pulumi/null";
 * import * as aws from "@pulumi/aws";
 * import * as command from "@pulumi/command";
 * import * as std from "@pulumi/std";
 *
 * const _default = aws.ec2.getSecurityGroup({
 *     name: "default",
 * });
 * const example = new aws.ec2.SecurityGroup("example", {
 *     name: "sg",
 *     tags: {
 *         workaround1: "tagged-name",
 *         workaround2: _default.then(_default => _default.id),
 *     },
 * });
 * const exampleProvisioner0 = new command.local.Command("exampleProvisioner0", {
 *     create: "true",
 *     update: "true",
 *     "delete": `            ENDPOINT_ID=`aws ec2 describe-vpc-endpoints --filters "Name=tag:Name,Values=${tags.workaround1}" --query "VpcEndpoints[0].VpcEndpointId" --output text` &&
 *             aws ec2 modify-vpc-endpoint --vpc-endpoint-id ${ENDPOINT_ID} --add-security-group-ids ${tags.workaround2} --remove-security-group-ids ${id}
 * `,
 * }, {
 *     dependsOn: [example],
 * });
 * const exampleResource = new _null.Resource("example", {triggers: {
 *     rerun_upon_change_of: std.join({
 *         separator: ",",
 *         input: exampleAwsVpcEndpoint.securityGroupIds,
 *     }).then(invoke => invoke.result),
 * }});
 * const exampleResourceProvisioner0 = new command.local.Command("exampleResourceProvisioner0", {create: `            aws ec2 modify-vpc-endpoint --vpc-endpoint-id ${exampleAwsVpcEndpoint.id} --remove-security-group-ids ${_default.id}
 * `}, {
 *     dependsOn: [exampleResource],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Security Groups using the security group `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/securityGroup:SecurityGroup elb_sg sg-903004f8
 * ```
 */
export class SecurityGroup extends pulumi.CustomResource {
    /**
     * Get an existing SecurityGroup resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: SecurityGroupState, opts?: pulumi.CustomResourceOptions): SecurityGroup {
        return new SecurityGroup(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/securityGroup:SecurityGroup';

    /**
     * Returns true if the given object is an instance of SecurityGroup.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is SecurityGroup {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === SecurityGroup.__pulumiType;
    }

    /**
     * ARN of the security group.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Security group description. Defaults to `Managed by Pulumi`. Cannot be `""`. **NOTE**: This field maps to the AWS `GroupDescription` attribute, for which there is no Update API. If you'd like to classify your security groups in a way that can be updated, use `tags`.
     */
    public readonly description!: pulumi.Output<string>;
    /**
     * Configuration block for egress rules. Can be specified multiple times for each egress rule. Each egress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
     */
    public readonly egress!: pulumi.Output<outputs.ec2.SecurityGroupEgress[]>;
    /**
     * Configuration block for ingress rules. Can be specified multiple times for each ingress rule. Each ingress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
     */
    public readonly ingress!: pulumi.Output<outputs.ec2.SecurityGroupIngress[]>;
    /**
     * Name of the security group. If omitted, the provider will assign a random, unique name.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    public readonly namePrefix!: pulumi.Output<string>;
    /**
     * Owner ID.
     */
    public /*out*/ readonly ownerId!: pulumi.Output<string>;
    /**
     * Instruct the provider to revoke all of the Security Groups attached ingress and egress rules before deleting the rule itself. This is normally not needed, however certain AWS services such as Elastic Map Reduce may automatically add required rules to security groups used with the service, and those rules may contain a cyclic dependency that prevent the security groups from being destroyed without removing the dependency first. Default `false`.
     */
    public readonly revokeRulesOnDelete!: pulumi.Output<boolean | undefined>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * VPC ID. Defaults to the region's default VPC.
     */
    public readonly vpcId!: pulumi.Output<string>;

    /**
     * Create a SecurityGroup resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: SecurityGroupArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: SecurityGroupArgs | SecurityGroupState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as SecurityGroupState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["egress"] = state ? state.egress : undefined;
            resourceInputs["ingress"] = state ? state.ingress : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["namePrefix"] = state ? state.namePrefix : undefined;
            resourceInputs["ownerId"] = state ? state.ownerId : undefined;
            resourceInputs["revokeRulesOnDelete"] = state ? state.revokeRulesOnDelete : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["vpcId"] = state ? state.vpcId : undefined;
        } else {
            const args = argsOrState as SecurityGroupArgs | undefined;
            resourceInputs["description"] = (args ? args.description : undefined) ?? "Managed by Pulumi";
            resourceInputs["egress"] = args ? args.egress : undefined;
            resourceInputs["ingress"] = args ? args.ingress : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["namePrefix"] = args ? args.namePrefix : undefined;
            resourceInputs["revokeRulesOnDelete"] = args ? args.revokeRulesOnDelete : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["vpcId"] = args ? args.vpcId : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["ownerId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(SecurityGroup.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering SecurityGroup resources.
 */
export interface SecurityGroupState {
    /**
     * ARN of the security group.
     */
    arn?: pulumi.Input<string>;
    /**
     * Security group description. Defaults to `Managed by Pulumi`. Cannot be `""`. **NOTE**: This field maps to the AWS `GroupDescription` attribute, for which there is no Update API. If you'd like to classify your security groups in a way that can be updated, use `tags`.
     */
    description?: pulumi.Input<string>;
    /**
     * Configuration block for egress rules. Can be specified multiple times for each egress rule. Each egress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
     */
    egress?: pulumi.Input<pulumi.Input<inputs.ec2.SecurityGroupEgress>[]>;
    /**
     * Configuration block for ingress rules. Can be specified multiple times for each ingress rule. Each ingress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
     */
    ingress?: pulumi.Input<pulumi.Input<inputs.ec2.SecurityGroupIngress>[]>;
    /**
     * Name of the security group. If omitted, the provider will assign a random, unique name.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
    /**
     * Owner ID.
     */
    ownerId?: pulumi.Input<string>;
    /**
     * Instruct the provider to revoke all of the Security Groups attached ingress and egress rules before deleting the rule itself. This is normally not needed, however certain AWS services such as Elastic Map Reduce may automatically add required rules to security groups used with the service, and those rules may contain a cyclic dependency that prevent the security groups from being destroyed without removing the dependency first. Default `false`.
     */
    revokeRulesOnDelete?: pulumi.Input<boolean>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * VPC ID. Defaults to the region's default VPC.
     */
    vpcId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a SecurityGroup resource.
 */
export interface SecurityGroupArgs {
    /**
     * Security group description. Defaults to `Managed by Pulumi`. Cannot be `""`. **NOTE**: This field maps to the AWS `GroupDescription` attribute, for which there is no Update API. If you'd like to classify your security groups in a way that can be updated, use `tags`.
     */
    description?: pulumi.Input<string>;
    /**
     * Configuration block for egress rules. Can be specified multiple times for each egress rule. Each egress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
     */
    egress?: pulumi.Input<pulumi.Input<inputs.ec2.SecurityGroupEgress>[]>;
    /**
     * Configuration block for ingress rules. Can be specified multiple times for each ingress rule. Each ingress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
     */
    ingress?: pulumi.Input<pulumi.Input<inputs.ec2.SecurityGroupIngress>[]>;
    /**
     * Name of the security group. If omitted, the provider will assign a random, unique name.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
    /**
     * Instruct the provider to revoke all of the Security Groups attached ingress and egress rules before deleting the rule itself. This is normally not needed, however certain AWS services such as Elastic Map Reduce may automatically add required rules to security groups used with the service, and those rules may contain a cyclic dependency that prevent the security groups from being destroyed without removing the dependency first. Default `false`.
     */
    revokeRulesOnDelete?: pulumi.Input<boolean>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * VPC ID. Defaults to the region's default VPC.
     */
    vpcId?: pulumi.Input<string>;
}
