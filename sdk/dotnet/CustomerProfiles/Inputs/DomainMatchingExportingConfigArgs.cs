// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CustomerProfiles.Inputs
{

    public sealed class DomainMatchingExportingConfigArgs : global::Pulumi.ResourceArgs
    {
        [Input("s3Exporting")]
        public Input<Inputs.DomainMatchingExportingConfigS3ExportingArgs>? S3Exporting { get; set; }

        public DomainMatchingExportingConfigArgs()
        {
        }
        public static new DomainMatchingExportingConfigArgs Empty => new DomainMatchingExportingConfigArgs();
    }
}
