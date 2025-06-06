// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ElastiCache
{
    public static class GetReservedCacheNodeOffering
    {
        /// <summary>
        /// Information about a single ElastiCache Reserved Cache Node Offering.
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
        ///     var example = Aws.ElastiCache.GetReservedCacheNodeOffering.Invoke(new()
        ///     {
        ///         CacheNodeType = "cache.t4g.small",
        ///         Duration = "P1Y",
        ///         OfferingType = "No Upfront",
        ///         ProductDescription = "redis",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetReservedCacheNodeOfferingResult> InvokeAsync(GetReservedCacheNodeOfferingArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetReservedCacheNodeOfferingResult>("aws:elasticache/getReservedCacheNodeOffering:getReservedCacheNodeOffering", args ?? new GetReservedCacheNodeOfferingArgs(), options.WithDefaults());

        /// <summary>
        /// Information about a single ElastiCache Reserved Cache Node Offering.
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
        ///     var example = Aws.ElastiCache.GetReservedCacheNodeOffering.Invoke(new()
        ///     {
        ///         CacheNodeType = "cache.t4g.small",
        ///         Duration = "P1Y",
        ///         OfferingType = "No Upfront",
        ///         ProductDescription = "redis",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetReservedCacheNodeOfferingResult> Invoke(GetReservedCacheNodeOfferingInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetReservedCacheNodeOfferingResult>("aws:elasticache/getReservedCacheNodeOffering:getReservedCacheNodeOffering", args ?? new GetReservedCacheNodeOfferingInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Information about a single ElastiCache Reserved Cache Node Offering.
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
        ///     var example = Aws.ElastiCache.GetReservedCacheNodeOffering.Invoke(new()
        ///     {
        ///         CacheNodeType = "cache.t4g.small",
        ///         Duration = "P1Y",
        ///         OfferingType = "No Upfront",
        ///         ProductDescription = "redis",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetReservedCacheNodeOfferingResult> Invoke(GetReservedCacheNodeOfferingInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetReservedCacheNodeOfferingResult>("aws:elasticache/getReservedCacheNodeOffering:getReservedCacheNodeOffering", args ?? new GetReservedCacheNodeOfferingInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetReservedCacheNodeOfferingArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Node type for the reserved cache node.
        /// See AWS documentation for information on [supported node types for Redis](https://docs.aws.amazon.com/AmazonElastiCache/latest/red-ug/CacheNodes.SupportedTypes.html) and [guidance on selecting node types for Redis](https://docs.aws.amazon.com/AmazonElastiCache/latest/red-ug/nodes-select-size.html).
        /// See AWS documentation for information on [supported node types for Memcached](https://docs.aws.amazon.com/AmazonElastiCache/latest/mem-ug/CacheNodes.SupportedTypes.html) and [guidance on selecting node types for Memcached](https://docs.aws.amazon.com/AmazonElastiCache/latest/mem-ug/nodes-select-size.html).
        /// </summary>
        [Input("cacheNodeType", required: true)]
        public string CacheNodeType { get; set; } = null!;

        /// <summary>
        /// Duration of the reservation in RFC3339 duration format.
        /// Valid values are `P1Y` (one year) and `P3Y` (three years).
        /// </summary>
        [Input("duration", required: true)]
        public string Duration { get; set; } = null!;

        /// <summary>
        /// Offering type of this reserved cache node.
        /// For the latest generation of nodes (e.g. M5, R5, T4 and newer) valid values are `No Upfront`, `Partial Upfront`, and `All Upfront`.
        /// For other current generation nodes (i.e. T2, M3, M4, R3, or R4) the only valid value is `Heavy Utilization`.
        /// For previous generation modes (i.e. T1, M1, M2, or C1) valid values are `Heavy Utilization`, `Medium Utilization`, and `Light Utilization`.
        /// </summary>
        [Input("offeringType", required: true)]
        public string OfferingType { get; set; } = null!;

        /// <summary>
        /// Engine type for the reserved cache node.
        /// Valid values are `redis`, `valkey` and `memcached`.
        /// </summary>
        [Input("productDescription", required: true)]
        public string ProductDescription { get; set; } = null!;

        public GetReservedCacheNodeOfferingArgs()
        {
        }
        public static new GetReservedCacheNodeOfferingArgs Empty => new GetReservedCacheNodeOfferingArgs();
    }

    public sealed class GetReservedCacheNodeOfferingInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Node type for the reserved cache node.
        /// See AWS documentation for information on [supported node types for Redis](https://docs.aws.amazon.com/AmazonElastiCache/latest/red-ug/CacheNodes.SupportedTypes.html) and [guidance on selecting node types for Redis](https://docs.aws.amazon.com/AmazonElastiCache/latest/red-ug/nodes-select-size.html).
        /// See AWS documentation for information on [supported node types for Memcached](https://docs.aws.amazon.com/AmazonElastiCache/latest/mem-ug/CacheNodes.SupportedTypes.html) and [guidance on selecting node types for Memcached](https://docs.aws.amazon.com/AmazonElastiCache/latest/mem-ug/nodes-select-size.html).
        /// </summary>
        [Input("cacheNodeType", required: true)]
        public Input<string> CacheNodeType { get; set; } = null!;

        /// <summary>
        /// Duration of the reservation in RFC3339 duration format.
        /// Valid values are `P1Y` (one year) and `P3Y` (three years).
        /// </summary>
        [Input("duration", required: true)]
        public Input<string> Duration { get; set; } = null!;

        /// <summary>
        /// Offering type of this reserved cache node.
        /// For the latest generation of nodes (e.g. M5, R5, T4 and newer) valid values are `No Upfront`, `Partial Upfront`, and `All Upfront`.
        /// For other current generation nodes (i.e. T2, M3, M4, R3, or R4) the only valid value is `Heavy Utilization`.
        /// For previous generation modes (i.e. T1, M1, M2, or C1) valid values are `Heavy Utilization`, `Medium Utilization`, and `Light Utilization`.
        /// </summary>
        [Input("offeringType", required: true)]
        public Input<string> OfferingType { get; set; } = null!;

        /// <summary>
        /// Engine type for the reserved cache node.
        /// Valid values are `redis`, `valkey` and `memcached`.
        /// </summary>
        [Input("productDescription", required: true)]
        public Input<string> ProductDescription { get; set; } = null!;

        public GetReservedCacheNodeOfferingInvokeArgs()
        {
        }
        public static new GetReservedCacheNodeOfferingInvokeArgs Empty => new GetReservedCacheNodeOfferingInvokeArgs();
    }


    [OutputType]
    public sealed class GetReservedCacheNodeOfferingResult
    {
        public readonly string CacheNodeType;
        public readonly string Duration;
        /// <summary>
        /// Fixed price charged for this reserved cache node.
        /// </summary>
        public readonly double FixedPrice;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Unique identifier for the reservation.
        /// </summary>
        public readonly string OfferingId;
        public readonly string OfferingType;
        public readonly string ProductDescription;

        [OutputConstructor]
        private GetReservedCacheNodeOfferingResult(
            string cacheNodeType,

            string duration,

            double fixedPrice,

            string id,

            string offeringId,

            string offeringType,

            string productDescription)
        {
            CacheNodeType = cacheNodeType;
            Duration = duration;
            FixedPrice = fixedPrice;
            Id = id;
            OfferingId = offeringId;
            OfferingType = offeringType;
            ProductDescription = productDescription;
        }
    }
}
