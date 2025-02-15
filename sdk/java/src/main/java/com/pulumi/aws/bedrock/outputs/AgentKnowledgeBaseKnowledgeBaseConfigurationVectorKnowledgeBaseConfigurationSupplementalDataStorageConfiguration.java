// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationStorageLocation;
import com.pulumi.core.annotations.CustomType;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfiguration {
    /**
     * @return A storage location specification for images extracted from multimodal documents in your data source.  See `storage_location` block for details.
     * 
     */
    private @Nullable List<AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationStorageLocation> storageLocations;

    private AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfiguration() {}
    /**
     * @return A storage location specification for images extracted from multimodal documents in your data source.  See `storage_location` block for details.
     * 
     */
    public List<AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationStorageLocation> storageLocations() {
        return this.storageLocations == null ? List.of() : this.storageLocations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationStorageLocation> storageLocations;
        public Builder() {}
        public Builder(AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.storageLocations = defaults.storageLocations;
        }

        @CustomType.Setter
        public Builder storageLocations(@Nullable List<AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationStorageLocation> storageLocations) {

            this.storageLocations = storageLocations;
            return this;
        }
        public Builder storageLocations(AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfigurationStorageLocation... storageLocations) {
            return storageLocations(List.of(storageLocations));
        }
        public AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfiguration build() {
            final var _resultValue = new AgentKnowledgeBaseKnowledgeBaseConfigurationVectorKnowledgeBaseConfigurationSupplementalDataStorageConfiguration();
            _resultValue.storageLocations = storageLocations;
            return _resultValue;
        }
    }
}
