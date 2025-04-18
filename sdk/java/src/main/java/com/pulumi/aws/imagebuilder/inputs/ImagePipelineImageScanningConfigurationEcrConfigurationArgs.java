// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.imagebuilder.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ImagePipelineImageScanningConfigurationEcrConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final ImagePipelineImageScanningConfigurationEcrConfigurationArgs Empty = new ImagePipelineImageScanningConfigurationEcrConfigurationArgs();

    @Import(name="containerTags")
    private @Nullable Output<List<String>> containerTags;

    public Optional<Output<List<String>>> containerTags() {
        return Optional.ofNullable(this.containerTags);
    }

    /**
     * The name of the repository to scan
     * 
     */
    @Import(name="repositoryName")
    private @Nullable Output<String> repositoryName;

    /**
     * @return The name of the repository to scan
     * 
     */
    public Optional<Output<String>> repositoryName() {
        return Optional.ofNullable(this.repositoryName);
    }

    private ImagePipelineImageScanningConfigurationEcrConfigurationArgs() {}

    private ImagePipelineImageScanningConfigurationEcrConfigurationArgs(ImagePipelineImageScanningConfigurationEcrConfigurationArgs $) {
        this.containerTags = $.containerTags;
        this.repositoryName = $.repositoryName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ImagePipelineImageScanningConfigurationEcrConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ImagePipelineImageScanningConfigurationEcrConfigurationArgs $;

        public Builder() {
            $ = new ImagePipelineImageScanningConfigurationEcrConfigurationArgs();
        }

        public Builder(ImagePipelineImageScanningConfigurationEcrConfigurationArgs defaults) {
            $ = new ImagePipelineImageScanningConfigurationEcrConfigurationArgs(Objects.requireNonNull(defaults));
        }

        public Builder containerTags(@Nullable Output<List<String>> containerTags) {
            $.containerTags = containerTags;
            return this;
        }

        public Builder containerTags(List<String> containerTags) {
            return containerTags(Output.of(containerTags));
        }

        public Builder containerTags(String... containerTags) {
            return containerTags(List.of(containerTags));
        }

        /**
         * @param repositoryName The name of the repository to scan
         * 
         * @return builder
         * 
         */
        public Builder repositoryName(@Nullable Output<String> repositoryName) {
            $.repositoryName = repositoryName;
            return this;
        }

        /**
         * @param repositoryName The name of the repository to scan
         * 
         * @return builder
         * 
         */
        public Builder repositoryName(String repositoryName) {
            return repositoryName(Output.of(repositoryName));
        }

        public ImagePipelineImageScanningConfigurationEcrConfigurationArgs build() {
            return $;
        }
    }

}
