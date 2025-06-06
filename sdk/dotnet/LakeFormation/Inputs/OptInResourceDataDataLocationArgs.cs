// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LakeFormation.Inputs
{

    public sealed class OptInResourceDataDataLocationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier for the Data Catalog. By default, it is the account ID of the caller.
        /// </summary>
        [Input("catalogId")]
        public Input<string>? CatalogId { get; set; }

        /// <summary>
        /// ARN that uniquely identifies the data location resource.
        /// </summary>
        [Input("resourceArn", required: true)]
        public Input<string> ResourceArn { get; set; } = null!;

        public OptInResourceDataDataLocationArgs()
        {
        }
        public static new OptInResourceDataDataLocationArgs Empty => new OptInResourceDataDataLocationArgs();
    }
}
