// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.inputs;

import com.pulumi.aws.s3.inputs.BucketV2ObjectLockConfigurationRuleArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class BucketV2ObjectLockConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final BucketV2ObjectLockConfigurationArgs Empty = new BucketV2ObjectLockConfigurationArgs();

    /**
     * Indicates whether this bucket has an Object Lock configuration enabled. Valid values are `true` or `false`. This argument is not supported in all regions or partitions.
     * 
     * @deprecated
     * object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead.
     * 
     */
    @Deprecated /* object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead. */
    @Import(name="objectLockEnabled")
    private @Nullable Output<String> objectLockEnabled;

    /**
     * @return Indicates whether this bucket has an Object Lock configuration enabled. Valid values are `true` or `false`. This argument is not supported in all regions or partitions.
     * 
     * @deprecated
     * object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead.
     * 
     */
    @Deprecated /* object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead. */
    public Optional<Output<String>> objectLockEnabled() {
        return Optional.ofNullable(this.objectLockEnabled);
    }

    /**
     * Object Lock rule in place for this bucket (documented below).
     * 
     * @deprecated
     * rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead. */
    @Import(name="rules")
    private @Nullable Output<List<BucketV2ObjectLockConfigurationRuleArgs>> rules;

    /**
     * @return Object Lock rule in place for this bucket (documented below).
     * 
     * @deprecated
     * rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead. */
    public Optional<Output<List<BucketV2ObjectLockConfigurationRuleArgs>>> rules() {
        return Optional.ofNullable(this.rules);
    }

    private BucketV2ObjectLockConfigurationArgs() {}

    private BucketV2ObjectLockConfigurationArgs(BucketV2ObjectLockConfigurationArgs $) {
        this.objectLockEnabled = $.objectLockEnabled;
        this.rules = $.rules;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BucketV2ObjectLockConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BucketV2ObjectLockConfigurationArgs $;

        public Builder() {
            $ = new BucketV2ObjectLockConfigurationArgs();
        }

        public Builder(BucketV2ObjectLockConfigurationArgs defaults) {
            $ = new BucketV2ObjectLockConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param objectLockEnabled Indicates whether this bucket has an Object Lock configuration enabled. Valid values are `true` or `false`. This argument is not supported in all regions or partitions.
         * 
         * @return builder
         * 
         * @deprecated
         * object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead.
         * 
         */
        @Deprecated /* object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead. */
        public Builder objectLockEnabled(@Nullable Output<String> objectLockEnabled) {
            $.objectLockEnabled = objectLockEnabled;
            return this;
        }

        /**
         * @param objectLockEnabled Indicates whether this bucket has an Object Lock configuration enabled. Valid values are `true` or `false`. This argument is not supported in all regions or partitions.
         * 
         * @return builder
         * 
         * @deprecated
         * object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead.
         * 
         */
        @Deprecated /* object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead. */
        public Builder objectLockEnabled(String objectLockEnabled) {
            return objectLockEnabled(Output.of(objectLockEnabled));
        }

        /**
         * @param rules Object Lock rule in place for this bucket (documented below).
         * 
         * @return builder
         * 
         * @deprecated
         * rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead.
         * 
         */
        @Deprecated /* rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead. */
        public Builder rules(@Nullable Output<List<BucketV2ObjectLockConfigurationRuleArgs>> rules) {
            $.rules = rules;
            return this;
        }

        /**
         * @param rules Object Lock rule in place for this bucket (documented below).
         * 
         * @return builder
         * 
         * @deprecated
         * rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead.
         * 
         */
        @Deprecated /* rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead. */
        public Builder rules(List<BucketV2ObjectLockConfigurationRuleArgs> rules) {
            return rules(Output.of(rules));
        }

        /**
         * @param rules Object Lock rule in place for this bucket (documented below).
         * 
         * @return builder
         * 
         * @deprecated
         * rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead.
         * 
         */
        @Deprecated /* rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead. */
        public Builder rules(BucketV2ObjectLockConfigurationRuleArgs... rules) {
            return rules(List.of(rules));
        }

        public BucketV2ObjectLockConfigurationArgs build() {
            return $;
        }
    }

}
