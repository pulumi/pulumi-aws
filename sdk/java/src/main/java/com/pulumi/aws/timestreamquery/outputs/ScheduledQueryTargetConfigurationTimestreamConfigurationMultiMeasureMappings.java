// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.timestreamquery.outputs;

import com.pulumi.aws.timestreamquery.outputs.ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappingsMultiMeasureAttributeMapping;
import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings {
    /**
     * @return Attribute mappings to be used for mapping query results to ingest data for multi-measure attributes. See above.
     * 
     */
    private @Nullable List<ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappingsMultiMeasureAttributeMapping> multiMeasureAttributeMappings;
    /**
     * @return Name of the target multi-measure name in the derived table. This input is required when `measure_name_column` is not provided. If `measure_name_column` is provided, then the value from that column will be used as the multi-measure name.
     * 
     */
    private @Nullable String targetMultiMeasureName;

    private ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings() {}
    /**
     * @return Attribute mappings to be used for mapping query results to ingest data for multi-measure attributes. See above.
     * 
     */
    public List<ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappingsMultiMeasureAttributeMapping> multiMeasureAttributeMappings() {
        return this.multiMeasureAttributeMappings == null ? List.of() : this.multiMeasureAttributeMappings;
    }
    /**
     * @return Name of the target multi-measure name in the derived table. This input is required when `measure_name_column` is not provided. If `measure_name_column` is provided, then the value from that column will be used as the multi-measure name.
     * 
     */
    public Optional<String> targetMultiMeasureName() {
        return Optional.ofNullable(this.targetMultiMeasureName);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappingsMultiMeasureAttributeMapping> multiMeasureAttributeMappings;
        private @Nullable String targetMultiMeasureName;
        public Builder() {}
        public Builder(ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.multiMeasureAttributeMappings = defaults.multiMeasureAttributeMappings;
    	      this.targetMultiMeasureName = defaults.targetMultiMeasureName;
        }

        @CustomType.Setter
        public Builder multiMeasureAttributeMappings(@Nullable List<ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappingsMultiMeasureAttributeMapping> multiMeasureAttributeMappings) {

            this.multiMeasureAttributeMappings = multiMeasureAttributeMappings;
            return this;
        }
        public Builder multiMeasureAttributeMappings(ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappingsMultiMeasureAttributeMapping... multiMeasureAttributeMappings) {
            return multiMeasureAttributeMappings(List.of(multiMeasureAttributeMappings));
        }
        @CustomType.Setter
        public Builder targetMultiMeasureName(@Nullable String targetMultiMeasureName) {

            this.targetMultiMeasureName = targetMultiMeasureName;
            return this;
        }
        public ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings build() {
            final var _resultValue = new ScheduledQueryTargetConfigurationTimestreamConfigurationMultiMeasureMappings();
            _resultValue.multiMeasureAttributeMappings = multiMeasureAttributeMappings;
            _resultValue.targetMultiMeasureName = targetMultiMeasureName;
            return _resultValue;
        }
    }
}
