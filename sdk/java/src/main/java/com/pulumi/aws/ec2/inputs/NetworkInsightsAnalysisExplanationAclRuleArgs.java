// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.NetworkInsightsAnalysisExplanationAclRulePortRangeArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class NetworkInsightsAnalysisExplanationAclRuleArgs extends com.pulumi.resources.ResourceArgs {

    public static final NetworkInsightsAnalysisExplanationAclRuleArgs Empty = new NetworkInsightsAnalysisExplanationAclRuleArgs();

    @Import(name="cidr")
    private @Nullable Output<String> cidr;

    public Optional<Output<String>> cidr() {
        return Optional.ofNullable(this.cidr);
    }

    @Import(name="egress")
    private @Nullable Output<Boolean> egress;

    public Optional<Output<Boolean>> egress() {
        return Optional.ofNullable(this.egress);
    }

    @Import(name="portRanges")
    private @Nullable Output<List<NetworkInsightsAnalysisExplanationAclRulePortRangeArgs>> portRanges;

    public Optional<Output<List<NetworkInsightsAnalysisExplanationAclRulePortRangeArgs>>> portRanges() {
        return Optional.ofNullable(this.portRanges);
    }

    @Import(name="protocol")
    private @Nullable Output<String> protocol;

    public Optional<Output<String>> protocol() {
        return Optional.ofNullable(this.protocol);
    }

    @Import(name="ruleAction")
    private @Nullable Output<String> ruleAction;

    public Optional<Output<String>> ruleAction() {
        return Optional.ofNullable(this.ruleAction);
    }

    @Import(name="ruleNumber")
    private @Nullable Output<Integer> ruleNumber;

    public Optional<Output<Integer>> ruleNumber() {
        return Optional.ofNullable(this.ruleNumber);
    }

    private NetworkInsightsAnalysisExplanationAclRuleArgs() {}

    private NetworkInsightsAnalysisExplanationAclRuleArgs(NetworkInsightsAnalysisExplanationAclRuleArgs $) {
        this.cidr = $.cidr;
        this.egress = $.egress;
        this.portRanges = $.portRanges;
        this.protocol = $.protocol;
        this.ruleAction = $.ruleAction;
        this.ruleNumber = $.ruleNumber;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NetworkInsightsAnalysisExplanationAclRuleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NetworkInsightsAnalysisExplanationAclRuleArgs $;

        public Builder() {
            $ = new NetworkInsightsAnalysisExplanationAclRuleArgs();
        }

        public Builder(NetworkInsightsAnalysisExplanationAclRuleArgs defaults) {
            $ = new NetworkInsightsAnalysisExplanationAclRuleArgs(Objects.requireNonNull(defaults));
        }

        public Builder cidr(@Nullable Output<String> cidr) {
            $.cidr = cidr;
            return this;
        }

        public Builder cidr(String cidr) {
            return cidr(Output.of(cidr));
        }

        public Builder egress(@Nullable Output<Boolean> egress) {
            $.egress = egress;
            return this;
        }

        public Builder egress(Boolean egress) {
            return egress(Output.of(egress));
        }

        public Builder portRanges(@Nullable Output<List<NetworkInsightsAnalysisExplanationAclRulePortRangeArgs>> portRanges) {
            $.portRanges = portRanges;
            return this;
        }

        public Builder portRanges(List<NetworkInsightsAnalysisExplanationAclRulePortRangeArgs> portRanges) {
            return portRanges(Output.of(portRanges));
        }

        public Builder portRanges(NetworkInsightsAnalysisExplanationAclRulePortRangeArgs... portRanges) {
            return portRanges(List.of(portRanges));
        }

        public Builder protocol(@Nullable Output<String> protocol) {
            $.protocol = protocol;
            return this;
        }

        public Builder protocol(String protocol) {
            return protocol(Output.of(protocol));
        }

        public Builder ruleAction(@Nullable Output<String> ruleAction) {
            $.ruleAction = ruleAction;
            return this;
        }

        public Builder ruleAction(String ruleAction) {
            return ruleAction(Output.of(ruleAction));
        }

        public Builder ruleNumber(@Nullable Output<Integer> ruleNumber) {
            $.ruleNumber = ruleNumber;
            return this;
        }

        public Builder ruleNumber(Integer ruleNumber) {
            return ruleNumber(Output.of(ruleNumber));
        }

        public NetworkInsightsAnalysisExplanationAclRuleArgs build() {
            return $;
        }
    }

}
