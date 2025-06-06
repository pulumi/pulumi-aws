// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kendra.Inputs
{

    public sealed class ExperienceConfigurationUserIdentityConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The AWS SSO field name that contains the identifiers of your users, such as their emails.
        /// </summary>
        [Input("identityAttributeName", required: true)]
        public Input<string> IdentityAttributeName { get; set; } = null!;

        public ExperienceConfigurationUserIdentityConfigurationArgs()
        {
        }
        public static new ExperienceConfigurationUserIdentityConfigurationArgs Empty => new ExperienceConfigurationUserIdentityConfigurationArgs();
    }
}
