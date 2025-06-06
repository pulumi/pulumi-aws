// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Outputs
{

    [OutputType]
    public sealed class ServiceAlarms
    {
        /// <summary>
        /// One or more CloudWatch alarm names.
        /// </summary>
        public readonly ImmutableArray<string> AlarmNames;
        /// <summary>
        /// Whether to use the CloudWatch alarm option in the service deployment process.
        /// </summary>
        public readonly bool Enable;
        /// <summary>
        /// Whether to configure Amazon ECS to roll back the service if a service deployment fails. If rollback is used, when a service deployment fails, the service is rolled back to the last deployment that completed successfully.
        /// </summary>
        public readonly bool Rollback;

        [OutputConstructor]
        private ServiceAlarms(
            ImmutableArray<string> alarmNames,

            bool enable,

            bool rollback)
        {
            AlarmNames = alarmNames;
            Enable = enable;
            Rollback = rollback;
        }
    }
}
