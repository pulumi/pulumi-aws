// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class DataSetLogicalTableMapDataTransformProjectOperationArgs : global::Pulumi.ResourceArgs
    {
        [Input("projectedColumns", required: true)]
        private InputList<string>? _projectedColumns;

        /// <summary>
        /// Projected columns.
        /// </summary>
        public InputList<string> ProjectedColumns
        {
            get => _projectedColumns ?? (_projectedColumns = new InputList<string>());
            set => _projectedColumns = value;
        }

        public DataSetLogicalTableMapDataTransformProjectOperationArgs()
        {
        }
        public static new DataSetLogicalTableMapDataTransformProjectOperationArgs Empty => new DataSetLogicalTableMapDataTransformProjectOperationArgs();
    }
}
