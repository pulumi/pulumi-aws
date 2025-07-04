// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.lightsail.Disk_attachmentArgs;
import com.pulumi.aws.lightsail.inputs.Disk_attachmentState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Manages a Lightsail disk attachment. Use this resource to attach additional storage disks to your Lightsail instances for expanded storage capacity.
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
 * import com.pulumi.aws.AwsFunctions;
 * import com.pulumi.aws.inputs.GetAvailabilityZonesArgs;
 * import com.pulumi.aws.lightsail.Disk;
 * import com.pulumi.aws.lightsail.DiskArgs;
 * import com.pulumi.aws.lightsail.Instance;
 * import com.pulumi.aws.lightsail.InstanceArgs;
 * import com.pulumi.aws.lightsail.Disk_attachment;
 * import com.pulumi.aws.lightsail.Disk_attachmentArgs;
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
 *         final var available = AwsFunctions.getAvailabilityZones(GetAvailabilityZonesArgs.builder()
 *             .state("available")
 *             .filters(GetAvailabilityZonesFilterArgs.builder()
 *                 .name("opt-in-status")
 *                 .values("opt-in-not-required")
 *                 .build())
 *             .build());
 * 
 *         var example = new Disk("example", DiskArgs.builder()
 *             .name("example-disk")
 *             .sizeInGb(8)
 *             .availabilityZone(available.names()[0])
 *             .build());
 * 
 *         var exampleInstance = new Instance("exampleInstance", InstanceArgs.builder()
 *             .name("example-instance")
 *             .availabilityZone(available.names()[0])
 *             .blueprintId("amazon_linux_2")
 *             .bundleId("nano_3_0")
 *             .build());
 * 
 *         var exampleDisk_attachment = new Disk_attachment("exampleDisk_attachment", Disk_attachmentArgs.builder()
 *             .diskName(example.name())
 *             .instanceName(exampleInstance.name())
 *             .diskPath("/dev/xvdf")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import `aws_lightsail_disk_attachment` using the id attribute. For example:
 * 
 * ```sh
 * $ pulumi import aws:lightsail/disk_attachment:Disk_attachment example example-disk,example-instance
 * ```
 * 
 */
@ResourceType(type="aws:lightsail/disk_attachment:Disk_attachment")
public class Disk_attachment extends com.pulumi.resources.CustomResource {
    /**
     * Name of the Lightsail disk.
     * 
     */
    @Export(name="diskName", refs={String.class}, tree="[0]")
    private Output<String> diskName;

    /**
     * @return Name of the Lightsail disk.
     * 
     */
    public Output<String> diskName() {
        return this.diskName;
    }
    /**
     * Disk path to expose to the instance.
     * 
     */
    @Export(name="diskPath", refs={String.class}, tree="[0]")
    private Output<String> diskPath;

    /**
     * @return Disk path to expose to the instance.
     * 
     */
    public Output<String> diskPath() {
        return this.diskPath;
    }
    /**
     * Name of the Lightsail instance to attach to.
     * 
     */
    @Export(name="instanceName", refs={String.class}, tree="[0]")
    private Output<String> instanceName;

    /**
     * @return Name of the Lightsail instance to attach to.
     * 
     */
    public Output<String> instanceName() {
        return this.instanceName;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Disk_attachment(java.lang.String name) {
        this(name, Disk_attachmentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Disk_attachment(java.lang.String name, Disk_attachmentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Disk_attachment(java.lang.String name, Disk_attachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lightsail/disk_attachment:Disk_attachment", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Disk_attachment(java.lang.String name, Output<java.lang.String> id, @Nullable Disk_attachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lightsail/disk_attachment:Disk_attachment", name, state, makeResourceOptions(options, id), false);
    }

    private static Disk_attachmentArgs makeArgs(Disk_attachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? Disk_attachmentArgs.Empty : args;
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
    public static Disk_attachment get(java.lang.String name, Output<java.lang.String> id, @Nullable Disk_attachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Disk_attachment(name, id, state, options);
    }
}
