// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsmContacts.Outputs
{

    [OutputType]
    public sealed class PlanStageTarget
    {
        public readonly Outputs.PlanStageTargetChannelTargetInfo? ChannelTargetInfo;
        public readonly Outputs.PlanStageTargetContactTargetInfo? ContactTargetInfo;

        [OutputConstructor]
        private PlanStageTarget(
            Outputs.PlanStageTargetChannelTargetInfo? channelTargetInfo,

            Outputs.PlanStageTargetContactTargetInfo? contactTargetInfo)
        {
            ChannelTargetInfo = channelTargetInfo;
            ContactTargetInfo = contactTargetInfo;
        }
    }
}