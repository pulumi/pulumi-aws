// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Workspaces.Inputs
{

    public sealed class WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The built-in pattern from the list of preconfigured patterns. Either a `custom_pattern` or `built_in_pattern_id` is required.
        /// </summary>
        [Input("builtInPatternId")]
        public Input<string>? BuiltInPatternId { get; set; }

        /// <summary>
        /// The confidence level for inline redaction pattern. This indicates the certainty of data type matches in the redaction process. Values range from 1 (low confidence) to 3 (high confidence).
        /// </summary>
        [Input("confidenceLevel")]
        public Input<int>? ConfidenceLevel { get; set; }

        /// <summary>
        /// The configuration for a custom pattern. Either a `custom_pattern` or `built_in_pattern_id` is required. Detailed below.
        /// </summary>
        [Input("customPattern")]
        public Input<Inputs.WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternCustomPatternGetArgs>? CustomPattern { get; set; }

        [Input("enforcedUrls")]
        private InputList<string>? _enforcedUrls;

        /// <summary>
        /// The enforced URL configuration for the inline redaction pattern.
        /// </summary>
        public InputList<string> EnforcedUrls
        {
            get => _enforcedUrls ?? (_enforcedUrls = new InputList<string>());
            set => _enforcedUrls = value;
        }

        [Input("exemptUrls")]
        private InputList<string>? _exemptUrls;

        /// <summary>
        /// The exempt URL configuration for the inline redaction pattern.
        /// </summary>
        public InputList<string> ExemptUrls
        {
            get => _exemptUrls ?? (_exemptUrls = new InputList<string>());
            set => _exemptUrls = value;
        }

        [Input("redactionPlaceHolders")]
        private InputList<Inputs.WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolderGetArgs>? _redactionPlaceHolders;

        /// <summary>
        /// The redaction placeholder that will replace the redacted text in session. Detailed below.
        /// </summary>
        public InputList<Inputs.WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolderGetArgs> RedactionPlaceHolders
        {
            get => _redactionPlaceHolders ?? (_redactionPlaceHolders = new InputList<Inputs.WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternRedactionPlaceHolderGetArgs>());
            set => _redactionPlaceHolders = value;
        }

        public WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternGetArgs()
        {
        }
        public static new WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternGetArgs Empty => new WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternGetArgs();
    }
}
