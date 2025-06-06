// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront
{
    /// <summary>
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
    ///     var example = new Aws.CloudFront.KeyValueStore("example", new()
    ///     {
    ///         Name = "ExampleKeyValueStore",
    ///         Comment = "This is an example key value store",
    ///     });
    /// 
    ///     var exampleKeyvaluestoreKey = new Aws.CloudFront.KeyvaluestoreKey("example", new()
    ///     {
    ///         KeyValueStoreArn = example.Arn,
    ///         Key = "Test Key",
    ///         Value = "Test Value",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import CloudFront KeyValueStore Key using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:cloudfront/keyvaluestoreKey:KeyvaluestoreKey example arn:aws:cloudfront::111111111111:key-value-store/8562g61f-caba-2845-9d99-b97diwae5d3c,someKey
    /// ```
    /// </summary>
    [AwsResourceType("aws:cloudfront/keyvaluestoreKey:KeyvaluestoreKey")]
    public partial class KeyvaluestoreKey : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Key to put.
        /// </summary>
        [Output("key")]
        public Output<string> Key { get; private set; } = null!;

        /// <summary>
        /// Amazon Resource Name (ARN) of the Key Value Store.
        /// </summary>
        [Output("keyValueStoreArn")]
        public Output<string> KeyValueStoreArn { get; private set; } = null!;

        /// <summary>
        /// Total size of the Key Value Store in bytes.
        /// </summary>
        [Output("totalSizeInBytes")]
        public Output<int> TotalSizeInBytes { get; private set; } = null!;

        /// <summary>
        /// Value to put.
        /// </summary>
        [Output("value")]
        public Output<string> Value { get; private set; } = null!;


        /// <summary>
        /// Create a KeyvaluestoreKey resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public KeyvaluestoreKey(string name, KeyvaluestoreKeyArgs args, CustomResourceOptions? options = null)
            : base("aws:cloudfront/keyvaluestoreKey:KeyvaluestoreKey", name, args ?? new KeyvaluestoreKeyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private KeyvaluestoreKey(string name, Input<string> id, KeyvaluestoreKeyState? state = null, CustomResourceOptions? options = null)
            : base("aws:cloudfront/keyvaluestoreKey:KeyvaluestoreKey", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing KeyvaluestoreKey resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static KeyvaluestoreKey Get(string name, Input<string> id, KeyvaluestoreKeyState? state = null, CustomResourceOptions? options = null)
        {
            return new KeyvaluestoreKey(name, id, state, options);
        }
    }

    public sealed class KeyvaluestoreKeyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Key to put.
        /// </summary>
        [Input("key", required: true)]
        public Input<string> Key { get; set; } = null!;

        /// <summary>
        /// Amazon Resource Name (ARN) of the Key Value Store.
        /// </summary>
        [Input("keyValueStoreArn", required: true)]
        public Input<string> KeyValueStoreArn { get; set; } = null!;

        /// <summary>
        /// Value to put.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public KeyvaluestoreKeyArgs()
        {
        }
        public static new KeyvaluestoreKeyArgs Empty => new KeyvaluestoreKeyArgs();
    }

    public sealed class KeyvaluestoreKeyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Key to put.
        /// </summary>
        [Input("key")]
        public Input<string>? Key { get; set; }

        /// <summary>
        /// Amazon Resource Name (ARN) of the Key Value Store.
        /// </summary>
        [Input("keyValueStoreArn")]
        public Input<string>? KeyValueStoreArn { get; set; }

        /// <summary>
        /// Total size of the Key Value Store in bytes.
        /// </summary>
        [Input("totalSizeInBytes")]
        public Input<int>? TotalSizeInBytes { get; set; }

        /// <summary>
        /// Value to put.
        /// </summary>
        [Input("value")]
        public Input<string>? Value { get; set; }

        public KeyvaluestoreKeyState()
        {
        }
        public static new KeyvaluestoreKeyState Empty => new KeyvaluestoreKeyState();
    }
}
