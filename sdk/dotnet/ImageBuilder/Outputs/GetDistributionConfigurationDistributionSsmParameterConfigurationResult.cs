// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Outputs
{

    [OutputType]
    public sealed class GetDistributionConfigurationDistributionSsmParameterConfigurationResult
    {
        /// <summary>
        /// The AWS account ID that own the parameter in the given region.
        /// </summary>
        public readonly string AmiAccountId;
        /// <summary>
        /// The data type of the SSM parameter.
        /// </summary>
        public readonly string DataType;
        /// <summary>
        /// Name of the SSM parameter used to store the AMI ID after distribution.
        /// </summary>
        public readonly string ParameterName;

        [OutputConstructor]
        private GetDistributionConfigurationDistributionSsmParameterConfigurationResult(
            string amiAccountId,

            string dataType,

            string parameterName)
        {
            AmiAccountId = amiAccountId;
            DataType = dataType;
            ParameterName = parameterName;
        }
    }
}
