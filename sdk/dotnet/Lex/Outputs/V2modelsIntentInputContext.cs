// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Outputs
{

    [OutputType]
    public sealed class V2modelsIntentInputContext
    {
        /// <summary>
        /// Name of the context.
        /// </summary>
        public readonly string Name;

        [OutputConstructor]
        private V2modelsIntentInputContext(string name)
        {
            Name = name;
        }
    }
}
