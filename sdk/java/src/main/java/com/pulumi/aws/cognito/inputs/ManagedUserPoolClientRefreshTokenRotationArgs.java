// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cognito.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ManagedUserPoolClientRefreshTokenRotationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ManagedUserPoolClientRefreshTokenRotationArgs Empty = new ManagedUserPoolClientRefreshTokenRotationArgs();

    /**
     * The state of refresh token rotation for the current app client. Valid values are `ENABLED` or `DISABLED`.
     * 
     */
    @Import(name="feature", required=true)
    private Output<String> feature;

    /**
     * @return The state of refresh token rotation for the current app client. Valid values are `ENABLED` or `DISABLED`.
     * 
     */
    public Output<String> feature() {
        return this.feature;
    }

    /**
     * A period of time in seconds that the user has to use the old refresh token before it is invalidated. Valid values are between `0` and `60`.
     * 
     */
    @Import(name="retryGracePeriodSeconds")
    private @Nullable Output<Integer> retryGracePeriodSeconds;

    /**
     * @return A period of time in seconds that the user has to use the old refresh token before it is invalidated. Valid values are between `0` and `60`.
     * 
     */
    public Optional<Output<Integer>> retryGracePeriodSeconds() {
        return Optional.ofNullable(this.retryGracePeriodSeconds);
    }

    private ManagedUserPoolClientRefreshTokenRotationArgs() {}

    private ManagedUserPoolClientRefreshTokenRotationArgs(ManagedUserPoolClientRefreshTokenRotationArgs $) {
        this.feature = $.feature;
        this.retryGracePeriodSeconds = $.retryGracePeriodSeconds;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ManagedUserPoolClientRefreshTokenRotationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ManagedUserPoolClientRefreshTokenRotationArgs $;

        public Builder() {
            $ = new ManagedUserPoolClientRefreshTokenRotationArgs();
        }

        public Builder(ManagedUserPoolClientRefreshTokenRotationArgs defaults) {
            $ = new ManagedUserPoolClientRefreshTokenRotationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param feature The state of refresh token rotation for the current app client. Valid values are `ENABLED` or `DISABLED`.
         * 
         * @return builder
         * 
         */
        public Builder feature(Output<String> feature) {
            $.feature = feature;
            return this;
        }

        /**
         * @param feature The state of refresh token rotation for the current app client. Valid values are `ENABLED` or `DISABLED`.
         * 
         * @return builder
         * 
         */
        public Builder feature(String feature) {
            return feature(Output.of(feature));
        }

        /**
         * @param retryGracePeriodSeconds A period of time in seconds that the user has to use the old refresh token before it is invalidated. Valid values are between `0` and `60`.
         * 
         * @return builder
         * 
         */
        public Builder retryGracePeriodSeconds(@Nullable Output<Integer> retryGracePeriodSeconds) {
            $.retryGracePeriodSeconds = retryGracePeriodSeconds;
            return this;
        }

        /**
         * @param retryGracePeriodSeconds A period of time in seconds that the user has to use the old refresh token before it is invalidated. Valid values are between `0` and `60`.
         * 
         * @return builder
         * 
         */
        public Builder retryGracePeriodSeconds(Integer retryGracePeriodSeconds) {
            return retryGracePeriodSeconds(Output.of(retryGracePeriodSeconds));
        }

        public ManagedUserPoolClientRefreshTokenRotationArgs build() {
            if ($.feature == null) {
                throw new MissingRequiredPropertyException("ManagedUserPoolClientRefreshTokenRotationArgs", "feature");
            }
            return $;
        }
    }

}
