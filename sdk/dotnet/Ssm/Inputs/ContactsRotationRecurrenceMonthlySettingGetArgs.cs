// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ssm.Inputs
{

    public sealed class ContactsRotationRecurrenceMonthlySettingGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// (Required) The day of the month when monthly recurring on-call rotations begin.
        /// </summary>
        [Input("dayOfMonth", required: true)]
        public Input<int> DayOfMonth { get; set; } = null!;

        /// <summary>
        /// (Required) The hand off time. See Hand Off Time for more details.
        /// </summary>
        [Input("handOffTime")]
        public Input<Inputs.ContactsRotationRecurrenceMonthlySettingHandOffTimeGetArgs>? HandOffTime { get; set; }

        public ContactsRotationRecurrenceMonthlySettingGetArgs()
        {
        }
        public static new ContactsRotationRecurrenceMonthlySettingGetArgs Empty => new ContactsRotationRecurrenceMonthlySettingGetArgs();
    }
}
