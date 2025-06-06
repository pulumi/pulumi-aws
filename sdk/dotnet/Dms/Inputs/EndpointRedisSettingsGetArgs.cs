// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Dms.Inputs
{

    public sealed class EndpointRedisSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("authPassword")]
        private Input<string>? _authPassword;

        /// <summary>
        /// The password provided with the auth-role and auth-token options of the AuthType setting for a Redis target endpoint.
        /// </summary>
        public Input<string>? AuthPassword
        {
            get => _authPassword;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _authPassword = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// The type of authentication to perform when connecting to a Redis target. Options include `none`, `auth-token`, and `auth-role`. The `auth-token` option requires an `auth_password` value to be provided. The `auth-role` option requires `auth_user_name` and `auth_password` values to be provided.
        /// </summary>
        [Input("authType", required: true)]
        public Input<string> AuthType { get; set; } = null!;

        /// <summary>
        /// The username provided with the `auth-role` option of the AuthType setting for a Redis target endpoint.
        /// </summary>
        [Input("authUserName")]
        public Input<string>? AuthUserName { get; set; }

        /// <summary>
        /// Transmission Control Protocol (TCP) port for the endpoint.
        /// </summary>
        [Input("port", required: true)]
        public Input<int> Port { get; set; } = null!;

        /// <summary>
        /// Fully qualified domain name of the endpoint.
        /// </summary>
        [Input("serverName", required: true)]
        public Input<string> ServerName { get; set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) for the certificate authority (CA) that DMS uses to connect to your Redis target endpoint.
        /// </summary>
        [Input("sslCaCertificateArn")]
        public Input<string>? SslCaCertificateArn { get; set; }

        /// <summary>
        /// The plaintext option doesn't provide Transport Layer Security (TLS) encryption for traffic between endpoint and database. Options include `plaintext`, `ssl-encryption`. The default is `ssl-encryption`.
        /// </summary>
        [Input("sslSecurityProtocol")]
        public Input<string>? SslSecurityProtocol { get; set; }

        public EndpointRedisSettingsGetArgs()
        {
        }
        public static new EndpointRedisSettingsGetArgs Empty => new EndpointRedisSettingsGetArgs();
    }
}
