// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ec2.NetworkInterfaceSecurityGroupAttachmentArgs;
import com.pulumi.aws.ec2.inputs.NetworkInterfaceSecurityGroupAttachmentState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * This resource attaches a security group to an Elastic Network Interface (ENI).
 * It can be used to attach a security group to any existing ENI, be it a
 * secondary ENI or one attached as the primary interface on an instance.
 * 
 * &gt; **NOTE on instances, interfaces, and security groups:** This provider currently
 * provides the capability to assign security groups via the [`aws.ec2.Instance`][1]
 * and the [`aws.ec2.NetworkInterface`][2] resources. Using this resource in
 * conjunction with security groups provided in-line in those resources will cause
 * conflicts, and will lead to spurious diffs and undefined behavior - please use
 * one or the other.
 * 
 * ## Example Usage
 * 
 * The following provides a very basic example of setting up an instance (provided
 * by `instance`) in the default security group, creating a security group
 * (provided by `sg`) and then attaching the security group to the instance&#39;s
 * primary network interface via the `aws.ec2.NetworkInterfaceSecurityGroupAttachment` resource,
 * named `sg_attachment`:
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ec2.Ec2Functions;
 * import com.pulumi.aws.ec2.inputs.GetAmiArgs;
 * import com.pulumi.aws.ec2.Instance;
 * import com.pulumi.aws.ec2.InstanceArgs;
 * import com.pulumi.aws.ec2.SecurityGroup;
 * import com.pulumi.aws.ec2.SecurityGroupArgs;
 * import com.pulumi.aws.ec2.NetworkInterfaceSecurityGroupAttachment;
 * import com.pulumi.aws.ec2.NetworkInterfaceSecurityGroupAttachmentArgs;
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
 *         final var ami = Ec2Functions.getAmi(GetAmiArgs.builder()
 *             .mostRecent(true)
 *             .filters(GetAmiFilterArgs.builder()
 *                 .name("name")
 *                 .values("amzn-ami-hvm-*")
 *                 .build())
 *             .owners("amazon")
 *             .build());
 * 
 *         var instance = new Instance("instance", InstanceArgs.builder()
 *             .instanceType("t2.micro")
 *             .ami(ami.id())
 *             .tags(Map.of("type", "test-instance"))
 *             .build());
 * 
 *         var sg = new SecurityGroup("sg", SecurityGroupArgs.builder()
 *             .tags(Map.of("type", "test-security-group"))
 *             .build());
 * 
 *         var sgAttachment = new NetworkInterfaceSecurityGroupAttachment("sgAttachment", NetworkInterfaceSecurityGroupAttachmentArgs.builder()
 *             .securityGroupId(sg.id())
 *             .networkInterfaceId(instance.primaryNetworkInterfaceId())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * In this example, `instance` is provided by the `aws.ec2.Instance` data source,
 * fetching an external instance, possibly not managed by this provider.
 * `sg_attachment` then attaches to the output instance&#39;s `network_interface_id`:
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ec2.Ec2Functions;
 * import com.pulumi.aws.ec2.inputs.GetInstanceArgs;
 * import com.pulumi.aws.ec2.SecurityGroup;
 * import com.pulumi.aws.ec2.SecurityGroupArgs;
 * import com.pulumi.aws.ec2.NetworkInterfaceSecurityGroupAttachment;
 * import com.pulumi.aws.ec2.NetworkInterfaceSecurityGroupAttachmentArgs;
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
 *         final var instance = Ec2Functions.getInstance(GetInstanceArgs.builder()
 *             .instanceId("i-1234567890abcdef0")
 *             .build());
 * 
 *         var sg = new SecurityGroup("sg", SecurityGroupArgs.builder()
 *             .tags(Map.of("type", "test-security-group"))
 *             .build());
 * 
 *         var sgAttachment = new NetworkInterfaceSecurityGroupAttachment("sgAttachment", NetworkInterfaceSecurityGroupAttachmentArgs.builder()
 *             .securityGroupId(sg.id())
 *             .networkInterfaceId(instance.networkInterfaceId())
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
 * Using `pulumi import`, import Network Interface Security Group attachments using the associated network interface ID and security group ID, separated by an underscore (`_`). For example:
 * 
 * ```sh
 * $ pulumi import aws:ec2/networkInterfaceSecurityGroupAttachment:NetworkInterfaceSecurityGroupAttachment sg_attachment eni-1234567890abcdef0_sg-1234567890abcdef0
 * ```
 * 
 */
@ResourceType(type="aws:ec2/networkInterfaceSecurityGroupAttachment:NetworkInterfaceSecurityGroupAttachment")
public class NetworkInterfaceSecurityGroupAttachment extends com.pulumi.resources.CustomResource {
    /**
     * The ID of the network interface to attach to.
     * 
     */
    @Export(name="networkInterfaceId", refs={String.class}, tree="[0]")
    private Output<String> networkInterfaceId;

    /**
     * @return The ID of the network interface to attach to.
     * 
     */
    public Output<String> networkInterfaceId() {
        return this.networkInterfaceId;
    }
    /**
     * The ID of the security group.
     * 
     */
    @Export(name="securityGroupId", refs={String.class}, tree="[0]")
    private Output<String> securityGroupId;

    /**
     * @return The ID of the security group.
     * 
     */
    public Output<String> securityGroupId() {
        return this.securityGroupId;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public NetworkInterfaceSecurityGroupAttachment(java.lang.String name) {
        this(name, NetworkInterfaceSecurityGroupAttachmentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public NetworkInterfaceSecurityGroupAttachment(java.lang.String name, NetworkInterfaceSecurityGroupAttachmentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public NetworkInterfaceSecurityGroupAttachment(java.lang.String name, NetworkInterfaceSecurityGroupAttachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/networkInterfaceSecurityGroupAttachment:NetworkInterfaceSecurityGroupAttachment", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private NetworkInterfaceSecurityGroupAttachment(java.lang.String name, Output<java.lang.String> id, @Nullable NetworkInterfaceSecurityGroupAttachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/networkInterfaceSecurityGroupAttachment:NetworkInterfaceSecurityGroupAttachment", name, state, makeResourceOptions(options, id), false);
    }

    private static NetworkInterfaceSecurityGroupAttachmentArgs makeArgs(NetworkInterfaceSecurityGroupAttachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? NetworkInterfaceSecurityGroupAttachmentArgs.Empty : args;
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
    public static NetworkInterfaceSecurityGroupAttachment get(java.lang.String name, Output<java.lang.String> id, @Nullable NetworkInterfaceSecurityGroupAttachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new NetworkInterfaceSecurityGroupAttachment(name, id, state, options);
    }
}
