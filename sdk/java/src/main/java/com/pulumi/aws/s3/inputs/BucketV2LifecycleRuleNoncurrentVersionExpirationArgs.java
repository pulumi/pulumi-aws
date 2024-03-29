// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class BucketV2LifecycleRuleNoncurrentVersionExpirationArgs extends com.pulumi.resources.ResourceArgs {

    public static final BucketV2LifecycleRuleNoncurrentVersionExpirationArgs Empty = new BucketV2LifecycleRuleNoncurrentVersionExpirationArgs();

    /**
     * Specifies the number of days noncurrent object versions expire.
     * 
     */
    @Import(name="days")
    private @Nullable Output<Integer> days;

    /**
     * @return Specifies the number of days noncurrent object versions expire.
     * 
     */
    public Optional<Output<Integer>> days() {
        return Optional.ofNullable(this.days);
    }

    private BucketV2LifecycleRuleNoncurrentVersionExpirationArgs() {}

    private BucketV2LifecycleRuleNoncurrentVersionExpirationArgs(BucketV2LifecycleRuleNoncurrentVersionExpirationArgs $) {
        this.days = $.days;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BucketV2LifecycleRuleNoncurrentVersionExpirationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BucketV2LifecycleRuleNoncurrentVersionExpirationArgs $;

        public Builder() {
            $ = new BucketV2LifecycleRuleNoncurrentVersionExpirationArgs();
        }

        public Builder(BucketV2LifecycleRuleNoncurrentVersionExpirationArgs defaults) {
            $ = new BucketV2LifecycleRuleNoncurrentVersionExpirationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param days Specifies the number of days noncurrent object versions expire.
         * 
         * @return builder
         * 
         */
        public Builder days(@Nullable Output<Integer> days) {
            $.days = days;
            return this;
        }

        /**
         * @param days Specifies the number of days noncurrent object versions expire.
         * 
         * @return builder
         * 
         */
        public Builder days(Integer days) {
            return days(Output.of(days));
        }

        public BucketV2LifecycleRuleNoncurrentVersionExpirationArgs build() {
            return $;
        }
    }

}
