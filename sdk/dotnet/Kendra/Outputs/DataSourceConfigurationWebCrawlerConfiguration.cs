// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kendra.Outputs
{

    [OutputType]
    public sealed class DataSourceConfigurationWebCrawlerConfiguration
    {
        /// <summary>
        /// A block with the configuration information required to connect to websites using authentication. You can connect to websites using basic authentication of user name and password. You use a secret in AWS Secrets Manager to store your authentication credentials. You must provide the website host name and port number. For example, the host name of `https://a.example.com/page1.html` is `"a.example.com"` and the port is `443`, the standard port for HTTPS. Detailed below.
        /// </summary>
        public readonly Outputs.DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfiguration? AuthenticationConfiguration;
        /// <summary>
        /// Specifies the number of levels in a website that you want to crawl. The first level begins from the website seed or starting point URL. For example, if a website has 3 levels – index level (i.e. seed in this example), sections level, and subsections level – and you are only interested in crawling information up to the sections level (i.e. levels 0-1), you can set your depth to 1. The default crawl depth is set to `2`. Minimum value of `0`. Maximum value of `10`.
        /// </summary>
        public readonly int? CrawlDepth;
        /// <summary>
        /// The maximum size (in MB) of a webpage or attachment to crawl. Files larger than this size (in MB) are skipped/not crawled. The default maximum size of a webpage or attachment is set to `50` MB. Minimum value of `1.0e-06`. Maximum value of `50`.
        /// </summary>
        public readonly double? MaxContentSizePerPageInMegaBytes;
        /// <summary>
        /// The maximum number of URLs on a webpage to include when crawling a website. This number is per webpage. As a website’s webpages are crawled, any URLs the webpages link to are also crawled. URLs on a webpage are crawled in order of appearance. The default maximum links per page is `100`. Minimum value of `1`. Maximum value of `1000`.
        /// </summary>
        public readonly int? MaxLinksPerPage;
        /// <summary>
        /// The maximum number of URLs crawled per website host per minute. The default maximum number of URLs crawled per website host per minute is `300`. Minimum value of `1`. Maximum value of `300`.
        /// </summary>
        public readonly int? MaxUrlsPerMinuteCrawlRate;
        /// <summary>
        /// Configuration information required to connect to your internal websites via a web proxy. You must provide the website host name and port number. For example, the host name of `https://a.example.com/page1.html` is `"a.example.com"` and the port is `443`, the standard port for HTTPS. Web proxy credentials are optional and you can use them to connect to a web proxy server that requires basic authentication. To store web proxy credentials, you use a secret in [AWS Secrets Manager](https://docs.aws.amazon.com/secretsmanager/latest/userguide/intro.html). Detailed below.
        /// </summary>
        public readonly Outputs.DataSourceConfigurationWebCrawlerConfigurationProxyConfiguration? ProxyConfiguration;
        /// <summary>
        /// A list of regular expression patterns to exclude certain URLs to crawl. URLs that match the patterns are excluded from the index. URLs that don't match the patterns are included in the index. If a URL matches both an inclusion and exclusion pattern, the exclusion pattern takes precedence and the URL file isn't included in the index. Array Members: Minimum number of `0` items. Maximum number of `100` items. Length Constraints: Minimum length of `1`. Maximum length of `150`.
        /// </summary>
        public readonly ImmutableArray<string> UrlExclusionPatterns;
        /// <summary>
        /// A list of regular expression patterns to include certain URLs to crawl. URLs that match the patterns are included in the index. URLs that don't match the patterns are excluded from the index. If a URL matches both an inclusion and exclusion pattern, the exclusion pattern takes precedence and the URL file isn't included in the index. Array Members: Minimum number of `0` items. Maximum number of `100` items. Length Constraints: Minimum length of `1`. Maximum length of `150`.
        /// </summary>
        public readonly ImmutableArray<string> UrlInclusionPatterns;
        /// <summary>
        /// A block that specifies the seed or starting point URLs of the websites or the sitemap URLs of the websites you want to crawl. You can include website subdomains. You can list up to `100` seed URLs and up to `3` sitemap URLs. You can only crawl websites that use the secure communication protocol, Hypertext Transfer Protocol Secure (HTTPS). If you receive an error when crawling a website, it could be that the website is blocked from crawling. When selecting websites to index, you must adhere to the [Amazon Acceptable Use Policy](https://aws.amazon.com/aup/) and all other Amazon terms. Remember that you must only use Amazon Kendra Web Crawler to index your own webpages, or webpages that you have authorization to index. Detailed below.
        /// </summary>
        public readonly Outputs.DataSourceConfigurationWebCrawlerConfigurationUrls Urls;

        [OutputConstructor]
        private DataSourceConfigurationWebCrawlerConfiguration(
            Outputs.DataSourceConfigurationWebCrawlerConfigurationAuthenticationConfiguration? authenticationConfiguration,

            int? crawlDepth,

            double? maxContentSizePerPageInMegaBytes,

            int? maxLinksPerPage,

            int? maxUrlsPerMinuteCrawlRate,

            Outputs.DataSourceConfigurationWebCrawlerConfigurationProxyConfiguration? proxyConfiguration,

            ImmutableArray<string> urlExclusionPatterns,

            ImmutableArray<string> urlInclusionPatterns,

            Outputs.DataSourceConfigurationWebCrawlerConfigurationUrls urls)
        {
            AuthenticationConfiguration = authenticationConfiguration;
            CrawlDepth = crawlDepth;
            MaxContentSizePerPageInMegaBytes = maxContentSizePerPageInMegaBytes;
            MaxLinksPerPage = maxLinksPerPage;
            MaxUrlsPerMinuteCrawlRate = maxUrlsPerMinuteCrawlRate;
            ProxyConfiguration = proxyConfiguration;
            UrlExclusionPatterns = urlExclusionPatterns;
            UrlInclusionPatterns = urlInclusionPatterns;
            Urls = urls;
        }
    }
}
