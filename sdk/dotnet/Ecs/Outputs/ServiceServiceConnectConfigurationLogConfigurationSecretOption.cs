// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Outputs
{

    [OutputType]
    public sealed class ServiceServiceConnectConfigurationLogConfigurationSecretOption
    {
        /// <summary>
        /// Name of the secret.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Secret to expose to the container. The supported values are either the full ARN of the AWS Secrets Manager secret or the full ARN of the parameter in the SSM Parameter Store.
        /// </summary>
        public readonly string ValueFrom;

        [OutputConstructor]
        private ServiceServiceConnectConfigurationLogConfigurationSecretOption(
            string name,

            string valueFrom)
        {
            Name = name;
            ValueFrom = valueFrom;
        }
    }
}
