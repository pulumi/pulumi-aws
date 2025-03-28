// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codepipeline.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PipelineStageActionArgs extends com.pulumi.resources.ResourceArgs {

    public static final PipelineStageActionArgs Empty = new PipelineStageActionArgs();

    /**
     * A category defines what kind of action can be taken in the stage, and constrains the provider type for the action. Possible values are `Approval`, `Build`, `Deploy`, `Invoke`, `Source` and `Test`.
     * 
     */
    @Import(name="category", required=true)
    private Output<String> category;

    /**
     * @return A category defines what kind of action can be taken in the stage, and constrains the provider type for the action. Possible values are `Approval`, `Build`, `Deploy`, `Invoke`, `Source` and `Test`.
     * 
     */
    public Output<String> category() {
        return this.category;
    }

    /**
     * A map of the action declaration&#39;s configuration. Configurations options for action types and providers can be found in the [Pipeline Structure Reference](http://docs.aws.amazon.com/codepipeline/latest/userguide/reference-pipeline-structure.html#action-requirements) and [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation. Note: The `DetectChanges` parameter (optional, default value is true) in the `configuration` section causes CodePipeline to automatically start your pipeline upon new commits. Please refer to AWS Documentation for more details: https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference-CodestarConnectionSource.html#action-reference-CodestarConnectionSource-config.
     * 
     */
    @Import(name="configuration")
    private @Nullable Output<Map<String,String>> configuration;

    /**
     * @return A map of the action declaration&#39;s configuration. Configurations options for action types and providers can be found in the [Pipeline Structure Reference](http://docs.aws.amazon.com/codepipeline/latest/userguide/reference-pipeline-structure.html#action-requirements) and [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation. Note: The `DetectChanges` parameter (optional, default value is true) in the `configuration` section causes CodePipeline to automatically start your pipeline upon new commits. Please refer to AWS Documentation for more details: https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference-CodestarConnectionSource.html#action-reference-CodestarConnectionSource-config.
     * 
     */
    public Optional<Output<Map<String,String>>> configuration() {
        return Optional.ofNullable(this.configuration);
    }

    /**
     * A list of artifact names to be worked on.
     * 
     */
    @Import(name="inputArtifacts")
    private @Nullable Output<List<String>> inputArtifacts;

    /**
     * @return A list of artifact names to be worked on.
     * 
     */
    public Optional<Output<List<String>>> inputArtifacts() {
        return Optional.ofNullable(this.inputArtifacts);
    }

    /**
     * The action declaration&#39;s name.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return The action declaration&#39;s name.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * The namespace all output variables will be accessed from.
     * 
     */
    @Import(name="namespace")
    private @Nullable Output<String> namespace;

    /**
     * @return The namespace all output variables will be accessed from.
     * 
     */
    public Optional<Output<String>> namespace() {
        return Optional.ofNullable(this.namespace);
    }

    /**
     * A list of artifact names to output. Output artifact names must be unique within a pipeline.
     * 
     */
    @Import(name="outputArtifacts")
    private @Nullable Output<List<String>> outputArtifacts;

    /**
     * @return A list of artifact names to output. Output artifact names must be unique within a pipeline.
     * 
     */
    public Optional<Output<List<String>>> outputArtifacts() {
        return Optional.ofNullable(this.outputArtifacts);
    }

    /**
     * The creator of the action being called. Possible values are `AWS`, `Custom` and `ThirdParty`.
     * 
     */
    @Import(name="owner", required=true)
    private Output<String> owner;

    /**
     * @return The creator of the action being called. Possible values are `AWS`, `Custom` and `ThirdParty`.
     * 
     */
    public Output<String> owner() {
        return this.owner;
    }

    /**
     * The provider of the service being called by the action. Valid providers are determined by the action category. Provider names are listed in the [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation.
     * 
     */
    @Import(name="provider", required=true)
    private Output<String> provider;

    /**
     * @return The provider of the service being called by the action. Valid providers are determined by the action category. Provider names are listed in the [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation.
     * 
     */
    public Output<String> provider() {
        return this.provider;
    }

    /**
     * The region in which to run the action.
     * 
     */
    @Import(name="region")
    private @Nullable Output<String> region;

    /**
     * @return The region in which to run the action.
     * 
     */
    public Optional<Output<String>> region() {
        return Optional.ofNullable(this.region);
    }

    /**
     * The ARN of the IAM service role that will perform the declared action. This is assumed through the roleArn for the pipeline.
     * 
     */
    @Import(name="roleArn")
    private @Nullable Output<String> roleArn;

    /**
     * @return The ARN of the IAM service role that will perform the declared action. This is assumed through the roleArn for the pipeline.
     * 
     */
    public Optional<Output<String>> roleArn() {
        return Optional.ofNullable(this.roleArn);
    }

    /**
     * The order in which actions are run.
     * 
     */
    @Import(name="runOrder")
    private @Nullable Output<Integer> runOrder;

    /**
     * @return The order in which actions are run.
     * 
     */
    public Optional<Output<Integer>> runOrder() {
        return Optional.ofNullable(this.runOrder);
    }

    /**
     * The action timeout for the rule.
     * 
     */
    @Import(name="timeoutInMinutes")
    private @Nullable Output<Integer> timeoutInMinutes;

    /**
     * @return The action timeout for the rule.
     * 
     */
    public Optional<Output<Integer>> timeoutInMinutes() {
        return Optional.ofNullable(this.timeoutInMinutes);
    }

    /**
     * A string that identifies the action type.
     * 
     */
    @Import(name="version", required=true)
    private Output<String> version;

    /**
     * @return A string that identifies the action type.
     * 
     */
    public Output<String> version() {
        return this.version;
    }

    private PipelineStageActionArgs() {}

    private PipelineStageActionArgs(PipelineStageActionArgs $) {
        this.category = $.category;
        this.configuration = $.configuration;
        this.inputArtifacts = $.inputArtifacts;
        this.name = $.name;
        this.namespace = $.namespace;
        this.outputArtifacts = $.outputArtifacts;
        this.owner = $.owner;
        this.provider = $.provider;
        this.region = $.region;
        this.roleArn = $.roleArn;
        this.runOrder = $.runOrder;
        this.timeoutInMinutes = $.timeoutInMinutes;
        this.version = $.version;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PipelineStageActionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PipelineStageActionArgs $;

        public Builder() {
            $ = new PipelineStageActionArgs();
        }

        public Builder(PipelineStageActionArgs defaults) {
            $ = new PipelineStageActionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param category A category defines what kind of action can be taken in the stage, and constrains the provider type for the action. Possible values are `Approval`, `Build`, `Deploy`, `Invoke`, `Source` and `Test`.
         * 
         * @return builder
         * 
         */
        public Builder category(Output<String> category) {
            $.category = category;
            return this;
        }

        /**
         * @param category A category defines what kind of action can be taken in the stage, and constrains the provider type for the action. Possible values are `Approval`, `Build`, `Deploy`, `Invoke`, `Source` and `Test`.
         * 
         * @return builder
         * 
         */
        public Builder category(String category) {
            return category(Output.of(category));
        }

        /**
         * @param configuration A map of the action declaration&#39;s configuration. Configurations options for action types and providers can be found in the [Pipeline Structure Reference](http://docs.aws.amazon.com/codepipeline/latest/userguide/reference-pipeline-structure.html#action-requirements) and [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation. Note: The `DetectChanges` parameter (optional, default value is true) in the `configuration` section causes CodePipeline to automatically start your pipeline upon new commits. Please refer to AWS Documentation for more details: https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference-CodestarConnectionSource.html#action-reference-CodestarConnectionSource-config.
         * 
         * @return builder
         * 
         */
        public Builder configuration(@Nullable Output<Map<String,String>> configuration) {
            $.configuration = configuration;
            return this;
        }

        /**
         * @param configuration A map of the action declaration&#39;s configuration. Configurations options for action types and providers can be found in the [Pipeline Structure Reference](http://docs.aws.amazon.com/codepipeline/latest/userguide/reference-pipeline-structure.html#action-requirements) and [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation. Note: The `DetectChanges` parameter (optional, default value is true) in the `configuration` section causes CodePipeline to automatically start your pipeline upon new commits. Please refer to AWS Documentation for more details: https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference-CodestarConnectionSource.html#action-reference-CodestarConnectionSource-config.
         * 
         * @return builder
         * 
         */
        public Builder configuration(Map<String,String> configuration) {
            return configuration(Output.of(configuration));
        }

        /**
         * @param inputArtifacts A list of artifact names to be worked on.
         * 
         * @return builder
         * 
         */
        public Builder inputArtifacts(@Nullable Output<List<String>> inputArtifacts) {
            $.inputArtifacts = inputArtifacts;
            return this;
        }

        /**
         * @param inputArtifacts A list of artifact names to be worked on.
         * 
         * @return builder
         * 
         */
        public Builder inputArtifacts(List<String> inputArtifacts) {
            return inputArtifacts(Output.of(inputArtifacts));
        }

        /**
         * @param inputArtifacts A list of artifact names to be worked on.
         * 
         * @return builder
         * 
         */
        public Builder inputArtifacts(String... inputArtifacts) {
            return inputArtifacts(List.of(inputArtifacts));
        }

        /**
         * @param name The action declaration&#39;s name.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name The action declaration&#39;s name.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param namespace The namespace all output variables will be accessed from.
         * 
         * @return builder
         * 
         */
        public Builder namespace(@Nullable Output<String> namespace) {
            $.namespace = namespace;
            return this;
        }

        /**
         * @param namespace The namespace all output variables will be accessed from.
         * 
         * @return builder
         * 
         */
        public Builder namespace(String namespace) {
            return namespace(Output.of(namespace));
        }

        /**
         * @param outputArtifacts A list of artifact names to output. Output artifact names must be unique within a pipeline.
         * 
         * @return builder
         * 
         */
        public Builder outputArtifacts(@Nullable Output<List<String>> outputArtifacts) {
            $.outputArtifacts = outputArtifacts;
            return this;
        }

        /**
         * @param outputArtifacts A list of artifact names to output. Output artifact names must be unique within a pipeline.
         * 
         * @return builder
         * 
         */
        public Builder outputArtifacts(List<String> outputArtifacts) {
            return outputArtifacts(Output.of(outputArtifacts));
        }

        /**
         * @param outputArtifacts A list of artifact names to output. Output artifact names must be unique within a pipeline.
         * 
         * @return builder
         * 
         */
        public Builder outputArtifacts(String... outputArtifacts) {
            return outputArtifacts(List.of(outputArtifacts));
        }

        /**
         * @param owner The creator of the action being called. Possible values are `AWS`, `Custom` and `ThirdParty`.
         * 
         * @return builder
         * 
         */
        public Builder owner(Output<String> owner) {
            $.owner = owner;
            return this;
        }

        /**
         * @param owner The creator of the action being called. Possible values are `AWS`, `Custom` and `ThirdParty`.
         * 
         * @return builder
         * 
         */
        public Builder owner(String owner) {
            return owner(Output.of(owner));
        }

        /**
         * @param provider The provider of the service being called by the action. Valid providers are determined by the action category. Provider names are listed in the [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation.
         * 
         * @return builder
         * 
         */
        public Builder provider(Output<String> provider) {
            $.provider = provider;
            return this;
        }

        /**
         * @param provider The provider of the service being called by the action. Valid providers are determined by the action category. Provider names are listed in the [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation.
         * 
         * @return builder
         * 
         */
        public Builder provider(String provider) {
            return provider(Output.of(provider));
        }

        /**
         * @param region The region in which to run the action.
         * 
         * @return builder
         * 
         */
        public Builder region(@Nullable Output<String> region) {
            $.region = region;
            return this;
        }

        /**
         * @param region The region in which to run the action.
         * 
         * @return builder
         * 
         */
        public Builder region(String region) {
            return region(Output.of(region));
        }

        /**
         * @param roleArn The ARN of the IAM service role that will perform the declared action. This is assumed through the roleArn for the pipeline.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(@Nullable Output<String> roleArn) {
            $.roleArn = roleArn;
            return this;
        }

        /**
         * @param roleArn The ARN of the IAM service role that will perform the declared action. This is assumed through the roleArn for the pipeline.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(String roleArn) {
            return roleArn(Output.of(roleArn));
        }

        /**
         * @param runOrder The order in which actions are run.
         * 
         * @return builder
         * 
         */
        public Builder runOrder(@Nullable Output<Integer> runOrder) {
            $.runOrder = runOrder;
            return this;
        }

        /**
         * @param runOrder The order in which actions are run.
         * 
         * @return builder
         * 
         */
        public Builder runOrder(Integer runOrder) {
            return runOrder(Output.of(runOrder));
        }

        /**
         * @param timeoutInMinutes The action timeout for the rule.
         * 
         * @return builder
         * 
         */
        public Builder timeoutInMinutes(@Nullable Output<Integer> timeoutInMinutes) {
            $.timeoutInMinutes = timeoutInMinutes;
            return this;
        }

        /**
         * @param timeoutInMinutes The action timeout for the rule.
         * 
         * @return builder
         * 
         */
        public Builder timeoutInMinutes(Integer timeoutInMinutes) {
            return timeoutInMinutes(Output.of(timeoutInMinutes));
        }

        /**
         * @param version A string that identifies the action type.
         * 
         * @return builder
         * 
         */
        public Builder version(Output<String> version) {
            $.version = version;
            return this;
        }

        /**
         * @param version A string that identifies the action type.
         * 
         * @return builder
         * 
         */
        public Builder version(String version) {
            return version(Output.of(version));
        }

        public PipelineStageActionArgs build() {
            if ($.category == null) {
                throw new MissingRequiredPropertyException("PipelineStageActionArgs", "category");
            }
            if ($.name == null) {
                throw new MissingRequiredPropertyException("PipelineStageActionArgs", "name");
            }
            if ($.owner == null) {
                throw new MissingRequiredPropertyException("PipelineStageActionArgs", "owner");
            }
            if ($.provider == null) {
                throw new MissingRequiredPropertyException("PipelineStageActionArgs", "provider");
            }
            if ($.version == null) {
                throw new MissingRequiredPropertyException("PipelineStageActionArgs", "version");
            }
            return $;
        }
    }

}
