// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("allowInterrupt")]
        public Input<bool>? AllowInterrupt { get; set; }

        [Input("messageGroups")]
        private InputList<Inputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupGetArgs>? _messageGroups;
        public InputList<Inputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupGetArgs> MessageGroups
        {
            get => _messageGroups ?? (_messageGroups = new InputList<Inputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseMessageGroupGetArgs>());
            set => _messageGroups = value;
        }

        public V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseGetArgs()
        {
        }
        public static new V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseGetArgs Empty => new V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationContinueResponseGetArgs();
    }
}
