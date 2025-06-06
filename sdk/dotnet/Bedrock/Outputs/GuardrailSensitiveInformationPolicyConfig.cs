// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Outputs
{

    [OutputType]
    public sealed class GuardrailSensitiveInformationPolicyConfig
    {
        /// <summary>
        /// List of entities. See PII Entities Config for more information.
        /// </summary>
        public readonly ImmutableArray<Outputs.GuardrailSensitiveInformationPolicyConfigPiiEntitiesConfig> PiiEntitiesConfigs;
        /// <summary>
        /// List of regex. See Regexes Config for more information.
        /// </summary>
        public readonly ImmutableArray<Outputs.GuardrailSensitiveInformationPolicyConfigRegexesConfig> RegexesConfigs;

        [OutputConstructor]
        private GuardrailSensitiveInformationPolicyConfig(
            ImmutableArray<Outputs.GuardrailSensitiveInformationPolicyConfigPiiEntitiesConfig> piiEntitiesConfigs,

            ImmutableArray<Outputs.GuardrailSensitiveInformationPolicyConfigRegexesConfig> regexesConfigs)
        {
            PiiEntitiesConfigs = piiEntitiesConfigs;
            RegexesConfigs = regexesConfigs;
        }
    }
}
