// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS Service Quotas Template.
 *
 * > Only the management account of an organization can alter Service Quota templates, and this must be done from the `us-east-1` region.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.servicequotas.Template("example", {
 *     region: "us-east-1",
 *     quotaCode: "L-2ACBD22F",
 *     serviceCode: "lambda",
 *     value: 80,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Service Quotas Template using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:servicequotas/template:Template example us-east-1,L-2ACBD22F,lambda
 * ```
 */
export class Template extends pulumi.CustomResource {
    /**
     * Get an existing Template resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: TemplateState, opts?: pulumi.CustomResourceOptions): Template {
        return new Template(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:servicequotas/template:Template';

    /**
     * Returns true if the given object is an instance of Template.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Template {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Template.__pulumiType;
    }

    /**
     * Indicates whether the quota is global.
     */
    public /*out*/ readonly globalQuota!: pulumi.Output<boolean>;
    /**
     * Quota identifier. To find the quota code for a specific quota, use the aws.servicequotas.ServiceQuota data source.
     */
    public readonly quotaCode!: pulumi.Output<string>;
    /**
     * Quota name.
     */
    public /*out*/ readonly quotaName!: pulumi.Output<string>;
    /**
     * AWS Region to which the template applies.
     */
    public readonly region!: pulumi.Output<string>;
    /**
     * Service identifier. To find the service code value for an AWS service, use the aws.servicequotas.getService data source.
     */
    public readonly serviceCode!: pulumi.Output<string>;
    /**
     * Service name.
     */
    public /*out*/ readonly serviceName!: pulumi.Output<string>;
    /**
     * Unit of measurement.
     */
    public /*out*/ readonly unit!: pulumi.Output<string>;
    /**
     * The new, increased value for the quota.
     */
    public readonly value!: pulumi.Output<number>;

    /**
     * Create a Template resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: TemplateArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: TemplateArgs | TemplateState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as TemplateState | undefined;
            resourceInputs["globalQuota"] = state ? state.globalQuota : undefined;
            resourceInputs["quotaCode"] = state ? state.quotaCode : undefined;
            resourceInputs["quotaName"] = state ? state.quotaName : undefined;
            resourceInputs["region"] = state ? state.region : undefined;
            resourceInputs["serviceCode"] = state ? state.serviceCode : undefined;
            resourceInputs["serviceName"] = state ? state.serviceName : undefined;
            resourceInputs["unit"] = state ? state.unit : undefined;
            resourceInputs["value"] = state ? state.value : undefined;
        } else {
            const args = argsOrState as TemplateArgs | undefined;
            if ((!args || args.quotaCode === undefined) && !opts.urn) {
                throw new Error("Missing required property 'quotaCode'");
            }
            if ((!args || args.region === undefined) && !opts.urn) {
                throw new Error("Missing required property 'region'");
            }
            if ((!args || args.serviceCode === undefined) && !opts.urn) {
                throw new Error("Missing required property 'serviceCode'");
            }
            if ((!args || args.value === undefined) && !opts.urn) {
                throw new Error("Missing required property 'value'");
            }
            resourceInputs["quotaCode"] = args ? args.quotaCode : undefined;
            resourceInputs["region"] = args ? args.region : undefined;
            resourceInputs["serviceCode"] = args ? args.serviceCode : undefined;
            resourceInputs["value"] = args ? args.value : undefined;
            resourceInputs["globalQuota"] = undefined /*out*/;
            resourceInputs["quotaName"] = undefined /*out*/;
            resourceInputs["serviceName"] = undefined /*out*/;
            resourceInputs["unit"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Template.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Template resources.
 */
export interface TemplateState {
    /**
     * Indicates whether the quota is global.
     */
    globalQuota?: pulumi.Input<boolean>;
    /**
     * Quota identifier. To find the quota code for a specific quota, use the aws.servicequotas.ServiceQuota data source.
     */
    quotaCode?: pulumi.Input<string>;
    /**
     * Quota name.
     */
    quotaName?: pulumi.Input<string>;
    /**
     * AWS Region to which the template applies.
     */
    region?: pulumi.Input<string>;
    /**
     * Service identifier. To find the service code value for an AWS service, use the aws.servicequotas.getService data source.
     */
    serviceCode?: pulumi.Input<string>;
    /**
     * Service name.
     */
    serviceName?: pulumi.Input<string>;
    /**
     * Unit of measurement.
     */
    unit?: pulumi.Input<string>;
    /**
     * The new, increased value for the quota.
     */
    value?: pulumi.Input<number>;
}

/**
 * The set of arguments for constructing a Template resource.
 */
export interface TemplateArgs {
    /**
     * Quota identifier. To find the quota code for a specific quota, use the aws.servicequotas.ServiceQuota data source.
     */
    quotaCode: pulumi.Input<string>;
    /**
     * AWS Region to which the template applies.
     */
    region: pulumi.Input<string>;
    /**
     * Service identifier. To find the service code value for an AWS service, use the aws.servicequotas.getService data source.
     */
    serviceCode: pulumi.Input<string>;
    /**
     * The new, increased value for the quota.
     */
    value: pulumi.Input<number>;
}
