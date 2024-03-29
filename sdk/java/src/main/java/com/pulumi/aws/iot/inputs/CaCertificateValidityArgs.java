// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iot.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CaCertificateValidityArgs extends com.pulumi.resources.ResourceArgs {

    public static final CaCertificateValidityArgs Empty = new CaCertificateValidityArgs();

    /**
     * The certificate is not valid after this date.
     * 
     */
    @Import(name="notAfter")
    private @Nullable Output<String> notAfter;

    /**
     * @return The certificate is not valid after this date.
     * 
     */
    public Optional<Output<String>> notAfter() {
        return Optional.ofNullable(this.notAfter);
    }

    /**
     * The certificate is not valid before this date.
     * 
     */
    @Import(name="notBefore")
    private @Nullable Output<String> notBefore;

    /**
     * @return The certificate is not valid before this date.
     * 
     */
    public Optional<Output<String>> notBefore() {
        return Optional.ofNullable(this.notBefore);
    }

    private CaCertificateValidityArgs() {}

    private CaCertificateValidityArgs(CaCertificateValidityArgs $) {
        this.notAfter = $.notAfter;
        this.notBefore = $.notBefore;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CaCertificateValidityArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CaCertificateValidityArgs $;

        public Builder() {
            $ = new CaCertificateValidityArgs();
        }

        public Builder(CaCertificateValidityArgs defaults) {
            $ = new CaCertificateValidityArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param notAfter The certificate is not valid after this date.
         * 
         * @return builder
         * 
         */
        public Builder notAfter(@Nullable Output<String> notAfter) {
            $.notAfter = notAfter;
            return this;
        }

        /**
         * @param notAfter The certificate is not valid after this date.
         * 
         * @return builder
         * 
         */
        public Builder notAfter(String notAfter) {
            return notAfter(Output.of(notAfter));
        }

        /**
         * @param notBefore The certificate is not valid before this date.
         * 
         * @return builder
         * 
         */
        public Builder notBefore(@Nullable Output<String> notBefore) {
            $.notBefore = notBefore;
            return this;
        }

        /**
         * @param notBefore The certificate is not valid before this date.
         * 
         * @return builder
         * 
         */
        public Builder notBefore(String notBefore) {
            return notBefore(Output.of(notBefore));
        }

        public CaCertificateValidityArgs build() {
            return $;
        }
    }

}
