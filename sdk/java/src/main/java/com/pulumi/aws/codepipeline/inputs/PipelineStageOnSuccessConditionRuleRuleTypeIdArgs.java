// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codepipeline.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PipelineStageOnSuccessConditionRuleRuleTypeIdArgs extends com.pulumi.resources.ResourceArgs {

    public static final PipelineStageOnSuccessConditionRuleRuleTypeIdArgs Empty = new PipelineStageOnSuccessConditionRuleRuleTypeIdArgs();

    /**
     * A category defines what kind of rule can be run in the stage, and constrains the provider type for the rule. The valid category is `Rule`.
     * 
     */
    @Import(name="category", required=true)
    private Output<String> category;

    /**
     * @return A category defines what kind of rule can be run in the stage, and constrains the provider type for the rule. The valid category is `Rule`.
     * 
     */
    public Output<String> category() {
        return this.category;
    }

    /**
     * The creator of the rule being called. The valid value for the Owner field in the rule category is `AWS`.
     * 
     */
    @Import(name="owner")
    private @Nullable Output<String> owner;

    /**
     * @return The creator of the rule being called. The valid value for the Owner field in the rule category is `AWS`.
     * 
     */
    public Optional<Output<String>> owner() {
        return Optional.ofNullable(this.owner);
    }

    /**
     * The rule provider, such as the DeploymentWindow rule. For a list of rule provider names, see the rules listed in the [AWS CodePipeline rule reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/rule-reference.html).
     * 
     */
    @Import(name="provider", required=true)
    private Output<String> provider;

    /**
     * @return The rule provider, such as the DeploymentWindow rule. For a list of rule provider names, see the rules listed in the [AWS CodePipeline rule reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/rule-reference.html).
     * 
     */
    public Output<String> provider() {
        return this.provider;
    }

    /**
     * A string that describes the rule version.
     * 
     */
    @Import(name="version")
    private @Nullable Output<String> version;

    /**
     * @return A string that describes the rule version.
     * 
     */
    public Optional<Output<String>> version() {
        return Optional.ofNullable(this.version);
    }

    private PipelineStageOnSuccessConditionRuleRuleTypeIdArgs() {}

    private PipelineStageOnSuccessConditionRuleRuleTypeIdArgs(PipelineStageOnSuccessConditionRuleRuleTypeIdArgs $) {
        this.category = $.category;
        this.owner = $.owner;
        this.provider = $.provider;
        this.version = $.version;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PipelineStageOnSuccessConditionRuleRuleTypeIdArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PipelineStageOnSuccessConditionRuleRuleTypeIdArgs $;

        public Builder() {
            $ = new PipelineStageOnSuccessConditionRuleRuleTypeIdArgs();
        }

        public Builder(PipelineStageOnSuccessConditionRuleRuleTypeIdArgs defaults) {
            $ = new PipelineStageOnSuccessConditionRuleRuleTypeIdArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param category A category defines what kind of rule can be run in the stage, and constrains the provider type for the rule. The valid category is `Rule`.
         * 
         * @return builder
         * 
         */
        public Builder category(Output<String> category) {
            $.category = category;
            return this;
        }

        /**
         * @param category A category defines what kind of rule can be run in the stage, and constrains the provider type for the rule. The valid category is `Rule`.
         * 
         * @return builder
         * 
         */
        public Builder category(String category) {
            return category(Output.of(category));
        }

        /**
         * @param owner The creator of the rule being called. The valid value for the Owner field in the rule category is `AWS`.
         * 
         * @return builder
         * 
         */
        public Builder owner(@Nullable Output<String> owner) {
            $.owner = owner;
            return this;
        }

        /**
         * @param owner The creator of the rule being called. The valid value for the Owner field in the rule category is `AWS`.
         * 
         * @return builder
         * 
         */
        public Builder owner(String owner) {
            return owner(Output.of(owner));
        }

        /**
         * @param provider The rule provider, such as the DeploymentWindow rule. For a list of rule provider names, see the rules listed in the [AWS CodePipeline rule reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/rule-reference.html).
         * 
         * @return builder
         * 
         */
        public Builder provider(Output<String> provider) {
            $.provider = provider;
            return this;
        }

        /**
         * @param provider The rule provider, such as the DeploymentWindow rule. For a list of rule provider names, see the rules listed in the [AWS CodePipeline rule reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/rule-reference.html).
         * 
         * @return builder
         * 
         */
        public Builder provider(String provider) {
            return provider(Output.of(provider));
        }

        /**
         * @param version A string that describes the rule version.
         * 
         * @return builder
         * 
         */
        public Builder version(@Nullable Output<String> version) {
            $.version = version;
            return this;
        }

        /**
         * @param version A string that describes the rule version.
         * 
         * @return builder
         * 
         */
        public Builder version(String version) {
            return version(Output.of(version));
        }

        public PipelineStageOnSuccessConditionRuleRuleTypeIdArgs build() {
            if ($.category == null) {
                throw new MissingRequiredPropertyException("PipelineStageOnSuccessConditionRuleRuleTypeIdArgs", "category");
            }
            if ($.provider == null) {
                throw new MissingRequiredPropertyException("PipelineStageOnSuccessConditionRuleRuleTypeIdArgs", "provider");
            }
            return $;
        }
    }

}
