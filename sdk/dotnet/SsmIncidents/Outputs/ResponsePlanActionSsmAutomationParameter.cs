// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsmIncidents.Outputs
{

    [OutputType]
    public sealed class ResponsePlanActionSsmAutomationParameter
    {
        /// <summary>
        /// The name of the response plan.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// The values for the associated parameter name.
        /// </summary>
        public readonly ImmutableArray<string> Values;

        [OutputConstructor]
        private ResponsePlanActionSsmAutomationParameter(
            string name,

            ImmutableArray<string> values)
        {
            Name = name;
            Values = values;
        }
    }
}