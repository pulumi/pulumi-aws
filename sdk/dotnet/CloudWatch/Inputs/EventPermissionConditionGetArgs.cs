// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch.Inputs
{

    public sealed class EventPermissionConditionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Key for the condition. Valid values: `aws:PrincipalOrgID`.
        /// </summary>
        [Input("key", required: true)]
        public Input<string> Key { get; set; } = null!;

        /// <summary>
        /// Type of condition. Value values: `StringEquals`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        /// <summary>
        /// Value for the key.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public EventPermissionConditionGetArgs()
        {
        }
        public static new EventPermissionConditionGetArgs Empty => new EventPermissionConditionGetArgs();
    }
}
