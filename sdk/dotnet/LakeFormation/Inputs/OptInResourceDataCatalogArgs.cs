// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LakeFormation.Inputs
{

    public sealed class OptInResourceDataCatalogArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier for the catalog resource.
        /// </summary>
        [Input("id")]
        public Input<string>? Id { get; set; }

        public OptInResourceDataCatalogArgs()
        {
        }
        public static new OptInResourceDataCatalogArgs Empty => new OptInResourceDataCatalogArgs();
    }
}
