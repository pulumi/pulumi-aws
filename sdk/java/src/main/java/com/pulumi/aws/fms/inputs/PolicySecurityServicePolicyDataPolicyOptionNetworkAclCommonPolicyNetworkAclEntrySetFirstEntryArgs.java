// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.fms.inputs;

import com.pulumi.aws.fms.inputs.PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCodeArgs;
import com.pulumi.aws.fms.inputs.PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs extends com.pulumi.resources.ResourceArgs {

    public static final PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs Empty = new PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs();

    /**
     * A string value containing the IPv4 network range to allow or deny, in CIDR notation.
     * 
     */
    @Import(name="cidrBlock")
    private @Nullable Output<String> cidrBlock;

    /**
     * @return A string value containing the IPv4 network range to allow or deny, in CIDR notation.
     * 
     */
    public Optional<Output<String>> cidrBlock() {
        return Optional.ofNullable(this.cidrBlock);
    }

    /**
     * A boolean value, if true Firewall Manager creates egress rule. If false Firewall Manager creates ingress rule.
     * 
     */
    @Import(name="egress", required=true)
    private Output<Boolean> egress;

    /**
     * @return A boolean value, if true Firewall Manager creates egress rule. If false Firewall Manager creates ingress rule.
     * 
     */
    public Output<Boolean> egress() {
        return this.egress;
    }

    /**
     * A configuration block for ICMP protocol: The ICMP type and code. See the `icmp_type_code` block.
     * 
     */
    @Import(name="icmpTypeCodes")
    private @Nullable Output<List<PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCodeArgs>> icmpTypeCodes;

    /**
     * @return A configuration block for ICMP protocol: The ICMP type and code. See the `icmp_type_code` block.
     * 
     */
    public Optional<Output<List<PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCodeArgs>>> icmpTypeCodes() {
        return Optional.ofNullable(this.icmpTypeCodes);
    }

    /**
     * A string value containing the IPv6 network range to allow or deny, in CIDR notation.
     * 
     */
    @Import(name="ipv6CidrBlock")
    private @Nullable Output<String> ipv6CidrBlock;

    /**
     * @return A string value containing the IPv6 network range to allow or deny, in CIDR notation.
     * 
     */
    public Optional<Output<String>> ipv6CidrBlock() {
        return Optional.ofNullable(this.ipv6CidrBlock);
    }

    /**
     * A configuration block for PortRange. See the `port_range` block.
     * 
     */
    @Import(name="portRanges")
    private @Nullable Output<List<PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeArgs>> portRanges;

    /**
     * @return A configuration block for PortRange. See the `port_range` block.
     * 
     */
    public Optional<Output<List<PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeArgs>>> portRanges() {
        return Optional.ofNullable(this.portRanges);
    }

    /**
     * The protocol number. A value of &#34;-1&#34; means all protocols.
     * 
     */
    @Import(name="protocol", required=true)
    private Output<String> protocol;

    /**
     * @return The protocol number. A value of &#34;-1&#34; means all protocols.
     * 
     */
    public Output<String> protocol() {
        return this.protocol;
    }

    /**
     * A string value that indicates whether to allow or deny the traffic that matches the rule. Valid values: `allow`, `deny`.
     * 
     */
    @Import(name="ruleAction", required=true)
    private Output<String> ruleAction;

    /**
     * @return A string value that indicates whether to allow or deny the traffic that matches the rule. Valid values: `allow`, `deny`.
     * 
     */
    public Output<String> ruleAction() {
        return this.ruleAction;
    }

    private PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs() {}

    private PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs(PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs $) {
        this.cidrBlock = $.cidrBlock;
        this.egress = $.egress;
        this.icmpTypeCodes = $.icmpTypeCodes;
        this.ipv6CidrBlock = $.ipv6CidrBlock;
        this.portRanges = $.portRanges;
        this.protocol = $.protocol;
        this.ruleAction = $.ruleAction;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs $;

        public Builder() {
            $ = new PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs();
        }

        public Builder(PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs defaults) {
            $ = new PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param cidrBlock A string value containing the IPv4 network range to allow or deny, in CIDR notation.
         * 
         * @return builder
         * 
         */
        public Builder cidrBlock(@Nullable Output<String> cidrBlock) {
            $.cidrBlock = cidrBlock;
            return this;
        }

        /**
         * @param cidrBlock A string value containing the IPv4 network range to allow or deny, in CIDR notation.
         * 
         * @return builder
         * 
         */
        public Builder cidrBlock(String cidrBlock) {
            return cidrBlock(Output.of(cidrBlock));
        }

        /**
         * @param egress A boolean value, if true Firewall Manager creates egress rule. If false Firewall Manager creates ingress rule.
         * 
         * @return builder
         * 
         */
        public Builder egress(Output<Boolean> egress) {
            $.egress = egress;
            return this;
        }

        /**
         * @param egress A boolean value, if true Firewall Manager creates egress rule. If false Firewall Manager creates ingress rule.
         * 
         * @return builder
         * 
         */
        public Builder egress(Boolean egress) {
            return egress(Output.of(egress));
        }

        /**
         * @param icmpTypeCodes A configuration block for ICMP protocol: The ICMP type and code. See the `icmp_type_code` block.
         * 
         * @return builder
         * 
         */
        public Builder icmpTypeCodes(@Nullable Output<List<PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCodeArgs>> icmpTypeCodes) {
            $.icmpTypeCodes = icmpTypeCodes;
            return this;
        }

        /**
         * @param icmpTypeCodes A configuration block for ICMP protocol: The ICMP type and code. See the `icmp_type_code` block.
         * 
         * @return builder
         * 
         */
        public Builder icmpTypeCodes(List<PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCodeArgs> icmpTypeCodes) {
            return icmpTypeCodes(Output.of(icmpTypeCodes));
        }

        /**
         * @param icmpTypeCodes A configuration block for ICMP protocol: The ICMP type and code. See the `icmp_type_code` block.
         * 
         * @return builder
         * 
         */
        public Builder icmpTypeCodes(PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCodeArgs... icmpTypeCodes) {
            return icmpTypeCodes(List.of(icmpTypeCodes));
        }

        /**
         * @param ipv6CidrBlock A string value containing the IPv6 network range to allow or deny, in CIDR notation.
         * 
         * @return builder
         * 
         */
        public Builder ipv6CidrBlock(@Nullable Output<String> ipv6CidrBlock) {
            $.ipv6CidrBlock = ipv6CidrBlock;
            return this;
        }

        /**
         * @param ipv6CidrBlock A string value containing the IPv6 network range to allow or deny, in CIDR notation.
         * 
         * @return builder
         * 
         */
        public Builder ipv6CidrBlock(String ipv6CidrBlock) {
            return ipv6CidrBlock(Output.of(ipv6CidrBlock));
        }

        /**
         * @param portRanges A configuration block for PortRange. See the `port_range` block.
         * 
         * @return builder
         * 
         */
        public Builder portRanges(@Nullable Output<List<PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeArgs>> portRanges) {
            $.portRanges = portRanges;
            return this;
        }

        /**
         * @param portRanges A configuration block for PortRange. See the `port_range` block.
         * 
         * @return builder
         * 
         */
        public Builder portRanges(List<PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeArgs> portRanges) {
            return portRanges(Output.of(portRanges));
        }

        /**
         * @param portRanges A configuration block for PortRange. See the `port_range` block.
         * 
         * @return builder
         * 
         */
        public Builder portRanges(PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRangeArgs... portRanges) {
            return portRanges(List.of(portRanges));
        }

        /**
         * @param protocol The protocol number. A value of &#34;-1&#34; means all protocols.
         * 
         * @return builder
         * 
         */
        public Builder protocol(Output<String> protocol) {
            $.protocol = protocol;
            return this;
        }

        /**
         * @param protocol The protocol number. A value of &#34;-1&#34; means all protocols.
         * 
         * @return builder
         * 
         */
        public Builder protocol(String protocol) {
            return protocol(Output.of(protocol));
        }

        /**
         * @param ruleAction A string value that indicates whether to allow or deny the traffic that matches the rule. Valid values: `allow`, `deny`.
         * 
         * @return builder
         * 
         */
        public Builder ruleAction(Output<String> ruleAction) {
            $.ruleAction = ruleAction;
            return this;
        }

        /**
         * @param ruleAction A string value that indicates whether to allow or deny the traffic that matches the rule. Valid values: `allow`, `deny`.
         * 
         * @return builder
         * 
         */
        public Builder ruleAction(String ruleAction) {
            return ruleAction(Output.of(ruleAction));
        }

        public PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs build() {
            if ($.egress == null) {
                throw new MissingRequiredPropertyException("PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs", "egress");
            }
            if ($.protocol == null) {
                throw new MissingRequiredPropertyException("PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs", "protocol");
            }
            if ($.ruleAction == null) {
                throw new MissingRequiredPropertyException("PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryArgs", "ruleAction");
            }
            return $;
        }
    }

}
