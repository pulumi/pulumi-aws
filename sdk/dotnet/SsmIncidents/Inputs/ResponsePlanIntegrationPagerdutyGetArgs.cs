// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsmIncidents.Inputs
{

    public sealed class ResponsePlanIntegrationPagerdutyGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the response plan.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// The ID of the AWS Secrets Manager secret that stores your PagerDuty key &amp;mdash; either a General Access REST API Key or User Token REST API Key &amp;mdash; and other user credentials.
        /// </summary>
        [Input("secretId", required: true)]
        public Input<string> SecretId { get; set; } = null!;

        /// <summary>
        /// The ID of the PagerDuty service that the response plan associated with the incident at launch.
        /// </summary>
        [Input("serviceId", required: true)]
        public Input<string> ServiceId { get; set; } = null!;

        public ResponsePlanIntegrationPagerdutyGetArgs()
        {
        }
        public static new ResponsePlanIntegrationPagerdutyGetArgs Empty => new ResponsePlanIntegrationPagerdutyGetArgs();
    }
}