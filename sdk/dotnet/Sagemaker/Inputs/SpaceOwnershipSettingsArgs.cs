// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class SpaceOwnershipSettingsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The user profile who is the owner of the private space.
        /// </summary>
        [Input("ownerUserProfileName", required: true)]
        public Input<string> OwnerUserProfileName { get; set; } = null!;

        public SpaceOwnershipSettingsArgs()
        {
        }
        public static new SpaceOwnershipSettingsArgs Empty => new SpaceOwnershipSettingsArgs();
    }
}
