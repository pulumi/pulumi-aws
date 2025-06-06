// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DirectoryService
{
    /// <summary>
    /// Provides a conditional forwarder for managed Microsoft AD in AWS Directory Service.
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
    ///     var example = new Aws.DirectoryService.ConditionalForwarder("example", new()
    ///     {
    ///         DirectoryId = ad.Id,
    ///         RemoteDomainName = "example.com",
    ///         DnsIps = new[]
    ///         {
    ///             "8.8.8.8",
    ///             "8.8.4.4",
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import conditional forwarders using the directory id and remote_domain_name. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:directoryservice/conditionalForwarder:ConditionalForwarder example d-1234567890:example.com
    /// ```
    /// </summary>
    [AwsResourceType("aws:directoryservice/conditionalForwarder:ConditionalForwarder")]
    public partial class ConditionalForwarder : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ID of directory.
        /// </summary>
        [Output("directoryId")]
        public Output<string> DirectoryId { get; private set; } = null!;

        /// <summary>
        /// A list of forwarder IP addresses.
        /// </summary>
        [Output("dnsIps")]
        public Output<ImmutableArray<string>> DnsIps { get; private set; } = null!;

        /// <summary>
        /// The fully qualified domain name of the remote domain for which forwarders will be used.
        /// </summary>
        [Output("remoteDomainName")]
        public Output<string> RemoteDomainName { get; private set; } = null!;


        /// <summary>
        /// Create a ConditionalForwarder resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ConditionalForwarder(string name, ConditionalForwarderArgs args, CustomResourceOptions? options = null)
            : base("aws:directoryservice/conditionalForwarder:ConditionalForwarder", name, args ?? new ConditionalForwarderArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ConditionalForwarder(string name, Input<string> id, ConditionalForwarderState? state = null, CustomResourceOptions? options = null)
            : base("aws:directoryservice/conditionalForwarder:ConditionalForwarder", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                Aliases =
                {
                    new global::Pulumi.Alias { Type = "aws:directoryservice/conditionalForwader:ConditionalForwader" },
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing ConditionalForwarder resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ConditionalForwarder Get(string name, Input<string> id, ConditionalForwarderState? state = null, CustomResourceOptions? options = null)
        {
            return new ConditionalForwarder(name, id, state, options);
        }
    }

    public sealed class ConditionalForwarderArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ID of directory.
        /// </summary>
        [Input("directoryId", required: true)]
        public Input<string> DirectoryId { get; set; } = null!;

        [Input("dnsIps", required: true)]
        private InputList<string>? _dnsIps;

        /// <summary>
        /// A list of forwarder IP addresses.
        /// </summary>
        public InputList<string> DnsIps
        {
            get => _dnsIps ?? (_dnsIps = new InputList<string>());
            set => _dnsIps = value;
        }

        /// <summary>
        /// The fully qualified domain name of the remote domain for which forwarders will be used.
        /// </summary>
        [Input("remoteDomainName", required: true)]
        public Input<string> RemoteDomainName { get; set; } = null!;

        public ConditionalForwarderArgs()
        {
        }
        public static new ConditionalForwarderArgs Empty => new ConditionalForwarderArgs();
    }

    public sealed class ConditionalForwarderState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ID of directory.
        /// </summary>
        [Input("directoryId")]
        public Input<string>? DirectoryId { get; set; }

        [Input("dnsIps")]
        private InputList<string>? _dnsIps;

        /// <summary>
        /// A list of forwarder IP addresses.
        /// </summary>
        public InputList<string> DnsIps
        {
            get => _dnsIps ?? (_dnsIps = new InputList<string>());
            set => _dnsIps = value;
        }

        /// <summary>
        /// The fully qualified domain name of the remote domain for which forwarders will be used.
        /// </summary>
        [Input("remoteDomainName")]
        public Input<string>? RemoteDomainName { get; set; }

        public ConditionalForwarderState()
        {
        }
        public static new ConditionalForwarderState Empty => new ConditionalForwarderState();
    }
}
