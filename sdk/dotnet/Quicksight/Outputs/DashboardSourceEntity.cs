// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Outputs
{

    [OutputType]
    public sealed class DashboardSourceEntity
    {
        /// <summary>
        /// The source template. See source_template.
        /// </summary>
        public readonly Outputs.DashboardSourceEntitySourceTemplate? SourceTemplate;

        [OutputConstructor]
        private DashboardSourceEntity(Outputs.DashboardSourceEntitySourceTemplate? sourceTemplate)
        {
            SourceTemplate = sourceTemplate;
        }
    }
}
