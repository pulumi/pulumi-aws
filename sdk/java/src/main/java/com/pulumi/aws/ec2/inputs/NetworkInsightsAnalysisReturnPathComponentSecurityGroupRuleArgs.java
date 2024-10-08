// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.NetworkInsightsAnalysisReturnPathComponentSecurityGroupRulePortRangeArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs extends com.pulumi.resources.ResourceArgs {

    public static final NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs Empty = new NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs();

    @Import(name="cidr")
    private @Nullable Output<String> cidr;

    public Optional<Output<String>> cidr() {
        return Optional.ofNullable(this.cidr);
    }

    @Import(name="direction")
    private @Nullable Output<String> direction;

    public Optional<Output<String>> direction() {
        return Optional.ofNullable(this.direction);
    }

    @Import(name="portRanges")
    private @Nullable Output<List<NetworkInsightsAnalysisReturnPathComponentSecurityGroupRulePortRangeArgs>> portRanges;

    public Optional<Output<List<NetworkInsightsAnalysisReturnPathComponentSecurityGroupRulePortRangeArgs>>> portRanges() {
        return Optional.ofNullable(this.portRanges);
    }

    @Import(name="prefixListId")
    private @Nullable Output<String> prefixListId;

    public Optional<Output<String>> prefixListId() {
        return Optional.ofNullable(this.prefixListId);
    }

    @Import(name="protocol")
    private @Nullable Output<String> protocol;

    public Optional<Output<String>> protocol() {
        return Optional.ofNullable(this.protocol);
    }

    @Import(name="securityGroupId")
    private @Nullable Output<String> securityGroupId;

    public Optional<Output<String>> securityGroupId() {
        return Optional.ofNullable(this.securityGroupId);
    }

    private NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs() {}

    private NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs(NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs $) {
        this.cidr = $.cidr;
        this.direction = $.direction;
        this.portRanges = $.portRanges;
        this.prefixListId = $.prefixListId;
        this.protocol = $.protocol;
        this.securityGroupId = $.securityGroupId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs $;

        public Builder() {
            $ = new NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs();
        }

        public Builder(NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs defaults) {
            $ = new NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs(Objects.requireNonNull(defaults));
        }

        public Builder cidr(@Nullable Output<String> cidr) {
            $.cidr = cidr;
            return this;
        }

        public Builder cidr(String cidr) {
            return cidr(Output.of(cidr));
        }

        public Builder direction(@Nullable Output<String> direction) {
            $.direction = direction;
            return this;
        }

        public Builder direction(String direction) {
            return direction(Output.of(direction));
        }

        public Builder portRanges(@Nullable Output<List<NetworkInsightsAnalysisReturnPathComponentSecurityGroupRulePortRangeArgs>> portRanges) {
            $.portRanges = portRanges;
            return this;
        }

        public Builder portRanges(List<NetworkInsightsAnalysisReturnPathComponentSecurityGroupRulePortRangeArgs> portRanges) {
            return portRanges(Output.of(portRanges));
        }

        public Builder portRanges(NetworkInsightsAnalysisReturnPathComponentSecurityGroupRulePortRangeArgs... portRanges) {
            return portRanges(List.of(portRanges));
        }

        public Builder prefixListId(@Nullable Output<String> prefixListId) {
            $.prefixListId = prefixListId;
            return this;
        }

        public Builder prefixListId(String prefixListId) {
            return prefixListId(Output.of(prefixListId));
        }

        public Builder protocol(@Nullable Output<String> protocol) {
            $.protocol = protocol;
            return this;
        }

        public Builder protocol(String protocol) {
            return protocol(Output.of(protocol));
        }

        public Builder securityGroupId(@Nullable Output<String> securityGroupId) {
            $.securityGroupId = securityGroupId;
            return this;
        }

        public Builder securityGroupId(String securityGroupId) {
            return securityGroupId(Output.of(securityGroupId));
        }

        public NetworkInsightsAnalysisReturnPathComponentSecurityGroupRuleArgs build() {
            return $;
        }
    }

}
