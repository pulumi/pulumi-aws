// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a VPC DHCP Options resource.
 *
 * ## Example Usage
 *
 * Basic usage:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const dnsResolver = new aws.ec2.VpcDhcpOptions("dns_resolver", {domainNameServers: [
 *     "8.8.8.8",
 *     "8.8.4.4",
 * ]});
 * ```
 *
 * Full usage:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const foo = new aws.ec2.VpcDhcpOptions("foo", {
 *     domainName: "service.consul",
 *     domainNameServers: [
 *         "127.0.0.1",
 *         "10.0.0.2",
 *     ],
 *     ipv6AddressPreferredLeaseTime: "1440",
 *     ntpServers: ["127.0.0.1"],
 *     netbiosNameServers: ["127.0.0.1"],
 *     netbiosNodeType: "2",
 *     tags: {
 *         Name: "foo-name",
 *     },
 * });
 * ```
 *
 * ## Remarks
 *
 * * Notice that all arguments are optional but you have to specify at least one argument.
 * * `domainNameServers`, `netbiosNameServers`, `ntpServers` are limited by AWS to maximum four servers only.
 * * To actually use the DHCP Options Set you need to associate it to a VPC using `aws.ec2.VpcDhcpOptionsAssociation`.
 * * If you delete a DHCP Options Set, all VPCs using it will be associated to AWS's `default` DHCP Option Set.
 * * In most cases unless you're configuring your own DNS you'll want to set `domainNameServers` to `AmazonProvidedDNS`.
 *
 * ## Import
 *
 * Using `pulumi import`, import VPC DHCP Options using the DHCP Options `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/vpcDhcpOptions:VpcDhcpOptions my_options dopt-d9070ebb
 * ```
 */
