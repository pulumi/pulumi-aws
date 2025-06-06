// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3Tables
{
    /// <summary>
    /// Resource for managing an Amazon S3 Tables Table Policy.
    /// 
    /// ## Example Usage
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import S3 Tables Table Policy using the `table_bucket_arn`, the value of `namespace`, and the value of `name`, separated by a semicolon (`;`). For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:s3tables/tablePolicy:TablePolicy example 'arn:aws:s3tables:us-west-2:123456789012:bucket/example-bucket;example-namespace;example-table'
    /// ```
    /// </summary>
    [AwsResourceType("aws:s3tables/tablePolicy:TablePolicy")]
    public partial class TablePolicy : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Name of the table.
        /// Must be between 1 and 255 characters in length.
        /// Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Name of the namespace for this table.
        /// Must be between 1 and 255 characters in length.
        /// Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
        /// </summary>
        [Output("namespace")]
        public Output<string> Namespace { get; private set; } = null!;

        /// <summary>
        /// Amazon Web Services resource-based policy document in JSON format.
        /// </summary>
        [Output("resourcePolicy")]
        public Output<string> ResourcePolicy { get; private set; } = null!;

        /// <summary>
        /// ARN referencing the Table Bucket that contains this Namespace.
        /// </summary>
        [Output("tableBucketArn")]
        public Output<string> TableBucketArn { get; private set; } = null!;


        /// <summary>
        /// Create a TablePolicy resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public TablePolicy(string name, TablePolicyArgs args, CustomResourceOptions? options = null)
            : base("aws:s3tables/tablePolicy:TablePolicy", name, args ?? new TablePolicyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private TablePolicy(string name, Input<string> id, TablePolicyState? state = null, CustomResourceOptions? options = null)
            : base("aws:s3tables/tablePolicy:TablePolicy", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing TablePolicy resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static TablePolicy Get(string name, Input<string> id, TablePolicyState? state = null, CustomResourceOptions? options = null)
        {
            return new TablePolicy(name, id, state, options);
        }
    }

    public sealed class TablePolicyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the table.
        /// Must be between 1 and 255 characters in length.
        /// Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Name of the namespace for this table.
        /// Must be between 1 and 255 characters in length.
        /// Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
        /// </summary>
        [Input("namespace", required: true)]
        public Input<string> Namespace { get; set; } = null!;

        /// <summary>
        /// Amazon Web Services resource-based policy document in JSON format.
        /// </summary>
        [Input("resourcePolicy", required: true)]
        public Input<string> ResourcePolicy { get; set; } = null!;

        /// <summary>
        /// ARN referencing the Table Bucket that contains this Namespace.
        /// </summary>
        [Input("tableBucketArn", required: true)]
        public Input<string> TableBucketArn { get; set; } = null!;

        public TablePolicyArgs()
        {
        }
        public static new TablePolicyArgs Empty => new TablePolicyArgs();
    }

    public sealed class TablePolicyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the table.
        /// Must be between 1 and 255 characters in length.
        /// Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Name of the namespace for this table.
        /// Must be between 1 and 255 characters in length.
        /// Can consist of lowercase letters, numbers, and underscores, and must begin and end with a lowercase letter or number.
        /// </summary>
        [Input("namespace")]
        public Input<string>? Namespace { get; set; }

        /// <summary>
        /// Amazon Web Services resource-based policy document in JSON format.
        /// </summary>
        [Input("resourcePolicy")]
        public Input<string>? ResourcePolicy { get; set; }

        /// <summary>
        /// ARN referencing the Table Bucket that contains this Namespace.
        /// </summary>
        [Input("tableBucketArn")]
        public Input<string>? TableBucketArn { get; set; }

        public TablePolicyState()
        {
        }
        public static new TablePolicyState Empty => new TablePolicyState();
    }
}
