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
    public sealed class GetExperienceEndpointResult
    {
        /// <summary>
        /// Endpoint of your Amazon Kendra Experience.
        /// </summary>
        public readonly string Endpoint;
        /// <summary>
        /// Type of endpoint for your Amazon Kendra Experience.
        /// </summary>
        public readonly string EndpointType;

        [OutputConstructor]
        private GetExperienceEndpointResult(
            string endpoint,

            string endpointType)
        {
            Endpoint = endpoint;
            EndpointType = endpointType;
        }
    }
}
