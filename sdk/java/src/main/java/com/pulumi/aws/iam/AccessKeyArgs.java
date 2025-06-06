// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iam;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AccessKeyArgs extends com.pulumi.resources.ResourceArgs {

    public static final AccessKeyArgs Empty = new AccessKeyArgs();

    /**
     * Either a base-64 encoded PGP public key, or a keybase username in the form `keybase:some_person_that_exists`, for use in the `encrypted_secret` output attribute. If providing a base-64 encoded PGP public key, make sure to provide the &#34;raw&#34; version and not the &#34;armored&#34; one (e.g. avoid passing the `-a` option to `gpg --export`).
     * 
     */
    @Import(name="pgpKey")
    private @Nullable Output<String> pgpKey;

    /**
     * @return Either a base-64 encoded PGP public key, or a keybase username in the form `keybase:some_person_that_exists`, for use in the `encrypted_secret` output attribute. If providing a base-64 encoded PGP public key, make sure to provide the &#34;raw&#34; version and not the &#34;armored&#34; one (e.g. avoid passing the `-a` option to `gpg --export`).
     * 
     */
    public Optional<Output<String>> pgpKey() {
        return Optional.ofNullable(this.pgpKey);
    }

    /**
     * Access key status to apply. Defaults to `Active`. Valid values are `Active` and `Inactive`.
     * 
     */
    @Import(name="status")
    private @Nullable Output<String> status;

    /**
     * @return Access key status to apply. Defaults to `Active`. Valid values are `Active` and `Inactive`.
     * 
     */
    public Optional<Output<String>> status() {
        return Optional.ofNullable(this.status);
    }

    /**
     * IAM user to associate with this access key.
     * 
     */
    @Import(name="user", required=true)
    private Output<String> user;

    /**
     * @return IAM user to associate with this access key.
     * 
     */
    public Output<String> user() {
        return this.user;
    }

    private AccessKeyArgs() {}

    private AccessKeyArgs(AccessKeyArgs $) {
        this.pgpKey = $.pgpKey;
        this.status = $.status;
        this.user = $.user;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AccessKeyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AccessKeyArgs $;

        public Builder() {
            $ = new AccessKeyArgs();
        }

        public Builder(AccessKeyArgs defaults) {
            $ = new AccessKeyArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param pgpKey Either a base-64 encoded PGP public key, or a keybase username in the form `keybase:some_person_that_exists`, for use in the `encrypted_secret` output attribute. If providing a base-64 encoded PGP public key, make sure to provide the &#34;raw&#34; version and not the &#34;armored&#34; one (e.g. avoid passing the `-a` option to `gpg --export`).
         * 
         * @return builder
         * 
         */
        public Builder pgpKey(@Nullable Output<String> pgpKey) {
            $.pgpKey = pgpKey;
            return this;
        }

        /**
         * @param pgpKey Either a base-64 encoded PGP public key, or a keybase username in the form `keybase:some_person_that_exists`, for use in the `encrypted_secret` output attribute. If providing a base-64 encoded PGP public key, make sure to provide the &#34;raw&#34; version and not the &#34;armored&#34; one (e.g. avoid passing the `-a` option to `gpg --export`).
         * 
         * @return builder
         * 
         */
        public Builder pgpKey(String pgpKey) {
            return pgpKey(Output.of(pgpKey));
        }

        /**
         * @param status Access key status to apply. Defaults to `Active`. Valid values are `Active` and `Inactive`.
         * 
         * @return builder
         * 
         */
        public Builder status(@Nullable Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status Access key status to apply. Defaults to `Active`. Valid values are `Active` and `Inactive`.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        /**
         * @param user IAM user to associate with this access key.
         * 
         * @return builder
         * 
         */
        public Builder user(Output<String> user) {
            $.user = user;
            return this;
        }

        /**
         * @param user IAM user to associate with this access key.
         * 
         * @return builder
         * 
         */
        public Builder user(String user) {
            return user(Output.of(user));
        }

        public AccessKeyArgs build() {
            if ($.user == null) {
                throw new MissingRequiredPropertyException("AccessKeyArgs", "user");
            }
            return $;
        }
    }

}
