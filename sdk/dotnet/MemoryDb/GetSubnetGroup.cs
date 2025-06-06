// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MemoryDb
{
    public static class GetSubnetGroup
    {
        /// <summary>
        /// Provides information about a MemoryDB Subnet Group.
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
        ///     var example = Aws.MemoryDb.GetSubnetGroup.Invoke(new()
        ///     {
        ///         Name = "my-subnet-group",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetSubnetGroupResult> InvokeAsync(GetSubnetGroupArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetSubnetGroupResult>("aws:memorydb/getSubnetGroup:getSubnetGroup", args ?? new GetSubnetGroupArgs(), options.WithDefaults());

        /// <summary>
        /// Provides information about a MemoryDB Subnet Group.
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
        ///     var example = Aws.MemoryDb.GetSubnetGroup.Invoke(new()
        ///     {
        ///         Name = "my-subnet-group",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetSubnetGroupResult> Invoke(GetSubnetGroupInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetSubnetGroupResult>("aws:memorydb/getSubnetGroup:getSubnetGroup", args ?? new GetSubnetGroupInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Provides information about a MemoryDB Subnet Group.
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
        ///     var example = Aws.MemoryDb.GetSubnetGroup.Invoke(new()
        ///     {
        ///         Name = "my-subnet-group",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetSubnetGroupResult> Invoke(GetSubnetGroupInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetSubnetGroupResult>("aws:memorydb/getSubnetGroup:getSubnetGroup", args ?? new GetSubnetGroupInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetSubnetGroupArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the subnet group.
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Map of tags assigned to the subnet group.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetSubnetGroupArgs()
        {
        }
        public static new GetSubnetGroupArgs Empty => new GetSubnetGroupArgs();
    }

    public sealed class GetSubnetGroupInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the subnet group.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags assigned to the subnet group.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetSubnetGroupInvokeArgs()
        {
        }
        public static new GetSubnetGroupInvokeArgs Empty => new GetSubnetGroupInvokeArgs();
    }


    [OutputType]
    public sealed class GetSubnetGroupResult
    {
        /// <summary>
        /// ARN of the subnet group.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Description of the subnet group.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string Name;
        /// <summary>
        /// Set of VPC Subnet ID-s of the subnet group.
        /// </summary>
        public readonly ImmutableArray<string> SubnetIds;
        /// <summary>
        /// Map of tags assigned to the subnet group.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;
        /// <summary>
        /// VPC in which the subnet group exists.
        /// </summary>
        public readonly string VpcId;

        [OutputConstructor]
        private GetSubnetGroupResult(
            string arn,

            string description,

            string id,

            string name,

            ImmutableArray<string> subnetIds,

            ImmutableDictionary<string, string> tags,

            string vpcId)
        {
            Arn = arn;
            Description = description;
            Id = id;
            Name = name;
            SubnetIds = subnetIds;
            Tags = tags;
            VpcId = vpcId;
        }
    }
}
