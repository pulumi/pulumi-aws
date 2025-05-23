// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.aws.bedrock.inputs.AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationLevelConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.List;
import java.util.Objects;


public final class AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs Empty = new AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs();

    /**
     * Maximum number of tokens to include in a chunk. Must contain two `level_configurations`. See `level_configurations` for details.
     * 
     */
    @Import(name="levelConfigurations", required=true)
    private Output<List<AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationLevelConfigurationArgs>> levelConfigurations;

    /**
     * @return Maximum number of tokens to include in a chunk. Must contain two `level_configurations`. See `level_configurations` for details.
     * 
     */
    public Output<List<AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationLevelConfigurationArgs>> levelConfigurations() {
        return this.levelConfigurations;
    }

    /**
     * The number of tokens to repeat across chunks in the same layer.
     * 
     */
    @Import(name="overlapTokens", required=true)
    private Output<Integer> overlapTokens;

    /**
     * @return The number of tokens to repeat across chunks in the same layer.
     * 
     */
    public Output<Integer> overlapTokens() {
        return this.overlapTokens;
    }

    private AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs() {}

    private AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs(AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs $) {
        this.levelConfigurations = $.levelConfigurations;
        this.overlapTokens = $.overlapTokens;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs $;

        public Builder() {
            $ = new AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs();
        }

        public Builder(AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs defaults) {
            $ = new AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param levelConfigurations Maximum number of tokens to include in a chunk. Must contain two `level_configurations`. See `level_configurations` for details.
         * 
         * @return builder
         * 
         */
        public Builder levelConfigurations(Output<List<AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationLevelConfigurationArgs>> levelConfigurations) {
            $.levelConfigurations = levelConfigurations;
            return this;
        }

        /**
         * @param levelConfigurations Maximum number of tokens to include in a chunk. Must contain two `level_configurations`. See `level_configurations` for details.
         * 
         * @return builder
         * 
         */
        public Builder levelConfigurations(List<AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationLevelConfigurationArgs> levelConfigurations) {
            return levelConfigurations(Output.of(levelConfigurations));
        }

        /**
         * @param levelConfigurations Maximum number of tokens to include in a chunk. Must contain two `level_configurations`. See `level_configurations` for details.
         * 
         * @return builder
         * 
         */
        public Builder levelConfigurations(AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationLevelConfigurationArgs... levelConfigurations) {
            return levelConfigurations(List.of(levelConfigurations));
        }

        /**
         * @param overlapTokens The number of tokens to repeat across chunks in the same layer.
         * 
         * @return builder
         * 
         */
        public Builder overlapTokens(Output<Integer> overlapTokens) {
            $.overlapTokens = overlapTokens;
            return this;
        }

        /**
         * @param overlapTokens The number of tokens to repeat across chunks in the same layer.
         * 
         * @return builder
         * 
         */
        public Builder overlapTokens(Integer overlapTokens) {
            return overlapTokens(Output.of(overlapTokens));
        }

        public AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs build() {
            if ($.levelConfigurations == null) {
                throw new MissingRequiredPropertyException("AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs", "levelConfigurations");
            }
            if ($.overlapTokens == null) {
                throw new MissingRequiredPropertyException("AgentDataSourceVectorIngestionConfigurationChunkingConfigurationHierarchicalChunkingConfigurationArgs", "overlapTokens");
            }
            return $;
        }
    }

}
