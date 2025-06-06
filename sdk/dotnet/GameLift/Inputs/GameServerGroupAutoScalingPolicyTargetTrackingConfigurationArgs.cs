// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GameLift.Inputs
{

    public sealed class GameServerGroupAutoScalingPolicyTargetTrackingConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Desired value to use with a game server group target-based scaling policy.
        /// </summary>
        [Input("targetValue", required: true)]
        public Input<double> TargetValue { get; set; } = null!;

        public GameServerGroupAutoScalingPolicyTargetTrackingConfigurationArgs()
        {
        }
        public static new GameServerGroupAutoScalingPolicyTargetTrackingConfigurationArgs Empty => new GameServerGroupAutoScalingPolicyTargetTrackingConfigurationArgs();
    }
}
