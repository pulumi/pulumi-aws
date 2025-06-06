// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.EcrPublic
{
    public static class GetAuthorizationToken
    {
        /// <summary>
        /// The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
        /// 
        /// &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
        ///     var token = Aws.EcrPublic.GetAuthorizationToken.Invoke();
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetAuthorizationTokenResult> InvokeAsync(InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetAuthorizationTokenResult>("aws:ecrpublic/getAuthorizationToken:getAuthorizationToken", InvokeArgs.Empty, options.WithDefaults());

        /// <summary>
        /// The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
        /// 
        /// &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
        ///     var token = Aws.EcrPublic.GetAuthorizationToken.Invoke();
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetAuthorizationTokenResult> Invoke(InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetAuthorizationTokenResult>("aws:ecrpublic/getAuthorizationToken:getAuthorizationToken", InvokeArgs.Empty, options.WithDefaults());

        /// <summary>
        /// The Public ECR Authorization Token data source allows the authorization token, token expiration date, user name, and password to be retrieved for a Public ECR repository.
        /// 
        /// &gt; **NOTE:** This data source can only be used in the `us-east-1` region.
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
        ///     var token = Aws.EcrPublic.GetAuthorizationToken.Invoke();
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetAuthorizationTokenResult> Invoke(InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetAuthorizationTokenResult>("aws:ecrpublic/getAuthorizationToken:getAuthorizationToken", InvokeArgs.Empty, options.WithDefaults());
    }


    [OutputType]
    public sealed class GetAuthorizationTokenResult
    {
        /// <summary>
        /// Temporary IAM authentication credentials to access the ECR repository encoded in base64 in the form of `user_name:password`.
        /// </summary>
        public readonly string AuthorizationToken;
        /// <summary>
        /// Time in UTC RFC3339 format when the authorization token expires.
        /// </summary>
        public readonly string ExpiresAt;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Password decoded from the authorization token.
        /// </summary>
        public readonly string Password;
        /// <summary>
        /// User name decoded from the authorization token.
        /// </summary>
        public readonly string UserName;

        [OutputConstructor]
        private GetAuthorizationTokenResult(
            string authorizationToken,

            string expiresAt,

            string id,

            string password,

            string userName)
        {
            AuthorizationToken = authorizationToken;
            ExpiresAt = expiresAt;
            Id = id;
            Password = password;
            UserName = userName;
        }
    }
}
