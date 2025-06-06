// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class SpaceSpaceSettingsJupyterServerAppSettingsDefaultResourceSpecGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The instance type.
        /// </summary>
        [Input("instanceType")]
        public Input<string>? InstanceType { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the Lifecycle Configuration attached to the Resource.
        /// </summary>
        [Input("lifecycleConfigArn")]
        public Input<string>? LifecycleConfigArn { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the SageMaker AI image created on the instance.
        /// </summary>
        [Input("sagemakerImageArn")]
        public Input<string>? SagemakerImageArn { get; set; }

        /// <summary>
        /// The SageMaker AI Image Version Alias.
        /// </summary>
        [Input("sagemakerImageVersionAlias")]
        public Input<string>? SagemakerImageVersionAlias { get; set; }

        /// <summary>
        /// The ARN of the image version created on the instance.
        /// </summary>
        [Input("sagemakerImageVersionArn")]
        public Input<string>? SagemakerImageVersionArn { get; set; }

        public SpaceSpaceSettingsJupyterServerAppSettingsDefaultResourceSpecGetArgs()
        {
        }
        public static new SpaceSpaceSettingsJupyterServerAppSettingsDefaultResourceSpecGetArgs Empty => new SpaceSpaceSettingsJupyterServerAppSettingsDefaultResourceSpecGetArgs();
    }
}
