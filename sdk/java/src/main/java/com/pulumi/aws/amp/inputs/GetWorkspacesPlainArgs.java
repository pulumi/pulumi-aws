// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.amp.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetWorkspacesPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetWorkspacesPlainArgs Empty = new GetWorkspacesPlainArgs();

    /**
     * Limits results to workspaces with aliases that begin with this value.
     * 
     */
    @Import(name="aliasPrefix")
    private @Nullable String aliasPrefix;

    /**
     * @return Limits results to workspaces with aliases that begin with this value.
     * 
     */
    public Optional<String> aliasPrefix() {
        return Optional.ofNullable(this.aliasPrefix);
    }

    private GetWorkspacesPlainArgs() {}

    private GetWorkspacesPlainArgs(GetWorkspacesPlainArgs $) {
        this.aliasPrefix = $.aliasPrefix;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetWorkspacesPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetWorkspacesPlainArgs $;

        public Builder() {
            $ = new GetWorkspacesPlainArgs();
        }

        public Builder(GetWorkspacesPlainArgs defaults) {
            $ = new GetWorkspacesPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param aliasPrefix Limits results to workspaces with aliases that begin with this value.
         * 
         * @return builder
         * 
         */
        public Builder aliasPrefix(@Nullable String aliasPrefix) {
            $.aliasPrefix = aliasPrefix;
            return this;
        }

        public GetWorkspacesPlainArgs build() {
            return $;
        }
    }

}
