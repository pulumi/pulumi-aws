// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lb.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetTargetGroupHealthCheck {
    private Boolean enabled;
    private Integer healthyThreshold;
    private Integer interval;
    private String matcher;
    private String path;
    private String port;
    private String protocol;
    private Integer timeout;
    private Integer unhealthyThreshold;

    private GetTargetGroupHealthCheck() {}
    public Boolean enabled() {
        return this.enabled;
    }
    public Integer healthyThreshold() {
        return this.healthyThreshold;
    }
    public Integer interval() {
        return this.interval;
    }
    public String matcher() {
        return this.matcher;
    }
    public String path() {
        return this.path;
    }
    public String port() {
        return this.port;
    }
    public String protocol() {
        return this.protocol;
    }
    public Integer timeout() {
        return this.timeout;
    }
    public Integer unhealthyThreshold() {
        return this.unhealthyThreshold;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetTargetGroupHealthCheck defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean enabled;
        private Integer healthyThreshold;
        private Integer interval;
        private String matcher;
        private String path;
        private String port;
        private String protocol;
        private Integer timeout;
        private Integer unhealthyThreshold;
        public Builder() {}
        public Builder(GetTargetGroupHealthCheck defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
    	      this.healthyThreshold = defaults.healthyThreshold;
    	      this.interval = defaults.interval;
    	      this.matcher = defaults.matcher;
    	      this.path = defaults.path;
    	      this.port = defaults.port;
    	      this.protocol = defaults.protocol;
    	      this.timeout = defaults.timeout;
    	      this.unhealthyThreshold = defaults.unhealthyThreshold;
        }

        @CustomType.Setter
        public Builder enabled(Boolean enabled) {
            if (enabled == null) {
              throw new MissingRequiredPropertyException("GetTargetGroupHealthCheck", "enabled");
            }
            this.enabled = enabled;
            return this;
        }
        @CustomType.Setter
        public Builder healthyThreshold(Integer healthyThreshold) {
            if (healthyThreshold == null) {
              throw new MissingRequiredPropertyException("GetTargetGroupHealthCheck", "healthyThreshold");
            }
            this.healthyThreshold = healthyThreshold;
            return this;
        }
        @CustomType.Setter
        public Builder interval(Integer interval) {
            if (interval == null) {
              throw new MissingRequiredPropertyException("GetTargetGroupHealthCheck", "interval");
            }
            this.interval = interval;
            return this;
        }
        @CustomType.Setter
        public Builder matcher(String matcher) {
            if (matcher == null) {
              throw new MissingRequiredPropertyException("GetTargetGroupHealthCheck", "matcher");
            }
            this.matcher = matcher;
            return this;
        }
        @CustomType.Setter
        public Builder path(String path) {
            if (path == null) {
              throw new MissingRequiredPropertyException("GetTargetGroupHealthCheck", "path");
            }
            this.path = path;
            return this;
        }
        @CustomType.Setter
        public Builder port(String port) {
            if (port == null) {
              throw new MissingRequiredPropertyException("GetTargetGroupHealthCheck", "port");
            }
            this.port = port;
            return this;
        }
        @CustomType.Setter
        public Builder protocol(String protocol) {
            if (protocol == null) {
              throw new MissingRequiredPropertyException("GetTargetGroupHealthCheck", "protocol");
            }
            this.protocol = protocol;
            return this;
        }
        @CustomType.Setter
        public Builder timeout(Integer timeout) {
            if (timeout == null) {
              throw new MissingRequiredPropertyException("GetTargetGroupHealthCheck", "timeout");
            }
            this.timeout = timeout;
            return this;
        }
        @CustomType.Setter
        public Builder unhealthyThreshold(Integer unhealthyThreshold) {
            if (unhealthyThreshold == null) {
              throw new MissingRequiredPropertyException("GetTargetGroupHealthCheck", "unhealthyThreshold");
            }
            this.unhealthyThreshold = unhealthyThreshold;
            return this;
        }
        public GetTargetGroupHealthCheck build() {
            final var _resultValue = new GetTargetGroupHealthCheck();
            _resultValue.enabled = enabled;
            _resultValue.healthyThreshold = healthyThreshold;
            _resultValue.interval = interval;
            _resultValue.matcher = matcher;
            _resultValue.path = path;
            _resultValue.port = port;
            _resultValue.protocol = protocol;
            _resultValue.timeout = timeout;
            _resultValue.unhealthyThreshold = unhealthyThreshold;
            return _resultValue;
        }
    }
}
