// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.inputs;

import com.pulumi.aws.networkfirewall.inputs.TlsInspectionConfigurationCertificateArgs;
import com.pulumi.aws.networkfirewall.inputs.TlsInspectionConfigurationCertificateAuthorityArgs;
import com.pulumi.aws.networkfirewall.inputs.TlsInspectionConfigurationEncryptionConfigurationArgs;
import com.pulumi.aws.networkfirewall.inputs.TlsInspectionConfigurationTimeoutsArgs;
import com.pulumi.aws.networkfirewall.inputs.TlsInspectionConfigurationTlsInspectionConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TlsInspectionConfigurationState extends com.pulumi.resources.ResourceArgs {

    public static final TlsInspectionConfigurationState Empty = new TlsInspectionConfigurationState();

    /**
     * ARN of the TLS Inspection Configuration.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the TLS Inspection Configuration.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Certificate Manager certificate block. See Certificate Authority below for details.
     * 
     */
    @Import(name="certificateAuthorities")
    private @Nullable Output<List<TlsInspectionConfigurationCertificateAuthorityArgs>> certificateAuthorities;

    /**
     * @return Certificate Manager certificate block. See Certificate Authority below for details.
     * 
     */
    public Optional<Output<List<TlsInspectionConfigurationCertificateAuthorityArgs>>> certificateAuthorities() {
        return Optional.ofNullable(this.certificateAuthorities);
    }

    /**
     * List of certificate blocks describing certificates associated with the TLS inspection configuration. See Certificates below for details.
     * 
     */
    @Import(name="certificates")
    private @Nullable Output<List<TlsInspectionConfigurationCertificateArgs>> certificates;

    /**
     * @return List of certificate blocks describing certificates associated with the TLS inspection configuration. See Certificates below for details.
     * 
     */
    public Optional<Output<List<TlsInspectionConfigurationCertificateArgs>>> certificates() {
        return Optional.ofNullable(this.certificates);
    }

    /**
     * Description of the TLS inspection configuration.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Description of the TLS inspection configuration.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Encryption configuration block. Detailed below.
     * 
     */
    @Import(name="encryptionConfigurations")
    private @Nullable Output<List<TlsInspectionConfigurationEncryptionConfigurationArgs>> encryptionConfigurations;

    /**
     * @return Encryption configuration block. Detailed below.
     * 
     */
    public Optional<Output<List<TlsInspectionConfigurationEncryptionConfigurationArgs>>> encryptionConfigurations() {
        return Optional.ofNullable(this.encryptionConfigurations);
    }

    /**
     * Descriptive name of the TLS inspection configuration.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Descriptive name of the TLS inspection configuration.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Number of firewall policies that use this TLS inspection configuration.
     * 
     */
    @Import(name="numberOfAssociations")
    private @Nullable Output<Integer> numberOfAssociations;

    /**
     * @return Number of firewall policies that use this TLS inspection configuration.
     * 
     */
    public Optional<Output<Integer>> numberOfAssociations() {
        return Optional.ofNullable(this.numberOfAssociations);
    }

    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    @Import(name="timeouts")
    private @Nullable Output<TlsInspectionConfigurationTimeoutsArgs> timeouts;

    public Optional<Output<TlsInspectionConfigurationTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * TLS inspection configuration block. Detailed below.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="tlsInspectionConfiguration")
    private @Nullable Output<TlsInspectionConfigurationTlsInspectionConfigurationArgs> tlsInspectionConfiguration;

    /**
     * @return TLS inspection configuration block. Detailed below.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<TlsInspectionConfigurationTlsInspectionConfigurationArgs>> tlsInspectionConfiguration() {
        return Optional.ofNullable(this.tlsInspectionConfiguration);
    }

    /**
     * A unique identifier for the TLS inspection configuration.
     * 
     */
    @Import(name="tlsInspectionConfigurationId")
    private @Nullable Output<String> tlsInspectionConfigurationId;

    /**
     * @return A unique identifier for the TLS inspection configuration.
     * 
     */
    public Optional<Output<String>> tlsInspectionConfigurationId() {
        return Optional.ofNullable(this.tlsInspectionConfigurationId);
    }

    /**
     * String token used when updating the rule group.
     * 
     */
    @Import(name="updateToken")
    private @Nullable Output<String> updateToken;

    /**
     * @return String token used when updating the rule group.
     * 
     */
    public Optional<Output<String>> updateToken() {
        return Optional.ofNullable(this.updateToken);
    }

    private TlsInspectionConfigurationState() {}

    private TlsInspectionConfigurationState(TlsInspectionConfigurationState $) {
        this.arn = $.arn;
        this.certificateAuthorities = $.certificateAuthorities;
        this.certificates = $.certificates;
        this.description = $.description;
        this.encryptionConfigurations = $.encryptionConfigurations;
        this.name = $.name;
        this.numberOfAssociations = $.numberOfAssociations;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
        this.timeouts = $.timeouts;
        this.tlsInspectionConfiguration = $.tlsInspectionConfiguration;
        this.tlsInspectionConfigurationId = $.tlsInspectionConfigurationId;
        this.updateToken = $.updateToken;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TlsInspectionConfigurationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TlsInspectionConfigurationState $;

        public Builder() {
            $ = new TlsInspectionConfigurationState();
        }

        public Builder(TlsInspectionConfigurationState defaults) {
            $ = new TlsInspectionConfigurationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of the TLS Inspection Configuration.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the TLS Inspection Configuration.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param certificateAuthorities Certificate Manager certificate block. See Certificate Authority below for details.
         * 
         * @return builder
         * 
         */
        public Builder certificateAuthorities(@Nullable Output<List<TlsInspectionConfigurationCertificateAuthorityArgs>> certificateAuthorities) {
            $.certificateAuthorities = certificateAuthorities;
            return this;
        }

        /**
         * @param certificateAuthorities Certificate Manager certificate block. See Certificate Authority below for details.
         * 
         * @return builder
         * 
         */
        public Builder certificateAuthorities(List<TlsInspectionConfigurationCertificateAuthorityArgs> certificateAuthorities) {
            return certificateAuthorities(Output.of(certificateAuthorities));
        }

        /**
         * @param certificateAuthorities Certificate Manager certificate block. See Certificate Authority below for details.
         * 
         * @return builder
         * 
         */
        public Builder certificateAuthorities(TlsInspectionConfigurationCertificateAuthorityArgs... certificateAuthorities) {
            return certificateAuthorities(List.of(certificateAuthorities));
        }

        /**
         * @param certificates List of certificate blocks describing certificates associated with the TLS inspection configuration. See Certificates below for details.
         * 
         * @return builder
         * 
         */
        public Builder certificates(@Nullable Output<List<TlsInspectionConfigurationCertificateArgs>> certificates) {
            $.certificates = certificates;
            return this;
        }

        /**
         * @param certificates List of certificate blocks describing certificates associated with the TLS inspection configuration. See Certificates below for details.
         * 
         * @return builder
         * 
         */
        public Builder certificates(List<TlsInspectionConfigurationCertificateArgs> certificates) {
            return certificates(Output.of(certificates));
        }

        /**
         * @param certificates List of certificate blocks describing certificates associated with the TLS inspection configuration. See Certificates below for details.
         * 
         * @return builder
         * 
         */
        public Builder certificates(TlsInspectionConfigurationCertificateArgs... certificates) {
            return certificates(List.of(certificates));
        }

        /**
         * @param description Description of the TLS inspection configuration.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Description of the TLS inspection configuration.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param encryptionConfigurations Encryption configuration block. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder encryptionConfigurations(@Nullable Output<List<TlsInspectionConfigurationEncryptionConfigurationArgs>> encryptionConfigurations) {
            $.encryptionConfigurations = encryptionConfigurations;
            return this;
        }

        /**
         * @param encryptionConfigurations Encryption configuration block. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder encryptionConfigurations(List<TlsInspectionConfigurationEncryptionConfigurationArgs> encryptionConfigurations) {
            return encryptionConfigurations(Output.of(encryptionConfigurations));
        }

        /**
         * @param encryptionConfigurations Encryption configuration block. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder encryptionConfigurations(TlsInspectionConfigurationEncryptionConfigurationArgs... encryptionConfigurations) {
            return encryptionConfigurations(List.of(encryptionConfigurations));
        }

        /**
         * @param name Descriptive name of the TLS inspection configuration.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Descriptive name of the TLS inspection configuration.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param numberOfAssociations Number of firewall policies that use this TLS inspection configuration.
         * 
         * @return builder
         * 
         */
        public Builder numberOfAssociations(@Nullable Output<Integer> numberOfAssociations) {
            $.numberOfAssociations = numberOfAssociations;
            return this;
        }

        /**
         * @param numberOfAssociations Number of firewall policies that use this TLS inspection configuration.
         * 
         * @return builder
         * 
         */
        public Builder numberOfAssociations(Integer numberOfAssociations) {
            return numberOfAssociations(Output.of(numberOfAssociations));
        }

        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public Builder timeouts(@Nullable Output<TlsInspectionConfigurationTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(TlsInspectionConfigurationTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param tlsInspectionConfiguration TLS inspection configuration block. Detailed below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder tlsInspectionConfiguration(@Nullable Output<TlsInspectionConfigurationTlsInspectionConfigurationArgs> tlsInspectionConfiguration) {
            $.tlsInspectionConfiguration = tlsInspectionConfiguration;
            return this;
        }

        /**
         * @param tlsInspectionConfiguration TLS inspection configuration block. Detailed below.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder tlsInspectionConfiguration(TlsInspectionConfigurationTlsInspectionConfigurationArgs tlsInspectionConfiguration) {
            return tlsInspectionConfiguration(Output.of(tlsInspectionConfiguration));
        }

        /**
         * @param tlsInspectionConfigurationId A unique identifier for the TLS inspection configuration.
         * 
         * @return builder
         * 
         */
        public Builder tlsInspectionConfigurationId(@Nullable Output<String> tlsInspectionConfigurationId) {
            $.tlsInspectionConfigurationId = tlsInspectionConfigurationId;
            return this;
        }

        /**
         * @param tlsInspectionConfigurationId A unique identifier for the TLS inspection configuration.
         * 
         * @return builder
         * 
         */
        public Builder tlsInspectionConfigurationId(String tlsInspectionConfigurationId) {
            return tlsInspectionConfigurationId(Output.of(tlsInspectionConfigurationId));
        }

        /**
         * @param updateToken String token used when updating the rule group.
         * 
         * @return builder
         * 
         */
        public Builder updateToken(@Nullable Output<String> updateToken) {
            $.updateToken = updateToken;
            return this;
        }

        /**
         * @param updateToken String token used when updating the rule group.
         * 
         * @return builder
         * 
         */
        public Builder updateToken(String updateToken) {
            return updateToken(Output.of(updateToken));
        }

        public TlsInspectionConfigurationState build() {
            return $;
        }
    }

}
