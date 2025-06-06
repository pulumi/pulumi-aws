// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a Glue Catalog Database Resource. You can refer to the [Glue Developer Guide](http://docs.aws.amazon.com/glue/latest/dg/populate-data-catalog.html) for a full explanation of the Glue Data Catalog functionality
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.glue.CatalogDatabase("example", {name: "MyCatalogDatabase"});
 * ```
 *
 * ### Create Table Default Permissions
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.glue.CatalogDatabase("example", {
 *     name: "MyCatalogDatabase",
 *     createTableDefaultPermissions: [{
 *         permissions: ["SELECT"],
 *         principal: {
 *             dataLakePrincipalIdentifier: "IAM_ALLOWED_PRINCIPALS",
 *         },
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Glue Catalog Databases using the `catalog_id:name`. If you have not set a Catalog ID specify the AWS Account ID that the database is in. For example:
 *
 * ```sh
 * $ pulumi import aws:glue/catalogDatabase:CatalogDatabase database 123456789012:my_database
 * ```
 */
export class CatalogDatabase extends pulumi.CustomResource {
    /**
     * Get an existing CatalogDatabase resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: CatalogDatabaseState, opts?: pulumi.CustomResourceOptions): CatalogDatabase {
        return new CatalogDatabase(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:glue/catalogDatabase:CatalogDatabase';

    /**
     * Returns true if the given object is an instance of CatalogDatabase.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is CatalogDatabase {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === CatalogDatabase.__pulumiType;
    }

    /**
     * ARN of the Glue Catalog Database.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * ID of the Glue Catalog to create the database in. If omitted, this defaults to the AWS Account ID.
     */
    public readonly catalogId!: pulumi.Output<string>;
    /**
     * Creates a set of default permissions on the table for principals. See `createTableDefaultPermission` below.
     */
    public readonly createTableDefaultPermissions!: pulumi.Output<outputs.glue.CatalogDatabaseCreateTableDefaultPermission[]>;
    /**
     * Description of the database.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Configuration block that references an entity outside the AWS Glue Data Catalog. See `federatedDatabase` below.
     */
    public readonly federatedDatabase!: pulumi.Output<outputs.glue.CatalogDatabaseFederatedDatabase | undefined>;
    /**
     * Location of the database (for example, an HDFS path).
     */
    public readonly locationUri!: pulumi.Output<string>;
    /**
     * Name of the database. The acceptable characters are lowercase letters, numbers, and the underscore character.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * List of key-value pairs that define parameters and properties of the database.
     */
    public readonly parameters!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Configuration block for a target database for resource linking. See `targetDatabase` below.
     */
    public readonly targetDatabase!: pulumi.Output<outputs.glue.CatalogDatabaseTargetDatabase | undefined>;

    /**
     * Create a CatalogDatabase resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: CatalogDatabaseArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: CatalogDatabaseArgs | CatalogDatabaseState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as CatalogDatabaseState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["catalogId"] = state ? state.catalogId : undefined;
            resourceInputs["createTableDefaultPermissions"] = state ? state.createTableDefaultPermissions : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["federatedDatabase"] = state ? state.federatedDatabase : undefined;
            resourceInputs["locationUri"] = state ? state.locationUri : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["parameters"] = state ? state.parameters : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["targetDatabase"] = state ? state.targetDatabase : undefined;
        } else {
            const args = argsOrState as CatalogDatabaseArgs | undefined;
            resourceInputs["catalogId"] = args ? args.catalogId : undefined;
            resourceInputs["createTableDefaultPermissions"] = args ? args.createTableDefaultPermissions : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["federatedDatabase"] = args ? args.federatedDatabase : undefined;
            resourceInputs["locationUri"] = args ? args.locationUri : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["parameters"] = args ? args.parameters : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["targetDatabase"] = args ? args.targetDatabase : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(CatalogDatabase.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering CatalogDatabase resources.
 */
export interface CatalogDatabaseState {
    /**
     * ARN of the Glue Catalog Database.
     */
    arn?: pulumi.Input<string>;
    /**
     * ID of the Glue Catalog to create the database in. If omitted, this defaults to the AWS Account ID.
     */
    catalogId?: pulumi.Input<string>;
    /**
     * Creates a set of default permissions on the table for principals. See `createTableDefaultPermission` below.
     */
    createTableDefaultPermissions?: pulumi.Input<pulumi.Input<inputs.glue.CatalogDatabaseCreateTableDefaultPermission>[]>;
    /**
     * Description of the database.
     */
    description?: pulumi.Input<string>;
    /**
     * Configuration block that references an entity outside the AWS Glue Data Catalog. See `federatedDatabase` below.
     */
    federatedDatabase?: pulumi.Input<inputs.glue.CatalogDatabaseFederatedDatabase>;
    /**
     * Location of the database (for example, an HDFS path).
     */
    locationUri?: pulumi.Input<string>;
    /**
     * Name of the database. The acceptable characters are lowercase letters, numbers, and the underscore character.
     */
    name?: pulumi.Input<string>;
    /**
     * List of key-value pairs that define parameters and properties of the database.
     */
    parameters?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Configuration block for a target database for resource linking. See `targetDatabase` below.
     */
    targetDatabase?: pulumi.Input<inputs.glue.CatalogDatabaseTargetDatabase>;
}

/**
 * The set of arguments for constructing a CatalogDatabase resource.
 */
export interface CatalogDatabaseArgs {
    /**
     * ID of the Glue Catalog to create the database in. If omitted, this defaults to the AWS Account ID.
     */
    catalogId?: pulumi.Input<string>;
    /**
     * Creates a set of default permissions on the table for principals. See `createTableDefaultPermission` below.
     */
    createTableDefaultPermissions?: pulumi.Input<pulumi.Input<inputs.glue.CatalogDatabaseCreateTableDefaultPermission>[]>;
    /**
     * Description of the database.
     */
    description?: pulumi.Input<string>;
    /**
     * Configuration block that references an entity outside the AWS Glue Data Catalog. See `federatedDatabase` below.
     */
    federatedDatabase?: pulumi.Input<inputs.glue.CatalogDatabaseFederatedDatabase>;
    /**
     * Location of the database (for example, an HDFS path).
     */
    locationUri?: pulumi.Input<string>;
    /**
     * Name of the database. The acceptable characters are lowercase letters, numbers, and the underscore character.
     */
    name?: pulumi.Input<string>;
    /**
     * List of key-value pairs that define parameters and properties of the database.
     */
    parameters?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Configuration block for a target database for resource linking. See `targetDatabase` below.
     */
    targetDatabase?: pulumi.Input<inputs.glue.CatalogDatabaseTargetDatabase>;
}
