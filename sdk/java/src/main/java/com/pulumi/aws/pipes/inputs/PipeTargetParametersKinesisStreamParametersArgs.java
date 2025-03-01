// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pipes.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class PipeTargetParametersKinesisStreamParametersArgs extends com.pulumi.resources.ResourceArgs {

    public static final PipeTargetParametersKinesisStreamParametersArgs Empty = new PipeTargetParametersKinesisStreamParametersArgs();

    /**
     * Determines which shard in the stream the data record is assigned to. Partition keys are Unicode strings with a maximum length limit of 256 characters for each key. Amazon Kinesis Data Streams uses the partition key as input to a hash function that maps the partition key and associated data to a specific shard. Specifically, an MD5 hash function is used to map partition keys to 128-bit integer values and to map associated data records to shards. As a result of this hashing mechanism, all data records with the same partition key map to the same shard within the stream.
     * 
     */
    @Import(name="partitionKey", required=true)
    private Output<String> partitionKey;

    /**
     * @return Determines which shard in the stream the data record is assigned to. Partition keys are Unicode strings with a maximum length limit of 256 characters for each key. Amazon Kinesis Data Streams uses the partition key as input to a hash function that maps the partition key and associated data to a specific shard. Specifically, an MD5 hash function is used to map partition keys to 128-bit integer values and to map associated data records to shards. As a result of this hashing mechanism, all data records with the same partition key map to the same shard within the stream.
     * 
     */
    public Output<String> partitionKey() {
        return this.partitionKey;
    }

    private PipeTargetParametersKinesisStreamParametersArgs() {}

    private PipeTargetParametersKinesisStreamParametersArgs(PipeTargetParametersKinesisStreamParametersArgs $) {
        this.partitionKey = $.partitionKey;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(PipeTargetParametersKinesisStreamParametersArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private PipeTargetParametersKinesisStreamParametersArgs $;

        public Builder() {
            $ = new PipeTargetParametersKinesisStreamParametersArgs();
        }

        public Builder(PipeTargetParametersKinesisStreamParametersArgs defaults) {
            $ = new PipeTargetParametersKinesisStreamParametersArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param partitionKey Determines which shard in the stream the data record is assigned to. Partition keys are Unicode strings with a maximum length limit of 256 characters for each key. Amazon Kinesis Data Streams uses the partition key as input to a hash function that maps the partition key and associated data to a specific shard. Specifically, an MD5 hash function is used to map partition keys to 128-bit integer values and to map associated data records to shards. As a result of this hashing mechanism, all data records with the same partition key map to the same shard within the stream.
         * 
         * @return builder
         * 
         */
        public Builder partitionKey(Output<String> partitionKey) {
            $.partitionKey = partitionKey;
            return this;
        }

        /**
         * @param partitionKey Determines which shard in the stream the data record is assigned to. Partition keys are Unicode strings with a maximum length limit of 256 characters for each key. Amazon Kinesis Data Streams uses the partition key as input to a hash function that maps the partition key and associated data to a specific shard. Specifically, an MD5 hash function is used to map partition keys to 128-bit integer values and to map associated data records to shards. As a result of this hashing mechanism, all data records with the same partition key map to the same shard within the stream.
         * 
         * @return builder
         * 
         */
        public Builder partitionKey(String partitionKey) {
            return partitionKey(Output.of(partitionKey));
        }

        public PipeTargetParametersKinesisStreamParametersArgs build() {
            if ($.partitionKey == null) {
                throw new MissingRequiredPropertyException("PipeTargetParametersKinesisStreamParametersArgs", "partitionKey");
            }
            return $;
        }
    }

}
