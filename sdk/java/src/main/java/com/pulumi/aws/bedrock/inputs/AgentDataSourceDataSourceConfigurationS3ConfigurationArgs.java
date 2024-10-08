// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AgentDataSourceDataSourceConfigurationS3ConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentDataSourceDataSourceConfigurationS3ConfigurationArgs Empty = new AgentDataSourceDataSourceConfigurationS3ConfigurationArgs();

    /**
     * ARN of the bucket that contains the data source.
     * 
     */
    @Import(name="bucketArn", required=true)
    private Output<String> bucketArn;

    /**
     * @return ARN of the bucket that contains the data source.
     * 
     */
    public Output<String> bucketArn() {
        return this.bucketArn;
    }

    /**
     * Bucket account owner ID for the S3 bucket.
     * 
     */
    @Import(name="bucketOwnerAccountId")
    private @Nullable Output<String> bucketOwnerAccountId;

    /**
     * @return Bucket account owner ID for the S3 bucket.
     * 
     */
    public Optional<Output<String>> bucketOwnerAccountId() {
        return Optional.ofNullable(this.bucketOwnerAccountId);
    }

    /**
     * List of S3 prefixes that define the object containing the data sources. For more information, see [Organizing objects using prefixes](https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-prefixes.html).
     * 
     */
    @Import(name="inclusionPrefixes")
    private @Nullable Output<List<String>> inclusionPrefixes;

    /**
     * @return List of S3 prefixes that define the object containing the data sources. For more information, see [Organizing objects using prefixes](https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-prefixes.html).
     * 
     */
    public Optional<Output<List<String>>> inclusionPrefixes() {
        return Optional.ofNullable(this.inclusionPrefixes);
    }

    private AgentDataSourceDataSourceConfigurationS3ConfigurationArgs() {}

    private AgentDataSourceDataSourceConfigurationS3ConfigurationArgs(AgentDataSourceDataSourceConfigurationS3ConfigurationArgs $) {
        this.bucketArn = $.bucketArn;
        this.bucketOwnerAccountId = $.bucketOwnerAccountId;
        this.inclusionPrefixes = $.inclusionPrefixes;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentDataSourceDataSourceConfigurationS3ConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentDataSourceDataSourceConfigurationS3ConfigurationArgs $;

        public Builder() {
            $ = new AgentDataSourceDataSourceConfigurationS3ConfigurationArgs();
        }

        public Builder(AgentDataSourceDataSourceConfigurationS3ConfigurationArgs defaults) {
            $ = new AgentDataSourceDataSourceConfigurationS3ConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param bucketArn ARN of the bucket that contains the data source.
         * 
         * @return builder
         * 
         */
        public Builder bucketArn(Output<String> bucketArn) {
            $.bucketArn = bucketArn;
            return this;
        }

        /**
         * @param bucketArn ARN of the bucket that contains the data source.
         * 
         * @return builder
         * 
         */
        public Builder bucketArn(String bucketArn) {
            return bucketArn(Output.of(bucketArn));
        }

        /**
         * @param bucketOwnerAccountId Bucket account owner ID for the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder bucketOwnerAccountId(@Nullable Output<String> bucketOwnerAccountId) {
            $.bucketOwnerAccountId = bucketOwnerAccountId;
            return this;
        }

        /**
         * @param bucketOwnerAccountId Bucket account owner ID for the S3 bucket.
         * 
         * @return builder
         * 
         */
        public Builder bucketOwnerAccountId(String bucketOwnerAccountId) {
            return bucketOwnerAccountId(Output.of(bucketOwnerAccountId));
        }

        /**
         * @param inclusionPrefixes List of S3 prefixes that define the object containing the data sources. For more information, see [Organizing objects using prefixes](https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-prefixes.html).
         * 
         * @return builder
         * 
         */
        public Builder inclusionPrefixes(@Nullable Output<List<String>> inclusionPrefixes) {
            $.inclusionPrefixes = inclusionPrefixes;
            return this;
        }

        /**
         * @param inclusionPrefixes List of S3 prefixes that define the object containing the data sources. For more information, see [Organizing objects using prefixes](https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-prefixes.html).
         * 
         * @return builder
         * 
         */
        public Builder inclusionPrefixes(List<String> inclusionPrefixes) {
            return inclusionPrefixes(Output.of(inclusionPrefixes));
        }

        /**
         * @param inclusionPrefixes List of S3 prefixes that define the object containing the data sources. For more information, see [Organizing objects using prefixes](https://docs.aws.amazon.com/AmazonS3/latest/userguide/using-prefixes.html).
         * 
         * @return builder
         * 
         */
        public Builder inclusionPrefixes(String... inclusionPrefixes) {
            return inclusionPrefixes(List.of(inclusionPrefixes));
        }

        public AgentDataSourceDataSourceConfigurationS3ConfigurationArgs build() {
            if ($.bucketArn == null) {
                throw new MissingRequiredPropertyException("AgentDataSourceDataSourceConfigurationS3ConfigurationArgs", "bucketArn");
            }
            return $;
        }
    }

}
