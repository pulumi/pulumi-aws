// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetCallerIdentityPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetCallerIdentityPlainArgs Empty = new GetCallerIdentityPlainArgs();

    /**
     * Account ID number of the account that owns or contains the calling entity.
     * 
     */
    @Import(name="id")
    private @Nullable String id;

    /**
     * @return Account ID number of the account that owns or contains the calling entity.
     * 
     */
    public Optional<String> id() {
        return Optional.ofNullable(this.id);
    }

    private GetCallerIdentityPlainArgs() {}

    private GetCallerIdentityPlainArgs(GetCallerIdentityPlainArgs $) {
        this.id = $.id;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetCallerIdentityPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetCallerIdentityPlainArgs $;

        public Builder() {
            $ = new GetCallerIdentityPlainArgs();
        }

        public Builder(GetCallerIdentityPlainArgs defaults) {
            $ = new GetCallerIdentityPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param id Account ID number of the account that owns or contains the calling entity.
         * 
         * @return builder
         * 
         */
        public Builder id(@Nullable String id) {
            $.id = id;
            return this;
        }

        public GetCallerIdentityPlainArgs build() {
            return $;
        }
    }

}
