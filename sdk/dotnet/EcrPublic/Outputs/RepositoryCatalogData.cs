// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.EcrPublic.Outputs
{

    [OutputType]
    public sealed class RepositoryCatalogData
    {
        /// <summary>
        /// A detailed description of the contents of the repository. It is publicly visible in the Amazon ECR Public Gallery. The text must be in markdown format.
        /// </summary>
        public readonly string? AboutText;
        /// <summary>
        /// The system architecture that the images in the repository are compatible with. On the Amazon ECR Public Gallery, the following supported architectures will appear as badges on the repository and are used as search filters: `ARM`, `ARM 64`, `x86`, `x86-64`
        /// </summary>
        public readonly ImmutableArray<string> Architectures;
        /// <summary>
        /// A short description of the contents of the repository. This text appears in both the image details and also when searching for repositories on the Amazon ECR Public Gallery.
        /// </summary>
        public readonly string? Description;
        /// <summary>
        /// The base64-encoded repository logo payload. (Only visible for verified accounts) Note that drift detection is disabled for this attribute.
        /// </summary>
        public readonly string? LogoImageBlob;
        /// <summary>
        /// The operating systems that the images in the repository are compatible with. On the Amazon ECR Public Gallery, the following supported operating systems will appear as badges on the repository and are used as search filters: `Linux`, `Windows`
        /// </summary>
        public readonly ImmutableArray<string> OperatingSystems;
        /// <summary>
        /// Detailed information on how to use the contents of the repository. It is publicly visible in the Amazon ECR Public Gallery. The usage text provides context, support information, and additional usage details for users of the repository. The text must be in markdown format.
        /// </summary>
        public readonly string? UsageText;

        [OutputConstructor]
        private RepositoryCatalogData(
            string? aboutText,

            ImmutableArray<string> architectures,

            string? description,

            string? logoImageBlob,

            ImmutableArray<string> operatingSystems,

            string? usageText)
        {
            AboutText = aboutText;
            Architectures = architectures;
            Description = description;
            LogoImageBlob = logoImageBlob;
            OperatingSystems = operatingSystems;
            UsageText = usageText;
        }
    }
}
