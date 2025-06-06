// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh
{
    public static class GetVirtualService
    {
        /// <summary>
        /// The App Mesh Virtual Service data source allows details of an App Mesh Virtual Service to be retrieved by its name, mesh_name, and optionally the mesh_owner.
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
        ///     var test = Aws.AppMesh.GetVirtualService.Invoke(new()
        ///     {
        ///         Name = "example.mesh.local",
        ///         MeshName = "example-mesh",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var current = Aws.GetCallerIdentity.Invoke();
        /// 
        ///     var test = Aws.AppMesh.GetVirtualService.Invoke(new()
        ///     {
        ///         Name = "example.mesh.local",
        ///         MeshName = "example-mesh",
        ///         MeshOwner = current.Apply(getCallerIdentityResult =&gt; getCallerIdentityResult.AccountId),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetVirtualServiceResult> InvokeAsync(GetVirtualServiceArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetVirtualServiceResult>("aws:appmesh/getVirtualService:getVirtualService", args ?? new GetVirtualServiceArgs(), options.WithDefaults());

        /// <summary>
        /// The App Mesh Virtual Service data source allows details of an App Mesh Virtual Service to be retrieved by its name, mesh_name, and optionally the mesh_owner.
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
        ///     var test = Aws.AppMesh.GetVirtualService.Invoke(new()
        ///     {
        ///         Name = "example.mesh.local",
        ///         MeshName = "example-mesh",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var current = Aws.GetCallerIdentity.Invoke();
        /// 
        ///     var test = Aws.AppMesh.GetVirtualService.Invoke(new()
        ///     {
        ///         Name = "example.mesh.local",
        ///         MeshName = "example-mesh",
        ///         MeshOwner = current.Apply(getCallerIdentityResult =&gt; getCallerIdentityResult.AccountId),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetVirtualServiceResult> Invoke(GetVirtualServiceInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetVirtualServiceResult>("aws:appmesh/getVirtualService:getVirtualService", args ?? new GetVirtualServiceInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// The App Mesh Virtual Service data source allows details of an App Mesh Virtual Service to be retrieved by its name, mesh_name, and optionally the mesh_owner.
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
        ///     var test = Aws.AppMesh.GetVirtualService.Invoke(new()
        ///     {
        ///         Name = "example.mesh.local",
        ///         MeshName = "example-mesh",
        ///     });
        /// 
        /// });
        /// ```
        /// 
        /// ```csharp
        /// using System.Collections.Generic;
        /// using System.Linq;
        /// using Pulumi;
        /// using Aws = Pulumi.Aws;
        /// 
        /// return await Deployment.RunAsync(() =&gt; 
        /// {
        ///     var current = Aws.GetCallerIdentity.Invoke();
        /// 
        ///     var test = Aws.AppMesh.GetVirtualService.Invoke(new()
        ///     {
        ///         Name = "example.mesh.local",
        ///         MeshName = "example-mesh",
        ///         MeshOwner = current.Apply(getCallerIdentityResult =&gt; getCallerIdentityResult.AccountId),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetVirtualServiceResult> Invoke(GetVirtualServiceInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetVirtualServiceResult>("aws:appmesh/getVirtualService:getVirtualService", args ?? new GetVirtualServiceInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetVirtualServiceArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the service mesh in which the virtual service exists.
        /// </summary>
        [Input("meshName", required: true)]
        public string MeshName { get; set; } = null!;

        /// <summary>
        /// AWS account ID of the service mesh's owner.
        /// </summary>
        [Input("meshOwner")]
        public string? MeshOwner { get; set; }

        /// <summary>
        /// Name of the virtual service.
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        [Input("tags")]
        private Dictionary<string, string>? _tags;

        /// <summary>
        /// Map of tags.
        /// </summary>
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetVirtualServiceArgs()
        {
        }
        public static new GetVirtualServiceArgs Empty => new GetVirtualServiceArgs();
    }

    public sealed class GetVirtualServiceInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the service mesh in which the virtual service exists.
        /// </summary>
        [Input("meshName", required: true)]
        public Input<string> MeshName { get; set; } = null!;

        /// <summary>
        /// AWS account ID of the service mesh's owner.
        /// </summary>
        [Input("meshOwner")]
        public Input<string>? MeshOwner { get; set; }

        /// <summary>
        /// Name of the virtual service.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetVirtualServiceInvokeArgs()
        {
        }
        public static new GetVirtualServiceInvokeArgs Empty => new GetVirtualServiceInvokeArgs();
    }


    [OutputType]
    public sealed class GetVirtualServiceResult
    {
        /// <summary>
        /// ARN of the virtual service.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Creation date of the virtual service.
        /// </summary>
        public readonly string CreatedDate;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Last update date of the virtual service.
        /// </summary>
        public readonly string LastUpdatedDate;
        public readonly string MeshName;
        public readonly string MeshOwner;
        public readonly string Name;
        /// <summary>
        /// Resource owner's AWS account ID.
        /// </summary>
        public readonly string ResourceOwner;
        /// <summary>
        /// Virtual service specification. See the `aws.appmesh.VirtualService` resource for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetVirtualServiceSpecResult> Specs;
        /// <summary>
        /// Map of tags.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Tags;

        [OutputConstructor]
        private GetVirtualServiceResult(
            string arn,

            string createdDate,

            string id,

            string lastUpdatedDate,

            string meshName,

            string meshOwner,

            string name,

            string resourceOwner,

            ImmutableArray<Outputs.GetVirtualServiceSpecResult> specs,

            ImmutableDictionary<string, string> tags)
        {
            Arn = arn;
            CreatedDate = createdDate;
            Id = id;
            LastUpdatedDate = lastUpdatedDate;
            MeshName = meshName;
            MeshOwner = meshOwner;
            Name = name;
            ResourceOwner = resourceOwner;
            Specs = specs;
            Tags = tags;
        }
    }
}
