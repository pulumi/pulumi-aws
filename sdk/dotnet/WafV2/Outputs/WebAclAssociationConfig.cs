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
    public sealed class WebAclAssociationConfig
    {
        /// <summary>
        /// Customizes the request body that your protected resource forward to AWS WAF for inspection. See `request_body` below for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.WebAclAssociationConfigRequestBody> RequestBodies;

        [OutputConstructor]
        private WebAclAssociationConfig(ImmutableArray<Outputs.WebAclAssociationConfigRequestBody> requestBodies)
        {
            RequestBodies = requestBodies;
        }
    }
}
