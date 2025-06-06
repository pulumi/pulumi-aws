// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sqs
{
    public static class GetQueues
    {
        /// <summary>
        /// Data source for managing an AWS SQS (Simple Queue) Queues.
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
        ///     var example = Aws.Sqs.GetQueues.Invoke(new()
        ///     {
        ///         QueueNamePrefix = "example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetQueuesResult> InvokeAsync(GetQueuesArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetQueuesResult>("aws:sqs/getQueues:getQueues", args ?? new GetQueuesArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS SQS (Simple Queue) Queues.
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
        ///     var example = Aws.Sqs.GetQueues.Invoke(new()
        ///     {
        ///         QueueNamePrefix = "example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetQueuesResult> Invoke(GetQueuesInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetQueuesResult>("aws:sqs/getQueues:getQueues", args ?? new GetQueuesInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS SQS (Simple Queue) Queues.
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
        ///     var example = Aws.Sqs.GetQueues.Invoke(new()
        ///     {
        ///         QueueNamePrefix = "example",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetQueuesResult> Invoke(GetQueuesInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetQueuesResult>("aws:sqs/getQueues:getQueues", args ?? new GetQueuesInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetQueuesArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// A string to use for filtering the list results. Only those queues whose name begins with the specified string are returned. Queue URLs and names are case-sensitive.
        /// </summary>
        [Input("queueNamePrefix")]
        public string? QueueNamePrefix { get; set; }

        public GetQueuesArgs()
        {
        }
        public static new GetQueuesArgs Empty => new GetQueuesArgs();
    }

    public sealed class GetQueuesInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// A string to use for filtering the list results. Only those queues whose name begins with the specified string are returned. Queue URLs and names are case-sensitive.
        /// </summary>
        [Input("queueNamePrefix")]
        public Input<string>? QueueNamePrefix { get; set; }

        public GetQueuesInvokeArgs()
        {
        }
        public static new GetQueuesInvokeArgs Empty => new GetQueuesInvokeArgs();
    }


    [OutputType]
    public sealed class GetQueuesResult
    {
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string? QueueNamePrefix;
        /// <summary>
        /// A list of queue URLs.
        /// </summary>
        public readonly ImmutableArray<string> QueueUrls;

        [OutputConstructor]
        private GetQueuesResult(
            string id,

            string? queueNamePrefix,

            ImmutableArray<string> queueUrls)
        {
            Id = id;
            QueueNamePrefix = queueNamePrefix;
            QueueUrls = queueUrls;
        }
    }
}
