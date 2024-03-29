// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.shield.inputs;

import com.pulumi.aws.shield.inputs.DrtAccessLogBucketAssociationTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DrtAccessLogBucketAssociationState extends com.pulumi.resources.ResourceArgs {

    public static final DrtAccessLogBucketAssociationState Empty = new DrtAccessLogBucketAssociationState();

    /**
     * The Amazon S3 bucket that contains the logs that you want to share.
     * 
     */
    @Import(name="logBucket")
    private @Nullable Output<String> logBucket;

    /**
     * @return The Amazon S3 bucket that contains the logs that you want to share.
     * 
     */
    public Optional<Output<String>> logBucket() {
        return Optional.ofNullable(this.logBucket);
    }

    /**
     * The ID of the Role Arn association used for allowing Shield DRT Access.
     * 
     */
    @Import(name="roleArnAssociationId")
    private @Nullable Output<String> roleArnAssociationId;

    /**
     * @return The ID of the Role Arn association used for allowing Shield DRT Access.
     * 
     */
    public Optional<Output<String>> roleArnAssociationId() {
        return Optional.ofNullable(this.roleArnAssociationId);
    }

    @Import(name="timeouts")
    private @Nullable Output<DrtAccessLogBucketAssociationTimeoutsArgs> timeouts;

    public Optional<Output<DrtAccessLogBucketAssociationTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    private DrtAccessLogBucketAssociationState() {}

    private DrtAccessLogBucketAssociationState(DrtAccessLogBucketAssociationState $) {
        this.logBucket = $.logBucket;
        this.roleArnAssociationId = $.roleArnAssociationId;
        this.timeouts = $.timeouts;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DrtAccessLogBucketAssociationState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DrtAccessLogBucketAssociationState $;

        public Builder() {
            $ = new DrtAccessLogBucketAssociationState();
        }

        public Builder(DrtAccessLogBucketAssociationState defaults) {
            $ = new DrtAccessLogBucketAssociationState(Objects.requireNonNull(defaults));
        }

        /**
         * @param logBucket The Amazon S3 bucket that contains the logs that you want to share.
         * 
         * @return builder
         * 
         */
        public Builder logBucket(@Nullable Output<String> logBucket) {
            $.logBucket = logBucket;
            return this;
        }

        /**
         * @param logBucket The Amazon S3 bucket that contains the logs that you want to share.
         * 
         * @return builder
         * 
         */
        public Builder logBucket(String logBucket) {
            return logBucket(Output.of(logBucket));
        }

        /**
         * @param roleArnAssociationId The ID of the Role Arn association used for allowing Shield DRT Access.
         * 
         * @return builder
         * 
         */
        public Builder roleArnAssociationId(@Nullable Output<String> roleArnAssociationId) {
            $.roleArnAssociationId = roleArnAssociationId;
            return this;
        }

        /**
         * @param roleArnAssociationId The ID of the Role Arn association used for allowing Shield DRT Access.
         * 
         * @return builder
         * 
         */
        public Builder roleArnAssociationId(String roleArnAssociationId) {
            return roleArnAssociationId(Output.of(roleArnAssociationId));
        }

        public Builder timeouts(@Nullable Output<DrtAccessLogBucketAssociationTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(DrtAccessLogBucketAssociationTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        public DrtAccessLogBucketAssociationState build() {
            return $;
        }
    }

}
