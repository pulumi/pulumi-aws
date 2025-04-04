// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedaccess.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class EndpointRdsOptionsArgs extends com.pulumi.resources.ResourceArgs {

    public static final EndpointRdsOptionsArgs Empty = new EndpointRdsOptionsArgs();

    @Import(name="port")
    private @Nullable Output<Integer> port;

    public Optional<Output<Integer>> port() {
        return Optional.ofNullable(this.port);
    }

    @Import(name="protocol")
    private @Nullable Output<String> protocol;

    public Optional<Output<String>> protocol() {
        return Optional.ofNullable(this.protocol);
    }

    @Import(name="rdsDbClusterArn")
    private @Nullable Output<String> rdsDbClusterArn;

    public Optional<Output<String>> rdsDbClusterArn() {
        return Optional.ofNullable(this.rdsDbClusterArn);
    }

    @Import(name="rdsDbInstanceArn")
    private @Nullable Output<String> rdsDbInstanceArn;

    public Optional<Output<String>> rdsDbInstanceArn() {
        return Optional.ofNullable(this.rdsDbInstanceArn);
    }

    @Import(name="rdsDbProxyArn")
    private @Nullable Output<String> rdsDbProxyArn;

    public Optional<Output<String>> rdsDbProxyArn() {
        return Optional.ofNullable(this.rdsDbProxyArn);
    }

    @Import(name="rdsEndpoint")
    private @Nullable Output<String> rdsEndpoint;

    public Optional<Output<String>> rdsEndpoint() {
        return Optional.ofNullable(this.rdsEndpoint);
    }

    @Import(name="subnetIds")
    private @Nullable Output<List<String>> subnetIds;

    public Optional<Output<List<String>>> subnetIds() {
        return Optional.ofNullable(this.subnetIds);
    }

    private EndpointRdsOptionsArgs() {}

    private EndpointRdsOptionsArgs(EndpointRdsOptionsArgs $) {
        this.port = $.port;
        this.protocol = $.protocol;
        this.rdsDbClusterArn = $.rdsDbClusterArn;
        this.rdsDbInstanceArn = $.rdsDbInstanceArn;
        this.rdsDbProxyArn = $.rdsDbProxyArn;
        this.rdsEndpoint = $.rdsEndpoint;
        this.subnetIds = $.subnetIds;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(EndpointRdsOptionsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private EndpointRdsOptionsArgs $;

        public Builder() {
            $ = new EndpointRdsOptionsArgs();
        }

        public Builder(EndpointRdsOptionsArgs defaults) {
            $ = new EndpointRdsOptionsArgs(Objects.requireNonNull(defaults));
        }

        public Builder port(@Nullable Output<Integer> port) {
            $.port = port;
            return this;
        }

        public Builder port(Integer port) {
            return port(Output.of(port));
        }

        public Builder protocol(@Nullable Output<String> protocol) {
            $.protocol = protocol;
            return this;
        }

        public Builder protocol(String protocol) {
            return protocol(Output.of(protocol));
        }

        public Builder rdsDbClusterArn(@Nullable Output<String> rdsDbClusterArn) {
            $.rdsDbClusterArn = rdsDbClusterArn;
            return this;
        }

        public Builder rdsDbClusterArn(String rdsDbClusterArn) {
            return rdsDbClusterArn(Output.of(rdsDbClusterArn));
        }

        public Builder rdsDbInstanceArn(@Nullable Output<String> rdsDbInstanceArn) {
            $.rdsDbInstanceArn = rdsDbInstanceArn;
            return this;
        }

        public Builder rdsDbInstanceArn(String rdsDbInstanceArn) {
            return rdsDbInstanceArn(Output.of(rdsDbInstanceArn));
        }

        public Builder rdsDbProxyArn(@Nullable Output<String> rdsDbProxyArn) {
            $.rdsDbProxyArn = rdsDbProxyArn;
            return this;
        }

        public Builder rdsDbProxyArn(String rdsDbProxyArn) {
            return rdsDbProxyArn(Output.of(rdsDbProxyArn));
        }

        public Builder rdsEndpoint(@Nullable Output<String> rdsEndpoint) {
            $.rdsEndpoint = rdsEndpoint;
            return this;
        }

        public Builder rdsEndpoint(String rdsEndpoint) {
            return rdsEndpoint(Output.of(rdsEndpoint));
        }

        public Builder subnetIds(@Nullable Output<List<String>> subnetIds) {
            $.subnetIds = subnetIds;
            return this;
        }

        public Builder subnetIds(List<String> subnetIds) {
            return subnetIds(Output.of(subnetIds));
        }

        public Builder subnetIds(String... subnetIds) {
            return subnetIds(List.of(subnetIds));
        }

        public EndpointRdsOptionsArgs build() {
            return $;
        }
    }

}
