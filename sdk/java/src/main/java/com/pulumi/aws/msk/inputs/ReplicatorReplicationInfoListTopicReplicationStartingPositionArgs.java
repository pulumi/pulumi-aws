// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.msk.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs extends com.pulumi.resources.ResourceArgs {

    public static final ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs Empty = new ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs();

    /**
     * The type of replication starting position. Supports `LATEST` and `EARLIEST`.
     * 
     */
    @Import(name="type")
    private @Nullable Output<String> type;

    /**
     * @return The type of replication starting position. Supports `LATEST` and `EARLIEST`.
     * 
     */
    public Optional<Output<String>> type() {
        return Optional.ofNullable(this.type);
    }

    private ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs() {}

    private ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs(ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs $) {
        this.type = $.type;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs $;

        public Builder() {
            $ = new ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs();
        }

        public Builder(ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs defaults) {
            $ = new ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param type The type of replication starting position. Supports `LATEST` and `EARLIEST`.
         * 
         * @return builder
         * 
         */
        public Builder type(@Nullable Output<String> type) {
            $.type = type;
            return this;
        }

        /**
         * @param type The type of replication starting position. Supports `LATEST` and `EARLIEST`.
         * 
         * @return builder
         * 
         */
        public Builder type(String type) {
            return type(Output.of(type));
        }

        public ReplicatorReplicationInfoListTopicReplicationStartingPositionArgs build() {
            return $;
        }
    }

}
