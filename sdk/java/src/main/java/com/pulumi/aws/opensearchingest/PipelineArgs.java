// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.opensearchingest;

import com.pulumi.aws.opensearchingest.inputs.PipelineBufferOptionsArgs;
import com.pulumi.aws.opensearchingest.inputs.PipelineEncryptionAtRestOptionsArgs;
import com.pulumi.aws.opensearchingest.inputs.PipelineLogPublishingOptionsArgs;
import com.pulumi.aws.opensearchingest.inputs.PipelineTimeoutsArgs;
import com.pulumi.aws.opensearchingest.inputs.PipelineVpcOptionsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class PipelineArgs extends com.pulumi.resources.ResourceArgs {

    public static final PipelineArgs Empty = new PipelineArgs();

    /**
     * Key-value pairs to configure persistent buffering for the pipeline. See `buffer_options` below.
     * 
     */
    @Import(name="bufferOptions")
    private @Nullable Output<PipelineBufferOptionsArgs> bufferOptions;

    /**
     * @return Key-value pairs to configure persistent buffering for the pipeline. See `buffer_options` below.
     * 
     */
    public Optional<Output<PipelineBufferOptionsArgs>> bufferOptions() {
        return Optional.ofNullable(this.bufferOptions);
    }

    /**
     * Key-value pairs to configure encryption for data that is written to a persistent buffer. See `encryption_at_rest_options` below.
     * 
     */
    @Import(name="encryptionAtRestOptions")
    private @Nullable Output<PipelineEncryptionAtRestOptionsArgs> encryptionAtRestOptions;

    /**
     * @return Key-value pairs to configure encryption for data that is written to a persistent buffer. See `encryption_at_rest_options` below.
     * 
     */
    public Optional<Output<PipelineEncryptionAtRestOptionsArgs>> encryptionAtRestOptions() {
        return Optional.ofNullable(this.encryptionAtRestOptions);
    }

    /**
     * Key-value pairs to configure log publishing. See `log_publishing_options` below.
     * 
     */
    @Import(name="logPublishingOptions")
    private @Nullable Output<PipelineLogPublishingOptionsArgs> logPublishingOptions;

    /**
     * @return Key-value pairs to configure log publishing. See `log_publishing_options` below.
     * 
     */
    public Optional<Output<PipelineLogPublishingOptionsArgs>> logPublishingOptions() {
        return Optional.ofNullable(this.logPublishingOptions);
    }

    /**
     * The maximum pipeline capacity, in Ingestion Compute Units (ICUs).
     * 
     */
    @Import(name="maxUnits", required=true)
    private Output<Integer> maxUnits;

    /**
     * @return The maximum pipeline capacity, in Ingestion Compute Units (ICUs).
     * 
     */
    public Output<Integer> maxUnits() {
        return this.maxUnits;
    }

    /**
     * The minimum pipeline capacity, in Ingestion Compute Units (ICUs).
     * 
     */
    @Import(name="minUnits", required=true)
    private Output<Integer> minUnits;

    /**
     * @return The minimum pipeline capacity, in Ingestion Compute Units (ICUs).
     * 
     */
    public Output<Integer> minUnits() {
        return this.minUnits;
    }

    /**
     * The pipeline configuration in YAML format. This argument accepts the pipeline configuration as a string or within a .yaml file. If you provide the configuration as a string, each new line must be escaped with \n.
     * 
     */
    @Import(name="pipelineConfigurationBody", required=true)
    private Output<String> pipelineConfigurationBody;

    /**
     * @return The pipeline configuration in YAML format. This argument accepts the pipeline configuration as a string or within a .yaml file. If you provide the configuration as a string, each new line must be escaped with \n.
     * 
     */
    public Output<String> pipelineConfigurationBody() {
        return this.pipelineConfigurationBody;
    }

    /**
     * The name of the OpenSearch Ingestion pipeline to create. Pipeline names are unique across the pipelines owned by an account within an AWS Region.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="pipelineName", required=true)
    private Output<String> pipelineName;

    /**
     * @return The name of the OpenSearch Ingestion pipeline to create. Pipeline names are unique across the pipelines owned by an account within an AWS Region.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> pipelineName() {
        return this.pipelineName;
    }

    /**
     * A map of tags to assign to the pipeline. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Import(name="tags")
    private @Nullable Output<Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the pipeline. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Optional<Output<Map<String,String>>> tags() {
        return Optional.ofNullable(this.tags);
    }

    @Import(name="timeouts")
    private @Nullable Output<PipelineTimeoutsArgs> timeouts;

    public Optional<Output<PipelineTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * Container for the values required to configure VPC access for the pipeline. If you don&#39;t specify these values, OpenSearch Ingestion creates the pipeline with a public endpoint. See `vpc_options` below.
     * 
     */
    @Import(name="vpcOptions")
    private @Nullable Output<PipelineVpcOptionsArgs> vpcOptions;

    /**
     * @return Container for the values required to configure VPC access for the pipeline. If you don&#39;t specify these values, OpenSearch Ingestion creates the pipeline with a public endpoint. See `vpc_options` below.
     * 
     */
    public Optional<Output<PipelineVpcOptionsArgs>> vpcOptions() {
        return Optional.ofNullable(this.vpcOptions);
    }

    private PipelineArgs() {}

    private PipelineArgs(PipelineArgs $) {
        this.bufferOptions = $.bufferOptions;
        this.encryptionAtRestOptions = $.encryptionAtRestOptions;
        this.logPublishingOptions = $.logPublishingOptions;
        this.maxUnits = $.maxUnits;
        this.minUnits = $.minUnits;
        this.pipelineConfigurationBody = $.pipelineConfigurationBody;
        this.pipelineName = $.pipelineName;
        this.tags = $.tags;
        this.timeouts = $.timeouts;
        this.vpcOptions = $.vpcOptions;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PipelineArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PipelineArgs $;

        public Builder() {
            $ = new PipelineArgs();
        }

        public Builder(PipelineArgs defaults) {
            $ = new PipelineArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param bufferOptions Key-value pairs to configure persistent buffering for the pipeline. See `buffer_options` below.
         * 
         * @return builder
         * 
         */
        public Builder bufferOptions(@Nullable Output<PipelineBufferOptionsArgs> bufferOptions) {
            $.bufferOptions = bufferOptions;
            return this;
        }

        /**
         * @param bufferOptions Key-value pairs to configure persistent buffering for the pipeline. See `buffer_options` below.
         * 
         * @return builder
         * 
         */
        public Builder bufferOptions(PipelineBufferOptionsArgs bufferOptions) {
            return bufferOptions(Output.of(bufferOptions));
        }

        /**
         * @param encryptionAtRestOptions Key-value pairs to configure encryption for data that is written to a persistent buffer. See `encryption_at_rest_options` below.
         * 
         * @return builder
         * 
         */
        public Builder encryptionAtRestOptions(@Nullable Output<PipelineEncryptionAtRestOptionsArgs> encryptionAtRestOptions) {
            $.encryptionAtRestOptions = encryptionAtRestOptions;
            return this;
        }

        /**
         * @param encryptionAtRestOptions Key-value pairs to configure encryption for data that is written to a persistent buffer. See `encryption_at_rest_options` below.
         * 
         * @return builder
         * 
         */
        public Builder encryptionAtRestOptions(PipelineEncryptionAtRestOptionsArgs encryptionAtRestOptions) {
            return encryptionAtRestOptions(Output.of(encryptionAtRestOptions));
        }

        /**
         * @param logPublishingOptions Key-value pairs to configure log publishing. See `log_publishing_options` below.
         * 
         * @return builder
         * 
         */
        public Builder logPublishingOptions(@Nullable Output<PipelineLogPublishingOptionsArgs> logPublishingOptions) {
            $.logPublishingOptions = logPublishingOptions;
            return this;
        }

        /**
         * @param logPublishingOptions Key-value pairs to configure log publishing. See `log_publishing_options` below.
         * 
         * @return builder
         * 
         */
        public Builder logPublishingOptions(PipelineLogPublishingOptionsArgs logPublishingOptions) {
            return logPublishingOptions(Output.of(logPublishingOptions));
        }

        /**
         * @param maxUnits The maximum pipeline capacity, in Ingestion Compute Units (ICUs).
         * 
         * @return builder
         * 
         */
        public Builder maxUnits(Output<Integer> maxUnits) {
            $.maxUnits = maxUnits;
            return this;
        }

        /**
         * @param maxUnits The maximum pipeline capacity, in Ingestion Compute Units (ICUs).
         * 
         * @return builder
         * 
         */
        public Builder maxUnits(Integer maxUnits) {
            return maxUnits(Output.of(maxUnits));
        }

        /**
         * @param minUnits The minimum pipeline capacity, in Ingestion Compute Units (ICUs).
         * 
         * @return builder
         * 
         */
        public Builder minUnits(Output<Integer> minUnits) {
            $.minUnits = minUnits;
            return this;
        }

        /**
         * @param minUnits The minimum pipeline capacity, in Ingestion Compute Units (ICUs).
         * 
         * @return builder
         * 
         */
        public Builder minUnits(Integer minUnits) {
            return minUnits(Output.of(minUnits));
        }

        /**
         * @param pipelineConfigurationBody The pipeline configuration in YAML format. This argument accepts the pipeline configuration as a string or within a .yaml file. If you provide the configuration as a string, each new line must be escaped with \n.
         * 
         * @return builder
         * 
         */
        public Builder pipelineConfigurationBody(Output<String> pipelineConfigurationBody) {
            $.pipelineConfigurationBody = pipelineConfigurationBody;
            return this;
        }

        /**
         * @param pipelineConfigurationBody The pipeline configuration in YAML format. This argument accepts the pipeline configuration as a string or within a .yaml file. If you provide the configuration as a string, each new line must be escaped with \n.
         * 
         * @return builder
         * 
         */
        public Builder pipelineConfigurationBody(String pipelineConfigurationBody) {
            return pipelineConfigurationBody(Output.of(pipelineConfigurationBody));
        }

        /**
         * @param pipelineName The name of the OpenSearch Ingestion pipeline to create. Pipeline names are unique across the pipelines owned by an account within an AWS Region.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder pipelineName(Output<String> pipelineName) {
            $.pipelineName = pipelineName;
            return this;
        }

        /**
         * @param pipelineName The name of the OpenSearch Ingestion pipeline to create. Pipeline names are unique across the pipelines owned by an account within an AWS Region.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder pipelineName(String pipelineName) {
            return pipelineName(Output.of(pipelineName));
        }

        /**
         * @param tags A map of tags to assign to the pipeline. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(@Nullable Output<Map<String,String>> tags) {
            $.tags = tags;
            return this;
        }

        /**
         * @param tags A map of tags to assign to the pipeline. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
         * 
         * @return builder
         * 
         */
        public Builder tags(Map<String,String> tags) {
            return tags(Output.of(tags));
        }

        public Builder timeouts(@Nullable Output<PipelineTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(PipelineTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param vpcOptions Container for the values required to configure VPC access for the pipeline. If you don&#39;t specify these values, OpenSearch Ingestion creates the pipeline with a public endpoint. See `vpc_options` below.
         * 
         * @return builder
         * 
         */
        public Builder vpcOptions(@Nullable Output<PipelineVpcOptionsArgs> vpcOptions) {
            $.vpcOptions = vpcOptions;
            return this;
        }

        /**
         * @param vpcOptions Container for the values required to configure VPC access for the pipeline. If you don&#39;t specify these values, OpenSearch Ingestion creates the pipeline with a public endpoint. See `vpc_options` below.
         * 
         * @return builder
         * 
         */
        public Builder vpcOptions(PipelineVpcOptionsArgs vpcOptions) {
            return vpcOptions(Output.of(vpcOptions));
        }

        public PipelineArgs build() {
            if ($.maxUnits == null) {
                throw new MissingRequiredPropertyException("PipelineArgs", "maxUnits");
            }
            if ($.minUnits == null) {
                throw new MissingRequiredPropertyException("PipelineArgs", "minUnits");
            }
            if ($.pipelineConfigurationBody == null) {
                throw new MissingRequiredPropertyException("PipelineArgs", "pipelineConfigurationBody");
            }
            if ($.pipelineName == null) {
                throw new MissingRequiredPropertyException("PipelineArgs", "pipelineName");
            }
            return $;
        }
    }

}
