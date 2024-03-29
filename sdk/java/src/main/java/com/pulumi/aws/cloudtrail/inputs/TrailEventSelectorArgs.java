// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudtrail.inputs;

import com.pulumi.aws.cloudtrail.inputs.TrailEventSelectorDataResourceArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class TrailEventSelectorArgs extends com.pulumi.resources.ResourceArgs {

    public static final TrailEventSelectorArgs Empty = new TrailEventSelectorArgs();

    /**
     * Configuration block for data events. See details below.
     * 
     */
    @Import(name="dataResources")
    private @Nullable Output<List<TrailEventSelectorDataResourceArgs>> dataResources;

    /**
     * @return Configuration block for data events. See details below.
     * 
     */
    public Optional<Output<List<TrailEventSelectorDataResourceArgs>>> dataResources() {
        return Optional.ofNullable(this.dataResources);
    }

    /**
     * A set of event sources to exclude. Valid values include: `kms.amazonaws.com` and `rdsdata.amazonaws.com`. `include_management_events` must be set to`true` to allow this.
     * 
     */
    @Import(name="excludeManagementEventSources")
    private @Nullable Output<List<String>> excludeManagementEventSources;

    /**
     * @return A set of event sources to exclude. Valid values include: `kms.amazonaws.com` and `rdsdata.amazonaws.com`. `include_management_events` must be set to`true` to allow this.
     * 
     */
    public Optional<Output<List<String>>> excludeManagementEventSources() {
        return Optional.ofNullable(this.excludeManagementEventSources);
    }

    /**
     * Whether to include management events for your trail. Defaults to `true`.
     * 
     */
    @Import(name="includeManagementEvents")
    private @Nullable Output<Boolean> includeManagementEvents;

    /**
     * @return Whether to include management events for your trail. Defaults to `true`.
     * 
     */
    public Optional<Output<Boolean>> includeManagementEvents() {
        return Optional.ofNullable(this.includeManagementEvents);
    }

    /**
     * Type of events to log. Valid values are `ReadOnly`, `WriteOnly`, `All`. Default value is `All`.
     * 
     */
    @Import(name="readWriteType")
    private @Nullable Output<String> readWriteType;

    /**
     * @return Type of events to log. Valid values are `ReadOnly`, `WriteOnly`, `All`. Default value is `All`.
     * 
     */
    public Optional<Output<String>> readWriteType() {
        return Optional.ofNullable(this.readWriteType);
    }

    private TrailEventSelectorArgs() {}

    private TrailEventSelectorArgs(TrailEventSelectorArgs $) {
        this.dataResources = $.dataResources;
        this.excludeManagementEventSources = $.excludeManagementEventSources;
        this.includeManagementEvents = $.includeManagementEvents;
        this.readWriteType = $.readWriteType;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(TrailEventSelectorArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private TrailEventSelectorArgs $;

        public Builder() {
            $ = new TrailEventSelectorArgs();
        }

        public Builder(TrailEventSelectorArgs defaults) {
            $ = new TrailEventSelectorArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param dataResources Configuration block for data events. See details below.
         * 
         * @return builder
         * 
         */
        public Builder dataResources(@Nullable Output<List<TrailEventSelectorDataResourceArgs>> dataResources) {
            $.dataResources = dataResources;
            return this;
        }

        /**
         * @param dataResources Configuration block for data events. See details below.
         * 
         * @return builder
         * 
         */
        public Builder dataResources(List<TrailEventSelectorDataResourceArgs> dataResources) {
            return dataResources(Output.of(dataResources));
        }

        /**
         * @param dataResources Configuration block for data events. See details below.
         * 
         * @return builder
         * 
         */
        public Builder dataResources(TrailEventSelectorDataResourceArgs... dataResources) {
            return dataResources(List.of(dataResources));
        }

        /**
         * @param excludeManagementEventSources A set of event sources to exclude. Valid values include: `kms.amazonaws.com` and `rdsdata.amazonaws.com`. `include_management_events` must be set to`true` to allow this.
         * 
         * @return builder
         * 
         */
        public Builder excludeManagementEventSources(@Nullable Output<List<String>> excludeManagementEventSources) {
            $.excludeManagementEventSources = excludeManagementEventSources;
            return this;
        }

        /**
         * @param excludeManagementEventSources A set of event sources to exclude. Valid values include: `kms.amazonaws.com` and `rdsdata.amazonaws.com`. `include_management_events` must be set to`true` to allow this.
         * 
         * @return builder
         * 
         */
        public Builder excludeManagementEventSources(List<String> excludeManagementEventSources) {
            return excludeManagementEventSources(Output.of(excludeManagementEventSources));
        }

        /**
         * @param excludeManagementEventSources A set of event sources to exclude. Valid values include: `kms.amazonaws.com` and `rdsdata.amazonaws.com`. `include_management_events` must be set to`true` to allow this.
         * 
         * @return builder
         * 
         */
        public Builder excludeManagementEventSources(String... excludeManagementEventSources) {
            return excludeManagementEventSources(List.of(excludeManagementEventSources));
        }

        /**
         * @param includeManagementEvents Whether to include management events for your trail. Defaults to `true`.
         * 
         * @return builder
         * 
         */
        public Builder includeManagementEvents(@Nullable Output<Boolean> includeManagementEvents) {
            $.includeManagementEvents = includeManagementEvents;
            return this;
        }

        /**
         * @param includeManagementEvents Whether to include management events for your trail. Defaults to `true`.
         * 
         * @return builder
         * 
         */
        public Builder includeManagementEvents(Boolean includeManagementEvents) {
            return includeManagementEvents(Output.of(includeManagementEvents));
        }

        /**
         * @param readWriteType Type of events to log. Valid values are `ReadOnly`, `WriteOnly`, `All`. Default value is `All`.
         * 
         * @return builder
         * 
         */
        public Builder readWriteType(@Nullable Output<String> readWriteType) {
            $.readWriteType = readWriteType;
            return this;
        }

        /**
         * @param readWriteType Type of events to log. Valid values are `ReadOnly`, `WriteOnly`, `All`. Default value is `All`.
         * 
         * @return builder
         * 
         */
        public Builder readWriteType(String readWriteType) {
            return readWriteType(Output.of(readWriteType));
        }

        public TrailEventSelectorArgs build() {
            return $;
        }
    }

}
