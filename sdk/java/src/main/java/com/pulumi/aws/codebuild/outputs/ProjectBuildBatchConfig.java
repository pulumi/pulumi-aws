// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codebuild.outputs;

import com.pulumi.aws.codebuild.outputs.ProjectBuildBatchConfigRestrictions;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ProjectBuildBatchConfig {
    /**
     * @return Specifies if the build artifacts for the batch build should be combined into a single
     * artifact location.
     * 
     */
    private @Nullable Boolean combineArtifacts;
    /**
     * @return Configuration block specifying the restrictions for the batch build. Detailed below.
     * 
     */
    private @Nullable ProjectBuildBatchConfigRestrictions restrictions;
    /**
     * @return Specifies the service role ARN for the batch build project.
     * 
     */
    private String serviceRole;
    /**
     * @return Specifies the maximum amount of time, in minutes, that the batch build must be
     * completed in.
     * 
     */
    private @Nullable Integer timeoutInMins;

    private ProjectBuildBatchConfig() {}
    /**
     * @return Specifies if the build artifacts for the batch build should be combined into a single
     * artifact location.
     * 
     */
    public Optional<Boolean> combineArtifacts() {
        return Optional.ofNullable(this.combineArtifacts);
    }
    /**
     * @return Configuration block specifying the restrictions for the batch build. Detailed below.
     * 
     */
    public Optional<ProjectBuildBatchConfigRestrictions> restrictions() {
        return Optional.ofNullable(this.restrictions);
    }
    /**
     * @return Specifies the service role ARN for the batch build project.
     * 
     */
    public String serviceRole() {
        return this.serviceRole;
    }
    /**
     * @return Specifies the maximum amount of time, in minutes, that the batch build must be
     * completed in.
     * 
     */
    public Optional<Integer> timeoutInMins() {
        return Optional.ofNullable(this.timeoutInMins);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ProjectBuildBatchConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean combineArtifacts;
        private @Nullable ProjectBuildBatchConfigRestrictions restrictions;
        private String serviceRole;
        private @Nullable Integer timeoutInMins;
        public Builder() {}
        public Builder(ProjectBuildBatchConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.combineArtifacts = defaults.combineArtifacts;
    	      this.restrictions = defaults.restrictions;
    	      this.serviceRole = defaults.serviceRole;
    	      this.timeoutInMins = defaults.timeoutInMins;
        }

        @CustomType.Setter
        public Builder combineArtifacts(@Nullable Boolean combineArtifacts) {

            this.combineArtifacts = combineArtifacts;
            return this;
        }
        @CustomType.Setter
        public Builder restrictions(@Nullable ProjectBuildBatchConfigRestrictions restrictions) {

            this.restrictions = restrictions;
            return this;
        }
        @CustomType.Setter
        public Builder serviceRole(String serviceRole) {
            if (serviceRole == null) {
              throw new MissingRequiredPropertyException("ProjectBuildBatchConfig", "serviceRole");
            }
            this.serviceRole = serviceRole;
            return this;
        }
        @CustomType.Setter
        public Builder timeoutInMins(@Nullable Integer timeoutInMins) {

            this.timeoutInMins = timeoutInMins;
            return this;
        }
        public ProjectBuildBatchConfig build() {
            final var _resultValue = new ProjectBuildBatchConfig();
            _resultValue.combineArtifacts = combineArtifacts;
            _resultValue.restrictions = restrictions;
            _resultValue.serviceRole = serviceRole;
            _resultValue.timeoutInMins = timeoutInMins;
            return _resultValue;
        }
    }
}
