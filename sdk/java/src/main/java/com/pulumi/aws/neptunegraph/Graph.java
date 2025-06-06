// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.neptunegraph;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.neptunegraph.GraphArgs;
import com.pulumi.aws.neptunegraph.inputs.GraphState;
import com.pulumi.aws.neptunegraph.outputs.GraphTimeouts;
import com.pulumi.aws.neptunegraph.outputs.GraphVectorSearchConfiguration;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * The aws.neptunegraph.Graph resource creates an Amazon Analytics Graph.
 * 
 * ## Example Usage
 * 
 * ### Neptune Graph (with Vector Search configuration)
 * 
 * Creates a Neptune Graph with 16GB provisioned memory, vector search capability with 128 dimensions, and a single replica for high availability.
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.neptunegraph.Graph;
 * import com.pulumi.aws.neptunegraph.GraphArgs;
 * import com.pulumi.aws.neptunegraph.inputs.GraphVectorSearchConfigurationArgs;
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
 *         // Create Neptune Graph
 *         var example = new Graph("example", GraphArgs.builder()
 *             .graphName("example-graph-test-20250203")
 *             .provisionedMemory(16)
 *             .deletionProtection(false)
 *             .publicConnectivity(false)
 *             .replicaCount(1)
 *             .kmsKeyIdentifier("arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012")
 *             .vectorSearchConfiguration(GraphVectorSearchConfigurationArgs.builder()
 *                 .vectorSearchDimension(128)
 *                 .build())
 *             .tags(Map.ofEntries(
 *                 Map.entry("Environment", "Development"),
 *                 Map.entry("ModifiedBy", "AWS")
 *             ))
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
 * Using `pulumi import`, import `aws_neptunegraph_graph` using the graph identifier. For example:
 * 
 * ```sh
 * $ pulumi import aws:neptunegraph/graph:Graph example &#34;graph_id&#34;
 * ```
 * 
 */
@ResourceType(type="aws:neptunegraph/graph:Graph")
public class Graph extends com.pulumi.resources.CustomResource {
    /**
     * (String) Graph resource ARN
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return (String) Graph resource ARN
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Value that indicates whether the Graph has deletion protection enabled. The graph can&#39;t be deleted when deletion protection is enabled.
     * 
     */
    @Export(name="deletionProtection", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> deletionProtection;

    /**
     * @return Value that indicates whether the Graph has deletion protection enabled. The graph can&#39;t be deleted when deletion protection is enabled.
     * 
     */
    public Output<Boolean> deletionProtection() {
        return this.deletionProtection;
    }
    /**
     * (String) The connection endpoint for the graph. For example: `g-12a3bcdef4.us-east-1.neptune-graph.amazonaws.com`
     * 
     */
    @Export(name="endpoint", refs={String.class}, tree="[0]")
    private Output<String> endpoint;

    /**
     * @return (String) The connection endpoint for the graph. For example: `g-12a3bcdef4.us-east-1.neptune-graph.amazonaws.com`
     * 
     */
    public Output<String> endpoint() {
        return this.endpoint;
    }
    /**
     * The graph name. For example: my-graph-1. The name must contain from 1 to 63 letters, numbers, or hyphens, and its first
     * character must be a letter. It cannot end with a hyphen or contain two consecutive hyphens. If you don&#39;t specify a graph
     * name, a unique graph name is generated for you using the prefix graph-for, followed by a combination of Stack Name and a
     * UUID.
     * 
     */
    @Export(name="graphName", refs={String.class}, tree="[0]")
    private Output<String> graphName;

    /**
     * @return The graph name. For example: my-graph-1. The name must contain from 1 to 63 letters, numbers, or hyphens, and its first
     * character must be a letter. It cannot end with a hyphen or contain two consecutive hyphens. If you don&#39;t specify a graph
     * name, a unique graph name is generated for you using the prefix graph-for, followed by a combination of Stack Name and a
     * UUID.
     * 
     */
    public Output<String> graphName() {
        return this.graphName;
    }
    /**
     * Allows user to specify name prefix and have remainder of name automatically generated.
     * 
     */
    @Export(name="graphNamePrefix", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> graphNamePrefix;

    /**
     * @return Allows user to specify name prefix and have remainder of name automatically generated.
     * 
     */
    public Output<Optional<String>> graphNamePrefix() {
        return Codegen.optional(this.graphNamePrefix);
    }
    /**
     * The ARN for the KMS encryption key. By Default, Neptune Analytics will use an AWS provided key (&#34;AWS_OWNED_KEY&#34;). This parameter is used if you want to encrypt the graph using a KMS Customer Managed Key (CMK).
     * 
     */
    @Export(name="kmsKeyIdentifier", refs={String.class}, tree="[0]")
    private Output<String> kmsKeyIdentifier;

    /**
     * @return The ARN for the KMS encryption key. By Default, Neptune Analytics will use an AWS provided key (&#34;AWS_OWNED_KEY&#34;). This parameter is used if you want to encrypt the graph using a KMS Customer Managed Key (CMK).
     * 
     */
    public Output<String> kmsKeyIdentifier() {
        return this.kmsKeyIdentifier;
    }
    /**
     * The provisioned memory-optimized Neptune Capacity Units (m-NCUs) to use for the graph.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="provisionedMemory", refs={Integer.class}, tree="[0]")
    private Output<Integer> provisionedMemory;

    /**
     * @return The provisioned memory-optimized Neptune Capacity Units (m-NCUs) to use for the graph.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<Integer> provisionedMemory() {
        return this.provisionedMemory;
    }
    /**
     * Specifies whether the Graph can be reached over the internet. Access to all graphs requires IAM authentication.  When the Graph is publicly reachable, its Domain Name System (DNS) endpoint resolves to the public IP address from the internet.  When the Graph isn&#39;t publicly reachable, you need to create a PrivateGraphEndpoint in a given VPC to ensure the DNS name resolves to a private IP address that is reachable from the VPC.
     * 
     */
    @Export(name="publicConnectivity", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> publicConnectivity;

    /**
     * @return Specifies whether the Graph can be reached over the internet. Access to all graphs requires IAM authentication.  When the Graph is publicly reachable, its Domain Name System (DNS) endpoint resolves to the public IP address from the internet.  When the Graph isn&#39;t publicly reachable, you need to create a PrivateGraphEndpoint in a given VPC to ensure the DNS name resolves to a private IP address that is reachable from the VPC.
     * 
     */
    public Output<Boolean> publicConnectivity() {
        return this.publicConnectivity;
    }
    /**
     * Specifies the number of replicas you want when finished. All replicas will be provisioned in different availability zones.  Replica Count should always be less than or equal to 2.
     * 
     */
    @Export(name="replicaCount", refs={Integer.class}, tree="[0]")
    private Output<Integer> replicaCount;

    /**
     * @return Specifies the number of replicas you want when finished. All replicas will be provisioned in different availability zones.  Replica Count should always be less than or equal to 2.
     * 
     */
    public Output<Integer> replicaCount() {
        return this.replicaCount;
    }
    /**
     * The tags associated with this graph. (see below for nested schema of tags)
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return The tags associated with this graph. (see below for nested schema of tags)
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
    @Export(name="timeouts", refs={GraphTimeouts.class}, tree="[0]")
    private Output</* @Nullable */ GraphTimeouts> timeouts;

    public Output<Optional<GraphTimeouts>> timeouts() {
        return Codegen.optional(this.timeouts);
    }
    /**
     * Vector Search Configuration (see below for nested schema of vector_search_configuration)
     * 
     */
    @Export(name="vectorSearchConfiguration", refs={GraphVectorSearchConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ GraphVectorSearchConfiguration> vectorSearchConfiguration;

    /**
     * @return Vector Search Configuration (see below for nested schema of vector_search_configuration)
     * 
     */
    public Output<Optional<GraphVectorSearchConfiguration>> vectorSearchConfiguration() {
        return Codegen.optional(this.vectorSearchConfiguration);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Graph(java.lang.String name) {
        this(name, GraphArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Graph(java.lang.String name, GraphArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Graph(java.lang.String name, GraphArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:neptunegraph/graph:Graph", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Graph(java.lang.String name, Output<java.lang.String> id, @Nullable GraphState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:neptunegraph/graph:Graph", name, state, makeResourceOptions(options, id), false);
    }

    private static GraphArgs makeArgs(GraphArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? GraphArgs.Empty : args;
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
    public static Graph get(java.lang.String name, Output<java.lang.String> id, @Nullable GraphState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Graph(name, id, state, options);
    }
}
