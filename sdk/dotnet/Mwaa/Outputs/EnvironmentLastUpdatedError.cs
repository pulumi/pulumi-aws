// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Mwaa.Outputs
{

    [OutputType]
    public sealed class EnvironmentLastUpdatedError
    {
        public readonly string? ErrorCode;
        public readonly string? ErrorMessage;

        [OutputConstructor]
        private EnvironmentLastUpdatedError(
            string? errorCode,

            string? errorMessage)
        {
            ErrorCode = errorCode;
            ErrorMessage = errorMessage;
        }
    }
}
