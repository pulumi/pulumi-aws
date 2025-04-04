// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedaccess.outputs;

import com.pulumi.aws.verifiedaccess.outputs.EndpointNetworkInterfaceOptionsPortRange;
import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class EndpointNetworkInterfaceOptions {
    private @Nullable String networkInterfaceId;
    private @Nullable Integer port;
    private @Nullable List<EndpointNetworkInterfaceOptionsPortRange> portRanges;
    private @Nullable String protocol;

    private EndpointNetworkInterfaceOptions() {}
    public Optional<String> networkInterfaceId() {
        return Optional.ofNullable(this.networkInterfaceId);
    }
    public Optional<Integer> port() {
        return Optional.ofNullable(this.port);
    }
    public List<EndpointNetworkInterfaceOptionsPortRange> portRanges() {
        return this.portRanges == null ? List.of() : this.portRanges;
    }
    public Optional<String> protocol() {
        return Optional.ofNullable(this.protocol);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(EndpointNetworkInterfaceOptions defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String networkInterfaceId;
        private @Nullable Integer port;
        private @Nullable List<EndpointNetworkInterfaceOptionsPortRange> portRanges;
        private @Nullable String protocol;
        public Builder() {}
        public Builder(EndpointNetworkInterfaceOptions defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.networkInterfaceId = defaults.networkInterfaceId;
    	      this.port = defaults.port;
    	      this.portRanges = defaults.portRanges;
    	      this.protocol = defaults.protocol;
        }

        @CustomType.Setter
        public Builder networkInterfaceId(@Nullable String networkInterfaceId) {

            this.networkInterfaceId = networkInterfaceId;
            return this;
        }
        @CustomType.Setter
        public Builder port(@Nullable Integer port) {

            this.port = port;
            return this;
        }
        @CustomType.Setter
        public Builder portRanges(@Nullable List<EndpointNetworkInterfaceOptionsPortRange> portRanges) {

            this.portRanges = portRanges;
            return this;
        }
        public Builder portRanges(EndpointNetworkInterfaceOptionsPortRange... portRanges) {
            return portRanges(List.of(portRanges));
        }
        @CustomType.Setter
        public Builder protocol(@Nullable String protocol) {

            this.protocol = protocol;
            return this;
        }
        public EndpointNetworkInterfaceOptions build() {
            final var _resultValue = new EndpointNetworkInterfaceOptions();
            _resultValue.networkInterfaceId = networkInterfaceId;
            _resultValue.port = port;
            _resultValue.portRanges = portRanges;
            _resultValue.protocol = protocol;
            return _resultValue;
        }
    }
}
