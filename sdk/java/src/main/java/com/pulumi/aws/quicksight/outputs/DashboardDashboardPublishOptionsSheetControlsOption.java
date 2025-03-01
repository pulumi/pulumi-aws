// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DashboardDashboardPublishOptionsSheetControlsOption {
    /**
     * @return Visibility state. Possibles values: EXPANDED, COLLAPSED.
     * 
     */
    private @Nullable String visibilityState;

    private DashboardDashboardPublishOptionsSheetControlsOption() {}
    /**
     * @return Visibility state. Possibles values: EXPANDED, COLLAPSED.
     * 
     */
    public Optional<String> visibilityState() {
        return Optional.ofNullable(this.visibilityState);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DashboardDashboardPublishOptionsSheetControlsOption defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String visibilityState;
        public Builder() {}
        public Builder(DashboardDashboardPublishOptionsSheetControlsOption defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.visibilityState = defaults.visibilityState;
        }

        @CustomType.Setter
        public Builder visibilityState(@Nullable String visibilityState) {

            this.visibilityState = visibilityState;
            return this;
        }
        public DashboardDashboardPublishOptionsSheetControlsOption build() {
            final var _resultValue = new DashboardDashboardPublishOptionsSheetControlsOption();
            _resultValue.visibilityState = visibilityState;
            return _resultValue;
        }
    }
}
