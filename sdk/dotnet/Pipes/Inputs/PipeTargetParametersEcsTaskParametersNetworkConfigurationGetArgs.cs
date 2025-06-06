// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Inputs
{

    public sealed class PipeTargetParametersEcsTaskParametersNetworkConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Use this structure to specify the VPC subnets and security groups for the task, and whether a public IP address is to be used. This structure is relevant only for ECS tasks that use the awsvpc network mode. Detailed below.
        /// </summary>
        [Input("awsVpcConfiguration")]
        public Input<Inputs.PipeTargetParametersEcsTaskParametersNetworkConfigurationAwsVpcConfigurationGetArgs>? AwsVpcConfiguration { get; set; }

        public PipeTargetParametersEcsTaskParametersNetworkConfigurationGetArgs()
        {
        }
        public static new PipeTargetParametersEcsTaskParametersNetworkConfigurationGetArgs Empty => new PipeTargetParametersEcsTaskParametersNetworkConfigurationGetArgs();
    }
}
