// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class EventPermissionCondition {
    /**
     * @return Key for the condition. Valid values: `aws:PrincipalOrgID`.
     * 
     */
    private String key;
    /**
     * @return Type of condition. Value values: `StringEquals`.
     * 
     */
    private String type;
    /**
     * @return Value for the key.
     * 
     */
    private String value;

    private EventPermissionCondition() {}
    /**
     * @return Key for the condition. Valid values: `aws:PrincipalOrgID`.
     * 
     */
    public String key() {
        return this.key;
    }
    /**
     * @return Type of condition. Value values: `StringEquals`.
     * 
     */
    public String type() {
        return this.type;
    }
    /**
     * @return Value for the key.
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(EventPermissionCondition defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String key;
        private String type;
        private String value;
        public Builder() {}
        public Builder(EventPermissionCondition defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.key = defaults.key;
    	      this.type = defaults.type;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder key(String key) {
            if (key == null) {
              throw new MissingRequiredPropertyException("EventPermissionCondition", "key");
            }
            this.key = key;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("EventPermissionCondition", "type");
            }
            this.type = type;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("EventPermissionCondition", "value");
            }
            this.value = value;
            return this;
        }
        public EventPermissionCondition build() {
            final var _resultValue = new EventPermissionCondition();
            _resultValue.key = key;
            _resultValue.type = type;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
