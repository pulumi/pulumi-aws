// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs Empty = new AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs();

    /**
     * Dimension details for the vector configuration used on the Bedrock embeddings model.
     * 
     */
    @Import(name="dimensions")
    private @Nullable Output<Integer> dimensions;

    /**
     * @return Dimension details for the vector configuration used on the Bedrock embeddings model.
     * 
     */
    public Optional<Output<Integer>> dimensions() {
        return Optional.ofNullable(this.dimensions);
    }

    /**
     * Data type for the vectors when using a model to convert text into vector embeddings. The model must support the specified data type for vector embeddings.  Valid values are `FLOAT32` and `BINARY`.
     * 
     */
    @Import(name="embeddingDataType")
    private @Nullable Output<String> embeddingDataType;

    /**
     * @return Data type for the vectors when using a model to convert text into vector embeddings. The model must support the specified data type for vector embeddings.  Valid values are `FLOAT32` and `BINARY`.
     * 
     */
    public Optional<Output<String>> embeddingDataType() {
        return Optional.ofNullable(this.embeddingDataType);
    }

    private AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs() {}

    private AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs(AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs $) {
        this.dimensions = $.dimensions;
        this.embeddingDataType = $.embeddingDataType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs $;

        public Builder() {
            $ = new AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs();
        }

        public Builder(AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs defaults) {
            $ = new AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param dimensions Dimension details for the vector configuration used on the Bedrock embeddings model.
         * 
         * @return builder
         * 
         */
        public Builder dimensions(@Nullable Output<Integer> dimensions) {
            $.dimensions = dimensions;
            return this;
        }

        /**
         * @param dimensions Dimension details for the vector configuration used on the Bedrock embeddings model.
         * 
         * @return builder
         * 
         */
        public Builder dimensions(Integer dimensions) {
            return dimensions(Output.of(dimensions));
        }

        /**
         * @param embeddingDataType Data type for the vectors when using a model to convert text into vector embeddings. The model must support the specified data type for vector embeddings.  Valid values are `FLOAT32` and `BINARY`.
         * 
         * @return builder
         * 
         */
        public Builder embeddingDataType(@Nullable Output<String> embeddingDataType) {
            $.embeddingDataType = embeddingDataType;
            return this;
        }

        /**
         * @param embeddingDataType Data type for the vectors when using a model to convert text into vector embeddings. The model must support the specified data type for vector embeddings.  Valid values are `FLOAT32` and `BINARY`.
         * 
         * @return builder
         * 
         */
        public Builder embeddingDataType(String embeddingDataType) {
            return embeddingDataType(Output.of(embeddingDataType));
        }

        public AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationEmbeddingModelConfigurationBedrockEmbeddingModelConfigurationArgs build() {
            return $;
        }
    }

}
