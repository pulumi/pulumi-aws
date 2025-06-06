// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS FinSpace Kx Volume.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.finspace.KxVolume("example", {
 *     name: "my-tf-kx-volume",
 *     environmentId: exampleAwsFinspaceKxEnvironment.id,
 *     availabilityZones: "use1-az2",
 *     azMode: "SINGLE",
 *     type: "NAS_1",
 *     nas1Configurations: [{
 *         size: 1200,
 *         type: "SSD_250",
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import an AWS FinSpace Kx Volume using the `id` (environment ID and volume name, comma-delimited). For example:
 *
 * ```sh
 * $ pulumi import aws:finspace/kxVolume:KxVolume example n3ceo7wqxoxcti5tujqwzs,my-tf-kx-volume
 * ```
 */
export class KxVolume extends pulumi.CustomResource {
    /**
     * Get an existing KxVolume resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: KxVolumeState, opts?: pulumi.CustomResourceOptions): KxVolume {
        return new KxVolume(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:finspace/kxVolume:KxVolume';

    /**
     * Returns true if the given object is an instance of KxVolume.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is KxVolume {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === KxVolume.__pulumiType;
    }

    /**
     * Amazon Resource Name (ARN) identifier of the KX volume.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    public /*out*/ readonly attachedClusters!: pulumi.Output<outputs.finspace.KxVolumeAttachedCluster[]>;
    /**
     * The identifier of the AWS Availability Zone IDs.
     *
     * The following arguments are optional:
     */
    public readonly availabilityZones!: pulumi.Output<string[]>;
    /**
     * The number of availability zones you want to assign per volume. Currently, Finspace only support SINGLE for volumes.
     * * `SINGLE` - Assigns one availability zone per volume.
     */
    public readonly azMode!: pulumi.Output<string>;
    /**
     * The timestamp at which the volume was created in FinSpace. The value is determined as epoch time in milliseconds. For example, the value for Monday, November 1, 2021 12:00:00 PM UTC is specified as 1635768000000.
     */
    public /*out*/ readonly createdTimestamp!: pulumi.Output<string>;
    /**
     * Description of the volume.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * A unique identifier for the kdb environment, whose clusters can attach to the volume.
     */
    public readonly environmentId!: pulumi.Output<string>;
    /**
     * Last timestamp at which the volume was updated in FinSpace. Value determined as epoch time in seconds. For example, the value for Monday, November 1, 2021 12:00:00 PM UTC is specified as 1635768000.
     */
    public /*out*/ readonly lastModifiedTimestamp!: pulumi.Output<string>;
    /**
     * Unique name for the volumr that you want to create.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Specifies the configuration for the Network attached storage (`NAS_1`) file system volume. This parameter is required when `volumeType` is `NAS_1`. See `nas1Configuration` Argument Reference below.
     */
    public readonly nas1Configurations!: pulumi.Output<outputs.finspace.KxVolumeNas1Configuration[] | undefined>;
    /**
     * The status of volume creation.
     * * `CREATING` – The volume creation is in progress.
     * * `CREATE_FAILED` – The volume creation has failed.
     * * `ACTIVE` – The volume is active.
     * * `UPDATING` – The volume is in the process of being updated.
     * * `UPDATE_FAILED` – The update action failed.
     * * `UPDATED` – The volume is successfully updated.
     * * `DELETING` – The volume is in the process of being deleted.
     * * `DELETE_FAILED` – The system failed to delete the volume.
     * * `DELETED` – The volume is successfully deleted.
     */
    public /*out*/ readonly status!: pulumi.Output<string>;
    /**
     * The error message when a failed state occurs.
     */
    public /*out*/ readonly statusReason!: pulumi.Output<string>;
    /**
     * A list of key-value pairs to label the volume. You can add up to 50 tags to a volume
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The type of file system volume. Currently, FinSpace only supports the `NAS_1` volume type. When you select the `NAS_1` volume type, you must also provide `nas1Configuration`.
     */
    public readonly type!: pulumi.Output<string>;

    /**
     * Create a KxVolume resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: KxVolumeArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: KxVolumeArgs | KxVolumeState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as KxVolumeState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["attachedClusters"] = state ? state.attachedClusters : undefined;
            resourceInputs["availabilityZones"] = state ? state.availabilityZones : undefined;
            resourceInputs["azMode"] = state ? state.azMode : undefined;
            resourceInputs["createdTimestamp"] = state ? state.createdTimestamp : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["environmentId"] = state ? state.environmentId : undefined;
            resourceInputs["lastModifiedTimestamp"] = state ? state.lastModifiedTimestamp : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["nas1Configurations"] = state ? state.nas1Configurations : undefined;
            resourceInputs["status"] = state ? state.status : undefined;
            resourceInputs["statusReason"] = state ? state.statusReason : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
        } else {
            const args = argsOrState as KxVolumeArgs | undefined;
            if ((!args || args.availabilityZones === undefined) && !opts.urn) {
                throw new Error("Missing required property 'availabilityZones'");
            }
            if ((!args || args.azMode === undefined) && !opts.urn) {
                throw new Error("Missing required property 'azMode'");
            }
            if ((!args || args.environmentId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'environmentId'");
            }
            if ((!args || args.type === undefined) && !opts.urn) {
                throw new Error("Missing required property 'type'");
            }
            resourceInputs["availabilityZones"] = args ? args.availabilityZones : undefined;
            resourceInputs["azMode"] = args ? args.azMode : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["environmentId"] = args ? args.environmentId : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["nas1Configurations"] = args ? args.nas1Configurations : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["type"] = args ? args.type : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["attachedClusters"] = undefined /*out*/;
            resourceInputs["createdTimestamp"] = undefined /*out*/;
            resourceInputs["lastModifiedTimestamp"] = undefined /*out*/;
            resourceInputs["status"] = undefined /*out*/;
            resourceInputs["statusReason"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(KxVolume.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering KxVolume resources.
 */
export interface KxVolumeState {
    /**
     * Amazon Resource Name (ARN) identifier of the KX volume.
     */
    arn?: pulumi.Input<string>;
    attachedClusters?: pulumi.Input<pulumi.Input<inputs.finspace.KxVolumeAttachedCluster>[]>;
    /**
     * The identifier of the AWS Availability Zone IDs.
     *
     * The following arguments are optional:
     */
    availabilityZones?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The number of availability zones you want to assign per volume. Currently, Finspace only support SINGLE for volumes.
     * * `SINGLE` - Assigns one availability zone per volume.
     */
    azMode?: pulumi.Input<string>;
    /**
     * The timestamp at which the volume was created in FinSpace. The value is determined as epoch time in milliseconds. For example, the value for Monday, November 1, 2021 12:00:00 PM UTC is specified as 1635768000000.
     */
    createdTimestamp?: pulumi.Input<string>;
    /**
     * Description of the volume.
     */
    description?: pulumi.Input<string>;
    /**
     * A unique identifier for the kdb environment, whose clusters can attach to the volume.
     */
    environmentId?: pulumi.Input<string>;
    /**
     * Last timestamp at which the volume was updated in FinSpace. Value determined as epoch time in seconds. For example, the value for Monday, November 1, 2021 12:00:00 PM UTC is specified as 1635768000.
     */
    lastModifiedTimestamp?: pulumi.Input<string>;
    /**
     * Unique name for the volumr that you want to create.
     */
    name?: pulumi.Input<string>;
    /**
     * Specifies the configuration for the Network attached storage (`NAS_1`) file system volume. This parameter is required when `volumeType` is `NAS_1`. See `nas1Configuration` Argument Reference below.
     */
    nas1Configurations?: pulumi.Input<pulumi.Input<inputs.finspace.KxVolumeNas1Configuration>[]>;
    /**
     * The status of volume creation.
     * * `CREATING` – The volume creation is in progress.
     * * `CREATE_FAILED` – The volume creation has failed.
     * * `ACTIVE` – The volume is active.
     * * `UPDATING` – The volume is in the process of being updated.
     * * `UPDATE_FAILED` – The update action failed.
     * * `UPDATED` – The volume is successfully updated.
     * * `DELETING` – The volume is in the process of being deleted.
     * * `DELETE_FAILED` – The system failed to delete the volume.
     * * `DELETED` – The volume is successfully deleted.
     */
    status?: pulumi.Input<string>;
    /**
     * The error message when a failed state occurs.
     */
    statusReason?: pulumi.Input<string>;
    /**
     * A list of key-value pairs to label the volume. You can add up to 50 tags to a volume
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The type of file system volume. Currently, FinSpace only supports the `NAS_1` volume type. When you select the `NAS_1` volume type, you must also provide `nas1Configuration`.
     */
    type?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a KxVolume resource.
 */
export interface KxVolumeArgs {
    /**
     * The identifier of the AWS Availability Zone IDs.
     *
     * The following arguments are optional:
     */
    availabilityZones: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The number of availability zones you want to assign per volume. Currently, Finspace only support SINGLE for volumes.
     * * `SINGLE` - Assigns one availability zone per volume.
     */
    azMode: pulumi.Input<string>;
    /**
     * Description of the volume.
     */
    description?: pulumi.Input<string>;
    /**
     * A unique identifier for the kdb environment, whose clusters can attach to the volume.
     */
    environmentId: pulumi.Input<string>;
    /**
     * Unique name for the volumr that you want to create.
     */
    name?: pulumi.Input<string>;
    /**
     * Specifies the configuration for the Network attached storage (`NAS_1`) file system volume. This parameter is required when `volumeType` is `NAS_1`. See `nas1Configuration` Argument Reference below.
     */
    nas1Configurations?: pulumi.Input<pulumi.Input<inputs.finspace.KxVolumeNas1Configuration>[]>;
    /**
     * A list of key-value pairs to label the volume. You can add up to 50 tags to a volume
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The type of file system volume. Currently, FinSpace only supports the `NAS_1` volume type. When you select the `NAS_1` volume type, you must also provide `nas1Configuration`.
     */
    type: pulumi.Input<string>;
}
