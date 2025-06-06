// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides details about a specific Amazon Lex Bot Alias.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const orderFlowersProd = aws.lex.getBotAlias({
 *     botName: "OrderFlowers",
 *     name: "OrderFlowersProd",
 * });
 * ```
 */
export function getBotAlias(args: GetBotAliasArgs, opts?: pulumi.InvokeOptions): Promise<GetBotAliasResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:lex/getBotAlias:getBotAlias", {
        "botName": args.botName,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getBotAlias.
 */
export interface GetBotAliasArgs {
    /**
     * Name of the bot.
     */
    botName: string;
    /**
     * Name of the bot alias. The name is case sensitive.
     */
    name: string;
}

/**
 * A collection of values returned by getBotAlias.
 */
export interface GetBotAliasResult {
    /**
     * ARN of the bot alias.
     */
    readonly arn: string;
    /**
     * Name of the bot.
     */
    readonly botName: string;
    /**
     * Version of the bot that the alias points to.
     */
    readonly botVersion: string;
    /**
     * Checksum of the bot alias.
     */
    readonly checksum: string;
    /**
     * Date that the bot alias was created.
     */
    readonly createdDate: string;
    /**
     * Description of the alias.
     */
    readonly description: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Date that the bot alias was updated. When you create a resource, the creation date and the last updated date are the same.
     */
    readonly lastUpdatedDate: string;
    /**
     * Name of the alias. The name is not case sensitive.
     */
    readonly name: string;
}
/**
 * Provides details about a specific Amazon Lex Bot Alias.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const orderFlowersProd = aws.lex.getBotAlias({
 *     botName: "OrderFlowers",
 *     name: "OrderFlowersProd",
 * });
 * ```
 */
export function getBotAliasOutput(args: GetBotAliasOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetBotAliasResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:lex/getBotAlias:getBotAlias", {
        "botName": args.botName,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getBotAlias.
 */
export interface GetBotAliasOutputArgs {
    /**
     * Name of the bot.
     */
    botName: pulumi.Input<string>;
    /**
     * Name of the bot alias. The name is case sensitive.
     */
    name: pulumi.Input<string>;
}
