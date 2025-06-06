// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws
{
    public static class GetBillingServiceAccount
    {
        /// <summary>
        /// Use this data source to get the Account ID of the [AWS Billing and Cost Management Service Account](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/billing-getting-started.html#step-2) for the purpose of permitting in S3 bucket policy.
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
        ///     var main = Aws.GetBillingServiceAccount.Invoke();
        /// 
        ///     var billingLogs = new Aws.S3.BucketV2("billing_logs", new()
        ///     {
        ///         Bucket = "my-billing-tf-test-bucket",
        ///     });
        /// 
        ///     var billingLogsAcl = new Aws.S3.BucketAclV2("billing_logs_acl", new()
        ///     {
        ///         Bucket = billingLogs.Id,
        ///         Acl = "private",
        ///     });
        /// 
        ///     var allowBillingLogging = Aws.Iam.GetPolicyDocument.Invoke(new()
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
        ///                             main.Apply(getBillingServiceAccountResult =&gt; getBillingServiceAccountResult.Arn),
        ///                         },
        ///                     },
        ///                 },
        ///                 Actions = new[]
        ///                 {
        ///                     "s3:GetBucketAcl",
        ///                     "s3:GetBucketPolicy",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     billingLogs.Arn,
        ///                 },
        ///             },
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
        ///                             main.Apply(getBillingServiceAccountResult =&gt; getBillingServiceAccountResult.Arn),
        ///                         },
        ///                     },
        ///                 },
        ///                 Actions = new[]
        ///                 {
        ///                     "s3:PutObject",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     $"{billingLogs.Arn}/*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        ///     var allowBillingLoggingBucketPolicy = new Aws.S3.BucketPolicy("allow_billing_logging", new()
        ///     {
        ///         Bucket = billingLogs.Id,
        ///         Policy = allowBillingLogging.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Task<GetBillingServiceAccountResult> InvokeAsync(GetBillingServiceAccountArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.InvokeAsync<GetBillingServiceAccountResult>("aws:index/getBillingServiceAccount:getBillingServiceAccount", args ?? new GetBillingServiceAccountArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get the Account ID of the [AWS Billing and Cost Management Service Account](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/billing-getting-started.html#step-2) for the purpose of permitting in S3 bucket policy.
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
        ///     var main = Aws.GetBillingServiceAccount.Invoke();
        /// 
        ///     var billingLogs = new Aws.S3.BucketV2("billing_logs", new()
        ///     {
        ///         Bucket = "my-billing-tf-test-bucket",
        ///     });
        /// 
        ///     var billingLogsAcl = new Aws.S3.BucketAclV2("billing_logs_acl", new()
        ///     {
        ///         Bucket = billingLogs.Id,
        ///         Acl = "private",
        ///     });
        /// 
        ///     var allowBillingLogging = Aws.Iam.GetPolicyDocument.Invoke(new()
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
        ///                             main.Apply(getBillingServiceAccountResult =&gt; getBillingServiceAccountResult.Arn),
        ///                         },
        ///                     },
        ///                 },
        ///                 Actions = new[]
        ///                 {
        ///                     "s3:GetBucketAcl",
        ///                     "s3:GetBucketPolicy",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     billingLogs.Arn,
        ///                 },
        ///             },
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
        ///                             main.Apply(getBillingServiceAccountResult =&gt; getBillingServiceAccountResult.Arn),
        ///                         },
        ///                     },
        ///                 },
        ///                 Actions = new[]
        ///                 {
        ///                     "s3:PutObject",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     $"{billingLogs.Arn}/*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        ///     var allowBillingLoggingBucketPolicy = new Aws.S3.BucketPolicy("allow_billing_logging", new()
        ///     {
        ///         Bucket = billingLogs.Id,
        ///         Policy = allowBillingLogging.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetBillingServiceAccountResult> Invoke(GetBillingServiceAccountInvokeArgs? args = null, InvokeOptions? options = null)
            => global::Pulumi.Deployment.Instance.Invoke<GetBillingServiceAccountResult>("aws:index/getBillingServiceAccount:getBillingServiceAccount", args ?? new GetBillingServiceAccountInvokeArgs(), options.WithDefaults());

        /// <summary>
        /// Use this data source to get the Account ID of the [AWS Billing and Cost Management Service Account](http://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/billing-getting-started.html#step-2) for the purpose of permitting in S3 bucket policy.
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
        ///     var main = Aws.GetBillingServiceAccount.Invoke();
        /// 
        ///     var billingLogs = new Aws.S3.BucketV2("billing_logs", new()
        ///     {
        ///         Bucket = "my-billing-tf-test-bucket",
        ///     });
        /// 
        ///     var billingLogsAcl = new Aws.S3.BucketAclV2("billing_logs_acl", new()
        ///     {
        ///         Bucket = billingLogs.Id,
        ///         Acl = "private",
        ///     });
        /// 
        ///     var allowBillingLogging = Aws.Iam.GetPolicyDocument.Invoke(new()
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
        ///                             main.Apply(getBillingServiceAccountResult =&gt; getBillingServiceAccountResult.Arn),
        ///                         },
        ///                     },
        ///                 },
        ///                 Actions = new[]
        ///                 {
        ///                     "s3:GetBucketAcl",
        ///                     "s3:GetBucketPolicy",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     billingLogs.Arn,
        ///                 },
        ///             },
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
        ///                             main.Apply(getBillingServiceAccountResult =&gt; getBillingServiceAccountResult.Arn),
        ///                         },
        ///                     },
        ///                 },
        ///                 Actions = new[]
        ///                 {
        ///                     "s3:PutObject",
        ///                 },
        ///                 Resources = new[]
        ///                 {
        ///                     $"{billingLogs.Arn}/*",
        ///                 },
        ///             },
        ///         },
        ///     });
        /// 
        ///     var allowBillingLoggingBucketPolicy = new Aws.S3.BucketPolicy("allow_billing_logging", new()
        ///     {
        ///         Bucket = billingLogs.Id,
        ///         Policy = allowBillingLogging.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
        ///     });
        /// 
        /// });
        /// ```
        /// </summary>
        public static Output<GetBillingServiceAccountResult> Invoke(GetBillingServiceAccountInvokeArgs args, InvokeOutputOptions options)
            => global::Pulumi.Deployment.Instance.Invoke<GetBillingServiceAccountResult>("aws:index/getBillingServiceAccount:getBillingServiceAccount", args ?? new GetBillingServiceAccountInvokeArgs(), options.WithDefaults());
    }


    public sealed class GetBillingServiceAccountArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ID of the AWS billing service account.
        /// </summary>
        [Input("id")]
        public string? Id { get; set; }

        public GetBillingServiceAccountArgs()
        {
        }
        public static new GetBillingServiceAccountArgs Empty => new GetBillingServiceAccountArgs();
    }

    public sealed class GetBillingServiceAccountInvokeArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// ID of the AWS billing service account.
        /// </summary>
        [Input("id")]
        public Input<string>? Id { get; set; }

        public GetBillingServiceAccountInvokeArgs()
        {
        }
        public static new GetBillingServiceAccountInvokeArgs Empty => new GetBillingServiceAccountInvokeArgs();
    }


    [OutputType]
    public sealed class GetBillingServiceAccountResult
    {
        /// <summary>
        /// ARN of the AWS billing service account.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// ID of the AWS billing service account.
        /// </summary>
        public readonly string Id;

        [OutputConstructor]
        private GetBillingServiceAccountResult(
            string arn,

            string id)
        {
            Arn = arn;
            Id = id;
        }
    }
}
