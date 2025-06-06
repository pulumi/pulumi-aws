// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeGuruReviewer.Inputs
{

    public sealed class RepositoryAssociationRepositoryCodecommitGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the AWS CodeCommit repository.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        public RepositoryAssociationRepositoryCodecommitGetArgs()
        {
        }
        public static new RepositoryAssociationRepositoryCodecommitGetArgs Empty => new RepositoryAssociationRepositoryCodecommitGetArgs();
    }
}
