// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2
{
    /// <summary>
    /// Provides an Traffic mirror filter rule.\
    /// Read [limits and considerations](https://docs.aws.amazon.com/vpc/latest/mirroring/traffic-mirroring-considerations.html) for traffic mirroring
    /// 
    /// ## Example Usage
    /// 
    /// To create a basic traffic mirror session
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var filter = new Aws.Ec2.TrafficMirrorFilter("filter", new()
    ///     {
    ///         Description = "traffic mirror filter - example",
    ///         NetworkServices = new[]
    ///         {
    ///             "amazon-dns",
    ///         },
    ///     });
    /// 
    ///     var ruleout = new Aws.Ec2.TrafficMirrorFilterRule("ruleout", new()
    ///     {
    ///         Description = "test rule",
    ///         TrafficMirrorFilterId = filter.Id,
    ///         DestinationCidrBlock = "10.0.0.0/8",
    ///         SourceCidrBlock = "10.0.0.0/8",
    ///         RuleNumber = 1,
    ///         RuleAction = "accept",
    ///         TrafficDirection = "egress",
    ///     });
    /// 
    ///     var rulein = new Aws.Ec2.TrafficMirrorFilterRule("rulein", new()
    ///     {
    ///         Description = "test rule",
    ///         TrafficMirrorFilterId = filter.Id,
    ///         DestinationCidrBlock = "10.0.0.0/8",
    ///         SourceCidrBlock = "10.0.0.0/8",
    ///         RuleNumber = 1,
    ///         RuleAction = "accept",
    ///         TrafficDirection = "ingress",
    ///         Protocol = 6,
    ///         DestinationPortRange = new Aws.Ec2.Inputs.TrafficMirrorFilterRuleDestinationPortRangeArgs
    ///         {
    ///             FromPort = 22,
    ///             ToPort = 53,
    ///         },
    ///         SourcePortRange = new Aws.Ec2.Inputs.TrafficMirrorFilterRuleSourcePortRangeArgs
    ///         {
    ///             FromPort = 0,
    ///             ToPort = 10,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import traffic mirror rules using the `traffic_mirror_filter_id` and `id` separated by `:`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2/trafficMirrorFilterRule:TrafficMirrorFilterRule rule tmf-0fbb93ddf38198f64:tmfr-05a458f06445d0aee
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2/trafficMirrorFilterRule:TrafficMirrorFilterRule")]
    public partial class TrafficMirrorFilterRule : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the traffic mirror filter rule.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Description of the traffic mirror filter rule.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Destination CIDR block to assign to the Traffic Mirror rule.
        /// </summary>
        [Output("destinationCidrBlock")]
        public Output<string> DestinationCidrBlock { get; private set; } = null!;

        /// <summary>
        /// Destination port range. Supported only when the protocol is set to TCP(6) or UDP(17). See Traffic mirror port range documented below
        /// </summary>
        [Output("destinationPortRange")]
        public Output<Outputs.TrafficMirrorFilterRuleDestinationPortRange?> DestinationPortRange { get; private set; } = null!;

        /// <summary>
        /// Protocol number, for example 17 (UDP), to assign to the Traffic Mirror rule. For information about the protocol value, see [Protocol Numbers](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml) on the Internet Assigned Numbers Authority (IANA) website.
        /// </summary>
        [Output("protocol")]
        public Output<int?> Protocol { get; private set; } = null!;

        /// <summary>
        /// Action to take (accept | reject) on the filtered traffic. Valid values are `accept` and `reject`
        /// </summary>
        [Output("ruleAction")]
        public Output<string> RuleAction { get; private set; } = null!;

        /// <summary>
        /// Number of the Traffic Mirror rule. This number must be unique for each Traffic Mirror rule in a given direction. The rules are processed in ascending order by rule number.
        /// </summary>
        [Output("ruleNumber")]
        public Output<int> RuleNumber { get; private set; } = null!;

        /// <summary>
        /// Source CIDR block to assign to the Traffic Mirror rule.
        /// </summary>
        [Output("sourceCidrBlock")]
        public Output<string> SourceCidrBlock { get; private set; } = null!;

        /// <summary>
        /// Source port range. Supported only when the protocol is set to TCP(6) or UDP(17). See Traffic mirror port range documented below
        /// </summary>
        [Output("sourcePortRange")]
        public Output<Outputs.TrafficMirrorFilterRuleSourcePortRange?> SourcePortRange { get; private set; } = null!;

        /// <summary>
        /// Direction of traffic to be captured. Valid values are `ingress` and `egress`
        /// 
        /// Traffic mirror port range support following attributes:
        /// </summary>
        [Output("trafficDirection")]
        public Output<string> TrafficDirection { get; private set; } = null!;

        /// <summary>
        /// ID of the traffic mirror filter to which this rule should be added
        /// </summary>
        [Output("trafficMirrorFilterId")]
        public Output<string> TrafficMirrorFilterId { get; private set; } = null!;


        /// <summary>
        /// Create a TrafficMirrorFilterRule resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public TrafficMirrorFilterRule(string name, TrafficMirrorFilterRuleArgs args, CustomResourceOptions? options = null)
            : base("aws:ec2/trafficMirrorFilterRule:TrafficMirrorFilterRule", name, args ?? new TrafficMirrorFilterRuleArgs(), MakeResourceOptions(options, ""))
        {
        }

        private TrafficMirrorFilterRule(string name, Input<string> id, TrafficMirrorFilterRuleState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2/trafficMirrorFilterRule:TrafficMirrorFilterRule", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing TrafficMirrorFilterRule resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static TrafficMirrorFilterRule Get(string name, Input<string> id, TrafficMirrorFilterRuleState? state = null, CustomResourceOptions? options = null)
        {
            return new TrafficMirrorFilterRule(name, id, state, options);
        }
    }

    public sealed class TrafficMirrorFilterRuleArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Description of the traffic mirror filter rule.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Destination CIDR block to assign to the Traffic Mirror rule.
        /// </summary>
        [Input("destinationCidrBlock", required: true)]
        public Input<string> DestinationCidrBlock { get; set; } = null!;

        /// <summary>
        /// Destination port range. Supported only when the protocol is set to TCP(6) or UDP(17). See Traffic mirror port range documented below
        /// </summary>
        [Input("destinationPortRange")]
        public Input<Inputs.TrafficMirrorFilterRuleDestinationPortRangeArgs>? DestinationPortRange { get; set; }

        /// <summary>
        /// Protocol number, for example 17 (UDP), to assign to the Traffic Mirror rule. For information about the protocol value, see [Protocol Numbers](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml) on the Internet Assigned Numbers Authority (IANA) website.
        /// </summary>
        [Input("protocol")]
        public Input<int>? Protocol { get; set; }

        /// <summary>
        /// Action to take (accept | reject) on the filtered traffic. Valid values are `accept` and `reject`
        /// </summary>
        [Input("ruleAction", required: true)]
        public Input<string> RuleAction { get; set; } = null!;

        /// <summary>
        /// Number of the Traffic Mirror rule. This number must be unique for each Traffic Mirror rule in a given direction. The rules are processed in ascending order by rule number.
        /// </summary>
        [Input("ruleNumber", required: true)]
        public Input<int> RuleNumber { get; set; } = null!;

        /// <summary>
        /// Source CIDR block to assign to the Traffic Mirror rule.
        /// </summary>
        [Input("sourceCidrBlock", required: true)]
        public Input<string> SourceCidrBlock { get; set; } = null!;

        /// <summary>
        /// Source port range. Supported only when the protocol is set to TCP(6) or UDP(17). See Traffic mirror port range documented below
        /// </summary>
        [Input("sourcePortRange")]
        public Input<Inputs.TrafficMirrorFilterRuleSourcePortRangeArgs>? SourcePortRange { get; set; }

        /// <summary>
        /// Direction of traffic to be captured. Valid values are `ingress` and `egress`
        /// 
        /// Traffic mirror port range support following attributes:
        /// </summary>
        [Input("trafficDirection", required: true)]
        public Input<string> TrafficDirection { get; set; } = null!;

        /// <summary>
        /// ID of the traffic mirror filter to which this rule should be added
        /// </summary>
        [Input("trafficMirrorFilterId", required: true)]
        public Input<string> TrafficMirrorFilterId { get; set; } = null!;

        public TrafficMirrorFilterRuleArgs()
        {
        }
        public static new TrafficMirrorFilterRuleArgs Empty => new TrafficMirrorFilterRuleArgs();
    }

    public sealed class TrafficMirrorFilterRuleState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the traffic mirror filter rule.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Description of the traffic mirror filter rule.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Destination CIDR block to assign to the Traffic Mirror rule.
        /// </summary>
        [Input("destinationCidrBlock")]
        public Input<string>? DestinationCidrBlock { get; set; }

        /// <summary>
        /// Destination port range. Supported only when the protocol is set to TCP(6) or UDP(17). See Traffic mirror port range documented below
        /// </summary>
        [Input("destinationPortRange")]
        public Input<Inputs.TrafficMirrorFilterRuleDestinationPortRangeGetArgs>? DestinationPortRange { get; set; }

        /// <summary>
        /// Protocol number, for example 17 (UDP), to assign to the Traffic Mirror rule. For information about the protocol value, see [Protocol Numbers](https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml) on the Internet Assigned Numbers Authority (IANA) website.
        /// </summary>
        [Input("protocol")]
        public Input<int>? Protocol { get; set; }

        /// <summary>
        /// Action to take (accept | reject) on the filtered traffic. Valid values are `accept` and `reject`
        /// </summary>
        [Input("ruleAction")]
        public Input<string>? RuleAction { get; set; }

        /// <summary>
        /// Number of the Traffic Mirror rule. This number must be unique for each Traffic Mirror rule in a given direction. The rules are processed in ascending order by rule number.
        /// </summary>
        [Input("ruleNumber")]
        public Input<int>? RuleNumber { get; set; }

        /// <summary>
        /// Source CIDR block to assign to the Traffic Mirror rule.
        /// </summary>
        [Input("sourceCidrBlock")]
        public Input<string>? SourceCidrBlock { get; set; }

        /// <summary>
        /// Source port range. Supported only when the protocol is set to TCP(6) or UDP(17). See Traffic mirror port range documented below
        /// </summary>
        [Input("sourcePortRange")]
        public Input<Inputs.TrafficMirrorFilterRuleSourcePortRangeGetArgs>? SourcePortRange { get; set; }

        /// <summary>
        /// Direction of traffic to be captured. Valid values are `ingress` and `egress`
        /// 
        /// Traffic mirror port range support following attributes:
        /// </summary>
        [Input("trafficDirection")]
        public Input<string>? TrafficDirection { get; set; }

        /// <summary>
        /// ID of the traffic mirror filter to which this rule should be added
        /// </summary>
        [Input("trafficMirrorFilterId")]
        public Input<string>? TrafficMirrorFilterId { get; set; }

        public TrafficMirrorFilterRuleState()
        {
        }
        public static new TrafficMirrorFilterRuleState Empty => new TrafficMirrorFilterRuleState();
    }
}
