// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.EcrPublic.Inputs
{

    public sealed class RepositoryCatalogDataArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A detailed description of the contents of the repository. It is publicly visible in the Amazon ECR Public Gallery. The text must be in markdown format.
        /// </summary>
        [Input("aboutText")]
        public Input<string>? AboutText { get; set; }

        [Input("architectures")]
        private InputList<string>? _architectures;

        /// <summary>
        /// The system architecture that the images in the repository are compatible with. On the Amazon ECR Public Gallery, the following supported architectures will appear as badges on the repository and are used as search filters: `ARM`, `ARM 64`, `x86`, `x86-64`
        /// </summary>
        public InputList<string> Architectures
        {
            get => _architectures ?? (_architectures = new InputList<string>());
            set => _architectures = value;
        }

        /// <summary>
        /// A short description of the contents of the repository. This text appears in both the image details and also when searching for repositories on the Amazon ECR Public Gallery.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// The base64-encoded repository logo payload. (Only visible for verified accounts) Note that drift detection is disabled for this attribute.
        /// </summary>
        [Input("logoImageBlob")]
        public Input<string>? LogoImageBlob { get; set; }

        [Input("operatingSystems")]
        private InputList<string>? _operatingSystems;

        /// <summary>
        /// The operating systems that the images in the repository are compatible with. On the Amazon ECR Public Gallery, the following supported operating systems will appear as badges on the repository and are used as search filters: `Linux`, `Windows`
        /// </summary>
        public InputList<string> OperatingSystems
        {
            get => _operatingSystems ?? (_operatingSystems = new InputList<string>());
            set => _operatingSystems = value;
        }

        /// <summary>
        /// Detailed information on how to use the contents of the repository. It is publicly visible in the Amazon ECR Public Gallery. The usage text provides context, support information, and additional usage details for users of the repository. The text must be in markdown format.
        /// </summary>
        [Input("usageText")]
        public Input<string>? UsageText { get; set; }

        public RepositoryCatalogDataArgs()
        {
        }
        public static new RepositoryCatalogDataArgs Empty => new RepositoryCatalogDataArgs();
    }
}
