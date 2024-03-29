// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ebs.outputs;

import com.pulumi.aws.ebs.outputs.GetEbsVolumesFilter;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class GetEbsVolumesResult {
    private @Nullable List<GetEbsVolumesFilter> filters;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;
    /**
     * @return Set of all the EBS Volume IDs found. This data source will fail if
     * no volumes match the provided criteria.
     * 
     */
    private List<String> ids;
    private @Nullable Map<String,String> tags;

    private GetEbsVolumesResult() {}
    public List<GetEbsVolumesFilter> filters() {
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
     * @return Set of all the EBS Volume IDs found. This data source will fail if
     * no volumes match the provided criteria.
     * 
     */
    public List<String> ids() {
        return this.ids;
    }
    public Map<String,String> tags() {
        return this.tags == null ? Map.of() : this.tags;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetEbsVolumesResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<GetEbsVolumesFilter> filters;
        private String id;
        private List<String> ids;
        private @Nullable Map<String,String> tags;
        public Builder() {}
        public Builder(GetEbsVolumesResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.filters = defaults.filters;
    	      this.id = defaults.id;
    	      this.ids = defaults.ids;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder filters(@Nullable List<GetEbsVolumesFilter> filters) {

            this.filters = filters;
            return this;
        }
        public Builder filters(GetEbsVolumesFilter... filters) {
            return filters(List.of(filters));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetEbsVolumesResult", "id");
            }
            this.id = id;
            return this;
        }
        @CustomType.Setter
        public Builder ids(List<String> ids) {
            if (ids == null) {
              throw new MissingRequiredPropertyException("GetEbsVolumesResult", "ids");
            }
            this.ids = ids;
            return this;
        }
        public Builder ids(String... ids) {
            return ids(List.of(ids));
        }
        @CustomType.Setter
        public Builder tags(@Nullable Map<String,String> tags) {

            this.tags = tags;
            return this;
        }
        public GetEbsVolumesResult build() {
            final var _resultValue = new GetEbsVolumesResult();
            _resultValue.filters = filters;
            _resultValue.id = id;
            _resultValue.ids = ids;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
