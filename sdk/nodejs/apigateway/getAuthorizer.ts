// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides details about a specific API Gateway Authorizer.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.apigateway.getAuthorizer({
 *     restApiId: exampleAwsApiGatewayRestApi.id,
 *     authorizerId: exampleAwsApiGatewayAuthorizers.ids[0],
 * });
 * ```
 */
export function getAuthorizer(args: GetAuthorizerArgs, opts?: pulumi.InvokeOptions): Promise<GetAuthorizerResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:apigateway/getAuthorizer:getAuthorizer", {
        "authorizerId": args.authorizerId,
        "restApiId": args.restApiId,
    }, opts);
}

/**
 * A collection of arguments for invoking getAuthorizer.
 */
export interface GetAuthorizerArgs {
    /**
     * Authorizer identifier.
     */
    authorizerId: string;
    /**
     * ID of the associated REST API.
     */
    restApiId: string;
}

/**
 * A collection of values returned by getAuthorizer.
 */
export interface GetAuthorizerResult {
    /**
     * ARN of the API Gateway Authorizer.
     */
    readonly arn: string;
    /**
     * Credentials required for the authorizer.
     */
    readonly authorizerCredentials: string;
    readonly authorizerId: string;
    /**
     * TTL of cached authorizer results in seconds.
     */
    readonly authorizerResultTtlInSeconds: number;
    /**
     * Authorizer's Uniform Resource Identifier (URI).
     */
    readonly authorizerUri: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Source of the identity in an incoming request.
     */
    readonly identitySource: string;
    /**
     * Validation expression for the incoming identity.
     */
    readonly identityValidationExpression: string;
    /**
     * Name of the authorizer.
     */
    readonly name: string;
    /**
     * List of the Amazon Cognito user pool ARNs.
     */
    readonly providerArns: string[];
    readonly restApiId: string;
    /**
     * Type of the authorizer.
     */
    readonly type: string;
}
/**
 * Provides details about a specific API Gateway Authorizer.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.apigateway.getAuthorizer({
 *     restApiId: exampleAwsApiGatewayRestApi.id,
 *     authorizerId: exampleAwsApiGatewayAuthorizers.ids[0],
 * });
 * ```
 */
export function getAuthorizerOutput(args: GetAuthorizerOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetAuthorizerResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:apigateway/getAuthorizer:getAuthorizer", {
        "authorizerId": args.authorizerId,
        "restApiId": args.restApiId,
    }, opts);
}

/**
 * A collection of arguments for invoking getAuthorizer.
 */
export interface GetAuthorizerOutputArgs {
    /**
     * Authorizer identifier.
     */
    authorizerId: pulumi.Input<string>;
    /**
     * ID of the associated REST API.
     */
    restApiId: pulumi.Input<string>;
}
