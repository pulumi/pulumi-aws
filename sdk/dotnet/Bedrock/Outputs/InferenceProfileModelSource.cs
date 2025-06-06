// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Outputs
{

    [OutputType]
    public sealed class InferenceProfileModelSource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the model.
        /// </summary>
        public readonly string CopyFrom;

        [OutputConstructor]
        private InferenceProfileModelSource(string copyFrom)
        {
            CopyFrom = copyFrom;
        }
    }
}
