// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.imagebuilder.WorkflowArgs;
import com.pulumi.aws.imagebuilder.inputs.WorkflowState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS EC2 Image Builder Workflow.
 * 
 * &gt; Image Builder manages the workflows for the distribution stage. Therefore, using the DISTRIBUTION workflow type results in an error.
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
 * import com.pulumi.aws.imagebuilder.Workflow;
 * import com.pulumi.aws.imagebuilder.WorkflowArgs;
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
 *         var example = new Workflow("example", WorkflowArgs.builder()
 *             .name("example")
 *             .version("1.0.0")
 *             .type("TEST")
 *             .data("""
 * name: example
 * description: Workflow to test an image
 * schemaVersion: 1.0
 * 
 * parameters:
 *   - name: waitForActionAtEnd
 *     type: boolean
 * 
 * steps:
 *   - name: LaunchTestInstance
 *     action: LaunchInstance
 *     onFailure: Abort
 *     inputs:
 *       waitFor: "ssmAgent"
 * 
 *   - name: TerminateTestInstance
 *     action: TerminateInstance
 *     onFailure: Continue
 *     inputs:
 *       instanceId.$: "$.stepOutputs.LaunchTestInstance.instanceId"
 * 
 *   - name: WaitForActionAtEnd
 *     action: WaitForAction
 *     if:
 *       booleanEquals: true
 *       value: "$.parameters.waitForActionAtEnd"
 *             """)
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
 * Using `pulumi import`, import EC2 Image Builder Workflow using the `example_id_arg`. For example:
 * 
 * ```sh
 * $ pulumi import aws:imagebuilder/workflow:Workflow example arn:aws:imagebuilder:us-east-1:aws:workflow/test/example/1.0.1/1
 * ```
 * Certain resource arguments, such as `uri`, cannot be read via the API and imported into Terraform. Terraform will display a difference for these arguments the first run after import if declared in the Terraform configuration for an imported resource.
 * 
 */
@ResourceType(type="aws:imagebuilder/workflow:Workflow")
public class Workflow extends com.pulumi.resources.CustomResource {
    /**
     * Amazon Resource Name (ARN) of the workflow.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of the workflow.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Change description of the workflow.
     * 
     */
    @Export(name="changeDescription", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> changeDescription;

    /**
     * @return Change description of the workflow.
     * 
     */
    public Output<Optional<String>> changeDescription() {
        return Codegen.optional(this.changeDescription);
    }
    /**
     * Inline YAML string with data of the workflow. Exactly one of `data` and `uri` can be specified.
     * 
     */
    @Export(name="data", refs={String.class}, tree="[0]")
    private Output<String> data;

    /**
     * @return Inline YAML string with data of the workflow. Exactly one of `data` and `uri` can be specified.
     * 
     */
    public Output<String> data() {
        return this.data;
    }
    /**
     * Date the workflow was created.
     * 
     */
    @Export(name="dateCreated", refs={String.class}, tree="[0]")
    private Output<String> dateCreated;

    /**
     * @return Date the workflow was created.
     * 
     */
    public Output<String> dateCreated() {
        return this.dateCreated;
    }
    /**
     * Description of the workflow.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Description of the workflow.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Amazon Resource Name (ARN) of the Key Management Service (KMS) Key used to encrypt the workflow.
     * 
     */
    @Export(name="kmsKeyId", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> kmsKeyId;

    /**
     * @return Amazon Resource Name (ARN) of the Key Management Service (KMS) Key used to encrypt the workflow.
     * 
     */
    public Output<Optional<String>> kmsKeyId() {
        return Codegen.optional(this.kmsKeyId);
    }
    /**
     * Name of the workflow.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the workflow.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Owner of the workflow.
     * 
     */
    @Export(name="owner", refs={String.class}, tree="[0]")
    private Output<String> owner;

    /**
     * @return Owner of the workflow.
     * 
     */
    public Output<String> owner() {
        return this.owner;
    }
    /**
     * Key-value map of resource tags for the workflow. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags for the workflow. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
     * Type of the workflow. Valid values: `BUILD`, `TEST`.
     * 
     */
    @Export(name="type", refs={String.class}, tree="[0]")
    private Output<String> type;

    /**
     * @return Type of the workflow. Valid values: `BUILD`, `TEST`.
     * 
     */
    public Output<String> type() {
        return this.type;
    }
    /**
     * S3 URI with data of the workflow. Exactly one of `data` and `uri` can be specified.
     * 
     */
    @Export(name="uri", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> uri;

    /**
     * @return S3 URI with data of the workflow. Exactly one of `data` and `uri` can be specified.
     * 
     */
    public Output<Optional<String>> uri() {
        return Codegen.optional(this.uri);
    }
    /**
     * Version of the workflow.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="version", refs={String.class}, tree="[0]")
    private Output<String> version;

    /**
     * @return Version of the workflow.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> version() {
        return this.version;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Workflow(java.lang.String name) {
        this(name, WorkflowArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Workflow(java.lang.String name, WorkflowArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Workflow(java.lang.String name, WorkflowArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:imagebuilder/workflow:Workflow", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Workflow(java.lang.String name, Output<java.lang.String> id, @Nullable WorkflowState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:imagebuilder/workflow:Workflow", name, state, makeResourceOptions(options, id), false);
    }

    private static WorkflowArgs makeArgs(WorkflowArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? WorkflowArgs.Empty : args;
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
    public static Workflow get(java.lang.String name, Output<java.lang.String> id, @Nullable WorkflowState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Workflow(name, id, state, options);
    }
}
