// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class VirtualGatewaySpecLoggingAccessLogFileFormatGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("jsons")]
        private InputList<Inputs.VirtualGatewaySpecLoggingAccessLogFileFormatJsonGetArgs>? _jsons;

        /// <summary>
        /// The logging format for JSON.
        /// </summary>
        public InputList<Inputs.VirtualGatewaySpecLoggingAccessLogFileFormatJsonGetArgs> Jsons
        {
            get => _jsons ?? (_jsons = new InputList<Inputs.VirtualGatewaySpecLoggingAccessLogFileFormatJsonGetArgs>());
            set => _jsons = value;
        }

        /// <summary>
        /// The logging format for text. Must be between 1 and 1000 characters in length.
        /// </summary>
        [Input("text")]
        public Input<string>? Text { get; set; }

        public VirtualGatewaySpecLoggingAccessLogFileFormatGetArgs()
        {
        }
        public static new VirtualGatewaySpecLoggingAccessLogFileFormatGetArgs Empty => new VirtualGatewaySpecLoggingAccessLogFileFormatGetArgs();
    }
}
