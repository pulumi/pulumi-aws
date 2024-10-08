// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.mq.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.util.Objects;

@CustomType
public final class GetBrokerLogs {
    private Boolean audit;
    private Boolean general;

    private GetBrokerLogs() {}
    public Boolean audit() {
        return this.audit;
    }
    public Boolean general() {
        return this.general;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetBrokerLogs defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean audit;
        private Boolean general;
        public Builder() {}
        public Builder(GetBrokerLogs defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.audit = defaults.audit;
    	      this.general = defaults.general;
        }

        @CustomType.Setter
        public Builder audit(Boolean audit) {
            if (audit == null) {
              throw new MissingRequiredPropertyException("GetBrokerLogs", "audit");
            }
            this.audit = audit;
            return this;
        }
        @CustomType.Setter
        public Builder general(Boolean general) {
            if (general == null) {
              throw new MissingRequiredPropertyException("GetBrokerLogs", "general");
            }
            this.general = general;
            return this;
        }
        public GetBrokerLogs build() {
            final var _resultValue = new GetBrokerLogs();
            _resultValue.audit = audit;
            _resultValue.general = general;
            return _resultValue;
        }
    }
}
