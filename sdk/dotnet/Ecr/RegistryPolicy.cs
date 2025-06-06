// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecr
{
    /// <summary>
    /// Provides an Elastic Container Registry Policy.
    /// 
    /// &gt; **NOTE on ECR Registry Policies:** While the AWS Management Console interface may suggest the ability to define multiple policies by creating multiple statements, ECR registry policies are effectively managed as singular entities at the regional level by the AWS APIs. Therefore, the `aws.ecr.RegistryPolicy` resource should be configured only once per region with all necessary statements defined in the same policy. Attempting to define multiple `aws.ecr.RegistryPolicy` resources may result in perpetual differences, with one policy overriding another.
    /// 
    /// ## Example Usage
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using System.Text.Json;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var current = Aws.GetCallerIdentity.Invoke();
    /// 
    ///     var currentGetRegion = Aws.GetRegion.Invoke();
    /// 
    ///     var currentGetPartition = Aws.GetPartition.Invoke();
    /// 
    ///     var example = new Aws.Ecr.RegistryPolicy("example", new()
    ///     {
    ///         Policy = JsonSerializer.Serialize(new Dictionary&lt;string, object?&gt;
    ///         {
    ///             ["Version"] = "2012-10-17",
    ///             ["Statement"] = new[]
    ///             {
    ///                 new Dictionary&lt;string, object?&gt;
    ///                 {
    ///                     ["Sid"] = "testpolicy",
    ///                     ["Effect"] = "Allow",
    ///                     ["Principal"] = new Dictionary&lt;string, object?&gt;
    ///                     {
    ///                         ["AWS"] = Output.Tuple(currentGetPartition, current).Apply(values =&gt;
    ///                         {
    ///                             var currentGetPartition = values.Item1;
    ///                             var current = values.Item2;
    ///                             return $"arn:{currentGetPartition.Apply(getPartitionResult =&gt; getPartitionResult.Partition)}:iam::{current.Apply(getCallerIdentityResult =&gt; getCallerIdentityResult.AccountId)}:root";
    ///                         }),
    ///                     },
    ///                     ["Action"] = new[]
    ///                     {
    ///                         "ecr:ReplicateImage",
    ///                     },
    ///                     ["Resource"] = new[]
    ///                     {
    ///                         Output.Tuple(currentGetPartition, currentGetRegion, current).Apply(values =&gt;
    ///                         {
    ///                             var currentGetPartition = values.Item1;
    ///                             var currentGetRegion = values.Item2;
    ///                             var current = values.Item3;
    ///                             return $"arn:{currentGetPartition.Apply(getPartitionResult =&gt; getPartitionResult.Partition)}:ecr:{currentGetRegion.Apply(getRegionResult =&gt; getRegionResult.Name)}:{current.Apply(getCallerIdentityResult =&gt; getCallerIdentityResult.AccountId)}:repository/*";
    ///                         }),
    ///                     },
    ///                 },
    ///             },
    ///         }),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import ECR Registry Policy using the registry id. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ecr/registryPolicy:RegistryPolicy example 123456789012
    /// ```
    /// </summary>
    [AwsResourceType("aws:ecr/registryPolicy:RegistryPolicy")]
    public partial class RegistryPolicy : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The policy document. This is a JSON formatted string.
        /// </summary>
        [Output("policy")]
        public Output<string> Policy { get; private set; } = null!;

        /// <summary>
        /// The registry ID where the registry was created.
        /// </summary>
        [Output("registryId")]
        public Output<string> RegistryId { get; private set; } = null!;


        /// <summary>
        /// Create a RegistryPolicy resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public RegistryPolicy(string name, RegistryPolicyArgs args, CustomResourceOptions? options = null)
            : base("aws:ecr/registryPolicy:RegistryPolicy", name, args ?? new RegistryPolicyArgs(), MakeResourceOptions(options, ""))
        {
        }

        private RegistryPolicy(string name, Input<string> id, RegistryPolicyState? state = null, CustomResourceOptions? options = null)
            : base("aws:ecr/registryPolicy:RegistryPolicy", name, state, MakeResourceOptions(options, id))
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
        /// The policy document. This is a JSON formatted string.
        /// </summary>
        [Input("policy", required: true)]
        public Input<string> Policy { get; set; } = null!;

        public RegistryPolicyArgs()
        {
        }
        public static new RegistryPolicyArgs Empty => new RegistryPolicyArgs();
    }

    public sealed class RegistryPolicyState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The policy document. This is a JSON formatted string.
        /// </summary>
        [Input("policy")]
        public Input<string>? Policy { get; set; }

        /// <summary>
        /// The registry ID where the registry was created.
        /// </summary>
        [Input("registryId")]
        public Input<string>? RegistryId { get; set; }

        public RegistryPolicyState()
        {
        }
        public static new RegistryPolicyState Empty => new RegistryPolicyState();
    }
}
