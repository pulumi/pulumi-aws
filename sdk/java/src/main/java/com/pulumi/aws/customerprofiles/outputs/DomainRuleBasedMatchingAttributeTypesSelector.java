// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.customerprofiles.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class DomainRuleBasedMatchingAttributeTypesSelector {
    /**
     * @return The `Address` type. You can choose from `Address`, `BusinessAddress`, `MaillingAddress`, and `ShippingAddress`.
     * 
     */
    private @Nullable List<String> addresses;
    /**
     * @return Configures the `AttributeMatchingModel`, you can either choose `ONE_TO_ONE` or `MANY_TO_MANY`.
     * 
     */
    private String attributeMatchingModel;
    /**
     * @return The `Email` type. You can choose from `EmailAddress`, `BusinessEmailAddress` and `PersonalEmailAddress`.
     * 
     */
    private @Nullable List<String> emailAddresses;
    /**
     * @return The `PhoneNumber` type. You can choose from `PhoneNumber`, `HomePhoneNumber`, and `MobilePhoneNumber`.
     * 
     */
    private @Nullable List<String> phoneNumbers;

    private DomainRuleBasedMatchingAttributeTypesSelector() {}
    /**
     * @return The `Address` type. You can choose from `Address`, `BusinessAddress`, `MaillingAddress`, and `ShippingAddress`.
     * 
     */
    public List<String> addresses() {
        return this.addresses == null ? List.of() : this.addresses;
    }
    /**
     * @return Configures the `AttributeMatchingModel`, you can either choose `ONE_TO_ONE` or `MANY_TO_MANY`.
     * 
     */
    public String attributeMatchingModel() {
        return this.attributeMatchingModel;
    }
    /**
     * @return The `Email` type. You can choose from `EmailAddress`, `BusinessEmailAddress` and `PersonalEmailAddress`.
     * 
     */
    public List<String> emailAddresses() {
        return this.emailAddresses == null ? List.of() : this.emailAddresses;
    }
    /**
     * @return The `PhoneNumber` type. You can choose from `PhoneNumber`, `HomePhoneNumber`, and `MobilePhoneNumber`.
     * 
     */
    public List<String> phoneNumbers() {
        return this.phoneNumbers == null ? List.of() : this.phoneNumbers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DomainRuleBasedMatchingAttributeTypesSelector defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<String> addresses;
        private String attributeMatchingModel;
        private @Nullable List<String> emailAddresses;
        private @Nullable List<String> phoneNumbers;
        public Builder() {}
        public Builder(DomainRuleBasedMatchingAttributeTypesSelector defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.addresses = defaults.addresses;
    	      this.attributeMatchingModel = defaults.attributeMatchingModel;
    	      this.emailAddresses = defaults.emailAddresses;
    	      this.phoneNumbers = defaults.phoneNumbers;
        }

        @CustomType.Setter
        public Builder addresses(@Nullable List<String> addresses) {

            this.addresses = addresses;
            return this;
        }
        public Builder addresses(String... addresses) {
            return addresses(List.of(addresses));
        }
        @CustomType.Setter
        public Builder attributeMatchingModel(String attributeMatchingModel) {
            if (attributeMatchingModel == null) {
              throw new MissingRequiredPropertyException("DomainRuleBasedMatchingAttributeTypesSelector", "attributeMatchingModel");
            }
            this.attributeMatchingModel = attributeMatchingModel;
            return this;
        }
        @CustomType.Setter
        public Builder emailAddresses(@Nullable List<String> emailAddresses) {

            this.emailAddresses = emailAddresses;
            return this;
        }
        public Builder emailAddresses(String... emailAddresses) {
            return emailAddresses(List.of(emailAddresses));
        }
        @CustomType.Setter
        public Builder phoneNumbers(@Nullable List<String> phoneNumbers) {

            this.phoneNumbers = phoneNumbers;
            return this;
        }
        public Builder phoneNumbers(String... phoneNumbers) {
            return phoneNumbers(List.of(phoneNumbers));
        }
        public DomainRuleBasedMatchingAttributeTypesSelector build() {
            final var _resultValue = new DomainRuleBasedMatchingAttributeTypesSelector();
            _resultValue.addresses = addresses;
            _resultValue.attributeMatchingModel = attributeMatchingModel;
            _resultValue.emailAddresses = emailAddresses;
            _resultValue.phoneNumbers = phoneNumbers;
            return _resultValue;
        }
    }
}
