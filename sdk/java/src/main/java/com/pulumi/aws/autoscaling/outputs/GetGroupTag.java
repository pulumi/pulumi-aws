// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.autoscaling.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetGroupTag {
    /**
     * @return Key.
     * 
     */
    private String key;
    /**
     * @return Whether the tag is propagated to Amazon EC2 instances launched via this ASG.
     * 
     */
    private Boolean propagateAtLaunch;
    /**
     * @return Value.
     * 
     */
    private String value;

    private GetGroupTag() {}
    /**
     * @return Key.
     * 
     */
    public String key() {
        return this.key;
    }
    /**
     * @return Whether the tag is propagated to Amazon EC2 instances launched via this ASG.
     * 
     */
    public Boolean propagateAtLaunch() {
        return this.propagateAtLaunch;
    }
    /**
     * @return Value.
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetGroupTag defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String key;
        private Boolean propagateAtLaunch;
        private String value;
        public Builder() {}
        public Builder(GetGroupTag defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.key = defaults.key;
    	      this.propagateAtLaunch = defaults.propagateAtLaunch;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder key(String key) {
            if (key == null) {
              throw new MissingRequiredPropertyException("GetGroupTag", "key");
            }
            this.key = key;
            return this;
        }
        @CustomType.Setter
        public Builder propagateAtLaunch(Boolean propagateAtLaunch) {
            if (propagateAtLaunch == null) {
              throw new MissingRequiredPropertyException("GetGroupTag", "propagateAtLaunch");
            }
            this.propagateAtLaunch = propagateAtLaunch;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("GetGroupTag", "value");
            }
            this.value = value;
            return this;
        }
        public GetGroupTag build() {
            final var _resultValue = new GetGroupTag();
            _resultValue.key = key;
            _resultValue.propagateAtLaunch = propagateAtLaunch;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
