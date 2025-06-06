// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Inputs
{

    public sealed class ImageRecipeComponentGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Amazon Resource Name (ARN) of the Image Builder Component to associate.
        /// </summary>
        [Input("componentArn", required: true)]
        public Input<string> ComponentArn { get; set; } = null!;

        [Input("parameters")]
        private InputList<Inputs.ImageRecipeComponentParameterGetArgs>? _parameters;

        /// <summary>
        /// Configuration block(s) for parameters to configure the component. Detailed below.
        /// </summary>
        public InputList<Inputs.ImageRecipeComponentParameterGetArgs> Parameters
        {
            get => _parameters ?? (_parameters = new InputList<Inputs.ImageRecipeComponentParameterGetArgs>());
            set => _parameters = value;
        }

        public ImageRecipeComponentGetArgs()
        {
        }
        public static new ImageRecipeComponentGetArgs Empty => new ImageRecipeComponentGetArgs();
    }
}
