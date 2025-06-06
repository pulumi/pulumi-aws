// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Organizations.Outputs
{

    [OutputType]
    public sealed class GetDelegatedServicesDelegatedServiceResult
    {
        /// <summary>
        /// The date that the account became a delegated administrator for this service.
        /// </summary>
        public readonly string DelegationEnabledDate;
        /// <summary>
        /// The name of an AWS service that can request an operation for the specified service.
        /// </summary>
        public readonly string ServicePrincipal;

        [OutputConstructor]
        private GetDelegatedServicesDelegatedServiceResult(
            string delegationEnabledDate,

            string servicePrincipal)
        {
            DelegationEnabledDate = delegationEnabledDate;
            ServicePrincipal = servicePrincipal;
        }
    }
}
