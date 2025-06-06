// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DomainDefaultSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Settings related to idle shutdown of Studio applications. see `idle_settings` Block below.
        /// </summary>
        [Input("idleSettings")]
        public Input<Inputs.DomainDefaultSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementIdleSettingsGetArgs>? IdleSettings { get; set; }

        public DomainDefaultSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementGetArgs()
        {
        }
        public static new DomainDefaultSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementGetArgs Empty => new DomainDefaultSpaceSettingsJupyterLabAppSettingsAppLifecycleManagementGetArgs();
    }
}
