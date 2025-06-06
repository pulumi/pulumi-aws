// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Outputs
{

    [OutputType]
    public sealed class ProjectServiceCatalogProvisioningDetails
    {
        /// <summary>
        /// The path identifier of the product. This value is optional if the product has a default path, and required if the product has more than one path.
        /// </summary>
        public readonly string? PathId;
        /// <summary>
        /// The ID of the product to provision.
        /// </summary>
        public readonly string ProductId;
        /// <summary>
        /// The ID of the provisioning artifact.
        /// </summary>
        public readonly string? ProvisioningArtifactId;
        /// <summary>
        /// A list of key value pairs that you specify when you provision a product. See Provisioning Parameter below.
        /// </summary>
        public readonly ImmutableArray<Outputs.ProjectServiceCatalogProvisioningDetailsProvisioningParameter> ProvisioningParameters;

        [OutputConstructor]
        private ProjectServiceCatalogProvisioningDetails(
            string? pathId,

            string productId,

            string? provisioningArtifactId,

            ImmutableArray<Outputs.ProjectServiceCatalogProvisioningDetailsProvisioningParameter> provisioningParameters)
        {
            PathId = pathId;
            ProductId = productId;
            ProvisioningArtifactId = provisioningArtifactId;
            ProvisioningParameters = provisioningParameters;
        }
    }
}
