// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock
{
    public static class GetAgentAgentVersions
    {
        /// <summary>
        /// Data source for managing an AWS Amazon BedrockAgent Agent Versions.
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
        ///     var test = Aws.Bedrock.GetAgentAgentVersions.Invoke(new()
        ///     {
        ///         AgentId = testAwsBedrockagentAgent.AgentId,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetAgentAgentVersionsResult> InvokeAsync(GetAgentAgentVersionsArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetAgentAgentVersionsResult>("aws:bedrock/getAgentAgentVersions:getAgentAgentVersions", args ?? new GetAgentAgentVersionsArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Amazon BedrockAgent Agent Versions.
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
        ///     var test = Aws.Bedrock.GetAgentAgentVersions.Invoke(new()
        ///     {
        ///         AgentId = testAwsBedrockagentAgent.AgentId,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetAgentAgentVersionsResult> Invoke(GetAgentAgentVersionsInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetAgentAgentVersionsResult>("aws:bedrock/getAgentAgentVersions:getAgentAgentVersions", args ?? new GetAgentAgentVersionsInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Amazon BedrockAgent Agent Versions.
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
        ///     var test = Aws.Bedrock.GetAgentAgentVersions.Invoke(new()
        ///     {
        ///         AgentId = testAwsBedrockagentAgent.AgentId,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetAgentAgentVersionsResult> Invoke(GetAgentAgentVersionsInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetAgentAgentVersionsResult>("aws:bedrock/getAgentAgentVersions:getAgentAgentVersions", args ?? new GetAgentAgentVersionsInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetAgentAgentVersionsArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Unique identifier of the agent.
        /// </summary>
        [Input("agentId", required: true)]
        public string AgentId { get; set; } = null!;

        [Input("agentVersionSummaries")]
        private List<Inputs.GetAgentAgentVersionsAgentVersionSummaryArgs>? _agentVersionSummaries;

        /// <summary>
        /// List of objects, each of which contains information about a version of the agent. See Agent Version Summaries
        /// </summary>
        public List<Inputs.GetAgentAgentVersionsAgentVersionSummaryArgs> AgentVersionSummaries
        {
            get => _agentVersionSummaries ?? (_agentVersionSummaries = new List<Inputs.GetAgentAgentVersionsAgentVersionSummaryArgs>());
            set => _agentVersionSummaries = value;
        }

        public GetAgentAgentVersionsArgs()
        {
        }
        public static new GetAgentAgentVersionsArgs Empty => new GetAgentAgentVersionsArgs();
    }

    public sealed class GetAgentAgentVersionsInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Unique identifier of the agent.
        /// </summary>
        [Input("agentId", required: true)]
        public Input<string> AgentId { get; set; } = null!;

        [Input("agentVersionSummaries")]
        private InputList<Inputs.GetAgentAgentVersionsAgentVersionSummaryInputArgs>? _agentVersionSummaries;

        /// <summary>
        /// List of objects, each of which contains information about a version of the agent. See Agent Version Summaries
        /// </summary>
        public InputList<Inputs.GetAgentAgentVersionsAgentVersionSummaryInputArgs> AgentVersionSummaries
        {
            get => _agentVersionSummaries ?? (_agentVersionSummaries = new InputList<Inputs.GetAgentAgentVersionsAgentVersionSummaryInputArgs>());
            set => _agentVersionSummaries = value;
        }

        public GetAgentAgentVersionsInvokeArgs()
        {
        }
        public static new GetAgentAgentVersionsInvokeArgs Empty => new GetAgentAgentVersionsInvokeArgs();
    }


    [OutputType]
    public sealed class GetAgentAgentVersionsResult
    {
        public readonly string AgentId;
        /// <summary>
        /// List of objects, each of which contains information about a version of the agent. See Agent Version Summaries
        /// </summary>
        public readonly ImmutableArray<Outputs.GetAgentAgentVersionsAgentVersionSummaryResult> AgentVersionSummaries;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;

        [OutputConstructor]
        private GetAgentAgentVersionsResult(
            string agentId,

            ImmutableArray<Outputs.GetAgentAgentVersionsAgentVersionSummaryResult> agentVersionSummaries,

            string id)
        {
            AgentId = agentId;
            AgentVersionSummaries = agentVersionSummaries;
            Id = id;
        }
    }
}
