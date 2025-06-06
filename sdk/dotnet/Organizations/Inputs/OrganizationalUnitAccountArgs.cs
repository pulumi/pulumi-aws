// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Organizations.Inputs
{

    public sealed class OrganizationalUnitAccountArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the organizational unit
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Email of the account
        /// </summary>
        [Input("email")]
        public Input<string>? Email { get; set; }

        /// <summary>
        /// Identifier of the organization unit
        /// </summary>
        [Input("id")]
        public Input<string>? Id { get; set; }

        /// <summary>
        /// The name for the organizational unit
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        public OrganizationalUnitAccountArgs()
        {
        }
        public static new OrganizationalUnitAccountArgs Empty => new OrganizationalUnitAccountArgs();
    }
}
