// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub
{
    /// <summary>
    /// Manages Security Hub configuration policy
    /// 
    /// &gt; **NOTE:** This resource requires `aws.securityhub.OrganizationConfiguration` to be configured of type `CENTRAL`. More information about Security Hub central configuration and configuration policies can be found in the [How Security Hub configuration policies work](https://docs.aws.amazon.com/securityhub/latest/userguide/configuration-policies-overview.html) documentation.
    /// 
    /// ## Example Usage
    /// 
    /// ### Default standards enabled
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.FindingAggregator("example", new()
    ///     {
    ///         LinkingMode = "ALL_REGIONS",
    ///     });
    /// 
    ///     var exampleOrganizationConfiguration = new Aws.SecurityHub.OrganizationConfiguration("example", new()
    ///     {
    ///         AutoEnable = false,
    ///         AutoEnableStandards = "NONE",
    ///         OrganizationConfigurationDetails = new Aws.SecurityHub.Inputs.OrganizationConfigurationOrganizationConfigurationArgs
    ///         {
    ///             ConfigurationType = "CENTRAL",
    ///         },
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    ///     var exampleConfigurationPolicy = new Aws.SecurityHub.ConfigurationPolicy("example", new()
    ///     {
    ///         Name = "Example",
    ///         Description = "This is an example configuration policy",
    ///         ConfigurationPolicyDetails = new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicyArgs
    ///         {
    ///             ServiceEnabled = true,
    ///             EnabledStandardArns = new[]
    ///             {
    ///                 "arn:aws:securityhub:us-east-1::standards/aws-foundational-security-best-practices/v/1.0.0",
    ///                 "arn:aws:securityhub:::ruleset/cis-aws-foundations-benchmark/v/1.2.0",
    ///             },
    ///             SecurityControlsConfiguration = new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationArgs
    ///             {
    ///                 DisabledControlIdentifiers = new() { },
    ///             },
    ///         },
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             exampleOrganizationConfiguration,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Disabled Policy
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var disabled = new Aws.SecurityHub.ConfigurationPolicy("disabled", new()
    ///     {
    ///         Name = "Disabled",
    ///         Description = "This is an example of disabled configuration policy",
    ///         ConfigurationPolicyDetails = new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicyArgs
    ///         {
    ///             ServiceEnabled = false,
    ///         },
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Custom Control Configuration
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var disabled = new Aws.SecurityHub.ConfigurationPolicy("disabled", new()
    ///     {
    ///         Name = "Custom Controls",
    ///         Description = "This is an example of configuration policy with custom control settings",
    ///         ConfigurationPolicyDetails = new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicyArgs
    ///         {
    ///             ServiceEnabled = true,
    ///             EnabledStandardArns = new[]
    ///             {
    ///                 "arn:aws:securityhub:us-east-1::standards/aws-foundational-security-best-practices/v/1.0.0",
    ///                 "arn:aws:securityhub:::ruleset/cis-aws-foundations-benchmark/v/1.2.0",
    ///             },
    ///             SecurityControlsConfiguration = new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationArgs
    ///             {
    ///                 EnabledControlIdentifiers = new[]
    ///                 {
    ///                     "APIGateway.1",
    ///                     "IAM.7",
    ///                 },
    ///                 SecurityControlCustomParameters = new[]
    ///                 {
    ///                     new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterArgs
    ///                     {
    ///                         SecurityControlId = "APIGateway.1",
    ///                         Parameters = new[]
    ///                         {
    ///                             new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterParameterArgs
    ///                             {
    ///                                 Name = "loggingLevel",
    ///                                 ValueType = "CUSTOM",
    ///                                 Enum = new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterParameterEnumArgs
    ///                                 {
    ///                                     Value = "INFO",
    ///                                 },
    ///                             },
    ///                         },
    ///                     },
    ///                     new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterArgs
    ///                     {
    ///                         SecurityControlId = "IAM.7",
    ///                         Parameters = new[]
    ///                         {
    ///                             new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterParameterArgs
    ///                             {
    ///                                 Name = "RequireLowercaseCharacters",
    ///                                 ValueType = "CUSTOM",
    ///                                 Bool = new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterParameterBoolArgs
    ///                                 {
    ///                                     Value = false,
    ///                                 },
    ///                             },
    ///                             new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterParameterArgs
    ///                             {
    ///                                 Name = "MaxPasswordAge",
    ///                                 ValueType = "CUSTOM",
    ///                                 Int = new Aws.SecurityHub.Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterParameterIntArgs
    ///                                 {
    ///                                     Value = 60,
    ///                                 },
    ///                             },
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import an existing Security Hub enabled account using the universally unique identifier (UUID) of the policy. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:securityhub/configurationPolicy:ConfigurationPolicy example "00000000-1111-2222-3333-444444444444"
    /// ```
    /// </summary>
    [AwsResourceType("aws:securityhub/configurationPolicy:ConfigurationPolicy")]
    public partial class ConfigurationPolicy : global::Pulumi.CustomResource
    {
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Defines how Security Hub is configured. See below.
        /// </summary>
        [Output("configurationPolicy")]
        public Output<Outputs.ConfigurationPolicyConfigurationPolicy> ConfigurationPolicyDetails { get; private set; } = null!;

        /// <summary>
        /// The description of the configuration policy.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// The name of the configuration policy.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;


        /// <summary>
        /// Create a ConfigurationPolicy resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ConfigurationPolicy(string name, ConfigurationPolicyArgs args, CustomResourceOptions? options = null)
            : base("aws:securityhub/configurationPolicy:ConfigurationPolicy", name, args ?? new ConfigurationPolicyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ConfigurationPolicy(string name, Input<string> id, ConfigurationPolicyState? state = null, CustomResourceOptions? options = null)
            : base("aws:securityhub/configurationPolicy:ConfigurationPolicy", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ConfigurationPolicy resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ConfigurationPolicy Get(string name, Input<string> id, ConfigurationPolicyState? state = null, CustomResourceOptions? options = null)
        {
            return new ConfigurationPolicy(name, id, state, options);
        }
    }

    public sealed class ConfigurationPolicyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Defines how Security Hub is configured. See below.
        /// </summary>
        [Input("configurationPolicy", required: true)]
        public Input<Inputs.ConfigurationPolicyConfigurationPolicyArgs> ConfigurationPolicyDetails { get; set; } = null!;

        /// <summary>
        /// The description of the configuration policy.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The name of the configuration policy.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        public ConfigurationPolicyArgs()
        {
        }
        public static new ConfigurationPolicyArgs Empty => new ConfigurationPolicyArgs();
    }

    public sealed class ConfigurationPolicyState : global::Pulumi.ResourceArgs
    {
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Defines how Security Hub is configured. See below.
        /// </summary>
        [Input("configurationPolicy")]
        public Input<Inputs.ConfigurationPolicyConfigurationPolicyGetArgs>? ConfigurationPolicyDetails { get; set; }

        /// <summary>
        /// The description of the configuration policy.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The name of the configuration policy.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        public ConfigurationPolicyState()
        {
        }
        public static new ConfigurationPolicyState Empty => new ConfigurationPolicyState();
    }
}
