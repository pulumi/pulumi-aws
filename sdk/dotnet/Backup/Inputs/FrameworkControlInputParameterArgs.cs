// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Backup.Inputs
{

    public sealed class FrameworkControlInputParameterArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of a parameter, for example, BackupPlanFrequency.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// The value of parameter, for example, hourly.
        /// </summary>
        [Input("value")]
        public Input<string>? Value { get; set; }

        public FrameworkControlInputParameterArgs()
        {
        }
        public static new FrameworkControlInputParameterArgs Empty => new FrameworkControlInputParameterArgs();
    }
}
