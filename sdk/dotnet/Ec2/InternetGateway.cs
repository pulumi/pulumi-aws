// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2
{
    /// <summary>
    /// Provides a resource to create a VPC Internet Gateway.
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
    ///     var gw = new Aws.Ec2.InternetGateway("gw", new()
    ///     {
    ///         VpcId = main.Id,
    ///         Tags = 
    ///         {
    ///             { "Name", "main" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Internet Gateways using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2/internetGateway:InternetGateway gw igw-c0a643a9
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2/internetGateway:InternetGateway")]
    public partial class InternetGateway : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN of the Internet Gateway.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The ID of the AWS account that owns the internet gateway.
        /// </summary>
        [Output("ownerId")]
        public Output<string> OwnerId { get; private set; } = null!;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// 
        /// &gt; **Note:** It's recommended to denote that the AWS Instance or Elastic IP depends on the Internet Gateway. For example:
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var gw = new Aws.Ec2.InternetGateway("gw", new()
        ///     {
        ///         VpcId = main.Id,
        ///     });
        /// 
        ///     var foo = new Aws.Ec2.Instance("foo", new()
        ///     {
        ///     }, new CustomResourceOptions
        ///     {
        ///         DependsOn =
        ///         {
        ///             gw,
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// The VPC ID to create in.  See the aws.ec2.InternetGatewayAttachment resource for an alternate way to attach an Internet Gateway to a VPC.
        /// </summary>
        [Output("vpcId")]
        public Output<string> VpcId { get; private set; } = null!;


        /// <summary>
        /// Create a InternetGateway resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public InternetGateway(string name, InternetGatewayArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:ec2/internetGateway:InternetGateway", name, args ?? new InternetGatewayArgs(), MakeResourceOptions(options, ""))
        {
        }

        private InternetGateway(string name, Input<string> id, InternetGatewayState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2/internetGateway:InternetGateway", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing InternetGateway resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static InternetGateway Get(string name, Input<string> id, InternetGatewayState? state = null, CustomResourceOptions? options = null)
        {
            return new InternetGateway(name, id, state, options);
        }
    }

    public sealed class InternetGatewayArgs : global::Pulumi.ResourceArgs
    {
        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// 
        /// &gt; **Note:** It's recommended to denote that the AWS Instance or Elastic IP depends on the Internet Gateway. For example:
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var gw = new Aws.Ec2.InternetGateway("gw", new()
        ///     {
        ///         VpcId = main.Id,
        ///     });
        /// 
        ///     var foo = new Aws.Ec2.Instance("foo", new()
        ///     {
        ///     }, new CustomResourceOptions
        ///     {
        ///         DependsOn =
        ///         {
        ///             gw,
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// The VPC ID to create in.  See the aws.ec2.InternetGatewayAttachment resource for an alternate way to attach an Internet Gateway to a VPC.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public InternetGatewayArgs()
        {
        }
        public static new InternetGatewayArgs Empty => new InternetGatewayArgs();
    }

    public sealed class InternetGatewayState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the Internet Gateway.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The ID of the AWS account that owns the internet gateway.
        /// </summary>
        [Input("ownerId")]
        public Input<string>? OwnerId { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// 
        /// &gt; **Note:** It's recommended to denote that the AWS Instance or Elastic IP depends on the Internet Gateway. For example:
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var gw = new Aws.Ec2.InternetGateway("gw", new()
        ///     {
        ///         VpcId = main.Id,
        ///     });
        /// 
        ///     var foo = new Aws.Ec2.Instance("foo", new()
        ///     {
        ///     }, new CustomResourceOptions
        ///     {
        ///         DependsOn =
        ///         {
        ///             gw,
        ///         },
        ///     });
        /// 
        /// });
        /// ```
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
        /// The VPC ID to create in.  See the aws.ec2.InternetGatewayAttachment resource for an alternate way to attach an Internet Gateway to a VPC.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public InternetGatewayState()
        {
        }
        public static new InternetGatewayState Empty => new InternetGatewayState();
    }
}
