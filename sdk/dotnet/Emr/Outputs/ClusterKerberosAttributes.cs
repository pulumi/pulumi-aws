// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Emr.Outputs
{

    [OutputType]
    public sealed class ClusterKerberosAttributes
    {
        /// <summary>
        /// Active Directory password for `ad_domain_join_user`. This provider cannot perform drift detection of this configuration.
        /// </summary>
        public readonly string? AdDomainJoinPassword;
        /// <summary>
        /// Required only when establishing a cross-realm trust with an Active Directory domain. A user with sufficient privileges to join resources to the domain. This provider cannot perform drift detection of this configuration.
        /// </summary>
        public readonly string? AdDomainJoinUser;
        /// <summary>
        /// Required only when establishing a cross-realm trust with a KDC in a different realm. The cross-realm principal password, which must be identical across realms. This provider cannot perform drift detection of this configuration.
        /// </summary>
        public readonly string? CrossRealmTrustPrincipalPassword;
        /// <summary>
        /// Password used within the cluster for the kadmin service on the cluster-dedicated KDC, which maintains Kerberos principals, password policies, and keytabs for the cluster. This provider cannot perform drift detection of this configuration.
        /// </summary>
        public readonly string KdcAdminPassword;
        /// <summary>
        /// Name of the Kerberos realm to which all nodes in a cluster belong. For example, `EC2.INTERNAL`
        /// </summary>
        public readonly string Realm;

        [OutputConstructor]
        private ClusterKerberosAttributes(
            string? adDomainJoinPassword,

            string? adDomainJoinUser,

            string? crossRealmTrustPrincipalPassword,

            string kdcAdminPassword,

            string realm)
        {
            AdDomainJoinPassword = adDomainJoinPassword;
            AdDomainJoinUser = adDomainJoinUser;
            CrossRealmTrustPrincipalPassword = crossRealmTrustPrincipalPassword;
            KdcAdminPassword = kdcAdminPassword;
            Realm = realm;
        }
    }
}
