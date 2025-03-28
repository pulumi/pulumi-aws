// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sesv2;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;


public final class AccountSuppressionAttributesArgs extends com.pulumi.resources.ResourceArgs {

    public static final AccountSuppressionAttributesArgs Empty = new AccountSuppressionAttributesArgs();

    /**
     * A list that contains the reasons that email addresses will be automatically added to the suppression list for your account. Valid values: `COMPLAINT`, `BOUNCE`.
     * 
     */
    @Import(name="suppressedReasons", required=true)
    private Output<List<String>> suppressedReasons;

    /**
     * @return A list that contains the reasons that email addresses will be automatically added to the suppression list for your account. Valid values: `COMPLAINT`, `BOUNCE`.
     * 
     */
    public Output<List<String>> suppressedReasons() {
        return this.suppressedReasons;
    }

    private AccountSuppressionAttributesArgs() {}

    private AccountSuppressionAttributesArgs(AccountSuppressionAttributesArgs $) {
        this.suppressedReasons = $.suppressedReasons;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AccountSuppressionAttributesArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AccountSuppressionAttributesArgs $;

        public Builder() {
            $ = new AccountSuppressionAttributesArgs();
        }

        public Builder(AccountSuppressionAttributesArgs defaults) {
            $ = new AccountSuppressionAttributesArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param suppressedReasons A list that contains the reasons that email addresses will be automatically added to the suppression list for your account. Valid values: `COMPLAINT`, `BOUNCE`.
         * 
         * @return builder
         * 
         */
        public Builder suppressedReasons(Output<List<String>> suppressedReasons) {
            $.suppressedReasons = suppressedReasons;
            return this;
        }

        /**
         * @param suppressedReasons A list that contains the reasons that email addresses will be automatically added to the suppression list for your account. Valid values: `COMPLAINT`, `BOUNCE`.
         * 
         * @return builder
         * 
         */
        public Builder suppressedReasons(List<String> suppressedReasons) {
            return suppressedReasons(Output.of(suppressedReasons));
        }

        /**
         * @param suppressedReasons A list that contains the reasons that email addresses will be automatically added to the suppression list for your account. Valid values: `COMPLAINT`, `BOUNCE`.
         * 
         * @return builder
         * 
         */
        public Builder suppressedReasons(String... suppressedReasons) {
            return suppressedReasons(List.of(suppressedReasons));
        }

        public AccountSuppressionAttributesArgs build() {
            if ($.suppressedReasons == null) {
                throw new MissingRequiredPropertyException("AccountSuppressionAttributesArgs", "suppressedReasons");
            }
            return $;
        }
    }

}
