// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsoAdmin.Inputs
{

    public sealed class GetApplicationPortalOptionSignInOptionInputArgs : global::Pulumi.ResourceArgs
    {
        [Input("applicationUrl", required: true)]
        public Input<string> ApplicationUrl { get; set; } = null!;

        [Input("origin", required: true)]
        public Input<string> Origin { get; set; } = null!;

        public GetApplicationPortalOptionSignInOptionInputArgs()
        {
        }
        public static new GetApplicationPortalOptionSignInOptionInputArgs Empty => new GetApplicationPortalOptionSignInOptionInputArgs();
    }
}
