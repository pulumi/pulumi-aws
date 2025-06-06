// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cfg.Outputs
{

    [OutputType]
    public sealed class RuleSourceCustomPolicyDetails
    {
        /// <summary>
        /// The boolean expression for enabling debug logging for your Config Custom Policy rule. The default value is `false`.
        /// </summary>
        public readonly bool? EnableDebugLogDelivery;
        /// <summary>
        /// The runtime system for your Config Custom Policy rule. Guard is a policy-as-code language that allows you to write policies that are enforced by Config Custom Policy rules. For more information about Guard, see the [Guard GitHub Repository](https://github.com/aws-cloudformation/cloudformation-guard).
        /// </summary>
        public readonly string PolicyRuntime;
        /// <summary>
        /// The policy definition containing the logic for your Config Custom Policy rule.
        /// </summary>
        public readonly string PolicyText;

        [OutputConstructor]
        private RuleSourceCustomPolicyDetails(
            bool? enableDebugLogDelivery,

            string policyRuntime,

            string policyText)
        {
            EnableDebugLogDelivery = enableDebugLogDelivery;
            PolicyRuntime = policyRuntime;
            PolicyText = policyText;
        }
    }
}
