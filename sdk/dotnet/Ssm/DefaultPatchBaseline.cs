// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ssm
{
    /// <summary>
    /// Resource for registering an AWS Systems Manager Default Patch Baseline.
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
    ///     var examplePatchBaseline = new Aws.Ssm.PatchBaseline("example", new()
    ///     {
    ///         Name = "example",
    ///         ApprovedPatches = new[]
    ///         {
    ///             "KB123456",
    ///         },
    ///     });
    /// 
    ///     var example = new Aws.Ssm.DefaultPatchBaseline("example", new()
    ///     {
    ///         BaselineId = examplePatchBaseline.Id,
    ///         OperatingSystem = examplePatchBaseline.OperatingSystem,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using the patch baseline ARN:
    /// 
    /// Using the operating system value:
    /// 
    /// __Using `pulumi import` to import__ the Systems Manager Default Patch Baseline using the patch baseline ID, patch baseline ARN, or the operating system value. For example:
    /// 
    /// Using the patch baseline ID:
    /// 
    /// ```sh
    /// $ pulumi import aws:ssm/defaultPatchBaseline:DefaultPatchBaseline example pb-1234567890abcdef1
    /// ```
    /// Using the patch baseline ARN:
    /// 
    /// ```sh
    /// $ pulumi import aws:ssm/defaultPatchBaseline:DefaultPatchBaseline example arn:aws:ssm:us-west-2:123456789012:patchbaseline/pb-1234567890abcdef1
    /// ```
    /// Using the operating system value:
    /// 
    /// ```sh
    /// $ pulumi import aws:ssm/defaultPatchBaseline:DefaultPatchBaseline example CENTOS
    /// ```
    /// </summary>
    [AwsResourceType("aws:ssm/defaultPatchBaseline:DefaultPatchBaseline")]
    public partial class DefaultPatchBaseline : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ID of the patch baseline.
        /// Can be an ID or an ARN.
        /// When specifying an AWS-provided patch baseline, must be the ARN.
        /// </summary>
        [Output("baselineId")]
        public Output<string> BaselineId { get; private set; } = null!;

        /// <summary>
        /// The operating system the patch baseline applies to.
        /// Valid values are
        /// `AMAZON_LINUX`,
        /// `AMAZON_LINUX_2`,
        /// `AMAZON_LINUX_2022`,
        /// `CENTOS`,
        /// `DEBIAN`,
        /// `MACOS`,
        /// `ORACLE_LINUX`,
        /// `RASPBIAN`,
        /// `REDHAT_ENTERPRISE_LINUX`,
        /// `ROCKY_LINUX`,
        /// `SUSE`,
        /// `UBUNTU`, and
        /// `WINDOWS`.
        /// </summary>
        [Output("operatingSystem")]
        public Output<string> OperatingSystem { get; private set; } = null!;


        /// <summary>
        /// Create a DefaultPatchBaseline resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public DefaultPatchBaseline(string name, DefaultPatchBaselineArgs args, CustomResourceOptions? options = null)
            : base("aws:ssm/defaultPatchBaseline:DefaultPatchBaseline", name, args ?? new DefaultPatchBaselineArgs(), MakeResourceOptions(options, ""))
        {
        }

        private DefaultPatchBaseline(string name, Input<string> id, DefaultPatchBaselineState? state = null, CustomResourceOptions? options = null)
            : base("aws:ssm/defaultPatchBaseline:DefaultPatchBaseline", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing DefaultPatchBaseline resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static DefaultPatchBaseline Get(string name, Input<string> id, DefaultPatchBaselineState? state = null, CustomResourceOptions? options = null)
        {
            return new DefaultPatchBaseline(name, id, state, options);
        }
    }

    public sealed class DefaultPatchBaselineArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ID of the patch baseline.
        /// Can be an ID or an ARN.
        /// When specifying an AWS-provided patch baseline, must be the ARN.
        /// </summary>
        [Input("baselineId", required: true)]
        public Input<string> BaselineId { get; set; } = null!;

        /// <summary>
        /// The operating system the patch baseline applies to.
        /// Valid values are
        /// `AMAZON_LINUX`,
        /// `AMAZON_LINUX_2`,
        /// `AMAZON_LINUX_2022`,
        /// `CENTOS`,
        /// `DEBIAN`,
        /// `MACOS`,
        /// `ORACLE_LINUX`,
        /// `RASPBIAN`,
        /// `REDHAT_ENTERPRISE_LINUX`,
        /// `ROCKY_LINUX`,
        /// `SUSE`,
        /// `UBUNTU`, and
        /// `WINDOWS`.
        /// </summary>
        [Input("operatingSystem", required: true)]
        public Input<string> OperatingSystem { get; set; } = null!;

        public DefaultPatchBaselineArgs()
        {
        }
        public static new DefaultPatchBaselineArgs Empty => new DefaultPatchBaselineArgs();
    }

    public sealed class DefaultPatchBaselineState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ID of the patch baseline.
        /// Can be an ID or an ARN.
        /// When specifying an AWS-provided patch baseline, must be the ARN.
        /// </summary>
        [Input("baselineId")]
        public Input<string>? BaselineId { get; set; }

        /// <summary>
        /// The operating system the patch baseline applies to.
        /// Valid values are
        /// `AMAZON_LINUX`,
        /// `AMAZON_LINUX_2`,
        /// `AMAZON_LINUX_2022`,
        /// `CENTOS`,
        /// `DEBIAN`,
        /// `MACOS`,
        /// `ORACLE_LINUX`,
        /// `RASPBIAN`,
        /// `REDHAT_ENTERPRISE_LINUX`,
        /// `ROCKY_LINUX`,
        /// `SUSE`,
        /// `UBUNTU`, and
        /// `WINDOWS`.
        /// </summary>
        [Input("operatingSystem")]
        public Input<string>? OperatingSystem { get; set; }

        public DefaultPatchBaselineState()
        {
        }
        public static new DefaultPatchBaselineState Empty => new DefaultPatchBaselineState();
    }
}
