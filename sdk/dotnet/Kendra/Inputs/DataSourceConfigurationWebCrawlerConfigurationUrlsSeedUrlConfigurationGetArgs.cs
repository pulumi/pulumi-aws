// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kendra.Inputs
{

    public sealed class DataSourceConfigurationWebCrawlerConfigurationUrlsSeedUrlConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("seedUrls", required: true)]
        private InputList<string>? _seedUrls;

        /// <summary>
        /// The list of seed or starting point URLs of the websites you want to crawl. The list can include a maximum of `100` seed URLs. Array Members: Minimum number of `0` items. Maximum number of `100` items. Length Constraints: Minimum length of `1`. Maximum length of `2048`.
        /// </summary>
        public InputList<string> SeedUrls
        {
            get => _seedUrls ?? (_seedUrls = new InputList<string>());
            set => _seedUrls = value;
        }

        /// <summary>
        /// The default mode is set to `HOST_ONLY`. You can choose one of the following modes:
        /// * `HOST_ONLY` – crawl only the website host names. For example, if the seed URL is `"abc.example.com"`, then only URLs with host name `"abc.example.com"` are crawled.
        /// * `SUBDOMAINS` – crawl the website host names with subdomains. For example, if the seed URL is `"abc.example.com"`, then `"a.abc.example.com"` and `"b.abc.example.com"` are also crawled.
        /// * `EVERYTHING` – crawl the website host names with subdomains and other domains that the webpages link to.
        /// </summary>
        [Input("webCrawlerMode")]
        public Input<string>? WebCrawlerMode { get; set; }

        public DataSourceConfigurationWebCrawlerConfigurationUrlsSeedUrlConfigurationGetArgs()
        {
        }
        public static new DataSourceConfigurationWebCrawlerConfigurationUrlsSeedUrlConfigurationGetArgs Empty => new DataSourceConfigurationWebCrawlerConfigurationUrlsSeedUrlConfigurationGetArgs();
    }
}
