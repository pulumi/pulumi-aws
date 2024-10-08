// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.glue.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class CrawlerSchemaChangePolicyArgs extends com.pulumi.resources.ResourceArgs {

    public static final CrawlerSchemaChangePolicyArgs Empty = new CrawlerSchemaChangePolicyArgs();

    /**
     * The deletion behavior when the crawler finds a deleted object. Valid values: `LOG`, `DELETE_FROM_DATABASE`, or `DEPRECATE_IN_DATABASE`. Defaults to `DEPRECATE_IN_DATABASE`.
     * 
     */
    @Import(name="deleteBehavior")
    private @Nullable Output<String> deleteBehavior;

    /**
     * @return The deletion behavior when the crawler finds a deleted object. Valid values: `LOG`, `DELETE_FROM_DATABASE`, or `DEPRECATE_IN_DATABASE`. Defaults to `DEPRECATE_IN_DATABASE`.
     * 
     */
    public Optional<Output<String>> deleteBehavior() {
        return Optional.ofNullable(this.deleteBehavior);
    }

    /**
     * The update behavior when the crawler finds a changed schema. Valid values: `LOG` or `UPDATE_IN_DATABASE`. Defaults to `UPDATE_IN_DATABASE`.
     * 
     */
    @Import(name="updateBehavior")
    private @Nullable Output<String> updateBehavior;

    /**
     * @return The update behavior when the crawler finds a changed schema. Valid values: `LOG` or `UPDATE_IN_DATABASE`. Defaults to `UPDATE_IN_DATABASE`.
     * 
     */
    public Optional<Output<String>> updateBehavior() {
        return Optional.ofNullable(this.updateBehavior);
    }

    private CrawlerSchemaChangePolicyArgs() {}

    private CrawlerSchemaChangePolicyArgs(CrawlerSchemaChangePolicyArgs $) {
        this.deleteBehavior = $.deleteBehavior;
        this.updateBehavior = $.updateBehavior;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(CrawlerSchemaChangePolicyArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private CrawlerSchemaChangePolicyArgs $;

        public Builder() {
            $ = new CrawlerSchemaChangePolicyArgs();
        }

        public Builder(CrawlerSchemaChangePolicyArgs defaults) {
            $ = new CrawlerSchemaChangePolicyArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param deleteBehavior The deletion behavior when the crawler finds a deleted object. Valid values: `LOG`, `DELETE_FROM_DATABASE`, or `DEPRECATE_IN_DATABASE`. Defaults to `DEPRECATE_IN_DATABASE`.
         * 
         * @return builder
         * 
         */
        public Builder deleteBehavior(@Nullable Output<String> deleteBehavior) {
            $.deleteBehavior = deleteBehavior;
            return this;
        }

        /**
         * @param deleteBehavior The deletion behavior when the crawler finds a deleted object. Valid values: `LOG`, `DELETE_FROM_DATABASE`, or `DEPRECATE_IN_DATABASE`. Defaults to `DEPRECATE_IN_DATABASE`.
         * 
         * @return builder
         * 
         */
        public Builder deleteBehavior(String deleteBehavior) {
            return deleteBehavior(Output.of(deleteBehavior));
        }

        /**
         * @param updateBehavior The update behavior when the crawler finds a changed schema. Valid values: `LOG` or `UPDATE_IN_DATABASE`. Defaults to `UPDATE_IN_DATABASE`.
         * 
         * @return builder
         * 
         */
        public Builder updateBehavior(@Nullable Output<String> updateBehavior) {
            $.updateBehavior = updateBehavior;
            return this;
        }

        /**
         * @param updateBehavior The update behavior when the crawler finds a changed schema. Valid values: `LOG` or `UPDATE_IN_DATABASE`. Defaults to `UPDATE_IN_DATABASE`.
         * 
         * @return builder
         * 
         */
        public Builder updateBehavior(String updateBehavior) {
            return updateBehavior(Output.of(updateBehavior));
        }

        public CrawlerSchemaChangePolicyArgs build() {
            return $;
        }
    }

}
