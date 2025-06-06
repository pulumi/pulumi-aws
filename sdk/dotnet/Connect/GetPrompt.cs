// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Connect
{
    public static class GetPrompt
    {
        /// <summary>
        /// Provides details about a specific Amazon Connect Prompt.
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
        ///     var example = Aws.Connect.GetPrompt.Invoke(new()
        ///     {
        ///         InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        ///         Name = "Beep.wav",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetPromptResult> InvokeAsync(GetPromptArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetPromptResult>("aws:connect/getPrompt:getPrompt", args ?? new GetPromptArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about a specific Amazon Connect Prompt.
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
        ///     var example = Aws.Connect.GetPrompt.Invoke(new()
        ///     {
        ///         InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        ///         Name = "Beep.wav",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetPromptResult> Invoke(GetPromptInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetPromptResult>("aws:connect/getPrompt:getPrompt", args ?? new GetPromptInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about a specific Amazon Connect Prompt.
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
        ///     var example = Aws.Connect.GetPrompt.Invoke(new()
        ///     {
        ///         InstanceId = "aaaaaaaa-bbbb-cccc-dddd-111111111111",
        ///         Name = "Beep.wav",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetPromptResult> Invoke(GetPromptInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetPromptResult>("aws:connect/getPrompt:getPrompt", args ?? new GetPromptInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetPromptArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Reference to the hosting Amazon Connect Instance
        /// </summary>
        [Input("instanceId", required: true)]
        public string InstanceId { get; set; } = null!;

        /// <summary>
        /// Returns information on a specific Prompt by name
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        public GetPromptArgs()
        {
        }
        public static new GetPromptArgs Empty => new GetPromptArgs();
    }

    public sealed class GetPromptInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Reference to the hosting Amazon Connect Instance
        /// </summary>
        [Input("instanceId", required: true)]
        public Input<string> InstanceId { get; set; } = null!;

        /// <summary>
        /// Returns information on a specific Prompt by name
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        public GetPromptInvokeArgs()
        {
        }
        public static new GetPromptInvokeArgs Empty => new GetPromptInvokeArgs();
    }


    [OutputType]
    public sealed class GetPromptResult
    {
        /// <summary>
        /// ARN of the Prompt.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string InstanceId;
        public readonly string Name;
        /// <summary>
        /// Identifier for the prompt.
        /// </summary>
        public readonly string PromptId;

        [OutputConstructor]
        private GetPromptResult(
            string arn,

            string id,

            string instanceId,

            string name,

            string promptId)
        {
            Arn = arn;
            Id = id;
            InstanceId = instanceId;
            Name = name;
            PromptId = promptId;
        }
    }
}
