// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.RedShift
{
    public static class GetProducerDataShares
    {
        /// <summary>
        /// Data source for managing AWS Redshift Producer Data Shares.
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
        ///     var example = Aws.RedShift.GetProducerDataShares.Invoke(new()
        ///     {
        ///         ProducerArn = "",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetProducerDataSharesResult> InvokeAsync(GetProducerDataSharesArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetProducerDataSharesResult>("aws:redshift/getProducerDataShares:getProducerDataShares", args ?? new GetProducerDataSharesArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing AWS Redshift Producer Data Shares.
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
        ///     var example = Aws.RedShift.GetProducerDataShares.Invoke(new()
        ///     {
        ///         ProducerArn = "",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetProducerDataSharesResult> Invoke(GetProducerDataSharesInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetProducerDataSharesResult>("aws:redshift/getProducerDataShares:getProducerDataShares", args ?? new GetProducerDataSharesInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing AWS Redshift Producer Data Shares.
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
        ///     var example = Aws.RedShift.GetProducerDataShares.Invoke(new()
        ///     {
        ///         ProducerArn = "",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetProducerDataSharesResult> Invoke(GetProducerDataSharesInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetProducerDataSharesResult>("aws:redshift/getProducerDataShares:getProducerDataShares", args ?? new GetProducerDataSharesInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetProducerDataSharesArgs : global::Pulumi.InvokeArgs
    {
        [Input("dataShares")]
        private List<Inputs.GetProducerDataSharesDataShareArgs>? _dataShares;

        /// <summary>
        /// An array of all data shares in the producer. See `data_shares` below.
        /// </summary>
        public List<Inputs.GetProducerDataSharesDataShareArgs> DataShares
        {
            get => _dataShares ?? (_dataShares = new List<Inputs.GetProducerDataSharesDataShareArgs>());
            set => _dataShares = value;
        }

        /// <summary>
        /// Amazon Resource Name (ARN) of the producer namespace that returns in the list of datashares.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("producerArn", required: true)]
        public string ProducerArn { get; set; } = null!;

        /// <summary>
        /// Status of a datashare in the producer. Valid values are `ACTIVE`, `AUTHORIZED`, `PENDING_AUTHORIZATION`, `DEAUTHORIZED`, and `REJECTED`. Omit this argument to return all statuses.
        /// </summary>
        [Input("status")]
        public string? Status { get; set; }

        public GetProducerDataSharesArgs()
        {
        }
        public static new GetProducerDataSharesArgs Empty => new GetProducerDataSharesArgs();
    }

    public sealed class GetProducerDataSharesInvokeArgs : global::Pulumi.InvokeArgs
    {
        [Input("dataShares")]
        private InputList<Inputs.GetProducerDataSharesDataShareInputArgs>? _dataShares;

        /// <summary>
        /// An array of all data shares in the producer. See `data_shares` below.
        /// </summary>
        public InputList<Inputs.GetProducerDataSharesDataShareInputArgs> DataShares
        {
            get => _dataShares ?? (_dataShares = new InputList<Inputs.GetProducerDataSharesDataShareInputArgs>());
            set => _dataShares = value;
        }

        /// <summary>
        /// Amazon Resource Name (ARN) of the producer namespace that returns in the list of datashares.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("producerArn", required: true)]
        public Input<string> ProducerArn { get; set; } = null!;

        /// <summary>
        /// Status of a datashare in the producer. Valid values are `ACTIVE`, `AUTHORIZED`, `PENDING_AUTHORIZATION`, `DEAUTHORIZED`, and `REJECTED`. Omit this argument to return all statuses.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        public GetProducerDataSharesInvokeArgs()
        {
        }
        public static new GetProducerDataSharesInvokeArgs Empty => new GetProducerDataSharesInvokeArgs();
    }


    [OutputType]
    public sealed class GetProducerDataSharesResult
    {
        /// <summary>
        /// An array of all data shares in the producer. See `data_shares` below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetProducerDataSharesDataShareResult> DataShares;
        /// <summary>
        /// Producer ARN.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// ARN (Amazon Resource Name) of the producer.
        /// </summary>
        public readonly string ProducerArn;
        public readonly string? Status;

        [OutputConstructor]
        private GetProducerDataSharesResult(
            ImmutableArray<Outputs.GetProducerDataSharesDataShareResult> dataShares,

            string id,

            string producerArn,

            string? status)
        {
            DataShares = dataShares;
            Id = id;
            ProducerArn = producerArn;
            Status = status;
        }
    }
}
