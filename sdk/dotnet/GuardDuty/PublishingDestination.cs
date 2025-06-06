// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GuardDuty
{
    /// <summary>
    /// Provides a resource to manage a GuardDuty PublishingDestination. Requires an existing GuardDuty Detector.
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
    ///     var current = Aws.GetCallerIdentity.Invoke();
    /// 
    ///     var currentGetRegion = Aws.GetRegion.Invoke();
    /// 
    ///     var gdBucket = new Aws.S3.BucketV2("gd_bucket", new()
    ///     {
    ///         Bucket = "example",
    ///         ForceDestroy = true,
    ///     });
    /// 
    ///     var bucketPol = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Sid = "Allow PutObject",
    ///                 Actions = new[]
    ///                 {
    ///                     "s3:PutObject",
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     $"{gdBucket.Arn}/*",
    ///                 },
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "Service",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "guardduty.amazonaws.com",
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Sid = "Allow GetBucketLocation",
    ///                 Actions = new[]
    ///                 {
    ///                     "s3:GetBucketLocation",
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     gdBucket.Arn,
    ///                 },
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "Service",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "guardduty.amazonaws.com",
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var kmsPol = Aws.Iam.GetPolicyDocument.Invoke(new()
    ///     {
    ///         Statements = new[]
    ///         {
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Sid = "Allow GuardDuty to encrypt findings",
    ///                 Actions = new[]
    ///                 {
    ///                     "kms:GenerateDataKey",
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     $"arn:aws:kms:{currentGetRegion.Apply(getRegionResult =&gt; getRegionResult.Name)}:{current.Apply(getCallerIdentityResult =&gt; getCallerIdentityResult.AccountId)}:key/*",
    ///                 },
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "Service",
    ///                         Identifiers = new[]
    ///                         {
    ///                             "guardduty.amazonaws.com",
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///             new Aws.Iam.Inputs.GetPolicyDocumentStatementInputArgs
    ///             {
    ///                 Sid = "Allow all users to modify/delete key (test only)",
    ///                 Actions = new[]
    ///                 {
    ///                     "kms:*",
    ///                 },
    ///                 Resources = new[]
    ///                 {
    ///                     $"arn:aws:kms:{currentGetRegion.Apply(getRegionResult =&gt; getRegionResult.Name)}:{current.Apply(getCallerIdentityResult =&gt; getCallerIdentityResult.AccountId)}:key/*",
    ///                 },
    ///                 Principals = new[]
    ///                 {
    ///                     new Aws.Iam.Inputs.GetPolicyDocumentStatementPrincipalInputArgs
    ///                     {
    ///                         Type = "AWS",
    ///                         Identifiers = new[]
    ///                         {
    ///                             $"arn:aws:iam::{current.Apply(getCallerIdentityResult =&gt; getCallerIdentityResult.AccountId)}:root",
    ///                         },
    ///                     },
    ///                 },
    ///             },
    ///         },
    ///     });
    /// 
    ///     var testGd = new Aws.GuardDuty.Detector("test_gd", new()
    ///     {
    ///         Enable = true,
    ///     });
    /// 
    ///     var gdBucketAcl = new Aws.S3.BucketAclV2("gd_bucket_acl", new()
    ///     {
    ///         Bucket = gdBucket.Id,
    ///         Acl = "private",
    ///     });
    /// 
    ///     var gdBucketPolicy = new Aws.S3.BucketPolicy("gd_bucket_policy", new()
    ///     {
    ///         Bucket = gdBucket.Id,
    ///         Policy = bucketPol.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var gdKey = new Aws.Kms.Key("gd_key", new()
    ///     {
    ///         Description = "Temporary key for AccTest of TF",
    ///         DeletionWindowInDays = 7,
    ///         Policy = kmsPol.Apply(getPolicyDocumentResult =&gt; getPolicyDocumentResult.Json),
    ///     });
    /// 
    ///     var test = new Aws.GuardDuty.PublishingDestination("test", new()
    ///     {
    ///         DetectorId = testGd.Id,
    ///         DestinationArn = gdBucket.Arn,
    ///         KmsKeyArn = gdKey.Arn,
    ///     }, new CustomResourceOptions
    ///     {
    ///         DependsOn =
    ///         {
    ///             gdBucketPolicy,
    ///         },
    ///     });
    /// 
    /// });
    /// ```
    /// 
    /// &gt; **Note:** Please do not use this simple example for Bucket-Policy and KMS Key Policy in a production environment. It is much too open for such a use-case. Refer to the AWS documentation here: https://docs.aws.amazon.com/guardduty/latest/ug/guardduty_exportfindings.html
    /// 
    /// ## Import
    /// 
    /// Using `pulumi import`, import GuardDuty PublishingDestination using the master GuardDuty detector ID and PublishingDestinationID. For example:
    /// 
    /// ```sh
    /// $ pulumi import aws:guardduty/publishingDestination:PublishingDestination test a4b86f26fa42e7e7cf0d1c333ea77777:a4b86f27a0e464e4a7e0516d242f1234
    /// ```
    /// </summary>
    [AwsResourceType("aws:guardduty/publishingDestination:PublishingDestination")]
    public partial class PublishingDestination : global::Pulumi.CustomResource
    {
        /// <summary>
        /// The bucket arn and prefix under which the findings get exported. Bucket-ARN is required, the prefix is optional and will be `AWSLogs/[Account-ID]/GuardDuty/[Region]/` if not provided
        /// </summary>
        [Output("destinationArn")]
        public Output<string> DestinationArn { get; private set; } = null!;

        /// <summary>
        /// Currently there is only "S3" available as destination type which is also the default value
        /// 
        /// &gt; **Note:** In case of missing permissions (S3 Bucket Policy _or_ KMS Key permissions) the resource will fail to create. If the permissions are changed after resource creation, this can be asked from the AWS API via the "DescribePublishingDestination" call (https://docs.aws.amazon.com/cli/latest/reference/guardduty/describe-publishing-destination.html).
        /// </summary>
        [Output("destinationType")]
        public Output<string?> DestinationType { get; private set; } = null!;

        /// <summary>
        /// The detector ID of the GuardDuty.
        /// </summary>
        [Output("detectorId")]
        public Output<string> DetectorId { get; private set; } = null!;

        /// <summary>
        /// The ARN of the KMS key used to encrypt GuardDuty findings. GuardDuty enforces this to be encrypted.
        /// </summary>
        [Output("kmsKeyArn")]
        public Output<string> KmsKeyArn { get; private set; } = null!;


        /// <summary>
        /// Create a PublishingDestination resource with the given unique name, arguments, and options.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public PublishingDestination(string name, PublishingDestinationArgs args, CustomResourceOptions? options = null)
            : base("aws:guardduty/publishingDestination:PublishingDestination", name, args ?? new PublishingDestinationArgs(), MakeResourceOptions(options, ""))
        {
        }

        private PublishingDestination(string name, Input<string> id, PublishingDestinationState? state = null, CustomResourceOptions? options = null)
            : base("aws:guardduty/publishingDestination:PublishingDestination", name, state, MakeResourceOptions(options, id))
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
        /// Get an existing PublishingDestination resource's state with the given name, ID, and optional extra
        /// properties used to qualify the lookup.
        /// </summary>
        ///
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="state">Any extra arguments used during the lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static PublishingDestination Get(string name, Input<string> id, PublishingDestinationState? state = null, CustomResourceOptions? options = null)
        {
            return new PublishingDestination(name, id, state, options);
        }
    }

    public sealed class PublishingDestinationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The bucket arn and prefix under which the findings get exported. Bucket-ARN is required, the prefix is optional and will be `AWSLogs/[Account-ID]/GuardDuty/[Region]/` if not provided
        /// </summary>
        [Input("destinationArn", required: true)]
        public Input<string> DestinationArn { get; set; } = null!;

        /// <summary>
        /// Currently there is only "S3" available as destination type which is also the default value
        /// 
        /// &gt; **Note:** In case of missing permissions (S3 Bucket Policy _or_ KMS Key permissions) the resource will fail to create. If the permissions are changed after resource creation, this can be asked from the AWS API via the "DescribePublishingDestination" call (https://docs.aws.amazon.com/cli/latest/reference/guardduty/describe-publishing-destination.html).
        /// </summary>
        [Input("destinationType")]
        public Input<string>? DestinationType { get; set; }

        /// <summary>
        /// The detector ID of the GuardDuty.
        /// </summary>
        [Input("detectorId", required: true)]
        public Input<string> DetectorId { get; set; } = null!;

        /// <summary>
        /// The ARN of the KMS key used to encrypt GuardDuty findings. GuardDuty enforces this to be encrypted.
        /// </summary>
        [Input("kmsKeyArn", required: true)]
        public Input<string> KmsKeyArn { get; set; } = null!;

        public PublishingDestinationArgs()
        {
        }
        public static new PublishingDestinationArgs Empty => new PublishingDestinationArgs();
    }

    public sealed class PublishingDestinationState : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The bucket arn and prefix under which the findings get exported. Bucket-ARN is required, the prefix is optional and will be `AWSLogs/[Account-ID]/GuardDuty/[Region]/` if not provided
        /// </summary>
        [Input("destinationArn")]
        public Input<string>? DestinationArn { get; set; }

        /// <summary>
        /// Currently there is only "S3" available as destination type which is also the default value
        /// 
        /// &gt; **Note:** In case of missing permissions (S3 Bucket Policy _or_ KMS Key permissions) the resource will fail to create. If the permissions are changed after resource creation, this can be asked from the AWS API via the "DescribePublishingDestination" call (https://docs.aws.amazon.com/cli/latest/reference/guardduty/describe-publishing-destination.html).
        /// </summary>
        [Input("destinationType")]
        public Input<string>? DestinationType { get; set; }

        /// <summary>
        /// The detector ID of the GuardDuty.
        /// </summary>
        [Input("detectorId")]
        public Input<string>? DetectorId { get; set; }

        /// <summary>
        /// The ARN of the KMS key used to encrypt GuardDuty findings. GuardDuty enforces this to be encrypted.
        /// </summary>
        [Input("kmsKeyArn")]
        public Input<string>? KmsKeyArn { get; set; }

        public PublishingDestinationState()
        {
        }
        public static new PublishingDestinationState Empty => new PublishingDestinationState();
    }
}
