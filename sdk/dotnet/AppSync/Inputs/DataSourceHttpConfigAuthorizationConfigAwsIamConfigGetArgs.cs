// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppSync.Inputs
{

    public sealed class DataSourceHttpConfigAuthorizationConfigAwsIamConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Signing Amazon Web Services Region for IAM authorization.
        /// </summary>
        [Input("signingRegion")]
        public Input<string>? SigningRegion { get; set; }

        /// <summary>
        /// Signing service name for IAM authorization.
        /// </summary>
        [Input("signingServiceName")]
        public Input<string>? SigningServiceName { get; set; }

        public DataSourceHttpConfigAuthorizationConfigAwsIamConfigGetArgs()
        {
        }
        public static new DataSourceHttpConfigAuthorizationConfigAwsIamConfigGetArgs Empty => new DataSourceHttpConfigAuthorizationConfigAwsIamConfigGetArgs();
    }
}
