// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeCatalyst.Inputs
{

    public sealed class GetDevEnvironmentRepositoryInputArgs : global::Pulumi.ResourceArgs
    {
        [Input("branchName", required: true)]
        public Input<string> BranchName { get; set; } = null!;

        [Input("repositoryName", required: true)]
        public Input<string> RepositoryName { get; set; } = null!;

        public GetDevEnvironmentRepositoryInputArgs()
        {
        }
        public static new GetDevEnvironmentRepositoryInputArgs Empty => new GetDevEnvironmentRepositoryInputArgs();
    }
}
