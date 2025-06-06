// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityLake.Outputs
{

    [OutputType]
    public sealed class DataLakeConfigurationLifecycleConfigurationExpiration
    {
        /// <summary>
        /// Number of days before data transition to a different S3 Storage Class in the Amazon Security Lake object.
        /// </summary>
        public readonly int? Days;

        [OutputConstructor]
        private DataLakeConfigurationLifecycleConfigurationExpiration(int? days)
        {
            Days = days;
        }
    }
}
