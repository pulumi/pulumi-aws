// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3Control.Inputs
{

    public sealed class BucketLifecycleConfigurationRuleExpirationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Date the object is to be deleted. Should be in `YYYY-MM-DD` date format, e.g., `2020-09-30`.
        /// </summary>
        [Input("date")]
        public Input<string>? Date { get; set; }

        /// <summary>
        /// Number of days before the object is to be deleted.
        /// </summary>
        [Input("days")]
        public Input<int>? Days { get; set; }

        /// <summary>
        /// Enable to remove a delete marker with no noncurrent versions. Cannot be specified with `date` or `days`.
        /// </summary>
        [Input("expiredObjectDeleteMarker")]
        public Input<bool>? ExpiredObjectDeleteMarker { get; set; }

        public BucketLifecycleConfigurationRuleExpirationGetArgs()
        {
        }
        public static new BucketLifecycleConfigurationRuleExpirationGetArgs Empty => new BucketLifecycleConfigurationRuleExpirationGetArgs();
    }
}
