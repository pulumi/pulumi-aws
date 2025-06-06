// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Emr.Outputs
{

    [OutputType]
    public sealed class ClusterMasterInstanceFleetLaunchSpecifications
    {
        /// <summary>
        /// Configuration block for on demand instances launch specifications.
        /// </summary>
        public readonly ImmutableArray<Outputs.ClusterMasterInstanceFleetLaunchSpecificationsOnDemandSpecification> OnDemandSpecifications;
        /// <summary>
        /// Configuration block for spot instances launch specifications.
        /// </summary>
        public readonly ImmutableArray<Outputs.ClusterMasterInstanceFleetLaunchSpecificationsSpotSpecification> SpotSpecifications;

        [OutputConstructor]
        private ClusterMasterInstanceFleetLaunchSpecifications(
            ImmutableArray<Outputs.ClusterMasterInstanceFleetLaunchSpecificationsOnDemandSpecification> onDemandSpecifications,

            ImmutableArray<Outputs.ClusterMasterInstanceFleetLaunchSpecificationsSpotSpecification> spotSpecifications)
        {
            OnDemandSpecifications = onDemandSpecifications;
            SpotSpecifications = spotSpecifications;
        }
    }
}
