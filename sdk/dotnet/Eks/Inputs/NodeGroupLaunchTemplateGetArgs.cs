// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Eks.Inputs
{

    public sealed class NodeGroupLaunchTemplateGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier of the EC2 Launch Template. Conflicts with `name`.
        /// </summary>
        [Input("id")]
        public Input<string>? Id { get; set; }

        /// <summary>
        /// Name of the EC2 Launch Template. Conflicts with `id`.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// EC2 Launch Template version number. While the API accepts values like `$Default` and `$Latest`, the API will convert the value to the associated version number (e.g., `1`) on read and the provider will show a difference on next plan. Using the `default_version` or `latest_version` attribute of the `aws.ec2.LaunchTemplate` resource or data source is recommended for this argument.
        /// </summary>
        [Input("version", required: true)]
        public Input<string> Version { get; set; } = null!;

        public NodeGroupLaunchTemplateGetArgs()
        {
        }
        public static new NodeGroupLaunchTemplateGetArgs Empty => new NodeGroupLaunchTemplateGetArgs();
    }
}
