// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SesV2.Outputs
{

    [OutputType]
    public sealed class GetConfigurationSetSendingOptionResult
    {
        /// <summary>
        /// Specifies whether email sending is enabled.
        /// </summary>
        public readonly bool SendingEnabled;

        [OutputConstructor]
        private GetConfigurationSetSendingOptionResult(bool sendingEnabled)
        {
            SendingEnabled = sendingEnabled;
        }
    }
}