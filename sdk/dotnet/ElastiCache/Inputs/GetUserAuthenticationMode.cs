// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ElastiCache.Inputs
{

    public sealed class GetUserAuthenticationModeArgs : global::Pulumi.InvokeArgs
    {
        [Input("passwordCount")]
        public int? PasswordCount { get; set; }

        [Input("type")]
        public string? Type { get; set; }

        public GetUserAuthenticationModeArgs()
        {
        }
        public static new GetUserAuthenticationModeArgs Empty => new GetUserAuthenticationModeArgs();
    }
}
