// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DynamoDB.Outputs
{

    [OutputType]
    public sealed class GetTablePointInTimeRecoveryResult
    {
        public readonly bool Enabled;
        public readonly int RecoveryPeriodInDays;

        [OutputConstructor]
        private GetTablePointInTimeRecoveryResult(
            bool enabled,

            int recoveryPeriodInDays)
        {
            Enabled = enabled;
            RecoveryPeriodInDays = recoveryPeriodInDays;
        }
    }
}
