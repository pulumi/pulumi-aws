// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Alb
{
    public static class GetTargetGroup
    {
        /// <summary>
        /// &gt; **Note:** `aws.alb.TargetGroup` is known as `aws.lb.TargetGroup`. The functionality is identical.
        /// 
        /// Provides information about a Load Balancer Target Group.
        /// 
        /// This data source can prove useful when a module accepts an LB Target Group as an
        /// input variable and needs to know its attributes. It can also be used to get the ARN of
        /// an LB Target Group for use in other resources, given LB Target Group name.
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
        ///     var config = new Config();
        ///     var lbTgArn = config.Get("lbTgArn") ?? "";
        ///     var lbTgName = config.Get("lbTgName") ?? "";
        ///     var test = Aws.LB.GetTargetGroup.Invoke(new()
        ///     {
        ///         Arn = lbTgArn,
        ///         Name = lbTgName,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetTargetGroupResult> InvokeAsync(GetTargetGroupArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetTargetGroupResult>("aws:alb/getTargetGroup:getTargetGroup", args ?? new GetTargetGroupArgs(), options.WithDefaults());

        /// <summary>
        /// &gt; **Note:** `aws.alb.TargetGroup` is known as `aws.lb.TargetGroup`. The functionality is identical.
        /// 
        /// Provides information about a Load Balancer Target Group.
        /// 
        /// This data source can prove useful when a module accepts an LB Target Group as an
        /// input variable and needs to know its attributes. It can also be used to get the ARN of
        /// an LB Target Group for use in other resources, given LB Target Group name.
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
        ///     var config = new Config();
        ///     var lbTgArn = config.Get("lbTgArn") ?? "";
        ///     var lbTgName = config.Get("lbTgName") ?? "";
        ///     var test = Aws.LB.GetTargetGroup.Invoke(new()
        ///     {
        ///         Arn = lbTgArn,
        ///         Name = lbTgName,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetTargetGroupResult> Invoke(GetTargetGroupInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetTargetGroupResult>("aws:alb/getTargetGroup:getTargetGroup", args ?? new GetTargetGroupInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// &gt; **Note:** `aws.alb.TargetGroup` is known as `aws.lb.TargetGroup`. The functionality is identical.
        /// 
        /// Provides information about a Load Balancer Target Group.
        /// 
        /// This data source can prove useful when a module accepts an LB Target Group as an
        /// input variable and needs to know its attributes. It can also be used to get the ARN of
        /// an LB Target Group for use in other resources, given LB Target Group name.
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
        ///     var config = new Config();
        ///     var lbTgArn = config.Get("lbTgArn") ?? "";
        ///     var lbTgName = config.Get("lbTgName") ?? "";
        ///     var test = Aws.LB.GetTargetGroup.Invoke(new()
        ///     {
        ///         Arn = lbTgArn,
        ///         Name = lbTgName,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetTargetGroupResult> Invoke(GetTargetGroupInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetTargetGroupResult>("aws:alb/getTargetGroup:getTargetGroup", args ?? new GetTargetGroupInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetTargetGroupArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Full ARN of the target group.
        /// </summary>
        [Input("arn")]
        public string? Arn { get; set; }

        [Input("loadBalancingAnomalyMitigation")]
        public string? LoadBalancingAnomalyMitigation { get; set; }

        /// <summary>
        /// Unique name of the target group.
        /// </summary>
        [Input("name")]
        public string? Name { get; set; }

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Mapping of tags, each pair of which must exactly match a pair on the desired target group.
        /// 
        /// &gt; **NOTE:** When both `arn` and `name` are specified, `arn` takes precedence. `tags` has the lowest precedence.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetTargetGroupArgs()
        {
        }
        public static new GetTargetGroupArgs Empty => new GetTargetGroupArgs();
    }

    public sealed class GetTargetGroupInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Full ARN of the target group.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        [Input("loadBalancingAnomalyMitigation")]
        public Input<string>? LoadBalancingAnomalyMitigation { get; set; }

        /// <summary>
        /// Unique name of the target group.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Mapping of tags, each pair of which must exactly match a pair on the desired target group.
        /// 
        /// &gt; **NOTE:** When both `arn` and `name` are specified, `arn` takes precedence. `tags` has the lowest precedence.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetTargetGroupInvokeArgs()
        {
        }
        public static new GetTargetGroupInvokeArgs Empty => new GetTargetGroupInvokeArgs();
    }


    [OutputType]
    public sealed class GetTargetGroupResult
    {
        public readonly string Arn;
        public readonly string ArnSuffix;
        public readonly bool ConnectionTermination;
        public readonly string DeregistrationDelay;
        public readonly Outputs.GetTargetGroupHealthCheckResult HealthCheck;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly bool LambdaMultiValueHeadersEnabled;
        public readonly ImmutableArray<string> LoadBalancerArns;
        public readonly string LoadBalancingAlgorithmType;
        public readonly string LoadBalancingAnomalyMitigation;
        public readonly string LoadBalancingCrossZoneEnabled;
        public readonly string Name;
        public readonly int Port;
        public readonly string PreserveClientIp;
        public readonly string Protocol;
        public readonly string ProtocolVersion;
        public readonly bool ProxyProtocolV2;
        public readonly int SlowStart;
        public readonly Outputs.GetTargetGroupStickinessResult Stickiness;
        public readonly ImmutableDictionary<string, string> Tags;
        public readonly string TargetType;
        public readonly string VpcId;

        [OutputConstructor]
        private GetTargetGroupResult(
            string arn,

            string arnSuffix,

            bool connectionTermination,

            string deregistrationDelay,

            Outputs.GetTargetGroupHealthCheckResult healthCheck,

            string id,

            bool lambdaMultiValueHeadersEnabled,

            ImmutableArray<string> loadBalancerArns,

            string loadBalancingAlgorithmType,

            string loadBalancingAnomalyMitigation,

            string loadBalancingCrossZoneEnabled,

            string name,

            int port,

            string preserveClientIp,

            string protocol,

            string protocolVersion,

            bool proxyProtocolV2,

            int slowStart,

            Outputs.GetTargetGroupStickinessResult stickiness,

            ImmutableDictionary<string, string> tags,

            string targetType,

            string vpcId)
        {
            Arn = arn;
            ArnSuffix = arnSuffix;
            ConnectionTermination = connectionTermination;
            DeregistrationDelay = deregistrationDelay;
            HealthCheck = healthCheck;
            Id = id;
            LambdaMultiValueHeadersEnabled = lambdaMultiValueHeadersEnabled;
            LoadBalancerArns = loadBalancerArns;
            LoadBalancingAlgorithmType = loadBalancingAlgorithmType;
            LoadBalancingAnomalyMitigation = loadBalancingAnomalyMitigation;
            LoadBalancingCrossZoneEnabled = loadBalancingCrossZoneEnabled;
            Name = name;
            Port = port;
            PreserveClientIp = preserveClientIp;
            Protocol = protocol;
            ProtocolVersion = protocolVersion;
            ProxyProtocolV2 = proxyProtocolV2;
            SlowStart = slowStart;
            Stickiness = stickiness;
            Tags = tags;
            TargetType = targetType;
            VpcId = vpcId;
        }
    }
}
