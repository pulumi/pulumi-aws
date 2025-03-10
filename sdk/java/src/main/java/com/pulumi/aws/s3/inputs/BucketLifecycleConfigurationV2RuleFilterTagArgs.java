// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class BucketLifecycleConfigurationV2RuleFilterTagArgs extends com.pulumi.resources.ResourceArgs {

    public static final BucketLifecycleConfigurationV2RuleFilterTagArgs Empty = new BucketLifecycleConfigurationV2RuleFilterTagArgs();

    /**
     * Name of the object key.
     * 
     */
    @Import(name="key", required=true)
    private Output<String> key;

    /**
     * @return Name of the object key.
     * 
     */
    public Output<String> key() {
        return this.key;
    }

    /**
     * Value of the tag.
     * 
     */
    @Import(name="value", required=true)
    private Output<String> value;

    /**
     * @return Value of the tag.
     * 
     */
    public Output<String> value() {
        return this.value;
    }

    private BucketLifecycleConfigurationV2RuleFilterTagArgs() {}

    private BucketLifecycleConfigurationV2RuleFilterTagArgs(BucketLifecycleConfigurationV2RuleFilterTagArgs $) {
        this.key = $.key;
        this.value = $.value;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BucketLifecycleConfigurationV2RuleFilterTagArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BucketLifecycleConfigurationV2RuleFilterTagArgs $;

        public Builder() {
            $ = new BucketLifecycleConfigurationV2RuleFilterTagArgs();
        }

        public Builder(BucketLifecycleConfigurationV2RuleFilterTagArgs defaults) {
            $ = new BucketLifecycleConfigurationV2RuleFilterTagArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param key Name of the object key.
         * 
         * @return builder
         * 
         */
        public Builder key(Output<String> key) {
            $.key = key;
            return this;
        }

        /**
         * @param key Name of the object key.
         * 
         * @return builder
         * 
         */
        public Builder key(String key) {
            return key(Output.of(key));
        }

        /**
         * @param value Value of the tag.
         * 
         * @return builder
         * 
         */
        public Builder value(Output<String> value) {
            $.value = value;
            return this;
        }

        /**
         * @param value Value of the tag.
         * 
         * @return builder
         * 
         */
        public Builder value(String value) {
            return value(Output.of(value));
        }

        public BucketLifecycleConfigurationV2RuleFilterTagArgs build() {
            if ($.key == null) {
                throw new MissingRequiredPropertyException("BucketLifecycleConfigurationV2RuleFilterTagArgs", "key");
            }
            if ($.value == null) {
                throw new MissingRequiredPropertyException("BucketLifecycleConfigurationV2RuleFilterTagArgs", "value");
            }
            return $;
        }
    }

}
