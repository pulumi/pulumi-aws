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
    public sealed class V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupMessageCustomPayload
    {
        /// <summary>
        /// String that is sent to your application.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private V2modelsIntentConfirmationSettingConfirmationConditionalDefaultBranchResponseMessageGroupMessageCustomPayload(string value)
        {
            Value = value;
        }
    }
}
