// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch.Inputs
{

    public sealed class GetLogDataProtectionPolicyDocumentConfigurationCustomDataIdentifierArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the custom data idenfitier
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        /// <summary>
        /// Regular expression to match sensitive data
        /// </summary>
        [Input("regex", required: true)]
        public string Regex { get; set; } = null!;

        public GetLogDataProtectionPolicyDocumentConfigurationCustomDataIdentifierArgs()
        {
        }
        public static new GetLogDataProtectionPolicyDocumentConfigurationCustomDataIdentifierArgs Empty => new GetLogDataProtectionPolicyDocumentConfigurationCustomDataIdentifierArgs();
    }
}
