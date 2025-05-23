// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codebuild.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class ProjectSecondarySourceVersionArgs extends com.pulumi.resources.ResourceArgs {

    public static final ProjectSecondarySourceVersionArgs Empty = new ProjectSecondarySourceVersionArgs();

    /**
     * An identifier for a source in the build project.
     * 
     */
    @Import(name="sourceIdentifier", required=true)
    private Output<String> sourceIdentifier;

    /**
     * @return An identifier for a source in the build project.
     * 
     */
    public Output<String> sourceIdentifier() {
        return this.sourceIdentifier;
    }

    /**
     * The source version for the corresponding source identifier.
     * See [AWS docs](https://docs.aws.amazon.com/codebuild/latest/APIReference/API_ProjectSourceVersion.html#CodeBuild-Type-ProjectSourceVersion-sourceVersion)
     * for more details.
     * 
     */
    @Import(name="sourceVersion", required=true)
    private Output<String> sourceVersion;

    /**
     * @return The source version for the corresponding source identifier.
     * See [AWS docs](https://docs.aws.amazon.com/codebuild/latest/APIReference/API_ProjectSourceVersion.html#CodeBuild-Type-ProjectSourceVersion-sourceVersion)
     * for more details.
     * 
     */
    public Output<String> sourceVersion() {
        return this.sourceVersion;
    }

    private ProjectSecondarySourceVersionArgs() {}

    private ProjectSecondarySourceVersionArgs(ProjectSecondarySourceVersionArgs $) {
        this.sourceIdentifier = $.sourceIdentifier;
        this.sourceVersion = $.sourceVersion;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ProjectSecondarySourceVersionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ProjectSecondarySourceVersionArgs $;

        public Builder() {
            $ = new ProjectSecondarySourceVersionArgs();
        }

        public Builder(ProjectSecondarySourceVersionArgs defaults) {
            $ = new ProjectSecondarySourceVersionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param sourceIdentifier An identifier for a source in the build project.
         * 
         * @return builder
         * 
         */
        public Builder sourceIdentifier(Output<String> sourceIdentifier) {
            $.sourceIdentifier = sourceIdentifier;
            return this;
        }

        /**
         * @param sourceIdentifier An identifier for a source in the build project.
         * 
         * @return builder
         * 
         */
        public Builder sourceIdentifier(String sourceIdentifier) {
            return sourceIdentifier(Output.of(sourceIdentifier));
        }

        /**
         * @param sourceVersion The source version for the corresponding source identifier.
         * See [AWS docs](https://docs.aws.amazon.com/codebuild/latest/APIReference/API_ProjectSourceVersion.html#CodeBuild-Type-ProjectSourceVersion-sourceVersion)
         * for more details.
         * 
         * @return builder
         * 
         */
        public Builder sourceVersion(Output<String> sourceVersion) {
            $.sourceVersion = sourceVersion;
            return this;
        }

        /**
         * @param sourceVersion The source version for the corresponding source identifier.
         * See [AWS docs](https://docs.aws.amazon.com/codebuild/latest/APIReference/API_ProjectSourceVersion.html#CodeBuild-Type-ProjectSourceVersion-sourceVersion)
         * for more details.
         * 
         * @return builder
         * 
         */
        public Builder sourceVersion(String sourceVersion) {
            return sourceVersion(Output.of(sourceVersion));
        }

        public ProjectSecondarySourceVersionArgs build() {
            if ($.sourceIdentifier == null) {
                throw new MissingRequiredPropertyException("ProjectSecondarySourceVersionArgs", "sourceIdentifier");
            }
            if ($.sourceVersion == null) {
                throw new MissingRequiredPropertyException("ProjectSecondarySourceVersionArgs", "sourceVersion");
            }
            return $;
        }
    }

}
