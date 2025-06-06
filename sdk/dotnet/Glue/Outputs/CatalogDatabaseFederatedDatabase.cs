// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Glue.Outputs
{

    [OutputType]
    public sealed class CatalogDatabaseFederatedDatabase
    {
        /// <summary>
        /// Name of the connection to the external metastore.
        /// </summary>
        public readonly string? ConnectionName;
        /// <summary>
        /// Unique identifier for the federated database.
        /// </summary>
        public readonly string? Identifier;

        [OutputConstructor]
        private CatalogDatabaseFederatedDatabase(
            string? connectionName,

            string? identifier)
        {
            ConnectionName = connectionName;
            Identifier = identifier;
        }
    }
}
