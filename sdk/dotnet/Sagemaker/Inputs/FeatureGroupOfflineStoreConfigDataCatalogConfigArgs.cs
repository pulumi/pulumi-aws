// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class FeatureGroupOfflineStoreConfigDataCatalogConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the Glue table catalog.
        /// </summary>
        [Input("catalog")]
        public Input<string>? Catalog { get; set; }

        /// <summary>
        /// The name of the Glue table database.
        /// </summary>
        [Input("database")]
        public Input<string>? Database { get; set; }

        /// <summary>
        /// The name of the Glue table.
        /// </summary>
        [Input("tableName")]
        public Input<string>? TableName { get; set; }

        public FeatureGroupOfflineStoreConfigDataCatalogConfigArgs()
        {
        }
        public static new FeatureGroupOfflineStoreConfigDataCatalogConfigArgs Empty => new FeatureGroupOfflineStoreConfigDataCatalogConfigArgs();
    }
}
