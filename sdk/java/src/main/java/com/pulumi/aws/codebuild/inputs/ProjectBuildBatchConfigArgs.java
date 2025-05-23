// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codebuild.inputs;

import com.pulumi.aws.codebuild.inputs.ProjectBuildBatchConfigRestrictionsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ProjectBuildBatchConfigArgs extends com.pulumi.resources.ResourceArgs {

    public static final ProjectBuildBatchConfigArgs Empty = new ProjectBuildBatchConfigArgs();

    /**
     * Specifies if the build artifacts for the batch build should be combined into a single
     * artifact location.
     * 
     */
    @Import(name="combineArtifacts")
    private @Nullable Output<Boolean> combineArtifacts;

    /**
     * @return Specifies if the build artifacts for the batch build should be combined into a single
     * artifact location.
     * 
     */
    public Optional<Output<Boolean>> combineArtifacts() {
        return Optional.ofNullable(this.combineArtifacts);
    }

    /**
     * Configuration block specifying the restrictions for the batch build. Detailed below.
     * 
     */
    @Import(name="restrictions")
    private @Nullable Output<ProjectBuildBatchConfigRestrictionsArgs> restrictions;

    /**
     * @return Configuration block specifying the restrictions for the batch build. Detailed below.
     * 
     */
    public Optional<Output<ProjectBuildBatchConfigRestrictionsArgs>> restrictions() {
        return Optional.ofNullable(this.restrictions);
    }

    /**
     * Specifies the service role ARN for the batch build project.
     * 
     */
    @Import(name="serviceRole", required=true)
    private Output<String> serviceRole;

    /**
     * @return Specifies the service role ARN for the batch build project.
     * 
     */
    public Output<String> serviceRole() {
        return this.serviceRole;
    }

    /**
     * Specifies the maximum amount of time, in minutes, that the batch build must be
     * completed in.
     * 
     */
    @Import(name="timeoutInMins")
    private @Nullable Output<Integer> timeoutInMins;

    /**
     * @return Specifies the maximum amount of time, in minutes, that the batch build must be
     * completed in.
     * 
     */
    public Optional<Output<Integer>> timeoutInMins() {
        return Optional.ofNullable(this.timeoutInMins);
    }

    private ProjectBuildBatchConfigArgs() {}

    private ProjectBuildBatchConfigArgs(ProjectBuildBatchConfigArgs $) {
        this.combineArtifacts = $.combineArtifacts;
        this.restrictions = $.restrictions;
        this.serviceRole = $.serviceRole;
        this.timeoutInMins = $.timeoutInMins;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ProjectBuildBatchConfigArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ProjectBuildBatchConfigArgs $;

        public Builder() {
            $ = new ProjectBuildBatchConfigArgs();
        }

        public Builder(ProjectBuildBatchConfigArgs defaults) {
            $ = new ProjectBuildBatchConfigArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param combineArtifacts Specifies if the build artifacts for the batch build should be combined into a single
         * artifact location.
         * 
         * @return builder
         * 
         */
        public Builder combineArtifacts(@Nullable Output<Boolean> combineArtifacts) {
            $.combineArtifacts = combineArtifacts;
            return this;
        }

        /**
         * @param combineArtifacts Specifies if the build artifacts for the batch build should be combined into a single
         * artifact location.
         * 
         * @return builder
         * 
         */
        public Builder combineArtifacts(Boolean combineArtifacts) {
            return combineArtifacts(Output.of(combineArtifacts));
        }

        /**
         * @param restrictions Configuration block specifying the restrictions for the batch build. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder restrictions(@Nullable Output<ProjectBuildBatchConfigRestrictionsArgs> restrictions) {
            $.restrictions = restrictions;
            return this;
        }

        /**
         * @param restrictions Configuration block specifying the restrictions for the batch build. Detailed below.
         * 
         * @return builder
         * 
         */
        public Builder restrictions(ProjectBuildBatchConfigRestrictionsArgs restrictions) {
            return restrictions(Output.of(restrictions));
        }

        /**
         * @param serviceRole Specifies the service role ARN for the batch build project.
         * 
         * @return builder
         * 
         */
        public Builder serviceRole(Output<String> serviceRole) {
            $.serviceRole = serviceRole;
            return this;
        }

        /**
         * @param serviceRole Specifies the service role ARN for the batch build project.
         * 
         * @return builder
         * 
         */
        public Builder serviceRole(String serviceRole) {
            return serviceRole(Output.of(serviceRole));
        }

        /**
         * @param timeoutInMins Specifies the maximum amount of time, in minutes, that the batch build must be
         * completed in.
         * 
         * @return builder
         * 
         */
        public Builder timeoutInMins(@Nullable Output<Integer> timeoutInMins) {
            $.timeoutInMins = timeoutInMins;
            return this;
        }

        /**
         * @param timeoutInMins Specifies the maximum amount of time, in minutes, that the batch build must be
         * completed in.
         * 
         * @return builder
         * 
         */
        public Builder timeoutInMins(Integer timeoutInMins) {
            return timeoutInMins(Output.of(timeoutInMins));
        }

        public ProjectBuildBatchConfigArgs build() {
            if ($.serviceRole == null) {
                throw new MissingRequiredPropertyException("ProjectBuildBatchConfigArgs", "serviceRole");
            }
            return $;
        }
    }

}
