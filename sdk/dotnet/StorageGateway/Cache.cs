// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.StorageGateway
{
    /// <summary>
    /// Manages an AWS Storage Gateway cache.
    /// 
    /// &gt; **NOTE:** The Storage Gateway API provides no method to remove a cache disk. Destroying this resource does not perform any Storage Gateway actions.
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
    ///     var example = new Aws.StorageGateway.Cache("example", new()
    ///     {
    ///         DiskId = exampleAwsStoragegatewayLocalDisk.Id,
    ///         GatewayArn = exampleAwsStoragegatewayGateway.Arn,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import `aws_storagegateway_cache` using the gateway Amazon Resource Name (ARN) and local disk identifier separated with a colon (`:`). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:storagegateway/cache:Cache example arn:aws:storagegateway:us-east-1:123456789012:gateway/sgw-12345678:pci-0000:03:00.0-scsi-0:0:0:0
    /// ```
    /// </summary>
    [AwsResourceType("aws:storagegateway/cache:Cache")]
    public partial class Cache : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Local disk identifier. For example, `pci-0000:03:00.0-scsi-0:0:0:0`.
        /// </summary>
        [Output("diskId")]
        public Output<string> DiskId { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the gateway.
        /// </summary>
        [Output("gatewayArn")]
        public Output<string> GatewayArn { get; private set; } = null!;


        /// <summary>
        /// Create a Cache resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Cache(string name, CacheArgs args, CustomResourceOptions? options = null)
            : base("aws:storagegateway/cache:Cache", name, args ?? new CacheArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Cache(string name, Input<string> id, CacheState? state = null, CustomResourceOptions? options = null)
            : base("aws:storagegateway/cache:Cache", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Cache resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Cache Get(string name, Input<string> id, CacheState? state = null, CustomResourceOptions? options = null)
        {
            return new Cache(name, id, state, options);
        }
    }

    public sealed class CacheArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Local disk identifier. For example, `pci-0000:03:00.0-scsi-0:0:0:0`.
        /// </summary>
        [Input("diskId", required: true)]
        public Input<string> DiskId { get; set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the gateway.
        /// </summary>
        [Input("gatewayArn", required: true)]
        public Input<string> GatewayArn { get; set; } = null!;

        public CacheArgs()
        {
        }
        public static new CacheArgs Empty => new CacheArgs();
    }

    public sealed class CacheState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Local disk identifier. For example, `pci-0000:03:00.0-scsi-0:0:0:0`.
        /// </summary>
        [Input("diskId")]
        public Input<string>? DiskId { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the gateway.
        /// </summary>
        [Input("gatewayArn")]
        public Input<string>? GatewayArn { get; set; }

        public CacheState()
        {
        }
        public static new CacheState Empty => new CacheState();
    }
}
