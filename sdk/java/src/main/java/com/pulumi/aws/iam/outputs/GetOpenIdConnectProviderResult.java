// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetOpenIdConnectProviderResult {
    private String arn;
    /**
     * @return List of client IDs (also known as audiences). When a mobile or web app registers with an OpenID Connect provider, they establish a value that identifies the application. (This is the value that&#39;s sent as the client_id parameter on OAuth requests.)
     * 
     */
    private List<String> clientIdLists;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return Map of resource tags for the IAM OIDC provider.
     * 
     */
    private Map<String,String> tags;
    /**
     * @return List of server certificate thumbprints for the OpenID Connect (OIDC) identity provider&#39;s server certificate(s).
     * 
     */
    private List<String> thumbprintLists;
    private String url;

    private GetOpenIdConnectProviderResult() {}
    public String arn() {
        return this.arn;
    }
    /**
     * @return List of client IDs (also known as audiences). When a mobile or web app registers with an OpenID Connect provider, they establish a value that identifies the application. (This is the value that&#39;s sent as the client_id parameter on OAuth requests.)
     * 
     */
    public List<String> clientIdLists() {
        return this.clientIdLists;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return Map of resource tags for the IAM OIDC provider.
     * 
     */
    public Map<String,String> tags() {
        return this.tags;
    }
    /**
     * @return List of server certificate thumbprints for the OpenID Connect (OIDC) identity provider&#39;s server certificate(s).
     * 
     */
    public List<String> thumbprintLists() {
        return this.thumbprintLists;
    }
    public String url() {
        return this.url;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetOpenIdConnectProviderResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String arn;
        private List<String> clientIdLists;
        private String id;
        private Map<String,String> tags;
        private List<String> thumbprintLists;
        private String url;
        public Builder() {}
        public Builder(GetOpenIdConnectProviderResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arn = defaults.arn;
    	      this.clientIdLists = defaults.clientIdLists;
    	      this.id = defaults.id;
    	      this.tags = defaults.tags;
    	      this.thumbprintLists = defaults.thumbprintLists;
    	      this.url = defaults.url;
        }

        @CustomType.Setter
        public Builder arn(String arn) {
            if (arn == null) {
              throw new MissingRequiredPropertyException("GetOpenIdConnectProviderResult", "arn");
            }
            this.arn = arn;
            return this;
        }
        @CustomType.Setter
        public Builder clientIdLists(List<String> clientIdLists) {
            if (clientIdLists == null) {
              throw new MissingRequiredPropertyException("GetOpenIdConnectProviderResult", "clientIdLists");
            }
            this.clientIdLists = clientIdLists;
            return this;
        }
        public Builder clientIdLists(String... clientIdLists) {
            return clientIdLists(List.of(clientIdLists));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetOpenIdConnectProviderResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder tags(Map<String,String> tags) {
            if (tags == null) {
              throw new MissingRequiredPropertyException("GetOpenIdConnectProviderResult", "tags");
            }
            this.tags = tags;
            return this;
        }
        @CustomType.Setter
        public Builder thumbprintLists(List<String> thumbprintLists) {
            if (thumbprintLists == null) {
              throw new MissingRequiredPropertyException("GetOpenIdConnectProviderResult", "thumbprintLists");
            }
            this.thumbprintLists = thumbprintLists;
            return this;
        }
        public Builder thumbprintLists(String... thumbprintLists) {
            return thumbprintLists(List.of(thumbprintLists));
        }
        @CustomType.Setter
        public Builder url(String url) {
            if (url == null) {
              throw new MissingRequiredPropertyException("GetOpenIdConnectProviderResult", "url");
            }
            this.url = url;
            return this;
        }
        public GetOpenIdConnectProviderResult build() {
            final var _resultValue = new GetOpenIdConnectProviderResult();
            _resultValue.arn = arn;
            _resultValue.clientIdLists = clientIdLists;
            _resultValue.id = id;
            _resultValue.tags = tags;
            _resultValue.thumbprintLists = thumbprintLists;
            _resultValue.url = url;
            return _resultValue;
        }
    }
}
