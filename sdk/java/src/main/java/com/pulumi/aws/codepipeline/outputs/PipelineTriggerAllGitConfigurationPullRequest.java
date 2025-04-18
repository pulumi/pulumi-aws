// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codepipeline.outputs;

import com.pulumi.aws.codepipeline.outputs.PipelineTriggerAllGitConfigurationPullRequestBranch;
import com.pulumi.aws.codepipeline.outputs.PipelineTriggerAllGitConfigurationPullRequestFilePath;
import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class PipelineTriggerAllGitConfigurationPullRequest {
    /**
     * @return The field that specifies to filter on branches for the pull request trigger configuration. A `branches` block is documented below.
     * 
     */
    private @Nullable List<PipelineTriggerAllGitConfigurationPullRequestBranch> branches;
    /**
     * @return A list that specifies which pull request events to filter on (opened, updated, closed) for the trigger configuration. Possible values are `OPEN`, ` UPDATED  ` and `CLOSED`.
     * 
     */
    private @Nullable List<String> events;
    /**
     * @return The field that specifies to filter on file paths for the pull request trigger configuration. A `file_paths` block is documented below.
     * 
     */
    private @Nullable List<PipelineTriggerAllGitConfigurationPullRequestFilePath> filePaths;

    private PipelineTriggerAllGitConfigurationPullRequest() {}
    /**
     * @return The field that specifies to filter on branches for the pull request trigger configuration. A `branches` block is documented below.
     * 
     */
    public List<PipelineTriggerAllGitConfigurationPullRequestBranch> branches() {
        return this.branches == null ? List.of() : this.branches;
    }
    /**
     * @return A list that specifies which pull request events to filter on (opened, updated, closed) for the trigger configuration. Possible values are `OPEN`, ` UPDATED  ` and `CLOSED`.
     * 
     */
    public List<String> events() {
        return this.events == null ? List.of() : this.events;
    }
    /**
     * @return The field that specifies to filter on file paths for the pull request trigger configuration. A `file_paths` block is documented below.
     * 
     */
    public List<PipelineTriggerAllGitConfigurationPullRequestFilePath> filePaths() {
        return this.filePaths == null ? List.of() : this.filePaths;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PipelineTriggerAllGitConfigurationPullRequest defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<PipelineTriggerAllGitConfigurationPullRequestBranch> branches;
        private @Nullable List<String> events;
        private @Nullable List<PipelineTriggerAllGitConfigurationPullRequestFilePath> filePaths;
        public Builder() {}
        public Builder(PipelineTriggerAllGitConfigurationPullRequest defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.branches = defaults.branches;
    	      this.events = defaults.events;
    	      this.filePaths = defaults.filePaths;
        }

        @CustomType.Setter
        public Builder branches(@Nullable List<PipelineTriggerAllGitConfigurationPullRequestBranch> branches) {

            this.branches = branches;
            return this;
        }
        public Builder branches(PipelineTriggerAllGitConfigurationPullRequestBranch... branches) {
            return branches(List.of(branches));
        }
        @CustomType.Setter
        public Builder events(@Nullable List<String> events) {

            this.events = events;
            return this;
        }
        public Builder events(String... events) {
            return events(List.of(events));
        }
        @CustomType.Setter
        public Builder filePaths(@Nullable List<PipelineTriggerAllGitConfigurationPullRequestFilePath> filePaths) {

            this.filePaths = filePaths;
            return this;
        }
        public Builder filePaths(PipelineTriggerAllGitConfigurationPullRequestFilePath... filePaths) {
            return filePaths(List.of(filePaths));
        }
        public PipelineTriggerAllGitConfigurationPullRequest build() {
            final var _resultValue = new PipelineTriggerAllGitConfigurationPullRequest();
            _resultValue.branches = branches;
            _resultValue.events = events;
            _resultValue.filePaths = filePaths;
            return _resultValue;
        }
    }
}
