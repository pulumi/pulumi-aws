// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class WorkteamWorkerAccessConfigurationS3PresignGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Use this parameter to specify the allowed request source. Possible sources are either SourceIp or VpcSourceIp. see IAM Policy Constraints details below.
        /// </summary>
        [Input("iamPolicyConstraints")]
        public Input<Inputs.WorkteamWorkerAccessConfigurationS3PresignIamPolicyConstraintsGetArgs>? IamPolicyConstraints { get; set; }

        public WorkteamWorkerAccessConfigurationS3PresignGetArgs()
        {
        }
        public static new WorkteamWorkerAccessConfigurationS3PresignGetArgs Empty => new WorkteamWorkerAccessConfigurationS3PresignGetArgs();
    }
}
