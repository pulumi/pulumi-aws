// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class FeatureGroupFeatureDefinitionArgs : global::Pulumi.ResourceArgs
    {
        [Input("collectionConfig")]
        public Input<Inputs.FeatureGroupFeatureDefinitionCollectionConfigArgs>? CollectionConfig { get; set; }

        [Input("collectionType")]
        public Input<string>? CollectionType { get; set; }

        /// <summary>
        /// The name of a feature. `feature_name` cannot be any of the following: `is_deleted`, `write_time`, `api_invocation_time`.
        /// </summary>
        [Input("featureName")]
        public Input<string>? FeatureName { get; set; }

        /// <summary>
        /// The value type of a feature. Valid values are `Integral`, `Fractional`, or `String`.
        /// </summary>
        [Input("featureType")]
        public Input<string>? FeatureType { get; set; }

        public FeatureGroupFeatureDefinitionArgs()
        {
        }
        public static new FeatureGroupFeatureDefinitionArgs Empty => new FeatureGroupFeatureDefinitionArgs();
    }
}
