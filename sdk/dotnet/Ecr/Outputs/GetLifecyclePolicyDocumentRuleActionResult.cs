// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecr.Outputs
{

    [OutputType]
    public sealed class GetLifecyclePolicyDocumentRuleActionResult
    {
        /// <summary>
        /// The supported value is `expire`.
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private GetLifecyclePolicyDocumentRuleActionResult(string type)
        {
            Type = type;
        }
    }
}
