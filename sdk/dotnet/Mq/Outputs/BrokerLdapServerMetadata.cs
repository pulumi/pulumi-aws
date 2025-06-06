// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Mq.Outputs
{

    [OutputType]
    public sealed class BrokerLdapServerMetadata
    {
        /// <summary>
        /// List of a fully qualified domain name of the LDAP server and an optional failover server.
        /// </summary>
        public readonly ImmutableArray<string> Hosts;
        /// <summary>
        /// Fully qualified name of the directory to search for a user’s groups.
        /// </summary>
        public readonly string? RoleBase;
        /// <summary>
        /// Specifies the LDAP attribute that identifies the group name attribute in the object returned from the group membership query.
        /// </summary>
        public readonly string? RoleName;
        /// <summary>
        /// Search criteria for groups.
        /// </summary>
        public readonly string? RoleSearchMatching;
        /// <summary>
        /// Whether the directory search scope is the entire sub-tree.
        /// </summary>
        public readonly bool? RoleSearchSubtree;
        /// <summary>
        /// Service account password.
        /// </summary>
        public readonly string? ServiceAccountPassword;
        /// <summary>
        /// Service account username.
        /// </summary>
        public readonly string? ServiceAccountUsername;
        /// <summary>
        /// Fully qualified name of the directory where you want to search for users.
        /// </summary>
        public readonly string? UserBase;
        /// <summary>
        /// Specifies the name of the LDAP attribute for the user group membership.
        /// </summary>
        public readonly string? UserRoleName;
        /// <summary>
        /// Search criteria for users.
        /// </summary>
        public readonly string? UserSearchMatching;
        /// <summary>
        /// Whether the directory search scope is the entire sub-tree.
        /// </summary>
        public readonly bool? UserSearchSubtree;

        [OutputConstructor]
        private BrokerLdapServerMetadata(
            ImmutableArray<string> hosts,

            string? roleBase,

            string? roleName,

            string? roleSearchMatching,

            bool? roleSearchSubtree,

            string? serviceAccountPassword,

            string? serviceAccountUsername,

            string? userBase,

            string? userRoleName,

            string? userSearchMatching,

            bool? userSearchSubtree)
        {
            Hosts = hosts;
            RoleBase = roleBase;
            RoleName = roleName;
            RoleSearchMatching = roleSearchMatching;
            RoleSearchSubtree = roleSearchSubtree;
            ServiceAccountPassword = serviceAccountPassword;
            ServiceAccountUsername = serviceAccountUsername;
            UserBase = userBase;
            UserRoleName = userRoleName;
            UserSearchMatching = userSearchMatching;
            UserSearchSubtree = userSearchSubtree;
        }
    }
}
