// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Transfer.Outputs
{

    [OutputType]
    public sealed class WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationEfsFileLocation
    {
        /// <summary>
        /// The ID of the file system, assigned by Amazon EFS.
        /// </summary>
        public readonly string? FileSystemId;
        /// <summary>
        /// The pathname for the folder being used by a workflow.
        /// </summary>
        public readonly string? Path;

        [OutputConstructor]
        private WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationEfsFileLocation(
            string? fileSystemId,

            string? path)
        {
            FileSystemId = fileSystemId;
            Path = path;
        }
    }
}
