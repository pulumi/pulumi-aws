// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.macie2.inputs;

import com.pulumi.aws.macie2.inputs.ClassificationJobS3JobDefinitionScopingIncludesAndSimpleScopeTermArgs;
import com.pulumi.aws.macie2.inputs.ClassificationJobS3JobDefinitionScopingIncludesAndTagScopeTermArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ClassificationJobS3JobDefinitionScopingIncludesAndArgs extends com.pulumi.resources.ResourceArgs {

    public static final ClassificationJobS3JobDefinitionScopingIncludesAndArgs Empty = new ClassificationJobS3JobDefinitionScopingIncludesAndArgs();

    /**
     * A property-based condition that defines a property, operator, and one or more values for including or excluding an object from the job. (documented below)
     * 
     */
    @Import(name="simpleScopeTerm")
    private @Nullable Output<ClassificationJobS3JobDefinitionScopingIncludesAndSimpleScopeTermArgs> simpleScopeTerm;

    /**
     * @return A property-based condition that defines a property, operator, and one or more values for including or excluding an object from the job. (documented below)
     * 
     */
    public Optional<Output<ClassificationJobS3JobDefinitionScopingIncludesAndSimpleScopeTermArgs>> simpleScopeTerm() {
        return Optional.ofNullable(this.simpleScopeTerm);
    }

    /**
     * A tag-based condition that defines the operator and tag keys or tag key and value pairs for including or excluding an object from the job. (documented below)
     * 
     */
    @Import(name="tagScopeTerm")
    private @Nullable Output<ClassificationJobS3JobDefinitionScopingIncludesAndTagScopeTermArgs> tagScopeTerm;

    /**
     * @return A tag-based condition that defines the operator and tag keys or tag key and value pairs for including or excluding an object from the job. (documented below)
     * 
     */
    public Optional<Output<ClassificationJobS3JobDefinitionScopingIncludesAndTagScopeTermArgs>> tagScopeTerm() {
        return Optional.ofNullable(this.tagScopeTerm);
    }

    private ClassificationJobS3JobDefinitionScopingIncludesAndArgs() {}

    private ClassificationJobS3JobDefinitionScopingIncludesAndArgs(ClassificationJobS3JobDefinitionScopingIncludesAndArgs $) {
        this.simpleScopeTerm = $.simpleScopeTerm;
        this.tagScopeTerm = $.tagScopeTerm;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ClassificationJobS3JobDefinitionScopingIncludesAndArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ClassificationJobS3JobDefinitionScopingIncludesAndArgs $;

        public Builder() {
            $ = new ClassificationJobS3JobDefinitionScopingIncludesAndArgs();
        }

        public Builder(ClassificationJobS3JobDefinitionScopingIncludesAndArgs defaults) {
            $ = new ClassificationJobS3JobDefinitionScopingIncludesAndArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param simpleScopeTerm A property-based condition that defines a property, operator, and one or more values for including or excluding an object from the job. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder simpleScopeTerm(@Nullable Output<ClassificationJobS3JobDefinitionScopingIncludesAndSimpleScopeTermArgs> simpleScopeTerm) {
            $.simpleScopeTerm = simpleScopeTerm;
            return this;
        }

        /**
         * @param simpleScopeTerm A property-based condition that defines a property, operator, and one or more values for including or excluding an object from the job. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder simpleScopeTerm(ClassificationJobS3JobDefinitionScopingIncludesAndSimpleScopeTermArgs simpleScopeTerm) {
            return simpleScopeTerm(Output.of(simpleScopeTerm));
        }

        /**
         * @param tagScopeTerm A tag-based condition that defines the operator and tag keys or tag key and value pairs for including or excluding an object from the job. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder tagScopeTerm(@Nullable Output<ClassificationJobS3JobDefinitionScopingIncludesAndTagScopeTermArgs> tagScopeTerm) {
            $.tagScopeTerm = tagScopeTerm;
            return this;
        }

        /**
         * @param tagScopeTerm A tag-based condition that defines the operator and tag keys or tag key and value pairs for including or excluding an object from the job. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder tagScopeTerm(ClassificationJobS3JobDefinitionScopingIncludesAndTagScopeTermArgs tagScopeTerm) {
            return tagScopeTerm(Output.of(tagScopeTerm));
        }

        public ClassificationJobS3JobDefinitionScopingIncludesAndArgs build() {
            return $;
        }
    }

}
