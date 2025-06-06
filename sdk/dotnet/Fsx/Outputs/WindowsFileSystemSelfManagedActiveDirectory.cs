// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fsx.Outputs
{

    [OutputType]
    public sealed class WindowsFileSystemSelfManagedActiveDirectory
    {
        /// <summary>
        /// A list of up to two IP addresses of DNS servers or domain controllers in the self-managed AD directory. The IP addresses need to be either in the same VPC CIDR range as the file system or in the private IP version 4 (IPv4) address ranges as specified in [RFC 1918](https://tools.ietf.org/html/rfc1918).
        /// </summary>
        public readonly ImmutableArray<string> DnsIps;
        /// <summary>
        /// The fully qualified domain name of the self-managed AD directory. For example, `corp.example.com`.
        /// </summary>
        public readonly string DomainName;
        /// <summary>
        /// The name of the domain group whose members are granted administrative privileges for the file system. Administrative privileges include taking ownership of files and folders, and setting audit controls (audit ACLs) on files and folders. The group that you specify must already exist in your domain. Defaults to `Domain Admins`.
        /// </summary>
        public readonly string? FileSystemAdministratorsGroup;
        /// <summary>
        /// The fully qualified distinguished name of the organizational unit within your self-managed AD directory that the Windows File Server instance will join. For example, `OU=FSx,DC=yourdomain,DC=corp,DC=com`. Only accepts OU as the direct parent of the file system. If none is provided, the FSx file system is created in the default location of your self-managed AD directory. To learn more, see [RFC 2253](https://tools.ietf.org/html/rfc2253).
        /// </summary>
        public readonly string? OrganizationalUnitDistinguishedName;
        /// <summary>
        /// The password for the service account on your self-managed AD domain that Amazon FSx will use to join to your AD domain.
        /// </summary>
        public readonly string Password;
        /// <summary>
        /// The user name for the service account on your self-managed AD domain that Amazon FSx will use to join to your AD domain.
        /// </summary>
        public readonly string Username;

        [OutputConstructor]
        private WindowsFileSystemSelfManagedActiveDirectory(
            ImmutableArray<string> dnsIps,

            string domainName,

            string? fileSystemAdministratorsGroup,

            string? organizationalUnitDistinguishedName,

            string password,

            string username)
        {
            DnsIps = dnsIps;
            DomainName = domainName;
            FileSystemAdministratorsGroup = fileSystemAdministratorsGroup;
            OrganizationalUnitDistinguishedName = organizationalUnitDistinguishedName;
            Password = password;
            Username = username;
        }
    }
}
