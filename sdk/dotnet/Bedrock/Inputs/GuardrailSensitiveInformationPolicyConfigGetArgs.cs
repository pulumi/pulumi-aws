// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class GuardrailSensitiveInformationPolicyConfigGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("piiEntitiesConfigs")]
        private InputList<Inputs.GuardrailSensitiveInformationPolicyConfigPiiEntitiesConfigGetArgs>? _piiEntitiesConfigs;

        /// <summary>
        /// List of entities. See PII Entities Config for more information.
        /// </summary>
        public InputList<Inputs.GuardrailSensitiveInformationPolicyConfigPiiEntitiesConfigGetArgs> PiiEntitiesConfigs
        {
            get => _piiEntitiesConfigs ?? (_piiEntitiesConfigs = new InputList<Inputs.GuardrailSensitiveInformationPolicyConfigPiiEntitiesConfigGetArgs>());
            set => _piiEntitiesConfigs = value;
        }

        [Input("regexesConfigs")]
        private InputList<Inputs.GuardrailSensitiveInformationPolicyConfigRegexesConfigGetArgs>? _regexesConfigs;

        /// <summary>
        /// List of regex. See Regexes Config for more information.
        /// </summary>
        public InputList<Inputs.GuardrailSensitiveInformationPolicyConfigRegexesConfigGetArgs> RegexesConfigs
        {
            get => _regexesConfigs ?? (_regexesConfigs = new InputList<Inputs.GuardrailSensitiveInformationPolicyConfigRegexesConfigGetArgs>());
            set => _regexesConfigs = value;
        }

        public GuardrailSensitiveInformationPolicyConfigGetArgs()
        {
        }
        public static new GuardrailSensitiveInformationPolicyConfigGetArgs Empty => new GuardrailSensitiveInformationPolicyConfigGetArgs();
    }
}
