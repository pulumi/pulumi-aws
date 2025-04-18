// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.acmpca.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CertificateAuthorityRevocationConfigurationOcspConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final CertificateAuthorityRevocationConfigurationOcspConfigurationArgs Empty = new CertificateAuthorityRevocationConfigurationOcspConfigurationArgs();

    /**
     * Boolean value that specifies whether a custom OCSP responder is enabled.
     * 
     */
    @Import(name="enabled", required=true)
    private Output<Boolean> enabled;

    /**
     * @return Boolean value that specifies whether a custom OCSP responder is enabled.
     * 
     */
    public Output<Boolean> enabled() {
        return this.enabled;
    }

    /**
     * CNAME specifying a customized OCSP domain. Note: The value of the CNAME must not include a protocol prefix such as &#34;http://&#34; or &#34;https://&#34;.
     * 
     */
    @Import(name="ocspCustomCname")
    private @Nullable Output<String> ocspCustomCname;

    /**
     * @return CNAME specifying a customized OCSP domain. Note: The value of the CNAME must not include a protocol prefix such as &#34;http://&#34; or &#34;https://&#34;.
     * 
     */
    public Optional<Output<String>> ocspCustomCname() {
        return Optional.ofNullable(this.ocspCustomCname);
    }

    private CertificateAuthorityRevocationConfigurationOcspConfigurationArgs() {}

    private CertificateAuthorityRevocationConfigurationOcspConfigurationArgs(CertificateAuthorityRevocationConfigurationOcspConfigurationArgs $) {
        this.enabled = $.enabled;
        this.ocspCustomCname = $.ocspCustomCname;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CertificateAuthorityRevocationConfigurationOcspConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CertificateAuthorityRevocationConfigurationOcspConfigurationArgs $;

        public Builder() {
            $ = new CertificateAuthorityRevocationConfigurationOcspConfigurationArgs();
        }

        public Builder(CertificateAuthorityRevocationConfigurationOcspConfigurationArgs defaults) {
            $ = new CertificateAuthorityRevocationConfigurationOcspConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param enabled Boolean value that specifies whether a custom OCSP responder is enabled.
         * 
         * @return builder
         * 
         */
        public Builder enabled(Output<Boolean> enabled) {
            $.enabled = enabled;
            return this;
        }

        /**
         * @param enabled Boolean value that specifies whether a custom OCSP responder is enabled.
         * 
         * @return builder
         * 
         */
        public Builder enabled(Boolean enabled) {
            return enabled(Output.of(enabled));
        }

        /**
         * @param ocspCustomCname CNAME specifying a customized OCSP domain. Note: The value of the CNAME must not include a protocol prefix such as &#34;http://&#34; or &#34;https://&#34;.
         * 
         * @return builder
         * 
         */
        public Builder ocspCustomCname(@Nullable Output<String> ocspCustomCname) {
            $.ocspCustomCname = ocspCustomCname;
            return this;
        }

        /**
         * @param ocspCustomCname CNAME specifying a customized OCSP domain. Note: The value of the CNAME must not include a protocol prefix such as &#34;http://&#34; or &#34;https://&#34;.
         * 
         * @return builder
         * 
         */
        public Builder ocspCustomCname(String ocspCustomCname) {
            return ocspCustomCname(Output.of(ocspCustomCname));
        }

        public CertificateAuthorityRevocationConfigurationOcspConfigurationArgs build() {
            if ($.enabled == null) {
                throw new MissingRequiredPropertyException("CertificateAuthorityRevocationConfigurationOcspConfigurationArgs", "enabled");
            }
            return $;
        }
    }

}
