// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudfront.inputs;

import com.pulumi.aws.cloudfront.inputs.DistributionTrustedSignerItemArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DistributionTrustedSignerArgs extends com.pulumi.resources.ResourceArgs {

    public static final DistributionTrustedSignerArgs Empty = new DistributionTrustedSignerArgs();

    /**
     * Whether the distribution is enabled to accept end user requests for content.
     * 
     */
    @Import(name="enabled")
    private @Nullable Output<Boolean> enabled;

    /**
     * @return Whether the distribution is enabled to accept end user requests for content.
     * 
     */
    public Optional<Output<Boolean>> enabled() {
        return Optional.ofNullable(this.enabled);
    }

    /**
     * List of nested attributes for each trusted signer
     * 
     */
    @Import(name="items")
    private @Nullable Output<List<DistributionTrustedSignerItemArgs>> items;

    /**
     * @return List of nested attributes for each trusted signer
     * 
     */
    public Optional<Output<List<DistributionTrustedSignerItemArgs>>> items() {
        return Optional.ofNullable(this.items);
    }

    private DistributionTrustedSignerArgs() {}

    private DistributionTrustedSignerArgs(DistributionTrustedSignerArgs $) {
        this.enabled = $.enabled;
        this.items = $.items;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DistributionTrustedSignerArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DistributionTrustedSignerArgs $;

        public Builder() {
            $ = new DistributionTrustedSignerArgs();
        }

        public Builder(DistributionTrustedSignerArgs defaults) {
            $ = new DistributionTrustedSignerArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param enabled Whether the distribution is enabled to accept end user requests for content.
         * 
         * @return builder
         * 
         */
        public Builder enabled(@Nullable Output<Boolean> enabled) {
            $.enabled = enabled;
            return this;
        }

        /**
         * @param enabled Whether the distribution is enabled to accept end user requests for content.
         * 
         * @return builder
         * 
         */
        public Builder enabled(Boolean enabled) {
            return enabled(Output.of(enabled));
        }

        /**
         * @param items List of nested attributes for each trusted signer
         * 
         * @return builder
         * 
         */
        public Builder items(@Nullable Output<List<DistributionTrustedSignerItemArgs>> items) {
            $.items = items;
            return this;
        }

        /**
         * @param items List of nested attributes for each trusted signer
         * 
         * @return builder
         * 
         */
        public Builder items(List<DistributionTrustedSignerItemArgs> items) {
            return items(Output.of(items));
        }

        /**
         * @param items List of nested attributes for each trusted signer
         * 
         * @return builder
         * 
         */
        public Builder items(DistributionTrustedSignerItemArgs... items) {
            return items(List.of(items));
        }

        public DistributionTrustedSignerArgs build() {
            return $;
        }
    }

}
