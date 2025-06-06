// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kms.Inputs
{

    public sealed class GetSecretSecretInputArgs : global::Pulumi.ResourceArgs
    {
        [Input("context")]
        private InputMap<string>? _context;
        public InputMap<string> Context
        {
            get => _context ?? (_context = new InputMap<string>());
            set => _context = value;
        }

        [Input("grantTokens")]
        private InputList<string>? _grantTokens;
        public InputList<string> GrantTokens
        {
            get => _grantTokens ?? (_grantTokens = new InputList<string>());
            set => _grantTokens = value;
        }

        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        [Input("payload", required: true)]
        public Input<string> Payload { get; set; } = null!;

        public GetSecretSecretInputArgs()
        {
        }
        public static new GetSecretSecretInputArgs Empty => new GetSecretSecretInputArgs();
    }
}
