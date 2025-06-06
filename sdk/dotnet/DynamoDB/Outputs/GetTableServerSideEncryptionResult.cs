// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DynamoDB.Outputs
{

    [OutputType]
    public sealed class GetTableServerSideEncryptionResult
    {
        public readonly bool Enabled;
        public readonly string KmsKeyArn;

        [OutputConstructor]
        private GetTableServerSideEncryptionResult(
            bool enabled,

            string kmsKeyArn)
        {
            Enabled = enabled;
            KmsKeyArn = kmsKeyArn;
        }
    }
}
