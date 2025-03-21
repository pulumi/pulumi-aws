// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafregional.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class RulePredicate {
    private String dataId;
    private Boolean negated;
    private String type;

    private RulePredicate() {}
    public String dataId() {
        return this.dataId;
    }
    public Boolean negated() {
        return this.negated;
    }
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(RulePredicate defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String dataId;
        private Boolean negated;
        private String type;
        public Builder() {}
        public Builder(RulePredicate defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.dataId = defaults.dataId;
    	      this.negated = defaults.negated;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder dataId(String dataId) {
            if (dataId == null) {
              throw new MissingRequiredPropertyException("RulePredicate", "dataId");
            }
            this.dataId = dataId;
            return this;
        }
        @CustomType.Setter
        public Builder negated(Boolean negated) {
            if (negated == null) {
              throw new MissingRequiredPropertyException("RulePredicate", "negated");
            }
            this.negated = negated;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("RulePredicate", "type");
            }
            this.type = type;
            return this;
        }
        public RulePredicate build() {
            final var _resultValue = new RulePredicate();
            _resultValue.dataId = dataId;
            _resultValue.negated = negated;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
