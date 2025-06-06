// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Mq.Inputs
{

    public sealed class BrokerUserGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether to enable access to the [ActiveMQ Web Console](http://activemq.apache.org/web-console.html) for the user. Applies to `engine_type` of `ActiveMQ` only.
        /// </summary>
        [Input("consoleAccess")]
        public Input<bool>? ConsoleAccess { get; set; }

        [Input("groups")]
        private InputList<string>? _groups;

        /// <summary>
        /// List of groups (20 maximum) to which the ActiveMQ user belongs. Applies to `engine_type` of `ActiveMQ` only.
        /// </summary>
        public InputList<string> Groups
        {
            get => _groups ?? (_groups = new InputList<string>());
            set => _groups = value;
        }

        [Input("password", required: true)]
        private Input<string>? _password;

        /// <summary>
        /// Password of the user. It must be 12 to 250 characters long, at least 4 unique characters, and must not contain commas.
        /// </summary>
        public Input<string>? Password
        {
            get => _password;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _password = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// Whether to set set replication user. Defaults to `false`.
        /// </summary>
        [Input("replicationUser")]
        public Input<bool>? ReplicationUser { get; set; }

        /// <summary>
        /// Username of the user.
        /// 
        /// &gt; **NOTE:** AWS currently does not support updating RabbitMQ users. Updates to users can only be in the RabbitMQ UI.
        /// </summary>
        [Input("username", required: true)]
        public Input<string> Username { get; set; } = null!;

        public BrokerUserGetArgs()
        {
        }
        public static new BrokerUserGetArgs Empty => new BrokerUserGetArgs();
    }
}
