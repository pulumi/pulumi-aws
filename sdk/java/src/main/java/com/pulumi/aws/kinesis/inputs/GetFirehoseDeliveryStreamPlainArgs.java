// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.kinesis.inputs;

import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;


public final class GetFirehoseDeliveryStreamPlainArgs extends com.pulumi.resources.InvokeArgs {

    public static final GetFirehoseDeliveryStreamPlainArgs Empty = new GetFirehoseDeliveryStreamPlainArgs();

    /**
     * Name of the Kinesis Firehose Delivery Stream.
     * 
     */
    @Import(name="name", required=true)
    private String name;

    /**
     * @return Name of the Kinesis Firehose Delivery Stream.
     * 
     */
    public String name() {
        return this.name;
    }

    private GetFirehoseDeliveryStreamPlainArgs() {}

    private GetFirehoseDeliveryStreamPlainArgs(GetFirehoseDeliveryStreamPlainArgs $) {
        this.name = $.name;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(GetFirehoseDeliveryStreamPlainArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private GetFirehoseDeliveryStreamPlainArgs $;

        public Builder() {
            $ = new GetFirehoseDeliveryStreamPlainArgs();
        }

        public Builder(GetFirehoseDeliveryStreamPlainArgs defaults) {
            $ = new GetFirehoseDeliveryStreamPlainArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param name Name of the Kinesis Firehose Delivery Stream.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            $.name = name;
            return this;
        }

        public GetFirehoseDeliveryStreamPlainArgs build() {
            if ($.name == null) {
                throw new MissingRequiredPropertyException("GetFirehoseDeliveryStreamPlainArgs", "name");
            }
            return $;
        }
    }

}
