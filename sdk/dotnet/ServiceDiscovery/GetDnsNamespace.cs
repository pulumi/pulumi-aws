// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ServiceDiscovery
{
    public static class GetDnsNamespace
    {
        /// <summary>
        /// Retrieves information about a Service Discovery private or public DNS namespace.
        /// 
        /// ## Example Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var test = Aws.ServiceDiscovery.GetDnsNamespace.Invoke(new()
        ///     {
        ///         Name = "example.service.local",
        ///         Type = "DNS_PRIVATE",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetDnsNamespaceResult> InvokeAsync(GetDnsNamespaceArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetDnsNamespaceResult>("aws:servicediscovery/getDnsNamespace:getDnsNamespace", args ?? new GetDnsNamespaceArgs(), options.WithDefaults());

        /// <summary>
        /// Retrieves information about a Service Discovery private or public DNS namespace.
        /// 
        /// ## Example Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var test = Aws.ServiceDiscovery.GetDnsNamespace.Invoke(new()
        ///     {
        ///         Name = "example.service.local",
        ///         Type = "DNS_PRIVATE",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetDnsNamespaceResult> Invoke(GetDnsNamespaceInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetDnsNamespaceResult>("aws:servicediscovery/getDnsNamespace:getDnsNamespace", args ?? new GetDnsNamespaceInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Retrieves information about a Service Discovery private or public DNS namespace.
        /// 
        /// ## Example Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var test = Aws.ServiceDiscovery.GetDnsNamespace.Invoke(new()
        ///     {
        ///         Name = "example.service.local",
        ///         Type = "DNS_PRIVATE",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetDnsNamespaceResult> Invoke(GetDnsNamespaceInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetDnsNamespaceResult>("aws:servicediscovery/getDnsNamespace:getDnsNamespace", args ?? new GetDnsNamespaceInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetDnsNamespaceArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the namespace.
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Map of tags for the resource.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        /// <summary>
        /// Type of the namespace. Allowed values are `DNS_PUBLIC` or `DNS_PRIVATE`.
        /// </summary>
        [Input("type", required: true)]
        public string Type { get; set; } = null!;

        public GetDnsNamespaceArgs()
        {
        }
        public static new GetDnsNamespaceArgs Empty => new GetDnsNamespaceArgs();
    }

    public sealed class GetDnsNamespaceInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the namespace.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags for the resource.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// Type of the namespace. Allowed values are `DNS_PUBLIC` or `DNS_PRIVATE`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public GetDnsNamespaceInvokeArgs()
        {
        }
        public static new GetDnsNamespaceInvokeArgs Empty => new GetDnsNamespaceInvokeArgs();
    }


    [OutputType]
    public sealed class GetDnsNamespaceResult
    {
        /// <summary>
        /// ARN of the namespace.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Description of the namespace.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// ID for the hosted zone that Amazon Route 53 creates when you create a namespace.
        /// </summary>
        public readonly string HostedZone;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string Name;
        /// <summary>
        /// Map of tags for the resource.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;
        public readonly string Type;

        [OutputConstructor]
        private GetDnsNamespaceResult(
            string arn,

            string description,

            string hostedZone,

            string id,

            string name,

            ImmutableDictionary<string, string> tags,

            string type)
        {
            Arn = arn;
            Description = description;
            HostedZone = hostedZone;
            Id = id;
            Name = name;
            Tags = tags;
            Type = type;
        }
    }
}
