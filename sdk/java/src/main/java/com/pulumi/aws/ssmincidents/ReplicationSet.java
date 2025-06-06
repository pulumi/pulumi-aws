// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssmincidents;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ssmincidents.ReplicationSetArgs;
import com.pulumi.aws.ssmincidents.inputs.ReplicationSetState;
import com.pulumi.aws.ssmincidents.outputs.ReplicationSetRegion;
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
 * Provides a resource for managing a replication set in AWS Systems Manager Incident Manager.
 * 
 * &gt; **NOTE:** Deleting a replication set also deletes all Incident Manager related data including response plans, incident records, contacts and escalation plans.
 * 
 * ## Example Usage
 * 
 * ### Basic Usage
 * 
 * Create a replication set.
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssmincidents.ReplicationSet;
 * import com.pulumi.aws.ssmincidents.ReplicationSetArgs;
 * import com.pulumi.aws.ssmincidents.inputs.ReplicationSetRegionArgs;
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
 *         var replicationSetName = new ReplicationSet("replicationSetName", ReplicationSetArgs.builder()
 *             .regions(ReplicationSetRegionArgs.builder()
 *                 .name("us-west-2")
 *                 .build())
 *             .tags(Map.of("exampleTag", "exampleValue"))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * Add a Region to a replication set. (You can add only one Region at a time.)
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssmincidents.ReplicationSet;
 * import com.pulumi.aws.ssmincidents.ReplicationSetArgs;
 * import com.pulumi.aws.ssmincidents.inputs.ReplicationSetRegionArgs;
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
 *         var replicationSetName = new ReplicationSet("replicationSetName", ReplicationSetArgs.builder()
 *             .regions(            
 *                 ReplicationSetRegionArgs.builder()
 *                     .name("us-west-2")
 *                     .build(),
 *                 ReplicationSetRegionArgs.builder()
 *                     .name("ap-southeast-2")
 *                     .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * Delete a Region from a replication set. (You can delete only one Region at a time.)
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.ssmincidents.ReplicationSet;
 * import com.pulumi.aws.ssmincidents.ReplicationSetArgs;
 * import com.pulumi.aws.ssmincidents.inputs.ReplicationSetRegionArgs;
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
 *         var replicationSetName = new ReplicationSet("replicationSetName", ReplicationSetArgs.builder()
 *             .regions(ReplicationSetRegionArgs.builder()
 *                 .name("us-west-2")
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Basic Usage with an AWS Customer Managed Key
 * 
 * Create a replication set with an AWS Key Management Service (AWS KMS) customer manager key:
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.kms.Key;
 * import com.pulumi.aws.ssmincidents.ReplicationSet;
 * import com.pulumi.aws.ssmincidents.ReplicationSetArgs;
 * import com.pulumi.aws.ssmincidents.inputs.ReplicationSetRegionArgs;
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
 *         var exampleKey = new Key("exampleKey");
 * 
 *         var replicationSetName = new ReplicationSet("replicationSetName", ReplicationSetArgs.builder()
 *             .regions(ReplicationSetRegionArgs.builder()
 *                 .name("us-west-2")
 *                 .kmsKeyArn(exampleKey.arn())
 *                 .build())
 *             .tags(Map.of("exampleTag", "exampleValue"))
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
 * Using `pulumi import`, import an Incident Manager replication. For example:
 * 
 * ```sh
 * $ pulumi import aws:ssmincidents/replicationSet:ReplicationSet replicationSetName import
 * ```
 * 
 */
@ResourceType(type="aws:ssmincidents/replicationSet:ReplicationSet")
public class ReplicationSet extends com.pulumi.resources.CustomResource {
    /**
     * The ARN of the replication set.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the replication set.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The ARN of the user who created the replication set.
     * 
     */
    @Export(name="createdBy", refs={String.class}, tree="[0]")
    private Output<String> createdBy;

    /**
     * @return The ARN of the user who created the replication set.
     * 
     */
    public Output<String> createdBy() {
        return this.createdBy;
    }
    /**
     * If `true`, the last region in a replication set cannot be deleted.
     * 
     */
    @Export(name="deletionProtected", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> deletionProtected;

    /**
     * @return If `true`, the last region in a replication set cannot be deleted.
     * 
     */
    public Output<Boolean> deletionProtected() {
        return this.deletionProtected;
    }
    /**
     * A timestamp showing when the replication set was last modified.
     * 
     */
    @Export(name="lastModifiedBy", refs={String.class}, tree="[0]")
    private Output<String> lastModifiedBy;

    /**
     * @return A timestamp showing when the replication set was last modified.
     * 
     */
    public Output<String> lastModifiedBy() {
        return this.lastModifiedBy;
    }
    /**
     * The Regions that Incident Manager replicates your data to. You can have up to three Regions in your replication set.
     * 
     */
    @Export(name="regions", refs={List.class,ReplicationSetRegion.class}, tree="[0,1]")
    private Output<List<ReplicationSetRegion>> regions;

    /**
     * @return The Regions that Incident Manager replicates your data to. You can have up to three Regions in your replication set.
     * 
     */
    public Output<List<ReplicationSetRegion>> regions() {
        return this.regions;
    }
    /**
     * The current status of the Region.
     * * Valid Values: `ACTIVE` | `CREATING` | `UPDATING` | `DELETING` | `FAILED`
     * 
     */
    @Export(name="status", refs={String.class}, tree="[0]")
    private Output<String> status;

    /**
     * @return The current status of the Region.
     * * Valid Values: `ACTIVE` | `CREATING` | `UPDATING` | `DELETING` | `FAILED`
     * 
     */
    public Output<String> status() {
        return this.status;
    }
    /**
     * Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * For information about the maximum allowed number of Regions and tag value constraints, see [CreateReplicationSet in the *AWS Systems Manager Incident Manager API Reference*](https://docs.aws.amazon.com/incident-manager/latest/APIReference/API_CreateReplicationSet.html).
     * 
     * &gt; **NOTE:** The Region specified by a provider must always be one of the Regions specified for the replication set. This is especially important when you perform complex update operations.
     * 
     * &gt; **NOTE:** After a replication set is created, you can add or delete only one Region at a time.
     * 
     * &gt; **NOTE:** Incident Manager does not support updating the customer managed key associated with a replication set. Instead, for a replication set with multiple Regions, you must first delete a Region from the replication set, then re-add it with a different customer managed key in separate deploy operations. For a replication set with only one Region, the entire replication set must be deleted and recreated. To do this, comment out the replication set and all response plans, and then run the deploy command to recreate the replication set with the new customer managed key.
     * 
     * &gt; **NOTE:** You must either use AWS-owned keys on all regions of a replication set, or customer managed keys. To change between an AWS owned key and a customer managed key, a replication set and it associated data must be deleted and recreated.
     * 
     * &gt; **NOTE:** If possible, create all the customer managed keys you need (using the deploy command) before you create the replication set, or create the keys and replication set in the same deploy command. Otherwise, to delete a replication set, you must run one deploy command to delete the replication set and another to delete the AWS KMS keys used by the replication set. Deleting the AWS KMS keys before deleting the replication set results in an error. In that case, you must manually reenable the deleted key using the AWS Management Console before you can delete the replication set.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * For information about the maximum allowed number of Regions and tag value constraints, see [CreateReplicationSet in the *AWS Systems Manager Incident Manager API Reference*](https://docs.aws.amazon.com/incident-manager/latest/APIReference/API_CreateReplicationSet.html).
     * 
     * &gt; **NOTE:** The Region specified by a provider must always be one of the Regions specified for the replication set. This is especially important when you perform complex update operations.
     * 
     * &gt; **NOTE:** After a replication set is created, you can add or delete only one Region at a time.
     * 
     * &gt; **NOTE:** Incident Manager does not support updating the customer managed key associated with a replication set. Instead, for a replication set with multiple Regions, you must first delete a Region from the replication set, then re-add it with a different customer managed key in separate deploy operations. For a replication set with only one Region, the entire replication set must be deleted and recreated. To do this, comment out the replication set and all response plans, and then run the deploy command to recreate the replication set with the new customer managed key.
     * 
     * &gt; **NOTE:** You must either use AWS-owned keys on all regions of a replication set, or customer managed keys. To change between an AWS owned key and a customer managed key, a replication set and it associated data must be deleted and recreated.
     * 
     * &gt; **NOTE:** If possible, create all the customer managed keys you need (using the deploy command) before you create the replication set, or create the keys and replication set in the same deploy command. Otherwise, to delete a replication set, you must run one deploy command to delete the replication set and another to delete the AWS KMS keys used by the replication set. Deleting the AWS KMS keys before deleting the replication set results in an error. In that case, you must manually reenable the deleted key using the AWS Management Console before you can delete the replication set.
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
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public ReplicationSet(java.lang.String name) {
        this(name, ReplicationSetArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public ReplicationSet(java.lang.String name, ReplicationSetArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public ReplicationSet(java.lang.String name, ReplicationSetArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssmincidents/replicationSet:ReplicationSet", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private ReplicationSet(java.lang.String name, Output<java.lang.String> id, @Nullable ReplicationSetState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ssmincidents/replicationSet:ReplicationSet", name, state, makeResourceOptions(options, id), false);
    }

    private static ReplicationSetArgs makeArgs(ReplicationSetArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ReplicationSetArgs.Empty : args;
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
    public static ReplicationSet get(java.lang.String name, Output<java.lang.String> id, @Nullable ReplicationSetState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new ReplicationSet(name, id, state, options);
    }
}
