// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.glue.PartitionArgs;
import com.pulumi.aws.glue.inputs.PartitionState;
import com.pulumi.aws.glue.outputs.PartitionStorageDescriptor;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a Glue Partition Resource.
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
 * import com.pulumi.aws.glue.Partition;
 * import com.pulumi.aws.glue.PartitionArgs;
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
 *         var example = new Partition("example", PartitionArgs.builder()
 *             .databaseName("some-database")
 *             .tableName("some-table")
 *             .partitionValues("some-value")
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
 * Using `pulumi import`, import Glue Partitions using the catalog ID (usually AWS account ID), database name, table name and partition values. For example:
 * 
 * ```sh
 * $ pulumi import aws:glue/partition:Partition part 123456789012:MyDatabase:MyTable:val1#val2
 * ```
 * 
 */
@ResourceType(type="aws:glue/partition:Partition")
public class Partition extends com.pulumi.resources.CustomResource {
    /**
     * ID of the Glue Catalog and database to create the table in. If omitted, this defaults to the AWS Account ID plus the database name.
     * 
     */
    @Export(name="catalogId", refs={String.class}, tree="[0]")
    private Output<String> catalogId;

    /**
     * @return ID of the Glue Catalog and database to create the table in. If omitted, this defaults to the AWS Account ID plus the database name.
     * 
     */
    public Output<String> catalogId() {
        return this.catalogId;
    }
    /**
     * The time at which the partition was created.
     * 
     */
    @Export(name="creationTime", refs={String.class}, tree="[0]")
    private Output<String> creationTime;

    /**
     * @return The time at which the partition was created.
     * 
     */
    public Output<String> creationTime() {
        return this.creationTime;
    }
    /**
     * Name of the metadata database where the table metadata resides. For Hive compatibility, this must be all lowercase.
     * 
     */
    @Export(name="databaseName", refs={String.class}, tree="[0]")
    private Output<String> databaseName;

    /**
     * @return Name of the metadata database where the table metadata resides. For Hive compatibility, this must be all lowercase.
     * 
     */
    public Output<String> databaseName() {
        return this.databaseName;
    }
    /**
     * The last time at which the partition was accessed.
     * 
     */
    @Export(name="lastAccessedTime", refs={String.class}, tree="[0]")
    private Output<String> lastAccessedTime;

    /**
     * @return The last time at which the partition was accessed.
     * 
     */
    public Output<String> lastAccessedTime() {
        return this.lastAccessedTime;
    }
    /**
     * The last time at which column statistics were computed for this partition.
     * 
     */
    @Export(name="lastAnalyzedTime", refs={String.class}, tree="[0]")
    private Output<String> lastAnalyzedTime;

    /**
     * @return The last time at which column statistics were computed for this partition.
     * 
     */
    public Output<String> lastAnalyzedTime() {
        return this.lastAnalyzedTime;
    }
    /**
     * Properties associated with this table, as a list of key-value pairs.
     * 
     */
    @Export(name="parameters", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> parameters;

    /**
     * @return Properties associated with this table, as a list of key-value pairs.
     * 
     */
    public Output<Optional<Map<String,String>>> parameters() {
        return Codegen.optional(this.parameters);
    }
    /**
     * The values that define the partition.
     * 
     */
    @Export(name="partitionValues", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> partitionValues;

    /**
     * @return The values that define the partition.
     * 
     */
    public Output<List<String>> partitionValues() {
        return this.partitionValues;
    }
    /**
     * A storage descriptor object containing information about the physical storage of this table. You can refer to the [Glue Developer Guide](https://docs.aws.amazon.com/glue/latest/dg/aws-glue-api-catalog-tables.html#aws-glue-api-catalog-tables-StorageDescriptor) for a full explanation of this object.
     * 
     */
    @Export(name="storageDescriptor", refs={PartitionStorageDescriptor.class}, tree="[0]")
    private Output</* @Nullable */ PartitionStorageDescriptor> storageDescriptor;

    /**
     * @return A storage descriptor object containing information about the physical storage of this table. You can refer to the [Glue Developer Guide](https://docs.aws.amazon.com/glue/latest/dg/aws-glue-api-catalog-tables.html#aws-glue-api-catalog-tables-StorageDescriptor) for a full explanation of this object.
     * 
     */
    public Output<Optional<PartitionStorageDescriptor>> storageDescriptor() {
        return Codegen.optional(this.storageDescriptor);
    }
    @Export(name="tableName", refs={String.class}, tree="[0]")
    private Output<String> tableName;

    public Output<String> tableName() {
        return this.tableName;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Partition(java.lang.String name) {
        this(name, PartitionArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Partition(java.lang.String name, PartitionArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Partition(java.lang.String name, PartitionArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:glue/partition:Partition", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Partition(java.lang.String name, Output<java.lang.String> id, @Nullable PartitionState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:glue/partition:Partition", name, state, makeResourceOptions(options, id), false);
    }

    private static PartitionArgs makeArgs(PartitionArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? PartitionArgs.Empty : args;
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
    public static Partition get(java.lang.String name, Output<java.lang.String> id, @Nullable PartitionState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Partition(name, id, state, options);
    }
}
