// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lambda.Inputs
{

    public sealed class CodeSigningConfigAllowedPublishersArgs : global::Pulumi.ResourceArgs
    {
        [Input("signingProfileVersionArns", required: true)]
        private InputList<string>? _signingProfileVersionArns;

        /// <summary>
        /// The Amazon Resource Name (ARN) for each of the signing profiles. A signing profile defines a trusted user who can sign a code package.
        /// </summary>
        public InputList<string> SigningProfileVersionArns
        {
            get => _signingProfileVersionArns ?? (_signingProfileVersionArns = new InputList<string>());
            set => _signingProfileVersionArns = value;
        }

        public CodeSigningConfigAllowedPublishersArgs()
        {
        }
        public static new CodeSigningConfigAllowedPublishersArgs Empty => new CodeSigningConfigAllowedPublishersArgs();
    }
}
