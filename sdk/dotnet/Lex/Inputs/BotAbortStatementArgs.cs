// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class BotAbortStatementArgs : global::Pulumi.ResourceArgs
    {
        [Input("messages", required: true)]
        private InputList<Inputs.BotAbortStatementMessageArgs>? _messages;
        public InputList<Inputs.BotAbortStatementMessageArgs> Messages
        {
            get => _messages ?? (_messages = new InputList<Inputs.BotAbortStatementMessageArgs>());
            set => _messages = value;
        }

        [Input("responseCard")]
        public Input<string>? ResponseCard { get; set; }

        public BotAbortStatementArgs()
        {
        }
        public static new BotAbortStatementArgs Empty => new BotAbortStatementArgs();
    }
}
