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
    /// Resource for managing an AWS Backup Logically Air Gapped Vault.
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
    ///     var example = new Aws.Backup.LogicallyAirGappedVault("example", new()
    ///     {
    ///         Name = "lag-example-vault",
    ///         MaxRetentionDays = 7,
    ///         MinRetentionDays = 7,
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Backup Logically Air Gapped Vault using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:backup/logicallyAirGappedVault:LogicallyAirGappedVault example lag-example-vault
    /// ```
    /// </summary>
    [AwsResourceType("aws:backup/logicallyAirGappedVault:LogicallyAirGappedVault")]
    public partial class LogicallyAirGappedVault : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN of the Logically Air Gapped Backup Vault.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Maximum retention period that the Logically Air Gapped Backup Vault retains recovery points.
        /// </summary>
        [Output("maxRetentionDays")]
        public Output<int> MaxRetentionDays { get; private set; } = null!;

        /// <summary>
        /// Minimum retention period that the Logically Air Gapped Backup Vault retains recovery points.
        /// </summary>
        [Output("minRetentionDays")]
        public Output<int> MinRetentionDays { get; private set; } = null!;

        /// <summary>
        /// Name of the Logically Air Gapped Backup Vault to create.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Metadata that you can assign to help organize the resources that you create. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        [Output("timeouts")]
        public Output<Outputs.LogicallyAirGappedVaultTimeouts?> Timeouts { get; private set; } = null!;


        /// <summary>
        /// Create a LogicallyAirGappedVault resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public LogicallyAirGappedVault(string name, LogicallyAirGappedVaultArgs args, CustomResourceOptions? options = null)
            : base("aws:backup/logicallyAirGappedVault:LogicallyAirGappedVault", name, args ?? new LogicallyAirGappedVaultArgs(), MakeResourceOptions(options, ""))
        {
        }

        private LogicallyAirGappedVault(string name, Input<string> id, LogicallyAirGappedVaultState? state = null, CustomResourceOptions? options = null)
            : base("aws:backup/logicallyAirGappedVault:LogicallyAirGappedVault", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing LogicallyAirGappedVault resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static LogicallyAirGappedVault Get(string name, Input<string> id, LogicallyAirGappedVaultState? state = null, CustomResourceOptions? options = null)
        {
            return new LogicallyAirGappedVault(name, id, state, options);
        }
    }

    public sealed class LogicallyAirGappedVaultArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Maximum retention period that the Logically Air Gapped Backup Vault retains recovery points.
        /// </summary>
        [Input("maxRetentionDays", required: true)]
        public Input<int> MaxRetentionDays { get; set; } = null!;

        /// <summary>
        /// Minimum retention period that the Logically Air Gapped Backup Vault retains recovery points.
        /// </summary>
        [Input("minRetentionDays", required: true)]
        public Input<int> MinRetentionDays { get; set; } = null!;

        /// <summary>
        /// Name of the Logically Air Gapped Backup Vault to create.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Metadata that you can assign to help organize the resources that you create. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("timeouts")]
        public Input<Inputs.LogicallyAirGappedVaultTimeoutsArgs>? Timeouts { get; set; }

        public LogicallyAirGappedVaultArgs()
        {
        }
        public static new LogicallyAirGappedVaultArgs Empty => new LogicallyAirGappedVaultArgs();
    }

    public sealed class LogicallyAirGappedVaultState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the Logically Air Gapped Backup Vault.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Maximum retention period that the Logically Air Gapped Backup Vault retains recovery points.
        /// </summary>
        [Input("maxRetentionDays")]
        public Input<int>? MaxRetentionDays { get; set; }

        /// <summary>
        /// Minimum retention period that the Logically Air Gapped Backup Vault retains recovery points.
        /// </summary>
        [Input("minRetentionDays")]
        public Input<int>? MinRetentionDays { get; set; }

        /// <summary>
        /// Name of the Logically Air Gapped Backup Vault to create.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Metadata that you can assign to help organize the resources that you create. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        [Input("timeouts")]
        public Input<Inputs.LogicallyAirGappedVaultTimeoutsGetArgs>? Timeouts { get; set; }

        public LogicallyAirGappedVaultState()
        {
        }
        public static new LogicallyAirGappedVaultState Empty => new LogicallyAirGappedVaultState();
    }
}
