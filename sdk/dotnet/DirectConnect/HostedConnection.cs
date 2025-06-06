// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DirectConnect
{
    /// <summary>
    /// Provides a hosted connection on the specified interconnect or a link aggregation group (LAG) of interconnects. Intended for use by AWS Direct Connect Partners only.
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
    ///     var hosted = new Aws.DirectConnect.HostedConnection("hosted", new()
    ///     {
    ///         ConnectionId = "dxcon-ffabc123",
    ///         Bandwidth = "100Mbps",
    ///         Name = "tf-dx-hosted-connection",
    ///         OwnerAccountId = "123456789012",
    ///         Vlan = 1,
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [AwsResourceType("aws:directconnect/hostedConnection:HostedConnection")]
    public partial class HostedConnection : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Direct Connect endpoint on which the physical connection terminates.
        /// </summary>
        [Output("awsDevice")]
        public Output<string> AwsDevice { get; private set; } = null!;

        /// <summary>
        /// The bandwidth of the connection. Valid values for dedicated connections: 1Gbps, 10Gbps. Valid values for hosted connections: 50Mbps, 100Mbps, 200Mbps, 300Mbps, 400Mbps, 500Mbps, 1Gbps, 2Gbps, 5Gbps, 10Gbps, and 25Gbps. Case sensitive. Refer to the AWS Direct Connection supported bandwidths for [Hosted Connections](https://docs.aws.amazon.com/directconnect/latest/UserGuide/hosted_connection.html).
        /// </summary>
        [Output("bandwidth")]
        public Output<string> Bandwidth { get; private set; } = null!;

        /// <summary>
        /// The ID of the interconnect or LAG.
        /// </summary>
        [Output("connectionId")]
        public Output<string> ConnectionId { get; private set; } = null!;

        /// <summary>
        /// Indicates whether the connection supports a secondary BGP peer in the same address family (IPv4/IPv6).
        /// </summary>
        [Output("hasLogicalRedundancy")]
        public Output<string> HasLogicalRedundancy { get; private set; } = null!;

        /// <summary>
        /// Boolean value representing if jumbo frames have been enabled for this connection.
        /// </summary>
        [Output("jumboFrameCapable")]
        public Output<bool> JumboFrameCapable { get; private set; } = null!;

        /// <summary>
        /// The ID of the LAG.
        /// </summary>
        [Output("lagId")]
        public Output<string> LagId { get; private set; } = null!;

        /// <summary>
        /// The time of the most recent call to [DescribeLoa](https://docs.aws.amazon.com/directconnect/latest/APIReference/API_DescribeLoa.html) for this connection.
        /// </summary>
        [Output("loaIssueTime")]
        public Output<string> LoaIssueTime { get; private set; } = null!;

        /// <summary>
        /// The location of the connection.
        /// </summary>
        [Output("location")]
        public Output<string> Location { get; private set; } = null!;

        /// <summary>
        /// The name of the connection.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The ID of the AWS account of the customer for the connection.
        /// </summary>
        [Output("ownerAccountId")]
        public Output<string> OwnerAccountId { get; private set; } = null!;

        /// <summary>
        /// The name of the AWS Direct Connect service provider associated with the connection.
        /// </summary>
        [Output("partnerName")]
        public Output<string> PartnerName { get; private set; } = null!;

        /// <summary>
        /// The name of the service provider associated with the connection.
        /// </summary>
        [Output("providerName")]
        public Output<string> ProviderName { get; private set; } = null!;

        /// <summary>
        /// The AWS Region where the connection is located.
        /// </summary>
        [Output("region")]
        public Output<string> Region { get; private set; } = null!;

        /// <summary>
        /// The state of the connection. Possible values include: ordering, requested, pending, available, down, deleting, deleted, rejected, unknown. See [AllocateHostedConnection](https://docs.aws.amazon.com/directconnect/latest/APIReference/API_AllocateHostedConnection.html) for a description of each connection state.
        /// </summary>
        [Output("state")]
        public Output<string> State { get; private set; } = null!;

        /// <summary>
        /// The dedicated VLAN provisioned to the hosted connection.
        /// </summary>
        [Output("vlan")]
        public Output<int> Vlan { get; private set; } = null!;


        /// <summary>
        /// Create a HostedConnection resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public HostedConnection(string name, HostedConnectionArgs args, CustomResourceOptions? options = null)
            : base("aws:directconnect/hostedConnection:HostedConnection", name, args ?? new HostedConnectionArgs(), MakeResourceOptions(options, ""))
        {
        }

        private HostedConnection(string name, Input<string> id, HostedConnectionState? state = null, CustomResourceOptions? options = null)
            : base("aws:directconnect/hostedConnection:HostedConnection", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing HostedConnection resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static HostedConnection Get(string name, Input<string> id, HostedConnectionState? state = null, CustomResourceOptions? options = null)
        {
            return new HostedConnection(name, id, state, options);
        }
    }

    public sealed class HostedConnectionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The bandwidth of the connection. Valid values for dedicated connections: 1Gbps, 10Gbps. Valid values for hosted connections: 50Mbps, 100Mbps, 200Mbps, 300Mbps, 400Mbps, 500Mbps, 1Gbps, 2Gbps, 5Gbps, 10Gbps, and 25Gbps. Case sensitive. Refer to the AWS Direct Connection supported bandwidths for [Hosted Connections](https://docs.aws.amazon.com/directconnect/latest/UserGuide/hosted_connection.html).
        /// </summary>
        [Input("bandwidth", required: true)]
        public Input<string> Bandwidth { get; set; } = null!;

        /// <summary>
        /// The ID of the interconnect or LAG.
        /// </summary>
        [Input("connectionId", required: true)]
        public Input<string> ConnectionId { get; set; } = null!;

        /// <summary>
        /// The name of the connection.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The ID of the AWS account of the customer for the connection.
        /// </summary>
        [Input("ownerAccountId", required: true)]
        public Input<string> OwnerAccountId { get; set; } = null!;

        /// <summary>
        /// The dedicated VLAN provisioned to the hosted connection.
        /// </summary>
        [Input("vlan", required: true)]
        public Input<int> Vlan { get; set; } = null!;

        public HostedConnectionArgs()
        {
        }
        public static new HostedConnectionArgs Empty => new HostedConnectionArgs();
    }

    public sealed class HostedConnectionState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Direct Connect endpoint on which the physical connection terminates.
        /// </summary>
        [Input("awsDevice")]
        public Input<string>? AwsDevice { get; set; }

        /// <summary>
        /// The bandwidth of the connection. Valid values for dedicated connections: 1Gbps, 10Gbps. Valid values for hosted connections: 50Mbps, 100Mbps, 200Mbps, 300Mbps, 400Mbps, 500Mbps, 1Gbps, 2Gbps, 5Gbps, 10Gbps, and 25Gbps. Case sensitive. Refer to the AWS Direct Connection supported bandwidths for [Hosted Connections](https://docs.aws.amazon.com/directconnect/latest/UserGuide/hosted_connection.html).
        /// </summary>
        [Input("bandwidth")]
        public Input<string>? Bandwidth { get; set; }

        /// <summary>
        /// The ID of the interconnect or LAG.
        /// </summary>
        [Input("connectionId")]
        public Input<string>? ConnectionId { get; set; }

        /// <summary>
        /// Indicates whether the connection supports a secondary BGP peer in the same address family (IPv4/IPv6).
        /// </summary>
        [Input("hasLogicalRedundancy")]
        public Input<string>? HasLogicalRedundancy { get; set; }

        /// <summary>
        /// Boolean value representing if jumbo frames have been enabled for this connection.
        /// </summary>
        [Input("jumboFrameCapable")]
        public Input<bool>? JumboFrameCapable { get; set; }

        /// <summary>
        /// The ID of the LAG.
        /// </summary>
        [Input("lagId")]
        public Input<string>? LagId { get; set; }

        /// <summary>
        /// The time of the most recent call to [DescribeLoa](https://docs.aws.amazon.com/directconnect/latest/APIReference/API_DescribeLoa.html) for this connection.
        /// </summary>
        [Input("loaIssueTime")]
        public Input<string>? LoaIssueTime { get; set; }

        /// <summary>
        /// The location of the connection.
        /// </summary>
        [Input("location")]
        public Input<string>? Location { get; set; }

        /// <summary>
        /// The name of the connection.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The ID of the AWS account of the customer for the connection.
        /// </summary>
        [Input("ownerAccountId")]
        public Input<string>? OwnerAccountId { get; set; }

        /// <summary>
        /// The name of the AWS Direct Connect service provider associated with the connection.
        /// </summary>
        [Input("partnerName")]
        public Input<string>? PartnerName { get; set; }

        /// <summary>
        /// The name of the service provider associated with the connection.
        /// </summary>
        [Input("providerName")]
        public Input<string>? ProviderName { get; set; }

        /// <summary>
        /// The AWS Region where the connection is located.
        /// </summary>
        [Input("region")]
        public Input<string>? Region { get; set; }

        /// <summary>
        /// The state of the connection. Possible values include: ordering, requested, pending, available, down, deleting, deleted, rejected, unknown. See [AllocateHostedConnection](https://docs.aws.amazon.com/directconnect/latest/APIReference/API_AllocateHostedConnection.html) for a description of each connection state.
        /// </summary>
        [Input("state")]
        public Input<string>? State { get; set; }

        /// <summary>
        /// The dedicated VLAN provisioned to the hosted connection.
        /// </summary>
        [Input("vlan")]
        public Input<int>? Vlan { get; set; }

        public HostedConnectionState()
        {
        }
        public static new HostedConnectionState Empty => new HostedConnectionState();
    }
}
