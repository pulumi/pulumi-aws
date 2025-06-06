// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CustomerProfiles.Outputs
{

    [OutputType]
    public sealed class DomainMatchingAutoMergingConflictResolution
    {
        /// <summary>
        /// How the auto-merging process should resolve conflicts between different profiles. Valid values are `RECENCY` and `SOURCE`
        /// </summary>
        public readonly string ConflictResolvingModel;
        /// <summary>
        /// The `ObjectType` name that is used to resolve profile merging conflicts when choosing `SOURCE` as the `ConflictResolvingModel`.
        /// </summary>
        public readonly string? SourceName;

        [OutputConstructor]
        private DomainMatchingAutoMergingConflictResolution(
            string conflictResolvingModel,

            string? sourceName)
        {
            ConflictResolvingModel = conflictResolvingModel;
            SourceName = sourceName;
        }
    }
}
