// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppRunner.Outputs
{

    [OutputType]
    public sealed class ServiceNetworkConfigurationEgressConfiguration
    {
        /// <summary>
        /// The type of egress configuration. Valid values are: `DEFAULT` and `VPC`.
        /// </summary>
        public readonly string? EgressType;
        /// <summary>
        /// The Amazon Resource Name (ARN) of the App Runner VPC connector that you want to associate with your App Runner service. Only valid when `EgressType = VPC`.
        /// </summary>
        public readonly string? VpcConnectorArn;

        [OutputConstructor]
        private ServiceNetworkConfigurationEgressConfiguration(
            string? egressType,

            string? vpcConnectorArn)
        {
            EgressType = egressType;
            VpcConnectorArn = vpcConnectorArn;
        }
    }
}
