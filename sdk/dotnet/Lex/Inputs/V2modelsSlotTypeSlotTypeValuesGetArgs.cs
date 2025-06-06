// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotTypeSlotTypeValuesGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("sampleValues")]
        private InputList<Inputs.V2modelsSlotTypeSlotTypeValuesSampleValueGetArgs>? _sampleValues;

        /// <summary>
        /// Value of the slot type entry.
        /// See `sample_value` argument reference below.
        /// </summary>
        public InputList<Inputs.V2modelsSlotTypeSlotTypeValuesSampleValueGetArgs> SampleValues
        {
            get => _sampleValues ?? (_sampleValues = new InputList<Inputs.V2modelsSlotTypeSlotTypeValuesSampleValueGetArgs>());
            set => _sampleValues = value;
        }

        [Input("synonyms")]
        private InputList<Inputs.V2modelsSlotTypeSlotTypeValuesSynonymGetArgs>? _synonyms;

        /// <summary>
        /// A list of additional values related to the slot type entry.
        /// See `synonyms` argument reference below.
        /// </summary>
        public InputList<Inputs.V2modelsSlotTypeSlotTypeValuesSynonymGetArgs> Synonyms
        {
            get => _synonyms ?? (_synonyms = new InputList<Inputs.V2modelsSlotTypeSlotTypeValuesSynonymGetArgs>());
            set => _synonyms = value;
        }

        public V2modelsSlotTypeSlotTypeValuesGetArgs()
        {
        }
        public static new V2modelsSlotTypeSlotTypeValuesGetArgs Empty => new V2modelsSlotTypeSlotTypeValuesGetArgs();
    }
}
