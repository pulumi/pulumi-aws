// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Elb
{
    public static class GetServiceAccount
    {
        /// <summary>
        /// Use this data source to get the Account ID of the [AWS Elastic Load Balancing Service Account](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/enable-access-logs.html#attach-bucket-policy)
        /// in a given region for the purpose of permitting in S3 bucket policy.
        /// 
        /// &gt; **Note:** For AWS Regions opened since Jakarta (`ap-southeast-3`) in December 2021, AWS [documents that](https://docs.aws.amazon.com/elasticloadbalancing/latest/classic/enable-access-logs.html#attach-bucket-policy) a [service principal name](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html#principal-services) should be used instead of an AWS account ID in any relevant IAM policy.
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
        ///     var main = Aws.Elb.GetServiceAccount.Invoke();
        /// 
        ///     var elbLogs = new Aws.S3.BucketV2("elb_logs", new()
        ///     {
        ///         Bucket = "my-elb-tf-test-bucket",
        ///     });
        /// 
        ///     var elbLogsAcl = new Aws.S3.BucketAclV2("elb_logs_acl", new()
        ///     {
        ///         Bucket = elbLogs.Id,
        ///         Acl = "private",
        ///     });
        /// 
        ///     var allowElbLogging = Aws.Iam.GetPolicyDocument.Invoke(new()
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
        ///                         Type = "AWS",
        ///                         Identifiers = new[]
        ///                         {
        ///                             main.Apply(getServiceAccountResult =&gt; getServiceAccountResult.Arn),
        ///                         },
        ///                     },
        ///                 },
        ///                 Actions = new[]
        ///                 {
        ///                     "s3:PutObject",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     $"{elbLogs.Arn}/AWSLogs/*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        ///     var allowElbLoggingBucketPolicy = new Aws.S3.BucketPolicy("allow_elb_logging", new()
        ///     {
        ///         Bucket = elbLogs.Id,
        ///         Policy = allowElbLogging.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
        ///     });
        /// 
        ///     var bar = new Aws.Elb.LoadBalancer("bar", new()
        ///     {
        ///         Name = "my-foobar-elb",
        ///         AvailabilityZones = new[]
        ///         {
        ///             "us-west-2a",
        ///         },
        ///         AccessLogs = new Aws.Elb.Inputs.LoadBalancerAccessLogsArgs
        ///         {
        ///             Bucket = elbLogs.Id,
        ///             Interval = 5,
        ///         },
        ///         Listeners = new[]
        ///         {
        ///             new Aws.Elb.Inputs.LoadBalancerListenerArgs
        ///             {
        ///                 InstancePort = 8000,
        ///                 InstanceProtocol = "http",
        ///                 LbPort = 80,
        ///                 LbProtocol = "http",
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetServiceAccountResult> InvokeAsync(GetServiceAccountArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetServiceAccountResult>("aws:elb/getServiceAccount:getServiceAccount", args ?? new GetServiceAccountArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get the Account ID of the [AWS Elastic Load Balancing Service Account](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/enable-access-logs.html#attach-bucket-policy)
        /// in a given region for the purpose of permitting in S3 bucket policy.
        /// 
        /// &gt; **Note:** For AWS Regions opened since Jakarta (`ap-southeast-3`) in December 2021, AWS [documents that](https://docs.aws.amazon.com/elasticloadbalancing/latest/classic/enable-access-logs.html#attach-bucket-policy) a [service principal name](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html#principal-services) should be used instead of an AWS account ID in any relevant IAM policy.
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
        ///     var main = Aws.Elb.GetServiceAccount.Invoke();
        /// 
        ///     var elbLogs = new Aws.S3.BucketV2("elb_logs", new()
        ///     {
        ///         Bucket = "my-elb-tf-test-bucket",
        ///     });
        /// 
        ///     var elbLogsAcl = new Aws.S3.BucketAclV2("elb_logs_acl", new()
        ///     {
        ///         Bucket = elbLogs.Id,
        ///         Acl = "private",
        ///     });
        /// 
        ///     var allowElbLogging = Aws.Iam.GetPolicyDocument.Invoke(new()
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
        ///                         Type = "AWS",
        ///                         Identifiers = new[]
        ///                         {
        ///                             main.Apply(getServiceAccountResult =&gt; getServiceAccountResult.Arn),
        ///                         },
        ///                     },
        ///                 },
        ///                 Actions = new[]
        ///                 {
        ///                     "s3:PutObject",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     $"{elbLogs.Arn}/AWSLogs/*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        ///     var allowElbLoggingBucketPolicy = new Aws.S3.BucketPolicy("allow_elb_logging", new()
        ///     {
        ///         Bucket = elbLogs.Id,
        ///         Policy = allowElbLogging.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
        ///     });
        /// 
        ///     var bar = new Aws.Elb.LoadBalancer("bar", new()
        ///     {
        ///         Name = "my-foobar-elb",
        ///         AvailabilityZones = new[]
        ///         {
        ///             "us-west-2a",
        ///         },
        ///         AccessLogs = new Aws.Elb.Inputs.LoadBalancerAccessLogsArgs
        ///         {
        ///             Bucket = elbLogs.Id,
        ///             Interval = 5,
        ///         },
        ///         Listeners = new[]
        ///         {
        ///             new Aws.Elb.Inputs.LoadBalancerListenerArgs
        ///             {
        ///                 InstancePort = 8000,
        ///                 InstanceProtocol = "http",
        ///                 LbPort = 80,
        ///                 LbProtocol = "http",
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetServiceAccountResult> Invoke(GetServiceAccountInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetServiceAccountResult>("aws:elb/getServiceAccount:getServiceAccount", args ?? new GetServiceAccountInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get the Account ID of the [AWS Elastic Load Balancing Service Account](http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/enable-access-logs.html#attach-bucket-policy)
        /// in a given region for the purpose of permitting in S3 bucket policy.
        /// 
        /// &gt; **Note:** For AWS Regions opened since Jakarta (`ap-southeast-3`) in December 2021, AWS [documents that](https://docs.aws.amazon.com/elasticloadbalancing/latest/classic/enable-access-logs.html#attach-bucket-policy) a [service principal name](https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_principal.html#principal-services) should be used instead of an AWS account ID in any relevant IAM policy.
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
        ///     var main = Aws.Elb.GetServiceAccount.Invoke();
        /// 
        ///     var elbLogs = new Aws.S3.BucketV2("elb_logs", new()
        ///     {
        ///         Bucket = "my-elb-tf-test-bucket",
        ///     });
        /// 
        ///     var elbLogsAcl = new Aws.S3.BucketAclV2("elb_logs_acl", new()
        ///     {
        ///         Bucket = elbLogs.Id,
        ///         Acl = "private",
        ///     });
        /// 
        ///     var allowElbLogging = Aws.Iam.GetPolicyDocument.Invoke(new()
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
        ///                         Type = "AWS",
        ///                         Identifiers = new[]
        ///                         {
        ///                             main.Apply(getServiceAccountResult =&gt; getServiceAccountResult.Arn),
        ///                         },
        ///                     },
        ///                 },
        ///                 Actions = new[]
        ///                 {
        ///                     "s3:PutObject",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     $"{elbLogs.Arn}/AWSLogs/*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        ///     var allowElbLoggingBucketPolicy = new Aws.S3.BucketPolicy("allow_elb_logging", new()
        ///     {
        ///         Bucket = elbLogs.Id,
        ///         Policy = allowElbLogging.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
        ///     });
        /// 
        ///     var bar = new Aws.Elb.LoadBalancer("bar", new()
        ///     {
        ///         Name = "my-foobar-elb",
        ///         AvailabilityZones = new[]
        ///         {
        ///             "us-west-2a",
        ///         },
        ///         AccessLogs = new Aws.Elb.Inputs.LoadBalancerAccessLogsArgs
        ///         {
        ///             Bucket = elbLogs.Id,
        ///             Interval = 5,
        ///         },
        ///         Listeners = new[]
        ///         {
        ///             new Aws.Elb.Inputs.LoadBalancerListenerArgs
        ///             {
        ///                 InstancePort = 8000,
        ///                 InstanceProtocol = "http",
        ///                 LbPort = 80,
        ///                 LbProtocol = "http",
        ///             },
        ///         },
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetServiceAccountResult> Invoke(GetServiceAccountInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetServiceAccountResult>("aws:elb/getServiceAccount:getServiceAccount", args ?? new GetServiceAccountInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetServiceAccountArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the region whose AWS ELB account ID is desired.
        /// Defaults to the region from the AWS provider configuration.
        /// </summary>
        [Input("region")]
        public string? Region { get; set; }

        public GetServiceAccountArgs()
        {
        }
        public static new GetServiceAccountArgs Empty => new GetServiceAccountArgs();
    }

    public sealed class GetServiceAccountInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Name of the region whose AWS ELB account ID is desired.
        /// Defaults to the region from the AWS provider configuration.
        /// </summary>
        [Input("region")]
        public Input<string>? Region { get; set; }

        public GetServiceAccountInvokeArgs()
        {
        }
        public static new GetServiceAccountInvokeArgs Empty => new GetServiceAccountInvokeArgs();
    }


    [OutputType]
    public sealed class GetServiceAccountResult
    {
        /// <summary>
        /// ARN of the AWS ELB service account in the selected region.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// The provider-assigned unique ID for this managed resource.
        /// </summary>
        public readonly string Id;
        public readonly string? Region;

        [OutputConstructor]
        private GetServiceAccountResult(
            string arn,

            string id,

            string? region)
        {
            Arn = arn;
            Id = id;
            Region = region;
        }
    }
}
