// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Workspaces.Outputs
{

    [OutputType]
    public sealed class WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPattern
    {
        /// <summary>
        /// The built-in pattern from the list of preconfigured patterns. Either a `custom_pattern` or `built_in_pattern_id` is required.
        /// </summary>
        public readonly string? BuiltInPatternId;
        /// <summary>
        /// The confidence level for inline redaction pattern. This indicates the certainty of data type matches in the redaction process. Values range from 1 (low confidence) to 3 (high confidence).
        /// </summary>
        public readonly int? ConfidenceLevel;
        /// <summary>
        /// The configuration for a custom pattern. Either a `custom_pattern` or `built_in_pattern_id` is required. Detailed below.
        /// </summary>
        public readonly Outputs.WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternCustomPattern? CustomPattern;
        /// <summary>
        /// The enforced URL configuration for the inline redaction pattern.
        /// </summary>
        public readonly ImmutableArray<string> EnforcedUrls;
        /// <summary>
        /// The exempt URL configuration for the inline redaction pattern.
        /// </summary>
        public readonly ImmutableArray<string> ExemptUrls;
        /// <summary>
        /// The redaction placeholder that will replace the redacted text in session. Detailed below.
        /// </summary>
        public readonly ImmutableArray<Outputs.WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolder> RedactionPlaceHolders;

        [OutputConstructor]
        private WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPattern(
            string? builtInPatternId,

            int? confidenceLevel,

            Outputs.WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternCustomPattern? customPattern,

            ImmutableArray<string> enforcedUrls,

            ImmutableArray<string> exemptUrls,

            ImmutableArray<Outputs.WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolder> redactionPlaceHolders)
        {
            BuiltInPatternId = builtInPatternId;
            ConfidenceLevel = confidenceLevel;
            CustomPattern = customPattern;
            EnforcedUrls = enforcedUrls;
            ExemptUrls = exemptUrls;
            RedactionPlaceHolders = redactionPlaceHolders;
        }
    }
}
