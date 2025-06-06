// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.memorydb.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetParameterGroupArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetParameterGroupArgs Empty = new GetParameterGroupArgs();

    /**
     * Name of the parameter group.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return Name of the parameter group.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * Map of tags assigned to the parameter group.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags assigned to the parameter group.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    private GetParameterGroupArgs() {}

    private GetParameterGroupArgs(GetParameterGroupArgs $) {
        this.name = $.name;
        this.tags = $.tags;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetParameterGroupArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetParameterGroupArgs $;

        public Builder() {
            $ = new GetParameterGroupArgs();
        }

        public Builder(GetParameterGroupArgs defaults) {
            $ = new GetParameterGroupArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name Name of the parameter group.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name of the parameter group.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param tags Map of tags assigned to the parameter group.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags assigned to the parameter group.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public GetParameterGroupArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("GetParameterGroupArgs", "name");
            }
            return $;
        }
    }

}
