// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kendra.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetIndexPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetIndexPlainArgs Empty = new GetIndexPlainArgs();

    /**
     * Returns information on a specific Index by id.
     * 
     */
    @Import(name="id", required=true)
    private String id;

    /**
     * @return Returns information on a specific Index by id.
     * 
     */
    public String id() {
        return this.id;
    }

    /**
     * Metadata that helps organize the Indices you create.
     * 
     */
    @Import(name="tags")
    private @Nullable Map<String,String> tags;

    /**
     * @return Metadata that helps organize the Indices you create.
     * 
     */
    public Optional<Map<String,String>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetIndexPlainArgs() {}

    private GetIndexPlainArgs(GetIndexPlainArgs $) {
        this.id = $.id;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetIndexPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetIndexPlainArgs $;

        public Builder() {
            $ = new GetIndexPlainArgs();
        }

        public Builder(GetIndexPlainArgs defaults) {
            $ = new GetIndexPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param id Returns information on a specific Index by id.
         * 
         * @return builder
         * 
         */
        public Builder id(String id) {
            $.id = id;
            return this;
        }

        /**
         * @param tags Metadata that helps organize the Indices you create.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Map<String,String> tags) {
            $.tags = tags;
            return this;
        }

        public GetIndexPlainArgs build() {
            if ($.id == null) {
                throw new MissingRequiredPropertyException("GetIndexPlainArgs", "id");
            }
            return $;
        }
    }

}
