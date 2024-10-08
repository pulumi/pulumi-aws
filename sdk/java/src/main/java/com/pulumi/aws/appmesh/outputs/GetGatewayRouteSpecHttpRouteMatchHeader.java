// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetGatewayRouteSpecHttpRouteMatchHeaderMatch;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetGatewayRouteSpecHttpRouteMatchHeader {
    private Boolean invert;
    private List<GetGatewayRouteSpecHttpRouteMatchHeaderMatch> matches;
    /**
     * @return Name of the gateway route.
     * 
     */
    private String name;

    private GetGatewayRouteSpecHttpRouteMatchHeader() {}
    public Boolean invert() {
        return this.invert;
    }
    public List<GetGatewayRouteSpecHttpRouteMatchHeaderMatch> matches() {
        return this.matches;
    }
    /**
     * @return Name of the gateway route.
     * 
     */
    public String name() {
        return this.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetGatewayRouteSpecHttpRouteMatchHeader defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean invert;
        private List<GetGatewayRouteSpecHttpRouteMatchHeaderMatch> matches;
        private String name;
        public Builder() {}
        public Builder(GetGatewayRouteSpecHttpRouteMatchHeader defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.invert = defaults.invert;
    	      this.matches = defaults.matches;
    	      this.name = defaults.name;
        }

        @CustomType.Setter
        public Builder invert(Boolean invert) {
            if (invert == null) {
              throw new MissingRequiredPropertyException("GetGatewayRouteSpecHttpRouteMatchHeader", "invert");
            }
            this.invert = invert;
            return this;
        }
        @CustomType.Setter
        public Builder matches(List<GetGatewayRouteSpecHttpRouteMatchHeaderMatch> matches) {
            if (matches == null) {
              throw new MissingRequiredPropertyException("GetGatewayRouteSpecHttpRouteMatchHeader", "matches");
            }
            this.matches = matches;
            return this;
        }
        public Builder matches(GetGatewayRouteSpecHttpRouteMatchHeaderMatch... matches) {
            return matches(List.of(matches));
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetGatewayRouteSpecHttpRouteMatchHeader", "name");
            }
            this.name = name;
            return this;
        }
        public GetGatewayRouteSpecHttpRouteMatchHeader build() {
            final var _resultValue = new GetGatewayRouteSpecHttpRouteMatchHeader();
            _resultValue.invert = invert;
            _resultValue.matches = matches;
            _resultValue.name = name;
            return _resultValue;
        }
    }
}
