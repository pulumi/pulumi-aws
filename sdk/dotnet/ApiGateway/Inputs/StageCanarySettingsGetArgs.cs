// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ApiGateway.Inputs
{

    public sealed class StageCanarySettingsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ID of the deployment that the canary points to.
        /// </summary>
        [Input("deploymentId", required: true)]
        public Input<string> DeploymentId { get; set; } = null!;

        /// <summary>
        /// Percent `0.0` - `100.0` of traffic to divert to the canary deployment.
        /// </summary>
        [Input("percentTraffic")]
        public Input<double>? PercentTraffic { get; set; }

        [Input("stageVariableOverrides")]
        private InputMap<string>? _stageVariableOverrides;

        /// <summary>
        /// Map of overridden stage `variables` (including new variables) for the canary deployment.
        /// </summary>
        public InputMap<string> StageVariableOverrides
        {
            get => _stageVariableOverrides ?? (_stageVariableOverrides = new InputMap<string>());
            set => _stageVariableOverrides = value;
        }

        /// <summary>
        /// Whether the canary deployment uses the stage cache. Defaults to false.
        /// </summary>
        [Input("useStageCache")]
        public Input<bool>? UseStageCache { get; set; }

        public StageCanarySettingsGetArgs()
        {
        }
        public static new StageCanarySettingsGetArgs Empty => new StageCanarySettingsGetArgs();
    }
}
