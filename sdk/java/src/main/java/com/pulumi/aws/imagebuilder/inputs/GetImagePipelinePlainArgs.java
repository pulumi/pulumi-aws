// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetImagePipelinePlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetImagePipelinePlainArgs Empty = new GetImagePipelinePlainArgs();

    /**
     * ARN of the image pipeline.
     * 
     */
    @Import(name="arn", required=true)
    private String arn;

    /**
     * @return ARN of the image pipeline.
     * 
     */
    public String arn() {
        return this.arn;
    }

    /**
     * Key-value map of resource tags for the image pipeline.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Key-value map of resource tags for the image pipeline.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetImagePipelinePlainArgs() {}

    private GetImagePipelinePlainArgs(GetImagePipelinePlainArgs $) {
        this.arn = $.arn;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetImagePipelinePlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetImagePipelinePlainArgs $;

        public Builder() {
            $ = new GetImagePipelinePlainArgs();
        }

        public Builder(GetImagePipelinePlainArgs defaults) {
            $ = new GetImagePipelinePlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of the image pipeline.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param tags Key-value map of resource tags for the image pipeline.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetImagePipelinePlainArgs build() {
            if ($.arn == null) {
                throw new MissingRequiredPropertyException("GetImagePipelinePlainArgs", "arn");
            }
            return $;
        }
    }

}
