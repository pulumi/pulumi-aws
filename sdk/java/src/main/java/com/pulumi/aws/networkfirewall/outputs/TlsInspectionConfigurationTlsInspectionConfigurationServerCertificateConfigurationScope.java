// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.networkfirewall.outputs;

import com.pulumi.aws.networkfirewall.outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestination;
import com.pulumi.aws.networkfirewall.outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPort;
import com.pulumi.aws.networkfirewall.outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSource;
import com.pulumi.aws.networkfirewall.outputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePort;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScope {
    /**
     * @return Set of configuration blocks describing the destination ports to inspect for. If not specified, this matches with any destination port. See Destination Ports below for details.
     * 
     */
    private @Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPort> destinationPorts;
    /**
     * @return Set of configuration blocks describing the destination IP address and address ranges to inspect for, in CIDR notation. If not specified, this matches with any destination address. See Destination below for details.
     * 
     */
    private @Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestination> destinations;
    /**
     * @return Set of protocols to inspect for, specified using the protocol&#39;s assigned internet protocol number (IANA). Network Firewall currently supports TCP only. Valid values: `6`
     * 
     */
    private List<Integer> protocols;
    /**
     * @return Set of configuration blocks describing the source ports to inspect for. If not specified, this matches with any source port. See Source Ports below for details.
     * 
     */
    private @Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePort> sourcePorts;
    /**
     * @return Set of configuration blocks describing the source IP address and address ranges to inspect for, in CIDR notation. If not specified, this matches with any source address. See Source below for details.
     * 
     */
    private @Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSource> sources;

    private TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScope() {}
    /**
     * @return Set of configuration blocks describing the destination ports to inspect for. If not specified, this matches with any destination port. See Destination Ports below for details.
     * 
     */
    public List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPort> destinationPorts() {
        return this.destinationPorts == null ? List.of() : this.destinationPorts;
    }
    /**
     * @return Set of configuration blocks describing the destination IP address and address ranges to inspect for, in CIDR notation. If not specified, this matches with any destination address. See Destination below for details.
     * 
     */
    public List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestination> destinations() {
        return this.destinations == null ? List.of() : this.destinations;
    }
    /**
     * @return Set of protocols to inspect for, specified using the protocol&#39;s assigned internet protocol number (IANA). Network Firewall currently supports TCP only. Valid values: `6`
     * 
     */
    public List<Integer> protocols() {
        return this.protocols;
    }
    /**
     * @return Set of configuration blocks describing the source ports to inspect for. If not specified, this matches with any source port. See Source Ports below for details.
     * 
     */
    public List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePort> sourcePorts() {
        return this.sourcePorts == null ? List.of() : this.sourcePorts;
    }
    /**
     * @return Set of configuration blocks describing the source IP address and address ranges to inspect for, in CIDR notation. If not specified, this matches with any source address. See Source below for details.
     * 
     */
    public List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSource> sources() {
        return this.sources == null ? List.of() : this.sources;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScope defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPort> destinationPorts;
        private @Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestination> destinations;
        private List<Integer> protocols;
        private @Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePort> sourcePorts;
        private @Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSource> sources;
        public Builder() {}
        public Builder(TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScope defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.destinationPorts = defaults.destinationPorts;
    	      this.destinations = defaults.destinations;
    	      this.protocols = defaults.protocols;
    	      this.sourcePorts = defaults.sourcePorts;
    	      this.sources = defaults.sources;
        }

        @CustomType.Setter
        public Builder destinationPorts(@Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPort> destinationPorts) {

            this.destinationPorts = destinationPorts;
            return this;
        }
        public Builder destinationPorts(TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPort... destinationPorts) {
            return destinationPorts(List.of(destinationPorts));
        }
        @CustomType.Setter
        public Builder destinations(@Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestination> destinations) {

            this.destinations = destinations;
            return this;
        }
        public Builder destinations(TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestination... destinations) {
            return destinations(List.of(destinations));
        }
        @CustomType.Setter
        public Builder protocols(List<Integer> protocols) {
            if (protocols == null) {
              throw new MissingRequiredPropertyException("TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScope", "protocols");
            }
            this.protocols = protocols;
            return this;
        }
        public Builder protocols(Integer... protocols) {
            return protocols(List.of(protocols));
        }
        @CustomType.Setter
        public Builder sourcePorts(@Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePort> sourcePorts) {

            this.sourcePorts = sourcePorts;
            return this;
        }
        public Builder sourcePorts(TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePort... sourcePorts) {
            return sourcePorts(List.of(sourcePorts));
        }
        @CustomType.Setter
        public Builder sources(@Nullable List<TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSource> sources) {

            this.sources = sources;
            return this;
        }
        public Builder sources(TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSource... sources) {
            return sources(List.of(sources));
        }
        public TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScope build() {
            final var _resultValue = new TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScope();
            _resultValue.destinationPorts = destinationPorts;
            _resultValue.destinations = destinations;
            _resultValue.protocols = protocols;
            _resultValue.sourcePorts = sourcePorts;
            _resultValue.sources = sources;
            return _resultValue;
        }
    }
}
