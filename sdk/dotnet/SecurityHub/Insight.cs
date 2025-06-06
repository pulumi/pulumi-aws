// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub
{
    /// <summary>
    /// Provides a Security Hub custom insight resource. See the [Managing custom insights section](https://docs.aws.amazon.com/securityhub/latest/userguide/securityhub-custom-insights.html) of the AWS User Guide for more information.
    /// 
    /// ## Example Usage
    /// 
    /// ### Filter by AWS account ID
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleInsight = new Aws.SecurityHub.Insight("example", new()
    ///     {
    ///         Filters = new Aws.SecurityHub.Inputs.InsightFiltersArgs
    ///         {
    ///             AwsAccountIds = new[]
    ///             {
    ///                 new Aws.SecurityHub.Inputs.InsightFiltersAwsAccountIdArgs
    ///                 {
    ///                     Comparison = "EQUALS",
    ///                     Value = "1234567890",
    ///                 },
    ///                 new Aws.SecurityHub.Inputs.InsightFiltersAwsAccountIdArgs
    ///                 {
    ///                     Comparison = "EQUALS",
    ///                     Value = "09876543210",
    ///                 },
    ///             },
    ///         },
    ///         GroupByAttribute = "AwsAccountId",
    ///         Name = "example-insight",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Filter by date range
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleInsight = new Aws.SecurityHub.Insight("example", new()
    ///     {
    ///         Filters = new Aws.SecurityHub.Inputs.InsightFiltersArgs
    ///         {
    ///             CreatedAts = new[]
    ///             {
    ///                 new Aws.SecurityHub.Inputs.InsightFiltersCreatedAtArgs
    ///                 {
    ///                     DateRange = new Aws.SecurityHub.Inputs.InsightFiltersCreatedAtDateRangeArgs
    ///                     {
    ///                         Unit = "DAYS",
    ///                         Value = 5,
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///         GroupByAttribute = "CreatedAt",
    ///         Name = "example-insight",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Filter by destination IPv4 address
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleInsight = new Aws.SecurityHub.Insight("example", new()
    ///     {
    ///         Filters = new Aws.SecurityHub.Inputs.InsightFiltersArgs
    ///         {
    ///             NetworkDestinationIpv4s = new[]
    ///             {
    ///                 new Aws.SecurityHub.Inputs.InsightFiltersNetworkDestinationIpv4Args
    ///                 {
    ///                     Cidr = "10.0.0.0/16",
    ///                 },
    ///             },
    ///         },
    ///         GroupByAttribute = "NetworkDestinationIpV4",
    ///         Name = "example-insight",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Filter by finding's confidence
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleInsight = new Aws.SecurityHub.Insight("example", new()
    ///     {
    ///         Filters = new Aws.SecurityHub.Inputs.InsightFiltersArgs
    ///         {
    ///             Confidences = new[]
    ///             {
    ///                 new Aws.SecurityHub.Inputs.InsightFiltersConfidenceArgs
    ///                 {
    ///                     Gte = "80",
    ///                 },
    ///             },
    ///         },
    ///         GroupByAttribute = "Confidence",
    ///         Name = "example-insight",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Filter by resource tags
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var exampleInsight = new Aws.SecurityHub.Insight("example", new()
    ///     {
    ///         Filters = new Aws.SecurityHub.Inputs.InsightFiltersArgs
    ///         {
    ///             ResourceTags = new[]
    ///             {
    ///                 new Aws.SecurityHub.Inputs.InsightFiltersResourceTagArgs
    ///                 {
    ///                     Comparison = "EQUALS",
    ///                     Key = "Environment",
    ///                     Value = "Production",
    ///                 },
    ///             },
    ///         },
    ///         GroupByAttribute = "ResourceTags",
    ///         Name = "example-insight",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Security Hub insights using the ARN. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:securityhub/insight:Insight example arn:aws:securityhub:us-west-2:1234567890:insight/1234567890/custom/91299ed7-abd0-4e44-a858-d0b15e37141a
    /// ```
    /// </summary>
    [AwsResourceType("aws:securityhub/insight:Insight")]
    public partial class Insight : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the insight.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// A configuration block including one or more (up to 10 distinct) attributes used to filter the findings included in the insight. The insight only includes findings that match criteria defined in the filters. See filters below for more details.
        /// </summary>
        [Output("filters")]
        public Output<Outputs.InsightFilters> Filters { get; private set; } = null!;

        /// <summary>
        /// The attribute used to group the findings for the insight e.g., if an insight is grouped by `ResourceId`, then the insight produces a list of resource identifiers.
        /// </summary>
        [Output("groupByAttribute")]
        public Output<string> GroupByAttribute { get; private set; } = null!;

        /// <summary>
        /// The name of the custom insight.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;


        /// <summary>
        /// Create a Insight resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Insight(string name, InsightArgs args, CustomResourceOptions? options = null)
            : base("aws:securityhub/insight:Insight", name, args ?? new InsightArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Insight(string name, Input<string> id, InsightState? state = null, CustomResourceOptions? options = null)
            : base("aws:securityhub/insight:Insight", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing Insight resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Insight Get(string name, Input<string> id, InsightState? state = null, CustomResourceOptions? options = null)
        {
            return new Insight(name, id, state, options);
        }
    }

    public sealed class InsightArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A configuration block including one or more (up to 10 distinct) attributes used to filter the findings included in the insight. The insight only includes findings that match criteria defined in the filters. See filters below for more details.
        /// </summary>
        [Input("filters", required: true)]
        public Input<Inputs.InsightFiltersArgs> Filters { get; set; } = null!;

        /// <summary>
        /// The attribute used to group the findings for the insight e.g., if an insight is grouped by `ResourceId`, then the insight produces a list of resource identifiers.
        /// </summary>
        [Input("groupByAttribute", required: true)]
        public Input<string> GroupByAttribute { get; set; } = null!;

        /// <summary>
        /// The name of the custom insight.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        public InsightArgs()
        {
        }
        public static new InsightArgs Empty => new InsightArgs();
    }

    public sealed class InsightState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the insight.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// A configuration block including one or more (up to 10 distinct) attributes used to filter the findings included in the insight. The insight only includes findings that match criteria defined in the filters. See filters below for more details.
        /// </summary>
        [Input("filters")]
        public Input<Inputs.InsightFiltersGetArgs>? Filters { get; set; }

        /// <summary>
        /// The attribute used to group the findings for the insight e.g., if an insight is grouped by `ResourceId`, then the insight produces a list of resource identifiers.
        /// </summary>
        [Input("groupByAttribute")]
        public Input<string>? GroupByAttribute { get; set; }

        /// <summary>
        /// The name of the custom insight.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        public InsightState()
        {
        }
        public static new InsightState Empty => new InsightState();
    }
}
