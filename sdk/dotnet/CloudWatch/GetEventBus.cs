// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch
{
    public static class GetEventBus
    {
        /// <summary>
        /// This data source can be used to fetch information about a specific
        /// EventBridge event bus. Use this data source to compute the ARN of
        /// an event bus, given the name of the bus.
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
        ///     var example = Aws.CloudWatch.GetEventBus.Invoke(new()
        ///     {
        ///         Name = "example-bus-name",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetEventBusResult> InvokeAsync(GetEventBusArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetEventBusResult>("aws:cloudwatch/getEventBus:getEventBus", args ?? new GetEventBusArgs(), options.WithDefaults());

        /// <summary>
        /// This data source can be used to fetch information about a specific
        /// EventBridge event bus. Use this data source to compute the ARN of
        /// an event bus, given the name of the bus.
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
        ///     var example = Aws.CloudWatch.GetEventBus.Invoke(new()
        ///     {
        ///         Name = "example-bus-name",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetEventBusResult> Invoke(GetEventBusInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetEventBusResult>("aws:cloudwatch/getEventBus:getEventBus", args ?? new GetEventBusInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// This data source can be used to fetch information about a specific
        /// EventBridge event bus. Use this data source to compute the ARN of
        /// an event bus, given the name of the bus.
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
        ///     var example = Aws.CloudWatch.GetEventBus.Invoke(new()
        ///     {
        ///         Name = "example-bus-name",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetEventBusResult> Invoke(GetEventBusInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetEventBusResult>("aws:cloudwatch/getEventBus:getEventBus", args ?? new GetEventBusInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetEventBusArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the event bus.
        /// </summary>
        [Input("name", required: true)]
        public string Name { get; set; } = null!;

        public GetEventBusArgs()
        {
        }
        public static new GetEventBusArgs Empty => new GetEventBusArgs();
    }

    public sealed class GetEventBusInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the event bus.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        public GetEventBusInvokeArgs()
        {
        }
        public static new GetEventBusInvokeArgs Empty => new GetEventBusInvokeArgs();
    }


    [OutputType]
    public sealed class GetEventBusResult
    {
        /// <summary>
        /// The ARN of the SQS queue specified as the target for the dead-letter queue.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Configuration details of the Amazon SQS queue for EventBridge to use as a dead-letter queue (DLQ). This block has the following arguments:
        /// </summary>
        public readonly ImmutableArray<Outputs.GetEventBusDeadLetterConfigResult> DeadLetterConfigs;
        /// <summary>
        /// Event bus description.
        /// </summary>
        public readonly string Description;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Identifier of the AWS KMS customer managed key for EventBridge to use to encrypt events on this event bus, if one has been specified.
        /// </summary>
        public readonly string KmsKeyIdentifier;
        public readonly string Name;

        [OutputConstructor]
        private GetEventBusResult(
            string arn,

            ImmutableArray<Outputs.GetEventBusDeadLetterConfigResult> deadLetterConfigs,

            string description,

            string id,

            string kmsKeyIdentifier,

            string name)
        {
            Arn = arn;
            DeadLetterConfigs = deadLetterConfigs;
            Description = description;
            Id = id;
            KmsKeyIdentifier = kmsKeyIdentifier;
            Name = name;
        }
    }
}
