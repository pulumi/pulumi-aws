// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iam
{
    /// <summary>
    /// Provides an [IAM service-linked role](https://docs.aws.amazon.com/IAM/latest/UserGuide/using-service-linked-roles.html).
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
    ///     var elasticbeanstalk = new Aws.Iam.ServiceLinkedRole("elasticbeanstalk", new()
    ///     {
    ///         AwsServiceName = "elasticbeanstalk.amazonaws.com",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import IAM service-linked roles using role ARN. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:iam/serviceLinkedRole:ServiceLinkedRole elasticbeanstalk arn:aws:iam::123456789012:role/aws-service-role/elasticbeanstalk.amazonaws.com/AWSServiceRoleForElasticBeanstalk
    /// ```
    /// </summary>
    [AwsResourceType("aws:iam/serviceLinkedRole:ServiceLinkedRole")]
    public partial class ServiceLinkedRole : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) specifying the role.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The AWS service to which this role is attached. You use a string similar to a URL but without the `http://` in front. For example: `elasticbeanstalk.amazonaws.com`. To find the full list of services that support service-linked roles, check [the docs](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html).
        /// </summary>
        [Output("awsServiceName")]
        public Output<string> AwsServiceName { get; private set; } = null!;

        /// <summary>
        /// The creation date of the IAM role.
        /// </summary>
        [Output("createDate")]
        public Output<string> CreateDate { get; private set; } = null!;

        /// <summary>
        /// Additional string appended to the role name. Not all AWS services support custom suffixes.
        /// </summary>
        [Output("customSuffix")]
        public Output<string?> CustomSuffix { get; private set; } = null!;

        /// <summary>
        /// The description of the role.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// The name of the role.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// The path of the role.
        /// </summary>
        [Output("path")]
        public Output<string> Path { get; private set; } = null!;

        /// <summary>
        /// Key-value mapping of tags for the IAM role. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// The stable and unique string identifying the role.
        /// </summary>
        [Output("uniqueId")]
        public Output<string> UniqueId { get; private set; } = null!;


        /// <summary>
        /// Create a ServiceLinkedRole resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ServiceLinkedRole(string name, ServiceLinkedRoleArgs args, CustomResourceOptions? options = null)
            : base("aws:iam/serviceLinkedRole:ServiceLinkedRole", name, args ?? new ServiceLinkedRoleArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ServiceLinkedRole(string name, Input<string> id, ServiceLinkedRoleState? state = null, CustomResourceOptions? options = null)
            : base("aws:iam/serviceLinkedRole:ServiceLinkedRole", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ServiceLinkedRole resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ServiceLinkedRole Get(string name, Input<string> id, ServiceLinkedRoleState? state = null, CustomResourceOptions? options = null)
        {
            return new ServiceLinkedRole(name, id, state, options);
        }
    }

    public sealed class ServiceLinkedRoleArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The AWS service to which this role is attached. You use a string similar to a URL but without the `http://` in front. For example: `elasticbeanstalk.amazonaws.com`. To find the full list of services that support service-linked roles, check [the docs](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html).
        /// </summary>
        [Input("awsServiceName", required: true)]
        public Input<string> AwsServiceName { get; set; } = null!;

        /// <summary>
        /// Additional string appended to the role name. Not all AWS services support custom suffixes.
        /// </summary>
        [Input("customSuffix")]
        public Input<string>? CustomSuffix { get; set; }

        /// <summary>
        /// The description of the role.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of tags for the IAM role. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public ServiceLinkedRoleArgs()
        {
        }
        public static new ServiceLinkedRoleArgs Empty => new ServiceLinkedRoleArgs();
    }

    public sealed class ServiceLinkedRoleState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) specifying the role.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The AWS service to which this role is attached. You use a string similar to a URL but without the `http://` in front. For example: `elasticbeanstalk.amazonaws.com`. To find the full list of services that support service-linked roles, check [the docs](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_aws-services-that-work-with-iam.html).
        /// </summary>
        [Input("awsServiceName")]
        public Input<string>? AwsServiceName { get; set; }

        /// <summary>
        /// The creation date of the IAM role.
        /// </summary>
        [Input("createDate")]
        public Input<string>? CreateDate { get; set; }

        /// <summary>
        /// Additional string appended to the role name. Not all AWS services support custom suffixes.
        /// </summary>
        [Input("customSuffix")]
        public Input<string>? CustomSuffix { get; set; }

        /// <summary>
        /// The description of the role.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The name of the role.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The path of the role.
        /// </summary>
        [Input("path")]
        public Input<string>? Path { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of tags for the IAM role. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        /// <summary>
        /// The stable and unique string identifying the role.
        /// </summary>
        [Input("uniqueId")]
        public Input<string>? UniqueId { get; set; }

        public ServiceLinkedRoleState()
        {
        }
        public static new ServiceLinkedRoleState Empty => new ServiceLinkedRoleState();
    }
}
