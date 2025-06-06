// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Chime.Outputs
{

    [OutputType]
    public sealed class VoiceConnectorGroupConnector
    {
        /// <summary>
        /// The priority associated with the Amazon Chime Voice Connector, with 1 being the highest priority. Higher priority Amazon Chime Voice Connectors are attempted first.
        /// </summary>
        public readonly int Priority;
        /// <summary>
        /// The Amazon Chime Voice Connector ID.
        /// </summary>
        public readonly string VoiceConnectorId;

        [OutputConstructor]
        private VoiceConnectorGroupConnector(
            int priority,

            string voiceConnectorId)
        {
            Priority = priority;
            VoiceConnectorId = voiceConnectorId;
        }
    }
}
