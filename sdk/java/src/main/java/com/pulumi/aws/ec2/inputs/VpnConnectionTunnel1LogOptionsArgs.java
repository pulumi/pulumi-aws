// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.aws.ec2.inputs.VpnConnectionTunnel1LogOptionsCloudwatchLogOptionsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class VpnConnectionTunnel1LogOptionsArgs extends com.pulumi.resources.ResourceArgs {

    public static final VpnConnectionTunnel1LogOptionsArgs Empty = new VpnConnectionTunnel1LogOptionsArgs();

    /**
     * Options for sending VPN tunnel logs to CloudWatch. See CloudWatch Log Options below for more details.
     * 
     */
    @Import(name="cloudwatchLogOptions")
    private @Nullable Output<VpnConnectionTunnel1LogOptionsCloudwatchLogOptionsArgs> cloudwatchLogOptions;

    /**
     * @return Options for sending VPN tunnel logs to CloudWatch. See CloudWatch Log Options below for more details.
     * 
     */
    public Optional<Output<VpnConnectionTunnel1LogOptionsCloudwatchLogOptionsArgs>> cloudwatchLogOptions() {
        return Optional.ofNullable(this.cloudwatchLogOptions);
    }

    private VpnConnectionTunnel1LogOptionsArgs() {}

    private VpnConnectionTunnel1LogOptionsArgs(VpnConnectionTunnel1LogOptionsArgs $) {
        this.cloudwatchLogOptions = $.cloudwatchLogOptions;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(VpnConnectionTunnel1LogOptionsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private VpnConnectionTunnel1LogOptionsArgs $;

        public Builder() {
            $ = new VpnConnectionTunnel1LogOptionsArgs();
        }

        public Builder(VpnConnectionTunnel1LogOptionsArgs defaults) {
            $ = new VpnConnectionTunnel1LogOptionsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param cloudwatchLogOptions Options for sending VPN tunnel logs to CloudWatch. See CloudWatch Log Options below for more details.
         * 
         * @return builder
         * 
         */
        public Builder cloudwatchLogOptions(@Nullable Output<VpnConnectionTunnel1LogOptionsCloudwatchLogOptionsArgs> cloudwatchLogOptions) {
            $.cloudwatchLogOptions = cloudwatchLogOptions;
            return this;
        }

        /**
         * @param cloudwatchLogOptions Options for sending VPN tunnel logs to CloudWatch. See CloudWatch Log Options below for more details.
         * 
         * @return builder
         * 
         */
        public Builder cloudwatchLogOptions(VpnConnectionTunnel1LogOptionsCloudwatchLogOptionsArgs cloudwatchLogOptions) {
            return cloudwatchLogOptions(Output.of(cloudwatchLogOptions));
        }

        public VpnConnectionTunnel1LogOptionsArgs build() {
            return $;
        }
    }

}
