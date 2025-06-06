// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedPermissions.Outputs
{

    [OutputType]
    public sealed class PolicyDefinitionTemplateLinkedPrincipal
    {
        /// <summary>
        /// The entity ID of the principal.
        /// </summary>
        public readonly string EntityId;
        /// <summary>
        /// The entity type of the principal.
        /// </summary>
        public readonly string EntityType;

        [OutputConstructor]
        private PolicyDefinitionTemplateLinkedPrincipal(
            string entityId,

            string entityType)
        {
            EntityId = entityId;
            EntityType = entityType;
        }
    }
}
