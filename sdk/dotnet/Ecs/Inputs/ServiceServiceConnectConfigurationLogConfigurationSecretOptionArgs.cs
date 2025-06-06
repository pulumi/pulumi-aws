// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Inputs
{

    public sealed class ServiceServiceConnectConfigurationLogConfigurationSecretOptionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the secret.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// Secret to expose to the container. The supported values are either the full ARN of the AWS Secrets Manager secret or the full ARN of the parameter in the SSM Parameter Store.
        /// </summary>
        [Input("valueFrom", required: true)]
        public Input<string> ValueFrom { get; set; } = null!;

        public ServiceServiceConnectConfigurationLogConfigurationSecretOptionArgs()
        {
        }
        public static new ServiceServiceConnectConfigurationLogConfigurationSecretOptionArgs Empty => new ServiceServiceConnectConfigurationLogConfigurationSecretOptionArgs();
    }
}
