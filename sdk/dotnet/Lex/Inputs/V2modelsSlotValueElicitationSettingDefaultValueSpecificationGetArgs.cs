// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotValueElicitationSettingDefaultValueSpecificationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("defaultValueLists")]
        private InputList<Inputs.V2modelsSlotValueElicitationSettingDefaultValueSpecificationDefaultValueListGetArgs>? _defaultValueLists;
        public InputList<Inputs.V2modelsSlotValueElicitationSettingDefaultValueSpecificationDefaultValueListGetArgs> DefaultValueLists
        {
            get => _defaultValueLists ?? (_defaultValueLists = new InputList<Inputs.V2modelsSlotValueElicitationSettingDefaultValueSpecificationDefaultValueListGetArgs>());
            set => _defaultValueLists = value;
        }

        public V2modelsSlotValueElicitationSettingDefaultValueSpecificationGetArgs()
        {
        }
        public static new V2modelsSlotValueElicitationSettingDefaultValueSpecificationGetArgs Empty => new V2modelsSlotValueElicitationSettingDefaultValueSpecificationGetArgs();
    }
}
