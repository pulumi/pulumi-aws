// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Creates a replica of an existing EFS file system in the same or another region. Creating this resource causes the source EFS file system to be replicated to a new read-only destination EFS file system (unless using the `destination.file_system_id` attribute). Deleting this resource will cause the replication from source to destination to stop and the destination file system will no longer be read only.
 *
 * > **NOTE:** Deleting this resource does **not** delete the destination file system that was created.
 *
 * ## Example Usage
 *
 * Will create a replica using regional storage in us-west-2 that will be encrypted by the default EFS KMS key `/aws/elasticfilesystem`.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.efs.FileSystem("example", {});
 * const exampleReplicationConfiguration = new aws.efs.ReplicationConfiguration("example", {
 *     sourceFileSystemId: example.id,
 *     destination: {
 *         region: "us-west-2",
 *     },
 * });
 * ```
 *
 * Replica will be created as One Zone storage in the us-west-2b Availability Zone and encrypted with the specified KMS key.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.efs.FileSystem("example", {});
 * const exampleReplicationConfiguration = new aws.efs.ReplicationConfiguration("example", {
 *     sourceFileSystemId: example.id,
 *     destination: {
 *         availabilityZoneName: "us-west-2b",
 *         kmsKeyId: "1234abcd-12ab-34cd-56ef-1234567890ab",
 *     },
 * });
 * ```
 *
 * Will create a replica and set the existing file system with id `fs-1234567890` in us-west-2 as destination.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.efs.FileSystem("example", {});
 * const exampleReplicationConfiguration = new aws.efs.ReplicationConfiguration("example", {
 *     sourceFileSystemId: example.id,
 *     destination: {
 *         fileSystemId: "fs-1234567890",
 *         region: "us-west-2",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import EFS Replication Configurations using the file system ID of either the source or destination file system. When importing, the `availability_zone_name` and `kms_key_id` attributes must __not__ be set in the configuration. The AWS API does not return these values when querying the replication configuration and their presence will therefore show as a diff in a subsequent plan. For example:
 *
 * ```sh
 * $ pulumi import aws:efs/replicationConfiguration:ReplicationConfiguration example fs-id
 * ```
 */
export class ReplicationConfiguration extends pulumi.CustomResource {
    /**
     * Get an existing ReplicationConfiguration resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ReplicationConfigurationState, opts?: pulumi.CustomResourceOptions): ReplicationConfiguration {
        return new ReplicationConfiguration(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:efs/replicationConfiguration:ReplicationConfiguration';

    /**
     * Returns true if the given object is an instance of ReplicationConfiguration.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ReplicationConfiguration {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ReplicationConfiguration.__pulumiType;
    }

    /**
     * When the replication configuration was created.
     * * `destination[0].file_system_id` - The fs ID of the replica.
     * * `destination[0].status` - The status of the replication.
     */
    public /*out*/ readonly creationTime!: pulumi.Output<string>;
    /**
     * A destination configuration block (documented below).
     */
    public readonly destination!: pulumi.Output<outputs.efs.ReplicationConfigurationDestination>;
    /**
     * The Amazon Resource Name (ARN) of the original source Amazon EFS file system in the replication configuration.
     */
    public /*out*/ readonly originalSourceFileSystemArn!: pulumi.Output<string>;
    /**
     * The Amazon Resource Name (ARN) of the current source file system in the replication configuration.
     */
    public /*out*/ readonly sourceFileSystemArn!: pulumi.Output<string>;
    /**
     * The ID of the file system that is to be replicated.
     */
    public readonly sourceFileSystemId!: pulumi.Output<string>;
    /**
     * The AWS Region in which the source Amazon EFS file system is located.
     */
    public /*out*/ readonly sourceFileSystemRegion!: pulumi.Output<string>;

    /**
     * Create a ReplicationConfiguration resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ReplicationConfigurationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ReplicationConfigurationArgs | ReplicationConfigurationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ReplicationConfigurationState | undefined;
            resourceInputs["creationTime"] = state ? state.creationTime : undefined;
            resourceInputs["destination"] = state ? state.destination : undefined;
            resourceInputs["originalSourceFileSystemArn"] = state ? state.originalSourceFileSystemArn : undefined;
            resourceInputs["sourceFileSystemArn"] = state ? state.sourceFileSystemArn : undefined;
            resourceInputs["sourceFileSystemId"] = state ? state.sourceFileSystemId : undefined;
            resourceInputs["sourceFileSystemRegion"] = state ? state.sourceFileSystemRegion : undefined;
        } else {
            const args = argsOrState as ReplicationConfigurationArgs | undefined;
            if ((!args || args.destination === undefined) && !opts.urn) {
                throw new Error("Missing required property 'destination'");
            }
            if ((!args || args.sourceFileSystemId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'sourceFileSystemId'");
            }
            resourceInputs["destination"] = args ? args.destination : undefined;
            resourceInputs["sourceFileSystemId"] = args ? args.sourceFileSystemId : undefined;
            resourceInputs["creationTime"] = undefined /*out*/;
            resourceInputs["originalSourceFileSystemArn"] = undefined /*out*/;
            resourceInputs["sourceFileSystemArn"] = undefined /*out*/;
            resourceInputs["sourceFileSystemRegion"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ReplicationConfiguration.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ReplicationConfiguration resources.
 */
export interface ReplicationConfigurationState {
    /**
     * When the replication configuration was created.
     * * `destination[0].file_system_id` - The fs ID of the replica.
     * * `destination[0].status` - The status of the replication.
     */
    creationTime?: pulumi.Input<string>;
    /**
     * A destination configuration block (documented below).
     */
    destination?: pulumi.Input<inputs.efs.ReplicationConfigurationDestination>;
    /**
     * The Amazon Resource Name (ARN) of the original source Amazon EFS file system in the replication configuration.
     */
    originalSourceFileSystemArn?: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) of the current source file system in the replication configuration.
     */
    sourceFileSystemArn?: pulumi.Input<string>;
    /**
     * The ID of the file system that is to be replicated.
     */
    sourceFileSystemId?: pulumi.Input<string>;
    /**
     * The AWS Region in which the source Amazon EFS file system is located.
     */
    sourceFileSystemRegion?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a ReplicationConfiguration resource.
 */
export interface ReplicationConfigurationArgs {
    /**
     * A destination configuration block (documented below).
     */
    destination: pulumi.Input<inputs.efs.ReplicationConfigurationDestination>;
    /**
     * The ID of the file system that is to be replicated.
     */
    sourceFileSystemId: pulumi.Input<string>;
}
