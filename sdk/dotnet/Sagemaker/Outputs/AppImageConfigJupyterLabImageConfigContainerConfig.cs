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
    public sealed class AppImageConfigJupyterLabImageConfigContainerConfig
    {
        /// <summary>
        /// The arguments for the container when you're running the application.
        /// </summary>
        public readonly ImmutableArray<string> ContainerArguments;
        /// <summary>
        /// The entrypoint used to run the application in the container.
        /// </summary>
        public readonly ImmutableArray<string> ContainerEntrypoints;
        /// <summary>
        /// The environment variables to set in the container.
        /// </summary>
        public readonly ImmutableDictionary<string, string>? ContainerEnvironmentVariables;

        [OutputConstructor]
        private AppImageConfigJupyterLabImageConfigContainerConfig(
            ImmutableArray<string> containerArguments,

            ImmutableArray<string> containerEntrypoints,

            ImmutableDictionary<string, string>? containerEnvironmentVariables)
        {
            ContainerArguments = containerArguments;
            ContainerEntrypoints = containerEntrypoints;
            ContainerEnvironmentVariables = containerEnvironmentVariables;
        }
    }
}
