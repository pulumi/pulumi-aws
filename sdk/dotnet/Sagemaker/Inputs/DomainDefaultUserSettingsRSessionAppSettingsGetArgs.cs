// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DomainDefaultUserSettingsRSessionAppSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("customImages")]
        private InputList<Inputs.DomainDefaultUserSettingsRSessionAppSettingsCustomImageGetArgs>? _customImages;

        /// <summary>
        /// A list of custom SageMaker AI images that are configured to run as a RSession app. see `custom_image` Block below.
        /// </summary>
        public InputList<Inputs.DomainDefaultUserSettingsRSessionAppSettingsCustomImageGetArgs> CustomImages
        {
            get => _customImages ?? (_customImages = new InputList<Inputs.DomainDefaultUserSettingsRSessionAppSettingsCustomImageGetArgs>());
            set => _customImages = value;
        }

        /// <summary>
        /// The default instance type and the Amazon Resource Name (ARN) of the SageMaker AI image created on the instance. see `default_resource_spec` Block above.
        /// </summary>
        [Input("defaultResourceSpec")]
        public Input<Inputs.DomainDefaultUserSettingsRSessionAppSettingsDefaultResourceSpecGetArgs>? DefaultResourceSpec { get; set; }

        public DomainDefaultUserSettingsRSessionAppSettingsGetArgs()
        {
        }
        public static new DomainDefaultUserSettingsRSessionAppSettingsGetArgs Empty => new DomainDefaultUserSettingsRSessionAppSettingsGetArgs();
    }
}
