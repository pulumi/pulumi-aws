// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ssm.Outputs
{

    [OutputType]
    public sealed class GetContactsRotationRecurrenceMonthlySettingHandOffTimeResult
    {
        public readonly int HourOfDay;
        public readonly int MinuteOfHour;

        [OutputConstructor]
        private GetContactsRotationRecurrenceMonthlySettingHandOffTimeResult(
            int hourOfDay,

            int minuteOfHour)
        {
            HourOfDay = hourOfDay;
            MinuteOfHour = minuteOfHour;
        }
    }
}
