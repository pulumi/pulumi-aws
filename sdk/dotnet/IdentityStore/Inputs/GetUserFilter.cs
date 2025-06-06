// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.IdentityStore.Inputs
{

    public sealed class GetUserFilterArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Attribute path that is used to specify which attribute name to search. Currently, `UserName` is the only valid attribute path.
        /// </summary>
        [Input("attributePath", required: true)]
        public string AttributePath { get; set; } = null!;

        /// <summary>
        /// Value for an attribute.
        /// </summary>
        [Input("attributeValue", required: true)]
        public string AttributeValue { get; set; } = null!;

        public GetUserFilterArgs()
        {
        }
        public static new GetUserFilterArgs Empty => new GetUserFilterArgs();
    }
}
