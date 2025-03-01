// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.amplify.inputs;

import com.pulumi.aws.amplify.inputs.DomainAssociationCertificateSettingsArgs;
import com.pulumi.aws.amplify.inputs.DomainAssociationSubDomainArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DomainAssociationState extends com.pulumi.resources.ResourceArgs {

    public static final DomainAssociationState Empty = new DomainAssociationState();

    /**
     * Unique ID for an Amplify app.
     * 
     */
    @Import(name="appId")
    private @Nullable Output<String> appId;

    /**
     * @return Unique ID for an Amplify app.
     * 
     */
    public Optional<Output<String>> appId() {
        return Optional.ofNullable(this.appId);
    }

    /**
     * ARN for the domain association.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN for the domain association.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * The type of SSL/TLS certificate to use for your custom domain. If you don&#39;t specify a certificate type, Amplify uses the default certificate that it provisions and manages for you.
     * 
     */
    @Import(name="certificateSettings")
    private @Nullable Output<DomainAssociationCertificateSettingsArgs> certificateSettings;

    /**
     * @return The type of SSL/TLS certificate to use for your custom domain. If you don&#39;t specify a certificate type, Amplify uses the default certificate that it provisions and manages for you.
     * 
     */
    public Optional<Output<DomainAssociationCertificateSettingsArgs>> certificateSettings() {
        return Optional.ofNullable(this.certificateSettings);
    }

    /**
     * DNS records for certificate verification in a space-delimited format (`&lt;record&gt; CNAME &lt;target&gt;`).
     * 
     */
    @Import(name="certificateVerificationDnsRecord")
    private @Nullable Output<String> certificateVerificationDnsRecord;

    /**
     * @return DNS records for certificate verification in a space-delimited format (`&lt;record&gt; CNAME &lt;target&gt;`).
     * 
     */
    public Optional<Output<String>> certificateVerificationDnsRecord() {
        return Optional.ofNullable(this.certificateVerificationDnsRecord);
    }

    /**
     * Domain name for the domain association.
     * 
     */
    @Import(name="domainName")
    private @Nullable Output<String> domainName;

    /**
     * @return Domain name for the domain association.
     * 
     */
    public Optional<Output<String>> domainName() {
        return Optional.ofNullable(this.domainName);
    }

    /**
     * Enables the automated creation of subdomains for branches.
     * 
     */
    @Import(name="enableAutoSubDomain")
    private @Nullable Output<Boolean> enableAutoSubDomain;

    /**
     * @return Enables the automated creation of subdomains for branches.
     * 
     */
    public Optional<Output<Boolean>> enableAutoSubDomain() {
        return Optional.ofNullable(this.enableAutoSubDomain);
    }

    /**
     * Setting for the subdomain. Documented below.
     * 
     */
    @Import(name="subDomains")
    private @Nullable Output<List<DomainAssociationSubDomainArgs>> subDomains;

    /**
     * @return Setting for the subdomain. Documented below.
     * 
     */
    public Optional<Output<List<DomainAssociationSubDomainArgs>>> subDomains() {
        return Optional.ofNullable(this.subDomains);
    }

    /**
     * If enabled, the resource will wait for the domain association status to change to `PENDING_DEPLOYMENT` or `AVAILABLE`. Setting this to `false` will skip the process. Default: `true`.
     * 
     */
    @Import(name="waitForVerification")
    private @Nullable Output<Boolean> waitForVerification;

    /**
     * @return If enabled, the resource will wait for the domain association status to change to `PENDING_DEPLOYMENT` or `AVAILABLE`. Setting this to `false` will skip the process. Default: `true`.
     * 
     */
    public Optional<Output<Boolean>> waitForVerification() {
        return Optional.ofNullable(this.waitForVerification);
    }

    private DomainAssociationState() {}

    private DomainAssociationState(DomainAssociationState $) {
        this.appId = $.appId;
        this.arn = $.arn;
        this.certificateSettings = $.certificateSettings;
        this.certificateVerificationDnsRecord = $.certificateVerificationDnsRecord;
        this.domainName = $.domainName;
        this.enableAutoSubDomain = $.enableAutoSubDomain;
        this.subDomains = $.subDomains;
        this.waitForVerification = $.waitForVerification;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DomainAssociationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DomainAssociationState $;

        public Builder() {
            $ = new DomainAssociationState();
        }

        public Builder(DomainAssociationState defaults) {
            $ = new DomainAssociationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param appId Unique ID for an Amplify app.
         * 
         * @return builder
         * 
         */
        public Builder appId(@Nullable Output<String> appId) {
            $.appId = appId;
            return this;
        }

        /**
         * @param appId Unique ID for an Amplify app.
         * 
         * @return builder
         * 
         */
        public Builder appId(String appId) {
            return appId(Output.of(appId));
        }

        /**
         * @param arn ARN for the domain association.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN for the domain association.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param certificateSettings The type of SSL/TLS certificate to use for your custom domain. If you don&#39;t specify a certificate type, Amplify uses the default certificate that it provisions and manages for you.
         * 
         * @return builder
         * 
         */
        public Builder certificateSettings(@Nullable Output<DomainAssociationCertificateSettingsArgs> certificateSettings) {
            $.certificateSettings = certificateSettings;
            return this;
        }

        /**
         * @param certificateSettings The type of SSL/TLS certificate to use for your custom domain. If you don&#39;t specify a certificate type, Amplify uses the default certificate that it provisions and manages for you.
         * 
         * @return builder
         * 
         */
        public Builder certificateSettings(DomainAssociationCertificateSettingsArgs certificateSettings) {
            return certificateSettings(Output.of(certificateSettings));
        }

        /**
         * @param certificateVerificationDnsRecord DNS records for certificate verification in a space-delimited format (`&lt;record&gt; CNAME &lt;target&gt;`).
         * 
         * @return builder
         * 
         */
        public Builder certificateVerificationDnsRecord(@Nullable Output<String> certificateVerificationDnsRecord) {
            $.certificateVerificationDnsRecord = certificateVerificationDnsRecord;
            return this;
        }

        /**
         * @param certificateVerificationDnsRecord DNS records for certificate verification in a space-delimited format (`&lt;record&gt; CNAME &lt;target&gt;`).
         * 
         * @return builder
         * 
         */
        public Builder certificateVerificationDnsRecord(String certificateVerificationDnsRecord) {
            return certificateVerificationDnsRecord(Output.of(certificateVerificationDnsRecord));
        }

        /**
         * @param domainName Domain name for the domain association.
         * 
         * @return builder
         * 
         */
        public Builder domainName(@Nullable Output<String> domainName) {
            $.domainName = domainName;
            return this;
        }

        /**
         * @param domainName Domain name for the domain association.
         * 
         * @return builder
         * 
         */
        public Builder domainName(String domainName) {
            return domainName(Output.of(domainName));
        }

        /**
         * @param enableAutoSubDomain Enables the automated creation of subdomains for branches.
         * 
         * @return builder
         * 
         */
        public Builder enableAutoSubDomain(@Nullable Output<Boolean> enableAutoSubDomain) {
            $.enableAutoSubDomain = enableAutoSubDomain;
            return this;
        }

        /**
         * @param enableAutoSubDomain Enables the automated creation of subdomains for branches.
         * 
         * @return builder
         * 
         */
        public Builder enableAutoSubDomain(Boolean enableAutoSubDomain) {
            return enableAutoSubDomain(Output.of(enableAutoSubDomain));
        }

        /**
         * @param subDomains Setting for the subdomain. Documented below.
         * 
         * @return builder
         * 
         */
        public Builder subDomains(@Nullable Output<List<DomainAssociationSubDomainArgs>> subDomains) {
            $.subDomains = subDomains;
            return this;
        }

        /**
         * @param subDomains Setting for the subdomain. Documented below.
         * 
         * @return builder
         * 
         */
        public Builder subDomains(List<DomainAssociationSubDomainArgs> subDomains) {
            return subDomains(Output.of(subDomains));
        }

        /**
         * @param subDomains Setting for the subdomain. Documented below.
         * 
         * @return builder
         * 
         */
        public Builder subDomains(DomainAssociationSubDomainArgs... subDomains) {
            return subDomains(List.of(subDomains));
        }

        /**
         * @param waitForVerification If enabled, the resource will wait for the domain association status to change to `PENDING_DEPLOYMENT` or `AVAILABLE`. Setting this to `false` will skip the process. Default: `true`.
         * 
         * @return builder
         * 
         */
        public Builder waitForVerification(@Nullable Output<Boolean> waitForVerification) {
            $.waitForVerification = waitForVerification;
            return this;
        }

        /**
         * @param waitForVerification If enabled, the resource will wait for the domain association status to change to `PENDING_DEPLOYMENT` or `AVAILABLE`. Setting this to `false` will skip the process. Default: `true`.
         * 
         * @return builder
         * 
         */
        public Builder waitForVerification(Boolean waitForVerification) {
            return waitForVerification(Output.of(waitForVerification));
        }

        public DomainAssociationState build() {
            return $;
        }
    }

}
