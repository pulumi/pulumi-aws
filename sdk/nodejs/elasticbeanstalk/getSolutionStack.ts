// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Use this data source to get the name of a elastic beanstalk solution stack.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const multiDocker = aws.elasticbeanstalk.getSolutionStack({
 *     mostRecent: true,
 *     nameRegex: "^64bit Amazon Linux (.*) Multi-container Docker (.*)$",
 * });
 * ```
 */
export function getSolutionStack(args: GetSolutionStackArgs, opts?: pulumi.InvokeOptions): Promise<GetSolutionStackResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:elasticbeanstalk/getSolutionStack:getSolutionStack", {
        "mostRecent": args.mostRecent,
        "nameRegex": args.nameRegex,
    }, opts);
}

/**
 * A collection of arguments for invoking getSolutionStack.
 */
export interface GetSolutionStackArgs {
    /**
     * If more than one result is returned, use the most
     * recent solution stack.
     */
    mostRecent?: boolean;
    /**
     * Regex string to apply to the solution stack list returned
     * by AWS. See [Elastic Beanstalk Supported Platforms][beanstalk-platforms] from
     * AWS documentation for reference solution stack names.
     *
     * > **NOTE:** If more or less than a single match is returned by the search,
     * this call will fail. Ensure that your search is specific enough to return
     * a single solution stack, or use `mostRecent` to choose the most recent one.
     */
    nameRegex: string;
}

/**
 * A collection of values returned by getSolutionStack.
 */
export interface GetSolutionStackResult {
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly mostRecent?: boolean;
    /**
     * Name of the solution stack.
     */
    readonly name: string;
    readonly nameRegex: string;
}
/**
 * Use this data source to get the name of a elastic beanstalk solution stack.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const multiDocker = aws.elasticbeanstalk.getSolutionStack({
 *     mostRecent: true,
 *     nameRegex: "^64bit Amazon Linux (.*) Multi-container Docker (.*)$",
 * });
 * ```
 */
export function getSolutionStackOutput(args: GetSolutionStackOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetSolutionStackResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:elasticbeanstalk/getSolutionStack:getSolutionStack", {
        "mostRecent": args.mostRecent,
        "nameRegex": args.nameRegex,
    }, opts);
}

/**
 * A collection of arguments for invoking getSolutionStack.
 */
export interface GetSolutionStackOutputArgs {
    /**
     * If more than one result is returned, use the most
     * recent solution stack.
     */
    mostRecent?: pulumi.Input<boolean>;
    /**
     * Regex string to apply to the solution stack list returned
     * by AWS. See [Elastic Beanstalk Supported Platforms][beanstalk-platforms] from
     * AWS documentation for reference solution stack names.
     *
     * > **NOTE:** If more or less than a single match is returned by the search,
     * this call will fail. Ensure that your search is specific enough to return
     * a single solution stack, or use `mostRecent` to choose the most recent one.
     */
    nameRegex: pulumi.Input<string>;
}
