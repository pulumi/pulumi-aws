// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Outputs
{

    [OutputType]
    public sealed class InputMediaConnectFlow
    {
        /// <summary>
        /// The ARN of the MediaConnect Flow
        /// </summary>
        public readonly string FlowArn;

        [OutputConstructor]
        private InputMediaConnectFlow(string flowArn)
        {
            FlowArn = flowArn;
        }
    }
}
