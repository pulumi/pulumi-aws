// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53.Outputs
{

    [OutputType]
    public sealed class RecordGeoproximityRoutingPolicyCoordinate
    {
        public readonly string Latitude;
        public readonly string Longitude;

        [OutputConstructor]
        private RecordGeoproximityRoutingPolicyCoordinate(
            string latitude,

            string longitude)
        {
            Latitude = latitude;
            Longitude = longitude;
        }
    }
}
