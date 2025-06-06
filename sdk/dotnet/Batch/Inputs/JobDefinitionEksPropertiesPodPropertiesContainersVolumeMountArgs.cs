// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Batch.Inputs
{

    public sealed class JobDefinitionEksPropertiesPodPropertiesContainersVolumeMountArgs : global::Pulumi.ResourceArgs
    {
        [Input("mountPath", required: true)]
        public Input<string> MountPath { get; set; } = null!;

        /// <summary>
        /// Name of the job definition.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        [Input("readOnly")]
        public Input<bool>? ReadOnly { get; set; }

        public JobDefinitionEksPropertiesPodPropertiesContainersVolumeMountArgs()
        {
        }
        public static new JobDefinitionEksPropertiesPodPropertiesContainersVolumeMountArgs Empty => new JobDefinitionEksPropertiesPodPropertiesContainersVolumeMountArgs();
    }
}
