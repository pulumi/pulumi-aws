// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Oam
{
    public static class GetLink
    {
        /// <summary>
        /// Data source for managing an AWS CloudWatch Observability Access Manager Link.
        /// 
        /// ## Example Usage
        /// 
        /// ### Basic Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Oam.GetLink.Invoke(new()
        ///     {
        ///         LinkIdentifier = "arn:aws:oam:us-west-1:111111111111:link/abcd1234-a123-456a-a12b-a123b456c789",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetLinkResult> InvokeAsync(GetLinkArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetLinkResult>("aws:oam/getLink:getLink", args ?? new GetLinkArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS CloudWatch Observability Access Manager Link.
        /// 
        /// ## Example Usage
        /// 
        /// ### Basic Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Oam.GetLink.Invoke(new()
        ///     {
        ///         LinkIdentifier = "arn:aws:oam:us-west-1:111111111111:link/abcd1234-a123-456a-a12b-a123b456c789",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetLinkResult> Invoke(GetLinkInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetLinkResult>("aws:oam/getLink:getLink", args ?? new GetLinkInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS CloudWatch Observability Access Manager Link.
        /// 
        /// ## Example Usage
        /// 
        /// ### Basic Usage
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Oam.GetLink.Invoke(new()
        ///     {
        ///         LinkIdentifier = "arn:aws:oam:us-west-1:111111111111:link/abcd1234-a123-456a-a12b-a123b456c789",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetLinkResult> Invoke(GetLinkInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetLinkResult>("aws:oam/getLink:getLink", args ?? new GetLinkInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetLinkArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ARN of the link.
        /// </summary>
        [Input("linkIdentifier", required: true)]
        public string LinkIdentifier { get; set; } = null!;

        [Input("tags")]
        private Dictionary<string, string>? _tags;
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetLinkArgs()
        {
        }
        public static new GetLinkArgs Empty => new GetLinkArgs();
    }

    public sealed class GetLinkInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ARN of the link.
        /// </summary>
        [Input("linkIdentifier", required: true)]
        public Input<string> LinkIdentifier { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetLinkInvokeArgs()
        {
        }
        public static new GetLinkInvokeArgs Empty => new GetLinkInvokeArgs();
    }


    [OutputType]
    public sealed class GetLinkResult
    {
        /// <summary>
        /// ARN of the link.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Label that is assigned to this link.
        /// </summary>
        public readonly string Label;
        /// <summary>
        /// Human-readable name used to identify this source account when you are viewing data from it in the monitoring account.
        /// </summary>
        public readonly string LabelTemplate;
        /// <summary>
        /// Configuration for creating filters that specify that only some metric namespaces or log groups are to be shared from the source account to the monitoring account. See `link_configuration` Block for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetLinkLinkConfigurationResult> LinkConfigurations;
        /// <summary>
        /// ID string that AWS generated as part of the link ARN.
        /// </summary>
        public readonly string LinkId;
        public readonly string LinkIdentifier;
        /// <summary>
        /// Types of data that the source account shares with the monitoring account.
        /// </summary>
        public readonly ImmutableArray<string> ResourceTypes;
        /// <summary>
        /// ARN of the sink that is used for this link.
        /// </summary>
        public readonly string SinkArn;
        public readonly ImmutableDictionary<string, string> Tags;

        [OutputConstructor]
        private GetLinkResult(
            string arn,

            string id,

            string label,

            string labelTemplate,

            ImmutableArray<Outputs.GetLinkLinkConfigurationResult> linkConfigurations,

            string linkId,

            string linkIdentifier,

            ImmutableArray<string> resourceTypes,

            string sinkArn,

            ImmutableDictionary<string, string> tags)
        {
            Arn = arn;
            Id = id;
            Label = label;
            LabelTemplate = labelTemplate;
            LinkConfigurations = linkConfigurations;
            LinkId = linkId;
            LinkIdentifier = linkIdentifier;
            ResourceTypes = resourceTypes;
            SinkArn = sinkArn;
            Tags = tags;
        }
    }
}
