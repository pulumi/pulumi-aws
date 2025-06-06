// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Outputs
{

    [OutputType]
    public sealed class RouteSpecHttp2RouteRetryPolicyPerRetryTimeout
    {
        /// <summary>
        /// Retry unit. Valid values: `ms`, `s`.
        /// </summary>
        public readonly string Unit;
        /// <summary>
        /// Retry value.
        /// </summary>
        public readonly int Value;

        [OutputConstructor]
        private RouteSpecHttp2RouteRetryPolicyPerRetryTimeout(
            string unit,

            int value)
        {
            Unit = unit;
            Value = value;
        }
    }
}
