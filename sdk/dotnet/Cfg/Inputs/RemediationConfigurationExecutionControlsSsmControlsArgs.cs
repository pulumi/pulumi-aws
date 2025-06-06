// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cfg.Inputs
{

    public sealed class RemediationConfigurationExecutionControlsSsmControlsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Maximum percentage of remediation actions allowed to run in parallel on the non-compliant resources for that specific rule. The default value is 10%.
        /// </summary>
        [Input("concurrentExecutionRatePercentage")]
        public Input<int>? ConcurrentExecutionRatePercentage { get; set; }

        /// <summary>
        /// Percentage of errors that are allowed before SSM stops running automations on non-compliant resources for that specific rule. The default is 50%.
        /// </summary>
        [Input("errorPercentage")]
        public Input<int>? ErrorPercentage { get; set; }

        public RemediationConfigurationExecutionControlsSsmControlsArgs()
        {
        }
        public static new RemediationConfigurationExecutionControlsSsmControlsArgs Empty => new RemediationConfigurationExecutionControlsSsmControlsArgs();
    }
}
