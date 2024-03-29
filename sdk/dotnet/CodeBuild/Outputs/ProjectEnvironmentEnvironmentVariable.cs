// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeBuild.Outputs
{

    [OutputType]
    public sealed class ProjectEnvironmentEnvironmentVariable
    {
        /// <summary>
        /// Project's name.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Build output artifact's type. Valid values: `CODEPIPELINE`, `NO_ARTIFACTS`, `S3`.
        /// </summary>
        public readonly string? Type;
        /// <summary>
        /// Environment variable's value.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private ProjectEnvironmentEnvironmentVariable(
            string name,

            string? type,

            string value)
        {
            Name = name;
            Type = type;
            Value = value;
        }
    }
}
