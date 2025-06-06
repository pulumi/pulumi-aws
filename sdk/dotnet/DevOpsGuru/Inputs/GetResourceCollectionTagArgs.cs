// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DevOpsGuru.Inputs
{

    public sealed class GetResourceCollectionTagInputArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// An AWS tag key that is used to identify the AWS resources that DevOps Guru analyzes.
        /// </summary>
        [Input("appBoundaryKey", required: true)]
        public Input<string> AppBoundaryKey { get; set; } = null!;

        [Input("tagValues", required: true)]
        private InputList<string>? _tagValues;

        /// <summary>
        /// Array of tag values.
        /// </summary>
        public InputList<string> TagValues
        {
            get => _tagValues ?? (_tagValues = new InputList<string>());
            set => _tagValues = value;
        }

        public GetResourceCollectionTagInputArgs()
        {
        }
        public static new GetResourceCollectionTagInputArgs Empty => new GetResourceCollectionTagInputArgs();
    }
}
