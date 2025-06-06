// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an AWS EBS Volume Attachment as a top level resource, to attach and
 * detach volumes from AWS Instances.
 *
 * > **NOTE on EBS block devices:** If you use `ebsBlockDevice` on an `aws.ec2.Instance`, this provider will assume management over the full set of non-root EBS block devices for the instance, and treats additional block devices as drift. For this reason, `ebsBlockDevice` cannot be mixed with external `aws.ebs.Volume` + `aws.ec2.VolumeAttachment` resources for a given instance.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const web = new aws.ec2.Instance("web", {
 *     ami: "ami-21f78e11",
 *     availabilityZone: "us-west-2a",
 *     instanceType: aws.ec2.InstanceType.T2_Micro,
 *     tags: {
 *         Name: "HelloWorld",
 *     },
 * });
 * const example = new aws.ebs.Volume("example", {
 *     availabilityZone: "us-west-2a",
 *     size: 1,
 * });
 * const ebsAtt = new aws.ec2.VolumeAttachment("ebs_att", {
 *     deviceName: "/dev/sdh",
 *     volumeId: example.id,
 *     instanceId: web.id,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import EBS Volume Attachments using `DEVICE_NAME:VOLUME_ID:INSTANCE_ID`. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/volumeAttachment:VolumeAttachment example /dev/sdh:vol-049df61146c4d7901:i-12345678
 * ```
 */
export class VolumeAttachment extends pulumi.CustomResource {
    /**
     * Get an existing VolumeAttachment resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: VolumeAttachmentState, opts?: pulumi.CustomResourceOptions): VolumeAttachment {
        return new VolumeAttachment(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/volumeAttachment:VolumeAttachment';

    /**
     * Returns true if the given object is an instance of VolumeAttachment.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is VolumeAttachment {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === VolumeAttachment.__pulumiType;
    }

    /**
     * The device name to expose to the instance (for
     * example, `/dev/sdh` or `xvdh`).  See [Device Naming on Linux Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/device_naming.html#available-ec2-device-names) and [Device Naming on Windows Instances](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/device_naming.html#available-ec2-device-names) for more information.
     */
    public readonly deviceName!: pulumi.Output<string>;
    /**
     * Set to `true` if you want to force the
     * volume to detach. Useful if previous attempts failed, but use this option only
     * as a last resort, as this can result in **data loss**. See
     * [Detaching an Amazon EBS Volume from an Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html) for more information.
     */
    public readonly forceDetach!: pulumi.Output<boolean | undefined>;
    /**
     * ID of the Instance to attach to
     */
    public readonly instanceId!: pulumi.Output<string>;
    /**
     * Set this to true if you do not wish
     * to detach the volume from the instance to which it is attached at destroy
     * time, and instead just remove the attachment from this provider state. This is
     * useful when destroying an instance which has volumes created by some other
     * means attached.
     */
    public readonly skipDestroy!: pulumi.Output<boolean | undefined>;
    /**
     * Set this to true to ensure that the target instance is stopped
     * before trying to detach the volume. Stops the instance, if it is not already stopped.
     */
    public readonly stopInstanceBeforeDetaching!: pulumi.Output<boolean | undefined>;
    /**
     * ID of the Volume to be attached
     */
    public readonly volumeId!: pulumi.Output<string>;

    /**
     * Create a VolumeAttachment resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: VolumeAttachmentArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: VolumeAttachmentArgs | VolumeAttachmentState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as VolumeAttachmentState | undefined;
            resourceInputs["deviceName"] = state ? state.deviceName : undefined;
            resourceInputs["forceDetach"] = state ? state.forceDetach : undefined;
            resourceInputs["instanceId"] = state ? state.instanceId : undefined;
            resourceInputs["skipDestroy"] = state ? state.skipDestroy : undefined;
            resourceInputs["stopInstanceBeforeDetaching"] = state ? state.stopInstanceBeforeDetaching : undefined;
            resourceInputs["volumeId"] = state ? state.volumeId : undefined;
        } else {
            const args = argsOrState as VolumeAttachmentArgs | undefined;
            if ((!args || args.deviceName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'deviceName'");
            }
            if ((!args || args.instanceId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'instanceId'");
            }
            if ((!args || args.volumeId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'volumeId'");
            }
            resourceInputs["deviceName"] = args ? args.deviceName : undefined;
            resourceInputs["forceDetach"] = args ? args.forceDetach : undefined;
            resourceInputs["instanceId"] = args ? args.instanceId : undefined;
            resourceInputs["skipDestroy"] = args ? args.skipDestroy : undefined;
            resourceInputs["stopInstanceBeforeDetaching"] = args ? args.stopInstanceBeforeDetaching : undefined;
            resourceInputs["volumeId"] = args ? args.volumeId : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(VolumeAttachment.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering VolumeAttachment resources.
 */
export interface VolumeAttachmentState {
    /**
     * The device name to expose to the instance (for
     * example, `/dev/sdh` or `xvdh`).  See [Device Naming on Linux Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/device_naming.html#available-ec2-device-names) and [Device Naming on Windows Instances](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/device_naming.html#available-ec2-device-names) for more information.
     */
    deviceName?: pulumi.Input<string>;
    /**
     * Set to `true` if you want to force the
     * volume to detach. Useful if previous attempts failed, but use this option only
     * as a last resort, as this can result in **data loss**. See
     * [Detaching an Amazon EBS Volume from an Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html) for more information.
     */
    forceDetach?: pulumi.Input<boolean>;
    /**
     * ID of the Instance to attach to
     */
    instanceId?: pulumi.Input<string>;
    /**
     * Set this to true if you do not wish
     * to detach the volume from the instance to which it is attached at destroy
     * time, and instead just remove the attachment from this provider state. This is
     * useful when destroying an instance which has volumes created by some other
     * means attached.
     */
    skipDestroy?: pulumi.Input<boolean>;
    /**
     * Set this to true to ensure that the target instance is stopped
     * before trying to detach the volume. Stops the instance, if it is not already stopped.
     */
    stopInstanceBeforeDetaching?: pulumi.Input<boolean>;
    /**
     * ID of the Volume to be attached
     */
    volumeId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a VolumeAttachment resource.
 */
export interface VolumeAttachmentArgs {
    /**
     * The device name to expose to the instance (for
     * example, `/dev/sdh` or `xvdh`).  See [Device Naming on Linux Instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/device_naming.html#available-ec2-device-names) and [Device Naming on Windows Instances](https://docs.aws.amazon.com/AWSEC2/latest/WindowsGuide/device_naming.html#available-ec2-device-names) for more information.
     */
    deviceName: pulumi.Input<string>;
    /**
     * Set to `true` if you want to force the
     * volume to detach. Useful if previous attempts failed, but use this option only
     * as a last resort, as this can result in **data loss**. See
     * [Detaching an Amazon EBS Volume from an Instance](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-detaching-volume.html) for more information.
     */
    forceDetach?: pulumi.Input<boolean>;
    /**
     * ID of the Instance to attach to
     */
    instanceId: pulumi.Input<string>;
    /**
     * Set this to true if you do not wish
     * to detach the volume from the instance to which it is attached at destroy
     * time, and instead just remove the attachment from this provider state. This is
     * useful when destroying an instance which has volumes created by some other
     * means attached.
     */
    skipDestroy?: pulumi.Input<boolean>;
    /**
     * Set this to true to ensure that the target instance is stopped
     * before trying to detach the volume. Stops the instance, if it is not already stopped.
     */
    stopInstanceBeforeDetaching?: pulumi.Input<boolean>;
    /**
     * ID of the Volume to be attached
     */
    volumeId: pulumi.Input<string>;
}
