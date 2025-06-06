// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MskConnect.Outputs
{

    [OutputType]
    public sealed class ConnectorLogDelivery
    {
        /// <summary>
        /// The workers can send worker logs to different destination types. This configuration specifies the details of these destinations. See `worker_log_delivery` Block for details.
        /// </summary>
        public readonly Outputs.ConnectorLogDeliveryWorkerLogDelivery WorkerLogDelivery;

        [OutputConstructor]
        private ConnectorLogDelivery(Outputs.ConnectorLogDeliveryWorkerLogDelivery workerLogDelivery)
        {
            WorkerLogDelivery = workerLogDelivery;
        }
    }
}
