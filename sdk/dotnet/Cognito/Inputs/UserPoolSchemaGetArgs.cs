// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cognito.Inputs
{

    public sealed class UserPoolSchemaGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Attribute data type. Must be one of `Boolean`, `Number`, `String`, `DateTime`.
        /// </summary>
        [Input("attributeDataType", required: true)]
        public Input<string> AttributeDataType { get; set; } = null!;

        /// <summary>
        /// Whether the attribute type is developer only.
        /// </summary>
        [Input("developerOnlyAttribute")]
        public Input<bool>? DeveloperOnlyAttribute { get; set; }

        /// <summary>
        /// Whether the attribute can be changed once it has been created.
        /// </summary>
        [Input("mutable")]
        public Input<bool>? Mutable { get; set; }

        /// <summary>
        /// Name of the attribute.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// Configuration block for the constraints for an attribute of the number type. Detailed below.
        /// </summary>
        [Input("numberAttributeConstraints")]
        public Input<Inputs.UserPoolSchemaNumberAttributeConstraintsGetArgs>? NumberAttributeConstraints { get; set; }

        /// <summary>
        /// Whether a user pool attribute is required. If the attribute is required and the user does not provide a value, registration or sign-in will fail.
        /// </summary>
        [Input("required")]
        public Input<bool>? Required { get; set; }

        /// <summary>
        /// Constraints for an attribute of the string type. Detailed below.
        /// </summary>
        [Input("stringAttributeConstraints")]
        public Input<Inputs.UserPoolSchemaStringAttributeConstraintsGetArgs>? StringAttributeConstraints { get; set; }

        public UserPoolSchemaGetArgs()
        {
        }
        public static new UserPoolSchemaGetArgs Empty => new UserPoolSchemaGetArgs();
    }
}
