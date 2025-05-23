// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudformation;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cloudformation.StackArgs;
import com.pulumi.aws.cloudformation.inputs.StackState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a CloudFormation Stack resource.
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
 * import com.pulumi.aws.cloudformation.Stack;
 * import com.pulumi.aws.cloudformation.StackArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
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
 *         var network = new Stack("network", StackArgs.builder()
 *             .name("networking-stack")
 *             .parameters(Map.of("VPCCidr", "10.0.0.0/16"))
 *             .templateBody(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("Parameters", jsonObject(
 *                         jsonProperty("VPCCidr", jsonObject(
 *                             jsonProperty("Type", "String"),
 *                             jsonProperty("Default", "10.0.0.0/16"),
 *                             jsonProperty("Description", "Enter the CIDR block for the VPC. Default is 10.0.0.0/16.")
 *                         ))
 *                     )),
 *                     jsonProperty("Resources", jsonObject(
 *                         jsonProperty("myVpc", jsonObject(
 *                             jsonProperty("Type", "AWS::EC2::VPC"),
 *                             jsonProperty("Properties", jsonObject(
 *                                 jsonProperty("CidrBlock", jsonObject(
 *                                     jsonProperty("Ref", "VPCCidr")
 *                                 )),
 *                                 jsonProperty("Tags", jsonArray(jsonObject(
 *                                     jsonProperty("Key", "Name"),
 *                                     jsonProperty("Value", "Primary_CF_VPC")
 *                                 )))
 *                             ))
 *                         ))
 *                     ))
 *                 )))
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
 * Using `pulumi import`, import Cloudformation Stacks using the `name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:cloudformation/stack:Stack stack networking-stack
 * ```
 * 
 */
@ResourceType(type="aws:cloudformation/stack:Stack")
public class Stack extends com.pulumi.resources.CustomResource {
    /**
     * A list of capabilities.
     * Valid values: `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, or `CAPABILITY_AUTO_EXPAND`
     * 
     */
    @Export(name="capabilities", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> capabilities;

    /**
     * @return A list of capabilities.
     * Valid values: `CAPABILITY_IAM`, `CAPABILITY_NAMED_IAM`, or `CAPABILITY_AUTO_EXPAND`
     * 
     */
    public Output<Optional<List<String>>> capabilities() {
        return Codegen.optional(this.capabilities);
    }
    /**
     * Set to true to disable rollback of the stack if stack creation failed.
     * Conflicts with `on_failure`.
     * 
     */
    @Export(name="disableRollback", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> disableRollback;

    /**
     * @return Set to true to disable rollback of the stack if stack creation failed.
     * Conflicts with `on_failure`.
     * 
     */
    public Output<Optional<Boolean>> disableRollback() {
        return Codegen.optional(this.disableRollback);
    }
    /**
     * The ARN of an IAM role that AWS CloudFormation assumes to create the stack. If you don&#39;t specify a value, AWS CloudFormation uses the role that was previously associated with the stack. If no role is available, AWS CloudFormation uses a temporary session that is generated from your user credentials.
     * 
     */
    @Export(name="iamRoleArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> iamRoleArn;

    /**
     * @return The ARN of an IAM role that AWS CloudFormation assumes to create the stack. If you don&#39;t specify a value, AWS CloudFormation uses the role that was previously associated with the stack. If no role is available, AWS CloudFormation uses a temporary session that is generated from your user credentials.
     * 
     */
    public Output<Optional<String>> iamRoleArn() {
        return Codegen.optional(this.iamRoleArn);
    }
    /**
     * Stack name.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Stack name.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * A list of SNS topic ARNs to publish stack related events.
     * 
     */
    @Export(name="notificationArns", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> notificationArns;

    /**
     * @return A list of SNS topic ARNs to publish stack related events.
     * 
     */
    public Output<Optional<List<String>>> notificationArns() {
        return Codegen.optional(this.notificationArns);
    }
    /**
     * Action to be taken if stack creation fails. This must be
     * one of: `DO_NOTHING`, `ROLLBACK`, or `DELETE`. Conflicts with `disable_rollback`.
     * 
     */
    @Export(name="onFailure", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> onFailure;

    /**
     * @return Action to be taken if stack creation fails. This must be
     * one of: `DO_NOTHING`, `ROLLBACK`, or `DELETE`. Conflicts with `disable_rollback`.
     * 
     */
    public Output<Optional<String>> onFailure() {
        return Codegen.optional(this.onFailure);
    }
    /**
     * A map of outputs from the stack.
     * 
     */
    @Export(name="outputs", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> outputs;

    /**
     * @return A map of outputs from the stack.
     * 
     */
    public Output<Map<String,String>> outputs() {
        return this.outputs;
    }
    /**
     * A map of Parameter structures that specify input parameters for the stack.
     * 
     */
    @Export(name="parameters", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> parameters;

    /**
     * @return A map of Parameter structures that specify input parameters for the stack.
     * 
     */
    public Output<Map<String,String>> parameters() {
        return this.parameters;
    }
    /**
     * Structure containing the stack policy body.
     * Conflicts w/ `policy_url`.
     * 
     */
    @Export(name="policyBody", refs={String.class}, tree="[0]")
    private Output<String> policyBody;

    /**
     * @return Structure containing the stack policy body.
     * Conflicts w/ `policy_url`.
     * 
     */
    public Output<String> policyBody() {
        return this.policyBody;
    }
    /**
     * Location of a file containing the stack policy.
     * Conflicts w/ `policy_body`.
     * 
     */
    @Export(name="policyUrl", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> policyUrl;

    /**
     * @return Location of a file containing the stack policy.
     * Conflicts w/ `policy_body`.
     * 
     */
    public Output<Optional<String>> policyUrl() {
        return Codegen.optional(this.policyUrl);
    }
    /**
     * Map of resource tags to associate with this stack. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of resource tags to associate with this stack. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
     * Structure containing the template body (max size: 51,200 bytes).
     * 
     */
    @Export(name="templateBody", refs={String.class}, tree="[0]")
    private Output<String> templateBody;

    /**
     * @return Structure containing the template body (max size: 51,200 bytes).
     * 
     */
    public Output<String> templateBody() {
        return this.templateBody;
    }
    /**
     * Location of a file containing the template body (max size: 460,800 bytes).
     * 
     */
    @Export(name="templateUrl", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> templateUrl;

    /**
     * @return Location of a file containing the template body (max size: 460,800 bytes).
     * 
     */
    public Output<Optional<String>> templateUrl() {
        return Codegen.optional(this.templateUrl);
    }
    /**
     * The amount of time that can pass before the stack status becomes `CREATE_FAILED`.
     * 
     */
    @Export(name="timeoutInMinutes", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> timeoutInMinutes;

    /**
     * @return The amount of time that can pass before the stack status becomes `CREATE_FAILED`.
     * 
     */
    public Output<Optional<Integer>> timeoutInMinutes() {
        return Codegen.optional(this.timeoutInMinutes);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Stack(java.lang.String name) {
        this(name, StackArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Stack(java.lang.String name, @Nullable StackArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Stack(java.lang.String name, @Nullable StackArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudformation/stack:Stack", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Stack(java.lang.String name, Output<java.lang.String> id, @Nullable StackState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudformation/stack:Stack", name, state, makeResourceOptions(options, id), false);
    }

    private static StackArgs makeArgs(@Nullable StackArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? StackArgs.Empty : args;
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
    public static Stack get(java.lang.String name, Output<java.lang.String> id, @Nullable StackState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Stack(name, id, state, options);
    }
}
