// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotTypeExternalSourceSettingGrammarSlotTypeSettingGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Source of the grammar used to create the slot type.
        /// See `source` argument reference below.
        /// </summary>
        [Input("source")]
        public Input<Inputs.V2modelsSlotTypeExternalSourceSettingGrammarSlotTypeSettingSourceGetArgs>? Source { get; set; }

        public V2modelsSlotTypeExternalSourceSettingGrammarSlotTypeSettingGetArgs()
        {
        }
        public static new V2modelsSlotTypeExternalSourceSettingGrammarSlotTypeSettingGetArgs Empty => new V2modelsSlotTypeExternalSourceSettingGrammarSlotTypeSettingGetArgs();
    }
}
