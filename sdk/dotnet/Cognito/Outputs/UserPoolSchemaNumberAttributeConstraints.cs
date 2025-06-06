// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cognito.Outputs
{

    [OutputType]
    public sealed class UserPoolSchemaNumberAttributeConstraints
    {
        /// <summary>
        /// Maximum value of an attribute that is of the number data type.
        /// </summary>
        public readonly string? MaxValue;
        /// <summary>
        /// Minimum value of an attribute that is of the number data type.
        /// </summary>
        public readonly string? MinValue;

        [OutputConstructor]
        private UserPoolSchemaNumberAttributeConstraints(
            string? maxValue,

            string? minValue)
        {
            MaxValue = maxValue;
            MinValue = minValue;
        }
    }
}
