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
    /// Adds a launch permission to an Amazon Machine Image (AMI).
    /// 
    /// ## Example Usage
    /// 
    /// ### AWS Account ID
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Ec2.AmiLaunchPermission("example", new()
    ///     {
    ///         ImageId = "ami-12345678",
    ///         AccountId = "123456789012",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Public Access
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Ec2.AmiLaunchPermission("example", new()
    ///     {
    ///         ImageId = "ami-12345678",
    ///         Group = "all",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Organization Access
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var current = Aws.Organizations.GetOrganization.Invoke();
    /// 
    ///     var example = new Aws.Ec2.AmiLaunchPermission("example", new()
    ///     {
    ///         ImageId = "ami-12345678",
    ///         OrganizationArn = current.Apply(getOrganizationResult =&gt; getOrganizationResult.Arn),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import AMI Launch Permissions using `[ACCOUNT-ID|GROUP-NAME|ORGANIZATION-ARN|ORGANIZATIONAL-UNIT-ARN]/IMAGE-ID`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2/amiLaunchPermission:AmiLaunchPermission example 123456789012/ami-12345678
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2/amiLaunchPermission:AmiLaunchPermission")]
    public partial class AmiLaunchPermission : global::Pulumi.CustomResource
    {
        /// <summary>
        /// AWS account ID for the launch permission.
        /// </summary>
        [Output("accountId")]
        public Output<string?> AccountId { get; private set; } = null!;

        /// <summary>
        /// Name of the group for the launch permission. Valid values: `"all"`.
        /// </summary>
        [Output("group")]
        public Output<string?> Group { get; private set; } = null!;

        /// <summary>
        /// ID of the AMI.
        /// </summary>
        [Output("imageId")]
        public Output<string> ImageId { get; private set; } = null!;

        /// <summary>
        /// ARN of an organization for the launch permission.
        /// </summary>
        [Output("organizationArn")]
        public Output<string?> OrganizationArn { get; private set; } = null!;

        /// <summary>
        /// ARN of an organizational unit for the launch permission.
        /// </summary>
        [Output("organizationalUnitArn")]
        public Output<string?> OrganizationalUnitArn { get; private set; } = null!;


        /// <summary>
        /// Create a AmiLaunchPermission resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public AmiLaunchPermission(string name, AmiLaunchPermissionArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2/amiLaunchPermission:AmiLaunchPermission", name, args ?? new AmiLaunchPermissionArgs(), MakeResourceOptions(options, ""))
        {
        }

        private AmiLaunchPermission(string name, Input<string> id, AmiLaunchPermissionState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2/amiLaunchPermission:AmiLaunchPermission", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing AmiLaunchPermission resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static AmiLaunchPermission Get(string name, Input<string> id, AmiLaunchPermissionState? state = null, CustomResourceOptions? options = null)
        {
            return new AmiLaunchPermission(name, id, state, options);
        }
    }

    public sealed class AmiLaunchPermissionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// AWS account ID for the launch permission.
        /// </summary>
        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// Name of the group for the launch permission. Valid values: `"all"`.
        /// </summary>
        [Input("group")]
        public Input<string>? Group { get; set; }

        /// <summary>
        /// ID of the AMI.
        /// </summary>
        [Input("imageId", required: true)]
        public Input<string> ImageId { get; set; } = null!;

        /// <summary>
        /// ARN of an organization for the launch permission.
        /// </summary>
        [Input("organizationArn")]
        public Input<string>? OrganizationArn { get; set; }

        /// <summary>
        /// ARN of an organizational unit for the launch permission.
        /// </summary>
        [Input("organizationalUnitArn")]
        public Input<string>? OrganizationalUnitArn { get; set; }

        public AmiLaunchPermissionArgs()
        {
        }
        public static new AmiLaunchPermissionArgs Empty => new AmiLaunchPermissionArgs();
    }

    public sealed class AmiLaunchPermissionState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// AWS account ID for the launch permission.
        /// </summary>
        [Input("accountId")]
        public Input<string>? AccountId { get; set; }

        /// <summary>
        /// Name of the group for the launch permission. Valid values: `"all"`.
        /// </summary>
        [Input("group")]
        public Input<string>? Group { get; set; }

        /// <summary>
        /// ID of the AMI.
        /// </summary>
        [Input("imageId")]
        public Input<string>? ImageId { get; set; }

        /// <summary>
        /// ARN of an organization for the launch permission.
        /// </summary>
        [Input("organizationArn")]
        public Input<string>? OrganizationArn { get; set; }

        /// <summary>
        /// ARN of an organizational unit for the launch permission.
        /// </summary>
        [Input("organizationalUnitArn")]
        public Input<string>? OrganizationalUnitArn { get; set; }

        public AmiLaunchPermissionState()
        {
        }
        public static new AmiLaunchPermissionState Empty => new AmiLaunchPermissionState();
    }
}
