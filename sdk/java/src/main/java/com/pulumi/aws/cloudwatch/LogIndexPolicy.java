// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cloudwatch.LogIndexPolicyArgs;
import com.pulumi.aws.cloudwatch.inputs.LogIndexPolicyState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS CloudWatch Logs Index Policy.
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
 * import com.pulumi.aws.cloudwatch.LogGroup;
 * import com.pulumi.aws.cloudwatch.LogGroupArgs;
 * import com.pulumi.aws.cloudwatch.LogIndexPolicy;
 * import com.pulumi.aws.cloudwatch.LogIndexPolicyArgs;
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
 *         var example = new LogGroup("example", LogGroupArgs.builder()
 *             .name("example")
 *             .build());
 * 
 *         var exampleLogIndexPolicy = new LogIndexPolicy("exampleLogIndexPolicy", LogIndexPolicyArgs.builder()
 *             .logGroupName(example.name())
 *             .policyDocument(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("Fields", jsonArray("eventName"))
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
 * Using `pulumi import`, import CloudWatch Logs Index Policy using the `log_group_name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:cloudwatch/logIndexPolicy:LogIndexPolicy example /aws/log/group/name
 * ```
 * 
 */
@ResourceType(type="aws:cloudwatch/logIndexPolicy:LogIndexPolicy")
public class LogIndexPolicy extends com.pulumi.resources.CustomResource {
    /**
     * Log group name to set the policy for.
     * 
     */
    @Export(name="logGroupName", refs={String.class}, tree="[0]")
    private Output<String> logGroupName;

    /**
     * @return Log group name to set the policy for.
     * 
     */
    public Output<String> logGroupName() {
        return this.logGroupName;
    }
    /**
     * JSON policy document. This is a JSON formatted string.
     * 
     */
    @Export(name="policyDocument", refs={String.class}, tree="[0]")
    private Output<String> policyDocument;

    /**
     * @return JSON policy document. This is a JSON formatted string.
     * 
     */
    public Output<String> policyDocument() {
        return this.policyDocument;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public LogIndexPolicy(java.lang.String name) {
        this(name, LogIndexPolicyArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public LogIndexPolicy(java.lang.String name, LogIndexPolicyArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public LogIndexPolicy(java.lang.String name, LogIndexPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/logIndexPolicy:LogIndexPolicy", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private LogIndexPolicy(java.lang.String name, Output<java.lang.String> id, @Nullable LogIndexPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/logIndexPolicy:LogIndexPolicy", name, state, makeResourceOptions(options, id), false);
    }

    private static LogIndexPolicyArgs makeArgs(LogIndexPolicyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? LogIndexPolicyArgs.Empty : args;
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
    public static LogIndexPolicy get(java.lang.String name, Output<java.lang.String> id, @Nullable LogIndexPolicyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new LogIndexPolicy(name, id, state, options);
    }
}
