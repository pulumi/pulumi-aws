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
    public sealed class V2modelsIntentDialogCodeHook
    {
        /// <summary>
        /// Enables the dialog code hook so that it processes user requests.
        /// </summary>
        public readonly bool Enabled;

        [OutputConstructor]
        private V2modelsIntentDialogCodeHook(bool enabled)
        {
            Enabled = enabled;
        }
    }
}
