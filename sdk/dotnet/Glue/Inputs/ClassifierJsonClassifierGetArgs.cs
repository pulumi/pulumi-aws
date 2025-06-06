// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Glue.Inputs
{

    public sealed class ClassifierJsonClassifierGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A `JsonPath` string defining the JSON data for the classifier to classify. AWS Glue supports a subset of `JsonPath`, as described in [Writing JsonPath Custom Classifiers](https://docs.aws.amazon.com/glue/latest/dg/custom-classifier.html#custom-classifier-json).
        /// </summary>
        [Input("jsonPath", required: true)]
        public Input<string> JsonPath { get; set; } = null!;

        public ClassifierJsonClassifierGetArgs()
        {
        }
        public static new ClassifierJsonClassifierGetArgs Empty => new ClassifierJsonClassifierGetArgs();
    }
}
