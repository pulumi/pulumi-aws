// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cognito
{
    /// <summary>
    /// Adds the specified user to the specified group.
    /// 
    /// ## Example Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Cognito.UserPool("example", new()
    ///     {
    ///         Name = "example",
    ///         PasswordPolicy = new Aws.Cognito.Inputs.UserPoolPasswordPolicyArgs
    ///         {
    ///             TemporaryPasswordValidityDays = 7,
    ///             MinimumLength = 6,
    ///             RequireUppercase = false,
    ///             RequireSymbols = false,
    ///             RequireNumbers = false,
    ///         },
    ///     });
    /// 
    ///     var exampleUser = new Aws.Cognito.User("example", new()
    ///     {
    ///         UserPoolId = example.Id,
    ///         Username = "example",
    ///     });
    /// 
    ///     var exampleUserGroup = new Aws.Cognito.UserGroup("example", new()
    ///     {
    ///         UserPoolId = example.Id,
    ///         Name = "example",
    ///     });
    /// 
    ///     var exampleUserInGroup = new Aws.Cognito.UserInGroup("example", new()
    ///     {
    ///         UserPoolId = example.Id,
    ///         GroupName = exampleUserGroup.Name,
    ///         Username = exampleUser.Username,
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [AwsResourceType("aws:cognito/userInGroup:UserInGroup")]
    public partial class UserInGroup : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The name of the group to which the user is to be added.
        /// </summary>
        [Output("groupName")]
        public Output<string> GroupName { get; private set; } = null!;

        /// <summary>
        /// The user pool ID of the user and group.
        /// </summary>
        [Output("userPoolId")]
        public Output<string> UserPoolId { get; private set; } = null!;

        /// <summary>
        /// The username of the user to be added to the group.
        /// </summary>
        [Output("username")]
        public Output<string> Username { get; private set; } = null!;


        /// <summary>
        /// Create a UserInGroup resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public UserInGroup(string name, UserInGroupArgs args, CustomResourceOptions? options = null)
            : base("aws:cognito/userInGroup:UserInGroup", name, args ?? new UserInGroupArgs(), MakeResourceOptions(options, ""))
        {
        }

        private UserInGroup(string name, Input<string> id, UserInGroupState? state = null, CustomResourceOptions? options = null)
            : base("aws:cognito/userInGroup:UserInGroup", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing UserInGroup resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static UserInGroup Get(string name, Input<string> id, UserInGroupState? state = null, CustomResourceOptions? options = null)
        {
            return new UserInGroup(name, id, state, options);
        }
    }

    public sealed class UserInGroupArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the group to which the user is to be added.
        /// </summary>
        [Input("groupName", required: true)]
        public Input<string> GroupName { get; set; } = null!;

        /// <summary>
        /// The user pool ID of the user and group.
        /// </summary>
        [Input("userPoolId", required: true)]
        public Input<string> UserPoolId { get; set; } = null!;

        /// <summary>
        /// The username of the user to be added to the group.
        /// </summary>
        [Input("username", required: true)]
        public Input<string> Username { get; set; } = null!;

        public UserInGroupArgs()
        {
        }
        public static new UserInGroupArgs Empty => new UserInGroupArgs();
    }

    public sealed class UserInGroupState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the group to which the user is to be added.
        /// </summary>
        [Input("groupName")]
        public Input<string>? GroupName { get; set; }

        /// <summary>
        /// The user pool ID of the user and group.
        /// </summary>
        [Input("userPoolId")]
        public Input<string>? UserPoolId { get; set; }

        /// <summary>
        /// The username of the user to be added to the group.
        /// </summary>
        [Input("username")]
        public Input<string>? Username { get; set; }

        public UserInGroupState()
        {
        }
        public static new UserInGroupState Empty => new UserInGroupState();
    }
}
