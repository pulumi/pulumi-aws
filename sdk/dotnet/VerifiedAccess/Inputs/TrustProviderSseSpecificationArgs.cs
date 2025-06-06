// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedAccess.Inputs
{

    public sealed class TrustProviderSseSpecificationArgs : global::Pulumi.ResourceArgs
    {
        [Input("customerManagedKeyEnabled")]
        public Input<bool>? CustomerManagedKeyEnabled { get; set; }

        [Input("kmsKeyArn")]
        public Input<string>? KmsKeyArn { get; set; }

        public TrustProviderSseSpecificationArgs()
        {
        }
        public static new TrustProviderSseSpecificationArgs Empty => new TrustProviderSseSpecificationArgs();
    }
}
