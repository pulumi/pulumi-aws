// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Comprehend.Inputs
{

    public sealed class EntityRecognizerInputDataConfigDocumentsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies how the input files should be processed.
        /// One of `ONE_DOC_PER_LINE` or `ONE_DOC_PER_FILE`.
        /// </summary>
        [Input("inputFormat")]
        public Input<string>? InputFormat { get; set; }

        /// <summary>
        /// Location of training documents.
        /// </summary>
        [Input("s3Uri", required: true)]
        public Input<string> S3Uri { get; set; } = null!;

        [Input("testS3Uri")]
        public Input<string>? TestS3Uri { get; set; }

        public EntityRecognizerInputDataConfigDocumentsGetArgs()
        {
        }
        public static new EntityRecognizerInputDataConfigDocumentsGetArgs Empty => new EntityRecognizerInputDataConfigDocumentsGetArgs();
    }
}
