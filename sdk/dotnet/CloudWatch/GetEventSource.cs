// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch
{
    public static class GetEventSource
    {
        /// <summary>
        /// Use this data source to get information about an EventBridge Partner Event Source. This data source will only return one partner event source. An error will be returned if multiple sources match the same name prefix.
        /// 
        /// &gt; **Note:** EventBridge was formerly known as CloudWatch Events. The functionality is identical.
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
        ///     var examplepartner = Aws.CloudWatch.GetEventSource.Invoke(new()
        ///     {
        ///         NamePrefix = "aws.partner/examplepartner.com",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetEventSourceResult> InvokeAsync(GetEventSourceArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetEventSourceResult>("aws:cloudwatch/getEventSource:getEventSource", args ?? new GetEventSourceArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get information about an EventBridge Partner Event Source. This data source will only return one partner event source. An error will be returned if multiple sources match the same name prefix.
        /// 
        /// &gt; **Note:** EventBridge was formerly known as CloudWatch Events. The functionality is identical.
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
        ///     var examplepartner = Aws.CloudWatch.GetEventSource.Invoke(new()
        ///     {
        ///         NamePrefix = "aws.partner/examplepartner.com",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetEventSourceResult> Invoke(GetEventSourceInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetEventSourceResult>("aws:cloudwatch/getEventSource:getEventSource", args ?? new GetEventSourceInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get information about an EventBridge Partner Event Source. This data source will only return one partner event source. An error will be returned if multiple sources match the same name prefix.
        /// 
        /// &gt; **Note:** EventBridge was formerly known as CloudWatch Events. The functionality is identical.
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
        ///     var examplepartner = Aws.CloudWatch.GetEventSource.Invoke(new()
        ///     {
        ///         NamePrefix = "aws.partner/examplepartner.com",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetEventSourceResult> Invoke(GetEventSourceInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetEventSourceResult>("aws:cloudwatch/getEventSource:getEventSource", args ?? new GetEventSourceInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetEventSourceArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Specifying this limits the results to only those partner event sources with names that start with the specified prefix
        /// </summary>
        [Input("namePrefix")]
        public string? NamePrefix { get; set; }

        public GetEventSourceArgs()
        {
        }
        public static new GetEventSourceArgs Empty => new GetEventSourceArgs();
    }

    public sealed class GetEventSourceInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Specifying this limits the results to only those partner event sources with names that start with the specified prefix
        /// </summary>
        [Input("namePrefix")]
        public Input<string>? NamePrefix { get; set; }

        public GetEventSourceInvokeArgs()
        {
        }
        public static new GetEventSourceInvokeArgs Empty => new GetEventSourceInvokeArgs();
    }


    [OutputType]
    public sealed class GetEventSourceResult
    {
        /// <summary>
        /// ARN of the partner event source
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// Name of the SaaS partner that created the event source
        /// </summary>
        public readonly string CreatedBy;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Name of the event source
        /// </summary>
        public readonly string Name;
        public readonly string? NamePrefix;
        /// <summary>
        /// State of the event source (`ACTIVE` or `PENDING`)
        /// </summary>
        public readonly string State;

        [OutputConstructor]
        private GetEventSourceResult(
            string arn,

            string createdBy,

            string id,

            string name,

            string? namePrefix,

            string state)
        {
            Arn = arn;
            CreatedBy = createdBy;
            Id = id;
            Name = name;
            NamePrefix = namePrefix;
            State = state;
        }
    }
}
