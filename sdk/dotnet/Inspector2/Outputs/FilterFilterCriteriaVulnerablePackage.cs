// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Inspector2.Outputs
{

    [OutputType]
    public sealed class FilterFilterCriteriaVulnerablePackage
    {
        /// <summary>
        /// (Optional) The architecture of the package. Documented below.
        /// </summary>
        public readonly Outputs.FilterFilterCriteriaVulnerablePackageArchitecture? Architecture;
        /// <summary>
        /// (Optional) The epoch of the package. Documented below.
        /// </summary>
        public readonly ImmutableArray<Outputs.FilterFilterCriteriaVulnerablePackageEpoch> Epoches;
        /// <summary>
        /// (Optional) The name of the package. Documented below.
        /// </summary>
        public readonly Outputs.FilterFilterCriteriaVulnerablePackageFilePath? FilePath;
        /// <summary>
        /// Name of the filter.
        /// </summary>
        public readonly Outputs.FilterFilterCriteriaVulnerablePackageName? Name;
        /// <summary>
        /// (Optional) The release of the package. Documented below.
        /// </summary>
        public readonly Outputs.FilterFilterCriteriaVulnerablePackageRelease? Release;
        /// <summary>
        /// (Optional) The ARN of the package's source lambda layer. Documented below.
        /// </summary>
        public readonly Outputs.FilterFilterCriteriaVulnerablePackageSourceLambdaLayerArn? SourceLambdaLayerArn;
        /// <summary>
        /// (Optional) The source layer hash of the package. Documented below.
        /// </summary>
        public readonly Outputs.FilterFilterCriteriaVulnerablePackageSourceLayerHash? SourceLayerHash;
        /// <summary>
        /// (Optional) The version of the package. Documented below.
        /// </summary>
        public readonly Outputs.FilterFilterCriteriaVulnerablePackageVersion? Version;

        [OutputConstructor]
        private FilterFilterCriteriaVulnerablePackage(
            Outputs.FilterFilterCriteriaVulnerablePackageArchitecture? architecture,

            ImmutableArray<Outputs.FilterFilterCriteriaVulnerablePackageEpoch> epoches,

            Outputs.FilterFilterCriteriaVulnerablePackageFilePath? filePath,

            Outputs.FilterFilterCriteriaVulnerablePackageName? name,

            Outputs.FilterFilterCriteriaVulnerablePackageRelease? release,

            Outputs.FilterFilterCriteriaVulnerablePackageSourceLambdaLayerArn? sourceLambdaLayerArn,

            Outputs.FilterFilterCriteriaVulnerablePackageSourceLayerHash? sourceLayerHash,

            Outputs.FilterFilterCriteriaVulnerablePackageVersion? version)
        {
            Architecture = architecture;
            Epoches = epoches;
            FilePath = filePath;
            Name = name;
            Release = release;
            SourceLambdaLayerArn = sourceLambdaLayerArn;
            SourceLayerHash = sourceLayerHash;
            Version = version;
        }
    }
}
