// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an Elastic IP resource.
 *
 * > **Note:** EIP may require IGW to exist prior to association. Use `dependsOn` to set an explicit dependency on the IGW.
 *
 * > **Note:** Do not use `networkInterface` to associate the EIP to `aws.lb.LoadBalancer` or `aws.ec2.NatGateway` resources. Instead use the `allocationId` available in those resources to allow AWS to manage the association, otherwise you will see `AuthFailure` errors.
 *
 * ## Example Usage
 *
 * ### Single EIP associated with an instance
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const lb = new aws.ec2.Eip("lb", {
 *     instance: web.id,
 *     domain: "vpc",
 * });
 * ```
 *
 * ### Multiple EIPs associated with a single network interface
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const multi_ip = new aws.ec2.NetworkInterface("multi-ip", {
 *     subnetId: main.id,
 *     privateIps: [
 *         "10.0.0.10",
 *         "10.0.0.11",
 *     ],
 * });
 * const one = new aws.ec2.Eip("one", {
 *     domain: "vpc",
 *     networkInterface: multi_ip.id,
 *     associateWithPrivateIp: "10.0.0.10",
 * });
 * const two = new aws.ec2.Eip("two", {
 *     domain: "vpc",
 *     networkInterface: multi_ip.id,
 *     associateWithPrivateIp: "10.0.0.11",
 * });
 * ```
 *
 * ### Attaching an EIP to an Instance with a pre-assigned private ip (VPC Only)
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const _default = new aws.ec2.Vpc("default", {
 *     cidrBlock: "10.0.0.0/16",
 *     enableDnsHostnames: true,
 * });
 * const gw = new aws.ec2.InternetGateway("gw", {vpcId: _default.id});
 * const myTestSubnet = new aws.ec2.Subnet("my_test_subnet", {
 *     vpcId: _default.id,
 *     cidrBlock: "10.0.0.0/24",
 *     mapPublicIpOnLaunch: true,
 * }, {
 *     dependsOn: [gw],
 * });
 * const foo = new aws.ec2.Instance("foo", {
 *     ami: "ami-5189a661",
 *     instanceType: aws.ec2.InstanceType.T2_Micro,
 *     privateIp: "10.0.0.12",
 *     subnetId: myTestSubnet.id,
 * });
 * const bar = new aws.ec2.Eip("bar", {
 *     domain: "vpc",
 *     instance: foo.id,
 *     associateWithPrivateIp: "10.0.0.12",
 * }, {
 *     dependsOn: [gw],
 * });
 * ```
 *
 * ### Allocating EIP from the BYOIP pool
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const byoip_ip = new aws.ec2.Eip("byoip-ip", {
 *     domain: "vpc",
 *     publicIpv4Pool: "ipv4pool-ec2-012345",
 * });
 * ```
 *
 * ### Allocating EIP from the IPAM Pool
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const ipam_ip = new aws.ec2.Eip("ipam-ip", {
 *     domain: "vpc",
 *     ipamPoolId: "ipam-pool-07ccc86aa41bef7ce",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import EIPs in a VPC using their Allocation ID. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/eip:Eip bar eipalloc-00a10e96
 * ```
 */
export class Eip extends pulumi.CustomResource {
    /**
     * Get an existing Eip resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: EipState, opts?: pulumi.CustomResourceOptions): Eip {
        return new Eip(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/eip:Eip';

    /**
     * Returns true if the given object is an instance of Eip.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Eip {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Eip.__pulumiType;
    }

    /**
     * IP address from an EC2 BYOIP pool. This option is only available for VPC EIPs.
     */
    public readonly address!: pulumi.Output<string | undefined>;
    /**
     * ID that AWS assigns to represent the allocation of the Elastic IP address for use with instances in a VPC.
     */
    public /*out*/ readonly allocationId!: pulumi.Output<string>;
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * User-specified primary or secondary private IP address to associate with the Elastic IP address. If no private IP address is specified, the Elastic IP address is associated with the primary private IP address.
     */
    public readonly associateWithPrivateIp!: pulumi.Output<string | undefined>;
    /**
     * ID representing the association of the address with an instance in a VPC.
     */
    public /*out*/ readonly associationId!: pulumi.Output<string>;
    /**
     * Carrier IP address.
     */
    public /*out*/ readonly carrierIp!: pulumi.Output<string>;
    /**
     * Customer owned IP.
     */
    public /*out*/ readonly customerOwnedIp!: pulumi.Output<string>;
    /**
     * ID  of a customer-owned address pool. For more on customer owned IP addressed check out [Customer-owned IP addresses guide](https://docs.aws.amazon.com/outposts/latest/userguide/outposts-networking-components.html#ip-addressing).
     */
    public readonly customerOwnedIpv4Pool!: pulumi.Output<string | undefined>;
    /**
     * Indicates if this EIP is for use in VPC (`vpc`).
     */
    public readonly domain!: pulumi.Output<string>;
    /**
     * EC2 instance ID.
     */
    public readonly instance!: pulumi.Output<string>;
    /**
     * The ID of an IPAM pool which has an Amazon-provided or BYOIP public IPv4 CIDR provisioned to it.
     */
    public readonly ipamPoolId!: pulumi.Output<string>;
    /**
     * Location from which the IP address is advertised. Use this parameter to limit the address to this location.
     */
    public readonly networkBorderGroup!: pulumi.Output<string>;
    /**
     * Network interface ID to associate with.
     */
    public readonly networkInterface!: pulumi.Output<string>;
    /**
     * The Private DNS associated with the Elastic IP address (if in VPC).
     */
    public /*out*/ readonly privateDns!: pulumi.Output<string>;
    /**
     * Contains the private IP address (if in VPC).
     */
    public /*out*/ readonly privateIp!: pulumi.Output<string>;
    /**
     * The DNS pointer (PTR) record for the IP address.
     */
    public /*out*/ readonly ptrRecord!: pulumi.Output<string>;
    /**
     * Public DNS associated with the Elastic IP address.
     */
    public /*out*/ readonly publicDns!: pulumi.Output<string>;
    /**
     * Contains the public IP address.
     */
    public /*out*/ readonly publicIp!: pulumi.Output<string>;
    /**
     * EC2 IPv4 address pool identifier or `amazon`.
     * This option is only available for VPC EIPs.
     */
    public readonly publicIpv4Pool!: pulumi.Output<string>;
    /**
     * Map of tags to assign to the resource. Tags can only be applied to EIPs in a VPC. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Boolean if the EIP is in a VPC or not. Use `domain` instead.
     * Defaults to `true` unless the region supports EC2-Classic.
     *
     * > **NOTE:** You can specify either the `instance` ID or the `networkInterface` ID, but not both. Including both will **not** return an error from the AWS API, but will have undefined behavior. See the relevant [AssociateAddress API Call][1] for more information.
     *
     * > **NOTE:** Specifying both `publicIpv4Pool` and `address` won't cause an error but `address` will be used in the
     * case both options are defined as the api only requires one or the other.
     *
     * @deprecated vpc is deprecated. Use domain instead.
     */
    public readonly vpc!: pulumi.Output<boolean>;

    /**
     * Create a Eip resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: EipArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: EipArgs | EipState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as EipState | undefined;
            resourceInputs["address"] = state ? state.address : undefined;
            resourceInputs["allocationId"] = state ? state.allocationId : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["associateWithPrivateIp"] = state ? state.associateWithPrivateIp : undefined;
            resourceInputs["associationId"] = state ? state.associationId : undefined;
            resourceInputs["carrierIp"] = state ? state.carrierIp : undefined;
            resourceInputs["customerOwnedIp"] = state ? state.customerOwnedIp : undefined;
            resourceInputs["customerOwnedIpv4Pool"] = state ? state.customerOwnedIpv4Pool : undefined;
            resourceInputs["domain"] = state ? state.domain : undefined;
            resourceInputs["instance"] = state ? state.instance : undefined;
            resourceInputs["ipamPoolId"] = state ? state.ipamPoolId : undefined;
            resourceInputs["networkBorderGroup"] = state ? state.networkBorderGroup : undefined;
            resourceInputs["networkInterface"] = state ? state.networkInterface : undefined;
            resourceInputs["privateDns"] = state ? state.privateDns : undefined;
            resourceInputs["privateIp"] = state ? state.privateIp : undefined;
            resourceInputs["ptrRecord"] = state ? state.ptrRecord : undefined;
            resourceInputs["publicDns"] = state ? state.publicDns : undefined;
            resourceInputs["publicIp"] = state ? state.publicIp : undefined;
            resourceInputs["publicIpv4Pool"] = state ? state.publicIpv4Pool : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["vpc"] = state ? state.vpc : undefined;
        } else {
            const args = argsOrState as EipArgs | undefined;
            resourceInputs["address"] = args ? args.address : undefined;
            resourceInputs["associateWithPrivateIp"] = args ? args.associateWithPrivateIp : undefined;
            resourceInputs["customerOwnedIpv4Pool"] = args ? args.customerOwnedIpv4Pool : undefined;
            resourceInputs["domain"] = args ? args.domain : undefined;
            resourceInputs["instance"] = args ? args.instance : undefined;
            resourceInputs["ipamPoolId"] = args ? args.ipamPoolId : undefined;
            resourceInputs["networkBorderGroup"] = args ? args.networkBorderGroup : undefined;
            resourceInputs["networkInterface"] = args ? args.networkInterface : undefined;
            resourceInputs["publicIpv4Pool"] = args ? args.publicIpv4Pool : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["vpc"] = args ? args.vpc : undefined;
            resourceInputs["allocationId"] = undefined /*out*/;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["associationId"] = undefined /*out*/;
            resourceInputs["carrierIp"] = undefined /*out*/;
            resourceInputs["customerOwnedIp"] = undefined /*out*/;
            resourceInputs["privateDns"] = undefined /*out*/;
            resourceInputs["privateIp"] = undefined /*out*/;
            resourceInputs["ptrRecord"] = undefined /*out*/;
            resourceInputs["publicDns"] = undefined /*out*/;
            resourceInputs["publicIp"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Eip.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Eip resources.
 */
export interface EipState {
    /**
     * IP address from an EC2 BYOIP pool. This option is only available for VPC EIPs.
     */
    address?: pulumi.Input<string>;
    /**
     * ID that AWS assigns to represent the allocation of the Elastic IP address for use with instances in a VPC.
     */
    allocationId?: pulumi.Input<string>;
    arn?: pulumi.Input<string>;
    /**
     * User-specified primary or secondary private IP address to associate with the Elastic IP address. If no private IP address is specified, the Elastic IP address is associated with the primary private IP address.
     */
    associateWithPrivateIp?: pulumi.Input<string>;
    /**
     * ID representing the association of the address with an instance in a VPC.
     */
    associationId?: pulumi.Input<string>;
    /**
     * Carrier IP address.
     */
    carrierIp?: pulumi.Input<string>;
    /**
     * Customer owned IP.
     */
    customerOwnedIp?: pulumi.Input<string>;
    /**
     * ID  of a customer-owned address pool. For more on customer owned IP addressed check out [Customer-owned IP addresses guide](https://docs.aws.amazon.com/outposts/latest/userguide/outposts-networking-components.html#ip-addressing).
     */
    customerOwnedIpv4Pool?: pulumi.Input<string>;
    /**
     * Indicates if this EIP is for use in VPC (`vpc`).
     */
    domain?: pulumi.Input<string>;
    /**
     * EC2 instance ID.
     */
    instance?: pulumi.Input<string>;
    /**
     * The ID of an IPAM pool which has an Amazon-provided or BYOIP public IPv4 CIDR provisioned to it.
     */
    ipamPoolId?: pulumi.Input<string>;
    /**
     * Location from which the IP address is advertised. Use this parameter to limit the address to this location.
     */
    networkBorderGroup?: pulumi.Input<string>;
    /**
     * Network interface ID to associate with.
     */
    networkInterface?: pulumi.Input<string>;
    /**
     * The Private DNS associated with the Elastic IP address (if in VPC).
     */
    privateDns?: pulumi.Input<string>;
    /**
     * Contains the private IP address (if in VPC).
     */
    privateIp?: pulumi.Input<string>;
    /**
     * The DNS pointer (PTR) record for the IP address.
     */
    ptrRecord?: pulumi.Input<string>;
    /**
     * Public DNS associated with the Elastic IP address.
     */
    publicDns?: pulumi.Input<string>;
    /**
     * Contains the public IP address.
     */
    publicIp?: pulumi.Input<string>;
    /**
     * EC2 IPv4 address pool identifier or `amazon`.
     * This option is only available for VPC EIPs.
     */
    publicIpv4Pool?: pulumi.Input<string>;
    /**
     * Map of tags to assign to the resource. Tags can only be applied to EIPs in a VPC. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Boolean if the EIP is in a VPC or not. Use `domain` instead.
     * Defaults to `true` unless the region supports EC2-Classic.
     *
     * > **NOTE:** You can specify either the `instance` ID or the `networkInterface` ID, but not both. Including both will **not** return an error from the AWS API, but will have undefined behavior. See the relevant [AssociateAddress API Call][1] for more information.
     *
     * > **NOTE:** Specifying both `publicIpv4Pool` and `address` won't cause an error but `address` will be used in the
     * case both options are defined as the api only requires one or the other.
     *
     * @deprecated vpc is deprecated. Use domain instead.
     */
    vpc?: pulumi.Input<boolean>;
}

/**
 * The set of arguments for constructing a Eip resource.
 */
export interface EipArgs {
    /**
     * IP address from an EC2 BYOIP pool. This option is only available for VPC EIPs.
     */
    address?: pulumi.Input<string>;
    /**
     * User-specified primary or secondary private IP address to associate with the Elastic IP address. If no private IP address is specified, the Elastic IP address is associated with the primary private IP address.
     */
    associateWithPrivateIp?: pulumi.Input<string>;
    /**
     * ID  of a customer-owned address pool. For more on customer owned IP addressed check out [Customer-owned IP addresses guide](https://docs.aws.amazon.com/outposts/latest/userguide/outposts-networking-components.html#ip-addressing).
     */
    customerOwnedIpv4Pool?: pulumi.Input<string>;
    /**
     * Indicates if this EIP is for use in VPC (`vpc`).
     */
    domain?: pulumi.Input<string>;
    /**
     * EC2 instance ID.
     */
    instance?: pulumi.Input<string>;
    /**
     * The ID of an IPAM pool which has an Amazon-provided or BYOIP public IPv4 CIDR provisioned to it.
     */
    ipamPoolId?: pulumi.Input<string>;
    /**
     * Location from which the IP address is advertised. Use this parameter to limit the address to this location.
     */
    networkBorderGroup?: pulumi.Input<string>;
    /**
     * Network interface ID to associate with.
     */
    networkInterface?: pulumi.Input<string>;
    /**
     * EC2 IPv4 address pool identifier or `amazon`.
     * This option is only available for VPC EIPs.
     */
    publicIpv4Pool?: pulumi.Input<string>;
    /**
     * Map of tags to assign to the resource. Tags can only be applied to EIPs in a VPC. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Boolean if the EIP is in a VPC or not. Use `domain` instead.
     * Defaults to `true` unless the region supports EC2-Classic.
     *
     * > **NOTE:** You can specify either the `instance` ID or the `networkInterface` ID, but not both. Including both will **not** return an error from the AWS API, but will have undefined behavior. See the relevant [AssociateAddress API Call][1] for more information.
     *
     * > **NOTE:** Specifying both `publicIpv4Pool` and `address` won't cause an error but `address` will be used in the
     * case both options are defined as the api only requires one or the other.
     *
     * @deprecated vpc is deprecated. Use domain instead.
     */
    vpc?: pulumi.Input<boolean>;
}
