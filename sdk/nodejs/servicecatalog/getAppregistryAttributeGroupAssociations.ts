// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Data source for managing AWS Service Catalog AppRegistry Attribute Group Associations.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.servicecatalog.getAppregistryAttributeGroupAssociations({
 *     id: "12456778723424sdffsdfsdq34,12234t3564dsfsdf34asff4ww3",
 * });
 * ```
 */
export function getAppregistryAttributeGroupAssociations(args?: GetAppregistryAttributeGroupAssociationsArgs, opts?: pulumi.InvokeOptions): Promise<GetAppregistryAttributeGroupAssociationsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:servicecatalog/getAppregistryAttributeGroupAssociations:getAppregistryAttributeGroupAssociations", {
        "id": args.id,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getAppregistryAttributeGroupAssociations.
 */
export interface GetAppregistryAttributeGroupAssociationsArgs {
    /**
     * ID of the application to which attribute groups are associated.
     */
    id?: string;
    /**
     * Name of the application to which attribute groups are associated.
     *
     * The following arguments are optional:
     */
    name?: string;
}

/**
 * A collection of values returned by getAppregistryAttributeGroupAssociations.
 */
export interface GetAppregistryAttributeGroupAssociationsResult {
    /**
     * Set of attribute group IDs this application is associated with.
     */
    readonly attributeGroupIds: string[];
    readonly id?: string;
    readonly name?: string;
}
/**
 * Data source for managing AWS Service Catalog AppRegistry Attribute Group Associations.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.servicecatalog.getAppregistryAttributeGroupAssociations({
 *     id: "12456778723424sdffsdfsdq34,12234t3564dsfsdf34asff4ww3",
 * });
 * ```
 */
export function getAppregistryAttributeGroupAssociationsOutput(args?: GetAppregistryAttributeGroupAssociationsOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetAppregistryAttributeGroupAssociationsResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:servicecatalog/getAppregistryAttributeGroupAssociations:getAppregistryAttributeGroupAssociations", {
        "id": args.id,
        "name": args.name,
    }, opts);
}

/**
 * A collection of arguments for invoking getAppregistryAttributeGroupAssociations.
 */
export interface GetAppregistryAttributeGroupAssociationsOutputArgs {
    /**
     * ID of the application to which attribute groups are associated.
     */
    id?: pulumi.Input<string>;
    /**
     * Name of the application to which attribute groups are associated.
     *
     * The following arguments are optional:
     */
    name?: pulumi.Input<string>;
}
