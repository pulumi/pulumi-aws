// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Keyspaces.Inputs
{

    public sealed class TableEncryptionSpecificationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the customer managed KMS key.
        /// </summary>
        [Input("kmsKeyIdentifier")]
        public Input<string>? KmsKeyIdentifier { get; set; }

        /// <summary>
        /// The encryption option specified for the table. Valid values: `AWS_OWNED_KMS_KEY`, `CUSTOMER_MANAGED_KMS_KEY`. The default value is `AWS_OWNED_KMS_KEY`.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public TableEncryptionSpecificationGetArgs()
        {
        }
        public static new TableEncryptionSpecificationGetArgs Empty => new TableEncryptionSpecificationGetArgs();
    }
}
