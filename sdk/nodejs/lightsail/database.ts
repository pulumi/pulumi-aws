// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a Lightsail Database. Amazon Lightsail is a service to provide easy virtual private servers
 * with custom software already setup. See [What is Amazon Lightsail?](https://lightsail.aws.amazon.com/ls/docs/getting-started/article/what-is-amazon-lightsail)
 * for more information.
 *
 * > **Note:** Lightsail is currently only supported in a limited number of AWS Regions, please see ["Regions and Availability Zones"](https://aws.amazon.com/about-aws/global-infrastructure/regional-product-services/) for more details
 *
 * ## Example Usage
 *
 * ### Basic mysql blueprint
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.lightsail.Database("test", {
 *     relationalDatabaseName: "test",
 *     availabilityZone: "us-east-1a",
 *     masterDatabaseName: "testdatabasename",
 *     masterPassword: "testdatabasepassword",
 *     masterUsername: "test",
 *     blueprintId: "mysql_8_0",
 *     bundleId: "micro_1_0",
 * });
 * ```
 *
 * ### Basic postrgres blueprint
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.lightsail.Database("test", {
 *     relationalDatabaseName: "test",
 *     availabilityZone: "us-east-1a",
 *     masterDatabaseName: "testdatabasename",
 *     masterPassword: "testdatabasepassword",
 *     masterUsername: "test",
 *     blueprintId: "postgres_12",
 *     bundleId: "micro_1_0",
 * });
 * ```
 *
 * ### Custom backup and maintenance windows
 *
 * Below is an example that sets a custom backup and maintenance window. Times are specified in UTC. This example will allow daily backups to take place between 16:00 and 16:30 each day. This example also requires any maintiance tasks (anything that would cause an outage, including changing some attributes) to take place on Tuesdays between 17:00 and 17:30. An action taken against this database that would cause an outage will wait until this time window to make the requested changes.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.lightsail.Database("test", {
 *     relationalDatabaseName: "test",
 *     availabilityZone: "us-east-1a",
 *     masterDatabaseName: "testdatabasename",
 *     masterPassword: "testdatabasepassword",
 *     masterUsername: "test",
 *     blueprintId: "postgres_12",
 *     bundleId: "micro_1_0",
 *     preferredBackupWindow: "16:00-16:30",
 *     preferredMaintenanceWindow: "Tue:17:00-Tue:17:30",
 * });
 * ```
 *
 * ### Final Snapshots
 *
 * To enable creating a final snapshot of your database on deletion, use the `finalSnapshotName` argument to provide a name to be used for the snapshot.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.lightsail.Database("test", {
 *     relationalDatabaseName: "test",
 *     availabilityZone: "us-east-1a",
 *     masterDatabaseName: "testdatabasename",
 *     masterPassword: "testdatabasepassword",
 *     masterUsername: "test",
 *     blueprintId: "postgres_12",
 *     bundleId: "micro_1_0",
 *     preferredBackupWindow: "16:00-16:30",
 *     preferredMaintenanceWindow: "Tue:17:00-Tue:17:30",
 *     finalSnapshotName: "MyFinalSnapshot",
 * });
 * ```
 *
 * ### Apply Immediately
 *
 * To enable applying changes immediately instead of waiting for a maintiance window, use the `applyImmediately` argument.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.lightsail.Database("test", {
 *     relationalDatabaseName: "test",
 *     availabilityZone: "us-east-1a",
 *     masterDatabaseName: "testdatabasename",
 *     masterPassword: "testdatabasepassword",
 *     masterUsername: "test",
 *     blueprintId: "postgres_12",
 *     bundleId: "micro_1_0",
 *     applyImmediately: true,
 * });
 * ```
 *
 * ## Blueprint Ids
 *
 * A list of all available Lightsail Blueprints for Relational Databases the [aws lightsail get-relational-database-blueprints](https://docs.aws.amazon.com/cli/latest/reference/lightsail/get-relational-database-blueprints.html) aws cli command.
 *
 * ### Examples
 *
 * - `mysql80`
 * - `postgres12`
 *
 * ### Prefix
 *
 * A Blueprint ID starts with a prefix of the engine type.
 *
 * ### Suffix
 *
 * A Blueprint ID has a sufix of the engine version.
 *
 * ## Bundles
 *
 * A list of all available Lightsail Bundles for Relational Databases the [aws lightsail get-relational-database-bundles](https://docs.aws.amazon.com/cli/latest/reference/lightsail/get-relational-database-bundles.html) aws cli command.
 *
 * ### Examples
 *
 * - `small10`
 * - `smallHa10`
 * - `large10`
 * - `largeHa10`
 *
 * ### Prefix
 *
 * A Bundle ID starts with one of the below size prefixes:
 *
 * - `micro_`
 * - `small_`
 * - `medium_`
 * - `large_`
 *
 * ### Infixes (Optional for HA Database)
 *
 * A Bundle Id can have the following infix added in order to use the HA option of the selected bundle.
 *
 * - `ha_`
 *
 * ### Suffix
 *
 * A Bundle ID ends with one of the following suffix: `10`
 *
 * ## Import
 *
 * Using `pulumi import`, import Lightsail Databases using their name. For example:
 *
 * ```sh
 * $ pulumi import aws:lightsail/database:Database foo 'bar'
 * ```
 */
export class Database extends pulumi.CustomResource {
    /**
     * Get an existing Database resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DatabaseState, opts?: pulumi.CustomResourceOptions): Database {
        return new Database(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:lightsail/database:Database';

    /**
     * Returns true if the given object is an instance of Database.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Database {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Database.__pulumiType;
    }

    /**
     * When true , applies changes immediately. When false , applies changes during the preferred maintenance window. Some changes may cause an outage.
     */
    public readonly applyImmediately!: pulumi.Output<boolean>;
    /**
     * The ARN of the Lightsail instance (matches `id`).
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The Availability Zone in which to create your new database. Use the us-east-2a case-sensitive format.
     */
    public readonly availabilityZone!: pulumi.Output<string>;
    /**
     * When true, enables automated backup retention for your database. When false, disables automated backup retention for your database. Disabling backup retention deletes all automated database backups. Before disabling this, you may want to create a snapshot of your database.
     */
    public readonly backupRetentionEnabled!: pulumi.Output<boolean | undefined>;
    /**
     * The blueprint ID for your new database. A blueprint describes the major engine version of a database. You can get a list of database blueprints IDs by using the AWS CLI command: `aws lightsail get-relational-database-blueprints`
     */
    public readonly blueprintId!: pulumi.Output<string>;
    /**
     * The bundle ID for your new database. A bundle describes the performance specifications for your database (see list below). You can get a list of database bundle IDs by using the AWS CLI command: `aws lightsail get-relational-database-bundles`.
     */
    public readonly bundleId!: pulumi.Output<string>;
    /**
     * The certificate associated with the database.
     */
    public /*out*/ readonly caCertificateIdentifier!: pulumi.Output<string>;
    /**
     * The number of vCPUs for the database.
     */
    public /*out*/ readonly cpuCount!: pulumi.Output<number>;
    /**
     * The timestamp when the instance was created.
     */
    public /*out*/ readonly createdAt!: pulumi.Output<string>;
    /**
     * The size of the disk for the database.
     */
    public /*out*/ readonly diskSize!: pulumi.Output<number>;
    /**
     * The database software (for example, MySQL).
     */
    public /*out*/ readonly engine!: pulumi.Output<string>;
    /**
     * The database engine version (for example, 5.7.23).
     */
    public /*out*/ readonly engineVersion!: pulumi.Output<string>;
    /**
     * The name of the database snapshot created if skip final snapshot is false, which is the default value for that parameter.
     */
    public readonly finalSnapshotName!: pulumi.Output<string | undefined>;
    /**
     * The name of the master database created when the Lightsail database resource is created.
     */
    public readonly masterDatabaseName!: pulumi.Output<string>;
    /**
     * The master endpoint fqdn for the database.
     */
    public /*out*/ readonly masterEndpointAddress!: pulumi.Output<string>;
    /**
     * The master endpoint network port for the database.
     */
    public /*out*/ readonly masterEndpointPort!: pulumi.Output<number>;
    /**
     * The password for the master user of your new database. The password can include any printable ASCII character except "/", """, or "@".
     */
    public readonly masterPassword!: pulumi.Output<string>;
    /**
     * The master user name for your new database.
     */
    public readonly masterUsername!: pulumi.Output<string>;
    /**
     * The daily time range during which automated backups are created for your new database if automated backups are enabled. Must be in the hh24:mi-hh24:mi format. Example: `16:00-16:30`. Specified in Coordinated Universal Time (UTC).
     */
    public readonly preferredBackupWindow!: pulumi.Output<string>;
    /**
     * The weekly time range during which system maintenance can occur on your new database. Must be in the ddd:hh24:mi-ddd:hh24:mi format. Specified in Coordinated Universal Time (UTC). Example: `Tue:17:00-Tue:17:30`
     */
    public readonly preferredMaintenanceWindow!: pulumi.Output<string>;
    /**
     * Specifies the accessibility options for your new database. A value of true specifies a database that is available to resources outside of your Lightsail account. A value of false specifies a database that is available only to your Lightsail resources in the same region as your database.
     */
    public readonly publiclyAccessible!: pulumi.Output<boolean | undefined>;
    /**
     * The amount of RAM in GB for the database.
     */
    public /*out*/ readonly ramSize!: pulumi.Output<number>;
    /**
     * The name to use for your new Lightsail database resource. Names be unique within each AWS Region in your Lightsail account.
     */
    public readonly relationalDatabaseName!: pulumi.Output<string>;
    /**
     * Describes the secondary Availability Zone of a high availability database. The secondary database is used for failover support of a high availability database.
     */
    public /*out*/ readonly secondaryAvailabilityZone!: pulumi.Output<string>;
    /**
     * Determines whether a final database snapshot is created before your database is deleted. If true is specified, no database snapshot is created. If false is specified, a database snapshot is created before your database is deleted. You must specify the final relational database snapshot name parameter if the skip final snapshot parameter is false.
     */
    public readonly skipFinalSnapshot!: pulumi.Output<boolean | undefined>;
    /**
     * The support code for the database. Include this code in your email to support when you have questions about a database in Lightsail. This code enables our support team to look up your Lightsail information more easily.
     */
    public /*out*/ readonly supportCode!: pulumi.Output<string>;
    /**
     * A map of tags to assign to the resource. To create a key-only tag, use an empty string as the value.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a Database resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: DatabaseArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DatabaseArgs | DatabaseState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DatabaseState | undefined;
            resourceInputs["applyImmediately"] = state ? state.applyImmediately : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["availabilityZone"] = state ? state.availabilityZone : undefined;
            resourceInputs["backupRetentionEnabled"] = state ? state.backupRetentionEnabled : undefined;
            resourceInputs["blueprintId"] = state ? state.blueprintId : undefined;
            resourceInputs["bundleId"] = state ? state.bundleId : undefined;
            resourceInputs["caCertificateIdentifier"] = state ? state.caCertificateIdentifier : undefined;
            resourceInputs["cpuCount"] = state ? state.cpuCount : undefined;
            resourceInputs["createdAt"] = state ? state.createdAt : undefined;
            resourceInputs["diskSize"] = state ? state.diskSize : undefined;
            resourceInputs["engine"] = state ? state.engine : undefined;
            resourceInputs["engineVersion"] = state ? state.engineVersion : undefined;
            resourceInputs["finalSnapshotName"] = state ? state.finalSnapshotName : undefined;
            resourceInputs["masterDatabaseName"] = state ? state.masterDatabaseName : undefined;
            resourceInputs["masterEndpointAddress"] = state ? state.masterEndpointAddress : undefined;
            resourceInputs["masterEndpointPort"] = state ? state.masterEndpointPort : undefined;
            resourceInputs["masterPassword"] = state ? state.masterPassword : undefined;
            resourceInputs["masterUsername"] = state ? state.masterUsername : undefined;
            resourceInputs["preferredBackupWindow"] = state ? state.preferredBackupWindow : undefined;
            resourceInputs["preferredMaintenanceWindow"] = state ? state.preferredMaintenanceWindow : undefined;
            resourceInputs["publiclyAccessible"] = state ? state.publiclyAccessible : undefined;
            resourceInputs["ramSize"] = state ? state.ramSize : undefined;
            resourceInputs["relationalDatabaseName"] = state ? state.relationalDatabaseName : undefined;
            resourceInputs["secondaryAvailabilityZone"] = state ? state.secondaryAvailabilityZone : undefined;
            resourceInputs["skipFinalSnapshot"] = state ? state.skipFinalSnapshot : undefined;
            resourceInputs["supportCode"] = state ? state.supportCode : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as DatabaseArgs | undefined;
            if ((!args || args.blueprintId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'blueprintId'");
            }
            if ((!args || args.bundleId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'bundleId'");
            }
            if ((!args || args.masterDatabaseName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'masterDatabaseName'");
            }
            if ((!args || args.masterPassword === undefined) && !opts.urn) {
                throw new Error("Missing required property 'masterPassword'");
            }
            if ((!args || args.masterUsername === undefined) && !opts.urn) {
                throw new Error("Missing required property 'masterUsername'");
            }
            if ((!args || args.relationalDatabaseName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'relationalDatabaseName'");
            }
            resourceInputs["applyImmediately"] = args ? args.applyImmediately : undefined;
            resourceInputs["availabilityZone"] = args ? args.availabilityZone : undefined;
            resourceInputs["backupRetentionEnabled"] = args ? args.backupRetentionEnabled : undefined;
            resourceInputs["blueprintId"] = args ? args.blueprintId : undefined;
            resourceInputs["bundleId"] = args ? args.bundleId : undefined;
            resourceInputs["finalSnapshotName"] = args ? args.finalSnapshotName : undefined;
            resourceInputs["masterDatabaseName"] = args ? args.masterDatabaseName : undefined;
            resourceInputs["masterPassword"] = args?.masterPassword ? pulumi.secret(args.masterPassword) : undefined;
            resourceInputs["masterUsername"] = args ? args.masterUsername : undefined;
            resourceInputs["preferredBackupWindow"] = args ? args.preferredBackupWindow : undefined;
            resourceInputs["preferredMaintenanceWindow"] = args ? args.preferredMaintenanceWindow : undefined;
            resourceInputs["publiclyAccessible"] = args ? args.publiclyAccessible : undefined;
            resourceInputs["relationalDatabaseName"] = args ? args.relationalDatabaseName : undefined;
            resourceInputs["skipFinalSnapshot"] = args ? args.skipFinalSnapshot : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["caCertificateIdentifier"] = undefined /*out*/;
            resourceInputs["cpuCount"] = undefined /*out*/;
            resourceInputs["createdAt"] = undefined /*out*/;
            resourceInputs["diskSize"] = undefined /*out*/;
            resourceInputs["engine"] = undefined /*out*/;
            resourceInputs["engineVersion"] = undefined /*out*/;
            resourceInputs["masterEndpointAddress"] = undefined /*out*/;
            resourceInputs["masterEndpointPort"] = undefined /*out*/;
            resourceInputs["ramSize"] = undefined /*out*/;
            resourceInputs["secondaryAvailabilityZone"] = undefined /*out*/;
            resourceInputs["supportCode"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        const secretOpts = { additionalSecretOutputs: ["masterPassword"] };
        opts = pulumi.mergeOptions(opts, secretOpts);
        super(Database.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Database resources.
 */
export interface DatabaseState {
    /**
     * When true , applies changes immediately. When false , applies changes during the preferred maintenance window. Some changes may cause an outage.
     */
    applyImmediately?: pulumi.Input<boolean>;
    /**
     * The ARN of the Lightsail instance (matches `id`).
     */
    arn?: pulumi.Input<string>;
    /**
     * The Availability Zone in which to create your new database. Use the us-east-2a case-sensitive format.
     */
    availabilityZone?: pulumi.Input<string>;
    /**
     * When true, enables automated backup retention for your database. When false, disables automated backup retention for your database. Disabling backup retention deletes all automated database backups. Before disabling this, you may want to create a snapshot of your database.
     */
    backupRetentionEnabled?: pulumi.Input<boolean>;
    /**
     * The blueprint ID for your new database. A blueprint describes the major engine version of a database. You can get a list of database blueprints IDs by using the AWS CLI command: `aws lightsail get-relational-database-blueprints`
     */
    blueprintId?: pulumi.Input<string>;
    /**
     * The bundle ID for your new database. A bundle describes the performance specifications for your database (see list below). You can get a list of database bundle IDs by using the AWS CLI command: `aws lightsail get-relational-database-bundles`.
     */
    bundleId?: pulumi.Input<string>;
    /**
     * The certificate associated with the database.
     */
    caCertificateIdentifier?: pulumi.Input<string>;
    /**
     * The number of vCPUs for the database.
     */
    cpuCount?: pulumi.Input<number>;
    /**
     * The timestamp when the instance was created.
     */
    createdAt?: pulumi.Input<string>;
    /**
     * The size of the disk for the database.
     */
    diskSize?: pulumi.Input<number>;
    /**
     * The database software (for example, MySQL).
     */
    engine?: pulumi.Input<string>;
    /**
     * The database engine version (for example, 5.7.23).
     */
    engineVersion?: pulumi.Input<string>;
    /**
     * The name of the database snapshot created if skip final snapshot is false, which is the default value for that parameter.
     */
    finalSnapshotName?: pulumi.Input<string>;
    /**
     * The name of the master database created when the Lightsail database resource is created.
     */
    masterDatabaseName?: pulumi.Input<string>;
    /**
     * The master endpoint fqdn for the database.
     */
    masterEndpointAddress?: pulumi.Input<string>;
    /**
     * The master endpoint network port for the database.
     */
    masterEndpointPort?: pulumi.Input<number>;
    /**
     * The password for the master user of your new database. The password can include any printable ASCII character except "/", """, or "@".
     */
    masterPassword?: pulumi.Input<string>;
    /**
     * The master user name for your new database.
     */
    masterUsername?: pulumi.Input<string>;
    /**
     * The daily time range during which automated backups are created for your new database if automated backups are enabled. Must be in the hh24:mi-hh24:mi format. Example: `16:00-16:30`. Specified in Coordinated Universal Time (UTC).
     */
    preferredBackupWindow?: pulumi.Input<string>;
    /**
     * The weekly time range during which system maintenance can occur on your new database. Must be in the ddd:hh24:mi-ddd:hh24:mi format. Specified in Coordinated Universal Time (UTC). Example: `Tue:17:00-Tue:17:30`
     */
    preferredMaintenanceWindow?: pulumi.Input<string>;
    /**
     * Specifies the accessibility options for your new database. A value of true specifies a database that is available to resources outside of your Lightsail account. A value of false specifies a database that is available only to your Lightsail resources in the same region as your database.
     */
    publiclyAccessible?: pulumi.Input<boolean>;
    /**
     * The amount of RAM in GB for the database.
     */
    ramSize?: pulumi.Input<number>;
    /**
     * The name to use for your new Lightsail database resource. Names be unique within each AWS Region in your Lightsail account.
     */
    relationalDatabaseName?: pulumi.Input<string>;
    /**
     * Describes the secondary Availability Zone of a high availability database. The secondary database is used for failover support of a high availability database.
     */
    secondaryAvailabilityZone?: pulumi.Input<string>;
    /**
     * Determines whether a final database snapshot is created before your database is deleted. If true is specified, no database snapshot is created. If false is specified, a database snapshot is created before your database is deleted. You must specify the final relational database snapshot name parameter if the skip final snapshot parameter is false.
     */
    skipFinalSnapshot?: pulumi.Input<boolean>;
    /**
     * The support code for the database. Include this code in your email to support when you have questions about a database in Lightsail. This code enables our support team to look up your Lightsail information more easily.
     */
    supportCode?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. To create a key-only tag, use an empty string as the value.
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
 * The set of arguments for constructing a Database resource.
 */
export interface DatabaseArgs {
    /**
     * When true , applies changes immediately. When false , applies changes during the preferred maintenance window. Some changes may cause an outage.
     */
    applyImmediately?: pulumi.Input<boolean>;
    /**
     * The Availability Zone in which to create your new database. Use the us-east-2a case-sensitive format.
     */
    availabilityZone?: pulumi.Input<string>;
    /**
     * When true, enables automated backup retention for your database. When false, disables automated backup retention for your database. Disabling backup retention deletes all automated database backups. Before disabling this, you may want to create a snapshot of your database.
     */
    backupRetentionEnabled?: pulumi.Input<boolean>;
    /**
     * The blueprint ID for your new database. A blueprint describes the major engine version of a database. You can get a list of database blueprints IDs by using the AWS CLI command: `aws lightsail get-relational-database-blueprints`
     */
    blueprintId: pulumi.Input<string>;
    /**
     * The bundle ID for your new database. A bundle describes the performance specifications for your database (see list below). You can get a list of database bundle IDs by using the AWS CLI command: `aws lightsail get-relational-database-bundles`.
     */
    bundleId: pulumi.Input<string>;
    /**
     * The name of the database snapshot created if skip final snapshot is false, which is the default value for that parameter.
     */
    finalSnapshotName?: pulumi.Input<string>;
    /**
     * The name of the master database created when the Lightsail database resource is created.
     */
    masterDatabaseName: pulumi.Input<string>;
    /**
     * The password for the master user of your new database. The password can include any printable ASCII character except "/", """, or "@".
     */
    masterPassword: pulumi.Input<string>;
    /**
     * The master user name for your new database.
     */
    masterUsername: pulumi.Input<string>;
    /**
     * The daily time range during which automated backups are created for your new database if automated backups are enabled. Must be in the hh24:mi-hh24:mi format. Example: `16:00-16:30`. Specified in Coordinated Universal Time (UTC).
     */
    preferredBackupWindow?: pulumi.Input<string>;
    /**
     * The weekly time range during which system maintenance can occur on your new database. Must be in the ddd:hh24:mi-ddd:hh24:mi format. Specified in Coordinated Universal Time (UTC). Example: `Tue:17:00-Tue:17:30`
     */
    preferredMaintenanceWindow?: pulumi.Input<string>;
    /**
     * Specifies the accessibility options for your new database. A value of true specifies a database that is available to resources outside of your Lightsail account. A value of false specifies a database that is available only to your Lightsail resources in the same region as your database.
     */
    publiclyAccessible?: pulumi.Input<boolean>;
    /**
     * The name to use for your new Lightsail database resource. Names be unique within each AWS Region in your Lightsail account.
     */
    relationalDatabaseName: pulumi.Input<string>;
    /**
     * Determines whether a final database snapshot is created before your database is deleted. If true is specified, no database snapshot is created. If false is specified, a database snapshot is created before your database is deleted. You must specify the final relational database snapshot name parameter if the skip final snapshot parameter is false.
     */
    skipFinalSnapshot?: pulumi.Input<boolean>;
    /**
     * A map of tags to assign to the resource. To create a key-only tag, use an empty string as the value.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
