// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appfabric.inputs;

import com.pulumi.aws.appfabric.inputs.IngestionDestinationDestinationConfigurationAuditLogDestinationArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class IngestionDestinationDestinationConfigurationAuditLogArgs extends com.pulumi.resources.ResourceArgs {

    public static final IngestionDestinationDestinationConfigurationAuditLogArgs Empty = new IngestionDestinationDestinationConfigurationAuditLogArgs();

    /**
     * Contains information about an audit log destination. Only one destination (Firehose Stream) or (S3 Bucket) can be specified.
     * 
     */
    @Import(name="destination")
    private @Nullable Output<IngestionDestinationDestinationConfigurationAuditLogDestinationArgs> destination;

    /**
     * @return Contains information about an audit log destination. Only one destination (Firehose Stream) or (S3 Bucket) can be specified.
     * 
     */
    public Optional<Output<IngestionDestinationDestinationConfigurationAuditLogDestinationArgs>> destination() {
        return Optional.ofNullable(this.destination);
    }

    private IngestionDestinationDestinationConfigurationAuditLogArgs() {}

    private IngestionDestinationDestinationConfigurationAuditLogArgs(IngestionDestinationDestinationConfigurationAuditLogArgs $) {
        this.destination = $.destination;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(IngestionDestinationDestinationConfigurationAuditLogArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private IngestionDestinationDestinationConfigurationAuditLogArgs $;

        public Builder() {
            $ = new IngestionDestinationDestinationConfigurationAuditLogArgs();
        }

        public Builder(IngestionDestinationDestinationConfigurationAuditLogArgs defaults) {
            $ = new IngestionDestinationDestinationConfigurationAuditLogArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param destination Contains information about an audit log destination. Only one destination (Firehose Stream) or (S3 Bucket) can be specified.
         * 
         * @return builder
         * 
         */
        public Builder destination(@Nullable Output<IngestionDestinationDestinationConfigurationAuditLogDestinationArgs> destination) {
            $.destination = destination;
            return this;
        }

        /**
         * @param destination Contains information about an audit log destination. Only one destination (Firehose Stream) or (S3 Bucket) can be specified.
         * 
         * @return builder
         * 
         */
        public Builder destination(IngestionDestinationDestinationConfigurationAuditLogDestinationArgs destination) {
            return destination(Output.of(destination));
        }

        public IngestionDestinationDestinationConfigurationAuditLogArgs build() {
            return $;
        }
    }

}
