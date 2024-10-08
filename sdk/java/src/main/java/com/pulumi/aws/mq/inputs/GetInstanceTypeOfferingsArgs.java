// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.mq.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetInstanceTypeOfferingsArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetInstanceTypeOfferingsArgs Empty = new GetInstanceTypeOfferingsArgs();

    /**
     * Filter response by engine type.
     * 
     */
    @Import(name="engineType")
    private @Nullable Output<String> engineType;

    /**
     * @return Filter response by engine type.
     * 
     */
    public Optional<Output<String>> engineType() {
        return Optional.ofNullable(this.engineType);
    }

    /**
     * Filter response by host instance type.
     * 
     */
    @Import(name="hostInstanceType")
    private @Nullable Output<String> hostInstanceType;

    /**
     * @return Filter response by host instance type.
     * 
     */
    public Optional<Output<String>> hostInstanceType() {
        return Optional.ofNullable(this.hostInstanceType);
    }

    /**
     * Filter response by storage type.
     * 
     */
    @Import(name="storageType")
    private @Nullable Output<String> storageType;

    /**
     * @return Filter response by storage type.
     * 
     */
    public Optional<Output<String>> storageType() {
        return Optional.ofNullable(this.storageType);
    }

    private GetInstanceTypeOfferingsArgs() {}

    private GetInstanceTypeOfferingsArgs(GetInstanceTypeOfferingsArgs $) {
        this.engineType = $.engineType;
        this.hostInstanceType = $.hostInstanceType;
        this.storageType = $.storageType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetInstanceTypeOfferingsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetInstanceTypeOfferingsArgs $;

        public Builder() {
            $ = new GetInstanceTypeOfferingsArgs();
        }

        public Builder(GetInstanceTypeOfferingsArgs defaults) {
            $ = new GetInstanceTypeOfferingsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param engineType Filter response by engine type.
         * 
         * @return builder
         * 
         */
        public Builder engineType(@Nullable Output<String> engineType) {
            $.engineType = engineType;
            return this;
        }

        /**
         * @param engineType Filter response by engine type.
         * 
         * @return builder
         * 
         */
        public Builder engineType(String engineType) {
            return engineType(Output.of(engineType));
        }

        /**
         * @param hostInstanceType Filter response by host instance type.
         * 
         * @return builder
         * 
         */
        public Builder hostInstanceType(@Nullable Output<String> hostInstanceType) {
            $.hostInstanceType = hostInstanceType;
            return this;
        }

        /**
         * @param hostInstanceType Filter response by host instance type.
         * 
         * @return builder
         * 
         */
        public Builder hostInstanceType(String hostInstanceType) {
            return hostInstanceType(Output.of(hostInstanceType));
        }

        /**
         * @param storageType Filter response by storage type.
         * 
         * @return builder
         * 
         */
        public Builder storageType(@Nullable Output<String> storageType) {
            $.storageType = storageType;
            return this;
        }

        /**
         * @param storageType Filter response by storage type.
         * 
         * @return builder
         * 
         */
        public Builder storageType(String storageType) {
            return storageType(Output.of(storageType));
        }

        public GetInstanceTypeOfferingsArgs build() {
            return $;
        }
    }

}
