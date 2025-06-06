// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53.Outputs
{

    [OutputType]
    public sealed class GetTrafficPolicyDocumentRulePrimaryResult
    {
        /// <summary>
        /// References to an endpoint.
        /// </summary>
        public readonly string? EndpointReference;
        /// <summary>
        /// Indicates whether you want Amazon Route 53 to evaluate the health of the endpoint and route traffic only to healthy endpoints.
        /// </summary>
        public readonly bool? EvaluateTargetHealth;
        /// <summary>
        /// If you want to associate a health check with the endpoint or rule.
        /// </summary>
        public readonly string? HealthCheck;
        /// <summary>
        /// References to a rule.
        /// </summary>
        public readonly string? RuleReference;

        [OutputConstructor]
        private GetTrafficPolicyDocumentRulePrimaryResult(
            string? endpointReference,

            bool? evaluateTargetHealth,

            string? healthCheck,

            string? ruleReference)
        {
            EndpointReference = endpointReference;
            EvaluateTargetHealth = evaluateTargetHealth;
            HealthCheck = healthCheck;
            RuleReference = ruleReference;
        }
    }
}
