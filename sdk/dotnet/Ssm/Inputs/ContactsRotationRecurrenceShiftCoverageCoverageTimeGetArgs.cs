// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ssm.Inputs
{

    public sealed class ContactsRotationRecurrenceShiftCoverageCoverageTimeGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// (Required) The end time of the on-call shift. See Hand Off Time for more details.
        /// </summary>
        [Input("end")]
        public Input<Inputs.ContactsRotationRecurrenceShiftCoverageCoverageTimeEndGetArgs>? End { get; set; }

        /// <summary>
        /// (Required) The start time of the on-call shift. See Hand Off Time for more details.
        /// </summary>
        [Input("start")]
        public Input<Inputs.ContactsRotationRecurrenceShiftCoverageCoverageTimeStartGetArgs>? Start { get; set; }

        public ContactsRotationRecurrenceShiftCoverageCoverageTimeGetArgs()
        {
        }
        public static new ContactsRotationRecurrenceShiftCoverageCoverageTimeGetArgs Empty => new ContactsRotationRecurrenceShiftCoverageCoverageTimeGetArgs();
    }
}
