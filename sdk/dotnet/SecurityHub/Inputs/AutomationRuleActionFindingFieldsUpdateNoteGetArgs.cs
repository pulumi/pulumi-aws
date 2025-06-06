// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub.Inputs
{

    public sealed class AutomationRuleActionFindingFieldsUpdateNoteGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The updated note text.
        /// </summary>
        [Input("text", required: true)]
        public Input<string> Text { get; set; } = null!;

        /// <summary>
        /// The principal that updated the note.
        /// </summary>
        [Input("updatedBy", required: true)]
        public Input<string> UpdatedBy { get; set; } = null!;

        public AutomationRuleActionFindingFieldsUpdateNoteGetArgs()
        {
        }
        public static new AutomationRuleActionFindingFieldsUpdateNoteGetArgs Empty => new AutomationRuleActionFindingFieldsUpdateNoteGetArgs();
    }
}
