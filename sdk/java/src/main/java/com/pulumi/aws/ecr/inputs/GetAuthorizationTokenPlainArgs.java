// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecr.inputs;

import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetAuthorizationTokenPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetAuthorizationTokenPlainArgs Empty = new GetAuthorizationTokenPlainArgs();

    /**
     * AWS account ID of the ECR Repository. If not specified the default account is assumed.
     * 
     */
    @Import(name="registryId")
    private @Nullable String registryId;

    /**
     * @return AWS account ID of the ECR Repository. If not specified the default account is assumed.
     * 
     */
    public Optional<String> registryId() {
        return Optional.ofNullable(this.registryId);
    }

    private GetAuthorizationTokenPlainArgs() {}

    private GetAuthorizationTokenPlainArgs(GetAuthorizationTokenPlainArgs $) {
        this.registryId = $.registryId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetAuthorizationTokenPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetAuthorizationTokenPlainArgs $;

        public Builder() {
            $ = new GetAuthorizationTokenPlainArgs();
        }

        public Builder(GetAuthorizationTokenPlainArgs defaults) {
            $ = new GetAuthorizationTokenPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param registryId AWS account ID of the ECR Repository. If not specified the default account is assumed.
         * 
         * @return builder
         * 
         */
        public Builder registryId(@Nullable String registryId) {
            $.registryId = registryId;
            return this;
        }

        public GetAuthorizationTokenPlainArgs build() {
            return $;
        }
    }

}
