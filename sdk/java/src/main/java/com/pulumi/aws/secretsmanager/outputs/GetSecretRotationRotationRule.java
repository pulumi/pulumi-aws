// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.secretsmanager.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetSecretRotationRotationRule {
    private Integer automaticallyAfterDays;
    private String duration;
    private String scheduleExpression;

    private GetSecretRotationRotationRule() {}
    public Integer automaticallyAfterDays() {
        return this.automaticallyAfterDays;
    }
    public String duration() {
        return this.duration;
    }
    public String scheduleExpression() {
        return this.scheduleExpression;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetSecretRotationRotationRule defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer automaticallyAfterDays;
        private String duration;
        private String scheduleExpression;
        public Builder() {}
        public Builder(GetSecretRotationRotationRule defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.automaticallyAfterDays = defaults.automaticallyAfterDays;
    	      this.duration = defaults.duration;
    	      this.scheduleExpression = defaults.scheduleExpression;
        }

        @CustomType.Setter
        public Builder automaticallyAfterDays(Integer automaticallyAfterDays) {
            if (automaticallyAfterDays == null) {
              throw new MissingRequiredPropertyException("GetSecretRotationRotationRule", "automaticallyAfterDays");
            }
            this.automaticallyAfterDays = automaticallyAfterDays;
            return this;
        }
        @CustomType.Setter
        public Builder duration(String duration) {
            if (duration == null) {
              throw new MissingRequiredPropertyException("GetSecretRotationRotationRule", "duration");
            }
            this.duration = duration;
            return this;
        }
        @CustomType.Setter
        public Builder scheduleExpression(String scheduleExpression) {
            if (scheduleExpression == null) {
              throw new MissingRequiredPropertyException("GetSecretRotationRotationRule", "scheduleExpression");
            }
            this.scheduleExpression = scheduleExpression;
            return this;
        }
        public GetSecretRotationRotationRule build() {
            final var _resultValue = new GetSecretRotationRotationRule();
            _resultValue.automaticallyAfterDays = automaticallyAfterDays;
            _resultValue.duration = duration;
            _resultValue.scheduleExpression = scheduleExpression;
            return _resultValue;
        }
    }
}
