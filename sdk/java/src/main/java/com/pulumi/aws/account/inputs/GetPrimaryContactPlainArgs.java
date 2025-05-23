// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.account.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetPrimaryContactPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetPrimaryContactPlainArgs Empty = new GetPrimaryContactPlainArgs();

    /**
     * The ID of the target account when managing member accounts. Will manage current user&#39;s account by default if omitted.
     * 
     */
    @Import(name="accountId")
    private @Nullable String accountId;

    /**
     * @return The ID of the target account when managing member accounts. Will manage current user&#39;s account by default if omitted.
     * 
     */
    public Optional<String> accountId() {
        return Optional.ofNullable(this.accountId);
    }

    private GetPrimaryContactPlainArgs() {}

    private GetPrimaryContactPlainArgs(GetPrimaryContactPlainArgs $) {
        this.accountId = $.accountId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetPrimaryContactPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetPrimaryContactPlainArgs $;

        public Builder() {
            $ = new GetPrimaryContactPlainArgs();
        }

        public Builder(GetPrimaryContactPlainArgs defaults) {
            $ = new GetPrimaryContactPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param accountId The ID of the target account when managing member accounts. Will manage current user&#39;s account by default if omitted.
         * 
         * @return builder
         * 
         */
        public Builder accountId(@Nullable String accountId) {
            $.accountId = accountId;
            return this;
        }

        public GetPrimaryContactPlainArgs build() {
            return $;
        }
    }

}
