// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Outputs
{

    [OutputType]
    public sealed class WebAclLoggingConfigurationLoggingFilter
    {
        /// <summary>
        /// Default handling for logs that don't match any of the specified filtering conditions. Valid values for `default_behavior` are `KEEP` or `DROP`.
        /// </summary>
        public readonly string DefaultBehavior;
        /// <summary>
        /// Filter(s) that you want to apply to the logs. See Filter below for more details.
        /// </summary>
        public readonly ImmutableArray<Outputs.WebAclLoggingConfigurationLoggingFilterFilter> Filters;

        [OutputConstructor]
        private WebAclLoggingConfigurationLoggingFilter(
            string defaultBehavior,

            ImmutableArray<Outputs.WebAclLoggingConfigurationLoggingFilterFilter> filters)
        {
            DefaultBehavior = defaultBehavior;
            Filters = filters;
        }
    }
}
