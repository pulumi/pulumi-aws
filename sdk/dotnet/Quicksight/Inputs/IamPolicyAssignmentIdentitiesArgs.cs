// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class IamPolicyAssignmentIdentitiesArgs : global::Pulumi.ResourceArgs
    {
        [Input("groups")]
        private InputList<string>? _groups;

        /// <summary>
        /// Array of Quicksight group names to assign the policy to.
        /// </summary>
        public InputList<string> Groups
        {
            get => _groups ?? (_groups = new InputList<string>());
            set => _groups = value;
        }

        [Input("users")]
        private InputList<string>? _users;

        /// <summary>
        /// Array of Quicksight user names to assign the policy to.
        /// </summary>
        public InputList<string> Users
        {
            get => _users ?? (_users = new InputList<string>());
            set => _users = value;
        }

        public IamPolicyAssignmentIdentitiesArgs()
        {
        }
        public static new IamPolicyAssignmentIdentitiesArgs Empty => new IamPolicyAssignmentIdentitiesArgs();
    }
}
