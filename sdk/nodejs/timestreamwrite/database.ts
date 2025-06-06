// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a Timestream database resource.
 *
 * ## Example Usage
 *
 * ### Basic usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.timestreamwrite.Database("example", {databaseName: "database-example"});
 * ```
 *
 * ### Full usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.timestreamwrite.Database("example", {
 *     databaseName: "database-example",
 *     kmsKeyId: exampleAwsKmsKey.arn,
 *     tags: {
 *         Name: "value",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Timestream databases using the `database_name`. For example:
 *
 * ```sh
 * $ pulumi import aws:timestreamwrite/database:Database example example
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
    public static readonly __pulumiType = 'aws:timestreamwrite/database:Database';

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
     * The ARN that uniquely identifies this database.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The name of the Timestream database. Minimum length of 3. Maximum length of 64.
     */
    public readonly databaseName!: pulumi.Output<string>;
    /**
     * The ARN (not Alias ARN) of the KMS key to be used to encrypt the data stored in the database. If the KMS key is not specified, the database will be encrypted with a Timestream managed KMS key located in your account. Refer to [AWS managed KMS keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) for more info.
     */
    public readonly kmsKeyId!: pulumi.Output<string>;
    /**
     * The total number of tables found within the Timestream database.
     */
    public /*out*/ readonly tableCount!: pulumi.Output<number>;
    /**
     * Map of tags to assign to this resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["databaseName"] = state ? state.databaseName : undefined;
            resourceInputs["kmsKeyId"] = state ? state.kmsKeyId : undefined;
            resourceInputs["tableCount"] = state ? state.tableCount : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as DatabaseArgs | undefined;
            if ((!args || args.databaseName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'databaseName'");
            }
            resourceInputs["databaseName"] = args ? args.databaseName : undefined;
            resourceInputs["kmsKeyId"] = args ? args.kmsKeyId : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tableCount"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Database.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Database resources.
 */
export interface DatabaseState {
    /**
     * The ARN that uniquely identifies this database.
     */
    arn?: pulumi.Input<string>;
    /**
     * The name of the Timestream database. Minimum length of 3. Maximum length of 64.
     */
    databaseName?: pulumi.Input<string>;
    /**
     * The ARN (not Alias ARN) of the KMS key to be used to encrypt the data stored in the database. If the KMS key is not specified, the database will be encrypted with a Timestream managed KMS key located in your account. Refer to [AWS managed KMS keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) for more info.
     */
    kmsKeyId?: pulumi.Input<string>;
    /**
     * The total number of tables found within the Timestream database.
     */
    tableCount?: pulumi.Input<number>;
    /**
     * Map of tags to assign to this resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
     * The name of the Timestream database. Minimum length of 3. Maximum length of 64.
     */
    databaseName: pulumi.Input<string>;
    /**
     * The ARN (not Alias ARN) of the KMS key to be used to encrypt the data stored in the database. If the KMS key is not specified, the database will be encrypted with a Timestream managed KMS key located in your account. Refer to [AWS managed KMS keys](https://docs.aws.amazon.com/kms/latest/developerguide/concepts.html#aws-managed-cmk) for more info.
     */
    kmsKeyId?: pulumi.Input<string>;
    /**
     * Map of tags to assign to this resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
