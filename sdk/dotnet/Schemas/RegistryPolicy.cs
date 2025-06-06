// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Schemas
{
    /// <summary>
    /// Resource for managing an AWS EventBridge Schemas Registry Policy.
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
    ///     var example = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Sid = "example",
    ///                 Effect = "Allow",
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "AWS",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "109876543210",
    ///                         },
    ///                     },
    ///                 },
    ///                 Actions = new[]
    ///                 {
    ///                     "schemas:*",
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     "arn:aws:schemas:us-east-1:123456789012:registry/example",
    ///                     "arn:aws:schemas:us-east-1:123456789012:schema/example*",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var exampleRegistryPolicy = new Aws.Schemas.RegistryPolicy("example", new()
    ///     {
    ///         RegistryName = "example",
    ///         Policy = example.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import EventBridge Schema Registry Policy using the `registry_name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:schemas/registryPolicy:RegistryPolicy example example
    /// ```
    /// </summary>
    [AwsResourceType("aws:schemas/registryPolicy:RegistryPolicy")]
    public partial class RegistryPolicy : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Resource Policy for EventBridge Schema Registry
        /// </summary>
        [Output("policy")]
        public Output<string> Policy { get; private set; } = null!;

        /// <summary>
        /// Name of EventBridge Schema Registry
        /// </summary>
        [Output("registryName")]
        public Output<string> RegistryName { get; private set; } = null!;


        /// <summary>
        /// Create a RegistryPolicy resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public RegistryPolicy(string name, RegistryPolicyArgs args, CustomResourceOptions? options = null)
            : base("aws:schemas/registryPolicy:RegistryPolicy", name, args ?? new RegistryPolicyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private RegistryPolicy(string name, Input<string> id, RegistryPolicyState? state = null, CustomResourceOptions? options = null)
            : base("aws:schemas/registryPolicy:RegistryPolicy", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing RegistryPolicy resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static RegistryPolicy Get(string name, Input<string> id, RegistryPolicyState? state = null, CustomResourceOptions? options = null)
        {
            return new RegistryPolicy(name, id, state, options);
        }
    }

    public sealed class RegistryPolicyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Resource Policy for EventBridge Schema Registry
        /// </summary>
        [Input("policy", required: true)]
        public Input<string> Policy { get; set; } = null!;

        /// <summary>
        /// Name of EventBridge Schema Registry
        /// </summary>
        [Input("registryName", required: true)]
        public Input<string> RegistryName { get; set; } = null!;

        public RegistryPolicyArgs()
        {
        }
        public static new RegistryPolicyArgs Empty => new RegistryPolicyArgs();
    }

    public sealed class RegistryPolicyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Resource Policy for EventBridge Schema Registry
        /// </summary>
        [Input("policy")]
        public Input<string>? Policy { get; set; }

        /// <summary>
        /// Name of EventBridge Schema Registry
        /// </summary>
        [Input("registryName")]
        public Input<string>? RegistryName { get; set; }

        public RegistryPolicyState()
        {
        }
        public static new RegistryPolicyState Empty => new RegistryPolicyState();
    }
}
