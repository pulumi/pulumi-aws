// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodePipeline.Inputs
{

    public sealed class CustomActionTypeSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The URL returned to the AWS CodePipeline console that provides a deep link to the resources of the external system.
        /// </summary>
        [Input("entityUrlTemplate")]
        public Input<string>? EntityUrlTemplate { get; set; }

        /// <summary>
        /// The URL returned to the AWS CodePipeline console that contains a link to the top-level landing page for the external system.
        /// </summary>
        [Input("executionUrlTemplate")]
        public Input<string>? ExecutionUrlTemplate { get; set; }

        /// <summary>
        /// The URL returned to the AWS CodePipeline console that contains a link to the page where customers can update or change the configuration of the external action.
        /// </summary>
        [Input("revisionUrlTemplate")]
        public Input<string>? RevisionUrlTemplate { get; set; }

        /// <summary>
        /// The URL of a sign-up page where users can sign up for an external service and perform initial configuration of the action provided by that service.
        /// </summary>
        [Input("thirdPartyConfigurationUrl")]
        public Input<string>? ThirdPartyConfigurationUrl { get; set; }

        public CustomActionTypeSettingsGetArgs()
        {
        }
        public static new CustomActionTypeSettingsGetArgs Empty => new CustomActionTypeSettingsGetArgs();
    }
}
