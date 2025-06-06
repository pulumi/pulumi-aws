// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Managing [IoT Thing indexing](https://docs.aws.amazon.com/iot/latest/developerguide/managing-index.html).
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.iot.IndexingConfiguration("example", {thingIndexingConfiguration: {
 *     thingIndexingMode: "REGISTRY_AND_SHADOW",
 *     thingConnectivityIndexingMode: "STATUS",
 *     deviceDefenderIndexingMode: "VIOLATIONS",
 *     namedShadowIndexingMode: "ON",
 *     filter: {
 *         namedShadowNames: ["thing1shadow"],
 *     },
 *     customFields: [
 *         {
 *             name: "shadow.desired.power",
 *             type: "Boolean",
 *         },
 *         {
 *             name: "attributes.version",
 *             type: "Number",
 *         },
 *         {
 *             name: "shadow.name.thing1shadow.desired.DefaultDesired",
 *             type: "String",
 *         },
 *         {
 *             name: "deviceDefender.securityProfile1.NUMBER_VALUE_BEHAVIOR.lastViolationValue.number",
 *             type: "Number",
 *         },
 *     ],
 * }});
 * ```
 */
export class IndexingConfiguration extends pulumi.CustomResource {
    /**
     * Get an existing IndexingConfiguration resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: IndexingConfigurationState, opts?: pulumi.CustomResourceOptions): IndexingConfiguration {
        return new IndexingConfiguration(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:iot/indexingConfiguration:IndexingConfiguration';

    /**
     * Returns true if the given object is an instance of IndexingConfiguration.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is IndexingConfiguration {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === IndexingConfiguration.__pulumiType;
    }

    /**
     * Thing group indexing configuration. See below.
     */
    public readonly thingGroupIndexingConfiguration!: pulumi.Output<outputs.iot.IndexingConfigurationThingGroupIndexingConfiguration>;
    /**
     * Thing indexing configuration. See below.
     */
    public readonly thingIndexingConfiguration!: pulumi.Output<outputs.iot.IndexingConfigurationThingIndexingConfiguration>;

    /**
     * Create a IndexingConfiguration resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: IndexingConfigurationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: IndexingConfigurationArgs | IndexingConfigurationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as IndexingConfigurationState | undefined;
            resourceInputs["thingGroupIndexingConfiguration"] = state ? state.thingGroupIndexingConfiguration : undefined;
            resourceInputs["thingIndexingConfiguration"] = state ? state.thingIndexingConfiguration : undefined;
        } else {
            const args = argsOrState as IndexingConfigurationArgs | undefined;
            resourceInputs["thingGroupIndexingConfiguration"] = args ? args.thingGroupIndexingConfiguration : undefined;
            resourceInputs["thingIndexingConfiguration"] = args ? args.thingIndexingConfiguration : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(IndexingConfiguration.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering IndexingConfiguration resources.
 */
export interface IndexingConfigurationState {
    /**
     * Thing group indexing configuration. See below.
     */
    thingGroupIndexingConfiguration?: pulumi.Input<inputs.iot.IndexingConfigurationThingGroupIndexingConfiguration>;
    /**
     * Thing indexing configuration. See below.
     */
    thingIndexingConfiguration?: pulumi.Input<inputs.iot.IndexingConfigurationThingIndexingConfiguration>;
}

/**
 * The set of arguments for constructing a IndexingConfiguration resource.
 */
export interface IndexingConfigurationArgs {
    /**
     * Thing group indexing configuration. See below.
     */
    thingGroupIndexingConfiguration?: pulumi.Input<inputs.iot.IndexingConfigurationThingGroupIndexingConfiguration>;
    /**
     * Thing indexing configuration. See below.
     */
    thingIndexingConfiguration?: pulumi.Input<inputs.iot.IndexingConfigurationThingIndexingConfiguration>;
}
