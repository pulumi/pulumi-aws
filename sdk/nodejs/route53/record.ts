// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a Route53 record resource.
 *
 * ## Example Usage
 *
 * ### Simple routing policy
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const www = new aws.route53.Record("www", {
 *     zoneId: primary.zoneId,
 *     name: "www.example.com",
 *     type: aws.route53.RecordType.A,
 *     ttl: 300,
 *     records: [lb.publicIp],
 * });
 * ```
 *
 * ### Weighted routing policy
 *
 * Other routing policies are configured similarly. See [Amazon Route 53 Developer Guide](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/routing-policy.html) for details.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const www_dev = new aws.route53.Record("www-dev", {
 *     zoneId: primary.zoneId,
 *     name: "www",
 *     type: aws.route53.RecordType.CNAME,
 *     ttl: 5,
 *     weightedRoutingPolicies: [{
 *         weight: 10,
 *     }],
 *     setIdentifier: "dev",
 *     records: ["dev.example.com"],
 * });
 * const www_live = new aws.route53.Record("www-live", {
 *     zoneId: primary.zoneId,
 *     name: "www",
 *     type: aws.route53.RecordType.CNAME,
 *     ttl: 5,
 *     weightedRoutingPolicies: [{
 *         weight: 90,
 *     }],
 *     setIdentifier: "live",
 *     records: ["live.example.com"],
 * });
 * ```
 *
 * ### Geoproximity routing policy
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const www = new aws.route53.Record("www", {
 *     zoneId: primary.zoneId,
 *     name: "www.example.com",
 *     type: aws.route53.RecordType.CNAME,
 *     ttl: 300,
 *     geoproximityRoutingPolicy: {
 *         coordinates: [{
 *             latitude: "49.22",
 *             longitude: "-74.01",
 *         }],
 *     },
 *     setIdentifier: "dev",
 *     records: ["dev.example.com"],
 * });
 * ```
 *
 * ### Alias record
 *
 * See [related part of Amazon Route 53 Developer Guide](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/resource-record-sets-choosing-alias-non-alias.html)
 * to understand differences between alias and non-alias records.
 *
 * TTL for all alias records is [60 seconds](https://aws.amazon.com/route53/faqs/#dns_failover_do_i_need_to_adjust),
 * you cannot change this, therefore `ttl` has to be omitted in alias records.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const main = new aws.elb.LoadBalancer("main", {
 *     name: "foobar-elb",
 *     availabilityZones: ["us-east-1c"],
 *     listeners: [{
 *         instancePort: 80,
 *         instanceProtocol: "http",
 *         lbPort: 80,
 *         lbProtocol: "http",
 *     }],
 * });
 * const www = new aws.route53.Record("www", {
 *     zoneId: primary.zoneId,
 *     name: "example.com",
 *     type: aws.route53.RecordType.A,
 *     aliases: [{
 *         name: main.dnsName,
 *         zoneId: main.zoneId,
 *         evaluateTargetHealth: true,
 *     }],
 * });
 * ```
 *
 * ### Alias record for AWS Global Accelerator
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const main = new aws.globalaccelerator.Accelerator("main", {
 *     name: "foobar-pulumi-accelerator",
 *     enabled: true,
 *     ipAddressType: "IPV4",
 * });
 * const www = new aws.route53.Record("www", {
 *     zoneId: primary.zoneId,
 *     name: "example.com",
 *     type: aws.route53.RecordType.A,
 *     aliases: [{
 *         name: main.dnsName,
 *         zoneId: main.hostedZoneId,
 *         evaluateTargetHealth: false,
 *     }],
 * });
 * ```
 *
 * ### NS and SOA Record Management
 *
 * When creating Route 53 zones, the `NS` and `SOA` records for the zone are automatically created. Enabling the `allowOverwrite` argument will allow managing these records in a single deployment without the requirement for `import`.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.route53.Zone("example", {name: "test.example.com"});
 * const exampleRecord = new aws.route53.Record("example", {
 *     allowOverwrite: true,
 *     name: "test.example.com",
 *     ttl: 172800,
 *     type: aws.route53.RecordType.NS,
 *     zoneId: example.zoneId,
 *     records: [
 *         example.nameServers[0],
 *         example.nameServers[1],
 *         example.nameServers[2],
 *         example.nameServers[3],
 *     ],
 * });
 * ```
 *
 * ## Import
 *
 * If the record also contains a set identifier, append it:
 *
 * If the record name is the empty string, it can be omitted:
 *
 * __Using `pulumi import` to import__ Route53 Records using the ID of the record, record name, record type, and set identifier. For example:
 *
 * Using the ID of the record, which is the zone identifier, record name, and record type, separated by underscores (`_`):
 *
 * ```sh
 * $ pulumi import aws:route53/record:Record myrecord Z4KAPRWWNC7JR_dev_NS
 * ```
 * If the record also contains a set identifier, append it:
 *
 * ```sh
 * $ pulumi import aws:route53/record:Record myrecord Z4KAPRWWNC7JR_dev_NS_dev
 * ```
 */
