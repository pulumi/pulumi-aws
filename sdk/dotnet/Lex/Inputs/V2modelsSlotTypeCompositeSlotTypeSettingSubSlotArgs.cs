// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotTypeCompositeSlotTypeSettingSubSlotArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of a constituent sub slot inside a composite slot.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// Unique identifier assigned to a slot type.
        /// This refers to either a built-in slot type or the unique `slot_type_id` of a custom slot type.
        /// </summary>
        [Input("slotTypeId", required: true)]
        public Input<string> SlotTypeId { get; set; } = null!;

        public V2modelsSlotTypeCompositeSlotTypeSettingSubSlotArgs()
        {
        }
        public static new V2modelsSlotTypeCompositeSlotTypeSettingSubSlotArgs Empty => new V2modelsSlotTypeCompositeSlotTypeSettingSubSlotArgs();
    }
}
