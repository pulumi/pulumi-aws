// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex
{
    public static class GetIntent
    {
        /// <summary>
        /// Provides details about a specific Amazon Lex Intent.
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
        ///     var orderFlowers = Aws.Lex.GetIntent.Invoke(new()
        ///     {
        ///         Name = "OrderFlowers",
        ///         Version = "$LATEST",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetIntentResult> InvokeAsync(GetIntentArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetIntentResult>("aws:lex/getIntent:getIntent", args ?? new GetIntentArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about a specific Amazon Lex Intent.
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
        ///     var orderFlowers = Aws.Lex.GetIntent.Invoke(new()
        ///     {
        ///         Name = "OrderFlowers",
        ///         Version = "$LATEST",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetIntentResult> Invoke(GetIntentInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetIntentResult>("aws:lex/getIntent:getIntent", args ?? new GetIntentInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about a specific Amazon Lex Intent.
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
        ///     var orderFlowers = Aws.Lex.GetIntent.Invoke(new()
        ///     {
        ///         Name = "OrderFlowers",
        ///         Version = "$LATEST",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetIntentResult> Invoke(GetIntentInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetIntentResult>("aws:lex/getIntent:getIntent", args ?? new GetIntentInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetIntentArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the intent. The name is case sensitive.
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        /// <summary>
        /// Version of the intent.
        /// </summary>
        [Input("version")]
        public string? Version { get; set; }

        public GetIntentArgs()
        {
        }
        public static new GetIntentArgs Empty => new GetIntentArgs();
    }

    public sealed class GetIntentInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the intent. The name is case sensitive.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// Version of the intent.
        /// </summary>
        [Input("version")]
        public Input<string>? Version { get; set; }

        public GetIntentInvokeArgs()
        {
        }
        public static new GetIntentInvokeArgs Empty => new GetIntentInvokeArgs();
    }


    [OutputType]
    public sealed class GetIntentResult
    {
        /// <summary>
        /// ARN of the Lex intent.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Checksum identifying the version of the intent that was created. The checksum is not
        /// included as an argument because the resource will add it automatically when updating the intent.
        /// </summary>
        public readonly string Checksum;
        /// <summary>
        /// Date when the intent version was created.
        /// </summary>
        public readonly string CreatedDate;
        /// <summary>
        /// Description of the intent.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Date when the $LATEST version of this intent was updated.
        /// </summary>
        public readonly string LastUpdatedDate;
        /// <summary>
        /// Name of the intent, not case sensitive.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// A unique identifier for the built-in intent to base this
        /// intent on. To find the signature for an intent, see
        /// [Standard Built-in Intents](https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/built-in-intent-ref/standard-intents)
        /// in the Alexa Skills Kit.
        /// </summary>
        public readonly string ParentIntentSignature;
        /// <summary>
        /// Version of the bot.
        /// </summary>
        public readonly string? Version;

        [OutputConstructor]
        private GetIntentResult(
            string arn,

            string checksum,

            string createdDate,

            string description,

            string id,

            string lastUpdatedDate,

            string name,

            string parentIntentSignature,

            string? version)
        {
            Arn = arn;
            Checksum = checksum;
            CreatedDate = createdDate;
            Description = description;
            Id = id;
            LastUpdatedDate = lastUpdatedDate;
            Name = name;
            ParentIntentSignature = parentIntentSignature;
            Version = version;
        }
    }
}
