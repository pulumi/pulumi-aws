// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2ClientVpn.Outputs
{

    [OutputType]
    public sealed class GetEndpointClientRouteEnforcementOptionResult
    {
        public readonly bool Enforced;

        [OutputConstructor]
        private GetEndpointClientRouteEnforcementOptionResult(bool enforced)
        {
            Enforced = enforced;
        }
    }
}
