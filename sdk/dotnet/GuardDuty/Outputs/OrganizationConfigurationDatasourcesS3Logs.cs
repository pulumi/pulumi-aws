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
    public sealed class OrganizationConfigurationDatasourcesS3Logs
    {
        /// <summary>
        /// Set to `true` if you want S3 data event logs to be automatically enabled for new members of the organization. Default: `false`
        /// </summary>
        public readonly bool AutoEnable;

        [OutputConstructor]
        private OrganizationConfigurationDatasourcesS3Logs(bool autoEnable)
        {
            AutoEnable = autoEnable;
        }
    }
}
