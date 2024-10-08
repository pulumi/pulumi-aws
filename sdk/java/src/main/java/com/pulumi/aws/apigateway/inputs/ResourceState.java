// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigateway.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ResourceState extends com.pulumi.resources.ResourceArgs {

    public static final ResourceState Empty = new ResourceState();

    /**
     * ID of the parent API resource
     * 
     */
    @Import(name="parentId")
    private @Nullable Output<String> parentId;

    /**
     * @return ID of the parent API resource
     * 
     */
    public Optional<Output<String>> parentId() {
        return Optional.ofNullable(this.parentId);
    }

    /**
     * Complete path for this API resource, including all parent paths.
     * 
     */
    @Import(name="path")
    private @Nullable Output<String> path;

    /**
     * @return Complete path for this API resource, including all parent paths.
     * 
     */
    public Optional<Output<String>> path() {
        return Optional.ofNullable(this.path);
    }

    /**
     * Last path segment of this API resource.
     * 
     */
    @Import(name="pathPart")
    private @Nullable Output<String> pathPart;

    /**
     * @return Last path segment of this API resource.
     * 
     */
    public Optional<Output<String>> pathPart() {
        return Optional.ofNullable(this.pathPart);
    }

    /**
     * ID of the associated REST API
     * 
     */
    @Import(name="restApi")
    private @Nullable Output<String> restApi;

    /**
     * @return ID of the associated REST API
     * 
     */
    public Optional<Output<String>> restApi() {
        return Optional.ofNullable(this.restApi);
    }

    private ResourceState() {}

    private ResourceState(ResourceState $) {
        this.parentId = $.parentId;
        this.path = $.path;
        this.pathPart = $.pathPart;
        this.restApi = $.restApi;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ResourceState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ResourceState $;

        public Builder() {
            $ = new ResourceState();
        }

        public Builder(ResourceState defaults) {
            $ = new ResourceState(Objects.requireNonNull(defaults));
        }

        /**
         * @param parentId ID of the parent API resource
         * 
         * @return builder
         * 
         */
        public Builder parentId(@Nullable Output<String> parentId) {
            $.parentId = parentId;
            return this;
        }

        /**
         * @param parentId ID of the parent API resource
         * 
         * @return builder
         * 
         */
        public Builder parentId(String parentId) {
            return parentId(Output.of(parentId));
        }

        /**
         * @param path Complete path for this API resource, including all parent paths.
         * 
         * @return builder
         * 
         */
        public Builder path(@Nullable Output<String> path) {
            $.path = path;
            return this;
        }

        /**
         * @param path Complete path for this API resource, including all parent paths.
         * 
         * @return builder
         * 
         */
        public Builder path(String path) {
            return path(Output.of(path));
        }

        /**
         * @param pathPart Last path segment of this API resource.
         * 
         * @return builder
         * 
         */
        public Builder pathPart(@Nullable Output<String> pathPart) {
            $.pathPart = pathPart;
            return this;
        }

        /**
         * @param pathPart Last path segment of this API resource.
         * 
         * @return builder
         * 
         */
        public Builder pathPart(String pathPart) {
            return pathPart(Output.of(pathPart));
        }

        /**
         * @param restApi ID of the associated REST API
         * 
         * @return builder
         * 
         */
        public Builder restApi(@Nullable Output<String> restApi) {
            $.restApi = restApi;
            return this;
        }

        /**
         * @param restApi ID of the associated REST API
         * 
         * @return builder
         * 
         */
        public Builder restApi(String restApi) {
            return restApi(Output.of(restApi));
        }

        public ResourceState build() {
            return $;
        }
    }

}
