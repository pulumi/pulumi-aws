// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ebs
{
    /// <summary>
    /// Resource for managing an EBS (Elastic Block Storage) Fast Snapshot Restore.
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
    ///     var example = new Aws.Ebs.FastSnapshotRestore("example", new()
    ///     {
    ///         AvailabilityZone = "us-west-2a",
    ///         SnapshotId = exampleAwsEbsSnapshot.Id,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import EC2 (Elastic Compute Cloud) EBS Fast Snapshot Restore using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ebs/fastSnapshotRestore:FastSnapshotRestore example us-west-2a,snap-abcdef123456
    /// ```
    /// </summary>
    [AwsResourceType("aws:ebs/fastSnapshotRestore:FastSnapshotRestore")]
    public partial class FastSnapshotRestore : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Availability zone in which to enable fast snapshot restores.
        /// </summary>
        [Output("availabilityZone")]
        public Output<string> AvailabilityZone { get; private set; } = null!;

        /// <summary>
        /// ID of the snapshot.
        /// </summary>
        [Output("snapshotId")]
        public Output<string> SnapshotId { get; private set; } = null!;

        /// <summary>
        /// State of fast snapshot restores. Valid values are `enabling`, `optimizing`, `enabled`, `disabling`, `disabled`.
        /// </summary>
        [Output("state")]
        public Output<string> State { get; private set; } = null!;

        [Output("timeouts")]
        public Output<Outputs.FastSnapshotRestoreTimeouts?> Timeouts { get; private set; } = null!;


        /// <summary>
        /// Create a FastSnapshotRestore resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public FastSnapshotRestore(string name, FastSnapshotRestoreArgs args, CustomResourceOptions? options = null)
            : base("aws:ebs/fastSnapshotRestore:FastSnapshotRestore", name, args ?? new FastSnapshotRestoreArgs(), MakeResourceOptions(options, ""))
        {
        }

        private FastSnapshotRestore(string name, Input<string> id, FastSnapshotRestoreState? state = null, CustomResourceOptions? options = null)
            : base("aws:ebs/fastSnapshotRestore:FastSnapshotRestore", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing FastSnapshotRestore resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static FastSnapshotRestore Get(string name, Input<string> id, FastSnapshotRestoreState? state = null, CustomResourceOptions? options = null)
        {
            return new FastSnapshotRestore(name, id, state, options);
        }
    }

    public sealed class FastSnapshotRestoreArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Availability zone in which to enable fast snapshot restores.
        /// </summary>
        [Input("availabilityZone", required: true)]
        public Input<string> AvailabilityZone { get; set; } = null!;

        /// <summary>
        /// ID of the snapshot.
        /// </summary>
        [Input("snapshotId", required: true)]
        public Input<string> SnapshotId { get; set; } = null!;

        [Input("timeouts")]
        public Input<Inputs.FastSnapshotRestoreTimeoutsArgs>? Timeouts { get; set; }

        public FastSnapshotRestoreArgs()
        {
        }
        public static new FastSnapshotRestoreArgs Empty => new FastSnapshotRestoreArgs();
    }

    public sealed class FastSnapshotRestoreState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Availability zone in which to enable fast snapshot restores.
        /// </summary>
        [Input("availabilityZone")]
        public Input<string>? AvailabilityZone { get; set; }

        /// <summary>
        /// ID of the snapshot.
        /// </summary>
        [Input("snapshotId")]
        public Input<string>? SnapshotId { get; set; }

        /// <summary>
        /// State of fast snapshot restores. Valid values are `enabling`, `optimizing`, `enabled`, `disabling`, `disabled`.
        /// </summary>
        [Input("state")]
        public Input<string>? State { get; set; }

        [Input("timeouts")]
        public Input<Inputs.FastSnapshotRestoreTimeoutsGetArgs>? Timeouts { get; set; }

        public FastSnapshotRestoreState()
        {
        }
        public static new FastSnapshotRestoreState Empty => new FastSnapshotRestoreState();
    }
}
