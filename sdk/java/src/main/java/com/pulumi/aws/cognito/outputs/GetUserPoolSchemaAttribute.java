// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito.outputs;

import com.pulumi.aws.cognito.outputs.GetUserPoolSchemaAttributeNumberAttributeConstraint;
import com.pulumi.aws.cognito.outputs.GetUserPoolSchemaAttributeStringAttributeConstraint;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetUserPoolSchemaAttribute {
    /**
     * @return - Data type of the attribute (e.g., string, number).
     * 
     */
    private String attributeDataType;
    /**
     * @return - Whether the attribute is for developer use only.
     * 
     */
    private Boolean developerOnlyAttribute;
    /**
     * @return - Whether the attribute can be changed after user creation.
     * 
     */
    private Boolean mutable;
    /**
     * @return - Name of the attribute.
     * 
     */
    private String name;
    private List<GetUserPoolSchemaAttributeNumberAttributeConstraint> numberAttributeConstraints;
    /**
     * @return - Whether the attribute is required during user registration.
     * * number_attribute_constraints - Constraints for numeric attributes.
     * * string_attribute_constraints - Constraints for string attributes.
     * 
     */
    private Boolean required;
    private List<GetUserPoolSchemaAttributeStringAttributeConstraint> stringAttributeConstraints;

    private GetUserPoolSchemaAttribute() {}
    /**
     * @return - Data type of the attribute (e.g., string, number).
     * 
     */
    public String attributeDataType() {
        return this.attributeDataType;
    }
    /**
     * @return - Whether the attribute is for developer use only.
     * 
     */
    public Boolean developerOnlyAttribute() {
        return this.developerOnlyAttribute;
    }
    /**
     * @return - Whether the attribute can be changed after user creation.
     * 
     */
    public Boolean mutable() {
        return this.mutable;
    }
    /**
     * @return - Name of the attribute.
     * 
     */
    public String name() {
        return this.name;
    }
    public List<GetUserPoolSchemaAttributeNumberAttributeConstraint> numberAttributeConstraints() {
        return this.numberAttributeConstraints;
    }
    /**
     * @return - Whether the attribute is required during user registration.
     * * number_attribute_constraints - Constraints for numeric attributes.
     * * string_attribute_constraints - Constraints for string attributes.
     * 
     */
    public Boolean required() {
        return this.required;
    }
    public List<GetUserPoolSchemaAttributeStringAttributeConstraint> stringAttributeConstraints() {
        return this.stringAttributeConstraints;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetUserPoolSchemaAttribute defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String attributeDataType;
        private Boolean developerOnlyAttribute;
        private Boolean mutable;
        private String name;
        private List<GetUserPoolSchemaAttributeNumberAttributeConstraint> numberAttributeConstraints;
        private Boolean required;
        private List<GetUserPoolSchemaAttributeStringAttributeConstraint> stringAttributeConstraints;
        public Builder() {}
        public Builder(GetUserPoolSchemaAttribute defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.attributeDataType = defaults.attributeDataType;
    	      this.developerOnlyAttribute = defaults.developerOnlyAttribute;
    	      this.mutable = defaults.mutable;
    	      this.name = defaults.name;
    	      this.numberAttributeConstraints = defaults.numberAttributeConstraints;
    	      this.required = defaults.required;
    	      this.stringAttributeConstraints = defaults.stringAttributeConstraints;
        }

        @CustomType.Setter
        public Builder attributeDataType(String attributeDataType) {
            if (attributeDataType == null) {
              throw new MissingRequiredPropertyException("GetUserPoolSchemaAttribute", "attributeDataType");
            }
            this.attributeDataType = attributeDataType;
            return this;
        }
        @CustomType.Setter
        public Builder developerOnlyAttribute(Boolean developerOnlyAttribute) {
            if (developerOnlyAttribute == null) {
              throw new MissingRequiredPropertyException("GetUserPoolSchemaAttribute", "developerOnlyAttribute");
            }
            this.developerOnlyAttribute = developerOnlyAttribute;
            return this;
        }
        @CustomType.Setter
        public Builder mutable(Boolean mutable) {
            if (mutable == null) {
              throw new MissingRequiredPropertyException("GetUserPoolSchemaAttribute", "mutable");
            }
            this.mutable = mutable;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            if (name == null) {
              throw new MissingRequiredPropertyException("GetUserPoolSchemaAttribute", "name");
            }
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder numberAttributeConstraints(List<GetUserPoolSchemaAttributeNumberAttributeConstraint> numberAttributeConstraints) {
            if (numberAttributeConstraints == null) {
              throw new MissingRequiredPropertyException("GetUserPoolSchemaAttribute", "numberAttributeConstraints");
            }
            this.numberAttributeConstraints = numberAttributeConstraints;
            return this;
        }
        public Builder numberAttributeConstraints(GetUserPoolSchemaAttributeNumberAttributeConstraint... numberAttributeConstraints) {
            return numberAttributeConstraints(List.of(numberAttributeConstraints));
        }
        @CustomType.Setter
        public Builder required(Boolean required) {
            if (required == null) {
              throw new MissingRequiredPropertyException("GetUserPoolSchemaAttribute", "required");
            }
            this.required = required;
            return this;
        }
        @CustomType.Setter
        public Builder stringAttributeConstraints(List<GetUserPoolSchemaAttributeStringAttributeConstraint> stringAttributeConstraints) {
            if (stringAttributeConstraints == null) {
              throw new MissingRequiredPropertyException("GetUserPoolSchemaAttribute", "stringAttributeConstraints");
            }
            this.stringAttributeConstraints = stringAttributeConstraints;
            return this;
        }
        public Builder stringAttributeConstraints(GetUserPoolSchemaAttributeStringAttributeConstraint... stringAttributeConstraints) {
            return stringAttributeConstraints(List.of(stringAttributeConstraints));
        }
        public GetUserPoolSchemaAttribute build() {
            final var _resultValue = new GetUserPoolSchemaAttribute();
            _resultValue.attributeDataType = attributeDataType;
            _resultValue.developerOnlyAttribute = developerOnlyAttribute;
            _resultValue.mutable = mutable;
            _resultValue.name = name;
            _resultValue.numberAttributeConstraints = numberAttributeConstraints;
            _resultValue.required = required;
            _resultValue.stringAttributeConstraints = stringAttributeConstraints;
            return _resultValue;
        }
    }
}
