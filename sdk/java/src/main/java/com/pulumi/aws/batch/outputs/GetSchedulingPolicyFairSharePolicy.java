// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.aws.batch.outputs.GetSchedulingPolicyFairSharePolicyShareDistribution;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetSchedulingPolicyFairSharePolicy {
    /**
     * @return Value used to reserve some of the available maximum vCPU for fair share identifiers that have not yet been used. For more information, see [FairsharePolicy](https://docs.aws.amazon.com/batch/latest/APIReference/API_FairsharePolicy.html).
     * 
     */
    private Integer computeReservation;
    private Integer shareDecaySeconds;
    /**
     * @return One or more share distribution blocks which define the weights for the fair share identifiers for the fair share policy. For more information, see [FairsharePolicy](https://docs.aws.amazon.com/batch/latest/APIReference/API_FairsharePolicy.html). The `share_distribution` block is documented below.
     * 
     */
    private List<GetSchedulingPolicyFairSharePolicyShareDistribution> shareDistributions;

    private GetSchedulingPolicyFairSharePolicy() {}
    /**
     * @return Value used to reserve some of the available maximum vCPU for fair share identifiers that have not yet been used. For more information, see [FairsharePolicy](https://docs.aws.amazon.com/batch/latest/APIReference/API_FairsharePolicy.html).
     * 
     */
    public Integer computeReservation() {
        return this.computeReservation;
    }
    public Integer shareDecaySeconds() {
        return this.shareDecaySeconds;
    }
    /**
     * @return One or more share distribution blocks which define the weights for the fair share identifiers for the fair share policy. For more information, see [FairsharePolicy](https://docs.aws.amazon.com/batch/latest/APIReference/API_FairsharePolicy.html). The `share_distribution` block is documented below.
     * 
     */
    public List<GetSchedulingPolicyFairSharePolicyShareDistribution> shareDistributions() {
        return this.shareDistributions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetSchedulingPolicyFairSharePolicy defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer computeReservation;
        private Integer shareDecaySeconds;
        private List<GetSchedulingPolicyFairSharePolicyShareDistribution> shareDistributions;
        public Builder() {}
        public Builder(GetSchedulingPolicyFairSharePolicy defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.computeReservation = defaults.computeReservation;
    	      this.shareDecaySeconds = defaults.shareDecaySeconds;
    	      this.shareDistributions = defaults.shareDistributions;
        }

        @CustomType.Setter
        public Builder computeReservation(Integer computeReservation) {
            if (computeReservation == null) {
              throw new MissingRequiredPropertyException("GetSchedulingPolicyFairSharePolicy", "computeReservation");
            }
            this.computeReservation = computeReservation;
            return this;
        }
        @CustomType.Setter
        public Builder shareDecaySeconds(Integer shareDecaySeconds) {
            if (shareDecaySeconds == null) {
              throw new MissingRequiredPropertyException("GetSchedulingPolicyFairSharePolicy", "shareDecaySeconds");
            }
            this.shareDecaySeconds = shareDecaySeconds;
            return this;
        }
        @CustomType.Setter
        public Builder shareDistributions(List<GetSchedulingPolicyFairSharePolicyShareDistribution> shareDistributions) {
            if (shareDistributions == null) {
              throw new MissingRequiredPropertyException("GetSchedulingPolicyFairSharePolicy", "shareDistributions");
            }
            this.shareDistributions = shareDistributions;
            return this;
        }
        public Builder shareDistributions(GetSchedulingPolicyFairSharePolicyShareDistribution... shareDistributions) {
            return shareDistributions(List.of(shareDistributions));
        }
        public GetSchedulingPolicyFairSharePolicy build() {
            final var _resultValue = new GetSchedulingPolicyFairSharePolicy();
            _resultValue.computeReservation = computeReservation;
            _resultValue.shareDecaySeconds = shareDecaySeconds;
            _resultValue.shareDistributions = shareDistributions;
            return _resultValue;
        }
    }
}
