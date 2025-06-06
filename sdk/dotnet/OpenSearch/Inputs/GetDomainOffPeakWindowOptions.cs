// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearch.Inputs
{

    public sealed class GetDomainOffPeakWindowOptionsArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Enabled disabled toggle for off-peak update window
        /// </summary>
        [Input("enabled", required: true)]
        public bool Enabled { get; set; }

        [Input("offPeakWindows", required: true)]
        private List<Inputs.GetDomainOffPeakWindowOptionsOffPeakWindowArgs>? _offPeakWindows;
        public List<Inputs.GetDomainOffPeakWindowOptionsOffPeakWindowArgs> OffPeakWindows
        {
            get => _offPeakWindows ?? (_offPeakWindows = new List<Inputs.GetDomainOffPeakWindowOptionsOffPeakWindowArgs>());
            set => _offPeakWindows = value;
        }

        public GetDomainOffPeakWindowOptionsArgs()
        {
        }
        public static new GetDomainOffPeakWindowOptionsArgs Empty => new GetDomainOffPeakWindowOptionsArgs();
    }
}
