// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Emr.Outputs
{

    [OutputType]
    public sealed class ClusterBootstrapAction
    {
        /// <summary>
        /// List of command line arguments to pass to the bootstrap action script.
        /// </summary>
        public readonly ImmutableArray<string> Args;
        /// <summary>
        /// Name of the bootstrap action.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Location of the script to run during a bootstrap action. Can be either a location in Amazon S3 or on a local file system.
        /// </summary>
        public readonly string Path;

        [OutputConstructor]
        private ClusterBootstrapAction(
            ImmutableArray<string> args,

            string name,

            string path)
        {
            Args = args;
            Name = name;
            Path = path;
        }
    }
}
