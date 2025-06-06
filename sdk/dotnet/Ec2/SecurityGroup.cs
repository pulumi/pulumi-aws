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
    /// Provides a security group resource.
    /// 
    /// &gt; **NOTE:** Avoid using the `ingress` and `egress` arguments of the `aws.ec2.SecurityGroup` resource to configure in-line rules, as they struggle with managing multiple CIDR blocks, and, due to the historical lack of unique IDs, tags and descriptions. To avoid these problems, use the current best practice of the `aws.vpc.SecurityGroupEgressRule` and `aws.vpc.SecurityGroupIngressRule` resources with one CIDR block per rule.
    /// 
    /// !&gt; **WARNING:** You should not use the `aws.ec2.SecurityGroup` resource with _in-line rules_ (using the `ingress` and `egress` arguments of `aws.ec2.SecurityGroup`) in conjunction with the `aws.vpc.SecurityGroupEgressRule` and `aws.vpc.SecurityGroupIngressRule` resources or the `aws.ec2.SecurityGroupRule` resource. Doing so may cause rule conflicts, perpetual differences, and result in rules being overwritten.
    /// 
    /// &gt; **NOTE:** Referencing Security Groups across VPC peering has certain restrictions. More information is available in the [VPC Peering User Guide](https://docs.aws.amazon.com/vpc/latest/peering/vpc-peering-security-groups.html).
    /// 
    /// &gt; **NOTE:** Due to [AWS Lambda improved VPC networking changes that began deploying in September 2019](https://aws.amazon.com/blogs/compute/announcing-improved-vpc-networking-for-aws-lambda-functions/), security groups associated with Lambda Functions can take up to 45 minutes to successfully delete. To allow for successful deletion, the provider will wait for at least 45 minutes even if a shorter delete timeout is specified.
    /// 
    /// &gt; **NOTE:** The `cidr_blocks` and `ipv6_cidr_blocks` parameters are optional in the `ingress` and `egress` blocks. If nothing is specified, traffic will be blocked as described in _NOTE on Egress rules_ later.
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
    ///     var allowTls = new Aws.Ec2.SecurityGroup("allow_tls", new()
    ///     {
    ///         Name = "allow_tls",
    ///         Description = "Allow TLS inbound traffic and all outbound traffic",
    ///         VpcId = main.Id,
    ///         Tags = 
    ///         {
    ///             { "Name", "allow_tls" },
    ///         },
    ///     });
    /// 
    ///     var allowTlsIpv4 = new Aws.Vpc.SecurityGroupIngressRule("allow_tls_ipv4", new()
    ///     {
    ///         SecurityGroupId = allowTls.Id,
    ///         CidrIpv4 = main.CidrBlock,
    ///         FromPort = 443,
    ///         IpProtocol = "tcp",
    ///         ToPort = 443,
    ///     });
    /// 
    ///     var allowTlsIpv6 = new Aws.Vpc.SecurityGroupIngressRule("allow_tls_ipv6", new()
    ///     {
    ///         SecurityGroupId = allowTls.Id,
    ///         CidrIpv6 = main.Ipv6CidrBlock,
    ///         FromPort = 443,
    ///         IpProtocol = "tcp",
    ///         ToPort = 443,
    ///     });
    /// 
    ///     var allowAllTrafficIpv4 = new Aws.Vpc.SecurityGroupEgressRule("allow_all_traffic_ipv4", new()
    ///     {
    ///         SecurityGroupId = allowTls.Id,
    ///         CidrIpv4 = "0.0.0.0/0",
    ///         IpProtocol = "-1",
    ///     });
    /// 
    ///     var allowAllTrafficIpv6 = new Aws.Vpc.SecurityGroupEgressRule("allow_all_traffic_ipv6", new()
    ///     {
    ///         SecurityGroupId = allowTls.Id,
    ///         CidrIpv6 = "::/0",
    ///         IpProtocol = "-1",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// &gt; **NOTE on Egress rules:** By default, AWS creates an `ALLOW ALL` egress rule when creating a new Security Group inside of a VPC. When creating a new Security Group inside a VPC, **this provider will remove this default rule**, and require you specifically re-create it if you desire that rule. We feel this leads to fewer surprises in terms of controlling your egress rules. If you desire this rule to be in place, you can use this `egress` block:
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Ec2.SecurityGroup("example", new()
    ///     {
    ///         Egress = new[]
    ///         {
    ///             new Aws.Ec2.Inputs.SecurityGroupEgressArgs
    ///             {
    ///                 FromPort = 0,
    ///                 ToPort = 0,
    ///                 Protocol = "-1",
    ///                 CidrBlocks = new[]
    ///                 {
    ///                     "0.0.0.0/0",
    ///                 },
    ///                 Ipv6CidrBlocks = new[]
    ///                 {
    ///                     "::/0",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Usage With Prefix List IDs
    /// 
    /// Prefix Lists are either managed by AWS internally, or created by the customer using a
    /// Prefix List resource. Prefix Lists provided by
    /// AWS are associated with a prefix list name, or service name, that is linked to a specific region.
    /// Prefix list IDs are exported on VPC Endpoints, so you can use this format:
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var myEndpoint = new Aws.Ec2.VpcEndpoint("my_endpoint");
    /// 
    ///     var example = new Aws.Ec2.SecurityGroup("example", new()
    ///     {
    ///         Egress = new[]
    ///         {
    ///             new Aws.Ec2.Inputs.SecurityGroupEgressArgs
    ///             {
    ///                 FromPort = 0,
    ///                 ToPort = 0,
    ///                 Protocol = "-1",
    ///                 PrefixListIds = new[]
    ///                 {
    ///                     myEndpoint.PrefixListId,
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// You can also find a specific Prefix List using the `aws.ec2.getPrefixList` data source.
    /// 
    /// ### Removing All Ingress and Egress Rules
    /// 
    /// The `ingress` and `egress` arguments are processed in attributes-as-blocks mode. Due to this, removing these arguments from the configuration will **not** cause the provider to destroy the managed rules. To subsequently remove all managed ingress and egress rules:
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Ec2.SecurityGroup("example", new()
    ///     {
    ///         Name = "sg",
    ///         VpcId = exampleAwsVpc.Id,
    ///         Ingress = new[] {},
    ///         Egress = new[] {},
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Recreating a Security Group
    /// 
    /// A simple security group `name` change "forces new" the security group--the provider destroys the security group and creates a new one. (Likewise, `description`, `name_prefix`, or `vpc_id` [cannot be changed](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/working-with-security-groups.html#creating-security-group).) Attempting to recreate the security group leads to a variety of complications depending on how it is used.
    /// 
    /// Security groups are generally associated with other resources--**more than 100** AWS Provider resources reference security groups. Referencing a resource from another resource creates a one-way dependency. For example, if you create an EC2 `aws.ec2.Instance` that has a `vpc_security_group_ids` argument that refers to an `aws.ec2.SecurityGroup` resource, the `aws.ec2.SecurityGroup` is a dependent of the `aws.ec2.Instance`. Because of this, the provider will create the security group first so that it can then be associated with the EC2 instance.
    /// 
    /// However, the dependency relationship actually goes both directions causing the _Security Group Deletion Problem_. AWS does not allow you to delete the security group associated with another resource (_e.g._, the `aws.ec2.Instance`).
    /// 
    /// The provider does not model bi-directional dependencies like this, but, even if it did, simply knowing the dependency situation would not be enough to solve it. For example, some resources must always have an associated security group while others don't need to. In addition, when the `aws.ec2.SecurityGroup` resource attempts to recreate, it receives a dependent object error, which does not provide information on whether the dependent object is a security group rule or, for example, an associated EC2 instance. Within the provider, the associated resource (_e.g._, `aws.ec2.Instance`) does not receive an error when the `aws.ec2.SecurityGroup` is trying to recreate even though that is where changes to the associated resource would need to take place (_e.g._, removing the security group association).
    /// 
    /// Despite these sticky problems, below are some ways to improve your experience when you find it necessary to recreate a security group.
    /// 
    /// ### Shorter timeout
    /// 
    /// (This example is one approach to recreating security groups. For more information on the challenges and the _Security Group Deletion Problem_, see the section above.)
    /// 
    /// If destroying a security group takes a long time, it may be because the provider cannot distinguish between a dependent object (_e.g._, a security group rule or EC2 instance) that is _in the process of being deleted_ and one that is not. In other words, it may be waiting for a train that isn't scheduled to arrive. To fail faster, shorten the `delete` timeout from the default timeout:
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Ec2.SecurityGroup("example", new()
    ///     {
    ///         Name = "izizavle",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Provisioners
    /// 
    /// (This example is one approach to recreating security groups. For more information on the challenges and the _Security Group Deletion Problem_, see the section above.)
    /// 
    /// **DISCLAIMER:** We **_HIGHLY_** recommend using one of the above approaches and _NOT_ using local provisioners. Provisioners, like the one shown below, should be considered a **last resort** since they are _not readable_, _require skills outside standard configuration_, are _error prone_ and _difficult to maintain_, are not compatible with cloud environments and upgrade tools, require AWS CLI installation, and are subject to changes outside the AWS Provider.
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// using Command = Pulumi.Command;
    /// using Null = Pulumi.Null;
    /// using Std = Pulumi.Std;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var @default = Aws.Ec2.GetSecurityGroup.Invoke(new()
    ///     {
    ///         Name = "default",
    ///     });
    /// 
    ///     var example = new Aws.Ec2.SecurityGroup("example", new()
    ///     {
    ///         Name = "sg",
    ///         Tags = 
    ///         {
    ///             { "workaround1", "tagged-name" },
    ///             { "workaround2", @default.Apply(@default =&gt; @default.Apply(getSecurityGroupResult =&gt; getSecurityGroupResult.Id)) },
    ///         },
    ///     });
    /// 
    ///     var exampleProvisioner0 = new Command.Local.Command("exampleProvisioner0", new()
    ///     {
    ///         Create = "true",
    ///         Update = "true",
    ///         Delete = @$"            ENDPOINT_ID=`aws ec2 describe-vpc-endpoints --filters ""Name=tag:Name,Values={tags.Workaround1}"" --query ""VpcEndpoints[0].VpcEndpointId"" --output text` &amp;&amp;
    ///             aws ec2 modify-vpc-endpoint --vpc-endpoint-id ${{ENDPOINT_ID}} --add-security-group-ids {tags.Workaround2} --remove-security-group-ids {id}
    /// ",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             example,
    ///         },
    ///     });
    /// 
    ///     var exampleResource = new Null.Resource("example", new()
    ///     {
    ///         Triggers = 
    ///         {
    ///             { "rerun_upon_change_of", Std.Join.Invoke(new()
    ///             {
    ///                 Separator = ",",
    ///                 Input = exampleAwsVpcEndpoint.SecurityGroupIds,
    ///             }).Apply(invoke =&gt; invoke.Result) },
    ///         },
    ///     });
    /// 
    ///     var exampleResourceProvisioner0 = new Command.Local.Command("exampleResourceProvisioner0", new()
    ///     {
    ///         Create = @$"            aws ec2 modify-vpc-endpoint --vpc-endpoint-id {exampleAwsVpcEndpoint.Id} --remove-security-group-ids {@default.Apply(getSecurityGroupResult =&gt; getSecurityGroupResult.Id)}
    /// ",
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             exampleResource,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Security Groups using the security group `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ec2/securityGroup:SecurityGroup elb_sg sg-903004f8
    /// ```
    /// </summary>
    [AwsResourceType("aws:ec2/securityGroup:SecurityGroup")]
    public partial class SecurityGroup : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the security group.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Security group description. Defaults to `Managed by Pulumi`. Cannot be `""`. **NOTE**: This field maps to the AWS `GroupDescription` attribute, for which there is no Update API. If you'd like to classify your security groups in a way that can be updated, use `tags`.
        /// </summary>
        [Output("description")]
        public Output<string> Description { get; private set; } = null!;

        /// <summary>
        /// Configuration block for egress rules. Can be specified multiple times for each egress rule. Each egress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
        /// </summary>
        [Output("egress")]
        public Output<ImmutableArray<Outputs.SecurityGroupEgress>> Egress { get; private set; } = null!;

        /// <summary>
        /// Configuration block for ingress rules. Can be specified multiple times for each ingress rule. Each ingress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
        /// </summary>
        [Output("ingress")]
        public Output<ImmutableArray<Outputs.SecurityGroupIngress>> Ingress { get; private set; } = null!;

        /// <summary>
        /// Name of the security group. If omitted, the provider will assign a random, unique name.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
        /// </summary>
        [Output("namePrefix")]
        public Output<string> NamePrefix { get; private set; } = null!;

        /// <summary>
        /// Owner ID.
        /// </summary>
        [Output("ownerId")]
        public Output<string> OwnerId { get; private set; } = null!;

        /// <summary>
        /// Instruct the provider to revoke all of the Security Groups attached ingress and egress rules before deleting the rule itself. This is normally not needed, however certain AWS services such as Elastic Map Reduce may automatically add required rules to security groups used with the service, and those rules may contain a cyclic dependency that prevent the security groups from being destroyed without removing the dependency first. Default `false`.
        /// </summary>
        [Output("revokeRulesOnDelete")]
        public Output<bool?> RevokeRulesOnDelete { get; private set; } = null!;

        /// <summary>
        /// Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// VPC ID. Defaults to the region's default VPC.
        /// </summary>
        [Output("vpcId")]
        public Output<string> VpcId { get; private set; } = null!;


        /// <summary>
        /// Create a SecurityGroup resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public SecurityGroup(string name, SecurityGroupArgs? args = null, CustomResourceOptions? options = null)
            : base("aws:ec2/securityGroup:SecurityGroup", name, args ?? new SecurityGroupArgs(), MakeResourceOptions(options, ""))
        {
        }

        private SecurityGroup(string name, Input<string> id, SecurityGroupState? state = null, CustomResourceOptions? options = null)
            : base("aws:ec2/securityGroup:SecurityGroup", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing SecurityGroup resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static SecurityGroup Get(string name, Input<string> id, SecurityGroupState? state = null, CustomResourceOptions? options = null)
        {
            return new SecurityGroup(name, id, state, options);
        }
    }

    public sealed class SecurityGroupArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Security group description. Defaults to `Managed by Pulumi`. Cannot be `""`. **NOTE**: This field maps to the AWS `GroupDescription` attribute, for which there is no Update API. If you'd like to classify your security groups in a way that can be updated, use `tags`.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        [Input("egress")]
        private InputList<Inputs.SecurityGroupEgressArgs>? _egress;

        /// <summary>
        /// Configuration block for egress rules. Can be specified multiple times for each egress rule. Each egress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
        /// </summary>
        public InputList<Inputs.SecurityGroupEgressArgs> Egress
        {
            get => _egress ?? (_egress = new InputList<Inputs.SecurityGroupEgressArgs>());
            set => _egress = value;
        }

        [Input("ingress")]
        private InputList<Inputs.SecurityGroupIngressArgs>? _ingress;

        /// <summary>
        /// Configuration block for ingress rules. Can be specified multiple times for each ingress rule. Each ingress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
        /// </summary>
        public InputList<Inputs.SecurityGroupIngressArgs> Ingress
        {
            get => _ingress ?? (_ingress = new InputList<Inputs.SecurityGroupIngressArgs>());
            set => _ingress = value;
        }

        /// <summary>
        /// Name of the security group. If omitted, the provider will assign a random, unique name.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
        /// </summary>
        [Input("namePrefix")]
        public Input<string>? NamePrefix { get; set; }

        /// <summary>
        /// Instruct the provider to revoke all of the Security Groups attached ingress and egress rules before deleting the rule itself. This is normally not needed, however certain AWS services such as Elastic Map Reduce may automatically add required rules to security groups used with the service, and those rules may contain a cyclic dependency that prevent the security groups from being destroyed without removing the dependency first. Default `false`.
        /// </summary>
        [Input("revokeRulesOnDelete")]
        public Input<bool>? RevokeRulesOnDelete { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// VPC ID. Defaults to the region's default VPC.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public SecurityGroupArgs()
        {
            Description = "Managed by Pulumi";
        }
        public static new SecurityGroupArgs Empty => new SecurityGroupArgs();
    }

    public sealed class SecurityGroupState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the security group.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Security group description. Defaults to `Managed by Pulumi`. Cannot be `""`. **NOTE**: This field maps to the AWS `GroupDescription` attribute, for which there is no Update API. If you'd like to classify your security groups in a way that can be updated, use `tags`.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        [Input("egress")]
        private InputList<Inputs.SecurityGroupEgressGetArgs>? _egress;

        /// <summary>
        /// Configuration block for egress rules. Can be specified multiple times for each egress rule. Each egress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
        /// </summary>
        public InputList<Inputs.SecurityGroupEgressGetArgs> Egress
        {
            get => _egress ?? (_egress = new InputList<Inputs.SecurityGroupEgressGetArgs>());
            set => _egress = value;
        }

        [Input("ingress")]
        private InputList<Inputs.SecurityGroupIngressGetArgs>? _ingress;

        /// <summary>
        /// Configuration block for ingress rules. Can be specified multiple times for each ingress rule. Each ingress block supports fields documented below. This argument is processed in attribute-as-blocks mode.
        /// </summary>
        public InputList<Inputs.SecurityGroupIngressGetArgs> Ingress
        {
            get => _ingress ?? (_ingress = new InputList<Inputs.SecurityGroupIngressGetArgs>());
            set => _ingress = value;
        }

        /// <summary>
        /// Name of the security group. If omitted, the provider will assign a random, unique name.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Creates a unique name beginning with the specified prefix. Conflicts with `name`.
        /// </summary>
        [Input("namePrefix")]
        public Input<string>? NamePrefix { get; set; }

        /// <summary>
        /// Owner ID.
        /// </summary>
        [Input("ownerId")]
        public Input<string>? OwnerId { get; set; }

        /// <summary>
        /// Instruct the provider to revoke all of the Security Groups attached ingress and egress rules before deleting the rule itself. This is normally not needed, however certain AWS services such as Elastic Map Reduce may automatically add required rules to security groups used with the service, and those rules may contain a cyclic dependency that prevent the security groups from being destroyed without removing the dependency first. Default `false`.
        /// </summary>
        [Input("revokeRulesOnDelete")]
        public Input<bool>? RevokeRulesOnDelete { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        /// <summary>
        /// VPC ID. Defaults to the region's default VPC.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public SecurityGroupState()
        {
            Description = "Managed by Pulumi";
        }
        public static new SecurityGroupState Empty => new SecurityGroupState();
    }
}
