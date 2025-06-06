// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ApiGateway
{
    /// <summary>
    /// Provides an API Gateway API Key.
    /// 
    /// &gt; **NOTE:** Since the API Gateway usage plans feature was launched on August 11, 2016, usage plans are now **required** to associate an API key with an API stage.
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
    ///     var example = new Aws.ApiGateway.ApiKey("example", new()
    ///     {
    ///         Name = "example",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import API Gateway Keys using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:apigateway/apiKey:ApiKey example 8bklk8bl1k3sB38D9B3l0enyWT8c09B30lkq0blk
    /// ```
    /// </summary>
    [AwsResourceType("aws:apigateway/apiKey:ApiKey")]
    public partial class ApiKey : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Creation date of the API key
        /// </summary>
        [Output("createdDate")]
        public Output<string> CreatedDate { get; private set; } = null!;

        /// <summary>
        /// An Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
        /// </summary>
        [Output("customerId")]
        public Output<string?> CustomerId { get; private set; } = null!;

        /// <summary>
        /// API key description. Defaults to "Managed by Pulumi".
        /// </summary>
        [Output("description")]
        public Output<string> Description { get; private set; } = null!;

        /// <summary>
        /// Whether the API key can be used by callers. Defaults to `true`.
        /// </summary>
        [Output("enabled")]
        public Output<bool?> Enabled { get; private set; } = null!;

        /// <summary>
        /// Last update date of the API key
        /// </summary>
        [Output("lastUpdatedDate")]
        public Output<string> LastUpdatedDate { get; private set; } = null!;

        /// <summary>
        /// Name of the API key.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// Value of the API key. If specified, the value must be an alphanumeric string between 20 and 128 characters. If not specified, it will be automatically generated by AWS on creation.
        /// </summary>
        [Output("value")]
        public Output<string> Value { get; private set; } = null!;


        /// <summary>
        /// Create a ApiKey resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ApiKey(string name, ApiKeyArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:apigateway/apiKey:ApiKey", name, args ?? new ApiKeyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ApiKey(string name, Input<string> id, ApiKeyState? state = null, CustomResourceOptions? options = null)
            : base("aws:apigateway/apiKey:ApiKey", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "value",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing ApiKey resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ApiKey Get(string name, Input<string> id, ApiKeyState? state = null, CustomResourceOptions? options = null)
        {
            return new ApiKey(name, id, state, options);
        }
    }

    public sealed class ApiKeyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// An Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
        /// </summary>
        [Input("customerId")]
        public Input<string>? CustomerId { get; set; }

        /// <summary>
        /// API key description. Defaults to "Managed by Pulumi".
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Whether the API key can be used by callers. Defaults to `true`.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        /// <summary>
        /// Name of the API key.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("value")]
        private Input<string>? _value;

        /// <summary>
        /// Value of the API key. If specified, the value must be an alphanumeric string between 20 and 128 characters. If not specified, it will be automatically generated by AWS on creation.
        /// </summary>
        public Input<string>? Value
        {
            get => _value;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _value = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        public ApiKeyArgs()
        {
            Description = "Managed by Pulumi";
        }
        public static new ApiKeyArgs Empty => new ApiKeyArgs();
    }

    public sealed class ApiKeyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Creation date of the API key
        /// </summary>
        [Input("createdDate")]
        public Input<string>? CreatedDate { get; set; }

        /// <summary>
        /// An Amazon Web Services Marketplace customer identifier, when integrating with the Amazon Web Services SaaS Marketplace.
        /// </summary>
        [Input("customerId")]
        public Input<string>? CustomerId { get; set; }

        /// <summary>
        /// API key description. Defaults to "Managed by Pulumi".
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Whether the API key can be used by callers. Defaults to `true`.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        /// <summary>
        /// Last update date of the API key
        /// </summary>
        [Input("lastUpdatedDate")]
        public Input<string>? LastUpdatedDate { get; set; }

        /// <summary>
        /// Name of the API key.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        [Input("value")]
        private Input<string>? _value;

        /// <summary>
        /// Value of the API key. If specified, the value must be an alphanumeric string between 20 and 128 characters. If not specified, it will be automatically generated by AWS on creation.
        /// </summary>
        public Input<string>? Value
        {
            get => _value;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _value = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        public ApiKeyState()
        {
            Description = "Managed by Pulumi";
        }
        public static new ApiKeyState Empty => new ApiKeyState();
    }
}
