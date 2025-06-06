// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Backup
{
    /// <summary>
    /// Provides an AWS Backup Report Plan resource.
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
    ///     var example = new Aws.Backup.ReportPlan("example", new()
    ///     {
    ///         Name = "example_name",
    ///         Description = "example description",
    ///         ReportDeliveryChannel = new Aws.Backup.Inputs.ReportPlanReportDeliveryChannelArgs
    ///         {
    ///             Formats = new[]
    ///             {
    ///                 "CSV",
    ///                 "JSON",
    ///             },
    ///             S3BucketName = "example-bucket-name",
    ///         },
    ///         ReportSetting = new Aws.Backup.Inputs.ReportPlanReportSettingArgs
    ///         {
    ///             ReportTemplate = "RESTORE_JOB_REPORT",
    ///         },
    ///         Tags = 
    ///         {
    ///             { "Name", "Example Report Plan" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Backup Report Plan using the `id` which corresponds to the name of the Backup Report Plan. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:backup/reportPlan:ReportPlan test &lt;id&gt;
    /// ```
    /// </summary>
    [AwsResourceType("aws:backup/reportPlan:ReportPlan")]
    public partial class ReportPlan : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN of the backup report plan.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// The date and time that a report plan is created, in Unix format and Coordinated Universal Time (UTC).
        /// </summary>
        [Output("creationTime")]
        public Output<string> CreationTime { get; private set; } = null!;

        /// <summary>
        /// The deployment status of a report plan. The statuses are: `CREATE_IN_PROGRESS` | `UPDATE_IN_PROGRESS` | `DELETE_IN_PROGRESS` | `COMPLETED`.
        /// </summary>
        [Output("deploymentStatus")]
        public Output<string> DeploymentStatus { get; private set; } = null!;

        /// <summary>
        /// The description of the report plan with a maximum of 1,024 characters
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// The unique name of the report plan. The name must be between 1 and 256 characters, starting with a letter, and consisting of letters, numbers, and underscores.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// An object that contains information about where and how to deliver your reports, specifically your Amazon S3 bucket name, S3 key prefix, and the formats of your reports. Detailed below.
        /// </summary>
        [Output("reportDeliveryChannel")]
        public Output<Outputs.ReportPlanReportDeliveryChannel> ReportDeliveryChannel { get; private set; } = null!;

        /// <summary>
        /// An object that identifies the report template for the report. Reports are built using a report template. Detailed below.
        /// </summary>
        [Output("reportSetting")]
        public Output<Outputs.ReportPlanReportSetting> ReportSetting { get; private set; } = null!;

        /// <summary>
        /// Metadata that you can assign to help organize the report plans you create. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a ReportPlan resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ReportPlan(string name, ReportPlanArgs args, CustomResourceOptions? options = null)
            : base("aws:backup/reportPlan:ReportPlan", name, args ?? new ReportPlanArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ReportPlan(string name, Input<string> id, ReportPlanState? state = null, CustomResourceOptions? options = null)
            : base("aws:backup/reportPlan:ReportPlan", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ReportPlan resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ReportPlan Get(string name, Input<string> id, ReportPlanState? state = null, CustomResourceOptions? options = null)
        {
            return new ReportPlan(name, id, state, options);
        }
    }

    public sealed class ReportPlanArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The description of the report plan with a maximum of 1,024 characters
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The unique name of the report plan. The name must be between 1 and 256 characters, starting with a letter, and consisting of letters, numbers, and underscores.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// An object that contains information about where and how to deliver your reports, specifically your Amazon S3 bucket name, S3 key prefix, and the formats of your reports. Detailed below.
        /// </summary>
        [Input("reportDeliveryChannel", required: true)]
        public Input<Inputs.ReportPlanReportDeliveryChannelArgs> ReportDeliveryChannel { get; set; } = null!;

        /// <summary>
        /// An object that identifies the report template for the report. Reports are built using a report template. Detailed below.
        /// </summary>
        [Input("reportSetting", required: true)]
        public Input<Inputs.ReportPlanReportSettingArgs> ReportSetting { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Metadata that you can assign to help organize the report plans you create. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public ReportPlanArgs()
        {
        }
        public static new ReportPlanArgs Empty => new ReportPlanArgs();
    }

    public sealed class ReportPlanState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the backup report plan.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// The date and time that a report plan is created, in Unix format and Coordinated Universal Time (UTC).
        /// </summary>
        [Input("creationTime")]
        public Input<string>? CreationTime { get; set; }

        /// <summary>
        /// The deployment status of a report plan. The statuses are: `CREATE_IN_PROGRESS` | `UPDATE_IN_PROGRESS` | `DELETE_IN_PROGRESS` | `COMPLETED`.
        /// </summary>
        [Input("deploymentStatus")]
        public Input<string>? DeploymentStatus { get; set; }

        /// <summary>
        /// The description of the report plan with a maximum of 1,024 characters
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The unique name of the report plan. The name must be between 1 and 256 characters, starting with a letter, and consisting of letters, numbers, and underscores.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// An object that contains information about where and how to deliver your reports, specifically your Amazon S3 bucket name, S3 key prefix, and the formats of your reports. Detailed below.
        /// </summary>
        [Input("reportDeliveryChannel")]
        public Input<Inputs.ReportPlanReportDeliveryChannelGetArgs>? ReportDeliveryChannel { get; set; }

        /// <summary>
        /// An object that identifies the report template for the report. Reports are built using a report template. Detailed below.
        /// </summary>
        [Input("reportSetting")]
        public Input<Inputs.ReportPlanReportSettingGetArgs>? ReportSetting { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Metadata that you can assign to help organize the report plans you create. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public ReportPlanState()
        {
        }
        public static new ReportPlanState Empty => new ReportPlanState();
    }
}
