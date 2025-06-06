// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MskConnect.Inputs
{

    public sealed class ConnectorLogDeliveryGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The workers can send worker logs to different destination types. This configuration specifies the details of these destinations. See `worker_log_delivery` Block for details.
        /// </summary>
        [Input("workerLogDelivery", required: true)]
        public Input<Inputs.ConnectorLogDeliveryWorkerLogDeliveryGetArgs> WorkerLogDelivery { get; set; } = null!;

        public ConnectorLogDeliveryGetArgs()
        {
        }
        public static new ConnectorLogDeliveryGetArgs Empty => new ConnectorLogDeliveryGetArgs();
    }
}
