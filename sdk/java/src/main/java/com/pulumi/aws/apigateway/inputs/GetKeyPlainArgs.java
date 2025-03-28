// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigateway.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetKeyPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetKeyPlainArgs Empty = new GetKeyPlainArgs();

    /**
     * ID of the API Key to look up.
     * 
     */
    @Import(name="id", required=true)
    private String id;

    /**
     * @return ID of the API Key to look up.
     * 
     */
    public String id() {
        return this.id;
    }

    /**
     * Map of tags for the resource.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Map of tags for the resource.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetKeyPlainArgs() {}

    private GetKeyPlainArgs(GetKeyPlainArgs $) {
        this.id = $.id;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetKeyPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetKeyPlainArgs $;

        public Builder() {
            $ = new GetKeyPlainArgs();
        }

        public Builder(GetKeyPlainArgs defaults) {
            $ = new GetKeyPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param id ID of the API Key to look up.
         * 
         * @return builder
         * 
         */
        public Builder id(String id) {
            $.id = id;
            return this;
        }

        /**
         * @param tags Map of tags for the resource.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetKeyPlainArgs build() {
            if ($.id == null) {
                throw new MissingRequiredPropertyException("GetKeyPlainArgs", "id");
            }
            return $;
        }
    }

}
