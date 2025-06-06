// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides an AppSync Data Source.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const exampleTable = new aws.dynamodb.Table("example", {
 *     name: "example",
 *     readCapacity: 1,
 *     writeCapacity: 1,
 *     hashKey: "UserId",
 *     attributes: [{
 *         name: "UserId",
 *         type: "S",
 *     }],
 * });
 * const assumeRole = aws.iam.getPolicyDocument({
 *     statements: [{
 *         effect: "Allow",
 *         principals: [{
 *             type: "Service",
 *             identifiers: ["appsync.amazonaws.com"],
 *         }],
 *         actions: ["sts:AssumeRole"],
 *     }],
 * });
 * const exampleRole = new aws.iam.Role("example", {
 *     name: "example",
 *     assumeRolePolicy: assumeRole.then(assumeRole => assumeRole.json),
 * });
 * const example = aws.iam.getPolicyDocumentOutput({
 *     statements: [{
 *         effect: "Allow",
 *         actions: ["dynamodb:*"],
 *         resources: [exampleTable.arn],
 *     }],
 * });
 * const exampleRolePolicy = new aws.iam.RolePolicy("example", {
 *     name: "example",
 *     role: exampleRole.id,
 *     policy: example.apply(example => example.json),
 * });
 * const exampleGraphQLApi = new aws.appsync.GraphQLApi("example", {
 *     authenticationType: "API_KEY",
 *     name: "my_appsync_example",
 * });
 * const exampleDataSource = new aws.appsync.DataSource("example", {
 *     apiId: exampleGraphQLApi.id,
 *     name: "my_appsync_example",
 *     serviceRoleArn: exampleRole.arn,
 *     type: "AMAZON_DYNAMODB",
 *     dynamodbConfig: {
 *         tableName: exampleTable.name,
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_appsync_datasource` using the `api_id`, a hyphen, and `name`. For example:
 *
 * ```sh
 * $ pulumi import aws:appsync/dataSource:DataSource example abcdef123456-example
 * ```
 */
export class DataSource extends pulumi.CustomResource {
    /**
     * Get an existing DataSource resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DataSourceState, opts?: pulumi.CustomResourceOptions): DataSource {
        return new DataSource(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:appsync/dataSource:DataSource';

    /**
     * Returns true if the given object is an instance of DataSource.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is DataSource {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === DataSource.__pulumiType;
    }

    /**
     * API ID for the GraphQL API for the data source.
     */
    public readonly apiId!: pulumi.Output<string>;
    /**
     * ARN
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Description of the data source.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * DynamoDB settings. See `dynamodbConfig` Block for details.
     */
    public readonly dynamodbConfig!: pulumi.Output<outputs.appsync.DataSourceDynamodbConfig | undefined>;
    /**
     * Amazon Elasticsearch settings. See `elasticsearchConfig` Block for details.
     */
    public readonly elasticsearchConfig!: pulumi.Output<outputs.appsync.DataSourceElasticsearchConfig | undefined>;
    /**
     * AWS EventBridge settings. See `eventBridgeConfig` Block for details.
     */
    public readonly eventBridgeConfig!: pulumi.Output<outputs.appsync.DataSourceEventBridgeConfig | undefined>;
    /**
     * HTTP settings. See `httpConfig` Block for details.
     */
    public readonly httpConfig!: pulumi.Output<outputs.appsync.DataSourceHttpConfig | undefined>;
    /**
     * AWS Lambda settings. See `lambdaConfig` Block for details.
     */
    public readonly lambdaConfig!: pulumi.Output<outputs.appsync.DataSourceLambdaConfig | undefined>;
    /**
     * User-supplied name for the data source.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Amazon OpenSearch Service settings. See `opensearchserviceConfig` Block for details.
     */
    public readonly opensearchserviceConfig!: pulumi.Output<outputs.appsync.DataSourceOpensearchserviceConfig | undefined>;
    /**
     * AWS RDS settings. See `relationalDatabaseConfig` Block for details.
     */
    public readonly relationalDatabaseConfig!: pulumi.Output<outputs.appsync.DataSourceRelationalDatabaseConfig | undefined>;
    /**
     * IAM service role ARN for the data source. Required if `type` is specified as `AWS_LAMBDA`, `AMAZON_DYNAMODB`, `AMAZON_ELASTICSEARCH`, `AMAZON_EVENTBRIDGE`, or `AMAZON_OPENSEARCH_SERVICE`.
     */
    public readonly serviceRoleArn!: pulumi.Output<string | undefined>;
    /**
     * Type of the Data Source. Valid values: `AWS_LAMBDA`, `AMAZON_DYNAMODB`, `AMAZON_ELASTICSEARCH`, `HTTP`, `NONE`, `RELATIONAL_DATABASE`, `AMAZON_EVENTBRIDGE`, `AMAZON_OPENSEARCH_SERVICE`.
     */
    public readonly type!: pulumi.Output<string>;

    /**
     * Create a DataSource resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: DataSourceArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DataSourceArgs | DataSourceState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DataSourceState | undefined;
            resourceInputs["apiId"] = state ? state.apiId : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["dynamodbConfig"] = state ? state.dynamodbConfig : undefined;
            resourceInputs["elasticsearchConfig"] = state ? state.elasticsearchConfig : undefined;
            resourceInputs["eventBridgeConfig"] = state ? state.eventBridgeConfig : undefined;
            resourceInputs["httpConfig"] = state ? state.httpConfig : undefined;
            resourceInputs["lambdaConfig"] = state ? state.lambdaConfig : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["opensearchserviceConfig"] = state ? state.opensearchserviceConfig : undefined;
            resourceInputs["relationalDatabaseConfig"] = state ? state.relationalDatabaseConfig : undefined;
            resourceInputs["serviceRoleArn"] = state ? state.serviceRoleArn : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
        } else {
            const args = argsOrState as DataSourceArgs | undefined;
            if ((!args || args.apiId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'apiId'");
            }
            if ((!args || args.type === undefined) && !opts.urn) {
                throw new Error("Missing required property 'type'");
            }
            resourceInputs["apiId"] = args ? args.apiId : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["dynamodbConfig"] = args ? args.dynamodbConfig : undefined;
            resourceInputs["elasticsearchConfig"] = args ? args.elasticsearchConfig : undefined;
            resourceInputs["eventBridgeConfig"] = args ? args.eventBridgeConfig : undefined;
            resourceInputs["httpConfig"] = args ? args.httpConfig : undefined;
            resourceInputs["lambdaConfig"] = args ? args.lambdaConfig : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["opensearchserviceConfig"] = args ? args.opensearchserviceConfig : undefined;
            resourceInputs["relationalDatabaseConfig"] = args ? args.relationalDatabaseConfig : undefined;
            resourceInputs["serviceRoleArn"] = args ? args.serviceRoleArn : undefined;
            resourceInputs["type"] = args ? args.type : undefined;
            resourceInputs["arn"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(DataSource.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering DataSource resources.
 */
export interface DataSourceState {
    /**
     * API ID for the GraphQL API for the data source.
     */
    apiId?: pulumi.Input<string>;
    /**
     * ARN
     */
    arn?: pulumi.Input<string>;
    /**
     * Description of the data source.
     */
    description?: pulumi.Input<string>;
    /**
     * DynamoDB settings. See `dynamodbConfig` Block for details.
     */
    dynamodbConfig?: pulumi.Input<inputs.appsync.DataSourceDynamodbConfig>;
    /**
     * Amazon Elasticsearch settings. See `elasticsearchConfig` Block for details.
     */
    elasticsearchConfig?: pulumi.Input<inputs.appsync.DataSourceElasticsearchConfig>;
    /**
     * AWS EventBridge settings. See `eventBridgeConfig` Block for details.
     */
    eventBridgeConfig?: pulumi.Input<inputs.appsync.DataSourceEventBridgeConfig>;
    /**
     * HTTP settings. See `httpConfig` Block for details.
     */
    httpConfig?: pulumi.Input<inputs.appsync.DataSourceHttpConfig>;
    /**
     * AWS Lambda settings. See `lambdaConfig` Block for details.
     */
    lambdaConfig?: pulumi.Input<inputs.appsync.DataSourceLambdaConfig>;
    /**
     * User-supplied name for the data source.
     */
    name?: pulumi.Input<string>;
    /**
     * Amazon OpenSearch Service settings. See `opensearchserviceConfig` Block for details.
     */
    opensearchserviceConfig?: pulumi.Input<inputs.appsync.DataSourceOpensearchserviceConfig>;
    /**
     * AWS RDS settings. See `relationalDatabaseConfig` Block for details.
     */
    relationalDatabaseConfig?: pulumi.Input<inputs.appsync.DataSourceRelationalDatabaseConfig>;
    /**
     * IAM service role ARN for the data source. Required if `type` is specified as `AWS_LAMBDA`, `AMAZON_DYNAMODB`, `AMAZON_ELASTICSEARCH`, `AMAZON_EVENTBRIDGE`, or `AMAZON_OPENSEARCH_SERVICE`.
     */
    serviceRoleArn?: pulumi.Input<string>;
    /**
     * Type of the Data Source. Valid values: `AWS_LAMBDA`, `AMAZON_DYNAMODB`, `AMAZON_ELASTICSEARCH`, `HTTP`, `NONE`, `RELATIONAL_DATABASE`, `AMAZON_EVENTBRIDGE`, `AMAZON_OPENSEARCH_SERVICE`.
     */
    type?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a DataSource resource.
 */
export interface DataSourceArgs {
    /**
     * API ID for the GraphQL API for the data source.
     */
    apiId: pulumi.Input<string>;
    /**
     * Description of the data source.
     */
    description?: pulumi.Input<string>;
    /**
     * DynamoDB settings. See `dynamodbConfig` Block for details.
     */
    dynamodbConfig?: pulumi.Input<inputs.appsync.DataSourceDynamodbConfig>;
    /**
     * Amazon Elasticsearch settings. See `elasticsearchConfig` Block for details.
     */
    elasticsearchConfig?: pulumi.Input<inputs.appsync.DataSourceElasticsearchConfig>;
    /**
     * AWS EventBridge settings. See `eventBridgeConfig` Block for details.
     */
    eventBridgeConfig?: pulumi.Input<inputs.appsync.DataSourceEventBridgeConfig>;
    /**
     * HTTP settings. See `httpConfig` Block for details.
     */
    httpConfig?: pulumi.Input<inputs.appsync.DataSourceHttpConfig>;
    /**
     * AWS Lambda settings. See `lambdaConfig` Block for details.
     */
    lambdaConfig?: pulumi.Input<inputs.appsync.DataSourceLambdaConfig>;
    /**
     * User-supplied name for the data source.
     */
    name?: pulumi.Input<string>;
    /**
     * Amazon OpenSearch Service settings. See `opensearchserviceConfig` Block for details.
     */
    opensearchserviceConfig?: pulumi.Input<inputs.appsync.DataSourceOpensearchserviceConfig>;
    /**
     * AWS RDS settings. See `relationalDatabaseConfig` Block for details.
     */
    relationalDatabaseConfig?: pulumi.Input<inputs.appsync.DataSourceRelationalDatabaseConfig>;
    /**
     * IAM service role ARN for the data source. Required if `type` is specified as `AWS_LAMBDA`, `AMAZON_DYNAMODB`, `AMAZON_ELASTICSEARCH`, `AMAZON_EVENTBRIDGE`, or `AMAZON_OPENSEARCH_SERVICE`.
     */
    serviceRoleArn?: pulumi.Input<string>;
    /**
     * Type of the Data Source. Valid values: `AWS_LAMBDA`, `AMAZON_DYNAMODB`, `AMAZON_ELASTICSEARCH`, `HTTP`, `NONE`, `RELATIONAL_DATABASE`, `AMAZON_EVENTBRIDGE`, `AMAZON_OPENSEARCH_SERVICE`.
     */
    type: pulumi.Input<string>;
}
