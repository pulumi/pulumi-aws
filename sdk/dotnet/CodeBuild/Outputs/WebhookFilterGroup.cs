// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeBuild.Outputs
{

    [OutputType]
    public sealed class WebhookFilterGroup
    {
        /// <summary>
        /// A webhook filter for the group. Filter blocks are documented below.
        /// </summary>
        public readonly ImmutableArray<Outputs.WebhookFilterGroupFilter> Filters;

        [OutputConstructor]
        private WebhookFilterGroup(ImmutableArray<Outputs.WebhookFilterGroupFilter> filters)
        {
            Filters = filters;
        }
    }
}
