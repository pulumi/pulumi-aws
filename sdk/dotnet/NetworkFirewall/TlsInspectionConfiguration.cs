// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall
{
    /// <summary>
    /// Resource for managing an AWS Network Firewall TLS Inspection Configuration.
    /// 
    /// ## Example Usage
    /// 
    /// &gt; **NOTE:** You must configure either inbound inspection, outbound inspection, or both.
    /// 
    /// ### Basic inbound/ingress inspection
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.NetworkFirewall.TlsInspectionConfiguration("example", new()
    ///     {
    ///         Name = "example",
    ///         Description = "example",
    ///         EncryptionConfigurations = new[]
    ///         {
    ///             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationEncryptionConfigurationArgs
    ///             {
    ///                 KeyId = "AWS_OWNED_KMS_KEY",
    ///                 Type = "AWS_OWNED_KMS_KEY",
    ///             },
    ///         },
    ///         TlsInspectionConfig = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationArgs
    ///         {
    ///             ServerCertificateConfiguration = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationArgs
    ///             {
    ///                 ServerCertificates = new[]
    ///                 {
    ///                     new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationServerCertificateArgs
    ///                     {
    ///                         ResourceArn = example1.Arn,
    ///                     },
    ///                 },
    ///                 Scopes = new[]
    ///                 {
    ///                     new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeArgs
    ///                     {
    ///                         Protocols = new[]
    ///                         {
    ///                             6,
    ///                         },
    ///                         DestinationPorts = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPortArgs
    ///                             {
    ///                                 FromPort = 443,
    ///                                 ToPort = 443,
    ///                             },
    ///                         },
    ///                         Destinations = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationArgs
    ///                             {
    ///                                 AddressDefinition = "0.0.0.0/0",
    ///                             },
    ///                         },
    ///                         SourcePorts = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePortArgs
    ///                             {
    ///                                 FromPort = 0,
    ///                                 ToPort = 65535,
    ///                             },
    ///                         },
    ///                         Sources = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourceArgs
    ///                             {
    ///                                 AddressDefinition = "0.0.0.0/0",
    ///                             },
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Basic outbound/engress inspection
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.NetworkFirewall.TlsInspectionConfiguration("example", new()
    ///     {
    ///         Name = "example",
    ///         Description = "example",
    ///         EncryptionConfigurations = new[]
    ///         {
    ///             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationEncryptionConfigurationArgs
    ///             {
    ///                 KeyId = "AWS_OWNED_KMS_KEY",
    ///                 Type = "AWS_OWNED_KMS_KEY",
    ///             },
    ///         },
    ///         TlsInspectionConfig = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationArgs
    ///         {
    ///             ServerCertificateConfiguration = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationArgs
    ///             {
    ///                 CertificateAuthorityArn = example1.Arn,
    ///                 CheckCertificateRevocationStatus = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationCheckCertificateRevocationStatusArgs
    ///                 {
    ///                     RevokedStatusAction = "REJECT",
    ///                     UnknownStatusAction = "PASS",
    ///                 },
    ///                 Scopes = new[]
    ///                 {
    ///                     new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeArgs
    ///                     {
    ///                         Protocols = new[]
    ///                         {
    ///                             6,
    ///                         },
    ///                         DestinationPorts = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPortArgs
    ///                             {
    ///                                 FromPort = 443,
    ///                                 ToPort = 443,
    ///                             },
    ///                         },
    ///                         Destinations = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationArgs
    ///                             {
    ///                                 AddressDefinition = "0.0.0.0/0",
    ///                             },
    ///                         },
    ///                         SourcePorts = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePortArgs
    ///                             {
    ///                                 FromPort = 0,
    ///                                 ToPort = 65535,
    ///                             },
    ///                         },
    ///                         Sources = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourceArgs
    ///                             {
    ///                                 AddressDefinition = "0.0.0.0/0",
    ///                             },
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Inbound with encryption configuration
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Kms.Key("example", new()
    ///     {
    ///         Description = "example",
    ///         DeletionWindowInDays = 7,
    ///     });
    /// 
    ///     var exampleTlsInspectionConfiguration = new Aws.NetworkFirewall.TlsInspectionConfiguration("example", new()
    ///     {
    ///         Name = "example",
    ///         Description = "example",
    ///         EncryptionConfigurations = new[]
    ///         {
    ///             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationEncryptionConfigurationArgs
    ///             {
    ///                 KeyId = example.Arn,
    ///                 Type = "CUSTOMER_KMS",
    ///             },
    ///         },
    ///         TlsInspectionConfig = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationArgs
    ///         {
    ///             ServerCertificateConfiguration = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationArgs
    ///             {
    ///                 ServerCertificates = new[]
    ///                 {
    ///                     new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationServerCertificateArgs
    ///                     {
    ///                         ResourceArn = example1.Arn,
    ///                     },
    ///                 },
    ///                 Scopes = new[]
    ///                 {
    ///                     new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeArgs
    ///                     {
    ///                         Protocols = new[]
    ///                         {
    ///                             6,
    ///                         },
    ///                         DestinationPorts = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPortArgs
    ///                             {
    ///                                 FromPort = 443,
    ///                                 ToPort = 443,
    ///                             },
    ///                         },
    ///                         Destinations = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationArgs
    ///                             {
    ///                                 AddressDefinition = "0.0.0.0/0",
    ///                             },
    ///                         },
    ///                         SourcePorts = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePortArgs
    ///                             {
    ///                                 FromPort = 0,
    ///                                 ToPort = 65535,
    ///                             },
    ///                         },
    ///                         Sources = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourceArgs
    ///                             {
    ///                                 AddressDefinition = "0.0.0.0/0",
    ///                             },
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Combined inbound and outbound
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.NetworkFirewall.TlsInspectionConfiguration("example", new()
    ///     {
    ///         Name = "example",
    ///         Description = "example",
    ///         EncryptionConfigurations = new[]
    ///         {
    ///             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationEncryptionConfigurationArgs
    ///             {
    ///                 KeyId = "AWS_OWNED_KMS_KEY",
    ///                 Type = "AWS_OWNED_KMS_KEY",
    ///             },
    ///         },
    ///         TlsInspectionConfig = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationArgs
    ///         {
    ///             ServerCertificateConfiguration = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationArgs
    ///             {
    ///                 CertificateAuthorityArn = example1.Arn,
    ///                 CheckCertificateRevocationStatus = new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationCheckCertificateRevocationStatusArgs
    ///                 {
    ///                     RevokedStatusAction = "REJECT",
    ///                     UnknownStatusAction = "PASS",
    ///                 },
    ///                 ServerCertificates = new[]
    ///                 {
    ///                     new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationServerCertificateArgs
    ///                     {
    ///                         ResourceArn = example2.Arn,
    ///                     },
    ///                 },
    ///                 Scopes = new[]
    ///                 {
    ///                     new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeArgs
    ///                     {
    ///                         Protocols = new[]
    ///                         {
    ///                             6,
    ///                         },
    ///                         DestinationPorts = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationPortArgs
    ///                             {
    ///                                 FromPort = 443,
    ///                                 ToPort = 443,
    ///                             },
    ///                         },
    ///                         Destinations = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeDestinationArgs
    ///                             {
    ///                                 AddressDefinition = "0.0.0.0/0",
    ///                             },
    ///                         },
    ///                         SourcePorts = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourcePortArgs
    ///                             {
    ///                                 FromPort = 0,
    ///                                 ToPort = 65535,
    ///                             },
    ///                         },
    ///                         Sources = new[]
    ///                         {
    ///                             new Aws.NetworkFirewall.Inputs.TlsInspectionConfigurationTlsInspectionConfigurationServerCertificateConfigurationScopeSourceArgs
    ///                             {
    ///                                 AddressDefinition = "0.0.0.0/0",
    ///                             },
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Network Firewall TLS Inspection Configuration using the `arn`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:networkfirewall/tlsInspectionConfiguration:TlsInspectionConfiguration example arn:aws:network-firewall::&lt;region&gt;:&lt;account_id&gt;:tls-configuration/example
    /// ```
    /// </summary>
    [AwsResourceType("aws:networkfirewall/tlsInspectionConfiguration:TlsInspectionConfiguration")]
    public partial class TlsInspectionConfiguration : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the TLS Inspection Configuration.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Certificate Manager certificate block. See Certificate Authority below for details.
        /// </summary>
        [Output("certificateAuthorities")]
        public Output<ImmutableArray<Outputs.TlsInspectionConfigurationCertificateAuthority>> CertificateAuthorities { get; private set; } = null!;

        /// <summary>
        /// List of certificate blocks describing certificates associated with the TLS inspection configuration. See Certificates below for details.
        /// </summary>
        [Output("certificates")]
        public Output<ImmutableArray<Outputs.TlsInspectionConfigurationCertificate>> Certificates { get; private set; } = null!;

        /// <summary>
        /// Description of the TLS inspection configuration.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Encryption configuration block. Detailed below.
        /// </summary>
        [Output("encryptionConfigurations")]
        public Output<ImmutableArray<Outputs.TlsInspectionConfigurationEncryptionConfiguration>> EncryptionConfigurations { get; private set; } = null!;

        /// <summary>
        /// Descriptive name of the TLS inspection configuration.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Number of firewall policies that use this TLS inspection configuration.
        /// </summary>
        [Output("numberOfAssociations")]
        public Output<int> NumberOfAssociations { get; private set; } = null!;

        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        [Output("timeouts")]
        public Output<Outputs.TlsInspectionConfigurationTimeouts?> Timeouts { get; private set; } = null!;

        /// <summary>
        /// TLS inspection configuration block. Detailed below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("tlsInspectionConfiguration")]
        public Output<Outputs.TlsInspectionConfigurationTlsInspectionConfiguration?> TlsInspectionConfig { get; private set; } = null!;

        /// <summary>
        /// A unique identifier for the TLS inspection configuration.
        /// </summary>
        [Output("tlsInspectionConfigurationId")]
        public Output<string> TlsInspectionConfigurationId { get; private set; } = null!;

        /// <summary>
        /// String token used when updating the rule group.
        /// </summary>
        [Output("updateToken")]
        public Output<string> UpdateToken { get; private set; } = null!;


        /// <summary>
        /// Create a TlsInspectionConfiguration resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public TlsInspectionConfiguration(string name, TlsInspectionConfigurationArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:networkfirewall/tlsInspectionConfiguration:TlsInspectionConfiguration", name, args ?? new TlsInspectionConfigurationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private TlsInspectionConfiguration(string name, Input<string> id, TlsInspectionConfigurationState? state = null, CustomResourceOptions? options = null)
            : base("aws:networkfirewall/tlsInspectionConfiguration:TlsInspectionConfiguration", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing TlsInspectionConfiguration resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static TlsInspectionConfiguration Get(string name, Input<string> id, TlsInspectionConfigurationState? state = null, CustomResourceOptions? options = null)
        {
            return new TlsInspectionConfiguration(name, id, state, options);
        }
    }

    public sealed class TlsInspectionConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Description of the TLS inspection configuration.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        [Input("encryptionConfigurations")]
        private InputList<Inputs.TlsInspectionConfigurationEncryptionConfigurationArgs>? _encryptionConfigurations;

        /// <summary>
        /// Encryption configuration block. Detailed below.
        /// </summary>
        public InputList<Inputs.TlsInspectionConfigurationEncryptionConfigurationArgs> EncryptionConfigurations
        {
            get => _encryptionConfigurations ?? (_encryptionConfigurations = new InputList<Inputs.TlsInspectionConfigurationEncryptionConfigurationArgs>());
            set => _encryptionConfigurations = value;
        }

        /// <summary>
        /// Descriptive name of the TLS inspection configuration.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("timeouts")]
        public Input<Inputs.TlsInspectionConfigurationTimeoutsArgs>? Timeouts { get; set; }

        /// <summary>
        /// TLS inspection configuration block. Detailed below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("tlsInspectionConfiguration")]
        public Input<Inputs.TlsInspectionConfigurationTlsInspectionConfigurationArgs>? TlsInspectionConfig { get; set; }

        public TlsInspectionConfigurationArgs()
        {
        }
        public static new TlsInspectionConfigurationArgs Empty => new TlsInspectionConfigurationArgs();
    }

    public sealed class TlsInspectionConfigurationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the TLS Inspection Configuration.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("certificateAuthorities")]
        private InputList<Inputs.TlsInspectionConfigurationCertificateAuthorityGetArgs>? _certificateAuthorities;

        /// <summary>
        /// Certificate Manager certificate block. See Certificate Authority below for details.
        /// </summary>
        public InputList<Inputs.TlsInspectionConfigurationCertificateAuthorityGetArgs> CertificateAuthorities
        {
            get => _certificateAuthorities ?? (_certificateAuthorities = new InputList<Inputs.TlsInspectionConfigurationCertificateAuthorityGetArgs>());
            set => _certificateAuthorities = value;
        }

        [Input("certificates")]
        private InputList<Inputs.TlsInspectionConfigurationCertificateGetArgs>? _certificates;

        /// <summary>
        /// List of certificate blocks describing certificates associated with the TLS inspection configuration. See Certificates below for details.
        /// </summary>
        public InputList<Inputs.TlsInspectionConfigurationCertificateGetArgs> Certificates
        {
            get => _certificates ?? (_certificates = new InputList<Inputs.TlsInspectionConfigurationCertificateGetArgs>());
            set => _certificates = value;
        }

        /// <summary>
        /// Description of the TLS inspection configuration.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        [Input("encryptionConfigurations")]
        private InputList<Inputs.TlsInspectionConfigurationEncryptionConfigurationGetArgs>? _encryptionConfigurations;

        /// <summary>
        /// Encryption configuration block. Detailed below.
        /// </summary>
        public InputList<Inputs.TlsInspectionConfigurationEncryptionConfigurationGetArgs> EncryptionConfigurations
        {
            get => _encryptionConfigurations ?? (_encryptionConfigurations = new InputList<Inputs.TlsInspectionConfigurationEncryptionConfigurationGetArgs>());
            set => _encryptionConfigurations = value;
        }

        /// <summary>
        /// Descriptive name of the TLS inspection configuration.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Number of firewall policies that use this TLS inspection configuration.
        /// </summary>
        [Input("numberOfAssociations")]
        public Input<int>? NumberOfAssociations { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        [Input("timeouts")]
        public Input<Inputs.TlsInspectionConfigurationTimeoutsGetArgs>? Timeouts { get; set; }

        /// <summary>
        /// TLS inspection configuration block. Detailed below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("tlsInspectionConfiguration")]
        public Input<Inputs.TlsInspectionConfigurationTlsInspectionConfigurationGetArgs>? TlsInspectionConfig { get; set; }

        /// <summary>
        /// A unique identifier for the TLS inspection configuration.
        /// </summary>
        [Input("tlsInspectionConfigurationId")]
        public Input<string>? TlsInspectionConfigurationId { get; set; }

        /// <summary>
        /// String token used when updating the rule group.
        /// </summary>
        [Input("updateToken")]
        public Input<string>? UpdateToken { get; set; }

        public TlsInspectionConfigurationState()
        {
        }
        public static new TlsInspectionConfigurationState Empty => new TlsInspectionConfigurationState();
    }
}
