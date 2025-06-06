// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.EmrServerless.Inputs
{

    public sealed class ApplicationInteractiveConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Enables an Apache Livy endpoint that you can connect to and run interactive jobs.
        /// </summary>
        [Input("livyEndpointEnabled")]
        public Input<bool>? LivyEndpointEnabled { get; set; }

        /// <summary>
        /// Enables you to connect an application to Amazon EMR Studio to run interactive workloads in a notebook.
        /// </summary>
        [Input("studioEnabled")]
        public Input<bool>? StudioEnabled { get; set; }

        public ApplicationInteractiveConfigurationGetArgs()
        {
        }
        public static new ApplicationInteractiveConfigurationGetArgs Empty => new ApplicationInteractiveConfigurationGetArgs();
    }
}
