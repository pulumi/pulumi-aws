// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Auditmanager.Outputs
{

    [OutputType]
    public sealed class ControlControlMappingSourceSourceKeyword
    {
        /// <summary>
        /// Input method for the keyword. Valid values are `INPUT_TEXT`, `SELECT_FROM_LIST`, or `UPLOAD_FILE`.
        /// </summary>
        public readonly string KeywordInputType;
        /// <summary>
        /// The value of the keyword that's used when mapping a control data source. For example, this can be a CloudTrail event name, a rule name for Config, a Security Hub control, or the name of an Amazon Web Services API call. See the [Audit Manager supported control data sources documentation](https://docs.aws.amazon.com/audit-manager/latest/userguide/control-data-sources.html) for more information.
        /// </summary>
        public readonly string KeywordValue;

        [OutputConstructor]
        private ControlControlMappingSourceSourceKeyword(
            string keywordInputType,

            string keywordValue)
        {
            KeywordInputType = keywordInputType;
            KeywordValue = keywordValue;
        }
    }
}
