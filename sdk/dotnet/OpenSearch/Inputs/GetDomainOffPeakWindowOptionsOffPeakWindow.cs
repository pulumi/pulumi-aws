// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearch.Inputs
{

    public sealed class GetDomainOffPeakWindowOptionsOffPeakWindowArgs : global::Pulumi.InvokeArgs
    {
        [Input("windowStartTimes", required: true)]
        private List<Inputs.GetDomainOffPeakWindowOptionsOffPeakWindowWindowStartTimeArgs>? _windowStartTimes;

        /// <summary>
        /// 10h window for updates
        /// </summary>
        public List<Inputs.GetDomainOffPeakWindowOptionsOffPeakWindowWindowStartTimeArgs> WindowStartTimes
        {
            get => _windowStartTimes ?? (_windowStartTimes = new List<Inputs.GetDomainOffPeakWindowOptionsOffPeakWindowWindowStartTimeArgs>());
            set => _windowStartTimes = value;
        }

        public GetDomainOffPeakWindowOptionsOffPeakWindowArgs()
        {
        }
        public static new GetDomainOffPeakWindowOptionsOffPeakWindowArgs Empty => new GetDomainOffPeakWindowOptionsOffPeakWindowArgs();
    }
}
