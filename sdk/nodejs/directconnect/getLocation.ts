// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Retrieve information about a specific AWS Direct Connect location in the current AWS Region.
 * These are the locations that can be specified when configuring `aws.directconnect.Connection` or `aws.directconnect.LinkAggregationGroup` resources.
 *
 * > **Note:** This data source is different from the `aws.directconnect.getLocations` data source which retrieves information about all the AWS Direct Connect locations in the current AWS Region.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.directconnect.getLocation({
 *     locationCode: "CS32A-24FL",
 * });
 * ```
 */
export function getLocation(args: GetLocationArgs, opts?: pulumi.InvokeOptions): Promise<GetLocationResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:directconnect/getLocation:getLocation", {
        "locationCode": args.locationCode,
    }, opts);
}

/**
 * A collection of arguments for invoking getLocation.
 */
export interface GetLocationArgs {
    /**
     * Code for the location to retrieve.
     */
    locationCode: string;
}

/**
 * A collection of values returned by getLocation.
 */
export interface GetLocationResult {
    /**
     * The available MAC Security (MACsec) port speeds for the location.
     */
    readonly availableMacsecPortSpeeds: string[];
    /**
     * The available port speeds for the location.
     */
    readonly availablePortSpeeds: string[];
    /**
     * Names of the service providers for the location.
     */
    readonly availableProviders: string[];
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly locationCode: string;
    /**
     * Name of the location. This includes the name of the colocation partner and the physical site of the building.
     */
    readonly locationName: string;
}
/**
 * Retrieve information about a specific AWS Direct Connect location in the current AWS Region.
 * These are the locations that can be specified when configuring `aws.directconnect.Connection` or `aws.directconnect.LinkAggregationGroup` resources.
 *
 * > **Note:** This data source is different from the `aws.directconnect.getLocations` data source which retrieves information about all the AWS Direct Connect locations in the current AWS Region.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.directconnect.getLocation({
 *     locationCode: "CS32A-24FL",
 * });
 * ```
 */
export function getLocationOutput(args: GetLocationOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetLocationResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:directconnect/getLocation:getLocation", {
        "locationCode": args.locationCode,
    }, opts);
}

/**
 * A collection of arguments for invoking getLocation.
 */
export interface GetLocationOutputArgs {
    /**
     * Code for the location to retrieve.
     */
    locationCode: pulumi.Input<string>;
}
