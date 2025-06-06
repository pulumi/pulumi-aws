// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Transfer.Outputs
{

    [OutputType]
    public sealed class ServerWorkflowDetails
    {
        /// <summary>
        /// A trigger that starts a workflow if a file is only partially uploaded. See Workflow Detail below. See `on_partial_upload` Block below for details.
        /// </summary>
        public readonly Outputs.ServerWorkflowDetailsOnPartialUpload? OnPartialUpload;
        /// <summary>
        /// A trigger that starts a workflow: the workflow begins to execute after a file is uploaded. See `on_upload` Block below for details.
        /// </summary>
        public readonly Outputs.ServerWorkflowDetailsOnUpload? OnUpload;

        [OutputConstructor]
        private ServerWorkflowDetails(
            Outputs.ServerWorkflowDetailsOnPartialUpload? onPartialUpload,

            Outputs.ServerWorkflowDetailsOnUpload? onUpload)
        {
            OnPartialUpload = onPartialUpload;
            OnUpload = onUpload;
        }
    }
}
