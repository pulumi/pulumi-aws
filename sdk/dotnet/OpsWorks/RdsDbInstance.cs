// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpsWorks
{
    /// <summary>
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
    ///     var myInstance = new Aws.OpsWorks.RdsDbInstance("my_instance", new()
    ///     {
    ///         StackId = myStack.Id,
    ///         RdsDbInstanceArn = myInstanceAwsDbInstance.Arn,
    ///         DbUser = "someUser",
    ///         DbPassword = "somePass",
    ///     });
    /// 
    /// });
    /// ```
    /// </summary>
    [AwsResourceType("aws:opsworks/rdsDbInstance:RdsDbInstance")]
    public partial class RdsDbInstance : global::Pulumi.CustomResource
    {
        /// <summary>
        /// A db password
        /// </summary>
        [Output("dbPassword")]
        public Output<string> DbPassword { get; private set; } = null!;

        /// <summary>
        /// A db username
        /// </summary>
        [Output("dbUser")]
        public Output<string> DbUser { get; private set; } = null!;

        /// <summary>
        /// The db instance to register for this stack. Changing this will force a new resource.
        /// </summary>
        [Output("rdsDbInstanceArn")]
        public Output<string> RdsDbInstanceArn { get; private set; } = null!;

        /// <summary>
        /// The stack to register a db instance for. Changing this will force a new resource.
        /// </summary>
        [Output("stackId")]
        public Output<string> StackId { get; private set; } = null!;


        /// <summary>
        /// Create a RdsDbInstance resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public RdsDbInstance(string name, RdsDbInstanceArgs args, CustomResourceOptions? options = null)
            : base("aws:opsworks/rdsDbInstance:RdsDbInstance", name, args ?? new RdsDbInstanceArgs(), MakeResourceOptions(options, ""))
        {
        }

        private RdsDbInstance(string name, Input<string> id, RdsDbInstanceState? state = null, CustomResourceOptions? options = null)
            : base("aws:opsworks/rdsDbInstance:RdsDbInstance", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "dbPassword",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing RdsDbInstance resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static RdsDbInstance Get(string name, Input<string> id, RdsDbInstanceState? state = null, CustomResourceOptions? options = null)
        {
            return new RdsDbInstance(name, id, state, options);
        }
    }

    public sealed class RdsDbInstanceArgs : global::Pulumi.ResourceArgs
    {
        [Input("dbPassword", required: true)]
        private Input<string>? _dbPassword;

        /// <summary>
        /// A db password
        /// </summary>
        public Input<string>? DbPassword
        {
            get => _dbPassword;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _dbPassword = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// A db username
        /// </summary>
        [Input("dbUser", required: true)]
        public Input<string> DbUser { get; set; } = null!;

        /// <summary>
        /// The db instance to register for this stack. Changing this will force a new resource.
        /// </summary>
        [Input("rdsDbInstanceArn", required: true)]
        public Input<string> RdsDbInstanceArn { get; set; } = null!;

        /// <summary>
        /// The stack to register a db instance for. Changing this will force a new resource.
        /// </summary>
        [Input("stackId", required: true)]
        public Input<string> StackId { get; set; } = null!;

        public RdsDbInstanceArgs()
        {
        }
        public static new RdsDbInstanceArgs Empty => new RdsDbInstanceArgs();
    }

    public sealed class RdsDbInstanceState : global::Pulumi.ResourceArgs
    {
        [Input("dbPassword")]
        private Input<string>? _dbPassword;

        /// <summary>
        /// A db password
        /// </summary>
        public Input<string>? DbPassword
        {
            get => _dbPassword;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _dbPassword = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// A db username
        /// </summary>
        [Input("dbUser")]
        public Input<string>? DbUser { get; set; }

        /// <summary>
        /// The db instance to register for this stack. Changing this will force a new resource.
        /// </summary>
        [Input("rdsDbInstanceArn")]
        public Input<string>? RdsDbInstanceArn { get; set; }

        /// <summary>
        /// The stack to register a db instance for. Changing this will force a new resource.
        /// </summary>
        [Input("stackId")]
        public Input<string>? StackId { get; set; }

        public RdsDbInstanceState()
        {
        }
        public static new RdsDbInstanceState Empty => new RdsDbInstanceState();
    }
}
