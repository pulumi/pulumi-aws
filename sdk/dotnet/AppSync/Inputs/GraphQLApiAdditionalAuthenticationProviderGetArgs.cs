// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppSync.Inputs
{

    public sealed class GraphQLApiAdditionalAuthenticationProviderGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Authentication type. Valid values: `API_KEY`, `AWS_IAM`, `AMAZON_COGNITO_USER_POOLS`, `OPENID_CONNECT`, `AWS_LAMBDA`
        /// </summary>
        [Input("authenticationType", required: true)]
        public Input<string> AuthenticationType { get; set; } = null!;

        /// <summary>
        /// Nested argument containing Lambda authorizer configuration. See `lambda_authorizer_config` Block for details.
        /// </summary>
        [Input("lambdaAuthorizerConfig")]
        public Input<Inputs.GraphQLApiAdditionalAuthenticationProviderLambdaAuthorizerConfigGetArgs>? LambdaAuthorizerConfig { get; set; }

        /// <summary>
        /// Nested argument containing OpenID Connect configuration. See `openid_connect_config` Block for details.
        /// </summary>
        [Input("openidConnectConfig")]
        public Input<Inputs.GraphQLApiAdditionalAuthenticationProviderOpenidConnectConfigGetArgs>? OpenidConnectConfig { get; set; }

        /// <summary>
        /// Amazon Cognito User Pool configuration. See `user_pool_config` Block for details.
        /// </summary>
        [Input("userPoolConfig")]
        public Input<Inputs.GraphQLApiAdditionalAuthenticationProviderUserPoolConfigGetArgs>? UserPoolConfig { get; set; }

        public GraphQLApiAdditionalAuthenticationProviderGetArgs()
        {
        }
        public static new GraphQLApiAdditionalAuthenticationProviderGetArgs Empty => new GraphQLApiAdditionalAuthenticationProviderGetArgs();
    }
}
