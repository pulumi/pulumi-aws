// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cognito
{
    public static class GetUserPoolClients
    {
        /// <summary>
        /// Use this data source to get a list of Cognito user pools clients for a Cognito IdP user pool.
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
        ///     var main = Aws.Cognito.GetUserPoolClients.Invoke(new()
        ///     {
        ///         UserPoolId = mainAwsCognitoUserPool.Id,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetUserPoolClientsResult> InvokeAsync(GetUserPoolClientsArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetUserPoolClientsResult>("aws:cognito/getUserPoolClients:getUserPoolClients", args ?? new GetUserPoolClientsArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get a list of Cognito user pools clients for a Cognito IdP user pool.
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
        ///     var main = Aws.Cognito.GetUserPoolClients.Invoke(new()
        ///     {
        ///         UserPoolId = mainAwsCognitoUserPool.Id,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetUserPoolClientsResult> Invoke(GetUserPoolClientsInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetUserPoolClientsResult>("aws:cognito/getUserPoolClients:getUserPoolClients", args ?? new GetUserPoolClientsInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get a list of Cognito user pools clients for a Cognito IdP user pool.
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
        ///     var main = Aws.Cognito.GetUserPoolClients.Invoke(new()
        ///     {
        ///         UserPoolId = mainAwsCognitoUserPool.Id,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetUserPoolClientsResult> Invoke(GetUserPoolClientsInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetUserPoolClientsResult>("aws:cognito/getUserPoolClients:getUserPoolClients", args ?? new GetUserPoolClientsInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetUserPoolClientsArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Cognito user pool ID.
        /// </summary>
        [Input("userPoolId", required: true)]
        public string UserPoolId { get; set; } = null!;

        public GetUserPoolClientsArgs()
        {
        }
        public static new GetUserPoolClientsArgs Empty => new GetUserPoolClientsArgs();
    }

    public sealed class GetUserPoolClientsInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Cognito user pool ID.
        /// </summary>
        [Input("userPoolId", required: true)]
        public Input<string> UserPoolId { get; set; } = null!;

        public GetUserPoolClientsInvokeArgs()
        {
        }
        public static new GetUserPoolClientsInvokeArgs Empty => new GetUserPoolClientsInvokeArgs();
    }


    [OutputType]
    public sealed class GetUserPoolClientsResult
    {
        /// <summary>
        /// List of Cognito user pool client IDs.
        /// </summary>
        public readonly ImmutableArray<string> ClientIds;
        /// <summary>
        /// List of Cognito user pool client names.
        /// </summary>
        public readonly ImmutableArray<string> ClientNames;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string UserPoolId;

        [OutputConstructor]
        private GetUserPoolClientsResult(
            ImmutableArray<string> clientIds,

            ImmutableArray<string> clientNames,

            string id,

            string userPoolId)
        {
            ClientIds = clientIds;
            ClientNames = clientNames;
            Id = id;
            UserPoolId = userPoolId;
        }
    }
}
