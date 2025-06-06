// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Transfer.Inputs
{

    public sealed class WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the details for the EFS file being copied.
        /// </summary>
        [Input("efsFileLocation")]
        public Input<Inputs.WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationEfsFileLocationGetArgs>? EfsFileLocation { get; set; }

        /// <summary>
        /// Specifies the details for the S3 file being copied.
        /// </summary>
        [Input("s3FileLocation")]
        public Input<Inputs.WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationS3FileLocationGetArgs>? S3FileLocation { get; set; }

        public WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationGetArgs()
        {
        }
        public static new WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationGetArgs Empty => new WorkflowOnExceptionStepCopyStepDetailsDestinationFileLocationGetArgs();
    }
}
