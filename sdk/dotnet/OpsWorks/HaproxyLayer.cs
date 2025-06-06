// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpsWorks
{
    /// <summary>
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
    ///     var lb = new Aws.OpsWorks.HaproxyLayer("lb", new()
    ///     {
    ///         StackId = main.Id,
    ///         StatsPassword = "foobarbaz",
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [AwsResourceType("aws:opsworks/haproxyLayer:HaproxyLayer")]
    public partial class HaproxyLayer : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The Amazon Resource Name(ARN) of the layer.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Whether to automatically assign an elastic IP address to the layer's instances.
        /// </summary>
        [Output("autoAssignElasticIps")]
        public Output<bool?> AutoAssignElasticIps { get; private set; } = null!;

        /// <summary>
        /// For stacks belonging to a VPC, whether to automatically assign a public IP address to each of the layer's instances.
        /// </summary>
        [Output("autoAssignPublicIps")]
        public Output<bool?> AutoAssignPublicIps { get; private set; } = null!;

        /// <summary>
        /// Whether to enable auto-healing for the layer.
        /// </summary>
        [Output("autoHealing")]
        public Output<bool?> AutoHealing { get; private set; } = null!;

        [Output("cloudwatchConfiguration")]
        public Output<Outputs.HaproxyLayerCloudwatchConfiguration?> CloudwatchConfiguration { get; private set; } = null!;

        [Output("customConfigureRecipes")]
        public Output<ImmutableArray<string>> CustomConfigureRecipes { get; private set; } = null!;

        [Output("customDeployRecipes")]
        public Output<ImmutableArray<string>> CustomDeployRecipes { get; private set; } = null!;

        /// <summary>
        /// The ARN of an IAM profile that will be used for the layer's instances.
        /// </summary>
        [Output("customInstanceProfileArn")]
        public Output<string?> CustomInstanceProfileArn { get; private set; } = null!;

        /// <summary>
        /// Custom JSON attributes to apply to the layer.
        /// </summary>
        [Output("customJson")]
        public Output<string?> CustomJson { get; private set; } = null!;

        /// <summary>
        /// Ids for a set of security groups to apply to the layer's instances.
        /// </summary>
        [Output("customSecurityGroupIds")]
        public Output<ImmutableArray<string>> CustomSecurityGroupIds { get; private set; } = null!;

        [Output("customSetupRecipes")]
        public Output<ImmutableArray<string>> CustomSetupRecipes { get; private set; } = null!;

        [Output("customShutdownRecipes")]
        public Output<ImmutableArray<string>> CustomShutdownRecipes { get; private set; } = null!;

        [Output("customUndeployRecipes")]
        public Output<ImmutableArray<string>> CustomUndeployRecipes { get; private set; } = null!;

        /// <summary>
        /// Whether to enable Elastic Load Balancing connection draining.
        /// </summary>
        [Output("drainElbOnShutdown")]
        public Output<bool?> DrainElbOnShutdown { get; private set; } = null!;

        /// <summary>
        /// `ebs_volume` blocks, as described below, will each create an EBS volume and connect it to the layer's instances.
        /// </summary>
        [Output("ebsVolumes")]
        public Output<ImmutableArray<Outputs.HaproxyLayerEbsVolume>> EbsVolumes { get; private set; } = null!;

        /// <summary>
        /// Name of an Elastic Load Balancer to attach to this layer
        /// </summary>
        [Output("elasticLoadBalancer")]
        public Output<string?> ElasticLoadBalancer { get; private set; } = null!;

        /// <summary>
        /// HTTP method to use for instance healthchecks. Defaults to "OPTIONS".
        /// </summary>
        [Output("healthcheckMethod")]
        public Output<string?> HealthcheckMethod { get; private set; } = null!;

        /// <summary>
        /// URL path to use for instance healthchecks. Defaults to "/".
        /// </summary>
        [Output("healthcheckUrl")]
        public Output<string?> HealthcheckUrl { get; private set; } = null!;

        /// <summary>
        /// Whether to install OS and package updates on each instance when it boots.
        /// </summary>
        [Output("installUpdatesOnBoot")]
        public Output<bool?> InstallUpdatesOnBoot { get; private set; } = null!;

        /// <summary>
        /// The time, in seconds, that OpsWorks will wait for Chef to complete after triggering the Shutdown event.
        /// </summary>
        [Output("instanceShutdownTimeout")]
        public Output<int?> InstanceShutdownTimeout { get; private set; } = null!;

        [Output("loadBasedAutoScaling")]
        public Output<Outputs.HaproxyLayerLoadBasedAutoScaling> LoadBasedAutoScaling { get; private set; } = null!;

        /// <summary>
        /// A human-readable name for the layer.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// ID of the stack the layer will belong to.
        /// </summary>
        [Output("stackId")]
        public Output<string> StackId { get; private set; } = null!;

        /// <summary>
        /// Whether to enable HAProxy stats.
        /// </summary>
        [Output("statsEnabled")]
        public Output<bool?> StatsEnabled { get; private set; } = null!;

        /// <summary>
        /// The password to use for HAProxy stats.
        /// </summary>
        [Output("statsPassword")]
        public Output<string> StatsPassword { get; private set; } = null!;

        /// <summary>
        /// The HAProxy stats URL. Defaults to "/haproxy?stats".
        /// </summary>
        [Output("statsUrl")]
        public Output<string?> StatsUrl { get; private set; } = null!;

        /// <summary>
        /// The username for HAProxy stats. Defaults to "opsworks".
        /// </summary>
        [Output("statsUser")]
        public Output<string?> StatsUser { get; private set; } = null!;

        /// <summary>
        /// Names of a set of system packages to install on the layer's instances.
        /// </summary>
        [Output("systemPackages")]
        public Output<ImmutableArray<string>> SystemPackages { get; private set; } = null!;

        /// <summary>
        /// A map of tags to assign to the resource. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// 
        /// The following extra optional arguments, all lists of Chef recipe names, allow
        /// custom Chef recipes to be applied to layer instances at the five different
        /// lifecycle events, if custom cookbooks are enabled on the layer's stack:
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// Whether to use EBS-optimized instances.
        /// </summary>
        [Output("useEbsOptimizedInstances")]
        public Output<bool?> UseEbsOptimizedInstances { get; private set; } = null!;


        /// <summary>
        /// Create a HaproxyLayer resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public HaproxyLayer(string name, HaproxyLayerArgs args, CustomResourceOptions? options = null)
            : base("aws:opsworks/haproxyLayer:HaproxyLayer", name, args ?? new HaproxyLayerArgs(), MakeResourceOptions(options, ""))
        {
        }

        private HaproxyLayer(string name, Input<string> id, HaproxyLayerState? state = null, CustomResourceOptions? options = null)
            : base("aws:opsworks/haproxyLayer:HaproxyLayer", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing HaproxyLayer resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static HaproxyLayer Get(string name, Input<string> id, HaproxyLayerState? state = null, CustomResourceOptions? options = null)
        {
            return new HaproxyLayer(name, id, state, options);
        }
    }

    public sealed class HaproxyLayerArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether to automatically assign an elastic IP address to the layer's instances.
        /// </summary>
        [Input("autoAssignElasticIps")]
        public Input<bool>? AutoAssignElasticIps { get; set; }

        /// <summary>
        /// For stacks belonging to a VPC, whether to automatically assign a public IP address to each of the layer's instances.
        /// </summary>
        [Input("autoAssignPublicIps")]
        public Input<bool>? AutoAssignPublicIps { get; set; }

        /// <summary>
        /// Whether to enable auto-healing for the layer.
        /// </summary>
        [Input("autoHealing")]
        public Input<bool>? AutoHealing { get; set; }

        [Input("cloudwatchConfiguration")]
        public Input<Inputs.HaproxyLayerCloudwatchConfigurationArgs>? CloudwatchConfiguration { get; set; }

        [Input("customConfigureRecipes")]
        private InputList<string>? _customConfigureRecipes;
        public InputList<string> CustomConfigureRecipes
        {
            get => _customConfigureRecipes ?? (_customConfigureRecipes = new InputList<string>());
            set => _customConfigureRecipes = value;
        }

        [Input("customDeployRecipes")]
        private InputList<string>? _customDeployRecipes;
        public InputList<string> CustomDeployRecipes
        {
            get => _customDeployRecipes ?? (_customDeployRecipes = new InputList<string>());
            set => _customDeployRecipes = value;
        }

        /// <summary>
        /// The ARN of an IAM profile that will be used for the layer's instances.
        /// </summary>
        [Input("customInstanceProfileArn")]
        public Input<string>? CustomInstanceProfileArn { get; set; }

        /// <summary>
        /// Custom JSON attributes to apply to the layer.
        /// </summary>
        [Input("customJson")]
        public Input<string>? CustomJson { get; set; }

        [Input("customSecurityGroupIds")]
        private InputList<string>? _customSecurityGroupIds;

        /// <summary>
        /// Ids for a set of security groups to apply to the layer's instances.
        /// </summary>
        public InputList<string> CustomSecurityGroupIds
        {
            get => _customSecurityGroupIds ?? (_customSecurityGroupIds = new InputList<string>());
            set => _customSecurityGroupIds = value;
        }

        [Input("customSetupRecipes")]
        private InputList<string>? _customSetupRecipes;
        public InputList<string> CustomSetupRecipes
        {
            get => _customSetupRecipes ?? (_customSetupRecipes = new InputList<string>());
            set => _customSetupRecipes = value;
        }

        [Input("customShutdownRecipes")]
        private InputList<string>? _customShutdownRecipes;
        public InputList<string> CustomShutdownRecipes
        {
            get => _customShutdownRecipes ?? (_customShutdownRecipes = new InputList<string>());
            set => _customShutdownRecipes = value;
        }

        [Input("customUndeployRecipes")]
        private InputList<string>? _customUndeployRecipes;
        public InputList<string> CustomUndeployRecipes
        {
            get => _customUndeployRecipes ?? (_customUndeployRecipes = new InputList<string>());
            set => _customUndeployRecipes = value;
        }

        /// <summary>
        /// Whether to enable Elastic Load Balancing connection draining.
        /// </summary>
        [Input("drainElbOnShutdown")]
        public Input<bool>? DrainElbOnShutdown { get; set; }

        [Input("ebsVolumes")]
        private InputList<Inputs.HaproxyLayerEbsVolumeArgs>? _ebsVolumes;

        /// <summary>
        /// `ebs_volume` blocks, as described below, will each create an EBS volume and connect it to the layer's instances.
        /// </summary>
        public InputList<Inputs.HaproxyLayerEbsVolumeArgs> EbsVolumes
        {
            get => _ebsVolumes ?? (_ebsVolumes = new InputList<Inputs.HaproxyLayerEbsVolumeArgs>());
            set => _ebsVolumes = value;
        }

        /// <summary>
        /// Name of an Elastic Load Balancer to attach to this layer
        /// </summary>
        [Input("elasticLoadBalancer")]
        public Input<string>? ElasticLoadBalancer { get; set; }

        /// <summary>
        /// HTTP method to use for instance healthchecks. Defaults to "OPTIONS".
        /// </summary>
        [Input("healthcheckMethod")]
        public Input<string>? HealthcheckMethod { get; set; }

        /// <summary>
        /// URL path to use for instance healthchecks. Defaults to "/".
        /// </summary>
        [Input("healthcheckUrl")]
        public Input<string>? HealthcheckUrl { get; set; }

        /// <summary>
        /// Whether to install OS and package updates on each instance when it boots.
        /// </summary>
        [Input("installUpdatesOnBoot")]
        public Input<bool>? InstallUpdatesOnBoot { get; set; }

        /// <summary>
        /// The time, in seconds, that OpsWorks will wait for Chef to complete after triggering the Shutdown event.
        /// </summary>
        [Input("instanceShutdownTimeout")]
        public Input<int>? InstanceShutdownTimeout { get; set; }

        [Input("loadBasedAutoScaling")]
        public Input<Inputs.HaproxyLayerLoadBasedAutoScalingArgs>? LoadBasedAutoScaling { get; set; }

        /// <summary>
        /// A human-readable name for the layer.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// ID of the stack the layer will belong to.
        /// </summary>
        [Input("stackId", required: true)]
        public Input<string> StackId { get; set; } = null!;

        /// <summary>
        /// Whether to enable HAProxy stats.
        /// </summary>
        [Input("statsEnabled")]
        public Input<bool>? StatsEnabled { get; set; }

        /// <summary>
        /// The password to use for HAProxy stats.
        /// </summary>
        [Input("statsPassword", required: true)]
        public Input<string> StatsPassword { get; set; } = null!;

        /// <summary>
        /// The HAProxy stats URL. Defaults to "/haproxy?stats".
        /// </summary>
        [Input("statsUrl")]
        public Input<string>? StatsUrl { get; set; }

        /// <summary>
        /// The username for HAProxy stats. Defaults to "opsworks".
        /// </summary>
        [Input("statsUser")]
        public Input<string>? StatsUser { get; set; }

        [Input("systemPackages")]
        private InputList<string>? _systemPackages;

        /// <summary>
        /// Names of a set of system packages to install on the layer's instances.
        /// </summary>
        public InputList<string> SystemPackages
        {
            get => _systemPackages ?? (_systemPackages = new InputList<string>());
            set => _systemPackages = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the resource. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// 
        /// The following extra optional arguments, all lists of Chef recipe names, allow
        /// custom Chef recipes to be applied to layer instances at the five different
        /// lifecycle events, if custom cookbooks are enabled on the layer's stack:
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// Whether to use EBS-optimized instances.
        /// </summary>
        [Input("useEbsOptimizedInstances")]
        public Input<bool>? UseEbsOptimizedInstances { get; set; }

        public HaproxyLayerArgs()
        {
        }
        public static new HaproxyLayerArgs Empty => new HaproxyLayerArgs();
    }

    public sealed class HaproxyLayerState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name(ARN) of the layer.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Whether to automatically assign an elastic IP address to the layer's instances.
        /// </summary>
        [Input("autoAssignElasticIps")]
        public Input<bool>? AutoAssignElasticIps { get; set; }

        /// <summary>
        /// For stacks belonging to a VPC, whether to automatically assign a public IP address to each of the layer's instances.
        /// </summary>
        [Input("autoAssignPublicIps")]
        public Input<bool>? AutoAssignPublicIps { get; set; }

        /// <summary>
        /// Whether to enable auto-healing for the layer.
        /// </summary>
        [Input("autoHealing")]
        public Input<bool>? AutoHealing { get; set; }

        [Input("cloudwatchConfiguration")]
        public Input<Inputs.HaproxyLayerCloudwatchConfigurationGetArgs>? CloudwatchConfiguration { get; set; }

        [Input("customConfigureRecipes")]
        private InputList<string>? _customConfigureRecipes;
        public InputList<string> CustomConfigureRecipes
        {
            get => _customConfigureRecipes ?? (_customConfigureRecipes = new InputList<string>());
            set => _customConfigureRecipes = value;
        }

        [Input("customDeployRecipes")]
        private InputList<string>? _customDeployRecipes;
        public InputList<string> CustomDeployRecipes
        {
            get => _customDeployRecipes ?? (_customDeployRecipes = new InputList<string>());
            set => _customDeployRecipes = value;
        }

        /// <summary>
        /// The ARN of an IAM profile that will be used for the layer's instances.
        /// </summary>
        [Input("customInstanceProfileArn")]
        public Input<string>? CustomInstanceProfileArn { get; set; }

        /// <summary>
        /// Custom JSON attributes to apply to the layer.
        /// </summary>
        [Input("customJson")]
        public Input<string>? CustomJson { get; set; }

        [Input("customSecurityGroupIds")]
        private InputList<string>? _customSecurityGroupIds;

        /// <summary>
        /// Ids for a set of security groups to apply to the layer's instances.
        /// </summary>
        public InputList<string> CustomSecurityGroupIds
        {
            get => _customSecurityGroupIds ?? (_customSecurityGroupIds = new InputList<string>());
            set => _customSecurityGroupIds = value;
        }

        [Input("customSetupRecipes")]
        private InputList<string>? _customSetupRecipes;
        public InputList<string> CustomSetupRecipes
        {
            get => _customSetupRecipes ?? (_customSetupRecipes = new InputList<string>());
            set => _customSetupRecipes = value;
        }

        [Input("customShutdownRecipes")]
        private InputList<string>? _customShutdownRecipes;
        public InputList<string> CustomShutdownRecipes
        {
            get => _customShutdownRecipes ?? (_customShutdownRecipes = new InputList<string>());
            set => _customShutdownRecipes = value;
        }

        [Input("customUndeployRecipes")]
        private InputList<string>? _customUndeployRecipes;
        public InputList<string> CustomUndeployRecipes
        {
            get => _customUndeployRecipes ?? (_customUndeployRecipes = new InputList<string>());
            set => _customUndeployRecipes = value;
        }

        /// <summary>
        /// Whether to enable Elastic Load Balancing connection draining.
        /// </summary>
        [Input("drainElbOnShutdown")]
        public Input<bool>? DrainElbOnShutdown { get; set; }

        [Input("ebsVolumes")]
        private InputList<Inputs.HaproxyLayerEbsVolumeGetArgs>? _ebsVolumes;

        /// <summary>
        /// `ebs_volume` blocks, as described below, will each create an EBS volume and connect it to the layer's instances.
        /// </summary>
        public InputList<Inputs.HaproxyLayerEbsVolumeGetArgs> EbsVolumes
        {
            get => _ebsVolumes ?? (_ebsVolumes = new InputList<Inputs.HaproxyLayerEbsVolumeGetArgs>());
            set => _ebsVolumes = value;
        }

        /// <summary>
        /// Name of an Elastic Load Balancer to attach to this layer
        /// </summary>
        [Input("elasticLoadBalancer")]
        public Input<string>? ElasticLoadBalancer { get; set; }

        /// <summary>
        /// HTTP method to use for instance healthchecks. Defaults to "OPTIONS".
        /// </summary>
        [Input("healthcheckMethod")]
        public Input<string>? HealthcheckMethod { get; set; }

        /// <summary>
        /// URL path to use for instance healthchecks. Defaults to "/".
        /// </summary>
        [Input("healthcheckUrl")]
        public Input<string>? HealthcheckUrl { get; set; }

        /// <summary>
        /// Whether to install OS and package updates on each instance when it boots.
        /// </summary>
        [Input("installUpdatesOnBoot")]
        public Input<bool>? InstallUpdatesOnBoot { get; set; }

        /// <summary>
        /// The time, in seconds, that OpsWorks will wait for Chef to complete after triggering the Shutdown event.
        /// </summary>
        [Input("instanceShutdownTimeout")]
        public Input<int>? InstanceShutdownTimeout { get; set; }

        [Input("loadBasedAutoScaling")]
        public Input<Inputs.HaproxyLayerLoadBasedAutoScalingGetArgs>? LoadBasedAutoScaling { get; set; }

        /// <summary>
        /// A human-readable name for the layer.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// ID of the stack the layer will belong to.
        /// </summary>
        [Input("stackId")]
        public Input<string>? StackId { get; set; }

        /// <summary>
        /// Whether to enable HAProxy stats.
        /// </summary>
        [Input("statsEnabled")]
        public Input<bool>? StatsEnabled { get; set; }

        /// <summary>
        /// The password to use for HAProxy stats.
        /// </summary>
        [Input("statsPassword")]
        public Input<string>? StatsPassword { get; set; }

        /// <summary>
        /// The HAProxy stats URL. Defaults to "/haproxy?stats".
        /// </summary>
        [Input("statsUrl")]
        public Input<string>? StatsUrl { get; set; }

        /// <summary>
        /// The username for HAProxy stats. Defaults to "opsworks".
        /// </summary>
        [Input("statsUser")]
        public Input<string>? StatsUser { get; set; }

        [Input("systemPackages")]
        private InputList<string>? _systemPackages;

        /// <summary>
        /// Names of a set of system packages to install on the layer's instances.
        /// </summary>
        public InputList<string> SystemPackages
        {
            get => _systemPackages ?? (_systemPackages = new InputList<string>());
            set => _systemPackages = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the resource. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// 
        /// The following extra optional arguments, all lists of Chef recipe names, allow
        /// custom Chef recipes to be applied to layer instances at the five different
        /// lifecycle events, if custom cookbooks are enabled on the layer's stack:
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
        /// Whether to use EBS-optimized instances.
        /// </summary>
        [Input("useEbsOptimizedInstances")]
        public Input<bool>? UseEbsOptimizedInstances { get; set; }

        public HaproxyLayerState()
        {
        }
        public static new HaproxyLayerState Empty => new HaproxyLayerState();
    }
}
