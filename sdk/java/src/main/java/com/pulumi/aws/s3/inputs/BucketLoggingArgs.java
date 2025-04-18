// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class BucketLoggingArgs extends com.pulumi.resources.ResourceArgs {

    public static final BucketLoggingArgs Empty = new BucketLoggingArgs();

    /**
     * The name of the bucket that will receive the log objects.
     * 
     */
    @Import(name="targetBucket", required=true)
    private Output<String> targetBucket;

    /**
     * @return The name of the bucket that will receive the log objects.
     * 
     */
    public Output<String> targetBucket() {
        return this.targetBucket;
    }

    /**
     * To specify a key prefix for log objects.
     * 
     */
    @Import(name="targetPrefix")
    private @Nullable Output<String> targetPrefix;

    /**
     * @return To specify a key prefix for log objects.
     * 
     */
    public Optional<Output<String>> targetPrefix() {
        return Optional.ofNullable(this.targetPrefix);
    }

    private BucketLoggingArgs() {}

    private BucketLoggingArgs(BucketLoggingArgs $) {
        this.targetBucket = $.targetBucket;
        this.targetPrefix = $.targetPrefix;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BucketLoggingArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BucketLoggingArgs $;

        public Builder() {
            $ = new BucketLoggingArgs();
        }

        public Builder(BucketLoggingArgs defaults) {
            $ = new BucketLoggingArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param targetBucket The name of the bucket that will receive the log objects.
         * 
         * @return builder
         * 
         */
        public Builder targetBucket(Output<String> targetBucket) {
            $.targetBucket = targetBucket;
            return this;
        }

        /**
         * @param targetBucket The name of the bucket that will receive the log objects.
         * 
         * @return builder
         * 
         */
        public Builder targetBucket(String targetBucket) {
            return targetBucket(Output.of(targetBucket));
        }

        /**
         * @param targetPrefix To specify a key prefix for log objects.
         * 
         * @return builder
         * 
         */
        public Builder targetPrefix(@Nullable Output<String> targetPrefix) {
            $.targetPrefix = targetPrefix;
            return this;
        }

        /**
         * @param targetPrefix To specify a key prefix for log objects.
         * 
         * @return builder
         * 
         */
        public Builder targetPrefix(String targetPrefix) {
            return targetPrefix(Output.of(targetPrefix));
        }

        public BucketLoggingArgs build() {
            if ($.targetBucket == null) {
                throw new MissingRequiredPropertyException("BucketLoggingArgs", "targetBucket");
            }
            return $;
        }
    }

}
