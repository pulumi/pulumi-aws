// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFormation.Inputs
{

    public sealed class StackSetInstanceStackInstanceSummaryGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Target AWS Account ID to create a Stack based on the StackSet. Defaults to current account.
        /// </summary>
        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// Organizational unit ID in which the stack is deployed.
        /// </summary>
        [Input("organizationalUnitId")]
        public Input<string>? OrganizationalUnitId { get; set; }

        /// <summary>
        /// Stack identifier.
        /// </summary>
        [Input("stackId")]
        public Input<string>? StackId { get; set; }

        public StackSetInstanceStackInstanceSummaryGetArgs()
        {
        }
        public static new StackSetInstanceStackInstanceSummaryGetArgs Empty => new StackSetInstanceStackInstanceSummaryGetArgs();
    }
}
