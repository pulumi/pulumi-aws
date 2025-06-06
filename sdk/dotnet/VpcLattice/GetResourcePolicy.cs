// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice
{
    public static class GetResourcePolicy
    {
        /// <summary>
        /// Data source for managing an AWS VPC Lattice Resource Policy.
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
        ///     var example = Aws.VpcLattice.GetResourcePolicy.Invoke(new()
        ///     {
        ///         ResourceArn = exampleAwsVpclatticeServiceNetwork.Arn,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetResourcePolicyResult> InvokeAsync(GetResourcePolicyArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetResourcePolicyResult>("aws:vpclattice/getResourcePolicy:getResourcePolicy", args ?? new GetResourcePolicyArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS VPC Lattice Resource Policy.
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
        ///     var example = Aws.VpcLattice.GetResourcePolicy.Invoke(new()
        ///     {
        ///         ResourceArn = exampleAwsVpclatticeServiceNetwork.Arn,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetResourcePolicyResult> Invoke(GetResourcePolicyInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetResourcePolicyResult>("aws:vpclattice/getResourcePolicy:getResourcePolicy", args ?? new GetResourcePolicyInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS VPC Lattice Resource Policy.
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
        ///     var example = Aws.VpcLattice.GetResourcePolicy.Invoke(new()
        ///     {
        ///         ResourceArn = exampleAwsVpclatticeServiceNetwork.Arn,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetResourcePolicyResult> Invoke(GetResourcePolicyInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetResourcePolicyResult>("aws:vpclattice/getResourcePolicy:getResourcePolicy", args ?? new GetResourcePolicyInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetResourcePolicyArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Resource ARN of the resource for which a policy is retrieved.
        /// </summary>
        [Input("resourceArn", required: true)]
        public string ResourceArn { get; set; } = null!;

        public GetResourcePolicyArgs()
        {
        }
        public static new GetResourcePolicyArgs Empty => new GetResourcePolicyArgs();
    }

    public sealed class GetResourcePolicyInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Resource ARN of the resource for which a policy is retrieved.
        /// </summary>
        [Input("resourceArn", required: true)]
        public Input<string> ResourceArn { get; set; } = null!;

        public GetResourcePolicyInvokeArgs()
        {
        }
        public static new GetResourcePolicyInvokeArgs Empty => new GetResourcePolicyInvokeArgs();
    }


    [OutputType]
    public sealed class GetResourcePolicyResult
    {
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// JSON-encoded string representation of the applied resource policy.
        /// </summary>
        public readonly string Policy;
        public readonly string ResourceArn;

        [OutputConstructor]
        private GetResourcePolicyResult(
            string id,

            string policy,

            string resourceArn)
        {
            Id = id;
            Policy = policy;
            ResourceArn = resourceArn;
        }
    }
}
