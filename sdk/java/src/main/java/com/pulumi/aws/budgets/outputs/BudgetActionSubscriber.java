// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.budgets.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class BudgetActionSubscriber {
    /**
     * @return The address that AWS sends budget notifications to, either an SNS topic or an email.
     * 
     */
    private String address;
    /**
     * @return The type of notification that AWS sends to a subscriber. Valid values are `SNS` or `EMAIL`.
     * 
     */
    private String subscriptionType;

    private BudgetActionSubscriber() {}
    /**
     * @return The address that AWS sends budget notifications to, either an SNS topic or an email.
     * 
     */
    public String address() {
        return this.address;
    }
    /**
     * @return The type of notification that AWS sends to a subscriber. Valid values are `SNS` or `EMAIL`.
     * 
     */
    public String subscriptionType() {
        return this.subscriptionType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(BudgetActionSubscriber defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String address;
        private String subscriptionType;
        public Builder() {}
        public Builder(BudgetActionSubscriber defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.address = defaults.address;
    	      this.subscriptionType = defaults.subscriptionType;
        }

        @CustomType.Setter
        public Builder address(String address) {
            if (address == null) {
              throw new MissingRequiredPropertyException("BudgetActionSubscriber", "address");
            }
            this.address = address;
            return this;
        }
        @CustomType.Setter
        public Builder subscriptionType(String subscriptionType) {
            if (subscriptionType == null) {
              throw new MissingRequiredPropertyException("BudgetActionSubscriber", "subscriptionType");
            }
            this.subscriptionType = subscriptionType;
            return this;
        }
        public BudgetActionSubscriber build() {
            final var _resultValue = new BudgetActionSubscriber();
            _resultValue.address = address;
            _resultValue.subscriptionType = subscriptionType;
            return _resultValue;
        }
    }
}