export class Record extends pulumi.CustomResource {
    /**
     * Get an existing Record resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: RecordState, opts?: pulumi.CustomResourceOptions): Record {
        return new Record(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:route53/record:Record';

    /**
     * Returns true if the given object is an instance of Record.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Record {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Record.__pulumiType;
    }

    /**
     * An alias block. Conflicts with `ttl` & `records`.
     * Documented below.
     */
    public readonly aliases!: pulumi.Output<outputs.route53.RecordAlias[] | undefined>;
    /**
     * Allow creation of this record to overwrite an existing record, if any. This does not affect the ability to update the record using this provider and does not prevent other resources within this provider or manual Route 53 changes outside this provider from overwriting this record. `false` by default. This configuration is not recommended for most environments.
     *
     * Exactly one of `records` or `alias` must be specified: this determines whether it's an alias record.
     */
    public readonly allowOverwrite!: pulumi.Output<boolean>;
    /**
     * A block indicating a routing policy based on the IP network ranges of requestors. Conflicts with any other routing policy. Documented below.
     */
    public readonly cidrRoutingPolicy!: pulumi.Output<outputs.route53.RecordCidrRoutingPolicy | undefined>;
    /**
     * A block indicating the routing behavior when associated health check fails. Conflicts with any other routing policy. Documented below.
     */
    public readonly failoverRoutingPolicies!: pulumi.Output<outputs.route53.RecordFailoverRoutingPolicy[] | undefined>;
    /**
     * [FQDN](https://en.wikipedia.org/wiki/Fully_qualified_domain_name) built using the zone domain and `name`.
     */
    public /*out*/ readonly fqdn!: pulumi.Output<string>;
    /**
     * A block indicating a routing policy based on the geolocation of the requestor. Conflicts with any other routing policy. Documented below.
     */
    public readonly geolocationRoutingPolicies!: pulumi.Output<outputs.route53.RecordGeolocationRoutingPolicy[] | undefined>;
    /**
     * A block indicating a routing policy based on the geoproximity of the requestor. Conflicts with any other routing policy. Documented below.
     */
    public readonly geoproximityRoutingPolicy!: pulumi.Output<outputs.route53.RecordGeoproximityRoutingPolicy | undefined>;
    /**
     * The health check the record should be associated with.
     */
    public readonly healthCheckId!: pulumi.Output<string | undefined>;
    /**
     * A block indicating a routing policy based on the latency between the requestor and an AWS region. Conflicts with any other routing policy. Documented below.
     */
    public readonly latencyRoutingPolicies!: pulumi.Output<outputs.route53.RecordLatencyRoutingPolicy[] | undefined>;
    /**
     * Set to `true` to indicate a multivalue answer routing policy. Conflicts with any other routing policy.
     */
    public readonly multivalueAnswerRoutingPolicy!: pulumi.Output<boolean | undefined>;
    /**
     * The name of the record.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * A string list of records. To specify a single record value longer than 255 characters such as a TXT record for DKIM, add `\"\"` inside the provider configuration string (e.g., `"first255characters\"\"morecharacters"`).
     */
    public readonly records!: pulumi.Output<string[] | undefined>;
    /**
     * Unique identifier to differentiate records with routing policies from one another. Required if using `cidrRoutingPolicy`, `failoverRoutingPolicy`, `geolocationRoutingPolicy`,`geoproximityRoutingPolicy`, `latencyRoutingPolicy`, `multivalueAnswerRoutingPolicy`, or `weightedRoutingPolicy`.
     */
    public readonly setIdentifier!: pulumi.Output<string | undefined>;
    /**
     * The TTL of the record.
     */
    public readonly ttl!: pulumi.Output<number | undefined>;
    /**
     * The record type. Valid values are `A`, `AAAA`, `CAA`, `CNAME`, `DS`, `HTTPS`, `MX`, `NAPTR`, `NS`, `PTR`, `SOA`, `SPF`, `SRV`, `SSHFP`, `SVCB`, `TLSA`, and `TXT`.
     */
    public readonly type!: pulumi.Output<string>;
    /**
     * A block indicating a weighted routing policy. Conflicts with any other routing policy. Documented below.
     */
    public readonly weightedRoutingPolicies!: pulumi.Output<outputs.route53.RecordWeightedRoutingPolicy[] | undefined>;
    /**
     * The ID of the hosted zone to contain this record.
     */
    public readonly zoneId!: pulumi.Output<string>;

