// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.IdentityStore
{
    public static class GetGroupMemberships
    {
        /// <summary>
        /// Use this data source to get a list of members in an Identity Store Group.
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
        ///     var example = Aws.SsoAdmin.GetInstances.Invoke();
        /// 
        ///     var exampleGetGroup = Aws.IdentityStore.GetGroup.Invoke(new()
        ///     {
        ///         IdentityStoreId = example.Apply(getInstancesResult =&gt; getInstancesResult.IdentityStoreIds[0]),
        ///         AlternateIdentifier = new Aws.IdentityStore.Inputs.GetGroupAlternateIdentifierInputArgs
        ///         {
        ///             UniqueAttribute = new Aws.IdentityStore.Inputs.GetGroupAlternateIdentifierUniqueAttributeInputArgs
        ///             {
        ///                 AttributePath = "DisplayName",
        ///                 AttributeValue = "ExampleGroup",
        ///             },
        ///         },
        ///     });
        /// 
        ///     var exampleGetGroupMemberships = Aws.IdentityStore.GetGroupMemberships.Invoke(new()
        ///     {
        ///         IdentityStoreId = example.Apply(getInstancesResult =&gt; getInstancesResult.IdentityStoreIds[0]),
        ///         GroupId = exampleGetGroup.Apply(getGroupResult =&gt; getGroupResult.GroupId),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetGroupMembershipsResult> InvokeAsync(GetGroupMembershipsArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetGroupMembershipsResult>("aws:identitystore/getGroupMemberships:getGroupMemberships", args ?? new GetGroupMembershipsArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get a list of members in an Identity Store Group.
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
        ///     var example = Aws.SsoAdmin.GetInstances.Invoke();
        /// 
        ///     var exampleGetGroup = Aws.IdentityStore.GetGroup.Invoke(new()
        ///     {
        ///         IdentityStoreId = example.Apply(getInstancesResult =&gt; getInstancesResult.IdentityStoreIds[0]),
        ///         AlternateIdentifier = new Aws.IdentityStore.Inputs.GetGroupAlternateIdentifierInputArgs
        ///         {
        ///             UniqueAttribute = new Aws.IdentityStore.Inputs.GetGroupAlternateIdentifierUniqueAttributeInputArgs
        ///             {
        ///                 AttributePath = "DisplayName",
        ///                 AttributeValue = "ExampleGroup",
        ///             },
        ///         },
        ///     });
        /// 
        ///     var exampleGetGroupMemberships = Aws.IdentityStore.GetGroupMemberships.Invoke(new()
        ///     {
        ///         IdentityStoreId = example.Apply(getInstancesResult =&gt; getInstancesResult.IdentityStoreIds[0]),
        ///         GroupId = exampleGetGroup.Apply(getGroupResult =&gt; getGroupResult.GroupId),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetGroupMembershipsResult> Invoke(GetGroupMembershipsInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetGroupMembershipsResult>("aws:identitystore/getGroupMemberships:getGroupMemberships", args ?? new GetGroupMembershipsInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get a list of members in an Identity Store Group.
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
        ///     var example = Aws.SsoAdmin.GetInstances.Invoke();
        /// 
        ///     var exampleGetGroup = Aws.IdentityStore.GetGroup.Invoke(new()
        ///     {
        ///         IdentityStoreId = example.Apply(getInstancesResult =&gt; getInstancesResult.IdentityStoreIds[0]),
        ///         AlternateIdentifier = new Aws.IdentityStore.Inputs.GetGroupAlternateIdentifierInputArgs
        ///         {
        ///             UniqueAttribute = new Aws.IdentityStore.Inputs.GetGroupAlternateIdentifierUniqueAttributeInputArgs
        ///             {
        ///                 AttributePath = "DisplayName",
        ///                 AttributeValue = "ExampleGroup",
        ///             },
        ///         },
        ///     });
        /// 
        ///     var exampleGetGroupMemberships = Aws.IdentityStore.GetGroupMemberships.Invoke(new()
        ///     {
        ///         IdentityStoreId = example.Apply(getInstancesResult =&gt; getInstancesResult.IdentityStoreIds[0]),
        ///         GroupId = exampleGetGroup.Apply(getGroupResult =&gt; getGroupResult.GroupId),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetGroupMembershipsResult> Invoke(GetGroupMembershipsInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetGroupMembershipsResult>("aws:identitystore/getGroupMemberships:getGroupMemberships", args ?? new GetGroupMembershipsInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetGroupMembershipsArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The identifier for a group in the Identity Store.
        /// </summary>
        [Input("groupId", required: true)]
        public string GroupId { get; set; } = null!;

        /// <summary>
        /// Identity Store ID associated with the Single Sign-On Instance.
        /// </summary>
        [Input("identityStoreId", required: true)]
        public string IdentityStoreId { get; set; } = null!;

        public GetGroupMembershipsArgs()
        {
        }
        public static new GetGroupMembershipsArgs Empty => new GetGroupMembershipsArgs();
    }

    public sealed class GetGroupMembershipsInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The identifier for a group in the Identity Store.
        /// </summary>
        [Input("groupId", required: true)]
        public Input<string> GroupId { get; set; } = null!;

        /// <summary>
        /// Identity Store ID associated with the Single Sign-On Instance.
        /// </summary>
        [Input("identityStoreId", required: true)]
        public Input<string> IdentityStoreId { get; set; } = null!;

        public GetGroupMembershipsInvokeArgs()
        {
        }
        public static new GetGroupMembershipsInvokeArgs Empty => new GetGroupMembershipsInvokeArgs();
    }


    [OutputType]
    public sealed class GetGroupMembershipsResult
    {
        /// <summary>
        /// Group identifier.
        /// </summary>
        public readonly string GroupId;
        /// <summary>
        /// A list of group membership objects. See `group_memberships` below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetGroupMembershipsGroupMembershipResult> GroupMemberships;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Identity store identifier.
        /// </summary>
        public readonly string IdentityStoreId;

        [OutputConstructor]
        private GetGroupMembershipsResult(
            string groupId,

            ImmutableArray<Outputs.GetGroupMembershipsGroupMembershipResult> groupMemberships,

            string id,

            string identityStoreId)
        {
            GroupId = groupId;
            GroupMemberships = groupMemberships;
            Id = id;
            IdentityStoreId = identityStoreId;
        }
    }
}
