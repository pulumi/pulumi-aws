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
    /// Subscribes to a Security Hub standard.
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
    ///     var example = new Aws.SecurityHub.Account("example");
    /// 
    ///     var current = Aws.GetRegion.Invoke();
    /// 
    ///     var cis = new Aws.SecurityHub.StandardsSubscription("cis", new()
    ///     {
    ///         StandardsArn = "arn:aws:securityhub:::ruleset/cis-aws-foundations-benchmark/v/1.2.0",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    ///     var pci321 = new Aws.SecurityHub.StandardsSubscription("pci_321", new()
    ///     {
    ///         StandardsArn = $"arn:aws:securityhub:{current.Apply(getRegionResult =&gt; getRegionResult.Name)}::standards/pci-dss/v/3.2.1",
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
    /// Using `pulumi import`, import Security Hub standards subscriptions using the standards subscription ARN. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:securityhub/standardsSubscription:StandardsSubscription cis arn:aws:securityhub:eu-west-1:123456789012:subscription/cis-aws-foundations-benchmark/v/1.2.0
    /// ```
    /// ```sh
    /// $ pulumi import aws:securityhub/standardsSubscription:StandardsSubscription pci_321 arn:aws:securityhub:eu-west-1:123456789012:subscription/pci-dss/v/3.2.1
    /// ```
    /// ```sh
    /// $ pulumi import aws:securityhub/standardsSubscription:StandardsSubscription nist_800_53_rev_5 arn:aws:securityhub:eu-west-1:123456789012:subscription/nist-800-53/v/5.0.0
    /// ```
    /// </summary>
    [AwsResourceType("aws:securityhub/standardsSubscription:StandardsSubscription")]
    public partial class StandardsSubscription : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN of a standard - see below.
        /// 
        /// Currently available standards (remember to replace `${var.partition}` and `${var.region}` as appropriate):
        /// 
        /// | Name                                     | ARN                                                                                                          |
        /// |------------------------------------------|--------------------------------------------------------------------------------------------------------------|
        /// | AWS Foundational Security Best Practices | `arn:${var.partition}:securityhub:${var.region}::standards/aws-foundational-security-best-practices/v/1.0.0` |
        /// | AWS Resource Tagging Standard            | `arn:${var.partition}:securityhub:${var.region}::standards/aws-resource-tagging-standard/v/1.0.0`            |
        /// | CIS AWS Foundations Benchmark v1.2.0     | `arn:${var.partition}:securityhub:::ruleset/cis-aws-foundations-benchmark/v/1.2.0`                           |
        /// | CIS AWS Foundations Benchmark v1.4.0     | `arn:${var.partition}:securityhub:${var.region}::standards/cis-aws-foundations-benchmark/v/1.4.0`            |
        /// | CIS AWS Foundations Benchmark v3.0.0     | `arn:${var.partition}:securityhub:${var.region}::standards/cis-aws-foundations-benchmark/v/3.0.0`            |
        /// | NIST SP 800-53 Rev. 5                    | `arn:${var.partition}:securityhub:${var.region}::standards/nist-800-53/v/5.0.0`                              |
        /// | PCI DSS                                  | `arn:${var.partition}:securityhub:${var.region}::standards/pci-dss/v/3.2.1`                                  |
        /// </summary>
        [Output("standardsArn")]
        public Output<string> StandardsArn { get; private set; } = null!;


        /// <summary>
        /// Create a StandardsSubscription resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public StandardsSubscription(string name, StandardsSubscriptionArgs args, CustomResourceOptions? options = null)
            : base("aws:securityhub/standardsSubscription:StandardsSubscription", name, args ?? new StandardsSubscriptionArgs(), MakeResourceOptions(options, ""))
        {
        }

        private StandardsSubscription(string name, Input<string> id, StandardsSubscriptionState? state = null, CustomResourceOptions? options = null)
            : base("aws:securityhub/standardsSubscription:StandardsSubscription", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing StandardsSubscription resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static StandardsSubscription Get(string name, Input<string> id, StandardsSubscriptionState? state = null, CustomResourceOptions? options = null)
        {
            return new StandardsSubscription(name, id, state, options);
        }
    }

    public sealed class StandardsSubscriptionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of a standard - see below.
        /// 
        /// Currently available standards (remember to replace `${var.partition}` and `${var.region}` as appropriate):
        /// 
        /// | Name                                     | ARN                                                                                                          |
        /// |------------------------------------------|--------------------------------------------------------------------------------------------------------------|
        /// | AWS Foundational Security Best Practices | `arn:${var.partition}:securityhub:${var.region}::standards/aws-foundational-security-best-practices/v/1.0.0` |
        /// | AWS Resource Tagging Standard            | `arn:${var.partition}:securityhub:${var.region}::standards/aws-resource-tagging-standard/v/1.0.0`            |
        /// | CIS AWS Foundations Benchmark v1.2.0     | `arn:${var.partition}:securityhub:::ruleset/cis-aws-foundations-benchmark/v/1.2.0`                           |
        /// | CIS AWS Foundations Benchmark v1.4.0     | `arn:${var.partition}:securityhub:${var.region}::standards/cis-aws-foundations-benchmark/v/1.4.0`            |
        /// | CIS AWS Foundations Benchmark v3.0.0     | `arn:${var.partition}:securityhub:${var.region}::standards/cis-aws-foundations-benchmark/v/3.0.0`            |
        /// | NIST SP 800-53 Rev. 5                    | `arn:${var.partition}:securityhub:${var.region}::standards/nist-800-53/v/5.0.0`                              |
        /// | PCI DSS                                  | `arn:${var.partition}:securityhub:${var.region}::standards/pci-dss/v/3.2.1`                                  |
        /// </summary>
        [Input("standardsArn", required: true)]
        public Input<string> StandardsArn { get; set; } = null!;

        public StandardsSubscriptionArgs()
        {
        }
        public static new StandardsSubscriptionArgs Empty => new StandardsSubscriptionArgs();
    }

    public sealed class StandardsSubscriptionState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of a standard - see below.
        /// 
        /// Currently available standards (remember to replace `${var.partition}` and `${var.region}` as appropriate):
        /// 
        /// | Name                                     | ARN                                                                                                          |
        /// |------------------------------------------|--------------------------------------------------------------------------------------------------------------|
        /// | AWS Foundational Security Best Practices | `arn:${var.partition}:securityhub:${var.region}::standards/aws-foundational-security-best-practices/v/1.0.0` |
        /// | AWS Resource Tagging Standard            | `arn:${var.partition}:securityhub:${var.region}::standards/aws-resource-tagging-standard/v/1.0.0`            |
        /// | CIS AWS Foundations Benchmark v1.2.0     | `arn:${var.partition}:securityhub:::ruleset/cis-aws-foundations-benchmark/v/1.2.0`                           |
        /// | CIS AWS Foundations Benchmark v1.4.0     | `arn:${var.partition}:securityhub:${var.region}::standards/cis-aws-foundations-benchmark/v/1.4.0`            |
        /// | CIS AWS Foundations Benchmark v3.0.0     | `arn:${var.partition}:securityhub:${var.region}::standards/cis-aws-foundations-benchmark/v/3.0.0`            |
        /// | NIST SP 800-53 Rev. 5                    | `arn:${var.partition}:securityhub:${var.region}::standards/nist-800-53/v/5.0.0`                              |
        /// | PCI DSS                                  | `arn:${var.partition}:securityhub:${var.region}::standards/pci-dss/v/3.2.1`                                  |
        /// </summary>
        [Input("standardsArn")]
        public Input<string>? StandardsArn { get; set; }

        public StandardsSubscriptionState()
        {
        }
        public static new StandardsSubscriptionState Empty => new StandardsSubscriptionState();
    }
}
