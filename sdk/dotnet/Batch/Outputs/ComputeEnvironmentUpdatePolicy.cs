// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Batch.Outputs
{

    [OutputType]
    public sealed class ComputeEnvironmentUpdatePolicy
    {
        /// <summary>
        /// Specifies the job timeout (in minutes) when the compute environment infrastructure is updated.
        /// </summary>
        public readonly int JobExecutionTimeoutMinutes;
        /// <summary>
        /// Specifies whether jobs are automatically terminated when the computer environment infrastructure is updated.
        /// </summary>
        public readonly bool TerminateJobsOnUpdate;

        [OutputConstructor]
        private ComputeEnvironmentUpdatePolicy(
            int jobExecutionTimeoutMinutes,

            bool terminateJobsOnUpdate)
        {
            JobExecutionTimeoutMinutes = jobExecutionTimeoutMinutes;
            TerminateJobsOnUpdate = terminateJobsOnUpdate;
        }
    }
}
