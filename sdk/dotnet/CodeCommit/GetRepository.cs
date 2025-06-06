// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeCommit
{
    public static class GetRepository
    {
        /// <summary>
        /// The CodeCommit Repository data source allows the ARN, Repository ID, Repository URL for HTTP and Repository URL for SSH to be retrieved for an CodeCommit repository.
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
        ///     var test = Aws.CodeCommit.GetRepository.Invoke(new()
        ///     {
        ///         RepositoryName = "MyTestRepository",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetRepositoryResult> InvokeAsync(GetRepositoryArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetRepositoryResult>("aws:codecommit/getRepository:getRepository", args ?? new GetRepositoryArgs(), options.WithDefaults());

        /// <summary>
        /// The CodeCommit Repository data source allows the ARN, Repository ID, Repository URL for HTTP and Repository URL for SSH to be retrieved for an CodeCommit repository.
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
        ///     var test = Aws.CodeCommit.GetRepository.Invoke(new()
        ///     {
        ///         RepositoryName = "MyTestRepository",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetRepositoryResult> Invoke(GetRepositoryInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetRepositoryResult>("aws:codecommit/getRepository:getRepository", args ?? new GetRepositoryInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// The CodeCommit Repository data source allows the ARN, Repository ID, Repository URL for HTTP and Repository URL for SSH to be retrieved for an CodeCommit repository.
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
        ///     var test = Aws.CodeCommit.GetRepository.Invoke(new()
        ///     {
        ///         RepositoryName = "MyTestRepository",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetRepositoryResult> Invoke(GetRepositoryInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetRepositoryResult>("aws:codecommit/getRepository:getRepository", args ?? new GetRepositoryInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetRepositoryArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name for the repository. This needs to be less than 100 characters.
        /// </summary>
        [Input("repositoryName", required: true)]
        public string RepositoryName { get; set; } = null!;

        public GetRepositoryArgs()
        {
        }
        public static new GetRepositoryArgs Empty => new GetRepositoryArgs();
    }

    public sealed class GetRepositoryInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name for the repository. This needs to be less than 100 characters.
        /// </summary>
        [Input("repositoryName", required: true)]
        public Input<string> RepositoryName { get; set; } = null!;

        public GetRepositoryInvokeArgs()
        {
        }
        public static new GetRepositoryInvokeArgs Empty => new GetRepositoryInvokeArgs();
    }


    [OutputType]
    public sealed class GetRepositoryResult
    {
        /// <summary>
        /// ARN of the repository.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// URL to use for cloning the repository over HTTPS.
        /// </summary>
        public readonly string CloneUrlHttp;
        /// <summary>
        /// URL to use for cloning the repository over SSH.
        /// </summary>
        public readonly string CloneUrlSsh;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// The ID of the encryption key.
        /// </summary>
        public readonly string KmsKeyId;
        /// <summary>
        /// ID of the repository.
        /// </summary>
        public readonly string RepositoryId;
        public readonly string RepositoryName;

        [OutputConstructor]
        private GetRepositoryResult(
            string arn,

            string cloneUrlHttp,

            string cloneUrlSsh,

            string id,

            string kmsKeyId,

            string repositoryId,

            string repositoryName)
        {
            Arn = arn;
            CloneUrlHttp = cloneUrlHttp;
            CloneUrlSsh = cloneUrlSsh;
            Id = id;
            KmsKeyId = kmsKeyId;
            RepositoryId = repositoryId;
            RepositoryName = repositoryName;
        }
    }
}
