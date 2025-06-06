// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Outputs
{

    [OutputType]
    public sealed class ContinuousDeploymentPolicyTrafficConfigSingleWeightConfig
    {
        /// <summary>
        /// Session stickiness provides the ability to define multiple requests from a single viewer as a single session. This prevents the potentially inconsistent experience of sending some of a given user's requests to the staging distribution, while others are sent to the primary distribution. Define the session duration using TTL values. See `session_stickiness_config`.
        /// </summary>
        public readonly Outputs.ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig? SessionStickinessConfig;
        /// <summary>
        /// The percentage of traffic to send to a staging distribution, expressed as a decimal number between `0` and `.15`.
        /// </summary>
        public readonly double Weight;

        [OutputConstructor]
        private ContinuousDeploymentPolicyTrafficConfigSingleWeightConfig(
            Outputs.ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig? sessionStickinessConfig,

            double weight)
        {
            SessionStickinessConfig = sessionStickinessConfig;
            Weight = weight;
        }
    }
}
