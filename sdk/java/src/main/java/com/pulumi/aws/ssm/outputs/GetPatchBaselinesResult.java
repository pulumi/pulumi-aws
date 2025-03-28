// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ssm.outputs;

import com.pulumi.aws.ssm.outputs.GetPatchBaselinesBaselineIdentity;
import com.pulumi.aws.ssm.outputs.GetPatchBaselinesFilter;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class GetPatchBaselinesResult {
    /**
     * @return List of baseline identities. See `baseline_identities` below.
     * 
     */
    private List<GetPatchBaselinesBaselineIdentity> baselineIdentities;
    private @Nullable Boolean defaultBaselines;
    private @Nullable List<GetPatchBaselinesFilter> filters;
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    private String id;

    private GetPatchBaselinesResult() {}
    /**
     * @return List of baseline identities. See `baseline_identities` below.
     * 
     */
    public List<GetPatchBaselinesBaselineIdentity> baselineIdentities() {
        return this.baselineIdentities;
    }
    public Optional<Boolean> defaultBaselines() {
        return Optional.ofNullable(this.defaultBaselines);
    }
    public List<GetPatchBaselinesFilter> filters() {
        return this.filters == null ? List.of() : this.filters;
    }
    /**
     * @return The provider-assigned unique ID for this managed resource.
     * 
     */
    public String id() {
        return this.id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetPatchBaselinesResult defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetPatchBaselinesBaselineIdentity> baselineIdentities;
        private @Nullable Boolean defaultBaselines;
        private @Nullable List<GetPatchBaselinesFilter> filters;
        private String id;
        public Builder() {}
        public Builder(GetPatchBaselinesResult defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.baselineIdentities = defaults.baselineIdentities;
    	      this.defaultBaselines = defaults.defaultBaselines;
    	      this.filters = defaults.filters;
    	      this.id = defaults.id;
        }

        @CustomType.Setter
        public Builder baselineIdentities(List<GetPatchBaselinesBaselineIdentity> baselineIdentities) {
            if (baselineIdentities == null) {
              throw new MissingRequiredPropertyException("GetPatchBaselinesResult", "baselineIdentities");
            }
            this.baselineIdentities = baselineIdentities;
            return this;
        }
        public Builder baselineIdentities(GetPatchBaselinesBaselineIdentity... baselineIdentities) {
            return baselineIdentities(List.of(baselineIdentities));
        }
        @CustomType.Setter
        public Builder defaultBaselines(@Nullable Boolean defaultBaselines) {

            this.defaultBaselines = defaultBaselines;
            return this;
        }
        @CustomType.Setter
        public Builder filters(@Nullable List<GetPatchBaselinesFilter> filters) {

            this.filters = filters;
            return this;
        }
        public Builder filters(GetPatchBaselinesFilter... filters) {
            return filters(List.of(filters));
        }
        @CustomType.Setter
        public Builder id(String id) {
            if (id == null) {
              throw new MissingRequiredPropertyException("GetPatchBaselinesResult", "id");
            }
            this.id = id;
            return this;
        }
        public GetPatchBaselinesResult build() {
            final var _resultValue = new GetPatchBaselinesResult();
            _resultValue.baselineIdentities = baselineIdentities;
            _resultValue.defaultBaselines = defaultBaselines;
            _resultValue.filters = filters;
            _resultValue.id = id;
            return _resultValue;
        }
    }
}
