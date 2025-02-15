// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.aws.bedrock.inputs.AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageS3LocationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs Empty = new AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs();

    /**
     * Configuration block for intermedia S3 storage.
     * 
     */
    @Import(name="s3Location")
    private @Nullable Output<AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageS3LocationArgs> s3Location;

    /**
     * @return Configuration block for intermedia S3 storage.
     * 
     */
    public Optional<Output<AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageS3LocationArgs>> s3Location() {
        return Optional.ofNullable(this.s3Location);
    }

    private AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs() {}

    private AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs(AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs $) {
        this.s3Location = $.s3Location;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs $;

        public Builder() {
            $ = new AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs();
        }

        public Builder(AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs defaults) {
            $ = new AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param s3Location Configuration block for intermedia S3 storage.
         * 
         * @return builder
         * 
         */
        public Builder s3Location(@Nullable Output<AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageS3LocationArgs> s3Location) {
            $.s3Location = s3Location;
            return this;
        }

        /**
         * @param s3Location Configuration block for intermedia S3 storage.
         * 
         * @return builder
         * 
         */
        public Builder s3Location(AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageS3LocationArgs s3Location) {
            return s3Location(Output.of(s3Location));
        }

        public AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationIntermediateStorageArgs build() {
            return $;
        }
    }

}
