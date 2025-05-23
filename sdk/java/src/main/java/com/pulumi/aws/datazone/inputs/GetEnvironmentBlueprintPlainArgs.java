// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.datazone.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;


public final class GetEnvironmentBlueprintPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetEnvironmentBlueprintPlainArgs Empty = new GetEnvironmentBlueprintPlainArgs();

    /**
     * ID of the domain.
     * 
     */
    @Import(name="domainId", required=true)
    private String domainId;

    /**
     * @return ID of the domain.
     * 
     */
    public String domainId() {
        return this.domainId;
    }

    /**
     * Whether the blueprint is managed by Amazon DataZone.
     * 
     */
    @Import(name="managed", required=true)
    private Boolean managed;

    /**
     * @return Whether the blueprint is managed by Amazon DataZone.
     * 
     */
    public Boolean managed() {
        return this.managed;
    }

    /**
     * Name of the blueprint.
     * 
     */
    @Import(name="name", required=true)
    private String name;

    /**
     * @return Name of the blueprint.
     * 
     */
    public String name() {
        return this.name;
    }

    private GetEnvironmentBlueprintPlainArgs() {}

    private GetEnvironmentBlueprintPlainArgs(GetEnvironmentBlueprintPlainArgs $) {
        this.domainId = $.domainId;
        this.managed = $.managed;
        this.name = $.name;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetEnvironmentBlueprintPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetEnvironmentBlueprintPlainArgs $;

        public Builder() {
            $ = new GetEnvironmentBlueprintPlainArgs();
        }

        public Builder(GetEnvironmentBlueprintPlainArgs defaults) {
            $ = new GetEnvironmentBlueprintPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param domainId ID of the domain.
         * 
         * @return builder
         * 
         */
        public Builder domainId(String domainId) {
            $.domainId = domainId;
            return this;
        }

        /**
         * @param managed Whether the blueprint is managed by Amazon DataZone.
         * 
         * @return builder
         * 
         */
        public Builder managed(Boolean managed) {
            $.managed = managed;
            return this;
        }

        /**
         * @param name Name of the blueprint.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            $.name = name;
            return this;
        }

        public GetEnvironmentBlueprintPlainArgs build() {
            if ($.domainId == null) {
                throw new MissingRequiredPropertyException("GetEnvironmentBlueprintPlainArgs", "domainId");
            }
            if ($.managed == null) {
                throw new MissingRequiredPropertyException("GetEnvironmentBlueprintPlainArgs", "managed");
            }
            if ($.name == null) {
                throw new MissingRequiredPropertyException("GetEnvironmentBlueprintPlainArgs", "name");
            }
            return $;
        }
    }

}
