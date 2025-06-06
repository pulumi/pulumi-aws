// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ElasticBeanstalk.Outputs
{

    [OutputType]
    public sealed class ConfigurationTemplateSetting
    {
        /// <summary>
        /// A unique name for this Template.
        /// </summary>
        public readonly string Name;
        public readonly string Namespace;
        public readonly string? Resource;
        public readonly string Value;

        [OutputConstructor]
        private ConfigurationTemplateSetting(
            string name,

            string @namespace,

            string? resource,

            string value)
        {
            Name = name;
            Namespace = @namespace;
            Resource = resource;
            Value = value;
        }
    }
}
