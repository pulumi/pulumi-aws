// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53;

import com.pulumi.aws.route53.inputs.RecordsExclusiveResourceRecordSetArgs;
import com.pulumi.aws.route53.inputs.RecordsExclusiveTimeoutsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class RecordsExclusiveArgs extends com.pulumi.resources.ResourceArgs {

    public static final RecordsExclusiveArgs Empty = new RecordsExclusiveArgs();

    /**
     * A list of all resource record sets associated with the hosted zone.
     * See `resource_record_set` below.
     * 
     */
    @Import(name="resourceRecordSets")
    private @Nullable Output<List<RecordsExclusiveResourceRecordSetArgs>> resourceRecordSets;

    /**
     * @return A list of all resource record sets associated with the hosted zone.
     * See `resource_record_set` below.
     * 
     */
    public Optional<Output<List<RecordsExclusiveResourceRecordSetArgs>>> resourceRecordSets() {
        return Optional.ofNullable(this.resourceRecordSets);
    }

    @Import(name="timeouts")
    private @Nullable Output<RecordsExclusiveTimeoutsArgs> timeouts;

    public Optional<Output<RecordsExclusiveTimeoutsArgs>> timeouts() {
        return Optional.ofNullable(this.timeouts);
    }

    /**
     * ID of the hosted zone containing the resource record sets.
     * 
     * The following arguments are optional:
     * 
     */
    @Import(name="zoneId", required=true)
    private Output<String> zoneId;

    /**
     * @return ID of the hosted zone containing the resource record sets.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> zoneId() {
        return this.zoneId;
    }

    private RecordsExclusiveArgs() {}

    private RecordsExclusiveArgs(RecordsExclusiveArgs $) {
        this.resourceRecordSets = $.resourceRecordSets;
        this.timeouts = $.timeouts;
        this.zoneId = $.zoneId;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(RecordsExclusiveArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private RecordsExclusiveArgs $;

        public Builder() {
            $ = new RecordsExclusiveArgs();
        }

        public Builder(RecordsExclusiveArgs defaults) {
            $ = new RecordsExclusiveArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param resourceRecordSets A list of all resource record sets associated with the hosted zone.
         * See `resource_record_set` below.
         * 
         * @return builder
         * 
         */
        public Builder resourceRecordSets(@Nullable Output<List<RecordsExclusiveResourceRecordSetArgs>> resourceRecordSets) {
            $.resourceRecordSets = resourceRecordSets;
            return this;
        }

        /**
         * @param resourceRecordSets A list of all resource record sets associated with the hosted zone.
         * See `resource_record_set` below.
         * 
         * @return builder
         * 
         */
        public Builder resourceRecordSets(List<RecordsExclusiveResourceRecordSetArgs> resourceRecordSets) {
            return resourceRecordSets(Output.of(resourceRecordSets));
        }

        /**
         * @param resourceRecordSets A list of all resource record sets associated with the hosted zone.
         * See `resource_record_set` below.
         * 
         * @return builder
         * 
         */
        public Builder resourceRecordSets(RecordsExclusiveResourceRecordSetArgs... resourceRecordSets) {
            return resourceRecordSets(List.of(resourceRecordSets));
        }

        public Builder timeouts(@Nullable Output<RecordsExclusiveTimeoutsArgs> timeouts) {
            $.timeouts = timeouts;
            return this;
        }

        public Builder timeouts(RecordsExclusiveTimeoutsArgs timeouts) {
            return timeouts(Output.of(timeouts));
        }

        /**
         * @param zoneId ID of the hosted zone containing the resource record sets.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder zoneId(Output<String> zoneId) {
            $.zoneId = zoneId;
            return this;
        }

        /**
         * @param zoneId ID of the hosted zone containing the resource record sets.
         * 
         * The following arguments are optional:
         * 
         * @return builder
         * 
         */
        public Builder zoneId(String zoneId) {
            return zoneId(Output.of(zoneId));
        }

        public RecordsExclusiveArgs build() {
            if ($.zoneId == null) {
                throw new MissingRequiredPropertyException("RecordsExclusiveArgs", "zoneId");
            }
            return $;
        }
    }

}
