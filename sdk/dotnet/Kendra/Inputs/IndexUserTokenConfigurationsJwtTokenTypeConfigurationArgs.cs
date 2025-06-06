// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kendra.Inputs
{

    public sealed class IndexUserTokenConfigurationsJwtTokenTypeConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The regular expression that identifies the claim. Minimum length of 1. Maximum length of 100.
        /// </summary>
        [Input("claimRegex")]
        public Input<string>? ClaimRegex { get; set; }

        /// <summary>
        /// The group attribute field. Minimum length of 1. Maximum length of 100.
        /// </summary>
        [Input("groupAttributeField")]
        public Input<string>? GroupAttributeField { get; set; }

        /// <summary>
        /// The issuer of the token. Minimum length of 1. Maximum length of 65.
        /// </summary>
        [Input("issuer")]
        public Input<string>? Issuer { get; set; }

        /// <summary>
        /// The location of the key. Valid values are `URL` or `SECRET_MANAGER`
        /// </summary>
        [Input("keyLocation", required: true)]
        public Input<string> KeyLocation { get; set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the secret.
        /// </summary>
        [Input("secretsManagerArn")]
        public Input<string>? SecretsManagerArn { get; set; }

        /// <summary>
        /// The signing key URL. Valid pattern is `^(https?|ftp|file):\/\/([^\s]*)`
        /// </summary>
        [Input("url")]
        public Input<string>? Url { get; set; }

        /// <summary>
        /// The user name attribute field. Minimum length of 1. Maximum length of 100.
        /// </summary>
        [Input("userNameAttributeField")]
        public Input<string>? UserNameAttributeField { get; set; }

        public IndexUserTokenConfigurationsJwtTokenTypeConfigurationArgs()
        {
        }
        public static new IndexUserTokenConfigurationsJwtTokenTypeConfigurationArgs Empty => new IndexUserTokenConfigurationsJwtTokenTypeConfigurationArgs();
    }
}
