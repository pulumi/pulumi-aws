// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class InstanceInstanceMarketOptionsSpotOptionsArgs extends com.pulumi.resources.ResourceArgs {

    public static final InstanceInstanceMarketOptionsSpotOptionsArgs Empty = new InstanceInstanceMarketOptionsSpotOptionsArgs();

    /**
     * The behavior when a Spot Instance is interrupted. Valid values include `hibernate`, `stop`, `terminate` . The default is `terminate`.
     * 
     */
    @Import(name="instanceInterruptionBehavior")
    private @Nullable Output<String> instanceInterruptionBehavior;

    /**
     * @return The behavior when a Spot Instance is interrupted. Valid values include `hibernate`, `stop`, `terminate` . The default is `terminate`.
     * 
     */
    public Optional<Output<String>> instanceInterruptionBehavior() {
        return Optional.ofNullable(this.instanceInterruptionBehavior);
    }

    /**
     * The maximum hourly price that you&#39;re willing to pay for a Spot Instance.
     * 
     */
    @Import(name="maxPrice")
    private @Nullable Output<String> maxPrice;

    /**
     * @return The maximum hourly price that you&#39;re willing to pay for a Spot Instance.
     * 
     */
    public Optional<Output<String>> maxPrice() {
        return Optional.ofNullable(this.maxPrice);
    }

    /**
     * The Spot Instance request type. Valid values include `one-time`, `persistent`. Persistent Spot Instance requests are only supported when the instance interruption behavior is either hibernate or stop. The default is `one-time`.
     * 
     */
    @Import(name="spotInstanceType")
    private @Nullable Output<String> spotInstanceType;

    /**
     * @return The Spot Instance request type. Valid values include `one-time`, `persistent`. Persistent Spot Instance requests are only supported when the instance interruption behavior is either hibernate or stop. The default is `one-time`.
     * 
     */
    public Optional<Output<String>> spotInstanceType() {
        return Optional.ofNullable(this.spotInstanceType);
    }

    /**
     * The end date of the request, in UTC format (YYYY-MM-DDTHH:MM:SSZ). Supported only for persistent requests.
     * 
     */
    @Import(name="validUntil")
    private @Nullable Output<String> validUntil;

    /**
     * @return The end date of the request, in UTC format (YYYY-MM-DDTHH:MM:SSZ). Supported only for persistent requests.
     * 
     */
    public Optional<Output<String>> validUntil() {
        return Optional.ofNullable(this.validUntil);
    }

    private InstanceInstanceMarketOptionsSpotOptionsArgs() {}

    private InstanceInstanceMarketOptionsSpotOptionsArgs(InstanceInstanceMarketOptionsSpotOptionsArgs $) {
        this.instanceInterruptionBehavior = $.instanceInterruptionBehavior;
        this.maxPrice = $.maxPrice;
        this.spotInstanceType = $.spotInstanceType;
        this.validUntil = $.validUntil;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(InstanceInstanceMarketOptionsSpotOptionsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private InstanceInstanceMarketOptionsSpotOptionsArgs $;

        public Builder() {
            $ = new InstanceInstanceMarketOptionsSpotOptionsArgs();
        }

        public Builder(InstanceInstanceMarketOptionsSpotOptionsArgs defaults) {
            $ = new InstanceInstanceMarketOptionsSpotOptionsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param instanceInterruptionBehavior The behavior when a Spot Instance is interrupted. Valid values include `hibernate`, `stop`, `terminate` . The default is `terminate`.
         * 
         * @return builder
         * 
         */
        public Builder instanceInterruptionBehavior(@Nullable Output<String> instanceInterruptionBehavior) {
            $.instanceInterruptionBehavior = instanceInterruptionBehavior;
            return this;
        }

        /**
         * @param instanceInterruptionBehavior The behavior when a Spot Instance is interrupted. Valid values include `hibernate`, `stop`, `terminate` . The default is `terminate`.
         * 
         * @return builder
         * 
         */
        public Builder instanceInterruptionBehavior(String instanceInterruptionBehavior) {
            return instanceInterruptionBehavior(Output.of(instanceInterruptionBehavior));
        }

        /**
         * @param maxPrice The maximum hourly price that you&#39;re willing to pay for a Spot Instance.
         * 
         * @return builder
         * 
         */
        public Builder maxPrice(@Nullable Output<String> maxPrice) {
            $.maxPrice = maxPrice;
            return this;
        }

        /**
         * @param maxPrice The maximum hourly price that you&#39;re willing to pay for a Spot Instance.
         * 
         * @return builder
         * 
         */
        public Builder maxPrice(String maxPrice) {
            return maxPrice(Output.of(maxPrice));
        }

        /**
         * @param spotInstanceType The Spot Instance request type. Valid values include `one-time`, `persistent`. Persistent Spot Instance requests are only supported when the instance interruption behavior is either hibernate or stop. The default is `one-time`.
         * 
         * @return builder
         * 
         */
        public Builder spotInstanceType(@Nullable Output<String> spotInstanceType) {
            $.spotInstanceType = spotInstanceType;
            return this;
        }

        /**
         * @param spotInstanceType The Spot Instance request type. Valid values include `one-time`, `persistent`. Persistent Spot Instance requests are only supported when the instance interruption behavior is either hibernate or stop. The default is `one-time`.
         * 
         * @return builder
         * 
         */
        public Builder spotInstanceType(String spotInstanceType) {
            return spotInstanceType(Output.of(spotInstanceType));
        }

        /**
         * @param validUntil The end date of the request, in UTC format (YYYY-MM-DDTHH:MM:SSZ). Supported only for persistent requests.
         * 
         * @return builder
         * 
         */
        public Builder validUntil(@Nullable Output<String> validUntil) {
            $.validUntil = validUntil;
            return this;
        }

        /**
         * @param validUntil The end date of the request, in UTC format (YYYY-MM-DDTHH:MM:SSZ). Supported only for persistent requests.
         * 
         * @return builder
         * 
         */
        public Builder validUntil(String validUntil) {
            return validUntil(Output.of(validUntil));
        }

        public InstanceInstanceMarketOptionsSpotOptionsArgs build() {
            return $;
        }
    }

}
