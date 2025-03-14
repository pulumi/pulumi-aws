// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkmanager;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.networkmanager.VpcAttachmentArgs;
import com.pulumi.aws.networkmanager.inputs.VpcAttachmentState;
import com.pulumi.aws.networkmanager.outputs.VpcAttachmentOptions;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS Network Manager VPC Attachment.
 * 
 * ## Example Usage
 * 
 * ### Basic Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.networkmanager.VpcAttachment;
 * import com.pulumi.aws.networkmanager.VpcAttachmentArgs;
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
 *         var example = new VpcAttachment("example", VpcAttachmentArgs.builder()
 *             .subnetArns(exampleAwsSubnet.arn())
 *             .coreNetworkId(exampleAwsccNetworkmanagerCoreNetwork.id())
 *             .vpcArn(exampleAwsVpc.arn())
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
 * Using `pulumi import`, import `aws_networkmanager_vpc_attachment` using the attachment ID. For example:
 * 
 * ```sh
 * $ pulumi import aws:networkmanager/vpcAttachment:VpcAttachment example attachment-0f8fa60d2238d1bd8
 * ```
 * 
 */
@ResourceType(type="aws:networkmanager/vpcAttachment:VpcAttachment")
public class VpcAttachment extends com.pulumi.resources.CustomResource {
    /**
     * The ARN of the attachment.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the attachment.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The policy rule number associated with the attachment.
     * 
     */
    @Export(name="attachmentPolicyRuleNumber", refs={Integer.class}, tree="[0]")
    private Output<Integer> attachmentPolicyRuleNumber;

    /**
     * @return The policy rule number associated with the attachment.
     * 
     */
    public Output<Integer> attachmentPolicyRuleNumber() {
        return this.attachmentPolicyRuleNumber;
    }
    /**
     * The type of attachment.
     * 
     */
    @Export(name="attachmentType", refs={String.class}, tree="[0]")
    private Output<String> attachmentType;

    /**
     * @return The type of attachment.
     * 
     */
    public Output<String> attachmentType() {
        return this.attachmentType;
    }
    /**
     * The ARN of a core network.
     * 
     */
    @Export(name="coreNetworkArn", refs={String.class}, tree="[0]")
    private Output<String> coreNetworkArn;

    /**
     * @return The ARN of a core network.
     * 
     */
    public Output<String> coreNetworkArn() {
        return this.coreNetworkArn;
    }
    /**
     * The ID of a core network for the VPC attachment.
     * 
     */
    @Export(name="coreNetworkId", refs={String.class}, tree="[0]")
    private Output<String> coreNetworkId;

    /**
     * @return The ID of a core network for the VPC attachment.
     * 
     */
    public Output<String> coreNetworkId() {
        return this.coreNetworkId;
    }
    /**
     * The Region where the edge is located.
     * 
     */
    @Export(name="edgeLocation", refs={String.class}, tree="[0]")
    private Output<String> edgeLocation;

    /**
     * @return The Region where the edge is located.
     * 
     */
    public Output<String> edgeLocation() {
        return this.edgeLocation;
    }
    /**
     * Options for the VPC attachment.
     * 
     */
    @Export(name="options", refs={VpcAttachmentOptions.class}, tree="[0]")
    private Output</* @Nullable */ VpcAttachmentOptions> options;

    /**
     * @return Options for the VPC attachment.
     * 
     */
    public Output<Optional<VpcAttachmentOptions>> options() {
        return Codegen.optional(this.options);
    }
    /**
     * The ID of the attachment account owner.
     * 
     */
    @Export(name="ownerAccountId", refs={String.class}, tree="[0]")
    private Output<String> ownerAccountId;

    /**
     * @return The ID of the attachment account owner.
     * 
     */
    public Output<String> ownerAccountId() {
        return this.ownerAccountId;
    }
    /**
     * The attachment resource ARN.
     * 
     */
    @Export(name="resourceArn", refs={String.class}, tree="[0]")
    private Output<String> resourceArn;

    /**
     * @return The attachment resource ARN.
     * 
     */
    public Output<String> resourceArn() {
        return this.resourceArn;
    }
    /**
     * The name of the segment attachment.
     * 
     */
    @Export(name="segmentName", refs={String.class}, tree="[0]")
    private Output<String> segmentName;

    /**
     * @return The name of the segment attachment.
     * 
     */
    public Output<String> segmentName() {
        return this.segmentName;
    }
    /**
     * The state of the attachment.
     * 
     */
    @Export(name="state", refs={String.class}, tree="[0]")
    private Output<String> state;

    /**
     * @return The state of the attachment.
     * 
     */
    public Output<String> state() {
        return this.state;
    }
    /**
     * The subnet ARN of the VPC attachment.
     * 
     */
    @Export(name="subnetArns", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> subnetArns;

    /**
     * @return The subnet ARN of the VPC attachment.
     * 
     */
    public Output<List<String>> subnetArns() {
        return this.subnetArns;
    }
    /**
     * Key-value tags for the attachment. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value tags for the attachment. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    /**
     * The ARN of the VPC.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="vpcArn", refs={String.class}, tree="[0]")
    private Output<String> vpcArn;

    /**
     * @return The ARN of the VPC.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> vpcArn() {
        return this.vpcArn;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public VpcAttachment(java.lang.String name) {
        this(name, VpcAttachmentArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public VpcAttachment(java.lang.String name, VpcAttachmentArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public VpcAttachment(java.lang.String name, VpcAttachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:networkmanager/vpcAttachment:VpcAttachment", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private VpcAttachment(java.lang.String name, Output<java.lang.String> id, @Nullable VpcAttachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:networkmanager/vpcAttachment:VpcAttachment", name, state, makeResourceOptions(options, id), false);
    }

    private static VpcAttachmentArgs makeArgs(VpcAttachmentArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? VpcAttachmentArgs.Empty : args;
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
    public static VpcAttachment get(java.lang.String name, Output<java.lang.String> id, @Nullable VpcAttachmentState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new VpcAttachment(name, id, state, options);
    }
}
