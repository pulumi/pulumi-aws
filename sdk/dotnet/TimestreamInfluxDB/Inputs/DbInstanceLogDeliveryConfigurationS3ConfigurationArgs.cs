// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.TimestreamInfluxDB.Inputs
{

    public sealed class DbInstanceLogDeliveryConfigurationS3ConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the S3 bucket to deliver logs to.
        /// </summary>
        [Input("bucketName", required: true)]
        public Input<string> BucketName { get; set; } = null!;

        /// <summary>
        /// Indicates whether log delivery to the S3 bucket is enabled.
        /// 
        /// **Note**: The following arguments do updates in-place: `db_parameter_group_identifier`, `log_delivery_configuration`, `port`, `deployment_type`, `db_instance_type`, and `tags`. Changes to any other argument after a DB instance has been deployed will cause destruction and re-creation of the DB instance. Additionally, when `db_parameter_group_identifier` is added to a DB instance or modified, the DB instance will be updated in-place but if `db_parameter_group_identifier` is removed from a DB instance, the DB instance will be destroyed and re-created.
        /// </summary>
        [Input("enabled", required: true)]
        public Input<bool> Enabled { get; set; } = null!;

        public DbInstanceLogDeliveryConfigurationS3ConfigurationArgs()
        {
        }
        public static new DbInstanceLogDeliveryConfigurationS3ConfigurationArgs Empty => new DbInstanceLogDeliveryConfigurationS3ConfigurationArgs();
    }
}
