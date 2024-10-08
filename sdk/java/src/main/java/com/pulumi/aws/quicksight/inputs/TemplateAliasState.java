// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.quicksight.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TemplateAliasState extends com.pulumi.resources.ResourceArgs {

    public static final TemplateAliasState Empty = new TemplateAliasState();

    /**
     * Display name of the template alias.
     * 
     */
    @Import(name="aliasName")
    private @Nullable Output<String> aliasName;

    /**
     * @return Display name of the template alias.
     * 
     */
    public Optional<Output<String>> aliasName() {
        return Optional.ofNullable(this.aliasName);
    }

    /**
     * Amazon Resource Name (ARN) of the template alias.
     * 
     */
    @Import(name="arn")
    private @Nullable Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of the template alias.
     * 
     */
    public Optional<Output<String>> arn() {
        return Optional.ofNullable(this.arn);
    }

    /**
     * AWS account ID.
     * 
     */
    @Import(name="awsAccountId")
    private @Nullable Output<String> awsAccountId;

    /**
     * @return AWS account ID.
     * 
     */
    public Optional<Output<String>> awsAccountId() {
        return Optional.ofNullable(this.awsAccountId);
    }

    /**
     * ID of the template.
     * 
     */
    @Import(name="templateId")
    private @Nullable Output<String> templateId;

    /**
     * @return ID of the template.
     * 
     */
    public Optional<Output<String>> templateId() {
        return Optional.ofNullable(this.templateId);
    }

    /**
     * Version number of the template.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="templateVersionNumber")
    private @Nullable Output<Integer> templateVersionNumber;

    /**
     * @return Version number of the template.
     * 
     * The following arguments are optional:
     * 
     */
    public Optional<Output<Integer>> templateVersionNumber() {
        return Optional.ofNullable(this.templateVersionNumber);
    }

    private TemplateAliasState() {}

    private TemplateAliasState(TemplateAliasState $) {
        this.aliasName = $.aliasName;
        this.arn = $.arn;
        this.awsAccountId = $.awsAccountId;
        this.templateId = $.templateId;
        this.templateVersionNumber = $.templateVersionNumber;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TemplateAliasState defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TemplateAliasState $;

        public Builder() {
            $ = new TemplateAliasState();
        }

        public Builder(TemplateAliasState defaults) {
            $ = new TemplateAliasState(Objects.requireNonNull(defaults));
        }

        /**
         * @param aliasName Display name of the template alias.
         * 
         * @return builder
         * 
         */
        public Builder aliasName(@Nullable Output<String> aliasName) {
            $.aliasName = aliasName;
            return this;
        }

        /**
         * @param aliasName Display name of the template alias.
         * 
         * @return builder
         * 
         */
        public Builder aliasName(String aliasName) {
            return aliasName(Output.of(aliasName));
        }

        /**
         * @param arn Amazon Resource Name (ARN) of the template alias.
         * 
         * @return builder
         * 
         */
        public Builder arn(@Nullable Output<String> arn) {
            $.arn = arn;
            return this;
        }

        /**
         * @param arn Amazon Resource Name (ARN) of the template alias.
         * 
         * @return builder
         * 
         */
        public Builder arn(String arn) {
            return arn(Output.of(arn));
        }

        /**
         * @param awsAccountId AWS account ID.
         * 
         * @return builder
         * 
         */
        public Builder awsAccountId(@Nullable Output<String> awsAccountId) {
            $.awsAccountId = awsAccountId;
            return this;
        }

        /**
         * @param awsAccountId AWS account ID.
         * 
         * @return builder
         * 
         */
        public Builder awsAccountId(String awsAccountId) {
            return awsAccountId(Output.of(awsAccountId));
        }

        /**
         * @param templateId ID of the template.
         * 
         * @return builder
         * 
         */
        public Builder templateId(@Nullable Output<String> templateId) {
            $.templateId = templateId;
            return this;
        }

        /**
         * @param templateId ID of the template.
         * 
         * @return builder
         * 
         */
        public Builder templateId(String templateId) {
            return templateId(Output.of(templateId));
        }

        /**
         * @param templateVersionNumber Version number of the template.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder templateVersionNumber(@Nullable Output<Integer> templateVersionNumber) {
            $.templateVersionNumber = templateVersionNumber;
            return this;
        }

        /**
         * @param templateVersionNumber Version number of the template.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder templateVersionNumber(Integer templateVersionNumber) {
            return templateVersionNumber(Output.of(templateVersionNumber));
        }

        public TemplateAliasState build() {
            return $;
        }
    }

}
