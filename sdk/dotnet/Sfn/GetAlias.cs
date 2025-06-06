// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sfn
{
    public static class GetAlias
    {
        /// <summary>
        /// Data source for managing an AWS SFN (Step Functions) State Machine Alias.
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
        ///     var example = Aws.Sfn.GetAlias.Invoke(new()
        ///     {
        ///         Name = "my_sfn_alias",
        ///         StatemachineArn = sfnTest.Arn,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetAliasResult> InvokeAsync(GetAliasArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetAliasResult>("aws:sfn/getAlias:getAlias", args ?? new GetAliasArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS SFN (Step Functions) State Machine Alias.
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
        ///     var example = Aws.Sfn.GetAlias.Invoke(new()
        ///     {
        ///         Name = "my_sfn_alias",
        ///         StatemachineArn = sfnTest.Arn,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetAliasResult> Invoke(GetAliasInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetAliasResult>("aws:sfn/getAlias:getAlias", args ?? new GetAliasInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS SFN (Step Functions) State Machine Alias.
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
        ///     var example = Aws.Sfn.GetAlias.Invoke(new()
        ///     {
        ///         Name = "my_sfn_alias",
        ///         StatemachineArn = sfnTest.Arn,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetAliasResult> Invoke(GetAliasInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetAliasResult>("aws:sfn/getAlias:getAlias", args ?? new GetAliasInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetAliasArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Description of state machine alias.
        /// </summary>
        [Input("description")]
        public string? Description { get; set; }

        /// <summary>
        /// Name of the State Machine alias.
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        /// <summary>
        /// ARN of the State Machine.
        /// </summary>
        [Input("statemachineArn", required: true)]
        public string StatemachineArn { get; set; } = null!;

        public GetAliasArgs()
        {
        }
        public static new GetAliasArgs Empty => new GetAliasArgs();
    }

    public sealed class GetAliasInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Description of state machine alias.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Name of the State Machine alias.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// ARN of the State Machine.
        /// </summary>
        [Input("statemachineArn", required: true)]
        public Input<string> StatemachineArn { get; set; } = null!;

        public GetAliasInvokeArgs()
        {
        }
        public static new GetAliasInvokeArgs Empty => new GetAliasInvokeArgs();
    }


    [OutputType]
    public sealed class GetAliasResult
    {
        /// <summary>
        /// ARN identifying the State Machine alias.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Date the state machine Alias was created.
        /// </summary>
        public readonly string CreationDate;
        /// <summary>
        /// Description of state machine alias.
        /// </summary>
        public readonly string? Description;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string Name;
        /// <summary>
        /// Routing Configuration of state machine alias
        /// </summary>
        public readonly ImmutableArray<Outputs.GetAliasRoutingConfigurationResult> RoutingConfigurations;
        public readonly string StatemachineArn;

        [OutputConstructor]
        private GetAliasResult(
            string arn,

            string creationDate,

            string? description,

            string id,

            string name,

            ImmutableArray<Outputs.GetAliasRoutingConfigurationResult> routingConfigurations,

            string statemachineArn)
        {
            Arn = arn;
            CreationDate = creationDate;
            Description = description;
            Id = id;
            Name = name;
            RoutingConfigurations = routingConfigurations;
            StatemachineArn = statemachineArn;
        }
    }
}
