// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides information about a Lambda Layer Version.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const config = new pulumi.Config();
 * const layerName = config.require("layerName");
 * const existing = aws.lambda.getLayerVersion({
 *     layerName: layerName,
 * });
 * ```
 */
export function getLayerVersion(args: GetLayerVersionArgs, opts?: pulumi.InvokeOptions): Promise<GetLayerVersionResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:lambda/getLayerVersion:getLayerVersion", {
        "compatibleArchitecture": args.compatibleArchitecture,
        "compatibleRuntime": args.compatibleRuntime,
        "layerName": args.layerName,
        "version": args.version,
    }, opts);
}

/**
 * A collection of arguments for invoking getLayerVersion.
 */
export interface GetLayerVersionArgs {
    /**
     * Specific architecture the layer version could support. Conflicts with `version`. If specified, the latest available layer version supporting the provided architecture will be used.
     */
    compatibleArchitecture?: string;
    /**
     * Specific runtime the layer version must support. Conflicts with `version`. If specified, the latest available layer version supporting the provided runtime will be used.
     */
    compatibleRuntime?: string;
    /**
     * Name of the lambda layer.
     */
    layerName: string;
    /**
     * Specific layer version. Conflicts with `compatibleRuntime` and `compatibleArchitecture`. If omitted, the latest available layer version will be used.
     */
    version?: number;
}

/**
 * A collection of values returned by getLayerVersion.
 */
export interface GetLayerVersionResult {
    /**
     * ARN of the Lambda Layer with version.
     */
    readonly arn: string;
    /**
     * Base64-encoded representation of raw SHA-256 sum of the zip file.
     */
    readonly codeSha256: string;
    readonly compatibleArchitecture?: string;
    /**
     * A list of [Architectures](https://docs.aws.amazon.com/lambda/latest/dg/API_GetLayerVersion.html#SSS-GetLayerVersion-response-CompatibleArchitectures) the specific Lambda Layer version is compatible with.
     */
    readonly compatibleArchitectures: string[];
    readonly compatibleRuntime?: string;
    /**
     * List of [Runtimes](https://docs.aws.amazon.com/lambda/latest/dg/API_GetLayerVersion.html#SSS-GetLayerVersion-response-CompatibleRuntimes) the specific Lambda Layer version is compatible with.
     */
    readonly compatibleRuntimes: string[];
    /**
     * Date this resource was created.
     */
    readonly createdDate: string;
    /**
     * Description of the specific Lambda Layer version.
     */
    readonly description: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * ARN of the Lambda Layer without version.
     */
    readonly layerArn: string;
    readonly layerName: string;
    /**
     * License info associated with the specific Lambda Layer version.
     */
    readonly licenseInfo: string;
    /**
     * ARN of a signing job.
     */
    readonly signingJobArn: string;
    /**
     * The ARN for a signing profile version.
     */
    readonly signingProfileVersionArn: string;
    /**
     * (**Deprecated** use `codeSha256` instead) Base64-encoded representation of raw SHA-256 sum of the zip file.
     *
     * @deprecated source_code_hash is deprecated. Use codeSha256 instead.
     */
    readonly sourceCodeHash: string;
    /**
     * Size in bytes of the function .zip file.
     */
    readonly sourceCodeSize: number;
    /**
     * This Lambda Layer version.
     */
    readonly version: number;
}
/**
 * Provides information about a Lambda Layer Version.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const config = new pulumi.Config();
 * const layerName = config.require("layerName");
 * const existing = aws.lambda.getLayerVersion({
 *     layerName: layerName,
 * });
 * ```
 */
export function getLayerVersionOutput(args: GetLayerVersionOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetLayerVersionResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:lambda/getLayerVersion:getLayerVersion", {
        "compatibleArchitecture": args.compatibleArchitecture,
        "compatibleRuntime": args.compatibleRuntime,
        "layerName": args.layerName,
        "version": args.version,
    }, opts);
}

/**
 * A collection of arguments for invoking getLayerVersion.
 */
export interface GetLayerVersionOutputArgs {
    /**
     * Specific architecture the layer version could support. Conflicts with `version`. If specified, the latest available layer version supporting the provided architecture will be used.
     */
    compatibleArchitecture?: pulumi.Input<string>;
    /**
     * Specific runtime the layer version must support. Conflicts with `version`. If specified, the latest available layer version supporting the provided runtime will be used.
     */
    compatibleRuntime?: pulumi.Input<string>;
    /**
     * Name of the lambda layer.
     */
    layerName: pulumi.Input<string>;
    /**
     * Specific layer version. Conflicts with `compatibleRuntime` and `compatibleArchitecture`. If omitted, the latest available layer version will be used.
     */
    version?: pulumi.Input<number>;
}
