// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kendra.Inputs
{

    public sealed class ExperienceEndpointArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The endpoint of your Amazon Kendra experience.
        /// </summary>
        [Input("endpoint")]
        public Input<string>? Endpoint { get; set; }

        /// <summary>
        /// The type of endpoint for your Amazon Kendra experience.
        /// </summary>
        [Input("endpointType")]
        public Input<string>? EndpointType { get; set; }

        public ExperienceEndpointArgs()
        {
        }
        public static new ExperienceEndpointArgs Empty => new ExperienceEndpointArgs();
    }
}
