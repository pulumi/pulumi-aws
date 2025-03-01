// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securitylake;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.securitylake.AwsLogSourceArgs;
import com.pulumi.aws.securitylake.inputs.AwsLogSourceState;
import com.pulumi.aws.securitylake.outputs.AwsLogSourceSource;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an Amazon Security Lake AWS Log Source.
 * 
 * &gt; **NOTE:** A single `aws.securitylake.AwsLogSource` should be used to configure a log source across all regions and accounts.
 * 
 * &gt; **NOTE:** The underlying `aws.securitylake.DataLake` must be configured before creating the `aws.securitylake.AwsLogSource`. Use a `depends_on` statement.
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
 * import com.pulumi.aws.securitylake.AwsLogSource;
 * import com.pulumi.aws.securitylake.AwsLogSourceArgs;
 * import com.pulumi.aws.securitylake.inputs.AwsLogSourceSourceArgs;
 * import com.pulumi.resources.CustomResourceOptions;
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
 *         var example = new AwsLogSource("example", AwsLogSourceArgs.builder()
 *             .source(AwsLogSourceSourceArgs.builder()
 *                 .accounts("123456789012")
 *                 .regions("eu-west-1")
 *                 .sourceName("ROUTE53")
 *                 .build())
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(exampleAwsSecuritylakeDataLake)
 *                 .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import AWS log sources using the source name. For example:
 * 
 * ```sh
 * $ pulumi import aws:securitylake/awsLogSource:AwsLogSource example ROUTE53
 * ```
 * 
 */
@ResourceType(type="aws:securitylake/awsLogSource:AwsLogSource")
public class AwsLogSource extends com.pulumi.resources.CustomResource {
    /**
     * Specify the natively-supported AWS service to add as a source in Security Lake.
     * 
     */
    @Export(name="source", refs={AwsLogSourceSource.class}, tree="[0]")
    private Output</* @Nullable */ AwsLogSourceSource> source;

    /**
     * @return Specify the natively-supported AWS service to add as a source in Security Lake.
     * 
     */
    public Output<Optional<AwsLogSourceSource>> source() {
        return Codegen.optional(this.source);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public AwsLogSource(java.lang.String name) {
        this(name, AwsLogSourceArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public AwsLogSource(java.lang.String name, @Nullable AwsLogSourceArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public AwsLogSource(java.lang.String name, @Nullable AwsLogSourceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:securitylake/awsLogSource:AwsLogSource", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private AwsLogSource(java.lang.String name, Output<java.lang.String> id, @Nullable AwsLogSourceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:securitylake/awsLogSource:AwsLogSource", name, state, makeResourceOptions(options, id), false);
    }

    private static AwsLogSourceArgs makeArgs(@Nullable AwsLogSourceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? AwsLogSourceArgs.Empty : args;
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
    public static AwsLogSource get(java.lang.String name, Output<java.lang.String> id, @Nullable AwsLogSourceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new AwsLogSource(name, id, state, options);
    }
}
