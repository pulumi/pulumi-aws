// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codepipeline.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PipelineTriggerAllGitConfigurationPushBranchArgs extends com.pulumi.resources.ResourceArgs {

    public static final PipelineTriggerAllGitConfigurationPushBranchArgs Empty = new PipelineTriggerAllGitConfigurationPushBranchArgs();

    /**
     * A list of patterns of Git branches that, when a commit is pushed, are to be excluded from starting the pipeline.
     * 
     */
    @Import(name="excludes")
    private @Nullable Output<List<String>> excludes;

    /**
     * @return A list of patterns of Git branches that, when a commit is pushed, are to be excluded from starting the pipeline.
     * 
     */
    public Optional<Output<List<String>>> excludes() {
        return Optional.ofNullable(this.excludes);
    }

    /**
     * A list of patterns of Git branches that, when a commit is pushed, are to be included as criteria that starts the pipeline.
     * 
     */
    @Import(name="includes")
    private @Nullable Output<List<String>> includes;

    /**
     * @return A list of patterns of Git branches that, when a commit is pushed, are to be included as criteria that starts the pipeline.
     * 
     */
    public Optional<Output<List<String>>> includes() {
        return Optional.ofNullable(this.includes);
    }

    private PipelineTriggerAllGitConfigurationPushBranchArgs() {}

    private PipelineTriggerAllGitConfigurationPushBranchArgs(PipelineTriggerAllGitConfigurationPushBranchArgs $) {
        this.excludes = $.excludes;
        this.includes = $.includes;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PipelineTriggerAllGitConfigurationPushBranchArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PipelineTriggerAllGitConfigurationPushBranchArgs $;

        public Builder() {
            $ = new PipelineTriggerAllGitConfigurationPushBranchArgs();
        }

        public Builder(PipelineTriggerAllGitConfigurationPushBranchArgs defaults) {
            $ = new PipelineTriggerAllGitConfigurationPushBranchArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param excludes A list of patterns of Git branches that, when a commit is pushed, are to be excluded from starting the pipeline.
         * 
         * @return builder
         * 
         */
        public Builder excludes(@Nullable Output<List<String>> excludes) {
            $.excludes = excludes;
            return this;
        }

        /**
         * @param excludes A list of patterns of Git branches that, when a commit is pushed, are to be excluded from starting the pipeline.
         * 
         * @return builder
         * 
         */
        public Builder excludes(List<String> excludes) {
            return excludes(Output.of(excludes));
        }

        /**
         * @param excludes A list of patterns of Git branches that, when a commit is pushed, are to be excluded from starting the pipeline.
         * 
         * @return builder
         * 
         */
        public Builder excludes(String... excludes) {
            return excludes(List.of(excludes));
        }

        /**
         * @param includes A list of patterns of Git branches that, when a commit is pushed, are to be included as criteria that starts the pipeline.
         * 
         * @return builder
         * 
         */
        public Builder includes(@Nullable Output<List<String>> includes) {
            $.includes = includes;
            return this;
        }

        /**
         * @param includes A list of patterns of Git branches that, when a commit is pushed, are to be included as criteria that starts the pipeline.
         * 
         * @return builder
         * 
         */
        public Builder includes(List<String> includes) {
            return includes(Output.of(includes));
        }

        /**
         * @param includes A list of patterns of Git branches that, when a commit is pushed, are to be included as criteria that starts the pipeline.
         * 
         * @return builder
         * 
         */
        public Builder includes(String... includes) {
            return includes(List.of(includes));
        }

        public PipelineTriggerAllGitConfigurationPushBranchArgs build() {
            return $;
        }
    }

}
