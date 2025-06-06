// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Chime
{
    /// <summary>
    /// Resource for managing an AWS Chime SDK Voice Profile Domain.
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
    ///     var example = new Aws.Kms.Key("example", new()
    ///     {
    ///         Description = "KMS Key for Voice Profile Domain",
    ///         DeletionWindowInDays = 7,
    ///     });
    /// 
    ///     var exampleSdkvoiceVoiceProfileDomain = new Aws.Chime.SdkvoiceVoiceProfileDomain("example", new()
    ///     {
    ///         Name = "ExampleVoiceProfileDomain",
    ///         ServerSideEncryptionConfiguration = new Aws.Chime.Inputs.SdkvoiceVoiceProfileDomainServerSideEncryptionConfigurationArgs
    ///         {
    ///             KmsKeyArn = example.Arn,
    ///         },
    ///         Description = "My Voice Profile Domain",
    ///         Tags = 
    ///         {
    ///             { "key1", "value1" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import AWS Chime SDK Voice Profile Domain using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:chime/sdkvoiceVoiceProfileDomain:SdkvoiceVoiceProfileDomain example abcdef123456
    /// ```
    /// </summary>
    [AwsResourceType("aws:chime/sdkvoiceVoiceProfileDomain:SdkvoiceVoiceProfileDomain")]
    public partial class SdkvoiceVoiceProfileDomain : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the Voice Profile Domain.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Description of Voice Profile Domain.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Name of Voice Profile Domain.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Configuration for server side encryption.
        /// </summary>
        [Output("serverSideEncryptionConfiguration")]
        public Output<Outputs.SdkvoiceVoiceProfileDomainServerSideEncryptionConfiguration> ServerSideEncryptionConfiguration { get; private set; } = null!;

        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a SdkvoiceVoiceProfileDomain resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public SdkvoiceVoiceProfileDomain(string name, SdkvoiceVoiceProfileDomainArgs args, CustomResourceOptions? options = null)
            : base("aws:chime/sdkvoiceVoiceProfileDomain:SdkvoiceVoiceProfileDomain", name, args ?? new SdkvoiceVoiceProfileDomainArgs(), MakeResourceOptions(options, ""))
        {
        }

        private SdkvoiceVoiceProfileDomain(string name, Input<string> id, SdkvoiceVoiceProfileDomainState? state = null, CustomResourceOptions? options = null)
            : base("aws:chime/sdkvoiceVoiceProfileDomain:SdkvoiceVoiceProfileDomain", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing SdkvoiceVoiceProfileDomain resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static SdkvoiceVoiceProfileDomain Get(string name, Input<string> id, SdkvoiceVoiceProfileDomainState? state = null, CustomResourceOptions? options = null)
        {
            return new SdkvoiceVoiceProfileDomain(name, id, state, options);
        }
    }

    public sealed class SdkvoiceVoiceProfileDomainArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Description of Voice Profile Domain.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Name of Voice Profile Domain.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Configuration for server side encryption.
        /// </summary>
        [Input("serverSideEncryptionConfiguration", required: true)]
        public Input<Inputs.SdkvoiceVoiceProfileDomainServerSideEncryptionConfigurationArgs> ServerSideEncryptionConfiguration { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public SdkvoiceVoiceProfileDomainArgs()
        {
        }
        public static new SdkvoiceVoiceProfileDomainArgs Empty => new SdkvoiceVoiceProfileDomainArgs();
    }

    public sealed class SdkvoiceVoiceProfileDomainState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the Voice Profile Domain.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Description of Voice Profile Domain.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Name of Voice Profile Domain.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Configuration for server side encryption.
        /// </summary>
        [Input("serverSideEncryptionConfiguration")]
        public Input<Inputs.SdkvoiceVoiceProfileDomainServerSideEncryptionConfigurationGetArgs>? ServerSideEncryptionConfiguration { get; set; }

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

        public SdkvoiceVoiceProfileDomainState()
        {
        }
        public static new SdkvoiceVoiceProfileDomainState Empty => new SdkvoiceVoiceProfileDomainState();
    }
}
