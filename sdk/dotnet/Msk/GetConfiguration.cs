// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Msk
{
    public static class GetConfiguration
    {
        /// <summary>
        /// Get information on an Amazon MSK Configuration.
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
        ///     var example = Aws.Msk.GetConfiguration.Invoke(new()
        ///     {
        ///         Name = "example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetConfigurationResult> InvokeAsync(GetConfigurationArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetConfigurationResult>("aws:msk/getConfiguration:getConfiguration", args ?? new GetConfigurationArgs(), options.WithDefaults());

        /// <summary>
        /// Get information on an Amazon MSK Configuration.
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
        ///     var example = Aws.Msk.GetConfiguration.Invoke(new()
        ///     {
        ///         Name = "example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetConfigurationResult> Invoke(GetConfigurationInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetConfigurationResult>("aws:msk/getConfiguration:getConfiguration", args ?? new GetConfigurationInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Get information on an Amazon MSK Configuration.
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
        ///     var example = Aws.Msk.GetConfiguration.Invoke(new()
        ///     {
        ///         Name = "example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetConfigurationResult> Invoke(GetConfigurationInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetConfigurationResult>("aws:msk/getConfiguration:getConfiguration", args ?? new GetConfigurationInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetConfigurationArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the configuration.
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        public GetConfigurationArgs()
        {
        }
        public static new GetConfigurationArgs Empty => new GetConfigurationArgs();
    }

    public sealed class GetConfigurationInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the configuration.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        public GetConfigurationInvokeArgs()
        {
        }
        public static new GetConfigurationInvokeArgs Empty => new GetConfigurationInvokeArgs();
    }


    [OutputType]
    public sealed class GetConfigurationResult
    {
        /// <summary>
        /// ARN of the configuration.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Description of the configuration.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// List of Apache Kafka versions which can use this configuration.
        /// </summary>
        public readonly ImmutableArray<string> KafkaVersions;
        /// <summary>
        /// Latest revision of the configuration.
        /// </summary>
        public readonly int LatestRevision;
        public readonly string Name;
        /// <summary>
        /// Contents of the server.properties file.
        /// </summary>
        public readonly string ServerProperties;

        [OutputConstructor]
        private GetConfigurationResult(
            string arn,

            string description,

            string id,

            ImmutableArray<string> kafkaVersions,

            int latestRevision,

            string name,

            string serverProperties)
        {
            Arn = arn;
            Description = description;
            Id = id;
            KafkaVersions = kafkaVersions;
            LatestRevision = latestRevision;
            Name = name;
            ServerProperties = serverProperties;
        }
    }
}
