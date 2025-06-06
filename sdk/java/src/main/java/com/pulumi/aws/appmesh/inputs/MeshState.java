// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appmesh.inputs;

import com.pulumi.aws.appmesh.inputs.MeshSpecArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class MeshState extends com.pulumi.resources.ResourceArgs {

    public static final MeshState Empty = new MeshState();

    /**
     * ARN of the service mesh.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return ARN of the service mesh.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * Creation date of the service mesh.
     * 
     */
    @Import(name="createdDate")
    private @Nullable Output<String> createdDate;

    /**
     * @return Creation date of the service mesh.
     * 
     */
    public Optional<Output<String>> createdDate() {
        return Optional.ofNullable(this.createdDate);
    }

    /**
     * Last update date of the service mesh.
     * 
     */
    @Import(name="lastUpdatedDate")
    private @Nullable Output<String> lastUpdatedDate;

    /**
     * @return Last update date of the service mesh.
     * 
     */
    public Optional<Output<String>> lastUpdatedDate() {
        return Optional.ofNullable(this.lastUpdatedDate);
    }

    /**
     * AWS account ID of the service mesh&#39;s owner.
     * 
     */
    @Import(name="meshOwner")
    private @Nullable Output<String> meshOwner;

    /**
     * @return AWS account ID of the service mesh&#39;s owner.
     * 
     */
    public Optional<Output<String>> meshOwner() {
        return Optional.ofNullable(this.meshOwner);
    }

    /**
     * Name to use for the service mesh. Must be between 1 and 255 characters in length.
     * 
     */
    @Import(name="name")
    private @Nullable Output<String> name;

    /**
     * @return Name to use for the service mesh. Must be between 1 and 255 characters in length.
     * 
     */
    public Optional<Output<String>> name() {
        return Optional.ofNullable(this.name);
    }

    /**
     * Resource owner&#39;s AWS account ID.
     * 
     */
    @Import(name="resourceOwner")
    private @Nullable Output<String> resourceOwner;

    /**
     * @return Resource owner&#39;s AWS account ID.
     * 
     */
    public Optional<Output<String>> resourceOwner() {
        return Optional.ofNullable(this.resourceOwner);
    }

    /**
     * Service mesh specification to apply.
     * 
     */
    @Import(name="spec")
    private @Nullable Output<MeshSpecArgs> spec;

    /**
     * @return Service mesh specification to apply.
     * 
     */
    public Optional<Output<MeshSpecArgs>> spec() {
        return Optional.ofNullable(this.spec);
    }

    /**
     * Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Import(name="tagsAll")
    private @Nullable Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    public Optional<Output<Map<String,String>>> tagsAll() {
        return Optional.ofNullable(this.tagsAll);
    }

    private MeshState() {}

    private MeshState(MeshState $) {
        this.arn = $.arn;
        this.createdDate = $.createdDate;
        this.lastUpdatedDate = $.lastUpdatedDate;
        this.meshOwner = $.meshOwner;
        this.name = $.name;
        this.resourceOwner = $.resourceOwner;
        this.spec = $.spec;
        this.tags = $.tags;
        this.tagsAll = $.tagsAll;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(MeshState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private MeshState $;

        public Builder() {
            $ = new MeshState();
        }

        public Builder(MeshState defaults) {
            $ = new MeshState(Objects.requireNonNull(defaults));
        }

        /**
         * @param arn ARN of the service mesh.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn ARN of the service mesh.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param createdDate Creation date of the service mesh.
         * 
         * @return builder
         * 
         */
        public Builder createdDate(@Nullable Output<String> createdDate) {
            $.createdDate = createdDate;
            return this;
        }

        /**
         * @param createdDate Creation date of the service mesh.
         * 
         * @return builder
         * 
         */
        public Builder createdDate(String createdDate) {
            return createdDate(Output.of(createdDate));
        }

        /**
         * @param lastUpdatedDate Last update date of the service mesh.
         * 
         * @return builder
         * 
         */
        public Builder lastUpdatedDate(@Nullable Output<String> lastUpdatedDate) {
            $.lastUpdatedDate = lastUpdatedDate;
            return this;
        }

        /**
         * @param lastUpdatedDate Last update date of the service mesh.
         * 
         * @return builder
         * 
         */
        public Builder lastUpdatedDate(String lastUpdatedDate) {
            return lastUpdatedDate(Output.of(lastUpdatedDate));
        }

        /**
         * @param meshOwner AWS account ID of the service mesh&#39;s owner.
         * 
         * @return builder
         * 
         */
        public Builder meshOwner(@Nullable Output<String> meshOwner) {
            $.meshOwner = meshOwner;
            return this;
        }

        /**
         * @param meshOwner AWS account ID of the service mesh&#39;s owner.
         * 
         * @return builder
         * 
         */
        public Builder meshOwner(String meshOwner) {
            return meshOwner(Output.of(meshOwner));
        }

        /**
         * @param name Name to use for the service mesh. Must be between 1 and 255 characters in length.
         * 
         * @return builder
         * 
         */
        public Builder name(@Nullable Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name Name to use for the service mesh. Must be between 1 and 255 characters in length.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param resourceOwner Resource owner&#39;s AWS account ID.
         * 
         * @return builder
         * 
         */
        public Builder resourceOwner(@Nullable Output<String> resourceOwner) {
            $.resourceOwner = resourceOwner;
            return this;
        }

        /**
         * @param resourceOwner Resource owner&#39;s AWS account ID.
         * 
         * @return builder
         * 
         */
        public Builder resourceOwner(String resourceOwner) {
            return resourceOwner(Output.of(resourceOwner));
        }

        /**
         * @param spec Service mesh specification to apply.
         * 
         * @return builder
         * 
         */
        public Builder spec(@Nullable Output<MeshSpecArgs> spec) {
            $.spec = spec;
            return this;
        }

        /**
         * @param spec Service mesh specification to apply.
         * 
         * @return builder
         * 
         */
        public Builder spec(MeshSpecArgs spec) {
            return spec(Output.of(spec));
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(@Nullable Output<Map<String,String>> tagsAll) {
            $.tagsAll = tagsAll;
            return this;
        }

        /**
         * @param tagsAll Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
         * 
         * @return builder
         * 
         * @deprecated
         * Please use `tags` instead.
         * 
         */
        @Deprecated /* Please use `tags` instead. */
        public Builder tagsAll(Map<String,String> tagsAll) {
            return tagsAll(Output.of(tagsAll));
        }

        public MeshState build() {
            return $;
        }
    }

}
