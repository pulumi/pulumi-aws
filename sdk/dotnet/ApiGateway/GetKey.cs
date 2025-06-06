// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ApiGateway
{
    public static class GetKey
    {
        /// <summary>
        /// Use this data source to get the name and value of a pre-existing API Key, for
        /// example to supply credentials for a dependency microservice.
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
        ///     var myApiKey = Aws.ApiGateway.GetKey.Invoke(new()
        ///     {
        ///         Id = "ru3mpjgse6",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetKeyResult> InvokeAsync(GetKeyArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetKeyResult>("aws:apigateway/getKey:getKey", args ?? new GetKeyArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get the name and value of a pre-existing API Key, for
        /// example to supply credentials for a dependency microservice.
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
        ///     var myApiKey = Aws.ApiGateway.GetKey.Invoke(new()
        ///     {
        ///         Id = "ru3mpjgse6",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetKeyResult> Invoke(GetKeyInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetKeyResult>("aws:apigateway/getKey:getKey", args ?? new GetKeyInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get the name and value of a pre-existing API Key, for
        /// example to supply credentials for a dependency microservice.
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
        ///     var myApiKey = Aws.ApiGateway.GetKey.Invoke(new()
        ///     {
        ///         Id = "ru3mpjgse6",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetKeyResult> Invoke(GetKeyInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetKeyResult>("aws:apigateway/getKey:getKey", args ?? new GetKeyInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetKeyArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ID of the API Key to look up.
        /// </summary>
        [Input("id", required: true)]
        public string Id { get; set; } = null!;

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

        public GetKeyArgs()
        {
        }
        public static new GetKeyArgs Empty => new GetKeyArgs();
    }

    public sealed class GetKeyInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ID of the API Key to look up.
        /// </summary>
        [Input("id", required: true)]
        public Input<string> Id { get; set; } = null!;

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

        public GetKeyInvokeArgs()
        {
        }
        public static new GetKeyInvokeArgs Empty => new GetKeyInvokeArgs();
    }


    [OutputType]
    public sealed class GetKeyResult
    {
        public readonly string Arn;
        /// <summary>
        /// Date and time when the API Key was created.
        /// </summary>
        public readonly string CreatedDate;
        /// <summary>
        /// Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
        /// </summary>
        public readonly string CustomerId;
        /// <summary>
        /// Description of the API Key.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// Whether the API Key is enabled.
        /// </summary>
        public readonly bool Enabled;
        /// <summary>
        /// Set to the ID of the API Key.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Date and time when the API Key was last updated.
        /// </summary>
        public readonly string LastUpdatedDate;
        /// <summary>
        /// Set to the name of the API Key.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Map of tags for the resource.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;
        /// <summary>
        /// Set to the value of the API Key.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private GetKeyResult(
            string arn,

            string createdDate,

            string customerId,

            string description,

            bool enabled,

            string id,

            string lastUpdatedDate,

            string name,

            ImmutableDictionary<string, string> tags,

            string value)
        {
            Arn = arn;
            CreatedDate = createdDate;
            CustomerId = customerId;
            Description = description;
            Enabled = enabled;
            Id = id;
            LastUpdatedDate = lastUpdatedDate;
            Name = name;
            Tags = tags;
            Value = value;
        }
    }
}
