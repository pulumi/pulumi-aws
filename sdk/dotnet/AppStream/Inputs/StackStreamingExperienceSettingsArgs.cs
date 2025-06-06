// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppStream.Inputs
{

    public sealed class StackStreamingExperienceSettingsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The preferred protocol that you want to use while streaming your application.
        /// Valid values are `TCP` and `UDP`.
        /// </summary>
        [Input("preferredProtocol")]
        public Input<string>? PreferredProtocol { get; set; }

        public StackStreamingExperienceSettingsArgs()
        {
        }
        public static new StackStreamingExperienceSettingsArgs Empty => new StackStreamingExperienceSettingsArgs();
    }
}
