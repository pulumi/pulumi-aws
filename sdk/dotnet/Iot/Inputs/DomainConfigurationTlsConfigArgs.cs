// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iot.Inputs
{

    public sealed class DomainConfigurationTlsConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The security policy for a domain configuration.
        /// </summary>
        [Input("securityPolicy")]
        public Input<string>? SecurityPolicy { get; set; }

        public DomainConfigurationTlsConfigArgs()
        {
        }
        public static new DomainConfigurationTlsConfigArgs Empty => new DomainConfigurationTlsConfigArgs();
    }
}
