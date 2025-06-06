// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Manages an EMR Serverless Application.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.emrserverless.Application("example", {
 *     name: "example",
 *     releaseLabel: "emr-6.6.0",
 *     type: "hive",
 * });
 * ```
 *
 * ### Initial Capacity Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.emrserverless.Application("example", {
 *     name: "example",
 *     releaseLabel: "emr-6.6.0",
 *     type: "hive",
 *     initialCapacities: [{
 *         initialCapacityType: "HiveDriver",
 *         initialCapacityConfig: {
 *             workerCount: 1,
 *             workerConfiguration: {
 *                 cpu: "2 vCPU",
 *                 memory: "10 GB",
 *             },
 *         },
 *     }],
 * });
 * ```
 *
 * ### Maximum Capacity Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.emrserverless.Application("example", {
 *     name: "example",
 *     releaseLabel: "emr-6.6.0",
 *     type: "hive",
 *     maximumCapacity: {
 *         cpu: "2 vCPU",
 *         memory: "10 GB",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import EMR Severless applications using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:emrserverless/application:Application example id
 * ```
 */
export class Application extends pulumi.CustomResource {
    /**
     * Get an existing Application resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ApplicationState, opts?: pulumi.CustomResourceOptions): Application {
        return new Application(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:emrserverless/application:Application';

    /**
     * Returns true if the given object is an instance of Application.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Application {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Application.__pulumiType;
    }

    /**
     * The CPU architecture of an application. Valid values are `ARM64` or `X86_64`. Default value is `X86_64`.
     */
    public readonly architecture!: pulumi.Output<string | undefined>;
    /**
     * ARN of the cluster.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The configuration for an application to automatically start on job submission.
     */
    public readonly autoStartConfiguration!: pulumi.Output<outputs.emrserverless.ApplicationAutoStartConfiguration>;
    /**
     * The configuration for an application to automatically stop after a certain amount of time being idle.
     */
    public readonly autoStopConfiguration!: pulumi.Output<outputs.emrserverless.ApplicationAutoStopConfiguration>;
    /**
     * The image configuration applied to all worker types.
     */
    public readonly imageConfiguration!: pulumi.Output<outputs.emrserverless.ApplicationImageConfiguration>;
    /**
     * The capacity to initialize when the application is created.
     */
    public readonly initialCapacities!: pulumi.Output<outputs.emrserverless.ApplicationInitialCapacity[] | undefined>;
    /**
     * Enables the interactive use cases to use when running an application.
     */
    public readonly interactiveConfiguration!: pulumi.Output<outputs.emrserverless.ApplicationInteractiveConfiguration>;
    /**
     * The maximum capacity to allocate when the application is created. This is cumulative across all workers at any given point in time, not just when an application is created. No new resources will be created once any one of the defined limits is hit.
     */
    public readonly maximumCapacity!: pulumi.Output<outputs.emrserverless.ApplicationMaximumCapacity>;
    /**
     * The name of the application.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The network configuration for customer VPC connectivity.
     */
    public readonly networkConfiguration!: pulumi.Output<outputs.emrserverless.ApplicationNetworkConfiguration | undefined>;
    /**
     * The EMR release version associated with the application.
     */
    public readonly releaseLabel!: pulumi.Output<string>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The type of application you want to start, such as `spark` or `hive`.
     */
    public readonly type!: pulumi.Output<string>;

    /**
     * Create a Application resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ApplicationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ApplicationArgs | ApplicationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ApplicationState | undefined;
            resourceInputs["architecture"] = state ? state.architecture : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["autoStartConfiguration"] = state ? state.autoStartConfiguration : undefined;
            resourceInputs["autoStopConfiguration"] = state ? state.autoStopConfiguration : undefined;
            resourceInputs["imageConfiguration"] = state ? state.imageConfiguration : undefined;
            resourceInputs["initialCapacities"] = state ? state.initialCapacities : undefined;
            resourceInputs["interactiveConfiguration"] = state ? state.interactiveConfiguration : undefined;
            resourceInputs["maximumCapacity"] = state ? state.maximumCapacity : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["networkConfiguration"] = state ? state.networkConfiguration : undefined;
            resourceInputs["releaseLabel"] = state ? state.releaseLabel : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
        } else {
            const args = argsOrState as ApplicationArgs | undefined;
            if ((!args || args.releaseLabel === undefined) && !opts.urn) {
                throw new Error("Missing required property 'releaseLabel'");
            }
            if ((!args || args.type === undefined) && !opts.urn) {
                throw new Error("Missing required property 'type'");
            }
            resourceInputs["architecture"] = args ? args.architecture : undefined;
            resourceInputs["autoStartConfiguration"] = args ? args.autoStartConfiguration : undefined;
            resourceInputs["autoStopConfiguration"] = args ? args.autoStopConfiguration : undefined;
            resourceInputs["imageConfiguration"] = args ? args.imageConfiguration : undefined;
            resourceInputs["initialCapacities"] = args ? args.initialCapacities : undefined;
            resourceInputs["interactiveConfiguration"] = args ? args.interactiveConfiguration : undefined;
            resourceInputs["maximumCapacity"] = args ? args.maximumCapacity : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["networkConfiguration"] = args ? args.networkConfiguration : undefined;
            resourceInputs["releaseLabel"] = args ? args.releaseLabel : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["type"] = args ? args.type : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Application.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Application resources.
 */
export interface ApplicationState {
    /**
     * The CPU architecture of an application. Valid values are `ARM64` or `X86_64`. Default value is `X86_64`.
     */
    architecture?: pulumi.Input<string>;
    /**
     * ARN of the cluster.
     */
    arn?: pulumi.Input<string>;
    /**
     * The configuration for an application to automatically start on job submission.
     */
    autoStartConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationAutoStartConfiguration>;
    /**
     * The configuration for an application to automatically stop after a certain amount of time being idle.
     */
    autoStopConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationAutoStopConfiguration>;
    /**
     * The image configuration applied to all worker types.
     */
    imageConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationImageConfiguration>;
    /**
     * The capacity to initialize when the application is created.
     */
    initialCapacities?: pulumi.Input<pulumi.Input<inputs.emrserverless.ApplicationInitialCapacity>[]>;
    /**
     * Enables the interactive use cases to use when running an application.
     */
    interactiveConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationInteractiveConfiguration>;
    /**
     * The maximum capacity to allocate when the application is created. This is cumulative across all workers at any given point in time, not just when an application is created. No new resources will be created once any one of the defined limits is hit.
     */
    maximumCapacity?: pulumi.Input<inputs.emrserverless.ApplicationMaximumCapacity>;
    /**
     * The name of the application.
     */
    name?: pulumi.Input<string>;
    /**
     * The network configuration for customer VPC connectivity.
     */
    networkConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationNetworkConfiguration>;
    /**
     * The EMR release version associated with the application.
     */
    releaseLabel?: pulumi.Input<string>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The type of application you want to start, such as `spark` or `hive`.
     */
    type?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Application resource.
 */
export interface ApplicationArgs {
    /**
     * The CPU architecture of an application. Valid values are `ARM64` or `X86_64`. Default value is `X86_64`.
     */
    architecture?: pulumi.Input<string>;
    /**
     * The configuration for an application to automatically start on job submission.
     */
    autoStartConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationAutoStartConfiguration>;
    /**
     * The configuration for an application to automatically stop after a certain amount of time being idle.
     */
    autoStopConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationAutoStopConfiguration>;
    /**
     * The image configuration applied to all worker types.
     */
    imageConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationImageConfiguration>;
    /**
     * The capacity to initialize when the application is created.
     */
    initialCapacities?: pulumi.Input<pulumi.Input<inputs.emrserverless.ApplicationInitialCapacity>[]>;
    /**
     * Enables the interactive use cases to use when running an application.
     */
    interactiveConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationInteractiveConfiguration>;
    /**
     * The maximum capacity to allocate when the application is created. This is cumulative across all workers at any given point in time, not just when an application is created. No new resources will be created once any one of the defined limits is hit.
     */
    maximumCapacity?: pulumi.Input<inputs.emrserverless.ApplicationMaximumCapacity>;
    /**
     * The name of the application.
     */
    name?: pulumi.Input<string>;
    /**
     * The network configuration for customer VPC connectivity.
     */
    networkConfiguration?: pulumi.Input<inputs.emrserverless.ApplicationNetworkConfiguration>;
    /**
     * The EMR release version associated with the application.
     */
    releaseLabel: pulumi.Input<string>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The type of application you want to start, such as `spark` or `hive`.
     */
    type: pulumi.Input<string>;
}
