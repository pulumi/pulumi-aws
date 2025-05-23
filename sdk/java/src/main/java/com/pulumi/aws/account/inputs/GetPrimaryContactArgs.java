// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.account.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetPrimaryContactArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetPrimaryContactArgs Empty = new GetPrimaryContactArgs();

    /**
     * The ID of the target account when managing member accounts. Will manage current user&#39;s account by default if omitted.
     * 
     */
    @Import(name="accountId")
    private @Nullable Output<String> accountId;

    /**
     * @return The ID of the target account when managing member accounts. Will manage current user&#39;s account by default if omitted.
     * 
     */
    public Optional<Output<String>> accountId() {
        return Optional.ofNullable(this.accountId);
    }

    private GetPrimaryContactArgs() {}

    private GetPrimaryContactArgs(GetPrimaryContactArgs $) {
        this.accountId = $.accountId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetPrimaryContactArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetPrimaryContactArgs $;

        public Builder() {
            $ = new GetPrimaryContactArgs();
        }

        public Builder(GetPrimaryContactArgs defaults) {
            $ = new GetPrimaryContactArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param accountId The ID of the target account when managing member accounts. Will manage current user&#39;s account by default if omitted.
         * 
         * @return builder
         * 
         */
        public Builder accountId(@Nullable Output<String> accountId) {
            $.accountId = accountId;
            return this;
        }

        /**
         * @param accountId The ID of the target account when managing member accounts. Will manage current user&#39;s account by default if omitted.
         * 
         * @return builder
         * 
         */
        public Builder accountId(String accountId) {
            return accountId(Output.of(accountId));
        }

        public GetPrimaryContactArgs build() {
            return $;
        }
    }

}
