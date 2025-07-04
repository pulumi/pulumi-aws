// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Neptune.Inputs
{

    public sealed class ClusterServerlessV2ScalingConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Maximum Neptune Capacity Units (NCUs) for this cluster. Must be lower or equal than **128**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
        /// </summary>
        [Input("maxCapacity")]
        public Input<double>? MaxCapacity { get; set; }

        /// <summary>
        /// Minimum Neptune Capacity Units (NCUs) for this cluster. Must be greater or equal than **1**. See [AWS Documentation](https://docs.aws.amazon.com/neptune/latest/userguide/neptune-serverless-capacity-scaling.html) for more details.
        /// </summary>
        [Input("minCapacity")]
        public Input<double>? MinCapacity { get; set; }

        public ClusterServerlessV2ScalingConfigurationGetArgs()
        {
        }
        public static new ClusterServerlessV2ScalingConfigurationGetArgs Empty => new ClusterServerlessV2ScalingConfigurationGetArgs();
    }
}
