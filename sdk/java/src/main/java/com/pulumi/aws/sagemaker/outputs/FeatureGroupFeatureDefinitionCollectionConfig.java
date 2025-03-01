// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.outputs;

import com.pulumi.aws.sagemaker.outputs.FeatureGroupFeatureDefinitionCollectionConfigVectorConfig;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class FeatureGroupFeatureDefinitionCollectionConfig {
    private @Nullable FeatureGroupFeatureDefinitionCollectionConfigVectorConfig vectorConfig;

    private FeatureGroupFeatureDefinitionCollectionConfig() {}
    public Optional<FeatureGroupFeatureDefinitionCollectionConfigVectorConfig> vectorConfig() {
        return Optional.ofNullable(this.vectorConfig);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(FeatureGroupFeatureDefinitionCollectionConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable FeatureGroupFeatureDefinitionCollectionConfigVectorConfig vectorConfig;
        public Builder() {}
        public Builder(FeatureGroupFeatureDefinitionCollectionConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.vectorConfig = defaults.vectorConfig;
        }

        @CustomType.Setter
        public Builder vectorConfig(@Nullable FeatureGroupFeatureDefinitionCollectionConfigVectorConfig vectorConfig) {

            this.vectorConfig = vectorConfig;
            return this;
        }
        public FeatureGroupFeatureDefinitionCollectionConfig build() {
            final var _resultValue = new FeatureGroupFeatureDefinitionCollectionConfig();
            _resultValue.vectorConfig = vectorConfig;
            return _resultValue;
        }
    }
}
