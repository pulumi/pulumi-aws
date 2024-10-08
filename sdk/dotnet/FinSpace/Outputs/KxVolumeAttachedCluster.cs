// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.FinSpace.Outputs
{

    [OutputType]
    public sealed class KxVolumeAttachedCluster
    {
        public readonly string ClusterName;
        public readonly string ClusterStatus;
        public readonly string ClusterType;

        [OutputConstructor]
        private KxVolumeAttachedCluster(
            string clusterName,

            string clusterStatus,

            string clusterType)
        {
            ClusterName = clusterName;
            ClusterStatus = clusterStatus;
            ClusterType = clusterType;
        }
    }
}
