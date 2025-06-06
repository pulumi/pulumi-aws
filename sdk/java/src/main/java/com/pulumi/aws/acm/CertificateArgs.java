// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.acm;

import com.pulumi.aws.acm.inputs.CertificateOptionsArgs;
import com.pulumi.aws.acm.inputs.CertificateValidationOptionArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CertificateArgs extends com.pulumi.resources.ResourceArgs {

    public static final CertificateArgs Empty = new CertificateArgs();

    /**
     * ARN of an ACM PCA
     * 
     */
    @Import(name="certificateAuthorityArn")
    private @Nullable Output<String> certificateAuthorityArn;

    /**
     * @return ARN of an ACM PCA
     * 
     */
    public Optional<Output<String>> certificateAuthorityArn() {
        return Optional.ofNullable(this.certificateAuthorityArn);
    }

    /**
     * Certificate&#39;s PEM-formatted public key
     * 
     */
    @Import(name="certificateBody")
    private @Nullable Output<String> certificateBody;

    /**
     * @return Certificate&#39;s PEM-formatted public key
     * 
     */
    public Optional<Output<String>> certificateBody() {
        return Optional.ofNullable(this.certificateBody);
    }

    /**
     * Certificate&#39;s PEM-formatted chain
     * * Creating a private CA issued certificate
     * 
     */
    @Import(name="certificateChain")
    private @Nullable Output<String> certificateChain;

    /**
     * @return Certificate&#39;s PEM-formatted chain
     * * Creating a private CA issued certificate
     * 
     */
    public Optional<Output<String>> certificateChain() {
        return Optional.ofNullable(this.certificateChain);
    }

    /**
     * Fully qualified domain name (FQDN) in the certificate.
     * 
     */
    @Import(name="domainName")
    private @Nullable Output<String> domainName;

    /**
     * @return Fully qualified domain name (FQDN) in the certificate.
     * 
     */
    public Optional<Output<String>> domainName() {
        return Optional.ofNullable(this.domainName);
    }

    /**
     * Amount of time to start automatic renewal process before expiration.
     * Has no effect if less than 60 days.
     * Represented by either
     * a subset of [RFC 3339 duration](https://www.rfc-editor.org/rfc/rfc3339) supporting years, months, and days (e.g., `P90D`),
     * or a string such as `2160h`.
     * 
     */
    @Import(name="earlyRenewalDuration")
    private @Nullable Output<String> earlyRenewalDuration;

    /**
     * @return Amount of time to start automatic renewal process before expiration.
     * Has no effect if less than 60 days.
     * Represented by either
     * a subset of [RFC 3339 duration](https://www.rfc-editor.org/rfc/rfc3339) supporting years, months, and days (e.g., `P90D`),
     * or a string such as `2160h`.
     * 
     */
    public Optional<Output<String>> earlyRenewalDuration() {
        return Optional.ofNullable(this.earlyRenewalDuration);
    }

    /**
     * Specifies the algorithm of the public and private key pair that your Amazon issued certificate uses to encrypt data. See [ACM Certificate characteristics](https://docs.aws.amazon.com/acm/latest/userguide/acm-certificate.html#algorithms) for more details.
     * 
     */
    @Import(name="keyAlgorithm")
    private @Nullable Output<String> keyAlgorithm;

    /**
     * @return Specifies the algorithm of the public and private key pair that your Amazon issued certificate uses to encrypt data. See [ACM Certificate characteristics](https://docs.aws.amazon.com/acm/latest/userguide/acm-certificate.html#algorithms) for more details.
     * 
     */
    public Optional<Output<String>> keyAlgorithm() {
        return Optional.ofNullable(this.keyAlgorithm);
    }

    /**
     * Configuration block used to set certificate options. Detailed below.
     * 
     */
    @Import(name="options")
    private @Nullable Output<CertificateOptionsArgs> options;

    /**
     * @return Configuration block used to set certificate options. Detailed below.
     * 
     */
    public Optional<Output<CertificateOptionsArgs>> options() {
        return Optional.ofNullable(this.options);
    }

    /**
     * Certificate&#39;s PEM-formatted private key
     * 
     */
    @Import(name="privateKey")
    private @Nullable Output<String> privateKey;

    /**
     * @return Certificate&#39;s PEM-formatted private key
     * 
     */
    public Optional<Output<String>> privateKey() {
        return Optional.ofNullable(this.privateKey);
    }

    /**
     * Set of domains that should be SANs in the issued certificate.  To remove all elements of a previously configured list, set this value equal to an empty list (`[]`).
     * 
     */
    @Import(name="subjectAlternativeNames")
    private @Nullable Output<List<String>> subjectAlternativeNames;

    /**
     * @return Set of domains that should be SANs in the issued certificate.  To remove all elements of a previously configured list, set this value equal to an empty list (`[]`).
     * 
     */
    public Optional<Output<List<String>>> subjectAlternativeNames() {
        return Optional.ofNullable(this.subjectAlternativeNames);
    }

    /**
     * Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Which method to use for validation. `DNS` or `EMAIL` are valid. This parameter must not be set for certificates that were imported into ACM and then into Pulumi.
     * 
     */
    @Import(name="validationMethod")
    private @Nullable Output<String> validationMethod;

    /**
     * @return Which method to use for validation. `DNS` or `EMAIL` are valid. This parameter must not be set for certificates that were imported into ACM and then into Pulumi.
     * 
     */
    public Optional<Output<String>> validationMethod() {
        return Optional.ofNullable(this.validationMethod);
    }

    /**
     * Configuration block used to specify information about the initial validation of each domain name. Detailed below.
     * * Importing an existing certificate
     * 
     */
    @Import(name="validationOptions")
    private @Nullable Output<List<CertificateValidationOptionArgs>> validationOptions;

    /**
     * @return Configuration block used to specify information about the initial validation of each domain name. Detailed below.
     * * Importing an existing certificate
     * 
     */
    public Optional<Output<List<CertificateValidationOptionArgs>>> validationOptions() {
        return Optional.ofNullable(this.validationOptions);
    }

    private CertificateArgs() {}

    private CertificateArgs(CertificateArgs $) {
        this.certificateAuthorityArn = $.certificateAuthorityArn;
        this.certificateBody = $.certificateBody;
        this.certificateChain = $.certificateChain;
        this.domainName = $.domainName;
        this.earlyRenewalDuration = $.earlyRenewalDuration;
        this.keyAlgorithm = $.keyAlgorithm;
        this.options = $.options;
        this.privateKey = $.privateKey;
        this.subjectAlternativeNames = $.subjectAlternativeNames;
        this.tags = $.tags;
        this.validationMethod = $.validationMethod;
        this.validationOptions = $.validationOptions;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CertificateArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CertificateArgs $;

        public Builder() {
            $ = new CertificateArgs();
        }

        public Builder(CertificateArgs defaults) {
            $ = new CertificateArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param certificateAuthorityArn ARN of an ACM PCA
         * 
         * @return builder
         * 
         */
        public Builder certificateAuthorityArn(@Nullable Output<String> certificateAuthorityArn) {
            $.certificateAuthorityArn = certificateAuthorityArn;
            return this;
        }

        /**
         * @param certificateAuthorityArn ARN of an ACM PCA
         * 
         * @return builder
         * 
         */
        public Builder certificateAuthorityArn(String certificateAuthorityArn) {
            return certificateAuthorityArn(Output.of(certificateAuthorityArn));
        }

        /**
         * @param certificateBody Certificate&#39;s PEM-formatted public key
         * 
         * @return builder
         * 
         */
        public Builder certificateBody(@Nullable Output<String> certificateBody) {
            $.certificateBody = certificateBody;
            return this;
        }

        /**
         * @param certificateBody Certificate&#39;s PEM-formatted public key
         * 
         * @return builder
         * 
         */
        public Builder certificateBody(String certificateBody) {
            return certificateBody(Output.of(certificateBody));
        }

        /**
         * @param certificateChain Certificate&#39;s PEM-formatted chain
         * * Creating a private CA issued certificate
         * 
         * @return builder
         * 
         */
        public Builder certificateChain(@Nullable Output<String> certificateChain) {
            $.certificateChain = certificateChain;
            return this;
        }

        /**
         * @param certificateChain Certificate&#39;s PEM-formatted chain
         * * Creating a private CA issued certificate
         * 
         * @return builder
         * 
         */
        public Builder certificateChain(String certificateChain) {
            return certificateChain(Output.of(certificateChain));
        }

        /**
         * @param domainName Fully qualified domain name (FQDN) in the certificate.
         * 
         * @return builder
         * 
         */
        public Builder domainName(@Nullable Output<String> domainName) {
            $.domainName = domainName;
            return this;
        }

        /**
         * @param domainName Fully qualified domain name (FQDN) in the certificate.
         * 
         * @return builder
         * 
         */
        public Builder domainName(String domainName) {
            return domainName(Output.of(domainName));
        }

        /**
         * @param earlyRenewalDuration Amount of time to start automatic renewal process before expiration.
         * Has no effect if less than 60 days.
         * Represented by either
         * a subset of [RFC 3339 duration](https://www.rfc-editor.org/rfc/rfc3339) supporting years, months, and days (e.g., `P90D`),
         * or a string such as `2160h`.
         * 
         * @return builder
         * 
         */
        public Builder earlyRenewalDuration(@Nullable Output<String> earlyRenewalDuration) {
            $.earlyRenewalDuration = earlyRenewalDuration;
            return this;
        }

        /**
         * @param earlyRenewalDuration Amount of time to start automatic renewal process before expiration.
         * Has no effect if less than 60 days.
         * Represented by either
         * a subset of [RFC 3339 duration](https://www.rfc-editor.org/rfc/rfc3339) supporting years, months, and days (e.g., `P90D`),
         * or a string such as `2160h`.
         * 
         * @return builder
         * 
         */
        public Builder earlyRenewalDuration(String earlyRenewalDuration) {
            return earlyRenewalDuration(Output.of(earlyRenewalDuration));
        }

        /**
         * @param keyAlgorithm Specifies the algorithm of the public and private key pair that your Amazon issued certificate uses to encrypt data. See [ACM Certificate characteristics](https://docs.aws.amazon.com/acm/latest/userguide/acm-certificate.html#algorithms) for more details.
         * 
         * @return builder
         * 
         */
        public Builder keyAlgorithm(@Nullable Output<String> keyAlgorithm) {
            $.keyAlgorithm = keyAlgorithm;
            return this;
        }

        /**
         * @param keyAlgorithm Specifies the algorithm of the public and private key pair that your Amazon issued certificate uses to encrypt data. See [ACM Certificate characteristics](https://docs.aws.amazon.com/acm/latest/userguide/acm-certificate.html#algorithms) for more details.
         * 
         * @return builder
         * 
         */
        public Builder keyAlgorithm(String keyAlgorithm) {
            return keyAlgorithm(Output.of(keyAlgorithm));
        }

        /**
         * @param options Configuration block used to set certificate options. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder options(@Nullable Output<CertificateOptionsArgs> options) {
            $.options = options;
            return this;
        }

        /**
         * @param options Configuration block used to set certificate options. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder options(CertificateOptionsArgs options) {
            return options(Output.of(options));
        }

        /**
         * @param privateKey Certificate&#39;s PEM-formatted private key
         * 
         * @return builder
         * 
         */
        public Builder privateKey(@Nullable Output<String> privateKey) {
            $.privateKey = privateKey;
            return this;
        }

        /**
         * @param privateKey Certificate&#39;s PEM-formatted private key
         * 
         * @return builder
         * 
         */
        public Builder privateKey(String privateKey) {
            return privateKey(Output.of(privateKey));
        }

        /**
         * @param subjectAlternativeNames Set of domains that should be SANs in the issued certificate.  To remove all elements of a previously configured list, set this value equal to an empty list (`[]`).
         * 
         * @return builder
         * 
         */
        public Builder subjectAlternativeNames(@Nullable Output<List<String>> subjectAlternativeNames) {
            $.subjectAlternativeNames = subjectAlternativeNames;
            return this;
        }

        /**
         * @param subjectAlternativeNames Set of domains that should be SANs in the issued certificate.  To remove all elements of a previously configured list, set this value equal to an empty list (`[]`).
         * 
         * @return builder
         * 
         */
        public Builder subjectAlternativeNames(List<String> subjectAlternativeNames) {
            return subjectAlternativeNames(Output.of(subjectAlternativeNames));
        }

        /**
         * @param subjectAlternativeNames Set of domains that should be SANs in the issued certificate.  To remove all elements of a previously configured list, set this value equal to an empty list (`[]`).
         * 
         * @return builder
         * 
         */
        public Builder subjectAlternativeNames(String... subjectAlternativeNames) {
            return subjectAlternativeNames(List.of(subjectAlternativeNames));
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param validationMethod Which method to use for validation. `DNS` or `EMAIL` are valid. This parameter must not be set for certificates that were imported into ACM and then into Pulumi.
         * 
         * @return builder
         * 
         */
        public Builder validationMethod(@Nullable Output<String> validationMethod) {
            $.validationMethod = validationMethod;
            return this;
        }

        /**
         * @param validationMethod Which method to use for validation. `DNS` or `EMAIL` are valid. This parameter must not be set for certificates that were imported into ACM and then into Pulumi.
         * 
         * @return builder
         * 
         */
        public Builder validationMethod(String validationMethod) {
            return validationMethod(Output.of(validationMethod));
        }

        /**
         * @param validationOptions Configuration block used to specify information about the initial validation of each domain name. Detailed below.
         * * Importing an existing certificate
         * 
         * @return builder
         * 
         */
        public Builder validationOptions(@Nullable Output<List<CertificateValidationOptionArgs>> validationOptions) {
            $.validationOptions = validationOptions;
            return this;
        }

        /**
         * @param validationOptions Configuration block used to specify information about the initial validation of each domain name. Detailed below.
         * * Importing an existing certificate
         * 
         * @return builder
         * 
         */
        public Builder validationOptions(List<CertificateValidationOptionArgs> validationOptions) {
            return validationOptions(Output.of(validationOptions));
        }

        /**
         * @param validationOptions Configuration block used to specify information about the initial validation of each domain name. Detailed below.
         * * Importing an existing certificate
         * 
         * @return builder
         * 
         */
        public Builder validationOptions(CertificateValidationOptionArgs... validationOptions) {
            return validationOptions(List.of(validationOptions));
        }

        public CertificateArgs build() {
            return $;
        }
    }

}
