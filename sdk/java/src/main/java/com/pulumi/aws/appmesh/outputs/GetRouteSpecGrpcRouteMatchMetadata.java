// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.outputs;

import com.pulumi.aws.appmesh.outputs.GetRouteSpecGrpcRouteMatchMetadataMatch;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetRouteSpecGrpcRouteMatchMetadata {
    private Boolean invert;
    private List<GetRouteSpecGrpcRouteMatchMetadataMatch> matches;
    /**
     * @return Name of the route.
     * 
     */
    private String name;

    private GetRouteSpecGrpcRouteMatchMetadata() {}
    public Boolean invert() {
        return this.invert;
    }
    public List<GetRouteSpecGrpcRouteMatchMetadataMatch> matches() {
        return this.matches;
    }
    /**
     * @return Name of the route.
     * 
     */
    public String name() {
        return this.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetRouteSpecGrpcRouteMatchMetadata defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean invert;
        private List<GetRouteSpecGrpcRouteMatchMetadataMatch> matches;
        private String name;
        public Builder() {}
        public Builder(GetRouteSpecGrpcRouteMatchMetadata defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.invert = defaults.invert;
    	      this.matches = defaults.matches;
    	      this.name = defaults.name;
        }

        @CustomType.Setter
        public Builder invert(Boolean invert) {
            if (invert == null) {
              throw new MissingRequiredPropertyException("GetRouteSpecGrpcRouteMatchMetadata", "invert");
            }
            this.invert = invert;
            return this;
        }
        @CustomType.Setter
        public Builder matches(List<GetRouteSpecGrpcRouteMatchMetadataMatch> matches) {
            if (matches == null) {
              throw new MissingRequiredPropertyException("GetRouteSpecGrpcRouteMatchMetadata", "matches");
            }
            this.matches = matches;
            return this;
        }
        public Builder matches(GetRouteSpecGrpcRouteMatchMetadataMatch... matches) {
            return matches(List.of(matches));
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetRouteSpecGrpcRouteMatchMetadata", "name");
            }
            this.name = name;
            return this;
        }
        public GetRouteSpecGrpcRouteMatchMetadata build() {
            final var _resultValue = new GetRouteSpecGrpcRouteMatchMetadata();
            _resultValue.invert = invert;
            _resultValue.matches = matches;
            _resultValue.name = name;
            return _resultValue;
        }
    }
}
