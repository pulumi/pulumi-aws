// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationWaitingResponseMessageGroupMessageSsmlMessageGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationWaitingResponseMessageGroupMessageSsmlMessageGetArgs()
        {
        }
        public static new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationWaitingResponseMessageGroupMessageSsmlMessageGetArgs Empty => new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecificationWaitingResponseMessageGroupMessageSsmlMessageGetArgs();
    }
}
