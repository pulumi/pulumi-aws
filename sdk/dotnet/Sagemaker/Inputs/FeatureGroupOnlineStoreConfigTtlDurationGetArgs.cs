// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class FeatureGroupOnlineStoreConfigTtlDurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// TtlDuration time unit. Valid values are `Seconds`, `Minutes`, `Hours`, `Days`, or `Weeks`.
        /// </summary>
        [Input("unit")]
        public Input<string>? Unit { get; set; }

        /// <summary>
        /// TtlDuration time value.
        /// </summary>
        [Input("value")]
        public Input<int>? Value { get; set; }

        public FeatureGroupOnlineStoreConfigTtlDurationGetArgs()
        {
        }
        public static new FeatureGroupOnlineStoreConfigTtlDurationGetArgs Empty => new FeatureGroupOnlineStoreConfigTtlDurationGetArgs();
    }
}
