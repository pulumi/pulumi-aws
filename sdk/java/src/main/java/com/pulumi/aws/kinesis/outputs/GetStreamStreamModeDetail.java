// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kinesis.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class GetStreamStreamModeDetail {
    /**
     * @return Capacity mode of the stream. Either `ON_DEMAND` or `PROVISIONED`.
     * 
     */
    private String streamMode;

    private GetStreamStreamModeDetail() {}
    /**
     * @return Capacity mode of the stream. Either `ON_DEMAND` or `PROVISIONED`.
     * 
     */
    public String streamMode() {
        return this.streamMode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetStreamStreamModeDetail defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String streamMode;
        public Builder() {}
        public Builder(GetStreamStreamModeDetail defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.streamMode = defaults.streamMode;
        }

        @CustomType.Setter
        public Builder streamMode(String streamMode) {
            if (streamMode == null) {
              throw new MissingRequiredPropertyException("GetStreamStreamModeDetail", "streamMode");
            }
            this.streamMode = streamMode;
            return this;
        }
        public GetStreamStreamModeDetail build() {
            final var _resultValue = new GetStreamStreamModeDetail();
            _resultValue.streamMode = streamMode;
            return _resultValue;
        }
    }
}
