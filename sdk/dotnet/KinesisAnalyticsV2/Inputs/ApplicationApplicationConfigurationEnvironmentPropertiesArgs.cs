// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Inputs
{

    public sealed class ApplicationApplicationConfigurationEnvironmentPropertiesArgs : global::Pulumi.ResourceArgs
    {
        [Input("propertyGroups", required: true)]
        private InputList<Inputs.ApplicationApplicationConfigurationEnvironmentPropertiesPropertyGroupArgs>? _propertyGroups;

        /// <summary>
        /// Describes the execution property groups.
        /// </summary>
        public InputList<Inputs.ApplicationApplicationConfigurationEnvironmentPropertiesPropertyGroupArgs> PropertyGroups
        {
            get => _propertyGroups ?? (_propertyGroups = new InputList<Inputs.ApplicationApplicationConfigurationEnvironmentPropertiesPropertyGroupArgs>());
            set => _propertyGroups = value;
        }

        public ApplicationApplicationConfigurationEnvironmentPropertiesArgs()
        {
        }
        public static new ApplicationApplicationConfigurationEnvironmentPropertiesArgs Empty => new ApplicationApplicationConfigurationEnvironmentPropertiesArgs();
    }
}
