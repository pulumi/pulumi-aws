// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeGuruProfiler.Inputs
{

    public sealed class ProfilingGroupAgentOrchestrationConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// (Required) Boolean that specifies whether the profiling agent collects profiling data or
        /// </summary>
        [Input("profilingEnabled", required: true)]
        public Input<bool> ProfilingEnabled { get; set; } = null!;

        public ProfilingGroupAgentOrchestrationConfigGetArgs()
        {
        }
        public static new ProfilingGroupAgentOrchestrationConfigGetArgs Empty => new ProfilingGroupAgentOrchestrationConfigGetArgs();
    }
}
