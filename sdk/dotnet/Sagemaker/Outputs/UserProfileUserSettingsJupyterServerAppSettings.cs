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
    public sealed class UserProfileUserSettingsJupyterServerAppSettings
    {
        /// <summary>
        /// A list of Git repositories that SageMaker AI automatically displays to users for cloning in the JupyterServer application. see Code Repository below.
        /// </summary>
        public readonly ImmutableArray<Outputs.UserProfileUserSettingsJupyterServerAppSettingsCodeRepository> CodeRepositories;
        /// <summary>
        /// The default instance type and the Amazon Resource Name (ARN) of the SageMaker AI image created on the instance. see Default Resource Spec below.
        /// </summary>
        public readonly Outputs.UserProfileUserSettingsJupyterServerAppSettingsDefaultResourceSpec? DefaultResourceSpec;
        /// <summary>
        /// The Amazon Resource Name (ARN) of the Lifecycle Configurations.
        /// </summary>
        public readonly ImmutableArray<string> LifecycleConfigArns;

        [OutputConstructor]
        private UserProfileUserSettingsJupyterServerAppSettings(
            ImmutableArray<Outputs.UserProfileUserSettingsJupyterServerAppSettingsCodeRepository> codeRepositories,

            Outputs.UserProfileUserSettingsJupyterServerAppSettingsDefaultResourceSpec? defaultResourceSpec,

            ImmutableArray<string> lifecycleConfigArns)
        {
            CodeRepositories = codeRepositories;
            DefaultResourceSpec = defaultResourceSpec;
            LifecycleConfigArns = lifecycleConfigArns;
        }
    }
}
