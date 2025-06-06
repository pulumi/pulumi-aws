// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ServiceCatalog.Outputs
{

    [OutputType]
    public sealed class ProvisionedProductOutput
    {
        /// <summary>
        /// The description of the output.
        /// </summary>
        public readonly string? Description;
        /// <summary>
        /// The output key.
        /// </summary>
        public readonly string? Key;
        /// <summary>
        /// The output value.
        /// </summary>
        public readonly string? Value;

        [OutputConstructor]
        private ProvisionedProductOutput(
            string? description,

            string? key,

            string? value)
        {
            Description = description;
            Key = key;
            Value = value;
        }
    }
}
