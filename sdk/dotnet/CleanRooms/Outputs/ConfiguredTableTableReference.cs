// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CleanRooms.Outputs
{

    [OutputType]
    public sealed class ConfiguredTableTableReference
    {
        public readonly string DatabaseName;
        public readonly string TableName;

        [OutputConstructor]
        private ConfiguredTableTableReference(
            string databaseName,

            string tableName)
        {
            DatabaseName = databaseName;
            TableName = tableName;
        }
    }
}
