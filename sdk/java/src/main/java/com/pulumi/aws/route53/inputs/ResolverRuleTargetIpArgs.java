// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ResolverRuleTargetIpArgs extends com.pulumi.resources.ResourceArgs {

    public static final ResolverRuleTargetIpArgs Empty = new ResolverRuleTargetIpArgs();

    /**
     * One IPv4 address that you want to forward DNS queries to.
     * 
     */
    @Import(name="ip")
    private @Nullable Output<String> ip;

    /**
     * @return One IPv4 address that you want to forward DNS queries to.
     * 
     */
    public Optional<Output<String>> ip() {
        return Optional.ofNullable(this.ip);
    }

    /**
     * One IPv6 address that you want to forward DNS queries to.
     * 
     */
    @Import(name="ipv6")
    private @Nullable Output<String> ipv6;

    /**
     * @return One IPv6 address that you want to forward DNS queries to.
     * 
     */
    public Optional<Output<String>> ipv6() {
        return Optional.ofNullable(this.ipv6);
    }

    /**
     * Port at `ip` that you want to forward DNS queries to. Default value is `53`.
     * 
     */
    @Import(name="port")
    private @Nullable Output<Integer> port;

    /**
     * @return Port at `ip` that you want to forward DNS queries to. Default value is `53`.
     * 
     */
    public Optional<Output<Integer>> port() {
        return Optional.ofNullable(this.port);
    }

    /**
     * Protocol for the resolver endpoint. Valid values can be found in the [AWS documentation](https://docs.aws.amazon.com/Route53/latest/APIReference/API_route53resolver_TargetAddress.html). Default value is `Do53`.
     * 
     */
    @Import(name="protocol")
    private @Nullable Output<String> protocol;

    /**
     * @return Protocol for the resolver endpoint. Valid values can be found in the [AWS documentation](https://docs.aws.amazon.com/Route53/latest/APIReference/API_route53resolver_TargetAddress.html). Default value is `Do53`.
     * 
     */
    public Optional<Output<String>> protocol() {
        return Optional.ofNullable(this.protocol);
    }

    private ResolverRuleTargetIpArgs() {}

    private ResolverRuleTargetIpArgs(ResolverRuleTargetIpArgs $) {
        this.ip = $.ip;
        this.ipv6 = $.ipv6;
        this.port = $.port;
        this.protocol = $.protocol;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ResolverRuleTargetIpArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ResolverRuleTargetIpArgs $;

        public Builder() {
            $ = new ResolverRuleTargetIpArgs();
        }

        public Builder(ResolverRuleTargetIpArgs defaults) {
            $ = new ResolverRuleTargetIpArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param ip One IPv4 address that you want to forward DNS queries to.
         * 
         * @return builder
         * 
         */
        public Builder ip(@Nullable Output<String> ip) {
            $.ip = ip;
            return this;
        }

        /**
         * @param ip One IPv4 address that you want to forward DNS queries to.
         * 
         * @return builder
         * 
         */
        public Builder ip(String ip) {
            return ip(Output.of(ip));
        }

        /**
         * @param ipv6 One IPv6 address that you want to forward DNS queries to.
         * 
         * @return builder
         * 
         */
        public Builder ipv6(@Nullable Output<String> ipv6) {
            $.ipv6 = ipv6;
            return this;
        }

        /**
         * @param ipv6 One IPv6 address that you want to forward DNS queries to.
         * 
         * @return builder
         * 
         */
        public Builder ipv6(String ipv6) {
            return ipv6(Output.of(ipv6));
        }

        /**
         * @param port Port at `ip` that you want to forward DNS queries to. Default value is `53`.
         * 
         * @return builder
         * 
         */
        public Builder port(@Nullable Output<Integer> port) {
            $.port = port;
            return this;
        }

        /**
         * @param port Port at `ip` that you want to forward DNS queries to. Default value is `53`.
         * 
         * @return builder
         * 
         */
        public Builder port(Integer port) {
            return port(Output.of(port));
        }

        /**
         * @param protocol Protocol for the resolver endpoint. Valid values can be found in the [AWS documentation](https://docs.aws.amazon.com/Route53/latest/APIReference/API_route53resolver_TargetAddress.html). Default value is `Do53`.
         * 
         * @return builder
         * 
         */
        public Builder protocol(@Nullable Output<String> protocol) {
            $.protocol = protocol;
            return this;
        }

        /**
         * @param protocol Protocol for the resolver endpoint. Valid values can be found in the [AWS documentation](https://docs.aws.amazon.com/Route53/latest/APIReference/API_route53resolver_TargetAddress.html). Default value is `Do53`.
         * 
         * @return builder
         * 
         */
        public Builder protocol(String protocol) {
            return protocol(Output.of(protocol));
        }

        public ResolverRuleTargetIpArgs build() {
            return $;
        }
    }

}
