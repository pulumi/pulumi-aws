// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LakeFormation.Outputs
{

    [OutputType]
    public sealed class OptInResourceDataTableWithColumnsColumnWildcard
    {
        public readonly ImmutableArray<string> ExcludedColumnNames;

        [OutputConstructor]
        private OptInResourceDataTableWithColumnsColumnWildcard(ImmutableArray<string> excludedColumnNames)
        {
            ExcludedColumnNames = excludedColumnNames;
        }
    }
}
