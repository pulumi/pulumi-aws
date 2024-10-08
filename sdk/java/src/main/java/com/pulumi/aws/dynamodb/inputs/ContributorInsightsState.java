// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dynamodb.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ContributorInsightsState extends com.pulumi.resources.ResourceArgs {

    public static final ContributorInsightsState Empty = new ContributorInsightsState();

    /**
     * The global secondary index name
     * 
     */
    @Import(name="indexName")
    private @Nullable Output<String> indexName;

    /**
     * @return The global secondary index name
     * 
     */
    public Optional<Output<String>> indexName() {
        return Optional.ofNullable(this.indexName);
    }

    /**
     * The name of the table to enable contributor insights
     * 
     */
    @Import(name="tableName")
    private @Nullable Output<String> tableName;

    /**
     * @return The name of the table to enable contributor insights
     * 
     */
    public Optional<Output<String>> tableName() {
        return Optional.ofNullable(this.tableName);
    }

    private ContributorInsightsState() {}

    private ContributorInsightsState(ContributorInsightsState $) {
        this.indexName = $.indexName;
        this.tableName = $.tableName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ContributorInsightsState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ContributorInsightsState $;

        public Builder() {
            $ = new ContributorInsightsState();
        }

        public Builder(ContributorInsightsState defaults) {
            $ = new ContributorInsightsState(Objects.requireNonNull(defaults));
        }

        /**
         * @param indexName The global secondary index name
         * 
         * @return builder
         * 
         */
        public Builder indexName(@Nullable Output<String> indexName) {
            $.indexName = indexName;
            return this;
        }

        /**
         * @param indexName The global secondary index name
         * 
         * @return builder
         * 
         */
        public Builder indexName(String indexName) {
            return indexName(Output.of(indexName));
        }

        /**
         * @param tableName The name of the table to enable contributor insights
         * 
         * @return builder
         * 
         */
        public Builder tableName(@Nullable Output<String> tableName) {
            $.tableName = tableName;
            return this;
        }

        /**
         * @param tableName The name of the table to enable contributor insights
         * 
         * @return builder
         * 
         */
        public Builder tableName(String tableName) {
            return tableName(Output.of(tableName));
        }

        public ContributorInsightsState build() {
            return $;
        }
    }

}
