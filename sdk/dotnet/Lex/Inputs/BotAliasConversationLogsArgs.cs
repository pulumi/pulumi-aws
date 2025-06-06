// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class BotAliasConversationLogsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the IAM role used to write your logs to CloudWatch Logs or an S3 bucket. Must be between 20 and 2048 characters in length.
        /// </summary>
        [Input("iamRoleArn", required: true)]
        public Input<string> IamRoleArn { get; set; } = null!;

        [Input("logSettings")]
        private InputList<Inputs.BotAliasConversationLogsLogSettingArgs>? _logSettings;

        /// <summary>
        /// The settings for your conversation logs. You can log text, audio, or both. Attributes are documented under log_settings.
        /// </summary>
        public InputList<Inputs.BotAliasConversationLogsLogSettingArgs> LogSettings
        {
            get => _logSettings ?? (_logSettings = new InputList<Inputs.BotAliasConversationLogsLogSettingArgs>());
            set => _logSettings = value;
        }

        public BotAliasConversationLogsArgs()
        {
        }
        public static new BotAliasConversationLogsArgs Empty => new BotAliasConversationLogsArgs();
    }
}
