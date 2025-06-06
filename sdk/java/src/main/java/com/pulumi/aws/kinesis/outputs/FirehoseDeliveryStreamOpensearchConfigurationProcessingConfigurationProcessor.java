// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kinesis.outputs;

import com.pulumi.aws.kinesis.outputs.FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessorParameter;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessor {
    /**
     * @return Specifies the processor parameters as multiple blocks. See `parameters` block below for details.
     * 
     */
    private @Nullable List<FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessorParameter> parameters;
    /**
     * @return The type of processor. Valid Values: `RecordDeAggregation`, `Lambda`, `MetadataExtraction`, `AppendDelimiterToRecord`, `Decompression`, `CloudWatchLogProcessing`. Validation is done against [AWS SDK constants](https://pkg.go.dev/github.com/aws/aws-sdk-go-v2/service/firehose/types#ProcessorType); so values not explicitly listed may also work.
     * 
     */
    private String type;

    private FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessor() {}
    /**
     * @return Specifies the processor parameters as multiple blocks. See `parameters` block below for details.
     * 
     */
    public List<FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessorParameter> parameters() {
        return this.parameters == null ? List.of() : this.parameters;
    }
    /**
     * @return The type of processor. Valid Values: `RecordDeAggregation`, `Lambda`, `MetadataExtraction`, `AppendDelimiterToRecord`, `Decompression`, `CloudWatchLogProcessing`. Validation is done against [AWS SDK constants](https://pkg.go.dev/github.com/aws/aws-sdk-go-v2/service/firehose/types#ProcessorType); so values not explicitly listed may also work.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessor defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessorParameter> parameters;
        private String type;
        public Builder() {}
        public Builder(FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessor defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.parameters = defaults.parameters;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder parameters(@Nullable List<FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessorParameter> parameters) {

            this.parameters = parameters;
            return this;
        }
        public Builder parameters(FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessorParameter... parameters) {
            return parameters(List.of(parameters));
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessor", "type");
            }
            this.type = type;
            return this;
        }
        public FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessor build() {
            final var _resultValue = new FirehoseDeliveryStreamOpensearchConfigurationProcessingConfigurationProcessor();
            _resultValue.parameters = parameters;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
