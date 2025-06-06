// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53Domains.Inputs
{

    public sealed class DomainAdminContactExtraParamArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of an additional parameter that is required by a top-level domain.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// The value that corresponds with the name of an extra parameter.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public DomainAdminContactExtraParamArgs()
        {
        }
        public static new DomainAdminContactExtraParamArgs Empty => new DomainAdminContactExtraParamArgs();
    }
}
