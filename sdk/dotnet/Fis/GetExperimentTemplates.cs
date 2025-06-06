// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fis
{
    public static class GetExperimentTemplates
    {
        /// <summary>
        /// This resource can be useful for getting back a set of FIS experiment template IDs.
        /// 
        /// ## Example Usage
        /// 
        /// The following shows outputting a list of all FIS experiment template IDs
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var all = Aws.Fis.GetExperimentTemplates.Invoke();
        /// 
        ///     return new Dictionary&lt;string, object?&gt;
        ///     {
        ///         ["all"] = all.Apply(getExperimentTemplatesResult =&gt; getExperimentTemplatesResult.Ids),
        ///     };
        /// });
        /// ```
        /// 
        /// The following shows filtering FIS experiment templates by tag
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Fis.GetExperimentTemplates.Invoke(new()
        ///     {
        ///         Tags = 
        ///         {
        ///             { "Name", "example" },
        ///             { "Tier", "1" },
        ///         },
        ///     });
        /// 
        ///     var exampleGetPolicyDocument = Aws.Iam.GetPolicyDocument.Invoke(new()
        ///     {
        ///         Statements = new[]
        ///         {
        ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
        ///             {
        ///                 Sid = "StartFISExperiment",
        ///                 Effect = "Allow",
        ///                 Actions = new[]
        ///                 {
        ///                     "fis:StartExperiment",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     $"arn:aws:fis:*:*:experiment-template/{example.Apply(getExperimentTemplatesResult =&gt; getExperimentTemplatesResult.Ids[0])}",
        ///                     "arn:aws:fis:*:*:experiment/*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetExperimentTemplatesResult> InvokeAsync(GetExperimentTemplatesArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetExperimentTemplatesResult>("aws:fis/getExperimentTemplates:getExperimentTemplates", args ?? new GetExperimentTemplatesArgs(), options.WithDefaults());

        /// <summary>
        /// This resource can be useful for getting back a set of FIS experiment template IDs.
        /// 
        /// ## Example Usage
        /// 
        /// The following shows outputting a list of all FIS experiment template IDs
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var all = Aws.Fis.GetExperimentTemplates.Invoke();
        /// 
        ///     return new Dictionary&lt;string, object?&gt;
        ///     {
        ///         ["all"] = all.Apply(getExperimentTemplatesResult =&gt; getExperimentTemplatesResult.Ids),
        ///     };
        /// });
        /// ```
        /// 
        /// The following shows filtering FIS experiment templates by tag
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Fis.GetExperimentTemplates.Invoke(new()
        ///     {
        ///         Tags = 
        ///         {
        ///             { "Name", "example" },
        ///             { "Tier", "1" },
        ///         },
        ///     });
        /// 
        ///     var exampleGetPolicyDocument = Aws.Iam.GetPolicyDocument.Invoke(new()
        ///     {
        ///         Statements = new[]
        ///         {
        ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
        ///             {
        ///                 Sid = "StartFISExperiment",
        ///                 Effect = "Allow",
        ///                 Actions = new[]
        ///                 {
        ///                     "fis:StartExperiment",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     $"arn:aws:fis:*:*:experiment-template/{example.Apply(getExperimentTemplatesResult =&gt; getExperimentTemplatesResult.Ids[0])}",
        ///                     "arn:aws:fis:*:*:experiment/*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetExperimentTemplatesResult> Invoke(GetExperimentTemplatesInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetExperimentTemplatesResult>("aws:fis/getExperimentTemplates:getExperimentTemplates", args ?? new GetExperimentTemplatesInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// This resource can be useful for getting back a set of FIS experiment template IDs.
        /// 
        /// ## Example Usage
        /// 
        /// The following shows outputting a list of all FIS experiment template IDs
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var all = Aws.Fis.GetExperimentTemplates.Invoke();
        /// 
        ///     return new Dictionary&lt;string, object?&gt;
        ///     {
        ///         ["all"] = all.Apply(getExperimentTemplatesResult =&gt; getExperimentTemplatesResult.Ids),
        ///     };
        /// });
        /// ```
        /// 
        /// The following shows filtering FIS experiment templates by tag
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var example = Aws.Fis.GetExperimentTemplates.Invoke(new()
        ///     {
        ///         Tags = 
        ///         {
        ///             { "Name", "example" },
        ///             { "Tier", "1" },
        ///         },
        ///     });
        /// 
        ///     var exampleGetPolicyDocument = Aws.Iam.GetPolicyDocument.Invoke(new()
        ///     {
        ///         Statements = new[]
        ///         {
        ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
        ///             {
        ///                 Sid = "StartFISExperiment",
        ///                 Effect = "Allow",
        ///                 Actions = new[]
        ///                 {
        ///                     "fis:StartExperiment",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     $"arn:aws:fis:*:*:experiment-template/{example.Apply(getExperimentTemplatesResult =&gt; getExperimentTemplatesResult.Ids[0])}",
        ///                     "arn:aws:fis:*:*:experiment/*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetExperimentTemplatesResult> Invoke(GetExperimentTemplatesInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetExperimentTemplatesResult>("aws:fis/getExperimentTemplates:getExperimentTemplates", args ?? new GetExperimentTemplatesInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetExperimentTemplatesArgs : global::Pulumi.InvokeArgs
    {
        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Map of tags, each pair of which must exactly match
        /// a pair on the desired experiment templates.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetExperimentTemplatesArgs()
        {
        }
        public static new GetExperimentTemplatesArgs Empty => new GetExperimentTemplatesArgs();
    }

    public sealed class GetExperimentTemplatesInvokeArgs : global::Pulumi.InvokeArgs
    {
        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags, each pair of which must exactly match
        /// a pair on the desired experiment templates.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetExperimentTemplatesInvokeArgs()
        {
        }
        public static new GetExperimentTemplatesInvokeArgs Empty => new GetExperimentTemplatesInvokeArgs();
    }


    [OutputType]
    public sealed class GetExperimentTemplatesResult
    {
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// List of all the experiment template ids found.
        /// </summary>
        public readonly ImmutableArray<string> Ids;
        public readonly ImmutableDictionary<string, string>? Tags;

        [OutputConstructor]
        private GetExperimentTemplatesResult(
            string id,

            ImmutableArray<string> ids,

            ImmutableDictionary<string, string>? tags)
        {
            Id = id;
            Ids = ids;
            Tags = tags;
        }
    }
}
