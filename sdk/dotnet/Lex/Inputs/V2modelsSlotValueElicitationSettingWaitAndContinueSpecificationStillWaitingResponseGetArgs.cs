// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("allowInterrupt")]
        public Input<bool>? AllowInterrupt { get; set; }

        [Input("frequencyInSeconds", required: true)]
        public Input<int> FrequencyInSeconds { get; set; } = null!;

        [Input("messageGroups")]
        private InputList<Inputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupGetArgs>? _messageGroups;
        public InputList<Inputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupGetArgs> MessageGroups
        {
            get => _messageGroups ?? (_messageGroups = new InputList<Inputs.V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseMessageGroupGetArgs>());
            set => _messageGroups = value;
        }

        [Input("timeoutInSeconds", required: true)]
        public Input<int> TimeoutInSeconds { get; set; } = null!;

        public V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseGetArgs()
        {
        }
        public static new V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseGetArgs Empty => new V2modelsSlotValueElicitationSettingWaitAndContinueSpecificationStillWaitingResponseGetArgs();
    }
}
