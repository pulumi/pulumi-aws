// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Connect.Outputs
{

    [OutputType]
    public sealed class GetUserHierarchyGroupHierarchyPathLevelTwoResult
    {
        /// <summary>
        /// ARN of the hierarchy group.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// The identifier of the hierarchy group.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Returns information on a specific hierarchy group by name
        /// 
        /// &gt; **NOTE:** `instance_id` and one of either `name` or `hierarchy_group_id` is required.
        /// </summary>
        public readonly string Name;

        [OutputConstructor]
        private GetUserHierarchyGroupHierarchyPathLevelTwoResult(
            string arn,

            string id,

            string name)
        {
            Arn = arn;
            Id = id;
            Name = name;
        }
    }
}
