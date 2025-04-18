// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigateway.outputs;

import com.pulumi.aws.apigateway.outputs.UsagePlanApiStageThrottle;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class UsagePlanApiStage {
    /**
     * @return API Id of the associated API stage in a usage plan.
     * 
     */
    private String apiId;
    /**
     * @return API stage name of the associated API stage in a usage plan.
     * 
     */
    private String stage;
    /**
     * @return The throttling limits of the usage plan.
     * 
     */
    private @Nullable List<UsagePlanApiStageThrottle> throttles;

    private UsagePlanApiStage() {}
    /**
     * @return API Id of the associated API stage in a usage plan.
     * 
     */
    public String apiId() {
        return this.apiId;
    }
    /**
     * @return API stage name of the associated API stage in a usage plan.
     * 
     */
    public String stage() {
        return this.stage;
    }
    /**
     * @return The throttling limits of the usage plan.
     * 
     */
    public List<UsagePlanApiStageThrottle> throttles() {
        return this.throttles == null ? List.of() : this.throttles;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(UsagePlanApiStage defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String apiId;
        private String stage;
        private @Nullable List<UsagePlanApiStageThrottle> throttles;
        public Builder() {}
        public Builder(UsagePlanApiStage defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.apiId = defaults.apiId;
    	      this.stage = defaults.stage;
    	      this.throttles = defaults.throttles;
        }

        @CustomType.Setter
        public Builder apiId(String apiId) {
            if (apiId == null) {
              throw new MissingRequiredPropertyException("UsagePlanApiStage", "apiId");
            }
            this.apiId = apiId;
            return this;
        }
        @CustomType.Setter
        public Builder stage(String stage) {
            if (stage == null) {
              throw new MissingRequiredPropertyException("UsagePlanApiStage", "stage");
            }
            this.stage = stage;
            return this;
        }
        @CustomType.Setter
        public Builder throttles(@Nullable List<UsagePlanApiStageThrottle> throttles) {

            this.throttles = throttles;
            return this;
        }
        public Builder throttles(UsagePlanApiStageThrottle... throttles) {
            return throttles(List.of(throttles));
        }
        public UsagePlanApiStage build() {
            final var _resultValue = new UsagePlanApiStage();
            _resultValue.apiId = apiId;
            _resultValue.stage = stage;
            _resultValue.throttles = throttles;
            return _resultValue;
        }
    }
}
