// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Outputs
{

    [OutputType]
    public sealed class ListenerDefaultActionFixedResponse
    {
        /// <summary>
        /// Custom HTTP status code to return, e.g. a 404 response code. See [Listeners](https://docs.aws.amazon.com/vpc-lattice/latest/ug/listeners.html) in the AWS documentation for a list of supported codes.
        /// </summary>
        public readonly int StatusCode;

        [OutputConstructor]
        private ListenerDefaultActionFixedResponse(int statusCode)
        {
            StatusCode = statusCode;
        }
    }
}
