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
    public sealed class ModelPrimaryContainerModelDataSourceS3DataSourceModelAccessConfig
    {
        /// <summary>
        /// Specifies agreement to the model end-user license agreement (EULA). The AcceptEula value must be explicitly defined as `true` in order to accept the EULA that this model requires. You are responsible for reviewing and complying with any applicable license terms and making sure they are acceptable for your use case before downloading or using a model.
        /// </summary>
        public readonly bool AcceptEula;

        [OutputConstructor]
        private ModelPrimaryContainerModelDataSourceS3DataSourceModelAccessConfig(bool acceptEula)
        {
            AcceptEula = acceptEula;
        }
    }
}
