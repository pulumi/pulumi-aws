// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Manages an Amazon API Gateway Version 2 domain name.
 * More information can be found in the [Amazon API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-custom-domains.html).
 *
 * > **Note:** This resource establishes ownership of and the TLS settings for
 * a particular domain name. An API stage can be associated with the domain name using the `aws.apigatewayv2.ApiMapping` resource.
 *
 * ## Example Usage
 *
 * ### Basic
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.apigatewayv2.DomainName("example", {
 *     domainName: "ws-api.example.com",
 *     domainNameConfiguration: {
 *         certificateArn: exampleAwsAcmCertificate.arn,
 *         endpointType: "REGIONAL",
 *         securityPolicy: "TLS_1_2",
 *     },
 * });
 * ```
 *
 * ### Associated Route 53 Resource Record
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.apigatewayv2.DomainName("example", {
 *     domainName: "http-api.example.com",
 *     domainNameConfiguration: {
 *         certificateArn: exampleAwsAcmCertificate.arn,
 *         endpointType: "REGIONAL",
 *         securityPolicy: "TLS_1_2",
 *     },
 * });
 * const exampleRecord = new aws.route53.Record("example", {
 *     name: example.domainName,
 *     type: aws.route53.RecordType.A,
 *     zoneId: exampleAwsRoute53Zone.zoneId,
 *     aliases: [{
 *         name: example.domainNameConfiguration.apply(domainNameConfiguration => domainNameConfiguration.targetDomainName),
 *         zoneId: example.domainNameConfiguration.apply(domainNameConfiguration => domainNameConfiguration.hostedZoneId),
 *         evaluateTargetHealth: false,
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_apigatewayv2_domain_name` using the domain name. For example:
 *
 * ```sh
 * $ pulumi import aws:apigatewayv2/domainName:DomainName example ws-api.example.com
 * ```
 */
export class DomainName extends pulumi.CustomResource {
    /**
     * Get an existing DomainName resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DomainNameState, opts?: pulumi.CustomResourceOptions): DomainName {
        return new DomainName(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:apigatewayv2/domainName:DomainName';

    /**
     * Returns true if the given object is an instance of DomainName.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is DomainName {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === DomainName.__pulumiType;
    }

    /**
     * [API mapping selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-mapping-selection-expressions) for the domain name.
     */
    public /*out*/ readonly apiMappingSelectionExpression!: pulumi.Output<string>;
    /**
     * ARN of the domain name.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Domain name. Must be between 1 and 512 characters in length.
     */
    public readonly domainName!: pulumi.Output<string>;
    /**
     * Domain name configuration. See below.
     */
    public readonly domainNameConfiguration!: pulumi.Output<outputs.apigatewayv2.DomainNameDomainNameConfiguration>;
    /**
     * Mutual TLS authentication configuration for the domain name.
     */
    public readonly mutualTlsAuthentication!: pulumi.Output<outputs.apigatewayv2.DomainNameMutualTlsAuthentication | undefined>;
    /**
     * Map of tags to assign to the domain name. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a DomainName resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: DomainNameArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DomainNameArgs | DomainNameState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DomainNameState | undefined;
            resourceInputs["apiMappingSelectionExpression"] = state ? state.apiMappingSelectionExpression : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["domainName"] = state ? state.domainName : undefined;
            resourceInputs["domainNameConfiguration"] = state ? state.domainNameConfiguration : undefined;
            resourceInputs["mutualTlsAuthentication"] = state ? state.mutualTlsAuthentication : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as DomainNameArgs | undefined;
            if ((!args || args.domainName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'domainName'");
            }
            if ((!args || args.domainNameConfiguration === undefined) && !opts.urn) {
                throw new Error("Missing required property 'domainNameConfiguration'");
            }
            resourceInputs["domainName"] = args ? args.domainName : undefined;
            resourceInputs["domainNameConfiguration"] = args ? args.domainNameConfiguration : undefined;
            resourceInputs["mutualTlsAuthentication"] = args ? args.mutualTlsAuthentication : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["apiMappingSelectionExpression"] = undefined /*out*/;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(DomainName.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering DomainName resources.
 */
export interface DomainNameState {
    /**
     * [API mapping selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-mapping-selection-expressions) for the domain name.
     */
    apiMappingSelectionExpression?: pulumi.Input<string>;
    /**
     * ARN of the domain name.
     */
    arn?: pulumi.Input<string>;
    /**
     * Domain name. Must be between 1 and 512 characters in length.
     */
    domainName?: pulumi.Input<string>;
    /**
     * Domain name configuration. See below.
     */
    domainNameConfiguration?: pulumi.Input<inputs.apigatewayv2.DomainNameDomainNameConfiguration>;
    /**
     * Mutual TLS authentication configuration for the domain name.
     */
    mutualTlsAuthentication?: pulumi.Input<inputs.apigatewayv2.DomainNameMutualTlsAuthentication>;
    /**
     * Map of tags to assign to the domain name. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a DomainName resource.
 */
export interface DomainNameArgs {
    /**
     * Domain name. Must be between 1 and 512 characters in length.
     */
    domainName: pulumi.Input<string>;
    /**
     * Domain name configuration. See below.
     */
    domainNameConfiguration: pulumi.Input<inputs.apigatewayv2.DomainNameDomainNameConfiguration>;
    /**
     * Mutual TLS authentication configuration for the domain name.
     */
    mutualTlsAuthentication?: pulumi.Input<inputs.apigatewayv2.DomainNameMutualTlsAuthentication>;
    /**
     * Map of tags to assign to the domain name. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
