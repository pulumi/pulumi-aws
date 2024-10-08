// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lb.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetLoadBalancerConnectionLog {
    private String bucket;
    private Boolean enabled;
    private String prefix;

    private GetLoadBalancerConnectionLog() {}
    public String bucket() {
        return this.bucket;
    }
    public Boolean enabled() {
        return this.enabled;
    }
    public String prefix() {
        return this.prefix;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetLoadBalancerConnectionLog defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String bucket;
        private Boolean enabled;
        private String prefix;
        public Builder() {}
        public Builder(GetLoadBalancerConnectionLog defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bucket = defaults.bucket;
    	      this.enabled = defaults.enabled;
    	      this.prefix = defaults.prefix;
        }

        @CustomType.Setter
        public Builder bucket(String bucket) {
            if (bucket == null) {
              throw new MissingRequiredPropertyException("GetLoadBalancerConnectionLog", "bucket");
            }
            this.bucket = bucket;
            return this;
        }
        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("GetLoadBalancerConnectionLog", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder prefix(String prefix) {
            if (prefix == null) {
              throw new MissingRequiredPropertyException("GetLoadBalancerConnectionLog", "prefix");
            }
            this.prefix = prefix;
            return this;
        }
        public GetLoadBalancerConnectionLog build() {
            final var _resultValue = new GetLoadBalancerConnectionLog();
            _resultValue.bucket = bucket;
            _resultValue.enabled = enabled;
            _resultValue.prefix = prefix;
            return _resultValue;
        }
    }
}
