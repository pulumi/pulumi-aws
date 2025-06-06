// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight
{
    /// <summary>
    /// Resource for managing an AWS QuickSight Folder Membership.
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
    ///     var example = new Aws.Quicksight.FolderMembership("example", new()
    ///     {
    ///         FolderId = exampleAwsQuicksightFolder.FolderId,
    ///         MemberType = "DATASET",
    ///         MemberId = exampleAwsQuicksightDataSet.DataSetId,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import QuickSight Folder Membership using the AWS account ID, folder ID, member type, and member ID separated by commas (`,`). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:quicksight/folderMembership:FolderMembership example 123456789012,example-folder,DATASET,example-dataset
    /// ```
    /// </summary>
    [AwsResourceType("aws:quicksight/folderMembership:FolderMembership")]
    public partial class FolderMembership : global::Pulumi.CustomResource
    {
        /// <summary>
        /// AWS account ID.
        /// </summary>
        [Output("awsAccountId")]
        public Output<string> AwsAccountId { get; private set; } = null!;

        /// <summary>
        /// Identifier for the folder.
        /// </summary>
        [Output("folderId")]
        public Output<string> FolderId { get; private set; } = null!;

        /// <summary>
        /// ID of the asset (the dashboard, analysis, or dataset).
        /// </summary>
        [Output("memberId")]
        public Output<string> MemberId { get; private set; } = null!;

        /// <summary>
        /// Type of the member. Valid values are `ANALYSIS`, `DASHBOARD`, and `DATASET`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("memberType")]
        public Output<string> MemberType { get; private set; } = null!;


        /// <summary>
        /// Create a FolderMembership resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public FolderMembership(string name, FolderMembershipArgs args, CustomResourceOptions? options = null)
            : base("aws:quicksight/folderMembership:FolderMembership", name, args ?? new FolderMembershipArgs(), MakeResourceOptions(options, ""))
        {
        }

        private FolderMembership(string name, Input<string> id, FolderMembershipState? state = null, CustomResourceOptions? options = null)
            : base("aws:quicksight/folderMembership:FolderMembership", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing FolderMembership resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static FolderMembership Get(string name, Input<string> id, FolderMembershipState? state = null, CustomResourceOptions? options = null)
        {
            return new FolderMembership(name, id, state, options);
        }
    }

    public sealed class FolderMembershipArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// AWS account ID.
        /// </summary>
        [Input("awsAccountId")]
        public Input<string>? AwsAccountId { get; set; }

        /// <summary>
        /// Identifier for the folder.
        /// </summary>
        [Input("folderId", required: true)]
        public Input<string> FolderId { get; set; } = null!;

        /// <summary>
        /// ID of the asset (the dashboard, analysis, or dataset).
        /// </summary>
        [Input("memberId", required: true)]
        public Input<string> MemberId { get; set; } = null!;

        /// <summary>
        /// Type of the member. Valid values are `ANALYSIS`, `DASHBOARD`, and `DATASET`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("memberType", required: true)]
        public Input<string> MemberType { get; set; } = null!;

        public FolderMembershipArgs()
        {
        }
        public static new FolderMembershipArgs Empty => new FolderMembershipArgs();
    }

    public sealed class FolderMembershipState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// AWS account ID.
        /// </summary>
        [Input("awsAccountId")]
        public Input<string>? AwsAccountId { get; set; }

        /// <summary>
        /// Identifier for the folder.
        /// </summary>
        [Input("folderId")]
        public Input<string>? FolderId { get; set; }

        /// <summary>
        /// ID of the asset (the dashboard, analysis, or dataset).
        /// </summary>
        [Input("memberId")]
        public Input<string>? MemberId { get; set; }

        /// <summary>
        /// Type of the member. Valid values are `ANALYSIS`, `DASHBOARD`, and `DATASET`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("memberType")]
        public Input<string>? MemberType { get; set; }

        public FolderMembershipState()
        {
        }
        public static new FolderMembershipState Empty => new FolderMembershipState();
    }
}
