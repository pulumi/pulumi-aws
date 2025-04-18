// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lambda.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class GetLayerVersionPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetLayerVersionPlainArgs Empty = new GetLayerVersionPlainArgs();

    /**
     * Specific architecture the layer version could support. Conflicts with `version`. If specified, the latest available layer version supporting the provided architecture will be used.
     * 
     */
    @Import(name="compatibleArchitecture")
    private @Nullable String compatibleArchitecture;

    /**
     * @return Specific architecture the layer version could support. Conflicts with `version`. If specified, the latest available layer version supporting the provided architecture will be used.
     * 
     */
    public Optional<String> compatibleArchitecture() {
        return Optional.ofNullable(this.compatibleArchitecture);
    }

    /**
     * Specific runtime the layer version must support. Conflicts with `version`. If specified, the latest available layer version supporting the provided runtime will be used.
     * 
     */
    @Import(name="compatibleRuntime")
    private @Nullable String compatibleRuntime;

    /**
     * @return Specific runtime the layer version must support. Conflicts with `version`. If specified, the latest available layer version supporting the provided runtime will be used.
     * 
     */
    public Optional<String> compatibleRuntime() {
        return Optional.ofNullable(this.compatibleRuntime);
    }

    /**
     * Name of the lambda layer.
     * 
     */
    @Import(name="layerName", required=true)
    private String layerName;

    /**
     * @return Name of the lambda layer.
     * 
     */
    public String layerName() {
        return this.layerName;
    }

    /**
     * Specific layer version. Conflicts with `compatible_runtime` and `compatible_architecture`. If omitted, the latest available layer version will be used.
     * 
     */
    @Import(name="version")
    private @Nullable Integer version;

    /**
     * @return Specific layer version. Conflicts with `compatible_runtime` and `compatible_architecture`. If omitted, the latest available layer version will be used.
     * 
     */
    public Optional<Integer> version() {
        return Optional.ofNullable(this.version);
    }

    private GetLayerVersionPlainArgs() {}

    private GetLayerVersionPlainArgs(GetLayerVersionPlainArgs $) {
        this.compatibleArchitecture = $.compatibleArchitecture;
        this.compatibleRuntime = $.compatibleRuntime;
        this.layerName = $.layerName;
        this.version = $.version;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetLayerVersionPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetLayerVersionPlainArgs $;

        public Builder() {
            $ = new GetLayerVersionPlainArgs();
        }

        public Builder(GetLayerVersionPlainArgs defaults) {
            $ = new GetLayerVersionPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param compatibleArchitecture Specific architecture the layer version could support. Conflicts with `version`. If specified, the latest available layer version supporting the provided architecture will be used.
         * 
         * @return builder
         * 
         */
        public Builder compatibleArchitecture(@Nullable String compatibleArchitecture) {
            $.compatibleArchitecture = compatibleArchitecture;
            return this;
        }

        /**
         * @param compatibleRuntime Specific runtime the layer version must support. Conflicts with `version`. If specified, the latest available layer version supporting the provided runtime will be used.
         * 
         * @return builder
         * 
         */
        public Builder compatibleRuntime(@Nullable String compatibleRuntime) {
            $.compatibleRuntime = compatibleRuntime;
            return this;
        }

        /**
         * @param layerName Name of the lambda layer.
         * 
         * @return builder
         * 
         */
        public Builder layerName(String layerName) {
            $.layerName = layerName;
            return this;
        }

        /**
         * @param version Specific layer version. Conflicts with `compatible_runtime` and `compatible_architecture`. If omitted, the latest available layer version will be used.
         * 
         * @return builder
         * 
         */
        public Builder version(@Nullable Integer version) {
            $.version = version;
            return this;
        }

        public GetLayerVersionPlainArgs build() {
            if ($.layerName == null) {
                throw new MissingRequiredPropertyException("GetLayerVersionPlainArgs", "layerName");
            }
            return $;
        }
    }

}
