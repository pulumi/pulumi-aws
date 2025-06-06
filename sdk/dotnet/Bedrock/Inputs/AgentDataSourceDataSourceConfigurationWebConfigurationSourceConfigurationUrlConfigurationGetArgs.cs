// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("seedUrls")]
        private InputList<Inputs.AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationSeedUrlGetArgs>? _seedUrls;

        /// <summary>
        /// List of one or more seed URLs to crawl. See `seed_urls` block for details.
        /// </summary>
        public InputList<Inputs.AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationSeedUrlGetArgs> SeedUrls
        {
            get => _seedUrls ?? (_seedUrls = new InputList<Inputs.AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationSeedUrlGetArgs>());
            set => _seedUrls = value;
        }

        public AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationGetArgs()
        {
        }
        public static new AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationGetArgs Empty => new AgentDataSourceDataSourceConfigurationWebConfigurationSourceConfigurationUrlConfigurationGetArgs();
    }
}
