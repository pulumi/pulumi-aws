// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LightSail
{
    /// <summary>
    /// Manages public ports for a Lightsail instance. Use this resource to open ports for a specific Amazon Lightsail instance and specify the IP addresses allowed to connect to the instance through the ports and the protocol.
    /// 
    /// &gt; See [What is Amazon Lightsail?](https://lightsail.aws.amazon.com/ls/docs/getting-started/article/what-is-amazon-lightsail) for more information.
    /// 
    /// &gt; **Note:** Lightsail is currently only supported in a limited number of AWS Regions, please see ["Regions and Availability Zones in Amazon Lightsail"](https://lightsail.aws.amazon.com/ls/docs/overview/article/understanding-regions-and-availability-zones-in-amazon-lightsail) for more details.
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
    ///     var available = Aws.GetAvailabilityZones.Invoke(new()
    ///     {
    ///         State = "available",
    ///         Filters = new[]
    ///         {
    ///             new Aws.Inputs.GetAvailabilityZonesFilterInputArgs
    ///             {
    ///                 Name = "opt-in-status",
    ///                 Values = new[]
    ///                 {
    ///                     "opt-in-not-required",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var example = new Aws.LightSail.Instance("example", new()
    ///     {
    ///         Name = "example-instance",
    ///         AvailabilityZone = available.Apply(getAvailabilityZonesResult =&gt; getAvailabilityZonesResult.Names[0]),
    ///         BlueprintId = "amazon_linux_2",
    ///         BundleId = "nano_3_0",
    ///     });
    /// 
    ///     var exampleInstancePublicPorts = new Aws.LightSail.InstancePublicPorts("example", new()
    ///     {
    ///         InstanceName = example.Name,
    ///         PortInfos = new[]
    ///         {
    ///             new Aws.LightSail.Inputs.InstancePublicPortsPortInfoArgs
    ///             {
    ///                 Protocol = "tcp",
    ///                 FromPort = 80,
    ///                 ToPort = 80,
    ///             },
    ///             new Aws.LightSail.Inputs.InstancePublicPortsPortInfoArgs
    ///             {
    ///                 Protocol = "tcp",
    ///                 FromPort = 443,
    ///                 ToPort = 443,
    ///                 Cidrs = new[]
    ///                 {
    ///                     "192.168.1.0/24",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [AwsResourceType("aws:lightsail/instancePublicPorts:InstancePublicPorts")]
    public partial class InstancePublicPorts : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Name of the Lightsail Instance.
        /// </summary>
        [Output("instanceName")]
        public Output<string> InstanceName { get; private set; } = null!;

        /// <summary>
        /// Configuration block with port information. AWS closes all currently open ports that are not included in the `port_info`. See below.
        /// </summary>
        [Output("portInfos")]
        public Output<ImmutableArray<Outputs.InstancePublicPortsPortInfo>> PortInfos { get; private set; } = null!;


        /// <summary>
        /// Create a InstancePublicPorts resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public InstancePublicPorts(string name, InstancePublicPortsArgs args, CustomResourceOptions? options = null)
            : base("aws:lightsail/instancePublicPorts:InstancePublicPorts", name, args ?? new InstancePublicPortsArgs(), MakeResourceOptions(options, ""))
        {
        }

        private InstancePublicPorts(string name, Input<string> id, InstancePublicPortsState? state = null, CustomResourceOptions? options = null)
            : base("aws:lightsail/instancePublicPorts:InstancePublicPorts", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing InstancePublicPorts resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static InstancePublicPorts Get(string name, Input<string> id, InstancePublicPortsState? state = null, CustomResourceOptions? options = null)
        {
            return new InstancePublicPorts(name, id, state, options);
        }
    }

    public sealed class InstancePublicPortsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the Lightsail Instance.
        /// </summary>
        [Input("instanceName", required: true)]
        public Input<string> InstanceName { get; set; } = null!;

        [Input("portInfos", required: true)]
        private InputList<Inputs.InstancePublicPortsPortInfoArgs>? _portInfos;

        /// <summary>
        /// Configuration block with port information. AWS closes all currently open ports that are not included in the `port_info`. See below.
        /// </summary>
        public InputList<Inputs.InstancePublicPortsPortInfoArgs> PortInfos
        {
            get => _portInfos ?? (_portInfos = new InputList<Inputs.InstancePublicPortsPortInfoArgs>());
            set => _portInfos = value;
        }

        public InstancePublicPortsArgs()
        {
        }
        public static new InstancePublicPortsArgs Empty => new InstancePublicPortsArgs();
    }

    public sealed class InstancePublicPortsState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the Lightsail Instance.
        /// </summary>
        [Input("instanceName")]
        public Input<string>? InstanceName { get; set; }

        [Input("portInfos")]
        private InputList<Inputs.InstancePublicPortsPortInfoGetArgs>? _portInfos;

        /// <summary>
        /// Configuration block with port information. AWS closes all currently open ports that are not included in the `port_info`. See below.
        /// </summary>
        public InputList<Inputs.InstancePublicPortsPortInfoGetArgs> PortInfos
        {
            get => _portInfos ?? (_portInfos = new InputList<Inputs.InstancePublicPortsPortInfoGetArgs>());
            set => _portInfos = value;
        }

        public InstancePublicPortsState()
        {
        }
        public static new InstancePublicPortsState Empty => new InstancePublicPortsState();
    }
}
