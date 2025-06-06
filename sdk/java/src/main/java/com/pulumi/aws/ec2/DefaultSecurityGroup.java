// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ec2.DefaultSecurityGroupArgs;
import com.pulumi.aws.ec2.inputs.DefaultSecurityGroupState;
import com.pulumi.aws.ec2.outputs.DefaultSecurityGroupEgress;
import com.pulumi.aws.ec2.outputs.DefaultSecurityGroupIngress;
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
 * Provides a resource to manage a default security group. This resource can manage the default security group of the default or a non-default VPC.
 * 
 * &gt; **NOTE:** This is an advanced resource with special caveats. Please read this document in its entirety before using this resource. The `aws.ec2.DefaultSecurityGroup` resource behaves differently from normal resources. This provider does not _create_ this resource but instead attempts to &#34;adopt&#34; it into management.
 * 
 * When the provider first begins managing the default security group, it **immediately removes all ingress and egress rules in the Security Group**. It then creates any rules specified in the configuration. This way only the rules specified in the configuration are created.
 * 
 * This resource treats its inline rules as absolute; only the rules defined inline are created, and any additions/removals external to this resource will result in diff shown. For these reasons, this resource is incompatible with the `aws.ec2.SecurityGroupRule` resource.
 * 
 * For more information about default security groups, see the AWS documentation on [Default Security Groups][aws-default-security-groups]. To manage normal security groups, see the `aws.ec2.SecurityGroup` resource.
 * 
 * ## Example Usage
 * 
 * The following config gives the default security group the same rules that AWS provides by default but under management by this provider. This means that any ingress or egress rules added or changed will be detected as drift.
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ec2.Vpc;
 * import com.pulumi.aws.ec2.VpcArgs;
 * import com.pulumi.aws.ec2.DefaultSecurityGroup;
 * import com.pulumi.aws.ec2.DefaultSecurityGroupArgs;
 * import com.pulumi.aws.ec2.inputs.DefaultSecurityGroupIngressArgs;
 * import com.pulumi.aws.ec2.inputs.DefaultSecurityGroupEgressArgs;
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
 *         var mainvpc = new Vpc("mainvpc", VpcArgs.builder()
 *             .cidrBlock("10.1.0.0/16")
 *             .build());
 * 
 *         var default_ = new DefaultSecurityGroup("default", DefaultSecurityGroupArgs.builder()
 *             .vpcId(mainvpc.id())
 *             .ingress(DefaultSecurityGroupIngressArgs.builder()
 *                 .protocol("-1")
 *                 .self(true)
 *                 .fromPort(0)
 *                 .toPort(0)
 *                 .build())
 *             .egress(DefaultSecurityGroupEgressArgs.builder()
 *                 .fromPort(0)
 *                 .toPort(0)
 *                 .protocol("-1")
 *                 .cidrBlocks("0.0.0.0/0")
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Example Config To Deny All Egress Traffic, Allowing Ingress
 * 
 * The following denies all Egress traffic by omitting any `egress` rules, while including the default `ingress` rule to allow all traffic.
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ec2.Vpc;
 * import com.pulumi.aws.ec2.VpcArgs;
 * import com.pulumi.aws.ec2.DefaultSecurityGroup;
 * import com.pulumi.aws.ec2.DefaultSecurityGroupArgs;
 * import com.pulumi.aws.ec2.inputs.DefaultSecurityGroupIngressArgs;
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
 *         var mainvpc = new Vpc("mainvpc", VpcArgs.builder()
 *             .cidrBlock("10.1.0.0/16")
 *             .build());
 * 
 *         var default_ = new DefaultSecurityGroup("default", DefaultSecurityGroupArgs.builder()
 *             .vpcId(mainvpc.id())
 *             .ingress(DefaultSecurityGroupIngressArgs.builder()
 *                 .protocol("-1")
 *                 .self(true)
 *                 .fromPort(0)
 *                 .toPort(0)
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Removing `aws.ec2.DefaultSecurityGroup` From Your Configuration
 * 
 * Removing this resource from your configuration will remove it from your statefile and management, but will not destroy the Security Group. All ingress or egress rules will be left as they are at the time of removal. You can resume managing them via the AWS Console.
 * 
 * ## Import
 * 
 * Using `pulumi import`, import Security Groups using the security group `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:ec2/defaultSecurityGroup:DefaultSecurityGroup default_sg sg-903004f8
 * ```
 * 
 */
@ResourceType(type="aws:ec2/defaultSecurityGroup:DefaultSecurityGroup")
public class DefaultSecurityGroup extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the security group.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the security group.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Description of the security group.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output<String> description;

    /**
     * @return Description of the security group.
     * 
     */
    public Output<String> description() {
        return this.description;
    }
    /**
     * Configuration block. Detailed below.
     * 
     */
    @Export(name="egress", refs={List.class,DefaultSecurityGroupEgress.class}, tree="[0,1]")
    private Output<List<DefaultSecurityGroupEgress>> egress;

    /**
     * @return Configuration block. Detailed below.
     * 
     */
    public Output<List<DefaultSecurityGroupEgress>> egress() {
        return this.egress;
    }
    /**
     * Configuration block. Detailed below.
     * 
     */
    @Export(name="ingress", refs={List.class,DefaultSecurityGroupIngress.class}, tree="[0,1]")
    private Output<List<DefaultSecurityGroupIngress>> ingress;

    /**
     * @return Configuration block. Detailed below.
     * 
     */
    public Output<List<DefaultSecurityGroupIngress>> ingress() {
        return this.ingress;
    }
    /**
     * Name of the security group.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the security group.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    @Export(name="namePrefix", refs={String.class}, tree="[0]")
    private Output<String> namePrefix;

    public Output<String> namePrefix() {
        return this.namePrefix;
    }
    /**
     * Owner ID.
     * 
     */
    @Export(name="ownerId", refs={String.class}, tree="[0]")
    private Output<String> ownerId;

    /**
     * @return Owner ID.
     * 
     */
    public Output<String> ownerId() {
        return this.ownerId;
    }
    @Export(name="revokeRulesOnDelete", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> revokeRulesOnDelete;

    public Output<Optional<Boolean>> revokeRulesOnDelete() {
        return Codegen.optional(this.revokeRulesOnDelete);
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
     * VPC ID. **Note that changing the `vpc_id` will _not_ restore any default security group rules that were modified, added, or removed.** It will be left in its current state.
     * 
     */
    @Export(name="vpcId", refs={String.class}, tree="[0]")
    private Output<String> vpcId;

    /**
     * @return VPC ID. **Note that changing the `vpc_id` will _not_ restore any default security group rules that were modified, added, or removed.** It will be left in its current state.
     * 
     */
    public Output<String> vpcId() {
        return this.vpcId;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public DefaultSecurityGroup(java.lang.String name) {
        this(name, DefaultSecurityGroupArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public DefaultSecurityGroup(java.lang.String name, @Nullable DefaultSecurityGroupArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public DefaultSecurityGroup(java.lang.String name, @Nullable DefaultSecurityGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/defaultSecurityGroup:DefaultSecurityGroup", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private DefaultSecurityGroup(java.lang.String name, Output<java.lang.String> id, @Nullable DefaultSecurityGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/defaultSecurityGroup:DefaultSecurityGroup", name, state, makeResourceOptions(options, id), false);
    }

    private static DefaultSecurityGroupArgs makeArgs(@Nullable DefaultSecurityGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DefaultSecurityGroupArgs.Empty : args;
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
    public static DefaultSecurityGroup get(java.lang.String name, Output<java.lang.String> id, @Nullable DefaultSecurityGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new DefaultSecurityGroup(name, id, state, options);
    }
}
