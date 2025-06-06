// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex
{
    /// <summary>
    /// Resource for managing an AWS Lex V2 Models Bot.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using System.Text.Json;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var exampleRole = new Aws.Iam.Role("example", new()
    ///     {
    ///         Name = "example",
    ///         AssumeRolePolicy = JsonSerializer.Serialize(new Dictionary&lt;string, object?&gt;
    ///         {
    ///             ["Version"] = "2012-10-17",
    ///             ["Statement"] = new[]
    ///             {
    ///                 new Dictionary&lt;string, object?&gt;
    ///                 {
    ///                     ["Action"] = "sts:AssumeRole",
    ///                     ["Effect"] = "Allow",
    ///                     ["Sid"] = "",
    ///                     ["Principal"] = new Dictionary&lt;string, object?&gt;
    ///                     {
    ///                         ["Service"] = "lexv2.amazonaws.com",
    ///                     },
    ///                 },
    ///             },
    ///         }),
    ///         Tags = 
    ///         {
    ///             { "created_by", "aws" },
    ///         },
    ///     });
    /// 
    ///     var example = new Aws.Lex.V2modelsBot("example", new()
    ///     {
    ///         Name = "example",
    ///         Description = "Example description",
    ///         DataPrivacies = new[]
    ///         {
    ///             new Aws.Lex.Inputs.V2modelsBotDataPrivacyArgs
    ///             {
    ///                 ChildDirected = false,
    ///             },
    ///         },
    ///         IdleSessionTtlInSeconds = 60,
    ///         RoleArn = exampleRole.Arn,
    ///         Type = "Bot",
    ///         Tags = 
    ///         {
    ///             { "foo", "bar" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Lex V2 Models Bot using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:lex/v2modelsBot:V2modelsBot example bot-id-12345678
    /// ```
    /// </summary>
    [AwsResourceType("aws:lex/v2modelsBot:V2modelsBot")]
    public partial class V2modelsBot : global::Pulumi.CustomResource
    {
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Provides information on additional privacy protections Amazon Lex should use with the bot's data. See `data_privacy`
        /// </summary>
        [Output("dataPrivacies")]
        public Output<ImmutableArray<Outputs.V2modelsBotDataPrivacy>> DataPrivacies { get; private set; } = null!;

        /// <summary>
        /// Description of the bot. It appears in lists to help you identify a particular bot.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Time, in seconds, that Amazon Lex should keep information about a user's conversation with the bot. You can specify between 60 (1 minute) and 86,400 (24 hours) seconds.
        /// </summary>
        [Output("idleSessionTtlInSeconds")]
        public Output<int> IdleSessionTtlInSeconds { get; private set; } = null!;

        /// <summary>
        /// List of bot members in a network to be created. See `bot_members`.
        /// </summary>
        [Output("members")]
        public Output<ImmutableArray<Outputs.V2modelsBotMember>> Members { get; private set; } = null!;

        /// <summary>
        /// Name of the bot. The bot name must be unique in the account that creates the bot. Type String. Length Constraints: Minimum length of 1. Maximum length of 100.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// ARN of an IAM role that has permission to access the bot.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("roleArn")]
        public Output<string> RoleArn { get; private set; } = null!;

        /// <summary>
        /// List of tags to add to the bot. You can only add tags when you create a bot.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// List of tags to add to the test alias for a bot. You can only add tags when you create a bot.
        /// </summary>
        [Output("testBotAliasTags")]
        public Output<ImmutableDictionary<string, string>?> TestBotAliasTags { get; private set; } = null!;

        [Output("timeouts")]
        public Output<Outputs.V2modelsBotTimeouts?> Timeouts { get; private set; } = null!;

        /// <summary>
        /// Type of a bot to create. Possible values are `"Bot"` and `"BotNetwork"`.
        /// </summary>
        [Output("type")]
        public Output<string> Type { get; private set; } = null!;


        /// <summary>
        /// Create a V2modelsBot resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public V2modelsBot(string name, V2modelsBotArgs args, CustomResourceOptions? options = null)
            : base("aws:lex/v2modelsBot:V2modelsBot", name, args ?? new V2modelsBotArgs(), MakeResourceOptions(options, ""))
        {
        }

        private V2modelsBot(string name, Input<string> id, V2modelsBotState? state = null, CustomResourceOptions? options = null)
            : base("aws:lex/v2modelsBot:V2modelsBot", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing V2modelsBot resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static V2modelsBot Get(string name, Input<string> id, V2modelsBotState? state = null, CustomResourceOptions? options = null)
        {
            return new V2modelsBot(name, id, state, options);
        }
    }

    public sealed class V2modelsBotArgs : global::Pulumi.ResourceArgs
    {
        [Input("dataPrivacies")]
        private InputList<Inputs.V2modelsBotDataPrivacyArgs>? _dataPrivacies;

        /// <summary>
        /// Provides information on additional privacy protections Amazon Lex should use with the bot's data. See `data_privacy`
        /// </summary>
        public InputList<Inputs.V2modelsBotDataPrivacyArgs> DataPrivacies
        {
            get => _dataPrivacies ?? (_dataPrivacies = new InputList<Inputs.V2modelsBotDataPrivacyArgs>());
            set => _dataPrivacies = value;
        }

        /// <summary>
        /// Description of the bot. It appears in lists to help you identify a particular bot.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Time, in seconds, that Amazon Lex should keep information about a user's conversation with the bot. You can specify between 60 (1 minute) and 86,400 (24 hours) seconds.
        /// </summary>
        [Input("idleSessionTtlInSeconds", required: true)]
        public Input<int> IdleSessionTtlInSeconds { get; set; } = null!;

        [Input("members")]
        private InputList<Inputs.V2modelsBotMemberArgs>? _members;

        /// <summary>
        /// List of bot members in a network to be created. See `bot_members`.
        /// </summary>
        public InputList<Inputs.V2modelsBotMemberArgs> Members
        {
            get => _members ?? (_members = new InputList<Inputs.V2modelsBotMemberArgs>());
            set => _members = value;
        }

        /// <summary>
        /// Name of the bot. The bot name must be unique in the account that creates the bot. Type String. Length Constraints: Minimum length of 1. Maximum length of 100.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// ARN of an IAM role that has permission to access the bot.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("roleArn", required: true)]
        public Input<string> RoleArn { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// List of tags to add to the bot. You can only add tags when you create a bot.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("testBotAliasTags")]
        private InputMap<string>? _testBotAliasTags;

        /// <summary>
        /// List of tags to add to the test alias for a bot. You can only add tags when you create a bot.
        /// </summary>
        public InputMap<string> TestBotAliasTags
        {
            get => _testBotAliasTags ?? (_testBotAliasTags = new InputMap<string>());
            set => _testBotAliasTags = value;
        }

        [Input("timeouts")]
        public Input<Inputs.V2modelsBotTimeoutsArgs>? Timeouts { get; set; }

        /// <summary>
        /// Type of a bot to create. Possible values are `"Bot"` and `"BotNetwork"`.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public V2modelsBotArgs()
        {
        }
        public static new V2modelsBotArgs Empty => new V2modelsBotArgs();
    }

    public sealed class V2modelsBotState : global::Pulumi.ResourceArgs
    {
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("dataPrivacies")]
        private InputList<Inputs.V2modelsBotDataPrivacyGetArgs>? _dataPrivacies;

        /// <summary>
        /// Provides information on additional privacy protections Amazon Lex should use with the bot's data. See `data_privacy`
        /// </summary>
        public InputList<Inputs.V2modelsBotDataPrivacyGetArgs> DataPrivacies
        {
            get => _dataPrivacies ?? (_dataPrivacies = new InputList<Inputs.V2modelsBotDataPrivacyGetArgs>());
            set => _dataPrivacies = value;
        }

        /// <summary>
        /// Description of the bot. It appears in lists to help you identify a particular bot.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Time, in seconds, that Amazon Lex should keep information about a user's conversation with the bot. You can specify between 60 (1 minute) and 86,400 (24 hours) seconds.
        /// </summary>
        [Input("idleSessionTtlInSeconds")]
        public Input<int>? IdleSessionTtlInSeconds { get; set; }

        [Input("members")]
        private InputList<Inputs.V2modelsBotMemberGetArgs>? _members;

        /// <summary>
        /// List of bot members in a network to be created. See `bot_members`.
        /// </summary>
        public InputList<Inputs.V2modelsBotMemberGetArgs> Members
        {
            get => _members ?? (_members = new InputList<Inputs.V2modelsBotMemberGetArgs>());
            set => _members = value;
        }

        /// <summary>
        /// Name of the bot. The bot name must be unique in the account that creates the bot. Type String. Length Constraints: Minimum length of 1. Maximum length of 100.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// ARN of an IAM role that has permission to access the bot.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("roleArn")]
        public Input<string>? RoleArn { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// List of tags to add to the bot. You can only add tags when you create a bot.
        /// </summary>
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

        [Input("testBotAliasTags")]
        private InputMap<string>? _testBotAliasTags;

        /// <summary>
        /// List of tags to add to the test alias for a bot. You can only add tags when you create a bot.
        /// </summary>
        public InputMap<string> TestBotAliasTags
        {
            get => _testBotAliasTags ?? (_testBotAliasTags = new InputMap<string>());
            set => _testBotAliasTags = value;
        }

        [Input("timeouts")]
        public Input<Inputs.V2modelsBotTimeoutsGetArgs>? Timeouts { get; set; }

        /// <summary>
        /// Type of a bot to create. Possible values are `"Bot"` and `"BotNetwork"`.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public V2modelsBotState()
        {
        }
        public static new V2modelsBotState Empty => new V2modelsBotState();
    }
}
