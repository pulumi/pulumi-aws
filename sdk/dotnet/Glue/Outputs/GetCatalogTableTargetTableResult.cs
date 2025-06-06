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
    public sealed class GetCatalogTableTargetTableResult
    {
        /// <summary>
        /// ID of the Glue Catalog and database where the table metadata resides. If omitted, this defaults to the current AWS Account ID.
        /// </summary>
        public readonly string CatalogId;
        /// <summary>
        /// Name of the metadata database where the table metadata resides.
        /// </summary>
        public readonly string DatabaseName;
        /// <summary>
        /// Name of the table.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Region of the target table.
        /// </summary>
        public readonly string Region;

        [OutputConstructor]
        private GetCatalogTableTargetTableResult(
            string catalogId,

            string databaseName,

            string name,

            string region)
        {
            CatalogId = catalogId;
            DatabaseName = databaseName;
            Name = name;
            Region = region;
        }
    }
}
