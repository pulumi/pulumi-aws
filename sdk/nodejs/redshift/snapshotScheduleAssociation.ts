// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const _default = new aws.redshift.Cluster("default", {
 *     clusterIdentifier: "tf-redshift-cluster",
 *     databaseName: "mydb",
 *     masterUsername: "foo",
 *     masterPassword: "Mustbe8characters",
 *     nodeType: "dc1.large",
 *     clusterType: "single-node",
 * });
 * const defaultSnapshotSchedule = new aws.redshift.SnapshotSchedule("default", {
 *     identifier: "tf-redshift-snapshot-schedule",
 *     definitions: ["rate(12 hours)"],
 * });
 * const defaultSnapshotScheduleAssociation = new aws.redshift.SnapshotScheduleAssociation("default", {
 *     clusterIdentifier: _default.id,
 *     scheduleIdentifier: defaultSnapshotSchedule.id,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Redshift Snapshot Schedule Association using the `<cluster-identifier>/<schedule-identifier>`. For example:
 *
 * ```sh
 * $ pulumi import aws:redshift/snapshotScheduleAssociation:SnapshotScheduleAssociation default tf-redshift-cluster/tf-redshift-snapshot-schedule
 * ```
 */
export class SnapshotScheduleAssociation extends pulumi.CustomResource {
    /**
     * Get an existing SnapshotScheduleAssociation resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: SnapshotScheduleAssociationState, opts?: pulumi.CustomResourceOptions): SnapshotScheduleAssociation {
        return new SnapshotScheduleAssociation(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:redshift/snapshotScheduleAssociation:SnapshotScheduleAssociation';

    /**
     * Returns true if the given object is an instance of SnapshotScheduleAssociation.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is SnapshotScheduleAssociation {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === SnapshotScheduleAssociation.__pulumiType;
    }

    /**
     * The cluster identifier.
     */
    public readonly clusterIdentifier!: pulumi.Output<string>;
    /**
     * The snapshot schedule identifier.
     */
    public readonly scheduleIdentifier!: pulumi.Output<string>;

    /**
     * Create a SnapshotScheduleAssociation resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: SnapshotScheduleAssociationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: SnapshotScheduleAssociationArgs | SnapshotScheduleAssociationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as SnapshotScheduleAssociationState | undefined;
            resourceInputs["clusterIdentifier"] = state ? state.clusterIdentifier : undefined;
            resourceInputs["scheduleIdentifier"] = state ? state.scheduleIdentifier : undefined;
        } else {
            const args = argsOrState as SnapshotScheduleAssociationArgs | undefined;
            if ((!args || args.clusterIdentifier === undefined) && !opts.urn) {
                throw new Error("Missing required property 'clusterIdentifier'");
            }
            if ((!args || args.scheduleIdentifier === undefined) && !opts.urn) {
                throw new Error("Missing required property 'scheduleIdentifier'");
            }
            resourceInputs["clusterIdentifier"] = args ? args.clusterIdentifier : undefined;
            resourceInputs["scheduleIdentifier"] = args ? args.scheduleIdentifier : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(SnapshotScheduleAssociation.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering SnapshotScheduleAssociation resources.
 */
export interface SnapshotScheduleAssociationState {
    /**
     * The cluster identifier.
     */
    clusterIdentifier?: pulumi.Input<string>;
    /**
     * The snapshot schedule identifier.
     */
    scheduleIdentifier?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a SnapshotScheduleAssociation resource.
 */
export interface SnapshotScheduleAssociationArgs {
    /**
     * The cluster identifier.
     */
    clusterIdentifier: pulumi.Input<string>;
    /**
     * The snapshot schedule identifier.
     */
    scheduleIdentifier: pulumi.Input<string>;
}
