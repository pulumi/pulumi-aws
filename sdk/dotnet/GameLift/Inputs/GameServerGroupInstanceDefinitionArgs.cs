// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GameLift.Inputs
{

    public sealed class GameServerGroupInstanceDefinitionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// An EC2 instance type.
        /// </summary>
        [Input("instanceType", required: true)]
        public Input<string> InstanceType { get; set; } = null!;

        /// <summary>
        /// Instance weighting that indicates how much this instance type contributes
        /// to the total capacity of a game server group.
        /// Instance weights are used by GameLift FleetIQ to calculate the instance type's cost per unit hour and better identify
        /// the most cost-effective options.
        /// </summary>
        [Input("weightedCapacity")]
        public Input<string>? WeightedCapacity { get; set; }

        public GameServerGroupInstanceDefinitionArgs()
        {
        }
        public static new GameServerGroupInstanceDefinitionArgs Empty => new GameServerGroupInstanceDefinitionArgs();
    }
}
