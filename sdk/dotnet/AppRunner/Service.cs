// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppRunner
{
    /// <summary>
    /// Manages an App Runner Service.
    /// 
    /// ## Example Usage
    /// 
    /// ### Service with a Code Repository Source
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.AppRunner.Service("example", new()
    ///     {
    ///         ServiceName = "example",
    ///         SourceConfiguration = new Aws.AppRunner.Inputs.ServiceSourceConfigurationArgs
    ///         {
    ///             AuthenticationConfiguration = new Aws.AppRunner.Inputs.ServiceSourceConfigurationAuthenticationConfigurationArgs
    ///             {
    ///                 ConnectionArn = exampleAwsApprunnerConnection.Arn,
    ///             },
    ///             CodeRepository = new Aws.AppRunner.Inputs.ServiceSourceConfigurationCodeRepositoryArgs
    ///             {
    ///                 CodeConfiguration = new Aws.AppRunner.Inputs.ServiceSourceConfigurationCodeRepositoryCodeConfigurationArgs
    ///                 {
    ///                     CodeConfigurationValues = new Aws.AppRunner.Inputs.ServiceSourceConfigurationCodeRepositoryCodeConfigurationCodeConfigurationValuesArgs
    ///                     {
    ///                         BuildCommand = "python setup.py develop",
    ///                         Port = "8000",
    ///                         Runtime = "PYTHON_3",
    ///                         StartCommand = "python runapp.py",
    ///                     },
    ///                     ConfigurationSource = "API",
    ///                 },
    ///                 RepositoryUrl = "https://github.com/example/my-example-python-app",
    ///                 SourceCodeVersion = new Aws.AppRunner.Inputs.ServiceSourceConfigurationCodeRepositorySourceCodeVersionArgs
    ///                 {
    ///                     Type = "BRANCH",
    ///                     Value = "main",
    ///                 },
    ///             },
    ///         },
    ///         NetworkConfiguration = new Aws.AppRunner.Inputs.ServiceNetworkConfigurationArgs
    ///         {
    ///             EgressConfiguration = new Aws.AppRunner.Inputs.ServiceNetworkConfigurationEgressConfigurationArgs
    ///             {
    ///                 EgressType = "VPC",
    ///                 VpcConnectorArn = connector.Arn,
    ///             },
    ///         },
    ///         Tags = 
    ///         {
    ///             { "Name", "example-apprunner-service" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Service with an Image Repository Source
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var example = new Aws.AppRunner.Service("example", new()
    ///     {
    ///         ServiceName = "example",
    ///         SourceConfiguration = new Aws.AppRunner.Inputs.ServiceSourceConfigurationArgs
    ///         {
    ///             ImageRepository = new Aws.AppRunner.Inputs.ServiceSourceConfigurationImageRepositoryArgs
    ///             {
    ///                 ImageConfiguration = new Aws.AppRunner.Inputs.ServiceSourceConfigurationImageRepositoryImageConfigurationArgs
    ///                 {
    ///                     Port = "8000",
    ///                 },
    ///                 ImageIdentifier = "public.ecr.aws/aws-containers/hello-app-runner:latest",
    ///                 ImageRepositoryType = "ECR_PUBLIC",
    ///             },
    ///             AutoDeploymentsEnabled = false,
    ///         },
    ///         Tags = 
    ///         {
    ///             { "Name", "example-apprunner-service" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Service with Observability Configuration
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var exampleObservabilityConfiguration = new Aws.AppRunner.ObservabilityConfiguration("example", new()
    ///     {
    ///         ObservabilityConfigurationName = "example",
    ///         TraceConfiguration = new Aws.AppRunner.Inputs.ObservabilityConfigurationTraceConfigurationArgs
    ///         {
    ///             Vendor = "AWSXRAY",
    ///         },
    ///     });
    /// 
    ///     var example = new Aws.AppRunner.Service("example", new()
    ///     {
    ///         ServiceName = "example",
    ///         ObservabilityConfiguration = new Aws.AppRunner.Inputs.ServiceObservabilityConfigurationArgs
    ///         {
    ///             ObservabilityConfigurationArn = exampleObservabilityConfiguration.Arn,
    ///             ObservabilityEnabled = true,
    ///         },
    ///         SourceConfiguration = new Aws.AppRunner.Inputs.ServiceSourceConfigurationArgs
    ///         {
    ///             ImageRepository = new Aws.AppRunner.Inputs.ServiceSourceConfigurationImageRepositoryArgs
    ///             {
    ///                 ImageConfiguration = new Aws.AppRunner.Inputs.ServiceSourceConfigurationImageRepositoryImageConfigurationArgs
    ///                 {
    ///                     Port = "8000",
    ///                 },
    ///                 ImageIdentifier = "public.ecr.aws/aws-containers/hello-app-runner:latest",
    ///                 ImageRepositoryType = "ECR_PUBLIC",
    ///             },
    ///             AutoDeploymentsEnabled = false,
    ///         },
    ///         Tags = 
    ///         {
    ///             { "Name", "example-apprunner-service" },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import App Runner Services using the `arn`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:apprunner/service:Service example arn:aws:apprunner:us-east-1:1234567890:service/example/0a03292a89764e5882c41d8f991c82fe
    /// ```
    /// </summary>
    [AwsResourceType("aws:apprunner/service:Service")]
    public partial class Service : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the App Runner service.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// ARN of an App Runner automatic scaling configuration resource that you want to associate with your service. If not provided, App Runner associates the latest revision of a default auto scaling configuration.
        /// </summary>
        [Output("autoScalingConfigurationArn")]
        public Output<string> AutoScalingConfigurationArn { get; private set; } = null!;

        /// <summary>
        /// An optional custom encryption key that App Runner uses to encrypt the copy of your source repository that it maintains and your service logs. By default, App Runner uses an AWS managed CMK. See Encryption Configuration below for more details.
        /// </summary>
        [Output("encryptionConfiguration")]
        public Output<Outputs.ServiceEncryptionConfiguration?> EncryptionConfiguration { get; private set; } = null!;

        /// <summary>
        /// Settings of the health check that AWS App Runner performs to monitor the health of your service. See Health Check Configuration below for more details.
        /// </summary>
        [Output("healthCheckConfiguration")]
        public Output<Outputs.ServiceHealthCheckConfiguration> HealthCheckConfiguration { get; private set; } = null!;

        /// <summary>
        /// The runtime configuration of instances (scaling units) of the App Runner service. See Instance Configuration below for more details.
        /// </summary>
        [Output("instanceConfiguration")]
        public Output<Outputs.ServiceInstanceConfiguration> InstanceConfiguration { get; private set; } = null!;

        /// <summary>
        /// Configuration settings related to network traffic of the web application that the App Runner service runs. See Network Configuration below for more details.
        /// </summary>
        [Output("networkConfiguration")]
        public Output<Outputs.ServiceNetworkConfiguration> NetworkConfiguration { get; private set; } = null!;

        /// <summary>
        /// The observability configuration of your service. See Observability Configuration below for more details.
        /// </summary>
        [Output("observabilityConfiguration")]
        public Output<Outputs.ServiceObservabilityConfiguration?> ObservabilityConfiguration { get; private set; } = null!;

        /// <summary>
        /// An alphanumeric ID that App Runner generated for this service. Unique within the AWS Region.
        /// </summary>
        [Output("serviceId")]
        public Output<string> ServiceId { get; private set; } = null!;

        /// <summary>
        /// Name of the service.
        /// </summary>
        [Output("serviceName")]
        public Output<string> ServiceName { get; private set; } = null!;

        /// <summary>
        /// Subdomain URL that App Runner generated for this service. You can use this URL to access your service web application.
        /// </summary>
        [Output("serviceUrl")]
        public Output<string> ServiceUrl { get; private set; } = null!;

        /// <summary>
        /// The source to deploy to the App Runner service. Can be a code or an image repository. See Source Configuration below for more details.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("sourceConfiguration")]
        public Output<Outputs.ServiceSourceConfiguration> SourceConfiguration { get; private set; } = null!;

        /// <summary>
        /// Current state of the App Runner service.
        /// </summary>
        [Output("status")]
        public Output<string> Status { get; private set; } = null!;

        /// <summary>
        /// Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a Service resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Service(string name, ServiceArgs args, CustomResourceOptions? options = null)
            : base("aws:apprunner/service:Service", name, args ?? new ServiceArgs(), MakeResourceOptions(options, ""))
        {
        }

        private Service(string name, Input<string> id, ServiceState? state = null, CustomResourceOptions? options = null)
            : base("aws:apprunner/service:Service", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing Service resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Service Get(string name, Input<string> id, ServiceState? state = null, CustomResourceOptions? options = null)
        {
            return new Service(name, id, state, options);
        }
    }

    public sealed class ServiceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of an App Runner automatic scaling configuration resource that you want to associate with your service. If not provided, App Runner associates the latest revision of a default auto scaling configuration.
        /// </summary>
        [Input("autoScalingConfigurationArn")]
        public Input<string>? AutoScalingConfigurationArn { get; set; }

        /// <summary>
        /// An optional custom encryption key that App Runner uses to encrypt the copy of your source repository that it maintains and your service logs. By default, App Runner uses an AWS managed CMK. See Encryption Configuration below for more details.
        /// </summary>
        [Input("encryptionConfiguration")]
        public Input<Inputs.ServiceEncryptionConfigurationArgs>? EncryptionConfiguration { get; set; }

        /// <summary>
        /// Settings of the health check that AWS App Runner performs to monitor the health of your service. See Health Check Configuration below for more details.
        /// </summary>
        [Input("healthCheckConfiguration")]
        public Input<Inputs.ServiceHealthCheckConfigurationArgs>? HealthCheckConfiguration { get; set; }

        /// <summary>
        /// The runtime configuration of instances (scaling units) of the App Runner service. See Instance Configuration below for more details.
        /// </summary>
        [Input("instanceConfiguration")]
        public Input<Inputs.ServiceInstanceConfigurationArgs>? InstanceConfiguration { get; set; }

        /// <summary>
        /// Configuration settings related to network traffic of the web application that the App Runner service runs. See Network Configuration below for more details.
        /// </summary>
        [Input("networkConfiguration")]
        public Input<Inputs.ServiceNetworkConfigurationArgs>? NetworkConfiguration { get; set; }

        /// <summary>
        /// The observability configuration of your service. See Observability Configuration below for more details.
        /// </summary>
        [Input("observabilityConfiguration")]
        public Input<Inputs.ServiceObservabilityConfigurationArgs>? ObservabilityConfiguration { get; set; }

        /// <summary>
        /// Name of the service.
        /// </summary>
        [Input("serviceName", required: true)]
        public Input<string> ServiceName { get; set; } = null!;

        /// <summary>
        /// The source to deploy to the App Runner service. Can be a code or an image repository. See Source Configuration below for more details.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("sourceConfiguration", required: true)]
        public Input<Inputs.ServiceSourceConfigurationArgs> SourceConfiguration { get; set; } = null!;

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public ServiceArgs()
        {
        }
        public static new ServiceArgs Empty => new ServiceArgs();
    }

    public sealed class ServiceState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the App Runner service.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// ARN of an App Runner automatic scaling configuration resource that you want to associate with your service. If not provided, App Runner associates the latest revision of a default auto scaling configuration.
        /// </summary>
        [Input("autoScalingConfigurationArn")]
        public Input<string>? AutoScalingConfigurationArn { get; set; }

        /// <summary>
        /// An optional custom encryption key that App Runner uses to encrypt the copy of your source repository that it maintains and your service logs. By default, App Runner uses an AWS managed CMK. See Encryption Configuration below for more details.
        /// </summary>
        [Input("encryptionConfiguration")]
        public Input<Inputs.ServiceEncryptionConfigurationGetArgs>? EncryptionConfiguration { get; set; }

        /// <summary>
        /// Settings of the health check that AWS App Runner performs to monitor the health of your service. See Health Check Configuration below for more details.
        /// </summary>
        [Input("healthCheckConfiguration")]
        public Input<Inputs.ServiceHealthCheckConfigurationGetArgs>? HealthCheckConfiguration { get; set; }

        /// <summary>
        /// The runtime configuration of instances (scaling units) of the App Runner service. See Instance Configuration below for more details.
        /// </summary>
        [Input("instanceConfiguration")]
        public Input<Inputs.ServiceInstanceConfigurationGetArgs>? InstanceConfiguration { get; set; }

        /// <summary>
        /// Configuration settings related to network traffic of the web application that the App Runner service runs. See Network Configuration below for more details.
        /// </summary>
        [Input("networkConfiguration")]
        public Input<Inputs.ServiceNetworkConfigurationGetArgs>? NetworkConfiguration { get; set; }

        /// <summary>
        /// The observability configuration of your service. See Observability Configuration below for more details.
        /// </summary>
        [Input("observabilityConfiguration")]
        public Input<Inputs.ServiceObservabilityConfigurationGetArgs>? ObservabilityConfiguration { get; set; }

        /// <summary>
        /// An alphanumeric ID that App Runner generated for this service. Unique within the AWS Region.
        /// </summary>
        [Input("serviceId")]
        public Input<string>? ServiceId { get; set; }

        /// <summary>
        /// Name of the service.
        /// </summary>
        [Input("serviceName")]
        public Input<string>? ServiceName { get; set; }

        /// <summary>
        /// Subdomain URL that App Runner generated for this service. You can use this URL to access your service web application.
        /// </summary>
        [Input("serviceUrl")]
        public Input<string>? ServiceUrl { get; set; }

        /// <summary>
        /// The source to deploy to the App Runner service. Can be a code or an image repository. See Source Configuration below for more details.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("sourceConfiguration")]
        public Input<Inputs.ServiceSourceConfigurationGetArgs>? SourceConfiguration { get; set; }

        /// <summary>
        /// Current state of the App Runner service.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value map of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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

        public ServiceState()
        {
        }
        public static new ServiceState Empty => new ServiceState();
    }
}
