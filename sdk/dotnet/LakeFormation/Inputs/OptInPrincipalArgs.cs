// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LakeFormation.Inputs
{

    public sealed class OptInPrincipalArgs : global::Pulumi.ResourceArgs
    {
        [Input("dataLakePrincipalIdentifier", required: true)]
        public Input<string> DataLakePrincipalIdentifier { get; set; } = null!;

        public OptInPrincipalArgs()
        {
        }
        public static new OptInPrincipalArgs Empty => new OptInPrincipalArgs();
    }
}
