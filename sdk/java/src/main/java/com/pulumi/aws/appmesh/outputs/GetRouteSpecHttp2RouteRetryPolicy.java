// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetRouteSpecHttp2RouteRetryPolicyPerRetryTimeout;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetRouteSpecHttp2RouteRetryPolicy {
    private List<String> httpRetryEvents;
    private Integer maxRetries;
    private List<GetRouteSpecHttp2RouteRetryPolicyPerRetryTimeout> perRetryTimeouts;
    private List<String> tcpRetryEvents;

    private GetRouteSpecHttp2RouteRetryPolicy() {}
    public List<String> httpRetryEvents() {
        return this.httpRetryEvents;
    }
    public Integer maxRetries() {
        return this.maxRetries;
    }
    public List<GetRouteSpecHttp2RouteRetryPolicyPerRetryTimeout> perRetryTimeouts() {
        return this.perRetryTimeouts;
    }
    public List<String> tcpRetryEvents() {
        return this.tcpRetryEvents;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetRouteSpecHttp2RouteRetryPolicy defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> httpRetryEvents;
        private Integer maxRetries;
        private List<GetRouteSpecHttp2RouteRetryPolicyPerRetryTimeout> perRetryTimeouts;
        private List<String> tcpRetryEvents;
        public Builder() {}
        public Builder(GetRouteSpecHttp2RouteRetryPolicy defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.httpRetryEvents = defaults.httpRetryEvents;
    	      this.maxRetries = defaults.maxRetries;
    	      this.perRetryTimeouts = defaults.perRetryTimeouts;
    	      this.tcpRetryEvents = defaults.tcpRetryEvents;
        }

        @CustomType.Setter
        public Builder httpRetryEvents(List<String> httpRetryEvents) {
            if (httpRetryEvents == null) {
              throw new MissingRequiredPropertyException("GetRouteSpecHttp2RouteRetryPolicy", "httpRetryEvents");
            }
            this.httpRetryEvents = httpRetryEvents;
            return this;
        }
        public Builder httpRetryEvents(String... httpRetryEvents) {
            return httpRetryEvents(List.of(httpRetryEvents));
        }
        @CustomType.Setter
        public Builder maxRetries(Integer maxRetries) {
            if (maxRetries == null) {
              throw new MissingRequiredPropertyException("GetRouteSpecHttp2RouteRetryPolicy", "maxRetries");
            }
            this.maxRetries = maxRetries;
            return this;
        }
        @CustomType.Setter
        public Builder perRetryTimeouts(List<GetRouteSpecHttp2RouteRetryPolicyPerRetryTimeout> perRetryTimeouts) {
            if (perRetryTimeouts == null) {
              throw new MissingRequiredPropertyException("GetRouteSpecHttp2RouteRetryPolicy", "perRetryTimeouts");
            }
            this.perRetryTimeouts = perRetryTimeouts;
            return this;
        }
        public Builder perRetryTimeouts(GetRouteSpecHttp2RouteRetryPolicyPerRetryTimeout... perRetryTimeouts) {
            return perRetryTimeouts(List.of(perRetryTimeouts));
        }
        @CustomType.Setter
        public Builder tcpRetryEvents(List<String> tcpRetryEvents) {
            if (tcpRetryEvents == null) {
              throw new MissingRequiredPropertyException("GetRouteSpecHttp2RouteRetryPolicy", "tcpRetryEvents");
            }
            this.tcpRetryEvents = tcpRetryEvents;
            return this;
        }
        public Builder tcpRetryEvents(String... tcpRetryEvents) {
            return tcpRetryEvents(List.of(tcpRetryEvents));
        }
        public GetRouteSpecHttp2RouteRetryPolicy build() {
            final var _resultValue = new GetRouteSpecHttp2RouteRetryPolicy();
            _resultValue.httpRetryEvents = httpRetryEvents;
            _resultValue.maxRetries = maxRetries;
            _resultValue.perRetryTimeouts = perRetryTimeouts;
            _resultValue.tcpRetryEvents = tcpRetryEvents;
            return _resultValue;
        }
    }
}
