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
    /// Provides a confirmation of the creation of the specified hosted connection on an interconnect.
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
    ///     var confirmation = new Aws.DirectConnect.ConnectionConfirmation("confirmation", new()
    ///     {
    ///         ConnectionId = "dxcon-ffabc123",
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [AwsResourceType("aws:directconnect/connectionConfirmation:ConnectionConfirmation")]
    public partial class ConnectionConfirmation : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ID of the hosted connection.
        /// </summary>
        [Output("connectionId")]
        public Output<string> ConnectionId { get; private set; } = null!;


        /// <summary>
        /// Create a ConnectionConfirmation resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ConnectionConfirmation(string name, ConnectionConfirmationArgs args, CustomResourceOptions? options = null)
            : base("aws:directconnect/connectionConfirmation:ConnectionConfirmation", name, args ?? new ConnectionConfirmationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ConnectionConfirmation(string name, Input<string> id, ConnectionConfirmationState? state = null, CustomResourceOptions? options = null)
            : base("aws:directconnect/connectionConfirmation:ConnectionConfirmation", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ConnectionConfirmation resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ConnectionConfirmation Get(string name, Input<string> id, ConnectionConfirmationState? state = null, CustomResourceOptions? options = null)
        {
            return new ConnectionConfirmation(name, id, state, options);
        }
    }

    public sealed class ConnectionConfirmationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the hosted connection.
        /// </summary>
        [Input("connectionId", required: true)]
        public Input<string> ConnectionId { get; set; } = null!;

        public ConnectionConfirmationArgs()
        {
        }
        public static new ConnectionConfirmationArgs Empty => new ConnectionConfirmationArgs();
    }

    public sealed class ConnectionConfirmationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the hosted connection.
        /// </summary>
        [Input("connectionId")]
        public Input<string>? ConnectionId { get; set; }

        public ConnectionConfirmationState()
        {
        }
        public static new ConnectionConfirmationState Empty => new ConnectionConfirmationState();
    }
}
