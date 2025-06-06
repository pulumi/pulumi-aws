// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2
{
    public static class GetVpcDhcpOptions
    {
        /// <summary>
        /// Retrieve information about an EC2 DHCP Options configuration.
        /// 
        /// ## Example Usage
        /// 
        /// ### Lookup by DHCP Options ID
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Ec2.GetVpcDhcpOptions.Invoke(new()
        ///     {
        ///         DhcpOptionsId = "dopts-12345678",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### Lookup by Filter
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Ec2.GetVpcDhcpOptions.Invoke(new()
        ///     {
        ///         Filters = new[]
        ///         {
        ///             new Aws.Ec2.Inputs.GetVpcDhcpOptionsFilterInputArgs
        ///             {
        ///                 Name = "key",
        ///                 Values = new[]
        ///                 {
        ///                     "domain-name",
        ///                 },
        ///             },
        ///             new Aws.Ec2.Inputs.GetVpcDhcpOptionsFilterInputArgs
        ///             {
        ///                 Name = "value",
        ///                 Values = new[]
        ///                 {
        ///                     "example.com",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetVpcDhcpOptionsResult> InvokeAsync(GetVpcDhcpOptionsArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetVpcDhcpOptionsResult>("aws:ec2/getVpcDhcpOptions:getVpcDhcpOptions", args ?? new GetVpcDhcpOptionsArgs(), options.WithDefaults());

        /// <summary>
        /// Retrieve information about an EC2 DHCP Options configuration.
        /// 
        /// ## Example Usage
        /// 
        /// ### Lookup by DHCP Options ID
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Ec2.GetVpcDhcpOptions.Invoke(new()
        ///     {
        ///         DhcpOptionsId = "dopts-12345678",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### Lookup by Filter
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Ec2.GetVpcDhcpOptions.Invoke(new()
        ///     {
        ///         Filters = new[]
        ///         {
        ///             new Aws.Ec2.Inputs.GetVpcDhcpOptionsFilterInputArgs
        ///             {
        ///                 Name = "key",
        ///                 Values = new[]
        ///                 {
        ///                     "domain-name",
        ///                 },
        ///             },
        ///             new Aws.Ec2.Inputs.GetVpcDhcpOptionsFilterInputArgs
        ///             {
        ///                 Name = "value",
        ///                 Values = new[]
        ///                 {
        ///                     "example.com",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetVpcDhcpOptionsResult> Invoke(GetVpcDhcpOptionsInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetVpcDhcpOptionsResult>("aws:ec2/getVpcDhcpOptions:getVpcDhcpOptions", args ?? new GetVpcDhcpOptionsInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Retrieve information about an EC2 DHCP Options configuration.
        /// 
        /// ## Example Usage
        /// 
        /// ### Lookup by DHCP Options ID
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Ec2.GetVpcDhcpOptions.Invoke(new()
        ///     {
        ///         DhcpOptionsId = "dopts-12345678",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### Lookup by Filter
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Ec2.GetVpcDhcpOptions.Invoke(new()
        ///     {
        ///         Filters = new[]
        ///         {
        ///             new Aws.Ec2.Inputs.GetVpcDhcpOptionsFilterInputArgs
        ///             {
        ///                 Name = "key",
        ///                 Values = new[]
        ///                 {
        ///                     "domain-name",
        ///                 },
        ///             },
        ///             new Aws.Ec2.Inputs.GetVpcDhcpOptionsFilterInputArgs
        ///             {
        ///                 Name = "value",
        ///                 Values = new[]
        ///                 {
        ///                     "example.com",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetVpcDhcpOptionsResult> Invoke(GetVpcDhcpOptionsInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetVpcDhcpOptionsResult>("aws:ec2/getVpcDhcpOptions:getVpcDhcpOptions", args ?? new GetVpcDhcpOptionsInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetVpcDhcpOptionsArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// EC2 DHCP Options ID.
        /// </summary>
        [Input("dhcpOptionsId")]
        public string? DhcpOptionsId { get; set; }

        [Input("filters")]
        private List<Inputs.GetVpcDhcpOptionsFilterArgs>? _filters;

        /// <summary>
        /// List of custom filters as described below.
        /// </summary>
        public List<Inputs.GetVpcDhcpOptionsFilterArgs> Filters
        {
            get => _filters ?? (_filters = new List<Inputs.GetVpcDhcpOptionsFilterArgs>());
            set => _filters = value;
        }

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Map of tags assigned to the resource.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetVpcDhcpOptionsArgs()
        {
        }
        public static new GetVpcDhcpOptionsArgs Empty => new GetVpcDhcpOptionsArgs();
    }

    public sealed class GetVpcDhcpOptionsInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// EC2 DHCP Options ID.
        /// </summary>
        [Input("dhcpOptionsId")]
        public Input<string>? DhcpOptionsId { get; set; }

        [Input("filters")]
        private InputList<Inputs.GetVpcDhcpOptionsFilterInputArgs>? _filters;

        /// <summary>
        /// List of custom filters as described below.
        /// </summary>
        public InputList<Inputs.GetVpcDhcpOptionsFilterInputArgs> Filters
        {
            get => _filters ?? (_filters = new InputList<Inputs.GetVpcDhcpOptionsFilterInputArgs>());
            set => _filters = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags assigned to the resource.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetVpcDhcpOptionsInvokeArgs()
        {
        }
        public static new GetVpcDhcpOptionsInvokeArgs Empty => new GetVpcDhcpOptionsInvokeArgs();
    }


    [OutputType]
    public sealed class GetVpcDhcpOptionsResult
    {
        /// <summary>
        /// ARN of the DHCP Options Set.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// EC2 DHCP Options ID
        /// </summary>
        public readonly string DhcpOptionsId;
        /// <summary>
        /// Suffix domain name to used when resolving non Fully Qualified Domain NamesE.g., the `search` value in the `/etc/resolv.conf` file.
        /// </summary>
        public readonly string DomainName;
        /// <summary>
        /// List of name servers.
        /// </summary>
        public readonly ImmutableArray<string> DomainNameServers;
        public readonly ImmutableArray<Outputs.GetVpcDhcpOptionsFilterResult> Filters;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// How frequently, in seconds, a running instance with an IPv6 assigned to it goes through DHCPv6 lease renewal.
        /// </summary>
        public readonly string Ipv6AddressPreferredLeaseTime;
        /// <summary>
        /// List of NETBIOS name servers.
        /// </summary>
        public readonly ImmutableArray<string> NetbiosNameServers;
        /// <summary>
        /// NetBIOS node type (1, 2, 4, or 8). For more information about these node types, see [RFC 2132](http://www.ietf.org/rfc/rfc2132.txt).
        /// </summary>
        public readonly string NetbiosNodeType;
        /// <summary>
        /// List of NTP servers.
        /// </summary>
        public readonly ImmutableArray<string> NtpServers;
        /// <summary>
        /// ID of the AWS account that owns the DHCP options set.
        /// </summary>
        public readonly string OwnerId;
        /// <summary>
        /// Map of tags assigned to the resource.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;

        [OutputConstructor]
        private GetVpcDhcpOptionsResult(
            string arn,

            string dhcpOptionsId,

            string domainName,

            ImmutableArray<string> domainNameServers,

            ImmutableArray<Outputs.GetVpcDhcpOptionsFilterResult> filters,

            string id,

            string ipv6AddressPreferredLeaseTime,

            ImmutableArray<string> netbiosNameServers,

            string netbiosNodeType,

            ImmutableArray<string> ntpServers,

            string ownerId,

            ImmutableDictionary<string, string> tags)
        {
            Arn = arn;
            DhcpOptionsId = dhcpOptionsId;
            DomainName = domainName;
            DomainNameServers = domainNameServers;
            Filters = filters;
            Id = id;
            Ipv6AddressPreferredLeaseTime = ipv6AddressPreferredLeaseTime;
            NetbiosNameServers = netbiosNameServers;
            NetbiosNodeType = netbiosNodeType;
            NtpServers = ntpServers;
            OwnerId = ownerId;
            Tags = tags;
        }
    }
}
