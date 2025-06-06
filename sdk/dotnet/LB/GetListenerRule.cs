// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LB
{
    public static class GetListenerRule
    {
        /// <summary>
        /// Provides information about an AWS Elastic Load Balancing Listener Rule.
        /// 
        /// ## Example Usage
        /// 
        /// ### Match by Rule ARN
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var config = new Config();
        ///     var lbRuleArn = config.Require("lbRuleArn");
        ///     var example = Aws.LB.GetListenerRule.Invoke(new()
        ///     {
        ///         Arn = lbRuleArn,
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### Match by Listener ARN and Priority
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var config = new Config();
        ///     var lbListenerArn = config.Require("lbListenerArn");
        ///     var lbRulePriority = config.RequireDouble("lbRulePriority");
        ///     var example = Aws.LB.GetListenerRule.Invoke(new()
        ///     {
        ///         ListenerArn = lbListenerArn,
        ///         Priority = lbRulePriority,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetListenerRuleResult> InvokeAsync(GetListenerRuleArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetListenerRuleResult>("aws:lb/getListenerRule:getListenerRule", args ?? new GetListenerRuleArgs(), options.WithDefaults());

        /// <summary>
        /// Provides information about an AWS Elastic Load Balancing Listener Rule.
        /// 
        /// ## Example Usage
        /// 
        /// ### Match by Rule ARN
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var config = new Config();
        ///     var lbRuleArn = config.Require("lbRuleArn");
        ///     var example = Aws.LB.GetListenerRule.Invoke(new()
        ///     {
        ///         Arn = lbRuleArn,
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### Match by Listener ARN and Priority
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var config = new Config();
        ///     var lbListenerArn = config.Require("lbListenerArn");
        ///     var lbRulePriority = config.RequireDouble("lbRulePriority");
        ///     var example = Aws.LB.GetListenerRule.Invoke(new()
        ///     {
        ///         ListenerArn = lbListenerArn,
        ///         Priority = lbRulePriority,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetListenerRuleResult> Invoke(GetListenerRuleInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetListenerRuleResult>("aws:lb/getListenerRule:getListenerRule", args ?? new GetListenerRuleInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Provides information about an AWS Elastic Load Balancing Listener Rule.
        /// 
        /// ## Example Usage
        /// 
        /// ### Match by Rule ARN
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var config = new Config();
        ///     var lbRuleArn = config.Require("lbRuleArn");
        ///     var example = Aws.LB.GetListenerRule.Invoke(new()
        ///     {
        ///         Arn = lbRuleArn,
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ### Match by Listener ARN and Priority
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var config = new Config();
        ///     var lbListenerArn = config.Require("lbListenerArn");
        ///     var lbRulePriority = config.RequireDouble("lbRulePriority");
        ///     var example = Aws.LB.GetListenerRule.Invoke(new()
        ///     {
        ///         ListenerArn = lbListenerArn,
        ///         Priority = lbRulePriority,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetListenerRuleResult> Invoke(GetListenerRuleInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetListenerRuleResult>("aws:lb/getListenerRule:getListenerRule", args ?? new GetListenerRuleInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetListenerRuleArgs : global::Pulumi.InvokeArgs
    {
        [Input("actions")]
        private List<Inputs.GetListenerRuleActionArgs>? _actions;

        /// <summary>
        /// List of actions associated with the rule, sorted by `order`.
        /// Detailed below.
        /// </summary>
        public List<Inputs.GetListenerRuleActionArgs> Actions
        {
            get => _actions ?? (_actions = new List<Inputs.GetListenerRuleActionArgs>());
            set => _actions = value;
        }

        /// <summary>
        /// ARN of the Listener Rule.
        /// Either `arn` or `listener_arn` must be set.
        /// </summary>
        [Input("arn")]
        public string? Arn { get; set; }

        [Input("conditions")]
        private List<Inputs.GetListenerRuleConditionArgs>? _conditions;

        /// <summary>
        /// Set of conditions associated with the rule.
        /// Detailed below.
        /// </summary>
        public List<Inputs.GetListenerRuleConditionArgs> Conditions
        {
            get => _conditions ?? (_conditions = new List<Inputs.GetListenerRuleConditionArgs>());
            set => _conditions = value;
        }

        /// <summary>
        /// ARN of the associated Listener.
        /// Either `arn` or `listener_arn` must be set.
        /// </summary>
        [Input("listenerArn")]
        public string? ListenerArn { get; set; }

        /// <summary>
        /// Priority of the Listener Rule within the Listener.
        /// Must be set if `listener_arn` is set, otherwise must not be set.
        /// </summary>
        [Input("priority")]
        public int? Priority { get; set; }

        public GetListenerRuleArgs()
        {
        }
        public static new GetListenerRuleArgs Empty => new GetListenerRuleArgs();
    }

    public sealed class GetListenerRuleInvokeArgs : global::Pulumi.InvokeArgs
    {
        [Input("actions")]
        private InputList<Inputs.GetListenerRuleActionInputArgs>? _actions;

        /// <summary>
        /// List of actions associated with the rule, sorted by `order`.
        /// Detailed below.
        /// </summary>
        public InputList<Inputs.GetListenerRuleActionInputArgs> Actions
        {
            get => _actions ?? (_actions = new InputList<Inputs.GetListenerRuleActionInputArgs>());
            set => _actions = value;
        }

        /// <summary>
        /// ARN of the Listener Rule.
        /// Either `arn` or `listener_arn` must be set.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("conditions")]
        private InputList<Inputs.GetListenerRuleConditionInputArgs>? _conditions;

        /// <summary>
        /// Set of conditions associated with the rule.
        /// Detailed below.
        /// </summary>
        public InputList<Inputs.GetListenerRuleConditionInputArgs> Conditions
        {
            get => _conditions ?? (_conditions = new InputList<Inputs.GetListenerRuleConditionInputArgs>());
            set => _conditions = value;
        }

        /// <summary>
        /// ARN of the associated Listener.
        /// Either `arn` or `listener_arn` must be set.
        /// </summary>
        [Input("listenerArn")]
        public Input<string>? ListenerArn { get; set; }

        /// <summary>
        /// Priority of the Listener Rule within the Listener.
        /// Must be set if `listener_arn` is set, otherwise must not be set.
        /// </summary>
        [Input("priority")]
        public Input<int>? Priority { get; set; }

        public GetListenerRuleInvokeArgs()
        {
        }
        public static new GetListenerRuleInvokeArgs Empty => new GetListenerRuleInvokeArgs();
    }


    [OutputType]
    public sealed class GetListenerRuleResult
    {
        /// <summary>
        /// List of actions associated with the rule, sorted by `order`.
        /// Detailed below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetListenerRuleActionResult> Actions;
        /// <summary>
        /// ARN of the target group.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Set of conditions associated with the rule.
        /// Detailed below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetListenerRuleConditionResult> Conditions;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string ListenerArn;
        public readonly int Priority;
        /// <summary>
        /// Tags assigned to the Listener Rule.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;

        [OutputConstructor]
        private GetListenerRuleResult(
            ImmutableArray<Outputs.GetListenerRuleActionResult> actions,

            string arn,

            ImmutableArray<Outputs.GetListenerRuleConditionResult> conditions,

            string id,

            string listenerArn,

            int priority,

            ImmutableDictionary<string, string> tags)
        {
            Actions = actions;
            Arn = arn;
            Conditions = conditions;
            Id = id;
            ListenerArn = listenerArn;
            Priority = priority;
            Tags = tags;
        }
    }
}
