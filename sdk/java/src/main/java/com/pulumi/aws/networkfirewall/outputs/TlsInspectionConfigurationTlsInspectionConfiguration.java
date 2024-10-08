// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.aws.networkfirewall.outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfiguration;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class TlsInspectionConfigurationTlsInspectionConfiguration {
    /**
     * @return Server certificate configurations that are associated with the TLS configuration. Detailed below.
     * 
     */
    private @Nullable TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfiguration serverCertificateConfiguration;

    private TlsInspectionConfigurationTlsInspectionConfiguration() {}
    /**
     * @return Server certificate configurations that are associated with the TLS configuration. Detailed below.
     * 
     */
    public Optional<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfiguration> serverCertificateConfiguration() {
        return Optional.ofNullable(this.serverCertificateConfiguration);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TlsInspectionConfigurationTlsInspectionConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfiguration serverCertificateConfiguration;
        public Builder() {}
        public Builder(TlsInspectionConfigurationTlsInspectionConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.serverCertificateConfiguration = defaults.serverCertificateConfiguration;
        }

        @CustomType.Setter
        public Builder serverCertificateConfiguration(@Nullable TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfiguration serverCertificateConfiguration) {

            this.serverCertificateConfiguration = serverCertificateConfiguration;
            return this;
        }
        public TlsInspectionConfigurationTlsInspectionConfiguration build() {
            final var _resultValue = new TlsInspectionConfigurationTlsInspectionConfiguration();
            _resultValue.serverCertificateConfiguration = serverCertificateConfiguration;
            return _resultValue;
        }
    }
}
