// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs extends com.pulumi.resources.ResourceArgs {

    public static final DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs Empty = new DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs();

    /**
     * The Amazon S3 URI for the constraints resource.
     * 
     */
    @Import(name="s3Uri")
    private @Nullable Output<String> s3Uri;

    /**
     * @return The Amazon S3 URI for the constraints resource.
     * 
     */
    public Optional<Output<String>> s3Uri() {
        return Optional.ofNullable(this.s3Uri);
    }

    private DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs() {}

    private DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs(DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs $) {
        this.s3Uri = $.s3Uri;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs $;

        public Builder() {
            $ = new DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs();
        }

        public Builder(DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs defaults) {
            $ = new DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param s3Uri The Amazon S3 URI for the constraints resource.
         * 
         * @return builder
         * 
         */
        public Builder s3Uri(@Nullable Output<String> s3Uri) {
            $.s3Uri = s3Uri;
            return this;
        }

        /**
         * @param s3Uri The Amazon S3 URI for the constraints resource.
         * 
         * @return builder
         * 
         */
        public Builder s3Uri(String s3Uri) {
            return s3Uri(Output.of(s3Uri));
        }

        public DataQualityJobDefinitionDataQualityBaselineConfigConstraintsResourceArgs build() {
            return $;
        }
    }

}