export class VpcDhcpOptions extends pulumi.CustomResource {
    /**
     * Get an existing VpcDhcpOptions resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: VpcDhcpOptionsState, opts?: pulumi.CustomResourceOptions): VpcDhcpOptions {
        return new VpcDhcpOptions(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/vpcDhcpOptions:VpcDhcpOptions';

    /**
     * Returns true if the given object is an instance of VpcDhcpOptions.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is VpcDhcpOptions {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === VpcDhcpOptions.__pulumiType;
    }

    /**
     * The ARN of the DHCP Options Set.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * the suffix domain name to use by default when resolving non Fully Qualified Domain Names. In other words, this is what ends up being the `search` value in the `/etc/resolv.conf` file.
     */
    public readonly domainName!: pulumi.Output<string | undefined>;
    /**
     * List of name servers to configure in `/etc/resolv.conf`. If you want to use the default AWS nameservers you should set this to `AmazonProvidedDNS`.
     */
    public readonly domainNameServers!: pulumi.Output<string[] | undefined>;
    /**
     * How frequently, in seconds, a running instance with an IPv6 assigned to it goes through DHCPv6 lease renewal. Acceptable values are between 140 and 2147483647 (approximately 68 years). If no value is entered, the default lease time is 140 seconds. If you use long-term addressing for EC2 instances, you can increase the lease time and avoid frequent lease renewal requests. Lease renewal typically occurs when half of the lease time has elapsed.
     */
    public readonly ipv6AddressPreferredLeaseTime!: pulumi.Output<string | undefined>;
    /**
     * List of NETBIOS name servers.
     */
    public readonly netbiosNameServers!: pulumi.Output<string[] | undefined>;
    /**
     * The NetBIOS node type (1, 2, 4, or 8). AWS recommends to specify 2 since broadcast and multicast are not supported in their network. For more information about these node types, see [RFC 2132](http://www.ietf.org/rfc/rfc2132.txt).
     */
    public readonly netbiosNodeType!: pulumi.Output<string | undefined>;
    /**
     * List of NTP servers to configure.
     */
    public readonly ntpServers!: pulumi.Output<string[] | undefined>;
    /**
     * The ID of the AWS account that owns the DHCP options set.
     */
    public /*out*/ readonly ownerId!: pulumi.Output<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a VpcDhcpOptions resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: VpcDhcpOptionsArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: VpcDhcpOptionsArgs | VpcDhcpOptionsState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as VpcDhcpOptionsState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["domainName"] = state ? state.domainName : undefined;
            resourceInputs["domainNameServers"] = state ? state.domainNameServers : undefined;
            resourceInputs["ipv6AddressPreferredLeaseTime"] = state ? state.ipv6AddressPreferredLeaseTime : undefined;
            resourceInputs["netbiosNameServers"] = state ? state.netbiosNameServers : undefined;
            resourceInputs["netbiosNodeType"] = state ? state.netbiosNodeType : undefined;
            resourceInputs["ntpServers"] = state ? state.ntpServers : undefined;
            resourceInputs["ownerId"] = state ? state.ownerId : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as VpcDhcpOptionsArgs | undefined;
            resourceInputs["domainName"] = args ? args.domainName : undefined;
            resourceInputs["domainNameServers"] = args ? args.domainNameServers : undefined;
            resourceInputs["ipv6AddressPreferredLeaseTime"] = args ? args.ipv6AddressPreferredLeaseTime : undefined;
            resourceInputs["netbiosNameServers"] = args ? args.netbiosNameServers : undefined;
            resourceInputs["netbiosNodeType"] = args ? args.netbiosNodeType : undefined;
            resourceInputs["ntpServers"] = args ? args.ntpServers : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["ownerId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(VpcDhcpOptions.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering VpcDhcpOptions resources.
 */
export interface VpcDhcpOptionsState {
    /**
     * The ARN of the DHCP Options Set.
     */
    arn?: pulumi.Input<string>;
    /**
     * the suffix domain name to use by default when resolving non Fully Qualified Domain Names. In other words, this is what ends up being the `search` value in the `/etc/resolv.conf` file.
     */
    domainName?: pulumi.Input<string>;
    /**
     * List of name servers to configure in `/etc/resolv.conf`. If you want to use the default AWS nameservers you should set this to `AmazonProvidedDNS`.
     */
    domainNameServers?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * How frequently, in seconds, a running instance with an IPv6 assigned to it goes through DHCPv6 lease renewal. Acceptable values are between 140 and 2147483647 (approximately 68 years). If no value is entered, the default lease time is 140 seconds. If you use long-term addressing for EC2 instances, you can increase the lease time and avoid frequent lease renewal requests. Lease renewal typically occurs when half of the lease time has elapsed.
     */
    ipv6AddressPreferredLeaseTime?: pulumi.Input<string>;
    /**
     * List of NETBIOS name servers.
     */
    netbiosNameServers?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The NetBIOS node type (1, 2, 4, or 8). AWS recommends to specify 2 since broadcast and multicast are not supported in their network. For more information about these node types, see [RFC 2132](http://www.ietf.org/rfc/rfc2132.txt).
     */
    netbiosNodeType?: pulumi.Input<string>;
    /**
     * List of NTP servers to configure.
     */
    ntpServers?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The ID of the AWS account that owns the DHCP options set.
     */
    ownerId?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a VpcDhcpOptions resource.
 */
export interface VpcDhcpOptionsArgs {
    /**
     * the suffix domain name to use by default when resolving non Fully Qualified Domain Names. In other words, this is what ends up being the `search` value in the `/etc/resolv.conf` file.
     */
    domainName?: pulumi.Input<string>;
    /**
     * List of name servers to configure in `/etc/resolv.conf`. If you want to use the default AWS nameservers you should set this to `AmazonProvidedDNS`.
     */
    domainNameServers?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * How frequently, in seconds, a running instance with an IPv6 assigned to it goes through DHCPv6 lease renewal. Acceptable values are between 140 and 2147483647 (approximately 68 years). If no value is entered, the default lease time is 140 seconds. If you use long-term addressing for EC2 instances, you can increase the lease time and avoid frequent lease renewal requests. Lease renewal typically occurs when half of the lease time has elapsed.
     */
    ipv6AddressPreferredLeaseTime?: pulumi.Input<string>;
    /**
     * List of NETBIOS name servers.
     */
    netbiosNameServers?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The NetBIOS node type (1, 2, 4, or 8). AWS recommends to specify 2 since broadcast and multicast are not supported in their network. For more information about these node types, see [RFC 2132](http://www.ietf.org/rfc/rfc2132.txt).
     */
    netbiosNodeType?: pulumi.Input<string>;
    /**
     * List of NTP servers to configure.
     */
    ntpServers?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
