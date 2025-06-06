// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class DashboardSourceEntitySourceTemplateArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the resource.
        /// </summary>
        [Input("arn", required: true)]
        public Input<string> Arn { get; set; } = null!;

        [Input("dataSetReferences", required: true)]
        private InputList<Inputs.DashboardSourceEntitySourceTemplateDataSetReferenceArgs>? _dataSetReferences;

        /// <summary>
        /// List of dataset references. See data_set_references.
        /// </summary>
        public InputList<Inputs.DashboardSourceEntitySourceTemplateDataSetReferenceArgs> DataSetReferences
        {
            get => _dataSetReferences ?? (_dataSetReferences = new InputList<Inputs.DashboardSourceEntitySourceTemplateDataSetReferenceArgs>());
            set => _dataSetReferences = value;
        }

        public DashboardSourceEntitySourceTemplateArgs()
        {
        }
        public static new DashboardSourceEntitySourceTemplateArgs Empty => new DashboardSourceEntitySourceTemplateArgs();
    }
}
