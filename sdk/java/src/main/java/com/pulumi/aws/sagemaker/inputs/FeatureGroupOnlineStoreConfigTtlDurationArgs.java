// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class FeatureGroupOnlineStoreConfigTtlDurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final FeatureGroupOnlineStoreConfigTtlDurationArgs Empty = new FeatureGroupOnlineStoreConfigTtlDurationArgs();

    /**
     * TtlDuration time unit. Valid values are `Seconds`, `Minutes`, `Hours`, `Days`, or `Weeks`.
     * 
     */
    @Import(name="unit")
    private @Nullable Output<String> unit;

    /**
     * @return TtlDuration time unit. Valid values are `Seconds`, `Minutes`, `Hours`, `Days`, or `Weeks`.
     * 
     */
    public Optional<Output<String>> unit() {
        return Optional.ofNullable(this.unit);
    }

    /**
     * TtlDuration time value.
     * 
     */
    @Import(name="value")
    private @Nullable Output<Integer> value;

    /**
     * @return TtlDuration time value.
     * 
     */
    public Optional<Output<Integer>> value() {
        return Optional.ofNullable(this.value);
    }

    private FeatureGroupOnlineStoreConfigTtlDurationArgs() {}

    private FeatureGroupOnlineStoreConfigTtlDurationArgs(FeatureGroupOnlineStoreConfigTtlDurationArgs $) {
        this.unit = $.unit;
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(FeatureGroupOnlineStoreConfigTtlDurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private FeatureGroupOnlineStoreConfigTtlDurationArgs $;

        public Builder() {
            $ = new FeatureGroupOnlineStoreConfigTtlDurationArgs();
        }

        public Builder(FeatureGroupOnlineStoreConfigTtlDurationArgs defaults) {
            $ = new FeatureGroupOnlineStoreConfigTtlDurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param unit TtlDuration time unit. Valid values are `Seconds`, `Minutes`, `Hours`, `Days`, or `Weeks`.
         * 
         * @return builder
         * 
         */
        public Builder unit(@Nullable Output<String> unit) {
            $.unit = unit;
            return this;
        }

        /**
         * @param unit TtlDuration time unit. Valid values are `Seconds`, `Minutes`, `Hours`, `Days`, or `Weeks`.
         * 
         * @return builder
         * 
         */
        public Builder unit(String unit) {
            return unit(Output.of(unit));
        }

        /**
         * @param value TtlDuration time value.
         * 
         * @return builder
         * 
         */
        public Builder value(@Nullable Output<Integer> value) {
            $.value = value;
            return this;
        }

        /**
         * @param value TtlDuration time value.
         * 
         * @return builder
         * 
         */
        public Builder value(Integer value) {
            return value(Output.of(value));
        }

        public FeatureGroupOnlineStoreConfigTtlDurationArgs build() {
            return $;
        }
    }

}
