// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GuardDuty.Outputs
{

    [OutputType]
    public sealed class DetectorDatasources
    {
        /// <summary>
        /// Configures [Kubernetes protection](https://docs.aws.amazon.com/guardduty/latest/ug/kubernetes-protection.html).
        /// See Kubernetes and Kubernetes Audit Logs below for more details.
        /// </summary>
        public readonly Outputs.DetectorDatasourcesKubernetes? Kubernetes;
        /// <summary>
        /// Configures [Malware Protection](https://docs.aws.amazon.com/guardduty/latest/ug/malware-protection.html).
        /// See Malware Protection, Scan EC2 instance with findings and EBS volumes below for more details.
        /// </summary>
        public readonly Outputs.DetectorDatasourcesMalwareProtection? MalwareProtection;
        /// <summary>
        /// Configures [S3 protection](https://docs.aws.amazon.com/guardduty/latest/ug/s3-protection.html).
        /// See S3 Logs below for more details.
        /// </summary>
        public readonly Outputs.DetectorDatasourcesS3Logs? S3Logs;

        [OutputConstructor]
        private DetectorDatasources(
            Outputs.DetectorDatasourcesKubernetes? kubernetes,

            Outputs.DetectorDatasourcesMalwareProtection? malwareProtection,

            Outputs.DetectorDatasourcesS3Logs? s3Logs)
        {
            Kubernetes = kubernetes;
            MalwareProtection = malwareProtection;
            S3Logs = s3Logs;
        }
    }
}
