// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.IdentityStore.Inputs
{

    public sealed class GetGroupAlternateIdentifierExternalIdArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The identifier issued to this resource by an external identity provider.
        /// </summary>
        [Input("id", required: true)]
        public string Id { get; set; } = null!;

        /// <summary>
        /// The issuer for an external identifier.
        /// </summary>
        [Input("issuer", required: true)]
        public string Issuer { get; set; } = null!;

        public GetGroupAlternateIdentifierExternalIdArgs()
        {
        }
        public static new GetGroupAlternateIdentifierExternalIdArgs Empty => new GetGroupAlternateIdentifierExternalIdArgs();
    }
}
