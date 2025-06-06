// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Outputs
{

    [OutputType]
    public sealed class GetDistributionConfigurationDistributionAmiDistributionConfigurationResult
    {
        /// <summary>
        /// Key-value map of tags to apply to distributed AMI.
        /// </summary>
        public readonly ImmutableDictionary<string, string> AmiTags;
        /// <summary>
        /// Description of the container distribution configuration.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// ARN of Key Management Service (KMS) Key to encrypt AMI.
        /// </summary>
        public readonly string KmsKeyId;
        /// <summary>
        /// Nested list of EC2 launch permissions.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetDistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionResult> LaunchPermissions;
        /// <summary>
        /// Name of the distribution configuration.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Set of target AWS Account identifiers.
        /// </summary>
        public readonly ImmutableArray<string> TargetAccountIds;

        [OutputConstructor]
        private GetDistributionConfigurationDistributionAmiDistributionConfigurationResult(
            ImmutableDictionary<string, string> amiTags,

            string description,

            string kmsKeyId,

            ImmutableArray<Outputs.GetDistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionResult> launchPermissions,

            string name,

            ImmutableArray<string> targetAccountIds)
        {
            AmiTags = amiTags;
            Description = description;
            KmsKeyId = kmsKeyId;
            LaunchPermissions = launchPermissions;
            Name = name;
            TargetAccountIds = targetAccountIds;
        }
    }
}
