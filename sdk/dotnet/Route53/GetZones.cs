// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53
{
    public static class GetZones
    {
        /// <summary>
        /// This resource can be useful for getting back a list of Route53 Hosted Zone IDs for a Region.
        /// 
        /// ## Example Usage
        /// 
        /// The following example retrieves a list of all Hosted Zone IDs.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var all = Aws.Route53.GetZones.Invoke();
        /// 
        ///     return new Dictionary&lt;string, object?&gt;
        ///     {
        ///         ["example"] = all.Apply(getZonesResult =&gt; getZonesResult.Ids),
        ///     };
        /// });
        /// ```
        /// </summary>
        public static Task<GetZonesResult> InvokeAsync(InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetZonesResult>("aws:route53/getZones:getZones", InvokeArgs.Empty, options.WithDefaults());

        /// <summary>
        /// This resource can be useful for getting back a list of Route53 Hosted Zone IDs for a Region.
        /// 
        /// ## Example Usage
        /// 
        /// The following example retrieves a list of all Hosted Zone IDs.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var all = Aws.Route53.GetZones.Invoke();
        /// 
        ///     return new Dictionary&lt;string, object?&gt;
        ///     {
        ///         ["example"] = all.Apply(getZonesResult =&gt; getZonesResult.Ids),
        ///     };
        /// });
        /// ```
        /// </summary>
        public static Output<GetZonesResult> Invoke(InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetZonesResult>("aws:route53/getZones:getZones", InvokeArgs.Empty, options.WithDefaults());

        /// <summary>
        /// This resource can be useful for getting back a list of Route53 Hosted Zone IDs for a Region.
        /// 
        /// ## Example Usage
        /// 
        /// The following example retrieves a list of all Hosted Zone IDs.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var all = Aws.Route53.GetZones.Invoke();
        /// 
        ///     return new Dictionary&lt;string, object?&gt;
        ///     {
        ///         ["example"] = all.Apply(getZonesResult =&gt; getZonesResult.Ids),
        ///     };
        /// });
        /// ```
        /// </summary>
        public static Output<GetZonesResult> Invoke(InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetZonesResult>("aws:route53/getZones:getZones", InvokeArgs.Empty, options.WithDefaults());
    }


    [OutputType]
    public sealed class GetZonesResult
    {
        public readonly string Id;
        /// <summary>
        /// A list of all the Route53 Hosted Zone IDs found.
        /// </summary>
        public readonly ImmutableArray<string> Ids;

        [OutputConstructor]
        private GetZonesResult(
            string id,

            ImmutableArray<string> ids)
        {
            Id = id;
            Ids = ids;
        }
    }
}
