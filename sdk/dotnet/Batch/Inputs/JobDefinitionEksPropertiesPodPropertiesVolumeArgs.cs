// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Batch.Inputs
{

    public sealed class JobDefinitionEksPropertiesPodPropertiesVolumeArgs : global::Pulumi.ResourceArgs
    {
        [Input("emptyDir")]
        public Input<Inputs.JobDefinitionEksPropertiesPodPropertiesVolumeEmptyDirArgs>? EmptyDir { get; set; }

        [Input("hostPath")]
        public Input<Inputs.JobDefinitionEksPropertiesPodPropertiesVolumeHostPathArgs>? HostPath { get; set; }

        /// <summary>
        /// Name of the job definition.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("secret")]
        public Input<Inputs.JobDefinitionEksPropertiesPodPropertiesVolumeSecretArgs>? Secret { get; set; }

        public JobDefinitionEksPropertiesPodPropertiesVolumeArgs()
        {
        }
        public static new JobDefinitionEksPropertiesPodPropertiesVolumeArgs Empty => new JobDefinitionEksPropertiesPodPropertiesVolumeArgs();
    }
}
