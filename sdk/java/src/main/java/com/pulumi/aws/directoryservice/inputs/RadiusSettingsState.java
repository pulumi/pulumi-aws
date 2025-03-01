// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.directoryservice.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RadiusSettingsState extends com.pulumi.resources.ResourceArgs {

    public static final RadiusSettingsState Empty = new RadiusSettingsState();

    /**
     * The protocol specified for your RADIUS endpoints. Valid values: `PAP`, `CHAP`, `MS-CHAPv1`, `MS-CHAPv2`.
     * 
     */
    @Import(name="authenticationProtocol")
    private @Nullable Output<String> authenticationProtocol;

    /**
     * @return The protocol specified for your RADIUS endpoints. Valid values: `PAP`, `CHAP`, `MS-CHAPv1`, `MS-CHAPv2`.
     * 
     */
    public Optional<Output<String>> authenticationProtocol() {
        return Optional.ofNullable(this.authenticationProtocol);
    }

    /**
     * The identifier of the directory for which you want to manager RADIUS settings.
     * 
     */
    @Import(name="directoryId")
    private @Nullable Output<String> directoryId;

    /**
     * @return The identifier of the directory for which you want to manager RADIUS settings.
     * 
     */
    public Optional<Output<String>> directoryId() {
        return Optional.ofNullable(this.directoryId);
    }

    /**
     * Display label.
     * 
     */
    @Import(name="displayLabel")
    private @Nullable Output<String> displayLabel;

    /**
     * @return Display label.
     * 
     */
    public Optional<Output<String>> displayLabel() {
        return Optional.ofNullable(this.displayLabel);
    }

    /**
     * The port that your RADIUS server is using for communications. Your self-managed network must allow inbound traffic over this port from the AWS Directory Service servers.
     * 
     */
    @Import(name="radiusPort")
    private @Nullable Output<Integer> radiusPort;

    /**
     * @return The port that your RADIUS server is using for communications. Your self-managed network must allow inbound traffic over this port from the AWS Directory Service servers.
     * 
     */
    public Optional<Output<Integer>> radiusPort() {
        return Optional.ofNullable(this.radiusPort);
    }

    /**
     * The maximum number of times that communication with the RADIUS server is attempted. Minimum value of `0`. Maximum value of `10`.
     * 
     */
    @Import(name="radiusRetries")
    private @Nullable Output<Integer> radiusRetries;

    /**
     * @return The maximum number of times that communication with the RADIUS server is attempted. Minimum value of `0`. Maximum value of `10`.
     * 
     */
    public Optional<Output<Integer>> radiusRetries() {
        return Optional.ofNullable(this.radiusRetries);
    }

    /**
     * An array of strings that contains the fully qualified domain name (FQDN) or IP addresses of the RADIUS server endpoints, or the FQDN or IP addresses of your RADIUS server load balancer.
     * 
     */
    @Import(name="radiusServers")
    private @Nullable Output<List<String>> radiusServers;

    /**
     * @return An array of strings that contains the fully qualified domain name (FQDN) or IP addresses of the RADIUS server endpoints, or the FQDN or IP addresses of your RADIUS server load balancer.
     * 
     */
    public Optional<Output<List<String>>> radiusServers() {
        return Optional.ofNullable(this.radiusServers);
    }

    /**
     * The amount of time, in seconds, to wait for the RADIUS server to respond. Minimum value of `1`. Maximum value of `50`.
     * 
     */
    @Import(name="radiusTimeout")
    private @Nullable Output<Integer> radiusTimeout;

    /**
     * @return The amount of time, in seconds, to wait for the RADIUS server to respond. Minimum value of `1`. Maximum value of `50`.
     * 
     */
    public Optional<Output<Integer>> radiusTimeout() {
        return Optional.ofNullable(this.radiusTimeout);
    }

    /**
     * Required for enabling RADIUS on the directory.
     * 
     */
    @Import(name="sharedSecret")
    private @Nullable Output<String> sharedSecret;

    /**
     * @return Required for enabling RADIUS on the directory.
     * 
     */
    public Optional<Output<String>> sharedSecret() {
        return Optional.ofNullable(this.sharedSecret);
    }

    /**
     * Not currently used.
     * 
     */
    @Import(name="useSameUsername")
    private @Nullable Output<Boolean> useSameUsername;

    /**
     * @return Not currently used.
     * 
     */
    public Optional<Output<Boolean>> useSameUsername() {
        return Optional.ofNullable(this.useSameUsername);
    }

    private RadiusSettingsState() {}

    private RadiusSettingsState(RadiusSettingsState $) {
        this.authenticationProtocol = $.authenticationProtocol;
        this.directoryId = $.directoryId;
        this.displayLabel = $.displayLabel;
        this.radiusPort = $.radiusPort;
        this.radiusRetries = $.radiusRetries;
        this.radiusServers = $.radiusServers;
        this.radiusTimeout = $.radiusTimeout;
        this.sharedSecret = $.sharedSecret;
        this.useSameUsername = $.useSameUsername;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RadiusSettingsState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RadiusSettingsState $;

        public Builder() {
            $ = new RadiusSettingsState();
        }

        public Builder(RadiusSettingsState defaults) {
            $ = new RadiusSettingsState(Objects.requireNonNull(defaults));
        }

        /**
         * @param authenticationProtocol The protocol specified for your RADIUS endpoints. Valid values: `PAP`, `CHAP`, `MS-CHAPv1`, `MS-CHAPv2`.
         * 
         * @return builder
         * 
         */
        public Builder authenticationProtocol(@Nullable Output<String> authenticationProtocol) {
            $.authenticationProtocol = authenticationProtocol;
            return this;
        }

        /**
         * @param authenticationProtocol The protocol specified for your RADIUS endpoints. Valid values: `PAP`, `CHAP`, `MS-CHAPv1`, `MS-CHAPv2`.
         * 
         * @return builder
         * 
         */
        public Builder authenticationProtocol(String authenticationProtocol) {
            return authenticationProtocol(Output.of(authenticationProtocol));
        }

        /**
         * @param directoryId The identifier of the directory for which you want to manager RADIUS settings.
         * 
         * @return builder
         * 
         */
        public Builder directoryId(@Nullable Output<String> directoryId) {
            $.directoryId = directoryId;
            return this;
        }

        /**
         * @param directoryId The identifier of the directory for which you want to manager RADIUS settings.
         * 
         * @return builder
         * 
         */
        public Builder directoryId(String directoryId) {
            return directoryId(Output.of(directoryId));
        }

        /**
         * @param displayLabel Display label.
         * 
         * @return builder
         * 
         */
        public Builder displayLabel(@Nullable Output<String> displayLabel) {
            $.displayLabel = displayLabel;
            return this;
        }

        /**
         * @param displayLabel Display label.
         * 
         * @return builder
         * 
         */
        public Builder displayLabel(String displayLabel) {
            return displayLabel(Output.of(displayLabel));
        }

        /**
         * @param radiusPort The port that your RADIUS server is using for communications. Your self-managed network must allow inbound traffic over this port from the AWS Directory Service servers.
         * 
         * @return builder
         * 
         */
        public Builder radiusPort(@Nullable Output<Integer> radiusPort) {
            $.radiusPort = radiusPort;
            return this;
        }

        /**
         * @param radiusPort The port that your RADIUS server is using for communications. Your self-managed network must allow inbound traffic over this port from the AWS Directory Service servers.
         * 
         * @return builder
         * 
         */
        public Builder radiusPort(Integer radiusPort) {
            return radiusPort(Output.of(radiusPort));
        }

        /**
         * @param radiusRetries The maximum number of times that communication with the RADIUS server is attempted. Minimum value of `0`. Maximum value of `10`.
         * 
         * @return builder
         * 
         */
        public Builder radiusRetries(@Nullable Output<Integer> radiusRetries) {
            $.radiusRetries = radiusRetries;
            return this;
        }

        /**
         * @param radiusRetries The maximum number of times that communication with the RADIUS server is attempted. Minimum value of `0`. Maximum value of `10`.
         * 
         * @return builder
         * 
         */
        public Builder radiusRetries(Integer radiusRetries) {
            return radiusRetries(Output.of(radiusRetries));
        }

        /**
         * @param radiusServers An array of strings that contains the fully qualified domain name (FQDN) or IP addresses of the RADIUS server endpoints, or the FQDN or IP addresses of your RADIUS server load balancer.
         * 
         * @return builder
         * 
         */
        public Builder radiusServers(@Nullable Output<List<String>> radiusServers) {
            $.radiusServers = radiusServers;
            return this;
        }

        /**
         * @param radiusServers An array of strings that contains the fully qualified domain name (FQDN) or IP addresses of the RADIUS server endpoints, or the FQDN or IP addresses of your RADIUS server load balancer.
         * 
         * @return builder
         * 
         */
        public Builder radiusServers(List<String> radiusServers) {
            return radiusServers(Output.of(radiusServers));
        }

        /**
         * @param radiusServers An array of strings that contains the fully qualified domain name (FQDN) or IP addresses of the RADIUS server endpoints, or the FQDN or IP addresses of your RADIUS server load balancer.
         * 
         * @return builder
         * 
         */
        public Builder radiusServers(String... radiusServers) {
            return radiusServers(List.of(radiusServers));
        }

        /**
         * @param radiusTimeout The amount of time, in seconds, to wait for the RADIUS server to respond. Minimum value of `1`. Maximum value of `50`.
         * 
         * @return builder
         * 
         */
        public Builder radiusTimeout(@Nullable Output<Integer> radiusTimeout) {
            $.radiusTimeout = radiusTimeout;
            return this;
        }

        /**
         * @param radiusTimeout The amount of time, in seconds, to wait for the RADIUS server to respond. Minimum value of `1`. Maximum value of `50`.
         * 
         * @return builder
         * 
         */
        public Builder radiusTimeout(Integer radiusTimeout) {
            return radiusTimeout(Output.of(radiusTimeout));
        }

        /**
         * @param sharedSecret Required for enabling RADIUS on the directory.
         * 
         * @return builder
         * 
         */
        public Builder sharedSecret(@Nullable Output<String> sharedSecret) {
            $.sharedSecret = sharedSecret;
            return this;
        }

        /**
         * @param sharedSecret Required for enabling RADIUS on the directory.
         * 
         * @return builder
         * 
         */
        public Builder sharedSecret(String sharedSecret) {
            return sharedSecret(Output.of(sharedSecret));
        }

        /**
         * @param useSameUsername Not currently used.
         * 
         * @return builder
         * 
         */
        public Builder useSameUsername(@Nullable Output<Boolean> useSameUsername) {
            $.useSameUsername = useSameUsername;
            return this;
        }

        /**
         * @param useSameUsername Not currently used.
         * 
         * @return builder
         * 
         */
        public Builder useSameUsername(Boolean useSameUsername) {
            return useSameUsername(Output.of(useSameUsername));
        }

        public RadiusSettingsState build() {
            return $;
        }
    }

}
