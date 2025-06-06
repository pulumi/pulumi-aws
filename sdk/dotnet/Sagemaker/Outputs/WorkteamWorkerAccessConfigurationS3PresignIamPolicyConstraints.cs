// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Outputs
{

    [OutputType]
    public sealed class WorkteamWorkerAccessConfigurationS3PresignIamPolicyConstraints
    {
        /// <summary>
        /// When SourceIp is Enabled the worker's IP address when a task is rendered in the worker portal is added to the IAM policy as a Condition used to generate the Amazon S3 presigned URL. This IP address is checked by Amazon S3 and must match in order for the Amazon S3 resource to be rendered in the worker portal. Valid values are `Enabled` or `Disabled`
        /// </summary>
        public readonly string? SourceIp;
        /// <summary>
        /// When VpcSourceIp is Enabled the worker's IP address when a task is rendered in private worker portal inside the VPC is added to the IAM policy as a Condition used to generate the Amazon S3 presigned URL. To render the task successfully Amazon S3 checks that the presigned URL is being accessed over an Amazon S3 VPC Endpoint, and that the worker's IP address matches the IP address in the IAM policy. To learn more about configuring private worker portal, see [Use Amazon VPC mode from a private worker portal](https://docs.aws.amazon.com/sagemaker/latest/dg/samurai-vpc-worker-portal.html). Valid values are `Enabled` or `Disabled`
        /// </summary>
        public readonly string? VpcSourceIp;

        [OutputConstructor]
        private WorkteamWorkerAccessConfigurationS3PresignIamPolicyConstraints(
            string? sourceIp,

            string? vpcSourceIp)
        {
            SourceIp = sourceIp;
            VpcSourceIp = vpcSourceIp;
        }
    }
}
