// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ssm
{
    /// <summary>
    /// Provides an SSM Parameter resource.
    /// 
    /// &gt; **Note:** The `overwrite` argument makes it possible to overwrite an existing SSM Parameter created outside of IAC.
    /// 
    /// ## Example Usage
    /// 
    /// ### Basic example
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var foo = new Aws.Ssm.Parameter("foo", new()
    ///     {
    ///         Name = "foo",
    ///         Type = Aws.Ssm.ParameterType.String,
    ///         Value = "bar",
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Encrypted string using default SSM KMS key
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var @default = new Aws.Rds.Instance("default", new()
    ///     {
    ///         AllocatedStorage = 10,
    ///         StorageType = Aws.Rds.StorageType.GP2,
    ///         Engine = "mysql",
    ///         EngineVersion = "5.7.16",
    ///         InstanceClass = Aws.Rds.InstanceType.T2_Micro,
    ///         DbName = "mydb",
    ///         Username = "foo",
    ///         Password = databaseMasterPassword,
    ///         DbSubnetGroupName = "my_database_subnet_group",
    ///         ParameterGroupName = "default.mysql5.7",
    ///     });
    /// 
    ///     var secret = new Aws.Ssm.Parameter("secret", new()
    ///     {
    ///         Name = "/production/database/password/master",
    ///         Description = "The parameter description",
    ///         Type = Aws.Ssm.ParameterType.SecureString,
    ///         Value = databaseMasterPassword,
    ///         Tags = 
    ///         {
    ///             { "environment", "production" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import SSM Parameters using the parameter store `name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:ssm/parameter:Parameter my_param /my_path/my_paramname
    /// ```
    /// </summary>
    [AwsResourceType("aws:ssm/parameter:Parameter")]
    public partial class Parameter : global::Pulumi.CustomResource
    {
        /// <summary>
        /// Regular expression used to validate the parameter value.
        /// </summary>
        [Output("allowedPattern")]
        public Output<string?> AllowedPattern { get; private set; } = null!;

        /// <summary>
        /// ARN of the parameter.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Data type of the parameter. Valid values: `text`, `aws:ssm:integration` and `aws:ec2:image` for AMI format, see the [Native parameter support for Amazon Machine Image IDs](https://docs.aws.amazon.com/systems-manager/latest/userguide/parameter-store-ec2-aliases.html).
        /// </summary>
        [Output("dataType")]
        public Output<string> DataType { get; private set; } = null!;

        /// <summary>
        /// Description of the parameter.
        /// </summary>
        [Output("description")]
        public Output<string?> Description { get; private set; } = null!;

        /// <summary>
        /// Value of the parameter. **Use caution:** This value is _never_ marked as sensitive in the pulumi preview output. This argument is not valid with a `type` of `SecureString`.
        /// </summary>
        [Output("insecureValue")]
        public Output<string> InsecureValue { get; private set; } = null!;

        /// <summary>
        /// KMS key ID or ARN for encrypting a SecureString.
        /// </summary>
        [Output("keyId")]
        public Output<string> KeyId { get; private set; } = null!;

        /// <summary>
        /// Name of the parameter. If the name contains a path (e.g., any forward slashes (`/`)), it must be fully qualified with a leading forward slash (`/`). For additional requirements and constraints, see the [AWS SSM User Guide](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-parameter-name-constraints.html).
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Overwrite an existing parameter. If not specified, defaults to `false` during create operations to avoid overwriting existing resources and then `true` for all subsequent operations once the resource is managed by IAC. Lifecycle rules should be used to manage non-standard update behavior.
        /// </summary>
        [Output("overwrite")]
        public Output<bool?> Overwrite { get; private set; } = null!;

        /// <summary>
        /// Map of tags to assign to the object. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;

        /// <summary>
        /// Parameter tier to assign to the parameter. If not specified, will use the default parameter tier for the region. Valid tiers are `Standard`, `Advanced`, and `Intelligent-Tiering`. Downgrading an `Advanced` tier parameter to `Standard` will recreate the resource. For more information on parameter tiers, see the [AWS SSM Parameter tier comparison and guide](https://docs.aws.amazon.com/systems-manager/latest/userguide/parameter-store-advanced-parameters.html).
        /// </summary>
        [Output("tier")]
        public Output<string?> Tier { get; private set; } = null!;

        /// <summary>
        /// Type of the parameter. Valid types are `String`, `StringList` and `SecureString`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("type")]
        public Output<string> Type { get; private set; } = null!;

        /// <summary>
        /// Value of the parameter. This value is always marked as sensitive in the pulumi preview output, regardless of `type
        /// </summary>
        [Output("value")]
        public Output<string> Value { get; private set; } = null!;

        /// <summary>
        /// Version of the parameter.
        /// </summary>
        [Output("version")]
        public Output<int> Version { get; private set; } = null!;


        /// <summary>
        /// Create a Parameter resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Parameter(string name, ParameterArgs args, CustomResourceOptions? options = null)
            : base("aws:ssm/parameter:Parameter", name, args ?? new ParameterArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Parameter(string name, Input<string> id, ParameterState? state = null, CustomResourceOptions? options = null)
            : base("aws:ssm/parameter:Parameter", name, state, MakeResourceOptions(options, id))
        {
        }

        private static CustomResourceOptions MakeResourceOptions(CustomResourceOptions? options, Input<string>? id)
        {
            var defaultOptions = new CustomResourceOptions
            {
                Version = Utilities.Version,
                AdditionalSecretOutputs =
                {
                    "value",
                },
            };
            var merged = CustomResourceOptions.Merge(defaultOptions, options);
            // Override the ID if one was specified for consistency with other language SDKs.
            merged.Id = id ?? merged.Id;
            return merged;
        }
        /// <summary>
        /// Get an existing Parameter resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Parameter Get(string name, Input<string> id, ParameterState? state = null, CustomResourceOptions? options = null)
        {
            return new Parameter(name, id, state, options);
        }
    }

    public sealed class ParameterArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Regular expression used to validate the parameter value.
        /// </summary>
        [Input("allowedPattern")]
        public Input<string>? AllowedPattern { get; set; }

        /// <summary>
        /// ARN of the parameter.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Data type of the parameter. Valid values: `text`, `aws:ssm:integration` and `aws:ec2:image` for AMI format, see the [Native parameter support for Amazon Machine Image IDs](https://docs.aws.amazon.com/systems-manager/latest/userguide/parameter-store-ec2-aliases.html).
        /// </summary>
        [Input("dataType")]
        public Input<string>? DataType { get; set; }

        /// <summary>
        /// Description of the parameter.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Value of the parameter. **Use caution:** This value is _never_ marked as sensitive in the pulumi preview output. This argument is not valid with a `type` of `SecureString`.
        /// </summary>
        [Input("insecureValue")]
        public Input<string>? InsecureValue { get; set; }

        /// <summary>
        /// KMS key ID or ARN for encrypting a SecureString.
        /// </summary>
        [Input("keyId")]
        public Input<string>? KeyId { get; set; }

        /// <summary>
        /// Name of the parameter. If the name contains a path (e.g., any forward slashes (`/`)), it must be fully qualified with a leading forward slash (`/`). For additional requirements and constraints, see the [AWS SSM User Guide](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-parameter-name-constraints.html).
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Overwrite an existing parameter. If not specified, defaults to `false` during create operations to avoid overwriting existing resources and then `true` for all subsequent operations once the resource is managed by IAC. Lifecycle rules should be used to manage non-standard update behavior.
        /// </summary>
        [Input("overwrite")]
        public Input<bool>? Overwrite { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to the object. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// Parameter tier to assign to the parameter. If not specified, will use the default parameter tier for the region. Valid tiers are `Standard`, `Advanced`, and `Intelligent-Tiering`. Downgrading an `Advanced` tier parameter to `Standard` will recreate the resource. For more information on parameter tiers, see the [AWS SSM Parameter tier comparison and guide](https://docs.aws.amazon.com/systems-manager/latest/userguide/parameter-store-advanced-parameters.html).
        /// </summary>
        [Input("tier")]
        public Input<string>? Tier { get; set; }

        /// <summary>
        /// Type of the parameter. Valid types are `String`, `StringList` and `SecureString`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("type", required: true)]
        public InputUnion<string, Pulumi.Aws.Ssm.ParameterType> Type { get; set; } = null!;

        [Input("value")]
        private Input<string>? _value;

        /// <summary>
        /// Value of the parameter. This value is always marked as sensitive in the pulumi preview output, regardless of `type
        /// </summary>
        public Input<string>? Value
        {
            get => _value;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _value = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        public ParameterArgs()
        {
        }
        public static new ParameterArgs Empty => new ParameterArgs();
    }

    public sealed class ParameterState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Regular expression used to validate the parameter value.
        /// </summary>
        [Input("allowedPattern")]
        public Input<string>? AllowedPattern { get; set; }

        /// <summary>
        /// ARN of the parameter.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Data type of the parameter. Valid values: `text`, `aws:ssm:integration` and `aws:ec2:image` for AMI format, see the [Native parameter support for Amazon Machine Image IDs](https://docs.aws.amazon.com/systems-manager/latest/userguide/parameter-store-ec2-aliases.html).
        /// </summary>
        [Input("dataType")]
        public Input<string>? DataType { get; set; }

        /// <summary>
        /// Description of the parameter.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Value of the parameter. **Use caution:** This value is _never_ marked as sensitive in the pulumi preview output. This argument is not valid with a `type` of `SecureString`.
        /// </summary>
        [Input("insecureValue")]
        public Input<string>? InsecureValue { get; set; }

        /// <summary>
        /// KMS key ID or ARN for encrypting a SecureString.
        /// </summary>
        [Input("keyId")]
        public Input<string>? KeyId { get; set; }

        /// <summary>
        /// Name of the parameter. If the name contains a path (e.g., any forward slashes (`/`)), it must be fully qualified with a leading forward slash (`/`). For additional requirements and constraints, see the [AWS SSM User Guide](https://docs.aws.amazon.com/systems-manager/latest/userguide/sysman-parameter-name-constraints.html).
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Overwrite an existing parameter. If not specified, defaults to `false` during create operations to avoid overwriting existing resources and then `true` for all subsequent operations once the resource is managed by IAC. Lifecycle rules should be used to manage non-standard update behavior.
        /// </summary>
        [Input("overwrite")]
        public Input<bool>? Overwrite { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to the object. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        /// <summary>
        /// Parameter tier to assign to the parameter. If not specified, will use the default parameter tier for the region. Valid tiers are `Standard`, `Advanced`, and `Intelligent-Tiering`. Downgrading an `Advanced` tier parameter to `Standard` will recreate the resource. For more information on parameter tiers, see the [AWS SSM Parameter tier comparison and guide](https://docs.aws.amazon.com/systems-manager/latest/userguide/parameter-store-advanced-parameters.html).
        /// </summary>
        [Input("tier")]
        public Input<string>? Tier { get; set; }

        /// <summary>
        /// Type of the parameter. Valid types are `String`, `StringList` and `SecureString`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("type")]
        public InputUnion<string, Pulumi.Aws.Ssm.ParameterType>? Type { get; set; }

        [Input("value")]
        private Input<string>? _value;

        /// <summary>
        /// Value of the parameter. This value is always marked as sensitive in the pulumi preview output, regardless of `type
        /// </summary>
        public Input<string>? Value
        {
            get => _value;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _value = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        /// <summary>
        /// Version of the parameter.
        /// </summary>
        [Input("version")]
        public Input<int>? Version { get; set; }

        public ParameterState()
        {
        }
        public static new ParameterState Empty => new ParameterState();
    }
}
