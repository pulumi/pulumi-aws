// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codepipeline.outputs;

import com.pulumi.aws.codepipeline.outputs.PipelineTriggerGitConfigurationPushBranches;
import com.pulumi.aws.codepipeline.outputs.PipelineTriggerGitConfigurationPushFilePaths;
import com.pulumi.aws.codepipeline.outputs.PipelineTriggerGitConfigurationPushTags;
import com.pulumi.core.annotations.CustomType;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class PipelineTriggerGitConfigurationPush {
    /**
     * @return The field that specifies to filter on branches for the push trigger configuration. A `branches` block is documented below.
     * 
     */
    private @Nullable PipelineTriggerGitConfigurationPushBranches branches;
    /**
     * @return The field that specifies to filter on file paths for the push trigger configuration. A `file_paths` block is documented below.
     * 
     */
    private @Nullable PipelineTriggerGitConfigurationPushFilePaths filePaths;
    /**
     * @return The field that contains the details for the Git tags trigger configuration. A `tags` block is documented below.
     * 
     */
    private @Nullable PipelineTriggerGitConfigurationPushTags tags;

    private PipelineTriggerGitConfigurationPush() {}
    /**
     * @return The field that specifies to filter on branches for the push trigger configuration. A `branches` block is documented below.
     * 
     */
    public Optional<PipelineTriggerGitConfigurationPushBranches> branches() {
        return Optional.ofNullable(this.branches);
    }
    /**
     * @return The field that specifies to filter on file paths for the push trigger configuration. A `file_paths` block is documented below.
     * 
     */
    public Optional<PipelineTriggerGitConfigurationPushFilePaths> filePaths() {
        return Optional.ofNullable(this.filePaths);
    }
    /**
     * @return The field that contains the details for the Git tags trigger configuration. A `tags` block is documented below.
     * 
     */
    public Optional<PipelineTriggerGitConfigurationPushTags> tags() {
        return Optional.ofNullable(this.tags);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PipelineTriggerGitConfigurationPush defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable PipelineTriggerGitConfigurationPushBranches branches;
        private @Nullable PipelineTriggerGitConfigurationPushFilePaths filePaths;
        private @Nullable PipelineTriggerGitConfigurationPushTags tags;
        public Builder() {}
        public Builder(PipelineTriggerGitConfigurationPush defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.branches = defaults.branches;
    	      this.filePaths = defaults.filePaths;
    	      this.tags = defaults.tags;
        }

        @CustomType.Setter
        public Builder branches(@Nullable PipelineTriggerGitConfigurationPushBranches branches) {

            this.branches = branches;
            return this;
        }
        @CustomType.Setter
        public Builder filePaths(@Nullable PipelineTriggerGitConfigurationPushFilePaths filePaths) {

            this.filePaths = filePaths;
            return this;
        }
        @CustomType.Setter
        public Builder tags(@Nullable PipelineTriggerGitConfigurationPushTags tags) {

            this.tags = tags;
            return this;
        }
        public PipelineTriggerGitConfigurationPush build() {
            final var _resultValue = new PipelineTriggerGitConfigurationPush();
            _resultValue.branches = branches;
            _resultValue.filePaths = filePaths;
            _resultValue.tags = tags;
            return _resultValue;
        }
    }
}
