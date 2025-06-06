// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DevOpsGuru
{
    /// <summary>
    /// Resource for managing an AWS DevOps Guru Notification Channel.
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
    ///     var example = new Aws.DevOpsGuru.NotificationChannel("example", new()
    ///     {
    ///         Sns = new Aws.DevOpsGuru.Inputs.NotificationChannelSnsArgs
    ///         {
    ///             TopicArn = exampleAwsSnsTopic.Arn,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Filters
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.DevOpsGuru.NotificationChannel("example", new()
    ///     {
    ///         Sns = new Aws.DevOpsGuru.Inputs.NotificationChannelSnsArgs
    ///         {
    ///             TopicArn = exampleAwsSnsTopic.Arn,
    ///         },
    ///         Filters = new Aws.DevOpsGuru.Inputs.NotificationChannelFiltersArgs
    ///         {
    ///             MessageTypes = new[]
    ///             {
    ///                 "NEW_INSIGHT",
    ///             },
    ///             Severities = new[]
    ///             {
    ///                 "HIGH",
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import DevOps Guru Notification Channel using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:devopsguru/notificationChannel:NotificationChannel example id-12345678
    /// ```
    /// </summary>
    [AwsResourceType("aws:devopsguru/notificationChannel:NotificationChannel")]
    public partial class NotificationChannel : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Filter configurations for the Amazon SNS notification topic. See the `filters` argument reference below.
        /// </summary>
        [Output("filters")]
        public Output<Outputs.NotificationChannelFilters?> Filters { get; private set; } = null!;

        /// <summary>
        /// SNS noficiation channel configurations. See the `sns` argument reference below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("sns")]
        public Output<Outputs.NotificationChannelSns?> Sns { get; private set; } = null!;


        /// <summary>
        /// Create a NotificationChannel resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public NotificationChannel(string name, NotificationChannelArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:devopsguru/notificationChannel:NotificationChannel", name, args ?? new NotificationChannelArgs(), MakeResourceOptions(options, ""))
        {
        }

        private NotificationChannel(string name, Input<string> id, NotificationChannelState? state = null, CustomResourceOptions? options = null)
            : base("aws:devopsguru/notificationChannel:NotificationChannel", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing NotificationChannel resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static NotificationChannel Get(string name, Input<string> id, NotificationChannelState? state = null, CustomResourceOptions? options = null)
        {
            return new NotificationChannel(name, id, state, options);
        }
    }

    public sealed class NotificationChannelArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Filter configurations for the Amazon SNS notification topic. See the `filters` argument reference below.
        /// </summary>
        [Input("filters")]
        public Input<Inputs.NotificationChannelFiltersArgs>? Filters { get; set; }

        /// <summary>
        /// SNS noficiation channel configurations. See the `sns` argument reference below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("sns")]
        public Input<Inputs.NotificationChannelSnsArgs>? Sns { get; set; }

        public NotificationChannelArgs()
        {
        }
        public static new NotificationChannelArgs Empty => new NotificationChannelArgs();
    }

    public sealed class NotificationChannelState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Filter configurations for the Amazon SNS notification topic. See the `filters` argument reference below.
        /// </summary>
        [Input("filters")]
        public Input<Inputs.NotificationChannelFiltersGetArgs>? Filters { get; set; }

        /// <summary>
        /// SNS noficiation channel configurations. See the `sns` argument reference below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("sns")]
        public Input<Inputs.NotificationChannelSnsGetArgs>? Sns { get; set; }

        public NotificationChannelState()
        {
        }
        public static new NotificationChannelState Empty => new NotificationChannelState();
    }
}
