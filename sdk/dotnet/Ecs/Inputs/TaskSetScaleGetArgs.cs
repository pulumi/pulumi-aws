// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Inputs
{

    public sealed class TaskSetScaleGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The unit of measure for the scale value. Default: `PERCENT`.
        /// </summary>
        [Input("unit")]
        public Input<string>? Unit { get; set; }

        /// <summary>
        /// The value, specified as a percent total of a service's `desiredCount`, to scale the task set. Defaults to `0` if not specified. Accepted values are numbers between 0.0 and 100.0.
        /// </summary>
        [Input("value")]
        public Input<double>? Value { get; set; }

        public TaskSetScaleGetArgs()
        {
        }
        public static new TaskSetScaleGetArgs Empty => new TaskSetScaleGetArgs();
    }
}
