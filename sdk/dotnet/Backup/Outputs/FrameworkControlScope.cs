// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Backup.Outputs
{

    [OutputType]
    public sealed class FrameworkControlScope
    {
        /// <summary>
        /// The ID of the only AWS resource that you want your control scope to contain. Minimum number of 1 item. Maximum number of 100 items.
        /// </summary>
        public readonly ImmutableArray<string> ComplianceResourceIds;
        /// <summary>
        /// Describes whether the control scope includes one or more types of resources, such as EFS or RDS.
        /// </summary>
        public readonly ImmutableArray<string> ComplianceResourceTypes;
        /// <summary>
        /// The tag key-value pair applied to those AWS resources that you want to trigger an evaluation for a rule. A maximum of one key-value pair can be provided.
        /// </summary>
        public readonly ImmutableDictionary<string, string>? Tags;

        [OutputConstructor]
        private FrameworkControlScope(
            ImmutableArray<string> complianceResourceIds,

            ImmutableArray<string> complianceResourceTypes,

            ImmutableDictionary<string, string>? tags)
        {
            ComplianceResourceIds = complianceResourceIds;
            ComplianceResourceTypes = complianceResourceTypes;
            Tags = tags;
        }
    }
}
