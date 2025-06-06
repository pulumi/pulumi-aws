// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Workspaces.Inputs
{

    public sealed class DirectoryActiveDirectoryConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Fully qualified domain name of the AWS Directory Service directory.
        /// </summary>
        [Input("domainName", required: true)]
        public Input<string> DomainName { get; set; } = null!;

        /// <summary>
        /// ARN of the Secrets Manager secret that contains the credentials for the service account. For more information, see [Service Account Details](https://docs.aws.amazon.com/workspaces/latest/adminguide/pools-service-account-details.html).
        /// </summary>
        [Input("serviceAccountSecretArn", required: true)]
        public Input<string> ServiceAccountSecretArn { get; set; } = null!;

        public DirectoryActiveDirectoryConfigArgs()
        {
        }
        public static new DirectoryActiveDirectoryConfigArgs Empty => new DirectoryActiveDirectoryConfigArgs();
    }
}
