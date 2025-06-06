// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.rds.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClusterEndpointState extends com.pulumi.resources.ResourceArgs {

    public static final ClusterEndpointState Empty = new ClusterEndpointState();

    /**
     * Amazon Resource Name (ARN) of cluster
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of cluster
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The identifier to use for the new endpoint. This parameter is stored as a lowercase string.
     * 
     */
    @Import(name="clusterEndpointIdentifier")
    private @Nullable Output<String> clusterEndpointIdentifier;

    /**
     * @return The identifier to use for the new endpoint. This parameter is stored as a lowercase string.
     * 
     */
    public Optional<Output<String>> clusterEndpointIdentifier() {
        return Optional.ofNullable(this.clusterEndpointIdentifier);
    }

    /**
     * The cluster identifier.
     * 
     */
    @Import(name="clusterIdentifier")
    private @Nullable Output<String> clusterIdentifier;

    /**
     * @return The cluster identifier.
     * 
     */
    public Optional<Output<String>> clusterIdentifier() {
        return Optional.ofNullable(this.clusterIdentifier);
    }

    /**
     * The type of the endpoint. One of: READER , ANY .
     * 
     */
    @Import(name="customEndpointType")
    private @Nullable Output<String> customEndpointType;

    /**
     * @return The type of the endpoint. One of: READER , ANY .
     * 
     */
    public Optional<Output<String>> customEndpointType() {
        return Optional.ofNullable(this.customEndpointType);
    }

    /**
     * A custom endpoint for the Aurora cluster
     * 
     */
    @Import(name="endpoint")
    private @Nullable Output<String> endpoint;

    /**
     * @return A custom endpoint for the Aurora cluster
     * 
     */
    public Optional<Output<String>> endpoint() {
        return Optional.ofNullable(this.endpoint);
    }

    /**
     * List of DB instance identifiers that aren&#39;t part of the custom endpoint group. All other eligible instances are reachable through the custom endpoint. Only relevant if the list of static members is empty. Conflicts with `static_members`.
     * 
     */
    @Import(name="excludedMembers")
    private @Nullable Output<List<String>> excludedMembers;

    /**
     * @return List of DB instance identifiers that aren&#39;t part of the custom endpoint group. All other eligible instances are reachable through the custom endpoint. Only relevant if the list of static members is empty. Conflicts with `static_members`.
     * 
     */
    public Optional<Output<List<String>>> excludedMembers() {
        return Optional.ofNullable(this.excludedMembers);
    }

    /**
     * List of DB instance identifiers that are part of the custom endpoint group. Conflicts with `excluded_members`.
     * 
     */
    @Import(name="staticMembers")
    private @Nullable Output<List<String>> staticMembers;

    /**
     * @return List of DB instance identifiers that are part of the custom endpoint group. Conflicts with `excluded_members`.
     * 
     */
    public Optional<Output<List<String>>> staticMembers() {
        return Optional.ofNullable(this.staticMembers);
    }

    /**
     * Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * For more detailed documentation about each argument, refer to
     * the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/rds/create-db-cluster-endpoint.html).
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * For more detailed documentation about each argument, refer to
     * the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/rds/create-db-cluster-endpoint.html).
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    private ClusterEndpointState() {}

    private ClusterEndpointState(ClusterEndpointState $) {
        this.arn = $.arn;
        this.clusterEndpointIdentifier = $.clusterEndpointIdentifier;
        this.clusterIdentifier = $.clusterIdentifier;
        this.customEndpointType = $.customEndpointType;
        this.endpoint = $.endpoint;
        this.excludedMembers = $.excludedMembers;
        this.staticMembers = $.staticMembers;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClusterEndpointState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClusterEndpointState $;

        public Builder() {
            $ = new ClusterEndpointState();
        }

        public Builder(ClusterEndpointState defaults) {
            $ = new ClusterEndpointState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn Amazon Resource Name (ARN) of cluster
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn Amazon Resource Name (ARN) of cluster
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param clusterEndpointIdentifier The identifier to use for the new endpoint. This parameter is stored as a lowercase string.
         * 
         * @return builder
         * 
         */
        public Builder clusterEndpointIdentifier(@Nullable Output<String> clusterEndpointIdentifier) {
            $.clusterEndpointIdentifier = clusterEndpointIdentifier;
            return this;
        }

        /**
         * @param clusterEndpointIdentifier The identifier to use for the new endpoint. This parameter is stored as a lowercase string.
         * 
         * @return builder
         * 
         */
        public Builder clusterEndpointIdentifier(String clusterEndpointIdentifier) {
            return clusterEndpointIdentifier(Output.of(clusterEndpointIdentifier));
        }

        /**
         * @param clusterIdentifier The cluster identifier.
         * 
         * @return builder
         * 
         */
        public Builder clusterIdentifier(@Nullable Output<String> clusterIdentifier) {
            $.clusterIdentifier = clusterIdentifier;
            return this;
        }

        /**
         * @param clusterIdentifier The cluster identifier.
         * 
         * @return builder
         * 
         */
        public Builder clusterIdentifier(String clusterIdentifier) {
            return clusterIdentifier(Output.of(clusterIdentifier));
        }

        /**
         * @param customEndpointType The type of the endpoint. One of: READER , ANY .
         * 
         * @return builder
         * 
         */
        public Builder customEndpointType(@Nullable Output<String> customEndpointType) {
            $.customEndpointType = customEndpointType;
            return this;
        }

        /**
         * @param customEndpointType The type of the endpoint. One of: READER , ANY .
         * 
         * @return builder
         * 
         */
        public Builder customEndpointType(String customEndpointType) {
            return customEndpointType(Output.of(customEndpointType));
        }

        /**
         * @param endpoint A custom endpoint for the Aurora cluster
         * 
         * @return builder
         * 
         */
        public Builder endpoint(@Nullable Output<String> endpoint) {
            $.endpoint = endpoint;
            return this;
        }

        /**
         * @param endpoint A custom endpoint for the Aurora cluster
         * 
         * @return builder
         * 
         */
        public Builder endpoint(String endpoint) {
            return endpoint(Output.of(endpoint));
        }

        /**
         * @param excludedMembers List of DB instance identifiers that aren&#39;t part of the custom endpoint group. All other eligible instances are reachable through the custom endpoint. Only relevant if the list of static members is empty. Conflicts with `static_members`.
         * 
         * @return builder
         * 
         */
        public Builder excludedMembers(@Nullable Output<List<String>> excludedMembers) {
            $.excludedMembers = excludedMembers;
            return this;
        }

        /**
         * @param excludedMembers List of DB instance identifiers that aren&#39;t part of the custom endpoint group. All other eligible instances are reachable through the custom endpoint. Only relevant if the list of static members is empty. Conflicts with `static_members`.
         * 
         * @return builder
         * 
         */
        public Builder excludedMembers(List<String> excludedMembers) {
            return excludedMembers(Output.of(excludedMembers));
        }

        /**
         * @param excludedMembers List of DB instance identifiers that aren&#39;t part of the custom endpoint group. All other eligible instances are reachable through the custom endpoint. Only relevant if the list of static members is empty. Conflicts with `static_members`.
         * 
         * @return builder
         * 
         */
        public Builder excludedMembers(String... excludedMembers) {
            return excludedMembers(List.of(excludedMembers));
        }

        /**
         * @param staticMembers List of DB instance identifiers that are part of the custom endpoint group. Conflicts with `excluded_members`.
         * 
         * @return builder
         * 
         */
        public Builder staticMembers(@Nullable Output<List<String>> staticMembers) {
            $.staticMembers = staticMembers;
            return this;
        }

        /**
         * @param staticMembers List of DB instance identifiers that are part of the custom endpoint group. Conflicts with `excluded_members`.
         * 
         * @return builder
         * 
         */
        public Builder staticMembers(List<String> staticMembers) {
            return staticMembers(Output.of(staticMembers));
        }

        /**
         * @param staticMembers List of DB instance identifiers that are part of the custom endpoint group. Conflicts with `excluded_members`.
         * 
         * @return builder
         * 
         */
        public Builder staticMembers(String... staticMembers) {
            return staticMembers(List.of(staticMembers));
        }

        /**
         * @param tags Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * For more detailed documentation about each argument, refer to
         * the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/rds/create-db-cluster-endpoint.html).
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * For more detailed documentation about each argument, refer to
         * the [AWS official documentation](https://docs.aws.amazon.com/cli/latest/reference/rds/create-db-cluster-endpoint.html).
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public ClusterEndpointState build() {
            return $;
        }
    }

}
