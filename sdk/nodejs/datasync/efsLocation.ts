// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

import {ARN} from "..";

/**
 * Manages an AWS DataSync EFS Location.
 *
 * > **NOTE:** The EFS File System must have a mounted EFS Mount Target before creating this resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.datasync.EfsLocation("example", {
 *     efsFileSystemArn: exampleAwsEfsMountTarget.fileSystemArn,
 *     ec2Config: {
 *         securityGroupArns: [exampleAwsSecurityGroup.arn],
 *         subnetArn: exampleAwsSubnet.arn,
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_datasync_location_efs` using the DataSync Task Amazon Resource Name (ARN). For example:
 *
 * ```sh
 * $ pulumi import aws:datasync/efsLocation:EfsLocation example arn:aws:datasync:us-east-1:123456789012:location/loc-12345678901234567
 * ```
 */
export class EfsLocation extends pulumi.CustomResource {
    /**
     * Get an existing EfsLocation resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: EfsLocationState, opts?: pulumi.CustomResourceOptions): EfsLocation {
        return new EfsLocation(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:datasync/efsLocation:EfsLocation';

    /**
     * Returns true if the given object is an instance of EfsLocation.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is EfsLocation {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === EfsLocation.__pulumiType;
    }

    /**
     * Specifies the Amazon Resource Name (ARN) of the access point that DataSync uses to access the Amazon EFS file system.
     */
    public readonly accessPointArn!: pulumi.Output<string | undefined>;
    /**
     * Amazon Resource Name (ARN) of the DataSync Location.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Configuration block containing EC2 configurations for connecting to the EFS File System.
     */
    public readonly ec2Config!: pulumi.Output<outputs.datasync.EfsLocationEc2Config>;
    /**
     * Amazon Resource Name (ARN) of EFS File System.
     */
    public readonly efsFileSystemArn!: pulumi.Output<ARN>;
    /**
     * Specifies an Identity and Access Management (IAM) role that DataSync assumes when mounting the Amazon EFS file system.
     */
    public readonly fileSystemAccessRoleArn!: pulumi.Output<string | undefined>;
    /**
     * Specifies whether you want DataSync to use TLS encryption when transferring data to or from your Amazon EFS file system. Valid values are `NONE` and `TLS1_2`.
     */
    public readonly inTransitEncryption!: pulumi.Output<string | undefined>;
    /**
     * Subdirectory to perform actions as source or destination. Default `/`.
     */
    public readonly subdirectory!: pulumi.Output<string | undefined>;
    /**
     * Key-value pairs of resource tags to assign to the DataSync Location. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    public /*out*/ readonly uri!: pulumi.Output<string>;

    /**
     * Create a EfsLocation resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: EfsLocationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: EfsLocationArgs | EfsLocationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as EfsLocationState | undefined;
            resourceInputs["accessPointArn"] = state ? state.accessPointArn : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["ec2Config"] = state ? state.ec2Config : undefined;
            resourceInputs["efsFileSystemArn"] = state ? state.efsFileSystemArn : undefined;
            resourceInputs["fileSystemAccessRoleArn"] = state ? state.fileSystemAccessRoleArn : undefined;
            resourceInputs["inTransitEncryption"] = state ? state.inTransitEncryption : undefined;
            resourceInputs["subdirectory"] = state ? state.subdirectory : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["uri"] = state ? state.uri : undefined;
        } else {
            const args = argsOrState as EfsLocationArgs | undefined;
            if ((!args || args.ec2Config === undefined) && !opts.urn) {
                throw new Error("Missing required property 'ec2Config'");
            }
            if ((!args || args.efsFileSystemArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'efsFileSystemArn'");
            }
            resourceInputs["accessPointArn"] = args ? args.accessPointArn : undefined;
            resourceInputs["ec2Config"] = args ? args.ec2Config : undefined;
            resourceInputs["efsFileSystemArn"] = args ? args.efsFileSystemArn : undefined;
            resourceInputs["fileSystemAccessRoleArn"] = args ? args.fileSystemAccessRoleArn : undefined;
            resourceInputs["inTransitEncryption"] = args ? args.inTransitEncryption : undefined;
            resourceInputs["subdirectory"] = args ? args.subdirectory : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["uri"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(EfsLocation.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering EfsLocation resources.
 */
export interface EfsLocationState {
    /**
     * Specifies the Amazon Resource Name (ARN) of the access point that DataSync uses to access the Amazon EFS file system.
     */
    accessPointArn?: pulumi.Input<string>;
    /**
     * Amazon Resource Name (ARN) of the DataSync Location.
     */
    arn?: pulumi.Input<string>;
    /**
     * Configuration block containing EC2 configurations for connecting to the EFS File System.
     */
    ec2Config?: pulumi.Input<inputs.datasync.EfsLocationEc2Config>;
    /**
     * Amazon Resource Name (ARN) of EFS File System.
     */
    efsFileSystemArn?: pulumi.Input<ARN>;
    /**
     * Specifies an Identity and Access Management (IAM) role that DataSync assumes when mounting the Amazon EFS file system.
     */
    fileSystemAccessRoleArn?: pulumi.Input<string>;
    /**
     * Specifies whether you want DataSync to use TLS encryption when transferring data to or from your Amazon EFS file system. Valid values are `NONE` and `TLS1_2`.
     */
    inTransitEncryption?: pulumi.Input<string>;
    /**
     * Subdirectory to perform actions as source or destination. Default `/`.
     */
    subdirectory?: pulumi.Input<string>;
    /**
     * Key-value pairs of resource tags to assign to the DataSync Location. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    uri?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a EfsLocation resource.
 */
export interface EfsLocationArgs {
    /**
     * Specifies the Amazon Resource Name (ARN) of the access point that DataSync uses to access the Amazon EFS file system.
     */
    accessPointArn?: pulumi.Input<string>;
    /**
     * Configuration block containing EC2 configurations for connecting to the EFS File System.
     */
    ec2Config: pulumi.Input<inputs.datasync.EfsLocationEc2Config>;
    /**
     * Amazon Resource Name (ARN) of EFS File System.
     */
    efsFileSystemArn: pulumi.Input<ARN>;
    /**
     * Specifies an Identity and Access Management (IAM) role that DataSync assumes when mounting the Amazon EFS file system.
     */
    fileSystemAccessRoleArn?: pulumi.Input<string>;
    /**
     * Specifies whether you want DataSync to use TLS encryption when transferring data to or from your Amazon EFS file system. Valid values are `NONE` and `TLS1_2`.
     */
    inTransitEncryption?: pulumi.Input<string>;
    /**
     * Subdirectory to perform actions as source or destination. Default `/`.
     */
    subdirectory?: pulumi.Input<string>;
    /**
     * Key-value pairs of resource tags to assign to the DataSync Location. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
