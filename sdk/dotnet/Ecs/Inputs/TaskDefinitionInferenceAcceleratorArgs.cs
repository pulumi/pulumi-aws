// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Inputs
{

    public sealed class TaskDefinitionInferenceAcceleratorArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Elastic Inference accelerator device name. The deviceName must also be referenced in a container definition as a ResourceRequirement.
        /// </summary>
        [Input("deviceName", required: true)]
        public Input<string> DeviceName { get; set; } = null!;

        /// <summary>
        /// Elastic Inference accelerator type to use.
        /// </summary>
        [Input("deviceType", required: true)]
        public Input<string> DeviceType { get; set; } = null!;

        public TaskDefinitionInferenceAcceleratorArgs()
        {
        }
        public static new TaskDefinitionInferenceAcceleratorArgs Empty => new TaskDefinitionInferenceAcceleratorArgs();
    }
}
