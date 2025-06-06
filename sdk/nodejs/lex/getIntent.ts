// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides details about a specific Amazon Lex Intent.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const orderFlowers = aws.lex.getIntent({
 *     name: "OrderFlowers",
 *     version: "$LATEST",
 * });
 * ```
 */
export function getIntent(args: GetIntentArgs, opts?: pulumi.InvokeOptions): Promise<GetIntentResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:lex/getIntent:getIntent", {
        "name": args.name,
        "version": args.version,
    }, opts);
}

/**
 * A collection of arguments for invoking getIntent.
 */
export interface GetIntentArgs {
    /**
     * Name of the intent. The name is case sensitive.
     */
    name: string;
    /**
     * Version of the intent.
     */
    version?: string;
}

/**
 * A collection of values returned by getIntent.
 */
export interface GetIntentResult {
    /**
     * ARN of the Lex intent.
     */
    readonly arn: string;
    /**
     * Checksum identifying the version of the intent that was created. The checksum is not
     * included as an argument because the resource will add it automatically when updating the intent.
     */
    readonly checksum: string;
    /**
     * Date when the intent version was created.
     */
    readonly createdDate: string;
    /**
     * Description of the intent.
     */
    readonly description: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Date when the $LATEST version of this intent was updated.
     */
    readonly lastUpdatedDate: string;
    /**
     * Name of the intent, not case sensitive.
     */
    readonly name: string;
    /**
     * A unique identifier for the built-in intent to base this
     * intent on. To find the signature for an intent, see
     * [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
     * in the Alexa Skills Kit.
     */
    readonly parentIntentSignature: string;
    /**
     * Version of the bot.
     */
    readonly version?: string;
}
/**
 * Provides details about a specific Amazon Lex Intent.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const orderFlowers = aws.lex.getIntent({
 *     name: "OrderFlowers",
 *     version: "$LATEST",
 * });
 * ```
 */
export function getIntentOutput(args: GetIntentOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetIntentResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:lex/getIntent:getIntent", {
        "name": args.name,
        "version": args.version,
    }, opts);
}

/**
 * A collection of arguments for invoking getIntent.
 */
export interface GetIntentOutputArgs {
    /**
     * Name of the intent. The name is case sensitive.
     */
    name: pulumi.Input<string>;
    /**
     * Version of the intent.
     */
    version?: pulumi.Input<string>;
}
