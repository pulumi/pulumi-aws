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
    public sealed class IntentConclusionStatement
    {
        public readonly ImmutableArray<Outputs.IntentConclusionStatementMessage> Messages;
        public readonly string? ResponseCard;

        [OutputConstructor]
        private IntentConclusionStatement(
            ImmutableArray<Outputs.IntentConclusionStatementMessage> messages,

            string? responseCard)
        {
            Messages = messages;
            ResponseCard = responseCard;
        }
    }
}
