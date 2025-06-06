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
    /// Provides a lightsail resource access to a bucket.
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_lightsail_bucket_resource_access` using the `id` attribute. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:lightsail/bucketResourceAccess:BucketResourceAccess test example-bucket,example-instance
    /// ```
    /// </summary>
    [AwsResourceType("aws:lightsail/bucketResourceAccess:BucketResourceAccess")]
    public partial class BucketResourceAccess : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The name of the bucket to grant access to.
        /// </summary>
        [Output("bucketName")]
        public Output<string> BucketName { get; private set; } = null!;

        /// <summary>
        /// The name of the resource to be granted bucket access.
        /// </summary>
        [Output("resourceName")]
        public Output<string> ResourceName { get; private set; } = null!;


        /// <summary>
        /// Create a BucketResourceAccess resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public BucketResourceAccess(string name, BucketResourceAccessArgs args, CustomResourceOptions? options = null)
            : base("aws:lightsail/bucketResourceAccess:BucketResourceAccess", name, args ?? new BucketResourceAccessArgs(), MakeResourceOptions(options, ""))
        {
        }

        private BucketResourceAccess(string name, Input<string> id, BucketResourceAccessState? state = null, CustomResourceOptions? options = null)
            : base("aws:lightsail/bucketResourceAccess:BucketResourceAccess", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing BucketResourceAccess resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static BucketResourceAccess Get(string name, Input<string> id, BucketResourceAccessState? state = null, CustomResourceOptions? options = null)
        {
            return new BucketResourceAccess(name, id, state, options);
        }
    }

    public sealed class BucketResourceAccessArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the bucket to grant access to.
        /// </summary>
        [Input("bucketName", required: true)]
        public Input<string> BucketName { get; set; } = null!;

        /// <summary>
        /// The name of the resource to be granted bucket access.
        /// </summary>
        [Input("resourceName", required: true)]
        public Input<string> ResourceName { get; set; } = null!;

        public BucketResourceAccessArgs()
        {
        }
        public static new BucketResourceAccessArgs Empty => new BucketResourceAccessArgs();
    }

    public sealed class BucketResourceAccessState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the bucket to grant access to.
        /// </summary>
        [Input("bucketName")]
        public Input<string>? BucketName { get; set; }

        /// <summary>
        /// The name of the resource to be granted bucket access.
        /// </summary>
        [Input("resourceName")]
        public Input<string>? ResourceName { get; set; }

        public BucketResourceAccessState()
        {
        }
        public static new BucketResourceAccessState Empty => new BucketResourceAccessState();
    }
}
