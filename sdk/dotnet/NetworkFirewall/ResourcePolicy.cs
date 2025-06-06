// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall
{
    /// <summary>
    /// Provides an AWS Network Firewall Resource Policy Resource for a rule group or firewall policy.
    /// 
    /// ## Example Usage
    /// 
    /// ### For a Firewall Policy resource
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using System.Text.Json;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.NetworkFirewall.ResourcePolicy("example", new()
    ///     {
    ///         ResourceArn = exampleAwsNetworkfirewallFirewallPolicy.Arn,
    ///         Policy = JsonSerializer.Serialize(new Dictionary&lt;string, object?&gt;
    ///         {
    ///             ["Statement"] = new[]
    ///             {
    ///                 new Dictionary&lt;string, object?&gt;
    ///                 {
    ///                     ["Action"] = new[]
    ///                     {
    ///                         "network-firewall:ListFirewallPolicies",
    ///                         "network-firewall:CreateFirewall",
    ///                         "network-firewall:UpdateFirewall",
    ///                         "network-firewall:AssociateFirewallPolicy",
    ///                     },
    ///                     ["Effect"] = "Allow",
    ///                     ["Resource"] = exampleAwsNetworkfirewallFirewallPolicy.Arn,
    ///                     ["Principal"] = new Dictionary&lt;string, object?&gt;
    ///                     {
    ///                         ["AWS"] = "arn:aws:iam::123456789012:root",
    ///                     },
    ///                 },
    ///             },
    ///             ["Version"] = "2012-10-17",
    ///         }),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### For a Rule Group resource
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using System.Text.Json;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.NetworkFirewall.ResourcePolicy("example", new()
    ///     {
    ///         ResourceArn = exampleAwsNetworkfirewallRuleGroup.Arn,
    ///         Policy = JsonSerializer.Serialize(new Dictionary&lt;string, object?&gt;
    ///         {
    ///             ["Statement"] = new[]
    ///             {
    ///                 new Dictionary&lt;string, object?&gt;
    ///                 {
    ///                     ["Action"] = new[]
    ///                     {
    ///                         "network-firewall:ListRuleGroups",
    ///                         "network-firewall:CreateFirewallPolicy",
    ///                         "network-firewall:UpdateFirewallPolicy",
    ///                     },
    ///                     ["Effect"] = "Allow",
    ///                     ["Resource"] = exampleAwsNetworkfirewallRuleGroup.Arn,
    ///                     ["Principal"] = new Dictionary&lt;string, object?&gt;
    ///                     {
    ///                         ["AWS"] = "arn:aws:iam::123456789012:root",
    ///                     },
    ///                 },
    ///             },
    ///             ["Version"] = "2012-10-17",
    ///         }),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Network Firewall Resource Policies using the `resource arn`. For example:
    /// ```sh
    /// $ pulumi import aws:networkfirewall/resourcePolicy:ResourcePolicy example arn:aws:network-firewall:us-west-1:123456789012:stateful-rulegroup/example
    /// ```
    /// </summary>
    [AwsResourceType("aws:networkfirewall/resourcePolicy:ResourcePolicy")]
    public partial class ResourcePolicy : global::Pulumi.CustomResource
    {
        /// <summary>
        /// JSON formatted policy document that controls access to the Network Firewall resource. The policy must be provided **without whitespaces**.  We recommend using jsonencode for formatting as seen in the examples above. For more details, including available policy statement Actions, see the [Policy](https://docs.aws.amazon.com/network-firewall/latest/APIReference/API_PutResourcePolicy.html#API_PutResourcePolicy_RequestSyntax) parameter in the AWS API documentation.
        /// </summary>
        [Output("policy")]
        public Output<string> Policy { get; private set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the rule group or firewall policy.
        /// </summary>
        [Output("resourceArn")]
        public Output<string> ResourceArn { get; private set; } = null!;


        /// <summary>
        /// Create a ResourcePolicy resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ResourcePolicy(string name, ResourcePolicyArgs args, CustomResourceOptions? options = null)
            : base("aws:networkfirewall/resourcePolicy:ResourcePolicy", name, args ?? new ResourcePolicyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private ResourcePolicy(string name, Input<string> id, ResourcePolicyState? state = null, CustomResourceOptions? options = null)
            : base("aws:networkfirewall/resourcePolicy:ResourcePolicy", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing ResourcePolicy resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ResourcePolicy Get(string name, Input<string> id, ResourcePolicyState? state = null, CustomResourceOptions? options = null)
        {
            return new ResourcePolicy(name, id, state, options);
        }
    }

    public sealed class ResourcePolicyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// JSON formatted policy document that controls access to the Network Firewall resource. The policy must be provided **without whitespaces**.  We recommend using jsonencode for formatting as seen in the examples above. For more details, including available policy statement Actions, see the [Policy](https://docs.aws.amazon.com/network-firewall/latest/APIReference/API_PutResourcePolicy.html#API_PutResourcePolicy_RequestSyntax) parameter in the AWS API documentation.
        /// </summary>
        [Input("policy", required: true)]
        public Input<string> Policy { get; set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the rule group or firewall policy.
        /// </summary>
        [Input("resourceArn", required: true)]
        public Input<string> ResourceArn { get; set; } = null!;

        public ResourcePolicyArgs()
        {
        }
        public static new ResourcePolicyArgs Empty => new ResourcePolicyArgs();
    }

    public sealed class ResourcePolicyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// JSON formatted policy document that controls access to the Network Firewall resource. The policy must be provided **without whitespaces**.  We recommend using jsonencode for formatting as seen in the examples above. For more details, including available policy statement Actions, see the [Policy](https://docs.aws.amazon.com/network-firewall/latest/APIReference/API_PutResourcePolicy.html#API_PutResourcePolicy_RequestSyntax) parameter in the AWS API documentation.
        /// </summary>
        [Input("policy")]
        public Input<string>? Policy { get; set; }

        /// <summary>
        /// The Amazon Resource Name (ARN) of the rule group or firewall policy.
        /// </summary>
        [Input("resourceArn")]
        public Input<string>? ResourceArn { get; set; }

        public ResourcePolicyState()
        {
        }
        public static new ResourcePolicyState Empty => new ResourcePolicyState();
    }
}
