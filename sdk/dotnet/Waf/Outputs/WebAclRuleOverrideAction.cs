// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Waf.Outputs
{

    [OutputType]
    public sealed class WebAclRuleOverrideAction
    {
        /// <summary>
        /// valid values are: `NONE` or `COUNT`
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private WebAclRuleOverrideAction(string type)
        {
            Type = type;
        }
    }
}
