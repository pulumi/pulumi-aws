// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.securityhub;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ActionTargetArgs extends com.pulumi.resources.ResourceArgs {

    public static final ActionTargetArgs Empty = new ActionTargetArgs();

    /**
     * The name of the custom action target.
     * 
     */
    @Import(name="description", required=true)
    private Output<String> description;

    /**
     * @return The name of the custom action target.
     * 
     */
    public Output<String> description() {
        return this.description;
    }

    /**
     * The ID for the custom action target.
     * 
     */
    @Import(name="identifier", required=true)
    private Output<String> identifier;

    /**
     * @return The ID for the custom action target.
     * 
     */
    public Output<String> identifier() {
        return this.identifier;
    }

    /**
     * The description for the custom action target.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return The description for the custom action target.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    private ActionTargetArgs() {}

    private ActionTargetArgs(ActionTargetArgs $) {
        this.description = $.description;
        this.identifier = $.identifier;
        this.name = $.name;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ActionTargetArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ActionTargetArgs $;

        public Builder() {
            $ = new ActionTargetArgs();
        }

        public Builder(ActionTargetArgs defaults) {
            $ = new ActionTargetArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param description The name of the custom action target.
         * 
         * @return builder
         * 
         */
        public Builder description(Output<String> description) {
            $.description = description;
            return this;
        }

        /**
         * @param description The name of the custom action target.
         * 
         * @return builder
         * 
         */
        public Builder description(String description) {
            return description(Output.of(description));
        }

        /**
         * @param identifier The ID for the custom action target.
         * 
         * @return builder
         * 
         */
        public Builder identifier(Output<String> identifier) {
            $.identifier = identifier;
            return this;
        }

        /**
         * @param identifier The ID for the custom action target.
         * 
         * @return builder
         * 
         */
        public Builder identifier(String identifier) {
            return identifier(Output.of(identifier));
        }

        /**
         * @param name The description for the custom action target.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The description for the custom action target.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        public ActionTargetArgs build() {
            if ($.description == null) {
                throw new MissingRequiredPropertyException("ActionTargetArgs", "description");
            }
            if ($.identifier == null) {
                throw new MissingRequiredPropertyException("ActionTargetArgs", "identifier");
            }
            return $;
        }
    }

}
