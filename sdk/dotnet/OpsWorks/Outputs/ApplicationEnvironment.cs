// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpsWorks.Outputs
{

    [OutputType]
    public sealed class ApplicationEnvironment
    {
        /// <summary>
        /// Variable name.
        /// </summary>
        public readonly string Key;
        /// <summary>
        /// Set visibility of the variable value to `true` or `false`.
        /// </summary>
        public readonly bool? Secure;
        /// <summary>
        /// Variable value.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private ApplicationEnvironment(
            string key,

            bool? secure,

            string value)
        {
            Key = key;
            Secure = secure;
            Value = value;
        }
    }
}
