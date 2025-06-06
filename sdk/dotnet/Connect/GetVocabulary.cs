// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Connect
{
    public static class GetVocabulary
    {
        /// <summary>
        /// Provides details about a specific Amazon Connect Vocabulary.
        /// 
        /// ## Example Usage
        /// 
        /// By `name`
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Connect.GetVocabulary.Invoke(new()
        ///     {
        ///         InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        ///         Name = "Example",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// By `vocabulary_id`
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Connect.GetVocabulary.Invoke(new()
        ///     {
        ///         InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        ///         VocabularyId = "cccccccc-bbbb-cccc-dddd-111111111111",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetVocabularyResult> InvokeAsync(GetVocabularyArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetVocabularyResult>("aws:connect/getVocabulary:getVocabulary", args ?? new GetVocabularyArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about a specific Amazon Connect Vocabulary.
        /// 
        /// ## Example Usage
        /// 
        /// By `name`
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Connect.GetVocabulary.Invoke(new()
        ///     {
        ///         InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        ///         Name = "Example",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// By `vocabulary_id`
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Connect.GetVocabulary.Invoke(new()
        ///     {
        ///         InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        ///         VocabularyId = "cccccccc-bbbb-cccc-dddd-111111111111",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetVocabularyResult> Invoke(GetVocabularyInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetVocabularyResult>("aws:connect/getVocabulary:getVocabulary", args ?? new GetVocabularyInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about a specific Amazon Connect Vocabulary.
        /// 
        /// ## Example Usage
        /// 
        /// By `name`
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Connect.GetVocabulary.Invoke(new()
        ///     {
        ///         InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        ///         Name = "Example",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// By `vocabulary_id`
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Connect.GetVocabulary.Invoke(new()
        ///     {
        ///         InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        ///         VocabularyId = "cccccccc-bbbb-cccc-dddd-111111111111",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetVocabularyResult> Invoke(GetVocabularyInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetVocabularyResult>("aws:connect/getVocabulary:getVocabulary", args ?? new GetVocabularyInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetVocabularyArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Reference to the hosting Amazon Connect Instance
        /// </summary>
        [Input("instanceId", required: true)]
        public string InstanceId { get; set; } = null!;

        /// <summary>
        /// Returns information on a specific Vocabulary by name
        /// </summary>
        [Input("name")]
        public string? Name { get; set; }

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// A map of tags to assign to the Vocabulary.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        /// <summary>
        /// Returns information on a specific Vocabulary by Vocabulary id
        /// 
        /// &gt; **NOTE:** `instance_id` and one of either `name` or `vocabulary_id` is required.
        /// </summary>
        [Input("vocabularyId")]
        public string? VocabularyId { get; set; }

        public GetVocabularyArgs()
        {
        }
        public static new GetVocabularyArgs Empty => new GetVocabularyArgs();
    }

    public sealed class GetVocabularyInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Reference to the hosting Amazon Connect Instance
        /// </summary>
        [Input("instanceId", required: true)]
        public Input<string> InstanceId { get; set; } = null!;

        /// <summary>
        /// Returns information on a specific Vocabulary by name
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// A map of tags to assign to the Vocabulary.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// Returns information on a specific Vocabulary by Vocabulary id
        /// 
        /// &gt; **NOTE:** `instance_id` and one of either `name` or `vocabulary_id` is required.
        /// </summary>
        [Input("vocabularyId")]
        public Input<string>? VocabularyId { get; set; }

        public GetVocabularyInvokeArgs()
        {
        }
        public static new GetVocabularyInvokeArgs Empty => new GetVocabularyInvokeArgs();
    }


    [OutputType]
    public sealed class GetVocabularyResult
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the Vocabulary.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// The content of the custom vocabulary in plain-text format with a table of values. Each row in the table represents a word or a phrase, described with Phrase, IPA, SoundsLike, and DisplayAs fields. Separate the fields with TAB characters. For more information, see [Create a custom vocabulary using a table](https://docs.aws.amazon.com/transcribe/latest/dg/custom-vocabulary.html#create-vocabulary-table).
        /// </summary>
        public readonly string Content;
        /// <summary>
        /// The reason why the custom vocabulary was not created.
        /// </summary>
        public readonly string FailureReason;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string InstanceId;
        /// <summary>
        /// The language code of the vocabulary entries. For a list of languages and their corresponding language codes, see [What is Amazon Transcribe?](https://docs.aws.amazon.com/transcribe/latest/dg/transcribe-whatis.html). Valid Values are `ar-AE`, `de-CH`, `de-DE`, `en-AB`, `en-AU`, `en-GB`, `en-IE`, `en-IN`, `en-US`, `en-WL`, `es-ES`, `es-US`, `fr-CA`, `fr-FR`, `hi-IN`, `it-IT`, `ja-JP`, `ko-KR`, `pt-BR`, `pt-PT`, `zh-CN`.
        /// </summary>
        public readonly string LanguageCode;
        /// <summary>
        /// The timestamp when the custom vocabulary was last modified.
        /// </summary>
        public readonly string LastModifiedTime;
        public readonly string Name;
        /// <summary>
        /// The current state of the custom vocabulary. Valid values are `CREATION_IN_PROGRESS`, `ACTIVE`, `CREATION_FAILED`, `DELETE_IN_PROGRESS`.
        /// </summary>
        public readonly string State;
        /// <summary>
        /// A map of tags to assign to the Vocabulary.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;
        /// <summary>
        /// The identifier of the custom vocabulary.
        /// </summary>
        public readonly string VocabularyId;

        [OutputConstructor]
        private GetVocabularyResult(
            string arn,

            string content,

            string failureReason,

            string id,

            string instanceId,

            string languageCode,

            string lastModifiedTime,

            string name,

            string state,

            ImmutableDictionary<string, string> tags,

            string vocabularyId)
        {
            Arn = arn;
            Content = content;
            FailureReason = failureReason;
            Id = id;
            InstanceId = instanceId;
            LanguageCode = languageCode;
            LastModifiedTime = lastModifiedTime;
            Name = name;
            State = state;
            Tags = tags;
            VocabularyId = vocabularyId;
        }
    }
}
