// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides details about an Image Builder Image Pipeline.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.imagebuilder.getImagePipeline({
 *     arn: "arn:aws:imagebuilder:us-west-2:aws:image-pipeline/example",
 * });
 * ```
 */
export function getImagePipeline(args: GetImagePipelineArgs, opts?: pulumi.InvokeOptions): Promise<GetImagePipelineResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:imagebuilder/getImagePipeline:getImagePipeline", {
        "arn": args.arn,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getImagePipeline.
 */
export interface GetImagePipelineArgs {
    /**
     * ARN of the image pipeline.
     */
    arn: string;
    /**
     * Key-value map of resource tags for the image pipeline.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getImagePipeline.
 */
export interface GetImagePipelineResult {
    readonly arn: string;
    /**
     * ARN of the container recipe.
     */
    readonly containerRecipeArn: string;
    /**
     * Date the image pipeline was created.
     */
    readonly dateCreated: string;
    /**
     * Date the image pipeline was last run.
     */
    readonly dateLastRun: string;
    /**
     * Date the image pipeline will run next.
     */
    readonly dateNextRun: string;
    /**
     * Date the image pipeline was updated.
     */
    readonly dateUpdated: string;
    /**
     * Description of the image pipeline.
     */
    readonly description: string;
    /**
     * ARN of the Image Builder Distribution Configuration.
     */
    readonly distributionConfigurationArn: string;
    /**
     * Whether additional information about the image being created is collected.
     */
    readonly enhancedImageMetadataEnabled: boolean;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * ARN of the image recipe.
     */
    readonly imageRecipeArn: string;
    readonly imageScanningConfigurations: outputs.imagebuilder.GetImagePipelineImageScanningConfiguration[];
    /**
     * List of an object with image tests configuration.
     */
    readonly imageTestsConfigurations: outputs.imagebuilder.GetImagePipelineImageTestsConfiguration[];
    /**
     * ARN of the Image Builder Infrastructure Configuration.
     */
    readonly infrastructureConfigurationArn: string;
    /**
     * Name of the image pipeline.
     */
    readonly name: string;
    /**
     * Platform of the image pipeline.
     */
    readonly platform: string;
    /**
     * List of an object with schedule settings.
     */
    readonly schedules: outputs.imagebuilder.GetImagePipelineSchedule[];
    /**
     * Status of the image pipeline.
     */
    readonly status: string;
    /**
     * Key-value map of resource tags for the image pipeline.
     */
    readonly tags: {[key: string]: string};
}
/**
 * Provides details about an Image Builder Image Pipeline.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.imagebuilder.getImagePipeline({
 *     arn: "arn:aws:imagebuilder:us-west-2:aws:image-pipeline/example",
 * });
 * ```
 */
export function getImagePipelineOutput(args: GetImagePipelineOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetImagePipelineResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:imagebuilder/getImagePipeline:getImagePipeline", {
        "arn": args.arn,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getImagePipeline.
 */
export interface GetImagePipelineOutputArgs {
    /**
     * ARN of the image pipeline.
     */
    arn: pulumi.Input<string>;
    /**
     * Key-value map of resource tags for the image pipeline.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
