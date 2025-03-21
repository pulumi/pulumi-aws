// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appsync.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DataSourceDynamodbConfigDeltaSyncConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final DataSourceDynamodbConfigDeltaSyncConfigArgs Empty = new DataSourceDynamodbConfigDeltaSyncConfigArgs();

    /**
     * The number of minutes that an Item is stored in the data source.
     * 
     */
    @Import(name="baseTableTtl")
    private @Nullable Output<Integer> baseTableTtl;

    /**
     * @return The number of minutes that an Item is stored in the data source.
     * 
     */
    public Optional<Output<Integer>> baseTableTtl() {
        return Optional.ofNullable(this.baseTableTtl);
    }

    /**
     * The table name.
     * 
     */
    @Import(name="deltaSyncTableName", required=true)
    private Output<String> deltaSyncTableName;

    /**
     * @return The table name.
     * 
     */
    public Output<String> deltaSyncTableName() {
        return this.deltaSyncTableName;
    }

    /**
     * The number of minutes that a Delta Sync log entry is stored in the Delta Sync table.
     * 
     */
    @Import(name="deltaSyncTableTtl")
    private @Nullable Output<Integer> deltaSyncTableTtl;

    /**
     * @return The number of minutes that a Delta Sync log entry is stored in the Delta Sync table.
     * 
     */
    public Optional<Output<Integer>> deltaSyncTableTtl() {
        return Optional.ofNullable(this.deltaSyncTableTtl);
    }

    private DataSourceDynamodbConfigDeltaSyncConfigArgs() {}

    private DataSourceDynamodbConfigDeltaSyncConfigArgs(DataSourceDynamodbConfigDeltaSyncConfigArgs $) {
        this.baseTableTtl = $.baseTableTtl;
        this.deltaSyncTableName = $.deltaSyncTableName;
        this.deltaSyncTableTtl = $.deltaSyncTableTtl;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataSourceDynamodbConfigDeltaSyncConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataSourceDynamodbConfigDeltaSyncConfigArgs $;

        public Builder() {
            $ = new DataSourceDynamodbConfigDeltaSyncConfigArgs();
        }

        public Builder(DataSourceDynamodbConfigDeltaSyncConfigArgs defaults) {
            $ = new DataSourceDynamodbConfigDeltaSyncConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param baseTableTtl The number of minutes that an Item is stored in the data source.
         * 
         * @return builder
         * 
         */
        public Builder baseTableTtl(@Nullable Output<Integer> baseTableTtl) {
            $.baseTableTtl = baseTableTtl;
            return this;
        }

        /**
         * @param baseTableTtl The number of minutes that an Item is stored in the data source.
         * 
         * @return builder
         * 
         */
        public Builder baseTableTtl(Integer baseTableTtl) {
            return baseTableTtl(Output.of(baseTableTtl));
        }

        /**
         * @param deltaSyncTableName The table name.
         * 
         * @return builder
         * 
         */
        public Builder deltaSyncTableName(Output<String> deltaSyncTableName) {
            $.deltaSyncTableName = deltaSyncTableName;
            return this;
        }

        /**
         * @param deltaSyncTableName The table name.
         * 
         * @return builder
         * 
         */
        public Builder deltaSyncTableName(String deltaSyncTableName) {
            return deltaSyncTableName(Output.of(deltaSyncTableName));
        }

        /**
         * @param deltaSyncTableTtl The number of minutes that a Delta Sync log entry is stored in the Delta Sync table.
         * 
         * @return builder
         * 
         */
        public Builder deltaSyncTableTtl(@Nullable Output<Integer> deltaSyncTableTtl) {
            $.deltaSyncTableTtl = deltaSyncTableTtl;
            return this;
        }

        /**
         * @param deltaSyncTableTtl The number of minutes that a Delta Sync log entry is stored in the Delta Sync table.
         * 
         * @return builder
         * 
         */
        public Builder deltaSyncTableTtl(Integer deltaSyncTableTtl) {
            return deltaSyncTableTtl(Output.of(deltaSyncTableTtl));
        }

        public DataSourceDynamodbConfigDeltaSyncConfigArgs build() {
            if ($.deltaSyncTableName == null) {
                throw new MissingRequiredPropertyException("DataSourceDynamodbConfigDeltaSyncConfigArgs", "deltaSyncTableName");
            }
            return $;
        }
    }

}
