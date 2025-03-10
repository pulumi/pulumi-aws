// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.dynamodb.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.util.Objects;

@CustomType
public final class TablePointInTimeRecovery {
    /**
     * @return Whether to enable point-in-time recovery. It can take 10 minutes to enable for new tables. If the `point_in_time_recovery` block is not provided, this defaults to `false`.
     * 
     */
    private Boolean enabled;

    private TablePointInTimeRecovery() {}
    /**
     * @return Whether to enable point-in-time recovery. It can take 10 minutes to enable for new tables. If the `point_in_time_recovery` block is not provided, this defaults to `false`.
     * 
     */
    public Boolean enabled() {
        return this.enabled;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TablePointInTimeRecovery defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean enabled;
        public Builder() {}
        public Builder(TablePointInTimeRecovery defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
        }

        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("TablePointInTimeRecovery", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        public TablePointInTimeRecovery build() {
            final var _resultValue = new TablePointInTimeRecovery();
            _resultValue.enabled = enabled;
            return _resultValue;
        }
    }
}
