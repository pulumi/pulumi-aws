// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Outputs
{

    [OutputType]
    public sealed class GroupInstanceRefreshPreferencesAlarmSpecification
    {
        /// <summary>
        /// List of Cloudwatch alarms. If any of these alarms goes into ALARM state, Instance Refresh is failed.
        /// </summary>
        public readonly ImmutableArray<string> Alarms;

        [OutputConstructor]
        private GroupInstanceRefreshPreferencesAlarmSpecification(ImmutableArray<string> alarms)
        {
            Alarms = alarms;
        }
    }
}
