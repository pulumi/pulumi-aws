// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Inputs
{

    public sealed class ApplicationApplicationConfigurationSqlApplicationConfigurationOutputDestinationSchemaArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the format of the records on the output stream. Valid values: `CSV`, `JSON`.
        /// </summary>
        [Input("recordFormatType", required: true)]
        public Input<string> RecordFormatType { get; set; } = null!;

        public ApplicationApplicationConfigurationSqlApplicationConfigurationOutputDestinationSchemaArgs()
        {
        }
        public static new ApplicationApplicationConfigurationSqlApplicationConfigurationOutputDestinationSchemaArgs Empty => new ApplicationApplicationConfigurationSqlApplicationConfigurationOutputDestinationSchemaArgs();
    }
}
