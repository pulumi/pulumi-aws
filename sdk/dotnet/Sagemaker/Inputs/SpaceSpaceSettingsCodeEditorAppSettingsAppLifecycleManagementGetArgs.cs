// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class SpaceSpaceSettingsCodeEditorAppSettingsAppLifecycleManagementGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Settings related to idle shutdown of Studio applications. See `idle_settings` Block below.
        /// </summary>
        [Input("idleSettings")]
        public Input<Inputs.SpaceSpaceSettingsCodeEditorAppSettingsAppLifecycleManagementIdleSettingsGetArgs>? IdleSettings { get; set; }

        public SpaceSpaceSettingsCodeEditorAppSettingsAppLifecycleManagementGetArgs()
        {
        }
        public static new SpaceSpaceSettingsCodeEditorAppSettingsAppLifecycleManagementGetArgs Empty => new SpaceSpaceSettingsCodeEditorAppSettingsAppLifecycleManagementGetArgs();
    }
}
