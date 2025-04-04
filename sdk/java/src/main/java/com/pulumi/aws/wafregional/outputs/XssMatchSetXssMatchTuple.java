// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.wafregional.outputs;

import com.pulumi.aws.wafregional.outputs.XssMatchSetXssMatchTupleFieldToMatch;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class XssMatchSetXssMatchTuple {
    /**
     * @return Specifies where in a web request to look for cross-site scripting attacks.
     * 
     */
    private XssMatchSetXssMatchTupleFieldToMatch fieldToMatch;
    /**
     * @return Which text transformation, if any, to perform on the web request before inspecting the request for cross-site scripting attacks.
     * 
     */
    private String textTransformation;

    private XssMatchSetXssMatchTuple() {}
    /**
     * @return Specifies where in a web request to look for cross-site scripting attacks.
     * 
     */
    public XssMatchSetXssMatchTupleFieldToMatch fieldToMatch() {
        return this.fieldToMatch;
    }
    /**
     * @return Which text transformation, if any, to perform on the web request before inspecting the request for cross-site scripting attacks.
     * 
     */
    public String textTransformation() {
        return this.textTransformation;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(XssMatchSetXssMatchTuple defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private XssMatchSetXssMatchTupleFieldToMatch fieldToMatch;
        private String textTransformation;
        public Builder() {}
        public Builder(XssMatchSetXssMatchTuple defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.fieldToMatch = defaults.fieldToMatch;
    	      this.textTransformation = defaults.textTransformation;
        }

        @CustomType.Setter
        public Builder fieldToMatch(XssMatchSetXssMatchTupleFieldToMatch fieldToMatch) {
            if (fieldToMatch == null) {
              throw new MissingRequiredPropertyException("XssMatchSetXssMatchTuple", "fieldToMatch");
            }
            this.fieldToMatch = fieldToMatch;
            return this;
        }
        @CustomType.Setter
        public Builder textTransformation(String textTransformation) {
            if (textTransformation == null) {
              throw new MissingRequiredPropertyException("XssMatchSetXssMatchTuple", "textTransformation");
            }
            this.textTransformation = textTransformation;
            return this;
        }
        public XssMatchSetXssMatchTuple build() {
            final var _resultValue = new XssMatchSetXssMatchTuple();
            _resultValue.fieldToMatch = fieldToMatch;
            _resultValue.textTransformation = textTransformation;
            return _resultValue;
        }
    }
}
