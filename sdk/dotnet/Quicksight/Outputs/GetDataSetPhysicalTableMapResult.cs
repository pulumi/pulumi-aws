// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Outputs
{

    [OutputType]
    public sealed class GetDataSetPhysicalTableMapResult
    {
        public readonly ImmutableArray<Outputs.GetDataSetPhysicalTableMapCustomSqlResult> CustomSqls;
        public readonly string PhysicalTableMapId;
        public readonly ImmutableArray<Outputs.GetDataSetPhysicalTableMapRelationalTableResult> RelationalTables;
        public readonly ImmutableArray<Outputs.GetDataSetPhysicalTableMapS3SourceResult> S3Sources;

        [OutputConstructor]
        private GetDataSetPhysicalTableMapResult(
            ImmutableArray<Outputs.GetDataSetPhysicalTableMapCustomSqlResult> customSqls,

            string physicalTableMapId,

            ImmutableArray<Outputs.GetDataSetPhysicalTableMapRelationalTableResult> relationalTables,

            ImmutableArray<Outputs.GetDataSetPhysicalTableMapS3SourceResult> s3Sources)
        {
            CustomSqls = customSqls;
            PhysicalTableMapId = physicalTableMapId;
            RelationalTables = relationalTables;
            S3Sources = s3Sources;
        }
    }
}
