// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Inputs
{

    public sealed class GetTaskExecutionCapacityProviderStrategyArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The number of tasks, at a minimum, to run on the specified capacity provider. Only one capacity provider in a capacity provider strategy can have a base defined. Defaults to `0`.
        /// </summary>
        [Input("base")]
        public int? Base { get; set; }

        /// <summary>
        /// Name of the capacity provider.
        /// </summary>
        [Input("capacityProvider", required: true)]
        public string CapacityProvider { get; set; } = null!;

        /// <summary>
        /// The relative percentage of the total number of launched tasks that should use the specified capacity provider. The `weight` value is taken into consideration after the `base` count of tasks has been satisfied. Defaults to `0`.
        /// </summary>
        [Input("weight")]
        public int? Weight { get; set; }

        public GetTaskExecutionCapacityProviderStrategyArgs()
        {
        }
        public static new GetTaskExecutionCapacityProviderStrategyArgs Empty => new GetTaskExecutionCapacityProviderStrategyArgs();
    }
}
