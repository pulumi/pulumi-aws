// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pinpoint
{
    /// <summary>
    /// Provides a Pinpoint Email Template resource
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
    ///     var test = new Aws.Pinpoint.EmailTemplate("test", new()
    ///     {
    ///         TemplateName = "testing",
    ///         EmailTemplates = new[]
    ///         {
    ///             new Aws.Pinpoint.Inputs.EmailTemplateEmailTemplateArgs
    ///             {
    ///                 Subject = "testing",
    ///                 TextPart = "we are testing template text part",
    ///                 Headers = new[]
    ///                 {
    ///                     new Aws.Pinpoint.Inputs.EmailTemplateEmailTemplateHeaderArgs
    ///                     {
    ///                         Name = "testingname",
    ///                         Value = "testingvalue",
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
    /// Using `pulumi import`, import Pinpoint Email Template using the `template_name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:pinpoint/emailTemplate:EmailTemplate reset template_name
    /// ```
    /// </summary>
    [AwsResourceType("aws:pinpoint/emailTemplate:EmailTemplate")]
    public partial class EmailTemplate : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the message template.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Specifies the content and settings for a message template that can be used in messages that are sent through the email channel. See Email Template
        /// </summary>
        [Output("emailTemplates")]
        public Output<ImmutableArray<Outputs.EmailTemplateEmailTemplate>> EmailTemplates { get; private set; } = null!;

        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// name of the message template. A template name must start with an alphanumeric character and can contain a maximum of 128 characters. The characters can be alphanumeric characters, underscores (_), or hyphens (-). Template names are case sensitive.
        /// </summary>
        [Output("templateName")]
        public Output<string> TemplateName { get; private set; } = null!;


        /// <summary>
        /// Create a EmailTemplate resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public EmailTemplate(string name, EmailTemplateArgs args, CustomResourceOptions? options = null)
            : base("aws:pinpoint/emailTemplate:EmailTemplate", name, args ?? new EmailTemplateArgs(), MakeResourceOptions(options, ""))
        {
        }

        private EmailTemplate(string name, Input<string> id, EmailTemplateState? state = null, CustomResourceOptions? options = null)
            : base("aws:pinpoint/emailTemplate:EmailTemplate", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing EmailTemplate resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static EmailTemplate Get(string name, Input<string> id, EmailTemplateState? state = null, CustomResourceOptions? options = null)
        {
            return new EmailTemplate(name, id, state, options);
        }
    }

    public sealed class EmailTemplateArgs : global::Pulumi.ResourceArgs
    {
        [Input("emailTemplates")]
        private InputList<Inputs.EmailTemplateEmailTemplateArgs>? _emailTemplates;

        /// <summary>
        /// Specifies the content and settings for a message template that can be used in messages that are sent through the email channel. See Email Template
        /// </summary>
        public InputList<Inputs.EmailTemplateEmailTemplateArgs> EmailTemplates
        {
            get => _emailTemplates ?? (_emailTemplates = new InputList<Inputs.EmailTemplateEmailTemplateArgs>());
            set => _emailTemplates = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// name of the message template. A template name must start with an alphanumeric character and can contain a maximum of 128 characters. The characters can be alphanumeric characters, underscores (_), or hyphens (-). Template names are case sensitive.
        /// </summary>
        [Input("templateName", required: true)]
        public Input<string> TemplateName { get; set; } = null!;

        public EmailTemplateArgs()
        {
        }
        public static new EmailTemplateArgs Empty => new EmailTemplateArgs();
    }

    public sealed class EmailTemplateState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the message template.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("emailTemplates")]
        private InputList<Inputs.EmailTemplateEmailTemplateGetArgs>? _emailTemplates;

        /// <summary>
        /// Specifies the content and settings for a message template that can be used in messages that are sent through the email channel. See Email Template
        /// </summary>
        public InputList<Inputs.EmailTemplateEmailTemplateGetArgs> EmailTemplates
        {
            get => _emailTemplates ?? (_emailTemplates = new InputList<Inputs.EmailTemplateEmailTemplateGetArgs>());
            set => _emailTemplates = value;
        }

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

        /// <summary>
        /// name of the message template. A template name must start with an alphanumeric character and can contain a maximum of 128 characters. The characters can be alphanumeric characters, underscores (_), or hyphens (-). Template names are case sensitive.
        /// </summary>
        [Input("templateName")]
        public Input<string>? TemplateName { get; set; }

        public EmailTemplateState()
        {
        }
        public static new EmailTemplateState Empty => new EmailTemplateState();
    }
}
