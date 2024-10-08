// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bcmdata.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ExportExportRefreshCadence {
    /**
     * @return Frequency that data exports are updated. The export refreshes each time the source data updates, up to three times daily. Valid values `SYNCHRONOUS`.
     * 
     */
    private String frequency;

    private ExportExportRefreshCadence() {}
    /**
     * @return Frequency that data exports are updated. The export refreshes each time the source data updates, up to three times daily. Valid values `SYNCHRONOUS`.
     * 
     */
    public String frequency() {
        return this.frequency;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ExportExportRefreshCadence defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String frequency;
        public Builder() {}
        public Builder(ExportExportRefreshCadence defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.frequency = defaults.frequency;
        }

        @CustomType.Setter
        public Builder frequency(String frequency) {
            if (frequency == null) {
              throw new MissingRequiredPropertyException("ExportExportRefreshCadence", "frequency");
            }
            this.frequency = frequency;
            return this;
        }
        public ExportExportRefreshCadence build() {
            final var _resultValue = new ExportExportRefreshCadence();
            _resultValue.frequency = frequency;
            return _resultValue;
        }
    }
}
