// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Waf
{
    /// <summary>
    /// Provides a WAF Web ACL Resource
    /// 
    /// ## Example Usage
    /// 
    /// This example blocks requests coming from `192.0.7.0/24` and allows everything else.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var ipset = new Aws.Waf.IpSet("ipset", new()
    ///     {
    ///         Name = "tfIPSet",
    ///         IpSetDescriptors = new[]
    ///         {
    ///             new Aws.Waf.Inputs.IpSetIpSetDescriptorArgs
    ///             {
    ///                 Type = "IPV4",
    ///                 Value = "192.0.7.0/24",
    ///             },
    ///         },
    ///     });
    /// 
    ///     var wafrule = new Aws.Waf.Rule("wafrule", new()
    ///     {
    ///         Name = "tfWAFRule",
    ///         MetricName = "tfWAFRule",
    ///         Predicates = new[]
    ///         {
    ///             new Aws.Waf.Inputs.RulePredicateArgs
    ///             {
    ///                 DataId = ipset.Id,
    ///                 Negated = false,
    ///                 Type = "IPMatch",
    ///             },
    ///         },
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             ipset,
    ///         },
    ///     });
    /// 
    ///     var wafAcl = new Aws.Waf.WebAcl("waf_acl", new()
    ///     {
    ///         Name = "tfWebACL",
    ///         MetricName = "tfWebACL",
    ///         DefaultAction = new Aws.Waf.Inputs.WebAclDefaultActionArgs
    ///         {
    ///             Type = "ALLOW",
    ///         },
    ///         Rules = new[]
    ///         {
    ///             new Aws.Waf.Inputs.WebAclRuleArgs
    ///             {
    ///                 Action = new Aws.Waf.Inputs.WebAclRuleActionArgs
    ///                 {
    ///                     Type = "BLOCK",
    ///                 },
    ///                 Priority = 1,
    ///                 RuleId = wafrule.Id,
    ///                 Type = "REGULAR",
    ///             },
    ///         },
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             ipset,
    ///             wafrule,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Logging
    /// 
    /// &gt; *NOTE:* The Kinesis Firehose Delivery Stream name must begin with `aws-waf-logs-` and be located in `us-east-1` region. See the [AWS WAF Developer Guide](https://docs.aws.amazon.com/waf/latest/developerguide/logging.html) for more information about enabling WAF logging.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Waf.WebAcl("example", new()
    ///     {
    ///         LoggingConfiguration = new Aws.Waf.Inputs.WebAclLoggingConfigurationArgs
    ///         {
    ///             LogDestination = exampleAwsKinesisFirehoseDeliveryStream.Arn,
    ///             RedactedFields = new Aws.Waf.Inputs.WebAclLoggingConfigurationRedactedFieldsArgs
    ///             {
    ///                 FieldToMatches = new[]
    ///                 {
    ///                     new Aws.Waf.Inputs.WebAclLoggingConfigurationRedactedFieldsFieldToMatchArgs
    ///                     {
    ///                         Type = "URI",
    ///                     },
    ///                     new Aws.Waf.Inputs.WebAclLoggingConfigurationRedactedFieldsFieldToMatchArgs
    ///                     {
    ///                         Data = "referer",
    ///                         Type = "HEADER",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import WAF Web ACL using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:waf/webAcl:WebAcl main 0c8e583e-18f3-4c13-9e2a-67c4805d2f94
    /// ```
    /// </summary>
    [AwsResourceType("aws:waf/webAcl:WebAcl")]
    public partial class WebAcl : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The ARN of the WAF WebACL.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Configuration block with action that you want AWS WAF to take when a request doesn't match the criteria in any of the rules that are associated with the web ACL. Detailed below.
        /// </summary>
        [Output("defaultAction")]
        public Output<Outputs.WebAclDefaultAction> DefaultAction { get; private set; } = null!;

        /// <summary>
        /// Configuration block to enable WAF logging. Detailed below.
        /// </summary>
        [Output("loggingConfiguration")]
        public Output<Outputs.WebAclLoggingConfiguration?> LoggingConfiguration { get; private set; } = null!;

        /// <summary>
        /// The name or description for the Amazon CloudWatch metric of this web ACL.
        /// </summary>
        [Output("metricName")]
        public Output<string> MetricName { get; private set; } = null!;

        /// <summary>
        /// The name or description of the web ACL.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Configuration blocks containing rules to associate with the web ACL and the settings for each rule. Detailed below.
        /// </summary>
        [Output("rules")]
        public Output<ImmutableArray<Outputs.WebAclRule>> Rules { get; private set; } = null!;

        /// <summary>
        /// Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a WebAcl resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public WebAcl(string name, WebAclArgs args, CustomResourceOptions? options = null)
            : base("aws:waf/webAcl:WebAcl", name, args ?? new WebAclArgs(), MakeResourceOptions(options, ""))
        {
        }

        private WebAcl(string name, Input<string> id, WebAclState? state = null, CustomResourceOptions? options = null)
            : base("aws:waf/webAcl:WebAcl", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing WebAcl resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static WebAcl Get(string name, Input<string> id, WebAclState? state = null, CustomResourceOptions? options = null)
        {
            return new WebAcl(name, id, state, options);
        }
    }

    public sealed class WebAclArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block with action that you want AWS WAF to take when a request doesn't match the criteria in any of the rules that are associated with the web ACL. Detailed below.
        /// </summary>
        [Input("defaultAction", required: true)]
        public Input<Inputs.WebAclDefaultActionArgs> DefaultAction { get; set; } = null!;

        /// <summary>
        /// Configuration block to enable WAF logging. Detailed below.
        /// </summary>
        [Input("loggingConfiguration")]
        public Input<Inputs.WebAclLoggingConfigurationArgs>? LoggingConfiguration { get; set; }

        /// <summary>
        /// The name or description for the Amazon CloudWatch metric of this web ACL.
        /// </summary>
        [Input("metricName", required: true)]
        public Input<string> MetricName { get; set; } = null!;

        /// <summary>
        /// The name or description of the web ACL.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("rules")]
        private InputList<Inputs.WebAclRuleArgs>? _rules;

        /// <summary>
        /// Configuration blocks containing rules to associate with the web ACL and the settings for each rule. Detailed below.
        /// </summary>
        public InputList<Inputs.WebAclRuleArgs> Rules
        {
            get => _rules ?? (_rules = new InputList<Inputs.WebAclRuleArgs>());
            set => _rules = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public WebAclArgs()
        {
        }
        public static new WebAclArgs Empty => new WebAclArgs();
    }

    public sealed class WebAclState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the WAF WebACL.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Configuration block with action that you want AWS WAF to take when a request doesn't match the criteria in any of the rules that are associated with the web ACL. Detailed below.
        /// </summary>
        [Input("defaultAction")]
        public Input<Inputs.WebAclDefaultActionGetArgs>? DefaultAction { get; set; }

        /// <summary>
        /// Configuration block to enable WAF logging. Detailed below.
        /// </summary>
        [Input("loggingConfiguration")]
        public Input<Inputs.WebAclLoggingConfigurationGetArgs>? LoggingConfiguration { get; set; }

        /// <summary>
        /// The name or description for the Amazon CloudWatch metric of this web ACL.
        /// </summary>
        [Input("metricName")]
        public Input<string>? MetricName { get; set; }

        /// <summary>
        /// The name or description of the web ACL.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("rules")]
        private InputList<Inputs.WebAclRuleGetArgs>? _rules;

        /// <summary>
        /// Configuration blocks containing rules to associate with the web ACL and the settings for each rule. Detailed below.
        /// </summary>
        public InputList<Inputs.WebAclRuleGetArgs> Rules
        {
            get => _rules ?? (_rules = new InputList<Inputs.WebAclRuleGetArgs>());
            set => _rules = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        public WebAclState()
        {
        }
        public static new WebAclState Empty => new WebAclState();
    }
}
