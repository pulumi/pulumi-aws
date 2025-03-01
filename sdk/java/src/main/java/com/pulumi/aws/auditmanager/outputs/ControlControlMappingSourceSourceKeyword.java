// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.auditmanager.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class ControlControlMappingSourceSourceKeyword {
    /**
     * @return Input method for the keyword. Valid values are `INPUT_TEXT`, `SELECT_FROM_LIST`, or `UPLOAD_FILE`.
     * 
     */
    private String keywordInputType;
    /**
     * @return The value of the keyword that&#39;s used when mapping a control data source. For example, this can be a CloudTrail event name, a rule name for Config, a Security Hub control, or the name of an Amazon Web Services API call. See the [Audit Manager supported control data sources documentation](https://docs.aws.amazon.com/audit-manager/latest/userguide/control-data-sources.html) for more information.
     * 
     */
    private String keywordValue;

    private ControlControlMappingSourceSourceKeyword() {}
    /**
     * @return Input method for the keyword. Valid values are `INPUT_TEXT`, `SELECT_FROM_LIST`, or `UPLOAD_FILE`.
     * 
     */
    public String keywordInputType() {
        return this.keywordInputType;
    }
    /**
     * @return The value of the keyword that&#39;s used when mapping a control data source. For example, this can be a CloudTrail event name, a rule name for Config, a Security Hub control, or the name of an Amazon Web Services API call. See the [Audit Manager supported control data sources documentation](https://docs.aws.amazon.com/audit-manager/latest/userguide/control-data-sources.html) for more information.
     * 
     */
    public String keywordValue() {
        return this.keywordValue;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ControlControlMappingSourceSourceKeyword defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String keywordInputType;
        private String keywordValue;
        public Builder() {}
        public Builder(ControlControlMappingSourceSourceKeyword defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.keywordInputType = defaults.keywordInputType;
    	      this.keywordValue = defaults.keywordValue;
        }

        @CustomType.Setter
        public Builder keywordInputType(String keywordInputType) {
            if (keywordInputType == null) {
              throw new MissingRequiredPropertyException("ControlControlMappingSourceSourceKeyword", "keywordInputType");
            }
            this.keywordInputType = keywordInputType;
            return this;
        }
        @CustomType.Setter
        public Builder keywordValue(String keywordValue) {
            if (keywordValue == null) {
              throw new MissingRequiredPropertyException("ControlControlMappingSourceSourceKeyword", "keywordValue");
            }
            this.keywordValue = keywordValue;
            return this;
        }
        public ControlControlMappingSourceSourceKeyword build() {
            final var _resultValue = new ControlControlMappingSourceSourceKeyword();
            _resultValue.keywordInputType = keywordInputType;
            _resultValue.keywordValue = keywordValue;
            return _resultValue;
        }
    }
}
