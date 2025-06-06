// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Outputs
{

    [OutputType]
    public sealed class PipeTargetParametersEcsTaskParametersNetworkConfiguration
    {
        /// <summary>
        /// Use this structure to specify the VPC subnets and security groups for the task, and whether a public IP address is to be used. This structure is relevant only for ECS tasks that use the awsvpc network mode. Detailed below.
        /// </summary>
        public readonly Outputs.PipeTargetParametersEcsTaskParametersNetworkConfigurationAwsVpcConfiguration? AwsVpcConfiguration;

        [OutputConstructor]
        private PipeTargetParametersEcsTaskParametersNetworkConfiguration(Outputs.PipeTargetParametersEcsTaskParametersNetworkConfigurationAwsVpcConfiguration? awsVpcConfiguration)
        {
            AwsVpcConfiguration = awsVpcConfiguration;
        }
    }
}
