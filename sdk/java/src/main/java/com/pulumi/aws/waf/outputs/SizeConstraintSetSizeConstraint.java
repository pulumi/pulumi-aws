// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.waf.outputs;

import com.pulumi.aws.waf.outputs.SizeConstraintSetSizeConstraintFieldToMatch;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class SizeConstraintSetSizeConstraint {
    /**
     * @return Type of comparison you want to perform, such as `EQ`, `NE`, `LT`, or `GT`. Please refer to the [documentation](https://docs.aws.amazon.com/waf/latest/APIReference/API_wafRegional_SizeConstraint.html) for a complete list of supported values.
     * 
     */
    private String comparisonOperator;
    /**
     * @return Parameter that specifies where in a web request to look for the size constraint.
     * 
     */
    private SizeConstraintSetSizeConstraintFieldToMatch fieldToMatch;
    /**
     * @return Size in bytes that you want to compare against the size of the specified `field_to_match`. Valid values for `size` are between 0 and 21474836480 bytes (0 and 20 GB).
     * 
     */
    private Integer size;
    /**
     * @return Parameter is used to eliminate unusual formatting that attackers may use in web requests to bypass AWS WAF. When a transformation is specified, AWS WAF performs the transformation on the `field_to_match` before inspecting the request for a match. Some examples of supported transformations are `CMD_LINE`, `HTML_ENTITY_DECODE`, and `NONE`. You can find a complete list of supported values in the [AWS WAF API Reference](http://docs.aws.amazon.com/waf/latest/APIReference/API_SizeConstraint.html#WAF-Type-SizeConstraint-TextTransformation).
     * **Note:** If you choose `BODY` as the `type`, you must also choose `NONE` because CloudFront only forwards the first 8192 bytes for inspection.
     * 
     */
    private String textTransformation;

    private SizeConstraintSetSizeConstraint() {}
    /**
     * @return Type of comparison you want to perform, such as `EQ`, `NE`, `LT`, or `GT`. Please refer to the [documentation](https://docs.aws.amazon.com/waf/latest/APIReference/API_wafRegional_SizeConstraint.html) for a complete list of supported values.
     * 
     */
    public String comparisonOperator() {
        return this.comparisonOperator;
    }
    /**
     * @return Parameter that specifies where in a web request to look for the size constraint.
     * 
     */
    public SizeConstraintSetSizeConstraintFieldToMatch fieldToMatch() {
        return this.fieldToMatch;
    }
    /**
     * @return Size in bytes that you want to compare against the size of the specified `field_to_match`. Valid values for `size` are between 0 and 21474836480 bytes (0 and 20 GB).
     * 
     */
    public Integer size() {
        return this.size;
    }
    /**
     * @return Parameter is used to eliminate unusual formatting that attackers may use in web requests to bypass AWS WAF. When a transformation is specified, AWS WAF performs the transformation on the `field_to_match` before inspecting the request for a match. Some examples of supported transformations are `CMD_LINE`, `HTML_ENTITY_DECODE`, and `NONE`. You can find a complete list of supported values in the [AWS WAF API Reference](http://docs.aws.amazon.com/waf/latest/APIReference/API_SizeConstraint.html#WAF-Type-SizeConstraint-TextTransformation).
     * **Note:** If you choose `BODY` as the `type`, you must also choose `NONE` because CloudFront only forwards the first 8192 bytes for inspection.
     * 
     */
    public String textTransformation() {
        return this.textTransformation;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SizeConstraintSetSizeConstraint defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String comparisonOperator;
        private SizeConstraintSetSizeConstraintFieldToMatch fieldToMatch;
        private Integer size;
        private String textTransformation;
        public Builder() {}
        public Builder(SizeConstraintSetSizeConstraint defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.comparisonOperator = defaults.comparisonOperator;
    	      this.fieldToMatch = defaults.fieldToMatch;
    	      this.size = defaults.size;
    	      this.textTransformation = defaults.textTransformation;
        }

        @CustomType.Setter
        public Builder comparisonOperator(String comparisonOperator) {
            if (comparisonOperator == null) {
              throw new MissingRequiredPropertyException("SizeConstraintSetSizeConstraint", "comparisonOperator");
            }
            this.comparisonOperator = comparisonOperator;
            return this;
        }
        @CustomType.Setter
        public Builder fieldToMatch(SizeConstraintSetSizeConstraintFieldToMatch fieldToMatch) {
            if (fieldToMatch == null) {
              throw new MissingRequiredPropertyException("SizeConstraintSetSizeConstraint", "fieldToMatch");
            }
            this.fieldToMatch = fieldToMatch;
            return this;
        }
        @CustomType.Setter
        public Builder size(Integer size) {
            if (size == null) {
              throw new MissingRequiredPropertyException("SizeConstraintSetSizeConstraint", "size");
            }
            this.size = size;
            return this;
        }
        @CustomType.Setter
        public Builder textTransformation(String textTransformation) {
            if (textTransformation == null) {
              throw new MissingRequiredPropertyException("SizeConstraintSetSizeConstraint", "textTransformation");
            }
            this.textTransformation = textTransformation;
            return this;
        }
        public SizeConstraintSetSizeConstraint build() {
            final var _resultValue = new SizeConstraintSetSizeConstraint();
            _resultValue.comparisonOperator = comparisonOperator;
            _resultValue.fieldToMatch = fieldToMatch;
            _resultValue.size = size;
            _resultValue.textTransformation = textTransformation;
            return _resultValue;
        }
    }
}
