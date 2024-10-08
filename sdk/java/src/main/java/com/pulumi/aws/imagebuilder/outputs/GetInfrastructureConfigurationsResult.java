// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.outputs;

import com.pulumi.aws.imagebuilder.outputs.GetInfrastructureConfigurationsFilter;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetInfrastructureConfigurationsResult {
    /**
     * @return Set of ARNs of the matched Image Builder Infrastructure Configurations.
     * 
     */
    private List<String> arns;
    private @Nullable List<GetInfrastructureConfigurationsFilter> filters;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return Set of names of the matched Image Builder Infrastructure Configurations.
     * 
     */
    private List<String> names;

    private GetInfrastructureConfigurationsResult() {}
    /**
     * @return Set of ARNs of the matched Image Builder Infrastructure Configurations.
     * 
     */
    public List<String> arns() {
        return this.arns;
    }
    public List<GetInfrastructureConfigurationsFilter> filters() {
        return this.filters == null ? List.of() : this.filters;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }
    /**
     * @return Set of names of the matched Image Builder Infrastructure Configurations.
     * 
     */
    public List<String> names() {
        return this.names;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetInfrastructureConfigurationsResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<String> arns;
        private @Nullable List<GetInfrastructureConfigurationsFilter> filters;
        private String id;
        private List<String> names;
        public Builder() {}
        public Builder(GetInfrastructureConfigurationsResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.arns = defaults.arns;
    	      this.filters = defaults.filters;
    	      this.id = defaults.id;
    	      this.names = defaults.names;
        }

        @CustomType.Setter
        public Builder arns(List<String> arns) {
            if (arns == null) {
              throw new MissingRequiredPropertyException("GetInfrastructureConfigurationsResult", "arns");
            }
            this.arns = arns;
            return this;
        }
        public Builder arns(String... arns) {
            return arns(List.of(arns));
        }
        @CustomType.Setter
        public Builder filters(@Nullable List<GetInfrastructureConfigurationsFilter> filters) {

            this.filters = filters;
            return this;
        }
        public Builder filters(GetInfrastructureConfigurationsFilter... filters) {
            return filters(List.of(filters));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetInfrastructureConfigurationsResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder names(List<String> names) {
            if (names == null) {
              throw new MissingRequiredPropertyException("GetInfrastructureConfigurationsResult", "names");
            }
            this.names = names;
            return this;
        }
        public Builder names(String... names) {
            return names(List.of(names));
        }
        public GetInfrastructureConfigurationsResult build() {
            final var _resultValue = new GetInfrastructureConfigurationsResult();
            _resultValue.arns = arns;
            _resultValue.filters = filters;
            _resultValue.id = id;
            _resultValue.names = names;
            return _resultValue;
        }
    }
}
