// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DataQualityJobDefinitionNetworkConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether to encrypt all communications between the instances used for the monitoring jobs. Choose `true` to encrypt communications. Encryption provides greater security for distributed jobs, but the processing might take longer.
        /// </summary>
        [Input("enableInterContainerTrafficEncryption")]
        public Input<bool>? EnableInterContainerTrafficEncryption { get; set; }

        /// <summary>
        /// Whether to allow inbound and outbound network calls to and from the containers used for the monitoring job.
        /// </summary>
        [Input("enableNetworkIsolation")]
        public Input<bool>? EnableNetworkIsolation { get; set; }

        /// <summary>
        /// Specifies a VPC that your training jobs and hosted models have access to. Control access to and from your training and model containers by configuring the VPC. Fields are documented below.
        /// </summary>
        [Input("vpcConfig")]
        public Input<Inputs.DataQualityJobDefinitionNetworkConfigVpcConfigArgs>? VpcConfig { get; set; }

        public DataQualityJobDefinitionNetworkConfigArgs()
        {
        }
        public static new DataQualityJobDefinitionNetworkConfigArgs Empty => new DataQualityJobDefinitionNetworkConfigArgs();
    }
}
