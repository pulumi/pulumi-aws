// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2;

import com.pulumi.aws.ec2.enums.ProtocolType;
import com.pulumi.core.Either;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class SecurityGroupRuleArgs extends com.pulumi.resources.ResourceArgs {

    public static final SecurityGroupRuleArgs Empty = new SecurityGroupRuleArgs();

    /**
     * List of CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
     * 
     */
    @Import(name="cidrBlocks")
    private @Nullable Output<List<String>> cidrBlocks;

    /**
     * @return List of CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
     * 
     */
    public Optional<Output<List<String>>> cidrBlocks() {
        return Optional.ofNullable(this.cidrBlocks);
    }

    /**
     * Description of the rule.
     * 
     */
    @Import(name="description")
    private @Nullable Output<String> description;

    /**
     * @return Description of the rule.
     * 
     */
    public Optional<Output<String>> description() {
        return Optional.ofNullable(this.description);
    }

    /**
     * Start port (or ICMP type number if protocol is &#34;icmp&#34; or &#34;icmpv6&#34;).
     * 
     */
    @Import(name="fromPort", required=true)
    private Output<Integer> fromPort;

    /**
     * @return Start port (or ICMP type number if protocol is &#34;icmp&#34; or &#34;icmpv6&#34;).
     * 
     */
    public Output<Integer> fromPort() {
        return this.fromPort;
    }

    /**
     * List of IPv6 CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
     * 
     */
    @Import(name="ipv6CidrBlocks")
    private @Nullable Output<List<String>> ipv6CidrBlocks;

    /**
     * @return List of IPv6 CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
     * 
     */
    public Optional<Output<List<String>>> ipv6CidrBlocks() {
        return Optional.ofNullable(this.ipv6CidrBlocks);
    }

    /**
     * List of Prefix List IDs.
     * 
     */
    @Import(name="prefixListIds")
    private @Nullable Output<List<String>> prefixListIds;

    /**
     * @return List of Prefix List IDs.
     * 
     */
    public Optional<Output<List<String>>> prefixListIds() {
        return Optional.ofNullable(this.prefixListIds);
    }

    /**
     * Protocol. If not icmp, icmpv6, tcp, udp, or all use the [protocol number](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml)
     * 
     */
    @Import(name="protocol", required=true)
    private Output<Either<String,ProtocolType>> protocol;

    /**
     * @return Protocol. If not icmp, icmpv6, tcp, udp, or all use the [protocol number](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml)
     * 
     */
    public Output<Either<String,ProtocolType>> protocol() {
        return this.protocol;
    }

    /**
     * Security group to apply this rule to.
     * 
     */
    @Import(name="securityGroupId", required=true)
    private Output<String> securityGroupId;

    /**
     * @return Security group to apply this rule to.
     * 
     */
    public Output<String> securityGroupId() {
        return this.securityGroupId;
    }

    /**
     * Whether the security group itself will be added as a source to this ingress rule. Cannot be specified with `cidr_blocks`, `ipv6_cidr_blocks`, or `source_security_group_id`.
     * 
     */
    @Import(name="self")
    private @Nullable Output<Boolean> self;

    /**
     * @return Whether the security group itself will be added as a source to this ingress rule. Cannot be specified with `cidr_blocks`, `ipv6_cidr_blocks`, or `source_security_group_id`.
     * 
     */
    public Optional<Output<Boolean>> self() {
        return Optional.ofNullable(this.self);
    }

    /**
     * Security group id to allow access to/from, depending on the `type`. Cannot be specified with `cidr_blocks`, `ipv6_cidr_blocks`, or `self`.
     * 
     */
    @Import(name="sourceSecurityGroupId")
    private @Nullable Output<String> sourceSecurityGroupId;

    /**
     * @return Security group id to allow access to/from, depending on the `type`. Cannot be specified with `cidr_blocks`, `ipv6_cidr_blocks`, or `self`.
     * 
     */
    public Optional<Output<String>> sourceSecurityGroupId() {
        return Optional.ofNullable(this.sourceSecurityGroupId);
    }

    /**
     * End port (or ICMP code if protocol is &#34;icmp&#34;).
     * 
     */
    @Import(name="toPort", required=true)
    private Output<Integer> toPort;

    /**
     * @return End port (or ICMP code if protocol is &#34;icmp&#34;).
     * 
     */
    public Output<Integer> toPort() {
        return this.toPort;
    }

    /**
     * Type of rule being created. Valid options are `ingress` (inbound)
     * or `egress` (outbound).
     * 
     * The following arguments are optional:
     * 
     * &gt; **Note** Although `cidr_blocks`, `ipv6_cidr_blocks`, `prefix_list_ids`, and `source_security_group_id` are all marked as optional, you _must_ provide one of them in order to configure the source of the traffic.
     * 
     */
    @Import(name="type", required=true)
    private Output<String> type;

    /**
     * @return Type of rule being created. Valid options are `ingress` (inbound)
     * or `egress` (outbound).
     * 
     * The following arguments are optional:
     * 
     * &gt; **Note** Although `cidr_blocks`, `ipv6_cidr_blocks`, `prefix_list_ids`, and `source_security_group_id` are all marked as optional, you _must_ provide one of them in order to configure the source of the traffic.
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    private SecurityGroupRuleArgs() {}

    private SecurityGroupRuleArgs(SecurityGroupRuleArgs $) {
        this.cidrBlocks = $.cidrBlocks;
        this.description = $.description;
        this.fromPort = $.fromPort;
        this.ipv6CidrBlocks = $.ipv6CidrBlocks;
        this.prefixListIds = $.prefixListIds;
        this.protocol = $.protocol;
        this.securityGroupId = $.securityGroupId;
        this.self = $.self;
        this.sourceSecurityGroupId = $.sourceSecurityGroupId;
        this.toPort = $.toPort;
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SecurityGroupRuleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SecurityGroupRuleArgs $;

        public Builder() {
            $ = new SecurityGroupRuleArgs();
        }

        public Builder(SecurityGroupRuleArgs defaults) {
            $ = new SecurityGroupRuleArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param cidrBlocks List of CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
         * 
         * @return builder
         * 
         */
        public Builder cidrBlocks(@Nullable Output<List<String>> cidrBlocks) {
            $.cidrBlocks = cidrBlocks;
            return this;
        }

        /**
         * @param cidrBlocks List of CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
         * 
         * @return builder
         * 
         */
        public Builder cidrBlocks(List<String> cidrBlocks) {
            return cidrBlocks(Output.of(cidrBlocks));
        }

        /**
         * @param cidrBlocks List of CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
         * 
         * @return builder
         * 
         */
        public Builder cidrBlocks(String... cidrBlocks) {
            return cidrBlocks(List.of(cidrBlocks));
        }

        /**
         * @param description Description of the rule.
         * 
         * @return builder
         * 
         */
        public Builder description(@Nullable Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description Description of the rule.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param fromPort Start port (or ICMP type number if protocol is &#34;icmp&#34; or &#34;icmpv6&#34;).
         * 
         * @return builder
         * 
         */
        public Builder fromPort(Output<Integer> fromPort) {
            $.fromPort = fromPort;
            return this;
        }

        /**
         * @param fromPort Start port (or ICMP type number if protocol is &#34;icmp&#34; or &#34;icmpv6&#34;).
         * 
         * @return builder
         * 
         */
        public Builder fromPort(Integer fromPort) {
            return fromPort(Output.of(fromPort));
        }

        /**
         * @param ipv6CidrBlocks List of IPv6 CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
         * 
         * @return builder
         * 
         */
        public Builder ipv6CidrBlocks(@Nullable Output<List<String>> ipv6CidrBlocks) {
            $.ipv6CidrBlocks = ipv6CidrBlocks;
            return this;
        }

        /**
         * @param ipv6CidrBlocks List of IPv6 CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
         * 
         * @return builder
         * 
         */
        public Builder ipv6CidrBlocks(List<String> ipv6CidrBlocks) {
            return ipv6CidrBlocks(Output.of(ipv6CidrBlocks));
        }

        /**
         * @param ipv6CidrBlocks List of IPv6 CIDR blocks. Cannot be specified with `source_security_group_id` or `self`.
         * 
         * @return builder
         * 
         */
        public Builder ipv6CidrBlocks(String... ipv6CidrBlocks) {
            return ipv6CidrBlocks(List.of(ipv6CidrBlocks));
        }

        /**
         * @param prefixListIds List of Prefix List IDs.
         * 
         * @return builder
         * 
         */
        public Builder prefixListIds(@Nullable Output<List<String>> prefixListIds) {
            $.prefixListIds = prefixListIds;
            return this;
        }

        /**
         * @param prefixListIds List of Prefix List IDs.
         * 
         * @return builder
         * 
         */
        public Builder prefixListIds(List<String> prefixListIds) {
            return prefixListIds(Output.of(prefixListIds));
        }

        /**
         * @param prefixListIds List of Prefix List IDs.
         * 
         * @return builder
         * 
         */
        public Builder prefixListIds(String... prefixListIds) {
            return prefixListIds(List.of(prefixListIds));
        }

        /**
         * @param protocol Protocol. If not icmp, icmpv6, tcp, udp, or all use the [protocol number](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml)
         * 
         * @return builder
         * 
         */
        public Builder protocol(Output<Either<String,ProtocolType>> protocol) {
            $.protocol = protocol;
            return this;
        }

        /**
         * @param protocol Protocol. If not icmp, icmpv6, tcp, udp, or all use the [protocol number](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml)
         * 
         * @return builder
         * 
         */
        public Builder protocol(Either<String,ProtocolType> protocol) {
            return protocol(Output.of(protocol));
        }

        /**
         * @param protocol Protocol. If not icmp, icmpv6, tcp, udp, or all use the [protocol number](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml)
         * 
         * @return builder
         * 
         */
        public Builder protocol(String protocol) {
            return protocol(Either.ofLeft(protocol));
        }

        /**
         * @param protocol Protocol. If not icmp, icmpv6, tcp, udp, or all use the [protocol number](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml)
         * 
         * @return builder
         * 
         */
        public Builder protocol(ProtocolType protocol) {
            return protocol(Either.ofRight(protocol));
        }

        /**
         * @param securityGroupId Security group to apply this rule to.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupId(Output<String> securityGroupId) {
            $.securityGroupId = securityGroupId;
            return this;
        }

        /**
         * @param securityGroupId Security group to apply this rule to.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupId(String securityGroupId) {
            return securityGroupId(Output.of(securityGroupId));
        }

        /**
         * @param self Whether the security group itself will be added as a source to this ingress rule. Cannot be specified with `cidr_blocks`, `ipv6_cidr_blocks`, or `source_security_group_id`.
         * 
         * @return builder
         * 
         */
        public Builder self(@Nullable Output<Boolean> self) {
            $.self = self;
            return this;
        }

        /**
         * @param self Whether the security group itself will be added as a source to this ingress rule. Cannot be specified with `cidr_blocks`, `ipv6_cidr_blocks`, or `source_security_group_id`.
         * 
         * @return builder
         * 
         */
        public Builder self(Boolean self) {
            return self(Output.of(self));
        }

        /**
         * @param sourceSecurityGroupId Security group id to allow access to/from, depending on the `type`. Cannot be specified with `cidr_blocks`, `ipv6_cidr_blocks`, or `self`.
         * 
         * @return builder
         * 
         */
        public Builder sourceSecurityGroupId(@Nullable Output<String> sourceSecurityGroupId) {
            $.sourceSecurityGroupId = sourceSecurityGroupId;
            return this;
        }

        /**
         * @param sourceSecurityGroupId Security group id to allow access to/from, depending on the `type`. Cannot be specified with `cidr_blocks`, `ipv6_cidr_blocks`, or `self`.
         * 
         * @return builder
         * 
         */
        public Builder sourceSecurityGroupId(String sourceSecurityGroupId) {
            return sourceSecurityGroupId(Output.of(sourceSecurityGroupId));
        }

        /**
         * @param toPort End port (or ICMP code if protocol is &#34;icmp&#34;).
         * 
         * @return builder
         * 
         */
        public Builder toPort(Output<Integer> toPort) {
            $.toPort = toPort;
            return this;
        }

        /**
         * @param toPort End port (or ICMP code if protocol is &#34;icmp&#34;).
         * 
         * @return builder
         * 
         */
        public Builder toPort(Integer toPort) {
            return toPort(Output.of(toPort));
        }

        /**
         * @param type Type of rule being created. Valid options are `ingress` (inbound)
         * or `egress` (outbound).
         * 
         * The following arguments are optional:
         * 
         * &gt; **Note** Although `cidr_blocks`, `ipv6_cidr_blocks`, `prefix_list_ids`, and `source_security_group_id` are all marked as optional, you _must_ provide one of them in order to configure the source of the traffic.
         * 
         * @return builder
         * 
         */
        public Builder type(Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type Type of rule being created. Valid options are `ingress` (inbound)
         * or `egress` (outbound).
         * 
         * The following arguments are optional:
         * 
         * &gt; **Note** Although `cidr_blocks`, `ipv6_cidr_blocks`, `prefix_list_ids`, and `source_security_group_id` are all marked as optional, you _must_ provide one of them in order to configure the source of the traffic.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public SecurityGroupRuleArgs build() {
            if ($.fromPort == null) {
                throw new MissingRequiredPropertyException("SecurityGroupRuleArgs", "fromPort");
            }
            if ($.protocol == null) {
                throw new MissingRequiredPropertyException("SecurityGroupRuleArgs", "protocol");
            }
            if ($.securityGroupId == null) {
                throw new MissingRequiredPropertyException("SecurityGroupRuleArgs", "securityGroupId");
            }
            if ($.toPort == null) {
                throw new MissingRequiredPropertyException("SecurityGroupRuleArgs", "toPort");
            }
            if ($.type == null) {
                throw new MissingRequiredPropertyException("SecurityGroupRuleArgs", "type");
            }
            return $;
        }
    }

}
