// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.inputs;

import com.pulumi.aws.bedrock.inputs.AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilterArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs extends com.pulumi.resources.ResourceArgs {

    public static final AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs Empty = new AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs();

    /**
     * The configuration of specific filters applied to your data source content. Minimum of 1 filter and maximum of 25 filters.
     * 
     * Each filter object should contain the following configuration:
     * 
     */
    @Import(name="filters")
    private @Nullable Output<List<AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilterArgs>> filters;

    /**
     * @return The configuration of specific filters applied to your data source content. Minimum of 1 filter and maximum of 25 filters.
     * 
     * Each filter object should contain the following configuration:
     * 
     */
    public Optional<Output<List<AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilterArgs>>> filters() {
        return Optional.ofNullable(this.filters);
    }

    private AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs() {}

    private AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs(AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs $) {
        this.filters = $.filters;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs $;

        public Builder() {
            $ = new AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs();
        }

        public Builder(AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs defaults) {
            $ = new AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param filters The configuration of specific filters applied to your data source content. Minimum of 1 filter and maximum of 25 filters.
         * 
         * Each filter object should contain the following configuration:
         * 
         * @return builder
         * 
         */
        public Builder filters(@Nullable Output<List<AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilterArgs>> filters) {
            $.filters = filters;
            return this;
        }

        /**
         * @param filters The configuration of specific filters applied to your data source content. Minimum of 1 filter and maximum of 25 filters.
         * 
         * Each filter object should contain the following configuration:
         * 
         * @return builder
         * 
         */
        public Builder filters(List<AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilterArgs> filters) {
            return filters(Output.of(filters));
        }

        /**
         * @param filters The configuration of specific filters applied to your data source content. Minimum of 1 filter and maximum of 25 filters.
         * 
         * Each filter object should contain the following configuration:
         * 
         * @return builder
         * 
         */
        public Builder filters(AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterFilterArgs... filters) {
            return filters(List.of(filters));
        }

        public AgentDataSourceDataSourceConfigurationConfluenceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilterArgs build() {
            return $;
        }
    }

}
