// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ObjectCopyOverrideProviderDefaultTagsArgs extends com.pulumi.resources.ResourceArgs {

    public static final ObjectCopyOverrideProviderDefaultTagsArgs Empty = new ObjectCopyOverrideProviderDefaultTagsArgs();

    /**
     * Map of tags to assign to the object. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the object. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private ObjectCopyOverrideProviderDefaultTagsArgs() {}

    private ObjectCopyOverrideProviderDefaultTagsArgs(ObjectCopyOverrideProviderDefaultTagsArgs $) {
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ObjectCopyOverrideProviderDefaultTagsArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ObjectCopyOverrideProviderDefaultTagsArgs $;

        public Builder() {
            $ = new ObjectCopyOverrideProviderDefaultTagsArgs();
        }

        public Builder(ObjectCopyOverrideProviderDefaultTagsArgs defaults) {
            $ = new ObjectCopyOverrideProviderDefaultTagsArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param tags Map of tags to assign to the object. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the object. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public ObjectCopyOverrideProviderDefaultTagsArgs build() {
            return $;
        }
    }

}
