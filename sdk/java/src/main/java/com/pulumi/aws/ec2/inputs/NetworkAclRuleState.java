// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class NetworkAclRuleState extends com.pulumi.resources.ResourceArgs {

    public static final NetworkAclRuleState Empty = new NetworkAclRuleState();

    /**
     * The network range to allow or deny, in CIDR notation (for example 172.16.0.0/24 ).
     * 
     */
    @Import(name="cidrBlock")
    private @Nullable Output<String> cidrBlock;

    /**
     * @return The network range to allow or deny, in CIDR notation (for example 172.16.0.0/24 ).
     * 
     */
    public Optional<Output<String>> cidrBlock() {
        return Optional.ofNullable(this.cidrBlock);
    }

    /**
     * Indicates whether this is an egress rule (rule is applied to traffic leaving the subnet). Default `false`.
     * 
     */
    @Import(name="egress")
    private @Nullable Output<Boolean> egress;

    /**
     * @return Indicates whether this is an egress rule (rule is applied to traffic leaving the subnet). Default `false`.
     * 
     */
    public Optional<Output<Boolean>> egress() {
        return Optional.ofNullable(this.egress);
    }

    /**
     * The from port to match.
     * 
     */
    @Import(name="fromPort")
    private @Nullable Output<Integer> fromPort;

    /**
     * @return The from port to match.
     * 
     */
    public Optional<Output<Integer>> fromPort() {
        return Optional.ofNullable(this.fromPort);
    }

    /**
     * ICMP protocol: The ICMP code. Required if specifying ICMP for the protocolE.g., -1
     * 
     * &gt; **NOTE:** If the value of `protocol` is `-1` or `all`, the `from_port` and `to_port` values will be ignored and the rule will apply to all ports.
     * 
     * &gt; **NOTE:** If the value of `icmp_type` is `-1` (which results in a wildcard ICMP type), the `icmp_code` must also be set to `-1` (wildcard ICMP code).
     * 
     * &gt; Note: For more information on ICMP types and codes, see here: https://www.iana.org/assignments/icmp-parameters/icmp-parameters.xhtml
     * 
     */
    @Import(name="icmpCode")
    private @Nullable Output<Integer> icmpCode;

    /**
     * @return ICMP protocol: The ICMP code. Required if specifying ICMP for the protocolE.g., -1
     * 
     * &gt; **NOTE:** If the value of `protocol` is `-1` or `all`, the `from_port` and `to_port` values will be ignored and the rule will apply to all ports.
     * 
     * &gt; **NOTE:** If the value of `icmp_type` is `-1` (which results in a wildcard ICMP type), the `icmp_code` must also be set to `-1` (wildcard ICMP code).
     * 
     * &gt; Note: For more information on ICMP types and codes, see here: https://www.iana.org/assignments/icmp-parameters/icmp-parameters.xhtml
     * 
     */
    public Optional<Output<Integer>> icmpCode() {
        return Optional.ofNullable(this.icmpCode);
    }

    /**
     * ICMP protocol: The ICMP type. Required if specifying ICMP for the protocolE.g., -1
     * 
     */
    @Import(name="icmpType")
    private @Nullable Output<Integer> icmpType;

    /**
     * @return ICMP protocol: The ICMP type. Required if specifying ICMP for the protocolE.g., -1
     * 
     */
    public Optional<Output<Integer>> icmpType() {
        return Optional.ofNullable(this.icmpType);
    }

    /**
     * The IPv6 CIDR block to allow or deny.
     * 
     */
    @Import(name="ipv6CidrBlock")
    private @Nullable Output<String> ipv6CidrBlock;

    /**
     * @return The IPv6 CIDR block to allow or deny.
     * 
     */
    public Optional<Output<String>> ipv6CidrBlock() {
        return Optional.ofNullable(this.ipv6CidrBlock);
    }

    /**
     * The ID of the network ACL.
     * 
     */
    @Import(name="networkAclId")
    private @Nullable Output<String> networkAclId;

    /**
     * @return The ID of the network ACL.
     * 
     */
    public Optional<Output<String>> networkAclId() {
        return Optional.ofNullable(this.networkAclId);
    }

    /**
     * The protocol. A value of -1 means all protocols.
     * 
     */
    @Import(name="protocol")
    private @Nullable Output<String> protocol;

    /**
     * @return The protocol. A value of -1 means all protocols.
     * 
     */
    public Optional<Output<String>> protocol() {
        return Optional.ofNullable(this.protocol);
    }

    /**
     * Indicates whether to allow or deny the traffic that matches the rule. Accepted values: `allow` | `deny`
     * 
     */
    @Import(name="ruleAction")
    private @Nullable Output<String> ruleAction;

    /**
     * @return Indicates whether to allow or deny the traffic that matches the rule. Accepted values: `allow` | `deny`
     * 
     */
    public Optional<Output<String>> ruleAction() {
        return Optional.ofNullable(this.ruleAction);
    }

    /**
     * The rule number for the entry (for example, 100). ACL entries are processed in ascending order by rule number.
     * 
     */
    @Import(name="ruleNumber")
    private @Nullable Output<Integer> ruleNumber;

    /**
     * @return The rule number for the entry (for example, 100). ACL entries are processed in ascending order by rule number.
     * 
     */
    public Optional<Output<Integer>> ruleNumber() {
        return Optional.ofNullable(this.ruleNumber);
    }

    /**
     * The to port to match.
     * 
     */
    @Import(name="toPort")
    private @Nullable Output<Integer> toPort;

    /**
     * @return The to port to match.
     * 
     */
    public Optional<Output<Integer>> toPort() {
        return Optional.ofNullable(this.toPort);
    }

    private NetworkAclRuleState() {}

    private NetworkAclRuleState(NetworkAclRuleState $) {
        this.cidrBlock = $.cidrBlock;
        this.egress = $.egress;
        this.fromPort = $.fromPort;
        this.icmpCode = $.icmpCode;
        this.icmpType = $.icmpType;
        this.ipv6CidrBlock = $.ipv6CidrBlock;
        this.networkAclId = $.networkAclId;
        this.protocol = $.protocol;
        this.ruleAction = $.ruleAction;
        this.ruleNumber = $.ruleNumber;
        this.toPort = $.toPort;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NetworkAclRuleState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NetworkAclRuleState $;

        public Builder() {
            $ = new NetworkAclRuleState();
        }

        public Builder(NetworkAclRuleState defaults) {
            $ = new NetworkAclRuleState(Objects.requireNonNull(defaults));
        }

        /**
         * @param cidrBlock The network range to allow or deny, in CIDR notation (for example 172.16.0.0/24 ).
         * 
         * @return builder
         * 
         */
        public Builder cidrBlock(@Nullable Output<String> cidrBlock) {
            $.cidrBlock = cidrBlock;
            return this;
        }

        /**
         * @param cidrBlock The network range to allow or deny, in CIDR notation (for example 172.16.0.0/24 ).
         * 
         * @return builder
         * 
         */
        public Builder cidrBlock(String cidrBlock) {
            return cidrBlock(Output.of(cidrBlock));
        }

        /**
         * @param egress Indicates whether this is an egress rule (rule is applied to traffic leaving the subnet). Default `false`.
         * 
         * @return builder
         * 
         */
        public Builder egress(@Nullable Output<Boolean> egress) {
            $.egress = egress;
            return this;
        }

        /**
         * @param egress Indicates whether this is an egress rule (rule is applied to traffic leaving the subnet). Default `false`.
         * 
         * @return builder
         * 
         */
        public Builder egress(Boolean egress) {
            return egress(Output.of(egress));
        }

        /**
         * @param fromPort The from port to match.
         * 
         * @return builder
         * 
         */
        public Builder fromPort(@Nullable Output<Integer> fromPort) {
            $.fromPort = fromPort;
            return this;
        }

        /**
         * @param fromPort The from port to match.
         * 
         * @return builder
         * 
         */
        public Builder fromPort(Integer fromPort) {
            return fromPort(Output.of(fromPort));
        }

        /**
         * @param icmpCode ICMP protocol: The ICMP code. Required if specifying ICMP for the protocolE.g., -1
         * 
         * &gt; **NOTE:** If the value of `protocol` is `-1` or `all`, the `from_port` and `to_port` values will be ignored and the rule will apply to all ports.
         * 
         * &gt; **NOTE:** If the value of `icmp_type` is `-1` (which results in a wildcard ICMP type), the `icmp_code` must also be set to `-1` (wildcard ICMP code).
         * 
         * &gt; Note: For more information on ICMP types and codes, see here: https://www.iana.org/assignments/icmp-parameters/icmp-parameters.xhtml
         * 
         * @return builder
         * 
         */
        public Builder icmpCode(@Nullable Output<Integer> icmpCode) {
            $.icmpCode = icmpCode;
            return this;
        }

        /**
         * @param icmpCode ICMP protocol: The ICMP code. Required if specifying ICMP for the protocolE.g., -1
         * 
         * &gt; **NOTE:** If the value of `protocol` is `-1` or `all`, the `from_port` and `to_port` values will be ignored and the rule will apply to all ports.
         * 
         * &gt; **NOTE:** If the value of `icmp_type` is `-1` (which results in a wildcard ICMP type), the `icmp_code` must also be set to `-1` (wildcard ICMP code).
         * 
         * &gt; Note: For more information on ICMP types and codes, see here: https://www.iana.org/assignments/icmp-parameters/icmp-parameters.xhtml
         * 
         * @return builder
         * 
         */
        public Builder icmpCode(Integer icmpCode) {
            return icmpCode(Output.of(icmpCode));
        }

        /**
         * @param icmpType ICMP protocol: The ICMP type. Required if specifying ICMP for the protocolE.g., -1
         * 
         * @return builder
         * 
         */
        public Builder icmpType(@Nullable Output<Integer> icmpType) {
            $.icmpType = icmpType;
            return this;
        }

        /**
         * @param icmpType ICMP protocol: The ICMP type. Required if specifying ICMP for the protocolE.g., -1
         * 
         * @return builder
         * 
         */
        public Builder icmpType(Integer icmpType) {
            return icmpType(Output.of(icmpType));
        }

        /**
         * @param ipv6CidrBlock The IPv6 CIDR block to allow or deny.
         * 
         * @return builder
         * 
         */
        public Builder ipv6CidrBlock(@Nullable Output<String> ipv6CidrBlock) {
            $.ipv6CidrBlock = ipv6CidrBlock;
            return this;
        }

        /**
         * @param ipv6CidrBlock The IPv6 CIDR block to allow or deny.
         * 
         * @return builder
         * 
         */
        public Builder ipv6CidrBlock(String ipv6CidrBlock) {
            return ipv6CidrBlock(Output.of(ipv6CidrBlock));
        }

        /**
         * @param networkAclId The ID of the network ACL.
         * 
         * @return builder
         * 
         */
        public Builder networkAclId(@Nullable Output<String> networkAclId) {
            $.networkAclId = networkAclId;
            return this;
        }

        /**
         * @param networkAclId The ID of the network ACL.
         * 
         * @return builder
         * 
         */
        public Builder networkAclId(String networkAclId) {
            return networkAclId(Output.of(networkAclId));
        }

        /**
         * @param protocol The protocol. A value of -1 means all protocols.
         * 
         * @return builder
         * 
         */
        public Builder protocol(@Nullable Output<String> protocol) {
            $.protocol = protocol;
            return this;
        }

        /**
         * @param protocol The protocol. A value of -1 means all protocols.
         * 
         * @return builder
         * 
         */
        public Builder protocol(String protocol) {
            return protocol(Output.of(protocol));
        }

        /**
         * @param ruleAction Indicates whether to allow or deny the traffic that matches the rule. Accepted values: `allow` | `deny`
         * 
         * @return builder
         * 
         */
        public Builder ruleAction(@Nullable Output<String> ruleAction) {
            $.ruleAction = ruleAction;
            return this;
        }

        /**
         * @param ruleAction Indicates whether to allow or deny the traffic that matches the rule. Accepted values: `allow` | `deny`
         * 
         * @return builder
         * 
         */
        public Builder ruleAction(String ruleAction) {
            return ruleAction(Output.of(ruleAction));
        }

        /**
         * @param ruleNumber The rule number for the entry (for example, 100). ACL entries are processed in ascending order by rule number.
         * 
         * @return builder
         * 
         */
        public Builder ruleNumber(@Nullable Output<Integer> ruleNumber) {
            $.ruleNumber = ruleNumber;
            return this;
        }

        /**
         * @param ruleNumber The rule number for the entry (for example, 100). ACL entries are processed in ascending order by rule number.
         * 
         * @return builder
         * 
         */
        public Builder ruleNumber(Integer ruleNumber) {
            return ruleNumber(Output.of(ruleNumber));
        }

        /**
         * @param toPort The to port to match.
         * 
         * @return builder
         * 
         */
        public Builder toPort(@Nullable Output<Integer> toPort) {
            $.toPort = toPort;
            return this;
        }

        /**
         * @param toPort The to port to match.
         * 
         * @return builder
         * 
         */
        public Builder toPort(Integer toPort) {
            return toPort(Output.of(toPort));
        }

        public NetworkAclRuleState build() {
            return $;
        }
    }

}
