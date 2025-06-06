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
    public sealed class DataSetLogicalTableMapSourceJoinInstructionLeftJoinKeyProperties
    {
        /// <summary>
        /// A value that indicates that a row in a table is uniquely identified by the columns in a join key. This is used by Amazon QuickSight to optimize query performance.
        /// </summary>
        public readonly bool? UniqueKey;

        [OutputConstructor]
        private DataSetLogicalTableMapSourceJoinInstructionLeftJoinKeyProperties(bool? uniqueKey)
        {
            UniqueKey = uniqueKey;
        }
    }
}
