// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.BcmData.Outputs
{

    [OutputType]
    public sealed class ExportExportDataQuery
    {
        /// <summary>
        /// Query statement.
        /// </summary>
        public readonly string QueryStatement;
        /// <summary>
        /// Table configuration.
        /// </summary>
        public readonly ImmutableDictionary<string, ImmutableDictionary<string, string>>? TableConfigurations;

        [OutputConstructor]
        private ExportExportDataQuery(
            string queryStatement,

            ImmutableDictionary<string, ImmutableDictionary<string, string>>? tableConfigurations)
        {
            QueryStatement = queryStatement;
            TableConfigurations = tableConfigurations;
        }
    }
}
