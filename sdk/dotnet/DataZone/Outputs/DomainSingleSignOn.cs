// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DataZone.Outputs
{

    [OutputType]
    public sealed class DomainSingleSignOn
    {
        public readonly string? Type;
        public readonly string? UserAssignment;

        [OutputConstructor]
        private DomainSingleSignOn(
            string? type,

            string? userAssignment)
        {
            Type = type;
            UserAssignment = userAssignment;
        }
    }
}
