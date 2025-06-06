// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LB
{
    public static class GetLbs
    {
        /// <summary>
        /// Use this data source to get a list of Load Balancer ARNs matching the specified criteria. Useful for passing to other
        /// resources.
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
        ///     var example = Aws.LB.GetLbs.Invoke(new()
        ///     {
        ///         Tags = 
        ///         {
        ///             { "elbv2.k8s.aws/cluster", "my-cluster" },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetLbsResult> InvokeAsync(GetLbsArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetLbsResult>("aws:lb/getLbs:getLbs", args ?? new GetLbsArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get a list of Load Balancer ARNs matching the specified criteria. Useful for passing to other
        /// resources.
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
        ///     var example = Aws.LB.GetLbs.Invoke(new()
        ///     {
        ///         Tags = 
        ///         {
        ///             { "elbv2.k8s.aws/cluster", "my-cluster" },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetLbsResult> Invoke(GetLbsInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetLbsResult>("aws:lb/getLbs:getLbs", args ?? new GetLbsInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get a list of Load Balancer ARNs matching the specified criteria. Useful for passing to other
        /// resources.
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
        ///     var example = Aws.LB.GetLbs.Invoke(new()
        ///     {
        ///         Tags = 
        ///         {
        ///             { "elbv2.k8s.aws/cluster", "my-cluster" },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetLbsResult> Invoke(GetLbsInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetLbsResult>("aws:lb/getLbs:getLbs", args ?? new GetLbsInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetLbsArgs : global::Pulumi.InvokeArgs
    {
        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Map of tags, each pair of which must exactly match
        /// a pair on the desired Load Balancers.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetLbsArgs()
        {
        }
        public static new GetLbsArgs Empty => new GetLbsArgs();
    }

    public sealed class GetLbsInvokeArgs : global::Pulumi.InvokeArgs
    {
        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags, each pair of which must exactly match
        /// a pair on the desired Load Balancers.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetLbsInvokeArgs()
        {
        }
        public static new GetLbsInvokeArgs Empty => new GetLbsInvokeArgs();
    }


    [OutputType]
    public sealed class GetLbsResult
    {
        /// <summary>
        /// Set of Load Balancer ARNs.
        /// </summary>
        public readonly ImmutableArray<string> Arns;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly ImmutableDictionary<string, string>? Tags;

        [OutputConstructor]
        private GetLbsResult(
            ImmutableArray<string> arns,

            string id,

            ImmutableDictionary<string, string>? tags)
        {
            Arns = arns;
            Id = id;
            Tags = tags;
        }
    }
}
