// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis
{
    public static class GetStreamConsumer
    {
        /// <summary>
        /// Provides details about a Kinesis Stream Consumer.
        /// 
        /// For more details, see the [Amazon Kinesis Stream Consumer Documentation](https://docs.aws.amazon.com/streams/latest/dev/amazon-kinesis-consumers.html).
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
        ///     var example = Aws.Kinesis.GetStreamConsumer.Invoke(new()
        ///     {
        ///         Name = "example-consumer",
        ///         StreamArn = exampleAwsKinesisStream.Arn,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetStreamConsumerResult> InvokeAsync(GetStreamConsumerArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetStreamConsumerResult>("aws:kinesis/getStreamConsumer:getStreamConsumer", args ?? new GetStreamConsumerArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about a Kinesis Stream Consumer.
        /// 
        /// For more details, see the [Amazon Kinesis Stream Consumer Documentation](https://docs.aws.amazon.com/streams/latest/dev/amazon-kinesis-consumers.html).
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
        ///     var example = Aws.Kinesis.GetStreamConsumer.Invoke(new()
        ///     {
        ///         Name = "example-consumer",
        ///         StreamArn = exampleAwsKinesisStream.Arn,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetStreamConsumerResult> Invoke(GetStreamConsumerInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetStreamConsumerResult>("aws:kinesis/getStreamConsumer:getStreamConsumer", args ?? new GetStreamConsumerInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Provides details about a Kinesis Stream Consumer.
        /// 
        /// For more details, see the [Amazon Kinesis Stream Consumer Documentation](https://docs.aws.amazon.com/streams/latest/dev/amazon-kinesis-consumers.html).
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
        ///     var example = Aws.Kinesis.GetStreamConsumer.Invoke(new()
        ///     {
        ///         Name = "example-consumer",
        ///         StreamArn = exampleAwsKinesisStream.Arn,
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetStreamConsumerResult> Invoke(GetStreamConsumerInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetStreamConsumerResult>("aws:kinesis/getStreamConsumer:getStreamConsumer", args ?? new GetStreamConsumerInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetStreamConsumerArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ARN of the stream consumer.
        /// </summary>
        [Input("arn")]
        public string? Arn { get; set; }

        /// <summary>
        /// Name of the stream consumer.
        /// </summary>
        [Input("name")]
        public string? Name { get; set; }

        /// <summary>
        /// ARN of the data stream the consumer is registered with.
        /// </summary>
        [Input("streamArn", required: true)]
        public string StreamArn { get; set; } = null!;

        public GetStreamConsumerArgs()
        {
        }
        public static new GetStreamConsumerArgs Empty => new GetStreamConsumerArgs();
    }

    public sealed class GetStreamConsumerInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ARN of the stream consumer.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Name of the stream consumer.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// ARN of the data stream the consumer is registered with.
        /// </summary>
        [Input("streamArn", required: true)]
        public Input<string> StreamArn { get; set; } = null!;

        public GetStreamConsumerInvokeArgs()
        {
        }
        public static new GetStreamConsumerInvokeArgs Empty => new GetStreamConsumerInvokeArgs();
    }


    [OutputType]
    public sealed class GetStreamConsumerResult
    {
        public readonly string Arn;
        /// <summary>
        /// Approximate timestamp in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) of when the stream consumer was created.
        /// </summary>
        public readonly string CreationTimestamp;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string Name;
        /// <summary>
        /// Current status of the stream consumer.
        /// </summary>
        public readonly string Status;
        public readonly string StreamArn;

        [OutputConstructor]
        private GetStreamConsumerResult(
            string arn,

            string creationTimestamp,

            string id,

            string name,

            string status,

            string streamArn)
        {
            Arn = arn;
            CreationTimestamp = creationTimestamp;
            Id = id;
            Name = name;
            Status = status;
            StreamArn = streamArn;
        }
    }
}
