// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3
{
    /// <summary>
    /// Provides a resource to manage S3 Bucket Ownership Controls. For more information, see the [S3 Developer Guide](https://docs.aws.amazon.com/AmazonS3/latest/dev/about-object-ownership.html).
    /// 
    /// &gt; This resource cannot be used with S3 directory buckets.
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
    ///     var example = new Aws.S3.BucketV2("example", new()
    ///     {
    ///         Bucket = "example",
    ///     });
    /// 
    ///     var exampleBucketOwnershipControls = new Aws.S3.BucketOwnershipControls("example", new()
    ///     {
    ///         Bucket = example.Id,
    ///         Rule = new Aws.S3.Inputs.BucketOwnershipControlsRuleArgs
    ///         {
    ///             ObjectOwnership = "BucketOwnerPreferred",
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import S3 Bucket Ownership Controls using S3 Bucket name. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:s3/bucketOwnershipControls:BucketOwnershipControls example my-bucket
    /// ```
    /// </summary>
    [AwsResourceType("aws:s3/bucketOwnershipControls:BucketOwnershipControls")]
    public partial class BucketOwnershipControls : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Name of the bucket that you want to associate this access point with.
        /// </summary>
        [Output("bucket")]
        public Output<string> Bucket { get; private set; } = null!;

        /// <summary>
        /// Configuration block(s) with Ownership Controls rules. Detailed below.
        /// </summary>
        [Output("rule")]
        public Output<Outputs.BucketOwnershipControlsRule> Rule { get; private set; } = null!;


        /// <summary>
        /// Create a BucketOwnershipControls resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public BucketOwnershipControls(string name, BucketOwnershipControlsArgs args, CustomResourceOptions? options = null)
            : base("aws:s3/bucketOwnershipControls:BucketOwnershipControls", name, args ?? new BucketOwnershipControlsArgs(), MakeResourceOptions(options, ""))
        {
        }

        private BucketOwnershipControls(string name, Input<string> id, BucketOwnershipControlsState? state = null, CustomResourceOptions? options = null)
            : base("aws:s3/bucketOwnershipControls:BucketOwnershipControls", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing BucketOwnershipControls resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static BucketOwnershipControls Get(string name, Input<string> id, BucketOwnershipControlsState? state = null, CustomResourceOptions? options = null)
        {
            return new BucketOwnershipControls(name, id, state, options);
        }
    }

    public sealed class BucketOwnershipControlsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the bucket that you want to associate this access point with.
        /// </summary>
        [Input("bucket", required: true)]
        public Input<string> Bucket { get; set; } = null!;

        /// <summary>
        /// Configuration block(s) with Ownership Controls rules. Detailed below.
        /// </summary>
        [Input("rule", required: true)]
        public Input<Inputs.BucketOwnershipControlsRuleArgs> Rule { get; set; } = null!;

        public BucketOwnershipControlsArgs()
        {
        }
        public static new BucketOwnershipControlsArgs Empty => new BucketOwnershipControlsArgs();
    }

    public sealed class BucketOwnershipControlsState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the bucket that you want to associate this access point with.
        /// </summary>
        [Input("bucket")]
        public Input<string>? Bucket { get; set; }

        /// <summary>
        /// Configuration block(s) with Ownership Controls rules. Detailed below.
        /// </summary>
        [Input("rule")]
        public Input<Inputs.BucketOwnershipControlsRuleGetArgs>? Rule { get; set; }

        public BucketOwnershipControlsState()
        {
        }
        public static new BucketOwnershipControlsState Empty => new BucketOwnershipControlsState();
    }
}
