// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Eks.Outputs
{

    [OutputType]
    public sealed class AccessPolicyAssociationAccessScope
    {
        /// <summary>
        /// The namespaces to which the access scope applies when type is namespace.
        /// </summary>
        public readonly ImmutableArray<string> Namespaces;
        /// <summary>
        /// Valid values are `namespace` or `cluster`.
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private AccessPolicyAssociationAccessScope(
            ImmutableArray<string> namespaces,

            string type)
        {
            Namespaces = namespaces;
            Type = type;
        }
    }
}
