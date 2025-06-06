// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CleanRooms.Inputs
{

    public sealed class MembershipDefaultResultConfigurationOutputConfigurationS3GetArgs : global::Pulumi.ResourceArgs
    {
        [Input("bucket", required: true)]
        public Input<string> Bucket { get; set; } = null!;

        [Input("keyPrefix")]
        public Input<string>? KeyPrefix { get; set; }

        [Input("resultFormat", required: true)]
        public Input<string> ResultFormat { get; set; } = null!;

        public MembershipDefaultResultConfigurationOutputConfigurationS3GetArgs()
        {
        }
        public static new MembershipDefaultResultConfigurationOutputConfigurationS3GetArgs Empty => new MembershipDefaultResultConfigurationOutputConfigurationS3GetArgs();
    }
}
