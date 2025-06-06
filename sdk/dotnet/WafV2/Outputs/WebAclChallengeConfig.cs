// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Outputs
{

    [OutputType]
    public sealed class WebAclChallengeConfig
    {
        /// <summary>
        /// Defines custom immunity time. See `immunity_time_property` below for details.
        /// </summary>
        public readonly Outputs.WebAclChallengeConfigImmunityTimeProperty? ImmunityTimeProperty;

        [OutputConstructor]
        private WebAclChallengeConfig(Outputs.WebAclChallengeConfigImmunityTimeProperty? immunityTimeProperty)
        {
            ImmunityTimeProperty = immunityTimeProperty;
        }
    }
}
