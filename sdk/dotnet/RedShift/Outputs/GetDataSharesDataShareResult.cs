// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.RedShift.Outputs
{

    [OutputType]
    public sealed class GetDataSharesDataShareResult
    {
        /// <summary>
        /// ARN (Amazon Resource Name) of the data share.
        /// </summary>
        public readonly string DataShareArn;
        /// <summary>
        /// Identifier of a datashare to show its managing entity.
        /// </summary>
        public readonly string ManagedBy;
        /// <summary>
        /// ARN (Amazon Resource Name) of the producer.
        /// </summary>
        public readonly string ProducerArn;

        [OutputConstructor]
        private GetDataSharesDataShareResult(
            string dataShareArn,

            string managedBy,

            string producerArn)
        {
            DataShareArn = dataShareArn;
            ManagedBy = managedBy;
            ProducerArn = producerArn;
        }
    }
}
