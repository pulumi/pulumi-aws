// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchNextStepIntentSlotValueGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("interpretedValue")]
        public Input<string>? InterpretedValue { get; set; }

        public V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchNextStepIntentSlotValueGetArgs()
        {
        }
        public static new V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchNextStepIntentSlotValueGetArgs Empty => new V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchNextStepIntentSlotValueGetArgs();
    }
}
