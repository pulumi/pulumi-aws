// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight
{
    public static class GetQuicksightAnalysis
    {
        /// <summary>
        /// Data source for managing an AWS QuickSight Analysis.
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
        ///     var example = Aws.Quicksight.GetQuicksightAnalysis.Invoke(new()
        ///     {
        ///         AnalysisId = "example-id",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetQuicksightAnalysisResult> InvokeAsync(GetQuicksightAnalysisArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetQuicksightAnalysisResult>("aws:quicksight/getQuicksightAnalysis:getQuicksightAnalysis", args ?? new GetQuicksightAnalysisArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS QuickSight Analysis.
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
        ///     var example = Aws.Quicksight.GetQuicksightAnalysis.Invoke(new()
        ///     {
        ///         AnalysisId = "example-id",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetQuicksightAnalysisResult> Invoke(GetQuicksightAnalysisInvokeArgs args, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetQuicksightAnalysisResult>("aws:quicksight/getQuicksightAnalysis:getQuicksightAnalysis", args ?? new GetQuicksightAnalysisInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Data source for managing an AWS QuickSight Analysis.
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
        ///     var example = Aws.Quicksight.GetQuicksightAnalysis.Invoke(new()
        ///     {
        ///         AnalysisId = "example-id",
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetQuicksightAnalysisResult> Invoke(GetQuicksightAnalysisInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetQuicksightAnalysisResult>("aws:quicksight/getQuicksightAnalysis:getQuicksightAnalysis", args ?? new GetQuicksightAnalysisInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetQuicksightAnalysisArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Identifier for the analysis.
        /// </summary>
        [Input("analysisId", required: true)]
        public string AnalysisId { get; set; } = null!;

        /// <summary>
        /// AWS account ID.
        /// </summary>
        [Input("awsAccountId")]
        public string? AwsAccountId { get; set; }

        [Input("tags")]
        private Dictionary<string, string>? _tags;
        public Dictionary<string, string> Tags
        {
            get => _tags ?? (_tags = new Dictionary<string, string>());
            set => _tags = value;
        }

        public GetQuicksightAnalysisArgs()
        {
        }
        public static new GetQuicksightAnalysisArgs Empty => new GetQuicksightAnalysisArgs();
    }

    public sealed class GetQuicksightAnalysisInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Identifier for the analysis.
        /// </summary>
        [Input("analysisId", required: true)]
        public Input<string> AnalysisId { get; set; } = null!;

        /// <summary>
        /// AWS account ID.
        /// </summary>
        [Input("awsAccountId")]
        public Input<string>? AwsAccountId { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public GetQuicksightAnalysisInvokeArgs()
        {
        }
        public static new GetQuicksightAnalysisInvokeArgs Empty => new GetQuicksightAnalysisInvokeArgs();
    }


    [OutputType]
    public sealed class GetQuicksightAnalysisResult
    {
        public readonly string AnalysisId;
        public readonly string Arn;
        public readonly string AwsAccountId;
        public readonly string CreatedTime;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string LastPublishedTime;
        public readonly string LastUpdatedTime;
        public readonly string Name;
        public readonly ImmutableArray<Outputs.GetQuicksightAnalysisPermissionResult> Permissions;
        public readonly string Status;
        public readonly ImmutableDictionary<string, string> Tags;
        public readonly string ThemeArn;

        [OutputConstructor]
        private GetQuicksightAnalysisResult(
            string analysisId,

            string arn,

            string awsAccountId,

            string createdTime,

            string id,

            string lastPublishedTime,

            string lastUpdatedTime,

            string name,

            ImmutableArray<Outputs.GetQuicksightAnalysisPermissionResult> permissions,

            string status,

            ImmutableDictionary<string, string> tags,

            string themeArn)
        {
            AnalysisId = analysisId;
            Arn = arn;
            AwsAccountId = awsAccountId;
            CreatedTime = createdTime;
            Id = id;
            LastPublishedTime = lastPublishedTime;
            LastUpdatedTime = lastUpdatedTime;
            Name = name;
            Permissions = permissions;
            Status = status;
            Tags = tags;
            ThemeArn = themeArn;
        }
    }
}
