// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GlobalAccelerator
{
    /// <summary>
    /// Provides a Global Accelerator custom routing endpoint group.
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
    ///     var example = new Aws.GlobalAccelerator.CustomRoutingEndpointGroup("example", new()
    ///     {
    ///         ListenerArn = exampleAwsGlobalacceleratorCustomRoutingListener.Arn,
    ///         DestinationConfigurations = new[]
    ///         {
    ///             new Aws.GlobalAccelerator.Inputs.CustomRoutingEndpointGroupDestinationConfigurationArgs
    ///             {
    ///                 FromPort = 80,
    ///                 ToPort = 8080,
    ///                 Protocols = new[]
    ///                 {
    ///                     "TCP",
    ///                 },
    ///             },
    ///         },
    ///         EndpointConfigurations = new[]
    ///         {
    ///             new Aws.GlobalAccelerator.Inputs.CustomRoutingEndpointGroupEndpointConfigurationArgs
    ///             {
    ///                 EndpointId = exampleAwsSubnet.Id,
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Global Accelerator custom routing endpoint groups using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:globalaccelerator/customRoutingEndpointGroup:CustomRoutingEndpointGroup example arn:aws:globalaccelerator::111111111111:accelerator/xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx/listener/xxxxxxx/endpoint-group/xxxxxxxx
    /// ```
    /// </summary>
    [AwsResourceType("aws:globalaccelerator/customRoutingEndpointGroup:CustomRoutingEndpointGroup")]
    public partial class CustomRoutingEndpointGroup : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the custom routing endpoint group.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        /// </summary>
        [Output("destinationConfigurations")]
        public Output<ImmutableArray<Outputs.CustomRoutingEndpointGroupDestinationConfiguration>> DestinationConfigurations { get; private set; } = null!;

        /// <summary>
        /// The list of endpoint objects. Fields documented below.
        /// </summary>
        [Output("endpointConfigurations")]
        public Output<ImmutableArray<Outputs.CustomRoutingEndpointGroupEndpointConfiguration>> EndpointConfigurations { get; private set; } = null!;

        /// <summary>
        /// The name of the AWS Region where the custom routing endpoint group is located.
        /// </summary>
        [Output("endpointGroupRegion")]
        public Output<string> EndpointGroupRegion { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the custom routing listener.
        /// </summary>
        [Output("listenerArn")]
        public Output<string> ListenerArn { get; private set; } = null!;


        /// <summary>
        /// Create a CustomRoutingEndpointGroup resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public CustomRoutingEndpointGroup(string name, CustomRoutingEndpointGroupArgs args, CustomResourceOptions? options = null)
            : base("aws:globalaccelerator/customRoutingEndpointGroup:CustomRoutingEndpointGroup", name, args ?? new CustomRoutingEndpointGroupArgs(), MakeResourceOptions(options, ""))
        {
        }

        private CustomRoutingEndpointGroup(string name, Input<string> id, CustomRoutingEndpointGroupState? state = null, CustomResourceOptions? options = null)
            : base("aws:globalaccelerator/customRoutingEndpointGroup:CustomRoutingEndpointGroup", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing CustomRoutingEndpointGroup resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static CustomRoutingEndpointGroup Get(string name, Input<string> id, CustomRoutingEndpointGroupState? state = null, CustomResourceOptions? options = null)
        {
            return new CustomRoutingEndpointGroup(name, id, state, options);
        }
    }

    public sealed class CustomRoutingEndpointGroupArgs : global::Pulumi.ResourceArgs
    {
        [Input("destinationConfigurations", required: true)]
        private InputList<Inputs.CustomRoutingEndpointGroupDestinationConfigurationArgs>? _destinationConfigurations;

        /// <summary>
        /// The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        /// </summary>
        public InputList<Inputs.CustomRoutingEndpointGroupDestinationConfigurationArgs> DestinationConfigurations
        {
            get => _destinationConfigurations ?? (_destinationConfigurations = new InputList<Inputs.CustomRoutingEndpointGroupDestinationConfigurationArgs>());
            set => _destinationConfigurations = value;
        }

        [Input("endpointConfigurations")]
        private InputList<Inputs.CustomRoutingEndpointGroupEndpointConfigurationArgs>? _endpointConfigurations;

        /// <summary>
        /// The list of endpoint objects. Fields documented below.
        /// </summary>
        public InputList<Inputs.CustomRoutingEndpointGroupEndpointConfigurationArgs> EndpointConfigurations
        {
            get => _endpointConfigurations ?? (_endpointConfigurations = new InputList<Inputs.CustomRoutingEndpointGroupEndpointConfigurationArgs>());
            set => _endpointConfigurations = value;
        }

        /// <summary>
        /// The name of the AWS Region where the custom routing endpoint group is located.
        /// </summary>
        [Input("endpointGroupRegion")]
        public Input<string>? EndpointGroupRegion { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the custom routing listener.
        /// </summary>
        [Input("listenerArn", required: true)]
        public Input<string> ListenerArn { get; set; } = null!;

        public CustomRoutingEndpointGroupArgs()
        {
        }
        public static new CustomRoutingEndpointGroupArgs Empty => new CustomRoutingEndpointGroupArgs();
    }

    public sealed class CustomRoutingEndpointGroupState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the custom routing endpoint group.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("destinationConfigurations")]
        private InputList<Inputs.CustomRoutingEndpointGroupDestinationConfigurationGetArgs>? _destinationConfigurations;

        /// <summary>
        /// The port ranges and protocols for all endpoints in a custom routing endpoint group to accept client traffic on. Fields documented below.
        /// </summary>
        public InputList<Inputs.CustomRoutingEndpointGroupDestinationConfigurationGetArgs> DestinationConfigurations
        {
            get => _destinationConfigurations ?? (_destinationConfigurations = new InputList<Inputs.CustomRoutingEndpointGroupDestinationConfigurationGetArgs>());
            set => _destinationConfigurations = value;
        }

        [Input("endpointConfigurations")]
        private InputList<Inputs.CustomRoutingEndpointGroupEndpointConfigurationGetArgs>? _endpointConfigurations;

        /// <summary>
        /// The list of endpoint objects. Fields documented below.
        /// </summary>
        public InputList<Inputs.CustomRoutingEndpointGroupEndpointConfigurationGetArgs> EndpointConfigurations
        {
            get => _endpointConfigurations ?? (_endpointConfigurations = new InputList<Inputs.CustomRoutingEndpointGroupEndpointConfigurationGetArgs>());
            set => _endpointConfigurations = value;
        }

        /// <summary>
        /// The name of the AWS Region where the custom routing endpoint group is located.
        /// </summary>
        [Input("endpointGroupRegion")]
        public Input<string>? EndpointGroupRegion { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the custom routing listener.
        /// </summary>
        [Input("listenerArn")]
        public Input<string>? ListenerArn { get; set; }

        public CustomRoutingEndpointGroupState()
        {
        }
        public static new CustomRoutingEndpointGroupState Empty => new CustomRoutingEndpointGroupState();
    }
}
