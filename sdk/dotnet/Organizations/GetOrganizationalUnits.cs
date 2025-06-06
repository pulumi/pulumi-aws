// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Organizations
{
    public static class GetOrganizationalUnits
    {
        /// <summary>
        /// Get all direct child organizational units under a parent organizational unit. This only provides immediate children, not all children.
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
        ///     var org = Aws.Organizations.GetOrganization.Invoke();
        /// 
        ///     var ou = Aws.Organizations.GetOrganizationalUnits.Invoke(new()
        ///     {
        ///         ParentId = org.Apply(getOrganizationResult =&gt; getOrganizationResult.Roots[0]?.Id),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetOrganizationalUnitsResult> InvokeAsync(GetOrganizationalUnitsArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetOrganizationalUnitsResult>("aws:organizations/getOrganizationalUnits:getOrganizationalUnits", args ?? new GetOrganizationalUnitsArgs(), options.WithDefaults());

        /// <summary>
        /// Get all direct child organizational units under a parent organizational unit. This only provides immediate children, not all children.
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
        ///     var org = Aws.Organizations.GetOrganization.Invoke();
        /// 
        ///     var ou = Aws.Organizations.GetOrganizationalUnits.Invoke(new()
        ///     {
        ///         ParentId = org.Apply(getOrganizationResult =&gt; getOrganizationResult.Roots[0]?.Id),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetOrganizationalUnitsResult> Invoke(GetOrganizationalUnitsInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetOrganizationalUnitsResult>("aws:organizations/getOrganizationalUnits:getOrganizationalUnits", args ?? new GetOrganizationalUnitsInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Get all direct child organizational units under a parent organizational unit. This only provides immediate children, not all children.
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
        ///     var org = Aws.Organizations.GetOrganization.Invoke();
        /// 
        ///     var ou = Aws.Organizations.GetOrganizationalUnits.Invoke(new()
        ///     {
        ///         ParentId = org.Apply(getOrganizationResult =&gt; getOrganizationResult.Roots[0]?.Id),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetOrganizationalUnitsResult> Invoke(GetOrganizationalUnitsInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetOrganizationalUnitsResult>("aws:organizations/getOrganizationalUnits:getOrganizationalUnits", args ?? new GetOrganizationalUnitsInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetOrganizationalUnitsArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Parent ID of the organizational unit.
        /// </summary>
        [Input("parentId", required: true)]
        public string ParentId { get; set; } = null!;

        public GetOrganizationalUnitsArgs()
        {
        }
        public static new GetOrganizationalUnitsArgs Empty => new GetOrganizationalUnitsArgs();
    }

    public sealed class GetOrganizationalUnitsInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Parent ID of the organizational unit.
        /// </summary>
        [Input("parentId", required: true)]
        public Input<string> ParentId { get; set; } = null!;

        public GetOrganizationalUnitsInvokeArgs()
        {
        }
        public static new GetOrganizationalUnitsInvokeArgs Empty => new GetOrganizationalUnitsInvokeArgs();
    }


    [OutputType]
    public sealed class GetOrganizationalUnitsResult
    {
        /// <summary>
        /// List of child organizational units, which have the following attributes:
        /// </summary>
        public readonly ImmutableArray<Outputs.GetOrganizationalUnitsChildResult> Children;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string ParentId;

        [OutputConstructor]
        private GetOrganizationalUnitsResult(
            ImmutableArray<Outputs.GetOrganizationalUnitsChildResult> children,

            string id,

            string parentId)
        {
            Children = children;
            Id = id;
            ParentId = parentId;
        }
    }
}
