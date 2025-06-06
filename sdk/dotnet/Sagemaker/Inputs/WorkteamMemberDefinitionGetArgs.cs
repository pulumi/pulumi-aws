// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class WorkteamMemberDefinitionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Cognito user group that is part of the work team. See Cognito Member Definition details below.
        /// </summary>
        [Input("cognitoMemberDefinition")]
        public Input<Inputs.WorkteamMemberDefinitionCognitoMemberDefinitionGetArgs>? CognitoMemberDefinition { get; set; }

        /// <summary>
        /// A list user groups that exist in your OIDC Identity Provider (IdP). One to ten groups can be used to create a single private work team. See Cognito Member Definition details below.
        /// </summary>
        [Input("oidcMemberDefinition")]
        public Input<Inputs.WorkteamMemberDefinitionOidcMemberDefinitionGetArgs>? OidcMemberDefinition { get; set; }

        public WorkteamMemberDefinitionGetArgs()
        {
        }
        public static new WorkteamMemberDefinitionGetArgs Empty => new WorkteamMemberDefinitionGetArgs();
    }
}
