// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.outputs;

import com.pulumi.aws.ec2.outputs.GetLaunchTemplateInstanceMarketOptionSpotOption;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetLaunchTemplateInstanceMarketOption {
    private String marketType;
    private List<GetLaunchTemplateInstanceMarketOptionSpotOption> spotOptions;

    private GetLaunchTemplateInstanceMarketOption() {}
    public String marketType() {
        return this.marketType;
    }
    public List<GetLaunchTemplateInstanceMarketOptionSpotOption> spotOptions() {
        return this.spotOptions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetLaunchTemplateInstanceMarketOption defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String marketType;
        private List<GetLaunchTemplateInstanceMarketOptionSpotOption> spotOptions;
        public Builder() {}
        public Builder(GetLaunchTemplateInstanceMarketOption defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.marketType = defaults.marketType;
    	      this.spotOptions = defaults.spotOptions;
        }

        @CustomType.Setter
        public Builder marketType(String marketType) {
            if (marketType == null) {
              throw new MissingRequiredPropertyException("GetLaunchTemplateInstanceMarketOption", "marketType");
            }
            this.marketType = marketType;
            return this;
        }
        @CustomType.Setter
        public Builder spotOptions(List<GetLaunchTemplateInstanceMarketOptionSpotOption> spotOptions) {
            if (spotOptions == null) {
              throw new MissingRequiredPropertyException("GetLaunchTemplateInstanceMarketOption", "spotOptions");
            }
            this.spotOptions = spotOptions;
            return this;
        }
        public Builder spotOptions(GetLaunchTemplateInstanceMarketOptionSpotOption... spotOptions) {
            return spotOptions(List.of(spotOptions));
        }
        public GetLaunchTemplateInstanceMarketOption build() {
            final var _resultValue = new GetLaunchTemplateInstanceMarketOption();
            _resultValue.marketType = marketType;
            _resultValue.spotOptions = spotOptions;
            return _resultValue;
        }
    }
}
