// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53
{
    public static class GetDelegationSet
    {
        /// <summary>
        /// `aws.route53.DelegationSet` provides details about a specific Route 53 Delegation Set.
        /// 
        /// This data source allows to find a list of name servers associated with a specific delegation set.
        /// 
        /// ## Example Usage
        /// 
        /// The following example shows how to get a delegation set from its id.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var dset = Aws.Route53.GetDelegationSet.Invoke(new()
        ///     {
        ///         Id = "MQWGHCBFAKEID",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetDelegationSetResult> InvokeAsync(GetDelegationSetArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetDelegationSetResult>("aws:route53/getDelegationSet:getDelegationSet", args ?? new GetDelegationSetArgs(), options.WithDefaults());

        /// <summary>
        /// `aws.route53.DelegationSet` provides details about a specific Route 53 Delegation Set.
        /// 
        /// This data source allows to find a list of name servers associated with a specific delegation set.
        /// 
        /// ## Example Usage
        /// 
        /// The following example shows how to get a delegation set from its id.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var dset = Aws.Route53.GetDelegationSet.Invoke(new()
        ///     {
        ///         Id = "MQWGHCBFAKEID",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetDelegationSetResult> Invoke(GetDelegationSetInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetDelegationSetResult>("aws:route53/getDelegationSet:getDelegationSet", args ?? new GetDelegationSetInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// `aws.route53.DelegationSet` provides details about a specific Route 53 Delegation Set.
        /// 
        /// This data source allows to find a list of name servers associated with a specific delegation set.
        /// 
        /// ## Example Usage
        /// 
        /// The following example shows how to get a delegation set from its id.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var dset = Aws.Route53.GetDelegationSet.Invoke(new()
        ///     {
        ///         Id = "MQWGHCBFAKEID",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetDelegationSetResult> Invoke(GetDelegationSetInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetDelegationSetResult>("aws:route53/getDelegationSet:getDelegationSet", args ?? new GetDelegationSetInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetDelegationSetArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Delegation set ID.
        /// </summary>
        [Input("id", required: true)]
        public string Id { get; set; } = null!;

        public GetDelegationSetArgs()
        {
        }
        public static new GetDelegationSetArgs Empty => new GetDelegationSetArgs();
    }

    public sealed class GetDelegationSetInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Delegation set ID.
        /// </summary>
        [Input("id", required: true)]
        public Input<string> Id { get; set; } = null!;

        public GetDelegationSetInvokeArgs()
        {
        }
        public static new GetDelegationSetInvokeArgs Empty => new GetDelegationSetInvokeArgs();
    }


    [OutputType]
    public sealed class GetDelegationSetResult
    {
        /// <summary>
        /// ARN of the Delegation Set.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Caller Reference of the delegation set.
        /// </summary>
        public readonly string CallerReference;
        public readonly string Id;
        /// <summary>
        /// List of DNS name servers for the delegation set.
        /// </summary>
        public readonly ImmutableArray<string> NameServers;

        [OutputConstructor]
        private GetDelegationSetResult(
            string arn,

            string callerReference,

            string id,

            ImmutableArray<string> nameServers)
        {
            Arn = arn;
            CallerReference = callerReference;
            Id = id;
            NameServers = nameServers;
        }
    }
}
