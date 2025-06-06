// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class LaunchTemplateCreditSpecificationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The credit option for CPU usage.
        /// Can be `standard` or `unlimited`.
        /// T3 instances are launched as `unlimited` by default.
        /// T2 instances are launched as `standard` by default.
        /// </summary>
        [Input("cpuCredits")]
        public Input<string>? CpuCredits { get; set; }

        public LaunchTemplateCreditSpecificationGetArgs()
        {
        }
        public static new LaunchTemplateCreditSpecificationGetArgs Empty => new LaunchTemplateCreditSpecificationGetArgs();
    }
}
