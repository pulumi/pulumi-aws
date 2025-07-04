// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class StaticIpState extends com.pulumi.resources.ResourceArgs {

    public static final StaticIpState Empty = new StaticIpState();

    /**
     * ARN of the Lightsail static IP.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the Lightsail static IP.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Allocated static IP address.
     * 
     */
    @Import(name="ipAddress")
    private @Nullable Output<String> ipAddress;

    /**
     * @return Allocated static IP address.
     * 
     */
    public Optional<Output<String>> ipAddress() {
        return Optional.ofNullable(this.ipAddress);
    }

    /**
     * Name for the allocated static IP.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name for the allocated static IP.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Support code for the static IP. Include this code in your email to support when you have questions about a static IP in Lightsail. This code enables our support team to look up your Lightsail information more easily.
     * 
     */
    @Import(name="supportCode")
    private @Nullable Output<String> supportCode;

    /**
     * @return Support code for the static IP. Include this code in your email to support when you have questions about a static IP in Lightsail. This code enables our support team to look up your Lightsail information more easily.
     * 
     */
    public Optional<Output<String>> supportCode() {
        return Optional.ofNullable(this.supportCode);
    }

    private StaticIpState() {}

    private StaticIpState(StaticIpState $) {
        this.arn = $.arn;
        this.ipAddress = $.ipAddress;
        this.name = $.name;
        this.supportCode = $.supportCode;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(StaticIpState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private StaticIpState $;

        public Builder() {
            $ = new StaticIpState();
        }

        public Builder(StaticIpState defaults) {
            $ = new StaticIpState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of the Lightsail static IP.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the Lightsail static IP.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param ipAddress Allocated static IP address.
         * 
         * @return builder
         * 
         */
        public Builder ipAddress(@Nullable Output<String> ipAddress) {
            $.ipAddress = ipAddress;
            return this;
        }

        /**
         * @param ipAddress Allocated static IP address.
         * 
         * @return builder
         * 
         */
        public Builder ipAddress(String ipAddress) {
            return ipAddress(Output.of(ipAddress));
        }

        /**
         * @param name Name for the allocated static IP.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name for the allocated static IP.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param supportCode Support code for the static IP. Include this code in your email to support when you have questions about a static IP in Lightsail. This code enables our support team to look up your Lightsail information more easily.
         * 
         * @return builder
         * 
         */
        public Builder supportCode(@Nullable Output<String> supportCode) {
            $.supportCode = supportCode;
            return this;
        }

        /**
         * @param supportCode Support code for the static IP. Include this code in your email to support when you have questions about a static IP in Lightsail. This code enables our support team to look up your Lightsail information more easily.
         * 
         * @return builder
         * 
         */
        public Builder supportCode(String supportCode) {
            return supportCode(Output.of(supportCode));
        }

        public StaticIpState build() {
            return $;
        }
    }

}
