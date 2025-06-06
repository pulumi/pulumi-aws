// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2
{
    public static class GetSecurityGroup
    {
        /// <summary>
        /// `aws.ec2.SecurityGroup` provides details about a specific Security Group.
        /// 
        /// This resource can prove useful when a module accepts a Security Group id as
        /// an input variable and needs to, for example, determine the id of the
        /// VPC that the security group belongs to.
        /// 
        /// ## Example Usage
        /// 
        /// The following example shows how one might accept a Security Group id as a variable
        /// and use this data source to obtain the data necessary to create a subnet.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var config = new Config();
        ///     var securityGroupId = config.RequireObject&lt;dynamic&gt;("securityGroupId");
        ///     var selected = Aws.Ec2.GetSecurityGroup.Invoke(new()
        ///     {
        ///         Id = securityGroupId,
        ///     });
        /// 
        ///     var subnet = new Aws.Ec2.Subnet("subnet", new()
        ///     {
        ///         VpcId = selected.Apply(getSecurityGroupResult =&gt; getSecurityGroupResult.VpcId),
        ///         CidrBlock = "10.0.1.0/24",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetSecurityGroupResult> InvokeAsync(GetSecurityGroupArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetSecurityGroupResult>("aws:ec2/getSecurityGroup:getSecurityGroup", args ?? new GetSecurityGroupArgs(), options.WithDefaults());

        /// <summary>
        /// `aws.ec2.SecurityGroup` provides details about a specific Security Group.
        /// 
        /// This resource can prove useful when a module accepts a Security Group id as
        /// an input variable and needs to, for example, determine the id of the
        /// VPC that the security group belongs to.
        /// 
        /// ## Example Usage
        /// 
        /// The following example shows how one might accept a Security Group id as a variable
        /// and use this data source to obtain the data necessary to create a subnet.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var config = new Config();
        ///     var securityGroupId = config.RequireObject&lt;dynamic&gt;("securityGroupId");
        ///     var selected = Aws.Ec2.GetSecurityGroup.Invoke(new()
        ///     {
        ///         Id = securityGroupId,
        ///     });
        /// 
        ///     var subnet = new Aws.Ec2.Subnet("subnet", new()
        ///     {
        ///         VpcId = selected.Apply(getSecurityGroupResult =&gt; getSecurityGroupResult.VpcId),
        ///         CidrBlock = "10.0.1.0/24",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetSecurityGroupResult> Invoke(GetSecurityGroupInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetSecurityGroupResult>("aws:ec2/getSecurityGroup:getSecurityGroup", args ?? new GetSecurityGroupInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// `aws.ec2.SecurityGroup` provides details about a specific Security Group.
        /// 
        /// This resource can prove useful when a module accepts a Security Group id as
        /// an input variable and needs to, for example, determine the id of the
        /// VPC that the security group belongs to.
        /// 
        /// ## Example Usage
        /// 
        /// The following example shows how one might accept a Security Group id as a variable
        /// and use this data source to obtain the data necessary to create a subnet.
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var config = new Config();
        ///     var securityGroupId = config.RequireObject&lt;dynamic&gt;("securityGroupId");
        ///     var selected = Aws.Ec2.GetSecurityGroup.Invoke(new()
        ///     {
        ///         Id = securityGroupId,
        ///     });
        /// 
        ///     var subnet = new Aws.Ec2.Subnet("subnet", new()
        ///     {
        ///         VpcId = selected.Apply(getSecurityGroupResult =&gt; getSecurityGroupResult.VpcId),
        ///         CidrBlock = "10.0.1.0/24",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetSecurityGroupResult> Invoke(GetSecurityGroupInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetSecurityGroupResult>("aws:ec2/getSecurityGroup:getSecurityGroup", args ?? new GetSecurityGroupInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetSecurityGroupArgs : global::Pulumi.InvokeArgs
    {
        [Input("filters")]
        private List<Inputs.GetSecurityGroupFilterArgs>? _filters;

        /// <summary>
        /// Custom filter block as described below.
        /// </summary>
        public List<Inputs.GetSecurityGroupFilterArgs> Filters
        {
            get => _filters ?? (_filters = new List<Inputs.GetSecurityGroupFilterArgs>());
            set => _filters = value;
        }

        /// <summary>
        /// Id of the specific security group to retrieve.
        /// </summary>
        [Input("id")]
        public string? Id { get; set; }

        /// <summary>
        /// Name of the field to filter by, as defined by
        /// [the underlying AWS API](http://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroups.html).
        /// </summary>
        [Input("name")]
        public string? Name { get; set; }

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Map of tags, each pair of which must exactly match
        /// a pair on the desired security group.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        /// <summary>
        /// Id of the VPC that the desired security group belongs to.
        /// 
        /// More complex filters can be expressed using one or more `filter` sub-blocks,
        /// which take the following arguments:
        /// </summary>
        [Input("vpcId")]
        public string? VpcId { get; set; }

        public GetSecurityGroupArgs()
        {
        }
        public static new GetSecurityGroupArgs Empty => new GetSecurityGroupArgs();
    }

    public sealed class GetSecurityGroupInvokeArgs : global::Pulumi.InvokeArgs
    {
        [Input("filters")]
        private InputList<Inputs.GetSecurityGroupFilterInputArgs>? _filters;

        /// <summary>
        /// Custom filter block as described below.
        /// </summary>
        public InputList<Inputs.GetSecurityGroupFilterInputArgs> Filters
        {
            get => _filters ?? (_filters = new InputList<Inputs.GetSecurityGroupFilterInputArgs>());
            set => _filters = value;
        }

        /// <summary>
        /// Id of the specific security group to retrieve.
        /// </summary>
        [Input("id")]
        public Input<string>? Id { get; set; }

        /// <summary>
        /// Name of the field to filter by, as defined by
        /// [the underlying AWS API](http://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_DescribeSecurityGroups.html).
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags, each pair of which must exactly match
        /// a pair on the desired security group.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// Id of the VPC that the desired security group belongs to.
        /// 
        /// More complex filters can be expressed using one or more `filter` sub-blocks,
        /// which take the following arguments:
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public GetSecurityGroupInvokeArgs()
        {
        }
        public static new GetSecurityGroupInvokeArgs Empty => new GetSecurityGroupInvokeArgs();
    }


    [OutputType]
    public sealed class GetSecurityGroupResult
    {
        /// <summary>
        /// Computed ARN of the security group.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Description of the security group.
        /// </summary>
        public readonly string Description;
        public readonly ImmutableArray<Outputs.GetSecurityGroupFilterResult> Filters;
        public readonly string Id;
        public readonly string Name;
        public readonly ImmutableDictionary<string, string> Tags;
        public readonly string VpcId;

        [OutputConstructor]
        private GetSecurityGroupResult(
            string arn,

            string description,

            ImmutableArray<Outputs.GetSecurityGroupFilterResult> filters,

            string id,

            string name,

            ImmutableDictionary<string, string> tags,

            string vpcId)
        {
            Arn = arn;
            Description = description;
            Filters = filters;
            Id = id;
            Name = name;
            Tags = tags;
            VpcId = vpcId;
        }
    }
}
