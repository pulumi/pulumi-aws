// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppStream.Outputs
{

    [OutputType]
    public sealed class GetImageApplicationResult
    {
        /// <summary>
        /// The app block ARN of the application.
        /// </summary>
        public readonly string AppBlockArn;
        /// <summary>
        /// Arn of the image being searched for. Cannot be used with name_regex or name.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Time at which this image was created.
        /// </summary>
        public readonly string CreatedTime;
        /// <summary>
        /// Description of image.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// Image name to display.
        /// </summary>
        public readonly string DisplayName;
        /// <summary>
        /// Bool based on if the application is enabled.
        /// </summary>
        public readonly bool Enabled;
        /// <summary>
        /// A list named icon_s3_location that contains the following:
        /// </summary>
        public readonly ImmutableArray<Outputs.GetImageApplicationIconS3LocationResult> IconS3Locations;
        /// <summary>
        /// URL of the application icon. This URL may be time-limited.
        /// </summary>
        public readonly string IconUrl;
        /// <summary>
        /// List of the instance families of the application.
        /// </summary>
        public readonly ImmutableArray<string> InstanceFamilies;
        /// <summary>
        /// Arguments that are passed to the application at it's launch.
        /// </summary>
        public readonly string LaunchParameters;
        /// <summary>
        /// Path to the application's excecutable in the instance.
        /// </summary>
        public readonly string LaunchPath;
        /// <summary>
        /// String to string map that contains additional attributes used to describe the application.
        /// * `Name` - Name of the application.
        /// </summary>
        public readonly ImmutableDictionary<string, string> Metadata;
        /// <summary>
        /// Name of the image being searched for. Cannot be used with name_regex or arn.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Array of strings describing the platforms on which the application can run.
        /// Values will be from: WINDOWS | WINDOWS_SERVER_2016 | WINDOWS_SERVER_2019 | WINDOWS_SERVER_2022 | AMAZON_LINUX2
        /// </summary>
        public readonly ImmutableArray<string> Platforms;
        /// <summary>
        /// Working directory for the application.
        /// </summary>
        public readonly string WorkingDirectory;

        [OutputConstructor]
        private GetImageApplicationResult(
            string appBlockArn,

            string arn,

            string createdTime,

            string description,

            string displayName,

            bool enabled,

            ImmutableArray<Outputs.GetImageApplicationIconS3LocationResult> iconS3Locations,

            string iconUrl,

            ImmutableArray<string> instanceFamilies,

            string launchParameters,

            string launchPath,

            ImmutableDictionary<string, string> metadata,

            string name,

            ImmutableArray<string> platforms,

            string workingDirectory)
        {
            AppBlockArn = appBlockArn;
            Arn = arn;
            CreatedTime = createdTime;
            Description = description;
            DisplayName = displayName;
            Enabled = enabled;
            IconS3Locations = iconS3Locations;
            IconUrl = iconUrl;
            InstanceFamilies = instanceFamilies;
            LaunchParameters = launchParameters;
            LaunchPath = launchPath;
            Metadata = metadata;
            Name = name;
            Platforms = platforms;
            WorkingDirectory = workingDirectory;
        }
    }
}
