// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a AWS Clean Rooms configured table. Configured tables are used to represent references to existing tables in the AWS Glue Data Catalog.
 *
 * ## Example Usage
 *
 * ### Configured table with tags
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const testConfiguredTable = new aws.cleanrooms.ConfiguredTable("test_configured_table", {
 *     name: "pulumi-example-table",
 *     description: "I made this table with Pulumi!",
 *     analysisMethod: "DIRECT_QUERY",
 *     allowedColumns: [
 *         "column1",
 *         "column2",
 *         "column3",
 *     ],
 *     tableReference: {
 *         databaseName: "example_database",
 *         tableName: "example_table",
 *     },
 *     tags: {
 *         Project: "Pulumi",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_cleanrooms_configured_table` using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:cleanrooms/configuredTable:ConfiguredTable table 1234abcd-12ab-34cd-56ef-1234567890ab
 * ```
 */
export class ConfiguredTable extends pulumi.CustomResource {
    /**
     * Get an existing ConfiguredTable resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ConfiguredTableState, opts?: pulumi.CustomResourceOptions): ConfiguredTable {
        return new ConfiguredTable(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:cleanrooms/configuredTable:ConfiguredTable';

    /**
     * Returns true if the given object is an instance of ConfiguredTable.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ConfiguredTable {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ConfiguredTable.__pulumiType;
    }

    /**
     * The columns of the references table which will be included in the configured table.
     */
    public readonly allowedColumns!: pulumi.Output<string[]>;
    /**
     * The analysis method for the configured table. The only valid value is currently `DIRECT_QUERY`.
     */
    public readonly analysisMethod!: pulumi.Output<string>;
    /**
     * The ARN of the configured table.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The date and time the configured table was created.
     */
    public /*out*/ readonly createTime!: pulumi.Output<string>;
    /**
     * A description for the configured table.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The name of the configured table.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * A reference to the AWS Glue table which will be used to create the configured table.
     * * `table_reference.database_name` - (Required - Forces new resource) - The name of the AWS Glue database which contains the table.
     * * `table_reference.table_name` - (Required - Forces new resource) - The name of the AWS Glue table which will be used to create the configured table.
     */
    public readonly tableReference!: pulumi.Output<outputs.cleanrooms.ConfiguredTableTableReference>;
    /**
     * Key value pairs which tag the configured table.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The date and time the configured table was last updated.
     */
    public /*out*/ readonly updateTime!: pulumi.Output<string>;

    /**
     * Create a ConfiguredTable resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ConfiguredTableArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ConfiguredTableArgs | ConfiguredTableState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ConfiguredTableState | undefined;
            resourceInputs["allowedColumns"] = state ? state.allowedColumns : undefined;
            resourceInputs["analysisMethod"] = state ? state.analysisMethod : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["createTime"] = state ? state.createTime : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["tableReference"] = state ? state.tableReference : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["updateTime"] = state ? state.updateTime : undefined;
        } else {
            const args = argsOrState as ConfiguredTableArgs | undefined;
            if ((!args || args.allowedColumns === undefined) && !opts.urn) {
                throw new Error("Missing required property 'allowedColumns'");
            }
            if ((!args || args.analysisMethod === undefined) && !opts.urn) {
                throw new Error("Missing required property 'analysisMethod'");
            }
            if ((!args || args.tableReference === undefined) && !opts.urn) {
                throw new Error("Missing required property 'tableReference'");
            }
            resourceInputs["allowedColumns"] = args ? args.allowedColumns : undefined;
            resourceInputs["analysisMethod"] = args ? args.analysisMethod : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tableReference"] = args ? args.tableReference : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["createTime"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["updateTime"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ConfiguredTable.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ConfiguredTable resources.
 */
export interface ConfiguredTableState {
    /**
     * The columns of the references table which will be included in the configured table.
     */
    allowedColumns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The analysis method for the configured table. The only valid value is currently `DIRECT_QUERY`.
     */
    analysisMethod?: pulumi.Input<string>;
    /**
     * The ARN of the configured table.
     */
    arn?: pulumi.Input<string>;
    /**
     * The date and time the configured table was created.
     */
    createTime?: pulumi.Input<string>;
    /**
     * A description for the configured table.
     */
    description?: pulumi.Input<string>;
    /**
     * The name of the configured table.
     */
    name?: pulumi.Input<string>;
    /**
     * A reference to the AWS Glue table which will be used to create the configured table.
     * * `table_reference.database_name` - (Required - Forces new resource) - The name of the AWS Glue database which contains the table.
     * * `table_reference.table_name` - (Required - Forces new resource) - The name of the AWS Glue table which will be used to create the configured table.
     */
    tableReference?: pulumi.Input<inputs.cleanrooms.ConfiguredTableTableReference>;
    /**
     * Key value pairs which tag the configured table.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The date and time the configured table was last updated.
     */
    updateTime?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a ConfiguredTable resource.
 */
export interface ConfiguredTableArgs {
    /**
     * The columns of the references table which will be included in the configured table.
     */
    allowedColumns: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The analysis method for the configured table. The only valid value is currently `DIRECT_QUERY`.
     */
    analysisMethod: pulumi.Input<string>;
    /**
     * A description for the configured table.
     */
    description?: pulumi.Input<string>;
    /**
     * The name of the configured table.
     */
    name?: pulumi.Input<string>;
    /**
     * A reference to the AWS Glue table which will be used to create the configured table.
     * * `table_reference.database_name` - (Required - Forces new resource) - The name of the AWS Glue database which contains the table.
     * * `table_reference.table_name` - (Required - Forces new resource) - The name of the AWS Glue table which will be used to create the configured table.
     */
    tableReference: pulumi.Input<inputs.cleanrooms.ConfiguredTableTableReference>;
    /**
     * Key value pairs which tag the configured table.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
