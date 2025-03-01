// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cleanrooms.inputs;

import com.pulumi.aws.cleanrooms.inputs.MembershipDefaultResultConfigurationOutputConfigurationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class MembershipDefaultResultConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final MembershipDefaultResultConfigurationArgs Empty = new MembershipDefaultResultConfigurationArgs();

    @Import(name="outputConfiguration")
    private @Nullable Output<MembershipDefaultResultConfigurationOutputConfigurationArgs> outputConfiguration;

    public Optional<Output<MembershipDefaultResultConfigurationOutputConfigurationArgs>> outputConfiguration() {
        return Optional.ofNullable(this.outputConfiguration);
    }

    /**
     * The ARN of the IAM role which will be used to create the membership.
     * - `output_configuration.s3.bucket` - (Required) - The name of the S3 bucket where the query results will be stored.
     * - `output_configuration.s3.result_format` - (Required) - The format of the query results. Valid values are `PARQUET` and `CSV`.
     * - `output_configuration.s3.key_prefix` - (Optional) - The prefix used for the query results.
     * 
     */
    @Import(name="roleArn")
    private @Nullable Output<String> roleArn;

    /**
     * @return The ARN of the IAM role which will be used to create the membership.
     * - `output_configuration.s3.bucket` - (Required) - The name of the S3 bucket where the query results will be stored.
     * - `output_configuration.s3.result_format` - (Required) - The format of the query results. Valid values are `PARQUET` and `CSV`.
     * - `output_configuration.s3.key_prefix` - (Optional) - The prefix used for the query results.
     * 
     */
    public Optional<Output<String>> roleArn() {
        return Optional.ofNullable(this.roleArn);
    }

    private MembershipDefaultResultConfigurationArgs() {}

    private MembershipDefaultResultConfigurationArgs(MembershipDefaultResultConfigurationArgs $) {
        this.outputConfiguration = $.outputConfiguration;
        this.roleArn = $.roleArn;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(MembershipDefaultResultConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private MembershipDefaultResultConfigurationArgs $;

        public Builder() {
            $ = new MembershipDefaultResultConfigurationArgs();
        }

        public Builder(MembershipDefaultResultConfigurationArgs defaults) {
            $ = new MembershipDefaultResultConfigurationArgs(Objects.requireNonNull(defaults));
        }

        public Builder outputConfiguration(@Nullable Output<MembershipDefaultResultConfigurationOutputConfigurationArgs> outputConfiguration) {
            $.outputConfiguration = outputConfiguration;
            return this;
        }

        public Builder outputConfiguration(MembershipDefaultResultConfigurationOutputConfigurationArgs outputConfiguration) {
            return outputConfiguration(Output.of(outputConfiguration));
        }

        /**
         * @param roleArn The ARN of the IAM role which will be used to create the membership.
         * - `output_configuration.s3.bucket` - (Required) - The name of the S3 bucket where the query results will be stored.
         * - `output_configuration.s3.result_format` - (Required) - The format of the query results. Valid values are `PARQUET` and `CSV`.
         * - `output_configuration.s3.key_prefix` - (Optional) - The prefix used for the query results.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(@Nullable Output<String> roleArn) {
            $.roleArn = roleArn;
            return this;
        }

        /**
         * @param roleArn The ARN of the IAM role which will be used to create the membership.
         * - `output_configuration.s3.bucket` - (Required) - The name of the S3 bucket where the query results will be stored.
         * - `output_configuration.s3.result_format` - (Required) - The format of the query results. Valid values are `PARQUET` and `CSV`.
         * - `output_configuration.s3.key_prefix` - (Optional) - The prefix used for the query results.
         * 
         * @return builder
         * 
         */
        public Builder roleArn(String roleArn) {
            return roleArn(Output.of(roleArn));
        }

        public MembershipDefaultResultConfigurationArgs build() {
            return $;
        }
    }

}
