// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class BucketAccelerateConfigurationV2State extends com.pulumi.resources.ResourceArgs {

    public static final BucketAccelerateConfigurationV2State Empty = new BucketAccelerateConfigurationV2State();

    /**
     * Name of the bucket.
     * 
     */
    @Import(name="bucket")
    private @Nullable Output<String> bucket;

    /**
     * @return Name of the bucket.
     * 
     */
    public Optional<Output<String>> bucket() {
        return Optional.ofNullable(this.bucket);
    }

    /**
     * Account ID of the expected bucket owner.
     * 
     */
    @Import(name="expectedBucketOwner")
    private @Nullable Output<String> expectedBucketOwner;

    /**
     * @return Account ID of the expected bucket owner.
     * 
     */
    public Optional<Output<String>> expectedBucketOwner() {
        return Optional.ofNullable(this.expectedBucketOwner);
    }

    /**
     * Transfer acceleration state of the bucket. Valid values: `Enabled`, `Suspended`.
     * 
     */
    @Import(name="status")
    private @Nullable Output<String> status;

    /**
     * @return Transfer acceleration state of the bucket. Valid values: `Enabled`, `Suspended`.
     * 
     */
    public Optional<Output<String>> status() {
        return Optional.ofNullable(this.status);
    }

    private BucketAccelerateConfigurationV2State() {}

    private BucketAccelerateConfigurationV2State(BucketAccelerateConfigurationV2State $) {
        this.bucket = $.bucket;
        this.expectedBucketOwner = $.expectedBucketOwner;
        this.status = $.status;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BucketAccelerateConfigurationV2State defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BucketAccelerateConfigurationV2State $;

        public Builder() {
            $ = new BucketAccelerateConfigurationV2State();
        }

        public Builder(BucketAccelerateConfigurationV2State defaults) {
            $ = new BucketAccelerateConfigurationV2State(Objects.requireNonNull(defaults));
        }

        /**
         * @param bucket Name of the bucket.
         * 
         * @return builder
         * 
         */
        public Builder bucket(@Nullable Output<String> bucket) {
            $.bucket = bucket;
            return this;
        }

        /**
         * @param bucket Name of the bucket.
         * 
         * @return builder
         * 
         */
        public Builder bucket(String bucket) {
            return bucket(Output.of(bucket));
        }

        /**
         * @param expectedBucketOwner Account ID of the expected bucket owner.
         * 
         * @return builder
         * 
         */
        public Builder expectedBucketOwner(@Nullable Output<String> expectedBucketOwner) {
            $.expectedBucketOwner = expectedBucketOwner;
            return this;
        }

        /**
         * @param expectedBucketOwner Account ID of the expected bucket owner.
         * 
         * @return builder
         * 
         */
        public Builder expectedBucketOwner(String expectedBucketOwner) {
            return expectedBucketOwner(Output.of(expectedBucketOwner));
        }

        /**
         * @param status Transfer acceleration state of the bucket. Valid values: `Enabled`, `Suspended`.
         * 
         * @return builder
         * 
         */
        public Builder status(@Nullable Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status Transfer acceleration state of the bucket. Valid values: `Enabled`, `Suspended`.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        public BucketAccelerateConfigurationV2State build() {
            return $;
        }
    }

}
