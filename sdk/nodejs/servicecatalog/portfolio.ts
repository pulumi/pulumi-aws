// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource to create a Service Catalog Portfolio.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const portfolio = new aws.servicecatalog.Portfolio("portfolio", {
 *     name: "My App Portfolio",
 *     description: "List of my organizations apps",
 *     providerName: "Brett",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Service Catalog Portfolios using the Service Catalog Portfolio `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:servicecatalog/portfolio:Portfolio testfolio port-12344321
 * ```
 */
export class Portfolio extends pulumi.CustomResource {
    /**
     * Get an existing Portfolio resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: PortfolioState, opts?: pulumi.CustomResourceOptions): Portfolio {
        return new Portfolio(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:servicecatalog/portfolio:Portfolio';

    /**
     * Returns true if the given object is an instance of Portfolio.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Portfolio {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Portfolio.__pulumiType;
    }

    public /*out*/ readonly arn!: pulumi.Output<string>;
    public /*out*/ readonly createdTime!: pulumi.Output<string>;
    /**
     * Description of the portfolio
     */
    public readonly description!: pulumi.Output<string>;
    /**
     * The name of the portfolio.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Name of the person or organization who owns the portfolio.
     */
    public readonly providerName!: pulumi.Output<string>;
    /**
     * Tags to apply to the connection. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a Portfolio resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: PortfolioArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: PortfolioArgs | PortfolioState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as PortfolioState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["createdTime"] = state ? state.createdTime : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["providerName"] = state ? state.providerName : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as PortfolioArgs | undefined;
            if ((!args || args.providerName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'providerName'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["providerName"] = args ? args.providerName : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["createdTime"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Portfolio.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Portfolio resources.
 */
export interface PortfolioState {
    arn?: pulumi.Input<string>;
    createdTime?: pulumi.Input<string>;
    /**
     * Description of the portfolio
     */
    description?: pulumi.Input<string>;
    /**
     * The name of the portfolio.
     */
    name?: pulumi.Input<string>;
    /**
     * Name of the person or organization who owns the portfolio.
     */
    providerName?: pulumi.Input<string>;
    /**
     * Tags to apply to the connection. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a Portfolio resource.
 */
export interface PortfolioArgs {
    /**
     * Description of the portfolio
     */
    description?: pulumi.Input<string>;
    /**
     * The name of the portfolio.
     */
    name?: pulumi.Input<string>;
    /**
     * Name of the person or organization who owns the portfolio.
     */
    providerName: pulumi.Input<string>;
    /**
     * Tags to apply to the connection. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
