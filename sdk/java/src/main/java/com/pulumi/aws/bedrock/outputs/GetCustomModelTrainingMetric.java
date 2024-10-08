// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Double;
import java.util.Objects;

@CustomType
public final class GetCustomModelTrainingMetric {
    /**
     * @return Loss metric associated with the customization job.
     * 
     */
    private Double trainingLoss;

    private GetCustomModelTrainingMetric() {}
    /**
     * @return Loss metric associated with the customization job.
     * 
     */
    public Double trainingLoss() {
        return this.trainingLoss;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetCustomModelTrainingMetric defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Double trainingLoss;
        public Builder() {}
        public Builder(GetCustomModelTrainingMetric defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.trainingLoss = defaults.trainingLoss;
        }

        @CustomType.Setter
        public Builder trainingLoss(Double trainingLoss) {
            if (trainingLoss == null) {
              throw new MissingRequiredPropertyException("GetCustomModelTrainingMetric", "trainingLoss");
            }
            this.trainingLoss = trainingLoss;
            return this;
        }
        public GetCustomModelTrainingMetric build() {
            final var _resultValue = new GetCustomModelTrainingMetric();
            _resultValue.trainingLoss = trainingLoss;
            return _resultValue;
        }
    }
}
