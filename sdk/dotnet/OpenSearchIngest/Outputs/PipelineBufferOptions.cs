// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearchIngest.Outputs
{

    [OutputType]
    public sealed class PipelineBufferOptions
    {
        /// <summary>
        /// Whether persistent buffering should be enabled.
        /// </summary>
        public readonly bool PersistentBufferEnabled;

        [OutputConstructor]
        private PipelineBufferOptions(bool persistentBufferEnabled)
        {
            PersistentBufferEnabled = persistentBufferEnabled;
        }
    }
}
