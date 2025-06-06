// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Outputs
{

    [OutputType]
    public sealed class BotAbortStatement
    {
        public readonly ImmutableArray<Outputs.BotAbortStatementMessage> Messages;
        public readonly string? ResponseCard;

        [OutputConstructor]
        private BotAbortStatement(
            ImmutableArray<Outputs.BotAbortStatementMessage> messages,

            string? responseCard)
        {
            Messages = messages;
            ResponseCard = responseCard;
        }
    }
}
