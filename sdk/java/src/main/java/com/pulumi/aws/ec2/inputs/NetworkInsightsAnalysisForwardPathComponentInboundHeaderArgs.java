// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.NetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRangeArgs;
import com.pulumi.aws.ec2.inputs.NetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRangeArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs extends com.pulumi.resources.ResourceArgs {

    public static final NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs Empty = new NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs();

    @Import(name="destinationAddresses")
    private @Nullable Output<List<String>> destinationAddresses;

    public Optional<Output<List<String>>> destinationAddresses() {
        return Optional.ofNullable(this.destinationAddresses);
    }

    @Import(name="destinationPortRanges")
    private @Nullable Output<List<NetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRangeArgs>> destinationPortRanges;

    public Optional<Output<List<NetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRangeArgs>>> destinationPortRanges() {
        return Optional.ofNullable(this.destinationPortRanges);
    }

    @Import(name="protocol")
    private @Nullable Output<String> protocol;

    public Optional<Output<String>> protocol() {
        return Optional.ofNullable(this.protocol);
    }

    @Import(name="sourceAddresses")
    private @Nullable Output<List<String>> sourceAddresses;

    public Optional<Output<List<String>>> sourceAddresses() {
        return Optional.ofNullable(this.sourceAddresses);
    }

    @Import(name="sourcePortRanges")
    private @Nullable Output<List<NetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRangeArgs>> sourcePortRanges;

    public Optional<Output<List<NetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRangeArgs>>> sourcePortRanges() {
        return Optional.ofNullable(this.sourcePortRanges);
    }

    private NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs() {}

    private NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs(NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs $) {
        this.destinationAddresses = $.destinationAddresses;
        this.destinationPortRanges = $.destinationPortRanges;
        this.protocol = $.protocol;
        this.sourceAddresses = $.sourceAddresses;
        this.sourcePortRanges = $.sourcePortRanges;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs $;

        public Builder() {
            $ = new NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs();
        }

        public Builder(NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs defaults) {
            $ = new NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs(Objects.requireNonNull(defaults));
        }

        public Builder destinationAddresses(@Nullable Output<List<String>> destinationAddresses) {
            $.destinationAddresses = destinationAddresses;
            return this;
        }

        public Builder destinationAddresses(List<String> destinationAddresses) {
            return destinationAddresses(Output.of(destinationAddresses));
        }

        public Builder destinationAddresses(String... destinationAddresses) {
            return destinationAddresses(List.of(destinationAddresses));
        }

        public Builder destinationPortRanges(@Nullable Output<List<NetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRangeArgs>> destinationPortRanges) {
            $.destinationPortRanges = destinationPortRanges;
            return this;
        }

        public Builder destinationPortRanges(List<NetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRangeArgs> destinationPortRanges) {
            return destinationPortRanges(Output.of(destinationPortRanges));
        }

        public Builder destinationPortRanges(NetworkInsightsAnalysisForwardPathComponentInboundHeaderDestinationPortRangeArgs... destinationPortRanges) {
            return destinationPortRanges(List.of(destinationPortRanges));
        }

        public Builder protocol(@Nullable Output<String> protocol) {
            $.protocol = protocol;
            return this;
        }

        public Builder protocol(String protocol) {
            return protocol(Output.of(protocol));
        }

        public Builder sourceAddresses(@Nullable Output<List<String>> sourceAddresses) {
            $.sourceAddresses = sourceAddresses;
            return this;
        }

        public Builder sourceAddresses(List<String> sourceAddresses) {
            return sourceAddresses(Output.of(sourceAddresses));
        }

        public Builder sourceAddresses(String... sourceAddresses) {
            return sourceAddresses(List.of(sourceAddresses));
        }

        public Builder sourcePortRanges(@Nullable Output<List<NetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRangeArgs>> sourcePortRanges) {
            $.sourcePortRanges = sourcePortRanges;
            return this;
        }

        public Builder sourcePortRanges(List<NetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRangeArgs> sourcePortRanges) {
            return sourcePortRanges(Output.of(sourcePortRanges));
        }

        public Builder sourcePortRanges(NetworkInsightsAnalysisForwardPathComponentInboundHeaderSourcePortRangeArgs... sourcePortRanges) {
            return sourcePortRanges(List.of(sourcePortRanges));
        }

        public NetworkInsightsAnalysisForwardPathComponentInboundHeaderArgs build() {
            return $;
        }
    }

}
