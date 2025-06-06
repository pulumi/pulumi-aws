// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DynamoDB
{
    /// <summary>
    /// Resource for managing an AWS DynamoDB Resource Policy.
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
    ///     var example = new Aws.DynamoDB.ResourcePolicy("example", new()
    ///     {
    ///         ResourceArn = exampleAwsDynamodbTable.Arn,
    ///         Policy = test.Json,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import DynamoDB Resource Policy using the `example_id_arg`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:dynamodb/resourcePolicy:ResourcePolicy example arn:aws:dynamodb:us-east-1:1234567890:table/my-table
    /// ```
    /// </summary>
    [AwsResourceType("aws:dynamodb/resourcePolicy:ResourcePolicy")]
    public partial class ResourcePolicy : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Set this parameter to true to confirm that you want to remove your permissions to change the policy of this resource in the future.
        /// </summary>
        [Output("confirmRemoveSelfResourceAccess")]
        public Output<bool> ConfirmRemoveSelfResourceAccess { get; private set; } = null!;

        /// <summary>
        /// n Amazon Web Services resource-based policy document in JSON format. The maximum size supported for a resource-based policy document is 20 KB. DynamoDB counts whitespaces when calculating the size of a policy against this limit. For a full list of all considerations that you should keep in mind while attaching a resource-based policy, see Resource-based policy considerations.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("policy")]
        public Output<string> Policy { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the DynamoDB resource to which the policy will be attached. The resources you can specify include tables and streams. You can control index permissions using the base table's policy. To specify the same permission level for your table and its indexes, you can provide both the table and index Amazon Resource Name (ARN)s in the Resource field of a given Statement in your policy document. Alternatively, to specify different permissions for your table, indexes, or both, you can define multiple Statement fields in your policy document.
        /// </summary>
        [Output("resourceArn")]
        public Output<string> ResourceArn { get; private set; } = null!;

        /// <summary>
        /// A unique string that represents the revision ID of the policy. If you are comparing revision IDs, make sure to always use string comparison logic.
        /// </summary>
        [Output("revisionId")]
        public Output<string> RevisionId { get; private set; } = null!;


        /// <summary>
        /// Create a ResourcePolicy resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ResourcePolicy(string name, ResourcePolicyArgs args, CustomResourceOptions? options = null)
            : base("aws:dynamodb/resourcePolicy:ResourcePolicy", name, args ?? new ResourcePolicyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ResourcePolicy(string name, Input<string> id, ResourcePolicyState? state = null, CustomResourceOptions? options = null)
            : base("aws:dynamodb/resourcePolicy:ResourcePolicy", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ResourcePolicy resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ResourcePolicy Get(string name, Input<string> id, ResourcePolicyState? state = null, CustomResourceOptions? options = null)
        {
            return new ResourcePolicy(name, id, state, options);
        }
    }

    public sealed class ResourcePolicyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Set this parameter to true to confirm that you want to remove your permissions to change the policy of this resource in the future.
        /// </summary>
        [Input("confirmRemoveSelfResourceAccess")]
        public Input<bool>? ConfirmRemoveSelfResourceAccess { get; set; }

        /// <summary>
        /// n Amazon Web Services resource-based policy document in JSON format. The maximum size supported for a resource-based policy document is 20 KB. DynamoDB counts whitespaces when calculating the size of a policy against this limit. For a full list of all considerations that you should keep in mind while attaching a resource-based policy, see Resource-based policy considerations.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("policy", required: true)]
        public Input<string> Policy { get; set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the DynamoDB resource to which the policy will be attached. The resources you can specify include tables and streams. You can control index permissions using the base table's policy. To specify the same permission level for your table and its indexes, you can provide both the table and index Amazon Resource Name (ARN)s in the Resource field of a given Statement in your policy document. Alternatively, to specify different permissions for your table, indexes, or both, you can define multiple Statement fields in your policy document.
        /// </summary>
        [Input("resourceArn", required: true)]
        public Input<string> ResourceArn { get; set; } = null!;

        public ResourcePolicyArgs()
        {
        }
        public static new ResourcePolicyArgs Empty => new ResourcePolicyArgs();
    }

    public sealed class ResourcePolicyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Set this parameter to true to confirm that you want to remove your permissions to change the policy of this resource in the future.
        /// </summary>
        [Input("confirmRemoveSelfResourceAccess")]
        public Input<bool>? ConfirmRemoveSelfResourceAccess { get; set; }

        /// <summary>
        /// n Amazon Web Services resource-based policy document in JSON format. The maximum size supported for a resource-based policy document is 20 KB. DynamoDB counts whitespaces when calculating the size of a policy against this limit. For a full list of all considerations that you should keep in mind while attaching a resource-based policy, see Resource-based policy considerations.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("policy")]
        public Input<string>? Policy { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the DynamoDB resource to which the policy will be attached. The resources you can specify include tables and streams. You can control index permissions using the base table's policy. To specify the same permission level for your table and its indexes, you can provide both the table and index Amazon Resource Name (ARN)s in the Resource field of a given Statement in your policy document. Alternatively, to specify different permissions for your table, indexes, or both, you can define multiple Statement fields in your policy document.
        /// </summary>
        [Input("resourceArn")]
        public Input<string>? ResourceArn { get; set; }

        /// <summary>
        /// A unique string that represents the revision ID of the policy. If you are comparing revision IDs, make sure to always use string comparison logic.
        /// </summary>
        [Input("revisionId")]
        public Input<string>? RevisionId { get; set; }

        public ResourcePolicyState()
        {
        }
        public static new ResourcePolicyState Empty => new ResourcePolicyState();
    }
}
