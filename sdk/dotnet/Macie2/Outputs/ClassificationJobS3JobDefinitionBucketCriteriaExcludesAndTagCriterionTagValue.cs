// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Macie2.Outputs
{

    [OutputType]
    public sealed class ClassificationJobS3JobDefinitionBucketCriteriaExcludesAndTagCriterionTagValue
    {
        /// <summary>
        /// The tag key.
        /// </summary>
        public readonly string? Key;
        /// <summary>
        /// The tag value.
        /// </summary>
        public readonly string? Value;

        [OutputConstructor]
        private ClassificationJobS3JobDefinitionBucketCriteriaExcludesAndTagCriterionTagValue(
            string? key,

            string? value)
        {
            Key = key;
            Value = value;
        }
    }
}
