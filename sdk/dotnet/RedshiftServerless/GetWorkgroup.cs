// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.RedshiftServerless
{
    public static class GetWorkgroup
    {
        /// <summary>
        /// Data source for managing an AWS Redshift Serverless Workgroup.
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
        ///     var example = Aws.RedshiftServerless.GetWorkgroup.Invoke(new()
        ///     {
        ///         WorkgroupName = exampleAwsRedshiftserverlessWorkgroup.WorkgroupName,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetWorkgroupResult> InvokeAsync(GetWorkgroupArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetWorkgroupResult>("aws:redshiftserverless/getWorkgroup:getWorkgroup", args ?? new GetWorkgroupArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Redshift Serverless Workgroup.
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
        ///     var example = Aws.RedshiftServerless.GetWorkgroup.Invoke(new()
        ///     {
        ///         WorkgroupName = exampleAwsRedshiftserverlessWorkgroup.WorkgroupName,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetWorkgroupResult> Invoke(GetWorkgroupInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetWorkgroupResult>("aws:redshiftserverless/getWorkgroup:getWorkgroup", args ?? new GetWorkgroupInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS Redshift Serverless Workgroup.
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
        ///     var example = Aws.RedshiftServerless.GetWorkgroup.Invoke(new()
        ///     {
        ///         WorkgroupName = exampleAwsRedshiftserverlessWorkgroup.WorkgroupName,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetWorkgroupResult> Invoke(GetWorkgroupInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetWorkgroupResult>("aws:redshiftserverless/getWorkgroup:getWorkgroup", args ?? new GetWorkgroupInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetWorkgroupArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The name of the workgroup associated with the database.
        /// </summary>
        [Input("workgroupName", required: true)]
        public string WorkgroupName { get; set; } = null!;

        public GetWorkgroupArgs()
        {
        }
        public static new GetWorkgroupArgs Empty => new GetWorkgroupArgs();
    }

    public sealed class GetWorkgroupInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The name of the workgroup associated with the database.
        /// </summary>
        [Input("workgroupName", required: true)]
        public Input<string> WorkgroupName { get; set; } = null!;

        public GetWorkgroupInvokeArgs()
        {
        }
        public static new GetWorkgroupInvokeArgs Empty => new GetWorkgroupInvokeArgs();
    }


    [OutputType]
    public sealed class GetWorkgroupResult
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the Redshift Serverless Workgroup.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// The endpoint that is created from the workgroup. See `Endpoint` below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetWorkgroupEndpointResult> Endpoints;
        /// <summary>
        /// The value that specifies whether to turn on enhanced virtual private cloud (VPC) routing, which forces Amazon Redshift Serverless to route traffic through your VPC instead of over the internet.
        /// </summary>
        public readonly bool EnhancedVpcRouting;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string NamespaceName;
        /// <summary>
        /// A value that specifies whether the workgroup can be accessed from a public network.
        /// </summary>
        public readonly bool PubliclyAccessible;
        /// <summary>
        /// An array of security group IDs to associate with the workgroup.
        /// </summary>
        public readonly ImmutableArray<string> SecurityGroupIds;
        /// <summary>
        /// An array of VPC subnet IDs to associate with the workgroup. When set, must contain at least three subnets spanning three Availability Zones. A minimum number of IP addresses is required and scales with the Base Capacity. For more information, see the following [AWS document](https://docs.aws.amazon.com/redshift/latest/mgmt/serverless-known-issues.html).
        /// </summary>
        public readonly ImmutableArray<string> SubnetIds;
        /// <summary>
        /// The name of the track for the workgroup.
        /// </summary>
        public readonly string TrackName;
        /// <summary>
        /// The Redshift Workgroup ID.
        /// </summary>
        public readonly string WorkgroupId;
        public readonly string WorkgroupName;

        [OutputConstructor]
        private GetWorkgroupResult(
            string arn,

            ImmutableArray<Outputs.GetWorkgroupEndpointResult> endpoints,

            bool enhancedVpcRouting,

            string id,

            string namespaceName,

            bool publiclyAccessible,

            ImmutableArray<string> securityGroupIds,

            ImmutableArray<string> subnetIds,

            string trackName,

            string workgroupId,

            string workgroupName)
        {
            Arn = arn;
            Endpoints = endpoints;
            EnhancedVpcRouting = enhancedVpcRouting;
            Id = id;
            NamespaceName = namespaceName;
            PubliclyAccessible = publiclyAccessible;
            SecurityGroupIds = securityGroupIds;
            SubnetIds = subnetIds;
            TrackName = trackName;
            WorkgroupId = workgroupId;
            WorkgroupName = workgroupName;
        }
    }
}
