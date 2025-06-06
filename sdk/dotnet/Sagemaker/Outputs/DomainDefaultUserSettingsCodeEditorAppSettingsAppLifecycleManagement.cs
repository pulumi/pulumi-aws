// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Outputs
{

    [OutputType]
    public sealed class DomainDefaultUserSettingsCodeEditorAppSettingsAppLifecycleManagement
    {
        /// <summary>
        /// Settings related to idle shutdown of Studio applications. see `idle_settings` Block below.
        /// </summary>
        public readonly Outputs.DomainDefaultUserSettingsCodeEditorAppSettingsAppLifecycleManagementIdleSettings? IdleSettings;

        [OutputConstructor]
        private DomainDefaultUserSettingsCodeEditorAppSettingsAppLifecycleManagement(Outputs.DomainDefaultUserSettingsCodeEditorAppSettingsAppLifecycleManagementIdleSettings? idleSettings)
        {
            IdleSettings = idleSettings;
        }
    }
}
