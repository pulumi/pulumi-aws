// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Workspaces.Inputs
{

    public sealed class WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternCustomPatternArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The keyword regex for the customer pattern.
        /// </summary>
        [Input("keywordRegex")]
        public Input<string>? KeywordRegex { get; set; }

        /// <summary>
        /// The pattern description for the customer pattern.
        /// </summary>
        [Input("patternDescription")]
        public Input<string>? PatternDescription { get; set; }

        /// <summary>
        /// The pattern name for the custom pattern.
        /// </summary>
        [Input("patternName", required: true)]
        public Input<string> PatternName { get; set; } = null!;

        /// <summary>
        /// The pattern regex for the customer pattern. The format must follow JavaScript regex format.
        /// </summary>
        [Input("patternRegex", required: true)]
        public Input<string> PatternRegex { get; set; } = null!;

        public WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternCustomPatternArgs()
        {
        }
        public static new WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternCustomPatternArgs Empty => new WebDataProtectionSettingsInlineRedactionConfigurationInlineRedactionPatternCustomPatternArgs();
    }
}
