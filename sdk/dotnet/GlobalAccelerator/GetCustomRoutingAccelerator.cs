// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GlobalAccelerator
{
    public static class GetCustomRoutingAccelerator
    {
        /// <summary>
        /// Provides information about a Global Accelerator custom routing accelerator.
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
        ///     var config = new Config();
        ///     var acceleratorArn = config.Get("acceleratorArn") ?? "";
        ///     var acceleratorName = config.Get("acceleratorName") ?? "";
        ///     var example = Aws.GlobalAccelerator.GetCustomRoutingAccelerator.Invoke(new()
        ///     {
        ///         Arn = acceleratorArn,
        ///         Name = acceleratorName,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetCustomRoutingAcceleratorResult> InvokeAsync(GetCustomRoutingAcceleratorArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetCustomRoutingAcceleratorResult>("aws:globalaccelerator/getCustomRoutingAccelerator:getCustomRoutingAccelerator", args ?? new GetCustomRoutingAcceleratorArgs(), options.WithDefaults());

        /// <summary>
        /// Provides information about a Global Accelerator custom routing accelerator.
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
        ///     var config = new Config();
        ///     var acceleratorArn = config.Get("acceleratorArn") ?? "";
        ///     var acceleratorName = config.Get("acceleratorName") ?? "";
        ///     var example = Aws.GlobalAccelerator.GetCustomRoutingAccelerator.Invoke(new()
        ///     {
        ///         Arn = acceleratorArn,
        ///         Name = acceleratorName,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetCustomRoutingAcceleratorResult> Invoke(GetCustomRoutingAcceleratorInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetCustomRoutingAcceleratorResult>("aws:globalaccelerator/getCustomRoutingAccelerator:getCustomRoutingAccelerator", args ?? new GetCustomRoutingAcceleratorInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Provides information about a Global Accelerator custom routing accelerator.
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
        ///     var config = new Config();
        ///     var acceleratorArn = config.Get("acceleratorArn") ?? "";
        ///     var acceleratorName = config.Get("acceleratorName") ?? "";
        ///     var example = Aws.GlobalAccelerator.GetCustomRoutingAccelerator.Invoke(new()
        ///     {
        ///         Arn = acceleratorArn,
        ///         Name = acceleratorName,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetCustomRoutingAcceleratorResult> Invoke(GetCustomRoutingAcceleratorInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetCustomRoutingAcceleratorResult>("aws:globalaccelerator/getCustomRoutingAccelerator:getCustomRoutingAccelerator", args ?? new GetCustomRoutingAcceleratorInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetCustomRoutingAcceleratorArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Full ARN of the custom routing accelerator.
        /// </summary>
        [Input("arn")]
        public string? Arn { get; set; }

        /// <summary>
        /// Unique name of the custom routing accelerator.
        /// 
        /// &gt; **NOTE:** When both `arn` and `name` are specified, `arn` takes precedence.
        /// </summary>
        [Input("name")]
        public string? Name { get; set; }

        [Input("tags")]
        private Dictionary<string, string>? _tags;
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetCustomRoutingAcceleratorArgs()
        {
        }
        public static new GetCustomRoutingAcceleratorArgs Empty => new GetCustomRoutingAcceleratorArgs();
    }

    public sealed class GetCustomRoutingAcceleratorInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Full ARN of the custom routing accelerator.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Unique name of the custom routing accelerator.
        /// 
        /// &gt; **NOTE:** When both `arn` and `name` are specified, `arn` takes precedence.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetCustomRoutingAcceleratorInvokeArgs()
        {
        }
        public static new GetCustomRoutingAcceleratorInvokeArgs Empty => new GetCustomRoutingAcceleratorInvokeArgs();
    }


    [OutputType]
    public sealed class GetCustomRoutingAcceleratorResult
    {
        public readonly string Arn;
        public readonly ImmutableArray<Outputs.GetCustomRoutingAcceleratorAttributeResult> Attributes;
        public readonly string DnsName;
        public readonly bool Enabled;
        public readonly string HostedZoneId;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string IpAddressType;
        public readonly ImmutableArray<Outputs.GetCustomRoutingAcceleratorIpSetResult> IpSets;
        public readonly string Name;
        public readonly ImmutableDictionary<string, string> Tags;

        [OutputConstructor]
        private GetCustomRoutingAcceleratorResult(
            string arn,

            ImmutableArray<Outputs.GetCustomRoutingAcceleratorAttributeResult> attributes,

            string dnsName,

            bool enabled,

            string hostedZoneId,

            string id,

            string ipAddressType,

            ImmutableArray<Outputs.GetCustomRoutingAcceleratorIpSetResult> ipSets,

            string name,

            ImmutableDictionary<string, string> tags)
        {
            Arn = arn;
            Attributes = attributes;
            DnsName = dnsName;
            Enabled = enabled;
            HostedZoneId = hostedZoneId;
            Id = id;
            IpAddressType = ipAddressType;
            IpSets = ipSets;
            Name = name;
            Tags = tags;
        }
    }
}
