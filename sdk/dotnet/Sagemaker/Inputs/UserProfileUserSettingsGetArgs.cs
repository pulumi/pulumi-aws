// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class UserProfileUserSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Indicates whether auto-mounting of an EFS volume is supported for the user profile. The `DefaultAsDomain` value is only supported for user profiles. Do not use the `DefaultAsDomain` value when setting this parameter for a domain. Valid values are: `Enabled`, `Disabled`, and `DefaultAsDomain`.
        /// </summary>
        [Input("autoMountHomeEfs")]
        public Input<string>? AutoMountHomeEfs { get; set; }

        /// <summary>
        /// The Canvas app settings. See Canvas App Settings below.
        /// </summary>
        [Input("canvasAppSettings")]
        public Input<Inputs.UserProfileUserSettingsCanvasAppSettingsGetArgs>? CanvasAppSettings { get; set; }

        /// <summary>
        /// The Code Editor application settings. See Code Editor App Settings below.
        /// </summary>
        [Input("codeEditorAppSettings")]
        public Input<Inputs.UserProfileUserSettingsCodeEditorAppSettingsGetArgs>? CodeEditorAppSettings { get; set; }

        [Input("customFileSystemConfigs")]
        private InputList<Inputs.UserProfileUserSettingsCustomFileSystemConfigGetArgs>? _customFileSystemConfigs;

        /// <summary>
        /// The settings for assigning a custom file system to a user profile. Permitted users can access this file system in Amazon SageMaker AI Studio. See Custom File System Config below.
        /// </summary>
        public InputList<Inputs.UserProfileUserSettingsCustomFileSystemConfigGetArgs> CustomFileSystemConfigs
        {
            get => _customFileSystemConfigs ?? (_customFileSystemConfigs = new InputList<Inputs.UserProfileUserSettingsCustomFileSystemConfigGetArgs>());
            set => _customFileSystemConfigs = value;
        }

        /// <summary>
        /// Details about the POSIX identity that is used for file system operations. See Custom Posix User Config below.
        /// </summary>
        [Input("customPosixUserConfig")]
        public Input<Inputs.UserProfileUserSettingsCustomPosixUserConfigGetArgs>? CustomPosixUserConfig { get; set; }

        /// <summary>
        /// The default experience that the user is directed to when accessing the domain. The supported values are: `studio::`: Indicates that Studio is the default experience. This value can only be passed if StudioWebPortal is set to ENABLED. `app:JupyterServer:`: Indicates that Studio Classic is the default experience.
        /// </summary>
        [Input("defaultLandingUri")]
        public Input<string>? DefaultLandingUri { get; set; }

        /// <summary>
        /// The execution role ARN for the user.
        /// </summary>
        [Input("executionRole", required: true)]
        public Input<string> ExecutionRole { get; set; } = null!;

        /// <summary>
        /// The settings for the JupyterLab application. See Jupyter Lab App Settings below.
        /// </summary>
        [Input("jupyterLabAppSettings")]
        public Input<Inputs.UserProfileUserSettingsJupyterLabAppSettingsGetArgs>? JupyterLabAppSettings { get; set; }

        /// <summary>
        /// The Jupyter server's app settings. See Jupyter Server App Settings below.
        /// </summary>
        [Input("jupyterServerAppSettings")]
        public Input<Inputs.UserProfileUserSettingsJupyterServerAppSettingsGetArgs>? JupyterServerAppSettings { get; set; }

        /// <summary>
        /// The kernel gateway app settings. See Kernel Gateway App Settings below.
        /// </summary>
        [Input("kernelGatewayAppSettings")]
        public Input<Inputs.UserProfileUserSettingsKernelGatewayAppSettingsGetArgs>? KernelGatewayAppSettings { get; set; }

        /// <summary>
        /// The RSession app settings. See RSession App Settings below.
        /// </summary>
        [Input("rSessionAppSettings")]
        public Input<Inputs.UserProfileUserSettingsRSessionAppSettingsGetArgs>? RSessionAppSettings { get; set; }

        /// <summary>
        /// A collection of settings that configure user interaction with the RStudioServerPro app. See RStudioServerProAppSettings below.
        /// </summary>
        [Input("rStudioServerProAppSettings")]
        public Input<Inputs.UserProfileUserSettingsRStudioServerProAppSettingsGetArgs>? RStudioServerProAppSettings { get; set; }

        [Input("securityGroups")]
        private InputList<string>? _securityGroups;

        /// <summary>
        /// A list of security group IDs that will be attached to the user.
        /// </summary>
        public InputList<string> SecurityGroups
        {
            get => _securityGroups ?? (_securityGroups = new InputList<string>());
            set => _securityGroups = value;
        }

        /// <summary>
        /// The sharing settings. See Sharing Settings below.
        /// </summary>
        [Input("sharingSettings")]
        public Input<Inputs.UserProfileUserSettingsSharingSettingsGetArgs>? SharingSettings { get; set; }

        /// <summary>
        /// The storage settings for a private space. See Space Storage Settings below.
        /// </summary>
        [Input("spaceStorageSettings")]
        public Input<Inputs.UserProfileUserSettingsSpaceStorageSettingsGetArgs>? SpaceStorageSettings { get; set; }

        /// <summary>
        /// Whether the user can access Studio. If this value is set to `DISABLED`, the user cannot access Studio, even if that is the default experience for the domain. Valid values are `ENABLED` and `DISABLED`.
        /// </summary>
        [Input("studioWebPortal")]
        public Input<string>? StudioWebPortal { get; set; }

        /// <summary>
        /// The Studio Web Portal settings. See `studio_web_portal_settings` Block below.
        /// </summary>
        [Input("studioWebPortalSettings")]
        public Input<Inputs.UserProfileUserSettingsStudioWebPortalSettingsGetArgs>? StudioWebPortalSettings { get; set; }

        /// <summary>
        /// The TensorBoard app settings. See TensorBoard App Settings below.
        /// </summary>
        [Input("tensorBoardAppSettings")]
        public Input<Inputs.UserProfileUserSettingsTensorBoardAppSettingsGetArgs>? TensorBoardAppSettings { get; set; }

        public UserProfileUserSettingsGetArgs()
        {
        }
        public static new UserProfileUserSettingsGetArgs Empty => new UserProfileUserSettingsGetArgs();
    }
}
