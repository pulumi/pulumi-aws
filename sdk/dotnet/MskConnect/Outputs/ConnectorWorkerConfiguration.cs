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
    public sealed class ConnectorWorkerConfiguration
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the worker configuration.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// The revision of the worker configuration.
        /// </summary>
        public readonly int Revision;

        [OutputConstructor]
        private ConnectorWorkerConfiguration(
            string arn,

            int revision)
        {
            Arn = arn;
            Revision = revision;
        }
    }
}
