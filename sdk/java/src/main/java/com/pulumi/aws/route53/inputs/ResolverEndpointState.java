// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.inputs;

import com.pulumi.aws.route53.inputs.ResolverEndpointIpAddressArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ResolverEndpointState extends com.pulumi.resources.ResourceArgs {

    public static final ResolverEndpointState Empty = new ResolverEndpointState();

    /**
     * ARN of the Route 53 Resolver endpoint.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the Route 53 Resolver endpoint.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Direction of DNS queries to or from the Route 53 Resolver endpoint.
     * Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
     * or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
     * 
     */
    @Import(name="direction")
    private @Nullable Output<String> direction;

    /**
     * @return Direction of DNS queries to or from the Route 53 Resolver endpoint.
     * Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
     * or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
     * 
     */
    public Optional<Output<String>> direction() {
        return Optional.ofNullable(this.direction);
    }

    /**
     * ID of the VPC that you want to create the resolver endpoint in.
     * 
     */
    @Import(name="hostVpcId")
    private @Nullable Output<String> hostVpcId;

    /**
     * @return ID of the VPC that you want to create the resolver endpoint in.
     * 
     */
    public Optional<Output<String>> hostVpcId() {
        return Optional.ofNullable(this.hostVpcId);
    }

    /**
     * Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
     * to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
     * 
     */
    @Import(name="ipAddresses")
    private @Nullable Output<List<ResolverEndpointIpAddressArgs>> ipAddresses;

    /**
     * @return Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
     * to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
     * 
     */
    public Optional<Output<List<ResolverEndpointIpAddressArgs>>> ipAddresses() {
        return Optional.ofNullable(this.ipAddresses);
    }

    /**
     * Friendly name of the Route 53 Resolver endpoint.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Friendly name of the Route 53 Resolver endpoint.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Protocols you want to use for the Route 53 Resolver endpoint.
     * Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
     * 
     */
    @Import(name="protocols")
    private @Nullable Output<List<String>> protocols;

    /**
     * @return Protocols you want to use for the Route 53 Resolver endpoint.
     * Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
     * 
     */
    public Optional<Output<List<String>>> protocols() {
        return Optional.ofNullable(this.protocols);
    }

    /**
     * Endpoint IP type. This endpoint type is applied to all IP addresses.
     * Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
     * 
     */
    @Import(name="resolverEndpointType")
    private @Nullable Output<String> resolverEndpointType;

    /**
     * @return Endpoint IP type. This endpoint type is applied to all IP addresses.
     * Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
     * 
     */
    public Optional<Output<String>> resolverEndpointType() {
        return Optional.ofNullable(this.resolverEndpointType);
    }

    /**
     * ID of one or more security groups that you want to use to control access to this VPC.
     * 
     */
    @Import(name="securityGroupIds")
    private @Nullable Output<List<String>> securityGroupIds;

    /**
     * @return ID of one or more security groups that you want to use to control access to this VPC.
     * 
     */
    public Optional<Output<List<String>>> securityGroupIds() {
        return Optional.ofNullable(this.securityGroupIds);
    }

    /**
     * Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    private ResolverEndpointState() {}

    private ResolverEndpointState(ResolverEndpointState $) {
        this.arn = $.arn;
        this.direction = $.direction;
        this.hostVpcId = $.hostVpcId;
        this.ipAddresses = $.ipAddresses;
        this.name = $.name;
        this.protocols = $.protocols;
        this.resolverEndpointType = $.resolverEndpointType;
        this.securityGroupIds = $.securityGroupIds;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ResolverEndpointState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ResolverEndpointState $;

        public Builder() {
            $ = new ResolverEndpointState();
        }

        public Builder(ResolverEndpointState defaults) {
            $ = new ResolverEndpointState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of the Route 53 Resolver endpoint.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the Route 53 Resolver endpoint.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param direction Direction of DNS queries to or from the Route 53 Resolver endpoint.
         * Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
         * or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
         * 
         * @return builder
         * 
         */
        public Builder direction(@Nullable Output<String> direction) {
            $.direction = direction;
            return this;
        }

        /**
         * @param direction Direction of DNS queries to or from the Route 53 Resolver endpoint.
         * Valid values are `INBOUND` (resolver forwards DNS queries to the DNS service for a VPC from your network or another VPC)
         * or `OUTBOUND` (resolver forwards DNS queries from the DNS service for a VPC to your network or another VPC).
         * 
         * @return builder
         * 
         */
        public Builder direction(String direction) {
            return direction(Output.of(direction));
        }

        /**
         * @param hostVpcId ID of the VPC that you want to create the resolver endpoint in.
         * 
         * @return builder
         * 
         */
        public Builder hostVpcId(@Nullable Output<String> hostVpcId) {
            $.hostVpcId = hostVpcId;
            return this;
        }

        /**
         * @param hostVpcId ID of the VPC that you want to create the resolver endpoint in.
         * 
         * @return builder
         * 
         */
        public Builder hostVpcId(String hostVpcId) {
            return hostVpcId(Output.of(hostVpcId));
        }

        /**
         * @param ipAddresses Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
         * to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
         * 
         * @return builder
         * 
         */
        public Builder ipAddresses(@Nullable Output<List<ResolverEndpointIpAddressArgs>> ipAddresses) {
            $.ipAddresses = ipAddresses;
            return this;
        }

        /**
         * @param ipAddresses Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
         * to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
         * 
         * @return builder
         * 
         */
        public Builder ipAddresses(List<ResolverEndpointIpAddressArgs> ipAddresses) {
            return ipAddresses(Output.of(ipAddresses));
        }

        /**
         * @param ipAddresses Subnets and IP addresses in your VPC that you want DNS queries to pass through on the way from your VPCs
         * to your network (for outbound endpoints) or on the way from your network to your VPCs (for inbound endpoints). Described below.
         * 
         * @return builder
         * 
         */
        public Builder ipAddresses(ResolverEndpointIpAddressArgs... ipAddresses) {
            return ipAddresses(List.of(ipAddresses));
        }

        /**
         * @param name Friendly name of the Route 53 Resolver endpoint.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Friendly name of the Route 53 Resolver endpoint.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param protocols Protocols you want to use for the Route 53 Resolver endpoint.
         * Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
         * 
         * @return builder
         * 
         */
        public Builder protocols(@Nullable Output<List<String>> protocols) {
            $.protocols = protocols;
            return this;
        }

        /**
         * @param protocols Protocols you want to use for the Route 53 Resolver endpoint.
         * Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
         * 
         * @return builder
         * 
         */
        public Builder protocols(List<String> protocols) {
            return protocols(Output.of(protocols));
        }

        /**
         * @param protocols Protocols you want to use for the Route 53 Resolver endpoint.
         * Valid values are `DoH`, `Do53`, or `DoH-FIPS`.
         * 
         * @return builder
         * 
         */
        public Builder protocols(String... protocols) {
            return protocols(List.of(protocols));
        }

        /**
         * @param resolverEndpointType Endpoint IP type. This endpoint type is applied to all IP addresses.
         * Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
         * 
         * @return builder
         * 
         */
        public Builder resolverEndpointType(@Nullable Output<String> resolverEndpointType) {
            $.resolverEndpointType = resolverEndpointType;
            return this;
        }

        /**
         * @param resolverEndpointType Endpoint IP type. This endpoint type is applied to all IP addresses.
         * Valid values are `IPV6`,`IPV4` or `DUALSTACK` (both IPv4 and IPv6).
         * 
         * @return builder
         * 
         */
        public Builder resolverEndpointType(String resolverEndpointType) {
            return resolverEndpointType(Output.of(resolverEndpointType));
        }

        /**
         * @param securityGroupIds ID of one or more security groups that you want to use to control access to this VPC.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(@Nullable Output<List<String>> securityGroupIds) {
            $.securityGroupIds = securityGroupIds;
            return this;
        }

        /**
         * @param securityGroupIds ID of one or more security groups that you want to use to control access to this VPC.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(List<String> securityGroupIds) {
            return securityGroupIds(Output.of(securityGroupIds));
        }

        /**
         * @param securityGroupIds ID of one or more security groups that you want to use to control access to this VPC.
         * 
         * @return builder
         * 
         */
        public Builder securityGroupIds(String... securityGroupIds) {
            return securityGroupIds(List.of(securityGroupIds));
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
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
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
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

        public ResolverEndpointState build() {
            return $;
        }
    }

}
