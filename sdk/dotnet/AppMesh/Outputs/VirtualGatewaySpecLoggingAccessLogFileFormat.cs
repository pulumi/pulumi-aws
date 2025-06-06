// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Outputs
{

    [OutputType]
    public sealed class VirtualGatewaySpecLoggingAccessLogFileFormat
    {
        /// <summary>
        /// The logging format for JSON.
        /// </summary>
        public readonly ImmutableArray<Outputs.VirtualGatewaySpecLoggingAccessLogFileFormatJson> Jsons;
        /// <summary>
        /// The logging format for text. Must be between 1 and 1000 characters in length.
        /// </summary>
        public readonly string? Text;

        [OutputConstructor]
        private VirtualGatewaySpecLoggingAccessLogFileFormat(
            ImmutableArray<Outputs.VirtualGatewaySpecLoggingAccessLogFileFormatJson> jsons,

            string? text)
        {
            Jsons = jsons;
            Text = text;
        }
    }
}
