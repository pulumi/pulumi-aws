// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ec2.AmiFromInstanceArgs;
import com.pulumi.aws.ec2.inputs.AmiFromInstanceState;
import com.pulumi.aws.ec2.outputs.AmiFromInstanceEbsBlockDevice;
import com.pulumi.aws.ec2.outputs.AmiFromInstanceEphemeralBlockDevice;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * The &#34;AMI from instance&#34; resource allows the creation of an Amazon Machine
 * Image (AMI) modeled after an existing EBS-backed EC2 instance.
 * 
 * The created AMI will refer to implicitly-created snapshots of the instance&#39;s
 * EBS volumes and mimick its assigned block device configuration at the time
 * the resource is created.
 * 
 * This resource is best applied to an instance that is stopped when this instance
 * is created, so that the contents of the created image are predictable. When
 * applied to an instance that is running, *the instance will be stopped before taking
 * the snapshots and then started back up again*, resulting in a period of
 * downtime.
 * 
 * Note that the source instance is inspected only at the initial creation of this
 * resource. Ongoing updates to the referenced instance will not be propagated into
 * the generated AMI. Users may taint or otherwise recreate the resource in order
 * to produce a fresh snapshot.
 * 
 * ## Example Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ec2.AmiFromInstance;
 * import com.pulumi.aws.ec2.AmiFromInstanceArgs;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var example = new AmiFromInstance("example", AmiFromInstanceArgs.builder()
 *             .name("example")
 *             .sourceInstanceId("i-xxxxxxxx")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 */
@ResourceType(type="aws:ec2/amiFromInstance:AmiFromInstance")
public class AmiFromInstance extends com.pulumi.resources.CustomResource {
    /**
     * Machine architecture for created instances. Defaults to `x86_64`.
     * 
     */
    @Export(name="architecture", refs={String.class}, tree="[0]")
    private Output<String> architecture;

    /**
     * @return Machine architecture for created instances. Defaults to `x86_64`.
     * 
     */
    public Output<String> architecture() {
        return this.architecture;
    }
    /**
     * ARN of the AMI.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the AMI.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Boot mode of the AMI. For more information, see [Boot modes](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ami-boot.html) in the Amazon Elastic Compute Cloud User Guide.
     * 
     */
    @Export(name="bootMode", refs={String.class}, tree="[0]")
    private Output<String> bootMode;

    /**
     * @return Boot mode of the AMI. For more information, see [Boot modes](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ami-boot.html) in the Amazon Elastic Compute Cloud User Guide.
     * 
     */
    public Output<String> bootMode() {
        return this.bootMode;
    }
    /**
     * Date and time to deprecate the AMI. If you specified a value for seconds, Amazon EC2 rounds the seconds to the nearest minute. Valid values: [RFC3339 time string](https://tools.ietf.org/html/rfc3339#section-5.8) (`YYYY-MM-DDTHH:MM:SSZ`)
     * 
     */
    @Export(name="deprecationTime", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> deprecationTime;

    /**
     * @return Date and time to deprecate the AMI. If you specified a value for seconds, Amazon EC2 rounds the seconds to the nearest minute. Valid values: [RFC3339 time string](https://tools.ietf.org/html/rfc3339#section-5.8) (`YYYY-MM-DDTHH:MM:SSZ`)
     * 
     */
    public Output<Optional<String>> deprecationTime() {
        return Codegen.optional(this.deprecationTime);
    }
    /**
     * Longer, human-readable description for the AMI.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Longer, human-readable description for the AMI.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Nested block describing an EBS block device that should be
     * attached to created instances. The structure of this block is described below.
     * 
     */
    @Export(name="ebsBlockDevices", refs={List.class,AmiFromInstanceEbsBlockDevice.class}, tree="[0,1]")
    private Output<List<AmiFromInstanceEbsBlockDevice>> ebsBlockDevices;

    /**
     * @return Nested block describing an EBS block device that should be
     * attached to created instances. The structure of this block is described below.
     * 
     */
    public Output<List<AmiFromInstanceEbsBlockDevice>> ebsBlockDevices() {
        return this.ebsBlockDevices;
    }
    /**
     * Whether enhanced networking with ENA is enabled. Defaults to `false`.
     * 
     */
    @Export(name="enaSupport", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> enaSupport;

    /**
     * @return Whether enhanced networking with ENA is enabled. Defaults to `false`.
     * 
     */
    public Output<Boolean> enaSupport() {
        return this.enaSupport;
    }
    /**
     * Nested block describing an ephemeral block device that
     * should be attached to created instances. The structure of this block is described below.
     * 
     */
    @Export(name="ephemeralBlockDevices", refs={List.class,AmiFromInstanceEphemeralBlockDevice.class}, tree="[0,1]")
    private Output<List<AmiFromInstanceEphemeralBlockDevice>> ephemeralBlockDevices;

    /**
     * @return Nested block describing an ephemeral block device that
     * should be attached to created instances. The structure of this block is described below.
     * 
     */
    public Output<List<AmiFromInstanceEphemeralBlockDevice>> ephemeralBlockDevices() {
        return this.ephemeralBlockDevices;
    }
    @Export(name="hypervisor", refs={String.class}, tree="[0]")
    private Output<String> hypervisor;

    public Output<String> hypervisor() {
        return this.hypervisor;
    }
    /**
     * Path to an S3 object containing an image manifest, e.g., created
     * by the `ec2-upload-bundle` command in the EC2 command line tools.
     * 
     */
    @Export(name="imageLocation", refs={String.class}, tree="[0]")
    private Output<String> imageLocation;

    /**
     * @return Path to an S3 object containing an image manifest, e.g., created
     * by the `ec2-upload-bundle` command in the EC2 command line tools.
     * 
     */
    public Output<String> imageLocation() {
        return this.imageLocation;
    }
    @Export(name="imageOwnerAlias", refs={String.class}, tree="[0]")
    private Output<String> imageOwnerAlias;

    public Output<String> imageOwnerAlias() {
        return this.imageOwnerAlias;
    }
    @Export(name="imageType", refs={String.class}, tree="[0]")
    private Output<String> imageType;

    public Output<String> imageType() {
        return this.imageType;
    }
    /**
     * If EC2 instances started from this image should require the use of the Instance Metadata Service V2 (IMDSv2), set this argument to `v2.0`. For more information, see [Configure instance metadata options for new instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/configuring-IMDS-new-instances.html#configure-IMDS-new-instances-ami-configuration).
     * 
     */
    @Export(name="imdsSupport", refs={String.class}, tree="[0]")
    private Output<String> imdsSupport;

    /**
     * @return If EC2 instances started from this image should require the use of the Instance Metadata Service V2 (IMDSv2), set this argument to `v2.0`. For more information, see [Configure instance metadata options for new instances](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/configuring-IMDS-new-instances.html#configure-IMDS-new-instances-ami-configuration).
     * 
     */
    public Output<String> imdsSupport() {
        return this.imdsSupport;
    }
    /**
     * ID of the kernel image (AKI) that will be used as the paravirtual
     * kernel in created instances.
     * 
     */
    @Export(name="kernelId", refs={String.class}, tree="[0]")
    private Output<String> kernelId;

    /**
     * @return ID of the kernel image (AKI) that will be used as the paravirtual
     * kernel in created instances.
     * 
     */
    public Output<String> kernelId() {
        return this.kernelId;
    }
    /**
     * Date and time, in ISO 8601 date-time format , when the AMI was last used to launch an EC2 instance. When the AMI is used to launch an instance, there is a 24-hour delay before that usage is reported. For more information, see the following [AWS document](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ami-last-launched-time.html).
     * 
     */
    @Export(name="lastLaunchedTime", refs={String.class}, tree="[0]")
    private Output<String> lastLaunchedTime;

    /**
     * @return Date and time, in ISO 8601 date-time format , when the AMI was last used to launch an EC2 instance. When the AMI is used to launch an instance, there is a 24-hour delay before that usage is reported. For more information, see the following [AWS document](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ami-last-launched-time.html).
     * 
     */
    public Output<String> lastLaunchedTime() {
        return this.lastLaunchedTime;
    }
    @Export(name="manageEbsSnapshots", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> manageEbsSnapshots;

    public Output<Boolean> manageEbsSnapshots() {
        return this.manageEbsSnapshots;
    }
    /**
     * Region-unique name for the AMI.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Region-unique name for the AMI.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    @Export(name="ownerId", refs={String.class}, tree="[0]")
    private Output<String> ownerId;

    public Output<String> ownerId() {
        return this.ownerId;
    }
    @Export(name="platform", refs={String.class}, tree="[0]")
    private Output<String> platform;

    public Output<String> platform() {
        return this.platform;
    }
    @Export(name="platformDetails", refs={String.class}, tree="[0]")
    private Output<String> platformDetails;

    public Output<String> platformDetails() {
        return this.platformDetails;
    }
    @Export(name="public", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> public_;

    public Output<Boolean> public_() {
        return this.public_;
    }
    /**
     * ID of an initrd image (ARI) that will be used when booting the
     * created instances.
     * 
     */
    @Export(name="ramdiskId", refs={String.class}, tree="[0]")
    private Output<String> ramdiskId;

    /**
     * @return ID of an initrd image (ARI) that will be used when booting the
     * created instances.
     * 
     */
    public Output<String> ramdiskId() {
        return this.ramdiskId;
    }
    /**
     * Name of the root device (for example, `/dev/sda1`, or `/dev/xvda`).
     * 
     */
    @Export(name="rootDeviceName", refs={String.class}, tree="[0]")
    private Output<String> rootDeviceName;

    /**
     * @return Name of the root device (for example, `/dev/sda1`, or `/dev/xvda`).
     * 
     */
    public Output<String> rootDeviceName() {
        return this.rootDeviceName;
    }
    @Export(name="rootSnapshotId", refs={String.class}, tree="[0]")
    private Output<String> rootSnapshotId;

    public Output<String> rootSnapshotId() {
        return this.rootSnapshotId;
    }
    /**
     * Boolean that overrides the behavior of stopping
     * the instance before snapshotting. This is risky since it may cause a snapshot of an
     * inconsistent filesystem state, but can be used to avoid downtime if the user otherwise
     * guarantees that no filesystem writes will be underway at the time of snapshot.
     * 
     */
    @Export(name="snapshotWithoutReboot", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> snapshotWithoutReboot;

    /**
     * @return Boolean that overrides the behavior of stopping
     * the instance before snapshotting. This is risky since it may cause a snapshot of an
     * inconsistent filesystem state, but can be used to avoid downtime if the user otherwise
     * guarantees that no filesystem writes will be underway at the time of snapshot.
     * 
     */
    public Output<Optional<Boolean>> snapshotWithoutReboot() {
        return Codegen.optional(this.snapshotWithoutReboot);
    }
    /**
     * ID of the instance to use as the basis of the AMI.
     * 
     */
    @Export(name="sourceInstanceId", refs={String.class}, tree="[0]")
    private Output<String> sourceInstanceId;

    /**
     * @return ID of the instance to use as the basis of the AMI.
     * 
     */
    public Output<String> sourceInstanceId() {
        return this.sourceInstanceId;
    }
    /**
     * When set to &#34;simple&#34; (the default), enables enhanced networking
     * for created instances. No other value is supported at this time.
     * 
     */
    @Export(name="sriovNetSupport", refs={String.class}, tree="[0]")
    private Output<String> sriovNetSupport;

    /**
     * @return When set to &#34;simple&#34; (the default), enables enhanced networking
     * for created instances. No other value is supported at this time.
     * 
     */
    public Output<String> sriovNetSupport() {
        return this.sriovNetSupport;
    }
    /**
     * Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    /**
     * If the image is configured for NitroTPM support, the value is `v2.0`. For more information, see [NitroTPM](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitrotpm.html) in the Amazon Elastic Compute Cloud User Guide.
     * 
     */
    @Export(name="tpmSupport", refs={String.class}, tree="[0]")
    private Output<String> tpmSupport;

    /**
     * @return If the image is configured for NitroTPM support, the value is `v2.0`. For more information, see [NitroTPM](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/nitrotpm.html) in the Amazon Elastic Compute Cloud User Guide.
     * 
     */
    public Output<String> tpmSupport() {
        return this.tpmSupport;
    }
    /**
     * Base64 representation of the non-volatile UEFI variable store.
     * 
     */
    @Export(name="uefiData", refs={String.class}, tree="[0]")
    private Output<String> uefiData;

    /**
     * @return Base64 representation of the non-volatile UEFI variable store.
     * 
     */
    public Output<String> uefiData() {
        return this.uefiData;
    }
    @Export(name="usageOperation", refs={String.class}, tree="[0]")
    private Output<String> usageOperation;

    public Output<String> usageOperation() {
        return this.usageOperation;
    }
    /**
     * Keyword to choose what virtualization mode created instances
     * will use. Can be either &#34;paravirtual&#34; (the default) or &#34;hvm&#34;. The choice of virtualization type
     * changes the set of further arguments that are required, as described below.
     * 
     */
    @Export(name="virtualizationType", refs={String.class}, tree="[0]")
    private Output<String> virtualizationType;

    /**
     * @return Keyword to choose what virtualization mode created instances
     * will use. Can be either &#34;paravirtual&#34; (the default) or &#34;hvm&#34;. The choice of virtualization type
     * changes the set of further arguments that are required, as described below.
     * 
     */
    public Output<String> virtualizationType() {
        return this.virtualizationType;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public AmiFromInstance(java.lang.String name) {
        this(name, AmiFromInstanceArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public AmiFromInstance(java.lang.String name, AmiFromInstanceArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public AmiFromInstance(java.lang.String name, AmiFromInstanceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/amiFromInstance:AmiFromInstance", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private AmiFromInstance(java.lang.String name, Output<java.lang.String> id, @Nullable AmiFromInstanceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/amiFromInstance:AmiFromInstance", name, state, makeResourceOptions(options, id), false);
    }

    private static AmiFromInstanceArgs makeArgs(AmiFromInstanceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? AmiFromInstanceArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .build();
        return com.pulumi.resources.CustomResourceOptions.merge(defaultOptions, options, id);
    }

    /**
     * Get an existing Host resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state
     * @param options Optional settings to control the behavior of the CustomResource.
     */
    public static AmiFromInstance get(java.lang.String name, Output<java.lang.String> id, @Nullable AmiFromInstanceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new AmiFromInstance(name, id, state, options);
    }
}
