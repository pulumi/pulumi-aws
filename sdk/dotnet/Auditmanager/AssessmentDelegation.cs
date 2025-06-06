// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Auditmanager
{
    /// <summary>
    /// Resource for managing an AWS Audit Manager Assessment Delegation.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.Auditmanager.AssessmentDelegation("example", new()
    ///     {
    ///         AssessmentId = exampleAwsAuditmanagerAssessment.Id,
    ///         RoleArn = exampleAwsIamRole.Arn,
    ///         RoleType = "RESOURCE_OWNER",
    ///         ControlSetId = "example",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import Audit Manager Assessment Delegation using the `id`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:auditmanager/assessmentDelegation:AssessmentDelegation example abcdef-123456,arn:aws:iam::123456789012:role/example,example
    /// ```
    /// </summary>
    [AwsResourceType("aws:auditmanager/assessmentDelegation:AssessmentDelegation")]
    public partial class AssessmentDelegation : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Identifier for the assessment.
        /// </summary>
        [Output("assessmentId")]
        public Output<string> AssessmentId { get; private set; } = null!;

        /// <summary>
        /// Comment describing the delegation request.
        /// </summary>
        [Output("comment")]
        public Output<string?> Comment { get; private set; } = null!;

        /// <summary>
        /// Assessment control set name. This value is the control set name used during assessment creation (not the AWS-generated ID). The `_id` suffix on this attribute has been preserved to be consistent with the underlying AWS API.
        /// </summary>
        [Output("controlSetId")]
        public Output<string> ControlSetId { get; private set; } = null!;

        /// <summary>
        /// Unique identifier for the delegation.
        /// </summary>
        [Output("delegationId")]
        public Output<string> DelegationId { get; private set; } = null!;

        /// <summary>
        /// Amazon Resource Name (ARN) of the IAM role.
        /// </summary>
        [Output("roleArn")]
        public Output<string> RoleArn { get; private set; } = null!;

        /// <summary>
        /// Type of customer persona. For assessment delegation, type must always be `RESOURCE_OWNER`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("roleType")]
        public Output<string> RoleType { get; private set; } = null!;

        /// <summary>
        /// Status of the delegation.
        /// </summary>
        [Output("status")]
        public Output<string> Status { get; private set; } = null!;


        /// <summary>
        /// Create a AssessmentDelegation resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public AssessmentDelegation(string name, AssessmentDelegationArgs args, CustomResourceOptions? options = null)
            : base("aws:auditmanager/assessmentDelegation:AssessmentDelegation", name, args ?? new AssessmentDelegationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private AssessmentDelegation(string name, Input<string> id, AssessmentDelegationState? state = null, CustomResourceOptions? options = null)
            : base("aws:auditmanager/assessmentDelegation:AssessmentDelegation", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing AssessmentDelegation resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static AssessmentDelegation Get(string name, Input<string> id, AssessmentDelegationState? state = null, CustomResourceOptions? options = null)
        {
            return new AssessmentDelegation(name, id, state, options);
        }
    }

    public sealed class AssessmentDelegationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier for the assessment.
        /// </summary>
        [Input("assessmentId", required: true)]
        public Input<string> AssessmentId { get; set; } = null!;

        /// <summary>
        /// Comment describing the delegation request.
        /// </summary>
        [Input("comment")]
        public Input<string>? Comment { get; set; }

        /// <summary>
        /// Assessment control set name. This value is the control set name used during assessment creation (not the AWS-generated ID). The `_id` suffix on this attribute has been preserved to be consistent with the underlying AWS API.
        /// </summary>
        [Input("controlSetId", required: true)]
        public Input<string> ControlSetId { get; set; } = null!;

        /// <summary>
        /// Amazon Resource Name (ARN) of the IAM role.
        /// </summary>
        [Input("roleArn", required: true)]
        public Input<string> RoleArn { get; set; } = null!;

        /// <summary>
        /// Type of customer persona. For assessment delegation, type must always be `RESOURCE_OWNER`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("roleType", required: true)]
        public Input<string> RoleType { get; set; } = null!;

        public AssessmentDelegationArgs()
        {
        }
        public static new AssessmentDelegationArgs Empty => new AssessmentDelegationArgs();
    }

    public sealed class AssessmentDelegationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Identifier for the assessment.
        /// </summary>
        [Input("assessmentId")]
        public Input<string>? AssessmentId { get; set; }

        /// <summary>
        /// Comment describing the delegation request.
        /// </summary>
        [Input("comment")]
        public Input<string>? Comment { get; set; }

        /// <summary>
        /// Assessment control set name. This value is the control set name used during assessment creation (not the AWS-generated ID). The `_id` suffix on this attribute has been preserved to be consistent with the underlying AWS API.
        /// </summary>
        [Input("controlSetId")]
        public Input<string>? ControlSetId { get; set; }

        /// <summary>
        /// Unique identifier for the delegation.
        /// </summary>
        [Input("delegationId")]
        public Input<string>? DelegationId { get; set; }

        /// <summary>
        /// Amazon Resource Name (ARN) of the IAM role.
        /// </summary>
        [Input("roleArn")]
        public Input<string>? RoleArn { get; set; }

        /// <summary>
        /// Type of customer persona. For assessment delegation, type must always be `RESOURCE_OWNER`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("roleType")]
        public Input<string>? RoleType { get; set; }

        /// <summary>
        /// Status of the delegation.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        public AssessmentDelegationState()
        {
        }
        public static new AssessmentDelegationState Empty => new AssessmentDelegationState();
    }
}