    /**
     * Create a Record resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: RecordArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: RecordArgs | RecordState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as RecordState | undefined;
            resourceInputs["aliases"] = state ? state.aliases : undefined;
            resourceInputs["allowOverwrite"] = state ? state.allowOverwrite : undefined;
            resourceInputs["cidrRoutingPolicy"] = state ? state.cidrRoutingPolicy : undefined;
            resourceInputs["failoverRoutingPolicies"] = state ? state.failoverRoutingPolicies : undefined;
            resourceInputs["fqdn"] = state ? state.fqdn : undefined;
            resourceInputs["geolocationRoutingPolicies"] = state ? state.geolocationRoutingPolicies : undefined;
            resourceInputs["geoproximityRoutingPolicy"] = state ? state.geoproximityRoutingPolicy : undefined;
            resourceInputs["healthCheckId"] = state ? state.healthCheckId : undefined;
            resourceInputs["latencyRoutingPolicies"] = state ? state.latencyRoutingPolicies : undefined;
            resourceInputs["multivalueAnswerRoutingPolicy"] = state ? state.multivalueAnswerRoutingPolicy : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["records"] = state ? state.records : undefined;
            resourceInputs["setIdentifier"] = state ? state.setIdentifier : undefined;
            resourceInputs["ttl"] = state ? state.ttl : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
            resourceInputs["weightedRoutingPolicies"] = state ? state.weightedRoutingPolicies : undefined;
            resourceInputs["zoneId"] = state ? state.zoneId : undefined;
        } else {
            const args = argsOrState as RecordArgs | undefined;
            if ((!args || args.name === undefined) && !opts.urn) {
                throw new Error("Missing required property 'name'");
            }
            if ((!args || args.type === undefined) && !opts.urn) {
                throw new Error("Missing required property 'type'");
            }
            if ((!args || args.zoneId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'zoneId'");
            }
            resourceInputs["aliases"] = args ? args.aliases : undefined;
            resourceInputs["allowOverwrite"] = args ? args.allowOverwrite : undefined;
            resourceInputs["cidrRoutingPolicy"] = args ? args.cidrRoutingPolicy : undefined;
            resourceInputs["failoverRoutingPolicies"] = args ? args.failoverRoutingPolicies : undefined;
            resourceInputs["geolocationRoutingPolicies"] = args ? args.geolocationRoutingPolicies : undefined;
            resourceInputs["geoproximityRoutingPolicy"] = args ? args.geoproximityRoutingPolicy : undefined;
            resourceInputs["healthCheckId"] = args ? args.healthCheckId : undefined;
            resourceInputs["latencyRoutingPolicies"] = args ? args.latencyRoutingPolicies : undefined;
            resourceInputs["multivalueAnswerRoutingPolicy"] = args ? args.multivalueAnswerRoutingPolicy : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["records"] = args ? args.records : undefined;
            resourceInputs["setIdentifier"] = args ? args.setIdentifier : undefined;
            resourceInputs["ttl"] = args ? args.ttl : undefined;
            resourceInputs["type"] = args ? args.type : undefined;
            resourceInputs["weightedRoutingPolicies"] = args ? args.weightedRoutingPolicies : undefined;
            resourceInputs["zoneId"] = args ? args.zoneId : undefined;
            resourceInputs["fqdn"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Record.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Record resources.
 */
export interface RecordState {
    /**
     * An alias block. Conflicts with `ttl` & `records`.
     * Documented below.
     */
    aliases?: pulumi.Input<pulumi.Input<inputs.route53.RecordAlias>[]>;
    /**
     * Allow creation of this record to overwrite an existing record, if any. This does not affect the ability to update the record using this provider and does not prevent other resources within this provider or manual Route 53 changes outside this provider from overwriting this record. `false` by default. This configuration is not recommended for most environments.
     *
     * Exactly one of `records` or `alias` must be specified: this determines whether it's an alias record.
     */
    allowOverwrite?: pulumi.Input<boolean>;
    /**
     * A block indicating a routing policy based on the IP network ranges of requestors. Conflicts with any other routing policy. Documented below.
     */
    cidrRoutingPolicy?: pulumi.Input<inputs.route53.RecordCidrRoutingPolicy>;
    /**
     * A block indicating the routing behavior when associated health check fails. Conflicts with any other routing policy. Documented below.
     */
    failoverRoutingPolicies?: pulumi.Input<pulumi.Input<inputs.route53.RecordFailoverRoutingPolicy>[]>;
    /**
     * [FQDN](https://en.wikipedia.org/wiki/Fully_qualified_domain_name) built using the zone domain and `name`.
     */
    fqdn?: pulumi.Input<string>;
    /**
     * A block indicating a routing policy based on the geolocation of the requestor. Conflicts with any other routing policy. Documented below.
     */
    geolocationRoutingPolicies?: pulumi.Input<pulumi.Input<inputs.route53.RecordGeolocationRoutingPolicy>[]>;
    /**
     * A block indicating a routing policy based on the geoproximity of the requestor. Conflicts with any other routing policy. Documented below.
     */
    geoproximityRoutingPolicy?: pulumi.Input<inputs.route53.RecordGeoproximityRoutingPolicy>;
    /**
     * The health check the record should be associated with.
     */
    healthCheckId?: pulumi.Input<string>;
    /**
     * A block indicating a routing policy based on the latency between the requestor and an AWS region. Conflicts with any other routing policy. Documented below.
     */
    latencyRoutingPolicies?: pulumi.Input<pulumi.Input<inputs.route53.RecordLatencyRoutingPolicy>[]>;
    /**
     * Set to `true` to indicate a multivalue answer routing policy. Conflicts with any other routing policy.
     */
    multivalueAnswerRoutingPolicy?: pulumi.Input<boolean>;
    /**
     * The name of the record.
     */
    name?: pulumi.Input<string>;
    /**
     * A string list of records. To specify a single record value longer than 255 characters such as a TXT record for DKIM, add `\"\"` inside the provider configuration string (e.g., `"first255characters\"\"morecharacters"`).
     */
    records?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Unique identifier to differentiate records with routing policies from one another. Required if using `cidrRoutingPolicy`, `failoverRoutingPolicy`, `geolocationRoutingPolicy`,`geoproximityRoutingPolicy`, `latencyRoutingPolicy`, `multivalueAnswerRoutingPolicy`, or `weightedRoutingPolicy`.
     */
    setIdentifier?: pulumi.Input<string>;
    /**
     * The TTL of the record.
     */
    ttl?: pulumi.Input<number>;
    /**
     * The record type. Valid values are `A`, `AAAA`, `CAA`, `CNAME`, `DS`, `HTTPS`, `MX`, `NAPTR`, `NS`, `PTR`, `SOA`, `SPF`, `SRV`, `SSHFP`, `SVCB`, `TLSA`, and `TXT`.
     */
    type?: pulumi.Input<string | enums.route53.RecordType>;
    /**
     * A block indicating a weighted routing policy. Conflicts with any other routing policy. Documented below.
     */
    weightedRoutingPolicies?: pulumi.Input<pulumi.Input<inputs.route53.RecordWeightedRoutingPolicy>[]>;
    /**
     * The ID of the hosted zone to contain this record.
     */
    zoneId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Record resource.
 */
export interface RecordArgs {
    /**
     * An alias block. Conflicts with `ttl` & `records`.
     * Documented below.
     */
    aliases?: pulumi.Input<pulumi.Input<inputs.route53.RecordAlias>[]>;
    /**
     * Allow creation of this record to overwrite an existing record, if any. This does not affect the ability to update the record using this provider and does not prevent other resources within this provider or manual Route 53 changes outside this provider from overwriting this record. `false` by default. This configuration is not recommended for most environments.
     *
     * Exactly one of `records` or `alias` must be specified: this determines whether it's an alias record.
     */
    allowOverwrite?: pulumi.Input<boolean>;
    /**
     * A block indicating a routing policy based on the IP network ranges of requestors. Conflicts with any other routing policy. Documented below.
     */
    cidrRoutingPolicy?: pulumi.Input<inputs.route53.RecordCidrRoutingPolicy>;
    /**
     * A block indicating the routing behavior when associated health check fails. Conflicts with any other routing policy. Documented below.
     */
    failoverRoutingPolicies?: pulumi.Input<pulumi.Input<inputs.route53.RecordFailoverRoutingPolicy>[]>;
    /**
     * A block indicating a routing policy based on the geolocation of the requestor. Conflicts with any other routing policy. Documented below.
     */
    geolocationRoutingPolicies?: pulumi.Input<pulumi.Input<inputs.route53.RecordGeolocationRoutingPolicy>[]>;
    /**
     * A block indicating a routing policy based on the geoproximity of the requestor. Conflicts with any other routing policy. Documented below.
     */
    geoproximityRoutingPolicy?: pulumi.Input<inputs.route53.RecordGeoproximityRoutingPolicy>;
    /**
     * The health check the record should be associated with.
     */
    healthCheckId?: pulumi.Input<string>;
    /**
     * A block indicating a routing policy based on the latency between the requestor and an AWS region. Conflicts with any other routing policy. Documented below.
     */
    latencyRoutingPolicies?: pulumi.Input<pulumi.Input<inputs.route53.RecordLatencyRoutingPolicy>[]>;
    /**
     * Set to `true` to indicate a multivalue answer routing policy. Conflicts with any other routing policy.
     */
    multivalueAnswerRoutingPolicy?: pulumi.Input<boolean>;
    /**
     * The name of the record.
     */
    name: pulumi.Input<string>;
    /**
     * A string list of records. To specify a single record value longer than 255 characters such as a TXT record for DKIM, add `\"\"` inside the provider configuration string (e.g., `"first255characters\"\"morecharacters"`).
     */
    records?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Unique identifier to differentiate records with routing policies from one another. Required if using `cidrRoutingPolicy`, `failoverRoutingPolicy`, `geolocationRoutingPolicy`,`geoproximityRoutingPolicy`, `latencyRoutingPolicy`, `multivalueAnswerRoutingPolicy`, or `weightedRoutingPolicy`.
     */
    setIdentifier?: pulumi.Input<string>;
    /**
     * The TTL of the record.
     */
    ttl?: pulumi.Input<number>;
    /**
     * The record type. Valid values are `A`, `AAAA`, `CAA`, `CNAME`, `DS`, `HTTPS`, `MX`, `NAPTR`, `NS`, `PTR`, `SOA`, `SPF`, `SRV`, `SSHFP`, `SVCB`, `TLSA`, and `TXT`.
     */
    type: pulumi.Input<string | enums.route53.RecordType>;
    /**
     * A block indicating a weighted routing policy. Conflicts with any other routing policy. Documented below.
     */
    weightedRoutingPolicies?: pulumi.Input<pulumi.Input<inputs.route53.RecordWeightedRoutingPolicy>[]>;
    /**
     * The ID of the hosted zone to contain this record.
     */
    zoneId: pulumi.Input<string>;
}
