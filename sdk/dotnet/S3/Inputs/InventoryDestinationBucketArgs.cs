// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class InventoryDestinationBucketArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ID of the account that owns the destination bucket. Recommended to be set to prevent problems if the destination bucket ownership changes.
        /// </summary>
        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// Amazon S3 bucket ARN of the destination.
        /// </summary>
        [Input("bucketArn", required: true)]
        public Input<string> BucketArn { get; set; } = null!;

        /// <summary>
        /// Contains the type of server-side encryption to use to encrypt the inventory (documented below).
        /// </summary>
        [Input("encryption")]
        public Input<Inputs.InventoryDestinationBucketEncryptionArgs>? Encryption { get; set; }

        /// <summary>
        /// Specifies the output format of the inventory results. Can be `CSV`, [`ORC`](https://orc.apache.org/) or [`Parquet`](https://parquet.apache.org/).
        /// </summary>
        [Input("format", required: true)]
        public Input<string> Format { get; set; } = null!;

        /// <summary>
        /// Prefix that is prepended to all inventory results.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        public InventoryDestinationBucketArgs()
        {
        }
        public static new InventoryDestinationBucketArgs Empty => new InventoryDestinationBucketArgs();
    }
}
