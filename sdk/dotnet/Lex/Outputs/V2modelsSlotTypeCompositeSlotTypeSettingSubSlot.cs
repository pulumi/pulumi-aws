// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Outputs
{

    [OutputType]
    public sealed class V2modelsSlotTypeCompositeSlotTypeSettingSubSlot
    {
        /// <summary>
        /// Name of a constituent sub slot inside a composite slot.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Unique identifier assigned to a slot type.
        /// This refers to either a built-in slot type or the unique `slot_type_id` of a custom slot type.
        /// </summary>
        public readonly string SlotTypeId;

        [OutputConstructor]
        private V2modelsSlotTypeCompositeSlotTypeSettingSubSlot(
            string name,

            string slotTypeId)
        {
            Name = name;
            SlotTypeId = slotTypeId;
        }
    }
}
