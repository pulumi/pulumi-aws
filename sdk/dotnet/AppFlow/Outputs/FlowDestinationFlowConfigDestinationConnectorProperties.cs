// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Outputs
{

    [OutputType]
    public sealed class FlowDestinationFlowConfigDestinationConnectorProperties
    {
        /// <summary>
        /// Properties that are required to query the custom Connector. See Custom Connector Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnector? CustomConnector;
        /// <summary>
        /// Properties that are required to query Amazon Connect Customer Profiles. See Customer Profiles Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesCustomerProfiles? CustomerProfiles;
        /// <summary>
        /// Properties that are required to query Amazon EventBridge. See Generic Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesEventBridge? EventBridge;
        /// <summary>
        /// Properties that are required to query Amazon Honeycode. See Generic Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesHoneycode? Honeycode;
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesLookoutMetrics? LookoutMetrics;
        /// <summary>
        /// Properties that are required to query Marketo. See Generic Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesMarketo? Marketo;
        /// <summary>
        /// Properties that are required to query Amazon Redshift. See Redshift Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesRedshift? Redshift;
        /// <summary>
        /// Properties that are required to query Amazon S3. See S3 Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesS3? S3;
        /// <summary>
        /// Properties that are required to query Salesforce. See Salesforce Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesSalesforce? Salesforce;
        /// <summary>
        /// Properties that are required to query SAPOData. See SAPOData Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesSapoData? SapoData;
        /// <summary>
        /// Properties that are required to query Snowflake. See Snowflake Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesSnowflake? Snowflake;
        /// <summary>
        /// Properties that are required to query Upsolver. See Upsolver Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolver? Upsolver;
        /// <summary>
        /// Properties that are required to query Zendesk. See Zendesk Destination Properties for more details.
        /// </summary>
        public readonly Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesZendesk? Zendesk;

        [OutputConstructor]
        private FlowDestinationFlowConfigDestinationConnectorProperties(
            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesCustomConnector? customConnector,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesCustomerProfiles? customerProfiles,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesEventBridge? eventBridge,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesHoneycode? honeycode,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesLookoutMetrics? lookoutMetrics,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesMarketo? marketo,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesRedshift? redshift,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesS3? s3,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesSalesforce? salesforce,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesSapoData? sapoData,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesSnowflake? snowflake,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolver? upsolver,

            Outputs.FlowDestinationFlowConfigDestinationConnectorPropertiesZendesk? zendesk)
        {
            CustomConnector = customConnector;
            CustomerProfiles = customerProfiles;
            EventBridge = eventBridge;
            Honeycode = honeycode;
            LookoutMetrics = lookoutMetrics;
            Marketo = marketo;
            Redshift = redshift;
            S3 = s3;
            Salesforce = salesforce;
            SapoData = sapoData;
            Snowflake = snowflake;
            Upsolver = upsolver;
            Zendesk = zendesk;
        }
    }
}
