// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lb.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetListenerDefaultActionAuthenticateCognito {
    private Map<String,String> authenticationRequestExtraParams;
    private String onUnauthenticatedRequest;
    private String scope;
    private String sessionCookieName;
    private Integer sessionTimeout;
    private String userPoolArn;
    private String userPoolClientId;
    private String userPoolDomain;

    private GetListenerDefaultActionAuthenticateCognito() {}
    public Map<String,String> authenticationRequestExtraParams() {
        return this.authenticationRequestExtraParams;
    }
    public String onUnauthenticatedRequest() {
        return this.onUnauthenticatedRequest;
    }
    public String scope() {
        return this.scope;
    }
    public String sessionCookieName() {
        return this.sessionCookieName;
    }
    public Integer sessionTimeout() {
        return this.sessionTimeout;
    }
    public String userPoolArn() {
        return this.userPoolArn;
    }
    public String userPoolClientId() {
        return this.userPoolClientId;
    }
    public String userPoolDomain() {
        return this.userPoolDomain;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetListenerDefaultActionAuthenticateCognito defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Map<String,String> authenticationRequestExtraParams;
        private String onUnauthenticatedRequest;
        private String scope;
        private String sessionCookieName;
        private Integer sessionTimeout;
        private String userPoolArn;
        private String userPoolClientId;
        private String userPoolDomain;
        public Builder() {}
        public Builder(GetListenerDefaultActionAuthenticateCognito defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.authenticationRequestExtraParams = defaults.authenticationRequestExtraParams;
    	      this.onUnauthenticatedRequest = defaults.onUnauthenticatedRequest;
    	      this.scope = defaults.scope;
    	      this.sessionCookieName = defaults.sessionCookieName;
    	      this.sessionTimeout = defaults.sessionTimeout;
    	      this.userPoolArn = defaults.userPoolArn;
    	      this.userPoolClientId = defaults.userPoolClientId;
    	      this.userPoolDomain = defaults.userPoolDomain;
        }

        @CustomType.Setter
        public Builder authenticationRequestExtraParams(Map<String,String> authenticationRequestExtraParams) {
            if (authenticationRequestExtraParams == null) {
              throw new MissingRequiredPropertyException("GetListenerDefaultActionAuthenticateCognito", "authenticationRequestExtraParams");
            }
            this.authenticationRequestExtraParams = authenticationRequestExtraParams;
            return this;
        }
        @CustomType.Setter
        public Builder onUnauthenticatedRequest(String onUnauthenticatedRequest) {
            if (onUnauthenticatedRequest == null) {
              throw new MissingRequiredPropertyException("GetListenerDefaultActionAuthenticateCognito", "onUnauthenticatedRequest");
            }
            this.onUnauthenticatedRequest = onUnauthenticatedRequest;
            return this;
        }
        @CustomType.Setter
        public Builder scope(String scope) {
            if (scope == null) {
              throw new MissingRequiredPropertyException("GetListenerDefaultActionAuthenticateCognito", "scope");
            }
            this.scope = scope;
            return this;
        }
        @CustomType.Setter
        public Builder sessionCookieName(String sessionCookieName) {
            if (sessionCookieName == null) {
              throw new MissingRequiredPropertyException("GetListenerDefaultActionAuthenticateCognito", "sessionCookieName");
            }
            this.sessionCookieName = sessionCookieName;
            return this;
        }
        @CustomType.Setter
        public Builder sessionTimeout(Integer sessionTimeout) {
            if (sessionTimeout == null) {
              throw new MissingRequiredPropertyException("GetListenerDefaultActionAuthenticateCognito", "sessionTimeout");
            }
            this.sessionTimeout = sessionTimeout;
            return this;
        }
        @CustomType.Setter
        public Builder userPoolArn(String userPoolArn) {
            if (userPoolArn == null) {
              throw new MissingRequiredPropertyException("GetListenerDefaultActionAuthenticateCognito", "userPoolArn");
            }
            this.userPoolArn = userPoolArn;
            return this;
        }
        @CustomType.Setter
        public Builder userPoolClientId(String userPoolClientId) {
            if (userPoolClientId == null) {
              throw new MissingRequiredPropertyException("GetListenerDefaultActionAuthenticateCognito", "userPoolClientId");
            }
            this.userPoolClientId = userPoolClientId;
            return this;
        }
        @CustomType.Setter
        public Builder userPoolDomain(String userPoolDomain) {
            if (userPoolDomain == null) {
              throw new MissingRequiredPropertyException("GetListenerDefaultActionAuthenticateCognito", "userPoolDomain");
            }
            this.userPoolDomain = userPoolDomain;
            return this;
        }
        public GetListenerDefaultActionAuthenticateCognito build() {
            final var _resultValue = new GetListenerDefaultActionAuthenticateCognito();
            _resultValue.authenticationRequestExtraParams = authenticationRequestExtraParams;
            _resultValue.onUnauthenticatedRequest = onUnauthenticatedRequest;
            _resultValue.scope = scope;
            _resultValue.sessionCookieName = sessionCookieName;
            _resultValue.sessionTimeout = sessionTimeout;
            _resultValue.userPoolArn = userPoolArn;
            _resultValue.userPoolClientId = userPoolClientId;
            _resultValue.userPoolDomain = userPoolDomain;
            return _resultValue;
        }
    }
}
