// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.amplify.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class AppCacheConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final AppCacheConfigArgs Empty = new AppCacheConfigArgs();

    /**
     * Type of cache configuration to use for an Amplify app. Valid values: `AMPLIFY_MANAGED`, `AMPLIFY_MANAGED_NO_COOKIES`.
     * 
     */
    @Import(name="type", required=true)
    private Output<String> type;

    /**
     * @return Type of cache configuration to use for an Amplify app. Valid values: `AMPLIFY_MANAGED`, `AMPLIFY_MANAGED_NO_COOKIES`.
     * 
     */
    public Output<String> type() {
        return this.type;
    }

    private AppCacheConfigArgs() {}

    private AppCacheConfigArgs(AppCacheConfigArgs $) {
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AppCacheConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AppCacheConfigArgs $;

        public Builder() {
            $ = new AppCacheConfigArgs();
        }

        public Builder(AppCacheConfigArgs defaults) {
            $ = new AppCacheConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param type Type of cache configuration to use for an Amplify app. Valid values: `AMPLIFY_MANAGED`, `AMPLIFY_MANAGED_NO_COOKIES`.
         * 
         * @return builder
         * 
         */
        public Builder type(Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type Type of cache configuration to use for an Amplify app. Valid values: `AMPLIFY_MANAGED`, `AMPLIFY_MANAGED_NO_COOKIES`.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public AppCacheConfigArgs build() {
            if ($.type == null) {
                throw new MissingRequiredPropertyException("AppCacheConfigArgs", "type");
            }
            return $;
        }
    }

}
