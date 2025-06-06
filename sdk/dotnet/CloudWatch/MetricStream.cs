// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch
{
    /// <summary>
    /// Provides a CloudWatch Metric Stream resource.
    /// 
    /// ## Example Usage
    /// 
    /// ### Filters
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     // https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-metric-streams-trustpolicy.html
    ///     var streamsAssumeRole = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Effect = "Allow",
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "Service",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "streams.metrics.cloudwatch.amazonaws.com",
    ///                         },
    ///                     },
    ///                 },
    ///                 Actions = new[]
    ///                 {
    ///                     "sts:AssumeRole",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var metricStreamToFirehoseRole = new Aws.Iam.Role("metric_stream_to_firehose", new()
    ///     {
    ///         Name = "metric_stream_to_firehose_role",
    ///         AssumeRolePolicy = streamsAssumeRole.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var bucket = new Aws.S3.BucketV2("bucket", new()
    ///     {
    ///         Bucket = "metric-stream-test-bucket",
    ///     });
    /// 
    ///     var firehoseAssumeRole = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Effect = "Allow",
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "Service",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "firehose.amazonaws.com",
    ///                         },
    ///                     },
    ///                 },
    ///                 Actions = new[]
    ///                 {
    ///                     "sts:AssumeRole",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var firehoseToS3Role = new Aws.Iam.Role("firehose_to_s3", new()
    ///     {
    ///         AssumeRolePolicy = firehoseAssumeRole.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var s3Stream = new Aws.Kinesis.FirehoseDeliveryStream("s3_stream", new()
    ///     {
    ///         Name = "metric-stream-test-stream",
    ///         Destination = "extended_s3",
    ///         ExtendedS3Configuration = new Aws.Kinesis.Inputs.FirehoseDeliveryStreamExtendedS3ConfigurationArgs
    ///         {
    ///             RoleArn = firehoseToS3Role.Arn,
    ///             BucketArn = bucket.Arn,
    ///         },
    ///     });
    /// 
    ///     var main = new Aws.CloudWatch.MetricStream("main", new()
    ///     {
    ///         Name = "my-metric-stream",
    ///         RoleArn = metricStreamToFirehoseRole.Arn,
    ///         FirehoseArn = s3Stream.Arn,
    ///         OutputFormat = "json",
    ///         IncludeFilters = new[]
    ///         {
    ///             new Aws.CloudWatch.Inputs.MetricStreamIncludeFilterArgs
    ///             {
    ///                 Namespace = "AWS/EC2",
    ///                 MetricNames = new[]
    ///                 {
    ///                     "CPUUtilization",
    ///                     "NetworkOut",
    ///                 },
    ///             },
    ///             new Aws.CloudWatch.Inputs.MetricStreamIncludeFilterArgs
    ///             {
    ///                 Namespace = "AWS/EBS",
    ///                 MetricNames = new() { },
    ///             },
    ///         },
    ///     });
    /// 
    ///     // https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-metric-streams-trustpolicy.html
    ///     var metricStreamToFirehose = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Effect = "Allow",
    ///                 Actions = new[]
    ///                 {
    ///                     "firehose:PutRecord",
    ///                     "firehose:PutRecordBatch",
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     s3Stream.Arn,
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var metricStreamToFirehoseRolePolicy = new Aws.Iam.RolePolicy("metric_stream_to_firehose", new()
    ///     {
    ///         Name = "default",
    ///         Role = metricStreamToFirehoseRole.Id,
    ///         Policy = metricStreamToFirehose.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var bucketAcl = new Aws.S3.BucketAclV2("bucket_acl", new()
    ///     {
    ///         Bucket = bucket.Id,
    ///         Acl = "private",
    ///     });
    /// 
    ///     var firehoseToS3 = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Effect = "Allow",
    ///                 Actions = new[]
    ///                 {
    ///                     "s3:AbortMultipartUpload",
    ///                     "s3:GetBucketLocation",
    ///                     "s3:GetObject",
    ///                     "s3:ListBucket",
    ///                     "s3:ListBucketMultipartUploads",
    ///                     "s3:PutObject",
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     bucket.Arn,
    ///                     $"{bucket.Arn}/*",
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var firehoseToS3RolePolicy = new Aws.Iam.RolePolicy("firehose_to_s3", new()
    ///     {
    ///         Name = "default",
    ///         Role = firehoseToS3Role.Id,
    ///         Policy = firehoseToS3.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ### Additional Statistics
    /// 
    /// ```csharp
    /// using System.Collections.Generic;
    /// using System.Linq;
    /// using Pulumi;
    /// using Aws = Pulumi.Aws;
    /// 
    /// return await Deployment.RunAsync(() =&gt; 
    /// {
    ///     var main = new Aws.CloudWatch.MetricStream("main", new()
    ///     {
    ///         Name = "my-metric-stream",
    ///         RoleArn = metricStreamToFirehose.Arn,
    ///         FirehoseArn = s3Stream.Arn,
    ///         OutputFormat = "json",
    ///         StatisticsConfigurations = new[]
    ///         {
    ///             new Aws.CloudWatch.Inputs.MetricStreamStatisticsConfigurationArgs
    ///             {
    ///                 AdditionalStatistics = new[]
    ///                 {
    ///                     "p1",
    ///                     "tm99",
    ///                 },
    ///                 IncludeMetrics = new[]
    ///                 {
    ///                     new Aws.CloudWatch.Inputs.MetricStreamStatisticsConfigurationIncludeMetricArgs
    ///                     {
    ///                         MetricName = "CPUUtilization",
    ///                         Namespace = "AWS/EC2",
    ///                     },
    ///                 },
    ///             },
    ///             new Aws.CloudWatch.Inputs.MetricStreamStatisticsConfigurationArgs
    ///             {
    ///                 AdditionalStatistics = new[]
    ///                 {
    ///                     "TS(50.5:)",
    ///                 },
    ///                 IncludeMetrics = new[]
    ///                 {
    ///                     new Aws.CloudWatch.Inputs.MetricStreamStatisticsConfigurationIncludeMetricArgs
    ///                     {
    ///                         MetricName = "CPUUtilization",
    ///                         Namespace = "AWS/EC2",
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import CloudWatch metric streams using the `name`. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:cloudwatch/metricStream:MetricStream sample sample-stream-name
    /// ```
    /// </summary>
    [AwsResourceType("aws:cloudwatch/metricStream:MetricStream")]
    public partial class MetricStream : global::Pulumi.CustomResource
    {
        /// <summary>
        /// ARN of the metric stream.
        /// </summary>
        [Output("arn")]
        public Output<string> Arn { get; private set; } = null!;

        /// <summary>
        /// Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the metric stream was created.
        /// </summary>
        [Output("creationDate")]
        public Output<string> CreationDate { get; private set; } = null!;

        /// <summary>
        /// List of exclusive metric filters. If you specify this parameter, the stream sends metrics from all metric namespaces except for the namespaces and the conditional metric names that you specify here. If you don't specify metric names or provide empty metric names whole metric namespace is excluded. Conflicts with `include_filter`.
        /// </summary>
        [Output("excludeFilters")]
        public Output<ImmutableArray<Outputs.MetricStreamExcludeFilter>> ExcludeFilters { get; private set; } = null!;

        /// <summary>
        /// ARN of the Amazon Kinesis Firehose delivery stream to use for this metric stream.
        /// </summary>
        [Output("firehoseArn")]
        public Output<string> FirehoseArn { get; private set; } = null!;

        /// <summary>
        /// List of inclusive metric filters. If you specify this parameter, the stream sends only the conditional metric names from the metric namespaces that you specify here. If you don't specify metric names or provide empty metric names whole metric namespace is included. Conflicts with `exclude_filter`.
        /// </summary>
        [Output("includeFilters")]
        public Output<ImmutableArray<Outputs.MetricStreamIncludeFilter>> IncludeFilters { get; private set; } = null!;

        /// <summary>
        /// If you are creating a metric stream in a monitoring account, specify true to include metrics from source accounts that are linked to this monitoring account, in the metric stream. The default is false. For more information about linking accounts, see [CloudWatch cross-account observability](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-Unified-Cross-Account.html).
        /// </summary>
        [Output("includeLinkedAccountsMetrics")]
        public Output<bool?> IncludeLinkedAccountsMetrics { get; private set; } = null!;

        /// <summary>
        /// Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the metric stream was last updated.
        /// </summary>
        [Output("lastUpdateDate")]
        public Output<string> LastUpdateDate { get; private set; } = null!;

        /// <summary>
        /// Friendly name of the metric stream. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
        /// </summary>
        [Output("name")]
        public Output<string> Name { get; private set; } = null!;

        /// <summary>
        /// Creates a unique friendly name beginning with the specified prefix. Conflicts with `name`.
        /// </summary>
        [Output("namePrefix")]
        public Output<string> NamePrefix { get; private set; } = null!;

        /// <summary>
        /// Output format for the stream. Possible values are `json`, `opentelemetry0.7`, and `opentelemetry1.0`. For more information about output formats, see [Metric streams output formats](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-metric-streams-formats.html).
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Output("outputFormat")]
        public Output<string> OutputFormat { get; private set; } = null!;

        /// <summary>
        /// ARN of the IAM role that this metric stream will use to access Amazon Kinesis Firehose resources. For more information about role permissions, see [Trust between CloudWatch and Kinesis Data Firehose](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-metric-streams-trustpolicy.html).
        /// </summary>
        [Output("roleArn")]
        public Output<string> RoleArn { get; private set; } = null!;

        /// <summary>
        /// State of the metric stream. Possible values are `running` and `stopped`.
        /// </summary>
        [Output("state")]
        public Output<string> State { get; private set; } = null!;

        /// <summary>
        /// For each entry in this array, you specify one or more metrics and the list of additional statistics to stream for those metrics. The additional statistics that you can stream depend on the stream's `output_format`. If the OutputFormat is `json`, you can stream any additional statistic that is supported by CloudWatch, listed in [CloudWatch statistics definitions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/Statistics-definitions.html.html). If the OutputFormat is `opentelemetry0.7` or `opentelemetry1.0`, you can stream percentile statistics (p99 etc.). See details below.
        /// </summary>
        [Output("statisticsConfigurations")]
        public Output<ImmutableArray<Outputs.MetricStreamStatisticsConfiguration>> StatisticsConfigurations { get; private set; } = null!;

        /// <summary>
        /// Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        [Output("tags")]
        public Output<ImmutableDictionary<string, string>?> Tags { get; private set; } = null!;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Output("tagsAll")]
        public Output<ImmutableDictionary<string, string>> TagsAll { get; private set; } = null!;


        /// <summary>
        /// Create a MetricStream resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public MetricStream(string name, MetricStreamArgs args, CustomResourceOptions? options = null)
            : base("aws:cloudwatch/metricStream:MetricStream", name, args ?? new MetricStreamArgs(), MakeResourceOptions(options, ""))
        {
        }

        private MetricStream(string name, Input<string> id, MetricStreamState? state = null, CustomResourceOptions? options = null)
            : base("aws:cloudwatch/metricStream:MetricStream", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing MetricStream resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static MetricStream Get(string name, Input<string> id, MetricStreamState? state = null, CustomResourceOptions? options = null)
        {
            return new MetricStream(name, id, state, options);
        }
    }

    public sealed class MetricStreamArgs : global::Pulumi.ResourceArgs
    {
        [Input("excludeFilters")]
        private InputList<Inputs.MetricStreamExcludeFilterArgs>? _excludeFilters;

        /// <summary>
        /// List of exclusive metric filters. If you specify this parameter, the stream sends metrics from all metric namespaces except for the namespaces and the conditional metric names that you specify here. If you don't specify metric names or provide empty metric names whole metric namespace is excluded. Conflicts with `include_filter`.
        /// </summary>
        public InputList<Inputs.MetricStreamExcludeFilterArgs> ExcludeFilters
        {
            get => _excludeFilters ?? (_excludeFilters = new InputList<Inputs.MetricStreamExcludeFilterArgs>());
            set => _excludeFilters = value;
        }

        /// <summary>
        /// ARN of the Amazon Kinesis Firehose delivery stream to use for this metric stream.
        /// </summary>
        [Input("firehoseArn", required: true)]
        public Input<string> FirehoseArn { get; set; } = null!;

        [Input("includeFilters")]
        private InputList<Inputs.MetricStreamIncludeFilterArgs>? _includeFilters;

        /// <summary>
        /// List of inclusive metric filters. If you specify this parameter, the stream sends only the conditional metric names from the metric namespaces that you specify here. If you don't specify metric names or provide empty metric names whole metric namespace is included. Conflicts with `exclude_filter`.
        /// </summary>
        public InputList<Inputs.MetricStreamIncludeFilterArgs> IncludeFilters
        {
            get => _includeFilters ?? (_includeFilters = new InputList<Inputs.MetricStreamIncludeFilterArgs>());
            set => _includeFilters = value;
        }

        /// <summary>
        /// If you are creating a metric stream in a monitoring account, specify true to include metrics from source accounts that are linked to this monitoring account, in the metric stream. The default is false. For more information about linking accounts, see [CloudWatch cross-account observability](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-Unified-Cross-Account.html).
        /// </summary>
        [Input("includeLinkedAccountsMetrics")]
        public Input<bool>? IncludeLinkedAccountsMetrics { get; set; }

        /// <summary>
        /// Friendly name of the metric stream. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Creates a unique friendly name beginning with the specified prefix. Conflicts with `name`.
        /// </summary>
        [Input("namePrefix")]
        public Input<string>? NamePrefix { get; set; }

        /// <summary>
        /// Output format for the stream. Possible values are `json`, `opentelemetry0.7`, and `opentelemetry1.0`. For more information about output formats, see [Metric streams output formats](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-metric-streams-formats.html).
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("outputFormat", required: true)]
        public Input<string> OutputFormat { get; set; } = null!;

        /// <summary>
        /// ARN of the IAM role that this metric stream will use to access Amazon Kinesis Firehose resources. For more information about role permissions, see [Trust between CloudWatch and Kinesis Data Firehose](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-metric-streams-trustpolicy.html).
        /// </summary>
        [Input("roleArn", required: true)]
        public Input<string> RoleArn { get; set; } = null!;

        [Input("statisticsConfigurations")]
        private InputList<Inputs.MetricStreamStatisticsConfigurationArgs>? _statisticsConfigurations;

        /// <summary>
        /// For each entry in this array, you specify one or more metrics and the list of additional statistics to stream for those metrics. The additional statistics that you can stream depend on the stream's `output_format`. If the OutputFormat is `json`, you can stream any additional statistic that is supported by CloudWatch, listed in [CloudWatch statistics definitions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/Statistics-definitions.html.html). If the OutputFormat is `opentelemetry0.7` or `opentelemetry1.0`, you can stream percentile statistics (p99 etc.). See details below.
        /// </summary>
        public InputList<Inputs.MetricStreamStatisticsConfigurationArgs> StatisticsConfigurations
        {
            get => _statisticsConfigurations ?? (_statisticsConfigurations = new InputList<Inputs.MetricStreamStatisticsConfigurationArgs>());
            set => _statisticsConfigurations = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        public MetricStreamArgs()
        {
        }
        public static new MetricStreamArgs Empty => new MetricStreamArgs();
    }

    public sealed class MetricStreamState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN of the metric stream.
        /// </summary>
        [Input("arn")]
        public Input<string>? Arn { get; set; }

        /// <summary>
        /// Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the metric stream was created.
        /// </summary>
        [Input("creationDate")]
        public Input<string>? CreationDate { get; set; }

        [Input("excludeFilters")]
        private InputList<Inputs.MetricStreamExcludeFilterGetArgs>? _excludeFilters;

        /// <summary>
        /// List of exclusive metric filters. If you specify this parameter, the stream sends metrics from all metric namespaces except for the namespaces and the conditional metric names that you specify here. If you don't specify metric names or provide empty metric names whole metric namespace is excluded. Conflicts with `include_filter`.
        /// </summary>
        public InputList<Inputs.MetricStreamExcludeFilterGetArgs> ExcludeFilters
        {
            get => _excludeFilters ?? (_excludeFilters = new InputList<Inputs.MetricStreamExcludeFilterGetArgs>());
            set => _excludeFilters = value;
        }

        /// <summary>
        /// ARN of the Amazon Kinesis Firehose delivery stream to use for this metric stream.
        /// </summary>
        [Input("firehoseArn")]
        public Input<string>? FirehoseArn { get; set; }

        [Input("includeFilters")]
        private InputList<Inputs.MetricStreamIncludeFilterGetArgs>? _includeFilters;

        /// <summary>
        /// List of inclusive metric filters. If you specify this parameter, the stream sends only the conditional metric names from the metric namespaces that you specify here. If you don't specify metric names or provide empty metric names whole metric namespace is included. Conflicts with `exclude_filter`.
        /// </summary>
        public InputList<Inputs.MetricStreamIncludeFilterGetArgs> IncludeFilters
        {
            get => _includeFilters ?? (_includeFilters = new InputList<Inputs.MetricStreamIncludeFilterGetArgs>());
            set => _includeFilters = value;
        }

        /// <summary>
        /// If you are creating a metric stream in a monitoring account, specify true to include metrics from source accounts that are linked to this monitoring account, in the metric stream. The default is false. For more information about linking accounts, see [CloudWatch cross-account observability](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-Unified-Cross-Account.html).
        /// </summary>
        [Input("includeLinkedAccountsMetrics")]
        public Input<bool>? IncludeLinkedAccountsMetrics { get; set; }

        /// <summary>
        /// Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the metric stream was last updated.
        /// </summary>
        [Input("lastUpdateDate")]
        public Input<string>? LastUpdateDate { get; set; }

        /// <summary>
        /// Friendly name of the metric stream. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Creates a unique friendly name beginning with the specified prefix. Conflicts with `name`.
        /// </summary>
        [Input("namePrefix")]
        public Input<string>? NamePrefix { get; set; }

        /// <summary>
        /// Output format for the stream. Possible values are `json`, `opentelemetry0.7`, and `opentelemetry1.0`. For more information about output formats, see [Metric streams output formats](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-metric-streams-formats.html).
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("outputFormat")]
        public Input<string>? OutputFormat { get; set; }

        /// <summary>
        /// ARN of the IAM role that this metric stream will use to access Amazon Kinesis Firehose resources. For more information about role permissions, see [Trust between CloudWatch and Kinesis Data Firehose](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/CloudWatch-metric-streams-trustpolicy.html).
        /// </summary>
        [Input("roleArn")]
        public Input<string>? RoleArn { get; set; }

        /// <summary>
        /// State of the metric stream. Possible values are `running` and `stopped`.
        /// </summary>
        [Input("state")]
        public Input<string>? State { get; set; }

        [Input("statisticsConfigurations")]
        private InputList<Inputs.MetricStreamStatisticsConfigurationGetArgs>? _statisticsConfigurations;

        /// <summary>
        /// For each entry in this array, you specify one or more metrics and the list of additional statistics to stream for those metrics. The additional statistics that you can stream depend on the stream's `output_format`. If the OutputFormat is `json`, you can stream any additional statistic that is supported by CloudWatch, listed in [CloudWatch statistics definitions](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/Statistics-definitions.html.html). If the OutputFormat is `opentelemetry0.7` or `opentelemetry1.0`, you can stream percentile statistics (p99 etc.). See details below.
        /// </summary>
        public InputList<Inputs.MetricStreamStatisticsConfigurationGetArgs> StatisticsConfigurations
        {
            get => _statisticsConfigurations ?? (_statisticsConfigurations = new InputList<Inputs.MetricStreamStatisticsConfigurationGetArgs>());
            set => _statisticsConfigurations = value;
        }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        [Obsolete(@"Please use `tags` instead.")]
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        public MetricStreamState()
        {
        }
        public static new MetricStreamState Empty => new MetricStreamState();
    }
}
