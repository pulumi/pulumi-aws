// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationSeedUrl;
import com.pulumi.core.annotations.CustomType;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfiguration {
    /**
     * @return List of one or more seed URLs to crawl. See `seed_urls` block for details.
     * 
     */
    private @Nullable List<AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationSeedUrl> seedUrls;

    private AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfiguration() {}
    /**
     * @return List of one or more seed URLs to crawl. See `seed_urls` block for details.
     * 
     */
    public List<AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationSeedUrl> seedUrls() {
        return this.seedUrls == null ? List.of() : this.seedUrls;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationSeedUrl> seedUrls;
        public Builder() {}
        public Builder(AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.seedUrls = defaults.seedUrls;
        }

        @CustomType.Setter
        public Builder seedUrls(@Nullable List<AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationSeedUrl> seedUrls) {

            this.seedUrls = seedUrls;
            return this;
        }
        public Builder seedUrls(AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationSeedUrl... seedUrls) {
            return seedUrls(List.of(seedUrls));
        }
        public AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfiguration build() {
            final var _resultValue = new AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfiguration();
            _resultValue.seedUrls = seedUrls;
            return _resultValue;
        }
    }
}
