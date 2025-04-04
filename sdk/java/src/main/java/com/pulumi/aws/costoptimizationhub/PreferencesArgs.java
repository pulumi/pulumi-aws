// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.costoptimizationhub;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PreferencesArgs extends com.pulumi.resources.ResourceArgs {

    public static final PreferencesArgs Empty = new PreferencesArgs();

    /**
     * Customize whether the member accounts can see the &#34;After Discounts&#34; savings estimates. Valid values are `All` and `None`. Default value is `All`.
     * 
     */
    @Import(name="memberAccountDiscountVisibility")
    private @Nullable Output<String> memberAccountDiscountVisibility;

    /**
     * @return Customize whether the member accounts can see the &#34;After Discounts&#34; savings estimates. Valid values are `All` and `None`. Default value is `All`.
     * 
     */
    public Optional<Output<String>> memberAccountDiscountVisibility() {
        return Optional.ofNullable(this.memberAccountDiscountVisibility);
    }

    /**
     * Customize how estimated monthly savings are calculated. Valid values are `BeforeDiscounts` and `AfterDiscounts`. Default value is `BeforeDiscounts`.
     * 
     */
    @Import(name="savingsEstimationMode")
    private @Nullable Output<String> savingsEstimationMode;

    /**
     * @return Customize how estimated monthly savings are calculated. Valid values are `BeforeDiscounts` and `AfterDiscounts`. Default value is `BeforeDiscounts`.
     * 
     */
    public Optional<Output<String>> savingsEstimationMode() {
        return Optional.ofNullable(this.savingsEstimationMode);
    }

    private PreferencesArgs() {}

    private PreferencesArgs(PreferencesArgs $) {
        this.memberAccountDiscountVisibility = $.memberAccountDiscountVisibility;
        this.savingsEstimationMode = $.savingsEstimationMode;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PreferencesArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PreferencesArgs $;

        public Builder() {
            $ = new PreferencesArgs();
        }

        public Builder(PreferencesArgs defaults) {
            $ = new PreferencesArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param memberAccountDiscountVisibility Customize whether the member accounts can see the &#34;After Discounts&#34; savings estimates. Valid values are `All` and `None`. Default value is `All`.
         * 
         * @return builder
         * 
         */
        public Builder memberAccountDiscountVisibility(@Nullable Output<String> memberAccountDiscountVisibility) {
            $.memberAccountDiscountVisibility = memberAccountDiscountVisibility;
            return this;
        }

        /**
         * @param memberAccountDiscountVisibility Customize whether the member accounts can see the &#34;After Discounts&#34; savings estimates. Valid values are `All` and `None`. Default value is `All`.
         * 
         * @return builder
         * 
         */
        public Builder memberAccountDiscountVisibility(String memberAccountDiscountVisibility) {
            return memberAccountDiscountVisibility(Output.of(memberAccountDiscountVisibility));
        }

        /**
         * @param savingsEstimationMode Customize how estimated monthly savings are calculated. Valid values are `BeforeDiscounts` and `AfterDiscounts`. Default value is `BeforeDiscounts`.
         * 
         * @return builder
         * 
         */
        public Builder savingsEstimationMode(@Nullable Output<String> savingsEstimationMode) {
            $.savingsEstimationMode = savingsEstimationMode;
            return this;
        }

        /**
         * @param savingsEstimationMode Customize how estimated monthly savings are calculated. Valid values are `BeforeDiscounts` and `AfterDiscounts`. Default value is `BeforeDiscounts`.
         * 
         * @return builder
         * 
         */
        public Builder savingsEstimationMode(String savingsEstimationMode) {
            return savingsEstimationMode(Output.of(savingsEstimationMode));
        }

        public PreferencesArgs build() {
            return $;
        }
    }

}
